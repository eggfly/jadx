package com.antutu.benchmark.modelreflact;

public class RedPointResponseModel {
    private RedPointModel data;
    private String desc;
    private int isdata;

    public RedPointModel getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(RedPointModel redPointModel) {
        this.data = redPointModel;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
