package com.google.android.gms.common.api.p155a;

import android.os.RemoteException;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3427c;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.C3444a.C3388d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p155a.C3428h.C3306e;
import com.google.android.gms.common.api.p155a.C3428h.C3420d;
import com.google.android.gms.common.internal.C3512u;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.common.api.a.a */
public class C3392a {

    /* renamed from: com.google.android.gms.common.api.a.a.a */
    public static abstract class C3307a<R extends C3386f, A extends C2924c> extends C3305b<R> implements C3306e<A> {
        private final C3388d<A> f11524b;
        private AtomicReference<C3420d> f11525c;

        protected C3307a(C3388d<A> c3388d, C3427c c3427c) {
            super((C3427c) C3512u.m14581a((Object) c3427c, (Object) "GoogleApiClient must not be null"));
            this.f11525c = new AtomicReference();
            this.f11524b = (C3388d) C3512u.m14580a((Object) c3388d);
        }

        private void m13462a(RemoteException remoteException) {
            m13463a(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public final void m13463a(Status status) {
            C3512u.m14589b(!status.m13963e(), "Failed result must not be success");
            m13443a(m13446c(status));
        }

        public final void m13464a(A a) {
            try {
                m13467b(a);
            } catch (RemoteException e) {
                m13462a(e);
                throw e;
            } catch (RemoteException e2) {
                m13462a(e2);
            }
        }

        public void m13465a(C3420d c3420d) {
            this.f11525c.set(c3420d);
        }

        public final C3388d<A> m13466b() {
            return this.f11524b;
        }

        protected abstract void m13467b(A a);

        public void m13468c() {
            m13444a(null);
        }

        protected void m13469d() {
            C3420d c3420d = (C3420d) this.f11525c.getAndSet(null);
            if (c3420d != null) {
                c3420d.m14119a(this);
            }
        }
    }
}
