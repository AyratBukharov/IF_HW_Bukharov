package ru.ifellow.bukharov.ifellowEduJira.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import ru.ifellow.bukharov.ifellowEduJira.page.*;

@Suite
@SelectClasses({
        AuthorizationPageTest.class,
        DashboardPageTest.class,
        ProjectPageTest.class,
        BrowsePageTest.class,
        CreateProjectPageTest.class
})
public class SuiteTest {
}
