package ru.ifellow.bukharov.server.step;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import ru.ifellow.bukharov.server.api.AuthApi;
import ru.ifellow.bukharov.server.dto.UserDTO;

import java.util.UUID;

import static ru.ifellow.bukharov.spec.Specification.baseResponse;

@RequiredArgsConstructor
public class AuthSteps {

    private final AuthApi api;

    @Step("Регистрация пользователя")
    public ValidatableResponse register(@Param(mode = Parameter.Mode.HIDDEN) UserDTO user,
                                        @Param(mode = Parameter.Mode.HIDDEN) String urn) {
        return api.postUserByUrn(user, urn);
    }

    @Step("Аутентификация пользователя")
    public ValidatableResponse login(@Param(mode = Parameter.Mode.HIDDEN) UserDTO user,
                                     @Param(mode = Parameter.Mode.HIDDEN) String urn) {
        return api.postUserByUrn(user, urn);
    }

    @Step("Выход из аккаунта")
    public ValidatableResponse logout(@Param(mode = Parameter.Mode.HIDDEN) UUID token,
                                      @Param(mode = Parameter.Mode.HIDDEN) String urn) {
        return api.logout(token, urn);
    }

    @Step("Аутентификация и полуение токена")
    public UUID loginAndExtractToken(@Param(mode = Parameter.Mode.HIDDEN) UserDTO user,
                                     @Param(mode = Parameter.Mode.HIDDEN) String urn) {
        String response = api.postUserByUrn(user, urn)
                .spec(baseResponse(HttpStatus.SC_OK))
                .extract()
                .asString();

        return extractToken(response);
    }

    public UUID extractToken(String response) {
        String token = response.split(":")[1].trim();
        return UUID.fromString(token);
    }
}
