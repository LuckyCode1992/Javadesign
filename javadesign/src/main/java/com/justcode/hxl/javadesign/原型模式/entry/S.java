package com.justcode.hxl.javadesign.原型模式.entry;

import com.justcode.hxl.javadesign.原型模式.SerializableUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S implements Serializable {
    int x, y;
    // transient 意味着指定不序列化
    public transient int z = 123;
    List<Integer> list = new ArrayList<>();

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setList(Integer... list) {
        this.list = Arrays.asList(list);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Integer> getList() {
        return list;
    }


    public Object deepClone() throws IOException, ClassNotFoundException {
        //序列化
        Long cur = System.currentTimeMillis();
        byte[] bytes = SerializableUtil.toByte(this);
//        System.out.println(System.currentTimeMillis()-cur);
        //反序列化
        return SerializableUtil.toObj(bytes);
    }
}


