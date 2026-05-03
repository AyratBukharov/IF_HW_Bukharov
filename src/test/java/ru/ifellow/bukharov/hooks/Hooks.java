package ru.ifellow.bukharov.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import ru.ifellow.bukharov.util.AllureEnvironmentWriter;
import ru.ifellow.bukharov.util.MaskingFilter;

public class Hooks {

    @BeforeAll
    public static void setFilter() {
        RestAssured.filters(new MaskingFilter());
    }

    @AfterAll
    public static void envWrite() {
        AllureEnvironmentWriter.write();
    }
}
