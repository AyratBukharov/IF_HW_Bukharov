package ru.ifellow.bukharov.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.config.TestConfig;
import ru.ifellow.bukharov.hooks.ServerHooks;
import ru.ifellow.bukharov.server.dto.UserDTO;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static ru.ifellow.bukharov.server.enums.AuthMessage.*;
import static ru.ifellow.bukharov.server.enums.AuthUrn.*;
import static ru.ifellow.bukharov.spec.Specification.baseResponse;

@Tag("DZ5")
@Tag("auth")
public class AuthTest extends ServerHooks {

    private final ObjectMapper mapper = new ObjectMapper();
    private static final TestConfig config = ConfigFactory.create(TestConfig.class);
    private final File userJson = config.jsonFile();

    @Test
    @Tag("negative")
    @DisplayName("Задача 2. Авторизация: Пользователь не найден")
    void loginUserNotFound() {
        UserDTO user = readUser();
        user.setUsername("bad_username");

        authStep.login(user, LOGIN.getValue())
                .spec(baseResponse(HttpStatus.SC_UNAUTHORIZED))
                .body(equalTo(NOT_FOUND.getValue()));
    }

    @Test
    @Tag("negative")
    @DisplayName("Задача 2. Авторизация: не верный пароль")
    void loginWrongPassword() {
        UserDTO user = readUser();
        user.setPassword("bad_pass");

        authStep.login(user, LOGIN.getValue())
                .spec(baseResponse(HttpStatus.SC_UNAUTHORIZED))
                .body(equalTo(NOT_RIGHT_PASS.getValue()));
    }

    @Test
    @Tag("positive")
    @DisplayName("Задача 2. Авторизация: успешный сценарий")
    void loginSuccess() {
        UserDTO user = createAndRegisterUser();
        UUID token = authStep.loginAndExtractToken(user, LOGIN.getValue());
        Assertions.assertNotNull(token);
    }

    @Test
    @Tag("negative")
    @DisplayName("Задача 2. Выход из учётки: неуспешный сценарий")
    void logoutInvalidToken() {
        authStep.logout(UUID.randomUUID(), LOGOUT.getValue())
                .spec(baseResponse(HttpStatus.SC_UNAUTHORIZED))
                .body(equalTo(NOT_FOUND.getValue()));
    }

    @Test
    @Tag("positive")
    @DisplayName("Задача 2. Выход из учётки: успешный сценарий")
    void logoutSuccess() {
        UserDTO user = createAndRegisterUser();
        UUID token = authStep.loginAndExtractToken(user, LOGIN.getValue());

        authStep.logout(token, LOGOUT.getValue())
                .spec(baseResponse(HttpStatus.SC_OK))
                .body(equalTo(SUCCESS_LOGOUT.getValue()));
    }

    private UserDTO createAndRegisterUser() {
        UserDTO user = readUser();
        authStep.register(user, REGISTER.getValue())
                .spec(baseResponse(HttpStatus.SC_OK))
                .body(equalTo(SUCCESS_REGISTER.getValue()));
        return user;
    }

    private UserDTO readUser() {
        try {
            return mapper.readValue(userJson, UserDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
