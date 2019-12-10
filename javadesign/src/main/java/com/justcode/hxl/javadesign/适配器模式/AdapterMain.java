package com.justcode.hxl.javadesign.适配器模式;

import com.justcode.hxl.javadesign.适配器模式.adapter.Adapter1;
import com.justcode.hxl.javadesign.适配器模式.adapter.Adapter2;

import org.junit.Test;

public class AdapterMain {
    /**
     * 适配器：接口转换，使原来不兼容的接口可以协作
     *  适配器适用环境：
     *  - 需要复用一些已经存在的类，但这些类提供的接口不能满足新需要，尤其当这些类是我们花很大成本完成的，他们经过项目考研表现确实一直很稳定。
     *  - 封装了一些公共的类，他们经常会被重用，但不确定目标环境需要何种接口
     *  - 新的接口可能需要的是前几个类所能提供的功能，而且新接口与他们不兼容
     */

    /**
     *  适配器的基本角色
     *
     *  Target:客户程序所期待的接口，也就是我们前面说的新接口
     *  Adaptee:需要被适配的目标类型，也就是前面说的接口较为老的类型
     *  ClassAdapter:适配器
     */

    @Test
    public void test1(){
        Target target = new ObjAdapter(new Adaptee());
        target.request();

        Target target1 = new ClassAdapter();
        target1.request();
    }
    @Test
    public void test2(){
        Target target1 = new ObjAdapter(new Adapter1());
        target1.request();

        Target target2 = new ObjAdapter(new Adapter2());
        target2.request();
    }
}
