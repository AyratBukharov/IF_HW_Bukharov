package ru.ifellow.bukharov.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({
        "classpath:environment.properties",
        "system:properties"
})
@LoadPolicy(LoadType.MERGE)
public interface EnvironmentConfig extends Config {

    @Key("env.name")
    String environmentName();

    @Key("owner")
    String owner();
}
