package com.miui.support.internal.variable;

import android.os.Build.VERSION;

public abstract class AbsClassFactory {
    protected static final int CURRENT_SUPPORT_SDK_VERSION;
    protected static final int MIN_SUPPORT_SDK_VERSION = 16;

    public abstract Object get();

    static {
        CURRENT_SUPPORT_SDK_VERSION = VERSION.SDK_INT;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.Object create(java.lang.String r8) {
        /*
        r7 = this;
        r0 = r7.getClass();
        r0 = r0.getPackage();
        r2 = r0.getName();
        r0 = CURRENT_SUPPORT_SDK_VERSION;
        r1 = r0;
    L_0x000f:
        r0 = 16;
        if (r1 < r0) goto L_0x004e;
    L_0x0013:
        r0 = java.util.Locale.US;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r2);
        r4 = ".v%d.%s";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r1);
        r4[r5] = r6;
        r5 = 1;
        r4[r5] = r8;
        r3 = java.lang.String.format(r0, r3, r4);
        r0 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x006f, Exception -> 0x0042 }
        r0 = r0.newInstance();	 Catch:{ ClassNotFoundException -> 0x006f, Exception -> 0x0042 }
    L_0x0041:
        return r0;
    L_0x0042:
        r0 = move-exception;
        r4 = com.miui.support.internal.variable.VariableExceptionHandler.getInstance();
        r4.onThrow(r3, r0);
    L_0x004a:
        r0 = r1 + -1;
        r1 = r0;
        goto L_0x000f;
    L_0x004e:
        r0 = com.miui.support.internal.variable.VariableExceptionHandler.getInstance();
        r1 = new java.lang.ClassNotFoundException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Cannot found class ";
        r2 = r2.append(r3);
        r2 = r2.append(r8);
        r2 = r2.toString();
        r1.<init>(r2);
        r0.onThrow(r8, r1);
        r0 = 0;
        goto L_0x0041;
    L_0x006f:
        r0 = move-exception;
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.internal.variable.AbsClassFactory.create(java.lang.String):java.lang.Object");
    }
}
