package ru.ifellow.bukharov.server.step;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import ru.ifellow.bukharov.server.api.AuthApi;
import ru.ifellow.bukharov.server.dto.UserDTO;

import java.util.UUID;

import static ru.ifellow.bukharov.spec.Specification.baseResponse;

public class AuthSteps {

    private final AuthApi api;

    public AuthSteps(AuthApi api) {
        this.api = api;
    }

    public ValidatableResponse register(UserDTO user, String urn) {
        return api.postUserByUrn(user, urn);
    }

    public ValidatableResponse login(UserDTO user, String urn) {
        return api.postUserByUrn(user, urn);
    }

    public ValidatableResponse logout(UUID token, String urn) {
        return api.logout(token, urn);
    }

    public UUID loginAndExtractToken(UserDTO user, String urn) {
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
