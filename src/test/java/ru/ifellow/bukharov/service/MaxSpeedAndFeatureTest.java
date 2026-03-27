package ru.ifellow.bukharov.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.BaseCarTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Тест вывода максимальной скорости и особенности автомобиля")
public class MaxSpeedAndFeatureTest extends BaseCarTest {

    @Test
    @DisplayName("Проверка метода, который выводит максимальную скорость автомобиля и особенность данной марки")
    void maxSpeedAndCarFeature() {
        assertDoesNotThrow(() -> MaxSpeedAndFeature.maxSpeedAndCarFeature(carList));
    }
}
