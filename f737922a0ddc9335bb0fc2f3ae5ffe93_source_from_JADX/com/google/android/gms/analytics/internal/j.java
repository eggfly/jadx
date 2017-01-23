package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.b;
import java.util.UUID;

public class j extends t {
    private long DW;
    private long FH;
    private final a Hw;
    private SharedPreferences j6;

    public final class a {
        private final String DW;
        private final long FH;
        final /* synthetic */ j j6;

        private a(j jVar, String str, long j) {
            this.j6 = jVar;
            b.j6(str);
            b.DW(j > 0);
            this.DW = str;
            this.FH = j;
        }

        private void FH() {
            long j6 = this.j6.J8().j6();
            Editor edit = this.j6.j6.edit();
            edit.remove(VH());
            edit.remove(DW());
            edit.putLong(Zo(), j6);
            edit.commit();
        }

        private long Hw() {
            long v5 = v5();
            return v5 == 0 ? 0 : Math.abs(v5 - this.j6.J8().j6());
        }

        private String VH() {
            return String.valueOf(this.DW).concat(":count");
        }

        private String Zo() {
            return String.valueOf(this.DW).concat(":start");
        }

        private long v5() {
            return this.j6.j6.getLong(Zo(), 0);
        }

        protected String DW() {
            return String.valueOf(this.DW).concat(":value");
        }

        public Pair<String, Long> j6() {
            long Hw = Hw();
            if (Hw < this.FH) {
                return null;
            }
            if (Hw > this.FH * 2) {
                FH();
                return null;
            }
            String string = this.j6.j6.getString(DW(), null);
            Hw = this.j6.j6.getLong(VH(), 0);
            FH();
            return (string == null || Hw <= 0) ? null : new Pair(string, Long.valueOf(Hw));
        }

        public void j6(String str) {
            if (v5() == 0) {
                FH();
            }
            if (str == null) {
                str = "";
            }
            synchronized (this) {
                long j = this.j6.j6.getLong(VH(), 0);
                if (j <= 0) {
                    Editor edit = this.j6.j6.edit();
                    edit.putString(DW(), str);
                    edit.putLong(VH(), 1);
                    edit.apply();
                    return;
                }
                Object obj = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1) ? 1 : null;
                Editor edit2 = this.j6.j6.edit();
                if (obj != null) {
                    edit2.putString(DW(), str);
                }
                edit2.putLong(VH(), j + 1);
                edit2.apply();
            }
        }
    }

    protected j(v vVar) {
        super(vVar);
        this.FH = -1;
        this.Hw = new a("monitoring", XL().SI(), null);
    }

    public long DW() {
        J0();
        P8();
        if (this.DW == 0) {
            long j = this.j6.getLong("first_run", 0);
            if (j != 0) {
                this.DW = j;
            } else {
                j = J8().j6();
                Editor edit = this.j6.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    v5("Failed to commit first run time");
                }
                this.DW = j;
            }
        }
        return this.DW;
    }

    public m FH() {
        return new m(J8(), DW());
    }

    public long Hw() {
        J0();
        P8();
        if (this.FH == -1) {
            this.FH = this.j6.getLong("last_dispatch", 0);
        }
        return this.FH;
    }

    public a VH() {
        return this.Hw;
    }

    public String Zo() {
        J0();
        P8();
        CharSequence string = this.j6.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }

    protected void j6() {
        this.j6 = Ws().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public void j6(String str) {
        J0();
        P8();
        Editor edit = this.j6.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            v5("Failed to commit campaign data");
        }
    }

    public void v5() {
        J0();
        P8();
        long j6 = J8().j6();
        Editor edit = this.j6.edit();
        edit.putLong("last_dispatch", j6);
        edit.apply();
        this.FH = j6;
    }
}
