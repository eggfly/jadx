package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.b;
import org.json.JSONObject;

@eh
public class dm {
    private final String DW;
    private final fj j6;

    public dm(fj fjVar) {
        this(fjVar, "");
    }

    public dm(fj fjVar, String str) {
        this.j6 = fjVar;
        this.DW = str;
    }

    public void DW(int i, int i2, int i3, int i4) {
        try {
            this.j6.j6("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            b.DW("Error occured while dispatching default position.", e);
        }
    }

    public void DW(String str) {
        try {
            this.j6.j6("onError", new JSONObject().put("message", str).put("action", this.DW));
        } catch (Throwable e) {
            b.DW("Error occurred while dispatching error event.", e);
        }
    }

    public void FH(String str) {
        try {
            this.j6.j6("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (Throwable e) {
            b.DW("Error occured while dispatching ready Event.", e);
        }
    }

    public void Hw(String str) {
        try {
            this.j6.j6("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            b.DW("Error occured while dispatching state change.", e);
        }
    }

    public void j6(int i, int i2, int i3, int i4) {
        try {
            this.j6.j6("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            b.DW("Error occured while dispatching size change.", e);
        }
    }

    public void j6(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.j6.j6("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            b.DW("Error occured while obtaining screen information.", e);
        }
    }
}
