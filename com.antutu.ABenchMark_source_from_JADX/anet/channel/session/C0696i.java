package anet.channel.session;

import android.content.Context;
import anet.channel.Session.Status;
import anet.channel.entity.C0666a;
import org.android.spdy.SpdySession;

/* renamed from: anet.channel.session.i */
public class C0696i extends C0687k {
    private static String f2281a;

    static {
        f2281a = "awcn.StandardSpdySession";
    }

    public C0696i(Context context, C0666a c0666a) {
        super(context, c0666a, c0666a.m2799c());
    }

    protected void auth() {
        this.mSessionStat.ret = 1;
        notifyStatus(Status.AUTH_SUCC, null);
    }

    protected Runnable getRecvTimeOutRunnable() {
        return new C0697j(this);
    }

    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        if (this.mStatus == Status.CONNECTED) {
            notifyStatus(Status.AUTH_SUCC, null);
            this.mHasUnrevPing = false;
            return;
        }
        super.spdyPingRecvCallback(spdySession, j, obj);
    }
}
