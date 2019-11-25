package com.justcode.hxl.javadesign;

import org.junit.Test;

public class SeasonFixture {
    @Test
    public void SwitchSeason() {
        Season winter = Season.WINTER;
        assert winter == Season.get(10);
        assert winter.ordinal() == 3;
        assert Season.AUTUMN == Season.get(3);
    }
}
