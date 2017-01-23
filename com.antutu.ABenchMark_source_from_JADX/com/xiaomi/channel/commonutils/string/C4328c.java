package com.xiaomi.channel.commonutils.string;

import android.support.v4.media.TransportMediator;
import anet.channel.security.ISecurity;
import com.xiaomi.pushsdk.BuildConfig;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.channel.commonutils.string.c */
public class C4328c {
    private static String m17738a(byte b) {
        int i = (b & TransportMediator.KEYCODE_MEDIA_PAUSE) + (b < null ? SpdyProtocol.SLIGHTSSLV2 : 0);
        return (i < 16 ? MessageService.MSG_DB_READY_REPORT : BuildConfig.FLAVOR) + Integer.toHexString(i).toLowerCase();
    }

    public static String m17739a(String str) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            StringBuffer stringBuffer = new StringBuffer();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            while (i < digest.length) {
                stringBuffer.append(C4328c.m17738a(digest[i]));
                i++;
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String m17740b(String str) {
        return C4328c.m17739a(str).subSequence(8, 24).toString();
    }
}
