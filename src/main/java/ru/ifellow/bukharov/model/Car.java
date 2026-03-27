package ru.ifellow.bukharov.model;

import lombok.Getter;

import static ru.ifellow.bukharov.validation.CarValidator.*;

@Getter
public abstract class Car {
    private final String model;
    private final int year;
    private Color color;
    private final BodyStyle bodyStyle;
    private final Transmission transmission;
    private final DriveWheels driveWheels;
    private final double engine;

    public Car(String model, int year, Color color, BodyStyle bodyStyle,
               Transmission transmission, DriveWheels driveWheels, double engine) {
        this.model = validateModel(model);
        this.year = validateYear(year);
        this.color = validateColor(color);
        this.bodyStyle = validateBodyStyle(bodyStyle);
        this.transmission = validateTransmission(transmission);
        this.driveWheels = validateDriveWheels(driveWheels);
        this.engine = validateEngine(engine);
    }

    public abstract int maxSpeed();

    public abstract String carFeature();

    public void setNewColor(Color color) {
        this.color = validateColor(color);
    }

    public String getFullInfo() {
        return "\nАвтомобиль:" +
                "\n модель: " + getClass().getSimpleName() + " " + model +
                "\n год выпуска: " + year +
                "\n цвет: " + color +
                "\n тип кузова: " + bodyStyle +
                "\n коробка передач: " + transmission +
                "\n привод: " + driveWheels +
                "\n объём двигателя: " + engine + " л";
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", getClass().getSimpleName(), model, year);
    }
}