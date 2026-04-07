package ru.ifellow.bukharov.ifellowEduJira;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.ifellow.bukharov.ifellowEduJira.config.ConfigReader;

public class WebHooks {

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.browser = "chrome";
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        Selenide.open(ConfigReader.get("base.url"));
    }

    @AfterEach
    public void afterTest() {
        Selenide.closeWebDriver();
    }
}
