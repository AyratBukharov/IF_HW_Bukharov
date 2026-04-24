package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Аутентификация")
public class AuthenticationPageTest extends EduJiraBaseTest {

    @Test
    @Story("Успешный вход с валидными данными")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("1. Аутентификация")
    public void loginTest() {
        Assertions.assertTrue(dashboardSteps.isOpened(),
                "Dashboard не открылся после аутентификации");
    }
}
