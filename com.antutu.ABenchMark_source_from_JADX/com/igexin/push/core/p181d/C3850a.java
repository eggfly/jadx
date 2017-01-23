package com.igexin.push.core.p181d;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;

/* renamed from: com.igexin.push.core.d.a */
public abstract class C3850a {
    protected Long f12911a;
    protected Activity f12912b;
    protected String f12913c;

    public C3850a() {
        this.f12911a = Long.valueOf(System.currentTimeMillis());
    }

    public Long m15836a() {
        return this.f12911a;
    }

    public void m15837a(Activity activity) {
        this.f12912b = activity;
    }

    public abstract void m15838a(Intent intent);

    public abstract void m15839a(Configuration configuration);

    public void m15840a(Long l) {
        this.f12911a = l;
    }

    public void m15841a(String str) {
        this.f12913c = str;
    }

    public abstract boolean m15842a(int i, KeyEvent keyEvent);

    public abstract boolean m15843a(Menu menu);

    public String m15844b() {
        return this.f12913c;
    }

    public abstract void m15845c();

    public abstract void m15846d();

    public abstract void m15847e();

    public abstract void m15848f();

    public abstract void m15849g();

    public abstract void m15850h();

    public abstract void m15851i();
}
