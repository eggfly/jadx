package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.h;
import com.google.android.gms.analytics.l;
import com.google.android.gms.analytics.n;
import com.google.android.gms.analytics.p;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.fv;
import com.google.android.gms.internal.fy;
import com.google.android.gms.internal.gd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class aa extends t {
    private final y DW;
    private boolean EQ;
    private final i FH;
    private final h Hw;
    private final ai VH;
    private long Zo;
    private final ai gn;
    private boolean j6;
    private long tp;
    private final m u7;
    private final x v5;

    class 1 extends ai {
        final /* synthetic */ aa j6;

        1(aa aaVar, v vVar) {
            this.j6 = aaVar;
            super(vVar);
        }

        public void j6() {
            this.j6.cb();
        }
    }

    class 2 extends ai {
        final /* synthetic */ aa j6;

        2(aa aaVar, v vVar) {
            this.j6 = aaVar;
            super(vVar);
        }

        public void j6() {
            this.j6.dx();
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ aa j6;

        3(aa aaVar) {
            this.j6 = aaVar;
        }

        public void run() {
            this.j6.FH();
        }
    }

    class 4 implements al {
        final /* synthetic */ aa j6;

        4(aa aaVar) {
            this.j6 = aaVar;
        }

        public void j6(Throwable th) {
            this.j6.KD();
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ long DW;
        final /* synthetic */ aa FH;
        final /* synthetic */ al j6;

        5(aa aaVar, al alVar, long j) {
            this.FH = aaVar;
            this.j6 = alVar;
            this.DW = j;
        }

        public void run() {
            this.FH.j6(this.j6, this.DW);
        }
    }

    protected aa(v vVar, zzg com_google_android_gms_analytics_internal_zzg) {
        super(vVar);
        b.j6((Object) com_google_android_gms_analytics_internal_zzg);
        this.Zo = Long.MIN_VALUE;
        this.Hw = com_google_android_gms_analytics_internal_zzg.EQ(vVar);
        this.DW = com_google_android_gms_analytics_internal_zzg.J0(vVar);
        this.FH = com_google_android_gms_analytics_internal_zzg.J8(vVar);
        this.v5 = com_google_android_gms_analytics_internal_zzg.Ws(vVar);
        this.u7 = new m(J8());
        this.VH = new 1(this, vVar);
        this.gn = new 2(this, vVar);
    }

    private void Mz() {
        ak U2 = U2();
        if (U2.FH()) {
            U2.v5();
        }
    }

    private void Sf() {
        ef();
        long ro = ro();
        long Hw = lg().Hw();
        if (Hw != 0) {
            Hw = ro - Math.abs(J8().j6() - Hw);
            if (Hw <= 0) {
                Hw = Math.min(XL().gn(), ro);
            }
        } else {
            Hw = Math.min(XL().gn(), ro);
        }
        j6("Dispatch scheduled (ms)", Long.valueOf(Hw));
        if (this.VH.FH()) {
            this.VH.DW(Math.max(1, Hw + this.VH.DW()));
            return;
        }
        this.VH.j6(Hw);
    }

    private boolean VH(String str) {
        return Ws().checkCallingOrSelfPermission(str) == 0;
    }

    private void cb() {
        j6(new 4(this));
    }

    private void dx() {
        try {
            this.DW.u7();
            KD();
        } catch (SQLiteException e) {
            Hw("Failed to delete stale hits", e);
        }
        this.gn.j6(XL().vy());
    }

    private void ef() {
        ak U2 = U2();
        if (U2.DW() && !U2.FH()) {
            long SI = SI();
            if (SI != 0 && Math.abs(J8().j6() - SI) <= XL().EQ()) {
                j6("Dispatch alarm scheduled (ms)", Long.valueOf(XL().tp()));
                U2.Hw();
            }
        }
    }

    private void g3() {
        if (this.VH.FH()) {
            DW("All hits dispatched or no network/service. Going to power save mode");
        }
        this.VH.Hw();
    }

    private void j6(w wVar, fv fvVar) {
        b.j6((Object) wVar);
        b.j6((Object) fvVar);
        h hVar = new h(EQ());
        hVar.j6(wVar.FH());
        hVar.FH(wVar.Hw());
        l we = hVar.we();
        gd gdVar = (gd) we.DW(gd.class);
        gdVar.j6("data");
        gdVar.DW(true);
        we.j6((n) fvVar);
        fy fyVar = (fy) we.DW(fy.class);
        fu fuVar = (fu) we.DW(fu.class);
        for (Entry entry : wVar.Zo().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                fuVar.j6(str2);
            } else if ("av".equals(str)) {
                fuVar.DW(str2);
            } else if ("aid".equals(str)) {
                fuVar.FH(str2);
            } else if ("aiid".equals(str)) {
                fuVar.Hw(str2);
            } else if ("uid".equals(str)) {
                gdVar.FH(str2);
            } else {
                fyVar.j6(str, str2);
            }
        }
        DW("Sending installation campaign to", wVar.FH(), fvVar);
        we.j6(lg().DW());
        we.v5();
    }

    private boolean sG() {
        return this.EQ ? false : (!XL().j6() || XL().DW()) && ro() > 0;
    }

    private void sh() {
        J0();
        Context DW = EQ().DW();
        if (!k.j6(DW)) {
            v5("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!l.j6(DW)) {
            Zo("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.j6(DW)) {
            v5("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!CampaignTrackingService.j6(DW)) {
            v5("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    private void vJ() {
        g3();
        Mz();
    }

    c DW(c cVar) {
        if (!TextUtils.isEmpty(cVar.gn())) {
            return cVar;
        }
        Pair j6 = lg().VH().j6();
        if (j6 == null) {
            return cVar;
        }
        Long l = (Long) j6.second;
        String str = (String) j6.first;
        String valueOf = String.valueOf(l);
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
        Map hashMap = new HashMap(cVar.DW());
        hashMap.put("_m", valueOf);
        return c.j6(this, cVar, hashMap);
    }

    void DW() {
        P8();
        b.j6(!this.j6, (Object) "Analytics backend already started");
        this.j6 = true;
        aM().j6(new 3(this));
    }

    protected void FH() {
        P8();
        if (!XL().j6()) {
            sh();
        }
        lg().DW();
        if (!VH("android.permission.ACCESS_NETWORK_STATE")) {
            Zo("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            cn();
        }
        if (!VH("android.permission.INTERNET")) {
            Zo("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            cn();
        }
        if (l.j6(Ws())) {
            DW("AnalyticsService registered in the app manifest and enabled");
        } else if (XL().j6()) {
            Zo("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            v5("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.EQ || XL().j6() || this.DW.gn())) {
            VH();
        }
        KD();
    }

    void Hw() {
        J0();
        this.tp = J8().j6();
    }

    public void KD() {
        EQ().j3();
        P8();
        if (!sG()) {
            this.Hw.DW();
            vJ();
        } else if (this.DW.gn()) {
            this.Hw.DW();
            vJ();
        } else {
            boolean z;
            if (((Boolean) an.cn.j6()).booleanValue()) {
                z = true;
            } else {
                this.Hw.j6();
                z = this.Hw.v5();
            }
            if (z) {
                Sf();
                return;
            }
            vJ();
            ef();
        }
    }

    public long SI() {
        p.Hw();
        P8();
        try {
            return this.DW.tp();
        } catch (SQLiteException e) {
            v5("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    protected void VH() {
        if (!this.EQ && XL().FH() && !this.v5.DW()) {
            if (this.u7.j6(XL().rN())) {
                this.u7.j6();
                DW("Connecting to service");
                if (this.v5.Hw()) {
                    DW("Connected to service");
                    this.u7.DW();
                    v5();
                }
            }
        }
    }

    public void Zo() {
        p.Hw();
        P8();
        DW("Service disconnected");
    }

    public void cn() {
        P8();
        J0();
        this.EQ = true;
        this.v5.v5();
        KD();
    }

    public void gn() {
        p.Hw();
        P8();
        if (!XL().j6()) {
            DW("Delete all hits from local store");
            try {
                this.DW.v5();
                this.DW.Zo();
                KD();
            } catch (SQLiteException e) {
                Hw("Failed to delete hits from store", e);
            }
        }
        VH();
        if (this.v5.FH()) {
            DW("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long j6(com.google.android.gms.analytics.internal.w r6, boolean r7) {
        /*
        r5 = this;
        com.google.android.gms.common.internal.b.j6(r6);
        r5.P8();
        r5.J0();
        r0 = r5.DW;	 Catch:{ SQLiteException -> 0x0049 }
        r0.DW();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.DW;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.j6();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.DW();	 Catch:{ SQLiteException -> 0x0049 }
        r0.j6(r2, r1);	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.DW;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.j6();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.DW();	 Catch:{ SQLiteException -> 0x0049 }
        r4 = r6.FH();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r0.j6(r2, r1, r4);	 Catch:{ SQLiteException -> 0x0049 }
        if (r7 != 0) goto L_0x0042;
    L_0x002f:
        r6.j6(r0);	 Catch:{ SQLiteException -> 0x0049 }
    L_0x0032:
        r2 = r5.DW;	 Catch:{ SQLiteException -> 0x0049 }
        r2.j6(r6);	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.DW;	 Catch:{ SQLiteException -> 0x0049 }
        r2.FH();	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.DW;	 Catch:{ SQLiteException -> 0x0058 }
        r2.Hw();	 Catch:{ SQLiteException -> 0x0058 }
    L_0x0041:
        return r0;
    L_0x0042:
        r2 = 1;
        r2 = r2 + r0;
        r6.j6(r2);	 Catch:{ SQLiteException -> 0x0049 }
        goto L_0x0032;
    L_0x0049:
        r0 = move-exception;
        r1 = "Failed to update Analytics property";
        r5.v5(r1, r0);	 Catch:{ all -> 0x0068 }
        r0 = r5.DW;	 Catch:{ SQLiteException -> 0x0060 }
        r0.Hw();	 Catch:{ SQLiteException -> 0x0060 }
    L_0x0055:
        r0 = -1;
        goto L_0x0041;
    L_0x0058:
        r2 = move-exception;
        r3 = "Failed to end transaction";
        r5.v5(r3, r2);
        goto L_0x0041;
    L_0x0060:
        r0 = move-exception;
        r1 = "Failed to end transaction";
        r5.v5(r1, r0);
        goto L_0x0055;
    L_0x0068:
        r0 = move-exception;
        r1 = r5.DW;	 Catch:{ SQLiteException -> 0x006f }
        r1.Hw();	 Catch:{ SQLiteException -> 0x006f }
    L_0x006e:
        throw r0;
    L_0x006f:
        r1 = move-exception;
        r2 = "Failed to end transaction";
        r5.v5(r2, r1);
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.aa.j6(com.google.android.gms.analytics.internal.w, boolean):long");
    }

    protected void j6() {
        this.DW.ei();
        this.FH.ei();
        this.v5.ei();
    }

    public void j6(al alVar) {
        j6(alVar, this.tp);
    }

    public void j6(al alVar, long j) {
        p.Hw();
        P8();
        long j2 = -1;
        long Hw = lg().Hw();
        if (Hw != 0) {
            j2 = Math.abs(J8().j6() - Hw);
        }
        DW("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!XL().j6()) {
            VH();
        }
        try {
            if (tp()) {
                aM().j6(new 5(this, alVar, j));
                return;
            }
            lg().v5();
            KD();
            if (alVar != null) {
                alVar.j6(null);
            }
            if (this.tp != j) {
                this.Hw.FH();
            }
        } catch (Throwable th) {
            v5("Local dispatch failed", th);
            lg().v5();
            KD();
            if (alVar != null) {
                alVar.j6(th);
            }
        }
    }

    public void j6(c cVar) {
        b.j6((Object) cVar);
        p.Hw();
        P8();
        if (this.EQ) {
            FH("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            j6("Delivering hit", cVar);
        }
        c DW = DW(cVar);
        VH();
        if (this.v5.j6(DW)) {
            FH("Hit sent to the device AnalyticsService for delivery");
        } else if (XL().j6()) {
            QX().j6(DW, "Service unavailable on package side");
        } else {
            try {
                this.DW.j6(DW);
                KD();
            } catch (SQLiteException e) {
                v5("Delivery failed to save hit to a database", e);
                QX().j6(DW, "deliver: failed to insert hit to database");
            }
        }
    }

    protected void j6(w wVar) {
        J0();
        DW("Sending first hit to property", wVar.FH());
        if (!lg().FH().j6(XL().nw())) {
            String Zo = lg().Zo();
            if (!TextUtils.isEmpty(Zo)) {
                fv j6 = p.j6(QX(), Zo);
                DW("Found relevant installation campaign", j6);
                j6(wVar, j6);
            }
        }
    }

    public void j6(String str) {
        b.j6(str);
        J0();
        we();
        fv j6 = p.j6(QX(), str);
        if (j6 == null) {
            Hw("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence Zo = lg().Zo();
        if (str.equals(Zo)) {
            v5("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(Zo)) {
            lg().j6(str);
            if (lg().FH().j6(XL().nw())) {
                Hw("Campaign received too late, ignoring", j6);
                return;
            }
            DW("Received installation campaign", j6);
            for (w j62 : this.DW.Hw(0)) {
                j6(j62, j6);
            }
        } else {
            Hw("Ignoring multiple install campaigns. original, new", Zo, str);
        }
    }

    public void j6(boolean z) {
        KD();
    }

    public void nw() {
        p.Hw();
        P8();
        FH("Sync dispatching local hits");
        long j = this.tp;
        if (!XL().j6()) {
            VH();
        }
        do {
            try {
            } catch (Throwable th) {
                v5("Sync local dispatch failed", th);
                KD();
                return;
            }
        } while (tp());
        lg().v5();
        KD();
        if (this.tp != j) {
            this.Hw.FH();
        }
    }

    public long ro() {
        if (this.Zo != Long.MIN_VALUE) {
            return this.Zo;
        }
        return a8().Zo() ? ((long) a8().VH()) * 1000 : XL().u7();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean tp() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.analytics.p.Hw();
        r12.P8();
        r0 = "Dispatching a batch of local hits";
        r12.DW(r0);
        r0 = r12.v5;
        r0 = r0.DW();
        if (r0 != 0) goto L_0x0034;
    L_0x0016:
        r0 = r12.XL();
        r0 = r0.j6();
        if (r0 != 0) goto L_0x0034;
    L_0x0020:
        r0 = r1;
    L_0x0021:
        r3 = r12.FH;
        r3 = r3.DW();
        if (r3 != 0) goto L_0x0036;
    L_0x0029:
        if (r0 == 0) goto L_0x0038;
    L_0x002b:
        if (r1 == 0) goto L_0x0038;
    L_0x002d:
        r0 = "No network or service available. Will retry later";
        r12.DW(r0);
    L_0x0033:
        return r2;
    L_0x0034:
        r0 = r2;
        goto L_0x0021;
    L_0x0036:
        r1 = r2;
        goto L_0x0029;
    L_0x0038:
        r0 = r12.XL();
        r0 = r0.we();
        r1 = r12.XL();
        r1 = r1.J0();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = 0;
    L_0x0054:
        r0 = r12.DW;	 Catch:{ all -> 0x01fc }
        r0.DW();	 Catch:{ all -> 0x01fc }
        r3.clear();	 Catch:{ all -> 0x01fc }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x00da }
        r8 = r0.DW(r6);	 Catch:{ SQLiteException -> 0x00da }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00da }
        if (r0 == 0) goto L_0x0087;
    L_0x0068:
        r0 = "Store is empty, nothing to dispatch";
        r12.DW(r0);	 Catch:{ SQLiteException -> 0x00da }
        r12.vJ();	 Catch:{ SQLiteException -> 0x00da }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x007c }
        r0.FH();	 Catch:{ SQLiteException -> 0x007c }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x007c }
        r0.Hw();	 Catch:{ SQLiteException -> 0x007c }
        goto L_0x0033;
    L_0x007c:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.v5(r1, r0);
        r12.vJ();
        goto L_0x0033;
    L_0x0087:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00da }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00da }
        r12.j6(r0, r1);	 Catch:{ SQLiteException -> 0x00da }
        r1 = r8.iterator();	 Catch:{ all -> 0x01fc }
    L_0x0099:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01fc }
        if (r0 == 0) goto L_0x00fc;
    L_0x009f:
        r0 = r1.next();	 Catch:{ all -> 0x01fc }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01fc }
        r10 = r0.FH();	 Catch:{ all -> 0x01fc }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0099;
    L_0x00ad:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01fc }
        r3 = r8.size();	 Catch:{ all -> 0x01fc }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01fc }
        r12.Hw(r0, r1, r3);	 Catch:{ all -> 0x01fc }
        r12.vJ();	 Catch:{ all -> 0x01fc }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x00ce }
        r0.FH();	 Catch:{ SQLiteException -> 0x00ce }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x00ce }
        r0.Hw();	 Catch:{ SQLiteException -> 0x00ce }
        goto L_0x0033;
    L_0x00ce:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.v5(r1, r0);
        r12.vJ();
        goto L_0x0033;
    L_0x00da:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.Hw(r1, r0);	 Catch:{ all -> 0x01fc }
        r12.vJ();	 Catch:{ all -> 0x01fc }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x00f0 }
        r0.FH();	 Catch:{ SQLiteException -> 0x00f0 }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x00f0 }
        r0.Hw();	 Catch:{ SQLiteException -> 0x00f0 }
        goto L_0x0033;
    L_0x00f0:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.v5(r1, r0);
        r12.vJ();
        goto L_0x0033;
    L_0x00fc:
        r0 = r12.v5;	 Catch:{ all -> 0x01fc }
        r0 = r0.DW();	 Catch:{ all -> 0x01fc }
        if (r0 == 0) goto L_0x0214;
    L_0x0104:
        r0 = r12.XL();	 Catch:{ all -> 0x01fc }
        r0 = r0.j6();	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x0214;
    L_0x010e:
        r0 = "Service connected, sending hits to the service";
        r12.DW(r0);	 Catch:{ all -> 0x01fc }
    L_0x0114:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x0214;
    L_0x011a:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01fc }
        r0 = (com.google.android.gms.analytics.internal.c) r0;	 Catch:{ all -> 0x01fc }
        r1 = r12.v5;	 Catch:{ all -> 0x01fc }
        r1 = r1.j6(r0);	 Catch:{ all -> 0x01fc }
        if (r1 != 0) goto L_0x0152;
    L_0x0129:
        r0 = r4;
    L_0x012a:
        r4 = r12.FH;	 Catch:{ all -> 0x01fc }
        r4 = r4.DW();	 Catch:{ all -> 0x01fc }
        if (r4 == 0) goto L_0x01a3;
    L_0x0132:
        r4 = r12.FH;	 Catch:{ all -> 0x01fc }
        r8 = r4.j6(r8);	 Catch:{ all -> 0x01fc }
        r9 = r8.iterator();	 Catch:{ all -> 0x01fc }
        r4 = r0;
    L_0x013d:
        r0 = r9.hasNext();	 Catch:{ all -> 0x01fc }
        if (r0 == 0) goto L_0x019a;
    L_0x0143:
        r0 = r9.next();	 Catch:{ all -> 0x01fc }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01fc }
        r0 = r0.longValue();	 Catch:{ all -> 0x01fc }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01fc }
        goto L_0x013d;
    L_0x0152:
        r10 = r0.FH();	 Catch:{ all -> 0x01fc }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01fc }
        r8.remove(r0);	 Catch:{ all -> 0x01fc }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.DW(r1, r0);	 Catch:{ all -> 0x01fc }
        r1 = r12.DW;	 Catch:{ SQLiteException -> 0x0178 }
        r10 = r0.FH();	 Catch:{ SQLiteException -> 0x0178 }
        r1.FH(r10);	 Catch:{ SQLiteException -> 0x0178 }
        r0 = r0.FH();	 Catch:{ SQLiteException -> 0x0178 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x0178 }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x0178 }
        goto L_0x0114;
    L_0x0178:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.v5(r1, r0);	 Catch:{ all -> 0x01fc }
        r12.vJ();	 Catch:{ all -> 0x01fc }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x018e }
        r0.FH();	 Catch:{ SQLiteException -> 0x018e }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x018e }
        r0.Hw();	 Catch:{ SQLiteException -> 0x018e }
        goto L_0x0033;
    L_0x018e:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.v5(r1, r0);
        r12.vJ();
        goto L_0x0033;
    L_0x019a:
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x01c1 }
        r0.j6(r8);	 Catch:{ SQLiteException -> 0x01c1 }
        r3.addAll(r8);	 Catch:{ SQLiteException -> 0x01c1 }
        r0 = r4;
    L_0x01a3:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01fc }
        if (r4 == 0) goto L_0x01e3;
    L_0x01a9:
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x01b5 }
        r0.FH();	 Catch:{ SQLiteException -> 0x01b5 }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x01b5 }
        r0.Hw();	 Catch:{ SQLiteException -> 0x01b5 }
        goto L_0x0033;
    L_0x01b5:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.v5(r1, r0);
        r12.vJ();
        goto L_0x0033;
    L_0x01c1:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.v5(r1, r0);	 Catch:{ all -> 0x01fc }
        r12.vJ();	 Catch:{ all -> 0x01fc }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x01d7 }
        r0.FH();	 Catch:{ SQLiteException -> 0x01d7 }
        r0 = r12.DW;	 Catch:{ SQLiteException -> 0x01d7 }
        r0.Hw();	 Catch:{ SQLiteException -> 0x01d7 }
        goto L_0x0033;
    L_0x01d7:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.v5(r1, r0);
        r12.vJ();
        goto L_0x0033;
    L_0x01e3:
        r4 = r12.DW;	 Catch:{ SQLiteException -> 0x01f0 }
        r4.FH();	 Catch:{ SQLiteException -> 0x01f0 }
        r4 = r12.DW;	 Catch:{ SQLiteException -> 0x01f0 }
        r4.Hw();	 Catch:{ SQLiteException -> 0x01f0 }
        r4 = r0;
        goto L_0x0054;
    L_0x01f0:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.v5(r1, r0);
        r12.vJ();
        goto L_0x0033;
    L_0x01fc:
        r0 = move-exception;
        r1 = r12.DW;	 Catch:{ SQLiteException -> 0x0208 }
        r1.FH();	 Catch:{ SQLiteException -> 0x0208 }
        r1 = r12.DW;	 Catch:{ SQLiteException -> 0x0208 }
        r1.Hw();	 Catch:{ SQLiteException -> 0x0208 }
        throw r0;
    L_0x0208:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.v5(r1, r0);
        r12.vJ();
        goto L_0x0033;
    L_0x0214:
        r0 = r4;
        goto L_0x012a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.aa.tp():boolean");
    }

    public void u7() {
        p.Hw();
        P8();
        we();
        if (!XL().FH()) {
            v5("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.v5.DW()) {
            DW("Service not connected");
        } else if (!this.DW.gn()) {
            DW("Dispatching local hits to device AnalyticsService");
            while (true) {
                try {
                    break;
                    List DW = this.DW.DW((long) XL().we());
                    if (DW.isEmpty()) {
                        c cVar;
                        while (true) {
                            if (!DW.isEmpty()) {
                                cVar = (c) DW.get(0);
                                if (this.v5.j6(cVar)) {
                                    KD();
                                    return;
                                }
                                DW.remove(cVar);
                                try {
                                    this.DW.FH(cVar.FH());
                                } catch (SQLiteException e) {
                                    v5("Failed to remove hit that was send for delivery", e);
                                    vJ();
                                    return;
                                }
                            }
                        }
                        List DW2 = this.DW.DW((long) XL().we());
                        if (DW2.isEmpty()) {
                            while (true) {
                                if (DW2.isEmpty()) {
                                    cVar = (c) DW2.get(0);
                                    if (this.v5.j6(cVar)) {
                                        DW2.remove(cVar);
                                        this.DW.FH(cVar.FH());
                                    } else {
                                        KD();
                                        return;
                                    }
                                }
                            }
                        }
                        KD();
                        return;
                    }
                    KD();
                    return;
                } catch (SQLiteException e2) {
                    v5("Failed to read hits from store", e2);
                    vJ();
                    return;
                }
            }
        }
    }

    protected void v5() {
        J0();
        if (!XL().j6()) {
            u7();
        }
    }
}
