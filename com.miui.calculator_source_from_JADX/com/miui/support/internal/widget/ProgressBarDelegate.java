package com.miui.support.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_AnimatedRotateDrawable_class;
import com.miui.support.internal.variable.Android_Graphics_Drawable_AnimatedRotateDrawable_class.Factory;
import com.miui.support.internal.variable.Android_Graphics_Drawable_StateListDrawable_class;
import com.miui.support.reflect.Method;
import com.miui.support.util.ViewUtils;

public class ProgressBarDelegate {
    private static final Method f3166a;
    private static final Method f3167b;
    private static final Method f3168c;
    private static final Method f3169d;
    private static final Android_Graphics_Drawable_AnimatedRotateDrawable_class f3170e;
    private static final Android_Graphics_Drawable_StateListDrawable_class f3171f;
    private final ProgressBar f3172g;
    private final Class<? extends ProgressBar> f3173h;
    private boolean f3174i;
    private Drawable f3175j;
    private Drawable f3176k;
    private boolean f3177l;
    private Drawable f3178m;
    private boolean f3179n;
    private float f3180o;

    static {
        f3166a = Method.of(ProgressBar.class, "setIndeterminate", "(Z)V");
        f3167b = Method.of(ProgressBar.class, "setIndeterminateDrawable", "(Landroid/graphics/drawable/Drawable;)V");
        f3168c = Method.of(ProgressBar.class, "setProgressDrawable", "(Landroid/graphics/drawable/Drawable;)V");
        f3169d = Method.of(ProgressBar.class, "onSizeChanged", "(IIII)V");
        f3170e = Factory.getInstance().get();
        f3171f = Android_Graphics_Drawable_StateListDrawable_class.Factory.getInstance().get();
    }

    private ProgressBarDelegate(ProgressBar progressBar, Class<? extends ProgressBar> cls) {
        this.f3174i = false;
        this.f3172g = progressBar;
        this.f3173h = cls;
    }

    public void m4857a(AttributeSet attributeSet, int i) {
        Context context = this.f3172g.getContext();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.ProgressBar, i, 0);
        Drawable drawable = this.f3178m;
        if (drawable != null && drawable.getClass().getName().equals(Android_Graphics_Drawable_AnimatedRotateDrawable_class.NAME)) {
            f3170e.setFramesCount(drawable, obtainStyledAttributes.getInt(C0264R.styleable.ProgressBar_indeterminateFramesCount, 48));
            f3170e.setFramesDuration(drawable, obtainStyledAttributes.getInt(C0264R.styleable.ProgressBar_indeterminateFramesDuration, 25));
        }
        this.f3174i = true;
        drawable = obtainStyledAttributes.getDrawable(C0264R.styleable.ProgressBar_progressMask);
        if (drawable != null) {
            m4851d(drawable);
            m4861c(drawable);
        } else {
            m4849c();
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842803}, 0, 0);
        this.f3180o = obtainStyledAttributes2.getFloat(0, 0.5f);
        obtainStyledAttributes2.recycle();
    }

    public void m4858a(boolean z) {
        if (z != this.f3172g.isIndeterminate()) {
            m4848b(z);
            m4850c(z);
        }
    }

    public void m4856a(Drawable drawable) {
        if (this.f3176k != drawable) {
            this.f3176k = drawable;
            this.f3177l = true;
            m4849c();
        }
    }

    public void m4860b(Drawable drawable) {
        if (this.f3178m != drawable) {
            this.f3178m = drawable;
            this.f3179n = true;
            m4849c();
        }
    }

    public synchronized void m4861c(Drawable drawable) {
        if (this.f3175j != drawable) {
            this.f3175j = drawable;
            this.f3177l = true;
            this.f3179n = true;
            m4849c();
        }
    }

    public Drawable m4854a() {
        return this.f3175j;
    }

    public void m4855a(int i, int i2, int i3, int i4) {
        this.f3177l = true;
        this.f3179n = true;
        m4849c();
        m4847b(i, i2, i3, i4);
    }

    public void m4859b() {
        boolean isEnabled = this.f3172g.isEnabled();
        if (!isEnabled) {
            this.f3172g.getProgressDrawable().setAlpha(255);
        }
        this.f3172g.setAlpha(isEnabled ? 1.0f : this.f3180o);
    }

    private void m4849c() {
        m4848b(this.f3172g.isIndeterminate());
    }

    private void m4848b(boolean z) {
        if (this.f3174i) {
            int i;
            ProgressBar progressBar = this.f3172g;
            int height = (progressBar.getHeight() - progressBar.getPaddingTop()) - progressBar.getPaddingBottom();
            int width = (progressBar.getWidth() - progressBar.getPaddingLeft()) - progressBar.getPaddingRight();
            if (height < width) {
                i = width;
            } else {
                i = height;
                height = width;
            }
            if (this.f3175j != null) {
                this.f3175j.setBounds(0, 0, i, height);
            }
            if (z && this.f3179n) {
                this.f3179n = true;
                Drawable a = m4845a(progressBar.getResources(), this.f3178m, this.f3175j, i, height, true);
                if (a != null && i > 0 && height > 0) {
                    if (ViewUtils.m5452a(this.f3172g)) {
                        width = i - i;
                        i -= 0;
                    } else {
                        width = 0;
                    }
                    a.setBounds(width, 0, i, height);
                }
                m4852e(a);
            } else if (!z && this.f3177l) {
                this.f3177l = true;
                m4853f(m4845a(progressBar.getResources(), this.f3176k, this.f3175j, i, height, false));
            }
        }
    }

    private static Drawable m4845a(Resources resources, Drawable drawable, Drawable drawable2, int i, int i2, boolean z) {
        int i3 = 0;
        if ((drawable instanceof NinePatchDrawable) || (drawable instanceof BitmapDrawable)) {
            return new ClipDrawable(m4844a(resources, drawable, drawable2, i, i2), 8388611, 1);
        }
        Drawable a;
        if (drawable instanceof ClipDrawable) {
            a = m4844a(resources, drawable, drawable2, i, i2);
            if (a != drawable) {
                return new ClipDrawable(a, 8388611, 1);
            }
            return a;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            r8 = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[r8];
            for (int i4 = 0; i4 < r8; i4++) {
                int id = layerDrawable.getId(i4);
                Drawable drawable3 = layerDrawable.getDrawable(i4);
                if (id == 16908301 || id == 16908303) {
                    drawableArr[i4] = m4845a(resources, drawable3, drawable2, i, i2, z);
                } else {
                    drawableArr[i4] = drawable3;
                }
            }
            a = new LayerDrawable(drawableArr);
            while (i3 < r8) {
                a.setId(i3, layerDrawable.getId(i3));
                i3++;
            }
            return a;
        } else if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            r6 = new StateListDrawable();
            r8 = f3171f.getStateCount(stateListDrawable);
            while (i3 < r8) {
                r6.addState(f3171f.getStateSet(stateListDrawable, i3), m4845a(resources, f3171f.getStateDrawable(stateListDrawable, i3), drawable2, i, i2, z));
                i3++;
            }
            return r6;
        } else if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            r8 = animationDrawable.getNumberOfFrames();
            r6 = new AnimationDrawable();
            r6.setOneShot(animationDrawable.isOneShot());
            while (i3 < r8) {
                a = m4845a(resources, animationDrawable.getFrame(i3), drawable2, i, i2, z);
                a.setLevel(10000);
                r6.addFrame(a, animationDrawable.getDuration(i3));
                i3++;
            }
            if (z) {
                r6.setLevel(10000);
            } else {
                r6.setLevel(animationDrawable.getLevel());
            }
            return r6;
        } else {
            Log.w("ProgressBarDelegate", "Unknown Drawable subclass, src=" + drawable);
            return drawable;
        }
    }

    private static Drawable m4844a(Resources resources, Drawable drawable, Drawable drawable2, int i, int i2) {
        if (drawable == null || drawable2 == null || i <= 0 || i2 <= 0) {
            return drawable;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        drawable.setLevel(10000);
        drawable.setBounds(0, 0, i, i2);
        drawable.draw(canvas);
        drawable2.draw(canvas);
        return new BitmapDrawable(resources, createBitmap);
    }

    private void m4851d(Drawable drawable) {
        Paint paint = null;
        if (drawable instanceof NinePatchDrawable) {
            paint = ((NinePatchDrawable) drawable).getPaint();
        } else if (drawable instanceof BitmapDrawable) {
            paint = ((BitmapDrawable) drawable).getPaint();
        }
        if (paint != null) {
            paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        } else {
            Log.w("ProgressBarDelegate", "The drawable should be NinePatchDrawable or BitmapDrawable. drawable=" + drawable);
        }
    }

    public static ProgressBarDelegate m4846a(ProgressBar progressBar, Class<? extends ProgressBar> cls) {
        return new ProgressBarDelegate(progressBar, cls);
    }

    private void m4850c(boolean z) {
        f3166a.invoke(this.f3173h, this.f3172g, Boolean.valueOf(z));
    }

    private void m4852e(Drawable drawable) {
        f3167b.invoke(this.f3173h, this.f3172g, drawable);
    }

    private void m4853f(Drawable drawable) {
        f3168c.invoke(this.f3173h, this.f3172g, drawable);
    }

    private void m4847b(int i, int i2, int i3, int i4) {
        f3169d.invoke(this.f3173h, this.f3172g, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
