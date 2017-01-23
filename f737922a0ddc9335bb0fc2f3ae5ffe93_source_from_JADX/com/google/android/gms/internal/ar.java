package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

@eh
public class ar {
    Map<String, au> DW;
    BlockingQueue<ay> j6;

    public au j6(String str) {
        au auVar = (au) this.DW.get(str);
        return auVar != null ? auVar : au.j6;
    }

    public boolean j6(ay ayVar) {
        return this.j6.offer(ayVar);
    }
}
