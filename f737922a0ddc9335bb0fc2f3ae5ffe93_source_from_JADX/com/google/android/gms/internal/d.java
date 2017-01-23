package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class d {

    public static class a {
        private final com.google.android.gms.internal.h.a DW;
        private final Map<String, com.google.android.gms.internal.h.a> j6;

        public com.google.android.gms.internal.h.a DW() {
            return this.DW;
        }

        public Map<String, com.google.android.gms.internal.h.a> j6() {
            return Collections.unmodifiableMap(this.j6);
        }

        public void j6(String str, com.google.android.gms.internal.h.a aVar) {
            this.j6.put(str, aVar);
        }

        public String toString() {
            String valueOf = String.valueOf(j6());
            String valueOf2 = String.valueOf(this.DW);
            return new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length()).append("Properties: ").append(valueOf).append(" pushAfterEvaluate: ").append(valueOf2).toString();
        }
    }

    public static class b {
        private final List<a> DW;
        private final List<a> FH;
        private final List<a> Hw;
        private final List<String> VH;
        private final List<a> Zo;
        private final List<String> gn;
        private final List<a> j6;
        private final List<a> v5;

        public List<a> DW() {
            return this.DW;
        }

        public List<a> FH() {
            return this.FH;
        }

        public List<a> Hw() {
            return this.Hw;
        }

        public List<String> VH() {
            return this.gn;
        }

        public List<String> Zo() {
            return this.VH;
        }

        public List<a> gn() {
            return this.Zo;
        }

        public List<a> j6() {
            return this.j6;
        }

        public String toString() {
            String valueOf = String.valueOf(j6());
            String valueOf2 = String.valueOf(DW());
            String valueOf3 = String.valueOf(FH());
            String valueOf4 = String.valueOf(Hw());
            String valueOf5 = String.valueOf(v5());
            String valueOf6 = String.valueOf(gn());
            return new StringBuilder((((((String.valueOf(valueOf).length() + 102) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()).append("Positive predicates: ").append(valueOf).append("  Negative predicates: ").append(valueOf2).append("  Add tags: ").append(valueOf3).append("  Remove tags: ").append(valueOf4).append("  Add macros: ").append(valueOf5).append("  Remove macros: ").append(valueOf6).toString();
        }

        public List<a> v5() {
            return this.v5;
        }
    }

    public static com.google.android.gms.internal.h.a j6(com.google.android.gms.internal.h.a aVar) {
        com.google.android.gms.internal.h.a aVar2 = new com.google.android.gms.internal.h.a();
        aVar2.j6 = aVar.j6;
        aVar2.EQ = (int[]) aVar.EQ.clone();
        if (aVar.we) {
            aVar2.we = aVar.we;
        }
        return aVar2;
    }
}
