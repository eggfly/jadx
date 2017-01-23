package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.k.b;
import com.google.android.gms.common.internal.k.c;
import com.google.android.gms.measurement.internal.x.a;

public class z extends k<x> {
    public z(Context context, Looper looper, b bVar, c cVar) {
        super(context, looper, 93, bVar, cVar, null);
    }

    public x DW(IBinder iBinder) {
        return a.j6(iBinder);
    }

    protected String VH() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    protected String Zo() {
        return "com.google.android.gms.measurement.START";
    }

    public /* synthetic */ IInterface j6(IBinder iBinder) {
        return DW(iBinder);
    }
}
