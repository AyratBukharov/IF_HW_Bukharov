package ru.ifellow.bukharov.model;

import lombok.RequiredArgsConstructor;

/**
 * Привод автомобиля.
 */
@RequiredArgsConstructor
public enum DriveWheels {
    FWD("Передний привод"),
    RWD("Задний привод"),
    AWD("Полный привод");

    private final String displayName;

    @Override
    public String toString() {
        return displayName;
    }
}
