package com.justcode.hxl.javadesign.创建者模式;

import com.justcode.hxl.javadesign.创建者模式.vehicle.BikeBuilder;
import com.justcode.hxl.javadesign.创建者模式.vehicle.CarBulder;
import com.justcode.hxl.javadesign.创建者模式.vehicle.Vehicle;
import com.justcode.hxl.javadesign.创建者模式.vehicle.VehicleDirector;

import org.junit.Before;
import org.junit.Test;


public class BuilderMain {
    /**
     * 创建者模式适用场景：产品局部加工过程变化较大，但组装过程相对固定
     * 比如 ：攒机
     * <p>
     * 主要角色：
     * Builder:描述创建一个产品各个组成的抽象接口
     * Concrete Builder: 实现Builder 要求的内容，提供一个获得最终产品的方法
     * Director:指导产品加工的步骤，但指导完全基于Builder的公共方法（抽象方法）
     */

    //下面就用一个 制造交通工具的例子说明：
    // 车，都有车轮和车灯
    VehicleDirector director;

    @Before
    public void setUp() {
        director = new VehicleDirector();
    }

    @Test
    public void test1() {
        //开始组装汽车
        director.setBuilder(new CarBulder());
        director.construct();
        Vehicle car = director.getVehicle();
        System.out.println(car.toString());

        //开始组装自行车
        director.setBuilder(new BikeBuilder());
        director.construct();
        Vehicle bike = director.getVehicle();
        System.out.println(bike.toString());

        /**
         *  采用这种创建者模式，有几个明显的优势：
         *  1.将复杂对象每个组成创建步骤暴露出来，借助Director（或者客户程序自己） 既可以选择执行次序，也可以选择执行哪些步骤。
         *  2.向客户程序屏蔽了对象创建过程的多变性，同样是经过”一系列“创建过程。
         *  3.构造过程的最终结果可以根据实际变化的情况，选择使用统一的接口，或者不同类的对象，给客户类型更大的灵活度。
         *
         *  劣势：
         *  创建者模式，暴露执行步骤，需要Director具有更多的领域只是，如果使用不慎容易造成更严重的耦合。因为Director 可能会成为瓶颈，
         *  如果它不稳定，那么整个创建者模式都不会稳定
         *
         */

    }
}
