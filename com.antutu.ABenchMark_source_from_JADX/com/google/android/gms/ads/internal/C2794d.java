package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.C2798f.C2797b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.az;
import com.google.android.gms.p146b.ba;
import com.google.android.gms.p146b.bc;
import com.google.android.gms.p146b.bd;
import com.google.android.gms.p146b.cb;
import com.google.android.gms.p146b.de;
import com.google.android.gms.p146b.du;
import com.google.android.gms.p146b.er;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.gx;
import com.google.android.gms.p146b.gx.C3232a;
import com.google.android.gms.p146b.hj;
import com.google.android.gms.p146b.ii;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.ads.internal.d */
public abstract class C2794d extends C2737c implements C2793h, er {

    /* renamed from: com.google.android.gms.ads.internal.d.1 */
    class C27881 implements cb {
        final /* synthetic */ C2794d f9467a;

        C27881(C2794d c2794d) {
            this.f9467a = c2794d;
        }

        public void m10755a(ii iiVar, Map<String, String> map) {
            if (this.f9467a.f.f10063j != null) {
                this.f9467a.h.m13875a(this.f9467a.f.f10062i, this.f9467a.f.f10063j, iiVar.m13233b(), (de) iiVar);
            } else {
                C2972b.m11583d("Request to enable ActiveView before adState is available.");
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.d.2 */
    class C27892 implements Runnable {
        final /* synthetic */ C3232a f9468a;
        final /* synthetic */ C2794d f9469b;

        C27892(C2794d c2794d, C3232a c3232a) {
            this.f9469b = c2794d;
            this.f9468a = c3232a;
        }

        public void run() {
            this.f9469b.m10484b(new gx(this.f9468a, null, null, null, null, null, null));
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.d.3 */
    class C27923 implements Runnable {
        final /* synthetic */ C3232a f9474a;
        final /* synthetic */ az f9475b;
        final /* synthetic */ C2794d f9476c;

        /* renamed from: com.google.android.gms.ads.internal.d.3.1 */
        class C27901 implements OnTouchListener {
            final /* synthetic */ C2798f f9470a;
            final /* synthetic */ C27923 f9471b;

            C27901(C27923 c27923, C2798f c2798f) {
                this.f9471b = c27923;
                this.f9470a = c2798f;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                this.f9470a.m10774a();
                return false;
            }
        }

        /* renamed from: com.google.android.gms.ads.internal.d.3.2 */
        class C27912 implements OnClickListener {
            final /* synthetic */ C2798f f9472a;
            final /* synthetic */ C27923 f9473b;

            C27912(C27923 c27923, C2798f c2798f) {
                this.f9473b = c27923;
                this.f9472a = c2798f;
            }

            public void onClick(View view) {
                this.f9472a.m10774a();
            }
        }

        C27923(C2794d c2794d, C3232a c3232a, az azVar) {
            this.f9476c = c2794d;
            this.f9474a = c3232a;
            this.f9475b = azVar;
        }

        public void run() {
            if (this.f9474a.f11167b.f9903s && this.f9476c.f.f10077x != null) {
                String str = null;
                if (this.f9474a.f11167b.f9886b != null) {
                    str = C2968s.m11525e().m13027a(this.f9474a.f11167b.f9886b);
                }
                bc baVar = new ba(this.f9476c, str, this.f9474a.f11167b.f9887c);
                this.f9476c.f.f10043D = 1;
                try {
                    this.f9476c.d = false;
                    this.f9476c.f.f10077x.m11877a(baVar);
                    return;
                } catch (Throwable e) {
                    C2972b.m11584d("Could not call the onCustomRenderedAdLoadedListener.", e);
                    this.f9476c.d = true;
                }
            }
            C2798f c2798f = new C2798f();
            ii a = this.f9476c.m10763a(this.f9474a, c2798f);
            c2798f.m10775a(new C2797b(this.f9474a, a));
            a.setOnTouchListener(new C27901(this, c2798f));
            a.setOnClickListener(new C27912(this, c2798f));
            this.f9476c.f.f10043D = 0;
            this.f9476c.f.f10061h = C2968s.m11524d().m12741a(this.f9476c.f.f10056c, this.f9476c, this.f9474a, this.f9476c.f.f10057d, a, this.f9476c.j, this.f9476c, this.f9475b);
        }
    }

    public C2794d(Context context, AdSizeParcel adSizeParcel, String str, du duVar, VersionInfoParcel versionInfoParcel, C2795e c2795e) {
        super(context, adSizeParcel, str, duVar, versionInfoParcel, c2795e);
    }

    public void m10761A() {
        m10497y();
        m10455h();
    }

    public void m10762B() {
        m10460n();
    }

    protected ii m10763a(C3232a c3232a, C2798f c2798f) {
        de deVar;
        View nextView = this.f.f10059f.getNextView();
        ii iiVar;
        if (nextView instanceof ii) {
            C2972b.m11576a("Reusing webview...");
            iiVar = (ii) nextView;
            iiVar.m13225a(this.f.f10056c, this.f.f10062i, this.a);
            deVar = iiVar;
        } else {
            if (nextView != null) {
                this.f.f10059f.removeView(nextView);
            }
            iiVar = C2968s.m11526f().m13300a(this.f.f10056c, this.f.f10062i, false, false, this.f.f10057d, this.f.f10058e, this.a, this.i);
            if (this.f.f10062i.f9332h == null) {
                m10425a(iiVar.m13233b());
            }
            Object obj = iiVar;
        }
        deVar.m13249l().m13281a(this, this, this, this, false, this, null, c2798f, this);
        m10766a(deVar);
        deVar.m13236b(c3232a.f11166a.f9873w);
        return deVar;
    }

    public void m10764a(int i, int i2, int i3, int i4) {
        m10462p();
    }

    public void m10765a(bd bdVar) {
        C3512u.m14587b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f.f10077x = bdVar;
    }

    protected void m10766a(de deVar) {
        deVar.m12202a("/trackActiveViewUnit", new C27881(this));
    }

    protected void m10767a(C3232a c3232a, az azVar) {
        if (c3232a.f11170e != -2) {
            hj.f11297a.post(new C27892(this, c3232a));
            return;
        }
        if (c3232a.f11169d != null) {
            this.f.f10062i = c3232a.f11169d;
        }
        if (!c3232a.f11167b.f9892h || c3232a.f11167b.f9879C) {
            hj.f11297a.post(new C27923(this, c3232a, azVar));
            return;
        }
        this.f.f10043D = 0;
        this.f.f10061h = C2968s.m11524d().m12741a(this.f.f10056c, this, c3232a, this.f.f10057d, null, this.j, this, azVar);
    }

    protected boolean m10768a(gx gxVar, gx gxVar2) {
        if (this.f.m11553e() && this.f.f10059f != null) {
            this.f.f10059f.m11542a().m13126a(gxVar2.f11174A);
        }
        return super.m10483a(gxVar, gxVar2);
    }

    public void m10769b(View view) {
        this.f.f10042C = view;
        m10484b(new gx(this.f.f10064k, null, null, null, null, null, null));
    }

    public void m10770z() {
        m10474a();
    }
}
