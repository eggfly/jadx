package com.antutu.redacc.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.antutu.redacc.p067f.C1748e;
import com.antutu.redacc.p072e.C1739c;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;

public class CircleCleanView extends View {
    private static int f6259a;
    private int f6260b;
    private int f6261c;
    private C1776a f6262d;
    private Path f6263e;
    private PathMeasure f6264f;
    private ArrayList<Path> f6265g;
    private Paint f6266h;
    private Paint f6267i;
    private Paint f6268j;
    private int f6269k;
    private int f6270l;
    private int f6271m;
    private int f6272n;
    private float f6273o;
    private float f6274p;
    private float f6275q;
    private int f6276r;
    private double f6277s;
    private RectF f6278t;
    private List<C1739c> f6279u;
    private ValueAnimator f6280v;
    private ValueAnimator f6281w;
    private ValueAnimator f6282x;
    private ValueAnimator f6283y;

    /* renamed from: com.antutu.redacc.view.CircleCleanView.1 */
    class C17691 implements AnimatorUpdateListener {
        final /* synthetic */ CircleCleanView f6248a;

        C17691(CircleCleanView circleCleanView) {
            this.f6248a = circleCleanView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f6248a.setPhare(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.antutu.redacc.view.CircleCleanView.2 */
    class C17702 implements AnimatorUpdateListener {
        final /* synthetic */ CircleCleanView f6249a;

        C17702(CircleCleanView circleCleanView) {
            this.f6249a = circleCleanView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f6249a.setStartAngle(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.antutu.redacc.view.CircleCleanView.3 */
    class C17713 implements AnimatorUpdateListener {
        final /* synthetic */ CircleCleanView f6250a;

        C17713(CircleCleanView circleCleanView) {
            this.f6250a = circleCleanView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f6250a.setEndAngle(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.antutu.redacc.view.CircleCleanView.4 */
    class C17724 implements AnimatorListener {
        final /* synthetic */ CircleCleanView f6251a;

        C17724(CircleCleanView circleCleanView) {
            this.f6251a = circleCleanView;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f6251a.f6262d != C1776a.Progressing && this.f6251a.f6282x != null && !this.f6251a.f6282x.isRunning() && !this.f6251a.f6282x.isStarted()) {
                this.f6251a.m6849a();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.antutu.redacc.view.CircleCleanView.5 */
    class C17735 implements AnimatorListener {
        final /* synthetic */ CircleCleanView f6252a;

        C17735(CircleCleanView circleCleanView) {
            this.f6252a = circleCleanView;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f6252a.f6281w != null) {
                if (this.f6252a.f6262d != C1776a.Progressing) {
                    this.f6252a.f6281w.setDuration(350);
                }
                this.f6252a.f6266h.setColor(this.f6252a.f6260b);
                this.f6252a.f6281w.start();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.antutu.redacc.view.CircleCleanView.6 */
    class C17746 implements AnimatorUpdateListener {
        final /* synthetic */ CircleCleanView f6253a;

        C17746(CircleCleanView circleCleanView) {
            this.f6253a = circleCleanView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f6253a.setChoosePos(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: com.antutu.redacc.view.CircleCleanView.7 */
    static /* synthetic */ class C17757 {
        static final /* synthetic */ int[] f6254a;

        static {
            f6254a = new int[C1776a.values().length];
            try {
                f6254a[C1776a.Success.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6254a[C1776a.Fail.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6254a[C1776a.Progressing.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.antutu.redacc.view.CircleCleanView.a */
    public enum C1776a {
        Success,
        Fail,
        Progressing
    }

    public CircleCleanView(Context context) {
        this(context, null);
    }

    public CircleCleanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleCleanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6260b = -1;
        this.f6261c = -16482393;
        this.f6262d = C1776a.Success;
        this.f6279u = new ArrayList();
        f6259a = C1748e.m6745a(context, 3.4f);
        this.f6263e = new Path();
        this.f6264f = new PathMeasure(this.f6263e, false);
        this.f6265g = new ArrayList();
        this.f6266h = new Paint(1);
        this.f6266h.setStyle(Style.FILL);
        this.f6266h.setColor(this.f6260b);
        this.f6266h.setStrokeWidth(20.0f);
        this.f6266h.setStrokeCap(Cap.ROUND);
        this.f6267i = new Paint(1);
        this.f6267i.setStyle(Style.FILL);
        this.f6267i.setColor(this.f6261c);
        this.f6267i.setStrokeWidth(20.0f);
        this.f6267i.setStrokeCap(Cap.ROUND);
        this.f6268j = new Paint(1);
        this.f6268j.setStyle(Style.STROKE);
        this.f6268j.setColor(this.f6261c);
        this.f6268j.setStrokeWidth(28.0f);
        this.f6268j.setStrokeCap(Cap.ROUND);
        this.f6278t = new RectF();
    }

    private void m6835a(Canvas canvas) {
        for (C1739c c1739c : this.f6279u) {
            if (c1739c.m6728c()) {
                canvas.drawCircle(c1739c.m6725a(), c1739c.m6727b(), (float) f6259a, this.f6267i);
            } else {
                canvas.drawCircle(c1739c.m6725a(), c1739c.m6727b(), (float) f6259a, this.f6266h);
            }
        }
    }

    private void m6839b(Canvas canvas) {
        float f = this.f6275q * 360.0f;
        float f2 = this.f6274p * 360.0f;
        if (f == 360.0f) {
            f = 0.0f;
        }
        float f3 = f2 - f;
        if (f3 < 0.0f) {
            f3 = 1.0f;
        }
        canvas.drawArc(this.f6278t, (float) ((((double) f) + this.f6277s) - 90.0d), f3, false, this.f6268j);
    }

    private void m6844d() {
        if (this.f6263e != null) {
            switch (C17757.f6254a[this.f6262d.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (this.f6264f.getSegment(0.0f, this.f6264f.getLength() * this.f6273o, (Path) this.f6265g.get(0), true)) {
                        ((Path) this.f6265g.get(0)).rLineTo(0.0f, 0.0f);
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    for (int i = 0; i < 2; i++) {
                        float f = this.f6273o - (((float) i) * 0.5f);
                        if (f < 0.0f) {
                            f = 0.0f;
                        }
                        if (this.f6264f.getSegment(0.0f, this.f6264f.getLength() * (f * 2.0f), (Path) this.f6265g.get(i), true)) {
                            ((Path) this.f6265g.get(i)).rLineTo(0.0f, 0.0f);
                        }
                        this.f6264f.nextContour();
                    }
                    this.f6264f.setPath(this.f6263e, false);
                default:
            }
        }
    }

    private void m6846e() {
        this.f6281w = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f6282x = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f6283y = ValueAnimator.ofInt(new int[]{0, 20});
        this.f6281w.addUpdateListener(new C17702(this));
        this.f6282x.addUpdateListener(new C17713(this));
        this.f6281w.addListener(new C17724(this));
        this.f6282x.addListener(new C17735(this));
        this.f6281w.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f6282x.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f6283y.addUpdateListener(new C17746(this));
        this.f6283y.setInterpolator(new LinearInterpolator());
        this.f6283y.setRepeatCount(-1);
        this.f6283y.setDuration(5000);
    }

    private void m6847f() {
        if (this.f6283y == null) {
            m6846e();
        }
        if (this.f6283y.isRunning()) {
            this.f6283y.end();
        }
        this.f6283y.start();
    }

    private void m6848g() {
        int i = (int) (((float) this.f6272n) * 0.15f);
        this.f6265g.clear();
        switch (C17757.f6254a[this.f6262d.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f6263e.reset();
                this.f6263e.moveTo((float) (this.f6269k - this.f6272n), (float) (this.f6270l + i));
                this.f6263e.lineTo((float) (this.f6269k - i), (float) ((this.f6270l + this.f6272n) - i));
                this.f6263e.lineTo((float) (this.f6269k + this.f6272n), (float) (i + (this.f6270l - this.f6272n)));
                this.f6265g.add(new Path());
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f6263e.reset();
                float f = ((float) this.f6272n) * 0.8f;
                this.f6263e.moveTo(((float) this.f6269k) - f, ((float) this.f6270l) - f);
                this.f6263e.lineTo(((float) this.f6269k) + f, ((float) this.f6270l) + f);
                this.f6263e.moveTo(((float) this.f6269k) + f, ((float) this.f6270l) - f);
                this.f6263e.lineTo(((float) this.f6269k) - f, f + ((float) this.f6270l));
                for (i = 0; i < 2; i++) {
                    this.f6265g.add(new Path());
                }
                break;
            default:
                this.f6263e.reset();
                break;
        }
        this.f6264f.setPath(this.f6263e, false);
    }

    private void setChoosePos(int i) {
        if (this.f6279u != null && i <= this.f6279u.size() - 1 && this.f6279u.size() > 0) {
            this.f6276r = i;
            for (C1739c c1739c : this.f6279u) {
                if (c1739c.m6728c()) {
                    c1739c.m6726a(false);
                }
            }
            ((C1739c) this.f6279u.get(i)).m6726a(true);
            invalidate();
        }
    }

    private void setEndAngle(float f) {
        this.f6275q = f;
        invalidate();
    }

    private void setPhare(float f) {
        this.f6273o = f;
        m6844d();
        invalidate();
    }

    private void setStartAngle(float f) {
        this.f6274p = f;
        invalidate();
    }

    public void m6849a() {
        if (this.f6280v == null) {
            this.f6280v = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f6280v.addUpdateListener(new C17691(this));
            this.f6280v.setDuration(350);
            this.f6280v.setInterpolator(new LinearInterpolator());
        }
        this.f6273o = 0.0f;
        this.f6280v.start();
    }

    public void m6850a(C1776a c1776a) {
        if (this.f6262d != c1776a) {
            this.f6262d = c1776a;
            if (this.f6280v != null && this.f6280v.isRunning()) {
                m6851b();
            }
            switch (C17757.f6254a[c1776a.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (this.f6283y.isRunning()) {
                        this.f6283y.end();
                    }
                    m6848g();
                    this.f6277s = (double) ((float) ((C1739c) this.f6279u.get(this.f6276r)).m6729d());
                    m6852c();
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    m6847f();
                default:
            }
        }
    }

    public void m6851b() {
        if (this.f6280v != null) {
            this.f6280v.end();
        }
    }

    public void m6852c() {
        if (this.f6281w == null || this.f6282x == null) {
            m6846e();
        }
        this.f6281w.setDuration(1000);
        this.f6282x.setDuration(1);
        this.f6281w.start();
        this.f6282x.start();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path;
        switch (C17757.f6254a[this.f6262d.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m6835a(canvas);
                path = (Path) this.f6265g.get(0);
                if (path != null) {
                    this.f6268j.setColor(this.f6260b);
                    canvas.drawPath(path, this.f6268j);
                }
                m6839b(canvas);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                m6835a(canvas);
                for (int i = 0; i < 2; i++) {
                    path = (Path) this.f6265g.get(i);
                    if (path != null) {
                        canvas.drawPath(path, this.f6268j);
                    }
                }
                m6839b(canvas);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                m6835a(canvas);
            default:
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f6269k = i / 2;
        this.f6270l = i2 / 2;
        this.f6271m = this.f6269k > this.f6270l ? this.f6270l : this.f6269k;
        this.f6272n = (int) (((float) this.f6271m) * 0.55f);
        int i5 = this.f6271m - 10;
        this.f6278t.left = (float) (((long) (this.f6269k - i5)) + 4);
        this.f6278t.top = (float) (((long) (this.f6270l - i5)) + 4);
        this.f6278t.right = (float) (((long) (this.f6269k + i5)) - 4);
        this.f6278t.bottom = (float) (((long) (this.f6270l + i5)) - 4);
        this.f6279u.clear();
        for (int i6 = 0; i6 < 20; i6++) {
            double d = 18.0d * ((double) i6);
            double toRadians = Math.toRadians(d);
            this.f6279u.add(new C1739c((float) (((double) this.f6269k) + (((double) (((long) i5) - 4)) * Math.sin(toRadians))), (float) (((double) this.f6270l) - (((double) (((long) i5) - 4)) * Math.cos(toRadians))), toRadians, d));
        }
        m6848g();
    }
}
