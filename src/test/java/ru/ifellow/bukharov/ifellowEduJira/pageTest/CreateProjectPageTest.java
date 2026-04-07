package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authentication;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;
import ru.ifellow.bukharov.ifellowEduJira.page.CreateProjectPage;

public class CreateProjectPageTest extends WebHooks {

    private final Authentication authentication = new Authentication();
    private static final String SUCCESS_MESSAGE = "успешно создан";
    private static final String STATUS_DONE = "готово";

    @Test
    @DisplayName("5. Создание нового бага с описанием")
    @Tag("DZ3")
    public void createNewBug() {
        CreateProjectPage projectPage = authentication.login()
                .openCreateTask()
                .createTask();

        Assertions.assertTrue(projectPage.getCreationMessage().contains(SUCCESS_MESSAGE),
                "Текст не содержит 'успешно создан'");

        projectPage.closeTask();

        Assertions.assertEquals(STATUS_DONE, projectPage.getStatusMyTask().toLowerCase(),
                "Статус задачи не поменялся");

    }
}
