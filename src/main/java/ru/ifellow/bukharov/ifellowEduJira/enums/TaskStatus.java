package ru.ifellow.bukharov.ifellowEduJira.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskStatus {

    DONE("готово"),
    IN_PROGRESS("сделать");

    private final String value;
}
