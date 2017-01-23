package com.google.android.gms.internal;

import agg;
import android.os.IBinder;
import com.google.android.gms.ads.formats.a.a;
import com.google.android.gms.ads.formats.d;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.List;

@eh
public class bk extends d {
    private final List<a> DW;
    private final be FH;
    private final bj j6;

    public bk(bj bjVar) {
        be beVar;
        this.DW = new ArrayList();
        this.j6 = bjVar;
        try {
            List<Object> FH = this.j6.FH();
            if (FH != null) {
                for (Object j6 : FH) {
                    bd j62 = j6(j6);
                    if (j62 != null) {
                        this.DW.add(new be(j62));
                    }
                }
            }
        } catch (Throwable e) {
            b.DW("Failed to get image.", e);
        }
        try {
            bd v5 = this.j6.v5();
            if (v5 != null) {
                beVar = new be(v5);
                this.FH = beVar;
            }
        } catch (Throwable e2) {
            b.DW("Failed to get icon.", e2);
        }
        beVar = null;
        this.FH = beVar;
    }

    public CharSequence DW() {
        try {
            return this.j6.DW();
        } catch (Throwable e) {
            b.DW("Failed to get headline.", e);
            return null;
        }
    }

    public List<a> FH() {
        return this.DW;
    }

    public CharSequence Hw() {
        try {
            return this.j6.Hw();
        } catch (Throwable e) {
            b.DW("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence VH() {
        try {
            return this.j6.VH();
        } catch (Throwable e) {
            b.DW("Failed to get attribution.", e);
            return null;
        }
    }

    public CharSequence Zo() {
        try {
            return this.j6.Zo();
        } catch (Throwable e) {
            b.DW("Failed to get call to action.", e);
            return null;
        }
    }

    protected agg gn() {
        try {
            return this.j6.j6();
        } catch (Throwable e) {
            b.DW("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    bd j6(Object obj) {
        return obj instanceof IBinder ? bd.a.j6((IBinder) obj) : null;
    }

    protected /* synthetic */ Object j6() {
        return gn();
    }

    public a v5() {
        return this.FH;
    }
}
