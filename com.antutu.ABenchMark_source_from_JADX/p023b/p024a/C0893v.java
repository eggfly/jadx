package p023b.p024a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import p023b.p024a.C0909w.C0904k;
import p023b.p024a.C0909w.C0907n;

/* renamed from: b.a.v */
public class C0893v {
    private final Map<String, Long> f2988a;
    private final ArrayList<C0904k> f2989b;

    public C0893v() {
        this.f2988a = new HashMap();
        this.f2989b = new ArrayList();
    }

    public static void m3974a(SharedPreferences sharedPreferences, C0907n c0907n) {
        if (sharedPreferences != null) {
            try {
                Object string = sharedPreferences.getString("activities", BuildConfig.FLAVOR);
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split(";");
                    for (String jSONArray : split) {
                        JSONArray jSONArray2 = new JSONArray(jSONArray);
                        C0904k c0904k = new C0904k();
                        c0904k.f3021a = jSONArray2.getString(0);
                        c0904k.f3022b = (long) jSONArray2.getInt(1);
                        c0907n.f3087g.add(c0904k);
                    }
                }
            } catch (Throwable e) {
                ap.m3385a(e);
            }
        }
    }

    public void m3975a() {
        String str = null;
        long j = 0;
        synchronized (this.f2988a) {
            for (Entry entry : this.f2988a.entrySet()) {
                String str2;
                long j2;
                if (((Long) entry.getValue()).longValue() > j) {
                    long longValue = ((Long) entry.getValue()).longValue();
                    str2 = (String) entry.getKey();
                    j2 = longValue;
                } else {
                    j2 = j;
                    str2 = str;
                }
                str = str2;
                j = j2;
            }
        }
        if (str != null) {
            m3978b(str);
        }
    }

    public void m3976a(Context context) {
        if (context != null) {
            try {
                SharedPreferences a = C0888r.m3932a(context);
                Editor edit = a.edit();
                if (this.f2989b.size() > 0) {
                    Object string = a.getString("activities", BuildConfig.FLAVOR);
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!TextUtils.isEmpty(string)) {
                        stringBuilder.append(string);
                        stringBuilder.append(";");
                    }
                    synchronized (this.f2989b) {
                        Iterator it = this.f2989b.iterator();
                        while (it.hasNext()) {
                            C0904k c0904k = (C0904k) it.next();
                            stringBuilder.append(String.format("[\"%s\",%d]", new Object[]{c0904k.f3021a, Long.valueOf(c0904k.f3022b)}));
                            stringBuilder.append(";");
                        }
                        this.f2989b.clear();
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    edit.remove("activities");
                    edit.putString("activities", stringBuilder.toString());
                }
                edit.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m3977a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f2988a) {
                this.f2988a.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public void m3978b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Long l;
            synchronized (this.f2988a) {
                l = (Long) this.f2988a.remove(str);
            }
            if (l == null) {
                ap.m3388b("please call 'onPageStart(%s)' before onPageEnd", str);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            synchronized (this.f2989b) {
                C0904k c0904k = new C0904k();
                c0904k.f3021a = str;
                c0904k.f3022b = currentTimeMillis;
                this.f2989b.add(c0904k);
            }
        }
    }
}
