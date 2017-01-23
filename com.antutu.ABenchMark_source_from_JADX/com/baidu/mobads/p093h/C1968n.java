package com.baidu.mobads.p093h;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.mobads.p093h.C1960g.C1959c;

/* renamed from: com.baidu.mobads.h.n */
class C1968n implements Runnable {
    final /* synthetic */ C1959c f6851a;
    final /* synthetic */ Handler f6852b;
    final /* synthetic */ C1960g f6853c;

    C1968n(C1960g c1960g, C1959c c1959c, Handler handler) {
        this.f6853c = c1960g;
        this.f6851a = c1959c;
        this.f6852b = handler;
    }

    public void run() {
        Editor edit;
        try {
            synchronized (C1960g.class) {
                this.f6853c.m7332b(this.f6851a, this.f6852b);
            }
            edit = this.f6853c.m7342j().edit();
            edit.putString("previousProxyVersion", this.f6853c.m7345a());
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Throwable th) {
            try {
                String str = "Load APK Failed: " + th.toString();
                this.f6853c.f6842l.m7400e("XAdApkLoader", str);
                this.f6853c.m7335b(false);
                edit = this.f6853c.m7342j().edit();
                edit.putString("previousProxyVersion", this.f6853c.m7345a());
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            } catch (Throwable th2) {
                Editor edit2 = this.f6853c.m7342j().edit();
                edit2.putString("previousProxyVersion", this.f6853c.m7345a());
                if (VERSION.SDK_INT >= 9) {
                    edit2.apply();
                } else {
                    edit2.commit();
                }
            }
        }
    }
}
