package com.justcode.hxl.javadesign.创建者模式.vehicle;

import org.omg.CORBA.PUBLIC_MEMBER;

public abstract class VehicleBuilder {

    protected Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void initialize(){
        vehicle = new Vehicle();
    }

    public abstract void addWhells();
    public abstract void addLights();


}
