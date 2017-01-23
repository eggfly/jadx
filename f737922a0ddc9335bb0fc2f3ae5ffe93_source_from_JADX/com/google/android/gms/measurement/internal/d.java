package com.google.android.gms.measurement.internal;

import afq;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.k.b;
import com.google.android.gms.common.internal.k.c;
import java.util.ArrayList;
import java.util.List;

public class d extends b {
    private x DW;
    private Boolean FH;
    private final q Hw;
    private final q VH;
    private final List<Runnable> Zo;
    private final a j6;
    private final h v5;

    class 1 extends q {
        final /* synthetic */ d j6;

        1(d dVar, ai aiVar) {
            this.j6 = dVar;
            super(aiVar);
        }

        public void j6() {
            this.j6.nw();
        }
    }

    class 2 extends q {
        final /* synthetic */ d j6;

        2(d dVar, ai aiVar) {
            this.j6 = dVar;
            super(aiVar);
        }

        public void j6() {
            this.j6.lg().yS().j6("Tasks have been queued for a long time");
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ d j6;

        3(d dVar) {
            this.j6 = dVar;
        }

        public void run() {
            x FH = this.j6.DW;
            if (FH == null) {
                this.j6.lg().Zo().j6("Failed to send measurementEnabled to service");
                return;
            }
            try {
                FH.DW(this.j6.J0().j6(this.j6.lg().nw()));
                this.j6.P8();
            } catch (RemoteException e) {
                this.j6.lg().Zo().j6("Failed to send measurementEnabled to AppMeasurementService", e);
            }
        }
    }

    class 4 implements Runnable {
        final /* synthetic */ EventParcel DW;
        final /* synthetic */ d FH;
        final /* synthetic */ String j6;

        4(d dVar, String str, EventParcel eventParcel) {
            this.FH = dVar;
            this.j6 = str;
            this.DW = eventParcel;
        }

        public void run() {
            x FH = this.FH.DW;
            if (FH == null) {
                this.FH.lg().Zo().j6("Discarding data. Failed to send event to service");
                return;
            }
            try {
                if (TextUtils.isEmpty(this.j6)) {
                    FH.j6(this.DW, this.FH.J0().j6(this.FH.lg().nw()));
                } else {
                    FH.j6(this.DW, this.j6, this.FH.lg().nw());
                }
                this.FH.P8();
            } catch (RemoteException e) {
                this.FH.lg().Zo().j6("Failed to send event to AppMeasurementService", e);
            }
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ d DW;
        final /* synthetic */ UserAttributeParcel j6;

        5(d dVar, UserAttributeParcel userAttributeParcel) {
            this.DW = dVar;
            this.j6 = userAttributeParcel;
        }

        public void run() {
            x FH = this.DW.DW;
            if (FH == null) {
                this.DW.lg().Zo().j6("Discarding data. Failed to set user attribute");
                return;
            }
            try {
                FH.j6(this.j6, this.DW.J0().j6(this.DW.lg().nw()));
                this.DW.P8();
            } catch (RemoteException e) {
                this.DW.lg().Zo().j6("Failed to send attribute to AppMeasurementService", e);
            }
        }
    }

    class 6 implements Runnable {
        final /* synthetic */ d j6;

        6(d dVar) {
            this.j6 = dVar;
        }

        public void run() {
            x FH = this.j6.DW;
            if (FH == null) {
                this.j6.lg().Zo().j6("Discarding data. Failed to send app launch");
                return;
            }
            try {
                FH.j6(this.j6.J0().j6(this.j6.lg().nw()));
                this.j6.P8();
            } catch (RemoteException e) {
                this.j6.lg().Zo().j6("Failed to send app launch to AppMeasurementService", e);
            }
        }
    }

    protected class a implements ServiceConnection, b, c {
        private volatile boolean DW;
        private volatile z FH;
        final /* synthetic */ d j6;

        class 1 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ x j6;

            1(a aVar, x xVar) {
                this.DW = aVar;
                this.j6 = xVar;
            }

            public void run() {
                synchronized (this.DW) {
                    this.DW.DW = false;
                    if (!this.DW.j6.Zo()) {
                        this.DW.j6.lg().ei().j6("Connected to service");
                        this.DW.j6.j6(this.j6);
                    }
                }
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ ComponentName j6;

            2(a aVar, ComponentName componentName) {
                this.DW = aVar;
                this.j6 = componentName;
            }

            public void run() {
                this.DW.j6.j6(this.j6);
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ x j6;

            3(a aVar, x xVar) {
                this.DW = aVar;
                this.j6 = xVar;
            }

            public void run() {
                synchronized (this.DW) {
                    this.DW.DW = false;
                    if (!this.DW.j6.Zo()) {
                        this.DW.j6.lg().P8().j6("Connected to remote service");
                        this.DW.j6.j6(this.j6);
                    }
                }
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ a j6;

            4(a aVar) {
                this.j6 = aVar;
            }

            public void run() {
                this.j6.j6.j6(new ComponentName(this.j6.j6.XL(), "com.google.android.gms.measurement.AppMeasurementService"));
            }
        }

        protected a(d dVar) {
            this.j6 = dVar;
        }

        public void j6() {
            this.j6.tp();
            Context XL = this.j6.XL();
            synchronized (this) {
                if (this.DW) {
                    this.j6.lg().ei().j6("Connection attempt already in progress");
                } else if (this.FH != null) {
                    this.j6.lg().ei().j6("Already awaiting connection attempt");
                } else {
                    this.FH = new z(XL, Looper.getMainLooper(), this, this);
                    this.j6.lg().ei().j6("Connecting to remote service");
                    this.DW = true;
                    this.FH.EQ();
                }
            }
        }

        public void j6(int i) {
            com.google.android.gms.common.internal.b.DW("MeasurementServiceConnection.onConnectionSuspended");
            this.j6.lg().P8().j6("Service connection suspended");
            this.j6.a8().j6(new 4(this));
        }

        public void j6(Intent intent) {
            this.j6.tp();
            Context XL = this.j6.XL();
            com.google.android.gms.common.stats.b j6 = com.google.android.gms.common.stats.b.j6();
            synchronized (this) {
                if (this.DW) {
                    this.j6.lg().ei().j6("Connection attempt already in progress");
                    return;
                }
                this.DW = true;
                j6.j6(XL, intent, this.j6.j6, (int) ProxyTextView.INPUTTYPE_textPassword);
            }
        }

        public void j6(Bundle bundle) {
            com.google.android.gms.common.internal.b.DW("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    x xVar = (x) this.FH.aM();
                    this.FH = null;
                    this.j6.a8().j6(new 3(this, xVar));
                } catch (DeadObjectException e) {
                    this.FH = null;
                    this.DW = false;
                } catch (IllegalStateException e2) {
                    this.FH = null;
                    this.DW = false;
                }
            }
        }

        public void j6(ConnectionResult connectionResult) {
            com.google.android.gms.common.internal.b.DW("MeasurementServiceConnection.onConnectionFailed");
            aa VH = this.j6.J8.VH();
            if (VH != null) {
                VH.yS().j6("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.DW = false;
                this.FH = null;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.google.android.gms.common.internal.b.DW("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.DW = false;
                    this.j6.lg().Zo().j6("Service connected with null binder");
                    return;
                }
                x xVar = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        xVar = com.google.android.gms.measurement.internal.x.a.j6(iBinder);
                        this.j6.lg().ei().j6("Bound to IMeasurementService interface");
                    } else {
                        this.j6.lg().Zo().j6("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.j6.lg().Zo().j6("Service connect failed to get IMeasurementService");
                }
                if (xVar == null) {
                    this.DW = false;
                    try {
                        com.google.android.gms.common.stats.b.j6().j6(this.j6.XL(), this.j6.j6);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.j6.a8().j6(new 1(this, xVar));
                }
                return;
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            com.google.android.gms.common.internal.b.DW("MeasurementServiceConnection.onServiceDisconnected");
            this.j6.lg().P8().j6("Service disconnected");
            this.j6.a8().j6(new 2(this, componentName));
        }
    }

    protected d(ai aiVar) {
        super(aiVar);
        this.Zo = new ArrayList();
        this.v5 = new h(aiVar.aM());
        this.j6 = new a(this);
        this.Hw = new 1(this, aiVar);
        this.VH = new 2(this, aiVar);
    }

    private void KD() {
        tp();
        lg().ei().j6("Processing queued up service tasks", Integer.valueOf(this.Zo.size()));
        for (Runnable j6 : this.Zo) {
            a8().j6(j6);
        }
        this.Zo.clear();
        this.VH.FH();
    }

    private void P8() {
        tp();
        this.v5.j6();
        if (!this.J8.vy()) {
            this.Hw.j6(er().sh());
        }
    }

    private void SI() {
        tp();
        gW();
    }

    private boolean ei() {
        List queryIntentServices = XL().getPackageManager().queryIntentServices(new Intent().setClassName(XL(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    private void j6(ComponentName componentName) {
        tp();
        if (this.DW != null) {
            this.DW = null;
            lg().ei().j6("Disconnected from device MeasurementService", componentName);
            SI();
        }
    }

    private void j6(x xVar) {
        tp();
        com.google.android.gms.common.internal.b.j6((Object) xVar);
        this.DW = xVar;
        P8();
        KD();
    }

    private void j6(Runnable runnable) {
        tp();
        if (Zo()) {
            runnable.run();
        } else if (((long) this.Zo.size()) >= er().x9()) {
            lg().Zo().j6("Discarding data. Max runnable queue size reached");
        } else {
            this.Zo.add(runnable);
            if (!this.J8.vy()) {
                this.VH.j6(60000);
            }
            gW();
        }
    }

    private void nw() {
        tp();
        if (Zo()) {
            lg().ei().j6("Inactivity, disconnecting from AppMeasurementService");
            vy();
        }
    }

    protected boolean BT() {
        tp();
        FH();
        if (er().ef()) {
            return true;
        }
        lg().ei().j6("Checking service availability");
        switch (i.DW().j6(XL())) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                lg().ei().j6("Service available");
                return true;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                lg().ei().j6("Service missing");
                return false;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                lg().P8().j6("Service container out of date");
                return true;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                lg().yS().j6("Service disabled");
                return false;
            case 9:
                lg().yS().j6("Service invalid");
                return false;
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                lg().yS().j6("Service updating");
                return true;
            default:
                return false;
        }
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
        tp();
        FH();
        j6(new 3(this));
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    public boolean Zo() {
        tp();
        FH();
        return this.DW != null;
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

    void gW() {
        tp();
        FH();
        if (!Zo()) {
            if (this.FH == null) {
                this.FH = rN().BT();
                if (this.FH == null) {
                    lg().ei().j6("State of service unknown");
                    this.FH = Boolean.valueOf(BT());
                    rN().j6(this.FH.booleanValue());
                }
            }
            if (this.FH.booleanValue()) {
                lg().ei().j6("Using measurement service");
                this.j6.j6();
            } else if (!this.J8.vy() && ei()) {
                lg().ei().j6("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(XL(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.j6.j6(intent);
            } else if (er().Sf()) {
                lg().ei().j6("Using direct local measurement implementation");
                j6(new aj(this.J8, true));
            } else {
                lg().Zo().j6("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    protected void j6(EventParcel eventParcel, String str) {
        com.google.android.gms.common.internal.b.j6((Object) eventParcel);
        tp();
        FH();
        j6(new 4(this, str, eventParcel));
    }

    protected void j6(UserAttributeParcel userAttributeParcel) {
        tp();
        FH();
        j6(new 5(this, userAttributeParcel));
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

    public void vy() {
        tp();
        FH();
        try {
            com.google.android.gms.common.stats.b.j6().j6(XL(), this.j6);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.DW = null;
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }

    protected void yS() {
        tp();
        FH();
        j6(new 6(this));
    }
}
