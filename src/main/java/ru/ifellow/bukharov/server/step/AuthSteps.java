package ru.ifellow.bukharov.server.step;

import io.restassured.response.ValidatableResponse;
import ru.ifellow.bukharov.server.api.AuthApi;
import ru.ifellow.bukharov.server.dto.UserDTO;
import ru.ifellow.bukharov.spec.Specification;

import java.util.UUID;

public class AuthSteps {

    private final AuthApi api;

    public AuthSteps(AuthApi api) {
        this.api = api;
    }

    public ValidatableResponse register(UserDTO user) {
        return api.register(user);
    }

    public ValidatableResponse login(UserDTO user) {
        return api.login(user);
    }

    public ValidatableResponse logout(UUID token) {
        return api.logout(token);
    }

    public UUID loginAndExtractToken(UserDTO user) {
        String response = api.login(user)
                .spec(Specification.baseResponseSpecOK200())
                .extract()
                .asString();

        return extractToken(response);
    }

    public UUID extractToken(String response) {
        String token = response.split(":")[1].trim();
        return UUID.fromString(token);
    }
}
