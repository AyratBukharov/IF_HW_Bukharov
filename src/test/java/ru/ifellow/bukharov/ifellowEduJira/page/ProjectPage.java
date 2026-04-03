package ru.ifellow.bukharov.ifellowEduJira.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница задач
 */
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

    public ProjectPage shouldBeOpened() {
        projectHeader.shouldBe(Condition.visible);
        return this;
    }

    public boolean isOpened() {
        return projectHeader.isDisplayed();
    }

    /**
     * Переход к списку всех задач
     */
    public ProjectPage goToAllTasks() {
        switchFilter.shouldBe(Condition.visible).click();
        chooseAllTasks.shouldBe(Condition.visible).click();
        allTasksTitle.shouldBe(Condition.visible).shouldHave(Condition.textCaseSensitive("Все задачи"));
        return this;
    }

    /**
     * Переход к расширенному поиску задач
     */
    public BrowsePage goToAllTaskAndFilter() {
        allTasksAndFilter.shouldBe(Condition.visible).click();
        return new BrowsePage();
    }

    /**
     * Создание задачи через быстрый ввод
     */
    public ProjectPage createTask() {
        createTaskButton.shouldBe(Condition.visible).click();
        summary.shouldBe(Condition.visible).setValue("что то должно быть сделано").pressEnter();
        return this;
    }

    /**
     * Возвращает общее количество задач в проекте
     */
    public int getTasksCount() {
        String text = taskCounter.shouldBe(Condition.visible).getText();
        String countInt = text.split("из")[1].trim();
        return Integer.parseInt(countInt);
    }

    /**
     * Ожидание изменения количества задач
     */
    public ProjectPage waitTasksCount(int expectedCount) {
        taskCounter.shouldHave(
                Condition.text(String.valueOf(expectedCount)),
                Duration.ofSeconds(10)
        );
        return this;
    }
}
