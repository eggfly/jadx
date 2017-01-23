package com.antutu.benchmark.modelreflact;

import com.antutu.benchmark.model.C1522c;
import java.util.List;

public class CommentModel {
    private int avatar;
    private String content;
    private int id;
    private String ip;
    private int level;
    private String region;
    private List<CommentReplyModel> replies;
    private int reply_count;
    private int reply_to_id;
    private String reply_to_ip;
    private String reply_to_region;
    private int reply_to_uid;
    private int root_id;
    private int time;
    private int uid;
    private int zan;

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

    public List<CommentReplyModel> getReplies() {
        return this.replies;
    }

    public int getReply_count() {
        return this.reply_count;
    }

    public int getReply_to_id() {
        return this.reply_to_id;
    }

    public String getReply_to_ip() {
        return this.reply_to_ip;
    }

    public String getReply_to_region() {
        return this.reply_to_region;
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

    public void setReplies(List<CommentReplyModel> list) {
        this.replies = list;
    }

    public void setReply_count(int i) {
        this.reply_count = i;
    }

    public void setReply_to_id(int i) {
        this.reply_to_id = i;
    }

    public void setReply_to_ip(String str) {
        this.reply_to_ip = str;
    }

    public void setReply_to_region(String str) {
        this.reply_to_region = str;
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
        if (this.replies == null || this.replies.size() == 0) {
            return new C1522c(this.id, this.level, this.content, this.time, this.ip, this.region, this.uid, this.avatar, this.root_id, this.reply_to_id, this.reply_to_uid, this.reply_count, this.zan);
        }
        CommentReplyModel commentReplyModel = (CommentReplyModel) this.replies.get(0);
        C1522c c1522c = new C1522c(this.id, this.level, this.content, this.time, this.ip, this.region, this.uid, this.avatar, this.root_id, this.reply_to_id, this.reply_to_uid, this.reply_count, this.zan);
        c1522c.m6047a(commentReplyModel);
        return c1522c;
    }
}
