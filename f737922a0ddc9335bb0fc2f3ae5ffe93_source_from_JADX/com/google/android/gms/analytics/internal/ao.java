package com.google.android.gms.analytics.internal;

public class ao extends af<b> {

    private static class a implements com.google.android.gms.analytics.internal.af.a<b> {
        private final b DW;
        private final v j6;

        public a(v vVar) {
            this.j6 = vVar;
            this.DW = new b();
        }

        public /* synthetic */ ae DW() {
            return j6();
        }

        public void DW(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.DW.j6 = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.DW.DW = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.DW.FH = str2;
            } else {
                this.j6.Zo().Hw("String xml configuration name not recognized", str);
            }
        }

        public b j6() {
            return this.DW;
        }

        public void j6(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.DW.Hw = i;
            } else {
                this.j6.Zo().Hw("Int xml configuration name not recognized", str);
            }
        }

        public void j6(String str, String str2) {
        }

        public void j6(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.DW.v5 = z ? 1 : 0;
                return;
            }
            this.j6.Zo().Hw("Bool xml configuration name not recognized", str);
        }
    }

    public ao(v vVar) {
        super(vVar, new a(vVar));
    }
}
