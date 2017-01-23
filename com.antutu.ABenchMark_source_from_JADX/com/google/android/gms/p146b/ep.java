package com.google.android.gms.p146b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.eo.C3171a;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.ep */
public class ep extends eq implements cb {
    DisplayMetrics f10810a;
    int f10811b;
    int f10812c;
    int f10813d;
    int f10814e;
    int f10815f;
    int f10816g;
    private final ii f10817h;
    private final Context f10818i;
    private final WindowManager f10819j;
    private final ai f10820k;
    private float f10821l;
    private int f10822m;

    public ep(ii iiVar, Context context, ai aiVar) {
        super(iiVar);
        this.f10811b = -1;
        this.f10812c = -1;
        this.f10813d = -1;
        this.f10814e = -1;
        this.f10815f = -1;
        this.f10816g = -1;
        this.f10817h = iiVar;
        this.f10818i = context;
        this.f10820k = aiVar;
        this.f10819j = (WindowManager) context.getSystemService("window");
    }

    private void m12626g() {
        this.f10810a = new DisplayMetrics();
        Display defaultDisplay = this.f10819j.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f10810a);
        this.f10821l = this.f10810a.density;
        this.f10822m = defaultDisplay.getRotation();
    }

    private void m12627h() {
        int[] iArr = new int[2];
        this.f10817h.getLocationOnScreen(iArr);
        m12630a(C2784w.m10741a().m11569b(this.f10818i, iArr[0]), C2784w.m10741a().m11569b(this.f10818i, iArr[1]));
    }

    private eo m12628i() {
        return new C3171a().m12621b(this.f10820k.m11776a()).m12619a(this.f10820k.m11778b()).m12622c(this.f10820k.m11781f()).m12623d(this.f10820k.m11779c()).m12624e(this.f10820k.m11780d()).m12620a();
    }

    void m12629a() {
        this.f10811b = C2784w.m10741a().m11570b(this.f10810a, this.f10810a.widthPixels);
        this.f10812c = C2784w.m10741a().m11570b(this.f10810a, this.f10810a.heightPixels);
        Activity f = this.f10817h.m13243f();
        if (f == null || f.getWindow() == null) {
            this.f10813d = this.f10811b;
            this.f10814e = this.f10812c;
            return;
        }
        int[] a = C2968s.m11525e().m13049a(f);
        this.f10813d = C2784w.m10741a().m11570b(this.f10810a, a[0]);
        this.f10814e = C2784w.m10741a().m11570b(this.f10810a, a[1]);
    }

    public void m12630a(int i, int i2) {
        m12588b(i, i2 - (this.f10818i instanceof Activity ? C2968s.m11525e().m13065d((Activity) this.f10818i)[0] : 0), this.f10815f, this.f10816g);
        this.f10817h.m13249l().m13278a(i, i2);
    }

    public void m12631a(ii iiVar, Map<String, String> map) {
        m12633c();
    }

    void m12632b() {
        if (this.f10817h.m13248k().f9329e) {
            this.f10815f = this.f10811b;
            this.f10816g = this.f10812c;
            return;
        }
        this.f10817h.measure(0, 0);
        this.f10815f = C2784w.m10741a().m11569b(this.f10818i, this.f10817h.getMeasuredWidth());
        this.f10816g = C2784w.m10741a().m11569b(this.f10818i, this.f10817h.getMeasuredHeight());
    }

    public void m12633c() {
        m12626g();
        m12629a();
        m12632b();
        m12635e();
        m12636f();
        m12627h();
        m12634d();
    }

    void m12634d() {
        if (C2972b.m11578a(2)) {
            C2972b.m11581c("Dispatching Ready Event.");
        }
        m12590c(this.f10817h.m13252o().f10081b);
    }

    void m12635e() {
        m12587a(this.f10811b, this.f10812c, this.f10813d, this.f10814e, this.f10821l, this.f10822m);
    }

    void m12636f() {
        this.f10817h.m12206b("onDeviceFeaturesReceived", m12628i().m12625a());
    }
}
