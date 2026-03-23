package ru.ifellow.bukharov.model;

public class Toyota extends Car {

    private final int maxSpeed;

    public Toyota(String model, int year, Color color, BodyStyle bodyStyle,
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
        return "Считается, что у " + this.getClass().getSimpleName() + " самые надёжные автомобили";
    }
}
