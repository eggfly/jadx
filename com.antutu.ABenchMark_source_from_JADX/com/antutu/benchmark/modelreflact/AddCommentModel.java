package com.antutu.benchmark.modelreflact;

public class AddCommentModel {
    private DataEntity data;
    private String desc;
    private int isdata;

    public static class DataEntity {
        private CmtinfoEntity cmtinfo;

        public static class CmtinfoEntity {
            private int avatar;
            private String content;
            private int id;
            private String ip;
            private int level;
            private String region;
            private int time;
            private int uid;

            public int getAvatar() {
                return this.avatar;
            }

            public String getContent() {
                return this.content;
            }

            public int getId() {
                return this.id;
            }

            public String getIp() {
                return this.ip;
            }

            public int getLevel() {
                return this.level;
            }

            public String getRegion() {
                return this.region;
            }

            public int getTime() {
                return this.time;
            }

            public int getUid() {
                return this.uid;
            }

            public void setAvatar(int i) {
                this.avatar = i;
            }

            public void setContent(String str) {
                this.content = str;
            }

            public void setId(int i) {
                this.id = i;
            }

            public void setIp(String str) {
                this.ip = str;
            }

            public void setLevel(int i) {
                this.level = i;
            }

            public void setRegion(String str) {
                this.region = str;
            }

            public void setTime(int i) {
                this.time = i;
            }

            public void setUid(int i) {
                this.uid = i;
            }
        }

        public CmtinfoEntity getCmtinfo() {
            return this.cmtinfo;
        }

        public void setCmtinfo(CmtinfoEntity cmtinfoEntity) {
            this.cmtinfo = cmtinfoEntity;
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
