package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.C4304b;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;

/* renamed from: com.xiaomi.push.service.v */
public class C4445v {
    private static volatile C4445v f15165b;
    protected SharedPreferences f15166a;

    private C4445v(Context context) {
        this.f15166a = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    public static C4445v m18368a(Context context) {
        if (f15165b == null) {
            synchronized (C4445v.class) {
                if (f15165b == null) {
                    f15165b = new C4445v(context);
                }
            }
        }
        return f15165b;
    }

    private String m18369a(int i) {
        return "normal_oc_" + i;
    }

    private void m18370a(Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (pair.second instanceof String) {
            editor.putString(str, (String) pair.second);
        } else if (pair.second instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
        }
    }

    private String m18371b(int i) {
        return "custom_oc_" + i;
    }

    public int m18372a(int i, int i2) {
        String b = m18371b(i);
        if (this.f15166a.contains(b)) {
            return this.f15166a.getInt(b, 0);
        }
        b = m18369a(i);
        return this.f15166a.contains(b) ? this.f15166a.getInt(b, 0) : i2;
    }

    public String m18373a(int i, String str) {
        String b = m18371b(i);
        if (this.f15166a.contains(b)) {
            return this.f15166a.getString(b, null);
        }
        b = m18369a(i);
        return this.f15166a.contains(b) ? this.f15166a.getString(b, null) : str;
    }

    public void m18374a(List<Pair<Integer, Object>> list) {
        if (!C4304b.m17660a(list)) {
            Editor edit = this.f15166a.edit();
            for (Pair pair : list) {
                if (!(pair.first == null || pair.second == null)) {
                    m18370a(edit, pair, m18369a(((Integer) pair.first).intValue()));
                }
            }
            edit.commit();
        }
    }

    public boolean m18375a(int i, boolean z) {
        String b = m18371b(i);
        if (this.f15166a.contains(b)) {
            return this.f15166a.getBoolean(b, false);
        }
        b = m18369a(i);
        return this.f15166a.contains(b) ? this.f15166a.getBoolean(b, false) : z;
    }

    public void m18376b(List<Pair<Integer, Object>> list) {
        if (!C4304b.m17660a(list)) {
            Editor edit = this.f15166a.edit();
            for (Pair pair : list) {
                if (pair.first != null) {
                    String b = m18371b(((Integer) pair.first).intValue());
                    if (pair.second == null) {
                        edit.remove(b);
                    } else {
                        m18370a(edit, pair, b);
                    }
                }
            }
            edit.commit();
        }
    }
}
