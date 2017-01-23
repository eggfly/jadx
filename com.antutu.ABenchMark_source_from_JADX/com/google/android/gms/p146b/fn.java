package com.google.android.gms.p146b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.ij.C2813a;
import com.umeng.message.util.HttpRequest;

@gb
/* renamed from: com.google.android.gms.b.fn */
public class fn implements Runnable {
    protected final ii f10926a;
    protected boolean f10927b;
    protected boolean f10928c;
    private final Handler f10929d;
    private final long f10930e;
    private long f10931f;
    private C2813a f10932g;
    private final int f10933h;
    private final int f10934i;

    /* renamed from: com.google.android.gms.b.fn.a */
    protected final class C3203a extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ fn f10923a;
        private final WebView f10924b;
        private Bitmap f10925c;

        public C3203a(fn fnVar, WebView webView) {
            this.f10923a = fnVar;
            this.f10924b = webView;
        }

        protected synchronized Boolean m12718a(Void... voidArr) {
            Boolean valueOf;
            int width = this.f10925c.getWidth();
            int height = this.f10925c.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.f10925c.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void m12719a(Boolean bool) {
            fn.m12722c(this.f10923a);
            if (bool.booleanValue() || this.f10923a.m12731c() || this.f10923a.f10931f <= 0) {
                this.f10923a.f10928c = bool.booleanValue();
                this.f10923a.f10932g.m10895a(this.f10923a.f10926a, true);
            } else if (this.f10923a.f10931f > 0) {
                if (C2972b.m11578a(2)) {
                    C2972b.m11576a("Ad not detected, scheduling another run.");
                }
                this.f10923a.f10929d.postDelayed(this.f10923a, this.f10923a.f10930e);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m12718a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m12719a((Boolean) obj);
        }

        protected synchronized void onPreExecute() {
            this.f10925c = Bitmap.createBitmap(this.f10923a.f10934i, this.f10923a.f10933h, Config.ARGB_8888);
            this.f10924b.setVisibility(0);
            this.f10924b.measure(MeasureSpec.makeMeasureSpec(this.f10923a.f10934i, 0), MeasureSpec.makeMeasureSpec(this.f10923a.f10933h, 0));
            this.f10924b.layout(0, 0, this.f10923a.f10934i, this.f10923a.f10933h);
            this.f10924b.draw(new Canvas(this.f10925c));
            this.f10924b.invalidate();
        }
    }

    public fn(C2813a c2813a, ii iiVar, int i, int i2) {
        this(c2813a, iiVar, i, i2, 200, 50);
    }

    public fn(C2813a c2813a, ii iiVar, int i, int i2, long j, long j2) {
        this.f10930e = j;
        this.f10931f = j2;
        this.f10929d = new Handler(Looper.getMainLooper());
        this.f10926a = iiVar;
        this.f10932g = c2813a;
        this.f10927b = false;
        this.f10928c = false;
        this.f10933h = i2;
        this.f10934i = i;
    }

    static /* synthetic */ long m12722c(fn fnVar) {
        long j = fnVar.f10931f - 1;
        fnVar.f10931f = j;
        return j;
    }

    public void m12727a() {
        this.f10929d.postDelayed(this, this.f10930e);
    }

    public void m12728a(AdResponseParcel adResponseParcel) {
        m12729a(adResponseParcel, new ir(this, this.f10926a, adResponseParcel.f9901q));
    }

    public void m12729a(AdResponseParcel adResponseParcel, ir irVar) {
        this.f10926a.setWebViewClient(irVar);
        this.f10926a.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.f9886b) ? null : C2968s.m11525e().m13027a(adResponseParcel.f9886b), adResponseParcel.f9887c, "text/html", HttpRequest.f14548a, null);
    }

    public synchronized void m12730b() {
        this.f10927b = true;
    }

    public synchronized boolean m12731c() {
        return this.f10927b;
    }

    public boolean m12732d() {
        return this.f10928c;
    }

    public void run() {
        if (this.f10926a == null || m12731c()) {
            this.f10932g.m10895a(this.f10926a, true);
        } else {
            new C3203a(this, this.f10926a.m13222a()).execute(new Void[0]);
        }
    }
}
