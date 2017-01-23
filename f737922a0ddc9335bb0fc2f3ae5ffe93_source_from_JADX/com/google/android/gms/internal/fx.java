package com.google.android.gms.internal;

import com.google.android.gms.analytics.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class fx extends n<fx> {
    private Map<Integer, Double> j6;

    public fx() {
        this.j6 = new HashMap(4);
    }

    public Map<Integer, Double> j6() {
        return Collections.unmodifiableMap(this.j6);
    }

    public /* synthetic */ void j6(n nVar) {
        j6((fx) nVar);
    }

    public void j6(fx fxVar) {
        fxVar.j6.putAll(this.j6);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.j6.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 6).append("metric").append(valueOf).toString(), entry.getValue());
        }
        return n.j6((Object) hashMap);
    }
}
