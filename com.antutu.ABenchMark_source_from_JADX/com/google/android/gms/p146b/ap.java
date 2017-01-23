package com.google.android.gms.p146b;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.common.C3465h;
import java.util.concurrent.Callable;

@gb
/* renamed from: com.google.android.gms.b.ap */
public class ap {
    private final Object f10257a;
    private boolean f10258b;
    private SharedPreferences f10259c;

    /* renamed from: com.google.android.gms.b.ap.1 */
    class C30301 implements Callable<T> {
        final /* synthetic */ am f10255a;
        final /* synthetic */ ap f10256b;

        C30301(ap apVar, am amVar) {
            this.f10256b = apVar;
            this.f10255a = amVar;
        }

        public T call() {
            return this.f10255a.m11791a(this.f10256b.f10259c);
        }
    }

    public ap() {
        this.f10257a = new Object();
        this.f10258b = false;
        this.f10259c = null;
    }

    public <T> T m11810a(am<T> amVar) {
        synchronized (this.f10257a) {
            if (this.f10258b) {
                return hu.m13160a(new C30301(this, amVar));
            }
            T b = amVar.m11793b();
            return b;
        }
    }

    public void m11811a(Context context) {
        synchronized (this.f10257a) {
            if (this.f10258b) {
                return;
            }
            Context d = C3465h.m14299d(context);
            if (d == null) {
                return;
            }
            this.f10259c = C2968s.m11532l().m11808a(d);
            this.f10258b = true;
        }
    }
}
