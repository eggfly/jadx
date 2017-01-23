package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@TargetApi(14)
/* renamed from: com.google.android.gms.ads.internal.overlay.i */
public abstract class C2854i extends TextureView {
    public C2854i(Context context) {
        super(context);
    }

    public abstract String m11048a();

    public abstract void m11049a(float f);

    public abstract void m11050a(int i);

    public abstract void m11051a(C2867h c2867h);

    public abstract void m11052b();

    public abstract void m11053c();

    public abstract void m11054d();

    public abstract void m11055e();

    public abstract void m11056f();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setMimeType(String str);

    public abstract void setVideoPath(String str);
}
