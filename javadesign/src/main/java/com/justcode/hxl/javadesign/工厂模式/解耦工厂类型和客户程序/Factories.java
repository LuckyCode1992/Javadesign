package com.justcode.hxl.javadesign.工厂模式.解耦工厂类型和客户程序;


import java.util.HashMap;
import java.util.Map;

/**
 * 创建工厂的工厂
 */
public class Factories {
    /**
     * 等级待构造产品类型及相应工厂类型
     */
    private static final Map<Class<?>, Class<?>> retistryFactory = new HashMap<>();

    /**
     * 封闭 构造函数
     */
    private Factories() {
    }

    /**
     * 配置待构造的产品类型和相应的工厂类型
     *
     * @param productType
     * @param factoryType
     */
    public static void config(
            Class<?> productType, Class<?> factoryType) {
        retistryFactory.put(productType, factoryType);
    }

    @SuppressWarnings("unchecked")
    public static <T> FactoryInterface<T> newFactory(Class<?> productType) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        if (retistryFactory.containsKey(productType)) {
            return (FactoryInterface<T>) retistryFactory.get(productType).newInstance();
        } else {
            throw new ClassNotFoundException("没有注册这类的factory");
        }
    }
}

class FactoryX1 implements FactoryInterface<X> {

    @Override
    public X newInstance() {
        return new X1();
    }
}

class FactoryY1 implements FactoryInterface<Y> {

    @Override
    public Y newInstance() {
        return new Y1();
    }
}
class FactoryX2 implements FactoryInterface<X>{

    @Override
    public X newInstance() {
        return new X2();
    }
}
