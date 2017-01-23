package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.channel.commonutils.string.C4329d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.xiaomi.push.service.s */
public class C4438s {
    private static Object f15151a;
    private static Map<String, Queue<String>> f15152b;

    static {
        f15151a = new Object();
        f15152b = new HashMap();
    }

    public static boolean m18345a(XMPushService xMPushService, String str, String str2) {
        synchronized (f15151a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Collection collection = (Queue) f15152b.get(str);
            if (collection == null) {
                String[] split = sharedPreferences.getString(str, BuildConfig.FLAVOR).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                collection = new LinkedList();
                for (Object add : split) {
                    collection.add(add);
                }
                f15152b.put(str, collection);
            }
            if (collection.contains(str2)) {
                return true;
            }
            collection.add(str2);
            if (collection.size() > 25) {
                collection.poll();
            }
            String a = C4329d.m17743a(collection, Constants.ACCEPT_TIME_SEPARATOR_SP);
            Editor edit = sharedPreferences.edit();
            edit.putString(str, a);
            edit.commit();
            return false;
        }
    }
}
