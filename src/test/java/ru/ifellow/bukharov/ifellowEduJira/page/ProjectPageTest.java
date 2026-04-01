package ru.ifellow.bukharov.ifellowEduJira.page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authorization;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;

public class ProjectPageTest extends WebHooks {

    private final Authorization authorization = new Authorization();

    @Test
    @DisplayName("3. Проверка общего количества заведённых задач")
    public void tasksCounter() {
        ProjectPage projectPage = authorization.login()
                .goToTest()
                .goToAllTasks();

        int countBefore = projectPage.allTestsCounter();
        projectPage.createTask();
        projectPage.waitTasksCount(countBefore + 1);
        int countAfter = projectPage.allTestsCounter();

        Assertions.assertEquals(countBefore + 1, countAfter,
                "Количество задач не увеличилось на 1");
    }
}
