package com.facebook.ads.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.internal.g */
public class C2471g extends View {
    private Paint f8501a;
    private Paint f8502b;
    private Paint f8503c;
    private int f8504d;
    private boolean f8505e;

    public C2471g(Context context) {
        this(context, 60, true);
    }

    public C2471g(Context context, int i, boolean z) {
        super(context);
        this.f8504d = i;
        this.f8505e = z;
        if (z) {
            this.f8501a = new Paint();
            this.f8501a.setColor(-3355444);
            this.f8501a.setStyle(Style.STROKE);
            this.f8501a.setStrokeWidth(3.0f);
            this.f8501a.setAntiAlias(true);
            this.f8502b = new Paint();
            this.f8502b.setColor(-1287371708);
            this.f8502b.setStyle(Style.FILL);
            this.f8502b.setAntiAlias(true);
            this.f8503c = new Paint();
            this.f8503c.setColor(-1);
            this.f8503c.setStyle(Style.STROKE);
            this.f8503c.setStrokeWidth(6.0f);
            this.f8503c.setAntiAlias(true);
        }
        m9398a();
    }

    private void m9398a() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((float) this.f8504d) * displayMetrics.density), (int) (displayMetrics.density * ((float) this.f8504d)));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        setLayoutParams(layoutParams);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f8505e) {
            if (canvas.isHardwareAccelerated() && VERSION.SDK_INT < 17) {
                setLayerType(1, null);
            }
            int min = Math.min(canvas.getWidth(), canvas.getHeight());
            int i = min / 2;
            int i2 = min / 2;
            int i3 = (i * 2) / 3;
            canvas.drawCircle((float) i, (float) i2, (float) i3, this.f8501a);
            canvas.drawCircle((float) i, (float) i2, (float) (i3 - 2), this.f8502b);
            int i4 = min / 3;
            int i5 = min / 3;
            canvas.drawLine((float) i4, (float) i5, (float) (i4 * 2), (float) (i5 * 2), this.f8503c);
            canvas.drawLine((float) (i4 * 2), (float) i5, (float) i4, (float) (i5 * 2), this.f8503c);
        }
        super.onDraw(canvas);
    }
}
