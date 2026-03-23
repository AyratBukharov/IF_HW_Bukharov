package ru.ifellow.bukharov.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BodyStyle {
    SEDAN("Седан"),
    HATCHBACK("Хэтчбек"),
    SUV("Кроссовер"),
    PICKUP("Пикап");

    private final String displayName;

    @Override
    public String toString() {
        return displayName;
    }
}
