package com.google.android.gms.internal;

import aes;
import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.c;
import com.google.ads.mediation.h;
import com.google.ads.mediation.i;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.d;
import com.google.android.gms.internal.cr.a;
import java.util.Map;

@eh
public final class cp extends a {
    private Map<Class<? extends Object>, Object> j6;

    private <NETWORK_EXTRAS extends i, SERVER_PARAMETERS extends h> cs FH(String str) {
        try {
            Class cls = Class.forName(str, false, cp.class.getClassLoader());
            if (c.class.isAssignableFrom(cls)) {
                c cVar = (c) cls.newInstance();
                return new dd(cVar, (i) this.j6.get(cVar.DW()));
            } else if (aes.class.isAssignableFrom(cls)) {
                return new cy((aes) cls.newInstance());
            } else {
                b.Hw(new StringBuilder(String.valueOf(str).length() + 64).append("Could not instantiate mediation adapter: ").append(str).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        } catch (Throwable th) {
            return Hw(str);
        }
    }

    private cs Hw(String str) {
        try {
            b.j6("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new cy(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new cy(new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new cy(new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                c customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new dd(customEventAdapter, (d) this.j6.get(customEventAdapter.DW()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            b.FH(new StringBuilder(String.valueOf(str).length() + 43).append("Could not instantiate mediation adapter: ").append(str).append(". ").toString(), th);
        }
    }

    public boolean DW(String str) {
        boolean z = false;
        try {
            z = com.google.android.gms.ads.mediation.customevent.a.class.isAssignableFrom(Class.forName(str, false, cp.class.getClassLoader()));
        } catch (Throwable th) {
            b.Hw(new StringBuilder(String.valueOf(str).length() + 80).append("Could not load custom event implementation class: ").append(str).append(", assuming old implementation.").toString());
        }
        return z;
    }

    public cs j6(String str) {
        return FH(str);
    }

    public void j6(Map<Class<? extends Object>, Object> map) {
        this.j6 = map;
    }
}
