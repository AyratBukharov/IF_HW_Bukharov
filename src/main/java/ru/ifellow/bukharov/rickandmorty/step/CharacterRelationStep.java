package ru.ifellow.bukharov.rickandmorty.step;

import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterDTO;
import ru.ifellow.bukharov.spec.Specification;

public class CharacterRelationStep {

    private final CharacterApi api;

    public CharacterRelationStep(CharacterApi api) {
        this.api = api;
    }

    public CharacterDTO getCharacter(String url) {
        return api.getCharacterByUrl(url)
                .spec(Specification.baseResponseSpecOK200())
                .extract()
                .as(CharacterDTO.class);
    }
}
