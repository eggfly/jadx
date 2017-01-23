package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class EdgeEffectCompat {
    private static final c DW;
    private Object j6;

    interface c {
        void DW(Object obj);

        boolean FH(Object obj);

        Object j6(Context context);

        void j6(Object obj, int i, int i2);

        boolean j6(Object obj);

        boolean j6(Object obj, float f);

        boolean j6(Object obj, float f, float f2);

        boolean j6(Object obj, int i);

        boolean j6(Object obj, Canvas canvas);
    }

    static class a implements c {
        a() {
        }

        public Object j6(Context context) {
            return null;
        }

        public void j6(Object obj, int i, int i2) {
        }

        public boolean j6(Object obj) {
            return true;
        }

        public void DW(Object obj) {
        }

        public boolean j6(Object obj, float f) {
            return false;
        }

        public boolean FH(Object obj) {
            return false;
        }

        public boolean j6(Object obj, int i) {
            return false;
        }

        public boolean j6(Object obj, Canvas canvas) {
            return false;
        }

        public boolean j6(Object obj, float f, float f2) {
            return false;
        }
    }

    static class b implements c {
        b() {
        }

        public Object j6(Context context) {
            return d.j6(context);
        }

        public void j6(Object obj, int i, int i2) {
            d.j6(obj, i, i2);
        }

        public boolean j6(Object obj) {
            return d.j6(obj);
        }

        public void DW(Object obj) {
            d.DW(obj);
        }

        public boolean j6(Object obj, float f) {
            return d.j6(obj, f);
        }

        public boolean FH(Object obj) {
            return d.FH(obj);
        }

        public boolean j6(Object obj, int i) {
            return d.j6(obj, i);
        }

        public boolean j6(Object obj, Canvas canvas) {
            return d.j6(obj, canvas);
        }

        public boolean j6(Object obj, float f, float f2) {
            return d.j6(obj, f);
        }
    }

    static class d extends b {
        d() {
        }

        public boolean j6(Object obj, float f, float f2) {
            return e.j6(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            DW = new d();
        } else if (VERSION.SDK_INT >= 14) {
            DW = new b();
        } else {
            DW = new a();
        }
    }

    public EdgeEffectCompat(Context context) {
        this.j6 = DW.j6(context);
    }

    public void j6(int i, int i2) {
        DW.j6(this.j6, i, i2);
    }

    public boolean j6() {
        return DW.j6(this.j6);
    }

    public void DW() {
        DW.DW(this.j6);
    }

    public boolean j6(float f) {
        return DW.j6(this.j6, f);
    }

    public boolean j6(float f, float f2) {
        return DW.j6(this.j6, f, f2);
    }

    public boolean FH() {
        return DW.FH(this.j6);
    }

    public boolean j6(int i) {
        return DW.j6(this.j6, i);
    }

    public boolean j6(Canvas canvas) {
        return DW.j6(this.j6, canvas);
    }
}
