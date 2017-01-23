package com.cmcm.p074a.p075a.p114c;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.cmcm.p074a.p075a.p112a.C2108b;
import com.cmcm.p074a.p075a.p112a.C2126s;
import com.cmcm.p074a.p075a.p112a.C2133z;
import com.cmcm.p074a.p075a.p112a.ad;
import com.cmcm.p074a.p075a.p115d.C2169j;

/* renamed from: com.cmcm.a.a.c.b */
public abstract class C2136b {
    private int f7487a;
    private boolean f7488b;

    public C2136b() {
        this.f7487a = 10;
        this.f7488b = false;
        m8064c();
    }

    private void m8064c() {
        m8066a(C2126s.m8026a(m8074f(), "mode", 10));
    }

    public void m8065a() {
        m8064c();
    }

    public final synchronized void m8066a(int i) {
        this.f7487a = i;
    }

    protected final void m8067a(BroadcastReceiver broadcastReceiver) {
        C2126s.m8030a(broadcastReceiver);
    }

    protected final void m8068a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        C2126s.m8031a(broadcastReceiver, intentFilter);
    }

    protected final void m8069a(String str) {
        C2169j.m8169a().m8198a(m8072d(), m8074f(), str);
    }

    public final synchronized boolean m8070a(boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.f7488b != z) {
                this.f7488b = z;
                if (C2133z.f7482a) {
                    ad.m7931a(m8074f(), "setEnabled(%s)", Boolean.valueOf(this.f7488b));
                }
                if (this.f7488b) {
                    m8071b();
                } else {
                    m8075g();
                }
                z2 = true;
            }
        }
        return z2;
    }

    protected void m8071b() {
    }

    public final synchronized int m8072d() {
        return this.f7487a;
    }

    public final synchronized boolean m8073e() {
        return this.f7488b;
    }

    public abstract String m8074f();

    protected void m8075g() {
    }

    protected final SharedPreferences m8076h() {
        return C2108b.m7937a("receiver").m7939b();
    }
}
