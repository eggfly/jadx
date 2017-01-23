package com.google.android.gms.p146b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.igexin.sdk.PushConsts;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.bz */
public final class bz implements cb {
    private long m11970a(long j) {
        return (j - C2968s.m11529i().m13543a()) + C2968s.m11529i().m13544b();
    }

    private void m11971b(ii iiVar, Map<String, String> map) {
        String str = (String) map.get("label");
        String str2 = (String) map.get("start_label");
        String str3 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            C2972b.m11583d("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            C2972b.m11583d("No timestamp given for CSI tick.");
        } else {
            try {
                long a = m11970a(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                iiVar.m13261x().m11848a(str, str2, a);
            } catch (Throwable e) {
                C2972b.m11584d("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private void m11972c(ii iiVar, Map<String, String> map) {
        String str = (String) map.get("value");
        if (TextUtils.isEmpty(str)) {
            C2972b.m11583d("No value given for CSI experiment.");
            return;
        }
        az a = iiVar.m13261x().m11846a();
        if (a == null) {
            C2972b.m11583d("No ticker for WebView, dropping experiment ID.");
        } else {
            a.m11853a("e", str);
        }
    }

    private void m11973d(ii iiVar, Map<String, String> map) {
        String str = (String) map.get("name");
        String str2 = (String) map.get("value");
        if (TextUtils.isEmpty(str2)) {
            C2972b.m11583d("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            C2972b.m11583d("No name given for CSI extra.");
        } else {
            az a = iiVar.m13261x().m11846a();
            if (a == null) {
                C2972b.m11583d("No ticker for WebView, dropping extra parameter.");
            } else {
                a.m11853a(str, str2);
            }
        }
    }

    public void m11974a(ii iiVar, Map<String, String> map) {
        String str = (String) map.get(PushConsts.CMD_ACTION);
        if ("tick".equals(str)) {
            m11971b(iiVar, map);
        } else if ("experiment".equals(str)) {
            m11972c(iiVar, map);
        } else if ("extra".equals(str)) {
            m11973d(iiVar, map);
        }
    }
}
