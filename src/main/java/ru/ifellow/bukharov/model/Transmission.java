package ru.ifellow.bukharov.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Transmission {
    AUTOMATIC("АКПП"),
    MANUAL("МКПП");

    private final String displayName;

    @Override
    public String toString() {
        return displayName;
    }
}
