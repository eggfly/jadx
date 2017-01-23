package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import com.igexin.sdk.PushConsts;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.eq */
public class eq {
    private final ii f10762a;
    private final String f10763b;

    public eq(ii iiVar) {
        this(iiVar, BuildConfig.FLAVOR);
    }

    public eq(ii iiVar, String str) {
        this.f10762a = iiVar;
        this.f10763b = str;
    }

    public void m12586a(int i, int i2, int i3, int i4) {
        try {
            this.f10762a.m12206b("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            C2972b.m11580b("Error occured while dispatching size change.", e);
        }
    }

    public void m12587a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f10762a.m12206b("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            C2972b.m11580b("Error occured while obtaining screen information.", e);
        }
    }

    public void m12588b(int i, int i2, int i3, int i4) {
        try {
            this.f10762a.m12206b("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            C2972b.m11580b("Error occured while dispatching default position.", e);
        }
    }

    public void m12589b(String str) {
        try {
            this.f10762a.m12206b("onError", new JSONObject().put(C4233j.f14376C, str).put(PushConsts.CMD_ACTION, this.f10763b));
        } catch (Throwable e) {
            C2972b.m11580b("Error occurred while dispatching error event.", e);
        }
    }

    public void m12590c(String str) {
        try {
            this.f10762a.m12206b("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (Throwable e) {
            C2972b.m11580b("Error occured while dispatching ready Event.", e);
        }
    }

    public void m12591d(String str) {
        try {
            this.f10762a.m12206b("onStateChanged", new JSONObject().put("state", str));
        } catch (Throwable e) {
            C2972b.m11580b("Error occured while dispatching state change.", e);
        }
    }
}
