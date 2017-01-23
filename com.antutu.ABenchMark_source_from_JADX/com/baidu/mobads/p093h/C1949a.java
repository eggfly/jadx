package com.baidu.mobads.p093h;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p093h.C1960g.C1957a;

/* renamed from: com.baidu.mobads.h.a */
public class C1949a {
    private static IXAdContainerFactory f6799e;
    public double f6800a;
    private Context f6801b;
    private Class<?> f6802c;
    private double f6803d;
    private Boolean f6804f;
    private IXAdLogger f6805g;

    public C1949a(Class<?> cls, Context context, double d, Boolean bool) {
        this.f6802c = null;
        this.f6800a = 0.1d;
        this.f6805g = C1991m.m7449a().m7457f();
        this.f6802c = cls;
        this.f6801b = context;
        this.f6803d = d;
        this.f6804f = bool;
    }

    public IXAdContainerFactory m7289a() {
        if (f6799e == null) {
            try {
                f6799e = (IXAdContainerFactory) this.f6802c.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f6801b});
                this.f6800a = f6799e.getRemoteVersion();
                f6799e.setDebugMode(this.f6804f);
                f6799e.handleShakeVersion(this.f6803d, "8.8");
            } catch (Throwable th) {
                this.f6805g.m7408w("XAdContainerFactoryBuilder", th.getMessage());
                C1957a c1957a = new C1957a("newXAdContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f6799e;
    }

    public void m7290b() {
        f6799e = null;
    }
}
