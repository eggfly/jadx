package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.stats.b;
import java.util.Collections;

public class x extends t {
    private d DW;
    private final ai FH;
    private m Hw;
    private final a j6;

    class 1 extends ai {
        final /* synthetic */ x j6;

        1(x xVar, v vVar) {
            this.j6 = xVar;
            super(vVar);
        }

        public void j6() {
            this.j6.VH();
        }
    }

    protected class a implements ServiceConnection {
        private volatile d DW;
        private volatile boolean FH;
        final /* synthetic */ x j6;

        class 1 implements Runnable {
            final /* synthetic */ a DW;
            final /* synthetic */ d j6;

            1(a aVar, d dVar) {
                this.DW = aVar;
                this.j6 = dVar;
            }

            public void run() {
                if (!this.DW.j6.DW()) {
                    this.DW.j6.FH("Connected to service after a timeout");
                    this.DW.j6.j6(this.j6);
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

        protected a(x xVar) {
            this.j6 = xVar;
        }

        public d j6() {
            d dVar = null;
            this.j6.J0();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            Context Ws = this.j6.Ws();
            intent.putExtra("app_package_name", Ws.getPackageName());
            b j6 = b.j6();
            synchronized (this) {
                this.DW = null;
                this.FH = true;
                boolean j62 = j6.j6(Ws, intent, this.j6.j6, (int) ProxyTextView.INPUTTYPE_textPassword);
                this.j6.j6("Bind to service requested", Boolean.valueOf(j62));
                if (j62) {
                    try {
                        wait(this.j6.XL().lg());
                    } catch (InterruptedException e) {
                        this.j6.v5("Wait for service connect was interrupted");
                    }
                    this.FH = false;
                    dVar = this.DW;
                    this.DW = null;
                    if (dVar == null) {
                        this.j6.Zo("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.FH = false;
                }
            }
            return dVar;
        }

        public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.analytics.internal.x.a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void. bs: [B:3:0x0009, B:9:0x0017]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:57)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r4 = this;
            r0 = "AnalyticsServiceConnection.onServiceConnected";
            com.google.android.gms.common.internal.b.DW(r0);
            monitor-enter(r4);
            if (r6 != 0) goto L_0x0016;
        L_0x0009:
            r0 = r4.j6;	 Catch:{ all -> 0x0060 }
            r1 = "Service connected with null binder";	 Catch:{ all -> 0x0060 }
            r0.Zo(r1);	 Catch:{ all -> 0x0060 }
            r4.notifyAll();	 Catch:{ all -> 0x004a }
            monitor-exit(r4);	 Catch:{ all -> 0x004a }
        L_0x0015:
            return;
        L_0x0016:
            r0 = 0;
            r1 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0056 }
            r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x0056 }
            r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0056 }
            if (r2 == 0) goto L_0x004d;	 Catch:{ RemoteException -> 0x0056 }
        L_0x0024:
            r0 = com.google.android.gms.analytics.internal.d.a.j6(r6);	 Catch:{ RemoteException -> 0x0056 }
            r1 = r4.j6;	 Catch:{ RemoteException -> 0x0056 }
            r2 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x0056 }
            r1.DW(r2);	 Catch:{ RemoteException -> 0x0056 }
        L_0x0030:
            if (r0 != 0) goto L_0x0065;
        L_0x0032:
            r0 = com.google.android.gms.common.stats.b.j6();	 Catch:{ IllegalArgumentException -> 0x0083 }
            r1 = r4.j6;	 Catch:{ IllegalArgumentException -> 0x0083 }
            r1 = r1.Ws();	 Catch:{ IllegalArgumentException -> 0x0083 }
            r2 = r4.j6;	 Catch:{ IllegalArgumentException -> 0x0083 }
            r2 = r2.j6;	 Catch:{ IllegalArgumentException -> 0x0083 }
            r0.j6(r1, r2);	 Catch:{ IllegalArgumentException -> 0x0083 }
        L_0x0045:
            r4.notifyAll();	 Catch:{ all -> 0x004a }
            monitor-exit(r4);	 Catch:{ all -> 0x004a }
            goto L_0x0015;	 Catch:{ all -> 0x004a }
        L_0x004a:
            r0 = move-exception;	 Catch:{ all -> 0x004a }
            monitor-exit(r4);	 Catch:{ all -> 0x004a }
            throw r0;
        L_0x004d:
            r2 = r4.j6;	 Catch:{ RemoteException -> 0x0056 }
            r3 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0056 }
            r2.v5(r3, r1);	 Catch:{ RemoteException -> 0x0056 }
            goto L_0x0030;
        L_0x0056:
            r1 = move-exception;
            r1 = r4.j6;	 Catch:{ all -> 0x0060 }
            r2 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x0060 }
            r1.Zo(r2);	 Catch:{ all -> 0x0060 }
            goto L_0x0030;
        L_0x0060:
            r0 = move-exception;
            r4.notifyAll();	 Catch:{ all -> 0x004a }
            throw r0;	 Catch:{ all -> 0x004a }
        L_0x0065:
            r1 = r4.FH;	 Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0080;	 Catch:{ all -> 0x0060 }
        L_0x0069:
            r1 = r4.j6;	 Catch:{ all -> 0x0060 }
            r2 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x0060 }
            r1.v5(r2);	 Catch:{ all -> 0x0060 }
            r1 = r4.j6;	 Catch:{ all -> 0x0060 }
            r1 = r1.aM();	 Catch:{ all -> 0x0060 }
            r2 = new com.google.android.gms.analytics.internal.x$a$1;	 Catch:{ all -> 0x0060 }
            r2.<init>(r4, r0);	 Catch:{ all -> 0x0060 }
            r1.j6(r2);	 Catch:{ all -> 0x0060 }
            goto L_0x0045;	 Catch:{ all -> 0x0060 }
        L_0x0080:
            r4.DW = r0;	 Catch:{ all -> 0x0060 }
            goto L_0x0045;
        L_0x0083:
            r0 = move-exception;
            goto L_0x0045;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.x.a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            com.google.android.gms.common.internal.b.DW("AnalyticsServiceConnection.onServiceDisconnected");
            this.j6.aM().j6(new 2(this, componentName));
        }
    }

    protected x(v vVar) {
        super(vVar);
        this.Hw = new m(vVar.Hw());
        this.j6 = new a(this);
        this.FH = new 1(this, vVar);
    }

    private void VH() {
        J0();
        if (DW()) {
            DW("Inactivity, disconnecting from device AnalyticsService");
            v5();
        }
    }

    private void Zo() {
        this.Hw.j6();
        this.FH.j6(XL().a8());
    }

    private void gn() {
        Mr().Zo();
    }

    private void j6(ComponentName componentName) {
        J0();
        if (this.DW != null) {
            this.DW = null;
            j6("Disconnected from device AnalyticsService", componentName);
            gn();
        }
    }

    private void j6(d dVar) {
        J0();
        this.DW = dVar;
        Zo();
        Mr().gn();
    }

    public boolean DW() {
        J0();
        P8();
        return this.DW != null;
    }

    public boolean FH() {
        J0();
        P8();
        d dVar = this.DW;
        if (dVar == null) {
            return false;
        }
        try {
            dVar.j6();
            Zo();
            return true;
        } catch (RemoteException e) {
            DW("Failed to clear hits from AnalyticsService");
            return false;
        }
    }

    public boolean Hw() {
        J0();
        P8();
        if (this.DW != null) {
            return true;
        }
        d j6 = this.j6.j6();
        if (j6 == null) {
            return false;
        }
        this.DW = j6;
        Zo();
        return true;
    }

    protected void j6() {
    }

    public boolean j6(c cVar) {
        com.google.android.gms.common.internal.b.j6((Object) cVar);
        J0();
        P8();
        d dVar = this.DW;
        if (dVar == null) {
            return false;
        }
        try {
            dVar.j6(cVar.DW(), cVar.Hw(), cVar.Zo() ? XL().Ws() : XL().QX(), Collections.emptyList());
            Zo();
            return true;
        } catch (RemoteException e) {
            DW("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public void v5() {
        J0();
        P8();
        try {
            b.j6().j6(Ws(), this.j6);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.DW != null) {
            this.DW = null;
            gn();
        }
    }
}
