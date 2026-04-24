package ru.ifellow.bukharov.ifellowEduJira.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:environment.properties",
        "system:properties"
})
@LoadPolicy(Config.LoadType.MERGE)
public interface EnvironmentConfig extends Config {

    @Key("env.name")
    String environmentName();

    @Key("browser")
    String browser();

    @Key("timeout")
    long timeout();

    @Key("page.load.strategy")
    String pageLoadStrategy();
}
