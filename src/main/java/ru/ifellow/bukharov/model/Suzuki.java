package ru.ifellow.bukharov.model;

public class Suzuki extends Car {

    private final int maxSpeed;

    public Suzuki(String model, int year, Color color, BodyStyle bodyStyle,
                  Transmission transmission, DriveWheels driveWheels, double engine, int maxSpeed) {
        super(model, year, color, bodyStyle, transmission, driveWheels, engine);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int maxSpeed() {
        return this.maxSpeed;
    }

    @Override
    public String carFeature() {
        return this.getClass().getSimpleName() + " - японское качество";
    }
}
