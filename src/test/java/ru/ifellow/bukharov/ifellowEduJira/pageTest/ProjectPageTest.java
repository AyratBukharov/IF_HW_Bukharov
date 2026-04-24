package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.step.ProjectSteps;

@Feature("Управление проектом")
public class ProjectPageTest extends EduJiraBaseTest {

    @Test
    @Story("Быстрое создание задачи увеличивает общее количество задач")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("3. Проверка общего количества заведённых задач")
    public void tasksCounter() {
        ProjectSteps projectSteps = dashboardSteps
                .goToTestProject()
                .goToAllTasks();
        int countBefore = projectSteps.getTasksCount();
        projectSteps.createQuickTask(config.summaryText());
        projectSteps.waitTasksCountIncreased(countBefore);
        int countAfter = projectSteps.getTasksCount();

        Assertions.assertTrue(countAfter > countBefore,
                String.format("Счётчик задач не увеличился. Было: %d, стало: %d", countBefore, countAfter));
    }
}
