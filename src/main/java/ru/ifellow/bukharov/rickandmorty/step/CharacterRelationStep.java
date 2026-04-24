package ru.ifellow.bukharov.rickandmorty.step;

import org.apache.http.HttpStatus;
import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterDTO;

import static ru.ifellow.bukharov.spec.Specification.baseResponse;

public class CharacterRelationStep {

    private final CharacterApi api;

    public CharacterRelationStep(CharacterApi api) {
        this.api = api;
    }

    public CharacterDTO getCharacter(String url) {
        return api.getCharacterByUrl(url)
                .spec(baseResponse(HttpStatus.SC_OK))
                .extract()
                .as(CharacterDTO.class);
    }
}
