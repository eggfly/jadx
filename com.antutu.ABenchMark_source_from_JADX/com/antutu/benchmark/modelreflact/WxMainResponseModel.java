package com.antutu.benchmark.modelreflact;

public class WxMainResponseModel {
    private WxMainModel data;
    private int isdata;

    public WxMainModel getData() {
        return this.data;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(WxMainModel wxMainModel) {
        this.data = wxMainModel;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
