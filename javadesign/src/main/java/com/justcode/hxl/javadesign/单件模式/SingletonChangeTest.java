package com.justcode.hxl.javadesign.单件模式;

import org.junit.Test;

import java.io.Serializable;

public class SingletonChangeTest {
    /**
     * singleton 变质
     */
    @Test
    public void test1() throws CloneNotSupportedException {
        SingletonChane1 s1 = SingletonChane1.getInstance();
        SingletonChane1 s2 = (SingletonChane1) s1.clone();
        SingletonChane1 s3 = (SingletonChane1) SingletonChane1.getInstance().clone();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

    }

}

/**
 * 父类实现Cloneable 接口会导致
 * 因为默认的clone（）是把属性值复制一份，创建一个新的对象
 * 所以，在使用时，如果用了clone 就不再是原来那个单例了
 */
class Base implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class SingletonChane1 extends Base{
    private static SingletonChane1 singletonChane1;

    private SingletonChane1() {
    }
    public static synchronized SingletonChane1 getInstance(){
        if (singletonChane1==null){
            singletonChane1 = new SingletonChane1();
        }
        return singletonChane1;
    }
}

/**
 * 序列化和反序列化，也会破坏单例
 */

class Ser implements Serializable{

}
class SingletonChange2 extends Ser{
    private static SingletonChange2 singletonChane2;

    private SingletonChange2() {
    }
    public static synchronized SingletonChange2 getInstance(){
        if (singletonChane2==null){
            singletonChane2 = new SingletonChange2();
        }
        return singletonChane2;
    }
}