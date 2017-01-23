package com.p063b.p077c.p078a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.b.c.a.a */
public final class C1888a extends Animation {
    public static final boolean f6427a;
    private static final WeakHashMap<View, C1888a> f6428b;
    private final WeakReference<View> f6429c;
    private final Camera f6430d;
    private boolean f6431e;
    private float f6432f;
    private float f6433g;
    private float f6434h;
    private float f6435i;
    private float f6436j;
    private float f6437k;
    private float f6438l;
    private float f6439m;
    private float f6440n;
    private float f6441o;
    private final RectF f6442p;
    private final RectF f6443q;
    private final Matrix f6444r;

    static {
        f6427a = Integer.valueOf(VERSION.SDK).intValue() < 11;
        f6428b = new WeakHashMap();
    }

    private C1888a(View view) {
        this.f6430d = new Camera();
        this.f6432f = 1.0f;
        this.f6438l = 1.0f;
        this.f6439m = 1.0f;
        this.f6442p = new RectF();
        this.f6443q = new RectF();
        this.f6444r = new Matrix();
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f6429c = new WeakReference(view);
    }

    public static C1888a m7089a(View view) {
        Animation animation = (C1888a) f6428b.get(view);
        if (animation != null && animation == view.getAnimation()) {
            return animation;
        }
        C1888a c1888a = new C1888a(view);
        f6428b.put(view, c1888a);
        return c1888a;
    }

    private void m7090a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.f6431e;
        float f = z ? this.f6433g : width / 2.0f;
        float f2 = z ? this.f6434h : height / 2.0f;
        float f3 = this.f6435i;
        float f4 = this.f6436j;
        float f5 = this.f6437k;
        if (!(f3 == 0.0f && f4 == 0.0f && f5 == 0.0f)) {
            Camera camera = this.f6430d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        f3 = this.f6438l;
        f4 = this.f6439m;
        if (!(f3 == 1.0f && f4 == 1.0f)) {
            matrix.postScale(f3, f4);
            matrix.postTranslate((-(f / width)) * ((f3 * width) - width), (-(f2 / height)) * ((f4 * height) - height));
        }
        matrix.postTranslate(this.f6440n, this.f6441o);
    }

    private void m7091a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f6444r;
        matrix.reset();
        m7090a(matrix, view);
        this.f6444r.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            f = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f;
        }
    }

    private void m7092o() {
        View view = (View) this.f6429c.get();
        if (view != null) {
            m7091a(this.f6442p, view);
        }
    }

    private void m7093p() {
        View view = (View) this.f6429c.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f6443q;
            m7091a(rectF, view);
            rectF.union(this.f6442p);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    public float m7094a() {
        return this.f6432f;
    }

    public void m7095a(float f) {
        if (this.f6432f != f) {
            this.f6432f = f;
            View view = (View) this.f6429c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    protected void applyTransformation(float f, Transformation transformation) {
        View view = (View) this.f6429c.get();
        if (view != null) {
            transformation.setAlpha(this.f6432f);
            m7090a(transformation.getMatrix(), view);
        }
    }

    public float m7096b() {
        return this.f6433g;
    }

    public void m7097b(float f) {
        if (!this.f6431e || this.f6433g != f) {
            m7092o();
            this.f6431e = true;
            this.f6433g = f;
            m7093p();
        }
    }

    public float m7098c() {
        return this.f6434h;
    }

    public void m7099c(float f) {
        if (!this.f6431e || this.f6434h != f) {
            m7092o();
            this.f6431e = true;
            this.f6434h = f;
            m7093p();
        }
    }

    public float m7100d() {
        return this.f6437k;
    }

    public void m7101d(float f) {
        if (this.f6437k != f) {
            m7092o();
            this.f6437k = f;
            m7093p();
        }
    }

    public float m7102e() {
        return this.f6435i;
    }

    public void m7103e(float f) {
        if (this.f6435i != f) {
            m7092o();
            this.f6435i = f;
            m7093p();
        }
    }

    public float m7104f() {
        return this.f6436j;
    }

    public void m7105f(float f) {
        if (this.f6436j != f) {
            m7092o();
            this.f6436j = f;
            m7093p();
        }
    }

    public float m7106g() {
        return this.f6438l;
    }

    public void m7107g(float f) {
        if (this.f6438l != f) {
            m7092o();
            this.f6438l = f;
            m7093p();
        }
    }

    public float m7108h() {
        return this.f6439m;
    }

    public void m7109h(float f) {
        if (this.f6439m != f) {
            m7092o();
            this.f6439m = f;
            m7093p();
        }
    }

    public int m7110i() {
        View view = (View) this.f6429c.get();
        return view == null ? 0 : view.getScrollX();
    }

    public void m7111i(float f) {
        if (this.f6440n != f) {
            m7092o();
            this.f6440n = f;
            m7093p();
        }
    }

    public int m7112j() {
        View view = (View) this.f6429c.get();
        return view == null ? 0 : view.getScrollY();
    }

    public void m7113j(float f) {
        if (this.f6441o != f) {
            m7092o();
            this.f6441o = f;
            m7093p();
        }
    }

    public float m7114k() {
        return this.f6440n;
    }

    public void m7115k(float f) {
        View view = (View) this.f6429c.get();
        if (view != null) {
            m7111i(f - ((float) view.getLeft()));
        }
    }

    public float m7116l() {
        return this.f6441o;
    }

    public void m7117l(float f) {
        View view = (View) this.f6429c.get();
        if (view != null) {
            m7113j(f - ((float) view.getTop()));
        }
    }

    public float m7118m() {
        View view = (View) this.f6429c.get();
        return view == null ? 0.0f : ((float) view.getLeft()) + this.f6440n;
    }

    public float m7119n() {
        View view = (View) this.f6429c.get();
        return view == null ? 0.0f : ((float) view.getTop()) + this.f6441o;
    }
}
