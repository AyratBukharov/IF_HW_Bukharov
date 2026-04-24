package ru.ifellow.bukharov.hooks;

import org.junit.jupiter.api.BeforeAll;
import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.step.CharacterRelationStep;
import ru.ifellow.bukharov.rickandmorty.step.CharacterSearchStep;
import ru.ifellow.bukharov.rickandmorty.step.EpisodeStep;

public class RickAndMortyHooks {

    protected static CharacterSearchStep searchStep;
    protected static EpisodeStep episodeStep;
    protected static CharacterRelationStep relationStep;

    @BeforeAll
    static void setup() {
        CharacterApi api = new CharacterApi();
        searchStep = new CharacterSearchStep(api);
        episodeStep = new EpisodeStep(api);
        relationStep = new CharacterRelationStep(api);
    }
}
