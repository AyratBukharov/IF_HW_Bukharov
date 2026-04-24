package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.step.ProjectSteps;

@Feature("Панель управления")
public class DashboardPageTest extends EduJiraBaseTest {

    @Test
    @Story("Переход в проект 'Test' с главной панели")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("2. Переход в проект 'Test'")
    public void goToTest() {
        ProjectSteps projectSteps = dashboardSteps
                .goToTestProject();

        Assertions.assertTrue(projectSteps.isOpened(), "Проект 'Test' не открылся");
    }
}
