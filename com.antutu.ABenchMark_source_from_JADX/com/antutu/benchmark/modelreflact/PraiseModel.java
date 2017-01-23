package com.antutu.benchmark.modelreflact;

public class PraiseModel {
    private String brand;
    private String comment;
    private String comment_count;
    private String goodpercent;
    private String level;
    private Integer mid;
    private String model;
    private String star1;
    private String star2;
    private String star3;
    private String star4;
    private String star5;

    public String getBrand() {
        return this.brand;
    }

    public String getComment() {
        return this.comment;
    }

    public String getComment_count() {
        return this.comment_count;
    }

    public String getGoodpercent() {
        return this.goodpercent;
    }

    public String getLevel() {
        return this.level;
    }

    public Integer getMid() {
        return this.mid;
    }

    public String getModel() {
        return this.model;
    }

    public String getStar1() {
        return this.star1;
    }

    public String getStar2() {
        return this.star2;
    }

    public String getStar3() {
        return this.star3;
    }

    public String getStar4() {
        return this.star4;
    }

    public String getStar5() {
        return this.star5;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setComment_count(String str) {
        this.comment_count = str;
    }

    public void setGoodpercent(String str) {
        this.goodpercent = str;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public void setMid(Integer num) {
        this.mid = num;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setStar1(String str) {
        this.star1 = str;
    }

    public void setStar2(String str) {
        this.star2 = str;
    }

    public void setStar3(String str) {
        this.star3 = str;
    }

    public void setStar4(String str) {
        this.star4 = str;
    }

    public void setStar5(String str) {
        this.star5 = str;
    }

    public String toString() {
        return "PraiseModel{brand='" + this.brand + '\'' + ", model='" + this.model + '\'' + ", level='" + this.level + '\'' + ", comment='" + this.comment + '\'' + ", goodpercent='" + this.goodpercent + '\'' + ", star1='" + this.star1 + '\'' + ", star2='" + this.star2 + '\'' + ", star3='" + this.star3 + '\'' + ", star4='" + this.star4 + '\'' + ", star5='" + this.star5 + '\'' + ", comment_count='" + this.comment_count + '\'' + ", mid=" + this.mid + '}';
    }
}
