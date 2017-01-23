package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.antutu.utils.widget.SystemBarTintManager;
import com.google.analytics.tracking.android.ModelFields;
import com.google.android.gms.common.internal.C3473d;
import com.google.android.gms.p146b.aw;
import com.google.android.gms.p146b.az;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.ii;
import com.umeng.message.proguard.C4233j;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

@gb
/* renamed from: com.google.android.gms.ads.internal.overlay.k */
public class C2869k extends FrameLayout implements C2867h {
    private final ii f9714a;
    private final FrameLayout f9715b;
    private final C2877u f9716c;
    private C2854i f9717d;
    private boolean f9718e;
    private boolean f9719f;
    private TextView f9720g;
    private long f9721h;
    private long f9722i;
    private String f9723j;
    private String f9724k;

    public C2869k(Context context, ii iiVar, int i, az azVar, aw awVar) {
        super(context);
        this.f9714a = iiVar;
        this.f9715b = new FrameLayout(context);
        addView(this.f9715b, new LayoutParams(-1, -1));
        C3473d.m14338a(iiVar.m13245h());
        this.f9717d = iiVar.m13245h().f9478b.m11134a(context, iiVar, i, azVar, awVar);
        if (this.f9717d != null) {
            this.f9715b.addView(this.f9717d, new LayoutParams(-1, -1, 17));
        }
        this.f9720g = new TextView(context);
        this.f9720g.setBackgroundColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        m11138o();
        this.f9716c = new C2877u(this);
        this.f9716c.m11189b();
        if (this.f9717d != null) {
            this.f9717d.m11051a((C2867h) this);
        }
        if (this.f9717d == null) {
            m11149a("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void m11136a(ii iiVar) {
        Map hashMap = new HashMap();
        hashMap.put(ModelFields.EVENT, "no_video_view");
        iiVar.m13230a("onVideoEvent", hashMap);
    }

    private void m11137a(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put(ModelFields.EVENT, str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.f9714a.m13230a("onVideoEvent", hashMap);
    }

    private void m11138o() {
        if (!m11140q()) {
            this.f9715b.addView(this.f9720g, new LayoutParams(-1, -1));
            this.f9715b.bringChildToFront(this.f9720g);
        }
    }

    private void m11139p() {
        if (m11140q()) {
            this.f9715b.removeView(this.f9720g);
        }
    }

    private boolean m11140q() {
        return this.f9720g.getParent() != null;
    }

    private void m11141r() {
        if (this.f9714a.m13243f() != null && !this.f9718e) {
            this.f9719f = (this.f9714a.m13243f().getWindow().getAttributes().flags & SpdyProtocol.SLIGHTSSLV2) != 0;
            if (!this.f9719f) {
                this.f9714a.m13243f().getWindow().addFlags(SpdyProtocol.SLIGHTSSLV2);
                this.f9718e = true;
            }
        }
    }

    private void m11142s() {
        if (this.f9714a.m13243f() != null && this.f9718e && !this.f9719f) {
            this.f9714a.m13243f().getWindow().clearFlags(SpdyProtocol.SLIGHTSSLV2);
            this.f9718e = false;
        }
    }

    public void m11143a() {
    }

    public void m11144a(float f) {
        if (this.f9717d != null) {
            this.f9717d.m11049a(f);
        }
    }

    public void m11145a(int i) {
        if (this.f9717d != null) {
            this.f9717d.m11050a(i);
        }
    }

    public void m11146a(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3 + 2, i4 + 2);
            layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
            this.f9715b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void m11147a(MotionEvent motionEvent) {
        if (this.f9717d != null) {
            this.f9717d.dispatchTouchEvent(motionEvent);
        }
    }

    public void m11148a(String str) {
        this.f9724k = str;
    }

    public void m11149a(String str, String str2) {
        m11137a(C4233j.f14375B, "what", str, "extra", str2);
    }

    public void m11150b() {
        if (this.f9717d != null && this.f9722i == 0) {
            float duration = ((float) this.f9717d.getDuration()) / 1000.0f;
            int videoWidth = this.f9717d.getVideoWidth();
            int videoHeight = this.f9717d.getVideoHeight();
            m11137a("canplaythrough", "duration", String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    public void m11151c() {
        m11141r();
    }

    public void m11152d() {
        m11137a("pause", new String[0]);
        m11142s();
    }

    public void m11153e() {
        m11137a("ended", new String[0]);
        m11142s();
    }

    public void m11154f() {
        m11138o();
        this.f9722i = this.f9721h;
    }

    public void m11155g() {
        if (this.f9717d != null) {
            if (TextUtils.isEmpty(this.f9724k)) {
                m11137a("no_src", new String[0]);
                return;
            }
            this.f9717d.setMimeType(this.f9723j);
            this.f9717d.setVideoPath(this.f9724k);
        }
    }

    public void m11156h() {
        if (this.f9717d != null) {
            this.f9717d.m11054d();
        }
    }

    public void m11157i() {
        if (this.f9717d != null) {
            this.f9717d.m11053c();
        }
    }

    public void m11158j() {
        if (this.f9717d != null) {
            this.f9717d.m11055e();
        }
    }

    public void m11159k() {
        if (this.f9717d != null) {
            this.f9717d.m11056f();
        }
    }

    public void m11160l() {
        if (this.f9717d != null) {
            View textView = new TextView(this.f9717d.getContext());
            textView.setText("AdMob - " + this.f9717d.m11048a());
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.f9715b.addView(textView, new LayoutParams(-2, -2, 17));
            this.f9715b.bringChildToFront(textView);
        }
    }

    public void m11161m() {
        this.f9716c.m11188a();
        if (this.f9717d != null) {
            this.f9717d.m11052b();
        }
        m11142s();
    }

    void m11162n() {
        if (this.f9717d != null) {
            long currentPosition = (long) this.f9717d.getCurrentPosition();
            if (this.f9721h != currentPosition && currentPosition > 0) {
                m11139p();
                float f = ((float) currentPosition) / 1000.0f;
                m11137a("timeupdate", C4233j.f14377D, String.valueOf(f));
                this.f9721h = currentPosition;
            }
        }
    }

    public void setMimeType(String str) {
        this.f9723j = str;
    }
}
