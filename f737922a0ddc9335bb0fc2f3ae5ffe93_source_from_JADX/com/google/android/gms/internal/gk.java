package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.a;
import com.google.android.gms.common.api.GoogleApiClient.b;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.r;

public class gk extends r<gm> {
    public gk(Context context, Looper looper, n nVar, a aVar, b bVar) {
        super(context, looper, 40, nVar, aVar, bVar);
    }

    protected gm DW(IBinder iBinder) {
        return gm.a.j6(iBinder);
    }

    protected String VH() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }

    protected String Zo() {
        return "com.google.android.gms.clearcut.service.START";
    }

    protected /* synthetic */ IInterface j6(IBinder iBinder) {
        return DW(iBinder);
    }
}
