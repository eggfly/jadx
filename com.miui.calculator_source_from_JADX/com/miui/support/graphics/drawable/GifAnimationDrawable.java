package com.miui.support.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.SystemClock;
import com.miui.support.internal.graphics.gif.DecodeGifImageHelper;
import com.miui.support.internal.graphics.gif.DecodeGifImageHelper.GifFrame;
import java.util.ArrayList;

public class GifAnimationDrawable extends AnimationDrawable {
    private final DecodeGifImageHelper f2013a;
    private Resources f2014b;
    private DrawableContainerState f2015c;
    private ArrayList<Integer> f2016d;
    private ArrayList<Integer> f2017e;
    private int f2018f;

    public GifAnimationDrawable() {
        this.f2013a = new DecodeGifImageHelper();
        this.f2016d = new ArrayList();
        this.f2017e = new ArrayList();
    }

    public final boolean selectDrawable(int i) {
        m3491a(i);
        this.f2018f = i;
        return super.selectDrawable(i);
    }

    private void m3491a(int i) {
        if (!this.f2013a.f2370b.isEmpty()) {
            GifFrame gifFrame = (GifFrame) this.f2013a.f2370b.get(0);
            if (this.f2013a.f2370b.size() > 1) {
                this.f2013a.f2370b.remove(0);
            }
            this.f2013a.m3966a();
            this.f2015c.getChildren()[i] = new BitmapDrawable(this.f2014b, gifFrame.f2366a);
            this.f2016d.add(i, Integer.valueOf(gifFrame.f2367b));
        }
    }

    protected final void setConstantState(DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        this.f2015c = drawableContainerState;
    }

    public final int getDuration(int i) {
        return ((Integer) this.f2016d.get(i)).intValue();
    }

    public final void addFrame(Drawable drawable, int i) {
        super.addFrame(drawable, i);
        this.f2016d.add(Integer.valueOf(i));
        this.f2017e.add(Integer.valueOf(i));
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (j == ((long) ((Integer) this.f2017e.get(this.f2018f)).intValue()) + SystemClock.uptimeMillis()) {
            j = SystemClock.uptimeMillis() + ((long) ((Integer) this.f2016d.get(this.f2018f)).intValue());
        }
        super.scheduleSelf(runnable, j);
    }
}
