package ru.ifellow.bukharov.rickandmorty.stepdefs;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.bukharov.rickandmorty.dto.CharacterResponse;
import ru.ifellow.bukharov.rickandmorty.util.RickAndMortyContext;

@RequiredArgsConstructor
public class RickAndMortyStepDefinitions {

    private final RickAndMortyContext context;

    @Когда("находим информацию о персонаже Морти и сохраняем его последний эпизод")
    public void findMortyAndSaveLastEpisode() {
        CharacterResponse response = context.getSearchStep().getCharacter(context.getConfig().searchName());

        context.setMorty(response.getResults().getFirst());

        Assertions.assertFalse(response.getResults().isEmpty(), "Персонаж с именем "
                + context.getConfig().searchName() + " не найден");

        context.setLastEpisode(context.getEpisodeStep()
                .getEpisode(context.getMorty().getEpisodes().getLast()));

        Assertions.assertNotNull(context.getLastEpisode(), "Не удалось получить последний эпизод");
    }

    @И("получаем последнего персонажа из этого эпизода")
    public void getLastCharacterFromEpisode() {
        Assertions.assertFalse(context.getLastEpisode().getCharacters().isEmpty(), "В эпизоде нет персонажей");

        context.setLastCharacter(context.getRelationStep()
                .getCharacter(context.getLastEpisode().getCharacters().getLast()));

        Assertions.assertNotNull(context.getLastCharacter(), "Не удалось получить последнего персонажа");
    }

    @И("получаем у последнего персонажа расу и местоположение")
    public void getSpeciesAndLocation() {
        Assertions.assertNotNull(context.getLastCharacter().getSpecies());
        Assertions.assertNotNull(context.getLastCharacter().getLocation());
    }

    @Тогда("проверяем, что его раса или местоположение отличаются от Морти")
    public void verifySpeciesOrLocationMismatch() {
        Assertions.assertFalse(
                context.getLastCharacter().getSpecies().equals(context.getMorty().getSpecies()) &&
                        context.getLastCharacter().getLocation().getName().equals(context.getMorty().getLocation().getName()),
                "Раса и местоположение последнего персонажа совпадают с расой и местоположением Морти");
    }
}
