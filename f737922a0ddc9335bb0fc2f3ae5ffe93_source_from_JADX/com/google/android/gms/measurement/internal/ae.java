package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;

class ae extends b {
    static final Pair<String, Long> j6;
    public final c DW;
    public final b EQ;
    public final b FH;
    public final b Hw;
    public boolean J0;
    private String QX;
    public final b VH;
    private SharedPreferences Ws;
    private boolean XL;
    public final b Zo;
    private long aM;
    public final b gn;
    private SecureRandom j3;
    public final a tp;
    public final b u7;
    public final b v5;
    public final b we;

    public final class a {
        private final String DW;
        private final boolean FH;
        private boolean Hw;
        final /* synthetic */ ae j6;
        private boolean v5;

        public a(ae aeVar, String str, boolean z) {
            this.j6 = aeVar;
            com.google.android.gms.common.internal.b.j6(str);
            this.DW = str;
            this.FH = z;
        }

        private void DW() {
            if (!this.Hw) {
                this.Hw = true;
                this.v5 = this.j6.Ws.getBoolean(this.DW, this.FH);
            }
        }

        public void j6(boolean z) {
            Editor edit = this.j6.Ws.edit();
            edit.putBoolean(this.DW, z);
            edit.apply();
            this.v5 = z;
        }

        public boolean j6() {
            DW();
            return this.v5;
        }
    }

    public final class b {
        private final String DW;
        private final long FH;
        private boolean Hw;
        final /* synthetic */ ae j6;
        private long v5;

        public b(ae aeVar, String str, long j) {
            this.j6 = aeVar;
            com.google.android.gms.common.internal.b.j6(str);
            this.DW = str;
            this.FH = j;
        }

        private void DW() {
            if (!this.Hw) {
                this.Hw = true;
                this.v5 = this.j6.Ws.getLong(this.DW, this.FH);
            }
        }

        public long j6() {
            DW();
            return this.v5;
        }

        public void j6(long j) {
            Editor edit = this.j6.Ws.edit();
            edit.putLong(this.DW, j);
            edit.apply();
            this.v5 = j;
        }
    }

    public final class c {
        final /* synthetic */ ae DW;
        private final String FH;
        private final String Hw;
        final String j6;
        private final long v5;

        private c(ae aeVar, String str, long j) {
            this.DW = aeVar;
            com.google.android.gms.common.internal.b.j6(str);
            com.google.android.gms.common.internal.b.DW(j > 0);
            this.j6 = String.valueOf(str).concat(":start");
            this.FH = String.valueOf(str).concat(":count");
            this.Hw = String.valueOf(str).concat(":value");
            this.v5 = j;
        }

        private void DW() {
            this.DW.tp();
            long j6 = this.DW.QX().j6();
            Editor edit = this.DW.Ws.edit();
            edit.remove(this.FH);
            edit.remove(this.Hw);
            edit.putLong(this.j6, j6);
            edit.apply();
        }

        private long FH() {
            this.DW.tp();
            long Hw = Hw();
            if (Hw != 0) {
                return Math.abs(Hw - this.DW.QX().j6());
            }
            DW();
            return 0;
        }

        private long Hw() {
            return this.DW.nw().getLong(this.j6, 0);
        }

        public Pair<String, Long> j6() {
            this.DW.tp();
            long FH = FH();
            if (FH < this.v5) {
                return null;
            }
            if (FH > this.v5 * 2) {
                DW();
                return null;
            }
            String string = this.DW.nw().getString(this.Hw, null);
            FH = this.DW.nw().getLong(this.FH, 0);
            DW();
            return (string == null || FH <= 0) ? ae.j6 : new Pair(string, Long.valueOf(FH));
        }

        public void j6(String str) {
            j6(str, 1);
        }

        public void j6(String str, long j) {
            this.DW.tp();
            if (Hw() == 0) {
                DW();
            }
            if (str == null) {
                str = "";
            }
            long j2 = this.DW.Ws.getLong(this.FH, 0);
            if (j2 <= 0) {
                Editor edit = this.DW.Ws.edit();
                edit.putString(this.Hw, str);
                edit.putLong(this.FH, j);
                edit.apply();
                return;
            }
            Object obj = (this.DW.ei().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
            Editor edit2 = this.DW.Ws.edit();
            if (obj != null) {
                edit2.putString(this.Hw, str);
            }
            edit2.putLong(this.FH, j2 + j);
            edit2.apply();
        }
    }

    static {
        j6 = new Pair("", Long.valueOf(0));
    }

    ae(ai aiVar) {
        super(aiVar);
        this.DW = new c("health_monitor", er().Qq(), null);
        this.FH = new b(this, "last_upload", 0);
        this.Hw = new b(this, "last_upload_attempt", 0);
        this.v5 = new b(this, "backoff", 0);
        this.Zo = new b(this, "last_delete_stale", 0);
        this.gn = new b(this, "time_before_start", 10000);
        this.u7 = new b(this, "session_timeout", 1800000);
        this.tp = new a(this, "start_new_session", true);
        this.EQ = new b(this, "last_pause_time", 0);
        this.we = new b(this, "time_active", 0);
        this.VH = new b(this, "midnight_offset", 0);
    }

    private SecureRandom ei() {
        tp();
        if (this.j3 == null) {
            this.j3 = new SecureRandom();
        }
        return this.j3;
    }

    private SharedPreferences nw() {
        tp();
        FH();
        return this.Ws;
    }

    Boolean BT() {
        tp();
        return !nw().contains("use_service") ? null : Boolean.valueOf(nw().getBoolean("use_service", false));
    }

    String DW(String str) {
        String str2 = (String) j6(str).first;
        if (l.gn("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, l.gn("MD5").digest(str2.getBytes()))});
    }

    void DW(boolean z) {
        tp();
        lg().ei().j6("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = nw().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    void FH(String str) {
        tp();
        Editor edit = nw().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    boolean FH(boolean z) {
        tp();
        return nw().getBoolean("measurement_enabled", z);
    }

    protected String P8() {
        tp();
        String string = nw().getString("previous_os_version", null);
        String VH = J8().VH();
        if (!(TextUtils.isEmpty(VH) || VH.equals(string))) {
            Editor edit = nw().edit();
            edit.putString("previous_os_version", VH);
            edit.apply();
        }
        return string;
    }

    String VH() {
        tp();
        return com.google.firebase.iid.b.j6().DW();
    }

    String Zo() {
        ei().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    String gW() {
        tp();
        return nw().getString("gmp_app_id", null);
    }

    Pair<String, Boolean> j6(String str) {
        tp();
        long DW = QX().DW();
        if (this.QX != null && DW < this.aM) {
            return new Pair(this.QX, Boolean.valueOf(this.XL));
        }
        this.aM = DW + er().DW(str);
        AdvertisingIdClient.DW(true);
        try {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.a DW2 = AdvertisingIdClient.DW(XL());
            this.QX = DW2.j6();
            if (this.QX == null) {
                this.QX = "";
            }
            this.XL = DW2.DW();
        } catch (Throwable th) {
            lg().P8().j6("Unable to get advertising id", th);
            this.QX = "";
        }
        AdvertisingIdClient.DW(false);
        return new Pair(this.QX, Boolean.valueOf(this.XL));
    }

    void j6(boolean z) {
        tp();
        lg().ei().j6("Setting useService", Boolean.valueOf(z));
        Editor edit = nw().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    protected void v5() {
        this.Ws = XL().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.J0 = this.Ws.getBoolean("has_been_opened", false);
        if (!this.J0) {
            Editor edit = this.Ws.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }

    void vy() {
        boolean z = true;
        tp();
        lg().ei().j6("Clearing collection preferences.");
        boolean contains = nw().contains("measurement_enabled");
        if (contains) {
            z = FH(true);
        }
        Editor edit = nw().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            DW(z);
        }
    }

    long yS() {
        FH();
        tp();
        long j6 = this.VH.j6();
        if (j6 != 0) {
            return j6;
        }
        j6 = (long) (ei().nextInt(86400000) + 1);
        this.VH.j6(j6);
        return j6;
    }
}
