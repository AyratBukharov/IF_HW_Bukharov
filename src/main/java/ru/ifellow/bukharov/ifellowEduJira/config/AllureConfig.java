package ru.ifellow.bukharov.ifellowEduJira.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:allure.properties",
        "system:properties"
})
@LoadPolicy(Config.LoadType.MERGE)
public interface AllureConfig extends Config {

    @Key("allure.screenshots")
    boolean screenshots();

    @Key("allure.save.page.source")
    boolean savePageSource();

    @Key("allure.include.selenide.steps")
    boolean includeSelenideSteps();
}
