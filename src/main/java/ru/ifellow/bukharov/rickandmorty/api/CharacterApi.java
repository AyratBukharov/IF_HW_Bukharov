package ru.ifellow.bukharov.rickandmorty.api;

import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import ru.ifellow.bukharov.api.BaseApi;
import ru.ifellow.bukharov.config.TestConfig;

import static io.restassured.RestAssured.given;

public class CharacterApi extends BaseApi {

    private static final TestConfig config = ConfigFactory.create(TestConfig.class);
    private static final String BASE_URL = config.baseUrlMorty();
    private static final String URN = "/character";

    public CharacterApi() {
        super(BASE_URL);
    }

    public ValidatableResponse getCharacterByName(String name) {
        return given()
                .when()
                .queryParam("name", name)
                .get(URN)
                .then();
    }

    public ValidatableResponse getEpisodeByUrl(String url) {
        return given()
                .when()
                .get(url)
                .then();
    }

    public ValidatableResponse getCharacterByUrl(String url) {
        return given()
                .when()
                .get(url)
                .then();
    }
}
