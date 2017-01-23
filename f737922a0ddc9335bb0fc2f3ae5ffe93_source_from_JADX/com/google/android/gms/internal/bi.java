package com.google.android.gms.internal;

import agg;
import android.os.IBinder;
import com.google.android.gms.ads.formats.a.a;
import com.google.android.gms.ads.formats.c;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.ArrayList;
import java.util.List;

@eh
public class bi extends c {
    private final List<a> DW;
    private final be FH;
    private final bh j6;

    public bi(bh bhVar) {
        be beVar;
        this.DW = new ArrayList();
        this.j6 = bhVar;
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

    public Double VH() {
        Double d = null;
        try {
            double VH = this.j6.VH();
            if (VH != -1.0d) {
                d = Double.valueOf(VH);
            }
        } catch (Throwable e) {
            b.DW("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence Zo() {
        try {
            return this.j6.Zo();
        } catch (Throwable e) {
            b.DW("Failed to get call to action.", e);
            return null;
        }
    }

    public CharSequence gn() {
        try {
            return this.j6.gn();
        } catch (Throwable e) {
            b.DW("Failed to get store", e);
            return null;
        }
    }

    bd j6(Object obj) {
        return obj instanceof IBinder ? bd.a.j6((IBinder) obj) : null;
    }

    protected /* synthetic */ Object j6() {
        return tp();
    }

    protected agg tp() {
        try {
            return this.j6.j6();
        } catch (Throwable e) {
            b.DW("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    public CharSequence u7() {
        try {
            return this.j6.u7();
        } catch (Throwable e) {
            b.DW("Failed to get price.", e);
            return null;
        }
    }

    public a v5() {
        return this.FH;
    }
}
