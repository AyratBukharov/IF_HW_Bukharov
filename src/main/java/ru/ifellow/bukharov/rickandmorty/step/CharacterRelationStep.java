package ru.ifellow.bukharov.rickandmorty.step;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterDTO;

import static ru.ifellow.bukharov.spec.Specification.baseResponse;

@RequiredArgsConstructor
public class CharacterRelationStep {

    private final CharacterApi api;

    @Step("Получение персонажа по ссылке: {url}")
    public CharacterDTO getCharacter(String url) {
        return api.getByUrl(url)
                .spec(baseResponse(HttpStatus.SC_OK))
                .extract()
                .as(CharacterDTO.class);
    }
}
