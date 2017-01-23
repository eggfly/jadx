package com.antutu.benchmark.modelreflact;

public class DeviceInfoModel {
    private DataEntity data;
    private String desc;
    private int isdata;

    public static class DataEntity {
        private String brand;
        private String comment;
        private String goodpercent;
        private String level;
        private String model;

        public String getBrand() {
            return this.brand;
        }

        public String getComment() {
            return this.comment;
        }

        public String getGoodpercent() {
            return this.goodpercent;
        }

        public String getLevel() {
            return this.level;
        }

        public String getModel() {
            return this.model;
        }

        public void setBrand(String str) {
            this.brand = str;
        }

        public void setComment(String str) {
            this.comment = str;
        }

        public void setGoodpercent(String str) {
            this.goodpercent = str;
        }

        public void setLevel(String str) {
            this.level = str;
        }

        public void setModel(String str) {
            this.model = str;
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
