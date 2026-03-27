package ru.ifellow.bukharov.validation;

import ru.ifellow.bukharov.model.BodyStyle;
import ru.ifellow.bukharov.model.Color;
import ru.ifellow.bukharov.model.DriveWheels;
import ru.ifellow.bukharov.model.Transmission;

/**
 * Валидация данных автомобиля.
 */
public class CarValidator {

    public static String validateModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("модель автомобиля не может быть null или пустой");
        }
        return model.trim();
    }

    public static int validateYear(int year) {
        if (year < 1980 || year > 2026) {
            throw new IllegalArgumentException("год выпуска должен быть от 1980 до 2026 года");
        }
        return year;
    }

    public static double validateEngine(double engine) {
        if (engine < 0.6 || engine > 10.4) {
            throw new IllegalArgumentException("объём двигателя должен быть в диапазоне от 0.6 до 10.4 л");
        }
        return engine;
    }

    public static Color validateColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("цвет не может быть null");
        }
        return color;
    }

    public static BodyStyle validateBodyStyle(BodyStyle bodyStyle) {
        if (bodyStyle == null) {
            throw new IllegalArgumentException("тип кузова не может быть null");
        }
        return bodyStyle;
    }

    public static Transmission validateTransmission(Transmission transmission) {
        if (transmission == null) {
            throw new IllegalArgumentException("коробка передач не может быть null");
        }
        return transmission;
    }

    public static DriveWheels validateDriveWheels(DriveWheels driveWheels) {
        if (driveWheels == null) {
            throw new IllegalArgumentException("привод не может быть null");
        }
        return driveWheels;
    }
}
