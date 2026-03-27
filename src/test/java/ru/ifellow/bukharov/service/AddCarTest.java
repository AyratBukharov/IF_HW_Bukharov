package ru.ifellow.bukharov.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.BaseCarTest;
import ru.ifellow.bukharov.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тест добавления автомобилей")
public class AddCarTest extends BaseCarTest {

    @Test
    @DisplayName("Проверка метода добавления автомобилей")
    void testAddCar() {
        List<Car> list = new ArrayList<>();
        AddCar.addCar(list);

        assertFalse(list.isEmpty());
        assertTrue(list.size() >= 10);
    }
}
