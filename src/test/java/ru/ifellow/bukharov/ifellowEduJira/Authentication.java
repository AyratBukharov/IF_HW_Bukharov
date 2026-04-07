package ru.ifellow.bukharov.ifellowEduJira;

import ru.ifellow.bukharov.ifellowEduJira.config.ConfigReader;
import ru.ifellow.bukharov.ifellowEduJira.page.AuthenticationPage;
import ru.ifellow.bukharov.ifellowEduJira.page.DashboardPage;

public class Authentication {

    private final AuthenticationPage authenticationPage = new AuthenticationPage();

    public DashboardPage login() {
        return authenticationPage.authentication(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }
}
