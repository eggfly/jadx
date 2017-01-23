package com.google.android.gms.common.api.p155a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3427c;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.C3444a.C3327b;
import com.google.android.gms.common.api.C3444a.C3388d;
import com.google.android.gms.common.api.C3450k;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;
import com.google.android.gms.common.api.p155a.C3398m.C3395a;
import com.google.android.gms.common.internal.C3477g;
import com.google.android.gms.common.internal.C3489j;
import com.google.android.gms.common.internal.C3489j.C2925a;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.kc;
import com.google.android.gms.p146b.kd;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.api.a.h */
public final class C3428h extends C3427c implements C3395a {
    final Queue<C3307a<?, ?>> f11901a;
    C3426c f11902b;
    final Map<C3388d<?>, C2924c> f11903c;
    Set<Scope> f11904d;
    final C3477g f11905e;
    final Map<C3444a<?>, Integer> f11906f;
    final C3327b<? extends kc, kd> f11907g;
    final Set<C3306e<?>> f11908h;
    Set<C3443s> f11909i;
    private final Lock f11910j;
    private final C3489j f11911k;
    private C3398m f11912l;
    private final int f11913m;
    private final Context f11914n;
    private final Looper f11915o;
    private volatile boolean f11916p;
    private long f11917q;
    private long f11918r;
    private final C3423a f11919s;
    private final C3457f f11920t;
    private final Set<C3432n<?>> f11921u;
    private C3450k f11922v;
    private final ArrayList<C3394c> f11923w;
    private Integer f11924x;
    private final C3420d f11925y;
    private final C2925a f11926z;

    /* renamed from: com.google.android.gms.common.api.a.h.e */
    interface C3306e<A extends C2924c> {
        Integer m13452a();

        void m13453a(Status status);

        void m13454a(A a);

        void m13455a(C3420d c3420d);

        C3388d<A> m13456b();

        void m13457b(Status status);

        void m13458c();

        boolean m13459e();

        void m13460f();

        void m13461g();
    }

    /* renamed from: com.google.android.gms.common.api.a.h.d */
    interface C3420d {
        void m14119a(C3306e<?> c3306e);
    }

    /* renamed from: com.google.android.gms.common.api.a.h.1 */
    class C34211 implements C3420d {
        final /* synthetic */ C3428h f11892a;

        C34211(C3428h c3428h) {
            this.f11892a = c3428h;
        }

        public void m14120a(C3306e<?> c3306e) {
            this.f11892a.f11908h.remove(c3306e);
            if (c3306e.m13452a() != null && this.f11892a.f11922v != null) {
                this.f11892a.f11922v.m14258a(c3306e.m13452a().intValue());
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.h.2 */
    class C34222 implements C2925a {
        final /* synthetic */ C3428h f11893a;

        C34222(C3428h c3428h) {
            this.f11893a = c3428h;
        }

        public boolean m14121e() {
            return this.f11893a.m14168e();
        }

        public Bundle e_() {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.h.a */
    final class C3423a extends Handler {
        final /* synthetic */ C3428h f11894a;

        C3423a(C3428h c3428h, Looper looper) {
            this.f11894a = c3428h;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.f11894a.m14150n();
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    this.f11894a.m14149m();
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.h.b */
    private static class C3424b implements DeathRecipient, C3420d {
        private final WeakReference<C3306e<?>> f11895a;
        private final WeakReference<C3450k> f11896b;
        private final WeakReference<IBinder> f11897c;

        private C3424b(C3306e c3306e, C3450k c3450k, IBinder iBinder) {
            this.f11896b = new WeakReference(c3450k);
            this.f11895a = new WeakReference(c3306e);
            this.f11897c = new WeakReference(iBinder);
        }

        private void m14122a() {
            C3306e c3306e = (C3306e) this.f11895a.get();
            C3450k c3450k = (C3450k) this.f11896b.get();
            if (!(c3450k == null || c3306e == null)) {
                c3450k.m14258a(c3306e.m13452a().intValue());
            }
            IBinder iBinder = (IBinder) this.f11897c.get();
            if (this.f11897c != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void m14123a(C3306e<?> c3306e) {
            m14122a();
        }

        public void binderDied() {
            m14122a();
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.h.c */
    static class C3426c extends C3425l {
        private WeakReference<C3428h> f11899b;

        C3426c(C3428h c3428h) {
            this.f11899b = new WeakReference(c3428h);
        }

        public void m14127a() {
            C3428h c3428h = (C3428h) this.f11899b.get();
            if (c3428h != null) {
                c3428h.m14149m();
            }
        }
    }

    public C3428h(Context context, Lock lock, Looper looper, C3477g c3477g, C3457f c3457f, C3327b<? extends kc, kd> c3327b, Map<C3444a<?>, Integer> map, List<C2921b> list, List<C2922c> list2, Map<C3388d<?>, C2924c> map2, int i, int i2, ArrayList<C3394c> arrayList) {
        this.f11912l = null;
        this.f11901a = new LinkedList();
        this.f11917q = 120000;
        this.f11918r = 5000;
        this.f11904d = new HashSet();
        this.f11921u = Collections.newSetFromMap(new WeakHashMap());
        this.f11908h = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
        this.f11924x = null;
        this.f11909i = null;
        this.f11925y = new C34211(this);
        this.f11926z = new C34222(this);
        this.f11914n = context;
        this.f11910j = lock;
        this.f11911k = new C3489j(looper, this.f11926z);
        this.f11915o = looper;
        this.f11919s = new C3423a(this, looper);
        this.f11920t = c3457f;
        this.f11913m = i;
        if (this.f11913m >= 0) {
            this.f11924x = Integer.valueOf(i2);
        }
        this.f11906f = map;
        this.f11903c = map2;
        this.f11923w = arrayList;
        for (C2921b a : list) {
            this.f11911k.m14384a(a);
        }
        for (C2922c a2 : list2) {
            this.f11911k.m14385a(a2);
        }
        this.f11905e = c3477g;
        this.f11907g = c3327b;
    }

    public static int m14141a(Iterable<C2924c> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (C2924c c2924c : iterable) {
            if (c2924c.m11353f()) {
                i2 = 1;
            }
            i = c2924c.m11354g() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    private static void m14143a(C3306e<?> c3306e, C3450k c3450k, IBinder iBinder) {
        if (c3306e.m13459e()) {
            c3306e.m13455a(new C3424b(c3450k, iBinder, null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            c3306e.m13455a(null);
            c3306e.m13460f();
            c3450k.m14258a(c3306e.m13452a().intValue());
        } else {
            C3420d c3424b = new C3424b(c3450k, iBinder, null);
            c3306e.m13455a(c3424b);
            try {
                iBinder.linkToDeath(c3424b, 0);
            } catch (RemoteException e) {
                c3306e.m13460f();
                c3450k.m14258a(c3306e.m13452a().intValue());
            }
        }
    }

    static String m14144b(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return "SIGN_IN_MODE_REQUIRED";
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return "SIGN_IN_MODE_OPTIONAL";
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void m14146c(int i) {
        if (this.f11924x == null) {
            this.f11924x = Integer.valueOf(i);
        } else if (this.f11924x.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + C3428h.m14144b(i) + ". Mode was already set to " + C3428h.m14144b(this.f11924x.intValue()));
        }
        if (this.f11912l == null) {
            Object obj = null;
            Object obj2 = null;
            for (C2924c c2924c : this.f11903c.values()) {
                if (c2924c.m11353f()) {
                    obj2 = 1;
                }
                obj = c2924c.m11354g() ? 1 : obj;
            }
            switch (this.f11924x.intValue()) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (obj2 != null) {
                        this.f11912l = new C3399d(this.f11914n, this, this.f11910j, this.f11915o, this.f11920t, this.f11903c, this.f11905e, this.f11906f, this.f11907g, this.f11923w);
                        return;
                    }
                    break;
            }
            this.f11912l = new C3430j(this.f11914n, this, this.f11910j, this.f11915o, this.f11920t, this.f11903c, this.f11905e, this.f11906f, this.f11907g, this.f11923w, this);
        }
    }

    private void m14148l() {
        this.f11911k.m14386b();
        this.f11912l.m13990a();
    }

    private void m14149m() {
        this.f11910j.lock();
        try {
            if (m14169f()) {
                m14148l();
            }
            this.f11910j.unlock();
        } catch (Throwable th) {
            this.f11910j.unlock();
        }
    }

    private void m14150n() {
        this.f11910j.lock();
        try {
            if (m14171h()) {
                m14148l();
            }
            this.f11910j.unlock();
        } catch (Throwable th) {
            this.f11910j.unlock();
        }
    }

    public Looper m14151a() {
        return this.f11915o;
    }

    public <C extends C2924c> C m14152a(C3388d<C> c3388d) {
        Object obj = (C2924c) this.f11903c.get(c3388d);
        C3512u.m14581a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends C2924c, R extends C3386f, T extends C3307a<R, A>> T m14153a(T t) {
        C3512u.m14589b(t.m13466b() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        C3512u.m14589b(this.f11903c.containsKey(t.m13466b()), "GoogleApiClient is not configured to use the API required for this call.");
        this.f11910j.lock();
        try {
            if (this.f11912l == null) {
                this.f11901a.add(t);
            } else {
                t = this.f11912l.m13989a(t);
                this.f11910j.unlock();
            }
            return t;
        } finally {
            this.f11910j.unlock();
        }
    }

    public void m14154a(int i) {
        boolean z = true;
        this.f11910j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            C3512u.m14589b(z, "Illegal sign-in mode: " + i);
            m14146c(i);
            m14148l();
        } finally {
            this.f11910j.unlock();
        }
    }

    public void m14155a(int i, boolean z) {
        if (i == 1 && !z) {
            m14170g();
        }
        for (C3306e c3306e : this.f11908h) {
            if (z) {
                c3306e.m13458c();
            }
            c3306e.m13457b(new Status(8, "The connection to Google Play services was lost"));
        }
        this.f11908h.clear();
        this.f11911k.m14381a(i);
        this.f11911k.m14380a();
        if (i == 2) {
            m14148l();
        }
    }

    public void m14156a(Bundle bundle) {
        while (!this.f11901a.isEmpty()) {
            m14163b((C3307a) this.f11901a.remove());
        }
        this.f11911k.m14382a(bundle);
    }

    public void m14157a(ConnectionResult connectionResult) {
        if (!this.f11920t.m14274a(this.f11914n, connectionResult.m13953c())) {
            m14171h();
        }
        if (!m14169f()) {
            this.f11911k.m14383a(connectionResult);
            this.f11911k.m14380a();
        }
    }

    <A extends C2924c> void m14158a(C3306e<A> c3306e) {
        this.f11908h.add(c3306e);
        c3306e.m13455a(this.f11925y);
    }

    public void m14159a(C3443s c3443s) {
        this.f11910j.lock();
        try {
            if (this.f11909i == null) {
                this.f11909i = new HashSet();
            }
            this.f11909i.add(c3443s);
        } finally {
            this.f11910j.unlock();
        }
    }

    public void m14160a(C2922c c2922c) {
        this.f11911k.m14385a(c2922c);
    }

    public void m14161a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f11914n);
        printWriter.append(str).append("mResuming=").print(this.f11916p);
        printWriter.append(" mWorkQueue.size()=").print(this.f11901a.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.f11908h.size());
        if (this.f11912l != null) {
            this.f11912l.m13991a(str, fileDescriptor, printWriter, strArr);
        }
    }

    void m14162a(boolean z) {
        for (C3306e c3306e : this.f11908h) {
            if (c3306e.m13452a() != null) {
                c3306e.m13458c();
                C3428h.m14143a(c3306e, this.f11922v, m14152a(c3306e.m13456b()).m11356i());
                this.f11908h.remove(c3306e);
            } else if (z) {
                c3306e.m13461g();
            } else {
                c3306e.m13460f();
                this.f11908h.remove(c3306e);
            }
        }
    }

    public <A extends C2924c, T extends C3307a<? extends C3386f, A>> T m14163b(T t) {
        C3512u.m14589b(t.m13466b() != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.f11910j.lock();
        try {
            if (this.f11912l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (m14169f()) {
                this.f11901a.add(t);
                while (!this.f11901a.isEmpty()) {
                    C3306e c3306e = (C3306e) this.f11901a.remove();
                    m14158a(c3306e);
                    c3306e.m13453a(Status.f11823c);
                }
            } else {
                t = this.f11912l.m13992b(t);
                this.f11910j.unlock();
            }
            return t;
        } finally {
            this.f11910j.unlock();
        }
    }

    public void m14164b() {
        boolean z = false;
        this.f11910j.lock();
        try {
            if (this.f11913m >= 0) {
                if (this.f11924x != null) {
                    z = true;
                }
                C3512u.m14585a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f11924x == null) {
                this.f11924x = Integer.valueOf(C3428h.m14141a(this.f11903c.values(), false));
            } else if (this.f11924x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m14154a(this.f11924x.intValue());
        } finally {
            this.f11910j.unlock();
        }
    }

    public void m14165b(C3443s c3443s) {
        this.f11910j.lock();
        try {
            if (this.f11909i == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f11909i.remove(c3443s)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m14172i()) {
                this.f11912l.m13995d();
            }
            this.f11910j.unlock();
        } catch (Throwable th) {
            this.f11910j.unlock();
        }
    }

    public void m14166b(C2922c c2922c) {
        this.f11911k.m14387b(c2922c);
    }

    public void m14167c() {
        this.f11910j.lock();
        try {
            boolean z = (this.f11912l == null || this.f11912l.m13993b()) ? false : true;
            m14162a(z);
            for (C3432n a : this.f11921u) {
                a.m14194a();
            }
            this.f11921u.clear();
            for (C3306e c3306e : this.f11901a) {
                c3306e.m13455a(null);
                c3306e.m13460f();
            }
            this.f11901a.clear();
            if (this.f11912l != null) {
                m14171h();
                this.f11911k.m14380a();
                this.f11910j.unlock();
            }
        } finally {
            this.f11910j.unlock();
        }
    }

    public boolean m14168e() {
        return this.f11912l != null && this.f11912l.m13994c();
    }

    boolean m14169f() {
        return this.f11916p;
    }

    void m14170g() {
        if (!m14169f()) {
            this.f11916p = true;
            if (this.f11902b == null) {
                this.f11902b = (C3426c) C3425l.m14124a(this.f11914n.getApplicationContext(), new C3426c(this), this.f11920t);
            }
            this.f11919s.sendMessageDelayed(this.f11919s.obtainMessage(1), this.f11917q);
            this.f11919s.sendMessageDelayed(this.f11919s.obtainMessage(2), this.f11918r);
        }
    }

    boolean m14171h() {
        if (!m14169f()) {
            return false;
        }
        this.f11916p = false;
        this.f11919s.removeMessages(2);
        this.f11919s.removeMessages(1);
        if (this.f11902b != null) {
            this.f11902b.m14126b();
            this.f11902b = null;
        }
        return true;
    }

    boolean m14172i() {
        boolean z = false;
        this.f11910j.lock();
        try {
            if (this.f11909i != null) {
                if (!this.f11909i.isEmpty()) {
                    z = true;
                }
                this.f11910j.unlock();
            }
            return z;
        } finally {
            this.f11910j.unlock();
        }
    }

    String m14173j() {
        Writer stringWriter = new StringWriter();
        m14161a(BuildConfig.FLAVOR, null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public int m14174k() {
        return System.identityHashCode(this);
    }
}
