package com.cmcm.p074a.p075a.p112a;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.a.r */
class C2125r extends C2122o {
    final /* synthetic */ C2116j f7458b;

    private C2125r(C2116j c2116j) {
        this.f7458b = c2116j;
        super(null);
    }

    public boolean m8024b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String string = new JSONObject(str).getJSONObject(Constants.KEY_DATA).getString("business_config");
                if (!TextUtils.isEmpty(string)) {
                    C2108b a = C2108b.m7936a();
                    a.m7940c().putLong("config_verion_timestamp", System.currentTimeMillis()).apply();
                    if (this.f7458b.m7984a(string, a.m7941c("config_version")) > 0) {
                        this.f7458b.m7994b(string);
                        return false;
                    }
                    this.f7458b.m7995b(null);
                    return false;
                }
            } catch (Exception e) {
                if (C2133z.f7482a) {
                    ad.m7931a("HttpDownloader", "failed to process the result of Version : " + e.getMessage(), new Object[0]);
                }
            }
        }
        if (m8018a()) {
            return true;
        }
        this.f7458b.m7995b(null);
        return false;
    }
}
