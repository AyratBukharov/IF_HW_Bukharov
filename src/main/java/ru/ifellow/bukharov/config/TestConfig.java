package ru.ifellow.bukharov.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

import java.io.File;

@Sources("classpath:config.properties")
public interface TestConfig extends Config {

    @Key("base.url.morty")
    String baseUrlMorty();

    @Key("base.url.server")
    String baseUrlServer();

    @Key("search.name")
    String searchName();

    @Key("json.file")
    File jsonFile();
}
