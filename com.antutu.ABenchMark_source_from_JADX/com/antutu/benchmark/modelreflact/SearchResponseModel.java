package com.antutu.benchmark.modelreflact;

public class SearchResponseModel {
    private SearchDetailResponseModel data;
    private String desc;
    private int isdata;

    public SearchDetailResponseModel getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(SearchDetailResponseModel searchDetailResponseModel) {
        this.data = searchDetailResponseModel;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
