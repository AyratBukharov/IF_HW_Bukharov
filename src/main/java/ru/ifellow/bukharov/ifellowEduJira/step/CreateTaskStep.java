package ru.ifellow.bukharov.ifellowEduJira.step;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import ru.ifellow.bukharov.ifellowEduJira.context.Context;
import ru.ifellow.bukharov.ifellowEduJira.page.CreateTaskPage;

@RequiredArgsConstructor
public class CreateTaskStep {

    private final Context context;

    @Когда("создаём новую задачу")
    public void createNewTask() {
        CreateTaskPage createTaskPage = context.getDashboardPage()
                .openCreateTask()
                .createTask();
        context.setCreateTaskPage(createTaskPage);
    }

    @Тогда("появляется сообщение {string}")
    public void checkMessage(String message) {
        Assertions.assertTrue(
                context.getCreateTaskPage().getCreationMessage().contains(message));
    }

    @Тогда("статус задачи становится {string}")
    public void checkStatus(String status) {
        context.getCreateTaskPage().closeTask();

        Assertions.assertEquals(status.toLowerCase(),
                context.getCreateTaskPage().getStatusMyTask().toLowerCase());
    }
}
