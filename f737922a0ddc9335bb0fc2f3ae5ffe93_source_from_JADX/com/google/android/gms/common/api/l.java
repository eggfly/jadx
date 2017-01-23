package com.google.android.gms.common.api;

import android.content.Context;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.hb;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class l<O extends a> {
    private final hb DW;
    private final a<O> FH;
    private final O Hw;
    private final gv VH;
    private final int Zo;
    private final AtomicBoolean gn;
    private final Context j6;
    private final AtomicInteger u7;
    private final go<O> v5;

    public a<O> DW() {
        return this.FH;
    }

    public O FH() {
        return this.Hw;
    }

    public go<O> Hw() {
        return this.v5;
    }

    public void j6() {
        boolean z = true;
        if (!this.gn.getAndSet(true)) {
            this.DW.j6();
            gv gvVar = this.VH;
            int i = this.Zo;
            if (this.u7.get() <= 0) {
                z = false;
            }
            gvVar.j6(i, z);
        }
    }

    public Context v5() {
        return this.j6;
    }
}
