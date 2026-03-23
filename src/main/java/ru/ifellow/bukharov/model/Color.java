package ru.ifellow.bukharov.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Color {
    BLACK("Чёрный"),
    WHITE("Белый"),
    SILVER("Серебристый"),
    GRAY("Серый"),
    BLUE("Синий"),
    GREEN("Зелёный"),
    RED("Красный");

    private final String displayName;

    @Override
    public String toString() {
        return displayName;
    }
}
