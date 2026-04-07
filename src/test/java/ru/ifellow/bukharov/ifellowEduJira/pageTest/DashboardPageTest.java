package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authentication;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;
import ru.ifellow.bukharov.ifellowEduJira.page.ProjectPage;

public class DashboardPageTest extends WebHooks {

    private final Authentication authentication = new Authentication();

    @Test
    @DisplayName("2. Переход в проект 'Test'")
    @Tag("DZ3")
    public void goToTest() {
        ProjectPage projectPage = authentication.login()
                .goToTest();

        Assertions.assertTrue(projectPage.isOpened(), "Проект 'Test' не открылся");
    }
}
