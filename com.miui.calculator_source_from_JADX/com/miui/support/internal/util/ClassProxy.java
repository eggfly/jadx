package com.miui.support.internal.util;

import com.miui.support.reflect.ReflectUtils;

public abstract class ClassProxy<T> {
    private long[] mCookies;
    private final Object mFinalizerGuardian;
    private long mPtr;

    /* renamed from: com.miui.support.internal.util.ClassProxy.1 */
    class C02891 {
        final /* synthetic */ ClassProxy f2544a;

        C02891(ClassProxy classProxy) {
            this.f2544a = classProxy;
        }

        protected void finalize() {
            try {
                this.f2544a.disposeNative();
            } finally {
                super.finalize();
            }
        }
    }

    private native long attachMethodNative(String str, String str2);

    private native void detachMethodNative(long j);

    private native void disposeNative();

    private native void initNative(Class<? extends T> cls);

    public static native boolean setupClassHook(int i, String str);

    public static native boolean setupInterpreterHook();

    public static native void setupResourceHook();

    protected abstract void handle();

    static {
        System.loadLibrary("miuiclassproxy");
    }

    public ClassProxy(Class<? extends T> cls) {
        this.mFinalizerGuardian = new C02891(this);
        this.mCookies = null;
        this.mPtr = 0;
        initNative(cls);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addCookie(long r10) {
        /*
        r9 = this;
        r2 = -1;
        r1 = 0;
        r0 = r9.mCookies;
        if (r0 != 0) goto L_0x0010;
    L_0x0006:
        r0 = 4;
        r0 = new long[r0];
        r9.mCookies = r0;
        r0 = r9.mCookies;
        r0[r1] = r10;
    L_0x000f:
        return;
    L_0x0010:
        r0 = r1;
    L_0x0011:
        r3 = r9.mCookies;
        r3 = r3.length;
        if (r0 >= r3) goto L_0x0046;
    L_0x0016:
        r3 = r9.mCookies;
        r4 = r3[r0];
        r6 = 0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x0028;
    L_0x0020:
        r3 = r9.mCookies;
        r4 = r3[r0];
        r3 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r3 != 0) goto L_0x0043;
    L_0x0028:
        if (r0 != r2) goto L_0x003e;
    L_0x002a:
        r0 = r9.mCookies;
        r0 = r0.length;
        r0 = r0 + 4;
        r2 = new long[r0];
        r0 = r9.mCookies;
        r3 = r9.mCookies;
        r3 = r3.length;
        java.lang.System.arraycopy(r0, r1, r2, r1, r3);
        r0 = r9.mCookies;
        r0 = r0.length;
        r9.mCookies = r2;
    L_0x003e:
        r1 = r9.mCookies;
        r1[r0] = r10;
        goto L_0x000f;
    L_0x0043:
        r0 = r0 + 1;
        goto L_0x0011;
    L_0x0046:
        r0 = r2;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.internal.util.ClassProxy.addCookie(long):void");
    }

    private boolean validateCookie(long j, boolean z) {
        int i = 0;
        while (i < this.mCookies.length) {
            if (this.mCookies[i] == j) {
                break;
            }
            i++;
        }
        i = -1;
        if (i < 0) {
            return false;
        }
        if (z) {
            this.mCookies[i] = 0;
        }
        return true;
    }

    protected final long attachMethod(String str, String str2) {
        long attachMethodNative;
        synchronized (this.mFinalizerGuardian) {
            attachMethodNative = attachMethodNative(str, str2);
            addCookie(attachMethodNative);
        }
        return attachMethodNative;
    }

    protected final long attachConstructor(String str) {
        return attachMethod(ReflectUtils.OBJECT_CONSTRUCTOR, str);
    }

    protected final void detachMethod(long j) {
        synchronized (this.mFinalizerGuardian) {
            if (validateCookie(j, true)) {
                detachMethodNative(j);
            }
        }
    }

    protected final void dispose() {
        disposeNative();
    }
}
