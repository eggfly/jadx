package com.igexin.push.core.bean;

public class BaseAction {
    private String f12786a;
    private String f12787b;
    private String f12788c;
    private boolean f12789d;

    public BaseAction() {
        this.f12789d = true;
    }

    public String getActionId() {
        return this.f12786a;
    }

    public String getDoActionId() {
        return this.f12788c;
    }

    public String getType() {
        return this.f12787b;
    }

    public boolean isSupportExt() {
        return this.f12789d;
    }

    public void setActionId(String str) {
        this.f12786a = str;
    }

    public void setDoActionId(String str) {
        this.f12788c = str;
    }

    public void setSupportExt(boolean z) {
        this.f12789d = z;
    }

    public void setType(String str) {
        this.f12787b = str;
    }
}
