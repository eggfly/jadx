package com.xiaomi.mipush.sdk;

import android.content.Context;

/* renamed from: com.xiaomi.mipush.sdk.f */
final class C4350f implements Runnable {
    final /* synthetic */ Context f14809a;
    final /* synthetic */ String f14810b;
    final /* synthetic */ String f14811c;

    C4350f(Context context, String str, String str2) {
        this.f14809a = context;
        this.f14810b = str;
        this.f14811c = str2;
    }

    public void run() {
        MiPushClient.initialize(this.f14809a, this.f14810b, this.f14811c, null);
    }
}
