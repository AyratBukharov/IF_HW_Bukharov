package ru.ifellow.bukharov.rickandmorty.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {

    private List<String> characters;
}
