package com.xiaomi.mipush.sdk;

import com.xiaomi.xmpush.thrift.C4513a;

/* renamed from: com.xiaomi.mipush.sdk.n */
/* synthetic */ class C4358n {
    static final /* synthetic */ int[] f14821a;

    static {
        f14821a = new int[C4513a.values().length];
        try {
            f14821a[C4513a.SendMessage.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f14821a[C4513a.Registration.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f14821a[C4513a.UnRegistration.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f14821a[C4513a.Subscription.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f14821a[C4513a.UnSubscription.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f14821a[C4513a.Command.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f14821a[C4513a.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
