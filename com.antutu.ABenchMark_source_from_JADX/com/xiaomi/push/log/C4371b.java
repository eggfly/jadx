package com.xiaomi.push.log;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.ads.AdError;
import com.umeng.analytics.C4156a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.channel.commonutils.file.C4300c;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4312f.C4311b;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.ah;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.smack.util.C4497h;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.log.b */
public class C4371b {
    private static volatile C4371b f14886c;
    private final ConcurrentLinkedQueue<C4368b> f14887a;
    private Context f14888b;

    /* renamed from: com.xiaomi.push.log.b.b */
    class C4368b extends C4311b {
        long f14876i;
        final /* synthetic */ C4371b f14877j;

        C4368b(C4371b c4371b) {
            this.f14877j = c4371b;
            this.f14876i = System.currentTimeMillis();
        }

        public void m17948b() {
        }

        public boolean m17949d() {
            return true;
        }

        final boolean m17950e() {
            return System.currentTimeMillis() - this.f14876i > 172800000;
        }
    }

    /* renamed from: com.xiaomi.push.log.b.a */
    class C4369a extends C4368b {
        final /* synthetic */ C4371b f14878a;

        C4369a(C4371b c4371b) {
            this.f14878a = c4371b;
            super(c4371b);
        }

        public void m17951b() {
            this.f14878a.m17961b();
        }
    }

    /* renamed from: com.xiaomi.push.log.b.c */
    class C4370c extends C4368b {
        String f14879a;
        String f14880b;
        File f14881c;
        int f14882d;
        boolean f14883e;
        boolean f14884f;
        final /* synthetic */ C4371b f14885g;

        C4370c(C4371b c4371b, String str, String str2, File file, boolean z) {
            this.f14885g = c4371b;
            super(c4371b);
            this.f14879a = str;
            this.f14880b = str2;
            this.f14881c = file;
            this.f14884f = z;
        }

        private boolean m17952f() {
            int i;
            SharedPreferences sharedPreferences = this.f14885g.f14888b.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", BuildConfig.FLAVOR);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong(C4233j.f14377D);
                i = jSONObject.getInt("times");
            } catch (JSONException e) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= C4156a.f13948j) {
                currentTimeMillis = System.currentTimeMillis();
                i = 0;
            } else if (i > 10) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(C4233j.f14377D, currentTimeMillis);
                jSONObject2.put("times", i + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                C4302b.m17653c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        public void m17953b() {
            try {
                if (m17952f()) {
                    Map hashMap = new HashMap();
                    hashMap.put("uid", ah.m18140e());
                    hashMap.put(Constants.EXTRA_KEY_TOKEN, this.f14880b);
                    hashMap.put("net", C4321d.m17712g(this.f14885g.f14888b));
                    C4321d.m17702a(this.f14879a, hashMap, this.f14881c, "file");
                }
                this.f14883e = true;
            } catch (IOException e) {
            }
        }

        public void m17954c() {
            if (!this.f14883e) {
                this.f14882d++;
                if (this.f14882d < 3) {
                    this.f14885g.f14887a.add(this);
                }
            }
            if (this.f14883e || this.f14882d >= 3) {
                this.f14881c.delete();
            }
            this.f14885g.m17958a((long) ((1 << this.f14882d) * AdError.NETWORK_ERROR_CODE));
        }

        public boolean m17955d() {
            return C4321d.m17711f(this.f14885g.f14888b) || (this.f14884f && C4321d.m17709d(this.f14885g.f14888b));
        }
    }

    static {
        f14886c = null;
    }

    private C4371b(Context context) {
        this.f14887a = new ConcurrentLinkedQueue();
        this.f14888b = context;
        this.f14887a.add(new C4369a(this));
        m17962b(0);
    }

    public static C4371b m17957a(Context context) {
        if (f14886c == null) {
            synchronized (C4371b.class) {
                if (f14886c == null) {
                    f14886c = new C4371b(context);
                }
            }
        }
        f14886c.f14888b = context;
        return f14886c;
    }

    private void m17958a(long j) {
        C4368b c4368b = (C4368b) this.f14887a.peek();
        if (c4368b != null && c4368b.m17949d()) {
            m17962b(j);
        }
    }

    private void m17961b() {
        if (!C4300c.m17639b() && !C4300c.m17638a()) {
            try {
                File file = new File(this.f14888b.getExternalFilesDir(null) + "/.logcache");
                if (file.exists() && file.isDirectory()) {
                    for (File delete : file.listFiles()) {
                        delete.delete();
                    }
                }
            } catch (NullPointerException e) {
            }
        }
    }

    private void m17962b(long j) {
        if (!this.f14887a.isEmpty()) {
            C4497h.m18654a(new C4373d(this), j);
        }
    }

    private void m17963c() {
        while (!this.f14887a.isEmpty()) {
            if (((C4368b) this.f14887a.peek()).m17950e() || this.f14887a.size() > 6) {
                C4302b.m17653c("remove Expired task");
                this.f14887a.remove();
            } else {
                return;
            }
        }
    }

    public void m17965a() {
        m17963c();
        m17958a(0);
    }

    public void m17966a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f14887a.add(new C4372c(this, i, date, date2, str, str2, z));
        m17962b(0);
    }
}
