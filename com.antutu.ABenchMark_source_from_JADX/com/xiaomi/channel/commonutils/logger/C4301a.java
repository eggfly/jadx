package com.xiaomi.channel.commonutils.logger;

import android.util.Log;
import com.umeng.message.MsgConstant;

/* renamed from: com.xiaomi.channel.commonutils.logger.a */
public class C4301a implements LoggerInterface {
    private String f14717a;

    public C4301a() {
        this.f14717a = MsgConstant.MESSAGE_SYSTEM_SOURCE_XIAOMI;
    }

    public void log(String str) {
        Log.v(this.f14717a, str);
    }

    public void log(String str, Throwable th) {
        Log.v(this.f14717a, str, th);
    }

    public void setTag(String str) {
        this.f14717a = str;
    }
}
