package ru.ifellow.bukharov.ifellowEduJira.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.ifellow.bukharov.ifellowEduJira.config.TestConfig;

import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    private final TestConfig config = ConfigFactory.create(TestConfig.class);

    @Before()
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.browser = "chrome";
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        open(config.baseUrl());
    }

    @After
    public void afterTest() {
        Selenide.closeWebDriver();
    }
}
