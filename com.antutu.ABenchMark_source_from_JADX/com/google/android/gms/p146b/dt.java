package com.google.android.gms.p146b;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.C2651c;
import com.google.ads.mediation.C2661h;
import com.google.ads.mediation.C2667i;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.mediation.C2633b;
import com.google.android.gms.ads.mediation.customevent.C2982a;
import com.google.android.gms.ads.mediation.customevent.C2984d;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.p146b.du.C3150a;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.dt */
public final class dt extends C3150a {
    private Map<Class<? extends Object>, Object> f10722a;

    private <NETWORK_EXTRAS extends C2667i, SERVER_PARAMETERS extends C2661h> dv m12360c(String str) {
        try {
            Class cls = Class.forName(str, false, dt.class.getClassLoader());
            if (C2651c.class.isAssignableFrom(cls)) {
                C2651c c2651c = (C2651c) cls.newInstance();
                return new eh(c2651c, (C2667i) this.f10722a.get(c2651c.m10229b()));
            } else if (C2633b.class.isAssignableFrom(cls)) {
                return new ec((C2633b) cls.newInstance());
            } else {
                C2972b.m11583d("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable th) {
            return m12361d(str);
        }
    }

    private dv m12361d(String str) {
        try {
            C2972b.m11576a("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new ec(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new ec(new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new ec(new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                C2651c customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new eh(customEventAdapter, (C2984d) this.f10722a.get(customEventAdapter.m10242b()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            C2972b.m11584d("Could not instantiate mediation adapter: " + str + ". ", th);
        }
    }

    public dv m12362a(String str) {
        return m12360c(str);
    }

    public void m12363a(Map<Class<? extends Object>, Object> map) {
        this.f10722a = map;
    }

    public boolean m12364b(String str) {
        boolean z = false;
        try {
            z = C2982a.class.isAssignableFrom(Class.forName(str, false, dt.class.getClassLoader()));
        } catch (Throwable th) {
            C2972b.m11583d("Could not load custom event implementation class: " + str + ", assuming old implementation.");
        }
        return z;
    }
}
