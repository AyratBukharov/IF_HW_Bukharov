package ru.ifellow.bukharov.server.stepdefs;

import io.cucumber.java.ru.Когда;
import lombok.RequiredArgsConstructor;
import ru.ifellow.bukharov.server.util.AuthContext;

import java.util.UUID;

import static ru.ifellow.bukharov.server.enums.AuthUrn.LOGOUT;

@RequiredArgsConstructor
public class LogoutStepDefinition {

    private final AuthContext context;

    @Когда("отправлем запрос на выход из аккаунта")
    public void sendLogoutRequest() {
        context.setLastResponse(context.getAuthSteps().logout(context.getExtractedToken(), LOGOUT.getValue()));
    }

    @Когда("отправляем запрос на выход из аккаунта с рандомным токеном")
    public void logoutWithRandomToken() {
        context.setLastResponse(context.getAuthSteps().logout(UUID.randomUUID(), LOGOUT.getValue()));
    }
}
