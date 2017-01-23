package com.baidu.mobads.p092g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mobads.AppActivity.ActionBarColorTheme;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.p080j.C1991m;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.baidu.mobads.g.a */
public class C1939a extends RelativeLayout {
    protected C1937c f6781a;
    Paint f6782b;
    int f6783c;
    int f6784d;
    private Context f6785e;
    private IXAdCommonUtils f6786f;
    private ActionBarColorTheme f6787g;
    private TextView f6788h;

    /* renamed from: com.baidu.mobads.g.a.a */
    public class C1935a extends View {
        final /* synthetic */ C1939a f6774a;

        public C1935a(C1939a c1939a, Context context) {
            this.f6774a = c1939a;
            super(context);
        }
    }

    /* renamed from: com.baidu.mobads.g.a.b */
    private class C1936b extends C1935a {
        final /* synthetic */ C1939a f6775b;
        private Paint f6776c;
        private int f6777d;

        public C1936b(C1939a c1939a, Context context, int i) {
            this.f6775b = c1939a;
            super(c1939a, context);
            this.f6777d = i;
        }

        private Paint m7273a() {
            if (this.f6776c == null) {
                this.f6776c = new Paint();
                this.f6776c.setStyle(Style.STROKE);
                this.f6776c.setColor(this.f6777d);
                this.f6776c.setAlpha(MotionEventCompat.ACTION_MASK);
                this.f6776c.setAntiAlias(true);
                this.f6776c.setStrokeWidth((float) ((int) this.f6775b.f6786f.getScreenDensity(getContext())));
            }
            return this.f6776c;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawLine((float) this.f6775b.f6786f.getPixel(getContext(), 18), (float) this.f6775b.f6786f.getPixel(getContext(), 15), (float) this.f6775b.f6786f.getPixel(getContext(), 34), (float) this.f6775b.f6786f.getPixel(getContext(), 31), m7273a());
            canvas.drawLine((float) this.f6775b.f6786f.getPixel(getContext(), 18), (float) this.f6775b.f6786f.getPixel(getContext(), 31), (float) this.f6775b.f6786f.getPixel(getContext(), 34), (float) this.f6775b.f6786f.getPixel(getContext(), 15), m7273a());
        }
    }

    /* renamed from: com.baidu.mobads.g.a.c */
    public interface C1937c {
        void m7274a();

        void m7275b();
    }

    /* renamed from: com.baidu.mobads.g.a.d */
    private class C1938d extends C1935a {
        final /* synthetic */ C1939a f6778b;
        private Paint f6779c;
        private int f6780d;

        public C1938d(C1939a c1939a, Context context, int i) {
            this.f6778b = c1939a;
            super(c1939a, context);
            this.f6780d = i;
        }

        private Paint m7276a() {
            if (this.f6779c == null) {
                this.f6779c = new Paint();
                this.f6779c.setColor(this.f6780d);
                this.f6779c.setAlpha(MotionEventCompat.ACTION_MASK);
                this.f6779c.setAntiAlias(true);
            }
            return this.f6779c;
        }

        private void m7277a(Canvas canvas, int i) {
            canvas.drawCircle((float) this.f6778b.f6786f.getPixel(getContext(), 26), (float) this.f6778b.f6786f.getPixel(getContext(), i), (float) ((int) (this.f6778b.f6786f.getScreenDensity(getContext()) * 1.0f)), m7276a());
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            m7277a(canvas, 31);
            m7277a(canvas, 15);
            m7277a(canvas, 23);
        }
    }

    public C1939a(Context context) {
        super(context);
        this.f6782b = new Paint();
        this.f6783c = 0;
        this.f6784d = 0;
        this.f6785e = context;
    }

    public C1939a(Context context, ActionBarColorTheme actionBarColorTheme) {
        this(context);
        this.f6787g = actionBarColorTheme;
        setBackgroundColor(this.f6787g.getBackgroundColor());
        this.f6786f = C1991m.m7449a().m7464m();
        m7279a();
    }

    protected void m7279a() {
        int pixel = this.f6786f.getPixel(this.f6785e, 52);
        View c1936b = new C1936b(this, this.f6785e, this.f6787g.getCloseColor());
        c1936b.setId(132343242);
        addView(c1936b, new LayoutParams(pixel, -1));
        c1936b.setOnClickListener(new C1940b(this));
        c1936b = new C1938d(this, this.f6785e, this.f6787g.getCloseColor());
        c1936b.setId(132343243);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(pixel, -1);
        layoutParams.addRule(11);
        c1936b.setOnClickListener(new C1941c(this));
        addView(c1936b, layoutParams);
        this.f6788h = new TextView(this.f6785e);
        this.f6788h.setTextSize(1, 16.0f);
        this.f6788h.setLines(1);
        this.f6788h.setEllipsize(TruncateAt.END);
        this.f6788h.setGravity(16);
        this.f6788h.setTextColor(this.f6787g.getTitleColor());
        this.f6788h.setText(BuildConfig.FLAVOR);
        layoutParams = new LayoutParams(this.f6786f.getScreenRect(this.f6785e).width() - (pixel * 2), -1);
        layoutParams.addRule(14);
        addView(this.f6788h, layoutParams);
    }

    public void m7280a(C1937c c1937c) {
        this.f6781a = c1937c;
    }

    public void m7281a(String str) {
        if (this.f6788h != null) {
            this.f6788h.setText(str);
            this.f6788h.invalidate();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6787g.equals(ActionBarColorTheme.ACTION_BAR_WHITE_THEME)) {
            this.f6782b.setColor(-5592406);
            this.f6782b.setStyle(Style.STROKE);
            this.f6782b.setStrokeWidth((float) this.f6786f.getPixel(this.f6785e, 1));
            canvas.drawLine(0.0f, (float) this.f6784d, (float) this.f6783c, (float) this.f6784d, this.f6782b);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f6783c = i3 - i;
        this.f6784d = i4 - i2;
    }
}
