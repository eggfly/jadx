package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.f;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.internal.bq;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.eh;

@eh
public class w {
    private static w DW;
    private static final Object j6;
    private final a FH;
    private final v Hw;

    static {
        j6 = new Object();
        j6(new w());
    }

    protected w() {
        this.FH = new a();
        this.Hw = new v(new q(), new p(), new g(), new bq(), new f(), new ea(), new do());
    }

    public static v DW() {
        return FH().Hw;
    }

    private static w FH() {
        w wVar;
        synchronized (j6) {
            wVar = DW;
        }
        return wVar;
    }

    public static a j6() {
        return FH().FH;
    }

    protected static void j6(w wVar) {
        synchronized (j6) {
            DW = wVar;
        }
    }
}
