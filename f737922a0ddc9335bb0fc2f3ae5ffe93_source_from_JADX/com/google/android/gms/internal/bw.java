package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;

@eh
public final class bw implements by {
    private void DW(fj fjVar, Map<String, String> map) {
        String str = (String) map.get("label");
        String str2 = (String) map.get("start_label");
        String str3 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            b.Hw("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            b.Hw("No timestamp given for CSI tick.");
        } else {
            try {
                long j6 = j6(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                fjVar.lg().j6(str, str2, j6);
            } catch (Throwable e) {
                b.FH("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private void FH(fj fjVar, Map<String, String> map) {
        String str = (String) map.get("value");
        if (TextUtils.isEmpty(str)) {
            b.Hw("No value given for CSI experiment.");
            return;
        }
        ay j6 = fjVar.lg().j6();
        if (j6 == null) {
            b.Hw("No ticker for WebView, dropping experiment ID.");
        } else {
            j6.j6("e", str);
        }
    }

    private void Hw(fj fjVar, Map<String, String> map) {
        String str = (String) map.get("name");
        String str2 = (String) map.get("value");
        if (TextUtils.isEmpty(str2)) {
            b.Hw("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            b.Hw("No name given for CSI extra.");
        } else {
            ay j6 = fjVar.lg().j6();
            if (j6 == null) {
                b.Hw("No ticker for WebView, dropping extra parameter.");
            } else {
                j6.j6(str, str2);
            }
        }
    }

    private long j6(long j) {
        return (j - f.VH().j6()) + f.VH().DW();
    }

    public void j6(fj fjVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            DW(fjVar, map);
        } else if ("experiment".equals(str)) {
            FH(fjVar, map);
        } else if ("extra".equals(str)) {
            Hw(fjVar, map);
        }
    }
}
