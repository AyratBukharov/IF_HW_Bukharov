package ru.ifellow.bukharov.ifellowEduJira.step;

import io.qameta.allure.Step;
import ru.ifellow.bukharov.ifellowEduJira.page.DashboardPage;

public class DashboardSteps {

    private final DashboardPage dashboardPage = new DashboardPage();
    private final ProjectSteps projectSteps = new ProjectSteps();
    private final CreateTaskSteps createTaskSteps = new CreateTaskSteps();

    @Step("Проверка, что успешно залогинились, Dashboard открылся")
    public boolean isOpened() {
        return dashboardPage.isProfileDisplayed();
    }

    @Step("Переход в проекты `Test`")
    public ProjectSteps goToTestProject() {
        dashboardPage
                .clickProjects()
                .clickTestProject();
        projectSteps.isOpened();
        return projectSteps;
    }

    @Step("Открытие окна создания задачи")
    public CreateTaskSteps openCreateTaskForm() {
        dashboardPage.clickCreateTask();
        createTaskSteps.isOpened();
        return createTaskSteps;
    }
}
