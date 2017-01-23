package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.C4302b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.j */
public class C4421j {
    private static final Map<String, byte[]> f15091a;
    private static ArrayList<Pair<String, byte[]>> f15092b;

    static {
        f15091a = new HashMap();
        f15092b = new ArrayList();
    }

    public static void m18245a(Context context, int i, String str) {
        synchronized (f15091a) {
            for (String str2 : f15091a.keySet()) {
                C4421j.m18246a(context, str2, (byte[]) f15091a.get(str2), i, str);
            }
            f15091a.clear();
        }
    }

    public static void m18246a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, C4407b.m18182a(str));
    }

    public static void m18247a(XMPushService xMPushService) {
        try {
            synchronized (f15091a) {
                for (String str : f15091a.keySet()) {
                    xMPushService.m18089a(str, (byte[]) f15091a.get(str));
                }
                f15091a.clear();
            }
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            xMPushService.m18079a(10, e);
        }
    }

    public static void m18248a(String str, byte[] bArr) {
        synchronized (f15091a) {
            f15091a.put(str, bArr);
        }
    }

    public static void m18249b(XMPushService xMPushService) {
        try {
            ArrayList arrayList;
            synchronized (f15092b) {
                arrayList = f15092b;
                f15092b = new ArrayList();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                xMPushService.m18089a((String) pair.first, (byte[]) pair.second);
            }
        } catch (Exception e) {
            C4302b.m17651a((Throwable) e);
            xMPushService.m18079a(10, e);
        }
    }

    public static void m18250b(String str, byte[] bArr) {
        synchronized (f15092b) {
            f15092b.add(new Pair(str, bArr));
            if (f15092b.size() > 50) {
                f15092b.remove(0);
            }
        }
    }
}
