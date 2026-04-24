package ru.ifellow.bukharov.server.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthMessage {

    SUCCESS_REGISTER("success register"),
    NOT_FOUND("not found"),
    NOT_RIGHT_PASS("not right pass"),
    SUCCESS_LOGOUT("success logout");

    private final String value;
}
