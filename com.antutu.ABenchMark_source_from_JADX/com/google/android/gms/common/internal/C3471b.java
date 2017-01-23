package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.api.C3444a.C3389e;

/* renamed from: com.google.android.gms.common.internal.b */
public class C3471b<T extends IInterface> extends C2926i<T> {
    private final C3389e<T> f12054a;

    public C3471b(Context context, Looper looper, int i, C2921b c2921b, C2922c c2922c, C3477g c3477g, C3389e c3389e) {
        super(context, looper, i, c3477g, c2921b, c2922c);
        this.f12054a = c3389e;
    }

    protected String m14331a() {
        return this.f12054a.m13966a();
    }

    protected void m14332a(int i, T t) {
        this.f12054a.m13967a(i, t);
    }

    protected T m14333b(IBinder iBinder) {
        return this.f12054a.m13965a(iBinder);
    }

    protected String m14334b() {
        return this.f12054a.m13968b();
    }
}
