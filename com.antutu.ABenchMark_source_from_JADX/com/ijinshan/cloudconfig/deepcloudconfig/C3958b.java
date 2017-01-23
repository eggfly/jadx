package com.ijinshan.cloudconfig.deepcloudconfig;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ijinshan.cloudconfig.deepcloudconfig.b */
public class C3958b {
    private static volatile HashMap<String, JSONObject> f13276a;
    private static boolean f13277b;
    private static List<String> f13278c;

    static {
        f13276a = new HashMap();
        f13277b = false;
        f13278c = new ArrayList();
    }

    public static double m16284a(Integer num, String str, String str2, double d) {
        JSONObject a = C3958b.m16288a(num, str);
        if (a != null) {
            try {
                d = a.optDouble(str2, d);
            } catch (Exception e) {
            }
        }
        return d;
    }

    public static int m16285a(Integer num, String str, String str2, int i) {
        JSONObject a = C3958b.m16288a(num, str);
        if (a != null) {
            try {
                i = a.optInt(str2, i);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public static long m16286a(Integer num, String str, String str2, long j) {
        JSONObject a = C3958b.m16288a(num, str);
        if (a != null) {
            try {
                j = a.optLong(str2, j);
            } catch (Exception e) {
            }
        }
        return j;
    }

    public static String m16287a(Integer num, String str, String str2, String str3) {
        JSONObject a = C3958b.m16288a(num, str);
        if (a != null) {
            try {
                str3 = a.optString(str2, str3);
            } catch (Exception e) {
            }
        }
        return str3;
    }

    private static synchronized JSONObject m16288a(Integer num, String str) {
        JSONObject jSONObject;
        synchronized (C3958b.class) {
            String str2 = num + Constants.ACCEPT_TIME_SEPARATOR_SP + str;
            jSONObject = (JSONObject) f13276a.get(str2);
            if (jSONObject == null || f13277b) {
                Object b = C3957a.m16278a().m16282b(num, str);
                if (TextUtils.isEmpty(b)) {
                    if (jSONObject != null) {
                        f13278c.add(str2);
                    }
                    jSONObject = null;
                } else {
                    try {
                        jSONObject = new JSONObject(b);
                        f13276a.put(str2, jSONObject);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                }
            }
        }
        return jSONObject;
    }

    public static void m16289a() {
        f13278c.clear();
        if (f13276a.size() > 0) {
            Set<String> keySet = f13276a.keySet();
            if (keySet != null && keySet.size() > 0) {
                f13277b = true;
                for (String split : keySet) {
                    try {
                        String[] split2 = split.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        if (split2 != null && split2.length == 2) {
                            C3958b.m16288a(Integer.valueOf(Integer.parseInt(split2[0])), split2[1]);
                        } else if (split2 != null && split2.length == 1) {
                            C3958b.m16288a(Integer.valueOf(Integer.parseInt(split2[0])), BuildConfig.FLAVOR);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        f13277b = false;
        if (f13278c.size() > 0) {
            for (String split3 : f13278c) {
                try {
                    f13276a.remove(split3);
                } catch (Exception e2) {
                }
            }
        }
    }

    public static boolean m16290a(Integer num, String str, String str2, boolean z) {
        JSONObject a = C3958b.m16288a(num, str);
        if (a != null) {
            try {
                z = a.optBoolean(str2, z);
            } catch (Exception e) {
            }
        }
        return z;
    }
}
