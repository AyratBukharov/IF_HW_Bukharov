package ru.ifellow.bukharov.server.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthUrn {

    REGISTER("/register"),
    LOGIN("/login"),
    LOGOUT("/logout");

    private final String value;
}
