package com.google.android.gms.p151a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.C3465h;
import com.google.android.gms.common.internal.C3512u;

/* renamed from: com.google.android.gms.a.c */
public abstract class C2692c<T> {
    private final String f9224a;
    private T f9225b;

    /* renamed from: com.google.android.gms.a.c.a */
    public static class C2691a extends Exception {
        public C2691a(String str) {
            super(str);
        }

        public C2691a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C2692c(String str) {
        this.f9224a = str;
    }

    protected final T m10264a(Context context) {
        if (this.f9225b == null) {
            C3512u.m14580a((Object) context);
            Context d = C3465h.m14299d(context);
            if (d == null) {
                throw new C2691a("Could not get remote context.");
            }
            try {
                this.f9225b = m10265b((IBinder) d.getClassLoader().loadClass(this.f9224a).newInstance());
            } catch (Throwable e) {
                throw new C2691a("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new C2691a("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new C2691a("Could not access creator.", e22);
            }
        }
        return this.f9225b;
    }

    protected abstract T m10265b(IBinder iBinder);
}
