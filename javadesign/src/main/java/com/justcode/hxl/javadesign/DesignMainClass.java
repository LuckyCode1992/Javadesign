package com.justcode.hxl.javadesign;

public class DesignMainClass {

    /**
     * 设计原则：
     * -面向类：
     * --SRP ：单一职责原则
     * --OCP：开放封闭原则
     * --LSP：里氏替换原则
     * --DIP：依赖倒置原则
     * --ISP：接口隔离原则
     * -面向包：
     * --REP：重用发布等价原则
     * --CCP：共同封闭原则
     * --CRP：共同重用原则
     * --ADP：无环依赖原则
     * --SDP：稳定依赖原则
     * --SAP：稳定抽象原则
     */
    public static void main(String[] args) {
        System.out.println("hello java");
        System.out.println(Season.SPRING.getNote());
        System.out.println(Season.get(12).getNote());
    }
}
