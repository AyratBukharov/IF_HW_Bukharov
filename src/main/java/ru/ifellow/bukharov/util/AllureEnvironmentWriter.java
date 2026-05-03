package ru.ifellow.bukharov.util;

import org.aeonbits.owner.ConfigFactory;
import ru.ifellow.bukharov.config.EnvironmentConfig;
import ru.ifellow.bukharov.config.TestConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class AllureEnvironmentWriter {

    public static void write() {
        TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());
        EnvironmentConfig envConfig = ConfigFactory.create(EnvironmentConfig.class, System.getProperties());

        Properties properties = new Properties();

        properties.put("Environment", envConfig.environmentName());
        properties.put("Owner", envConfig.owner());
        properties.put("Server API URL", testConfig.baseUrlServer());
        properties.put("Rick and Morty API URL", testConfig.baseUrlMorty());
        properties.put("OS", System.getProperty("os.name"));
        properties.put("Java version", System.getProperty("java.version"));


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
