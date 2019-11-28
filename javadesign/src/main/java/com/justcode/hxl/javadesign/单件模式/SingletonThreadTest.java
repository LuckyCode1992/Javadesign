package com.justcode.hxl.javadesign.单件模式;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class SingletonThreadTest {
    /**
     * 线程级单件模式
     */
    //保存各个线程中的SingletonThread对象
    public static Set<Integer> hashCodeSet = new LinkedHashSet<>();

    private void action() {
        System.out.println("打印hashcode：" + SingletonThread.getInstance().hashCode());
        System.out.println("打印hashcode：" + SingletonThread.getInstance().hashCode());
        //记录当前的 hashcode
        hashCodeSet.add(SingletonThread.getInstance().hashCode());
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    action();
                }
            }).start();
        }
    }
    @Test
    public void test() throws InterruptedException {
      run();
      Thread.sleep(1000);
        for (Integer integer : hashCodeSet) {
            System.out.println(integer);
        }
    }
}

class SingletonThread {

    private static final ThreadLocal<SingletonThread> local = new ThreadLocal<SingletonThread>() {
        @Override
        protected SingletonThread initialValue() {
            return new SingletonThread();
        }
    };

    private SingletonThread() {
    }

    public static SingletonThread getInstance() {
        return local.get();
    }
}
