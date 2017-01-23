package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.C0420R;

class aw extends Drawable {
    static final double f1902a;
    static C0556a f1903c;
    final int f1904b;
    Paint f1905d;
    Paint f1906e;
    Paint f1907f;
    final RectF f1908g;
    float f1909h;
    Path f1910i;
    float f1911j;
    float f1912k;
    float f1913l;
    float f1914m;
    private boolean f1915n;
    private final int f1916o;
    private final int f1917p;
    private boolean f1918q;
    private boolean f1919r;

    /* renamed from: android.support.v7.widget.aw.a */
    interface C0556a {
        void m2185a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    static {
        f1902a = Math.cos(Math.toRadians(45.0d));
    }

    aw(Resources resources, int i, float f, float f2, float f3) {
        this.f1915n = true;
        this.f1918q = true;
        this.f1919r = false;
        this.f1916o = resources.getColor(C0420R.color.cardview_shadow_start_color);
        this.f1917p = resources.getColor(C0420R.color.cardview_shadow_end_color);
        this.f1904b = resources.getDimensionPixelSize(C0420R.dimen.cardview_compat_inset_shadow);
        this.f1905d = new Paint(5);
        this.f1905d.setColor(i);
        this.f1906e = new Paint(5);
        this.f1906e.setStyle(Style.FILL);
        this.f1909h = (float) ((int) (0.5f + f));
        this.f1908g = new RectF();
        this.f1907f = new Paint(this.f1906e);
        this.f1907f.setAntiAlias(false);
        m2442a(f2, f3);
    }

    static float m2434a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f1902a) * ((double) f2))) : 1.5f * f;
    }

    private void m2435a(Canvas canvas) {
        float f = (-this.f1909h) - this.f1913l;
        float f2 = (this.f1909h + ((float) this.f1904b)) + (this.f1914m / 2.0f);
        Object obj = this.f1908g.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f1908g.height() - (2.0f * f2) > 0.0f ? 1 : null;
        int save = canvas.save();
        canvas.translate(this.f1908g.left + f2, this.f1908g.top + f2);
        canvas.drawPath(this.f1910i, this.f1906e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f1908g.width() - (2.0f * f2), -this.f1909h, this.f1907f);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.f1908g.right - f2, this.f1908g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1910i, this.f1906e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f1908g.width() - (2.0f * f2), this.f1913l + (-this.f1909h), this.f1907f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f1908g.left + f2, this.f1908g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1910i, this.f1906e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f1908g.height() - (2.0f * f2), -this.f1909h, this.f1907f);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f1908g.right - f2, this.f1908g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1910i, this.f1906e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f1908g.height() - (2.0f * f2), -this.f1909h, this.f1907f);
        }
        canvas.restoreToCount(save2);
    }

    static float m2436b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f1902a) * ((double) f2))) : f;
    }

    private void m2437b(Rect rect) {
        float f = this.f1912k * 1.5f;
        this.f1908g.set(((float) rect.left) + this.f1912k, ((float) rect.top) + f, ((float) rect.right) - this.f1912k, ((float) rect.bottom) - f);
        m2439f();
    }

    private int m2438d(float f) {
        int i = (int) (0.5f + f);
        return i % 2 == 1 ? i - 1 : i;
    }

    private void m2439f() {
        RectF rectF = new RectF(-this.f1909h, -this.f1909h, this.f1909h, this.f1909h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f1913l, -this.f1913l);
        if (this.f1910i == null) {
            this.f1910i = new Path();
        } else {
            this.f1910i.reset();
        }
        this.f1910i.setFillType(FillType.EVEN_ODD);
        this.f1910i.moveTo(-this.f1909h, 0.0f);
        this.f1910i.rLineTo(-this.f1913l, 0.0f);
        this.f1910i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1910i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1910i.close();
        float f = this.f1909h / (this.f1909h + this.f1913l);
        float[] fArr = new float[]{0.0f, f, 1.0f};
        f = 0.0f;
        this.f1906e.setShader(new RadialGradient(0.0f, f, this.f1909h + this.f1913l, new int[]{this.f1916o, this.f1916o, this.f1917p}, fArr, TileMode.CLAMP));
        float f2 = 0.0f;
        this.f1907f.setShader(new LinearGradient(0.0f, (-this.f1909h) + this.f1913l, f2, (-this.f1909h) - this.f1913l, new int[]{this.f1916o, this.f1916o, this.f1917p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f1907f.setAntiAlias(false);
    }

    float m2440a() {
        return this.f1909h;
    }

    void m2441a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (this.f1909h != f2) {
            this.f1909h = f2;
            this.f1915n = true;
            invalidateSelf();
        }
    }

    void m2442a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float d = (float) m2438d(f);
            float d2 = (float) m2438d(f2);
            if (d > d2) {
                if (!this.f1919r) {
                    this.f1919r = true;
                }
                d = d2;
            }
            if (this.f1914m != d || this.f1912k != d2) {
                this.f1914m = d;
                this.f1912k = d2;
                this.f1913l = (float) ((int) (((d * 1.5f) + ((float) this.f1904b)) + 0.5f));
                this.f1911j = ((float) this.f1904b) + d2;
                this.f1915n = true;
                invalidateSelf();
            }
        }
    }

    public void m2443a(int i) {
        this.f1905d.setColor(i);
        invalidateSelf();
    }

    void m2444a(Rect rect) {
        getPadding(rect);
    }

    public void m2445a(boolean z) {
        this.f1918q = z;
        invalidateSelf();
    }

    float m2446b() {
        return this.f1914m;
    }

    void m2447b(float f) {
        m2442a(f, this.f1912k);
    }

    float m2448c() {
        return this.f1912k;
    }

    void m2449c(float f) {
        m2442a(this.f1914m, f);
    }

    float m2450d() {
        return (Math.max(this.f1912k, (this.f1909h + ((float) this.f1904b)) + (this.f1912k / 2.0f)) * 2.0f) + ((this.f1912k + ((float) this.f1904b)) * 2.0f);
    }

    public void draw(Canvas canvas) {
        if (this.f1915n) {
            m2437b(getBounds());
            this.f1915n = false;
        }
        canvas.translate(0.0f, this.f1914m / 2.0f);
        m2435a(canvas);
        canvas.translate(0.0f, (-this.f1914m) / 2.0f);
        f1903c.m2185a(canvas, this.f1908g, this.f1909h, this.f1905d);
    }

    float m2451e() {
        return (Math.max(this.f1912k, (this.f1909h + ((float) this.f1904b)) + ((this.f1912k * 1.5f) / 2.0f)) * 2.0f) + (((this.f1912k * 1.5f) + ((float) this.f1904b)) * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m2434a(this.f1912k, this.f1909h, this.f1918q));
        int ceil2 = (int) Math.ceil((double) m2436b(this.f1912k, this.f1909h, this.f1918q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1915n = true;
    }

    public void setAlpha(int i) {
        this.f1905d.setAlpha(i);
        this.f1906e.setAlpha(i);
        this.f1907f.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1905d.setColorFilter(colorFilter);
    }
}
