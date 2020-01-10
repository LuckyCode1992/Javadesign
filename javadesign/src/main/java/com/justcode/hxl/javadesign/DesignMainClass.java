package com.justcode.hxl.javadesign;

public class DesignMainClass {


    public static void main(String[] args) {
        System.out.println("hello java");
        System.out.println(Season.SPRING.getNote());
        System.out.println(Season.get(12).getNote());
    }
}
