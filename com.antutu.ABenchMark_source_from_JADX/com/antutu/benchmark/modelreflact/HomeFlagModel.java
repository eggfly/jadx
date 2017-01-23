package com.antutu.benchmark.modelreflact;

public class HomeFlagModel {
    public static final String IS_SHOW_3D_AD = "IS_SHOW_3D_AD";
    public static final String IS_SHOW_3D_TEST = "IS_SHOW_3D_TEST";
    public static final String IS_SHOW_BAOGUANG = "IS_SHOW_BAOGUANG";
    public static final String IS_SHOW_HOTNEWS = "IS_SHOW_HOTNEWS";
    public static final String IS_SHOW_JIASU = "IS_SHOW_JIASU";
    public static final String IS_SHOW_LONG_TEST = "IS_SHOW_LONG_TEST";
    public static final String IS_SHOW_MORE_TEST = "IS_SHOW_MORE_TEST";
    public static final String IS_SHOW_PINGLUN = "IS_SHOW_PINGLUN";
    public static final String IS_SHOW_YANJI = "IS_SHOW_YANJI";
    private Integer isshow;
    private String label;

    public HomeFlagModel(String str, Integer num) {
        this.label = str;
        this.isshow = num;
    }

    public Integer getIsshow() {
        return this.isshow;
    }

    public String getLabel() {
        return this.label;
    }

    public void setIsshow(Integer num) {
        this.isshow = num;
    }

    public void setLabel(String str) {
        this.label = str;
    }
}
