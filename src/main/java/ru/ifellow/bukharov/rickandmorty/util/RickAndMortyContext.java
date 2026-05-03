package ru.ifellow.bukharov.rickandmorty.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.aeonbits.owner.ConfigFactory;
import ru.ifellow.bukharov.config.TestConfig;
import ru.ifellow.bukharov.rickandmorty.api.CharacterApi;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterDTO;
import ru.ifellow.bukharov.rickandmorty.dto.Episode;
import ru.ifellow.bukharov.rickandmorty.step.CharacterRelationStep;
import ru.ifellow.bukharov.rickandmorty.step.CharacterSearchStep;
import ru.ifellow.bukharov.rickandmorty.step.EpisodeStep;

@Getter
@Setter
@RequiredArgsConstructor
public class RickAndMortyContext {

    private final TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());
    private final CharacterApi characterApi;
    private final CharacterSearchStep searchStep;
    private final EpisodeStep episodeStep;
    private final CharacterRelationStep relationStep;
    private CharacterDTO morty;
    private Episode lastEpisode;
    private CharacterDTO lastCharacter;
}
