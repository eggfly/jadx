package com.gc.materialdesign.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.gc.materialdesign.p135a.C2514a;

public class ProgressBarCircularIndeterminateSingle extends C2515b {
    int f8655a;
    int f8656b;
    int f8657c;
    float f8658d;
    int f8659e;

    public ProgressBarCircularIndeterminateSingle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8655a = Color.parseColor("#1E88E5");
        this.f8656b = 1;
        this.f8657c = 0;
        this.f8658d = 0.0f;
        this.f8659e = 0;
        setAttributes(attributeSet);
    }

    private void m9531a(Canvas canvas) {
        if (this.f8657c == this.f8659e) {
            this.f8656b += 6;
        }
        if (this.f8656b >= 290 || this.f8657c > this.f8659e) {
            this.f8657c += 6;
            this.f8656b -= 6;
        }
        if (this.f8657c > this.f8659e + 290) {
            this.f8659e = this.f8657c;
            this.f8657c = this.f8659e;
            this.f8656b = 1;
        }
        this.f8658d += 4.0f;
        canvas.rotate(this.f8658d, (float) (getWidth() / 2), (float) (getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.f8655a);
        canvas2.drawArc(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), (float) this.f8657c, (float) this.f8656b, true, paint);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(getResources().getColor(17170445));
        paint2.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() / 2) - C2514a.m9521a(4.0f, getResources())), paint2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, new Paint());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m9531a(canvas);
        invalidate();
    }

    protected void setAttributes(AttributeSet attributeSet) {
        setMinimumHeight(C2514a.m9521a(32.0f, getResources()));
        setMinimumWidth(C2514a.m9521a(32.0f, getResources()));
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
        if (attributeResourceValue != -1) {
            setBackgroundColor(getResources().getColor(attributeResourceValue));
        } else {
            attributeResourceValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "background", -1);
            if (attributeResourceValue != -1) {
                setBackgroundColor(attributeResourceValue);
            } else {
                setBackgroundColor(Color.parseColor("#1E88E5"));
            }
        }
        setMinimumHeight(C2514a.m9521a(3.0f, getResources()));
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(getResources().getColor(17170445));
        if (isEnabled()) {
            this.p = this.f8655a;
        }
        this.f8655a = i;
    }
}
