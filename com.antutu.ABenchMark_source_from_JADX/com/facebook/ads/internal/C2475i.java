package com.facebook.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.NativeAd.MediaCacheFlag;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.C2288s;
import com.facebook.ads.internal.adapters.C2307r;
import com.facebook.ads.internal.adapters.C2312f;
import com.facebook.ads.internal.p125c.C2344a;
import com.facebook.ads.internal.p125c.C2347c;
import com.facebook.ads.internal.p125c.C2350e;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.server.C2479a;
import com.facebook.ads.internal.server.C2479a.C2294a;
import com.facebook.ads.internal.server.C2483d;
import com.facebook.ads.internal.util.C2290u;
import com.facebook.ads.internal.util.C2498g;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.i */
public class C2475i implements C2294a {
    private final Context f8510a;
    private final String f8511b;
    private final C2479a f8512c;
    private final C2409e f8513d;
    private final C2353c f8514e;
    private final AdSize f8515f;
    private final int f8516g;
    private boolean f8517h;
    private final Handler f8518i;
    private final Runnable f8519j;
    private C2277a f8520k;
    private C2347c f8521l;

    /* renamed from: com.facebook.ads.internal.i.a */
    public interface C2277a {
        void m8637a(C2343b c2343b);

        void m8638a(List<C2307r> list);
    }

    /* renamed from: com.facebook.ads.internal.i.1 */
    class C24731 implements C2288s {
        final /* synthetic */ List f8508a;
        final /* synthetic */ C2475i f8509b;

        C24731(C2475i c2475i, List list) {
            this.f8509b = c2475i;
            this.f8508a = list;
        }

        public void m9407a(C2307r c2307r) {
            this.f8508a.add(c2307r);
        }

        public void m9408a(C2307r c2307r, AdError adError) {
        }

        public void m9409b(C2307r c2307r) {
        }

        public void m9410c(C2307r c2307r) {
        }
    }

    /* renamed from: com.facebook.ads.internal.i.b */
    private static final class C2474b extends C2290u<C2475i> {
        public C2474b(C2475i c2475i) {
            super(c2475i);
        }

        public void run() {
            C2475i c2475i = (C2475i) m8655a();
            if (c2475i != null) {
                if (C2498g.m9481a(c2475i.f8510a)) {
                    c2475i.m9415a();
                } else {
                    c2475i.f8518i.postDelayed(c2475i.f8519j, 5000);
                }
            }
        }
    }

    public C2475i(Context context, String str, C2409e c2409e, AdSize adSize, C2353c c2353c, int i, EnumSet<MediaCacheFlag> enumSet) {
        this.f8510a = context;
        this.f8511b = str;
        this.f8513d = c2409e;
        this.f8515f = adSize;
        this.f8514e = c2353c;
        this.f8516g = i;
        this.f8512c = new C2479a(context);
        this.f8512c.m9439a((C2294a) this);
        this.f8517h = true;
        this.f8518i = new Handler();
        this.f8519j = new C2474b(this);
    }

    private List<C2307r> m9414d() {
        C2347c c2347c = this.f8521l;
        C2344a d = c2347c.m9045d();
        List<C2307r> arrayList = new ArrayList(c2347c.m9044c());
        for (C2344a c2344a = d; c2344a != null; c2344a = c2347c.m9045d()) {
            AdAdapter a = C2312f.m8815a(c2344a.m9037a(), AdPlacementType.NATIVE);
            if (a != null && a.getPlacementType() == AdPlacementType.NATIVE) {
                Map hashMap = new HashMap();
                hashMap.put(Constants.KEY_DATA, c2344a.m9039b());
                hashMap.put("definition", c2347c.m9041a());
                ((C2307r) a).m8727a(this.f8510a, new C24731(this, arrayList), hashMap);
            }
        }
        return arrayList;
    }

    public void m9415a() {
        this.f8512c.m9438a(new C2350e(this.f8510a, this.f8511b, this.f8515f, this.f8513d, this.f8514e, this.f8516g, AdSettings.isTestMode(this.f8510a)));
    }

    public void m9416a(C2343b c2343b) {
        if (this.f8517h) {
            this.f8518i.postDelayed(this.f8519j, 1800000);
        }
        if (this.f8520k != null) {
            this.f8520k.m8637a(c2343b);
        }
    }

    public void m9417a(C2277a c2277a) {
        this.f8520k = c2277a;
    }

    public void m9418a(C2483d c2483d) {
        C2347c b = c2483d.m9446b();
        if (b == null) {
            throw new IllegalStateException("no placement in response");
        }
        if (this.f8517h) {
            long b2 = b.m9041a().m9048b();
            if (b2 == 0) {
                b2 = 1800000;
            }
            this.f8518i.postDelayed(this.f8519j, b2);
        }
        this.f8521l = b;
        List d = m9414d();
        if (this.f8520k == null) {
            return;
        }
        if (d.isEmpty()) {
            this.f8520k.m8637a(AdErrorType.NO_FILL.getAdErrorWrapper(BuildConfig.FLAVOR));
        } else {
            this.f8520k.m8638a(d);
        }
    }

    public void m9419b() {
    }

    public void m9420c() {
        this.f8517h = false;
        this.f8518i.removeCallbacks(this.f8519j);
    }
}
