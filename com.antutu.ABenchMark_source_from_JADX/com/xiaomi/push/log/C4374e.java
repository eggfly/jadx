package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* renamed from: com.xiaomi.push.log.e */
public class C4374e implements LoggerInterface {
    private LoggerInterface f14899a;
    private LoggerInterface f14900b;

    public C4374e(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f14899a = null;
        this.f14900b = null;
        this.f14899a = loggerInterface;
        this.f14900b = loggerInterface2;
    }

    public void log(String str) {
        if (this.f14899a != null) {
            this.f14899a.log(str);
        }
        if (this.f14900b != null) {
            this.f14900b.log(str);
        }
    }

    public void log(String str, Throwable th) {
        if (this.f14899a != null) {
            this.f14899a.log(str, th);
        }
        if (this.f14900b != null) {
            this.f14900b.log(str, th);
        }
    }

    public void setTag(String str) {
    }
}
