package com.google.android.gms.p146b;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fd.C2885a;
import com.google.android.gms.p146b.fe.C3197a;
import com.google.android.gms.p151a.C2690b;
import com.google.android.gms.p151a.C2692c;

@gb
/* renamed from: com.google.android.gms.b.fi */
public final class fi extends C2692c<fe> {
    private static final fi f10910a;

    /* renamed from: com.google.android.gms.b.fi.a */
    private static final class C3201a extends Exception {
        public C3201a(String str) {
            super(str);
        }
    }

    static {
        f10910a = new fi();
    }

    private fi() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public static fd m12702a(Activity activity) {
        try {
            if (!fi.m12703b(activity)) {
                fd c = f10910a.m12704c(activity);
                if (c != null) {
                    return c;
                }
            }
            C2972b.m11576a("Using AdOverlay from the client jar.");
            return C2784w.m10744c().m10738a(activity);
        } catch (C3201a e) {
            C2972b.m11583d(e.getMessage());
            return null;
        }
    }

    private static boolean m12703b(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new C3201a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    private fd m12704c(Activity activity) {
        try {
            return C2885a.m11228a(((fe) m10264a(activity)).m12688a(C2690b.m10262a((Object) activity)));
        } catch (Throwable e) {
            C2972b.m11584d("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            C2972b.m11584d("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected fe m12705a(IBinder iBinder) {
        return C3197a.m12690a(iBinder);
    }

    protected /* synthetic */ Object m12706b(IBinder iBinder) {
        return m12705a(iBinder);
    }
}
