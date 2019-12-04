package com.justcode.hxl.javadesign.创建者模式.vehicle;

public class CarBulder extends VehicleBuilder {
    @Override
    public void addWhells() {
        vehicle.addWheels("左前轮");
        vehicle.addWheels("左后轮");
        vehicle.addWheels("右前轮");
        vehicle.addWheels("右后轮");
    }

    @Override
    public void addLights() {
        vehicle.addLights("左前灯");
        vehicle.addLights("左后灯");
        vehicle.addLights("右前灯");
        vehicle.addLights("右后灯");
    }
}
