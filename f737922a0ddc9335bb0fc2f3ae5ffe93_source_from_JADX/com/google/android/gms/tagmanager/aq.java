package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.h.a;
import java.util.Map;

abstract class aq extends i {
    public aq(String str, String... strArr) {
        super(str, strArr);
    }

    public abstract void DW(Map<String, a> map);

    public a j6(Map<String, a> map) {
        DW(map);
        return as.j6();
    }

    public boolean j6() {
        return false;
    }
}
