package ru.ifellow.bukharov.rickandmorty.step;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterResponse;

import static ru.ifellow.bukharov.spec.Specification.baseResponse;

@RequiredArgsConstructor
public class CharacterSearchStep {

    private final CharacterApi api;

    @Step("Получение персонажа по имени: \"{name}\"")
    public CharacterResponse getCharacter(String name) {
        return api.getCharacterByName(name)
                .spec(baseResponse(HttpStatus.SC_OK))
                .extract()
                .as(CharacterResponse.class);
    }
}
