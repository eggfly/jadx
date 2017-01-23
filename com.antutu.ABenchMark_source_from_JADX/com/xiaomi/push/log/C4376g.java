package com.xiaomi.push.log;

import android.util.Log;
import com.xiaomi.channel.commonutils.file.C4300c;
import com.xiaomi.channel.commonutils.misc.C4312f.C4311b;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.xiaomi.push.log.g */
class C4376g extends C4311b {
    final /* synthetic */ C4375f f14907a;

    C4376g(C4375f c4375f) {
        this.f14907a = c4375f;
    }

    public void m17975b() {
        if (!C4375f.f14904f.isEmpty()) {
            try {
                if (C4300c.m17641d()) {
                    this.f14907a.m17973b();
                } else {
                    Log.w(this.f14907a.f14905d, "SDCard is unavailable.");
                }
            } catch (Throwable e) {
                Log.e(this.f14907a.f14905d, BuildConfig.FLAVOR, e);
            }
        }
    }
}
