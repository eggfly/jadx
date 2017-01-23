package com.p105c.p106a.p107a.p108a;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

/* renamed from: com.c.a.a.a.d */
public class C2090d {
    public static final String m7806a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        Object a = C2089c.m7805a(currentTimeMillis);
        Object a2 = C2089c.m7805a(nanoTime);
        Object a3 = C2089c.m7805a(nextInt);
        Object a4 = C2089c.m7805a(nextInt2);
        Object obj = new byte[16];
        System.arraycopy(a, 0, obj, 0, 4);
        System.arraycopy(a2, 0, obj, 4, 4);
        System.arraycopy(a3, 0, obj, 8, 4);
        System.arraycopy(a4, 0, obj, 12, 4);
        return C2088b.m7802b(obj, 2);
    }

    public static String m7807a(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                str = telephonyManager != null ? telephonyManager.getDeviceId() : null;
            } catch (Exception e) {
            }
        }
        return C2091e.m7809a(str) ? C2090d.m7806a() : str;
    }

    public static String m7808b(Context context) {
        String str = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                str = telephonyManager != null ? telephonyManager.getSubscriberId() : null;
            } catch (Exception e) {
            }
        }
        return C2091e.m7809a(str) ? C2090d.m7806a() : str;
    }
}
