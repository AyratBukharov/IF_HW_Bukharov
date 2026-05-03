package ru.ifellow.bukharov.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

import java.io.File;

@Sources({"classpath:config.properties",
        "system:properties"
})
@LoadPolicy(Config.LoadType.MERGE)
public interface TestConfig extends Config {

    @Key("base.url.morty")
    String baseUrlMorty();

    @Key("morty.character.urn")
    String characterUrn();

    @Key("base.url.server")
    String baseUrlServer();

    @Key("search.name")
    String searchName();

    @Key("json.file")
    File jsonFile();

    @Key("user.bad.username")
    String badUsername();

    @Key("user.bad.pass")
    String badPassword();
}
