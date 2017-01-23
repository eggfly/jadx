package com.appfour.common.gcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.d;
import com.google.android.gms.gcm.a;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class b {
    private static b Zo;
    private String DW;
    private Context FH;
    private Handler Hw;
    private a j6;
    private c v5;

    class 1 extends Thread {
        final /* synthetic */ String DW;
        final /* synthetic */ long FH;
        final /* synthetic */ b Hw;
        final /* synthetic */ String j6;

        1(b bVar, String str, String str2, String str3, long j) {
            this.Hw = bVar;
            this.j6 = str2;
            this.DW = str3;
            this.FH = j;
            super(str);
        }

        public void run() {
            try {
                this.Hw.DW = this.j6;
                boolean j6 = this.Hw.DW();
                a.DW("GCM id: " + this.Hw.DW);
                if (!this.Hw.DW.equals(this.DW)) {
                    if (j6 || this.FH + 3600000 < System.currentTimeMillis()) {
                        this.Hw.VH();
                    }
                }
            } catch (Throwable th) {
                a.j6(th);
            }
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ b DW;
        final /* synthetic */ String j6;

        2(b bVar, String str) {
            this.DW = bVar;
            this.j6 = str;
        }

        public void run() {
            this.DW.FH(this.j6);
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ b j6;

        3(b bVar) {
            this.j6 = bVar;
        }

        public void run() {
            this.j6.gn();
            a.DW("GCM: Startup msg sent");
        }
    }

    public static void j6(Context context, c cVar) {
        if (Zo != null) {
            throw new IllegalStateException("GcmService already initialized");
        }
        Zo = new b();
        Zo.DW(context, cVar);
    }

    public static b j6() {
        if (Zo != null) {
            return Zo;
        }
        throw new IllegalStateException("GcmService not initialized");
    }

    private b() {
    }

    private void DW(Context context, c cVar) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.FH = context;
        this.v5 = cVar;
        this.Hw = new Handler(Looper.getMainLooper());
        if (FH()) {
            this.j6 = a.j6(context);
            Thread 1 = new 1(this, "GCM", Hw(), v5(), Zo());
            1.setPriority(1);
            1.start();
        }
    }

    private boolean DW() {
        boolean z = true;
        long j = 1000;
        String str = null;
        while (true) {
            if (str != null && !str.isEmpty()) {
                break;
            }
            String j6;
            try {
                j6 = this.j6.j6("381461820831");
            } catch (Throwable e) {
                a.j6(e);
                j6 = str;
            }
            try {
                Thread.sleep(j);
            } catch (InterruptedException e2) {
            }
            j *= 2;
            str = j6;
        }
        if (this.DW.isEmpty() || str.equals(this.DW)) {
            z = false;
        }
        if (this.DW.isEmpty() || !str.equals(this.DW)) {
            this.DW = str;
            this.Hw.post(new 2(this, this.DW));
        }
        return z;
    }

    private boolean FH() {
        int j6 = d.j6(this.FH);
        if (j6 == 0) {
            return true;
        }
        a.DW("Google Play services not available: " + j6);
        return false;
    }

    private String Hw() {
        return this.FH.getSharedPreferences("Gcm", 0).getString("GcmId", "");
    }

    private String v5() {
        return this.FH.getSharedPreferences("Gcm", 0).getString("GcmAcknowledgedId", "");
    }

    private long Zo() {
        return this.FH.getSharedPreferences("Gcm", 0).getLong("GcmLastSent", 0);
    }

    private void VH() {
        long j = 1000;
        while (true) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("api_version", "2");
                bundle.putString("action", "startup");
                this.j6.j6("381461820831@gcm.googleapis.com", UUID.randomUUID().toString(), 86400, bundle);
                this.Hw.post(new 3(this));
                break;
            } catch (Throwable e) {
                a.j6(e);
                try {
                    Thread.sleep(j);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                j = 2 * j;
            }
        }
    }

    private void FH(String str) {
        Editor edit = this.FH.getSharedPreferences("Gcm", 0).edit();
        edit.putString("GcmId", str);
        edit.commit();
    }

    private void gn() {
        Editor edit = this.FH.getSharedPreferences("Gcm", 0).edit();
        edit.putLong("GcmLastSent", System.currentTimeMillis());
        edit.commit();
    }

    public void j6(String str) {
        Editor edit = this.FH.getSharedPreferences("Gcm", 0).edit();
        edit.putString("GcmAcknowledgedId", str);
        edit.commit();
    }

    private boolean Hw(String str) {
        return new HashSet(this.FH.getSharedPreferences("Gcm", 0).getStringSet("GcmReceivedNotifications", Collections.emptySet())).contains(str);
    }

    private void v5(String str) {
        SharedPreferences sharedPreferences = this.FH.getSharedPreferences("Gcm", 0);
        Set hashSet = new HashSet(sharedPreferences.getStringSet("GcmReceivedNotifications", Collections.emptySet()));
        hashSet.add(str);
        Editor edit = sharedPreferences.edit();
        edit.putStringSet("GcmReceivedNotifications", hashSet);
        edit.commit();
    }

    public void DW(String str) {
    }

    public void j6(d dVar) {
        if (!Hw(dVar.j6)) {
            v5(dVar.j6);
            if (!dVar.Zo.before(new GregorianCalendar()) && this.v5 != null) {
                this.v5.j6(dVar);
            }
        }
    }
}
