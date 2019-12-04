package com.justcode.hxl.javadesign.创建者模式.vehicle;

public class VehicleDirector {
    private VehicleBuilder builder;
    public void setBuilder(VehicleBuilder builder){
        this.builder = builder;
    }
    /**
     *  指导builder 如何加工的抽象工序描述
     */
    public void construct(){
        builder.initialize();
        builder.addWhells();
        builder.addLights();
    }
    public Vehicle getVehicle(){
        return builder.getVehicle();
    }
}
