package com.lab;

public class Main {

    public static void main(String[] args) {
        Car bmw = new Car("BMW", "1992", 120);
        SerializeCar.serialize(bmw);
        Car car = SerializeCar.deserialize();
    }
}

