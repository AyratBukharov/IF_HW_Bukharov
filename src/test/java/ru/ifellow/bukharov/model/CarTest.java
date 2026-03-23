package ru.ifellow.bukharov.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты по созданию и изменению объекта")
class CarTest {

    private Car audi;

    @BeforeEach
    void setUp() {
        audi = new Audi("A7", 2011, Color.GREEN, BodyStyle.SEDAN,
                Transmission.AUTOMATIC, DriveWheels.AWD, 4, 250);
    }

    @Test
    @DisplayName("Успешное создание объекта")
    void testCreateValidCar() {
        assertAll(
                () -> assertEquals("A7", audi.getModel()),
                () -> assertEquals(2011, audi.getYear()),
                () -> assertEquals(Color.GREEN, audi.getColor()),
                () -> assertEquals(BodyStyle.SEDAN, audi.getBodyStyle()),
                () -> assertEquals(Transmission.AUTOMATIC, audi.getTransmission()),
                () -> assertEquals(DriveWheels.AWD, audi.getDriveWheels()),
                () -> assertEquals(4.0, audi.getEngine()));
    }

    @ParameterizedTest(name = "модель: {0}")
    @NullAndEmptySource
    @DisplayName("Проверка поля 'модель' на null или пустую строку")
    void testCarModel(String model) {
        assertThrows(IllegalArgumentException.class, () -> new Audi(
                model, 2011, Color.BLACK, BodyStyle.SEDAN,
                Transmission.AUTOMATIC, DriveWheels.AWD, 4, 250));
    }

    @ParameterizedTest(name = "год выпуска: {0}")
    @ValueSource(ints = {1960, 1979, 2027, 2030})
    @DisplayName("Проверка поля 'год выпуска' на значения меньше или больше допустимого")
    void testCarYear(int year) {
        assertThrows(IllegalArgumentException.class, () ->
                new Audi("A7", year, Color.BLACK, BodyStyle.SEDAN,
                        Transmission.AUTOMATIC, DriveWheels.AWD, 4, 250));
    }

    @ParameterizedTest(name = "цвет: {0}")
    @NullSource
    @DisplayName("Проверка поля 'цвет' при создании объекта на null")
    void testCarColor(Color color) {
        assertThrows(IllegalArgumentException.class, () ->
                new Audi("A7", 2011, color, BodyStyle.SEDAN,
                        Transmission.AUTOMATIC, DriveWheels.AWD, 4, 250));
    }

    @ParameterizedTest(name = "тип кузова: {0}")
    @NullSource
    @DisplayName("Проверка поля 'тип кузова' при создании объекта на null")
    void testCarBodyStyle(BodyStyle bodyStyle) {
        assertThrows(IllegalArgumentException.class, () ->
                new Audi("A7", 2011, Color.BLACK, bodyStyle,
                        Transmission.AUTOMATIC, DriveWheels.AWD, 4, 250));
    }

    @ParameterizedTest(name = "коробка передач: {0}")
    @NullSource
    @DisplayName("Проверка поля 'коробка передач' при создании объекта на null")
    void testCarTransmission(Transmission transmission) {
        assertThrows(IllegalArgumentException.class, () ->
                new Audi("A7", 2011, Color.BLACK, BodyStyle.SEDAN,
                        transmission, DriveWheels.AWD, 4, 250));
    }

    @ParameterizedTest(name = "привод: {0}")
    @NullSource
    @DisplayName("Проверка поля 'привод' при создании объекта на null")
    void testCarDriveWheels(DriveWheels driveWheels) {
        assertThrows(IllegalArgumentException.class, () ->
                new Audi("A7", 2011, Color.BLACK, BodyStyle.SEDAN,
                        Transmission.AUTOMATIC, driveWheels, 4, 250));
    }

    @ParameterizedTest(name = "объём двигателя: {0}")
    @ValueSource(doubles = {-4, 0, 0.59, 10.5, 24})
    @DisplayName("Проверка поля 'объём двигателя' на значения меньше или больше допустимого")
    void testCarEngine(double engine) {
        assertThrows(IllegalArgumentException.class, () ->
                new Audi("A7", 2011, Color.BLACK, BodyStyle.SEDAN,
                        Transmission.AUTOMATIC, DriveWheels.AWD, engine, 250));
    }

    @Test
    @DisplayName("Проверка изменения поля 'цвет'")
    void testCarSetColor() {
        audi.setNewColor(Color.RED);

        assertEquals(Color.RED, audi.getColor());
    }

    @ParameterizedTest(name = "цвет: {0}")
    @NullSource
    @DisplayName("Проверка поля 'цвет' при изменении цвета объекта на null")
    void testCarSetColorIsNull(Color color) {
        assertThrows(IllegalArgumentException.class, () ->
                audi.setNewColor(color));
    }
}