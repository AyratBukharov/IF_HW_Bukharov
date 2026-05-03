package ru.ifellow.bukharov.server.util;

import io.restassured.response.ValidatableResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.aeonbits.owner.ConfigFactory;
import ru.ifellow.bukharov.config.TestConfig;
import ru.ifellow.bukharov.server.api.AuthApi;
import ru.ifellow.bukharov.server.dto.UserDTO;
import ru.ifellow.bukharov.server.step.AuthSteps;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthContext {

    private final TestConfig config = ConfigFactory.create(TestConfig.class);
    private final AuthApi authApi;
    private final AuthSteps authSteps;
    private UserDTO currentUser;
    private ValidatableResponse lastResponse;
    private UUID extractedToken;
}
