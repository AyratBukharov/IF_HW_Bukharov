package ru.ifellow.bukharov.ifellowEduJira.step;

import io.qameta.allure.Step;
import ru.ifellow.bukharov.ifellowEduJira.page.CreateTaskPage;

public class CreateTaskSteps {

    private final CreateTaskPage createTaskPage = new CreateTaskPage();

    public CreateTaskSteps checkDefaultValues(String projectText, String typeTaskText, String priorityText) {
        createTaskPage.checkDefaultValues(projectText, typeTaskText, priorityText);
        return this;
    }

    public CreateTaskSteps fillTopic(String topicText) {
        createTaskPage.setTopic(topicText);
        return this;
    }

    public CreateTaskSteps fillDescription(String descriptionText) {
        createTaskPage.fillDescriptionWithText(descriptionText);
        return this;
    }

    public CreateTaskSteps selectFixVersion() {
        createTaskPage.selectFixVersion();
        return this;
    }

    public CreateTaskSteps fillTags(String tagsText) {
        createTaskPage.setTags(tagsText);
        return this;
    }

    public CreateTaskSteps fillEnvironment(String environmentText) {
        createTaskPage.fillEnvironmentWithText(environmentText);
        return this;
    }

    public CreateTaskSteps selectAffectsVersion() {
        createTaskPage.selectAffectsVersion();
        return this;
    }

    public CreateTaskSteps checkRelatedTask(String relatedTaskText) {
        createTaskPage.checkRelatedTask(relatedTaskText);
        return this;
    }

    public CreateTaskSteps assignExecutor(String executorText) {
        createTaskPage.assignExecutorWithCheck(executorText);
        return this;
    }

    public CreateTaskSteps checkEpicAndSprint() {
        createTaskPage.checkEpicAndSprint();
        return this;
    }

    public CreateTaskSteps selectSeriousness() {
        createTaskPage.selectSeriousness();
        return this;
    }

    public CreateTaskSteps submitTask() {
        createTaskPage.clickCreateButton();
        return this;
    }

    public CreateTaskSteps verifyCreation() {
        createTaskPage.verifyCreation();
        return this;
    }

    public String getCreationMessage() {
        return createTaskPage.getCreationMessageText();
    }

    @Step("Проверка, что форма создания задачи открылась")
    public void isOpened() {
        createTaskPage.waitFormOpened();
    }

    @Step("Создание новой задачи(бага) с заполнением всех полей")
    public CreateTaskSteps createFullTask(String topicText, String descriptionText, String tagsText,
                                          String environmentText, String projectText, String typeTaskText,
                                          String priorityText, String relatedTaskText, String executorText) {

        return checkDefaultValues(projectText, typeTaskText, priorityText)
                .fillTopic(topicText)
                .fillDescription(descriptionText)
                .selectFixVersion()
                .fillTags(tagsText)
                .fillEnvironment(environmentText)
                .selectAffectsVersion()
                .checkRelatedTask(relatedTaskText)
                .assignExecutor(executorText)
                .checkEpicAndSprint()
                .selectSeriousness()
                .submitTask()
                .verifyCreation();
    }

    @Step("Закрытие задачи(бага) и ожидание статуса: '{expectedStatus}'")
    public String closeTaskAndGetStatus(String expectedStatus) {
        return createTaskPage
                .clickTasksMenu()
                .clickMyOpenTasks()
                .clickBusinessProcess()
                .clickDone()
                .getStatusText(expectedStatus);
    }
}
