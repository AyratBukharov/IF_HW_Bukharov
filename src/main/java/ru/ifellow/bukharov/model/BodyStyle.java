package ru.ifellow.bukharov.model;

import lombok.RequiredArgsConstructor;

/**
 * Тип кузова автомобиля.
 */
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
