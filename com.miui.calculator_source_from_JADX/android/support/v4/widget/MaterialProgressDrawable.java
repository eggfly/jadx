package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final Interpolator f1120b;
    private static final Interpolator f1121c;
    boolean f1122a;
    private final int[] f1123d;
    private final ArrayList<Animation> f1124e;
    private final Ring f1125f;
    private float f1126g;
    private Resources f1127h;
    private View f1128i;
    private Animation f1129j;
    private float f1130k;
    private double f1131l;
    private double f1132m;
    private final Callback f1133n;

    /* renamed from: android.support.v4.widget.MaterialProgressDrawable.1 */
    class C01121 extends Animation {
        final /* synthetic */ Ring f1091a;
        final /* synthetic */ MaterialProgressDrawable f1092b;

        C01121(MaterialProgressDrawable materialProgressDrawable, Ring ring) {
            this.f1092b = materialProgressDrawable;
            this.f1091a = ring;
        }

        public void applyTransformation(float f, Transformation transformation) {
            if (this.f1092b.f1122a) {
                this.f1092b.m2276b(f, this.f1091a);
                return;
            }
            float a = this.f1092b.m2266a(this.f1091a);
            float g = this.f1091a.m2259g();
            float f2 = this.f1091a.m2258f();
            float k = this.f1091a.m2263k();
            this.f1092b.m2273a(f, this.f1091a);
            if (f <= 0.5f) {
                float f3 = 0.8f - a;
                this.f1091a.m2248b(f2 + (MaterialProgressDrawable.f1121c.getInterpolation(f / 0.5f) * f3));
            }
            if (f > 0.5f) {
                this.f1091a.m2251c(((0.8f - a) * MaterialProgressDrawable.f1121c.getInterpolation((f - 0.5f) / 0.5f)) + g);
            }
            this.f1091a.m2254d((0.25f * f) + k);
            this.f1092b.m2285c((216.0f * f) + (1080.0f * (this.f1092b.f1130k / 5.0f)));
        }
    }

    /* renamed from: android.support.v4.widget.MaterialProgressDrawable.2 */
    class C01132 implements AnimationListener {
        final /* synthetic */ Ring f1093a;
        final /* synthetic */ MaterialProgressDrawable f1094b;

        C01132(MaterialProgressDrawable materialProgressDrawable, Ring ring) {
            this.f1094b = materialProgressDrawable;
            this.f1093a = ring;
        }

        public void onAnimationStart(Animation animation) {
            this.f1094b.f1130k = 0.0f;
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
            this.f1093a.m2264l();
            this.f1093a.m2247b();
            this.f1093a.m2248b(this.f1093a.m2261i());
            if (this.f1094b.f1122a) {
                this.f1094b.f1122a = false;
                animation.setDuration(1332);
                this.f1093a.m2245a(false);
                return;
            }
            this.f1094b.f1130k = (this.f1094b.f1130k + 1.0f) % 5.0f;
        }
    }

    /* renamed from: android.support.v4.widget.MaterialProgressDrawable.3 */
    class C01143 implements Callback {
        final /* synthetic */ MaterialProgressDrawable f1095a;

        C01143(MaterialProgressDrawable materialProgressDrawable) {
            this.f1095a = materialProgressDrawable;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f1095a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f1095a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f1095a.unscheduleSelf(runnable);
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ProgressDrawableSize {
    }

    private static class Ring {
        private final RectF f1096a;
        private final Paint f1097b;
        private final Paint f1098c;
        private final Callback f1099d;
        private float f1100e;
        private float f1101f;
        private float f1102g;
        private float f1103h;
        private float f1104i;
        private int[] f1105j;
        private int f1106k;
        private float f1107l;
        private float f1108m;
        private float f1109n;
        private boolean f1110o;
        private Path f1111p;
        private float f1112q;
        private double f1113r;
        private int f1114s;
        private int f1115t;
        private int f1116u;
        private final Paint f1117v;
        private int f1118w;
        private int f1119x;

        public Ring(Callback callback) {
            this.f1096a = new RectF();
            this.f1097b = new Paint();
            this.f1098c = new Paint();
            this.f1100e = 0.0f;
            this.f1101f = 0.0f;
            this.f1102g = 0.0f;
            this.f1103h = 5.0f;
            this.f1104i = 2.5f;
            this.f1117v = new Paint(1);
            this.f1099d = callback;
            this.f1097b.setStrokeCap(Cap.SQUARE);
            this.f1097b.setAntiAlias(true);
            this.f1097b.setStyle(Style.STROKE);
            this.f1098c.setStyle(Style.FILL);
            this.f1098c.setAntiAlias(true);
        }

        public void m2241a(int i) {
            this.f1118w = i;
        }

        public void m2240a(float f, float f2) {
            this.f1114s = (int) f;
            this.f1115t = (int) f2;
        }

        public void m2243a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1096a;
            rectF.set(rect);
            rectF.inset(this.f1104i, this.f1104i);
            float f = (this.f1100e + this.f1102g) * 360.0f;
            float f2 = ((this.f1101f + this.f1102g) * 360.0f) - f;
            this.f1097b.setColor(this.f1119x);
            canvas.drawArc(rectF, f, f2, false, this.f1097b);
            m2234a(canvas, f, f2, rect);
            if (this.f1116u < 255) {
                this.f1117v.setColor(this.f1118w);
                this.f1117v.setAlpha(255 - this.f1116u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f1117v);
            }
        }

        private void m2234a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f1110o) {
                if (this.f1111p == null) {
                    this.f1111p = new Path();
                    this.f1111p.setFillType(FillType.EVEN_ODD);
                } else {
                    this.f1111p.reset();
                }
                float f3 = ((float) (((int) this.f1104i) / 2)) * this.f1112q;
                float cos = (float) ((this.f1113r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float sin = (float) ((this.f1113r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.f1111p.moveTo(0.0f, 0.0f);
                this.f1111p.lineTo(((float) this.f1114s) * this.f1112q, 0.0f);
                this.f1111p.lineTo((((float) this.f1114s) * this.f1112q) / 2.0f, ((float) this.f1115t) * this.f1112q);
                this.f1111p.offset(cos - f3, sin);
                this.f1111p.close();
                this.f1098c.setColor(this.f1119x);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f1111p, this.f1098c);
            }
        }

        public void m2246a(@NonNull int[] iArr) {
            this.f1105j = iArr;
            m2252c(0);
        }

        public void m2249b(int i) {
            this.f1119x = i;
        }

        public void m2252c(int i) {
            this.f1106k = i;
            this.f1119x = this.f1105j[this.f1106k];
        }

        public int m2237a() {
            return this.f1105j[m2235n()];
        }

        private int m2235n() {
            return (this.f1106k + 1) % this.f1105j.length;
        }

        public void m2247b() {
            m2252c(m2235n());
        }

        public void m2244a(ColorFilter colorFilter) {
            this.f1097b.setColorFilter(colorFilter);
            m2236o();
        }

        public void m2255d(int i) {
            this.f1116u = i;
        }

        public int m2250c() {
            return this.f1116u;
        }

        public void m2239a(float f) {
            this.f1103h = f;
            this.f1097b.setStrokeWidth(f);
            m2236o();
        }

        public float m2253d() {
            return this.f1103h;
        }

        public void m2248b(float f) {
            this.f1100e = f;
            m2236o();
        }

        public float m2256e() {
            return this.f1100e;
        }

        public float m2258f() {
            return this.f1107l;
        }

        public float m2259g() {
            return this.f1108m;
        }

        public int m2260h() {
            return this.f1105j[this.f1106k];
        }

        public void m2251c(float f) {
            this.f1101f = f;
            m2236o();
        }

        public float m2261i() {
            return this.f1101f;
        }

        public void m2254d(float f) {
            this.f1102g = f;
            m2236o();
        }

        public void m2242a(int i, int i2) {
            float min = (float) Math.min(i, i2);
            if (this.f1113r <= 0.0d || min < 0.0f) {
                min = (float) Math.ceil((double) (this.f1103h / 2.0f));
            } else {
                min = (float) (((double) (min / 2.0f)) - this.f1113r);
            }
            this.f1104i = min;
        }

        public void m2238a(double d) {
            this.f1113r = d;
        }

        public double m2262j() {
            return this.f1113r;
        }

        public void m2245a(boolean z) {
            if (this.f1110o != z) {
                this.f1110o = z;
                m2236o();
            }
        }

        public void m2257e(float f) {
            if (f != this.f1112q) {
                this.f1112q = f;
                m2236o();
            }
        }

        public float m2263k() {
            return this.f1109n;
        }

        public void m2264l() {
            this.f1107l = this.f1100e;
            this.f1108m = this.f1101f;
            this.f1109n = this.f1102g;
        }

        public void m2265m() {
            this.f1107l = 0.0f;
            this.f1108m = 0.0f;
            this.f1109n = 0.0f;
            m2248b(0.0f);
            m2251c(0.0f);
            m2254d(0.0f);
        }

        private void m2236o() {
            this.f1099d.invalidateDrawable(null);
        }
    }

    static {
        f1120b = new LinearInterpolator();
        f1121c = new FastOutSlowInInterpolator();
    }

    public MaterialProgressDrawable(Context context, View view) {
        this.f1123d = new int[]{-16777216};
        this.f1124e = new ArrayList();
        this.f1133n = new C01143(this);
        this.f1128i = view;
        this.f1127h = context.getResources();
        this.f1125f = new Ring(this.f1133n);
        this.f1125f.m2246a(this.f1123d);
        m2280a(1);
        m2275b();
    }

    private void m2272a(double d, double d2, double d3, double d4, float f, float f2) {
        Ring ring = this.f1125f;
        float f3 = this.f1127h.getDisplayMetrics().density;
        this.f1131l = ((double) f3) * d;
        this.f1132m = ((double) f3) * d2;
        ring.m2239a(((float) d4) * f3);
        ring.m2238a(((double) f3) * d3);
        ring.m2252c(0);
        ring.m2240a(f * f3, f3 * f2);
        ring.m2242a((int) this.f1131l, (int) this.f1132m);
    }

    public void m2280a(@ProgressDrawableSize int i) {
        if (i == 0) {
            m2272a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m2272a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void m2281a(boolean z) {
        this.f1125f.m2245a(z);
    }

    public void m2278a(float f) {
        this.f1125f.m2257e(f);
    }

    public void m2279a(float f, float f2) {
        this.f1125f.m2248b(f);
        this.f1125f.m2251c(f2);
    }

    public void m2283b(float f) {
        this.f1125f.m2254d(f);
    }

    public void m2284b(int i) {
        this.f1125f.m2241a(i);
    }

    public void m2282a(int... iArr) {
        this.f1125f.m2246a(iArr);
        this.f1125f.m2252c(0);
    }

    public int getIntrinsicHeight() {
        return (int) this.f1132m;
    }

    public int getIntrinsicWidth() {
        return (int) this.f1131l;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f1126g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1125f.m2243a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.f1125f.m2255d(i);
    }

    public int getAlpha() {
        return this.f1125f.m2250c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1125f.m2244a(colorFilter);
    }

    void m2285c(float f) {
        this.f1126g = f;
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.f1124e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.f1129j.reset();
        this.f1125f.m2264l();
        if (this.f1125f.m2261i() != this.f1125f.m2256e()) {
            this.f1122a = true;
            this.f1129j.setDuration(666);
            this.f1128i.startAnimation(this.f1129j);
            return;
        }
        this.f1125f.m2252c(0);
        this.f1125f.m2265m();
        this.f1129j.setDuration(1332);
        this.f1128i.startAnimation(this.f1129j);
    }

    public void stop() {
        this.f1128i.clearAnimation();
        m2285c(0.0f);
        this.f1125f.m2245a(false);
        this.f1125f.m2252c(0);
        this.f1125f.m2265m();
    }

    private float m2266a(Ring ring) {
        return (float) Math.toRadians(((double) ring.m2253d()) / (6.283185307179586d * ring.m2262j()));
    }

    private int m2270a(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        intValue &= 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (intValue + ((int) (((float) ((intValue2 & 255) - intValue)) * f))) | ((((i3 + ((int) (((float) (((intValue2 >> 24) & 255) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((intValue2 >> 16) & 255) - i4)) * f))) << 16)) | ((((int) (((float) (((intValue2 >> 8) & 255) - i5)) * f)) + i5) << 8));
    }

    private void m2273a(float f, Ring ring) {
        if (f > 0.75f) {
            ring.m2249b(m2270a((f - 0.75f) / 0.25f, ring.m2260h(), ring.m2237a()));
        }
    }

    private void m2276b(float f, Ring ring) {
        m2273a(f, ring);
        float floor = (float) (Math.floor((double) (ring.m2263k() / 0.8f)) + 1.0d);
        float a = m2266a(ring);
        ring.m2248b((((ring.m2259g() - a) - ring.m2258f()) * f) + ring.m2258f());
        ring.m2251c(ring.m2259g());
        ring.m2254d(((floor - ring.m2263k()) * f) + ring.m2263k());
    }

    private void m2275b() {
        Ring ring = this.f1125f;
        Animation c01121 = new C01121(this, ring);
        c01121.setRepeatCount(-1);
        c01121.setRepeatMode(1);
        c01121.setInterpolator(f1120b);
        c01121.setAnimationListener(new C01132(this, ring));
        this.f1129j = c01121;
    }
}
