package com.xiaomi.mipush.sdk;

import com.xiaomi.xmpush.thrift.C4513a;

/* renamed from: com.xiaomi.mipush.sdk.l */
/* synthetic */ class C4356l {
    static final /* synthetic */ int[] f14816a;

    static {
        f14816a = new int[C4513a.values().length];
        try {
            f14816a[C4513a.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f14816a[C4513a.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f14816a[C4513a.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f14816a[C4513a.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f14816a[C4513a.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f14816a[C4513a.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f14816a[C4513a.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f14816a[C4513a.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f14816a[C4513a.Notification.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f14816a[C4513a.Command.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
    }
}
