package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

public class z {
    static final k j6;

    interface k {
        void DW(View view);

        void DW(View view, float f);

        boolean DW(View view, int i);

        boolean EQ(View view);

        int FH(View view);

        void FH(View view, float f);

        void FH(View view, int i);

        int Hw(View view);

        void J0(View view);

        boolean VH(View view);

        ViewParent Zo(View view);

        boolean gn(View view);

        int j6(View view);

        void j6(View view, float f);

        void j6(View view, int i, int i2, int i3, int i4);

        void j6(View view, int i, Paint paint);

        void j6(View view, Paint paint);

        void j6(View view, a aVar);

        void j6(View view, Runnable runnable);

        void j6(View view, boolean z);

        void j6(ViewGroup viewGroup, boolean z);

        boolean j6(View view, int i);

        float tp(View view);

        float u7(View view);

        int v5(View view);

        boolean we(View view);
    }

    static class a implements k {
        WeakHashMap<View, Object> j6;

        a() {
            this.j6 = null;
        }

        public boolean j6(View view, int i) {
            return (view instanceof w) && j6((w) view, i);
        }

        public boolean DW(View view, int i) {
            return (view instanceof w) && DW((w) view, i);
        }

        public int j6(View view) {
            return 2;
        }

        public void j6(View view, a aVar) {
        }

        public void DW(View view) {
            view.invalidate();
        }

        public void j6(View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }

        public void j6(View view, Runnable runnable) {
            view.postDelayed(runnable, j6());
        }

        long j6() {
            return 10;
        }

        public int FH(View view) {
            return 0;
        }

        public void FH(View view, int i) {
        }

        public void j6(View view, int i, Paint paint) {
        }

        public int Hw(View view) {
            return 0;
        }

        public void j6(View view, Paint paint) {
        }

        public int v5(View view) {
            return 0;
        }

        public ViewParent Zo(View view) {
            return view.getParent();
        }

        public boolean VH(View view) {
            Drawable background = view.getBackground();
            if (background == null || background.getOpacity() != -1) {
                return false;
            }
            return true;
        }

        public boolean gn(View view) {
            return true;
        }

        public float u7(View view) {
            return 0.0f;
        }

        public void j6(View view, float f) {
        }

        public void DW(View view, float f) {
        }

        public void FH(View view, float f) {
        }

        public float tp(View view) {
            return 0.0f;
        }

        public void j6(ViewGroup viewGroup, boolean z) {
        }

        public boolean EQ(View view) {
            return false;
        }

        public void j6(View view, boolean z) {
        }

        public boolean we(View view) {
            if (view instanceof r) {
                return ((r) view).isNestedScrollingEnabled();
            }
            return false;
        }

        private boolean j6(w wVar, int i) {
            int DW = wVar.DW();
            int j6 = wVar.j6() - wVar.FH();
            if (j6 == 0) {
                return false;
            }
            if (i < 0) {
                if (DW <= 0) {
                    return false;
                }
                return true;
            } else if (DW >= j6 - 1) {
                return false;
            } else {
                return true;
            }
        }

        private boolean DW(w wVar, int i) {
            int v5 = wVar.v5();
            int Hw = wVar.Hw() - wVar.Zo();
            if (Hw == 0) {
                return false;
            }
            if (i < 0) {
                if (v5 <= 0) {
                    return false;
                }
                return true;
            } else if (v5 >= Hw - 1) {
                return false;
            } else {
                return true;
            }
        }

        public void J0(View view) {
            if (view instanceof r) {
                ((r) view).stopNestedScroll();
            }
        }
    }

    static class b extends a {
        b() {
        }

        public boolean VH(View view) {
            return aa.j6(view);
        }

        public void j6(ViewGroup viewGroup, boolean z) {
            aa.j6(viewGroup, z);
        }
    }

    static class c extends b {
        c() {
        }

        public int j6(View view) {
            return ab.j6(view);
        }
    }

    static class d extends c {
        d() {
        }

        long j6() {
            return ac.j6();
        }

        public void j6(View view, int i, Paint paint) {
            ac.j6(view, i, paint);
        }

        public int Hw(View view) {
            return ac.j6(view);
        }

        public void j6(View view, Paint paint) {
            j6(view, Hw(view), paint);
            view.invalidate();
        }

        public void j6(View view, float f) {
            ac.j6(view, f);
        }

        public void DW(View view, float f) {
            ac.DW(view, f);
        }

        public float u7(View view) {
            return ac.DW(view);
        }

        public void j6(View view, boolean z) {
            ac.j6(view, z);
        }
    }

    static class e extends d {
        static boolean DW;

        e() {
        }

        static {
            DW = false;
        }

        public boolean j6(View view, int i) {
            return ad.j6(view, i);
        }

        public boolean DW(View view, int i) {
            return ad.DW(view, i);
        }

        public void j6(View view, a aVar) {
            ad.j6(view, aVar == null ? null : aVar.j6());
        }
    }

    static class f extends e {
        f() {
        }

        public void DW(View view) {
            ae.j6(view);
        }

        public void j6(View view, int i, int i2, int i3, int i4) {
            ae.j6(view, i, i2, i3, i4);
        }

        public void j6(View view, Runnable runnable) {
            ae.j6(view, runnable);
        }

        public int FH(View view) {
            return ae.DW(view);
        }

        public void FH(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            ae.j6(view, i);
        }

        public ViewParent Zo(View view) {
            return ae.FH(view);
        }

        public boolean EQ(View view) {
            return ae.Hw(view);
        }

        public boolean gn(View view) {
            return ae.v5(view);
        }
    }

    static class g extends f {
        g() {
        }

        public void j6(View view, Paint paint) {
            af.j6(view, paint);
        }

        public int v5(View view) {
            return af.j6(view);
        }
    }

    static class h extends g {
        h() {
        }
    }

    static class i extends h {
        i() {
        }

        public void FH(View view, int i) {
            ae.j6(view, i);
        }
    }

    static class j extends i {
        j() {
        }

        public void FH(View view, float f) {
            ag.j6(view, f);
        }

        public float tp(View view) {
            return ag.j6(view);
        }

        public boolean we(View view) {
            return ag.DW(view);
        }

        public void J0(View view) {
            ag.FH(view);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            j6 = new j();
        } else if (i >= 19) {
            j6 = new i();
        } else if (i >= 17) {
            j6 = new g();
        } else if (i >= 16) {
            j6 = new f();
        } else if (i >= 14) {
            j6 = new e();
        } else if (i >= 11) {
            j6 = new d();
        } else if (i >= 9) {
            j6 = new c();
        } else if (i >= 7) {
            j6 = new b();
        } else {
            j6 = new a();
        }
    }

    public static boolean j6(View view, int i) {
        return j6.j6(view, i);
    }

    public static boolean DW(View view, int i) {
        return j6.DW(view, i);
    }

    public static int j6(View view) {
        return j6.j6(view);
    }

    public static void j6(View view, a aVar) {
        j6.j6(view, aVar);
    }

    public static void DW(View view) {
        j6.DW(view);
    }

    public static void j6(View view, int i, int i2, int i3, int i4) {
        j6.j6(view, i, i2, i3, i4);
    }

    public static void j6(View view, Runnable runnable) {
        j6.j6(view, runnable);
    }

    public static int FH(View view) {
        return j6.FH(view);
    }

    public static void FH(View view, int i) {
        j6.FH(view, i);
    }

    public static void j6(View view, int i, Paint paint) {
        j6.j6(view, i, paint);
    }

    public static int Hw(View view) {
        return j6.Hw(view);
    }

    public static void j6(View view, Paint paint) {
        j6.j6(view, paint);
    }

    public static int v5(View view) {
        return j6.v5(view);
    }

    public static ViewParent Zo(View view) {
        return j6.Zo(view);
    }

    public static boolean VH(View view) {
        return j6.VH(view);
    }

    public static void j6(View view, float f) {
        j6.j6(view, f);
    }

    public static void DW(View view, float f) {
        j6.DW(view, f);
    }

    public static float gn(View view) {
        return j6.u7(view);
    }

    public static void FH(View view, float f) {
        j6.FH(view, f);
    }

    public static float u7(View view) {
        return j6.tp(view);
    }

    public static void j6(ViewGroup viewGroup, boolean z) {
        j6.j6(viewGroup, z);
    }

    public static boolean tp(View view) {
        return j6.EQ(view);
    }

    public static void j6(View view, boolean z) {
        j6.j6(view, z);
    }

    public static boolean EQ(View view) {
        return j6.gn(view);
    }

    public static boolean we(View view) {
        return j6.we(view);
    }

    public static void J0(View view) {
        j6.J0(view);
    }
}
