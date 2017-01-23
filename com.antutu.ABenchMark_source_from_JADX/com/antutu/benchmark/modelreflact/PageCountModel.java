package com.antutu.benchmark.modelreflact;

public class PageCountModel {
    private int count;
    private int countpage;
    private int currpage;

    public int getCount() {
        return this.count;
    }

    public int getCountpage() {
        return this.countpage;
    }

    public int getCurrpage() {
        return this.currpage;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setCountpage(int i) {
        this.countpage = i;
    }

    public void setCurrpage(int i) {
        this.currpage = i;
    }
}
