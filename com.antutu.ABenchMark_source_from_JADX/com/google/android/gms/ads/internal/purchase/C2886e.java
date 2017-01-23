package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fb;
import com.google.android.gms.p146b.fd.C2885a;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.purchase.e */
public class C2886e extends C2885a implements ServiceConnection {
    C2891h f9769a;
    private final Activity f9770b;
    private Context f9771c;
    private fb f9772d;
    private C2880b f9773e;
    private C2887f f9774f;
    private C2736j f9775g;
    private C2894k f9776h;
    private String f9777i;

    public C2886e(Activity activity) {
        this.f9777i = null;
        this.f9770b = activity;
        this.f9769a = C2891h.m11244a(this.f9770b.getApplicationContext());
    }

    public void m11229a() {
        GInAppPurchaseManagerInfoParcel a = GInAppPurchaseManagerInfoParcel.m11191a(this.f9770b.getIntent());
        this.f9775g = a.f9750e;
        this.f9776h = a.f9747b;
        this.f9772d = a.f9748c;
        this.f9773e = new C2880b(this.f9770b.getApplicationContext());
        this.f9771c = a.f9749d;
        if (this.f9770b.getResources().getConfiguration().orientation == 2) {
            this.f9770b.setRequestedOrientation(C2968s.m11527g().m13075a());
        } else {
            this.f9770b.setRequestedOrientation(C2968s.m11527g().m13089b());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.f9770b.bindService(intent, this, 1);
    }

    public void m11230a(int i, int i2, Intent intent) {
        if (i == AdError.NO_FILL_ERROR_CODE) {
            boolean z = false;
            try {
                int a = C2968s.m11535o().m11253a(intent);
                if (i2 == -1) {
                    C2968s.m11535o();
                    if (a == 0) {
                        if (this.f9776h.m11262a(this.f9777i, i2, intent)) {
                            z = true;
                        }
                        this.f9772d.m11217c(a);
                        this.f9770b.finish();
                        m11231a(this.f9772d.m11215a(), z, i2, intent);
                    }
                }
                this.f9769a.m11249a(this.f9774f);
                this.f9772d.m11217c(a);
                this.f9770b.finish();
                m11231a(this.f9772d.m11215a(), z, i2, intent);
            } catch (RemoteException e) {
                C2972b.m11583d("Fail to process purchase result.");
                this.f9770b.finish();
            } finally {
                this.f9777i = null;
            }
        }
    }

    protected void m11231a(String str, boolean z, int i, Intent intent) {
        if (this.f9775g != null) {
            this.f9775g.m10466a(str, z, i, intent, this.f9774f);
        }
    }

    public void m11232b() {
        this.f9770b.unbindService(this);
        this.f9773e.m11203a();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Throwable e;
        this.f9773e.m11204a(iBinder);
        try {
            this.f9777i = this.f9776h.m11261a();
            Bundle a = this.f9773e.m11202a(this.f9770b.getPackageName(), this.f9772d.m11215a(), this.f9777i);
            PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int a2 = C2968s.m11535o().m11254a(a);
                this.f9772d.m11217c(a2);
                m11231a(this.f9772d.m11215a(), false, a2, null);
                this.f9770b.finish();
                return;
            }
            this.f9774f = new C2887f(this.f9772d.m11215a(), this.f9777i);
            this.f9769a.m11251b(this.f9774f);
            this.f9770b.startIntentSenderForResult(pendingIntent.getIntentSender(), AdError.NO_FILL_ERROR_CODE, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            C2972b.m11584d("Error when connecting in-app billing service", e);
            this.f9770b.finish();
        } catch (SendIntentException e3) {
            e = e3;
            C2972b.m11584d("Error when connecting in-app billing service", e);
            this.f9770b.finish();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C2972b.m11581c("In-app billing service disconnected.");
        this.f9773e.m11203a();
    }
}
