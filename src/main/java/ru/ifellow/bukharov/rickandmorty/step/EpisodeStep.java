package ru.ifellow.bukharov.rickandmorty.step;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.Episode;

import static ru.ifellow.bukharov.spec.Specification.baseResponse;

@RequiredArgsConstructor
public class EpisodeStep {

    private final CharacterApi api;

    @Step("Получение эпизода по ссылке: {url}")
    public Episode getEpisode(String url) {
        return api.getByUrl(url)
                .spec(baseResponse(HttpStatus.SC_OK))
                .extract()
                .as(Episode.class);
    }
}
