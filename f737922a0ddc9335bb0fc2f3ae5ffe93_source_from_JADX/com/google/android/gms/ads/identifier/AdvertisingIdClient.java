package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.g;
import com.google.android.gms.common.i;
import com.google.android.gms.internal.ab;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    ab DW;
    boolean FH;
    Object Hw;
    private final Context VH;
    final long Zo;
    g j6;
    b v5;

    public static final class a {
        private final boolean DW;
        private final String j6;

        public a(String str, boolean z) {
            this.j6 = str;
            this.DW = z;
        }

        public boolean DW() {
            return this.DW;
        }

        public String j6() {
            return this.j6;
        }

        public String toString() {
            String str = this.j6;
            return new StringBuilder(String.valueOf(str).length() + 7).append("{").append(str).append("}").append(this.DW).toString();
        }
    }

    static class b extends Thread {
        boolean DW;
        private WeakReference<AdvertisingIdClient> FH;
        private long Hw;
        CountDownLatch j6;

        public b(AdvertisingIdClient advertisingIdClient, long j) {
            this.FH = new WeakReference(advertisingIdClient);
            this.Hw = j;
            this.j6 = new CountDownLatch(1);
            this.DW = false;
            start();
        }

        private void FH() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.FH.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.DW();
                this.DW = true;
            }
        }

        public boolean DW() {
            return this.DW;
        }

        public void j6() {
            this.j6.countDown();
        }

        public void run() {
            try {
                if (!this.j6.await(this.Hw, TimeUnit.MILLISECONDS)) {
                    FH();
                }
            } catch (InterruptedException e) {
                FH();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.Hw = new Object();
        com.google.android.gms.common.internal.b.j6((Object) context);
        this.VH = context;
        this.FH = false;
        this.Zo = j;
    }

    public static a DW(Context context) {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.j6(false);
            a j6 = advertisingIdClient.j6();
            return j6;
        } finally {
            advertisingIdClient.DW();
        }
    }

    public static void DW(boolean z) {
    }

    private void FH() {
        synchronized (this.Hw) {
            if (this.v5 != null) {
                this.v5.j6();
                try {
                    this.v5.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.Zo > 0) {
                this.v5 = new b(this, this.Zo);
            }
        }
    }

    static g j6(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (i.DW().j6(context)) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    ServiceConnection gVar = new g();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (com.google.android.gms.common.stats.b.j6().j6(context, intent, gVar, 1)) {
                            return gVar;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new com.google.android.gms.common.b(9);
        }
    }

    static ab j6(Context context, g gVar) {
        try {
            return com.google.android.gms.internal.ab.a.j6(gVar.j6(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    public void DW() {
        com.google.android.gms.common.internal.b.FH("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.VH == null || this.j6 == null) {
                return;
            }
            try {
                if (this.FH) {
                    com.google.android.gms.common.stats.b.j6().j6(this.VH, this.j6);
                }
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            }
            this.FH = false;
            this.DW = null;
            this.j6 = null;
        }
    }

    protected void finalize() {
        DW();
        super.finalize();
    }

    public a j6() {
        a aVar;
        com.google.android.gms.common.internal.b.FH("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.FH) {
                synchronized (this.Hw) {
                    if (this.v5 == null || !this.v5.DW()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    j6(false);
                    if (!this.FH) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            com.google.android.gms.common.internal.b.j6(this.j6);
            com.google.android.gms.common.internal.b.j6(this.DW);
            aVar = new a(this.DW.j6(), this.DW.j6(true));
        }
        FH();
        return aVar;
    }

    protected void j6(boolean z) {
        com.google.android.gms.common.internal.b.FH("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.FH) {
                DW();
            }
            this.j6 = j6(this.VH);
            this.DW = j6(this.VH, this.j6);
            this.FH = true;
            if (z) {
                FH();
            }
        }
    }
}
