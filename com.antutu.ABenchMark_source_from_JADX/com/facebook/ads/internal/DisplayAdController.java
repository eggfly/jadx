package com.facebook.ads.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.BannerAdapter;
import com.facebook.ads.internal.adapters.BannerAdapterListener;
import com.facebook.ads.internal.adapters.C2288s;
import com.facebook.ads.internal.adapters.C2307r;
import com.facebook.ads.internal.adapters.C2312f;
import com.facebook.ads.internal.adapters.InterstitialAdapter;
import com.facebook.ads.internal.adapters.InterstitialAdapterListener;
import com.facebook.ads.internal.p125c.C2344a;
import com.facebook.ads.internal.p125c.C2347c;
import com.facebook.ads.internal.p125c.C2348d;
import com.facebook.ads.internal.p125c.C2350e;
import com.facebook.ads.internal.p125c.C2351f;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.server.C2479a;
import com.facebook.ads.internal.server.C2479a.C2294a;
import com.facebook.ads.internal.server.C2483d;
import com.facebook.ads.internal.util.C2290u;
import com.facebook.ads.internal.util.C2489b;
import com.facebook.ads.internal.util.C2490c;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2507o;
import com.facebook.ads.internal.util.C2510r;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

public class DisplayAdController implements C2294a {
    private static final String f7928b;
    private static final Handler f7929h;
    private static boolean f7930i;
    protected C2253a f7931a;
    private final Context f7932c;
    private final String f7933d;
    private final AdPlacementType f7934e;
    private final C2479a f7935f;
    private final Handler f7936g;
    private final Runnable f7937j;
    private final Runnable f7938k;
    private volatile boolean f7939l;
    private boolean f7940m;
    private volatile boolean f7941n;
    private AdAdapter f7942o;
    private View f7943p;
    private C2347c f7944q;
    private C2350e f7945r;
    private C2409e f7946s;
    private C2353c f7947t;
    private AdSize f7948u;
    private int f7949v;
    private final C2293c f7950w;
    private boolean f7951x;

    /* renamed from: com.facebook.ads.internal.DisplayAdController.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ C2343b f7901a;
        final /* synthetic */ DisplayAdController f7902b;

        AnonymousClass10(DisplayAdController displayAdController, C2343b c2343b) {
            this.f7902b = displayAdController;
            this.f7901a = c2343b;
        }

        public void run() {
            this.f7902b.f7931a.m8520a(this.f7901a);
            if (!this.f7902b.f7940m && !this.f7902b.f7939l) {
                switch (this.f7901a.m9035a().getErrorCode()) {
                    case AdError.NETWORK_ERROR_CODE /*1000*/:
                    case AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE /*1002*/:
                        switch (C22812.f7905a[this.f7902b.m8683k().ordinal()]) {
                            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                                this.f7902b.f7936g.postDelayed(this.f7902b.f7937j, 30000);
                                this.f7902b.f7939l = true;
                            default:
                        }
                    default:
                }
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.1 */
    class C22801 implements Runnable {
        final /* synthetic */ C2483d f7903a;
        final /* synthetic */ DisplayAdController f7904b;

        C22801(DisplayAdController displayAdController, C2483d c2483d) {
            this.f7904b = displayAdController;
            this.f7903a = c2483d;
        }

        public void run() {
            C2347c b = this.f7903a.m9446b();
            if (b == null || b.m9041a() == null) {
                throw new IllegalStateException("invalid placement in response");
            }
            this.f7904b.f7944q = b;
            this.f7904b.m8688m();
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.2 */
    static /* synthetic */ class C22812 {
        static final /* synthetic */ int[] f7905a;

        static {
            f7905a = new int[AdPlacementType.values().length];
            try {
                f7905a[AdPlacementType.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7905a[AdPlacementType.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7905a[AdPlacementType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.3 */
    class C22823 implements Runnable {
        final /* synthetic */ DisplayAdController f7906a;

        C22823(DisplayAdController displayAdController) {
            this.f7906a = displayAdController;
        }

        public void run() {
            try {
                this.f7906a.m8689n();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.4 */
    class C22834 implements Runnable {
        final /* synthetic */ BannerAdapter f7907a;
        final /* synthetic */ DisplayAdController f7908b;

        C22834(DisplayAdController displayAdController, BannerAdapter bannerAdapter) {
            this.f7908b = displayAdController;
            this.f7907a = bannerAdapter;
        }

        public void run() {
            this.f7908b.m8665a(this.f7907a);
            this.f7908b.m8688m();
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.5 */
    class C22845 implements BannerAdapterListener {
        final /* synthetic */ Runnable f7909a;
        final /* synthetic */ DisplayAdController f7910b;

        C22845(DisplayAdController displayAdController, Runnable runnable) {
            this.f7910b = displayAdController;
            this.f7909a = runnable;
        }

        public void onBannerAdClicked(BannerAdapter bannerAdapter) {
            this.f7910b.f7931a.m8521b();
        }

        public void onBannerAdExpanded(BannerAdapter bannerAdapter) {
            this.f7910b.m8691p();
        }

        public void onBannerAdLoaded(BannerAdapter bannerAdapter, View view) {
            this.f7910b.f7936g.removeCallbacks(this.f7909a);
            AdAdapter f = this.f7910b.f7942o;
            this.f7910b.f7942o = bannerAdapter;
            this.f7910b.f7943p = view;
            if (this.f7910b.f7941n) {
                this.f7910b.f7931a.m8518a(view);
                this.f7910b.m8665a(f);
                this.f7910b.m8690o();
                return;
            }
            this.f7910b.f7931a.m8517a();
        }

        public void onBannerAdMinimized(BannerAdapter bannerAdapter) {
            this.f7910b.m8690o();
        }

        public void onBannerError(BannerAdapter bannerAdapter, AdError adError) {
            this.f7910b.f7936g.removeCallbacks(this.f7909a);
            this.f7910b.m8665a((AdAdapter) bannerAdapter);
            this.f7910b.m8688m();
        }

        public void onBannerLoggingImpression(BannerAdapter bannerAdapter) {
            this.f7910b.f7931a.m8522c();
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.6 */
    class C22856 implements Runnable {
        final /* synthetic */ InterstitialAdapter f7911a;
        final /* synthetic */ DisplayAdController f7912b;

        C22856(DisplayAdController displayAdController, InterstitialAdapter interstitialAdapter) {
            this.f7912b = displayAdController;
            this.f7911a = interstitialAdapter;
        }

        public void run() {
            this.f7912b.m8665a(this.f7911a);
            this.f7912b.m8688m();
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.7 */
    class C22867 implements InterstitialAdapterListener {
        final /* synthetic */ Runnable f7913a;
        final /* synthetic */ DisplayAdController f7914b;

        C22867(DisplayAdController displayAdController, Runnable runnable) {
            this.f7914b = displayAdController;
            this.f7913a = runnable;
        }

        public void onInterstitialAdClicked(InterstitialAdapter interstitialAdapter, String str, boolean z) {
            this.f7914b.f7931a.m8521b();
            Object obj = !C2510r.m9516a(str) ? 1 : null;
            if (z && obj != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!(this.f7914b.f7945r.f8189d instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.setData(Uri.parse(str));
                this.f7914b.f7945r.f8189d.startActivity(intent);
            }
        }

        public void onInterstitialAdDismissed(InterstitialAdapter interstitialAdapter) {
            this.f7914b.f7931a.m8524e();
        }

        public void onInterstitialAdDisplayed(InterstitialAdapter interstitialAdapter) {
            this.f7914b.f7931a.m8523d();
        }

        public void onInterstitialAdLoaded(InterstitialAdapter interstitialAdapter) {
            this.f7914b.f7936g.removeCallbacks(this.f7913a);
            this.f7914b.f7942o = interstitialAdapter;
            this.f7914b.f7931a.m8517a();
            this.f7914b.m8690o();
        }

        public void onInterstitialError(InterstitialAdapter interstitialAdapter, AdError adError) {
            this.f7914b.f7936g.removeCallbacks(this.f7913a);
            this.f7914b.m8665a((AdAdapter) interstitialAdapter);
            this.f7914b.m8688m();
        }

        public void onInterstitialLoggingImpression(InterstitialAdapter interstitialAdapter) {
            this.f7914b.f7931a.m8522c();
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.8 */
    class C22878 implements Runnable {
        final /* synthetic */ C2307r f7915a;
        final /* synthetic */ long f7916b;
        final /* synthetic */ C2344a f7917c;
        final /* synthetic */ DisplayAdController f7918d;

        C22878(DisplayAdController displayAdController, C2307r c2307r, long j, C2344a c2344a) {
            this.f7918d = displayAdController;
            this.f7915a = c2307r;
            this.f7916b = j;
            this.f7917c = c2344a;
        }

        public void run() {
            this.f7918d.m8665a(this.f7915a);
            Map a = this.f7918d.m8660a(this.f7916b);
            a.put(C4233j.f14375B, "-1");
            a.put(XAdErrorCode.ERROR_CODE_MESSAGE, "timeout");
            this.f7918d.m8669a(this.f7917c.m9038a(C2351f.REQUEST), a);
            this.f7918d.m8688m();
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.9 */
    class C22899 implements C2288s {
        boolean f7919a;
        boolean f7920b;
        boolean f7921c;
        final /* synthetic */ Runnable f7922d;
        final /* synthetic */ long f7923e;
        final /* synthetic */ C2344a f7924f;
        final /* synthetic */ DisplayAdController f7925g;

        C22899(DisplayAdController displayAdController, Runnable runnable, long j, C2344a c2344a) {
            this.f7925g = displayAdController;
            this.f7922d = runnable;
            this.f7923e = j;
            this.f7924f = c2344a;
            this.f7919a = false;
            this.f7920b = false;
            this.f7921c = false;
        }

        public void m8651a(C2307r c2307r) {
            this.f7925g.f7936g.removeCallbacks(this.f7922d);
            this.f7925g.f7942o = c2307r;
            this.f7925g.f7931a.m8517a();
            if (!this.f7919a) {
                this.f7919a = true;
                this.f7925g.m8669a(this.f7924f.m9038a(C2351f.REQUEST), this.f7925g.m8660a(this.f7923e));
            }
        }

        public void m8652a(C2307r c2307r, AdError adError) {
            this.f7925g.f7936g.removeCallbacks(this.f7922d);
            this.f7925g.m8665a((AdAdapter) c2307r);
            if (!this.f7919a) {
                this.f7919a = true;
                Map a = this.f7925g.m8660a(this.f7923e);
                a.put(C4233j.f14375B, String.valueOf(adError.getErrorCode()));
                a.put(XAdErrorCode.ERROR_CODE_MESSAGE, String.valueOf(adError.getErrorMessage()));
                this.f7925g.m8669a(this.f7924f.m9038a(C2351f.REQUEST), a);
            }
            this.f7925g.m8688m();
        }

        public void m8653b(C2307r c2307r) {
            if (!this.f7920b) {
                this.f7920b = true;
                this.f7925g.m8669a(this.f7924f.m9038a(C2351f.IMPRESSION), null);
            }
        }

        public void m8654c(C2307r c2307r) {
            if (!this.f7921c) {
                this.f7921c = true;
                this.f7925g.m8669a(this.f7924f.m9038a(C2351f.CLICK), null);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.a */
    private static final class C2291a extends C2290u<DisplayAdController> {
        public C2291a(DisplayAdController displayAdController) {
            super(displayAdController);
        }

        public void run() {
            DisplayAdController displayAdController = (DisplayAdController) m8655a();
            if (displayAdController != null) {
                displayAdController.f7939l = false;
                displayAdController.m8686l();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.b */
    private static final class C2292b extends C2290u<DisplayAdController> {
        public C2292b(DisplayAdController displayAdController) {
            super(displayAdController);
        }

        public void run() {
            DisplayAdController displayAdController = (DisplayAdController) m8655a();
            if (displayAdController != null) {
                displayAdController.m8690o();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController.c */
    private class C2293c extends BroadcastReceiver {
        final /* synthetic */ DisplayAdController f7927a;

        private C2293c(DisplayAdController displayAdController) {
            this.f7927a = displayAdController;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.f7927a.m8691p();
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                this.f7927a.m8690o();
            }
        }
    }

    static {
        f7928b = DisplayAdController.class.getSimpleName();
        f7929h = new Handler(Looper.getMainLooper());
        f7930i = false;
    }

    public DisplayAdController(Context context, String str, C2409e c2409e, AdPlacementType adPlacementType, AdSize adSize, C2353c c2353c, int i, boolean z) {
        this.f7936g = new Handler();
        this.f7932c = context;
        this.f7933d = str;
        this.f7946s = c2409e;
        this.f7934e = adPlacementType;
        this.f7948u = adSize;
        this.f7947t = c2353c;
        this.f7949v = i;
        this.f7950w = new C2293c();
        this.f7935f = new C2479a(context);
        this.f7935f.m9439a((C2294a) this);
        this.f7937j = new C2291a(this);
        this.f7938k = new C2292b(this);
        this.f7940m = z;
        m8680i();
    }

    private Map<String, String> m8660a(long j) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("delay", String.valueOf(System.currentTimeMillis() - j));
        return hashMap;
    }

    private void m8665a(AdAdapter adAdapter) {
        if (adAdapter != null) {
            adAdapter.onDestroy();
        }
    }

    private void m8666a(BannerAdapter bannerAdapter, C2347c c2347c, Map<String, Object> map) {
        Runnable c22834 = new C22834(this, bannerAdapter);
        this.f7936g.postDelayed(c22834, (long) c2347c.m9041a().m9054h());
        bannerAdapter.loadBannerAd(this.f7932c, this.f7948u, new C22845(this, c22834), map);
    }

    private void m8667a(InterstitialAdapter interstitialAdapter, C2347c c2347c, Map<String, Object> map) {
        Runnable c22856 = new C22856(this, interstitialAdapter);
        this.f7936g.postDelayed(c22856, (long) c2347c.m9041a().m9054h());
        interstitialAdapter.loadInterstitialAd(this.f7932c, new C22867(this, c22856), map);
    }

    private void m8668a(C2307r c2307r, C2347c c2347c, C2344a c2344a, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        Runnable c22878 = new C22878(this, c2307r, currentTimeMillis, c2344a);
        this.f7936g.postDelayed(c22878, (long) c2347c.m9041a().m9054h());
        c2307r.m8727a(this.f7932c, new C22899(this, c22878, currentTimeMillis, c2344a), map);
    }

    private void m8669a(List<String> list, Map<String, String> map) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                new C2507o(map).execute(new String[]{str});
            }
        }
    }

    private void m8680i() {
        if (!this.f7940m) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f7932c.registerReceiver(this.f7950w, intentFilter);
            this.f7951x = true;
        }
    }

    private void m8681j() {
        if (this.f7951x) {
            try {
                this.f7932c.unregisterReceiver(this.f7950w);
                this.f7951x = false;
            } catch (Throwable e) {
                C2490c.m9456a(C2489b.m9453a(e, "Error unregistering screen state receiever"));
            }
        }
    }

    private AdPlacementType m8683k() {
        return this.f7934e != null ? this.f7934e : this.f7948u == null ? AdPlacementType.NATIVE : this.f7948u == AdSize.INTERSTITIAL ? AdPlacementType.INTERSTITIAL : AdPlacementType.BANNER;
    }

    private void m8686l() {
        this.f7945r = new C2350e(this.f7932c, this.f7933d, this.f7948u, this.f7946s, this.f7947t, this.f7949v, AdSettings.isTestMode(this.f7932c));
        this.f7935f.m9438a(this.f7945r);
    }

    private synchronized void m8688m() {
        f7929h.post(new C22823(this));
    }

    private void m8689n() {
        C2347c c2347c = this.f7944q;
        C2344a d = c2347c.m9045d();
        if (d == null) {
            this.f7931a.m8520a(AdErrorType.NO_FILL.getAdErrorWrapper(BuildConfig.FLAVOR));
            m8690o();
            return;
        }
        String a = d.m9037a();
        AdAdapter a2 = C2312f.m8815a(a, c2347c.m9041a().m9047a());
        if (a2 == null) {
            Log.e(f7928b, "Adapter does not exist: " + a);
            m8688m();
        } else if (m8683k() != a2.getPlacementType()) {
            this.f7931a.m8520a(AdErrorType.INTERNAL_ERROR.getAdErrorWrapper(BuildConfig.FLAVOR));
        } else {
            Map hashMap = new HashMap();
            C2348d a3 = c2347c.m9041a();
            hashMap.put(Constants.KEY_DATA, d.m9039b());
            hashMap.put("definition", a3);
            if (this.f7945r == null) {
                this.f7931a.m8520a(AdErrorType.UNKNOWN_ERROR.getAdErrorWrapper("environment is empty"));
            }
            switch (C22812.f7905a[a2.getPlacementType().ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    m8667a((InterstitialAdapter) a2, c2347c, hashMap);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    m8666a((BannerAdapter) a2, c2347c, hashMap);
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    m8668a((C2307r) a2, c2347c, d, hashMap);
                default:
                    Log.e(f7928b, "attempt unexpected adapter type");
            }
        }
    }

    private void m8690o() {
        if (!this.f7940m && !this.f7939l) {
            switch (C22812.f7905a[m8683k().ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (!C2498g.m9481a(this.f7932c)) {
                        this.f7936g.postDelayed(this.f7938k, 1000);
                        break;
                    }
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    int e = this.f7944q == null ? 1 : this.f7944q.m9041a().m9051e();
                    if (!(this.f7943p == null || C2498g.m9482a(this.f7932c, this.f7943p, e))) {
                        this.f7936g.postDelayed(this.f7938k, 1000);
                        return;
                    }
                default:
                    return;
            }
            long b = this.f7944q == null ? 30000 : this.f7944q.m9041a().m9048b();
            if (b > 0) {
                this.f7936g.postDelayed(this.f7937j, b);
                this.f7939l = true;
            }
        }
    }

    private void m8691p() {
        if (this.f7939l) {
            this.f7936g.removeCallbacks(this.f7937j);
            this.f7939l = false;
        }
    }

    private Handler m8692q() {
        return !m8693r() ? this.f7936g : f7929h;
    }

    private static synchronized boolean m8693r() {
        boolean z;
        synchronized (DisplayAdController.class) {
            z = f7930i;
        }
        return z;
    }

    protected static synchronized void setMainThreadForced(boolean z) {
        synchronized (DisplayAdController.class) {
            Log.d(f7928b, "DisplayAdController changed main thread forced from " + f7930i + " to " + z);
            f7930i = z;
        }
    }

    public C2348d m8694a() {
        return this.f7944q == null ? null : this.f7944q.m9041a();
    }

    public void m8695a(C2253a c2253a) {
        this.f7931a = c2253a;
    }

    public synchronized void m8696a(C2343b c2343b) {
        m8692q().post(new AnonymousClass10(this, c2343b));
    }

    public synchronized void m8697a(C2483d c2483d) {
        m8692q().post(new C22801(this, c2483d));
    }

    public void m8698b() {
        m8686l();
    }

    public void m8699c() {
        if (this.f7942o == null) {
            throw new IllegalStateException("no adapter ready to start");
        } else if (this.f7941n) {
            throw new IllegalStateException("ad already started");
        } else {
            this.f7941n = true;
            switch (C22812.f7905a[this.f7942o.getPlacementType().ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    ((InterstitialAdapter) this.f7942o).show();
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (this.f7943p != null) {
                        this.f7931a.m8518a(this.f7943p);
                        m8690o();
                    }
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    C2307r c2307r = (C2307r) this.f7942o;
                    if (c2307r.m8731b()) {
                        this.f7931a.m8519a(c2307r);
                        return;
                    }
                    throw new IllegalStateException("ad is not ready or already displayed");
                default:
                    Log.e(f7928b, "start unexpected adapter type");
            }
        }
    }

    public void m8700d() {
        m8681j();
        if (this.f7941n) {
            m8691p();
            m8665a(this.f7942o);
            this.f7943p = null;
            this.f7941n = false;
        }
    }

    public void m8701e() {
        if (this.f7941n) {
            m8691p();
        }
    }

    public void m8702f() {
        if (this.f7941n) {
            m8690o();
        }
    }

    public void m8703g() {
        m8691p();
        m8686l();
    }

    public void m8704h() {
        this.f7940m = true;
        m8691p();
    }
}
