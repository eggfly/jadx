package com.antutu.benchmark.modelreflact;

public class TestResultModel {
    public static final String TYPE_AD = "ad";
    public static final String TYPE_HUISHOUBAO = "huishoubao";
    public static final String TYPE_NEWSLIST = "newslist";
    private Object data;
    private String type;

    public Object getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setType(String str) {
        this.type = str;
    }
}
