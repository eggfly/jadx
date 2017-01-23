package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.f;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@eh
public class ay {
    private final List<aw> DW;
    private final Map<String, String> FH;
    private final Object Hw;
    boolean j6;
    private ay v5;

    public ay(boolean z, String str, String str2) {
        this.DW = new LinkedList();
        this.FH = new LinkedHashMap();
        this.Hw = new Object();
        this.j6 = z;
        this.FH.put("action", str);
        this.FH.put("ad_format", str2);
    }

    public aw j6() {
        return j6(f.VH().DW());
    }

    public aw j6(long j) {
        return !this.j6 ? null : new aw(j, null, null);
    }

    public void j6(ay ayVar) {
        synchronized (this.Hw) {
            this.v5 = ayVar;
        }
    }

    public void j6(String str, String str2) {
        if (this.j6 && !TextUtils.isEmpty(str2)) {
            ar j6 = f.Zo().j6();
            if (j6 != null) {
                synchronized (this.Hw) {
                    j6.j6(str).j6(this.FH, str, str2);
                }
            }
        }
    }

    public boolean j6(aw awVar, long j, String... strArr) {
        synchronized (this.Hw) {
            for (String awVar2 : strArr) {
                this.DW.add(new aw(j, awVar2, awVar));
            }
        }
        return true;
    }

    public boolean j6(aw awVar, String... strArr) {
        return (!this.j6 || awVar == null) ? false : j6(awVar, f.VH().DW(), strArr);
    }
}
