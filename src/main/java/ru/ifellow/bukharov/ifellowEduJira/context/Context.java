package ru.ifellow.bukharov.ifellowEduJira.context;

import lombok.Getter;
import lombok.Setter;
import ru.ifellow.bukharov.ifellowEduJira.page.BrowsePage;
import ru.ifellow.bukharov.ifellowEduJira.page.CreateTaskPage;
import ru.ifellow.bukharov.ifellowEduJira.page.DashboardPage;
import ru.ifellow.bukharov.ifellowEduJira.page.ProjectPage;

@Setter
@Getter
public class Context {
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;
    private BrowsePage browsePage;
    private CreateTaskPage createTaskPage;
    private int tasksCountBefore;
}
