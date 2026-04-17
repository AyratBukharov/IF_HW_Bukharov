package ru.ifellow.bukharov.ifellowEduJira.step;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.bukharov.ifellowEduJira.page.DashboardPage;
import ru.ifellow.bukharov.ifellowEduJira.page.ProjectPage;

@RequiredArgsConstructor
public class ProjectStep {

    private ProjectPage projectPage;
    private int countBefore;

    @Когда("открываем проекты")
    public void openProject() {
        projectPage = new DashboardPage().goToTest();
    }

    @Тогда("открывается страница проектов")
    public void checkProjectOpened() {
        Assertions.assertTrue(projectPage.isOpened());
    }

    @Когда("переходим в список всех задач")
    public void goToTasks() {
        projectPage = projectPage.goToAllTasks();
    }

    @Тогда("записываем количество всех задач")
    public void taskCount() {
        countBefore = projectPage.getTasksCount();
    }

    @Когда("создаём задачу")
    public void createTask() {
        projectPage.createTask();
    }

    @Тогда("количество задач увеличивается на 1")
    public void checkTasksCount() {
        projectPage.waitTasksCount(countBefore + 1);
        int countAfter = projectPage.getTasksCount();
        Assertions.assertEquals(countBefore + 1, countAfter);
    }
}
