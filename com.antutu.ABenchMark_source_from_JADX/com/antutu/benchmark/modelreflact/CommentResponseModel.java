package com.antutu.benchmark.modelreflact;

import java.util.List;

public class CommentResponseModel {
    private DataBean data;
    private String desc;
    private int isdata;

    public static class DataBean {
        private List<CommentModel> cmtlist;

        public List<CommentModel> getCmtlist() {
            return this.cmtlist;
        }

        public void setCmtlist(List<CommentModel> list) {
            this.cmtlist = list;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}