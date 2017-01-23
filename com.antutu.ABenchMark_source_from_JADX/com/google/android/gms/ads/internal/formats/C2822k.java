package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.bh.C2766a;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.hj;
import com.google.android.gms.p146b.id;
import com.google.android.gms.p146b.ii;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.ads.internal.formats.k */
public class C2822k extends C2766a implements OnClickListener, OnTouchListener, OnGlobalLayoutListener, OnScrollChangedListener {
    boolean f9560a;
    int f9561b;
    int f9562c;
    private final Object f9563d;
    private final FrameLayout f9564e;
    private FrameLayout f9565f;
    private Map<String, WeakReference<View>> f9566g;
    private C2800b f9567h;
    private C2810h f9568i;

    /* renamed from: com.google.android.gms.ads.internal.formats.k.1 */
    class C28211 implements Runnable {
        final /* synthetic */ C2811i f9558a;
        final /* synthetic */ C2822k f9559b;

        C28211(C2822k c2822k, C2811i c2811i) {
            this.f9559b = c2822k;
            this.f9558a = c2811i;
        }

        public void run() {
            ii d = this.f9558a.m10883d();
            if (d != null) {
                this.f9559b.f9565f.addView(d.m13233b());
            }
        }
    }

    public C2822k(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f9563d = new Object();
        this.f9566g = new HashMap();
        this.f9560a = false;
        this.f9564e = frameLayout;
        this.f9565f = frameLayout2;
        id.m13202a(this.f9564e, (OnGlobalLayoutListener) this);
        id.m13203a(this.f9564e, (OnScrollChangedListener) this);
        this.f9564e.setOnTouchListener(this);
    }

    int m10906a(int i) {
        return C2784w.m10741a().m11569b(this.f9568i.m10869f(), i);
    }

    Point m10907a(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.f9564e.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
    }

    public C2687a m10908a(String str) {
        C2687a a;
        synchronized (this.f9563d) {
            Object obj;
            WeakReference weakReference = (WeakReference) this.f9566g.get(str);
            if (weakReference == null) {
                obj = null;
            } else {
                View view = (View) weakReference.get();
            }
            a = C2690b.m10262a(obj);
        }
        return a;
    }

    C2800b m10909a(C2811i c2811i) {
        return c2811i.m10874a((OnClickListener) this);
    }

    public void m10910a() {
        this.f9565f.removeAllViews();
        this.f9565f = null;
        this.f9566g = null;
        this.f9567h = null;
        this.f9568i = null;
    }

    void m10911a(View view) {
        if (this.f9568i != null) {
            C2810h c = this.f9568i instanceof C2812g ? ((C2812g) this.f9568i).m10893c() : this.f9568i;
            if (c != null) {
                c.m10867c(view);
            }
        }
    }

    public void m10912a(C2687a c2687a) {
        synchronized (this.f9563d) {
            this.f9560a = true;
            m10911a(null);
            Object a = C2690b.m10263a(c2687a);
            if (a instanceof C2811i) {
                C2811i c2811i = (C2811i) a;
                if ((this.f9568i instanceof C2812g) && ((C2812g) this.f9568i).m10892b()) {
                    ((C2812g) this.f9568i).m10891a((C2810h) c2811i);
                } else {
                    this.f9568i = c2811i;
                    if (this.f9568i instanceof C2812g) {
                        ((C2812g) this.f9568i).m10891a(null);
                    }
                }
                this.f9565f.removeAllViews();
                this.f9567h = m10909a(c2811i);
                if (this.f9567h != null) {
                    this.f9566g.put("1007", new WeakReference(this.f9567h.m10784a()));
                    this.f9565f.addView(this.f9567h);
                }
                hj.f11297a.post(new C28211(this, c2811i));
                c2811i.m10877a(this.f9564e);
                m10911a(this.f9564e);
                return;
            }
            C2972b.m11583d("Not an instance of native engine. This is most likely a transient error");
        }
    }

    public void m10913a(String str, C2687a c2687a) {
        View view = (View) C2690b.m10263a(c2687a);
        synchronized (this.f9563d) {
            if (view == null) {
                this.f9566g.remove(str);
            } else {
                this.f9566g.put(str, new WeakReference(view));
                view.setOnTouchListener(this);
                view.setOnClickListener(this);
            }
        }
    }

    int m10914b() {
        return this.f9564e.getMeasuredWidth();
    }

    Point m10915b(View view) {
        if (this.f9567h == null || !this.f9567h.m10784a().equals(view)) {
            Point point = new Point();
            view.getGlobalVisibleRect(new Rect(), point);
            return point;
        }
        Point point2 = new Point();
        this.f9564e.getGlobalVisibleRect(new Rect(), point2);
        Point point3 = new Point();
        view.getGlobalVisibleRect(new Rect(), point3);
        return new Point(point3.x - point2.x, point3.y - point2.y);
    }

    int m10916c() {
        return this.f9564e.getMeasuredHeight();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r10) {
        /*
        r9 = this;
        r6 = r9.f9563d;
        monitor-enter(r6);
        r0 = r9.f9568i;	 Catch:{ all -> 0x0091 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r6);	 Catch:{ all -> 0x0091 }
    L_0x0008:
        return;
    L_0x0009:
        r3 = new org.json.JSONObject;	 Catch:{ all -> 0x0091 }
        r3.<init>();	 Catch:{ all -> 0x0091 }
        r0 = r9.f9566g;	 Catch:{ all -> 0x0091 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0091 }
        r2 = r0.iterator();	 Catch:{ all -> 0x0091 }
    L_0x0018:
        r0 = r2.hasNext();	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0094;
    L_0x001e:
        r0 = r2.next();	 Catch:{ all -> 0x0091 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0091 }
        r1 = r0.getValue();	 Catch:{ all -> 0x0091 }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x0091 }
        r1 = r1.get();	 Catch:{ all -> 0x0091 }
        r1 = (android.view.View) r1;	 Catch:{ all -> 0x0091 }
        r4 = r9.m10915b(r1);	 Catch:{ all -> 0x0091 }
        r5 = new org.json.JSONObject;	 Catch:{ all -> 0x0091 }
        r5.<init>();	 Catch:{ all -> 0x0091 }
        r7 = "width";
        r8 = r1.getWidth();	 Catch:{ JSONException -> 0x0073 }
        r8 = r9.m10906a(r8);	 Catch:{ JSONException -> 0x0073 }
        r5.put(r7, r8);	 Catch:{ JSONException -> 0x0073 }
        r7 = "height";
        r1 = r1.getHeight();	 Catch:{ JSONException -> 0x0073 }
        r1 = r9.m10906a(r1);	 Catch:{ JSONException -> 0x0073 }
        r5.put(r7, r1);	 Catch:{ JSONException -> 0x0073 }
        r1 = "x";
        r7 = r4.x;	 Catch:{ JSONException -> 0x0073 }
        r7 = r9.m10906a(r7);	 Catch:{ JSONException -> 0x0073 }
        r5.put(r1, r7);	 Catch:{ JSONException -> 0x0073 }
        r1 = "y";
        r4 = r4.y;	 Catch:{ JSONException -> 0x0073 }
        r4 = r9.m10906a(r4);	 Catch:{ JSONException -> 0x0073 }
        r5.put(r1, r4);	 Catch:{ JSONException -> 0x0073 }
        r1 = r0.getKey();	 Catch:{ JSONException -> 0x0073 }
        r1 = (java.lang.String) r1;	 Catch:{ JSONException -> 0x0073 }
        r3.put(r1, r5);	 Catch:{ JSONException -> 0x0073 }
        goto L_0x0018;
    L_0x0073:
        r1 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0091 }
        r1.<init>();	 Catch:{ all -> 0x0091 }
        r4 = "Unable to get view rectangle for view ";
        r1 = r1.append(r4);	 Catch:{ all -> 0x0091 }
        r0 = r0.getKey();	 Catch:{ all -> 0x0091 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0091 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0091 }
        r0 = r0.toString();	 Catch:{ all -> 0x0091 }
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r0);	 Catch:{ all -> 0x0091 }
        goto L_0x0018;
    L_0x0091:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0091 }
        throw r0;
    L_0x0094:
        r4 = new org.json.JSONObject;	 Catch:{ all -> 0x0091 }
        r4.<init>();	 Catch:{ all -> 0x0091 }
        r0 = "x";
        r1 = r9.f9561b;	 Catch:{ JSONException -> 0x00e8 }
        r1 = r9.m10906a(r1);	 Catch:{ JSONException -> 0x00e8 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x00e8 }
        r0 = "y";
        r1 = r9.f9562c;	 Catch:{ JSONException -> 0x00e8 }
        r1 = r9.m10906a(r1);	 Catch:{ JSONException -> 0x00e8 }
        r4.put(r0, r1);	 Catch:{ JSONException -> 0x00e8 }
    L_0x00af:
        r5 = new org.json.JSONObject;	 Catch:{ all -> 0x0091 }
        r5.<init>();	 Catch:{ all -> 0x0091 }
        r0 = "width";
        r1 = r9.m10914b();	 Catch:{ JSONException -> 0x00ef }
        r1 = r9.m10906a(r1);	 Catch:{ JSONException -> 0x00ef }
        r5.put(r0, r1);	 Catch:{ JSONException -> 0x00ef }
        r0 = "height";
        r1 = r9.m10916c();	 Catch:{ JSONException -> 0x00ef }
        r1 = r9.m10906a(r1);	 Catch:{ JSONException -> 0x00ef }
        r5.put(r0, r1);	 Catch:{ JSONException -> 0x00ef }
    L_0x00ce:
        r0 = r9.f9567h;	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x00f6;
    L_0x00d2:
        r0 = r9.f9567h;	 Catch:{ all -> 0x0091 }
        r0 = r0.m10784a();	 Catch:{ all -> 0x0091 }
        r0 = r0.equals(r10);	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x00f6;
    L_0x00de:
        r0 = r9.f9568i;	 Catch:{ all -> 0x0091 }
        r1 = "1007";
        r0.m10865a(r1, r3, r4, r5);	 Catch:{ all -> 0x0091 }
    L_0x00e5:
        monitor-exit(r6);	 Catch:{ all -> 0x0091 }
        goto L_0x0008;
    L_0x00e8:
        r0 = move-exception;
        r0 = "Unable to get click location";
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r0);	 Catch:{ all -> 0x0091 }
        goto L_0x00af;
    L_0x00ef:
        r0 = move-exception;
        r0 = "Unable to get native ad view bounding box";
        com.google.android.gms.ads.internal.util.client.C2972b.m11583d(r0);	 Catch:{ all -> 0x0091 }
        goto L_0x00ce;
    L_0x00f6:
        r0 = r9.f9568i;	 Catch:{ all -> 0x0091 }
        r2 = r9.f9566g;	 Catch:{ all -> 0x0091 }
        r1 = r10;
        r0.m10864a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0091 }
        goto L_0x00e5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.formats.k.onClick(android.view.View):void");
    }

    public void onGlobalLayout() {
        synchronized (this.f9563d) {
            if (this.f9560a) {
                int b = m10914b();
                int c = m10916c();
                if (!(b == 0 || c == 0)) {
                    this.f9565f.setLayoutParams(new LayoutParams(b, c));
                    this.f9560a = false;
                }
            }
            if (this.f9568i != null) {
                this.f9568i.m10866b(this.f9564e);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.f9563d) {
            if (this.f9568i != null) {
                this.f9568i.m10866b(this.f9564e);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.f9563d) {
            if (this.f9568i == null) {
            } else {
                Point a = m10907a(motionEvent);
                this.f9561b = a.x;
                this.f9562c = a.y;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setLocation((float) a.x, (float) a.y);
                this.f9568i.m10863a(obtain);
                obtain.recycle();
            }
        }
        return false;
    }
}
