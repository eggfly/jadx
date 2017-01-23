package com.igexin.push.core.bean;

import java.util.List;
import java.util.Map;

public class PushTaskBean {
    private String f12790a;
    private String f12791b;
    private String f12792c;
    private String f12793d;
    private String f12794e;
    private List f12795f;
    private byte[] f12796g;
    private String f12797h;
    private String f12798i;
    private int f12799j;
    private int f12800k;
    private boolean f12801l;
    private boolean f12802m;
    private boolean f12803n;
    private Map f12804o;
    private int f12805p;
    private int f12806q;

    public PushTaskBean() {
        this.f12801l = false;
        this.f12802m = false;
        this.f12803n = false;
    }

    public String getAction() {
        return this.f12790a;
    }

    public List getActionChains() {
        return this.f12795f;
    }

    public String getAppKey() {
        return this.f12798i;
    }

    public String getAppid() {
        return this.f12791b;
    }

    public BaseAction getBaseAction(String str) {
        for (BaseAction baseAction : getActionChains()) {
            if (baseAction.getActionId().equals(str)) {
                return baseAction;
            }
        }
        return null;
    }

    public Map getConditionMap() {
        return this.f12804o;
    }

    public int getCurrentActionid() {
        return this.f12799j;
    }

    public int getExecuteTimes() {
        return this.f12806q;
    }

    public String getId() {
        return this.f12792c;
    }

    public String getMessageId() {
        return this.f12793d;
    }

    public String getMsgAddress() {
        return this.f12797h;
    }

    public byte[] getMsgExtra() {
        return this.f12796g;
    }

    public int getPerActionid() {
        return this.f12800k;
    }

    public int getStatus() {
        return this.f12805p;
    }

    public String getTaskId() {
        return this.f12794e;
    }

    public boolean isCDNType() {
        return this.f12803n;
    }

    public boolean isHttpImg() {
        return this.f12801l;
    }

    public boolean isStop() {
        return this.f12802m;
    }

    public void setAction(String str) {
        this.f12790a = str;
    }

    public void setActionChains(List list) {
        this.f12795f = list;
    }

    public void setAppKey(String str) {
        this.f12798i = str;
    }

    public void setAppid(String str) {
        this.f12791b = str;
    }

    public void setCDNType(boolean z) {
        this.f12803n = z;
    }

    public void setConditionMap(Map map) {
        this.f12804o = map;
    }

    public void setCurrentActionid(int i) {
        this.f12799j = i;
    }

    public void setExecuteTimes(int i) {
        this.f12806q = i;
    }

    public void setHttpImg(boolean z) {
        this.f12801l = z;
    }

    public void setId(String str) {
        this.f12792c = str;
    }

    public void setMessageId(String str) {
        this.f12793d = str;
    }

    public void setMsgAddress(String str) {
        this.f12797h = str;
    }

    public void setMsgExtra(byte[] bArr) {
        this.f12796g = bArr;
    }

    public void setPerActionid(int i) {
        this.f12800k = i;
    }

    public void setStatus(int i) {
        this.f12805p = i;
    }

    public void setStop(boolean z) {
        this.f12802m = z;
    }

    public void setTaskId(String str) {
        this.f12794e = str;
    }
}
