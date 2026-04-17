package ru.ifellow.bukharov.ifellowEduJira.step;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Тогда;
import lombok.RequiredArgsConstructor;
import org.aeonbits.owner.ConfigFactory;
import ru.ifellow.bukharov.ifellowEduJira.config.TestConfig;
import ru.ifellow.bukharov.ifellowEduJira.page.AuthenticationPage;
import ru.ifellow.bukharov.ifellowEduJira.page.DashboardPage;

@RequiredArgsConstructor
public class AuthenticationStep {

    private final AuthenticationPage authenticationPage = new AuthenticationPage();
    private final TestConfig config = ConfigFactory.create(TestConfig.class);

    @Допустим("успешно залогинились")
    public void loginTest() {
        authenticationPage.authentication(
                config.username(),
                config.password()
        );
    }

    @Тогда("попадаем на Dashboard")
    public void checkDashboard() {
        new DashboardPage().shouldBeOpened();
    }
}