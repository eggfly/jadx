package com.antutu.benchmark.modelreflact;

import java.util.List;

public class OtherCommentResponseModel {
    private List<OtherCommentModel> data;
    private String desc;
    private int isdata;

    public List<OtherCommentModel> getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(List<OtherCommentModel> list) {
        this.data = list;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
