package com.facebook.ads.internal.p127e.p129b;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import anet.channel.security.ISecurity;
import java.io.Closeable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/* renamed from: com.facebook.ads.internal.e.b.m */
public class C2407m {
    static String m9252a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Object fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        return TextUtils.isEmpty(fileExtensionFromUrl) ? null : singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    private static String m9253a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString();
    }

    static void m9254a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                Log.e("ProxyCache", "Error closing resource", e);
            }
        }
    }

    static void m9255a(byte[] bArr, long j, int i) {
        boolean z = true;
        C2404j.m9250a((Object) bArr, "Buffer must be not null!");
        C2404j.m9251a(j >= 0, "Data offset must be positive!");
        if (i < 0 || i > bArr.length) {
            z = false;
        }
        C2404j.m9251a(z, "Length must be in range [0..buffer.length]");
    }

    static String m9256b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Throwable e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    static String m9257c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Throwable e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    public static String m9258d(String str) {
        try {
            return C2407m.m9253a(MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5).digest(str.getBytes()));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
