package com.google.android.gms.analytics.internal;

import agc;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.b;
import java.util.HashSet;
import java.util.Set;

public class ag {
    private volatile Boolean DW;
    private String FH;
    private Set<Integer> Hw;
    private final v j6;

    protected ag(v vVar) {
        b.j6((Object) vVar);
        this.j6 = vVar;
    }

    public String BT() {
        return "google_analytics2_v4.db";
    }

    public boolean DW() {
        if (this.DW == null) {
            synchronized (this) {
                if (this.DW == null) {
                    ApplicationInfo applicationInfo = this.j6.DW().getApplicationInfo();
                    String DW = agc.DW();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(DW);
                        this.DW = Boolean.valueOf(z);
                    }
                    if ((this.DW == null || !this.DW.booleanValue()) && "com.google.android.gms.analytics".equals(DW)) {
                        this.DW = Boolean.TRUE;
                    }
                    if (this.DW == null) {
                        this.DW = Boolean.TRUE;
                        this.j6.Zo().Zo("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.DW.booleanValue();
    }

    public long EQ() {
        return ((Long) an.J8.j6()).longValue();
    }

    public boolean FH() {
        return ((Boolean) an.DW.j6()).booleanValue();
    }

    public int Hw() {
        return ((Integer) an.U2.j6()).intValue();
    }

    public int J0() {
        return ((Integer) an.QX.j6()).intValue();
    }

    public long J8() {
        return (long) ((Integer) an.vy.j6()).intValue();
    }

    public ad Mr() {
        return ad.j6((String) an.lg.j6());
    }

    public int P8() {
        return ((Integer) an.ei.j6()).intValue();
    }

    public String QX() {
        return (String) an.XL.j6();
    }

    public long SI() {
        return ((Long) an.Sf.j6()).longValue();
    }

    public Set<Integer> U2() {
        String str = (String) an.BT.j6();
        if (this.Hw == null || this.FH == null || !this.FH.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.FH = str;
            this.Hw = hashSet;
        }
        return this.Hw;
    }

    public int VH() {
        return ((Integer) an.gW.j6()).intValue();
    }

    public String Ws() {
        return (String) an.aM.j6();
    }

    public String XL() {
        return (String) an.j3.j6();
    }

    public int Zo() {
        return ((Integer) an.yS.j6()).intValue();
    }

    public long a8() {
        return ((Long) an.sh.j6()).longValue();
    }

    public String aM() {
        return (String) an.Mr.j6();
    }

    public int ei() {
        return ((Integer) an.nw.j6()).intValue();
    }

    public int er() {
        return ((Integer) an.Zo.j6()).intValue();
    }

    public String gW() {
        return "google_analytics_v4.db";
    }

    public long gn() {
        return ((Long) an.tp.j6()).longValue();
    }

    public ab j3() {
        return ab.j6((String) an.a8.j6());
    }

    public boolean j6() {
        return false;
    }

    public long lg() {
        return ((Long) an.cb.j6()).longValue();
    }

    public long nw() {
        return ((Long) an.SI.j6()).longValue();
    }

    public long rN() {
        return ((Long) an.ef.j6()).longValue();
    }

    public long tp() {
        return ((Long) an.J0.j6()).longValue();
    }

    public long u7() {
        return ((Long) an.u7.j6()).longValue();
    }

    public int v5() {
        return ((Integer) an.er.j6()).intValue();
    }

    public long vy() {
        return 86400000;
    }

    public int we() {
        return ((Integer) an.Ws.j6()).intValue();
    }

    public int yS() {
        return ((Integer) an.gn.j6()).intValue();
    }
}
