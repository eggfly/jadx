package com.igexin.push.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.text.TextUtils;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3742a;
import com.igexin.push.config.C3754m;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.bean.C3823c;
import com.igexin.push.core.bean.C3826f;
import com.igexin.push.core.bean.C3827g;
import com.igexin.sdk.PushBuildConfig;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.igexin.push.util.a */
public class C3922a {
    private static final String f13191a;

    static {
        f13191a = C3922a.class.getName();
    }

    public static void m16137a(C3827g c3827g) {
        C3855g.ao = 0;
        C3855g.ap = 0;
        C3855g.ar = c3827g;
        Map b = c3827g.m15734b();
        C3826f c3826f;
        if (C3754m.f12675s != null) {
            int intValue;
            Map b2 = C3754m.f12675s.m15734b();
            List<Integer> arrayList = new ArrayList();
            for (Entry entry : b2.entrySet()) {
                intValue = ((Integer) entry.getKey()).intValue();
                c3826f = (C3826f) entry.getValue();
                if (!b.containsKey(Integer.valueOf(intValue))) {
                    C3855g.as = true;
                    C3926e.m16166b(c3826f.m15719c());
                    arrayList.add(Integer.valueOf(intValue));
                }
            }
            if (!arrayList.isEmpty()) {
                for (Integer intValue2 : arrayList) {
                    b2.remove(Integer.valueOf(intValue2.intValue()));
                }
                C3742a.m15382a().m15399g();
            }
            boolean z = true;
            for (Entry entry2 : b.entrySet()) {
                boolean z2;
                intValue = ((Integer) entry2.getKey()).intValue();
                c3826f = (C3826f) entry2.getValue();
                if (b2.containsKey(Integer.valueOf(intValue))) {
                    if (!((C3826f) b2.get(Integer.valueOf(intValue))).m15716b().equals(c3826f.m15716b())) {
                        C3855g.as = true;
                        C3855g.ao++;
                        C3926e.m16158a(c3826f);
                        z = false;
                    }
                    z2 = z;
                } else {
                    C3855g.ao++;
                    C3926e.m16158a(c3826f);
                    z2 = false;
                }
                z = z2;
            }
            if (z) {
                C3754m.f12675s.m15732a(c3827g.m15731a());
                C3742a.m15382a().m15399g();
                Process.killProcess(Process.myPid());
                return;
            }
            return;
        }
        for (Entry entry22 : b.entrySet()) {
            c3826f = (C3826f) entry22.getValue();
            C3855g.ao++;
            C3926e.m16158a(c3826f);
        }
    }

    private static void m16138a(Map map, String str) {
        C3823c c3823c = (C3823c) map.get(str);
        map.remove(str);
        for (String str2 : c3823c.m15703b()) {
            C3823c c3823c2 = (C3823c) map.get(str2);
            if (c3823c2 != null) {
                c3823c2.m15706e();
                if (c3823c2.m15704c() == 0) {
                    C3922a.m16138a(map, str2);
                }
            }
        }
    }

    public static boolean m16139a() {
        try {
            if (PushBuildConfig.sdk_conf_debug_level.equals(C3754m.f12676t)) {
                return false;
            }
            for (String b : C3754m.f12676t.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (C3922a.m16146b(b)) {
                    return false;
                }
            }
            if (PushBuildConfig.sdk_conf_debug_level.equals(C3754m.f12677u)) {
                return false;
            }
            String[] split = C3754m.f12677u.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            Class cls = Class.forName("android.os.ServiceManager");
            Method method = cls.getMethod("getService", new Class[]{String.class});
            method.setAccessible(true);
            for (String a : split) {
                if (C3922a.m16141a(cls, method, a)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m16140a(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return queryIntentServices != null && queryIntentServices.size() > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean m16141a(Class cls, Method method, String str) {
        try {
            return method.invoke(cls, new Object[]{str}) != null;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean m16142a(String str) {
        try {
            return C3855g.f12969g.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m16143a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            return C3855g.f12969g.getPackageManager().resolveActivity(intent, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m16144a(JSONObject jSONObject) {
        try {
            C3823c c3823c;
            Map hashMap = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                C3823c c3823c2 = new C3823c();
                if (jSONObject2.has("actionid")) {
                    c3823c2.m15701a(jSONObject2.getString("actionid"));
                    List arrayList = new ArrayList();
                    if (jSONObject2.has(C4233j.f14402y)) {
                        String string = jSONObject2.getString(C4233j.f14402y);
                        if (AgooConstants.MESSAGE_POPUP.equals(string)) {
                            if (jSONObject2.has("buttons")) {
                                JSONArray jSONArray2 = jSONObject2.getJSONArray("buttons");
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    if (((JSONObject) jSONArray2.get(i2)).has("do")) {
                                        arrayList.add(((JSONObject) jSONArray2.get(i2)).getString("do"));
                                    }
                                }
                            }
                            if (jSONObject2.has("do")) {
                                arrayList.add(jSONObject2.getString("do"));
                            }
                        } else if ("startapp".equals(string)) {
                            if (jSONObject2.has("noinstall_action")) {
                                arrayList.add(jSONObject2.getString("noinstall_action"));
                            }
                            if (jSONObject2.has("do")) {
                                arrayList.add(jSONObject2.getString("do"));
                            }
                        } else if ("checkapp".equals(string)) {
                            if (jSONObject2.has("do_installed")) {
                                arrayList.add(jSONObject2.getString("do_installed"));
                            }
                            if (jSONObject2.has("do_uninstalled")) {
                                arrayList.add(jSONObject2.getString("do_uninstalled"));
                            }
                        } else if ("checkversions".equals(string)) {
                            if (jSONObject2.has("do_match")) {
                                arrayList.add(jSONObject2.getString("do_match"));
                            }
                            if (jSONObject2.has("do_dismatch")) {
                                arrayList.add(jSONObject2.getString("do_dismatch"));
                            }
                            if (jSONObject2.has("do")) {
                                arrayList.add(jSONObject2.getString("do"));
                            }
                        } else if ("startintent".equals(string)) {
                            if (jSONObject2.has("do_failed")) {
                                arrayList.add(jSONObject2.getString("do_failed"));
                            }
                            if (jSONObject2.has("do")) {
                                arrayList.add(jSONObject2.getString("do"));
                            }
                        } else if (!"null".equals(string) && jSONObject2.has("do")) {
                            arrayList.add(jSONObject2.getString("do"));
                        }
                        c3823c2.m15702a(arrayList);
                        hashMap.put(c3823c2.m15700a(), c3823c2);
                    } else {
                        continue;
                    }
                }
            }
            List<C3823c> arrayList2 = new ArrayList(hashMap.values());
            for (Entry value : hashMap.entrySet()) {
                List<String> b = ((C3823c) value.getValue()).m15703b();
                if (b != null) {
                    for (String str : b) {
                        c3823c = (C3823c) hashMap.get(str);
                        if (c3823c != null) {
                            c3823c.m15705d();
                            if (arrayList2.contains(c3823c)) {
                                arrayList2.remove(c3823c);
                            }
                        }
                    }
                }
            }
            for (C3823c c3823c3 : arrayList2) {
                C3922a.m16138a(hashMap, c3823c3.m15700a());
            }
            if (hashMap.size() > 0) {
                C3688a.m15097b(f13191a + "|action_chains have loop nodeMap not empty");
                return true;
            }
        } catch (Throwable th) {
            C3688a.m15097b(f13191a + "|isHaveLoop exception :" + th.toString());
        }
        return false;
    }

    public static boolean m16145b() {
        return System.currentTimeMillis() > C3754m.f12659c;
    }

    private static boolean m16146b(String str) {
        try {
            C3855g.f12969g.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m16147c() {
        try {
            PackageManager packageManager = C3855g.f12969g.getPackageManager();
            String packageName = C3855g.f12969g.getPackageName();
            return packageManager.checkPermission(MsgConstant.PERMISSION_ACCESS_WIFI_STATE, packageName) == 0 && packageManager.checkPermission("android.permission.CHANGE_WIFI_STATE", packageName) == 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean m16148d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) C3855g.f12969g.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean m16149e() {
        try {
            Class.forName("android.support.v4.content.LocalBroadcastManager");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
