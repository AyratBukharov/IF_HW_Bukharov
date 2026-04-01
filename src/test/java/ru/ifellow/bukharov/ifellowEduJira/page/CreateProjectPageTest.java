package ru.ifellow.bukharov.ifellowEduJira.page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authorization;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;

public class CreateProjectPageTest extends WebHooks {

    private final Authorization authorization = new Authorization();

    @Test
    @DisplayName("5. Создание нового бага с описанием")
    public void createNewBug() {
        CreateProjectPage projectPage = authorization.login()
                .openCreateTask()
                .createNewTask();

        Assertions.assertTrue(projectPage.isCreated().contains("успешно создан"),
                "Текст не содержит 'успешно создан'");

        projectPage.doneNewTask();

        Assertions.assertEquals("готово", projectPage.getStatusMyTask().toLowerCase(),
                "Статус задачи не поменялся");

    }
}
