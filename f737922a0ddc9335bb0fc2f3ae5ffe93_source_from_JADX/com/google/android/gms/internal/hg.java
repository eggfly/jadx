package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.m;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import l;

public class hg {
    private static final com.google.android.gms.internal.gq.a<?, ?>[] DW;
    private final b FH;
    private final Map<d<?>, f> Hw;
    final Set<com.google.android.gms.internal.gq.a<?, ?>> j6;

    interface b {
        void j6(com.google.android.gms.internal.gq.a<?, ?> aVar);
    }

    class 1 implements b {
        final /* synthetic */ hg j6;

        1(hg hgVar) {
            this.j6 = hgVar;
        }

        public void j6(com.google.android.gms.internal.gq.a<?, ?> aVar) {
            this.j6.j6.remove(aVar);
            if (aVar.j6() != null && null != null) {
                null.j6(aVar.j6().intValue());
            }
        }
    }

    private static class a implements DeathRecipient, b {
        private final WeakReference<m> DW;
        private final WeakReference<IBinder> FH;
        private final WeakReference<com.google.android.gms.internal.gq.a<?, ?>> j6;

        private a(com.google.android.gms.internal.gq.a<?, ?> aVar, m mVar, IBinder iBinder) {
            this.DW = new WeakReference(mVar);
            this.j6 = new WeakReference(aVar);
            this.FH = new WeakReference(iBinder);
        }

        private void j6() {
            com.google.android.gms.internal.gq.a aVar = (com.google.android.gms.internal.gq.a) this.j6.get();
            m mVar = (m) this.DW.get();
            if (!(mVar == null || aVar == null)) {
                mVar.j6(aVar.j6().intValue());
            }
            IBinder iBinder = (IBinder) this.FH.get();
            if (this.FH != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            j6();
        }

        public void j6(com.google.android.gms.internal.gq.a<?, ?> aVar) {
            j6();
        }
    }

    static {
        DW = new com.google.android.gms.internal.gq.a[0];
    }

    public hg(d<?> dVar, f fVar) {
        this.j6 = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.FH = new 1(this);
        this.Hw = new l();
        this.Hw.put(dVar, fVar);
    }

    private static void j6(com.google.android.gms.internal.gq.a<?, ?> aVar, m mVar, IBinder iBinder) {
        if (aVar.v5()) {
            aVar.j6(new a(mVar, iBinder, null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            aVar.j6(null);
            aVar.Zo();
            mVar.j6(aVar.j6().intValue());
        } else {
            b aVar2 = new a(mVar, iBinder, null);
            aVar.j6(aVar2);
            try {
                iBinder.linkToDeath(aVar2, 0);
            } catch (RemoteException e) {
                aVar.Zo();
                mVar.j6(aVar.j6().intValue());
            }
        }
    }

    public boolean DW() {
        for (com.google.android.gms.internal.gq.a v5 : (com.google.android.gms.internal.gq.a[]) this.j6.toArray(DW)) {
            if (!v5.v5()) {
                return true;
            }
        }
        return false;
    }

    public void j6() {
        for (com.google.android.gms.internal.gq.a aVar : (com.google.android.gms.internal.gq.a[]) this.j6.toArray(DW)) {
            aVar.j6(null);
            if (aVar.j6() != null) {
                aVar.FH();
                j6(aVar, null, ((f) this.Hw.get(aVar.DW())).v5());
                this.j6.remove(aVar);
            } else if (aVar.VH()) {
                this.j6.remove(aVar);
            }
        }
    }

    <A extends c> void j6(com.google.android.gms.internal.gq.a<? extends e, A> aVar) {
        this.j6.add(aVar);
        aVar.j6(this.FH);
    }
}
