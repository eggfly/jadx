package com.google.android.gms.common.api.p155a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.C3444a.C3327b;
import com.google.android.gms.common.api.C3444a.C3388d;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;
import com.google.android.gms.common.api.p155a.C3398m.C3395a;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.p146b.kc;
import com.google.android.gms.p146b.kd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.api.a.j */
public class C3430j implements C3398m {
    final Map<C3388d<?>, C2924c> f11928a;
    final Map<C3388d<?>, ConnectionResult> f11929b;
    final C3477g f11930c;
    final Map<C3444a<?>, Integer> f11931d;
    final C3327b<? extends kc, kd> f11932e;
    int f11933f;
    final C3428h f11934g;
    final C3395a f11935h;
    private final Lock f11936i;
    private final Condition f11937j;
    private final Context f11938k;
    private final C3457f f11939l;
    private final C3429b f11940m;
    private volatile C3403i f11941n;
    private ConnectionResult f11942o;

    /* renamed from: com.google.android.gms.common.api.a.j.a */
    static abstract class C3400a {
        private final C3403i f11849a;

        protected C3400a(C3403i c3403i) {
            this.f11849a = c3403i;
        }

        protected abstract void m14026a();

        public final void m14027a(C3430j c3430j) {
            c3430j.f11936i.lock();
            try {
                if (c3430j.f11941n == this.f11849a) {
                    m14026a();
                    c3430j.f11936i.unlock();
                }
            } finally {
                c3430j.f11936i.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.j.b */
    final class C3429b extends Handler {
        final /* synthetic */ C3430j f11927a;

        C3429b(C3430j c3430j, Looper looper) {
            this.f11927a = c3430j;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    ((C3400a) message.obj).m14027a(this.f11927a);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
            }
        }
    }

    public C3430j(Context context, C3428h c3428h, Lock lock, Looper looper, C3457f c3457f, Map<C3388d<?>, C2924c> map, C3477g c3477g, Map<C3444a<?>, Integer> map2, C3327b<? extends kc, kd> c3327b, ArrayList<C3394c> arrayList, C3395a c3395a) {
        this.f11929b = new HashMap();
        this.f11942o = null;
        this.f11938k = context;
        this.f11936i = lock;
        this.f11939l = c3457f;
        this.f11928a = map;
        this.f11930c = c3477g;
        this.f11931d = map2;
        this.f11932e = c3327b;
        this.f11934g = c3428h;
        this.f11935h = c3395a;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C3394c) it.next()).m13979a(this);
        }
        this.f11940m = new C3429b(this, looper);
        this.f11937j = lock.newCondition();
        this.f11941n = new C3419g(this);
    }

    public <A extends C2924c, R extends C3386f, T extends C3307a<R, A>> T m14177a(T t) {
        return this.f11941n.m14030a((C3307a) t);
    }

    public void m14178a() {
        this.f11941n.m14037c();
    }

    public void m14179a(int i) {
        this.f11936i.lock();
        try {
            this.f11941n.m14032a(i);
        } finally {
            this.f11936i.unlock();
        }
    }

    public void m14180a(Bundle bundle) {
        this.f11936i.lock();
        try {
            this.f11941n.m14033a(bundle);
        } finally {
            this.f11936i.unlock();
        }
    }

    void m14181a(ConnectionResult connectionResult) {
        this.f11936i.lock();
        try {
            this.f11942o = connectionResult;
            this.f11941n = new C3419g(this);
            this.f11941n.m14031a();
            this.f11937j.signalAll();
        } finally {
            this.f11936i.unlock();
        }
    }

    public void m14182a(ConnectionResult connectionResult, C3444a<?> c3444a, int i) {
        this.f11936i.lock();
        try {
            this.f11941n.m14034a(connectionResult, c3444a, i);
        } finally {
            this.f11936i.unlock();
        }
    }

    void m14183a(C3400a c3400a) {
        this.f11940m.sendMessage(this.f11940m.obtainMessage(1, c3400a));
    }

    void m14184a(RuntimeException runtimeException) {
        this.f11940m.sendMessage(this.f11940m.obtainMessage(2, runtimeException));
    }

    public void m14185a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "  ";
        for (C3444a c3444a : this.f11931d.keySet()) {
            printWriter.append(str).append(c3444a.m14242e()).println(":");
            ((C2924c) this.f11928a.get(c3444a.m14240c())).m11350a(str2, fileDescriptor, printWriter, strArr);
        }
    }

    public <A extends C2924c, T extends C3307a<? extends C3386f, A>> T m14186b(T t) {
        return this.f11941n.m14035b(t);
    }

    public boolean m14187b() {
        boolean b = this.f11941n.m14036b();
        if (b) {
            this.f11929b.clear();
        }
        return b;
    }

    public boolean m14188c() {
        return this.f11941n instanceof C3404e;
    }

    public void m14189d() {
        if (m14188c()) {
            ((C3404e) this.f11941n).m14048d();
        }
    }

    void m14190e() {
        this.f11936i.lock();
        try {
            this.f11941n = new C3418f(this, this.f11930c, this.f11931d, this.f11939l, this.f11932e, this.f11936i, this.f11938k);
            this.f11941n.m14031a();
            this.f11937j.signalAll();
        } finally {
            this.f11936i.unlock();
        }
    }

    void m14191f() {
        this.f11936i.lock();
        try {
            this.f11934g.m14171h();
            this.f11941n = new C3404e(this);
            this.f11941n.m14031a();
            this.f11937j.signalAll();
        } finally {
            this.f11936i.unlock();
        }
    }

    void m14192g() {
        for (C2924c d : this.f11928a.values()) {
            d.m11351d();
        }
    }
}
