package ru.ifellow.bukharov.service;

import ru.ifellow.bukharov.model.Car;
import ru.ifellow.bukharov.model.Color;

import java.util.List;

/**
 * Изменение цвета автомобиля.
 */
public class CarColor {

    public static void setColorCar(List<Car> list) {
        for (Car car : list) {
            if (car.getColor() == Color.GREEN) {
                car.setNewColor(Color.RED);
                System.out.format("\nЦвет автомобиля %s был зелёный - изменили на красный\n", car);
            }
        }
    }
}
