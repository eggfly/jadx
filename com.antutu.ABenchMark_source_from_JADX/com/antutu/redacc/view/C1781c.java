package com.antutu.redacc.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.antutu.redacc.C1692R;

/* renamed from: com.antutu.redacc.view.c */
public class C1781c extends Drawable {
    private Context f6299a;
    private Paint f6300b;
    private Bitmap f6301c;
    private int f6302d;
    private int f6303e;
    private int f6304f;
    private float f6305g;
    private float f6306h;

    public C1781c(Context context) {
        this.f6302d = 0;
        this.f6303e = 450;
        this.f6304f = 0;
        this.f6305g = 1.0f;
        this.f6306h = 1.0f;
        this.f6299a = context;
        this.f6300b = new Paint();
        this.f6300b.setStyle(Style.FILL);
        this.f6300b.setColor(-1);
        this.f6301c = BitmapFactory.decodeResource(context.getResources(), C1692R.drawable.thermometer_mid);
        this.f6305g = ((float) this.f6301c.getWidth()) / 56.0f;
        this.f6306h = ((float) this.f6301c.getHeight()) / 116.0f;
    }

    public float m6861a() {
        float f = ((float) (this.f6304f - this.f6302d)) / ((float) (this.f6303e - this.f6302d));
        return f < 0.0f ? 0.0f : f > 1.0f ? 1.0f : f;
    }

    public Rect m6862a(Canvas canvas) {
        Rect rect = new Rect();
        rect.left = (int) (((double) (22.0f * this.f6305g)) + 0.5d);
        rect.top = (int) (((double) (((float) (((int) (60.0f * (1.0f - m6861a()))) + 4)) * this.f6306h)) + 0.5d);
        rect.right = (int) (((double) (32.0f * this.f6305g)) + 0.5d);
        rect.bottom = (int) (((double) (64.0f * this.f6306h)) + 0.5d);
        return rect;
    }

    public void m6863a(int i) {
        this.f6304f = i;
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.f6301c, 0.0f, 0.0f, this.f6300b);
        canvas.drawRect(m6862a(canvas), this.f6300b);
    }

    public int getIntrinsicHeight() {
        return this.f6301c.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.f6301c.getWidth();
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.f6300b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6300b.setColorFilter(colorFilter);
    }
}
