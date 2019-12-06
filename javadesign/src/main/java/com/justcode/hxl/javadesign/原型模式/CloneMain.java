package com.justcode.hxl.javadesign.原型模式;

import com.justcode.hxl.javadesign.原型模式.entry.Employee;
import com.justcode.hxl.javadesign.原型模式.entry.PartialEntry;
import com.justcode.hxl.javadesign.原型模式.entry.S;
import com.justcode.hxl.javadesign.原型模式.entry.U;

import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

public class CloneMain {
    /**
     * 原型模式（克隆模式）
     */
    @Test
    public void testClone() throws CloneNotSupportedException {
        /**
         *  简单例子
         */
        Employee employee = new Employee(UUID.randomUUID().toString());
        Employee eclone = (Employee) employee.clone();

        System.out.println(employee.getId().equals(eclone.getId()));
        System.out.println(employee.hashCode() == eclone.hashCode());
    }

    @Test
    public void testClone1() throws CloneNotSupportedException {
        PartialEntry entry = new PartialEntry();
        System.out.println(entry.hashCode());
        System.out.println(entry.getLostPart().hashCode());
        System.out.println(entry.getRemains());
        System.out.println(entry.getLostPart().getId());

        PartialEntry clone = (PartialEntry) entry.clone();
        System.out.println(clone.hashCode());
        System.out.println(clone.getLostPart().hashCode());
        System.out.println(clone.getRemains());
        System.out.println(clone.getLostPart().getId());
        /**
         * 这是 浅层赋值，所以，除了 entry 和 clone对象不是一样，其他都是一样
         * 其中 LostPart 的hashcode相同，说明，clone的和原型的LostPart是指向同一个内存地址，即相同
         */
    }

    @Test
    public void testClone2() throws IOException {
        U u = new U();
        //NotSerializableException 会抛出这个异常
        SerializableUtil.toByte(u);
    }

    @Test
    public void testClone3() throws IOException, ClassNotFoundException {
        S s = new S();
        //NotSerializableException 会抛出这个异常
        Integer[] list = {10, 20, 30};
        System.out.println(s instanceof Serializable);
        s.setXY(20, 10);
        s.setList(list);
        s.z = 999;
        System.out.println(list == s.getList().toArray());

        //序列化
//        byte[] bytes = SerializableUtil.toByte(s);
        //反序列化
//        S clone = (S) SerializableUtil.toObj(bytes);
        //上面两个可以再简化为一句话
        System.out.println("开始计时");
        Long l = System.currentTimeMillis();
        S clone = (S) s.deepClone();
        System.out.println(System.currentTimeMillis()-l);
        System.out.println("结束计时");
        // 对比
        System.out.println(s.getX() == clone.getX());
        System.out.println(s.getY() == clone.getY());
        System.out.println(list == clone.getList().toArray());
        System.out.println(s.hashCode() == clone.hashCode());
        System.out.println(s.z);
        System.out.println(clone.z);
        /**
         * true
         * false
         * true
         * true
         * false
         * false
         * 这个结果，就是深层复制，所有引用类型的都被复制了，不再指向同一个内存地址了
         *
         * 使用 transient 修饰的成员，不会被序列化
         * 上面这种是使用序列化和反序列化的操作，实现深克隆
         * 但是 这种效率比较低，因为是IO操作
         * 可以使用 json和对象相互转换的方式实现 深克隆
         */
    }
}
