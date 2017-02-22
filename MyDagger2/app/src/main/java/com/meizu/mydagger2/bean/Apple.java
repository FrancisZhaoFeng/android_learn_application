package com.meizu.mydagger2.bean;

/**
 * Created by zhaoguofeng on 2016/5/17.
 */
public class Apple {
    String color;
    int size;

    public Apple(String color, int size) {
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
