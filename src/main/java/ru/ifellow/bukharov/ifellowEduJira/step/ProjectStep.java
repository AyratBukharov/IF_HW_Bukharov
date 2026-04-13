package ru.ifellow.bukharov.ifellowEduJira.step;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.bukharov.ifellowEduJira.context.Context;
import ru.ifellow.bukharov.ifellowEduJira.page.ProjectPage;

@RequiredArgsConstructor
public class ProjectStep {

    private final Context context;

    @Когда("открываем проекты")
    public void openProject() {
        ProjectPage projectPage = context.getDashboardPage().goToTest();
        context.setProjectPage(projectPage);
    }

    @Тогда("открывается страница проектов")
    public void checkProjectOpened() {
        Assertions.assertTrue(context.getProjectPage().isOpened());
    }

    @Когда("переходим в список всех задач")
    public void goToTasks() {
        ProjectPage projectPage = context.getProjectPage().goToAllTasks();
        context.setProjectPage(projectPage);
    }

    @Тогда("записываем количество всех задач")
    public void taskCount() {
        int count = context.getProjectPage().getTasksCount();
        context.setTasksCountBefore(count);
    }

    @Когда("создаём задачу")
    public void createTask() {
        context.getProjectPage().createTask();
    }

    @Тогда("количество задач увеличивается на 1")
    public void checkTasksCount() {
        int expected = context.getTasksCountBefore() + 1;
        context.getProjectPage().waitTasksCount(expected);
        int actual = context.getProjectPage().getTasksCount();
        Assertions.assertEquals(expected, actual);
    }
}
