package com.baidu.mobads.production.p100d;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.vo.C2031d;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.d.d */
public class C2046d extends C2031d {
    private Boolean f7150a;

    public C2046d(Context context, Activity activity, SlotType slotType, Boolean bool) {
        super(context, activity, slotType);
        this.f7150a = bool;
        if (m7713c().booleanValue()) {
            this.b = "http://mobads.baidu.com/ads/index.htm";
        }
    }

    protected HashMap<String, String> m7711a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String m7712b() {
        return m7713c().booleanValue() ? super.m7616b() : "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }

    public Boolean m7713c() {
        return this.f7150a;
    }
}
