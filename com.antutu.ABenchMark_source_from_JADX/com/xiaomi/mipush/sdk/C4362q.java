package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4304b;
import com.xiaomi.channel.commonutils.misc.C4308d;
import com.xiaomi.channel.commonutils.string.C4329d;
import com.xiaomi.push.service.C4445v;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.xmpush.thrift.C4518b;
import com.xiaomi.xmpush.thrift.C4548s;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.xiaomi.mipush.sdk.q */
public class C4362q {
    public static void m17880a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        long j = sharedPreferences.getLong("last_sync_info", -1);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a = (long) C4445v.m18368a(context).m18372a(C4518b.SyncInfoFrequency.m18794a(), 1209600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (Math.abs(currentTimeMillis - j) > a) {
            C4362q.m17882a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    public static void m17881a(Context context, C4548s c4548s) {
        C4302b.m17649a("need to update local info with: " + c4548s.m19068h());
        String str = (String) c4548s.m19068h().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    C4343a.m17800a(context).m17805a(true);
                } else {
                    C4343a.m17800a(context).m17805a(false);
                }
            }
        }
        str = (String) c4548s.m19068h().get(Constants.EXTRA_KEY_ALIASES);
        if (str != null) {
            MiPushClient.removeAllAliases(context);
            if (!BuildConfig.FLAVOR.equals(str)) {
                for (String addAlias : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addAlias(context, addAlias);
                }
            }
        }
        str = (String) c4548s.m19068h().get(Constants.EXTRA_KEY_TOPICS);
        if (str != null) {
            MiPushClient.removeAllTopics(context);
            if (!BuildConfig.FLAVOR.equals(str)) {
                for (String addAlias2 : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addTopic(context, addAlias2);
                }
            }
        }
        str = (String) c4548s.m19068h().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str != null) {
            MiPushClient.removeAllAccounts(context);
            if (!BuildConfig.FLAVOR.equals(str)) {
                for (String addAccount : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addAccount(context, addAccount);
                }
            }
        }
    }

    public static void m17882a(Context context, boolean z) {
        C4308d.m17667a(context).m17670a(new C4363r(context, z));
    }

    private static void m17885b(Map<String, String> map, String str, String str2) {
        if (map != null && str != null && str2 != null) {
            map.put(str, str2);
        }
    }

    private static String m17886c(List<String> list) {
        String a = C4329d.m17742a(C4362q.m17887d(list));
        return (TextUtils.isEmpty(a) || a.length() <= 4) ? BuildConfig.FLAVOR : a.substring(0, 4).toLowerCase();
    }

    private static String m17887d(List<String> list) {
        if (C4304b.m17660a(list)) {
            return BuildConfig.FLAVOR;
        }
        List<String> arrayList = new ArrayList(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        String str = BuildConfig.FLAVOR;
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            str = str + str2;
        }
        return str;
    }
}
