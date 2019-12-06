package com.justcode.hxl.javadesign.原型模式.entry;

import java.util.UUID;

public class PartialEntry implements Cloneable {
    private LostPart lostPart = new LostPart(UUID.randomUUID().toString());
    private String remains = UUID.randomUUID().toString();

    public LostPart getLostPart() {
        return lostPart;
    }

    public String getRemains() {
        return remains;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
