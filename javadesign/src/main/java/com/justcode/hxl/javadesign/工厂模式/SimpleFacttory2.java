package com.justcode.hxl.javadesign.工厂模式;

import org.junit.Test;

public class SimpleFacttory2 {
    /**
     * 针对 SimpleFacttory1 进行优化
     *
     * 这里就大致解决了外部 new()的问题
     *
     * 但是，这里还是有一个问题，就是应用种需要的工厂类型非常多，但职责又一样的情况下。就需要再进行优化了。
     */
    @Test
    public void test() {
        assert StaticFactory.newInstance(Category.A) instanceof ProductA;
        assert StaticFactory.newInstance(Category.B) instanceof ProductB;
        assert StaticFactory.newInstance(Category.C) instanceof ProductB;
    }

}

enum Category {
    A, B, C
}

class StaticFactory {

    public static Product newInstance(Category category) {
        switch (category) {
            case A:
                return new ProductA();
            case B:
                return new ProductB();
            default:
                throw new UnsupportedOperationException("未知类型");
        }
    }

}

