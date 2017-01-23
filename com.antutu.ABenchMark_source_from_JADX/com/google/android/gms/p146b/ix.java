package com.google.android.gms.p146b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.internal.C2926i;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.p146b.iz.C3316a;

/* renamed from: com.google.android.gms.b.ix */
public class ix extends C2926i<iz> {
    public ix(Context context, Looper looper, C3477g c3477g, C2921b c2921b, C2922c c2922c) {
        super(context, looper, 40, c3477g, c2921b, c2922c);
    }

    protected iz m13493a(IBinder iBinder) {
        return C3316a.m13501a(iBinder);
    }

    protected String m13494a() {
        return "com.google.android.gms.clearcut.service.START";
    }

    public void m13495a(iy iyVar, LogEventParcelable logEventParcelable) {
        ((iz) m11398q()).m13499a(iyVar, logEventParcelable);
    }

    protected /* synthetic */ IInterface m13496b(IBinder iBinder) {
        return m13493a(iBinder);
    }

    protected String m13497b() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
