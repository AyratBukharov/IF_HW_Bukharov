package ru.ifellow.bukharov.rickandmorty.api;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import ru.ifellow.bukharov.config.TestConfig;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterDTO;
import ru.ifellow.bukharov.rickandmorty.dto.Episode;
import ru.ifellow.bukharov.rickandmorty.step.CharacterRelationStep;
import ru.ifellow.bukharov.rickandmorty.step.CharacterSearchStep;
import ru.ifellow.bukharov.rickandmorty.step.EpisodeStep;

@Tag("DZ5")
public class RickAndMortyTest {

    private static CharacterSearchStep searchStep;
    private static EpisodeStep episodeStep;
    private static CharacterRelationStep relationStep;
    private static final TestConfig config = ConfigFactory.create(TestConfig.class);
    public static final String MORTY_SMITH = config.searchName();

    @BeforeAll
    static void setUp() {
        CharacterApi api = new CharacterApi();
        searchStep = new CharacterSearchStep(api);
        episodeStep = new EpisodeStep(api);
        relationStep = new CharacterRelationStep(api);
    }

    @Test
    @Tag("RickAndMorty")
    @DisplayName("Задача 1. Рик и Морти")
    void shouldNotMatchMortyBySpeciesAndLocation() {
        CharacterDTO morty = searchStep.getCharacter(MORTY_SMITH)
                .getResults()
                .getFirst();

        Episode lastEpisode = episodeStep.getEpisode(morty.getEpisodes().getLast());

        CharacterDTO lastCharacter = relationStep.getCharacter(lastEpisode.getCharacters().getLast());

        Assertions.assertFalse(
                lastCharacter.getSpecies().equals(morty.getSpecies()) &&
                        lastCharacter.getLocation().getName().equals(morty.getLocation().getName())
        );
    }
}
