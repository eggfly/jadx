package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.purchase.b */
public class C2880b {
    Object f9751a;
    private final Context f9752b;
    private final boolean f9753c;

    public C2880b(Context context) {
        this(context, true);
    }

    public C2880b(Context context, boolean z) {
        this.f9752b = context;
        this.f9753c = z;
    }

    public int m11200a(int i, String str, String str2) {
        try {
            Class loadClass = this.f9752b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("isBillingSupported", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.f9751a), new Object[]{Integer.valueOf(i), str, str2})).intValue();
        } catch (Throwable e) {
            if (this.f9753c) {
                C2972b.m11584d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public int m11201a(String str, String str2) {
        try {
            Class loadClass = this.f9752b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.f9751a), new Object[]{Integer.valueOf(3), str, str2})).intValue();
        } catch (Throwable e) {
            if (this.f9753c) {
                C2972b.m11584d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public Bundle m11202a(String str, String str2, String str3) {
        try {
            Class loadClass = this.f9752b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.f9751a), new Object[]{Integer.valueOf(3), str, str2, "inapp", str3});
        } catch (Throwable e) {
            if (this.f9753c) {
                C2972b.m11584d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }

    public void m11203a() {
        this.f9751a = null;
    }

    public void m11204a(IBinder iBinder) {
        try {
            this.f9751a = this.f9752b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
        } catch (Exception e) {
            if (this.f9753c) {
                C2972b.m11583d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            }
        }
    }

    public Bundle m11205b(String str, String str2) {
        try {
            Class loadClass = this.f9752b.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.f9751a), new Object[]{Integer.valueOf(3), str, "inapp", str2});
        } catch (Throwable e) {
            if (this.f9753c) {
                C2972b.m11584d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }
}
