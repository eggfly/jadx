package com.google.android.gms.p146b;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.b.cw */
public class cw implements jl {
    private final Executor f10534a;

    /* renamed from: com.google.android.gms.b.cw.1 */
    class C31061 implements Executor {
        final /* synthetic */ Handler f10528a;
        final /* synthetic */ cw f10529b;

        C31061(cw cwVar, Handler handler) {
            this.f10529b = cwVar;
            this.f10528a = handler;
        }

        public void execute(Runnable runnable) {
            this.f10528a.post(runnable);
        }
    }

    /* renamed from: com.google.android.gms.b.cw.a */
    private class C3107a implements Runnable {
        final /* synthetic */ cw f10530a;
        private final it f10531b;
        private final jb f10532c;
        private final Runnable f10533d;

        public C3107a(cw cwVar, it itVar, jb jbVar, Runnable runnable) {
            this.f10530a = cwVar;
            this.f10531b = itVar;
            this.f10532c = jbVar;
            this.f10533d = runnable;
        }

        public void run() {
            if (this.f10531b.m11995g()) {
                this.f10531b.m11991c("canceled-at-delivery");
                return;
            }
            if (this.f10532c.m13530a()) {
                this.f10531b.m11986a(this.f10532c.f11557a);
            } else {
                this.f10531b.m11988b(this.f10532c.f11559c);
            }
            if (this.f10532c.f11560d) {
                this.f10531b.m11989b("intermediate-response");
            } else {
                this.f10531b.m11991c("done");
            }
            if (this.f10533d != null) {
                this.f10533d.run();
            }
        }
    }

    public cw(Handler handler) {
        this.f10534a = new C31061(this, handler);
    }

    public void m12158a(it<?> itVar, jb<?> jbVar) {
        m12159a(itVar, jbVar, null);
    }

    public void m12159a(it<?> itVar, jb<?> jbVar, Runnable runnable) {
        itVar.m12008t();
        itVar.m11989b("post-response");
        this.f10534a.execute(new C3107a(this, itVar, jbVar, runnable));
    }

    public void m12160a(it<?> itVar, jz jzVar) {
        itVar.m11989b("post-error");
        this.f10534a.execute(new C3107a(this, itVar, jb.m13528a(jzVar), null));
    }
}
