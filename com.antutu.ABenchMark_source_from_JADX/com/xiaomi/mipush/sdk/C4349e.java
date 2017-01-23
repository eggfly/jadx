package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.xiaomi.channel.commonutils.logger.C4302b;

/* renamed from: com.xiaomi.mipush.sdk.e */
final class C4349e implements Runnable {
    final /* synthetic */ Context f14808a;

    C4349e(Context context) {
        this.f14808a = context;
    }

    public void run() {
        try {
            PackageInfo packageInfo = this.f14808a.getPackageManager().getPackageInfo(this.f14808a.getPackageName(), 4100);
            C4348d.m17830c(this.f14808a);
            C4348d.m17832d(this.f14808a, packageInfo);
            C4348d.m17831c(this.f14808a, packageInfo);
        } catch (Throwable e) {
            C4302b.m17651a(e);
        }
    }
}
