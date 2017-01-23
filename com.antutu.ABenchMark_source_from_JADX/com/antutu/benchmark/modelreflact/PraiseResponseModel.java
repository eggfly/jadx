package com.antutu.benchmark.modelreflact;

public class PraiseResponseModel {
    private PraiseModel data;
    private String desc;
    private int isdata;

    public PraiseModel getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(PraiseModel praiseModel) {
        this.data = praiseModel;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
