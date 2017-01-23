package com.facebook.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.NativeAdView.Type;
import com.facebook.ads.internal.C2253a;
import com.facebook.ads.internal.C2343b;
import com.facebook.ads.internal.C2353c;
import com.facebook.ads.internal.C2409e;
import com.facebook.ads.internal.C2472h;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.C2268b;
import com.facebook.ads.internal.adapters.C2307r;
import com.facebook.ads.internal.adapters.C2310e;
import com.facebook.ads.internal.adapters.C2310e.C2266a;
import com.facebook.ads.internal.adapters.C2334q;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.p121f.C2264p;
import com.facebook.ads.internal.p121f.C2469q;
import com.facebook.ads.internal.p121f.p132b.C2430c;
import com.facebook.ads.internal.p121f.p133c.C2449a;
import com.facebook.ads.internal.p122b.C2261a;
import com.facebook.ads.internal.p122b.C2339b;
import com.facebook.ads.internal.p125c.C2348d;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.C2489b;
import com.facebook.ads.internal.util.C2489b.C2488b;
import com.facebook.ads.internal.util.C2490c;
import com.facebook.ads.internal.util.C2502k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONObject;

public class NativeAd implements Ad {
    private static final C2353c f7833a;
    private static final String f7834c;
    private static WeakHashMap<View, WeakReference<NativeAd>> f7835d;
    private long f7836A;
    private String f7837B;
    private boolean f7838C;
    private final long f7839b;
    private final Context f7840e;
    private final String f7841f;
    private final String f7842g;
    private final C2339b f7843h;
    private AdListener f7844i;
    private ImpressionListener f7845j;
    private DisplayAdController f7846k;
    private volatile boolean f7847l;
    private C2307r f7848m;
    private C2348d f7849n;
    private View f7850o;
    private List<View> f7851p;
    private OnTouchListener f7852q;
    private C2310e f7853r;
    private C2334q f7854s;
    private C2272a f7855t;
    private C2273b f7856u;
    private C2469q f7857v;
    private Type f7858w;
    private boolean f7859x;
    private boolean f7860y;
    private boolean f7861z;

    /* renamed from: com.facebook.ads.NativeAd.1 */
    class C22631 extends C2253a {
        final /* synthetic */ EnumSet f7805a;
        final /* synthetic */ NativeAd f7806b;

        /* renamed from: com.facebook.ads.NativeAd.1.1 */
        class C22621 implements C2261a {
            final /* synthetic */ C2307r f7803a;
            final /* synthetic */ C22631 f7804b;

            C22621(C22631 c22631, C2307r c2307r) {
                this.f7804b = c22631;
                this.f7803a = c2307r;
            }

            public void m8564a() {
                this.f7804b.f7806b.f7848m = this.f7803a;
                this.f7804b.f7806b.m8608l();
                this.f7804b.f7806b.m8610m();
                if (this.f7804b.f7806b.f7844i != null) {
                    this.f7804b.f7806b.f7844i.onAdLoaded(this.f7804b.f7806b);
                }
            }
        }

        C22631(NativeAd nativeAd, EnumSet enumSet) {
            this.f7806b = nativeAd;
            this.f7805a = enumSet;
        }

        public void m8565a() {
            if (this.f7806b.f7846k != null) {
                this.f7806b.f7846k.m8699c();
            }
        }

        public void m8566a(C2307r c2307r) {
            C2490c.m9456a(C2489b.m9452a(C2488b.LOADING_AD, AdPlacementType.NATIVE, System.currentTimeMillis() - this.f7806b.f7836A, null));
            if (c2307r != null) {
                if (this.f7805a.contains(MediaCacheFlag.ICON) && c2307r.m8740k() != null) {
                    this.f7806b.f7843h.m9022a(c2307r.m8740k().getUrl());
                }
                if (this.f7805a.contains(MediaCacheFlag.IMAGE)) {
                    if (c2307r.m8741l() != null) {
                        this.f7806b.f7843h.m9022a(c2307r.m8741l().getUrl());
                    }
                    if (c2307r.m8724B() != null) {
                        for (NativeAd nativeAd : c2307r.m8724B()) {
                            if (nativeAd.getAdCoverImage() != null) {
                                this.f7806b.f7843h.m9022a(nativeAd.getAdCoverImage().getUrl());
                            }
                        }
                    }
                }
                if (this.f7805a.contains(MediaCacheFlag.VIDEO) && !TextUtils.isEmpty(c2307r.m8752w()) && C2472h.m9402d(this.f7806b.f7840e)) {
                    this.f7806b.f7843h.m9023b(c2307r.m8752w());
                }
                this.f7806b.f7843h.m9021a(new C22621(this, c2307r));
            }
        }

        public void m8567a(C2343b c2343b) {
            if (this.f7806b.f7844i != null) {
                this.f7806b.f7844i.onError(this.f7806b, c2343b.m9036b());
            }
        }

        public void m8568b() {
            if (this.f7806b.f7844i != null) {
                this.f7806b.f7844i.onAdClicked(this.f7806b);
            }
        }

        public void m8569c() {
            throw new IllegalStateException("Native ads manager their own impressions.");
        }
    }

    /* renamed from: com.facebook.ads.NativeAd.2 */
    class C22652 implements C2264p {
        final /* synthetic */ NativeAd f7807a;

        C22652(NativeAd nativeAd) {
            this.f7807a = nativeAd;
        }

        public void m8571a(int i) {
            if (this.f7807a.f7848m != null) {
                this.f7807a.f7848m.m8726a(i);
            }
        }
    }

    /* renamed from: com.facebook.ads.NativeAd.3 */
    class C22673 extends C2266a {
        final /* synthetic */ NativeAd f7808a;

        C22673(NativeAd nativeAd) {
            this.f7808a = nativeAd;
        }

        public void m8574a() {
            this.f7808a.f7854s.m9007a(this.f7808a.f7850o);
            this.f7808a.f7854s.m9008a(this.f7808a.f7858w);
            this.f7808a.f7854s.m9010a(this.f7808a.f7859x);
            this.f7808a.f7854s.m9012b(this.f7808a.f7860y);
            this.f7808a.f7854s.m9013c(this.f7808a.f7861z);
            this.f7808a.f7854s.m8719a();
            this.f7808a.f7855t.m8586a();
        }
    }

    /* renamed from: com.facebook.ads.NativeAd.4 */
    class C22694 extends C2268b {
        final /* synthetic */ NativeAd f7809a;

        C22694(NativeAd nativeAd) {
            this.f7809a = nativeAd;
        }

        public boolean m8580a() {
            return true;
        }
    }

    /* renamed from: com.facebook.ads.NativeAd.c */
    private class C2270c extends C2268b {
        final /* synthetic */ NativeAd f7810b;

        private C2270c(NativeAd nativeAd) {
            this.f7810b = nativeAd;
        }

        public boolean m8581a() {
            return false;
        }

        public void m8582d() {
            if (this.f7810b.f7845j != null) {
                this.f7810b.f7845j.onLoggingImpression(this.f7810b);
            }
            if ((this.f7810b.f7844i instanceof ImpressionListener) && this.f7810b.f7844i != this.f7810b.f7845j) {
                ((ImpressionListener) this.f7810b.f7844i).onLoggingImpression(this.f7810b);
            }
        }

        public void m8583e() {
        }
    }

    /* renamed from: com.facebook.ads.NativeAd.5 */
    class C22715 extends C2270c {
        final /* synthetic */ NativeAd f7811a;

        C22715(NativeAd nativeAd) {
            this.f7811a = nativeAd;
            super(null);
        }

        public boolean m8584b() {
            return true;
        }

        public String m8585c() {
            return this.f7811a.f7837B;
        }
    }

    public static class Image {
        private final String f7812a;
        private final int f7813b;
        private final int f7814c;

        public Image(String str, int i, int i2) {
            this.f7812a = str;
            this.f7813b = i;
            this.f7814c = i2;
        }

        public static Image fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("url");
            return optString != null ? new Image(optString, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)) : null;
        }

        public int getHeight() {
            return this.f7814c;
        }

        public String getUrl() {
            return this.f7812a;
        }

        public int getWidth() {
            return this.f7813b;
        }
    }

    public enum MediaCacheFlag {
        NONE(0),
        ICON(1),
        IMAGE(2),
        VIDEO(3);
        
        public static final EnumSet<MediaCacheFlag> ALL;
        private final long f7816a;

        static {
            ALL = EnumSet.allOf(MediaCacheFlag.class);
        }

        private MediaCacheFlag(long j) {
            this.f7816a = j;
        }

        public long getCacheFlagValue() {
            return this.f7816a;
        }
    }

    public static class Rating {
        private final double f7817a;
        private final double f7818b;

        public Rating(double d, double d2) {
            this.f7817a = d;
            this.f7818b = d2;
        }

        public static Rating fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            double optDouble = jSONObject.optDouble("value", 0.0d);
            double optDouble2 = jSONObject.optDouble("scale", 0.0d);
            return (optDouble == 0.0d || optDouble2 == 0.0d) ? null : new Rating(optDouble, optDouble2);
        }

        public double getScale() {
            return this.f7818b;
        }

        public double getValue() {
            return this.f7817a;
        }
    }

    /* renamed from: com.facebook.ads.NativeAd.a */
    private class C2272a implements OnClickListener, OnTouchListener {
        final /* synthetic */ NativeAd f7819a;
        private int f7820b;
        private int f7821c;
        private int f7822d;
        private int f7823e;
        private float f7824f;
        private float f7825g;
        private int f7826h;
        private int f7827i;
        private boolean f7828j;
        private boolean f7829k;
        private long f7830l;

        private C2272a(NativeAd nativeAd) {
            this.f7819a = nativeAd;
            this.f7829k = false;
            this.f7830l = System.currentTimeMillis();
        }

        public void m8586a() {
            if (!this.f7829k) {
                this.f7830l = System.currentTimeMillis();
                this.f7829k = true;
            }
        }

        public Map<String, Object> m8587b() {
            Map<String, Object> hashMap = new HashMap();
            hashMap.put("clickX", Integer.valueOf(this.f7820b));
            hashMap.put("clickY", Integer.valueOf(this.f7821c));
            hashMap.put("width", Integer.valueOf(this.f7822d));
            hashMap.put("height", Integer.valueOf(this.f7823e));
            hashMap.put("adPositionX", Float.valueOf(this.f7824f));
            hashMap.put("adPositionY", Float.valueOf(this.f7825g));
            hashMap.put("visibleWidth", Integer.valueOf(this.f7827i));
            hashMap.put("visibleHeight", Integer.valueOf(this.f7826h));
            return hashMap;
        }

        public void onClick(View view) {
            if (System.currentTimeMillis() - this.f7830l < this.f7819a.f7839b) {
                Log.v(NativeAd.f7834c, "Premature click event (threshold=" + this.f7819a.f7839b + ").");
                return;
            }
            if (this.f7819a.f7844i != null) {
                this.f7819a.f7844i.onAdClicked(this.f7819a);
            }
            if (!this.f7828j) {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            Map b = m8587b();
            if (this.f7819a.f7858w != null) {
                b.put("nti", String.valueOf(this.f7819a.f7858w.getValue()));
            }
            if (this.f7819a.f7859x) {
                b.put("nhs", String.valueOf(this.f7819a.f7859x));
            }
            this.f7819a.f7848m.m8730b(b);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && this.f7819a.f7850o != null) {
                this.f7822d = this.f7819a.f7850o.getWidth();
                this.f7823e = this.f7819a.f7850o.getHeight();
                int[] iArr = new int[2];
                this.f7819a.f7850o.getLocationInWindow(iArr);
                this.f7824f = (float) iArr[0];
                this.f7825g = (float) iArr[1];
                Rect rect = new Rect();
                this.f7819a.f7850o.getGlobalVisibleRect(rect);
                this.f7827i = rect.width();
                this.f7826h = rect.height();
                int[] iArr2 = new int[2];
                view.getLocationInWindow(iArr2);
                this.f7820b = (((int) motionEvent.getX()) + iArr2[0]) - iArr[0];
                this.f7821c = (iArr2[1] + ((int) motionEvent.getY())) - iArr[1];
                this.f7828j = true;
            }
            return this.f7819a.f7852q != null && this.f7819a.f7852q.onTouch(view, motionEvent);
        }
    }

    /* renamed from: com.facebook.ads.NativeAd.b */
    private class C2273b extends BroadcastReceiver {
        final /* synthetic */ NativeAd f7831a;
        private boolean f7832b;

        private C2273b(NativeAd nativeAd) {
            this.f7831a = nativeAd;
        }

        public void m8588a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.facebook.ads.native.impression:" + this.f7831a.f7842g);
            intentFilter.addAction("com.facebook.ads.native.click:" + this.f7831a.f7842g);
            LocalBroadcastManager.getInstance(this.f7831a.f7840e).registerReceiver(this, intentFilter);
            this.f7832b = true;
        }

        public void m8589b() {
            if (this.f7832b) {
                try {
                    LocalBroadcastManager.getInstance(this.f7831a.f7840e).unregisterReceiver(this);
                } catch (Exception e) {
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            Object obj = intent.getAction().split(":")[0];
            if ("com.facebook.ads.native.impression".equals(obj)) {
                this.f7831a.f7854s.m8719a();
            } else if ("com.facebook.ads.native.click".equals(obj)) {
                Map hashMap = new HashMap();
                hashMap.put("mil", Boolean.valueOf(true));
                this.f7831a.f7848m.m8730b(hashMap);
            }
        }
    }

    static {
        f7833a = C2353c.ADS;
        f7834c = NativeAd.class.getSimpleName();
        f7835d = new WeakHashMap();
    }

    public NativeAd(Context context, C2307r c2307r, C2348d c2348d) {
        this(context, null);
        this.f7849n = c2348d;
        this.f7847l = true;
        this.f7848m = c2307r;
    }

    public NativeAd(Context context, String str) {
        this.f7842g = UUID.randomUUID().toString();
        this.f7851p = new ArrayList();
        this.f7838C = false;
        this.f7840e = context;
        this.f7841f = str;
        this.f7839b = C2472h.m9401c(context);
        this.f7843h = new C2339b(context);
    }

    NativeAd(NativeAd nativeAd) {
        this(nativeAd.f7840e, null);
        this.f7849n = nativeAd.f7849n;
        this.f7847l = true;
        this.f7848m = nativeAd.f7848m;
    }

    private void m8592a(View view) {
        this.f7851p.add(view);
        view.setOnClickListener(this.f7855t);
        view.setOnTouchListener(this.f7855t);
    }

    private void m8593a(List<View> list, View view) {
        if (!(view instanceof C2449a) && !(view instanceof AdChoicesView) && !(view instanceof C2430c)) {
            list.add(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    m8593a((List) list, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void downloadAndDisplayImage(Image image, ImageView imageView) {
        if (image != null && imageView != null) {
            new C2502k(imageView).m9502a(image.getUrl());
        }
    }

    private int getMinViewabilityPercentage() {
        return this.f7849n != null ? this.f7849n.m9051e() : (this.f7846k == null || this.f7846k.m8694a() == null) ? 1 : this.f7846k.m8694a().m9051e();
    }

    private int m8602i() {
        return this.f7849n != null ? this.f7849n.m9051e() : this.f7848m != null ? this.f7848m.m8738i() : (this.f7846k == null || this.f7846k.m8694a() == null) ? 0 : this.f7846k.m8694a().m9052f();
    }

    private int m8604j() {
        return this.f7849n != null ? this.f7849n.m9053g() : this.f7848m != null ? this.f7848m.m8739j() : (this.f7846k == null || this.f7846k.m8694a() == null) ? AdError.NETWORK_ERROR_CODE : this.f7846k.m8694a().m9053g();
    }

    private void m8607k() {
        for (View view : this.f7851p) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
        }
        this.f7851p.clear();
    }

    private void m8608l() {
        if (this.f7848m != null && this.f7848m.m8732c()) {
            this.f7856u = new C2273b();
            this.f7856u.m8588a();
            this.f7854s = new C2334q(this.f7840e, new C22694(this), this.f7848m);
        }
    }

    private void logExternalClick(String str) {
        Map hashMap = new HashMap();
        hashMap.put("eil", Boolean.valueOf(true));
        hashMap.put("eil_source", str);
        this.f7848m.m8730b(hashMap);
    }

    private void logExternalImpression() {
        this.f7854s.m8719a();
    }

    private void m8610m() {
        if (this.f7838C) {
            this.f7854s = new C2334q(this.f7840e, new C22715(this), this.f7848m);
        }
    }

    private void registerExternalLogReceiver(String str) {
        this.f7838C = true;
        this.f7837B = str;
    }

    C2307r m8619a() {
        return this.f7848m;
    }

    void m8620a(Type type) {
        this.f7858w = type;
    }

    void m8621a(boolean z) {
        this.f7859x = z;
    }

    String m8622b() {
        return !isAdLoaded() ? null : this.f7848m.m8751v();
    }

    void m8623b(boolean z) {
        this.f7860y = z;
    }

    String m8624c() {
        return !isAdLoaded() ? null : (!C2472h.m9402d(this.f7840e) || TextUtils.isEmpty(this.f7848m.m8752w())) ? this.f7848m.m8752w() : this.f7843h.m9024c(this.f7848m.m8752w());
    }

    int m8625d() {
        return this.f7848m.m8753x();
    }

    public void destroy() {
        if (this.f7856u != null) {
            this.f7856u.m8589b();
            this.f7856u = null;
        }
        if (this.f7846k != null) {
            this.f7846k.m8700d();
            this.f7846k = null;
        }
    }

    String m8626e() {
        return !isAdLoaded() ? null : this.f7848m.m8754y();
    }

    String m8627f() {
        return !isAdLoaded() ? null : this.f7848m.m8755z();
    }

    List<NativeAd> m8628g() {
        return !isAdLoaded() ? null : this.f7848m.m8724B();
    }

    public String getAdBody() {
        return !isAdLoaded() ? null : this.f7848m.m8745p();
    }

    public String getAdCallToAction() {
        return !isAdLoaded() ? null : this.f7848m.m8746q();
    }

    public Image getAdChoicesIcon() {
        return !isAdLoaded() ? null : this.f7848m.m8749t();
    }

    public String getAdChoicesLinkUrl() {
        return !isAdLoaded() ? null : this.f7848m.m8750u();
    }

    public Image getAdCoverImage() {
        return !isAdLoaded() ? null : this.f7848m.m8741l();
    }

    public AdExtras getAdExtras() {
        return !isAdLoaded() ? null : this.f7848m.m8723A();
    }

    public Image getAdIcon() {
        return !isAdLoaded() ? null : this.f7848m.m8740k();
    }

    public String getAdSocialContext() {
        return !isAdLoaded() ? null : this.f7848m.m8747r();
    }

    @Deprecated
    public Rating getAdStarRating() {
        return !isAdLoaded() ? null : this.f7848m.m8748s();
    }

    public String getAdSubtitle() {
        return !isAdLoaded() ? null : this.f7848m.m8744o();
    }

    public String getAdTitle() {
        return !isAdLoaded() ? null : this.f7848m.m8743n();
    }

    public NativeAdViewAttributes getAdViewAttributes() {
        return !isAdLoaded() ? null : this.f7848m.m8742m();
    }

    public String getId() {
        return !isAdLoaded() ? null : this.f7842g;
    }

    public String getPlacementId() {
        return this.f7841f;
    }

    public boolean isAdLoaded() {
        return this.f7848m != null && this.f7848m.m8731b();
    }

    public boolean isNativeConfigEnabled() {
        return isAdLoaded() && this.f7848m.m8735f();
    }

    public void loadAd() {
        loadAd(EnumSet.of(MediaCacheFlag.NONE));
    }

    public void loadAd(EnumSet<MediaCacheFlag> enumSet) {
        if (this.f7847l) {
            throw new IllegalStateException("loadAd cannot be called more than once");
        }
        this.f7836A = System.currentTimeMillis();
        this.f7847l = true;
        this.f7846k = new DisplayAdController(this.f7840e, this.f7841f, C2409e.NATIVE_UNKNOWN, AdPlacementType.NATIVE, null, f7833a, 1, true);
        this.f7846k.m8695a(new C22631(this, enumSet));
        this.f7846k.m8698b();
    }

    public void registerViewForInteraction(View view) {
        List arrayList = new ArrayList();
        m8593a(arrayList, view);
        registerViewForInteraction(view, arrayList);
    }

    public void registerViewForInteraction(View view, List<View> list) {
        if (view == null) {
            throw new IllegalArgumentException("Must provide a View");
        } else if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Invalid set of clickable views");
        } else if (isAdLoaded()) {
            if (this.f7850o != null) {
                Log.w(f7834c, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
                unregisterView();
            }
            if (f7835d.containsKey(view)) {
                Log.w(f7834c, "View already registered with a NativeAd. Auto unregistering and proceeding.");
                ((NativeAd) ((WeakReference) f7835d.get(view)).get()).unregisterView();
            }
            this.f7855t = new C2272a();
            this.f7850o = view;
            if (view instanceof ViewGroup) {
                this.f7857v = new C2469q(view.getContext(), new C22652(this));
                ((ViewGroup) view).addView(this.f7857v);
            }
            for (View a : list) {
                m8592a(a);
            }
            this.f7848m.m8728a(view, list);
            this.f7854s = new C2334q(this.f7840e, new C2270c(), this.f7848m);
            this.f7854s.m9009a((List) list);
            this.f7853r = new C2310e(this.f7840e, this.f7850o, getMinViewabilityPercentage(), new C22673(this));
            this.f7853r.m8811a(m8602i());
            this.f7853r.m8813b(m8604j());
            this.f7853r.m8810a();
            f7835d.put(view, new WeakReference(this));
        } else {
            Log.e(f7834c, "Ad not loaded");
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f7844i = adListener;
    }

    @Deprecated
    public void setImpressionListener(ImpressionListener impressionListener) {
        this.f7845j = impressionListener;
    }

    public void setMediaViewAutoplay(boolean z) {
        this.f7861z = z;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f7852q = onTouchListener;
    }

    public void unregisterView() {
        if (this.f7850o != null) {
            if (f7835d.containsKey(this.f7850o) && ((WeakReference) f7835d.get(this.f7850o)).get() == this) {
                if ((this.f7850o instanceof ViewGroup) && this.f7857v != null) {
                    ((ViewGroup) this.f7850o).removeView(this.f7857v);
                    this.f7857v = null;
                }
                if (this.f7848m != null) {
                    this.f7848m.m8725a();
                }
                f7835d.remove(this.f7850o);
                m8607k();
                this.f7850o = null;
                if (this.f7853r != null) {
                    this.f7853r.m8812b();
                    this.f7853r = null;
                }
                this.f7854s = null;
                return;
            }
            throw new IllegalStateException("View not registered with this NativeAd");
        }
    }
}
