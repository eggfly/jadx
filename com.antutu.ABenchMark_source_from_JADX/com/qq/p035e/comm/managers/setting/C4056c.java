package com.qq.p035e.comm.managers.setting;

import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.setting.c */
public class C4056c {
    private JSONObject f13484a;

    public C4056c() {
        this.f13484a = new JSONObject();
    }

    public C4056c(String str) {
        this();
        GDTLogger.m16599d("Initialize GDTSDKSetting,Json=" + str);
        if (!StringUtil.isEmpty(str)) {
            try {
                this.f13484a = new JSONObject(str);
            } catch (Throwable e) {
                GDTLogger.report("Exception while building GDTSDKSetting from json", e);
            }
        }
    }

    final Object m16575a(String str) {
        return this.f13484a.opt(str);
    }

    final void m16576a(String str, Object obj) {
        try {
            this.f13484a.putOpt(str, obj);
        } catch (Throwable e) {
            GDTLogger.m16601e("Exception while update setting", e);
        }
    }

    public String toString() {
        return "GDTSDKSetting[" + this.f13484a.toString() + "]";
    }
}
