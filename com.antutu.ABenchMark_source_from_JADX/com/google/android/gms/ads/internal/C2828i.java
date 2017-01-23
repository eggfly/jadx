package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.C2827g;
import com.google.android.gms.p146b.C3319j;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.hi;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@gb
/* renamed from: com.google.android.gms.ads.internal.i */
class C2828i implements C2827g, Runnable {
    CountDownLatch f9573a;
    private final List<Object[]> f9574b;
    private final AtomicReference<C2827g> f9575c;
    private C2970t f9576d;

    public C2828i(C2970t c2970t) {
        this.f9574b = new Vector();
        this.f9575c = new AtomicReference();
        this.f9573a = new CountDownLatch(1);
        this.f9576d = c2970t;
        if (C2784w.m10741a().m11571b()) {
            hi.m13004a((Runnable) this);
        } else {
            run();
        }
    }

    private Context m10936b(Context context) {
        if (!((Boolean) aq.f10299m.m11794c()).booleanValue()) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    private void m10937b() {
        if (!this.f9574b.isEmpty()) {
            for (Object[] objArr : this.f9574b) {
                if (objArr.length == 1) {
                    ((C2827g) this.f9575c.get()).m10935a((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((C2827g) this.f9575c.get()).m10934a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.f9574b.clear();
        }
    }

    protected C2827g m10938a(String str, Context context, boolean z) {
        return C3319j.m13505a(str, context, z);
    }

    public String m10939a(Context context) {
        if (m10944a()) {
            C2827g c2827g = (C2827g) this.f9575c.get();
            if (c2827g != null) {
                m10937b();
                return c2827g.m10932a(m10936b(context));
            }
        }
        return BuildConfig.FLAVOR;
    }

    public String m10940a(Context context, String str) {
        if (m10944a()) {
            C2827g c2827g = (C2827g) this.f9575c.get();
            if (c2827g != null) {
                m10937b();
                return c2827g.m10933a(m10936b(context), str);
            }
        }
        return BuildConfig.FLAVOR;
    }

    public void m10941a(int i, int i2, int i3) {
        C2827g c2827g = (C2827g) this.f9575c.get();
        if (c2827g != null) {
            m10937b();
            c2827g.m10934a(i, i2, i3);
            return;
        }
        this.f9574b.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void m10942a(MotionEvent motionEvent) {
        C2827g c2827g = (C2827g) this.f9575c.get();
        if (c2827g != null) {
            m10937b();
            c2827g.m10935a(motionEvent);
            return;
        }
        this.f9574b.add(new Object[]{motionEvent});
    }

    protected void m10943a(C2827g c2827g) {
        this.f9575c.set(c2827g);
    }

    protected boolean m10944a() {
        try {
            this.f9573a.await();
            return true;
        } catch (Throwable e) {
            C2972b.m11584d("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public void run() {
        try {
            boolean z = !((Boolean) aq.f10311y.m11794c()).booleanValue() || this.f9576d.f10058e.f10084e;
            m10943a(m10938a(this.f9576d.f10058e.f10081b, m10936b(this.f9576d.f10056c), z));
        } finally {
            this.f9573a.countDown();
            this.f9576d = null;
        }
    }
}
