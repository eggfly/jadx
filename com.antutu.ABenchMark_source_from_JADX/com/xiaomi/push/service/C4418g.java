package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.igexin.download.Downloads;
import com.qq.p035e.comm.pi.ACTD;
import com.xiaomi.channel.commonutils.android.C4293e;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4303a;
import com.xiaomi.channel.commonutils.network.C4318b;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.channel.commonutils.string.C4329d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Map;
import java.util.TreeMap;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.service.g */
public class C4418g {
    private static C4416f f15081a;
    private static C4417a f15082b;

    /* renamed from: com.xiaomi.push.service.g.a */
    public interface C4417a {
        void m18231a();
    }

    public static synchronized C4416f m18232a(Context context) {
        C4416f c4416f = null;
        synchronized (C4418g.class) {
            if (f15081a != null) {
                c4416f = f15081a;
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
                Object string = sharedPreferences.getString("uuid", null);
                Object string2 = sharedPreferences.getString(Constants.EXTRA_KEY_TOKEN, null);
                Object string3 = sharedPreferences.getString("security", null);
                String string4 = sharedPreferences.getString("app_id", null);
                String string5 = sharedPreferences.getString("app_token", null);
                String string6 = sharedPreferences.getString("package_name", null);
                Object string7 = sharedPreferences.getString("device_id", null);
                int i = sharedPreferences.getInt("env_type", 1);
                if (!TextUtils.isEmpty(string7) && string7.startsWith("a-")) {
                    string7 = C4293e.m17613e(context);
                    sharedPreferences.edit().putString("device_id", string7).commit();
                }
                if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3))) {
                    CharSequence e = C4293e.m17613e(context);
                    if ("com.xiaomi.xmsf".equals(context.getPackageName()) || TextUtils.isEmpty(e) || TextUtils.isEmpty(r8) || r8.equals(e)) {
                        f15081a = new C4416f(string, string2, string3, string4, string5, string6, i);
                        c4416f = f15081a;
                    } else {
                        C4302b.m17654d("erase the old account.");
                        C4418g.m18237b(context);
                    }
                }
            }
        }
        return c4416f;
    }

    public static synchronized C4416f m18233a(Context context, String str, String str2, String str3) {
        C4416f c4416f = null;
        synchronized (C4418g.class) {
            PackageInfo packageInfo;
            Map treeMap = new TreeMap();
            treeMap.put("devid", C4293e.m17608a(context));
            String str4 = C4418g.m18238c(context) ? "1000271" : str2;
            String str5 = C4418g.m18238c(context) ? "420100086271" : str3;
            String str6 = C4418g.m18238c(context) ? "com.xiaomi.xmsf" : str;
            treeMap.put(ACTD.APPID_KEY, str4);
            treeMap.put("apptoken", str5);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str6, SpdyProtocol.SLIGHTSSL_L7E);
            } catch (Throwable e) {
                C4302b.m17651a(e);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo != null ? String.valueOf(packageInfo.versionCode) : MessageService.MSG_DB_READY_REPORT);
            treeMap.put("sdkversion", Integer.toString(21));
            treeMap.put("packagename", str6);
            treeMap.put(com.taobao.accs.common.Constants.KEY_MODEL, Build.MODEL);
            treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, C4329d.m17742a(C4293e.m17611c(context)));
            treeMap.put(com.taobao.accs.common.Constants.KEY_OS_VERSION, VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + VERSION.INCREMENTAL);
            int b = C4293e.m17609b();
            if (b >= 0) {
                treeMap.put("space_id", Integer.toString(b));
            }
            CharSequence a = C4329d.m17742a(C4293e.m17615g(context));
            if (!TextUtils.isEmpty(a)) {
                treeMap.put("mac_address", a);
            }
            treeMap.put("android_id", C4293e.m17610b(context));
            C4318b a2 = C4321d.m17696a(context, C4418g.m18234a(), treeMap);
            String str7 = BuildConfig.FLAVOR;
            if (a2 != null) {
                str7 = a2.m17693a();
            }
            if (!TextUtils.isEmpty(str7)) {
                JSONObject jSONObject = new JSONObject(str7);
                if (jSONObject.getInt(com.taobao.accs.common.Constants.KEY_HTTP_CODE) == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(com.taobao.accs.common.Constants.KEY_DATA);
                    c4416f = new C4416f(jSONObject2.getString("userId") + "@xiaomi.com/an" + C4329d.m17741a(6), jSONObject2.getString(Constants.EXTRA_KEY_TOKEN), jSONObject2.getString("ssecurity"), str4, str5, str6, C4303a.m17659c());
                    C4418g.m18235a(context, c4416f);
                    f15081a = c4416f;
                } else {
                    C4421j.m18245a(context, jSONObject.getInt(com.taobao.accs.common.Constants.KEY_HTTP_CODE), jSONObject.optString(Downloads.COLUMN_DESCRIPTION));
                    C4302b.m17649a(str7);
                }
            }
        }
        return c4416f;
    }

    public static String m18234a() {
        if (C4303a.m17658b()) {
            return "http://10.237.14.141:9085/pass/register";
        }
        return "https://" + (C4303a.m17657a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com") + "/pass/register";
    }

    public static void m18235a(Context context, C4416f c4416f) {
        Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", c4416f.f15074a);
        edit.putString("security", c4416f.f15076c);
        edit.putString(Constants.EXTRA_KEY_TOKEN, c4416f.f15075b);
        edit.putString("app_id", c4416f.f15077d);
        edit.putString("package_name", c4416f.f15079f);
        edit.putString("app_token", c4416f.f15078e);
        edit.putString("device_id", C4293e.m17613e(context));
        edit.putInt("env_type", c4416f.f15080g);
        edit.commit();
        C4418g.m18236b();
    }

    public static void m18236b() {
        if (f15082b != null) {
            f15082b.m18231a();
        }
    }

    public static void m18237b(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f15081a = null;
        C4418g.m18236b();
    }

    private static boolean m18238c(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
