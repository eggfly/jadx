package com.google.android.gms.ads.p124b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.bh;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;

/* renamed from: com.google.android.gms.ads.b.c */
public abstract class C2705c extends FrameLayout {
    private final FrameLayout f9236a;
    private final bh f9237b;

    public C2705c(Context context) {
        super(context);
        this.f9236a = m10289b(context);
        this.f9237b = m10288a();
    }

    private bh m10288a() {
        C3512u.m14581a(this.f9236a, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return C2784w.m10745d().m11953a(this.f9236a.getContext(), this, this.f9236a);
    }

    private FrameLayout m10289b(Context context) {
        View a = m10291a(context);
        a.setLayoutParams(new LayoutParams(-1, -1));
        addView(a);
        return a;
    }

    protected View m10290a(String str) {
        try {
            C2687a a = this.f9237b.m10686a(str);
            if (a != null) {
                return (View) C2690b.m10263a(a);
            }
        } catch (Throwable e) {
            C2972b.m11580b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    FrameLayout m10291a(Context context) {
        return new FrameLayout(context);
    }

    protected void m10292a(String str, View view) {
        try {
            this.f9237b.m10689a(str, C2690b.m10262a((Object) view));
        } catch (Throwable e) {
            C2972b.m11580b("Unable to call setAssetView on delegate", e);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f9236a);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f9236a != view) {
            super.bringChildToFront(this.f9236a);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f9236a);
    }

    public void removeView(View view) {
        if (this.f9236a != view) {
            super.removeView(view);
        }
    }

    public void setNativeAd(C2701a c2701a) {
        try {
            this.f9237b.m10688a((C2687a) c2701a.m10277a());
        } catch (Throwable e) {
            C2972b.m11580b("Unable to call setNativeAd on delegate", e);
        }
    }
}
