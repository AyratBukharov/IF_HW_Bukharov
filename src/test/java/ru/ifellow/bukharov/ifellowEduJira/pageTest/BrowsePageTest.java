package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.step.BrowseSteps;

import static ru.ifellow.bukharov.ifellowEduJira.enums.TaskStatus.IN_PROGRESS;
import static ru.ifellow.bukharov.ifellowEduJira.enums.TaskVersion.VERSION_2;

@Feature("Просмотр задач")
public class BrowsePageTest extends EduJiraBaseTest {

    @Test
    @Story("Поиск задачи по имени и проверка её статуса и версии исправления")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("4. Переход в задачу TestSeleniumATHomework и проверка статуса и версии")
    public void checkTask() {
        BrowseSteps browseSteps = dashboardSteps
                .goToTestProject()
                .goToAdvancedSearch()
                .findTaskByName(config.taskName());

        Assertions.assertEquals(IN_PROGRESS.getValue(), browseSteps.getStatus().toLowerCase(),
                "Статус задачи неверный");
        Assertions.assertEquals(VERSION_2.getValue(), browseSteps.getVersion().toLowerCase(),
                "Исправить в версиях неверно");
    }
}
