package com.antutu.benchmark.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class AlphabetScrollBar extends View {
    private Paint f5653a;
    private Paint f5654b;
    private String[] f5655c;
    private boolean f5656d;
    private int f5657e;
    private int f5658f;
    private C1615a f5659g;
    private NinePatchDrawable f5660h;
    private NinePatchDrawable f5661i;
    private Rect f5662j;
    private Rect f5663k;
    private int f5664l;
    private int f5665m;
    private int f5666n;
    private int f5667o;
    private int f5668p;

    /* renamed from: com.antutu.benchmark.view.AlphabetScrollBar.a */
    public interface C1615a {
        void m6382a(String str);
    }

    public AlphabetScrollBar(Context context) {
        super(context);
        this.f5653a = new Paint();
        this.f5654b = new Paint();
        this.f5655c = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.f5657e = -1;
        this.f5658f = -1;
        this.f5664l = 14;
        this.f5665m = 17;
        this.f5666n = 4;
        this.f5667o = 7;
        this.f5668p = 15;
    }

    public AlphabetScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5653a = new Paint();
        this.f5654b = new Paint();
        this.f5655c = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.f5657e = -1;
        this.f5658f = -1;
        this.f5664l = 14;
        this.f5665m = 17;
        this.f5666n = 4;
        this.f5667o = 7;
        this.f5668p = 15;
    }

    public AlphabetScrollBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5653a = new Paint();
        this.f5654b = new Paint();
        this.f5655c = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.f5657e = -1;
        this.f5658f = -1;
        this.f5664l = 14;
        this.f5665m = 17;
        this.f5666n = 4;
        this.f5667o = 7;
        this.f5668p = 15;
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        int width = getWidth();
        int height = getHeight();
        if (this.f5662j == null) {
            this.f5662j = new Rect(0, 0, width, height);
        }
        if (this.f5663k == null) {
            this.f5663k = new Rect(width - (this.f5668p + 10), 0, width - this.f5668p, height);
        }
        this.f5660h.setBounds(this.f5662j);
        this.f5660h.draw(canvas);
        this.f5661i.setBounds(this.f5663k);
        this.f5661i.draw(canvas);
        height /= this.f5655c.length;
        if (this.f5656d) {
            canvas.drawColor(Color.parseColor("#4FFFFFFF"));
        }
        while (i < this.f5655c.length) {
            this.f5653a.setColor(Color.parseColor("#D4D4D4"));
            this.f5653a.setAntiAlias(true);
            float f = (float) (width / 6);
            float f2 = (float) ((height * i) + (height / 2));
            if (i == this.f5657e) {
                this.f5653a.setColor(Color.parseColor("#A11715"));
                this.f5654b.setColor(-7829368);
                this.f5653a.setFakeBoldText(true);
                this.f5653a.setTextSize((float) this.f5665m);
                canvas.drawCircle((float) ((width - (this.f5668p + 10)) + 5), f2 - 7.0f, (float) this.f5667o, this.f5654b);
            } else {
                this.f5653a.setTextSize((float) this.f5664l);
                canvas.drawCircle((float) ((width - (this.f5668p + 10)) + 5), f2 - 7.0f, (float) this.f5666n, this.f5654b);
            }
            canvas.drawText(this.f5655c[i], f, f2, this.f5653a);
            this.f5653a.reset();
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f5656d = true;
                this.f5657e = (int) ((motionEvent.getY() / ((float) getHeight())) * ((float) this.f5655c.length));
                if (this.f5659g == null || this.f5658f == this.f5657e) {
                    return true;
                }
                if (this.f5657e >= 0 && this.f5657e < this.f5655c.length) {
                    this.f5659g.m6382a(this.f5655c[this.f5657e]);
                    invalidate();
                }
                this.f5658f = this.f5657e;
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f5656d = false;
                this.f5657e = -1;
                invalidate();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f5657e = (int) ((motionEvent.getY() / ((float) getHeight())) * ((float) this.f5655c.length));
                if (this.f5659g == null || this.f5657e == this.f5658f) {
                    return true;
                }
                if (this.f5657e >= 0 && this.f5657e < this.f5655c.length) {
                    this.f5659g.m6382a(this.f5655c[this.f5657e]);
                    invalidate();
                }
                this.f5658f = this.f5657e;
                return true;
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    public void setIndexSet(int i) {
        if (i >= 0 && i < this.f5655c.length && this.f5659g != null) {
            this.f5657e = i;
            this.f5658f = this.f5657e;
            invalidate();
        }
    }

    public void setOnTouchBarListener(C1615a c1615a) {
        this.f5659g = c1615a;
    }
}
