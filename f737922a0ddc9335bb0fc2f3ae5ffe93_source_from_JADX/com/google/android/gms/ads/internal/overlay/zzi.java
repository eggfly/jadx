package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.internal.eh;

@eh
@TargetApi(14)
public abstract class zzi extends TextureView {
    public zzi(Context context) {
        super(context);
    }

    public abstract void DW();

    public abstract void FH();

    public abstract void Hw();

    public abstract void Zo();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract String j6();

    public abstract void j6(float f);

    public abstract void j6(float f, float f2);

    public abstract void j6(int i);

    public abstract void j6(g gVar);

    public abstract void setMimeType(String str);

    public abstract void setVideoPath(String str);

    public abstract void v5();
}
