package ru.ifellow.bukharov.rickandmorty.step;

import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterResponse;
import ru.ifellow.bukharov.spec.Specification;

public class CharacterSearchStep {

    private final CharacterApi api;

    public CharacterSearchStep(CharacterApi api) {
        this.api = api;
    }

    public CharacterResponse getCharacter(String name) {
        return api.getCharacterByName(name)
                .spec(Specification.baseResponseSpecOK200())
                .extract()
                .as(CharacterResponse.class);
    }
}
