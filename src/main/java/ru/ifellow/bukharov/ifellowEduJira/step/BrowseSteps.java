package ru.ifellow.bukharov.ifellowEduJira.step;

import io.qameta.allure.Step;
import ru.ifellow.bukharov.ifellowEduJira.page.BrowsePage;

public class BrowseSteps {

    private final BrowsePage browsePage = new BrowsePage();

    @Step("Поиск задачи по названию: {taskName}")
    public BrowseSteps findTaskByName(String taskName) {
        browsePage
                .inputSearchText(taskName)
                .clickSearchButton()
                .openOrderByDropdown()
                .selectCreatedFilter()
                .clickOrderByCreated();
        return this;
    }

    @Step("Получение статуса выбранной задачи")
    public String getStatus() {
        return browsePage.getStatus();
    }

    @Step("Получение версии выбранной задачи")
    public String getVersion() {
        return browsePage.getVersion();
    }
}
