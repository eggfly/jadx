package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.request.C2934j.C2936a;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.internal.C2926i;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.request.e */
public class C2927e extends C2926i<C2934j> {
    final int f9979a;

    public C2927e(Context context, Looper looper, C2921b c2921b, C2922c c2922c, int i) {
        super(context, looper, 8, C3477g.m14343a(context), c2921b, c2922c);
        this.f9979a = i;
    }

    protected C2934j m11400a(IBinder iBinder) {
        return C2936a.m11421a(iBinder);
    }

    protected String m11401a() {
        return "com.google.android.gms.ads.service.START";
    }

    protected /* synthetic */ IInterface m11402b(IBinder iBinder) {
        return m11400a(iBinder);
    }

    protected String m11403b() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public C2934j m11404c() {
        return (C2934j) super.m11398q();
    }
}
