package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.b;
import java.util.concurrent.atomic.AtomicReference;

public class gq {

    public static abstract class a<R extends e, A extends c> extends gs<R> {
        private final d<A> Hw;
        private AtomicReference<b> v5;

        private void j6(RemoteException remoteException) {
            j6(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public final d<A> DW() {
            return this.Hw;
        }

        protected abstract void DW(A a);

        public void FH() {
            j6(null);
        }

        protected void Hw() {
            b bVar = (b) this.v5.getAndSet(null);
            if (bVar != null) {
                bVar.j6(this);
            }
        }

        public final void j6(Status status) {
            b.DW(!status.v5(), "Failed result must not be success");
            e DW = DW(status);
            DW(DW);
            j6(DW);
        }

        public final void j6(A a) {
            try {
                DW(a);
            } catch (RemoteException e) {
                j6(e);
                throw e;
            } catch (RemoteException e2) {
                j6(e2);
            }
        }

        protected void j6(R r) {
        }

        public void j6(b bVar) {
            this.v5.set(bVar);
        }
    }
}
