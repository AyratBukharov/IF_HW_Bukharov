package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authentication;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;
import ru.ifellow.bukharov.ifellowEduJira.page.BrowsePage;

public class BrowsePageTest extends WebHooks {

    private final Authentication authentication = new Authentication();
    private final static String STATUS = "сделать";
    private final static String VERSION = "version 2.0";
    private final static String TASK_NAME = "TestSeleniumATHomework";

    @Test
    @DisplayName("4. Переход в задачу TestSeleniumATHomework и проверка статуса и версии")
    @Tag("DZ3")
    public void checkTask() {
        BrowsePage browsePage = authentication.login()
                .goToTest()
                .goToAllTaskAndFilter()
                .findTaskByName(TASK_NAME);

        Assertions.assertEquals(STATUS, browsePage.getStatus().toLowerCase(),
                "Статус задачи неверный");
        Assertions.assertEquals(VERSION, browsePage.getVersion().toLowerCase(),
                "Исправить в версиях неверно");
    }
}
