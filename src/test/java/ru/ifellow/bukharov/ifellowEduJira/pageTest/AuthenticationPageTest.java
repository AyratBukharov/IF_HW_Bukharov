package ru.ifellow.bukharov.ifellowEduJira.pageTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authentication;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;
import ru.ifellow.bukharov.ifellowEduJira.page.DashboardPage;

public class AuthenticationPageTest extends WebHooks {

    private final Authentication authentication = new Authentication();

    @Test
    @DisplayName("1. Авторизация")
    @Tag("DZ3")
    public void loginTest() {
        DashboardPage dashboardPage = authentication.login();

        Assertions.assertTrue(dashboardPage.isOpened(),
                "Dashboard не открылся после авторизации");
    }
}
