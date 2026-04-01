package ru.ifellow.bukharov.ifellowEduJira;

import ru.ifellow.bukharov.config.ConfigReader;
import ru.ifellow.bukharov.ifellowEduJira.page.AuthorizationPage;
import ru.ifellow.bukharov.ifellowEduJira.page.DashboardPage;

public class Authorization {

    private final AuthorizationPage authorizationPage = new AuthorizationPage();

    public DashboardPage login() {
        return authorizationPage.authorization(
                ConfigReader.get("userLogin"),
                ConfigReader.get("userPassword")
        );
    }
}