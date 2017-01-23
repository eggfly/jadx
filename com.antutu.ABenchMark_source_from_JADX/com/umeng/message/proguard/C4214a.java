package com.umeng.message.proguard;

import com.umeng.message.util.HttpRequest;
import java.io.UnsupportedEncodingException;

/* renamed from: com.umeng.message.proguard.a */
public class C4214a {
    private static IllegalStateException m17192a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static String m17193a(byte[] bArr) {
        return C4214a.m17194a(bArr, C4218e.f14336a);
    }

    public static String m17194a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw C4214a.m17192a(str, e);
        }
    }

    public static byte[] m17195a(String str) {
        return C4214a.m17196a(str, C4218e.f14336a);
    }

    public static byte[] m17196a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            throw C4214a.m17192a(str2, e);
        }
    }

    public static String m17197b(byte[] bArr) {
        return C4214a.m17194a(bArr, C4218e.f14337b);
    }

    public static byte[] m17198b(String str) {
        return C4214a.m17196a(str, C4218e.f14337b);
    }

    public static String m17199c(byte[] bArr) {
        return C4214a.m17194a(bArr, C4218e.f14338c);
    }

    public static byte[] m17200c(String str) {
        return C4214a.m17196a(str, C4218e.f14338c);
    }

    public static String m17201d(byte[] bArr) {
        return C4214a.m17194a(bArr, C4218e.f14339d);
    }

    public static byte[] m17202d(String str) {
        return C4214a.m17196a(str, C4218e.f14339d);
    }

    public static String m17203e(byte[] bArr) {
        return C4214a.m17194a(bArr, C4218e.f14340e);
    }

    public static byte[] m17204e(String str) {
        return C4214a.m17196a(str, C4218e.f14340e);
    }

    public static String m17205f(byte[] bArr) {
        return C4214a.m17194a(bArr, HttpRequest.f14548a);
    }

    public static byte[] m17206f(String str) {
        return C4214a.m17196a(str, HttpRequest.f14548a);
    }
}
