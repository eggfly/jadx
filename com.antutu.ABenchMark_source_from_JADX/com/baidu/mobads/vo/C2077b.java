package com.baidu.mobads.vo;

import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.vo.b */
public class C2077b implements IXAdProdInfo {
    private C2031d f7296a;
    private SlotType f7297b;
    private boolean f7298c;

    public C2077b(C2031d c2031d, SlotType slotType) {
        this.f7298c = false;
        this.f7296a = c2031d;
        this.f7297b = slotType;
    }

    public void m7762a(boolean z) {
        this.f7298c = z;
    }

    public String getAdPlacementId() {
        return this.f7296a.getApid();
    }

    public String getAdRequestURL() {
        return this.f7296a.m7616b();
    }

    public int getApt() {
        return this.f7296a.getApt();
    }

    public JSONObject getAttribute() {
        return new JSONObject();
    }

    public int getInstanceCount() {
        return 0;
    }

    public String getProdType() {
        return this.f7296a.getProd();
    }

    public int getRequestAdHeight() {
        return this.f7296a.getH();
    }

    public int getRequestAdWidth() {
        return this.f7296a.getW();
    }

    public SlotType getType() {
        return this.f7297b;
    }

    public boolean isAutoPlay() {
        return this.f7298c;
    }

    public boolean isMsspTagAvailable() {
        return false;
    }
}
