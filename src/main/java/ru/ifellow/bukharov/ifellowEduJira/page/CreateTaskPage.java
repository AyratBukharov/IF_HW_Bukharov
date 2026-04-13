package ru.ifellow.bukharov.ifellowEduJira.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

/**
 * Окно создания задачи
 */
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

    @Getter
    private String taskNumber;
    @Getter
    private String statusMyTask;

    /**
     * Метод создания новой задачи(бага) с заполнением всех полей
     */
    public CreateTaskPage createTask() {
        project.shouldHave(Condition.value("test"), Duration.ofSeconds(15));
        typeTask.shouldHave(Condition.value("Ошибка"));
        topic.shouldBe(Condition.visible).setValue("Заполнил поле 'Тема'");
        visualDescription.click();
        switchTo().frame(description);
        bodyInDescription.shouldBe(Condition.visible).setValue("Заполнил поле 'Описание'");
        switchTo().defaultContent();
        version.shouldBe(Condition.visible).click();
        priority.shouldHave(Condition.value("Medium"));
        tags.shouldBe(Condition.visible).setValue("Заполнил поле 'Метки'");
        visualEnvironment.shouldBe(Condition.visible).click();
        switchTo().frame(environment);
        bodyInEnvironment.shouldBe(Condition.visible).setValue("Заполнил поле 'Окружение'");
        switchTo().defaultContent();
        useVersion.shouldBe(Condition.visible).click();
        relatedTask.shouldHave(Condition.value("blocks"));
        task.shouldBe(Condition.visible).shouldBe(Condition.empty);
        executor.shouldHave(Condition.value("Автоматически"));
        selectMeExecutor.shouldBe(Condition.visible).click();
        epic.shouldBe(Condition.visible).shouldBe(Condition.empty);
        sprint.shouldBe(Condition.visible).shouldBe(Condition.empty);
        seriousness.shouldBe(Condition.visible).click();
        createButton.shouldBe(Condition.visible).click();
        message.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Метод закрытия бага(задачи): перевод задачи в статус - 'ГОТОВО'
     */
    public void closeTask() {
        taskButton.shouldBe(Condition.visible).click();
        myOpenTasks.shouldBe(Condition.visible).click();
        businessProcess.shouldBe(Condition.visible).click();
        doneButton.shouldBe(Condition.visible).click();
        statusMyTask = status.shouldHave(Condition.text("готово"), Duration.ofSeconds(10)).getText();
    }

    /**
     * Метод проверки сообщения о создании задачи и извлечение её номера
     */
    public String getCreationMessage() {
        taskNumber = messageCreated.shouldBe(Condition.visible, Duration.ofSeconds(5))
                .getText().split(" ")[1].trim();
        return messageCreated.shouldBe(Condition.visible, Duration.ofSeconds(5)).getText();
    }
}
