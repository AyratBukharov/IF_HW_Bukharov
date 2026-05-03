package ru.ifellow.bukharov.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.aeonbits.owner.ConfigFactory;
import ru.ifellow.bukharov.config.MaskingConfig;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class MaskingUtils {

    private static final MaskingConfig config = ConfigFactory.create(MaskingConfig.class);
    private static final Set<String> SENSITIVE_FIELDS = Set.of(config.sensitiveFields().split(","));
    private static final Set<String> SENSITIVE_HEADERS = Set.of(config.sensitiveHeaders().split(","));
    private static final Map<String, Pattern> PATTERN_CACHE = new ConcurrentHashMap<>();
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String maskBody(String contentType, String body) {
        if (body == null || body.isBlank()) return body;
        if (contentType != null && contentType.contains("json")) {
            return maskJson(body);
        } else {
            return maskPlainText(body);
        }
    }

    private static String maskJson(String json) {
        try {
            JsonNode root = MAPPER.readTree(json);
            maskJsonNode(root);
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        } catch (Exception e) {
            return json;
        }
    }

    private static void maskJsonNode(JsonNode node) {
        if (node == null || node.isNull()) return;
        if (node.isObject()) {
            ObjectNode obj = (ObjectNode) node;
            obj.fieldNames().forEachRemaining(field -> {
                if (SENSITIVE_FIELDS.contains(field.toLowerCase())) {
                    obj.put(field, "******");
                } else {
                    maskJsonNode(obj.get(field));
                }
            });
        } else if (node.isArray()) {
            node.forEach(MaskingUtils::maskJsonNode);
        }
    }

    private static String maskPlainText(String text) {
        return maskByPatterns(text, SENSITIVE_FIELDS);
    }

    public static String maskHeaders(String headers) {
        return headers == null ? null : maskByPatterns(headers, SENSITIVE_HEADERS);
    }

    private static String maskByPatterns(String input, Set<String> keywords) {
        String result = input;
        for (String keyword : keywords) {
            Pattern pattern = PATTERN_CACHE.computeIfAbsent(keyword,
                    k -> Pattern.compile("(?i)(" + k + "\\s*[:=]\\s*)([^\\s,\\n]+)"));
            result = pattern.matcher(result).replaceAll("$1******");
        }
        return result;
    }
}
