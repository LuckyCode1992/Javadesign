package com.justcode.hxl.javadesign.适配器模式.adapter;

import com.justcode.hxl.javadesign.适配器模式.Adaptee;

public class Adapter1 extends Adaptee {
    @Override
    public void someRequest(String request) {
        System.out.println("打印子类的request：adapter1");
    }
}
