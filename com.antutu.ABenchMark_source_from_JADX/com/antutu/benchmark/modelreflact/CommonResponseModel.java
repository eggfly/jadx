package com.antutu.benchmark.modelreflact;

public class CommonResponseModel {
    private Object data;
    private String desc;
    private int isdata;

    public Object getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
