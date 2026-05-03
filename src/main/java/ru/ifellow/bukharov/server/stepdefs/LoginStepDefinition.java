package ru.ifellow.bukharov.server.stepdefs;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import ru.ifellow.bukharov.server.dto.UserDTO;
import ru.ifellow.bukharov.server.util.AuthContext;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.ifellow.bukharov.server.enums.AuthUrn.LOGIN;

@RequiredArgsConstructor
public class LoginStepDefinition {

    private final AuthContext context;

    @Когда("отправляем запрос на аутентификацию")
    public void sendLoginRequest() {
        context.setLastResponse(context.getAuthSteps().login(context.getCurrentUser(), LOGIN.getValue()));
    }

    @Когда("отправляем запрос на аутентификацию с невалидным именем и валидным паролем")
    public void loginWithUsername() {
        UserDTO badUser = new UserDTO(context.getConfig().badUsername(), context.getCurrentUser().getPassword());
        context.setLastResponse(context.getAuthSteps().login(badUser, LOGIN.getValue()));
    }

    @Когда("отправляем запрос на аутентификацию с валидным именем и невалидным паролем")
    public void loginWithPassword() {
        UserDTO badUser = new UserDTO(context.getCurrentUser().getUsername(), context.getConfig().badPassword());
        context.setLastResponse(context.getAuthSteps().login(badUser, LOGIN.getValue()));
    }

    @Тогда("в ответе получен валидный UUID токен")
    public void extractAndValidateToken() {
        UUID token = context.getAuthSteps().extractToken(context.getLastResponse().extract().asString());
        assertNotNull(token);
        context.setExtractedToken(token);
    }
}
