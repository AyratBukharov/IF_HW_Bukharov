package ru.ifellow.bukharov.ifellowEduJira;

import org.aeonbits.owner.ConfigFactory;
import ru.ifellow.bukharov.ifellowEduJira.config.EnvironmentConfig;
import ru.ifellow.bukharov.ifellowEduJira.config.TestConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class AllureEnvironmentWriter {

    public static void write() {

        TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());
        EnvironmentConfig envConfig = ConfigFactory.create(EnvironmentConfig.class, System.getProperties()
        );

        Properties properties = new Properties();

        properties.put("Environment", envConfig.environmentName());
        properties.put("BaseURL", testConfig.baseUrl());
        properties.put("Browser", envConfig.browser());
        properties.put("Timeout", String.valueOf(envConfig.timeout()));
        properties.put("PageLoadStrategy", envConfig.pageLoadStrategy());
        properties.put("OS", System.getProperty("os.name"));
        properties.put("JavaVersion", System.getProperty("java.version"));

        String resultsDir = System.getProperty("allure.results.directory", "target/allure-results");
        File file = new File(resultsDir, "environment.properties");
        file.getParentFile().mkdirs();

        try (FileOutputStream fos = new FileOutputStream(file)) {
            properties.store(fos, "Allure Environment");
        } catch (Exception e) {
            throw new RuntimeException("Failed to write Allure environment properties", e);
        }
    }
}
