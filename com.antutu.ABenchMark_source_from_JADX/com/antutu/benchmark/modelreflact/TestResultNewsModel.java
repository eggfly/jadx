package com.antutu.benchmark.modelreflact;

import java.util.List;

public class TestResultNewsModel {
    private List<NewsInfoData> data;
    private String type;

    public List<NewsInfoData> getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public void setData(List<NewsInfoData> list) {
        this.data = list;
    }

    public void setType(String str) {
        this.type = str;
    }
}
