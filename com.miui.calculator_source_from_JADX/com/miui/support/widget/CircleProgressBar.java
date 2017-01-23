package com.miui.support.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

public class CircleProgressBar extends ProgressBar {
    private RectF f3998a;
    private Path f3999b;
    private Animator f4000c;
    private int[] f4001d;
    private Drawable[] f4002e;
    private Drawable[] f4003f;
    private Drawable[] f4004g;
    private OnProgressChangedListener f4005h;
    private int f4006i;
    private Bitmap f4007j;
    private Canvas f4008k;
    private Paint f4009l;
    private int f4010m;
    private int f4011n;
    private int f4012o;
    private Drawable f4013p;

    public interface OnProgressChangedListener {
        void m5710a();
    }

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3999b = new Path();
        this.f4012o = 300;
        setIndeterminate(false);
        this.f4009l = new Paint();
        this.f4009l.setColor(-16777216);
    }

    public void setProgressLevels(int[] iArr) {
        this.f4001d = iArr;
    }

    public int getProgressLevelCount() {
        return this.f4001d == null ? 1 : this.f4001d.length + 1;
    }

    private Drawable m5711a(int i) {
        return this.f4002e == null ? null : this.f4002e[i];
    }

    private Drawable m5713b(int i) {
        return this.f4003f == null ? null : this.f4003f[i];
    }

    private Drawable m5714c(int i) {
        return this.f4004g == null ? null : this.f4004g[i];
    }

    public void setRotateVelocity(int i) {
        this.f4012o = i;
    }

    public void setProgressByAnimator(int i) {
        m5717a(i, null);
    }

    public void setOnProgressChangedListener(OnProgressChangedListener onProgressChangedListener) {
        this.f4005h = onProgressChangedListener;
    }

    public void m5717a(int i, AnimatorListener animatorListener) {
        m5716a();
        int abs = Math.abs((int) ((((float) (i - getProgress())) / ((float) getMax())) * 360.0f));
        this.f4000c = ObjectAnimator.ofInt(this, "progress", new int[]{i});
        this.f4000c.setDuration((long) m5715d(abs));
        this.f4000c.setInterpolator(getInterpolator());
        if (animatorListener != null) {
            this.f4000c.addListener(animatorListener);
        }
        this.f4000c.start();
    }

    public void m5716a() {
        if (this.f4000c != null && this.f4000c.isRunning()) {
            this.f4000c.cancel();
        }
    }

    private int m5715d(int i) {
        return (i * 1000) / this.f4012o;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int progressLevelCount = getProgressLevelCount();
        for (int i = 0; i < progressLevelCount; i++) {
            if (this.f4002e != null) {
                this.f4002e[i].setState(getDrawableState());
            }
            if (this.f4003f != null) {
                this.f4003f[i].setState(getDrawableState());
            }
            if (this.f4004g != null) {
                this.f4004g[i].setState(getDrawableState());
            }
        }
        invalidate();
    }

    public synchronized void setProgress(int i) {
        int i2 = 0;
        synchronized (this) {
            super.setProgress(i);
            if (this.f4001d != null) {
                int length = this.f4001d.length;
                while (i2 < length) {
                    if (i < this.f4001d[i2]) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
                if (i2 == -1) {
                    i2 = length;
                }
            }
            if (i2 != this.f4006i) {
                this.f4010m = this.f4006i;
                this.f4006i = i2;
                setPrevAlpha(255);
                Animator ofInt = ObjectAnimator.ofInt(this, "prevAlpha", new int[]{0});
                ofInt.setDuration(300);
                ofInt.setInterpolator(new LinearInterpolator());
                ofInt.start();
            }
            if (this.f4005h != null) {
                this.f4005h.m5710a();
            }
        }
    }

    private float getRate() {
        return ((float) getProgress()) / ((float) getMax());
    }

    private int getIntrinsicWidth() {
        int intrinsicWidth = m5713b(0).getIntrinsicWidth();
        if (this.f4004g != null) {
            intrinsicWidth = Math.max(intrinsicWidth, this.f4004g[0].getIntrinsicWidth());
        }
        if (this.f4002e != null) {
            return Math.max(intrinsicWidth, this.f4002e[0].getIntrinsicWidth());
        }
        return intrinsicWidth;
    }

    private int getIntrinsicHeight() {
        int intrinsicHeight = m5713b(0).getIntrinsicHeight();
        if (this.f4004g != null) {
            intrinsicHeight = Math.max(intrinsicHeight, this.f4004g[0].getIntrinsicHeight());
        }
        if (this.f4002e != null) {
            return Math.max(intrinsicHeight, this.f4002e[0].getIntrinsicHeight());
        }
        return intrinsicHeight;
    }

    protected synchronized void onMeasure(int i, int i2) {
        setMeasuredDimension(getIntrinsicWidth(), getIntrinsicHeight());
    }

    protected synchronized void onDraw(Canvas canvas) {
        m5712a(canvas, m5711a(this.f4006i), m5714c(this.f4006i), m5713b(this.f4006i), getRate(), 255 - this.f4011n);
        if (this.f4011n >= 10) {
            m5712a(canvas, m5711a(this.f4010m), m5714c(this.f4010m), m5713b(this.f4010m), getRate(), this.f4011n);
        }
    }

    private void m5712a(Canvas canvas, Drawable drawable, Drawable drawable2, Drawable drawable3, float f, int i) {
        if (drawable != null) {
            drawable.setAlpha(i);
            drawable.draw(canvas);
        }
        if (canvas.isHardwareAccelerated()) {
            canvas.saveLayer((float) drawable3.getBounds().left, (float) drawable3.getBounds().top, (float) drawable3.getBounds().right, (float) drawable3.getBounds().bottom, null, 16);
            this.f4009l.setStyle(Style.STROKE);
            this.f4009l.setStrokeWidth((float) drawable3.getBounds().width());
            this.f3999b.reset();
            this.f3999b.addArc(this.f3998a, -90.0f, 360.0f * f);
            canvas.drawPath(this.f3999b, this.f4009l);
            this.f4009l.setStyle(Style.FILL);
            this.f4009l.setStrokeWidth(0.0f);
            drawable3.setAlpha(i);
            drawable3.draw(canvas);
            canvas.restore();
        } else {
            if (this.f4007j == null) {
                this.f4007j = Bitmap.createBitmap(drawable3.getBounds().width(), drawable3.getBounds().height(), Config.ARGB_8888);
                this.f4008k = new Canvas(this.f4007j);
            }
            this.f4007j.eraseColor(0);
            this.f4008k.save();
            this.f4008k.translate((float) (-drawable3.getBounds().left), (float) (-drawable3.getBounds().top));
            this.f4008k.drawArc(this.f3998a, -90.0f, 360.0f * f, true, this.f4009l);
            drawable3.setAlpha(i);
            drawable3.draw(this.f4008k);
            this.f4008k.restore();
            canvas.drawBitmap(this.f4007j, (float) drawable3.getBounds().left, (float) drawable3.getBounds().top, null);
        }
        Drawable drawable4 = this.f4013p;
        if (drawable4 != null) {
            canvas.save();
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2;
            int height = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2;
            int intrinsicWidth = drawable4.getIntrinsicWidth();
            int intrinsicHeight = drawable4.getIntrinsicHeight();
            canvas.rotate((360.0f * ((float) getProgress())) / ((float) getMax()), (float) width, (float) height);
            drawable4.setBounds(width - (intrinsicWidth / 2), height - (intrinsicHeight / 2), width + (intrinsicWidth / 2), height + (intrinsicHeight / 2));
            drawable4.draw(canvas);
            canvas.restore();
        }
        if (drawable2 != null) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
        }
    }

    public void setPrevAlpha(int i) {
        this.f4011n = i;
        invalidate();
    }

    public int getPrevAlpha() {
        return this.f4011n;
    }

    public void setThumb(int i) {
        setThumb(getResources().getDrawable(i));
    }

    public void setThumb(Drawable drawable) {
        this.f4013p = drawable;
    }
}
