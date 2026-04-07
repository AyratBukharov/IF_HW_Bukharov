package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authentication;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;
import ru.ifellow.bukharov.ifellowEduJira.page.ProjectPage;

public class ProjectPageTest extends WebHooks {

    private final Authentication authentication = new Authentication();

    @Test
    @DisplayName("3. Проверка общего количества заведённых задач")
    @Tag("DZ3")
    public void tasksCounter() {
        ProjectPage projectPage = authentication.login()
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
