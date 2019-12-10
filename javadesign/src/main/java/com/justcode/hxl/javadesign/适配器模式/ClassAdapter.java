package com.justcode.hxl.javadesign.适配器模式;

/**
 * 类适配器
 */
public class ClassAdapter extends Adaptee implements Target {

    /**
     *  - 基于继承概念
     *  - 因为语言的单继承要求，所以适配器不能同时继承自其他类，Target只能是接口形式
     *  - 可以覆盖Adaptee的某些方法
     *  - 虽然不可以适配子类，但可以通过覆盖修改某些方法，部分情况下可以达到适配子类同样的效果
     */

    @Override
    public void request() {
        super.someRequest("类适配器");
    }
}
