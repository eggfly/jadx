package com.antutu.benchmark.modelreflact;

import java.io.Serializable;

public class ExposureItemModel implements Serializable {
    private String banner;
    private String subtitle;
    private String title;

    public String getBanner() {
        return this.banner;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBanner(String str) {
        this.banner = str;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
