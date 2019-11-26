package com.justcode.hxl.javadesign.工厂模式;

import org.junit.Test;

public class SimpleFacttory1 {
    /**
     * 把 new() 延迟到了 Factory 的 newInstance()
     * 但是，如此写法，一个factory 只能生产一种类型的 Product
     */

    @Test
    public void testSimpleFactory() {
        assert new Factory1().newInstance() instanceof ProductA;
    }

}

class Factory1 {
    public Product newInstance() {
        return new ProductA();
    }
}

interface Product {
}

class ProductA implements Product {

}

class ProductB implements Product {
}

