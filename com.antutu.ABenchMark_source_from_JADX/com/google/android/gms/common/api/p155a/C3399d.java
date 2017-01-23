package com.google.android.gms.common.api.p155a;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.C3444a.C3327b;
import com.google.android.gms.common.api.C3444a.C3388d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;
import com.google.android.gms.common.api.p155a.C3398m.C3395a;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.kc;
import com.google.android.gms.p146b.kd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.api.a.d */
public class C3399d implements C3398m {
    private final Context f11835a;
    private final C3428h f11836b;
    private final Looper f11837c;
    private final C3430j f11838d;
    private final C3430j f11839e;
    private final Map<C3388d<?>, C3430j> f11840f;
    private final Set<C3435q> f11841g;
    private final C2924c f11842h;
    private Bundle f11843i;
    private ConnectionResult f11844j;
    private ConnectionResult f11845k;
    private boolean f11846l;
    private final Lock f11847m;
    private int f11848n;

    /* renamed from: com.google.android.gms.common.api.a.d.1 */
    class C33961 implements C3395a {
        final /* synthetic */ C3399d f11833a;

        C33961(C3399d c3399d) {
            this.f11833a = c3399d;
        }

        public void m13983a(int i, boolean z) {
            this.f11833a.f11847m.lock();
            try {
                if (this.f11833a.f11846l || this.f11833a.f11845k == null || !this.f11833a.f11845k.m13952b()) {
                    this.f11833a.f11846l = false;
                    this.f11833a.m13998a(i, z);
                    return;
                }
                this.f11833a.f11846l = true;
                this.f11833a.f11839e.m14179a(i);
                this.f11833a.f11847m.unlock();
            } finally {
                this.f11833a.f11847m.unlock();
            }
        }

        public void m13984a(Bundle bundle) {
            this.f11833a.f11847m.lock();
            try {
                this.f11833a.m13999a(bundle);
                this.f11833a.f11844j = ConnectionResult.f11813a;
                this.f11833a.m14013g();
            } finally {
                this.f11833a.f11847m.unlock();
            }
        }

        public void m13985a(ConnectionResult connectionResult) {
            this.f11833a.f11847m.lock();
            try {
                this.f11833a.f11844j = connectionResult;
                this.f11833a.m14013g();
            } finally {
                this.f11833a.f11847m.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.d.2 */
    class C33972 implements C3395a {
        final /* synthetic */ C3399d f11834a;

        C33972(C3399d c3399d) {
            this.f11834a = c3399d;
        }

        public void m13986a(int i, boolean z) {
            this.f11834a.f11847m.lock();
            try {
                if (this.f11834a.f11846l) {
                    this.f11834a.f11846l = false;
                    this.f11834a.m13998a(i, z);
                    return;
                }
                this.f11834a.f11846l = true;
                this.f11834a.f11838d.m14179a(i);
                this.f11834a.f11847m.unlock();
            } finally {
                this.f11834a.f11847m.unlock();
            }
        }

        public void m13987a(Bundle bundle) {
            this.f11834a.f11847m.lock();
            try {
                this.f11834a.f11845k = ConnectionResult.f11813a;
                this.f11834a.m14013g();
            } finally {
                this.f11834a.f11847m.unlock();
            }
        }

        public void m13988a(ConnectionResult connectionResult) {
            this.f11834a.f11847m.lock();
            try {
                this.f11834a.f11845k = connectionResult;
                this.f11834a.m14013g();
            } finally {
                this.f11834a.f11847m.unlock();
            }
        }
    }

    public C3399d(Context context, C3428h c3428h, Lock lock, Looper looper, C3457f c3457f, Map<C3388d<?>, C2924c> map, C3477g c3477g, Map<C3444a<?>, Integer> map2, C3327b<? extends kc, kd> c3327b, ArrayList<C3394c> arrayList) {
        this.f11840f = new ArrayMap();
        this.f11841g = Collections.newSetFromMap(new WeakHashMap());
        this.f11844j = null;
        this.f11845k = null;
        this.f11846l = false;
        this.f11848n = 0;
        this.f11835a = context;
        this.f11836b = c3428h;
        this.f11847m = lock;
        this.f11837c = looper;
        C2924c c2924c = null;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        for (C3388d c3388d : map.keySet()) {
            C2924c c2924c2 = (C2924c) map.get(c3388d);
            if (c2924c2.m11354g()) {
                c2924c = c2924c2;
            }
            if (c2924c2.m11353f()) {
                arrayMap.put(c3388d, c2924c2);
            } else {
                arrayMap2.put(c3388d, c2924c2);
            }
        }
        this.f11842h = c2924c;
        if (arrayMap.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (C3444a c3444a : map2.keySet()) {
            C3388d c = c3444a.m14240c();
            if (arrayMap.containsKey(c)) {
                arrayMap3.put(c3444a, map2.get(c3444a));
            } else if (arrayMap2.containsKey(c)) {
                arrayMap4.put(c3444a, map2.get(c3444a));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C3394c c3394c = (C3394c) it.next();
            if (arrayMap3.containsKey(c3394c.f11830a)) {
                arrayList2.add(c3394c);
            } else if (arrayMap4.containsKey(c3394c.f11830a)) {
                arrayList3.add(c3394c);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        Context context2 = context;
        this.f11838d = new C3430j(context2, this.f11836b, lock, looper, c3457f, arrayMap2, null, arrayMap4, null, arrayList3, new C33961(this));
        Context context3 = context;
        this.f11839e = new C3430j(context3, this.f11836b, lock, looper, c3457f, arrayMap, c3477g, arrayMap3, c3327b, arrayList2, new C33972(this));
        for (C3388d c3388d2 : arrayMap2.keySet()) {
            this.f11840f.put(c3388d2, this.f11838d);
        }
        for (C3388d c3388d22 : arrayMap.keySet()) {
            this.f11840f.put(c3388d22, this.f11839e);
        }
    }

    private void m13998a(int i, boolean z) {
        this.f11836b.m14155a(i, z);
        this.f11845k = null;
        this.f11844j = null;
    }

    private void m13999a(Bundle bundle) {
        if (this.f11843i == null) {
            this.f11843i = bundle;
        } else if (bundle != null) {
            this.f11843i.putAll(bundle);
        }
    }

    private void m14000a(ConnectionResult connectionResult) {
        switch (this.f11848n) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f11836b.m14157a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m14015i();
        this.f11848n = 0;
    }

    private static boolean m14006b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.m13952b();
    }

    private boolean m14007c(C3307a<? extends C3386f, ? extends C2924c> c3307a) {
        C3388d b = c3307a.m13466b();
        C3512u.m14589b(this.f11840f.containsKey(b), "GoogleApiClient is not configured to use the API required for this call.");
        return ((C3430j) this.f11840f.get(b)).equals(this.f11839e);
    }

    private void m14012f() {
        this.f11845k = null;
        this.f11844j = null;
        this.f11838d.m14178a();
        this.f11839e.m14178a();
    }

    private void m14013g() {
        if (C3399d.m14006b(this.f11844j)) {
            if (C3399d.m14006b(this.f11845k) || m14016j()) {
                m14014h();
            } else if (this.f11845k == null) {
            } else {
                if (this.f11848n == 1) {
                    m14015i();
                    return;
                }
                m14000a(this.f11845k);
                this.f11838d.m14187b();
            }
        } else if (this.f11844j != null && C3399d.m14006b(this.f11845k)) {
            this.f11839e.m14187b();
            m14000a(this.f11844j);
        } else if (this.f11844j != null && this.f11845k != null) {
            ConnectionResult connectionResult = this.f11844j;
            if (this.f11839e.f11933f < this.f11838d.f11933f) {
                connectionResult = this.f11845k;
            }
            m14000a(connectionResult);
        }
    }

    private void m14014h() {
        switch (this.f11848n) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f11836b.m14156a(this.f11843i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m14015i();
        this.f11848n = 0;
    }

    private void m14015i() {
        for (C3435q a : this.f11841g) {
            a.m14200a();
        }
        this.f11841g.clear();
    }

    private boolean m14016j() {
        return this.f11845k != null && this.f11845k.m13953c() == 4;
    }

    private PendingIntent m14017k() {
        return this.f11842h == null ? null : PendingIntent.getActivity(this.f11835a, this.f11836b.m14174k(), this.f11842h.m11355h(), 134217728);
    }

    public <A extends C2924c, R extends C3386f, T extends C3307a<R, A>> T m14018a(T t) {
        if (!m14007c((C3307a) t)) {
            return this.f11838d.m14177a((C3307a) t);
        }
        if (!m14016j()) {
            return this.f11839e.m14177a((C3307a) t);
        }
        t.m13463a(new Status(4, null, m14017k()));
        return t;
    }

    public void m14019a() {
        this.f11848n = 2;
        this.f11846l = false;
        m14012f();
    }

    public void m14020a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f11839e.m14185a(str + "  ", fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f11838d.m14185a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public <A extends C2924c, T extends C3307a<? extends C3386f, A>> T m14021b(T t) {
        if (!m14007c((C3307a) t)) {
            return this.f11838d.m14186b((C3307a) t);
        }
        if (!m14016j()) {
            return this.f11839e.m14186b((C3307a) t);
        }
        t.m13463a(new Status(4, null, m14017k()));
        return t;
    }

    public boolean m14022b() {
        this.f11845k = null;
        this.f11844j = null;
        this.f11848n = 0;
        boolean b = this.f11838d.m14187b();
        boolean b2 = this.f11839e.m14187b();
        m14015i();
        return b && b2;
    }

    public boolean m14023c() {
        boolean z = true;
        this.f11847m.lock();
        try {
            if (!(this.f11838d.m14188c() && (m14025e() || m14016j() || this.f11848n == 1))) {
                z = false;
            }
            this.f11847m.unlock();
            return z;
        } catch (Throwable th) {
            this.f11847m.unlock();
        }
    }

    public void m14024d() {
        this.f11838d.m14189d();
        this.f11839e.m14189d();
    }

    public boolean m14025e() {
        return this.f11839e.m14188c();
    }
}
