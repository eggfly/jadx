package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class gs<R extends e> extends c<R> {
    static final ThreadLocal<Boolean> j6;
    protected final a<R> DW;
    private boolean EQ;
    protected final WeakReference<GoogleApiClient> FH;
    private final Object Hw;
    private w J0;
    private volatile hf<R> J8;
    private f<? super R> VH;
    private boolean Ws;
    private final ArrayList<com.google.android.gms.common.api.c.a> Zo;
    private R gn;
    private volatile boolean tp;
    private b u7;
    private final CountDownLatch v5;
    private boolean we;

    class 1 extends ThreadLocal<Boolean> {
        1() {
        }

        protected /* synthetic */ Object initialValue() {
            return j6();
        }

        protected Boolean j6() {
            return Boolean.valueOf(false);
        }
    }

    public static class a<R extends e> extends Handler {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        protected void DW(f<? super R> fVar, R r) {
            try {
                fVar.j6(r);
            } catch (RuntimeException e) {
                gs.FH((e) r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    Pair pair = (Pair) message.obj;
                    DW((f) pair.first, (e) pair.second);
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    ((gs) message.obj).FH(Status.Hw);
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
            }
        }

        public void j6() {
            removeMessages(2);
        }

        public void j6(f<? super R> fVar, R r) {
            sendMessage(obtainMessage(1, new Pair(fVar, r)));
        }
    }

    private final class b {
        final /* synthetic */ gs j6;

        private b(gs gsVar) {
            this.j6 = gsVar;
        }

        protected void finalize() {
            gs.FH(this.j6.gn);
            super.finalize();
        }
    }

    static {
        j6 = new 1();
    }

    @Deprecated
    gs() {
        this.Hw = new Object();
        this.v5 = new CountDownLatch(1);
        this.Zo = new ArrayList();
        this.Ws = false;
        this.DW = new a(Looper.getMainLooper());
        this.FH = new WeakReference(null);
    }

    private R DW() {
        R r;
        boolean z = true;
        synchronized (this.Hw) {
            if (this.tp) {
                z = false;
            }
            com.google.android.gms.common.internal.b.j6(z, (Object) "Result has already been consumed.");
            com.google.android.gms.common.internal.b.j6(v5(), (Object) "Result is not ready.");
            r = this.gn;
            this.gn = null;
            this.VH = null;
            this.tp = true;
        }
        Hw();
        return r;
    }

    public static void FH(e eVar) {
        if (eVar instanceof d) {
            try {
                ((d) eVar).j6();
            } catch (Throwable e) {
                String valueOf = String.valueOf(eVar);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private void j6(R r) {
        this.gn = r;
        this.J0 = null;
        this.v5.countDown();
        Status DW = this.gn.DW();
        if (this.EQ) {
            this.VH = null;
        } else if (this.VH != null) {
            this.DW.j6();
            this.DW.j6(this.VH, DW());
        } else if (this.gn instanceof d) {
            this.u7 = new b();
        }
        Iterator it = this.Zo.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.c.a) it.next()).j6(DW);
        }
        this.Zo.clear();
    }

    protected abstract R DW(Status status);

    public final void DW(R r) {
        boolean z = true;
        synchronized (this.Hw) {
            if (this.we || this.EQ || (v5() && u7())) {
                FH((e) r);
                return;
            }
            com.google.android.gms.common.internal.b.j6(!v5(), (Object) "Results have already been set");
            if (this.tp) {
                z = false;
            }
            com.google.android.gms.common.internal.b.j6(z, (Object) "Result has already been consumed");
            j6((e) r);
        }
    }

    public final void FH(Status status) {
        synchronized (this.Hw) {
            if (!v5()) {
                DW(DW(status));
                this.we = true;
            }
        }
    }

    protected void Hw() {
    }

    public boolean VH() {
        boolean gn;
        synchronized (this.Hw) {
            if (((GoogleApiClient) this.FH.get()) == null || !this.Ws) {
                Zo();
            }
            gn = gn();
        }
        return gn;
    }

    public void Zo() {
        synchronized (this.Hw) {
            if (this.EQ || this.tp) {
                return;
            }
            if (this.J0 != null) {
                try {
                    this.J0.j6();
                } catch (RemoteException e) {
                }
            }
            FH(this.gn);
            this.EQ = true;
            j6(DW(Status.v5));
        }
    }

    public boolean gn() {
        boolean z;
        synchronized (this.Hw) {
            z = this.EQ;
        }
        return z;
    }

    public Integer j6() {
        return null;
    }

    public final void j6(f<? super R> fVar) {
        boolean z = true;
        synchronized (this.Hw) {
            if (fVar == null) {
                this.VH = null;
                return;
            }
            com.google.android.gms.common.internal.b.j6(!this.tp, (Object) "Result has already been consumed.");
            if (this.J8 != null) {
                z = false;
            }
            com.google.android.gms.common.internal.b.j6(z, (Object) "Cannot set callbacks if then() has been called.");
            if (gn()) {
                return;
            }
            if (v5()) {
                this.DW.j6(fVar, DW());
            } else {
                this.VH = fVar;
            }
            return;
        }
    }

    boolean u7() {
        return false;
    }

    public final boolean v5() {
        return this.v5.getCount() == 0;
    }
}
