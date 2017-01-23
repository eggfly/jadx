package com.antutu.benchmark.modelreflact;

import java.io.Serializable;

public class ExposureListModel implements Serializable {
    private String clicks;
    private String date;
    private String model;
    private String modelpic;
    private String score;
    private String url;

    public ExposureListModel(String str, String str2, String str3, String str4, String str5, String str6) {
        this.model = str;
        this.score = str2;
        this.date = str3;
        this.clicks = str4;
        this.modelpic = str5;
        this.url = str6;
    }

    public String getClicks() {
        return this.clicks;
    }

    public String getDate() {
        return this.date;
    }

    public String getModel() {
        return this.model;
    }

    public String getModelpic() {
        return this.modelpic;
    }

    public String getScore() {
        return this.score;
    }

    public String getUrl() {
        return this.url;
    }

    public void setClicks(String str) {
        this.clicks = str;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setModelpic(String str) {
        this.modelpic = str;
    }

    public void setScore(String str) {
        this.score = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
