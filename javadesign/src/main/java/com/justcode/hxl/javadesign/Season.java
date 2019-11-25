package com.justcode.hxl.javadesign;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Season {


    SPRING(1, 3) {
        @Override
        public String getNote() {
            return "春天";
        }
    },
    SUMMER(4, 6) {
        @Override
        public String getNote() {
            return "夏天";
        }
    },
    AUTUMN(7, 9) {
        @Override
        public String getNote() {
            return "秋天";
        }
    },
    WINTER(10, 12) {
        @Override
        public String getNote() {
            return "冬天";
        }
    };

    private final int startMonth;
    private final int endMonth;

    Season(int startMonth, int endMonth) {
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }


    public int getStartMonth() {
        return startMonth;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public abstract String getNote();

    public static Season get(int month) {
        if (month > 12 || month < 1) {
            throw new IndexOutOfBoundsException("一年只有12个月");
        }
        int index = (month-1)/3*3;
        return monthLookup.get(index);
    }

    private static final Map<Integer, Season> monthLookup = new HashMap<>();

    static {
        for (Season s : EnumSet.allOf(Season.class)) {
            monthLookup.put(s.getStartMonth()-1, s);
        }
        System.out.println(monthLookup);
    }
}
