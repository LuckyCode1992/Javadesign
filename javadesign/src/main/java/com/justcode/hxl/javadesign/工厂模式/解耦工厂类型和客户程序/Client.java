package com.justcode.hxl.javadesign.工厂模式.解耦工厂类型和客户程序;

import org.junit.BeforeClass;
import org.junit.Test;


public class Client {

    @BeforeClass
    public static void setUpClass(){
        //登记抽象类型和工厂类型的对应关系
        Factories.config(X.class,FactoryX1.class);
        Factories.config(Y.class,FactoryY1.class);
    }

    @Test
    public void test() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        FactoryInterface<X> xFactoryInterface = Factories.newFactory(X.class);
        assert xFactoryInterface.newInstance() instanceof X;
        assert xFactoryInterface.newInstance() instanceof X1;


        FactoryInterface<Y> yFactoryInterface = Factories.newFactory(Y.class);
        assert yFactoryInterface.newInstance() instanceof Y;
        assert yFactoryInterface.newInstance() instanceof Y1;
    }
}
