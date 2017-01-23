package com.taobao.accs.client;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.C4156a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.taobao.accs.client.b */
public class C4086b {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";
    public static final String SP_BIND_FILE_NAME = "ACCS_BIND";
    private static C4086b f13633a;
    private Context f13634b;
    private ConcurrentHashMap<String, Integer> f13635c;
    private ConcurrentHashMap<String, Set<String>> f13636d;
    private long f13637e;
    private ConcurrentHashMap<String, Integer> f13638f;
    private String f13639g;
    private long f13640h;

    static {
        f13633a = null;
    }

    private C4086b(Context context) {
        this.f13635c = new ConcurrentHashMap();
        this.f13636d = new ConcurrentHashMap();
        this.f13638f = new ConcurrentHashMap();
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f13634b = context.getApplicationContext();
        m16672b();
    }

    public static synchronized C4086b m16670a(Context context) {
        C4086b c4086b;
        synchronized (C4086b.class) {
            if (f13633a == null) {
                f13633a = new C4086b(context);
            }
            c4086b = f13633a;
        }
        return c4086b;
    }

    private void m16671a(String str, long j, Map<String, Integer> map) {
        try {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            JSONArray jSONArray = new JSONArray();
            if (j <= 0 || j >= System.currentTimeMillis()) {
                jSONArray.put(((double) System.currentTimeMillis()) - (Math.random() * 8.64E7d));
            } else {
                jSONArray.put(j);
            }
            for (Object obj : strArr) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p", obj);
                jSONObject.put("s", ((Integer) map.get(obj)).intValue());
                jSONArray.put(jSONObject);
            }
            Editor edit = this.f13634b.getSharedPreferences(str, 0).edit();
            edit.putString("bind_status", jSONArray.toString());
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m16672b() {
        try {
            Object string = this.f13634b.getSharedPreferences(SP_BIND_FILE_NAME, 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.m16904i("ClientManager", "restoreClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f13637e = jSONArray.getLong(0);
            if (System.currentTimeMillis() < this.f13637e + C4156a.f13948j) {
                for (int i = 1; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.f13635c.put(jSONObject.getString("p"), Integer.valueOf(jSONObject.getInt("s")));
                }
                ALog.m16904i("ClientManager", "restoreClients mBindStatus restore=" + this.f13635c, new Object[0]);
                return;
            }
            ALog.m16904i("ClientManager", "restoreClients expired", "lastFlushTime", Long.valueOf(this.f13637e));
            this.f13637e = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void m16673c() {
        try {
            Object string = this.f13634b.getSharedPreferences(SP_AGOO_BIND_FILE_NAME, 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.m16904i("ClientManager", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f13640h = jSONArray.getLong(0);
            if (System.currentTimeMillis() < this.f13640h + C4156a.f13948j) {
                for (int i = 1; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.f13638f.put(jSONObject.getString("p"), Integer.valueOf(jSONObject.getInt("s")));
                }
                ALog.m16904i("ClientManager", "restoreAgooClients mAgooBindStatus restore = " + this.f13638f, new Object[0]);
                return;
            }
            ALog.m16904i("ClientManager", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(this.f13640h));
            this.f13640h = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m16674a() {
        this.f13639g = null;
    }

    public void m16675a(String str) {
        Integer num = (Integer) this.f13635c.get(str);
        if (num == null || num.intValue() != 2) {
            this.f13635c.put(str, Integer.valueOf(2));
            m16671a(SP_BIND_FILE_NAME, this.f13637e, this.f13635c);
        }
    }

    public void m16676a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                Set set = (Set) this.f13636d.get(str);
                if (set == null) {
                    set = new HashSet();
                }
                set.add(str2);
                this.f13636d.put(str, set);
            }
        } catch (Exception e) {
            ALog.m16903e("ClientManager", "ClientManager" + e.toString(), new Object[0]);
            e.printStackTrace();
        }
    }

    public void m16677b(String str) {
        Integer num = (Integer) this.f13635c.get(str);
        if (num == null || num.intValue() != 4) {
            this.f13635c.put(str, Integer.valueOf(4));
            m16671a(SP_BIND_FILE_NAME, this.f13637e, this.f13635c);
        }
    }

    public boolean m16678b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Set set = (Set) this.f13636d.get(str);
            if (set != null && set.contains(str2)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            ALog.m16903e("ClientManager", "ClientManager" + e.toString(), new Object[0]);
            e.printStackTrace();
        }
    }

    public boolean m16679c(String str) {
        if (this.f13635c.isEmpty()) {
            m16672b();
        }
        Integer num = (Integer) this.f13635c.get(str);
        ALog.m16904i("ClientManager", "isAppBinded begin..appStatus=" + num + ",mBindStatus=" + this.f13635c, new Object[0]);
        return num != null && num.intValue() == 2;
    }

    public boolean m16680d(String str) {
        Integer num = (Integer) this.f13635c.get(str);
        return num != null && num.intValue() == 4;
    }

    public void m16681e(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f13636d.remove(str);
            }
        } catch (Exception e) {
            ALog.m16903e("ClientManager", "ClientManager" + e.toString(), new Object[0]);
            e.printStackTrace();
        }
    }

    public void m16682f(String str) {
        Integer num = (Integer) this.f13638f.get(str);
        if (num == null || num.intValue() != 2) {
            this.f13638f.put(str, Integer.valueOf(2));
            m16671a(SP_AGOO_BIND_FILE_NAME, this.f13640h, this.f13638f);
        }
    }

    public boolean m16683g(String str) {
        if (this.f13638f.isEmpty()) {
            m16673c();
        }
        Integer num = (Integer) this.f13638f.get(str);
        ALog.m16904i("ClientManager", "isAgooRegistered begin..appStatus=" + num + ",mAgooBindStatus=" + this.f13638f, new Object[0]);
        return num != null && num.intValue() == 2;
    }

    public void m16684h(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13639g = str;
        }
    }

    public boolean m16685i(String str) {
        return this.f13639g != null && this.f13639g.equals(str);
    }

    public void m16686j(String str) {
        try {
            Editor edit = this.f13634b.getSharedPreferences(str, 0).edit();
            edit.clear();
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
