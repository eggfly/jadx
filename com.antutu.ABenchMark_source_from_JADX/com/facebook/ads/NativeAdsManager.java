package com.facebook.ads;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.NativeAd.MediaCacheFlag;
import com.facebook.ads.internal.C2343b;
import com.facebook.ads.internal.C2353c;
import com.facebook.ads.internal.C2409e;
import com.facebook.ads.internal.C2472h;
import com.facebook.ads.internal.C2475i;
import com.facebook.ads.internal.C2475i.C2277a;
import com.facebook.ads.internal.adapters.C2307r;
import com.facebook.ads.internal.p122b.C2261a;
import com.facebook.ads.internal.p122b.C2339b;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class NativeAdsManager {
    private static final C2353c f7887a;
    private final Context f7888b;
    private final String f7889c;
    private final int f7890d;
    private final List<NativeAd> f7891e;
    private int f7892f;
    private Listener f7893g;
    private C2475i f7894h;
    private boolean f7895i;
    private boolean f7896j;

    public interface Listener {
        void onAdError(AdError adError);

        void onAdsLoaded();
    }

    /* renamed from: com.facebook.ads.NativeAdsManager.1 */
    class C22781 implements C2277a {
        final /* synthetic */ EnumSet f7885a;
        final /* synthetic */ NativeAdsManager f7886b;

        /* renamed from: com.facebook.ads.NativeAdsManager.1.1 */
        class C22761 implements C2261a {
            final /* synthetic */ List f7883a;
            final /* synthetic */ C22781 f7884b;

            C22761(C22781 c22781, List list) {
                this.f7884b = c22781;
                this.f7883a = list;
            }

            public void m8636a() {
                this.f7884b.f7886b.f7896j = true;
                this.f7884b.f7886b.f7891e.clear();
                this.f7884b.f7886b.f7892f = 0;
                for (C2307r nativeAd : this.f7883a) {
                    this.f7884b.f7886b.f7891e.add(new NativeAd(this.f7884b.f7886b.f7888b, nativeAd, null));
                }
                if (this.f7884b.f7886b.f7893g != null) {
                    this.f7884b.f7886b.f7893g.onAdsLoaded();
                }
            }
        }

        C22781(NativeAdsManager nativeAdsManager, EnumSet enumSet) {
            this.f7886b = nativeAdsManager;
            this.f7885a = enumSet;
        }

        public void m8639a(C2343b c2343b) {
            if (this.f7886b.f7893g != null) {
                this.f7886b.f7893g.onAdError(c2343b.m9036b());
            }
        }

        public void m8640a(List<C2307r> list) {
            C2339b c2339b = new C2339b(this.f7886b.f7888b);
            for (C2307r c2307r : list) {
                if (this.f7885a.contains(MediaCacheFlag.ICON) && c2307r.m8740k() != null) {
                    c2339b.m9022a(c2307r.m8740k().getUrl());
                }
                if (this.f7885a.contains(MediaCacheFlag.IMAGE) && c2307r.m8741l() != null) {
                    c2339b.m9022a(c2307r.m8741l().getUrl());
                }
                if (this.f7885a.contains(MediaCacheFlag.VIDEO) && !TextUtils.isEmpty(c2307r.m8752w()) && C2472h.m9402d(this.f7886b.f7888b)) {
                    c2339b.m9023b(c2307r.m8752w());
                }
            }
            c2339b.m9021a(new C22761(this, list));
        }
    }

    static {
        f7887a = C2353c.ADS;
    }

    public NativeAdsManager(Context context, String str, int i) {
        this.f7888b = context;
        this.f7889c = str;
        this.f7890d = Math.max(i, 0);
        this.f7891e = new ArrayList(i);
        this.f7892f = -1;
        this.f7896j = false;
        this.f7895i = false;
    }

    public void disableAutoRefresh() {
        this.f7895i = true;
        if (this.f7894h != null) {
            this.f7894h.m9420c();
        }
    }

    public int getUniqueNativeAdCount() {
        return this.f7891e.size();
    }

    public boolean isLoaded() {
        return this.f7896j;
    }

    public void loadAds() {
        loadAds(EnumSet.of(MediaCacheFlag.NONE));
    }

    public void loadAds(EnumSet<MediaCacheFlag> enumSet) {
        C2409e c2409e = C2409e.NATIVE_UNKNOWN;
        int i = this.f7890d;
        if (this.f7894h != null) {
            this.f7894h.m9419b();
        }
        this.f7894h = new C2475i(this.f7888b, this.f7889c, c2409e, null, f7887a, i, enumSet);
        if (this.f7895i) {
            this.f7894h.m9420c();
        }
        this.f7894h.m9417a(new C22781(this, enumSet));
        this.f7894h.m9415a();
    }

    public NativeAd nextNativeAd() {
        if (this.f7891e.size() == 0) {
            return null;
        }
        int i = this.f7892f;
        this.f7892f = i + 1;
        NativeAd nativeAd = (NativeAd) this.f7891e.get(i % this.f7891e.size());
        return i >= this.f7891e.size() ? new NativeAd(nativeAd) : nativeAd;
    }

    public void setListener(Listener listener) {
        this.f7893g = listener;
    }
}
