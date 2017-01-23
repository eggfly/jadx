package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class av extends Drawable {
    private float f1892a;
    private final Paint f1893b;
    private final RectF f1894c;
    private final Rect f1895d;
    private float f1896e;
    private boolean f1897f;
    private boolean f1898g;
    private PorterDuffColorFilter f1899h;
    private ColorStateList f1900i;
    private Mode f1901j;

    public av(int i, float f) {
        this.f1897f = false;
        this.f1898g = true;
        this.f1901j = Mode.SRC_IN;
        this.f1892a = f;
        this.f1893b = new Paint(5);
        this.f1893b.setColor(i);
        this.f1894c = new RectF();
        this.f1895d = new Rect();
    }

    private PorterDuffColorFilter m2427a(ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void m2428a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1894c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1895d.set(rect);
        if (this.f1897f) {
            float a = aw.m2434a(this.f1896e, this.f1892a, this.f1898g);
            this.f1895d.inset((int) Math.ceil((double) aw.m2436b(this.f1896e, this.f1892a, this.f1898g)), (int) Math.ceil((double) a));
            this.f1894c.set(this.f1895d);
        }
    }

    float m2429a() {
        return this.f1896e;
    }

    void m2430a(float f) {
        if (f != this.f1892a) {
            this.f1892a = f;
            m2428a(null);
            invalidateSelf();
        }
    }

    void m2431a(float f, boolean z, boolean z2) {
        if (f != this.f1896e || this.f1897f != z || this.f1898g != z2) {
            this.f1896e = f;
            this.f1897f = z;
            this.f1898g = z2;
            m2428a(null);
            invalidateSelf();
        }
    }

    public void m2432a(int i) {
        this.f1893b.setColor(i);
        invalidateSelf();
    }

    public float m2433b() {
        return this.f1892a;
    }

    public void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.f1893b;
        if (this.f1899h == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.f1899h);
            obj = 1;
        }
        canvas.drawRoundRect(this.f1894c, this.f1892a, this.f1892a, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1895d, this.f1892a);
    }

    public boolean isStateful() {
        return (this.f1900i != null && this.f1900i.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m2428a(rect);
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f1900i == null || this.f1901j == null) {
            return false;
        }
        this.f1899h = m2427a(this.f1900i, this.f1901j);
        return true;
    }

    public void setAlpha(int i) {
        this.f1893b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1893b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1900i = colorStateList;
        this.f1899h = m2427a(this.f1900i, this.f1901j);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f1901j = mode;
        this.f1899h = m2427a(this.f1900i, this.f1901j);
        invalidateSelf();
    }
}
