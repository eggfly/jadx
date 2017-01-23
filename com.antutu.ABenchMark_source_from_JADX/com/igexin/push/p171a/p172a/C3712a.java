package com.igexin.push.p171a.p172a;

import android.os.Message;
import com.igexin.push.core.C3794a;
import com.igexin.push.core.C3854f;
import com.igexin.push.p169f.p170b.C3711d;

/* renamed from: com.igexin.push.a.a.a */
public class C3712a implements C3711d {
    private long f12521a;

    public C3712a() {
        this.f12521a = 0;
    }

    public void m15212a() {
        Message obtain = Message.obtain();
        obtain.what = C3794a.f12729i;
        C3854f.m15859a().m15865a(obtain);
    }

    public void m15213a(long j) {
        this.f12521a = j;
    }

    public boolean m15214b() {
        return System.currentTimeMillis() - this.f12521a > 360000;
    }
}
