package com.google.android.gms.analytics;

import afi;
import afj;
import afk;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.c;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.s;
import com.google.android.gms.analytics.internal.u;
import com.google.android.gms.analytics.internal.v;
import com.google.android.gms.analytics.internal.w;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.fv;
import com.google.android.gms.internal.fw;
import com.google.android.gms.internal.fx;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.fz;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gb;
import com.google.android.gms.internal.gc;
import com.google.android.gms.internal.gd;
import com.google.android.gms.internal.ge;
import com.google.android.gms.internal.gf;
import com.google.android.gms.internal.gg;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class i extends s implements r {
    private static DecimalFormat j6;
    private final v DW;
    private final String FH;
    private final Uri Hw;
    private final boolean Zo;
    private final boolean v5;

    public i(v vVar, String str) {
        this(vVar, str, true, false);
    }

    public i(v vVar, String str, boolean z, boolean z2) {
        super(vVar);
        b.j6(str);
        this.DW = vVar;
        this.FH = str;
        this.v5 = z;
        this.Zo = z2;
        this.Hw = j6(this.FH);
    }

    public static Map<String, String> DW(l lVar) {
        CharSequence DW;
        Map hashMap = new HashMap();
        fy fyVar = (fy) lVar.j6(fy.class);
        if (fyVar != null) {
            for (Entry entry : fyVar.j6().entrySet()) {
                String j6 = j6(entry.getValue());
                if (j6 != null) {
                    hashMap.put((String) entry.getKey(), j6);
                }
            }
        }
        gd gdVar = (gd) lVar.j6(gd.class);
        if (gdVar != null) {
            j6(hashMap, "t", gdVar.j6());
            j6(hashMap, "cid", gdVar.DW());
            j6(hashMap, "uid", gdVar.FH());
            j6(hashMap, "sc", gdVar.Zo());
            j6(hashMap, "sf", gdVar.gn());
            j6(hashMap, "ni", gdVar.VH());
            j6(hashMap, "adid", gdVar.Hw());
            j6(hashMap, "ate", gdVar.v5());
        }
        ge geVar = (ge) lVar.j6(ge.class);
        if (geVar != null) {
            j6(hashMap, "cd", geVar.DW());
            j6(hashMap, "a", (double) geVar.FH());
            j6(hashMap, "dr", geVar.Hw());
        }
        gb gbVar = (gb) lVar.j6(gb.class);
        if (gbVar != null) {
            j6(hashMap, "ec", gbVar.j6());
            j6(hashMap, "ea", gbVar.DW());
            j6(hashMap, "el", gbVar.FH());
            j6(hashMap, "ev", (double) gbVar.Hw());
        }
        fv fvVar = (fv) lVar.j6(fv.class);
        if (fvVar != null) {
            j6(hashMap, "cn", fvVar.j6());
            j6(hashMap, "cs", fvVar.DW());
            j6(hashMap, "cm", fvVar.FH());
            j6(hashMap, "ck", fvVar.Hw());
            j6(hashMap, "cc", fvVar.v5());
            j6(hashMap, "ci", fvVar.Zo());
            j6(hashMap, "anid", fvVar.VH());
            j6(hashMap, "gclid", fvVar.gn());
            j6(hashMap, "dclid", fvVar.u7());
            j6(hashMap, "aclid", fvVar.tp());
        }
        gc gcVar = (gc) lVar.j6(gc.class);
        if (gcVar != null) {
            j6(hashMap, "exd", gcVar.j6());
            j6(hashMap, "exf", gcVar.DW());
        }
        gf gfVar = (gf) lVar.j6(gf.class);
        if (gfVar != null) {
            j6(hashMap, "sn", gfVar.j6());
            j6(hashMap, "sa", gfVar.DW());
            j6(hashMap, "st", gfVar.FH());
        }
        gg ggVar = (gg) lVar.j6(gg.class);
        if (ggVar != null) {
            j6(hashMap, "utv", ggVar.j6());
            j6(hashMap, "utt", (double) ggVar.DW());
            j6(hashMap, "utc", ggVar.FH());
            j6(hashMap, "utl", ggVar.Hw());
        }
        fw fwVar = (fw) lVar.j6(fw.class);
        if (fwVar != null) {
            for (Entry entry2 : fwVar.j6().entrySet()) {
                DW = j.DW(((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(DW)) {
                    hashMap.put(DW, (String) entry2.getValue());
                }
            }
        }
        fx fxVar = (fx) lVar.j6(fx.class);
        if (fxVar != null) {
            for (Entry entry22 : fxVar.j6().entrySet()) {
                DW = j.FH(((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(DW)) {
                    hashMap.put(DW, j6(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        ga gaVar = (ga) lVar.j6(ga.class);
        if (gaVar != null) {
            afj j62 = gaVar.j6();
            if (j62 != null) {
                for (Entry entry3 : j62.j6().entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), (String) entry3.getValue());
                    } else {
                        hashMap.put((String) entry3.getKey(), (String) entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (afk j63 : gaVar.Hw()) {
                hashMap.putAll(j63.j6(j.VH(i)));
                i++;
            }
            i = 1;
            for (afi j64 : gaVar.DW()) {
                hashMap.putAll(j64.j6(j.v5(i)));
                i++;
            }
            i = 1;
            for (Entry entry222 : gaVar.FH().entrySet()) {
                List<afi> list = (List) entry222.getValue();
                String tp = j.tp(i);
                int i2 = 1;
                for (afi j642 : list) {
                    String valueOf = String.valueOf(tp);
                    String valueOf2 = String.valueOf(j.gn(i2));
                    hashMap.putAll(j642.j6(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i2++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry222.getKey())) {
                    String valueOf3 = String.valueOf(tp);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry222.getKey());
                }
                i++;
            }
        }
        fz fzVar = (fz) lVar.j6(fz.class);
        if (fzVar != null) {
            j6(hashMap, "ul", fzVar.Zo());
            j6(hashMap, "sd", (double) fzVar.j6());
            j6(hashMap, "sr", fzVar.DW(), fzVar.FH());
            j6(hashMap, "vp", fzVar.Hw(), fzVar.v5());
        }
        fu fuVar = (fu) lVar.j6(fu.class);
        if (fuVar != null) {
            j6(hashMap, "an", fuVar.j6());
            j6(hashMap, "aid", fuVar.FH());
            j6(hashMap, "aiid", fuVar.Hw());
            j6(hashMap, "av", fuVar.DW());
        }
        return hashMap;
    }

    static Uri j6(String str) {
        b.j6(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String j6(double d) {
        if (j6 == null) {
            j6 = new DecimalFormat("0.######");
        }
        return j6.format(d);
    }

    private static String j6(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return TextUtils.isEmpty(str) ? null : str;
        } else if (!(obj instanceof Double)) {
            return obj instanceof Boolean ? obj != Boolean.FALSE ? "1" : null : String.valueOf(obj);
        } else {
            Double d = (Double) obj;
            return d.doubleValue() != 0.0d ? j6(d.doubleValue()) : null;
        }
    }

    private static String j6(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }

    private static void j6(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, j6(d));
        }
    }

    private static void j6(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void j6(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void j6(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    public Uri j6() {
        return this.Hw;
    }

    public void j6(l lVar) {
        b.j6((Object) lVar);
        b.DW(lVar.Zo(), "Can't deliver not submitted measurement");
        b.FH("deliver should be called on worker thread");
        l j6 = lVar.j6();
        gd gdVar = (gd) j6.DW(gd.class);
        if (TextUtils.isEmpty(gdVar.j6())) {
            QX().j6(DW(j6), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(gdVar.DW())) {
            QX().j6(DW(j6), "Ignoring measurement without client id");
        } else if (!this.DW.EQ().Zo()) {
            double gn = gdVar.gn();
            if (p.j6(gn, gdVar.DW())) {
                DW("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(gn));
                return;
            }
            Map DW = DW(j6);
            DW.put("v", "1");
            DW.put("_v", u.DW);
            DW.put("tid", this.FH);
            if (this.DW.EQ().v5()) {
                FH("Dry run is enabled. GoogleAnalytics would have sent", j6(DW));
                return;
            }
            Map hashMap = new HashMap();
            p.j6(hashMap, "uid", gdVar.FH());
            fu fuVar = (fu) lVar.j6(fu.class);
            if (fuVar != null) {
                p.j6(hashMap, "an", fuVar.j6());
                p.j6(hashMap, "aid", fuVar.FH());
                p.j6(hashMap, "av", fuVar.DW());
                p.j6(hashMap, "aiid", fuVar.Hw());
            }
            DW.put("_s", String.valueOf(Mr().j6(new w(0, gdVar.DW(), this.FH, !TextUtils.isEmpty(gdVar.Hw()), 0, hashMap))));
            Mr().j6(new c(QX(), DW, lVar.Hw(), true));
        }
    }
}
