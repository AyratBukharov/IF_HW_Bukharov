package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authorization;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;
import ru.ifellow.bukharov.ifellowEduJira.page.ProjectPage;

public class ProjectPageTest extends WebHooks {

    private final Authorization authorization = new Authorization();

    @Test
    @DisplayName("3. Проверка общего количества заведённых задач")
    public void tasksCounter() {
        ProjectPage projectPage = authorization.login()
                .goToTest()
                .goToAllTasks();

        int countBefore = projectPage.getTasksCount();
        projectPage.createTask();
        projectPage.waitTasksCount(countBefore + 1);
        int countAfter = projectPage.getTasksCount();

        Assertions.assertEquals(countBefore + 1, countAfter,
                "Количество задач не увеличилось на 1");
    }
}
