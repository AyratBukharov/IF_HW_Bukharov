package ru.ifellow.bukharov.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.BaseCarTest;
import ru.ifellow.bukharov.model.Car;
import ru.ifellow.bukharov.model.Color;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Тест изменения цвета автомобиля")
public class CarColorTest extends BaseCarTest {

    @Test
    @DisplayName("Проверка метода изменения цвета автомобиля с зеленого на красный")
    void testSetColorCar() {
        CarColor.setColorCar(carList);

        for (Car car : carList) {
            assertNotEquals(Color.GREEN, car.getColor());
        }
    }

}
