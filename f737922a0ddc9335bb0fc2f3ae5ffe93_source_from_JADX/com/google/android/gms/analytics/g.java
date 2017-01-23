package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.c;
import com.google.android.gms.analytics.internal.e;
import com.google.android.gms.analytics.internal.o;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.t;
import com.google.android.gms.analytics.internal.u;
import com.google.android.gms.analytics.internal.v;
import com.google.android.gms.analytics.internal.w;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.fu;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class g extends t {
    private final Map<String, String> DW;
    private final Map<String, String> FH;
    private final e Hw;
    private o VH;
    private b Zo;
    private boolean j6;
    private final a v5;

    class 1 implements Runnable {
        final /* synthetic */ boolean DW;
        final /* synthetic */ String FH;
        final /* synthetic */ long Hw;
        final /* synthetic */ String VH;
        final /* synthetic */ boolean Zo;
        final /* synthetic */ g gn;
        final /* synthetic */ Map j6;
        final /* synthetic */ boolean v5;

        1(g gVar, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
            this.gn = gVar;
            this.j6 = map;
            this.DW = z;
            this.FH = str;
            this.Hw = j;
            this.v5 = z2;
            this.Zo = z3;
            this.VH = str2;
        }

        public void run() {
            boolean z = true;
            if (this.gn.v5.DW()) {
                this.j6.put("sc", "start");
            }
            p.DW(this.j6, "cid", this.gn.j3().gn());
            String str = (String) this.j6.get("sf");
            if (str != null) {
                double j6 = p.j6(str, 100.0d);
                if (p.j6(j6, (String) this.j6.get("cid"))) {
                    this.gn.DW("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(j6));
                    return;
                }
            }
            com.google.android.gms.analytics.internal.a DW = this.gn.er();
            if (this.DW) {
                p.j6(this.j6, "ate", DW.DW());
                p.j6(this.j6, "adid", DW.FH());
            } else {
                this.j6.remove("ate");
                this.j6.remove("adid");
            }
            fu FH = this.gn.yS().FH();
            p.j6(this.j6, "an", FH.j6());
            p.j6(this.j6, "av", FH.DW());
            p.j6(this.j6, "aid", FH.FH());
            p.j6(this.j6, "aiid", FH.Hw());
            this.j6.put("v", "1");
            this.j6.put("_v", u.DW);
            p.j6(this.j6, "ul", this.gn.gW().DW().Zo());
            p.j6(this.j6, "sr", this.gn.gW().FH());
            boolean z2 = this.FH.equals("transaction") || this.FH.equals("item");
            if (z2 || this.gn.Hw.j6()) {
                long j62 = p.j6((String) this.j6.get("ht"));
                if (j62 == 0) {
                    j62 = this.Hw;
                }
                if (this.v5) {
                    this.gn.QX().FH("Dry run enabled. Would have sent hit", new c(this.gn, this.j6, j62, this.Zo));
                    return;
                }
                String str2 = (String) this.j6.get("cid");
                Map hashMap = new HashMap();
                p.j6(hashMap, "uid", this.j6);
                p.j6(hashMap, "an", this.j6);
                p.j6(hashMap, "aid", this.j6);
                p.j6(hashMap, "av", this.j6);
                p.j6(hashMap, "aiid", this.j6);
                String str3 = this.VH;
                if (TextUtils.isEmpty((CharSequence) this.j6.get("adid"))) {
                    z = false;
                }
                this.j6.put("_s", String.valueOf(this.gn.Mr().j6(new w(0, str2, str3, z, 0, hashMap))));
                this.gn.Mr().j6(new c(this.gn, this.j6, j62, this.Zo));
                return;
            }
            this.gn.QX().j6(this.j6, "Too many hits sent too quickly, rate limiting invoked");
        }
    }

    private class a extends t implements a {
        private boolean DW;
        private int FH;
        private long Hw;
        private long Zo;
        final /* synthetic */ g j6;
        private boolean v5;

        protected a(g gVar, v vVar) {
            this.j6 = gVar;
            super(vVar);
            this.Hw = -1;
        }

        private void Hw() {
            if (this.Hw >= 0 || this.DW) {
                j3().j6(this.j6.v5);
            } else {
                j3().DW(this.j6.v5);
            }
        }

        public void DW(Activity activity) {
            this.FH--;
            this.FH = Math.max(0, this.FH);
            if (this.FH == 0) {
                this.Zo = J8().DW();
            }
        }

        public synchronized boolean DW() {
            boolean z;
            z = this.v5;
            this.v5 = false;
            return z;
        }

        boolean FH() {
            return J8().DW() >= this.Zo + Math.max(1000, this.Hw);
        }

        protected void j6() {
        }

        public void j6(long j) {
            this.Hw = j;
            Hw();
        }

        public void j6(Activity activity) {
            if (this.FH == 0 && FH()) {
                this.v5 = true;
            }
            this.FH++;
            if (this.DW) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.j6.j6(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                this.j6.j6("&cd", this.j6.VH != null ? this.j6.VH.j6(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    CharSequence j6 = g.j6(activity);
                    if (!TextUtils.isEmpty(j6)) {
                        hashMap.put("&dr", j6);
                    }
                }
                this.j6.j6(hashMap);
            }
        }

        public void j6(boolean z) {
            this.DW = z;
            Hw();
        }
    }

    g(v vVar, String str, e eVar) {
        super(vVar);
        this.DW = new HashMap();
        this.FH = new HashMap();
        if (str != null) {
            this.DW.put("&tid", str);
        }
        this.DW.put("useSecure", "1");
        this.DW.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        if (eVar == null) {
            this.Hw = new e("tracking", J8());
        } else {
            this.Hw = eVar;
        }
        this.v5 = new a(this, vVar);
    }

    private static String DW(Entry<String, String> entry) {
        return !j6((Entry) entry) ? null : ((String) entry.getKey()).substring(1);
    }

    private static void DW(Map<String, String> map, Map<String, String> map2) {
        b.j6((Object) map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String DW = DW(entry);
                if (!(DW == null || map2.containsKey(DW))) {
                    map2.put(DW, (String) entry.getValue());
                }
            }
        }
    }

    private boolean FH() {
        return this.Zo != null;
    }

    static String j6(Activity activity) {
        b.j6((Object) activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        CharSequence stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return !TextUtils.isEmpty(stringExtra) ? stringExtra : null;
    }

    private static void j6(Map<String, String> map, Map<String, String> map2) {
        b.j6((Object) map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String DW = DW(entry);
                if (DW != null) {
                    map2.put(DW, (String) entry.getValue());
                }
            }
        }
    }

    private static boolean j6(Entry<String, String> entry) {
        String str = (String) entry.getKey();
        String str2 = (String) entry.getValue();
        return str.startsWith("&") && str.length() >= 2;
    }

    public void DW(boolean z) {
        this.v5.j6(z);
    }

    boolean DW() {
        return this.j6;
    }

    public void FH(boolean z) {
        this.j6 = z;
    }

    protected void j6() {
        this.v5.ei();
        String FH = a8().FH();
        if (FH != null) {
            j6("&an", FH);
        }
        FH = a8().DW();
        if (FH != null) {
            j6("&av", FH);
        }
    }

    public void j6(long j) {
        this.v5.j6(1000 * j);
    }

    public void j6(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            CharSequence queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                String str = "http://hostname/?";
                String valueOf = String.valueOf(queryParameter);
                Uri parse = Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                str = parse.getQueryParameter("utm_id");
                if (str != null) {
                    this.FH.put("&ci", str);
                }
                str = parse.getQueryParameter("anid");
                if (str != null) {
                    this.FH.put("&anid", str);
                }
                str = parse.getQueryParameter("utm_campaign");
                if (str != null) {
                    this.FH.put("&cn", str);
                }
                str = parse.getQueryParameter("utm_content");
                if (str != null) {
                    this.FH.put("&cc", str);
                }
                str = parse.getQueryParameter("utm_medium");
                if (str != null) {
                    this.FH.put("&cm", str);
                }
                str = parse.getQueryParameter("utm_source");
                if (str != null) {
                    this.FH.put("&cs", str);
                }
                str = parse.getQueryParameter("utm_term");
                if (str != null) {
                    this.FH.put("&ck", str);
                }
                str = parse.getQueryParameter("dclid");
                if (str != null) {
                    this.FH.put("&dclid", str);
                }
                str = parse.getQueryParameter("gclid");
                if (str != null) {
                    this.FH.put("&gclid", str);
                }
                valueOf = parse.getQueryParameter("aclid");
                if (valueOf != null) {
                    this.FH.put("&aclid", valueOf);
                }
            }
        }
    }

    void j6(o oVar) {
        DW("Loading Tracker config values");
        this.VH = oVar;
        if (this.VH.j6()) {
            String DW = this.VH.DW();
            j6("&tid", DW);
            j6("trackingId loaded", DW);
        }
        if (this.VH.FH()) {
            DW = Double.toString(this.VH.Hw());
            j6("&sf", DW);
            j6("Sample frequency loaded", DW);
        }
        if (this.VH.v5()) {
            int Zo = this.VH.Zo();
            j6((long) Zo);
            j6("Session timeout loaded", Integer.valueOf(Zo));
        }
        if (this.VH.VH()) {
            boolean gn = this.VH.gn();
            DW(gn);
            j6("Auto activity tracking loaded", Boolean.valueOf(gn));
        }
        if (this.VH.u7()) {
            gn = this.VH.tp();
            if (gn) {
                j6("&aip", "1");
            }
            j6("Anonymize ip loaded", Boolean.valueOf(gn));
        }
        j6(this.VH.EQ());
    }

    public void j6(String str) {
        j6("&cd", str);
    }

    public void j6(String str, String str2) {
        b.j6((Object) str, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.DW.put(str, str2);
        }
    }

    public void j6(Map<String, String> map) {
        long j6 = J8().j6();
        if (j3().Zo()) {
            FH("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean v5 = j3().v5();
        Map hashMap = new HashMap();
        j6(this.DW, hashMap);
        j6((Map) map, hashMap);
        boolean j62 = p.j6((String) this.DW.get("useSecure"), true);
        DW(this.FH, hashMap);
        this.FH.clear();
        String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            QX().j6(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            QX().j6(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean DW = DW();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt((String) this.DW.get("&a")) + 1;
                if (parseInt >= Integer.MAX_VALUE) {
                    parseInt = 1;
                }
                this.DW.put("&a", Integer.toString(parseInt));
            }
        }
        aM().j6(new 1(this, hashMap, DW, str, j6, v5, j62, str2));
    }

    public void j6(boolean z) {
        synchronized (this) {
            if (FH() == z) {
                return;
            }
            if (z) {
                this.Zo = new b(this, Thread.getDefaultUncaughtExceptionHandler(), Ws());
                Thread.setDefaultUncaughtExceptionHandler(this.Zo);
                DW("Uncaught exceptions will be reported to Google Analytics");
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this.Zo.DW());
                DW("Uncaught exceptions will not be reported to Google Analytics");
            }
        }
    }
}
