package com.google.android.gms.internal;

import com.google.android.gms.analytics.n;
import com.google.android.gms.common.internal.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class fy extends n<fy> {
    private final Map<String, Object> j6;

    public fy() {
        this.j6 = new HashMap();
    }

    private String j6(String str) {
        b.j6(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        b.j6(str, (Object) "Name can not be empty or \"&\"");
        return str;
    }

    public Map<String, Object> j6() {
        return Collections.unmodifiableMap(this.j6);
    }

    public /* synthetic */ void j6(n nVar) {
        j6((fy) nVar);
    }

    public void j6(fy fyVar) {
        b.j6((Object) fyVar);
        fyVar.j6.putAll(this.j6);
    }

    public void j6(String str, String str2) {
        this.j6.put(j6(str), str2);
    }

    public String toString() {
        return n.j6((Object) this.j6);
    }
}
