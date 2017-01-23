package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.antutu.utils.widget.SystemBarTintManager;
import com.github.mikephil.charting.data.C2560e;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p039d.C1202f;
import com.github.mikephil.charting.p039d.C2554b;
import com.github.mikephil.charting.p136a.C2522a;
import com.github.mikephil.charting.p138c.C2533c;
import com.github.mikephil.charting.p138c.C2536e;
import com.github.mikephil.charting.p139f.p140a.C2542c;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p142e.C2579b;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p143g.C2588b;
import com.github.mikephil.charting.p143g.C2591c;
import com.github.mikephil.charting.p143g.C2592d;
import com.github.mikephil.charting.p144h.C2598c;
import com.github.mikephil.charting.p144h.C2602e;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"NewApi"})
/* renamed from: com.github.mikephil.charting.charts.b */
public abstract class C2543b<T extends C2560e<? extends C2563d<? extends Entry>>> extends ViewGroup implements C2542c {
    protected float f8819A;
    protected float f8820B;
    protected boolean f8821C;
    protected C2533c f8822D;
    protected C2592d f8823E;
    protected C2588b f8824F;
    protected C2602e f8825G;
    protected C2598c f8826H;
    protected C2579b f8827I;
    protected C2621g f8828J;
    protected C2522a f8829K;
    protected Paint f8830L;
    protected C2581c[] f8831M;
    protected boolean f8832N;
    protected C2536e f8833O;
    protected ArrayList<Runnable> f8834P;
    private boolean f8835a;
    private float f8836b;
    private String f8837c;
    private C2591c f8838d;
    private String f8839e;
    private float f8840f;
    private float f8841g;
    private float f8842h;
    private float f8843i;
    private boolean f8844j;
    private PointF f8845k;
    private boolean f8846l;
    protected boolean f8847s;
    protected T f8848t;
    protected boolean f8849u;
    protected C1202f f8850v;
    protected Paint f8851w;
    protected Paint f8852x;
    protected String f8853y;
    protected float f8854z;

    /* renamed from: com.github.mikephil.charting.charts.b.1 */
    class C25491 implements AnimatorUpdateListener {
        final /* synthetic */ C2543b f8901a;

        C25491(C2543b c2543b) {
            this.f8901a = c2543b;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f8901a.postInvalidate();
        }
    }

    public C2543b(Context context) {
        super(context);
        this.f8847s = false;
        this.f8848t = null;
        this.f8849u = true;
        this.f8835a = true;
        this.f8836b = 0.9f;
        this.f8853y = "Description";
        this.f8854z = 1.0f;
        this.f8819A = 0.0f;
        this.f8820B = 0.0f;
        this.f8821C = true;
        this.f8837c = "No chart data available.";
        this.f8840f = 0.0f;
        this.f8841g = 0.0f;
        this.f8842h = 0.0f;
        this.f8843i = 0.0f;
        this.f8844j = false;
        this.f8832N = true;
        this.f8834P = new ArrayList();
        this.f8846l = false;
        m9647a();
    }

    public C2543b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8847s = false;
        this.f8848t = null;
        this.f8849u = true;
        this.f8835a = true;
        this.f8836b = 0.9f;
        this.f8853y = "Description";
        this.f8854z = 1.0f;
        this.f8819A = 0.0f;
        this.f8820B = 0.0f;
        this.f8821C = true;
        this.f8837c = "No chart data available.";
        this.f8840f = 0.0f;
        this.f8841g = 0.0f;
        this.f8842h = 0.0f;
        this.f8843i = 0.0f;
        this.f8844j = false;
        this.f8832N = true;
        this.f8834P = new ArrayList();
        this.f8846l = false;
        m9647a();
    }

    public C2543b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8847s = false;
        this.f8848t = null;
        this.f8849u = true;
        this.f8835a = true;
        this.f8836b = 0.9f;
        this.f8853y = "Description";
        this.f8854z = 1.0f;
        this.f8819A = 0.0f;
        this.f8820B = 0.0f;
        this.f8821C = true;
        this.f8837c = "No chart data available.";
        this.f8840f = 0.0f;
        this.f8841g = 0.0f;
        this.f8842h = 0.0f;
        this.f8843i = 0.0f;
        this.f8844j = false;
        this.f8832N = true;
        this.f8834P = new ArrayList();
        this.f8846l = false;
        m9647a();
    }

    private void m9646a(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                m9646a(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
        }
    }

    protected void m9647a() {
        setWillNotDraw(false);
        if (VERSION.SDK_INT < 11) {
            this.f8829K = new C2522a();
        } else {
            this.f8829K = new C2522a(new C25491(this));
        }
        C2620f.m10060a(getContext());
        this.f8850v = new C2554b(1);
        this.f8828J = new C2621g();
        this.f8822D = new C2533c();
        this.f8825G = new C2602e(this.f8828J, this.f8822D);
        this.f8851w = new Paint(1);
        this.f8851w.setColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        this.f8851w.setTextAlign(Align.RIGHT);
        this.f8851w.setTextSize(C2620f.m10053a(9.0f));
        this.f8852x = new Paint(1);
        this.f8852x.setColor(Color.rgb(247, 189, 51));
        this.f8852x.setTextAlign(Align.CENTER);
        this.f8852x.setTextSize(C2620f.m10053a(12.0f));
        this.f8830L = new Paint(4);
        if (this.f8847s) {
            Log.i(BuildConfig.FLAVOR, "Chart.init()");
        }
    }

    public void m9648a(int i) {
        this.f8829K.m9541a(i);
    }

    @Deprecated
    public void m9649a(C2581c c2581c) {
        m9650a(c2581c, true);
    }

    public void m9650a(C2581c c2581c, boolean z) {
        Entry entry = null;
        if (c2581c == null) {
            this.f8831M = null;
        } else {
            if (this.f8847s) {
                Log.i("MPAndroidChart", "Highlighted: " + c2581c.toString());
            }
            Entry a = this.f8848t.m9755a(c2581c);
            if (a == null || a.m9743d() != c2581c.m9885b()) {
                this.f8831M = null;
                c2581c = null;
                entry = a;
            } else {
                this.f8831M = new C2581c[]{c2581c};
                entry = a;
            }
        }
        if (z && this.f8823E != null) {
            if (m9660u()) {
                this.f8823E.m9927a(entry, c2581c.m9883a(), c2581c);
            } else {
                this.f8823E.m9926a();
            }
        }
        invalidate();
    }

    public void m9651a(C2581c[] c2581cArr) {
        this.f8831M = c2581cArr;
        if (c2581cArr == null || c2581cArr.length <= 0 || c2581cArr[0] == null) {
            this.f8824F.m9904a(null);
        } else {
            this.f8824F.m9904a(c2581cArr[0]);
        }
        invalidate();
    }

    protected abstract float[] m9652a(Entry entry, C2581c c2581c);

    protected abstract void m9653b();

    protected void m9654b(Canvas canvas) {
        if (!this.f8853y.equals(BuildConfig.FLAVOR)) {
            if (this.f8845k == null) {
                canvas.drawText(this.f8853y, (((float) getWidth()) - this.f8828J.m10082b()) - 10.0f, (((float) getHeight()) - this.f8828J.m10088d()) - 10.0f, this.f8851w);
            } else {
                canvas.drawText(this.f8853y, this.f8845k.x, this.f8845k.y, this.f8851w);
            }
        }
    }

    protected void m9655c(float f, float f2) {
        float max = (this.f8848t == null || this.f8848t.m9768l() < 2) ? Math.max(Math.abs(f), Math.abs(f2)) : Math.abs(f2 - f);
        this.f8850v = new C2554b(C2620f.m10070b(max));
    }

    protected void m9656c(Canvas canvas) {
        if (this.f8833O != null && this.f8832N && m9660u()) {
            int i = 0;
            while (i < this.f8831M.length) {
                C2581c c2581c = this.f8831M[i];
                int b = c2581c.m9885b();
                c2581c.m9883a();
                if (((float) b) <= this.f8854z && ((float) b) <= this.f8854z * this.f8829K.m9542b()) {
                    Entry a = this.f8848t.m9755a(this.f8831M[i]);
                    if (a != null && a.m9743d() == this.f8831M[i].m9885b()) {
                        float[] a2 = m9652a(a, c2581c);
                        if (this.f8828J.m10085b(a2[0], a2[1])) {
                            this.f8833O.m9611a(a, c2581c);
                            this.f8833O.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                            this.f8833O.layout(0, 0, this.f8833O.getMeasuredWidth(), this.f8833O.getMeasuredHeight());
                            if (a2[1] - ((float) this.f8833O.getHeight()) <= 0.0f) {
                                this.f8833O.m9610a(canvas, a2[0], (((float) this.f8833O.getHeight()) - a2[1]) + a2[1]);
                            } else {
                                this.f8833O.m9610a(canvas, a2[0], a2[1]);
                            }
                        }
                    }
                }
                i++;
            }
        }
    }

    public C2522a getAnimator() {
        return this.f8829K;
    }

    public PointF getCenter() {
        return new PointF(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public PointF getCenterOfView() {
        return getCenter();
    }

    public PointF getCenterOffsets() {
        return this.f8828J.m10103l();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.f8828J.m10102k();
    }

    public T getData() {
        return this.f8848t;
    }

    public C1202f getDefaultValueFormatter() {
        return this.f8850v;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.f8836b;
    }

    public float getExtraBottomOffset() {
        return this.f8842h;
    }

    public float getExtraLeftOffset() {
        return this.f8843i;
    }

    public float getExtraRightOffset() {
        return this.f8841g;
    }

    public float getExtraTopOffset() {
        return this.f8840f;
    }

    public C2581c[] getHighlighted() {
        return this.f8831M;
    }

    public C2579b getHighlighter() {
        return this.f8827I;
    }

    public ArrayList<Runnable> getJobs() {
        return this.f8834P;
    }

    public C2533c getLegend() {
        return this.f8822D;
    }

    public C2602e getLegendRenderer() {
        return this.f8825G;
    }

    public C2536e getMarkerView() {
        return this.f8833O;
    }

    public C2591c getOnChartGestureListener() {
        return this.f8838d;
    }

    public C2598c getRenderer() {
        return this.f8826H;
    }

    public int getValueCount() {
        return this.f8848t.m9765i();
    }

    public C2621g getViewPortHandler() {
        return this.f8828J;
    }

    public float getXChartMax() {
        return this.f8820B;
    }

    public float getXChartMin() {
        return this.f8819A;
    }

    public int getXValCount() {
        return this.f8848t.m9768l();
    }

    public float getYMax() {
        return this.f8848t.m9763g();
    }

    public float getYMin() {
        return this.f8848t.m9762f();
    }

    public abstract void m9657h();

    protected abstract void m9658i();

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f8846l) {
            m9646a((View) this);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.f8848t == null) {
            float f;
            boolean z = !TextUtils.isEmpty(this.f8837c);
            boolean z2 = !TextUtils.isEmpty(this.f8839e);
            float b = z ? (float) C2620f.m10071b(this.f8852x, this.f8837c) : 0.0f;
            float b2 = z2 ? (float) C2620f.m10071b(this.f8852x, this.f8839e) : 0.0f;
            float fontSpacing = (z && z2) ? this.f8852x.getFontSpacing() - b : 0.0f;
            b2 = ((((float) getHeight()) - (b2 + (b + fontSpacing))) / 2.0f) + b;
            if (z) {
                canvas.drawText(this.f8837c, (float) (getWidth() / 2), b2, this.f8852x);
                if (z2) {
                    f = (b2 + b) + fontSpacing;
                    if (z2) {
                        canvas.drawText(this.f8839e, (float) (getWidth() / 2), f, this.f8852x);
                    }
                }
            }
            f = b2;
            if (z2) {
                canvas.drawText(this.f8839e, (float) (getWidth() / 2), f, this.f8852x);
            }
        } else if (!this.f8844j) {
            m9658i();
            this.f8844j = true;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int a = (int) C2620f.m10053a(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), C2543b.resolveSize(a, i)), Math.max(getSuggestedMinimumHeight(), C2543b.resolveSize(a, i2)));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.f8847s) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            this.f8828J.m10079a((float) i, (float) i2);
            if (this.f8847s) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i + ", height: " + i2);
            }
            Iterator it = this.f8834P.iterator();
            while (it.hasNext()) {
                post((Runnable) it.next());
            }
            this.f8834P.clear();
        }
        m9657h();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setData(T t) {
        if (t == null) {
            Log.e("MPAndroidChart", "Cannot set data for chart. Provided data object is null.");
            return;
        }
        this.f8844j = false;
        this.f8848t = t;
        m9655c(t.m9762f(), t.m9763g());
        for (C2563d c2563d : this.f8848t.m9767k()) {
            if (C2620f.m10064a(c2563d.m9786g())) {
                c2563d.m9776a(this.f8850v);
            }
        }
        m9657h();
        if (this.f8847s) {
            Log.i("MPAndroidChart", "Data is set.");
        }
    }

    public void setDescription(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.f8853y = str;
    }

    public void setDescriptionColor(int i) {
        this.f8851w.setColor(i);
    }

    public void setDescriptionTextSize(float f) {
        float f2 = 16.0f;
        float f3 = 6.0f;
        if (f <= 16.0f) {
            f2 = f;
        }
        if (f2 >= 6.0f) {
            f3 = f2;
        }
        this.f8851w.setTextSize(C2620f.m10053a(f3));
    }

    public void setDescriptionTypeface(Typeface typeface) {
        this.f8851w.setTypeface(typeface);
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.f8835a = z;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = f;
        }
        if (f2 >= 1.0f) {
            f2 = 0.999f;
        }
        this.f8836b = f2;
    }

    public void setDrawMarkerViews(boolean z) {
        this.f8832N = z;
    }

    public void setExtraBottomOffset(float f) {
        this.f8842h = C2620f.m10053a(f);
    }

    public void setExtraLeftOffset(float f) {
        this.f8843i = C2620f.m10053a(f);
    }

    public void setExtraRightOffset(float f) {
        this.f8841g = C2620f.m10053a(f);
    }

    public void setExtraTopOffset(float f) {
        this.f8840f = C2620f.m10053a(f);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (VERSION.SDK_INT < 11) {
            Log.e("MPAndroidChart", "Cannot enable/disable hardware acceleration for devices below API level 11.");
        } else if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.f8849u = z;
    }

    public void setHighlighter(C2579b c2579b) {
        this.f8827I = c2579b;
    }

    public void setLogEnabled(boolean z) {
        this.f8847s = z;
    }

    public void setMarkerView(C2536e c2536e) {
        this.f8833O = c2536e;
    }

    public void setNoDataText(String str) {
        this.f8837c = str;
    }

    public void setNoDataTextDescription(String str) {
        this.f8839e = str;
    }

    public void setOnChartGestureListener(C2591c c2591c) {
        this.f8838d = c2591c;
    }

    public void setOnChartValueSelectedListener(C2592d c2592d) {
        this.f8823E = c2592d;
    }

    public void setOnTouchListener(C2588b c2588b) {
        this.f8824F = c2588b;
    }

    public void setRenderer(C2598c c2598c) {
        if (c2598c != null) {
            this.f8826H = c2598c;
        }
    }

    public void setTouchEnabled(boolean z) {
        this.f8821C = z;
    }

    public void setUnbindEnabled(boolean z) {
        this.f8846l = z;
    }

    public boolean m9659t() {
        return this.f8849u;
    }

    public boolean m9660u() {
        return (this.f8831M == null || this.f8831M.length <= 0 || this.f8831M[0] == null) ? false : true;
    }

    public boolean m9661v() {
        return this.f8835a;
    }

    public boolean m9662w() {
        return this.f8847s;
    }

    public void m9663x() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void m9664y() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }
}
