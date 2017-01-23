package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public interface aa {

    public static class a {
        public String DW;
        public long FH;
        public long Hw;
        public Map<String, String> VH;
        public long Zo;
        public byte[] j6;
        public long v5;

        public a() {
            this.VH = Collections.emptyMap();
        }

        public boolean DW() {
            return this.Zo < System.currentTimeMillis();
        }

        public boolean j6() {
            return this.v5 < System.currentTimeMillis();
        }
    }

    a j6(String str);

    void j6();

    void j6(String str, a aVar);
}
