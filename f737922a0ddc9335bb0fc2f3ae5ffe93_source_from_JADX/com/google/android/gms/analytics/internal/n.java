package com.google.android.gms.analytics.internal;

public class n extends af<o> {

    private static class a extends s implements com.google.android.gms.analytics.internal.af.a<o> {
        private final o j6;

        public a(v vVar) {
            super(vVar);
            this.j6 = new o();
        }

        public /* synthetic */ ae DW() {
            return j6();
        }

        public void DW(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.j6.j6 = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.j6.DW = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    FH("Error parsing ga_sampleFrequency value", str2, e);
                }
            } else {
                Hw("string configuration name not recognized", str);
            }
        }

        public o j6() {
            return this.j6;
        }

        public void j6(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.j6.FH = i;
            } else {
                Hw("int configuration name not recognized", str);
            }
        }

        public void j6(String str, String str2) {
            this.j6.VH.put(str, str2);
        }

        public void j6(String str, boolean z) {
            int i = 1;
            o oVar;
            if ("ga_autoActivityTracking".equals(str)) {
                oVar = this.j6;
                if (!z) {
                    i = 0;
                }
                oVar.Hw = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                oVar = this.j6;
                if (!z) {
                    i = 0;
                }
                oVar.v5 = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                oVar = this.j6;
                if (!z) {
                    i = 0;
                }
                oVar.Zo = i;
            } else {
                Hw("bool configuration name not recognized", str);
            }
        }
    }

    public n(v vVar) {
        super(vVar, new a(vVar));
    }
}
