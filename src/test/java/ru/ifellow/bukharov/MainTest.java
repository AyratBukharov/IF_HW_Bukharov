package ru.ifellow.bukharov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifellow.bukharov.model.Car;
import ru.ifellow.bukharov.model.Color;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты методов в Main")
class MainTest {

    private List<Car> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        Main.addCar(list);
    }

    @Test
    @DisplayName("Проверка метода добавления автомобилей")
    void testAddCar() {
        List<Car> list = new ArrayList<>();
        Main.addCar(list);

        assertFalse(list.isEmpty());
        assertTrue(list.size() >= 10);
    }

    @Test
    @DisplayName("Проверка метода изменения цвета автомобиля с зеленого на красный")
    void testSetColorCar() {
        Main.setColorCar(list);

        for (Car car : list) {
            assertNotEquals(Color.GREEN, car.getColor());
        }
    }

    @Test
    @DisplayName("Проверка метода, который выводит максимальную скорость автомобиля и особенность данной марки")
    void testFindOldAndNewCar() {
        assertDoesNotThrow(() -> Main.maxSpeedAndCarFeature(list));
    }
}