package com.antutu.benchmark.modelreflact;

import com.antutu.benchmark.model.C1522c;

public class CommentReplyModel {
    private int avatar;
    private String content;
    private int id;
    private String ip;
    private int level;
    private int model_id;
    private String region;
    private int reply_count;
    private int reply_to_avatar;
    private int reply_to_id;
    private String reply_to_ip;
    private String reply_to_region;
    private int reply_to_uid;
    private int root_id;
    private int time;
    private int uid;
    private int zan;

    public CommentReplyModel(int i, String str, int i2, String str2, String str3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, String str4, String str5) {
        this.id = i;
        this.content = str;
        this.time = i2;
        this.ip = str2;
        this.region = str3;
        this.uid = i3;
        this.avatar = i4;
        this.reply_to_id = i5;
        this.reply_to_uid = i6;
        this.reply_to_avatar = i7;
        this.reply_count = i8;
        this.level = i9;
        this.root_id = i10;
        this.zan = i11;
        this.model_id = i12;
        this.reply_to_ip = str4;
        this.reply_to_region = str5;
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

    public int getRoot_id() {
        return this.root_id;
    }

    public int getTime() {
        return this.time;
    }

    public int getUid() {
        return this.uid;
    }

    public int getZan() {
        return this.zan;
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

    public void setRoot_id(int i) {
        this.root_id = i;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setZan(int i) {
        this.zan = i;
    }

    public C1522c transCommentAdapterModel() {
        return new C1522c(this.id, this.level, this.content, this.time, this.ip, this.region, this.uid, this.avatar, this.root_id, this.reply_to_id, this.reply_to_uid, this.reply_count, this.zan);
    }
}
