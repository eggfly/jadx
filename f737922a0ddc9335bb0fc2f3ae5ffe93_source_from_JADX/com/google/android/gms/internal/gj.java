package com.google.android.gms.internal;

import afq;
import afs;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class gj implements com.google.android.gms.clearcut.b {
    private static final c DW;
    private static final long FH;
    private static final Object j6;
    private final Runnable EQ;
    private final afq Hw;
    private long VH;
    private final Object Zo;
    private final long gn;
    private GoogleApiClient tp;
    private ScheduledFuture<?> u7;
    private final a v5;

    class 1 implements Runnable {
        final /* synthetic */ gj j6;

        1(gj gjVar) {
            this.j6 = gjVar;
        }

        public void run() {
            synchronized (this.j6.Zo) {
                if (0 <= this.j6.Hw.DW() && this.j6.tp != null) {
                    Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                    this.j6.tp.j6();
                    this.j6.tp = null;
                }
            }
        }
    }

    public interface a {
    }

    public static class b implements a {
    }

    private static final class c {
        private int j6;

        private c() {
            this.j6 = 0;
        }
    }

    static {
        j6 = new Object();
        DW = new c();
        FH = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    }

    public gj() {
        this(new afs(), FH, new b());
    }

    public gj(afq afq, long j, a aVar) {
        this.Zo = new Object();
        this.VH = 0;
        this.u7 = null;
        this.tp = null;
        this.EQ = new 1(this);
        this.Hw = afq;
        this.gn = j;
        this.v5 = aVar;
    }
}
