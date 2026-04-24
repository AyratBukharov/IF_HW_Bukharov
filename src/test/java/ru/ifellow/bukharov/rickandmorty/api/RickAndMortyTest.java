package ru.ifellow.bukharov.rickandmorty.api;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.config.TestConfig;
import ru.ifellow.bukharov.hooks.RickAndMortyHooks;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterDTO;
import ru.ifellow.bukharov.rickandmorty.dto.Episode;

@Tag("DZ5")
public class RickAndMortyTest extends RickAndMortyHooks {

    private static final TestConfig config = ConfigFactory.create(TestConfig.class);
    public static final String MORTY_SMITH = config.searchName();

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
