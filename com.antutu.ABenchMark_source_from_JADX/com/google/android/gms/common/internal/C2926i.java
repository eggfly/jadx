package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3427c.C2921b;
import com.google.android.gms.common.api.C3427c.C2922c;
import com.google.android.gms.common.api.C3427c.C3406d;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.C3445b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C3482p.C3483a;
import com.google.android.gms.common.internal.C3489j.C2925a;
import com.google.android.gms.common.internal.C3499q.C3501a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.android.gms.common.internal.i */
public abstract class C2926i<T extends IInterface> implements C2924c, C2925a {
    public static final String[] f9953d;
    private int f9954a;
    final Handler f9955b;
    protected AtomicInteger f9956c;
    private long f9957e;
    private long f9958f;
    private int f9959g;
    private long f9960h;
    private final Context f9961i;
    private final C3477g f9962j;
    private final Looper f9963k;
    private final C3490k f9964l;
    private final C3457f f9965m;
    private final Object f9966n;
    private final Object f9967o;
    private C3499q f9968p;
    private C3406d f9969q;
    private T f9970r;
    private final ArrayList<C3479c<?>> f9971s;
    private C3485e f9972t;
    private int f9973u;
    private final Set<Scope> f9974v;
    private final Account f9975w;
    private final C2921b f9976x;
    private final C2922c f9977y;
    private final int f9978z;

    /* renamed from: com.google.android.gms.common.internal.i.c */
    protected abstract class C3479c<TListener> {
        private TListener f12068a;
        private boolean f12069b;
        final /* synthetic */ C2926i f12070d;

        public C3479c(C2926i c2926i, TListener tListener) {
            this.f12070d = c2926i;
            this.f12068a = tListener;
            this.f12069b = false;
        }

        protected abstract void m14357a(TListener tListener);

        protected abstract void m14358b();

        public void m14359c() {
            synchronized (this) {
                Object obj = this.f12068a;
                if (this.f12069b) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    m14357a(obj);
                } catch (RuntimeException e) {
                    m14358b();
                    throw e;
                }
            }
            m14358b();
            synchronized (this) {
                this.f12069b = true;
            }
            m14360d();
        }

        public void m14360d() {
            m14361e();
            synchronized (this.f12070d.f9971s) {
                this.f12070d.f9971s.remove(this);
            }
        }

        public void m14361e() {
            synchronized (this) {
                this.f12068a = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.i.a */
    private abstract class C3480a extends C3479c<Boolean> {
        public final int f12071a;
        public final Bundle f12072b;
        final /* synthetic */ C2926i f12073c;

        protected C3480a(C2926i c2926i, int i, Bundle bundle) {
            this.f12073c = c2926i;
            super(c2926i, Boolean.valueOf(true));
            this.f12071a = i;
            this.f12072b = bundle;
        }

        protected abstract void m14362a(ConnectionResult connectionResult);

        protected void m14363a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.f12073c.m11365b(1, null);
                return;
            }
            switch (this.f12071a) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    if (!m14365a()) {
                        this.f12073c.m11365b(1, null);
                        m14362a(new ConnectionResult(8, null));
                    }
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    this.f12073c.m11365b(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.f12073c.m11365b(1, null);
                    if (this.f12072b != null) {
                        pendingIntent = (PendingIntent) this.f12072b.getParcelable("pendingIntent");
                    }
                    m14362a(new ConnectionResult(this.f12071a, pendingIntent));
            }
        }

        protected /* synthetic */ void m14364a(Object obj) {
            m14363a((Boolean) obj);
        }

        protected abstract boolean m14365a();

        protected void m14366b() {
        }
    }

    /* renamed from: com.google.android.gms.common.internal.i.b */
    final class C3481b extends Handler {
        final /* synthetic */ C2926i f12074a;

        public C3481b(C2926i c2926i, Looper looper) {
            this.f12074a = c2926i;
            super(looper);
        }

        private void m14367a(Message message) {
            C3479c c3479c = (C3479c) message.obj;
            c3479c.m14358b();
            c3479c.m14360d();
        }

        private boolean m14368b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            if (this.f12074a.f9956c.get() != message.arg1) {
                if (m14368b(message)) {
                    m14367a(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !this.f12074a.m11393l()) {
                m14367a(message);
            } else if (message.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, null);
                this.f12074a.f9969q.m14049a(connectionResult);
                this.f12074a.m11379a(connectionResult);
            } else if (message.what == 4) {
                this.f12074a.m11365b(4, null);
                if (this.f12074a.f9976x != null) {
                    this.f12074a.f9976x.m11337a(message.arg2);
                }
                this.f12074a.m11374a(message.arg2);
                this.f12074a.m11361a(4, 1, null);
            } else if (message.what == 2 && !this.f12074a.m11387e()) {
                m14367a(message);
            } else if (m14368b(message)) {
                ((C3479c) message.obj).m14359c();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.i.d */
    public static final class C3484d extends C3483a {
        private C2926i f12075a;
        private final int f12076b;

        public C3484d(C2926i c2926i, int i) {
            this.f12075a = c2926i;
            this.f12076b = i;
        }

        private void m14372a() {
            this.f12075a = null;
        }

        public void m14373a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public void m14374a(int i, IBinder iBinder, Bundle bundle) {
            C3512u.m14581a(this.f12075a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f12075a.m11376a(i, iBinder, bundle, this.f12076b);
            m14372a();
        }
    }

    /* renamed from: com.google.android.gms.common.internal.i.e */
    public final class C3485e implements ServiceConnection {
        final /* synthetic */ C2926i f12077a;
        private final int f12078b;

        public C3485e(C2926i c2926i, int i) {
            this.f12077a = c2926i;
            this.f12078b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C3512u.m14581a((Object) iBinder, (Object) "Expecting a valid IBinder");
            synchronized (this.f12077a.f9967o) {
                this.f12077a.f9968p = C3501a.m14512a(iBinder);
            }
            this.f12077a.m11375a(0, this.f12078b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.f12077a.f9967o) {
                this.f12077a.f9968p = null;
            }
            this.f12077a.f9955b.sendMessage(this.f12077a.f9955b.obtainMessage(4, this.f12078b, 1));
        }
    }

    /* renamed from: com.google.android.gms.common.internal.i.f */
    protected class C3486f implements C3406d {
        final /* synthetic */ C2926i f12079a;

        public C3486f(C2926i c2926i) {
            this.f12079a = c2926i;
        }

        public void m14375a(ConnectionResult connectionResult) {
            if (connectionResult.m13952b()) {
                this.f12079a.m11381a(null, this.f12079a.f9974v);
            } else if (this.f12079a.f9977y != null) {
                this.f12079a.f9977y.m11339a(connectionResult);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.i.g */
    protected final class C3487g extends C3480a {
        public final IBinder f12080e;
        final /* synthetic */ C2926i f12081f;

        public C3487g(C2926i c2926i, int i, IBinder iBinder, Bundle bundle) {
            this.f12081f = c2926i;
            super(c2926i, i, bundle);
            this.f12080e = iBinder;
        }

        protected void m14376a(ConnectionResult connectionResult) {
            if (this.f12081f.f9977y != null) {
                this.f12081f.f9977y.m11339a(connectionResult);
            }
            this.f12081f.m11379a(connectionResult);
        }

        protected boolean m14377a() {
            try {
                String interfaceDescriptor = this.f12080e.getInterfaceDescriptor();
                if (this.f12081f.m11384b().equals(interfaceDescriptor)) {
                    IInterface b = this.f12081f.m11383b(this.f12080e);
                    if (b == null || !this.f12081f.m11361a(2, 3, b)) {
                        return false;
                    }
                    Bundle e_ = this.f12081f.e_();
                    if (this.f12081f.f9976x != null) {
                        this.f12081f.f9976x.m11338a(e_);
                    }
                    return true;
                }
                Log.e("GmsClient", "service descriptor mismatch: " + this.f12081f.m11384b() + " vs. " + interfaceDescriptor);
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.i.h */
    protected final class C3488h extends C3480a {
        final /* synthetic */ C2926i f12082e;

        public C3488h(C2926i c2926i, int i) {
            this.f12082e = c2926i;
            super(c2926i, i, null);
        }

        protected void m14378a(ConnectionResult connectionResult) {
            this.f12082e.f9969q.m14049a(connectionResult);
            this.f12082e.m11379a(connectionResult);
        }

        protected boolean m14379a() {
            this.f12082e.f9969q.m14049a(ConnectionResult.f11813a);
            return true;
        }
    }

    static {
        f9953d = new String[]{"service_esmobile", "service_googleme"};
    }

    protected C2926i(Context context, Looper looper, int i, C3477g c3477g, C2921b c2921b, C2922c c2922c) {
        this(context, looper, C3490k.m14388a(context), C3457f.m14269a(), i, c3477g, (C2921b) C3512u.m14580a((Object) c2921b), (C2922c) C3512u.m14580a((Object) c2922c));
    }

    protected C2926i(Context context, Looper looper, C3490k c3490k, C3457f c3457f, int i, C3477g c3477g, C2921b c2921b, C2922c c2922c) {
        this.f9966n = new Object();
        this.f9967o = new Object();
        this.f9969q = new C3486f(this);
        this.f9971s = new ArrayList();
        this.f9973u = 1;
        this.f9956c = new AtomicInteger(0);
        this.f9961i = (Context) C3512u.m14581a((Object) context, (Object) "Context must not be null");
        this.f9963k = (Looper) C3512u.m14581a((Object) looper, (Object) "Looper must not be null");
        this.f9964l = (C3490k) C3512u.m14581a((Object) c3490k, (Object) "Supervisor must not be null");
        this.f9965m = (C3457f) C3512u.m14581a((Object) c3457f, (Object) "API availability must not be null");
        this.f9955b = new C3481b(this, looper);
        this.f9978z = i;
        this.f9962j = (C3477g) C3512u.m14580a((Object) c3477g);
        this.f9975w = c3477g.m14344a();
        this.f9974v = m11364b(c3477g.m14348d());
        this.f9976x = c2921b;
        this.f9977y = c2922c;
    }

    private boolean m11361a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f9966n) {
            if (this.f9973u != i) {
                z = false;
            } else {
                m11365b(i2, t);
                z = true;
            }
        }
        return z;
    }

    private Set<Scope> m11364b(Set<Scope> set) {
        Set<Scope> a = m11373a((Set) set);
        if (a == null) {
            return a;
        }
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11365b(int r5, T r6) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        r2 = 3;
        if (r5 != r2) goto L_0x001d;
    L_0x0005:
        r3 = r0;
    L_0x0006:
        if (r6 == 0) goto L_0x001f;
    L_0x0008:
        r2 = r0;
    L_0x0009:
        if (r3 != r2) goto L_0x0021;
    L_0x000b:
        com.google.android.gms.common.internal.C3512u.m14588b(r0);
        r1 = r4.f9966n;
        monitor-enter(r1);
        r4.f9973u = r5;	 Catch:{ all -> 0x0027 }
        r4.f9970r = r6;	 Catch:{ all -> 0x0027 }
        r4.m11377a(r5, r6);	 Catch:{ all -> 0x0027 }
        switch(r5) {
            case 1: goto L_0x002e;
            case 2: goto L_0x0023;
            case 3: goto L_0x002a;
            default: goto L_0x001b;
        };	 Catch:{ all -> 0x0027 }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        return;
    L_0x001d:
        r3 = r1;
        goto L_0x0006;
    L_0x001f:
        r2 = r1;
        goto L_0x0009;
    L_0x0021:
        r0 = r1;
        goto L_0x000b;
    L_0x0023:
        r4.m11367c();	 Catch:{ all -> 0x0027 }
        goto L_0x001b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r4.m11378a(r6);	 Catch:{ all -> 0x0027 }
        goto L_0x001b;
    L_0x002e:
        r4.m11371s();	 Catch:{ all -> 0x0027 }
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.i.b(int, android.os.IInterface):void");
    }

    private void m11367c() {
        if (this.f9972t != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + m11372a());
            this.f9964l.m14390b(m11372a(), this.f9972t, k_());
            this.f9956c.incrementAndGet();
        }
        this.f9972t = new C3485e(this, this.f9956c.get());
        if (!this.f9964l.m14389a(m11372a(), this.f9972t, k_())) {
            Log.e("GmsClient", "unable to connect to service: " + m11372a());
            m11375a(8, this.f9956c.get());
        }
    }

    private void m11371s() {
        if (this.f9972t != null) {
            this.f9964l.m14390b(m11372a(), this.f9972t, k_());
            this.f9972t = null;
        }
    }

    protected abstract String m11372a();

    protected Set<Scope> m11373a(Set<Scope> set) {
        return set;
    }

    protected void m11374a(int i) {
        this.f9954a = i;
        this.f9957e = System.currentTimeMillis();
    }

    protected void m11375a(int i, int i2) {
        this.f9955b.sendMessage(this.f9955b.obtainMessage(5, i2, -1, new C3488h(this, i)));
    }

    protected void m11376a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f9955b.sendMessage(this.f9955b.obtainMessage(1, i2, -1, new C3487g(this, i, iBinder, bundle)));
    }

    void m11377a(int i, T t) {
    }

    protected void m11378a(T t) {
        this.f9958f = System.currentTimeMillis();
    }

    protected void m11379a(ConnectionResult connectionResult) {
        this.f9959g = connectionResult.m13953c();
        this.f9960h = System.currentTimeMillis();
    }

    public void m11380a(C3406d c3406d) {
        this.f9969q = (C3406d) C3512u.m14581a((Object) c3406d, (Object) "Connection progress callbacks cannot be null.");
        m11365b(2, null);
    }

    public void m11381a(C3468n c3468n, Set<Scope> set) {
        try {
            GetServiceRequest a = new GetServiceRequest(this.f9978z).m14314a(this.f9961i.getPackageName()).m14312a(m11396o());
            if (set != null) {
                a.m14315a((Collection) set);
            }
            if (m11388f()) {
                a.m14311a(m11395n()).m14313a(c3468n);
            } else if (m11399r()) {
                a.m14311a(this.f9975w);
            }
            synchronized (this.f9967o) {
                if (this.f9968p != null) {
                    this.f9968p.m14434a(new C3484d(this, this.f9956c.get()), a);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            m11385b(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void m11382a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f9966n) {
            int i = this.f9973u;
            IInterface iInterface = this.f9970r;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                printWriter.print("DISCONNECTED");
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                printWriter.print("CONNECTING");
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                printWriter.print("CONNECTED");
                break;
            case SpdyProtocol.QUIC /*4*/:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(m11384b()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f9958f > 0) {
            printWriter.append(str).append("lastConnectedTime=").println(this.f9958f + " " + simpleDateFormat.format(new Date(this.f9958f)));
        }
        if (this.f9957e > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f9954a) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f9954a));
                    break;
            }
            printWriter.append(" lastSuspendedTime=").println(this.f9957e + " " + simpleDateFormat.format(new Date(this.f9957e)));
        }
        if (this.f9960h > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(C3445b.m14243a(this.f9959g));
            printWriter.append(" lastFailedTime=").println(this.f9960h + " " + simpleDateFormat.format(new Date(this.f9960h)));
        }
    }

    protected abstract T m11383b(IBinder iBinder);

    protected abstract String m11384b();

    public void m11385b(int i) {
        this.f9955b.sendMessage(this.f9955b.obtainMessage(4, this.f9956c.get(), i));
    }

    public void m11386d() {
        this.f9956c.incrementAndGet();
        synchronized (this.f9971s) {
            int size = this.f9971s.size();
            for (int i = 0; i < size; i++) {
                ((C3479c) this.f9971s.get(i)).m14361e();
            }
            this.f9971s.clear();
        }
        synchronized (this.f9967o) {
            this.f9968p = null;
        }
        m11365b(1, null);
    }

    public boolean m11387e() {
        boolean z;
        synchronized (this.f9966n) {
            z = this.f9973u == 3;
        }
        return z;
    }

    public Bundle e_() {
        return null;
    }

    public boolean m11388f() {
        return false;
    }

    public boolean m11389g() {
        return false;
    }

    public Intent m11390h() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public IBinder m11391i() {
        IBinder iBinder;
        synchronized (this.f9967o) {
            if (this.f9968p == null) {
                iBinder = null;
            } else {
                iBinder = this.f9968p.asBinder();
            }
        }
        return iBinder;
    }

    public void m11392k() {
        int a = this.f9965m.m14271a(this.f9961i);
        if (a != 0) {
            m11365b(1, null);
            this.f9969q = new C3486f(this);
            this.f9955b.sendMessage(this.f9955b.obtainMessage(3, this.f9956c.get(), a));
            return;
        }
        m11380a(new C3486f(this));
    }

    protected final String k_() {
        return this.f9962j.m14351g();
    }

    public boolean m11393l() {
        boolean z;
        synchronized (this.f9966n) {
            z = this.f9973u == 2;
        }
        return z;
    }

    public final Context m11394m() {
        return this.f9961i;
    }

    public final Account m11395n() {
        return this.f9975w != null ? this.f9975w : new Account("<<default account>>", "com.google");
    }

    protected Bundle m11396o() {
        return new Bundle();
    }

    protected final void m11397p() {
        if (!m11387e()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T m11398q() {
        T t;
        synchronized (this.f9966n) {
            if (this.f9973u == 4) {
                throw new DeadObjectException();
            }
            m11397p();
            C3512u.m14585a(this.f9970r != null, (Object) "Client is connected but service is null");
            t = this.f9970r;
        }
        return t;
    }

    public boolean m11399r() {
        return false;
    }
}
