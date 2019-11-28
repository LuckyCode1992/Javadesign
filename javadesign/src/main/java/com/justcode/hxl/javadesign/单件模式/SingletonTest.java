package com.justcode.hxl.javadesign.单件模式;


import org.junit.Test;

public class SingletonTest {
    /**
     * 单件模式（单例模式）Singleton
     */
    @Test
    public void test1() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton1 s3 = Singleton1.getInstance();
                System.out.println(s3.hashCode());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton1 s4 = Singleton1.getInstance();
                System.out.println(s4.hashCode());
            }
        }).start();
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }

    @Test
    public void test2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton2 s3 = Singleton2.getInstance();
                System.out.println(s3.hashCode());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton2 s4 = Singleton2.getInstance();
                System.out.println(s4.hashCode());
            }
        }).start();
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

/**
 * 常见的一种单件模式写法
 * <p>
 * 这种写法仅适用于非多线程情况
 */
class Singleton1 {
    private static Singleton1 singleton1;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        //LAZY方式创建唯一实例的过程
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}

/**
 * 这种方式，可以解决多线程场景中问题
 * <p>
 * 但是，每次调用 getInstance() 都要进行同步，性能负载较大
 */
class Singleton21 {
    private static   Singleton21 singleton2;

    private Singleton21() {
    }

    public static synchronized Singleton21 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton21();
        }
        return singleton2;
    }
}

/**
 * double check
 * 用这种方式，对上一个方式进行优化
 */
class Singleton2 {
    // volatile 关键字
    private static volatile Singleton2 singleton2;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }

        }
        return singleton2;
    }
}

/**
 *  public static final 方式
 *  在程序运行时就创建好，就不存在再创建的问题，自然机不存在线程干扰等问题
 */
class Singleton3{
    public static final Singleton3 instance = new Singleton3();
    private Singleton3() {
    }
}


