package ru.ifellow.bukharov;

import ru.ifellow.bukharov.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    //it's Main origin
    public static void main(String[] args) {
        List<Car> list = new ArrayList<>();
        addCar(list);
        carAfter2006Year(list);
        setColorCar(list);
        maxSpeedAndCarFeature(list);
    }

    public static void addCar(List<Car> list) {
        list.add(new Audi("A7", 2011, Color.BLACK, BodyStyle.SEDAN,
                Transmission.AUTOMATIC, DriveWheels.AWD, 4, 250));

        list.add(new Audi("A2", 2002, Color.GREEN, BodyStyle.HATCHBACK,
                Transmission.AUTOMATIC, DriveWheels.FWD, 4, 202));

        list.add(new BMW("X7", 2022, Color.BLACK, BodyStyle.SUV,
                Transmission.AUTOMATIC, DriveWheels.RWD, 3, 280));

        list.add(new Toyota("Crown", 2007, Color.WHITE, BodyStyle.SEDAN,
                Transmission.AUTOMATIC, DriveWheels.RWD, 3.5, 200));

        list.add(new Toyota("Hilux", 1995, Color.GRAY, BodyStyle.PICKUP,
                Transmission.MANUAL, DriveWheels.AWD, 2.8, 180));

        list.add(new Lada("Granta", 2019, Color.BLUE, BodyStyle.SEDAN,
                Transmission.MANUAL, DriveWheels.FWD, 1.6, 169));

        list.add(new Lada("2104", 2001, Color.GREEN, BodyStyle.SEDAN,
                Transmission.MANUAL, DriveWheels.RWD, 1.5, 165));

        list.add(new Lada("Iskra", 2026, Color.SILVER, BodyStyle.SEDAN,
                Transmission.AUTOMATIC, DriveWheels.FWD, 1.6, 170));

        list.add(new Suzuki("Jimny", 2018, Color.GREEN, BodyStyle.SUV,
                Transmission.AUTOMATIC, DriveWheels.AWD, 1.3, 145));

        list.add(new BMW("5", 2006, Color.WHITE, BodyStyle.SEDAN,
                Transmission.AUTOMATIC, DriveWheels.RWD, 2.2, 305));

        list.add(new Toyota("Camry", 2021, Color.BLACK, BodyStyle.SEDAN,
                Transmission.AUTOMATIC, DriveWheels.FWD, 2.5, 180));

        list.add(new Audi("Q5", 2020, Color.RED, BodyStyle.HATCHBACK,
                Transmission.AUTOMATIC, DriveWheels.AWD, 2, 250));
    }

    public static void carAfter2006Year(List<Car> list) {
        for (Car car : list) {
            if (car.getYear() > 2006) {
                System.out.println(car.getFullInfo());
            } else System.out.format("\n%s - устаревший автомобиль\n", car);
        }
    }

    public static void setColorCar(List<Car> list) {
        for (Car car : list) {
            if (car.getColor() == Color.GREEN) {
                car.setNewColor(Color.RED);
                System.out.format("\nЦвет автомобиля %s был зелёный - изменили на красный\n", car);
            }
        }
    }

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
