package ru.ifellow.bukharov.rickandmorty.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDTO {

    private String species;
    private Location location;
    @JsonProperty("episode")
    private List<String> episodes;
}
