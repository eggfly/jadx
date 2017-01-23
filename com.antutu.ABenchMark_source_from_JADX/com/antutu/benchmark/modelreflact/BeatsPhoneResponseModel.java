package com.antutu.benchmark.modelreflact;

public class BeatsPhoneResponseModel {
    private BeatsPhoneModel data;
    private String desc;
    private int isdata;

    public BeatsPhoneModel getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(BeatsPhoneModel beatsPhoneModel) {
        this.data = beatsPhoneModel;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
