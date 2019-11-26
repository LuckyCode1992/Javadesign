package com.justcode.hxl.javadesign.工厂模式.解耦工厂类型和客户程序;

/**
 *  负责构造某类型产品的工厂类型的抽象定义
 * @param <T>
 */
public interface FactoryInterface<T> {
    T newInstance();
}
