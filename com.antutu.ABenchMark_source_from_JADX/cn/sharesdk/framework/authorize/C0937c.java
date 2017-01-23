package cn.sharesdk.framework.authorize;

import android.content.Intent;

/* renamed from: cn.sharesdk.framework.authorize.c */
public class C0937c extends C0936a {
    protected SSOListener f3195b;
    private C0916d f3196c;

    public void m4119a(SSOListener sSOListener) {
        this.f3195b = sSOListener;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f3196c.m4033a(i, i2, intent);
    }

    public void onCreate() {
        this.f3196c = this.a.getSSOProcessor(this);
        if (this.f3196c == null) {
            finish();
            AuthorizeListener authorizeListener = this.a.getAuthorizeListener();
            if (authorizeListener != null) {
                authorizeListener.onError(new Throwable("Failed to start SSO for " + this.a.getPlatform().getName()));
                return;
            }
            return;
        }
        this.f3196c.m4032a(32973);
        this.f3196c.m4031a();
    }

    public void onNewIntent(Intent intent) {
        this.f3196c.m4034a(intent);
    }
}
