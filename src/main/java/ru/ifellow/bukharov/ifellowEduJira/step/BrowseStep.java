package ru.ifellow.bukharov.ifellowEduJira.step;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.bukharov.ifellowEduJira.page.BrowsePage;
import ru.ifellow.bukharov.ifellowEduJira.page.DashboardPage;

@RequiredArgsConstructor
public class BrowseStep {

    private BrowsePage browsePage;

    @Когда("ищем задачу {string}")
    public void findTask(String taskName) {
        browsePage = new DashboardPage()
                .goToTest()
                .goToAllTaskAndFilter()
                .findTaskByName(taskName);
    }

    @Тогда("статус задачи {string}")
    public void checkStatus(String status) {
        Assertions.assertEquals(status.toLowerCase(),
                browsePage.getStatus().toLowerCase());
    }

    @Тогда("версия задачи {string}")
    public void checkVersion(String version) {
        Assertions.assertEquals(version.toLowerCase(),
                browsePage.getVersion().toLowerCase());
    }
}
