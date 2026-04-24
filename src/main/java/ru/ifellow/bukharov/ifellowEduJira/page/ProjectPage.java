package ru.ifellow.bukharov.ifellowEduJira.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {

    private final SelenideElement projectHeader = $x("//header[@class='aui-page-header issue-search-header']")
            .as("Открытые задачи");

    private final SelenideElement switchFilter = $x("//button[@id='subnav-trigger']")
            .as("Переключить фильтр");

    private final SelenideElement chooseAllTasks = $x("//a[@data-item-id='allissues']")
            .as("Все задачи");

    private final SelenideElement taskCounter = $x("//div[@class='showing']")
            .as("Счётчик всех задач");

    private final SelenideElement createTaskButton = $x("//button[@type='button' and @class='aui-button aui-button-subtle']")
            .as("Создать задачу");

    private final SelenideElement summary = $x("//textarea[@name='summary']")
            .as("Поле для заполнения описания задачи");

    private final SelenideElement allTasksAndFilter = $x("//div[@id='full-issue-navigator']")
            .as("Посмотреть все задачи и фильтры");

    private final SelenideElement allTasksTitle = $x("//span[@id='issues-subnavigation-title']")
            .as("Текст 'Все задачи'");

    private final SelenideElement testingCoverage = $x("//div[@class='css-8dom0t-EmptySection erc8m750']")
            .as("Поле 'Покрытие тестирования'");

    private static final String ALL_TASK_TEXT = "Все задачи";
    private static final String TASK_COUNT_DELIMITER = "из ";

    public boolean isProjectHeaderDisplayed() {
        return projectHeader.isDisplayed();
    }

    public ProjectPage clickSwitchFilter() {
        switchFilter.shouldBe(Condition.visible).click();
        return this;
    }

    public ProjectPage clickChooseAllTasks() {
        chooseAllTasks.shouldBe(Condition.visible).click();
        return this;
    }

    public ProjectPage waitAllTasksTitle() {
        allTasksTitle.shouldBe(Condition.visible).shouldHave(Condition.textCaseSensitive(ALL_TASK_TEXT));
        return this;
    }

    public ProjectPage waitTestingCoverage() {
        testingCoverage.shouldBe(Condition.visible);
        return this;
    }

    public void clickAllTasksAndFilter() {
        allTasksAndFilter.shouldBe(Condition.visible).click();
    }

    public ProjectPage clickCreateTaskQuick() {
        createTaskButton.shouldBe(Condition.visible).click();
        return this;
    }

    public ProjectPage setSummary(String summaryText) {
        this.summary.shouldBe(Condition.visible).setValue(summaryText);
        return this;
    }

    public void pressEnter() {
        summary.pressEnter();
    }

    public int getTasksCount() {
        String text = taskCounter.shouldBe(Condition.visible).getText();
        String countInt = text.split(TASK_COUNT_DELIMITER)[1].trim();
        return Integer.parseInt(countInt);
    }

    public String getTaskCounterText() {
        return taskCounter.shouldBe(Condition.visible).getText();
    }

    public void waitForTaskCounterChanged(String oldText) {
        taskCounter.shouldNot(Condition.exactText(oldText));
    }
}
