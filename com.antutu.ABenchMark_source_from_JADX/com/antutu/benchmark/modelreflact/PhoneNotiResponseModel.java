package com.antutu.benchmark.modelreflact;

public class PhoneNotiResponseModel {
    private PhoneNotiModel data;
    private String desc;
    private int isdata;

    public PhoneNotiModel getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(PhoneNotiModel phoneNotiModel) {
        this.data = phoneNotiModel;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
