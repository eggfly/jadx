package com.google.android.gms.measurement.internal;

import afq;
import afr;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.b;
import java.util.HashSet;
import java.util.Set;

public class c extends b {
    private b DW;
    private final Set<com.google.android.gms.measurement.AppMeasurement.c> FH;
    private boolean Hw;
    private a j6;

    class 1 implements Runnable {
        final /* synthetic */ c DW;
        final /* synthetic */ boolean j6;

        public void run() {
            this.DW.j6(this.j6);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ long FH;
        final /* synthetic */ Bundle Hw;
        final /* synthetic */ boolean VH;
        final /* synthetic */ boolean Zo;
        final /* synthetic */ String gn;
        final /* synthetic */ String j6;
        final /* synthetic */ c u7;
        final /* synthetic */ boolean v5;

        2(c cVar, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
            this.u7 = cVar;
            this.j6 = str;
            this.DW = str2;
            this.FH = j;
            this.Hw = bundle;
            this.v5 = z;
            this.Zo = z2;
            this.VH = z3;
            this.gn = str3;
        }

        public void run() {
            this.u7.DW(this.j6, this.DW, this.FH, this.Hw, this.v5, this.Zo, this.VH, this.gn);
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ String DW;
        final /* synthetic */ Object FH;
        final /* synthetic */ long Hw;
        final /* synthetic */ String j6;
        final /* synthetic */ c v5;

        3(c cVar, String str, String str2, Object obj, long j) {
            this.v5 = cVar;
            this.j6 = str;
            this.DW = str2;
            this.FH = obj;
            this.Hw = j;
        }

        public void run() {
            this.v5.j6(this.j6, this.DW, this.FH, this.Hw);
        }
    }

    @TargetApi(14)
    private class a implements ActivityLifecycleCallbacks {
        final /* synthetic */ c j6;

        private a(c cVar) {
            this.j6 = cVar;
        }

        private boolean j6(Uri uri) {
            Object queryParameter = uri.getQueryParameter("utm_campaign");
            Object queryParameter2 = uri.getQueryParameter("utm_source");
            Object queryParameter3 = uri.getQueryParameter("utm_medium");
            Object queryParameter4 = uri.getQueryParameter("gclid");
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                return false;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            queryParameter = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("content", queryParameter);
            }
            queryParameter = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("aclid", queryParameter);
            }
            queryParameter = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("cp1", queryParameter);
            }
            queryParameter = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("anid", queryParameter);
            }
            this.j6.j6("auto", "_cmp", bundle);
            return true;
        }

        private boolean j6(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.j6.j6("auto", "_ldl", (Object) str);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                this.j6.lg().ei().j6("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        if (bundle == null) {
                            j6(data);
                        }
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.contains("gclid")) {
                                this.j6.lg().P8().j6("Activity created with referrer", queryParameter);
                                j6(queryParameter);
                                return;
                            }
                            this.j6.lg().P8().j6("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                this.j6.lg().Zo().j6("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            this.j6.U2().VH();
        }

        public void onActivityResumed(Activity activity) {
            this.j6.U2().Zo();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected c(ai aiVar) {
        super(aiVar);
        this.FH = new HashSet();
    }

    private void DW(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6(str2);
        com.google.android.gms.common.internal.b.j6((Object) bundle);
        tp();
        FH();
        if (this.J8.P8()) {
            if (!this.Hw) {
                this.Hw = true;
                yS();
            }
            boolean tp = l.tp(str2);
            if (z && this.DW != null && !tp) {
                lg().P8().j6("Passing event to registered event handler (FE)", str2, bundle);
                this.DW.j6(str, str2, bundle, j);
                return;
            } else if (this.J8.DW()) {
                int DW = j3().DW(str2);
                if (DW != 0) {
                    this.J8.J8().j6(DW, "_ev", j3().j6(str2, er().FH(), true));
                    return;
                }
                bundle.putString("_o", str);
                Bundle j6 = j3().j6(str2, bundle, afr.j6((Object) "_o"), z3);
                Bundle j62 = z2 ? j6(j6) : j6;
                lg().P8().j6("Logging event (FE)", str2, j62);
                Ws().j6(new EventParcel(str2, new EventParams(j62), str, j), str3);
                for (com.google.android.gms.measurement.AppMeasurement.c j63 : this.FH) {
                    j63.j6(str, str2, j62, j);
                }
                return;
            } else {
                return;
            }
        }
        lg().P8().j6("Event not sent since app measurement is disabled");
    }

    private String gW() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void j6(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        j6(str, str2, QX().j6(), bundle, z, z2, z3, str3);
    }

    private void j6(String str, String str2, Object obj, long j) {
        com.google.android.gms.common.internal.b.j6(str);
        com.google.android.gms.common.internal.b.j6(str2);
        tp();
        gn();
        FH();
        if (!this.J8.P8()) {
            lg().P8().j6("User property not set since app measurement is disabled");
        } else if (this.J8.DW()) {
            lg().P8().j6("Setting user property (FE)", str2, obj);
            Ws().j6(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    private void j6(boolean z) {
        tp();
        gn();
        FH();
        lg().P8().j6("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        rN().DW(z);
        Ws().VH();
    }

    private void yS() {
        try {
            j6(Class.forName(gW()));
        } catch (ClassNotFoundException e) {
            lg().vy().j6("Tag Manager is not found and thus will not be used");
        }
    }

    public /* bridge */ /* synthetic */ n EQ() {
        return super.EQ();
    }

    public /* bridge */ /* synthetic */ y J0() {
        return super.J0();
    }

    public /* bridge */ /* synthetic */ r J8() {
        return super.J8();
    }

    public /* bridge */ /* synthetic */ ag Mr() {
        return super.Mr();
    }

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    public void VH() {
        tp();
        gn();
        FH();
        if (this.J8.DW()) {
            Ws().yS();
            String P8 = rN().P8();
            if (!TextUtils.isEmpty(P8) && !P8.equals(J8().VH())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", P8);
                j6("auto", "_ou", bundle);
            }
        }
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    @TargetApi(14)
    public void Zo() {
        if (XL().getApplicationContext() instanceof Application) {
            Application application = (Application) XL().getApplicationContext();
            if (this.j6 == null) {
                this.j6 = new a();
            }
            application.unregisterActivityLifecycleCallbacks(this.j6);
            application.registerActivityLifecycleCallbacks(this.j6);
            lg().ei().j6("Registered activity lifecycle callback");
        }
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    Bundle j6(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object DW = j3().DW(str, bundle.get(str));
                if (DW == null) {
                    lg().yS().j6("Param value can't be null", str);
                } else if ((!(DW instanceof String) && !(DW instanceof Character) && !(DW instanceof CharSequence)) || !TextUtils.isEmpty(String.valueOf(DW))) {
                    j3().j6(bundle2, str, DW);
                }
            }
        }
        return bundle2;
    }

    public void j6(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{XL()});
        } catch (Exception e) {
            lg().yS().j6("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    protected void j6(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        a8().j6(new 2(this, str, str2, j, bundle != null ? new Bundle(bundle) : new Bundle(), z, z2, z3, str3));
    }

    void j6(String str, String str2, long j, Object obj) {
        a8().j6(new 3(this, str, str2, obj, j));
    }

    public void j6(String str, String str2, Bundle bundle) {
        gn();
        boolean z = this.DW == null || l.tp(str2);
        j6(str, str2, bundle, true, z, false, null);
    }

    public void j6(String str, String str2, Object obj) {
        com.google.android.gms.common.internal.b.j6(str);
        long j6 = QX().j6();
        int FH = j3().FH(str2);
        if (FH != 0) {
            this.J8.J8().j6(FH, "_ev", j3().j6(str2, er().Hw(), true));
        } else if (obj != null) {
            FH = j3().FH(str2, obj);
            if (FH != 0) {
                this.J8.J8().j6(FH, "_ev", j3().j6(str2, er().Hw(), true));
                return;
            }
            Object Hw = j3().Hw(str2, obj);
            if (Hw != null) {
                j6(str, str2, j6, Hw);
            }
        } else {
            j6(str, str2, j6, null);
        }
    }

    public /* bridge */ /* synthetic */ aa lg() {
        return super.lg();
    }

    public /* bridge */ /* synthetic */ ae rN() {
        return super.rN();
    }

    public /* bridge */ /* synthetic */ void tp() {
        super.tp();
    }

    public /* bridge */ /* synthetic */ void u7() {
        super.u7();
    }

    protected void v5() {
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }
}
