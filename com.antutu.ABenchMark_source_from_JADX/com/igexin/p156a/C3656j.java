package com.igexin.p156a;

import android.os.Build;
import android.os.Build.VERSION;

/* renamed from: com.igexin.a.j */
final class C3656j implements C3651e {
    C3656j() {
    }

    public void m14926a(String str) {
        System.loadLibrary(str);
    }

    public String[] m14927a() {
        if (VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS;
        }
        return new String[]{Build.CPU_ABI};
    }

    public void m14928b(String str) {
        System.load(str);
    }

    public String m14929c(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    public String m14930d(String str) {
        return str.substring(3, str.length() - 3);
    }
}
