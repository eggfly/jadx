package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.stats.C3527b;
import com.google.android.gms.p146b.ff.C2888a;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.purchase.g */
public final class C2889g extends C2888a implements ServiceConnection {
    C2880b f9781a;
    private boolean f9782b;
    private Context f9783c;
    private int f9784d;
    private Intent f9785e;
    private C2887f f9786f;
    private String f9787g;

    public C2889g(Context context, String str, boolean z, int i, Intent intent, C2887f c2887f) {
        this.f9782b = false;
        this.f9787g = str;
        this.f9784d = i;
        this.f9785e = intent;
        this.f9782b = z;
        this.f9783c = context;
        this.f9786f = c2887f;
    }

    public boolean m11239a() {
        return this.f9782b;
    }

    public String m11240b() {
        return this.f9787g;
    }

    public Intent m11241c() {
        return this.f9785e;
    }

    public int m11242d() {
        return this.f9784d;
    }

    public void m11243e() {
        int a = C2968s.m11535o().m11253a(this.f9785e);
        if (this.f9784d == -1 && a == 0) {
            this.f9781a = new C2880b(this.f9783c);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            C3527b.m14718a().m14729a(this.f9783c, intent, (ServiceConnection) this, 1);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C2972b.m11581c("In-app billing service connected.");
        this.f9781a.m11204a(iBinder);
        String b = C2968s.m11535o().m11259b(C2968s.m11535o().m11258b(this.f9785e));
        if (b != null) {
            if (this.f9781a.m11201a(this.f9783c.getPackageName(), b) == 0) {
                C2891h.m11244a(this.f9783c).m11249a(this.f9786f);
            }
            C3527b.m14718a().m14727a(this.f9783c, (ServiceConnection) this);
            this.f9781a.m11203a();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C2972b.m11581c("In-app billing service disconnected.");
        this.f9781a.m11203a();
    }
}
