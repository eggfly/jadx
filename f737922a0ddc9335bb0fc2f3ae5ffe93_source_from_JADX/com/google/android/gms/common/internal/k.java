package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
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
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k<T extends IInterface> {
    public static final String[] FH;
    protected AtomicInteger DW;
    private final s EQ;
    private int Hw;
    private final Object J0;
    private final Object J8;
    private int Mr;
    private f QX;
    private final b U2;
    private int VH;
    private z Ws;
    private T XL;
    private long Zo;
    private final c a8;
    private final ArrayList<e<?>> aM;
    private long gn;
    private h j3;
    final Handler j6;
    private final int lg;
    private final String rN;
    private final Looper tp;
    private final Context u7;
    private long v5;
    private final com.google.android.gms.common.i we;

    protected abstract class e<TListener> {
        private boolean DW;
        final /* synthetic */ k Hw;
        private TListener j6;

        public e(k kVar, TListener tListener) {
            this.Hw = kVar;
            this.j6 = tListener;
            this.DW = false;
        }

        protected abstract void DW();

        public void FH() {
            synchronized (this) {
                Object obj = this.j6;
                if (this.DW) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (obj != null) {
                try {
                    j6(obj);
                } catch (RuntimeException e) {
                    DW();
                    throw e;
                }
            }
            DW();
            synchronized (this) {
                this.DW = true;
            }
            Hw();
        }

        public void Hw() {
            v5();
            synchronized (this.Hw.aM) {
                this.Hw.aM.remove(this);
            }
        }

        protected abstract void j6(TListener tListener);

        public void v5() {
            synchronized (this) {
                this.j6 = null;
            }
        }
    }

    private abstract class a extends e<Boolean> {
        public final Bundle DW;
        final /* synthetic */ k FH;
        public final int j6;

        protected a(k kVar, int i, Bundle bundle) {
            this.FH = kVar;
            super(kVar, Boolean.valueOf(true));
            this.j6 = i;
            this.DW = bundle;
        }

        protected void DW() {
        }

        protected abstract void j6(ConnectionResult connectionResult);

        protected void j6(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.FH.DW(1, null);
                return;
            }
            switch (this.j6) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    if (!j6()) {
                        this.FH.DW(1, null);
                        j6(new ConnectionResult(8, null));
                    }
                case 10:
                    this.FH.DW(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.FH.DW(1, null);
                    if (this.DW != null) {
                        pendingIntent = (PendingIntent) this.DW.getParcelable("pendingIntent");
                    }
                    j6(new ConnectionResult(this.j6, pendingIntent));
            }
        }

        protected /* synthetic */ void j6(Object obj) {
            j6((Boolean) obj);
        }

        protected abstract boolean j6();
    }

    public interface b {
        void j6(int i);

        void j6(Bundle bundle);
    }

    public interface c {
        void j6(ConnectionResult connectionResult);
    }

    final class d extends Handler {
        final /* synthetic */ k j6;

        public d(k kVar, Looper looper) {
            this.j6 = kVar;
            super(looper);
        }

        private boolean DW(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        private void j6(Message message) {
            e eVar = (e) message.obj;
            eVar.DW();
            eVar.Hw();
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.j6.DW.get() != message.arg1) {
                if (DW(message)) {
                    j6(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !this.j6.FH()) {
                j6(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.j6.QX.j6(connectionResult);
                this.j6.j6(connectionResult);
            } else if (message.what == 4) {
                this.j6.DW(4, null);
                if (this.j6.U2 != null) {
                    this.j6.U2.j6(message.arg2);
                }
                this.j6.j6(message.arg2);
                this.j6.j6(4, 1, null);
            } else if (message.what == 2 && !this.j6.DW()) {
                j6(message);
            } else if (DW(message)) {
                ((e) message.obj).FH();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    public interface f {
        void j6(ConnectionResult connectionResult);
    }

    public static final class g extends com.google.android.gms.common.internal.y.a {
        private final int DW;
        private k j6;

        public g(k kVar, int i) {
            this.j6 = kVar;
            this.DW = i;
        }

        private void j6() {
            this.j6 = null;
        }

        public void j6(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public void j6(int i, IBinder iBinder, Bundle bundle) {
            b.j6(this.j6, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.j6.j6(i, iBinder, bundle, this.DW);
            j6();
        }
    }

    public final class h implements ServiceConnection {
        private final int DW;
        final /* synthetic */ k j6;

        public h(k kVar, int i) {
            this.j6 = kVar;
            this.DW = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.j6((Object) iBinder, (Object) "Expecting a valid IBinder");
            synchronized (this.j6.J8) {
                this.j6.Ws = com.google.android.gms.common.internal.z.a.j6(iBinder);
            }
            this.j6.j6(0, null, this.DW);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.j6.J8) {
                this.j6.Ws = null;
            }
            this.j6.j6.sendMessage(this.j6.j6.obtainMessage(4, this.DW, 1));
        }
    }

    protected class i implements f {
        final /* synthetic */ k j6;

        public i(k kVar) {
            this.j6 = kVar;
        }

        public void j6(ConnectionResult connectionResult) {
            if (connectionResult.DW()) {
                this.j6.j6(null, this.j6.U2());
            } else if (this.j6.a8 != null) {
                this.j6.a8.j6(connectionResult);
            }
        }
    }

    protected final class j extends a {
        final /* synthetic */ k Zo;
        public final IBinder v5;

        public j(k kVar, int i, IBinder iBinder, Bundle bundle) {
            this.Zo = kVar;
            super(kVar, i, bundle);
            this.v5 = iBinder;
        }

        protected void j6(ConnectionResult connectionResult) {
            if (this.Zo.a8 != null) {
                this.Zo.a8.j6(connectionResult);
            }
            this.Zo.j6(connectionResult);
        }

        protected boolean j6() {
            try {
                String interfaceDescriptor = this.v5.getInterfaceDescriptor();
                if (this.Zo.VH().equals(interfaceDescriptor)) {
                    IInterface j6 = this.Zo.j6(this.v5);
                    if (j6 == null || !this.Zo.j6(2, 3, j6)) {
                        return false;
                    }
                    Bundle XL = this.Zo.XL();
                    if (this.Zo.U2 != null) {
                        this.Zo.U2.j6(XL);
                    }
                    return true;
                }
                String valueOf = String.valueOf(this.Zo.VH());
                Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class k extends a {
        final /* synthetic */ k v5;

        public k(k kVar, int i, Bundle bundle) {
            this.v5 = kVar;
            super(kVar, i, bundle);
        }

        protected void j6(ConnectionResult connectionResult) {
            this.v5.QX.j6(connectionResult);
            this.v5.j6(connectionResult);
        }

        protected boolean j6() {
            this.v5.QX.j6(ConnectionResult.j6);
            return true;
        }
    }

    static {
        FH = new String[]{"service_esmobile", "service_googleme"};
    }

    protected k(Context context, Looper looper, int i, b bVar, c cVar, String str) {
        this(context, looper, s.j6(context), com.google.android.gms.common.i.DW(), i, (b) b.j6((Object) bVar), (c) b.j6((Object) cVar), str);
    }

    protected k(Context context, Looper looper, s sVar, com.google.android.gms.common.i iVar, int i, b bVar, c cVar, String str) {
        this.J0 = new Object();
        this.J8 = new Object();
        this.aM = new ArrayList();
        this.Mr = 1;
        this.DW = new AtomicInteger(0);
        this.u7 = (Context) b.j6((Object) context, (Object) "Context must not be null");
        this.tp = (Looper) b.j6((Object) looper, (Object) "Looper must not be null");
        this.EQ = (s) b.j6((Object) sVar, (Object) "Supervisor must not be null");
        this.we = (com.google.android.gms.common.i) b.j6((Object) iVar, (Object) "API availability must not be null");
        this.j6 = new d(this, looper);
        this.lg = i;
        this.U2 = bVar;
        this.a8 = cVar;
        this.rN = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void DW(int r5, T r6) {
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
        com.google.android.gms.common.internal.b.DW(r0);
        r1 = r4.J0;
        monitor-enter(r1);
        r4.Mr = r5;	 Catch:{ all -> 0x0027 }
        r4.XL = r6;	 Catch:{ all -> 0x0027 }
        r4.j6(r5, r6);	 Catch:{ all -> 0x0027 }
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
        r4.gn();	 Catch:{ all -> 0x0027 }
        goto L_0x001b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r4.j6(r6);	 Catch:{ all -> 0x0027 }
        goto L_0x001b;
    L_0x002e:
        r4.a8();	 Catch:{ all -> 0x0027 }
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.k.DW(int, android.os.IInterface):void");
    }

    private void a8() {
        if (this.j3 != null) {
            this.EQ.DW(Zo(), u7(), this.j3, tp());
            this.j3 = null;
        }
    }

    private void gn() {
        if (this.j3 != null) {
            String valueOf = String.valueOf(Zo());
            String valueOf2 = String.valueOf(u7());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.EQ.DW(Zo(), u7(), this.j3, tp());
            this.DW.incrementAndGet();
        }
        this.j3 = new h(this, this.DW.get());
        if (!this.EQ.j6(Zo(), u7(), this.j3, tp())) {
            valueOf = String.valueOf(Zo());
            valueOf2 = String.valueOf(u7());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            j6(16, null, this.DW.get());
        }
    }

    private boolean j6(int i, int i2, T t) {
        boolean z;
        synchronized (this.J0) {
            if (this.Mr != i) {
                z = false;
            } else {
                DW(i2, t);
                z = true;
            }
        }
        return z;
    }

    public void DW(int i) {
        this.j6.sendMessage(this.j6.obtainMessage(4, this.DW.get(), i));
    }

    public boolean DW() {
        boolean z;
        synchronized (this.J0) {
            z = this.Mr == 3;
        }
        return z;
    }

    public void EQ() {
        int j6 = this.we.j6(this.u7);
        if (j6 != 0) {
            DW(1, null);
            this.QX = new i(this);
            this.j6.sendMessage(this.j6.obtainMessage(3, this.DW.get(), j6));
            return;
        }
        j6(new i(this));
    }

    public boolean FH() {
        boolean z;
        synchronized (this.J0) {
            z = this.Mr == 2;
        }
        return z;
    }

    public boolean Hw() {
        return true;
    }

    public Account J0() {
        return null;
    }

    public final Account J8() {
        return J0() != null ? J0() : new Account("<<default account>>", "com.google");
    }

    public boolean Mr() {
        return false;
    }

    protected final void QX() {
        if (!DW()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected Set<Scope> U2() {
        return Collections.EMPTY_SET;
    }

    protected abstract String VH();

    protected Bundle Ws() {
        return new Bundle();
    }

    public Bundle XL() {
        return null;
    }

    protected abstract String Zo();

    public final T aM() {
        T t;
        synchronized (this.J0) {
            if (this.Mr == 4) {
                throw new DeadObjectException();
            }
            QX();
            b.j6(this.XL != null, (Object) "Client is connected but service is null");
            t = this.XL;
        }
        return t;
    }

    public boolean j3() {
        return false;
    }

    protected abstract T j6(IBinder iBinder);

    public void j6() {
        this.DW.incrementAndGet();
        synchronized (this.aM) {
            int size = this.aM.size();
            for (int i = 0; i < size; i++) {
                ((e) this.aM.get(i)).v5();
            }
            this.aM.clear();
        }
        synchronized (this.J8) {
            this.Ws = null;
        }
        DW(1, null);
    }

    protected void j6(int i) {
        this.Hw = i;
        this.v5 = System.currentTimeMillis();
    }

    protected void j6(int i, Bundle bundle, int i2) {
        this.j6.sendMessage(this.j6.obtainMessage(5, i2, -1, new k(this, i, bundle)));
    }

    protected void j6(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.j6.sendMessage(this.j6.obtainMessage(1, i2, -1, new j(this, i, iBinder, bundle)));
    }

    void j6(int i, T t) {
    }

    protected void j6(T t) {
        this.Zo = System.currentTimeMillis();
    }

    protected void j6(ConnectionResult connectionResult) {
        this.VH = connectionResult.FH();
        this.gn = System.currentTimeMillis();
    }

    public void j6(f fVar) {
        this.QX = (f) b.j6((Object) fVar, (Object) "Connection progress callbacks cannot be null.");
        DW(2, null);
    }

    public void j6(v vVar, Set<Scope> set) {
        try {
            GetServiceRequest j6 = new GetServiceRequest(this.lg).j6(this.u7.getPackageName()).j6(Ws());
            if (set != null) {
                j6.j6((Collection) set);
            }
            if (j3()) {
                j6.j6(J8()).j6(vVar);
            } else if (Mr()) {
                j6.j6(J0());
            }
            synchronized (this.J8) {
                if (this.Ws != null) {
                    this.Ws.j6(new g(this, this.DW.get()), j6);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            DW(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    protected final String tp() {
        return this.rN == null ? this.u7.getClass().getName() : this.rN;
    }

    protected String u7() {
        return "com.google.android.gms";
    }

    public IBinder v5() {
        IBinder iBinder;
        synchronized (this.J8) {
            if (this.Ws == null) {
                iBinder = null;
            } else {
                iBinder = this.Ws.asBinder();
            }
        }
        return iBinder;
    }

    public final Context we() {
        return this.u7;
    }
}
