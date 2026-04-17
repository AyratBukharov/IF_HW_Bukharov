package ru.ifellow.bukharov.rickandmorty.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private String name;
}
