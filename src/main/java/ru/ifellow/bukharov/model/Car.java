package ru.ifellow.bukharov.model;

import lombok.Getter;

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

    private String validateModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("модель автомобиля не может быть null или пустой");
        }
        return model.trim();
    }

    private int validateYear(int year) {
        if (year < 1980 || year > 2026) {
            throw new IllegalArgumentException("год выпуска должен быть от 1980 до 2026 года");
        }
        return year;
    }

    private double validateEngine(double engine) {
        if (engine < 0.6 || engine > 10.4) {
            throw new IllegalArgumentException("объём двигателя должен быть в диапазоне от 0.6 до 10.4 л");
        }
        return engine;
    }

    private Color validateColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("цвет не может быть null");
        }
        return color;
    }

    private BodyStyle validateBodyStyle(BodyStyle bodyStyle) {
        if (bodyStyle == null) {
            throw new IllegalArgumentException("тип кузова не может быть null");
        }
        return bodyStyle;
    }

    private Transmission validateTransmission(Transmission transmission) {
        if (transmission == null) {
            throw new IllegalArgumentException("коробка передач не может быть null");
        }
        return transmission;
    }

    private DriveWheels validateDriveWheels(DriveWheels driveWheels) {
        if (driveWheels == null) {
            throw new IllegalArgumentException("привод не может быть null");
        }
        return driveWheels;
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