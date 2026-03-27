package ru.ifellow.bukharov.service;

import ru.ifellow.bukharov.model.Car;

import java.util.List;

/**
 * Поиск автомобиля старше 2006 года выпуска.
 */
public class CarAfter2006year {

    public static void carAfter2006Year(List<Car> list) {
        for (Car car : list) {
            if (car.getYear() > 2006) {
                System.out.println(car.getFullInfo());
            } else System.out.format("\n%s - устаревший автомобиль\n", car);
        }
    }
}
