package com.google.android.gms.measurement.internal;

import afq;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class f extends b {
    private long DW;
    private final Runnable FH;
    private final q Hw;
    private Handler j6;
    private final q v5;

    class 1 implements Runnable {
        final /* synthetic */ f j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                this.j6.j6.yS();
            }
        }

        1(f fVar) {
            this.j6 = fVar;
        }

        public void run() {
            this.j6.a8().j6(new 1(this));
        }
    }

    class 2 extends q {
        final /* synthetic */ f j6;

        2(f fVar, ai aiVar) {
            this.j6 = fVar;
            super(aiVar);
        }

        public void j6() {
            this.j6.BT();
        }
    }

    class 3 extends q {
        final /* synthetic */ f j6;

        3(f fVar, ai aiVar) {
            this.j6 = fVar;
            super(aiVar);
        }

        public void j6() {
            this.j6.vy();
        }
    }

    class 4 implements Runnable {
        final /* synthetic */ f DW;
        final /* synthetic */ long j6;

        4(f fVar, long j) {
            this.DW = fVar;
            this.j6 = j;
        }

        public void run() {
            this.DW.j6(this.j6);
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ f DW;
        final /* synthetic */ long j6;

        5(f fVar, long j) {
            this.DW = fVar;
            this.j6 = j;
        }

        public void run() {
            this.DW.DW(this.j6);
        }
    }

    f(ai aiVar) {
        super(aiVar);
        this.FH = new 1(this);
        this.Hw = new 2(this, this.J8);
        this.v5 = new 3(this, this.J8);
    }

    private void BT() {
        tp();
        lg().ei().j6("Session started, time", Long.valueOf(QX().DW()));
        rN().tp.j6(false);
        we().j6("auto", "_s", new Bundle());
    }

    private void DW(long j) {
        tp();
        gW();
        this.Hw.FH();
        this.v5.FH();
        lg().ei().j6("Activity paused, time", Long.valueOf(j));
        if (this.DW != 0) {
            rN().we.j6(rN().we.j6() + (j - this.DW));
        }
        rN().EQ.j6(QX().j6());
        synchronized (this) {
            if (!rN().tp.j6()) {
                this.j6.postDelayed(this.FH, 1000);
            }
        }
    }

    private void gW() {
        synchronized (this) {
            if (this.j6 == null) {
                this.j6 = new Handler(Looper.getMainLooper());
            }
        }
    }

    private void j6(long j) {
        tp();
        gW();
        this.Hw.FH();
        this.v5.FH();
        lg().ei().j6("Activity resumed, time", Long.valueOf(j));
        this.DW = j;
        if (QX().j6() - rN().u7.j6() > rN().EQ.j6()) {
            rN().tp.j6(true);
            rN().we.j6(0);
        }
        if (rN().tp.j6()) {
            this.Hw.j6(Math.max(0, rN().gn.j6() - rN().we.j6()));
        } else {
            this.v5.j6(Math.max(0, 3600000 - rN().we.j6()));
        }
    }

    private void vy() {
        tp();
        long DW = QX().DW();
        if (this.DW == 0) {
            this.DW = DW - 3600000;
        }
        long j6 = rN().we.j6() + (DW - this.DW);
        rN().we.j6(j6);
        lg().ei().j6("Recording user engagement, ms", Long.valueOf(j6));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j6);
        we().j6("auto", "_e", bundle);
        rN().we.j6(0);
        this.DW = DW;
        this.v5.j6(Math.max(0, 3600000 - rN().we.j6()));
    }

    public /* bridge */ /* synthetic */ n EQ() {
        return super.EQ();
    }

    public /* bridge */ /* synthetic */ y J0() {
        return super.J0();
    }

    public /* bridge */ /* synthetic */ r J8() {
        return super.J8();
    }

    public /* bridge */ /* synthetic */ ag Mr() {
        return super.Mr();
    }

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    protected void VH() {
        a8().j6(new 5(this, QX().DW()));
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    protected void Zo() {
        synchronized (this) {
            gW();
            this.j6.removeCallbacks(this.FH);
        }
        a8().j6(new 4(this, QX().DW()));
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    public /* bridge */ /* synthetic */ aa lg() {
        return super.lg();
    }

    public /* bridge */ /* synthetic */ ae rN() {
        return super.rN();
    }

    public /* bridge */ /* synthetic */ void tp() {
        super.tp();
    }

    public /* bridge */ /* synthetic */ void u7() {
        super.u7();
    }

    protected void v5() {
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }

    public void yS() {
        tp();
        lg().P8().j6("Application backgrounded. Logging engagement");
        long j6 = rN().we.j6();
        if (j6 > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j6);
            we().j6("auto", "_e", bundle);
            rN().we.j6(0);
            return;
        }
        lg().yS().j6("Not logging non-positive engagement time", Long.valueOf(j6));
    }
}
