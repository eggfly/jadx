package com.antutu.redacc.p067f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.antutu.redacc.f.c */
public class C1746c {
    private List<ApplicationInfo> f6178a;

    public C1746c(Context context) {
        this.f6178a = context.getPackageManager().getInstalledApplications(SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
    }

    public ApplicationInfo m6743a(String str) {
        if (str == null) {
            return null;
        }
        for (ApplicationInfo applicationInfo : this.f6178a) {
            if (str.equals(applicationInfo.processName)) {
                return applicationInfo;
            }
        }
        return null;
    }
}
