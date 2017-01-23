package com.baidu.mobads;

import com.xiaomi.pushsdk.BuildConfig;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdSettings {
    private static HashSet<String> f6599a;
    private static JSONArray f6600b;
    private static String f6601c;
    private static String f6602d;
    private static String f6603e;
    private static String f6604f;
    private static String f6605g;
    private static String f6606h;
    private static String f6607i;
    private static HashSet<String> f6608j;
    private static JSONArray f6609k;
    private static JSONObject f6610l;

    /* renamed from: com.baidu.mobads.AdSettings.a */
    public enum C1901a {
        PRIMARY(0),
        JUNIOR(1),
        SENIOR(2),
        SPECIALTY(3),
        BACHELOR(4),
        MASTER(5),
        DOCTOR(6);
        
        private int f6579h;

        private C1901a(int i) {
            this.f6579h = i;
        }

        public int m7177a() {
            return this.f6579h;
        }
    }

    /* renamed from: com.baidu.mobads.AdSettings.b */
    public enum C1902b {
        F0T1k(0),
        F1kT2k(1),
        F2kT3k(2),
        F3kT4k(3),
        F4kT5k(4),
        F5kT6k(5),
        F6kT7k(6),
        F7kT8k(7),
        F8kT9k(8),
        F9kT10k(9),
        F10kT15k(10),
        F15kT20k(11),
        F20(12);
        
        private int f6594n;

        private C1902b(int i) {
            this.f6594n = i;
        }

        public int m7178a() {
            return this.f6594n;
        }
    }

    /* renamed from: com.baidu.mobads.AdSettings.c */
    public enum C1903c {
        MALE(0),
        FEMALE(1);
        
        private int f6598c;

        private C1903c(int i) {
            this.f6598c = i;
        }

        public int m7179a() {
            return this.f6598c;
        }
    }

    static {
        f6599a = new HashSet();
        f6600b = new JSONArray();
        f6608j = new HashSet();
        f6609k = new JSONArray();
        f6610l = new JSONObject();
    }

    protected static JSONObject getAttr() {
        JSONObject jSONObject = new JSONObject();
        Iterator it = f6599a.iterator();
        f6600b = new JSONArray();
        while (it.hasNext()) {
            f6600b.put(it.next());
        }
        it = f6608j.iterator();
        f6609k = new JSONArray();
        while (it.hasNext()) {
            f6609k.put(it.next());
        }
        try {
            jSONObject.putOpt("KEY", f6600b);
            jSONObject.putOpt("SEX", f6601c);
            jSONObject.putOpt("BIR", f6602d);
            jSONObject.putOpt("CITY", f6603e);
            jSONObject.putOpt("ZIP", f6604f);
            jSONObject.putOpt("JOB", f6605g);
            jSONObject.putOpt("EDU", f6606h);
            jSONObject.putOpt("SAL", f6607i);
            jSONObject.putOpt("HOB", f6609k);
            jSONObject.putOpt("R", f6610l);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static void setBirthday(Calendar calendar) {
        if (calendar != null) {
            int i = calendar.get(1);
            int i2 = calendar.get(2) + 1;
            int i3 = calendar.get(5);
            f6602d = i + BuildConfig.FLAVOR;
            if (i2 <= 0 || i2 >= 10) {
                f6602d += i2;
            } else {
                f6602d += MessageService.MSG_DB_READY_REPORT + i2;
            }
            if (i3 <= 0 || i3 >= 10) {
                f6602d += i3;
            } else {
                f6602d += MessageService.MSG_DB_READY_REPORT + i3;
            }
        }
    }

    public static void setCity(String str) {
        f6603e = str;
    }

    public static void setEducation(C1901a c1901a) {
        if (c1901a != null) {
            f6606h = c1901a.m7177a() + BuildConfig.FLAVOR;
        }
    }

    public static void setHob(List<String> list) {
        f6608j.addAll(list);
    }

    public static void setHob(String[] strArr) {
        for (Object add : strArr) {
            f6608j.add(add);
        }
    }

    public static void setJob(String str) {
        f6605g = str;
    }

    public static void setKey(List<String> list) {
        f6599a.addAll(list);
    }

    public static void setKey(String[] strArr) {
        for (Object add : strArr) {
            f6599a.add(add);
        }
    }

    public static void setSalary(C1902b c1902b) {
        if (c1902b != null) {
            f6607i = c1902b.m7178a() + BuildConfig.FLAVOR;
        }
    }

    public static void setSex(C1903c c1903c) {
        if (c1903c != null) {
            f6601c = c1903c.m7179a() + BuildConfig.FLAVOR;
        }
    }

    public static void setUserAttr(String str, String str2) {
        try {
            f6610l.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public static void setZip(String str) {
        f6604f = str;
    }
}
