package ru.ifellow.bukharov.rickandmorty.step;

import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.Episode;
import ru.ifellow.bukharov.spec.Specification;

public class EpisodeStep {

    private final CharacterApi api;

    public EpisodeStep(CharacterApi api) {
        this.api = api;
    }

    public Episode getEpisode(String url) {
        return api.getEpisodeByUrl(url)
                .spec(Specification.baseResponseSpecOK200())
                .extract()
                .as(Episode.class);
    }
}
