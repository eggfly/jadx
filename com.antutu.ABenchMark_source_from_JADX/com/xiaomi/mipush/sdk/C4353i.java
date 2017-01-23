package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;

/* renamed from: com.xiaomi.mipush.sdk.i */
final class C4353i implements Runnable {
    final /* synthetic */ String[] f14812a;
    final /* synthetic */ Context f14813b;

    C4353i(String[] strArr, Context context) {
        this.f14812a = strArr;
        this.f14813b = context;
    }

    public void run() {
        try {
            for (Object obj : this.f14812a) {
                if (!TextUtils.isEmpty(obj)) {
                    PackageInfo packageInfo = this.f14813b.getPackageManager().getPackageInfo(obj, 4);
                    if (packageInfo != null) {
                        MiPushClient.awakePushServiceByPackageInfo(this.f14813b, packageInfo);
                    }
                }
            }
        } catch (Throwable th) {
            C4302b.m17651a(th);
        }
    }
}
