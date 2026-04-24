package ru.ifellow.bukharov.ifellowEduJira.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class CreateTaskPage {

    private final SelenideElement project = $x("//input[@id='project-field']")
            .as("Поле 'Проект'");

    private final SelenideElement typeTask = $x("//input[@id='issuetype-field']")
            .as("Поле 'Тип задачи'");

    private final SelenideElement topic = $x("//input[@id='summary']")
            .as("Поле 'Тема'");

    private final SelenideElement visualDescription = $x("(//button[text()='Визуальный'])[1]")
            .as("Кнопка 'Визуальный' в описании");

    private final SelenideElement description = $x("//iframe[@id='mce_0_ifr']")
            .as("Поле описание''");

    private final SelenideElement bodyInDescription = $x("//body[@id='tinymce']")
            .as("Тело внутри поля 'Описание'");

    private final SelenideElement version = $x("(//option[@value='10000'])[1]")
            .as("Поле 'Исправить в версиях'");

    private final SelenideElement priority = $x("//input[@id='priority-field']")
            .as("Поле 'Приоритет'");

    private final SelenideElement tags = $x("//textarea[@id='labels-textarea']")
            .as("Поле 'Метки'");

    private final SelenideElement visualEnvironment = $x("(//button[text()='Визуальный'])[2]")
            .as("Кнопка 'Визуальный' в окружении");

    private final SelenideElement environment = $x("//iframe[@id='mce_6_ifr']")
            .as("Поле 'Окружение'");

    private final SelenideElement bodyInEnvironment = $x("//body[@id='tinymce']")
            .as("Тело внутри поля 'Окружение'");

    private final SelenideElement useVersion = $x("(//option[@value='10000'])[2]")
            .as("Поле 'Затронутые версии'");

    private final SelenideElement relatedTask = $x("//select[@id='issuelinks-linktype']")
            .as("Поле 'Связанные таблицы'");

    private final SelenideElement task = $x("(//textarea[@id='issuelinks-issues-textarea'])[1]")
            .as("Поле 'Задача'");

    private final SelenideElement executor = $x("//input[@id='assignee-field']")
            .as("Поле 'Исполнитель'");

    private final SelenideElement selectMeExecutor = $x("//button[@id='assign-to-me-trigger']")
            .as("Кнопка 'Назначить меня' в поле 'Исполнитель'");

    private final SelenideElement epic = $x("//input[@id='customfield_10100-field']")
            .as("Поле 'Ссылка на эпик'");

    private final SelenideElement sprint = $x("//input[@id='customfield_10104-field']")
            .as("Поле 'Спринт'");

    private final SelenideElement seriousness = $x("//option[@value='10101']")
            .as("Поле 'Серьёзность'");

    private final SelenideElement createButton = $x("//input[@id='create-issue-submit']")
            .as("Кнопка 'Создать'");

    private final SelenideElement message = $x("//a[@class='issue-created-key issue-link']")
            .as("Сообщение об успешном создании задачи");

    private final SelenideElement messageCreated = $x("//div[@class='aui-message closeable aui-message-success aui-will-close']")
            .as("Сообщение о созданном баге");

    private final SelenideElement taskButton = $x("//a[@id='find_link']")
            .as("Кнопка 'Задачи'");

    private final SelenideElement businessProcess = $x("//a[@id='opsbar-transitions_more']")
            .as("Кнопка 'Бизнес-процесс'");

    private final SelenideElement doneButton = $x("//aui-item-link[@id='action_id_31']")
            .as("Кнопка 'Выполнено'");

    private final SelenideElement status = $x("//span[@id='status-val']")
            .as("Статус задачи");

    private final SelenideElement myOpenTasks = $x("//a[@id='filter_lnk_my_lnk']")
            .as("мои открытые задачи");

    public void waitFormOpened() {
        topic.shouldBe(Condition.visible);
    }

    public void setTopic(String topicText) {
        topic.shouldBe(Condition.visible).setValue(topicText);
    }

    public void selectFixVersion() {
        version.shouldBe(Condition.visible).click();
    }

    public void setTags(String tagsText) {
        tags.shouldBe(Condition.visible).setValue(tagsText);
    }

    public void fillDescriptionWithText(String descriptionText) {
        visualDescription.click();
        switchTo().frame(description);
        bodyInDescription.shouldBe(Condition.visible).setValue(descriptionText);
        switchTo().defaultContent();
    }

    public void fillEnvironmentWithText(String environmentText) {
        visualEnvironment.click();
        switchTo().frame(environment);
        bodyInEnvironment.shouldBe(Condition.visible).setValue(environmentText);
        switchTo().defaultContent();
    }

    public void selectAffectsVersion() {
        useVersion.shouldBe(Condition.visible).click();
    }

    public void selectSeriousness() {
        seriousness.shouldBe(Condition.visible).click();
    }

    public void clickCreateButton() {
        createButton.shouldBe(Condition.visible).click();
    }

    public String getCreationMessageText() {
        return messageCreated.shouldBe(Condition.visible).getText();
    }

    public CreateTaskPage clickTasksMenu() {
        taskButton.shouldBe(Condition.visible).click();
        return this;
    }

    public CreateTaskPage clickMyOpenTasks() {
        myOpenTasks.shouldBe(Condition.visible).click();
        return this;
    }

    public CreateTaskPage clickBusinessProcess() {
        businessProcess.shouldBe(Condition.visible).click();
        return this;
    }

    public CreateTaskPage clickDone() {
        doneButton.shouldBe(Condition.visible).click();
        return this;
    }

    public void checkDefaultValues(String projectText, String typeTaskText, String priorityText) {
        project.shouldHave(Condition.value(projectText));
        typeTask.shouldHave(Condition.value(typeTaskText));
        priority.shouldHave(Condition.value(priorityText));
    }

    public void checkRelatedTask(String relatedTaskText) {
        relatedTask.shouldHave(Condition.value(relatedTaskText));
        task.shouldBe(Condition.empty);
    }

    public void assignExecutorWithCheck(String executorText) {
        executor.shouldHave(Condition.value(executorText));
        selectMeExecutor.shouldBe(Condition.visible).click();
    }

    public void checkEpicAndSprint() {
        epic.shouldBe(Condition.empty);
        sprint.shouldBe(Condition.empty);
    }

    public void verifyCreation() {
        message.shouldBe(Condition.visible);
    }

    public String getStatusText(String expectedStatus) {
        return status.shouldHave(Condition.text(expectedStatus)).getText();
    }
}
