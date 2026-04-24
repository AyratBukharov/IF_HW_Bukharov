package ru.ifellow.bukharov.ifellowEduJira.step;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.ifellow.bukharov.ifellowEduJira.page.ProjectPage;

public class ProjectSteps {

    private final ProjectPage projectPage = new ProjectPage();

    @Step("Проверка, что страница задач открылась")
    public boolean isOpened() {
        return projectPage.isProjectHeaderDisplayed();
    }

    @Step("Переход во все задачи")
    public ProjectSteps goToAllTasks() {
        String oldCounterText = projectPage.getTaskCounterText();

        projectPage
                .clickSwitchFilter()
                .clickChooseAllTasks()
                .waitAllTasksTitle()
                .waitTestingCoverage()
                .waitForTaskCounterChanged(oldCounterText);
        return this;
    }

    @Step("Переключение на `Все задачи`")
    public BrowseSteps goToAdvancedSearch() {
        projectPage.clickAllTasksAndFilter();
        return new BrowseSteps();
    }


    @Step("Получение количества задач")
    public int getTasksCount() {
        return projectPage.getTasksCount();
    }

    @Step("Ожидание, что счётчик задач увеличился относительно {previousCount}")
    public void waitTasksCountIncreased(int previousCount) {
        Selenide.Wait().until(_ -> projectPage.getTasksCount() > previousCount);
    }

    @Step("Создание задачи(бага) через быстрый ввод")
    public void createQuickTask(String summaryText) {
        projectPage
                .clickCreateTaskQuick()
                .setSummary(summaryText)
                .pressEnter();
    }
}
