package ru.ifellow.bukharov;

import ru.ifellow.bukharov.model.Car;

import java.util.ArrayList;
import java.util.List;

import static ru.ifellow.bukharov.service.AddCar.addCar;
import static ru.ifellow.bukharov.service.CarAfter2006year.carAfter2006Year;
import static ru.ifellow.bukharov.service.CarColor.setColorCar;
import static ru.ifellow.bukharov.service.MaxSpeedAndFeature.maxSpeedAndCarFeature;


public class Main {
    //it's Main origin
    public static void main(String[] args) {
        List<Car> list = new ArrayList<>();
        addCar(list);
        carAfter2006Year(list);
        setColorCar(list);
        maxSpeedAndCarFeature(list);
    }
}
