package com.miui.support.internal.webkit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import com.miui.support.internal.hybrid.provider.AbsWebView;
import com.miui.support.internal.util.UrlResolverHelper;
import com.miui.support.util.UrlResolver;

public class WebViewClientDelegate {
    private boolean f2845a;
    private boolean f2846b;
    private DeviceAccountLogin f2847c;
    private LoginState f2848d;

    private enum LoginState {
        LOGIN_START,
        LOGIN_INPROGRESS,
        LOGIN_FINISHED
    }

    public WebViewClientDelegate() {
        this(-1);
    }

    public WebViewClientDelegate(int i) {
        this(i, -1);
    }

    public WebViewClientDelegate(int i, int i2) {
        boolean z;
        boolean z2 = true;
        this.f2848d = LoginState.LOGIN_FINISHED;
        int i3 = ((i2 ^ -1) & -1) | (i & i2);
        if ((i3 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2845a = z;
        if ((i3 & 2) == 0) {
            z2 = false;
        }
        this.f2846b = z2;
    }

    public boolean m4609a(AbsWebView absWebView, String str) {
        if (!this.f2845a || !UrlResolverHelper.m4259a(str)) {
            return false;
        }
        Context l = absWebView.m4124l();
        PackageManager packageManager = l.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addCategory("android.intent.category.BROWSABLE");
        ResolveInfo a = UrlResolver.m5446a(l, packageManager, intent);
        if (a == null) {
            return false;
        }
        if (a.activityInfo != null) {
            l.startActivity(intent);
        }
        return true;
    }

    public void m4607a(AbsWebView absWebView, String str, Bitmap bitmap) {
        if (this.f2846b && this.f2848d == LoginState.LOGIN_START) {
            this.f2848d = LoginState.LOGIN_INPROGRESS;
        }
    }

    public void m4610b(AbsWebView absWebView, String str) {
        if (this.f2846b && this.f2848d == LoginState.LOGIN_INPROGRESS) {
            this.f2848d = LoginState.LOGIN_FINISHED;
            this.f2847c.m4596d();
        }
    }

    public void m4608a(AbsWebView absWebView, String str, String str2, String str3) {
        if (this.f2846b) {
            Activity activity = (Activity) absWebView.m4125m().getContext();
            if (this.f2847c == null) {
                this.f2847c = new DefaultDeviceAccountLogin(activity, absWebView);
            }
            if (!absWebView.m4118f()) {
                this.f2848d = LoginState.LOGIN_START;
                absWebView.m4109a(4);
                this.f2847c.m4593a(str, str2, str3);
            } else if (absWebView.m4117e()) {
                absWebView.m4119g();
            } else {
                activity.finish();
            }
        }
    }
}
