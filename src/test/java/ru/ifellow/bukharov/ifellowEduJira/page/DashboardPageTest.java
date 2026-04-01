package ru.ifellow.bukharov.ifellowEduJira.page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authorization;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;

public class DashboardPageTest extends WebHooks {

    private final Authorization authorization = new Authorization();

    @Test
    @DisplayName("2. Переход в проект 'Test'")
    public void goToTest() {
        ProjectPage projectPage = authorization.login()
                .goToTest();

        Assertions.assertTrue(projectPage.isOpened(), "Проект 'Test' не открылся");
    }
}
