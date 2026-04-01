package ru.ifellow.bukharov.ifellowEduJira.page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.ifellowEduJira.Authorization;
import ru.ifellow.bukharov.ifellowEduJira.WebHooks;

public class AuthorizationPageTest extends WebHooks {

    private final Authorization authorization = new Authorization();

    @Test
    @DisplayName("1. Авторизация")
    public void loginTest() {
        DashboardPage dashboardPage = authorization.login();

        Assertions.assertTrue(dashboardPage.isOpened(),
                "Dashboard не открылся после авторизации");
    }
}
