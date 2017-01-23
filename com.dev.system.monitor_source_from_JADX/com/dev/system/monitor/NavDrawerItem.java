package com.dev.system.monitor;

public class NavDrawerItem {
    private String count;
    private int icon;
    private boolean isCounterVisible;
    private String title;

    public NavDrawerItem() {
        this.count = "0";
        this.isCounterVisible = false;
    }

    public NavDrawerItem(String title, int icon) {
        this.count = "0";
        this.isCounterVisible = false;
        this.title = title;
        this.icon = icon;
    }

    public NavDrawerItem(String title, int icon, boolean isCounterVisible, String count) {
        this.count = "0";
        this.isCounterVisible = false;
        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public String getTitle() {
        return this.title;
    }

    public int getIcon() {
        return this.icon;
    }

    public String getCount() {
        return this.count;
    }

    public boolean getCounterVisibility() {
        return this.isCounterVisible;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }
}
