package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.mobads.p080j.C1991m;
import com.xiaomi.pushsdk.BuildConfig;

public class AdService {
    protected static String channelId;
    protected static int instanceCount;
    private AdView f6570a;

    static {
        channelId = BuildConfig.FLAVOR;
        instanceCount = -1;
    }

    public AdService(Context context, ViewGroup viewGroup, LayoutParams layoutParams, AdViewListener adViewListener) {
        this(context, viewGroup, layoutParams, adViewListener, AdSize.Banner, BuildConfig.FLAVOR);
    }

    public AdService(Context context, ViewGroup viewGroup, LayoutParams layoutParams, AdViewListener adViewListener, AdSize adSize, String str) {
        if (context == null || viewGroup == null || layoutParams == null || adViewListener == null || adSize == null) {
            throw new IllegalArgumentException("One of arguments is null");
        }
        this.f6570a = new AdView(context, false, adSize, str);
        this.f6570a.setListener(adViewListener);
        m7176a(viewGroup, layoutParams);
        instanceCount++;
    }

    private void m7176a(ViewGroup viewGroup, LayoutParams layoutParams) {
        try {
            if (this.f6570a.getParent() != viewGroup) {
                if (this.f6570a.getParent() != null) {
                    ((ViewGroup) this.f6570a.getParent()).removeView(this.f6570a);
                }
                viewGroup.addView(this.f6570a, layoutParams);
            }
        } catch (Throwable e) {
            C1991m.m7449a().m7457f().m7395d(e);
        }
    }

    public static void setChannelId(String str) {
        channelId = str;
        C1991m.m7449a().m7464m().setChannelId(str);
    }

    public void destroy() {
        if (this.f6570a != null) {
            this.f6570a.destroy();
            this.f6570a = null;
        }
    }
}
