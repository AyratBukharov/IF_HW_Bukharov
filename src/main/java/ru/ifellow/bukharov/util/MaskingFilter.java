package ru.ifellow.bukharov.util;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class MaskingFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification req,
                           FilterableResponseSpecification res,
                           FilterContext ctx) {
        Allure.addAttachment("Request", "text/plain", format(req));
        Response response = ctx.next(req, res);
        Allure.addAttachment("Response", "text/plain", format(response));
        return response;
    }

    private String format(FilterableRequestSpecification req) {
        String body = req.getBody() != null ? req.getBody().toString() : "";
        String maskedBody = MaskingUtils.maskBody(req.getContentType(), body);
        String maskedHeaders = MaskingUtils.maskHeaders(req.getHeaders().toString());
        return req.getMethod() + " " + req.getURI() + "\n\nHeaders:\n" + maskedHeaders + "\n\nBody:\n" + maskedBody;
    }

    private String format(Response res) {
        String body = res.getBody() != null ? res.getBody().asString() : "";
        String maskedBody = MaskingUtils.maskBody(res.getContentType(), body);
        String maskedHeaders = MaskingUtils.maskHeaders(res.getHeaders().toString());
        return "Status code: " + res.statusCode() + "\n\nHeaders:\n" + maskedHeaders + "\n\nBody:\n" + maskedBody;
    }
}
