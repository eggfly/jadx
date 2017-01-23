package com.google.android.gms.internal;

import com.google.android.gms.analytics.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class fw extends n<fw> {
    private Map<Integer, String> j6;

    public fw() {
        this.j6 = new HashMap(4);
    }

    public Map<Integer, String> j6() {
        return Collections.unmodifiableMap(this.j6);
    }

    public /* synthetic */ void j6(n nVar) {
        j6((fw) nVar);
    }

    public void j6(fw fwVar) {
        fwVar.j6.putAll(this.j6);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.j6.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 9).append("dimension").append(valueOf).toString(), entry.getValue());
        }
        return n.j6((Object) hashMap);
    }
}
