package com.cmcm.p074a.p075a.p115d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.cmcm.a.a.d.a */
public class C2160a {
    private static C2160a f7517c;
    private String f7518a;
    private boolean f7519b;

    static {
        f7517c = null;
    }

    private C2160a() {
        this.f7518a = BuildConfig.FLAVOR;
        this.f7519b = false;
    }

    public static IInterface m8145a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C2162d)) ? new C2163c(iBinder) : queryLocalInterface;
    }

    static C2166g m8146a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            Object c2166g = new C2166g();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, c2166g, 1)) {
                    return c2166g;
                }
            } catch (SecurityException e) {
            }
            return null;
        } catch (NameNotFoundException e2) {
            return null;
        }
    }

    public static C2160a m8150b() {
        if (f7517c == null) {
            f7517c = new C2160a();
        }
        return f7517c;
    }

    public String m8151a() {
        return this.f7518a;
    }

    public void m8152b(Context context) {
        if (TextUtils.isEmpty(this.f7518a)) {
            new Thread(new C2161b(this, context)).start();
        }
    }
}
