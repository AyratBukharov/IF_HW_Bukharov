package ru.ifellow.bukharov.hooks;

import org.junit.jupiter.api.BeforeAll;
import ru.ifellow.bukharov.server.api.AuthApi;
import ru.ifellow.bukharov.server.step.AuthSteps;

public class ServerHooks {

    protected static AuthSteps authStep;

    @BeforeAll
    static void setup() {
        authStep = new AuthSteps(new AuthApi());
    }
}
