package com.google.android.gms.tagmanager;

import afq;
import afs;
import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class e {
    private static e J0;
    private static Object we;
    private volatile long DW;
    private a EQ;
    private volatile boolean FH;
    private volatile com.google.android.gms.ads.identifier.AdvertisingIdClient.a Hw;
    private final Context VH;
    private volatile long Zo;
    private final afq gn;
    private volatile long j6;
    private final Object tp;
    private final Thread u7;
    private volatile long v5;

    public interface a {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.a j6();
    }

    class 1 implements a {
        final /* synthetic */ e j6;

        1(e eVar) {
            this.j6 = eVar;
        }

        public com.google.android.gms.ads.identifier.AdvertisingIdClient.a j6() {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.a aVar = null;
            try {
                aVar = AdvertisingIdClient.DW(this.j6.VH);
            } catch (Throwable e) {
                r.DW("IllegalStateException getting Advertising Id Info", e);
            } catch (Throwable e2) {
                r.DW("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
            } catch (Throwable e22) {
                r.DW("IOException getting Ad Id Info", e22);
            } catch (Throwable e222) {
                r.DW("GooglePlayServicesNotAvailableException getting Advertising Id Info", e222);
            } catch (Throwable e2222) {
                r.DW("Unknown exception. Could not get the Advertising Id Info.", e2222);
            }
            return aVar;
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ e j6;

        2(e eVar) {
            this.j6 = eVar;
        }

        public void run() {
            this.j6.VH();
        }
    }

    static {
        we = new Object();
    }

    private e(Context context) {
        this(context, null, afs.Hw());
    }

    public e(Context context, a aVar, afq afq) {
        this.j6 = 900000;
        this.DW = 30000;
        this.FH = false;
        this.tp = new Object();
        this.EQ = new 1(this);
        this.gn = afq;
        if (context != null) {
            this.VH = context.getApplicationContext();
        } else {
            this.VH = context;
        }
        if (aVar != null) {
            this.EQ = aVar;
        }
        this.v5 = this.gn.j6();
        this.u7 = new Thread(new 2(this));
    }

    private void Hw() {
        synchronized (this) {
            try {
                v5();
                wait(500);
            } catch (InterruptedException e) {
            }
        }
    }

    private void VH() {
        Process.setThreadPriority(10);
        while (!this.FH) {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.a j6 = this.EQ.j6();
            if (j6 != null) {
                this.Hw = j6;
                this.Zo = this.gn.j6();
                r.FH("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.tp) {
                    this.tp.wait(this.j6);
                }
            } catch (InterruptedException e) {
                r.FH("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void Zo() {
        if (this.gn.j6() - this.Zo > 3600000) {
            this.Hw = null;
        }
    }

    public static e j6(Context context) {
        if (J0 == null) {
            synchronized (we) {
                if (J0 == null) {
                    J0 = new e(context);
                    J0.FH();
                }
            }
        }
        return J0;
    }

    private void v5() {
        if (this.gn.j6() - this.v5 > this.DW) {
            synchronized (this.tp) {
                this.tp.notify();
            }
            this.v5 = this.gn.j6();
        }
    }

    public boolean DW() {
        if (this.Hw == null) {
            Hw();
        } else {
            v5();
        }
        Zo();
        return this.Hw == null ? true : this.Hw.DW();
    }

    public void FH() {
        this.u7.start();
    }

    public String j6() {
        if (this.Hw == null) {
            Hw();
        } else {
            v5();
        }
        Zo();
        return this.Hw == null ? null : this.Hw.j6();
    }
}
