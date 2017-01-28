package com.baidu.mobads;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.production.p098a.C2029a;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AdView extends RelativeLayout {
    protected static final String P_VERSION = "3.61";
    IOAdEventListener f6613a;
    private AtomicBoolean f6614b;
    private C2029a f6615c;
    private AdViewListener f6616d;

    public AdView(Context context) {
        super(context);
        this.f6614b = new AtomicBoolean(false);
        this.f6613a = new C1909a(this);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z, AdSize adSize, String str) {
        super(context, attributeSet);
        this.f6614b = new AtomicBoolean(false);
        this.f6613a = new C1909a(this);
        View alVar = new al(context);
        this.f6615c = new C2029a(context, alVar, str, z);
        this.f6615c.addEventListener(IXAdEvent.AD_LOADED, this.f6613a);
        this.f6615c.addEventListener(IXAdEvent.AD_ERROR, this.f6613a);
        this.f6615c.addEventListener(IXAdEvent.AD_STARTED, this.f6613a);
        this.f6615c.addEventListener("AdUserClick", this.f6613a);
        alVar.m7214a(new C1919c(this));
        addView(alVar, new LayoutParams(-1, -1));
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    AdView(Context context, boolean z, AdSize adSize, String str) {
        this(context, null, z, adSize, str);
    }

    private void m7181a() {
        if (!this.f6614b.get()) {
            this.f6614b.set(true);
            this.f6615c.request();
        }
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        C1991m.m7449a().m7464m().setAppId(str);
    }

    public void destroy() {
        this.f6615c.m7594k();
    }

    @Deprecated
    public void setAlpha(float f) {
    }

    @Deprecated
    public void setBackgroundColor(int i) {
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        C1991m.m7449a().m7457f().m7396d("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        C1991m.m7449a().m7457f().m7396d("AdView.setLayoutParams", Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f));
        if (i <= 0) {
            i = Math.min(i3, i4);
        } else if (i > 0 && ((float) i) < 200.0f * f) {
            i = (int) (200.0f * f);
        }
        int min = i2 <= 0 ? (int) (((float) Math.min(i3, i4)) * 0.15f) : (i2 <= 0 || ((float) i2) >= 30.0f * f) ? i2 : (int) (30.0f * f);
        layoutParams.width = i;
        layoutParams.height = min;
        C1991m.m7449a().m7457f().m7396d("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        this.f6616d = adViewListener;
    }
}
