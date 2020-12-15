package com.lab;

import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private String year;
    private Integer hp;

    public Car(String name, String year, Integer hp) {
        this.name = name;
        this.year = year;
        this.hp = hp;
    }
}
