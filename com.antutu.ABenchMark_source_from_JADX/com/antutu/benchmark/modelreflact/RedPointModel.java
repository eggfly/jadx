package com.antutu.benchmark.modelreflact;

public class RedPointModel {
    public static final int TAG_UNREAD_IN = 1;
    private int lastid;
    private int lasttime;
    private int unread;

    public int getLastid() {
        return this.lastid;
    }

    public int getLasttime() {
        return this.lasttime;
    }

    public int getUnread() {
        return this.unread;
    }

    public void setLastid(int i) {
        this.lastid = i;
    }

    public void setLasttime(int i) {
        this.lasttime = i;
    }

    public void setUnread(int i) {
        this.unread = i;
    }
}
