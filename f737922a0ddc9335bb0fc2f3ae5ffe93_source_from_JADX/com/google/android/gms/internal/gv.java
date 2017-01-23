package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.SparseArray;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.a.i;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.n;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class gv implements Callback {
    private static final Object Hw;
    private static gv v5;
    private long DW;
    private gt EQ;
    private long FH;
    private final Handler J0;
    private final ReferenceQueue<l<?>> J8;
    private b QX;
    private final com.google.android.gms.common.a VH;
    private final SparseArray<a> Ws;
    private final Context Zo;
    private int gn;
    private long j6;
    private final Map<go<?>, c<?>> tp;
    private final SparseArray<c<?>> u7;
    private final Set<go<?>> we;

    private final class a extends PhantomReference<l<?>> {
        private final int DW;
        final /* synthetic */ gv j6;

        public a(gv gvVar, l lVar, int i, ReferenceQueue<l<?>> referenceQueue) {
            this.j6 = gvVar;
            super(lVar, referenceQueue);
            this.DW = i;
        }

        public void j6() {
            this.j6.J0.sendMessage(this.j6.J0.obtainMessage(2, this.DW, 2));
        }
    }

    private static final class b extends Thread {
        private final SparseArray<a> DW;
        private final AtomicBoolean FH;
        private final ReferenceQueue<l<?>> j6;

        public b(ReferenceQueue<l<?>> referenceQueue, SparseArray<a> sparseArray) {
            super("GoogleApiCleanup");
            this.FH = new AtomicBoolean();
            this.j6 = referenceQueue;
            this.DW = sparseArray;
        }

        public void run() {
            this.FH.set(true);
            Process.setThreadPriority(10);
            while (this.FH.get()) {
                try {
                    a aVar = (a) this.j6.remove();
                    this.DW.remove(aVar.DW);
                    aVar.j6();
                } catch (InterruptedException e) {
                } finally {
                    this.FH.set(false);
                }
            }
        }
    }

    private class c<O extends com.google.android.gms.common.api.a.a> implements com.google.android.gms.common.api.GoogleApiClient.a, com.google.android.gms.common.api.GoogleApiClient.b {
        private final Queue<gn> DW;
        private final f FH;
        private final com.google.android.gms.common.api.a.c Hw;
        private final Set<gp> VH;
        private final SparseArray<hg> Zo;
        private final SparseArray<Map<Object, com.google.android.gms.internal.gq.a>> gn;
        final /* synthetic */ gv j6;
        private ConnectionResult tp;
        private boolean u7;
        private final go<O> v5;

        public c(gv gvVar, l<O> lVar) {
            this.j6 = gvVar;
            this.DW = new LinkedList();
            this.Zo = new SparseArray();
            this.VH = new HashSet();
            this.gn = new SparseArray();
            this.tp = null;
            this.FH = j6((l) lVar);
            if (this.FH instanceof g) {
                this.Hw = ((g) this.FH).gn();
            } else {
                this.Hw = this.FH;
            }
            this.v5 = lVar.Hw();
        }

        private void DW(ConnectionResult connectionResult) {
            for (gp j6 : this.VH) {
                j6.j6(this.v5, connectionResult);
            }
            this.VH.clear();
        }

        private void DW(gn gnVar) {
            gnVar.j6(this.Zo);
            Map map;
            if (gnVar.DW == 3) {
                try {
                    Map map2;
                    map = (Map) this.gn.get(gnVar.j6);
                    if (map == null) {
                        l lVar = new l(1);
                        this.gn.put(gnVar.j6, lVar);
                        map2 = lVar;
                    } else {
                        map2 = map;
                    }
                    com.google.android.gms.internal.gq.a aVar = ((com.google.android.gms.internal.gn.a) gnVar).FH;
                    map2.put(((gz) aVar).j6(), aVar);
                } catch (ClassCastException e) {
                    throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
                }
            } else if (gnVar.DW == 4) {
                try {
                    map = (Map) this.gn.get(gnVar.j6);
                    gz gzVar = (gz) ((com.google.android.gms.internal.gn.a) gnVar).FH;
                    if (map != null) {
                        map.remove(gzVar.j6());
                    } else {
                        Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
                }
            }
            try {
                gnVar.j6(this.Hw);
            } catch (DeadObjectException e3) {
                this.FH.j6();
                j6(1);
            }
        }

        private void VH() {
            if (this.u7) {
                Zo();
                j6(this.j6.VH.j6(this.j6.Zo) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.FH.j6();
            }
        }

        private void Zo() {
            if (this.u7) {
                this.j6.J0.removeMessages(9, this.v5);
                this.j6.J0.removeMessages(8, this.v5);
                this.u7 = false;
            }
        }

        private void gn() {
            this.j6.J0.removeMessages(10, this.v5);
            this.j6.J0.sendMessageDelayed(this.j6.J0.obtainMessage(10, this.v5), this.j6.FH);
        }

        private f j6(l lVar) {
            com.google.android.gms.common.api.a DW = lVar.DW();
            if (!DW.Hw()) {
                return lVar.DW().j6().j6(lVar.v5(), this.j6.J0.getLooper(), n.j6(lVar.v5()), lVar.FH(), this, this);
            }
            i DW2 = DW.DW();
            return new g(lVar.v5(), this.j6.J0.getLooper(), DW2.j6(), this, this, n.j6(lVar.v5()), DW2.j6(lVar.FH()));
        }

        private void j6(Status status) {
            for (gn j6 : this.DW) {
                j6.j6(status);
            }
            this.DW.clear();
        }

        private void tp() {
            if (!this.FH.DW() && !this.FH.FH()) {
                if (this.FH.Hw() && this.j6.gn != 0) {
                    this.j6.gn = this.j6.VH.j6(this.j6.Zo);
                    if (this.j6.gn != 0) {
                        j6(new ConnectionResult(this.j6.gn, null));
                        return;
                    }
                }
                this.FH.j6(new d(this.j6, this.FH, this.v5));
            }
        }

        private void u7() {
            if (this.FH.DW() && this.gn.size() == 0) {
                for (int i = 0; i < this.Zo.size(); i++) {
                    if (((hg) this.Zo.get(this.Zo.keyAt(i))).DW()) {
                        gn();
                        return;
                    }
                }
                this.FH.j6();
            }
        }

        private void v5() {
            if (this.u7) {
                tp();
            }
        }

        public void DW() {
            this.tp = null;
        }

        public void DW(int i) {
            this.Zo.put(i, new hg(this.v5.j6(), this.FH));
        }

        ConnectionResult FH() {
            return this.tp;
        }

        boolean Hw() {
            return this.FH.DW();
        }

        public void j6() {
            while (this.FH.DW() && !this.DW.isEmpty()) {
                DW((gn) this.DW.remove());
            }
        }

        public void j6(int i) {
            DW();
            this.u7 = true;
            this.j6.J0.sendMessageDelayed(Message.obtain(this.j6.J0, 8, this.v5), this.j6.j6);
            this.j6.J0.sendMessageDelayed(Message.obtain(this.j6.J0, 9, this.v5), this.j6.DW);
            this.j6.gn = -1;
        }

        public void j6(int i, boolean z) {
            Iterator it = this.DW.iterator();
            while (it.hasNext()) {
                gn gnVar = (gn) it.next();
                if (gnVar.j6 == i && gnVar.DW != 1 && gnVar.j6()) {
                    it.remove();
                }
            }
            ((hg) this.Zo.get(i)).j6();
            this.gn.delete(i);
            if (!z) {
                this.Zo.remove(i);
                this.j6.Ws.remove(i);
                if (this.Zo.size() == 0 && this.DW.isEmpty()) {
                    Zo();
                    this.FH.j6();
                    this.j6.tp.remove(this.v5);
                    synchronized (gv.Hw) {
                        this.j6.we.remove(this.v5);
                    }
                }
            }
        }

        public void j6(Bundle bundle) {
            DW();
            DW(ConnectionResult.j6);
            Zo();
            for (int i = 0; i < this.gn.size(); i++) {
                for (com.google.android.gms.internal.gq.a j6 : ((Map) this.gn.get(this.gn.keyAt(i))).values()) {
                    try {
                        j6.j6(this.Hw);
                    } catch (DeadObjectException e) {
                        this.FH.j6();
                        j6(1);
                    }
                }
            }
            j6();
            gn();
        }

        public void j6(ConnectionResult connectionResult) {
            DW();
            this.j6.gn = -1;
            DW(connectionResult);
            int keyAt = this.Zo.keyAt(0);
            if (this.DW.isEmpty()) {
                this.tp = connectionResult;
                return;
            }
            synchronized (gv.Hw) {
                if (null == null || !this.j6.we.contains(this.v5)) {
                    if (!this.j6.j6(connectionResult, keyAt)) {
                        if (connectionResult.FH() == 18) {
                            this.u7 = true;
                        }
                        if (this.u7) {
                            this.j6.J0.sendMessageDelayed(Message.obtain(this.j6.J0, 8, this.v5), this.j6.j6);
                            return;
                        }
                        String valueOf = String.valueOf(this.v5.DW());
                        j6(new Status(17, new StringBuilder(String.valueOf(valueOf).length() + 38).append("API: ").append(valueOf).append(" is not available on this device.").toString()));
                        return;
                    }
                    return;
                }
                null.DW(connectionResult, keyAt);
            }
        }

        public void j6(gn gnVar) {
            if (this.FH.DW()) {
                DW(gnVar);
                gn();
                return;
            }
            this.DW.add(gnVar);
            if (this.tp == null || !this.tp.j6()) {
                tp();
            } else {
                j6(this.tp);
            }
        }

        public void j6(gp gpVar) {
            this.VH.add(gpVar);
        }
    }

    private class d implements k.f {
        private final f DW;
        private final go<?> FH;
        final /* synthetic */ gv j6;

        public d(gv gvVar, f fVar, go<?> goVar) {
            this.j6 = gvVar;
            this.DW = fVar;
            this.FH = goVar;
        }

        public void j6(ConnectionResult connectionResult) {
            if (connectionResult.DW()) {
                this.DW.j6(null, Collections.emptySet());
            } else {
                ((c) this.j6.tp.get(this.FH)).j6(connectionResult);
            }
        }
    }

    static {
        Hw = new Object();
    }

    private void DW(int i, boolean z) {
        c cVar = (c) this.u7.get(i);
        if (cVar != null) {
            if (!z) {
                this.u7.delete(i);
            }
            cVar.j6(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", "onRelease received for unknown instance: " + i, new Exception());
    }

    private void Hw() {
        for (c cVar : this.tp.values()) {
            cVar.DW();
            cVar.tp();
        }
    }

    public static gv j6() {
        gv gvVar;
        synchronized (Hw) {
            gvVar = v5;
        }
        return gvVar;
    }

    private void j6(l<?> lVar, int i) {
        go Hw = lVar.Hw();
        if (!this.tp.containsKey(Hw)) {
            this.tp.put(Hw, new c(this, lVar));
        }
        c cVar = (c) this.tp.get(Hw);
        cVar.DW(i);
        this.u7.put(i, cVar);
        cVar.tp();
        this.Ws.put(i, new a(this, lVar, i, this.J8));
        if (this.QX == null || !this.QX.FH.get()) {
            this.QX = new b(this.J8, this.Ws);
            this.QX.start();
        }
    }

    private void j6(gn gnVar) {
        ((c) this.u7.get(gnVar.j6)).j6(gnVar);
    }

    public void DW() {
        this.J0.sendMessage(this.J0.obtainMessage(3));
    }

    public void DW(ConnectionResult connectionResult, int i) {
        if (!j6(connectionResult, i)) {
            this.J0.sendMessage(this.J0.obtainMessage(5, i, 0));
        }
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j6((gp) message.obj);
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case 7:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                DW(i, z);
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                Hw();
                break;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                j6((gn) message.obj);
                break;
            case 5:
                if (this.u7.get(message.arg1) != null) {
                    ((c) this.u7.get(message.arg1)).j6(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                j6((l) message.obj, message.arg1);
                break;
            case 8:
                if (this.tp.containsKey(message.obj)) {
                    ((c) this.tp.get(message.obj)).v5();
                    break;
                }
                break;
            case 9:
                if (this.tp.containsKey(message.obj)) {
                    ((c) this.tp.get(message.obj)).VH();
                    break;
                }
                break;
            case 10:
                if (this.tp.containsKey(message.obj)) {
                    ((c) this.tp.get(message.obj)).u7();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }

    public void j6(int i, boolean z) {
        this.J0.sendMessage(this.J0.obtainMessage(7, i, z ? 1 : 2));
    }

    public void j6(gp gpVar) {
        for (go goVar : gpVar.DW()) {
            c cVar = (c) this.tp.get(goVar);
            if (cVar == null) {
                gpVar.Zo();
                return;
            } else if (cVar.Hw()) {
                gpVar.j6(goVar, ConnectionResult.j6);
            } else if (cVar.FH() != null) {
                gpVar.j6(goVar, cVar.FH());
            } else {
                cVar.j6(gpVar);
            }
        }
    }

    public void j6(gt gtVar) {
        synchronized (Hw) {
            if (gtVar == null) {
                this.EQ = null;
                this.we.clear();
            }
        }
    }

    boolean j6(ConnectionResult connectionResult, int i) {
        if (!connectionResult.j6() && !this.VH.j6(connectionResult.FH())) {
            return false;
        }
        this.VH.j6(this.Zo, connectionResult, i);
        return true;
    }
}
