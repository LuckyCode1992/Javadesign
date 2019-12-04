package com.justcode.hxl.javadesign.创建者模式.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private List<Wheel> wheels = new ArrayList<>();
    private List<Light> lights = new ArrayList<>();

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void addWheels(String name) {
        getWheels().add(new Wheel(name));
    }

    public List<Light> getLights() {
        return lights;
    }

    public void addLights(String name) {
        getLights().add(new Light(name));
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "wheels=" + wheels +
                ", lights=" + lights +
                '}';
    }
}

class Wheel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wheel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Light {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Light{" +
                "name='" + name + '\'' +
                '}';
    }
}