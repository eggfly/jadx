package com.antutu.benchmark.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.antutu.utils.MLog;
import com.antutu.utils.widget.SystemBarTintManager;
import com.p063b.p064a.C1863m;
import com.p063b.p064a.C1863m.C1623b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.List;

public class ChartView extends View implements C1623b {
    private static int f5715b;
    private static int f5716c;
    private static int f5717d;
    private static int f5718e;
    private static int f5719f;
    private static int f5720g;
    private static int f5721h;
    private static int f5722i;
    private static int[] f5723j;
    C1622d f5724a;
    private double f5725k;
    private int f5726l;
    private int f5727m;
    private int f5728n;
    private GestureDetector f5729o;
    private C1620b f5730p;
    private List<C1622d> f5731q;
    private C1619a f5732r;

    public class DrawableProperty {
        private NinePatchDrawable f5694a;

        public float getWidth() {
            return (float) this.f5694a.getBounds().width();
        }

        public void setWidth(float f) {
            NinePatchDrawable ninePatchDrawable = this.f5694a;
            Rect rect = new Rect(ninePatchDrawable.copyBounds());
            rect.right = rect.left + ((int) f);
            ninePatchDrawable.setBounds(rect);
        }
    }

    /* renamed from: com.antutu.benchmark.view.ChartView.a */
    private class C1619a {
        final /* synthetic */ ChartView f5695a;
        private ShapeDrawable f5696b;
        private ShapeDrawable f5697c;
        private Path[] f5698d;
        private Path f5699e;
        private Paint f5700f;
        private Paint f5701g;
        private Paint f5702h;
        private int f5703i;
        private boolean f5704j;

        public void m6400a(Canvas canvas) {
            if (!this.f5704j) {
                int i = this.f5703i;
                int b = this.f5695a.f5726l;
                canvas.drawPath(this.f5699e, this.f5700f);
                int i2 = 0;
                int i3 = i;
                for (Path path : this.f5698d) {
                    canvas.drawText(i2 + BuildConfig.FLAVOR, (float) i3, (float) b, this.f5702h);
                    i2 += this.f5695a.f5727m;
                    i3 += (int) (this.f5695a.f5725k * ((double) this.f5695a.f5727m));
                    canvas.drawPath(path, this.f5701g);
                }
                this.f5696b.draw(canvas);
                this.f5697c.draw(canvas);
                this.f5704j = false;
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.ChartView.b */
    public interface C1620b {
    }

    /* renamed from: com.antutu.benchmark.view.ChartView.c */
    private class C1621c {
        private DrawableProperty f5705a;
        private DrawableProperty f5706b;

        public void m6401a(Canvas canvas) {
            this.f5705a.f5694a.draw(canvas);
        }

        public void m6402b(Canvas canvas) {
            if (this.f5706b != null) {
                Drawable a = this.f5706b.f5694a;
                if (a != null) {
                    a.draw(canvas);
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.ChartView.d */
    private class C1622d {
        Paint f5707a;
        Paint f5708b;
        final /* synthetic */ ChartView f5709c;
        private C1621c f5710d;
        private String f5711e;
        private int f5712f;
        private int f5713g;
        private int f5714h;

        public int m6403a() {
            return this.f5712f;
        }

        public void m6404a(Canvas canvas) {
            this.f5710d.m6401a(canvas);
            canvas.drawText(this.f5711e, (float) (this.f5713g + 1), (float) (this.f5714h + (this.f5709c.f5726l / 12)), this.f5707a);
            canvas.drawText(this.f5711e, (float) this.f5713g, (float) this.f5714h, this.f5708b);
        }

        public void m6405a(boolean z, Canvas canvas) {
            if (z && canvas != null) {
                this.f5710d.m6402b(canvas);
            }
        }
    }

    static {
        f5715b = -15132133;
        f5716c = -11184811;
        f5717d = -15132133;
        f5718e = -13618891;
        f5719f = -48848;
        f5720g = SystemBarTintManager.DEFAULT_TINT_COLOR;
        f5721h = -1;
        f5722i = -1;
        f5723j = new int[12];
    }

    public void m6410a(C1863m c1863m) {
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawColor(f5715b);
        this.f5732r.m6400a(canvas);
        int size = this.f5731q.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (!z && i < size && this.f5728n >= ((C1622d) this.f5731q.get(i)).m6403a()) {
                this.f5724a.m6404a(canvas);
                this.f5724a.m6405a(true, canvas);
                z = true;
            }
            ((C1622d) this.f5731q.get(i)).m6404a(canvas);
            if (!z && this.f5728n > 0 && i == size - 1) {
                this.f5724a.m6404a(canvas);
                this.f5724a.m6405a(true, canvas);
                z = true;
            }
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MLog.m6864d("onTouchEvent...");
        return this.f5729o.onTouchEvent(motionEvent);
    }

    public void setBackAnimationListener(C1620b c1620b) {
        this.f5730p = c1620b;
    }
}
