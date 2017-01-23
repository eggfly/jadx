package com.google.android.gms.measurement.internal;

import afq;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.b;

public class i extends b {
    private final AlarmManager DW;
    private boolean j6;

    protected i(ai aiVar) {
        super(aiVar);
        this.DW = (AlarmManager) XL().getSystemService("alarm");
    }

    private PendingIntent VH() {
        Intent className = new Intent().setClassName(XL(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(XL(), 0, className, 0);
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

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    public void Zo() {
        FH();
        this.j6 = false;
        this.DW.cancel(VH());
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

    public void j6(long j) {
        FH();
        b.DW(j > 0);
        b.j6(af.j6(XL()), (Object) "Receiver not registered/enabled");
        b.j6(e.j6(XL()), (Object) "Service not registered/enabled");
        Zo();
        long DW = QX().DW() + j;
        this.j6 = true;
        this.DW.setInexactRepeating(2, DW, Math.max(er().kQ(), j), VH());
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
        this.DW.cancel(VH());
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }
}
