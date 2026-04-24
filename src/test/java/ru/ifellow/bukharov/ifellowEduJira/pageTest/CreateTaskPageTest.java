package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.step.CreateTaskSteps;

import static ru.ifellow.bukharov.ifellowEduJira.enums.TaskStatus.DONE;

@Feature("Создание задач")
public class CreateTaskPageTest extends EduJiraBaseTest {

    @Test
    @Story("Создание бага с полным описанием и перевод в статус 'ГОТОВО'")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("5. Создание нового бага с описанием")
    public void createNewBug() {
        CreateTaskSteps taskSteps = dashboardSteps
                .openCreateTaskForm()
                .createFullTask(
                        config.topicText(),
                        config.descriptionText(),
                        config.tagsText(),
                        config.environmentText(),
                        config.projectText(),
                        config.typeTaskText(),
                        config.priorityText(),
                        config.relatedTaskTet(),
                        config.executorText()
                );

        Assertions.assertTrue(taskSteps.getCreationMessage().contains(config.successMessage()), () -> String.format(
                "Сообщение о создании задачи не содержит: '%s'", config.successMessage()));
        Assertions.assertEquals(DONE.getValue(), taskSteps.closeTaskAndGetStatus(DONE.getValue()).toLowerCase(),
                "Статус задачи не поменялся");
    }
}
