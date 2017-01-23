package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class g {
    a DW;
    Object j6;

    interface a {
        int DW(Object obj);

        int FH(Object obj);

        float Hw(Object obj);

        int VH(Object obj);

        void Zo(Object obj);

        int gn(Object obj);

        Object j6(Context context, Interpolator interpolator);

        void j6(Object obj, int i, int i2, int i3, int i4);

        void j6(Object obj, int i, int i2, int i3, int i4, int i5);

        void j6(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        boolean j6(Object obj);

        boolean v5(Object obj);
    }

    static class b implements a {
        b() {
        }

        public Object j6(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public boolean j6(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public int DW(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public int FH(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public float Hw(Object obj) {
            return 0.0f;
        }

        public boolean v5(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public void j6(Object obj, int i, int i2, int i3, int i4) {
            ((Scroller) obj).startScroll(i, i2, i3, i4);
        }

        public void j6(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public void j6(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
        }

        public void Zo(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public int VH(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public int gn(Object obj) {
            return ((Scroller) obj).getFinalY();
        }
    }

    static class c implements a {
        c() {
        }

        public Object j6(Context context, Interpolator interpolator) {
            return h.j6(context, interpolator);
        }

        public boolean j6(Object obj) {
            return h.j6(obj);
        }

        public int DW(Object obj) {
            return h.DW(obj);
        }

        public int FH(Object obj) {
            return h.FH(obj);
        }

        public float Hw(Object obj) {
            return 0.0f;
        }

        public boolean v5(Object obj) {
            return h.Hw(obj);
        }

        public void j6(Object obj, int i, int i2, int i3, int i4) {
            h.j6(obj, i, i2, i3, i4);
        }

        public void j6(Object obj, int i, int i2, int i3, int i4, int i5) {
            h.j6(obj, i, i2, i3, i4, i5);
        }

        public void j6(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            h.j6(obj, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        }

        public void Zo(Object obj) {
            h.v5(obj);
        }

        public int VH(Object obj) {
            return h.Zo(obj);
        }

        public int gn(Object obj) {
            return h.VH(obj);
        }
    }

    static class d extends c {
        d() {
        }

        public float Hw(Object obj) {
            return i.j6(obj);
        }
    }

    public static g j6(Context context, Interpolator interpolator) {
        return new g(context, interpolator);
    }

    g(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    private g(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.DW = new d();
        } else if (i >= 9) {
            this.DW = new c();
        } else {
            this.DW = new b();
        }
        this.j6 = this.DW.j6(context, interpolator);
    }

    public boolean j6() {
        return this.DW.j6(this.j6);
    }

    public int DW() {
        return this.DW.DW(this.j6);
    }

    public int FH() {
        return this.DW.FH(this.j6);
    }

    public int Hw() {
        return this.DW.VH(this.j6);
    }

    public int v5() {
        return this.DW.gn(this.j6);
    }

    public float Zo() {
        return this.DW.Hw(this.j6);
    }

    public boolean VH() {
        return this.DW.v5(this.j6);
    }

    public void j6(int i, int i2, int i3, int i4) {
        this.DW.j6(this.j6, i, i2, i3, i4);
    }

    public void j6(int i, int i2, int i3, int i4, int i5) {
        this.DW.j6(this.j6, i, i2, i3, i4, i5);
    }

    public void j6(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.DW.j6(this.j6, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public void gn() {
        this.DW.Zo(this.j6);
    }
}
