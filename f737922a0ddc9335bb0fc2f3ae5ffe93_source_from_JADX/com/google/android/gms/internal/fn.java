package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.c.a;
import com.google.android.gms.ads.internal.client.d;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.HashMap;
import java.util.Map;

@eh
public class fn extends a {
    private final Object DW;
    private final float FH;
    private int Hw;
    private boolean VH;
    private boolean Zo;
    private float gn;
    private final fj j6;
    private boolean u7;
    private d v5;

    class 1 implements Runnable {
        final /* synthetic */ fn DW;
        final /* synthetic */ Map j6;

        1(fn fnVar, Map map) {
            this.DW = fnVar;
            this.j6 = map;
        }

        public void run() {
            this.DW.j6.j6("pubVideoCmd", this.j6);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ int DW;
        final /* synthetic */ fn FH;
        final /* synthetic */ int j6;

        2(fn fnVar, int i, int i2) {
            this.FH = fnVar;
            this.j6 = i;
            this.DW = i2;
        }

        public void run() {
            boolean z = false;
            synchronized (this.FH.DW) {
                boolean z2 = this.j6 != this.DW;
                boolean z3 = !this.FH.Zo && this.DW == 1;
                boolean z4 = z2 && this.DW == 1;
                boolean z5 = z2 && this.DW == 2;
                z2 = z2 && this.DW == 3;
                fn fnVar = this.FH;
                if (this.FH.Zo || z3) {
                    z = true;
                }
                fnVar.Zo = z;
                if (this.FH.v5 == null) {
                    return;
                }
                if (z3) {
                    try {
                        this.FH.v5.j6();
                    } catch (Throwable e) {
                        b.FH("Unable to call onVideoStart()", e);
                    }
                }
                if (z4) {
                    try {
                        this.FH.v5.DW();
                    } catch (Throwable e2) {
                        b.FH("Unable to call onVideoPlay()", e2);
                    }
                }
                if (z5) {
                    try {
                        this.FH.v5.FH();
                    } catch (Throwable e22) {
                        b.FH("Unable to call onVideoPause()", e22);
                    }
                }
                if (z2) {
                    try {
                        this.FH.v5.Hw();
                    } catch (Throwable e222) {
                        b.FH("Unable to call onVideoEnd()", e222);
                    }
                }
            }
        }
    }

    public fn(fj fjVar, float f) {
        this.DW = new Object();
        this.u7 = true;
        this.j6 = fjVar;
        this.FH = f;
    }

    private void j6(int i, int i2) {
        f.FH().j6(new 2(this, i, i2));
    }

    private void j6(String str) {
        j6(str, null);
    }

    private void j6(String str, Map<String, String> map) {
        Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        f.FH().j6(new 1(this, hashMap));
    }

    public void DW() {
        j6("pause");
    }

    public boolean FH() {
        boolean z;
        synchronized (this.DW) {
            z = this.VH;
        }
        return z;
    }

    public int Hw() {
        int i;
        synchronized (this.DW) {
            i = this.Hw;
        }
        return i;
    }

    public float Zo() {
        float f;
        synchronized (this.DW) {
            f = this.gn;
        }
        return f;
    }

    public void j6() {
        j6("play");
    }

    public void j6(float f, int i, boolean z) {
        int i2;
        synchronized (this.DW) {
            this.gn = f;
            this.VH = z;
            i2 = this.Hw;
            this.Hw = i;
        }
        j6(i2, i);
    }

    public void j6(d dVar) {
        synchronized (this.DW) {
            this.v5 = dVar;
        }
    }

    public void j6(boolean z) {
        j6(z ? "mute" : "unmute");
    }

    public float v5() {
        return this.FH;
    }
}
