package com.antutu.utils;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipUtil {
    public static byte[] compress(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String uncompress(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return BuildConfig.FLAVOR;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read < 0) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }
}
