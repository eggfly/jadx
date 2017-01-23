package cn.sharesdk.framework.authorize;

import android.content.Intent;

/* renamed from: cn.sharesdk.framework.authorize.d */
public abstract class C0916d {
    protected C0937c f3130a;
    protected int f3131b;
    protected SSOListener f3132c;

    public C0916d(C0937c c0937c) {
        this.f3130a = c0937c;
        this.f3132c = c0937c.m4117a().getSSOListener();
    }

    public abstract void m4031a();

    public void m4032a(int i) {
        this.f3131b = i;
    }

    public void m4033a(int i, int i2, Intent intent) {
    }

    protected void m4034a(Intent intent) {
    }
}
