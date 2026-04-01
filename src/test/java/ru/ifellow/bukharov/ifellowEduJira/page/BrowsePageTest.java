package ru.ifellow.bukharov.ifellowEduJira.page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authorization;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;

public class BrowsePageTest extends WebHooks {

    private final Authorization authorization = new Authorization();

    @Test
    @DisplayName("4. Переход в задачу TestSeleniumATHomework и проверка статуса и версии")
    public void checkTask() {
        BrowsePage browsePage = authorization.login()
                .goToTest()
                .goToAllTaskAndFilter()
                .findTestSelenium();

        Assertions.assertEquals("сделать", browsePage.getStatus().toLowerCase(),
                "Статус задачи неверный");
        Assertions.assertEquals("version 2.0", browsePage.getVersion().toLowerCase(),
                "Исправить в версиях неверно");
    }
}
