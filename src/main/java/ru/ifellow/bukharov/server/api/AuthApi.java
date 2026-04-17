package ru.ifellow.bukharov.server.api;

import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import ru.ifellow.bukharov.api.BaseApi;
import ru.ifellow.bukharov.config.TestConfig;
import ru.ifellow.bukharov.server.dto.UserDTO;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class AuthApi extends BaseApi {

    private static final TestConfig config = ConfigFactory.create(TestConfig.class);
    private static final String BASE_URL = config.baseUrlServer();

    public AuthApi() {
        super(BASE_URL);
    }

    public ValidatableResponse register(UserDTO user) {
        return given()
                .body(user)
                .when()
                .post("/register")
                .then();
    }

    public ValidatableResponse login(UserDTO user) {
        return given()
                .body(user)
                .when()
                .post("/login")
                .then();
    }

    public ValidatableResponse logout(UUID token) {
        return given()
                .header("Authorization", token.toString())
                .when()
                .get("/logout")
                .then();
    }
}
