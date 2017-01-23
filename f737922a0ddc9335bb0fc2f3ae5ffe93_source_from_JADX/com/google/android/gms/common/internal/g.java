package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.a;
import com.google.android.gms.common.api.GoogleApiClient.b;
import com.google.android.gms.common.api.a.h;

public class g<T extends IInterface> extends r<T> {
    private final h<T> Hw;

    public g(Context context, Looper looper, int i, a aVar, b bVar, n nVar, h<T> hVar) {
        super(context, looper, i, nVar, aVar, bVar);
        this.Hw = hVar;
    }

    protected String VH() {
        return this.Hw.DW();
    }

    protected String Zo() {
        return this.Hw.j6();
    }

    public h<T> gn() {
        return this.Hw;
    }

    protected T j6(IBinder iBinder) {
        return this.Hw.j6(iBinder);
    }

    protected void j6(int i, T t) {
        this.Hw.j6(i, t);
    }
}
