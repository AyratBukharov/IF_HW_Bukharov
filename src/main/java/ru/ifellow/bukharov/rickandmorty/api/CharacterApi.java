package ru.ifellow.bukharov.rickandmorty.api;

import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import ru.ifellow.bukharov.api.BaseApi;
import ru.ifellow.bukharov.config.TestConfig;

import static io.restassured.RestAssured.given;

public class CharacterApi extends BaseApi {

    private static final TestConfig config = ConfigFactory.create(TestConfig.class);

    public CharacterApi() {
        super(config.baseUrlMorty());
    }

    public ValidatableResponse getCharacterByName(String name) {
        return given()
                .when()
                .queryParam("name", name)
                .get(config.characterUrn())
                .then();
    }

    public ValidatableResponse getByUrl(String url) {
        return given()
                .when()
                .get(url)
                .then();
    }
}
