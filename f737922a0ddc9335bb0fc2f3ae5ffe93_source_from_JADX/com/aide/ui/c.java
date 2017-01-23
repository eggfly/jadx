package com.aide.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RoundRectShape;

public class c extends Drawable {
    private MainActivity j6;

    public c(MainActivity mainActivity) {
        this.j6 = mainActivity;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        float f = this.j6.getResources().getDisplayMetrics().density;
        float EQ = this.j6.EQ();
        float f2 = 2.0f * f;
        float f3 = 3.0f * f;
        Paint paint = new Paint(1);
        paint.setShadowLayer(2.0f * f, -f2, f2, this.j6.getResources().getColor(2131230741));
        paint.setColor(this.j6.getResources().getColor(2131230739));
        j6(canvas, EQ + f3, ((float) bounds.top) - f3, ((float) bounds.right) + f3, ((float) bounds.bottom) - f3, 0.0f, 0.0f, 13.0f * f, 0.0f, paint);
    }

    private void j6(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, Paint paint) {
        canvas.save(1);
        RoundRectShape roundRectShape = new RoundRectShape(new float[]{f5, f5, f6, f6, f8, f8, f7, f7}, null, null);
        roundRectShape.resize(f3 - f, f4 - f2);
        canvas.translate(f, f2);
        roundRectShape.draw(canvas, paint);
        canvas.restore();
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }
}
