package com.antutu.benchmark.modelreflact;

import java.util.List;

public class CommentListResponseModel {
    private DataBean data;
    private String desc;
    private int isdata;

    public static class DataBean {
        private List<CmtlistBean> cmtlist;

        public static class CmtlistBean {
            private int avatar;
            private String content;
            private int id;
            private String ip;
            private int level;
            private String region;
            private List<RepliesBean> replies;
            private int reply_count;
            private int reply_to_id;
            private int reply_to_uid;
            private int root_id;
            private int time;
            private int uid;

            public static class RepliesBean {
                private int avatar;
                private String content;
                private int id;
                private String ip;
                private String region;
                private int reply_count;
                private int reply_to_avatar;
                private int reply_to_id;
                private int reply_to_uid;
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

                public String getRegion() {
                    return this.region;
                }

                public int getReply_count() {
                    return this.reply_count;
                }

                public int getReply_to_avatar() {
                    return this.reply_to_avatar;
                }

                public int getReply_to_id() {
                    return this.reply_to_id;
                }

                public int getReply_to_uid() {
                    return this.reply_to_uid;
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

                public void setRegion(String str) {
                    this.region = str;
                }

                public void setReply_count(int i) {
                    this.reply_count = i;
                }

                public void setReply_to_avatar(int i) {
                    this.reply_to_avatar = i;
                }

                public void setReply_to_id(int i) {
                    this.reply_to_id = i;
                }

                public void setReply_to_uid(int i) {
                    this.reply_to_uid = i;
                }

                public void setTime(int i) {
                    this.time = i;
                }

                public void setUid(int i) {
                    this.uid = i;
                }
            }

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

            public List<RepliesBean> getReplies() {
                return this.replies;
            }

            public int getReply_count() {
                return this.reply_count;
            }

            public int getReply_to_id() {
                return this.reply_to_id;
            }

            public int getReply_to_uid() {
                return this.reply_to_uid;
            }

            public int getRoot_id() {
                return this.root_id;
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

            public void setReplies(List<RepliesBean> list) {
                this.replies = list;
            }

            public void setReply_count(int i) {
                this.reply_count = i;
            }

            public void setReply_to_id(int i) {
                this.reply_to_id = i;
            }

            public void setReply_to_uid(int i) {
                this.reply_to_uid = i;
            }

            public void setRoot_id(int i) {
                this.root_id = i;
            }

            public void setTime(int i) {
                this.time = i;
            }

            public void setUid(int i) {
                this.uid = i;
            }
        }

        public List<CmtlistBean> getCmtlist() {
            return this.cmtlist;
        }

        public void setCmtlist(List<CmtlistBean> list) {
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
