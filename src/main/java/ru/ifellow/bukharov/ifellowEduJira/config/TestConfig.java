package ru.ifellow.bukharov.ifellowEduJira.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:config.properties")
public interface TestConfig extends Config {

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("base.url")
    String baseUrl();
}
