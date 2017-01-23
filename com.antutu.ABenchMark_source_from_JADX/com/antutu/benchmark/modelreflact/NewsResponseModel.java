package com.antutu.benchmark.modelreflact;

import java.util.List;

public class NewsResponseModel {
    private DataEntity data;
    private String desc;
    private int isdata;

    public static class DataEntity {
        private List<NewsInfoData> infolist;
        private PageModel page;

        public List<NewsInfoData> getInfolist() {
            return this.infolist;
        }

        public PageModel getPage() {
            return this.page;
        }

        public void setInfolist(List<NewsInfoData> list) {
            this.infolist = list;
        }

        public void setPage(PageModel pageModel) {
            this.page = pageModel;
        }
    }

    public DataEntity getData() {
        return this.data;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsdata() {
        return this.isdata;
    }

    public void setData(DataEntity dataEntity) {
        this.data = dataEntity;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIsdata(int i) {
        this.isdata = i;
    }
}
