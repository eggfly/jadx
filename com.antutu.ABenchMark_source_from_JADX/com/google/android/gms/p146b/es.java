package com.google.android.gms.p146b;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.et.C2862a;
import com.google.android.gms.p146b.eu.C3175a;
import com.google.android.gms.p151a.C2690b;
import com.google.android.gms.p151a.C2692c;

@gb
/* renamed from: com.google.android.gms.b.es */
public final class es extends C2692c<eu> {
    private static final es f10823a;

    /* renamed from: com.google.android.gms.b.es.a */
    private static final class C3172a extends Exception {
        public C3172a(String str) {
            super(str);
        }
    }

    static {
        f10823a = new es();
    }

    private es() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static et m12637a(Activity activity) {
        try {
            if (!es.m12638b(activity)) {
                et c = f10823a.m12639c(activity);
                if (c != null) {
                    return c;
                }
            }
            C2972b.m11576a("Using AdOverlay from the client jar.");
            return C2784w.m10744c().m10740b(activity);
        } catch (C3172a e) {
            C2972b.m11583d(e.getMessage());
            return null;
        }
    }

    private static boolean m12638b(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C3172a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private et m12639c(Activity activity) {
        try {
            return C2862a.m11094a(((eu) m10264a(activity)).m12653a(C2690b.m10262a((Object) activity)));
        } catch (Throwable e) {
            C2972b.m11584d("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            C2972b.m11584d("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected eu m12640a(IBinder iBinder) {
        return C3175a.m12655a(iBinder);
    }

    protected /* synthetic */ Object m12641b(IBinder iBinder) {
        return m12640a(iBinder);
    }
}
