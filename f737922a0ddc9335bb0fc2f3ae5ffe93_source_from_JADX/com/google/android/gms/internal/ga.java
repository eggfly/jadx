package com.google.android.gms.internal;

import afi;
import afj;
import afk;
import com.google.android.gms.analytics.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ga extends n<ga> {
    private final List<afk> DW;
    private final Map<String, List<afi>> FH;
    private afj Hw;
    private final List<afi> j6;

    public ga() {
        this.j6 = new ArrayList();
        this.DW = new ArrayList();
        this.FH = new HashMap();
    }

    public List<afi> DW() {
        return Collections.unmodifiableList(this.j6);
    }

    public Map<String, List<afi>> FH() {
        return this.FH;
    }

    public List<afk> Hw() {
        return Collections.unmodifiableList(this.DW);
    }

    public afj j6() {
        return this.Hw;
    }

    public void j6(afi afi, String str) {
        if (afi != null) {
            Object obj;
            if (str == null) {
                obj = "";
            }
            if (!this.FH.containsKey(obj)) {
                this.FH.put(obj, new ArrayList());
            }
            ((List) this.FH.get(obj)).add(afi);
        }
    }

    public /* synthetic */ void j6(n nVar) {
        j6((ga) nVar);
    }

    public void j6(ga gaVar) {
        gaVar.j6.addAll(this.j6);
        gaVar.DW.addAll(this.DW);
        for (Entry entry : this.FH.entrySet()) {
            String str = (String) entry.getKey();
            for (afi j6 : (List) entry.getValue()) {
                gaVar.j6(j6, str);
            }
        }
        if (this.Hw != null) {
            gaVar.Hw = this.Hw;
        }
    }

    public String toString() {
        Map hashMap = new HashMap();
        if (!this.j6.isEmpty()) {
            hashMap.put("products", this.j6);
        }
        if (!this.DW.isEmpty()) {
            hashMap.put("promotions", this.DW);
        }
        if (!this.FH.isEmpty()) {
            hashMap.put("impressions", this.FH);
        }
        hashMap.put("productAction", this.Hw);
        return n.j6((Object) hashMap);
    }
}
