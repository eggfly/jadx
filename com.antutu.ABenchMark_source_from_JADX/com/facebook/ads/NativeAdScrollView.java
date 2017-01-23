package com.facebook.ads;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.ads.NativeAdView.Type;
import java.util.ArrayList;
import java.util.List;

public class NativeAdScrollView extends LinearLayout {
    public static final int DEFAULT_INSET = 20;
    public static final int DEFAULT_MAX_ADS = 10;
    private final Context f7865a;
    private final NativeAdsManager f7866b;
    private final AdViewProvider f7867c;
    private final Type f7868d;
    private final int f7869e;
    private final C2275b f7870f;
    private final NativeAdViewAttributes f7871g;

    public interface AdViewProvider {
        View createView(NativeAd nativeAd, int i);

        void destroyView(NativeAd nativeAd, View view);
    }

    /* renamed from: com.facebook.ads.NativeAdScrollView.a */
    private class C2274a extends PagerAdapter {
        final /* synthetic */ NativeAdScrollView f7862a;
        private List<NativeAd> f7863b;

        public C2274a(NativeAdScrollView nativeAdScrollView) {
            this.f7862a = nativeAdScrollView;
            this.f7863b = new ArrayList();
        }

        public void m8629a() {
            this.f7863b.clear();
            int min = Math.min(this.f7862a.f7869e, this.f7862a.f7866b.getUniqueNativeAdCount());
            for (int i = 0; i < min; i++) {
                NativeAd nextNativeAd = this.f7862a.f7866b.nextNativeAd();
                nextNativeAd.m8621a(true);
                this.f7863b.add(nextNativeAd);
            }
            notifyDataSetChanged();
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (i < this.f7863b.size()) {
                if (this.f7862a.f7868d != null) {
                    ((NativeAd) this.f7863b.get(i)).unregisterView();
                } else {
                    this.f7862a.f7867c.destroyView((NativeAd) this.f7863b.get(i), (View) obj);
                }
            }
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f7863b.size();
        }

        public int getItemPosition(Object obj) {
            int indexOf = this.f7863b.indexOf(obj);
            return indexOf >= 0 ? indexOf : -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View render = this.f7862a.f7868d != null ? NativeAdView.render(this.f7862a.f7865a, (NativeAd) this.f7863b.get(i), this.f7862a.f7868d, this.f7862a.f7871g) : this.f7862a.f7867c.createView((NativeAd) this.f7863b.get(i), i);
            viewGroup.addView(render);
            return render;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: com.facebook.ads.NativeAdScrollView.b */
    private class C2275b extends ViewPager {
        final /* synthetic */ NativeAdScrollView f7864a;

        public C2275b(NativeAdScrollView nativeAdScrollView, Context context) {
            this.f7864a = nativeAdScrollView;
            super(context);
        }

        protected void onMeasure(int i, int i2) {
            int i3 = 0;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                childAt.measure(i, MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
            }
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider) {
        this(context, nativeAdsManager, adViewProvider, null, null, DEFAULT_MAX_ADS);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, int i) {
        this(context, nativeAdsManager, adViewProvider, null, null, i);
    }

    private NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, Type type, NativeAdViewAttributes nativeAdViewAttributes, int i) {
        super(context);
        if (!nativeAdsManager.isLoaded()) {
            throw new IllegalStateException("NativeAdsManager not loaded");
        } else if (type == null && adViewProvider == null) {
            throw new IllegalArgumentException("Must provide one of AdLayoutProperties or a CustomAdView");
        } else {
            this.f7865a = context;
            this.f7866b = nativeAdsManager;
            this.f7871g = nativeAdViewAttributes;
            this.f7867c = adViewProvider;
            this.f7868d = type;
            this.f7869e = i;
            PagerAdapter c2274a = new C2274a(this);
            this.f7870f = new C2275b(this, context);
            this.f7870f.setAdapter(c2274a);
            setInset(DEFAULT_INSET);
            c2274a.m8629a();
            addView(this.f7870f);
        }
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, Type type) {
        this(context, nativeAdsManager, null, type, new NativeAdViewAttributes(), DEFAULT_MAX_ADS);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, null, type, nativeAdViewAttributes, DEFAULT_MAX_ADS);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, Type type, NativeAdViewAttributes nativeAdViewAttributes, int i) {
        this(context, nativeAdsManager, null, type, nativeAdViewAttributes, i);
    }

    public void setInset(int i) {
        if (i > 0) {
            DisplayMetrics displayMetrics = this.f7865a.getResources().getDisplayMetrics();
            int round = Math.round(((float) i) * displayMetrics.density);
            this.f7870f.setPadding(round, 0, round, 0);
            this.f7870f.setPageMargin(Math.round(displayMetrics.density * ((float) (i / 2))));
            this.f7870f.setClipToPadding(false);
        }
    }
}
