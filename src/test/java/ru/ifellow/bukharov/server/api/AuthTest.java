package ru.ifellow.bukharov.server.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import ru.ifellow.bukharov.server.dto.UserDTO;
import ru.ifellow.bukharov.server.step.AuthSteps;
import ru.ifellow.bukharov.spec.Specification;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;

@Tag("DZ5")
@Tag("auth")
public class AuthTest {

    private static AuthSteps authStep;
    private final ObjectMapper mapper = new ObjectMapper();
    private final File userJson = new File("src/test/resources/user.json");
    private static final String SUCCESS_REGISTER = "success register";
    private static final String NOT_FOUND = "not found";
    private static final String NOT_RIGHT_PASS = "not right pass";
    private static final String SUCCESS_LOGOUT = "success logout";

    @BeforeAll
    static void setUp() {
        authStep = new AuthSteps(new AuthApi());
    }

    @Test
    @Tag("negative")
    @DisplayName("Задача 2. Авторизация: Пользователь не найден")
    void loginUserNotFound() {
        UserDTO user = readUser();
        user.setUsername("bad_username");

        authStep.login(user)
                .spec(Specification.baseResponseError401())
                .body(equalTo(NOT_FOUND));
    }

    @Test
    @Tag("negative")
    @DisplayName("Задача 2. Авторизация: не верный пароль")
    void loginWrongPassword() {
        UserDTO user = readUser();
        user.setPassword("bad_pass");

        authStep.login(user)
                .spec(Specification.baseResponseError401())
                .body(equalTo(NOT_RIGHT_PASS));
    }

    @Test
    @Tag("positive")
    @DisplayName("Задача 2. Авторизация: успешный сценарий")
    void loginSuccess() {
        UserDTO user = createAndRegisterUser();
        UUID token = authStep.loginAndExtractToken(user);
        Assertions.assertNotNull(token);
    }

    @Test
    @Tag("negative")
    @DisplayName("Задача 2. Выход из учётки: неуспешный сценарий")
    void logoutInvalidToken() {
        authStep.logout(UUID.randomUUID())
                .spec(Specification.baseResponseError401())
                .body(equalTo(NOT_FOUND));
    }

    @Test
    @Tag("positive")
    @DisplayName("Задача 2. Выход из учётки: успешный сценарий")
    void logoutSuccess() {
        UserDTO user = createAndRegisterUser();
        UUID token = authStep.loginAndExtractToken(user);

        authStep.logout(token)
                .spec(Specification.baseResponseSpecOK200())
                .body(equalTo(SUCCESS_LOGOUT));
    }

    private UserDTO createAndRegisterUser() {
        UserDTO user = readUser();
        authStep.register(user)
                .spec(Specification.baseResponseSpecOK200())
                .body(equalTo(SUCCESS_REGISTER));
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
