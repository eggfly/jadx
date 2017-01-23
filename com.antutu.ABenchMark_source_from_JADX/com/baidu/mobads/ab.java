package com.baidu.mobads;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.widget.ImageView;
import com.umeng.analytics.C4156a;

class ab extends ImageView {
    int f6667a;
    RectF f6668b;
    private final Paint f6669c;
    private final Context f6670d;

    public ab(Context context) {
        super(context);
        this.f6667a = 0;
        this.f6668b = new RectF();
        this.f6670d = context;
        this.f6669c = new Paint();
        this.f6669c.setAntiAlias(true);
        this.f6669c.setStyle(Style.STROKE);
    }

    public static int m7200a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int a = m7200a(this.f6670d, 15.0f);
        int a2 = m7200a(this.f6670d, 4.0f);
        this.f6668b.left = (float) (width - ((a + 1) + (a2 / 2)));
        this.f6668b.top = (float) (width - ((a + 1) + (a2 / 2)));
        this.f6668b.right = (float) (((a + 1) + (a2 / 2)) + width);
        this.f6668b.bottom = (float) (width + ((a + 1) + (a2 / 2)));
        this.f6669c.setColor(-1907998);
        this.f6669c.setStrokeWidth((float) a2);
        canvas.drawArc(this.f6668b, (float) (this.f6667a + 0), 72.0f, false, this.f6669c);
        this.f6669c.setColor(-1594427658);
        canvas.drawArc(this.f6668b, (float) (this.f6667a + 72), 270.0f, false, this.f6669c);
        this.f6667a += 10;
        if (this.f6667a >= C4156a.f13955q) {
            this.f6667a = 0;
        }
        super.onDraw(canvas);
        invalidate();
    }
}
