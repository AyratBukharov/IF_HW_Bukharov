package ru.ifellow.bukharov.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({"classpath:masking.properties",
        "system:properties"
})
@LoadPolicy(LoadType.MERGE)
public interface MaskingConfig extends Config {

    @Key("sensitive.fields")
    String sensitiveFields();

    @Key("sensitive.headers")
    String sensitiveHeaders();
}
