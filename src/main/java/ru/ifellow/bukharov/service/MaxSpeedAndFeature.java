package ru.ifellow.bukharov.service;

import ru.ifellow.bukharov.model.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Поиск и вывод максимальной скорости автомобиля и особенности марки.
 */
public class MaxSpeedAndFeature {

    public static void maxSpeedAndCarFeature(List<Car> list) {
        Set<String> blackList = new HashSet<>();
        String brandCar;

        for (Car car : list) {
            System.out.format("\nМаксимальная скорость автомобиля %s: %d км/ч\n", car, car.maxSpeed());
            brandCar = car.getClass().getSimpleName();
            if (!blackList.contains(brandCar)) {
                System.out.println(car.carFeature());
                blackList.add(brandCar);
            }
        }
    }
}
