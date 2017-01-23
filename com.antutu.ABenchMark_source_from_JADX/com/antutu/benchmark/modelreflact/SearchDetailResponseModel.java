package com.antutu.benchmark.modelreflact;

import java.util.List;

public class SearchDetailResponseModel {
    private Pager pager;
    private int popsearch;
    private List<SearchDetailModel> thelist;

    public static class Pager {
        private int currPage;
        private int totalPage;

        public int getCurrPage() {
            return this.currPage;
        }

        public int getTotalPage() {
            return this.totalPage;
        }

        public void setCurrPage(int i) {
            this.currPage = i;
        }

        public void setTotalPage(int i) {
            this.totalPage = i;
        }
    }

    public Pager getPager() {
        return this.pager;
    }

    public int getPopsearch() {
        return this.popsearch;
    }

    public List<SearchDetailModel> getThelist() {
        return this.thelist;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public void setPopsearch(int i) {
        this.popsearch = i;
    }

    public void setThelist(List<SearchDetailModel> list) {
        this.thelist = list;
    }
}
