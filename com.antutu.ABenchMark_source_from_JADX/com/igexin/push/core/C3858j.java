package com.igexin.push.core;

/* renamed from: com.igexin.push.core.j */
/* synthetic */ class C3858j {
    static final /* synthetic */ int[] f12994a;
    static final /* synthetic */ int[] f12995b;

    static {
        f12995b = new int[C3859k.m15902a().length];
        try {
            f12995b[C3859k.HEARTBEAT_OK.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f12995b[C3859k.HEARTBEAT_TIMEOUT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f12995b[C3859k.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f12995b[C3859k.NETWORK_SWITCH.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f12994a = new int[C3860l.m15903a().length];
        try {
            f12994a[C3860l.DETECT.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f12994a[C3860l.STABLE.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f12994a[C3860l.PENDING.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}
