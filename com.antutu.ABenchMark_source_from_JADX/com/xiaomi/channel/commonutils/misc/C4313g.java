package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.channel.commonutils.misc.C4312f.C4311b;

/* renamed from: com.xiaomi.channel.commonutils.misc.g */
class C4313g extends Handler {
    final /* synthetic */ C4312f f14748a;

    C4313g(C4312f c4312f, Looper looper) {
        this.f14748a = c4312f;
        super(looper);
    }

    public void handleMessage(Message message) {
        C4311b c4311b = (C4311b) message.obj;
        if (message.what == 0) {
            c4311b.m17676a();
        } else if (message.what == 1) {
            c4311b.m17678c();
        }
        super.handleMessage(message);
    }
}
