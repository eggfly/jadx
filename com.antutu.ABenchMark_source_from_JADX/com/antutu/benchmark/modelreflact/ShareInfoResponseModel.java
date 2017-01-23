package com.antutu.benchmark.modelreflact;

public class ShareInfoResponseModel {
    private DataEntity data;
    private String desc;
    private int isdata;

    public static class DataEntity {
        private ShareInfoModel sharedinfo;

        public ShareInfoModel getSharedinfo() {
            return this.sharedinfo;
        }

        public void setSharedinfo(ShareInfoModel shareInfoModel) {
            this.sharedinfo = shareInfoModel;
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
