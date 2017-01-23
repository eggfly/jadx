package android.support.v4.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public abstract class RoundedBitmapDrawable extends Drawable {
    final Bitmap f460a;
    final Rect f461b;
    private int f462c;
    private final Paint f463d;
    private final BitmapShader f464e;
    private final Matrix f465f;
    private float f466g;
    private final RectF f467h;
    private boolean f468i;
    private boolean f469j;
    private int f470k;
    private int f471l;

    public void setFilterBitmap(boolean z) {
        this.f463d.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f463d.setDither(z);
        invalidateSelf();
    }

    void m598a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    void m597a() {
        if (this.f468i) {
            if (this.f469j) {
                int min = Math.min(this.f470k, this.f471l);
                m598a(this.f462c, min, min, getBounds(), this.f461b);
                int min2 = Math.min(this.f461b.width(), this.f461b.height());
                this.f461b.inset(Math.max(0, (this.f461b.width() - min2) / 2), Math.max(0, (this.f461b.height() - min2) / 2));
                this.f466g = ((float) min2) * 0.5f;
            } else {
                m598a(this.f462c, this.f470k, this.f471l, getBounds(), this.f461b);
            }
            this.f467h.set(this.f461b);
            if (this.f464e != null) {
                this.f465f.setTranslate(this.f467h.left, this.f467h.top);
                this.f465f.preScale(this.f467h.width() / ((float) this.f460a.getWidth()), this.f467h.height() / ((float) this.f460a.getHeight()));
                this.f464e.setLocalMatrix(this.f465f);
                this.f463d.setShader(this.f464e);
            }
            this.f468i = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f460a;
        if (bitmap != null) {
            m597a();
            if (this.f463d.getShader() == null) {
                canvas.drawBitmap(bitmap, null, this.f461b, this.f463d);
            } else {
                canvas.drawRoundRect(this.f467h, this.f466g, this.f466g, this.f463d);
            }
        }
    }

    public void setAlpha(int i) {
        if (i != this.f463d.getAlpha()) {
            this.f463d.setAlpha(i);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f463d.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f463d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.f463d.getColorFilter();
    }

    private void m596c() {
        this.f466g = (float) (Math.min(this.f471l, this.f470k) / 2);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f469j) {
            m596c();
        }
        this.f468i = true;
    }

    public float m599b() {
        return this.f466g;
    }

    public int getIntrinsicWidth() {
        return this.f470k;
    }

    public int getIntrinsicHeight() {
        return this.f471l;
    }

    public int getOpacity() {
        if (this.f462c != 119 || this.f469j) {
            return -3;
        }
        Bitmap bitmap = this.f460a;
        if (bitmap == null || bitmap.hasAlpha() || this.f463d.getAlpha() < 255 || m595a(this.f466g)) {
            return -3;
        }
        return -1;
    }

    private static boolean m595a(float f) {
        return f > 0.05f;
    }
}
