package com.cmcm.support.p116a;

import android.support.v4.view.MotionEventCompat;
import org.android.agoo.message.MessageService;

/* renamed from: com.cmcm.support.a.j */
public final class C2197j {
    public static String m8263a(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & MotionEventCompat.ACTION_MASK);
            if (toHexString.length() < 2) {
                stringBuilder.append(MessageService.MSG_DB_READY_REPORT);
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }
}
