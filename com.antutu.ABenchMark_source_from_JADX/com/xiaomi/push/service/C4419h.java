package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.string.C4329d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.h */
public class C4419h {
    private static C4419h f15083a;
    private Context f15084b;
    private List<String> f15085c;

    static {
        f15083a = null;
    }

    private C4419h(Context context) {
        int i = 0;
        this.f15085c = new ArrayList();
        this.f15084b = context.getApplicationContext();
        if (this.f15084b == null) {
            this.f15084b = context;
        }
        String[] split = this.f15084b.getSharedPreferences("mipush_app_info", 0).getString("unregistered_pkg_names", BuildConfig.FLAVOR).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int length = split.length;
        while (i < length) {
            CharSequence charSequence = split[i];
            if (TextUtils.isEmpty(charSequence)) {
                this.f15085c.add(charSequence);
            }
            i++;
        }
    }

    public static C4419h m18239a(Context context) {
        if (f15083a == null) {
            f15083a = new C4419h(context);
        }
        return f15083a;
    }

    public boolean m18240a(String str) {
        boolean contains;
        synchronized (this.f15085c) {
            contains = this.f15085c.contains(str);
        }
        return contains;
    }

    public void m18241b(String str) {
        synchronized (this.f15085c) {
            if (!this.f15085c.contains(str)) {
                this.f15085c.add(str);
                this.f15084b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C4329d.m17743a(this.f15085c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void m18242c(String str) {
        synchronized (this.f15085c) {
            if (this.f15085c.contains(str)) {
                this.f15085c.remove(str);
                this.f15084b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C4329d.m17743a(this.f15085c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
