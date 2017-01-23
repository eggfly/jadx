package com.antutu.benchmark.modelreflact;

public class CommentNotRedResponseModel {
    private DataBean data;
    private String desc;
    private int isdata;

    public static class DataBean {
        private long cmt_received;

        public long getCmt_received() {
            return this.cmt_received;
        }

        public void setCmt_received(long j) {
            this.cmt_received = j;
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
