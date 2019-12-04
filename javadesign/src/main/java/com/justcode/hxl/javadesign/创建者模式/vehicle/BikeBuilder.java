package com.justcode.hxl.javadesign.创建者模式.vehicle;

public class BikeBuilder extends VehicleBuilder {
    @Override
    public void addWhells() {
        vehicle.addWheels("前轮");
        vehicle.addWheels("后轮");
    }

    @Override
    public void addLights() {
        vehicle.addLights("前灯");
    }
}
