package ru.ifellow.bukharov;

import org.junit.jupiter.api.BeforeEach;
import ru.ifellow.bukharov.model.Car;
import ru.ifellow.bukharov.service.AddCar;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для тестов, содержащий общий setup.
 */
public abstract class BaseCarTest {

    protected List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        AddCar.addCar(carList);
    }
}