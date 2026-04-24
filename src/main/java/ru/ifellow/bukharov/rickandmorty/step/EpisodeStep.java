package ru.ifellow.bukharov.rickandmorty.step;

import org.apache.http.HttpStatus;
import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.Episode;

import static ru.ifellow.bukharov.spec.Specification.baseResponse;

public class EpisodeStep {

    private final CharacterApi api;

    public EpisodeStep(CharacterApi api) {
        this.api = api;
    }

    public Episode getEpisode(String url) {
        return api.getEpisodeByUrl(url)
                .spec(baseResponse(HttpStatus.SC_OK))
                .extract()
                .as(Episode.class);
    }
}
