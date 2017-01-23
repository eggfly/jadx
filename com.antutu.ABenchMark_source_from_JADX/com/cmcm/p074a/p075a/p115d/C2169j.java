package com.cmcm.p074a.p075a.p115d;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.antutu.utils.ACPManager;
import com.cmcm.p074a.p075a.C2159c;
import com.cmcm.p074a.p075a.p112a.C2108b;
import com.cmcm.p074a.p075a.p112a.C2109c;
import com.cmcm.p074a.p075a.p112a.C2115i;
import com.cmcm.p074a.p075a.p112a.C2131x;
import com.cmcm.p074a.p075a.p112a.C2133z;
import com.cmcm.p074a.p075a.p112a.ad;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* renamed from: com.cmcm.a.a.d.j */
public class C2169j {
    private static final C2169j f7536a;
    private Context f7537b;
    private File f7538c;
    private Handler f7539d;
    private volatile C2167h f7540e;
    private String f7541f;
    private C2109c f7542g;
    private C2109c f7543h;
    private volatile long f7544i;
    private volatile long f7545j;
    private C2180t f7546k;
    private AtomicBoolean f7547l;
    private AtomicBoolean f7548m;
    private long f7549n;
    private volatile C2159c f7550o;

    static {
        f7536a = new C2169j();
    }

    public C2169j() {
        this.f7544i = 21600000;
        this.f7545j = 300000;
        this.f7547l = new AtomicBoolean(false);
        this.f7548m = new AtomicBoolean(true);
    }

    public static C2169j m8169a() {
        return f7536a;
    }

    private File m8170a(int i) {
        return new File(this.f7538c, "Reporter_" + i + ".tmp");
    }

    private List m8171a(Cursor cursor, File file, int i) {
        Closeable closeable = null;
        try {
            closeable = C2183w.m8214a(file);
            if (TextUtils.isEmpty(C2133z.f7483b)) {
                closeable.m8216a("{");
            } else {
                closeable.m8216a(String.format("{\"env\":\"%s\",", new Object[]{C2133z.f7483b}));
            }
            closeable.m8216a("\"header\":");
            closeable.m8216a(this.f7541f);
            closeable.m8216a(",\"extras\":");
            closeable.m8216a(m8189g());
            closeable.m8216a(",\"body\":[");
            int columnIndex = cursor.getColumnIndex("ver");
            int columnIndex2 = cursor.getColumnIndex("proto");
            int columnIndex3 = cursor.getColumnIndex("timestamp");
            int columnIndex4 = cursor.getColumnIndex("guid");
            int columnIndex5 = cursor.getColumnIndex(C4233j.f14402y);
            int columnIndex6 = cursor.getColumnIndex(Constants.KEY_DATA);
            List arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                if (cursor.getPosition() != 0) {
                    closeable.m8216a(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                String string = cursor.getString(columnIndex4);
                arrayList.add(string);
                JSONStringer jSONStringer = new JSONStringer();
                jSONStringer.object();
                jSONStringer.key(Constants.SP_KEY_VERSION).value((long) cursor.getInt(columnIndex));
                jSONStringer.key("protocol").value((long) cursor.getInt(columnIndex2));
                jSONStringer.key("timestamp").value(cursor.getLong(columnIndex3));
                jSONStringer.key("guid").value(string);
                jSONStringer.key(C4233j.f14402y).value(cursor.getString(columnIndex5));
                jSONStringer.key(Constants.KEY_DATA).value(cursor.getString(columnIndex6));
                jSONStringer.endObject();
                closeable.m8216a(jSONStringer.toString());
                if (closeable.m8215a() > i) {
                    break;
                }
            }
            closeable.m8216a("]}");
            return arrayList;
        } finally {
            C2115i.m7967a(closeable);
        }
    }

    private void m8176a(String str, File file, C2178x c2178x) {
        new Thread(new C2176q(this, file, str, c2178x)).start();
    }

    private void m8178a(boolean z) {
        if (C2133z.f7482a) {
            C2169j.m8180b(10, "begin to check", new Object[0]);
        }
        if (this.f7546k.m8213a()) {
            if (C2133z.f7482a) {
                C2169j.m8180b(10, "reporting", new Object[0]);
            }
        } else if (C2115i.m7980i(this.f7537b)) {
            if (m8195j()) {
                if (!z || C2108b.m7936a().m7938b("report_timestamp") + this.f7544i <= System.currentTimeMillis()) {
                    Cursor cursor = null;
                    try {
                        cursor = this.f7540e.m8163a(10);
                        if (cursor == null || cursor.getCount() == 0) {
                            if (C2133z.f7482a) {
                                C2169j.m8180b(10, "no Data", new Object[0]);
                            }
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                        if (C2133z.f7482a) {
                            C2169j.m8180b(10, "start to report", new Object[0]);
                        }
                        File a = m8170a(10);
                        this.f7546k.m8211a(a, m8171a(cursor, a, (int) IoUtils.DEFAULT_IMAGE_TOTAL_SIZE));
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception e) {
                        if (C2133z.f7482a) {
                            C2169j.m8180b(10, e.getMessage(), new Object[0]);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } else if (C2133z.f7482a) {
                    C2169j.m8180b(10, "no Time", new Object[0]);
                }
            } else if (C2133z.f7482a) {
                C2169j.m8180b(10, "disabled", new Object[0]);
            }
        } else if (C2133z.f7482a) {
            C2169j.m8180b(10, "no Wifi", new Object[0]);
        }
    }

    private static void m8180b(int i, String str, Object... objArr) {
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(str, objArr);
            if (i == 10) {
                C2169j.m8181b("[Batch] %s", format);
                return;
            }
            C2169j.m8181b("[Fast] %s", format);
        }
    }

    private static void m8181b(String str, Object... objArr) {
        ad.m7931a("Reporter", str, objArr);
    }

    private void m8185e() {
        C2160a.m8150b().m8152b(this.f7537b);
        C2167h c2167h = new C2167h(this.f7537b);
        c2167h.m8164a();
        this.f7540e = c2167h;
        this.f7549n = C2108b.m7936a().m7938b("report_heartbeat");
        m8192i();
        this.f7539d.postDelayed(new C2173n(this), 60000);
    }

    private void m8186f() {
        this.f7541f = C2184y.m8218b(this.f7537b);
        this.f7546k = new C2180t();
        this.f7542g = new C2109c(this.f7539d);
        this.f7543h = new C2109c(this.f7539d);
        long j = this.f7544i;
        long currentTimeMillis = System.currentTimeMillis();
        C2108b a = C2108b.m7936a();
        long b = a.m7938b("report_timestamp");
        if (b == 0) {
            a.m7940c().putLong("report_timestamp", currentTimeMillis).apply();
        } else if (currentTimeMillis <= b || currentTimeMillis >= b + j) {
            m8178a(false);
        } else {
            j -= currentTimeMillis - b;
        }
        this.f7542g.m7951a(new C2174o(this), j);
        this.f7543h.m7951a(new C2175p(this), this.f7545j);
        if (C2133z.f7482a) {
            C2169j.m8181b("finished", new Object[0]);
        }
    }

    private String m8189g() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uptime", (int) (System.currentTimeMillis() / 1000));
            jSONObject.put("oslanguage", Locale.getDefault().toString());
            jSONObject.put("timezone", TimeZone.getDefault().getRawOffset());
            jSONObject.put("network", C2115i.m7982k(this.f7537b));
            return jSONObject.toString();
        } catch (JSONException e) {
            return BuildConfig.FLAVOR;
        }
    }

    private void m8191h() {
        if (C2133z.f7482a) {
            C2169j.m8180b(50, "begin to check", new Object[0]);
        }
        m8192i();
        if (C2115i.m7980i(this.f7537b) || C2115i.m7981j(this.f7537b)) {
            if (m8195j()) {
                Cursor cursor = null;
                try {
                    cursor = this.f7540e.m8163a(50);
                    if (cursor == null || cursor.getCount() == 0) {
                        if (C2133z.f7482a) {
                            C2169j.m8180b(50, "no data", new Object[0]);
                        }
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                    if (C2133z.f7482a) {
                        C2169j.m8180b(50, "start to report", new Object[0]);
                    }
                    File a = m8170a(50);
                    List a2 = m8171a(cursor, a, (int) ACPManager.MAX_BUFFER);
                    this.f7540e.m8167a(a2, true);
                    m8176a(C2131x.m8050a().m8055d(), a, new C2179s(this, a, a2));
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    if (C2133z.f7482a) {
                        C2169j.m8180b(50, e.getMessage(), new Object[0]);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } else if (C2133z.f7482a) {
                C2169j.m8180b(50, "disabled", new Object[0]);
            }
        } else if (C2133z.f7482a) {
            C2169j.m8180b(50, "no Network", new Object[0]);
        }
    }

    private void m8192i() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f7549n) >= C4156a.f13948j) {
            this.f7549n = currentTimeMillis;
            C2108b.m7936a().m7940c().putLong("report_heartbeat", currentTimeMillis).apply();
            C2168i c2168i = new C2168i(50, "heartbeat", null, currentTimeMillis);
            if (C2133z.f7482a) {
                C2169j.m8181b("%s", c2168i.toString());
            }
            this.f7540e.m8165a(c2168i);
        }
    }

    private boolean m8195j() {
        if (!m8202b()) {
            return false;
        }
        C2159c c2159c = this.f7550o;
        if (c2159c == null) {
            if (C2133z.f7482a) {
                C2169j.m8181b("DmcReporterDelegate == null", new Object[0]);
            }
            return true;
        }
        boolean a = c2159c.m8144a();
        if (C2133z.f7482a) {
            C2169j.m8181b("DmcReporterDelegate.canReport() : " + a, new Object[0]);
        }
        return a;
    }

    public void m8198a(int i, String str, String str2) {
        if (this.f7539d != null) {
            if (i < 10) {
                i = 10;
            }
            C2168i c2168i = new C2168i(i, str, str2);
            if (C2133z.f7482a) {
                C2169j.m8181b("%s", c2168i.toString());
            }
            this.f7539d.post(new C2172m(this, c2168i));
        } else if (C2133z.f7482a) {
            ad.m7931a("Reporter", "mHandler == null", new Object[0]);
        }
    }

    public void m8199a(long j) {
        if (j <= 0) {
            this.f7545j = 300000;
        } else {
            this.f7545j = Math.max((60 * j) * 1000, 60000);
        }
    }

    public void m8200a(Context context, File file) {
        this.f7537b = context;
        this.f7538c = file;
        HandlerThread handlerThread = new HandlerThread("Reporter");
        handlerThread.start();
        this.f7539d = new Handler(handlerThread.getLooper());
        this.f7539d.post(new C2170k(this));
    }

    public void m8201b(long j) {
        if (j <= 0) {
            this.f7544i = 21600000;
        } else {
            this.f7544i = Math.max((60 * j) * 1000, 300000);
        }
    }

    public boolean m8202b() {
        return this.f7548m.get();
    }

    public boolean m8203c() {
        return this.f7540e != null;
    }

    public void m8204d() {
        if (!m8203c()) {
            return;
        }
        if (!this.f7547l.get()) {
            if (C2133z.f7482a) {
                C2169j.m8181b("received", new Object[0]);
            }
            this.f7547l.set(true);
            this.f7539d.postDelayed(new C2171l(this), 10000);
        } else if (C2133z.f7482a) {
            C2169j.m8181b("network changed ...", new Object[0]);
        }
    }
}
