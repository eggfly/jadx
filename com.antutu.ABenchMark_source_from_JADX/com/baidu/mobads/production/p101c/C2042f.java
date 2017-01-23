package com.baidu.mobads.production.p101c;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.vo.C2031d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.c.f */
public class C2042f extends C2031d {
    private Boolean f7138a;

    public C2042f(Context context, Activity activity, SlotType slotType, Boolean bool) {
        super(context, activity, slotType);
        this.f7138a = bool;
        if (m7691c().booleanValue()) {
            this.b = "http://mobads.baidu.com/ads/index.htm";
        }
    }

    protected HashMap<String, String> m7689a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String m7690b() {
        return m7691c().booleanValue() ? super.m7616b() : "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }

    public Boolean m7691c() {
        return this.f7138a;
    }
}
