package com.antutu.benchmark.modelreflact;

import java.io.Serializable;
import java.util.List;

public class ExposureResponseModel {
    private DataEntity data;
    private String desc;
    private int isdata;

    public static class DataEntity implements Serializable {
        private ExposureItemModel index;
        private List<ExposureListModel> modelist;

        public ExposureItemModel getIndex() {
            return this.index;
        }

        public List<ExposureListModel> getModelist() {
            return this.modelist;
        }

        public void setIndex(ExposureItemModel exposureItemModel) {
            this.index = exposureItemModel;
        }

        public void setModelist(List<ExposureListModel> list) {
            this.modelist = list;
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
