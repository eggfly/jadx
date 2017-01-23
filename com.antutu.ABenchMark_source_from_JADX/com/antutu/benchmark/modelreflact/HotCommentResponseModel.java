package com.antutu.benchmark.modelreflact;

import java.util.List;

public class HotCommentResponseModel {
    private DataBean data;
    private String desc;
    private int isdata;

    public static class DataBean {
        private List<CommentListModel> cmtlist;

        public List<CommentListModel> getCmtlist() {
            return this.cmtlist;
        }

        public void setCmtlist(List<CommentListModel> list) {
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
