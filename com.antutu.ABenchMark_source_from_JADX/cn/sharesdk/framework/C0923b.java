package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.C0916d;
import cn.sharesdk.framework.authorize.C0937c;
import cn.sharesdk.framework.authorize.C0942e;
import cn.sharesdk.framework.authorize.SSOListener;

/* renamed from: cn.sharesdk.framework.b */
public abstract class C0923b implements AuthorizeHelper {
    protected Platform f3141a;
    private AuthorizeListener f3142b;
    private SSOListener f3143c;

    public C0923b(Platform platform) {
        this.f3141a = platform;
    }

    protected void m4044a(SSOListener sSOListener) {
        this.f3143c = sSOListener;
        C0937c c0937c = new C0937c();
        c0937c.m4119a(sSOListener);
        c0937c.m4118a(this);
    }

    protected void m4045b(AuthorizeListener authorizeListener) {
        this.f3142b = authorizeListener;
        C0942e c0942e = new C0942e();
        c0942e.m4123a(this.f3142b);
        c0942e.m4118a(this);
    }

    public int m4046c() {
        return this.f3141a.getPlatformId();
    }

    public AuthorizeListener getAuthorizeListener() {
        return this.f3142b;
    }

    public Platform getPlatform() {
        return this.f3141a;
    }

    public SSOListener getSSOListener() {
        return this.f3143c;
    }

    public C0916d getSSOProcessor(C0937c c0937c) {
        return null;
    }
}
