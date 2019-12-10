package com.justcode.hxl.javadesign.适配器模式;

/**
 * 对象适配器
 */
public class ObjAdapter implements Target{
    /**
     *  - 基于对象组合的思路
     *  - Target可能是接口，抽象类甚至实体类，只要Adapter符合java的单继承
     *  - 无法覆盖Adaptee的方法
     *  - 不仅可以适配Adaptee，还可以根据里氏替换适配Adaptee的子类
     */
    private Adaptee adaptee;

    public ObjAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.someRequest("对象适配器");
    }
}
