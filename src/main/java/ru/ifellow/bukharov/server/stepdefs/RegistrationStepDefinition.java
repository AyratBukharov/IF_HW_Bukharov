package ru.ifellow.bukharov.server.stepdefs;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import ru.ifellow.bukharov.server.enums.AuthMessage;
import ru.ifellow.bukharov.server.util.AuthContext;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.ifellow.bukharov.server.enums.AuthUrn.LOGIN;
import static ru.ifellow.bukharov.server.enums.AuthUrn.REGISTER;
import static ru.ifellow.bukharov.spec.Specification.baseResponse;

@RequiredArgsConstructor
public class RegistrationStepDefinition {

    private final AuthContext context;

    @Допустим("пользователь зарегистрирован")
    public void userIsRegistered() {
        context.getAuthSteps().register(context.getCurrentUser(), REGISTER.getValue())
                .spec(baseResponse(HttpStatus.SC_OK))
                .body(equalTo(AuthMessage.SUCCESS_REGISTER.getValue()));
    }

    @Допустим("пользователь зарегистрирован и залогинен")
    public void userIsRegisteredAndLoggedIn() {
        userIsRegistered();
        UUID token = context.getAuthSteps().loginAndExtractToken(context.getCurrentUser(), LOGIN.getValue());
        assertNotNull(token);
        context.setExtractedToken(token);
    }

    @Когда("отправляем запрос на регистрацию")
    public void sendRegisterRequest() {
        context.setLastResponse(context.getAuthSteps().register(context.getCurrentUser(), REGISTER.getValue()));
    }
}
