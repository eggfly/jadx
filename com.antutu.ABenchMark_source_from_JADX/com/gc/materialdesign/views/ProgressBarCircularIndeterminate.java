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
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import com.gc.materialdesign.p135a.C2514a;
import org.android.spdy.SpdyProtocol;

public class ProgressBarCircularIndeterminate extends C2515b {
    int f8646a;
    float f8647b;
    float f8648c;
    int f8649d;
    boolean f8650e;
    int f8651f;
    int f8652g;
    float f8653h;
    int f8654i;

    public ProgressBarCircularIndeterminate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8646a = Color.parseColor("#1E88E5");
        this.f8647b = 0.0f;
        this.f8648c = 0.0f;
        this.f8649d = 0;
        this.f8650e = false;
        this.f8651f = 1;
        this.f8652g = 0;
        this.f8653h = 0.0f;
        this.f8654i = 0;
        setAttributes(attributeSet);
    }

    private void m9528a(Canvas canvas) {
        if (this.f8647b < ((float) (getWidth() / 2))) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(m9530a());
            this.f8647b = this.f8647b >= ((float) (getWidth() / 2)) ? ((float) getWidth()) / 2.0f : this.f8647b + 1.0f;
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.f8647b, paint);
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(m9530a());
        canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) (getHeight() / 2), paint2);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(getResources().getColor(17170445));
        paint3.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        if (this.f8649d >= 50) {
            this.f8648c = this.f8648c >= ((float) (getWidth() / 2)) ? ((float) getWidth()) / 2.0f : this.f8648c + 1.0f;
        } else {
            this.f8648c = this.f8648c >= ((float) ((getWidth() / 2) - C2514a.m9521a(4.0f, getResources()))) ? (((float) getWidth()) / 2.0f) - ((float) C2514a.m9521a(4.0f, getResources())) : this.f8648c + 1.0f;
        }
        canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.f8648c, paint3);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, new Paint());
        if (this.f8648c >= ((float) ((getWidth() / 2) - C2514a.m9521a(4.0f, getResources())))) {
            this.f8649d++;
        }
        if (this.f8648c >= ((float) (getWidth() / 2))) {
            this.f8650e = true;
        }
    }

    private void m9529b(Canvas canvas) {
        if (this.f8652g == this.f8654i) {
            this.f8651f += 6;
        }
        if (this.f8651f >= 290 || this.f8652g > this.f8654i) {
            this.f8652g += 6;
            this.f8651f -= 6;
        }
        if (this.f8652g > this.f8654i + 290) {
            this.f8654i = this.f8652g;
            this.f8652g = this.f8654i;
            this.f8651f = 1;
        }
        this.f8653h += 4.0f;
        canvas.rotate(this.f8653h, (float) (getWidth() / 2), (float) (getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.f8646a);
        canvas2.drawArc(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), (float) this.f8652g, (float) this.f8651f, true, paint);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(getResources().getColor(17170445));
        paint2.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() / 2) - C2514a.m9521a(4.0f, getResources())), paint2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, new Paint());
    }

    protected int m9530a() {
        return Color.argb(SpdyProtocol.SLIGHTSSLV2, (this.f8646a >> 16) & MotionEventCompat.ACTION_MASK, (this.f8646a >> 8) & MotionEventCompat.ACTION_MASK, (this.f8646a >> 0) & MotionEventCompat.ACTION_MASK);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f8650e) {
            m9528a(canvas);
        }
        if (this.f8649d > 0) {
            m9529b(canvas);
        }
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
            this.p = this.f8646a;
        }
        this.f8646a = i;
    }
}
