package com.zxwl.myzxwl.domeshop;

/**
 * Created by Administrator on 2018/3/7.
 */

public class persenter {
    private String name;
    private boolean roid;

    public persenter(String name, boolean roid) {
        this.name = name;
        this.roid = roid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRoid() {
        return roid;
    }

    public void setRoid(boolean roid) {
        this.roid = roid;
    }
}
