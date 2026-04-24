package ru.ifellow.bukharov.ifellowEduJira.step;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import ru.ifellow.bukharov.ifellowEduJira.page.AuthenticationPage;

public class AuthenticationSteps {

    private final AuthenticationPage authPage = new AuthenticationPage();
    private final DashboardSteps dashboardSteps = new DashboardSteps();

    @Step("Аутентификация пользователем: {username}")
    public DashboardSteps login(String username, @Param(mode = Parameter.Mode.MASKED) String password) {
        authPage
                .setLogin(username)
                .setPassword(password)
                .clickLoginButton();
        dashboardSteps.isOpened();
        return dashboardSteps;
    }
}
