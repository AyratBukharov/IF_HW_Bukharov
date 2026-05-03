package ru.ifellow.bukharov.server.stepdefs;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import ru.ifellow.bukharov.server.dto.UserDTO;
import ru.ifellow.bukharov.server.util.AuthContext;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

@RequiredArgsConstructor
public class CommonStepDefinitions {

    private final AuthContext context;

    @Допустим("пользователь с данными из файла конфиг.проперти")
    public void loadUserFromJson() {
        context.setCurrentUser(readUserFromFile(context.getConfig().jsonFile()));
    }

    private UserDTO readUserFromFile(File file) {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().readValue(file, UserDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Тогда("статус ответа {int}")
    public void verifyStatusCode(int statusCode) {
        context.getLastResponse().statusCode(statusCode);
    }

    @Тогда("тело ответа: {string}")
    public void verifyBody(String expectedMessage) {
        context.getLastResponse().body(equalTo(expectedMessage));
    }
}
