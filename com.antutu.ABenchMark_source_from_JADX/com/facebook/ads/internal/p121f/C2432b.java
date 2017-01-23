package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdView.Type;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.p121f.p131a.C2418b;
import com.facebook.ads.internal.p121f.p131a.C2420d;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.f.b */
public class C2432b extends RelativeLayout {
    private final NativeAdViewAttributes f8394a;
    private final NativeAd f8395b;
    private final DisplayMetrics f8396c;
    private ArrayList<View> f8397d;

    /* renamed from: com.facebook.ads.internal.f.b.1 */
    static /* synthetic */ class C24231 {
        static final /* synthetic */ int[] f8370a;

        static {
            f8370a = new int[Type.values().length];
            try {
                f8370a[Type.HEIGHT_400.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8370a[Type.HEIGHT_300.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8370a[Type.HEIGHT_100.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8370a[Type.HEIGHT_120.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public C2432b(Context context, NativeAd nativeAd, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        super(context);
        setBackgroundColor(nativeAdViewAttributes.getBackgroundColor());
        this.f8394a = nativeAdViewAttributes;
        this.f8395b = nativeAd;
        this.f8396c = context.getResources().getDisplayMetrics();
        setLayoutParams(new LayoutParams(-1, Math.round(((float) type.getHeight()) * this.f8396c.density)));
        View c2466m = new C2466m(context);
        c2466m.setMinWidth(Math.round(280.0f * this.f8396c.density));
        c2466m.setMaxWidth(Math.round(375.0f * this.f8396c.density));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        c2466m.setLayoutParams(layoutParams);
        addView(c2466m);
        ViewGroup linearLayout = new LinearLayout(context);
        this.f8397d = new ArrayList();
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        c2466m.addView(linearLayout);
        switch (C24231.f8370a[type.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m9303b(linearLayout);
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                break;
        }
        m9299a(linearLayout);
        m9300a(linearLayout, type);
        nativeAd.registerViewForInteraction(this, this.f8397d);
        View adChoicesView = new AdChoicesView(getContext(), nativeAd, true);
        LayoutParams layoutParams2 = (LayoutParams) adChoicesView.getLayoutParams();
        layoutParams2.addRule(11);
        layoutParams2.setMargins(Math.round(this.f8396c.density * 4.0f), Math.round(this.f8396c.density * 4.0f), Math.round(this.f8396c.density * 4.0f), Math.round(this.f8396c.density * 4.0f));
        c2466m.addView(adChoicesView);
    }

    private void m9299a(ViewGroup viewGroup) {
        View relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(this.f8396c.density * 180.0f)));
        relativeLayout.setBackgroundColor(this.f8394a.getBackgroundColor());
        View mediaView = new MediaView(getContext());
        relativeLayout.addView(mediaView);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, (int) (this.f8396c.density * 180.0f));
        layoutParams.addRule(13, -1);
        mediaView.setLayoutParams(layoutParams);
        mediaView.setAutoplay(this.f8394a.getAutoplay());
        mediaView.setNativeAd(this.f8395b);
        viewGroup.addView(relativeLayout);
        this.f8397d.add(mediaView);
    }

    private void m9300a(ViewGroup viewGroup, Type type) {
        View c2418b = new C2418b(getContext(), this.f8395b, this.f8394a, m9301a(type), m9302b(type));
        c2418b.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(((float) m9302b(type)) * this.f8396c.density)));
        viewGroup.addView(c2418b);
        this.f8397d.add(c2418b.getIconView());
        this.f8397d.add(c2418b.getCallToActionView());
    }

    private boolean m9301a(Type type) {
        return type == Type.HEIGHT_300 || type == Type.HEIGHT_120;
    }

    private int m9302b(Type type) {
        switch (C24231.f8370a[type.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return (type.getHeight() - 180) / 2;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return type.getHeight() - 180;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.QUIC /*4*/:
                return type.getHeight();
            default:
                return 0;
        }
    }

    private void m9303b(ViewGroup viewGroup) {
        View c2420d = new C2420d(getContext(), this.f8395b, this.f8394a);
        c2420d.setLayoutParams(new LinearLayout.LayoutParams(-1, Math.round(110.0f * this.f8396c.density)));
        viewGroup.addView(c2420d);
    }
}
