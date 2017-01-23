package com.xiaomi.push.service;

import com.xiaomi.xmpush.thrift.C4519c;
import com.xiaomi.xmpush.thrift.C4520d;

/* renamed from: com.xiaomi.push.service.x */
/* synthetic */ class C4447x {
    static final /* synthetic */ int[] f15167a;
    static final /* synthetic */ int[] f15168b;

    static {
        f15168b = new int[C4520d.values().length];
        try {
            f15168b[C4520d.INT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f15168b[C4520d.LONG.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f15168b[C4520d.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f15168b[C4520d.BOOLEAN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f15167a = new int[C4519c.values().length];
        try {
            f15167a[C4519c.MISC_CONFIG.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f15167a[C4519c.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
    }
}
