package ru.ifellow.bukharov.ifellowEduJira.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.ifellow.bukharov.ifellowEduJira.AllureEnvironmentWriter;
import ru.ifellow.bukharov.ifellowEduJira.config.AllureConfig;
import ru.ifellow.bukharov.ifellowEduJira.config.EnvironmentConfig;
import ru.ifellow.bukharov.ifellowEduJira.config.TestConfig;
import ru.ifellow.bukharov.ifellowEduJira.step.AuthenticationSteps;
import ru.ifellow.bukharov.ifellowEduJira.step.DashboardSteps;

public class Hooks {

    protected DashboardSteps dashboardSteps;
    protected final TestConfig config = ConfigFactory.create(TestConfig.class, System.getProperties());
    protected final EnvironmentConfig envConfig = ConfigFactory.create(EnvironmentConfig.class, System.getProperties());

    @BeforeAll
    static void setListener() {
        AllureConfig allureConfig = ConfigFactory.create(AllureConfig.class, System.getProperties());

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(allureConfig.screenshots())
                        .savePageSource(allureConfig.savePageSource())
                        .includeSelenideSteps(allureConfig.includeSelenideSteps())
        );
    }

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = envConfig.pageLoadStrategy();
        Configuration.browser = envConfig.browser();
        Configuration.browserSize = null;
        Configuration.timeout = envConfig.timeout();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        Selenide.open(config.baseUrl());
        AuthenticationSteps authSteps = new AuthenticationSteps();
        dashboardSteps = authSteps.login(config.username(), config.password());
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @AfterAll
    public static void writeEnvironment() {
        SelenideLogger.removeListener("AllureSelenide");
        AllureEnvironmentWriter.write();
    }
}
