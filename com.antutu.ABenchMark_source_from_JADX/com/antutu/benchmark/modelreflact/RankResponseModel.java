package com.antutu.benchmark.modelreflact;

import java.util.List;

public class RankResponseModel {
    private List<RankModel> data;
    private String desc;
    private int isdata;

    public List<RankModel> getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(List<RankModel> list) {
        this.data = list;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
