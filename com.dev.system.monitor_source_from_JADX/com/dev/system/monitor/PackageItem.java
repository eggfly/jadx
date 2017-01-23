package com.dev.system.monitor;

import android.graphics.drawable.Drawable;

public class PackageItem {
    private Drawable icon;
    private int memoryInKByte;
    private String name;
    private String packageName;

    String getPackageName() {
        return this.packageName;
    }

    void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    Drawable getIcon() {
        return this.icon;
    }

    void setIcon(Drawable icon) {
        this.icon = icon;
    }

    int getMemoryInKByte() {
        return this.memoryInKByte;
    }

    void setMemoryInKByte(int memoryInKByte) {
        this.memoryInKByte = memoryInKByte;
    }
}
