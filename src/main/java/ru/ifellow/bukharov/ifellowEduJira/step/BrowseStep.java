package ru.ifellow.bukharov.ifellowEduJira.step;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.bukharov.ifellowEduJira.context.Context;
import ru.ifellow.bukharov.ifellowEduJira.page.BrowsePage;

@RequiredArgsConstructor
public class BrowseStep {

    private final Context context;

    @Когда("ищем задачу {string}")
    public void findTask(String taskName) {
        BrowsePage browsePage = context.getDashboardPage()
                .goToTest()
                .goToAllTaskAndFilter()
                .findTaskByName(taskName);
        context.setBrowsePage(browsePage);
    }

    @Тогда("статус задачи {string}")
    public void checkStatus(String status) {
        Assertions.assertEquals(status.toLowerCase(),
                context.getBrowsePage().getStatus().toLowerCase());
    }

    @Тогда("версия задачи {string}")
    public void checkVersion(String version) {
        Assertions.assertEquals(version.toLowerCase(),
                context.getBrowsePage().getVersion().toLowerCase());
    }
}
