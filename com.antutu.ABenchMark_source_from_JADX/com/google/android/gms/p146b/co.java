package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.internal.C3473d;
import com.igexin.download.Downloads;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.co */
public class co implements cb {
    public void m12088a(ii iiVar, Map<String, String> map) {
        cm t = C2968s.m11540t();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                C2972b.m11583d("Precache video action is missing the src parameter.");
                return;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String str2 = map.containsKey(Downloads.COLUMN_MIME_TYPE) ? (String) map.get(Downloads.COLUMN_MIME_TYPE) : BuildConfig.FLAVOR;
            if (t.m12075b(iiVar)) {
                C2972b.m11583d("Precache task already running.");
                return;
            }
            C3473d.m14338a(iiVar.m13245h());
            new cl(iiVar, iiVar.m13245h().f9477a.m11968a(iiVar, parseInt, str2), str).m10975g();
        } else if (!t.m12073a(iiVar)) {
            C2972b.m11583d("Precache abort but no preload task running.");
        }
    }
}
