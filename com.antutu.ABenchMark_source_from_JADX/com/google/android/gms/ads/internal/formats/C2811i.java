package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.antutu.benchmark.modelreflact.TestResultModel;
import com.google.android.gms.ads.internal.C2900q;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.C3326k;
import com.google.android.gms.p146b.cb;
import com.google.android.gms.p146b.da;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.ii;
import com.google.android.gms.p146b.ij.C2813a;
import com.umeng.message.util.HttpRequest;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.ads.internal.formats.i */
public class C2811i implements C2810h {
    private final Object f9533a;
    private final C2900q f9534b;
    private final Context f9535c;
    private final JSONObject f9536d;
    private final da f9537e;
    private final C2804a f9538f;
    private final C3326k f9539g;
    private final VersionInfoParcel f9540h;
    private boolean f9541i;
    private ii f9542j;
    private String f9543k;
    private WeakReference<View> f9544l;

    /* renamed from: com.google.android.gms.ads.internal.formats.i.1 */
    class C28151 implements cb {
        final /* synthetic */ C2811i f9553a;

        /* renamed from: com.google.android.gms.ads.internal.formats.i.1.1 */
        class C28141 implements C2813a {
            final /* synthetic */ Map f9551a;
            final /* synthetic */ C28151 f9552b;

            C28141(C28151 c28151, Map map) {
                this.f9552b = c28151;
                this.f9551a = map;
            }

            public void m10896a(ii iiVar, boolean z) {
                this.f9552b.f9553a.f9543k = (String) this.f9551a.get(AgooConstants.MESSAGE_ID);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("messageType", "htmlLoaded");
                    jSONObject.put(AgooConstants.MESSAGE_ID, this.f9552b.f9553a.f9543k);
                    this.f9552b.f9553a.f9537e.m12206b("sendMessageToNativeJs", jSONObject);
                } catch (Throwable e) {
                    C2972b.m11580b("Unable to dispatch sendMessageToNativeJsevent", e);
                }
            }
        }

        C28151(C2811i c2811i) {
            this.f9553a = c2811i;
        }

        public void m10897a(ii iiVar, Map<String, String> map) {
            this.f9553a.f9542j.m13249l().m13285a(new C28141(this, map));
            String str = (String) map.get("overlayHtml");
            String str2 = (String) map.get("baseUrl");
            if (TextUtils.isEmpty(str2)) {
                this.f9553a.f9542j.loadData(str, "text/html", HttpRequest.f14548a);
            } else {
                this.f9553a.f9542j.loadDataWithBaseURL(str2, str, "text/html", HttpRequest.f14548a, null);
            }
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.formats.i.2 */
    class C28162 implements cb {
        final /* synthetic */ C2811i f9554a;

        C28162(C2811i c2811i) {
            this.f9554a = c2811i;
        }

        public void m10898a(ii iiVar, Map<String, String> map) {
            this.f9554a.f9542j.m13233b().setVisibility(0);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.formats.i.3 */
    class C28173 implements cb {
        final /* synthetic */ C2811i f9555a;

        C28173(C2811i c2811i) {
            this.f9555a = c2811i;
        }

        public void m10899a(ii iiVar, Map<String, String> map) {
            this.f9555a.f9542j.m13233b().setVisibility(8);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.formats.i.4 */
    class C28184 implements cb {
        final /* synthetic */ C2811i f9556a;

        C28184(C2811i c2811i) {
            this.f9556a = c2811i;
        }

        public void m10900a(ii iiVar, Map<String, String> map) {
            this.f9556a.f9542j.m13233b().setVisibility(8);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.formats.i.5 */
    class C28195 implements cb {
        final /* synthetic */ C2811i f9557a;

        C28195(C2811i c2811i) {
            this.f9557a = c2811i;
        }

        public void m10901a(ii iiVar, Map<String, String> map) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
                jSONObject.put(AgooConstants.MESSAGE_ID, this.f9557a.f9543k);
                this.f9557a.f9537e.m12206b("sendMessageToNativeJs", jSONObject);
            } catch (Throwable e) {
                C2972b.m11580b("Unable to dispatch sendMessageToNativeJs event", e);
            }
        }
    }

    public C2811i(Context context, C2900q c2900q, da daVar, C3326k c3326k, JSONObject jSONObject, C2804a c2804a, VersionInfoParcel versionInfoParcel) {
        this.f9533a = new Object();
        this.f9544l = null;
        this.f9535c = context;
        this.f9534b = c2900q;
        this.f9537e = daVar;
        this.f9539g = c3326k;
        this.f9536d = jSONObject;
        this.f9538f = c2804a;
        this.f9540h = versionInfoParcel;
    }

    public C2800b m10874a(OnClickListener onClickListener) {
        C2799a l = this.f9538f.m10807l();
        if (l == null) {
            return null;
        }
        C2800b c2800b = new C2800b(this.f9535c, l);
        c2800b.setLayoutParams(new LayoutParams(-1, -1));
        c2800b.m10784a().setOnClickListener(onClickListener);
        c2800b.m10784a().setContentDescription("Ad attribution icon");
        return c2800b;
    }

    public void m10875a() {
        C3512u.m14587b("recordImpression must be called on the main UI thread.");
        m10880a(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TestResultModel.TYPE_AD, this.f9536d);
            this.f9537e.m12204a("google.afma.nativeAds.handleImpressionPing", jSONObject);
        } catch (Throwable e) {
            C2972b.m11580b("Unable to create impression JSON.", e);
        }
        this.f9534b.m11273a((C2810h) this);
    }

    public void m10876a(MotionEvent motionEvent) {
        this.f9539g.m13587a(motionEvent);
    }

    public void m10877a(View view) {
    }

    public void m10878a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        C3512u.m14587b("performClick must be called on the main UI thread.");
        for (Entry entry : map.entrySet()) {
            if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                m10879a((String) entry.getKey(), jSONObject, jSONObject2, jSONObject3);
                return;
            }
        }
    }

    public void m10879a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        C3512u.m14587b("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("asset", str);
            jSONObject4.put("template", this.f9538f.m10805j());
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(TestResultModel.TYPE_AD, this.f9536d);
            jSONObject5.put("click", jSONObject4);
            jSONObject5.put("has_custom_click_handler", this.f9534b.m11283c(this.f9538f.m10806k()) != null);
            if (jSONObject != null) {
                jSONObject5.put("view_rectangles", jSONObject);
            }
            if (jSONObject2 != null) {
                jSONObject5.put("click_point", jSONObject2);
            }
            if (jSONObject3 != null) {
                jSONObject5.put("native_view_rectangle", jSONObject3);
            }
            this.f9537e.m12204a("google.afma.nativeAds.handleClickGmsg", jSONObject5);
        } catch (Throwable e) {
            C2972b.m11580b("Unable to create click JSON.", e);
        }
    }

    protected void m10880a(boolean z) {
        this.f9541i = z;
    }

    public void m10881b(View view) {
        synchronized (this.f9533a) {
            if (this.f9541i) {
            } else if (!view.isShown()) {
            } else if (view.getGlobalVisibleRect(new Rect(), null)) {
                m10875a();
            }
        }
    }

    public void m10882c(View view) {
        this.f9544l = new WeakReference(view);
    }

    public ii m10883d() {
        this.f9542j = m10886g();
        this.f9542j.m13233b().setVisibility(8);
        this.f9537e.m12202a("/loadHtml", new C28151(this));
        this.f9537e.m12202a("/showOverlay", new C28162(this));
        this.f9537e.m12202a("/hideOverlay", new C28173(this));
        this.f9542j.m13249l().m13287a("/hideOverlay", new C28184(this));
        this.f9542j.m13249l().m13287a("/sendMessageToSdk", new C28195(this));
        return this.f9542j;
    }

    public View m10884e() {
        return this.f9544l != null ? (View) this.f9544l.get() : null;
    }

    public Context m10885f() {
        return this.f9535c;
    }

    ii m10886g() {
        return C2968s.m11526f().m13299a(this.f9535c, AdSizeParcel.m10500a(this.f9535c), false, false, this.f9539g, this.f9540h);
    }
}
