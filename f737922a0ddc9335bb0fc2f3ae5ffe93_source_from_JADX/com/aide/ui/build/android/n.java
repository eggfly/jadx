package com.aide.ui.build.android;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.aide.common.e;
import com.aide.ui.build.packagingservice.ExternalPackagingService;
import com.aide.ui.build.packagingservice.a;
import com.aide.ui.build.packagingservice.b;
import java.util.LinkedList;
import java.util.Queue;

public class n {
    private a DW;
    private Queue<Runnable> FH;
    private ServiceConnection Hw;
    private b j6;

    class 1 implements ServiceConnection {
        final /* synthetic */ n j6;

        1(n nVar) {
            this.j6 = nVar;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.j6.DW = a.a.j6(iBinder);
            if (this.j6.j6 != null) {
                try {
                    this.j6.DW.j6(this.j6.j6);
                } catch (Throwable e) {
                    e.j6(e);
                }
            }
            while (!this.j6.FH.isEmpty()) {
                ((Runnable) this.j6.FH.poll()).run();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            e.DW("External Packaging service disconnected");
            this.j6.DW = null;
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ n j6;

        2(n nVar) {
            this.j6 = nVar;
        }

        public void run() {
            com.aide.ui.e.gn().unbindService(this.j6.Hw);
            this.j6.DW = null;
        }
    }

    class 3 extends b.a {
        final /* synthetic */ n DW;
        final /* synthetic */ b j6;

        3(n nVar, b bVar) {
            this.DW = nVar;
            this.j6 = bVar;
        }

        public void j6() {
            this.j6.j6();
        }

        public void j6(String str) {
            this.j6.j6(str);
            this.DW.FH();
        }

        public void j6(boolean z) {
            this.j6.j6(z);
            this.DW.FH();
        }

        public void j6(String str, int i) {
            this.j6.j6(str, i);
        }
    }

    class 4 implements Runnable {
        final /* synthetic */ String[] DW;
        final /* synthetic */ String EQ;
        final /* synthetic */ String[] FH;
        final /* synthetic */ String[] Hw;
        final /* synthetic */ String J0;
        final /* synthetic */ boolean J8;
        final /* synthetic */ boolean QX;
        final /* synthetic */ String VH;
        final /* synthetic */ boolean Ws;
        final /* synthetic */ n XL;
        final /* synthetic */ String Zo;
        final /* synthetic */ String[] gn;
        final /* synthetic */ String j6;
        final /* synthetic */ String tp;
        final /* synthetic */ String u7;
        final /* synthetic */ String v5;
        final /* synthetic */ String we;

        4(n nVar, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String[] strArr4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, boolean z3) {
            this.XL = nVar;
            this.j6 = str;
            this.DW = strArr;
            this.FH = strArr2;
            this.Hw = strArr3;
            this.v5 = str2;
            this.Zo = str3;
            this.VH = str4;
            this.gn = strArr4;
            this.u7 = str5;
            this.tp = str6;
            this.EQ = str7;
            this.we = str8;
            this.J0 = str9;
            this.J8 = z;
            this.Ws = z2;
            this.QX = z3;
        }

        public void run() {
            try {
                this.XL.DW.j6(this.j6, this.DW, this.FH, this.Hw, this.v5, this.Zo, this.VH, this.gn, this.u7, this.tp, this.EQ, this.we, this.J0, this.J8, this.Ws, this.QX);
            } catch (Throwable e) {
                e.j6(e);
            }
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ n j6;

        5(n nVar) {
            this.j6 = nVar;
        }

        public void run() {
            try {
                this.j6.DW.j6();
            } catch (Throwable e) {
                e.j6(e);
            }
        }
    }

    public n() {
        this.FH = new LinkedList();
        this.Hw = new 1(this);
    }

    public void j6(b bVar) {
        this.j6 = DW(bVar);
        if (this.DW != null) {
            try {
                this.DW.j6(this.j6);
            } catch (Throwable e) {
                e.j6(e);
            }
        }
    }

    private void FH() {
        com.aide.ui.e.j6(new 2(this));
    }

    private b DW(b bVar) {
        return new 3(this, bVar);
    }

    public void j6(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String[] strArr4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, boolean z3) {
        j6(new 4(this, str, strArr, strArr2, strArr3, str2, str3, str4, strArr4, str5, str6, str7, str8, str9, z, z2, z3));
    }

    private void j6(Runnable runnable) {
        if (this.DW != null) {
            runnable.run();
        } else if (com.aide.ui.e.gn().bindService(new Intent(com.aide.ui.e.gn(), ExternalPackagingService.class), this.Hw, 1)) {
            this.FH.add(runnable);
        } else {
            e.j6("Could not bind to service");
        }
    }

    public void j6() {
        try {
            this.j6.j6(false);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void DW() {
        j6(new 5(this));
    }
}
