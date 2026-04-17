package ru.ifellow.bukharov.ifellowEduJira.step;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.bukharov.ifellowEduJira.page.CreateTaskPage;
import ru.ifellow.bukharov.ifellowEduJira.page.DashboardPage;

@RequiredArgsConstructor
public class CreateTaskStep {

    CreateTaskPage createTaskPage = new CreateTaskPage();

    @Когда("создаём новую задачу")
    public void createNewTask() {
        new DashboardPage()
                .openCreateTask()
                .createTask();
    }

    @Тогда("появляется сообщение {string}")
    public void checkMessage(String message) {
        Assertions.assertTrue(
                createTaskPage.getCreationMessage().contains(message));
    }

    @Тогда("статус задачи становится {string}")
    public void checkStatus(String status) {
        createTaskPage.closeTask();
        Assertions.assertEquals(status.toLowerCase(),
                createTaskPage.getStatusMyTask().toLowerCase());
    }
}
