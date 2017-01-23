package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.h.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class i {
    private final String DW;
    private final Set<String> j6;

    public i(String str, String... strArr) {
        this.DW = str;
        this.j6 = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.j6.add(add);
        }
    }

    public Set<String> DW() {
        return this.j6;
    }

    public abstract a j6(Map<String, a> map);

    public abstract boolean j6();

    boolean j6(Set<String> set) {
        return set.containsAll(this.j6);
    }
}
