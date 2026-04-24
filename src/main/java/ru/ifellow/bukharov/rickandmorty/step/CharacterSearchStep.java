package ru.ifellow.bukharov.rickandmorty.step;

import org.apache.http.HttpStatus;
import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterResponse;

import static ru.ifellow.bukharov.spec.Specification.baseResponse;

public class CharacterSearchStep {

    private final CharacterApi api;

    public CharacterSearchStep(CharacterApi api) {
        this.api = api;
    }

    public CharacterResponse getCharacter(String name) {
        return api.getCharacterByName(name)
                .spec(baseResponse(HttpStatus.SC_OK))
                .extract()
                .as(CharacterResponse.class);
    }
}
