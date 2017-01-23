package android.support.v4.view;

import aa;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import v;

public class a {
    private static final b DW;
    private static final Object FH;
    final Object j6;

    interface b {
        void DW(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void FH(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void Hw(Object obj, View view, AccessibilityEvent accessibilityEvent);

        aa j6(Object obj, View view);

        Object j6();

        Object j6(a aVar);

        void j6(Object obj, View view, int i);

        void j6(Object obj, View view, v vVar);

        boolean j6(Object obj, View view, int i, Bundle bundle);

        boolean j6(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean j6(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);
    }

    static class d implements b {
        d() {
        }

        public Object j6() {
            return null;
        }

        public Object j6(a aVar) {
            return null;
        }

        public boolean j6(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public void DW(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void j6(Object obj, View view, v vVar) {
        }

        public void FH(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public boolean j6(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void j6(Object obj, View view, int i) {
        }

        public void Hw(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public aa j6(Object obj, View view) {
            return null;
        }

        public boolean j6(Object obj, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static class a extends d {

        class 1 implements android.support.v4.view.b.a {
            final /* synthetic */ a DW;
            final /* synthetic */ a j6;

            1(a aVar, a aVar2) {
                this.DW = aVar;
                this.j6 = aVar2;
            }

            public boolean j6(View view, AccessibilityEvent accessibilityEvent) {
                return this.j6.DW(view, accessibilityEvent);
            }

            public void DW(View view, AccessibilityEvent accessibilityEvent) {
                this.j6.Hw(view, accessibilityEvent);
            }

            public void j6(View view, Object obj) {
                this.j6.j6(view, new v(obj));
            }

            public void FH(View view, AccessibilityEvent accessibilityEvent) {
                this.j6.FH(view, accessibilityEvent);
            }

            public boolean j6(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.j6.j6(viewGroup, view, accessibilityEvent);
            }

            public void j6(View view, int i) {
                this.j6.j6(view, i);
            }

            public void Hw(View view, AccessibilityEvent accessibilityEvent) {
                this.j6.j6(view, accessibilityEvent);
            }
        }

        a() {
        }

        public Object j6() {
            return b.j6();
        }

        public Object j6(a aVar) {
            return b.j6(new 1(this, aVar));
        }

        public boolean j6(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return b.j6(obj, view, accessibilityEvent);
        }

        public void DW(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            b.DW(obj, view, accessibilityEvent);
        }

        public void j6(Object obj, View view, v vVar) {
            b.j6(obj, view, vVar.j6());
        }

        public void FH(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            b.FH(obj, view, accessibilityEvent);
        }

        public boolean j6(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return b.j6(obj, viewGroup, view, accessibilityEvent);
        }

        public void j6(Object obj, View view, int i) {
            b.j6(obj, view, i);
        }

        public void Hw(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            b.Hw(obj, view, accessibilityEvent);
        }
    }

    static class c extends a {

        class 1 implements android.support.v4.view.c.a {
            final /* synthetic */ c DW;
            final /* synthetic */ a j6;

            1(c cVar, a aVar) {
                this.DW = cVar;
                this.j6 = aVar;
            }

            public boolean j6(View view, AccessibilityEvent accessibilityEvent) {
                return this.j6.DW(view, accessibilityEvent);
            }

            public void DW(View view, AccessibilityEvent accessibilityEvent) {
                this.j6.Hw(view, accessibilityEvent);
            }

            public void j6(View view, Object obj) {
                this.j6.j6(view, new v(obj));
            }

            public void FH(View view, AccessibilityEvent accessibilityEvent) {
                this.j6.FH(view, accessibilityEvent);
            }

            public boolean j6(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.j6.j6(viewGroup, view, accessibilityEvent);
            }

            public void j6(View view, int i) {
                this.j6.j6(view, i);
            }

            public void Hw(View view, AccessibilityEvent accessibilityEvent) {
                this.j6.j6(view, accessibilityEvent);
            }

            public Object j6(View view) {
                aa j6 = this.j6.j6(view);
                return j6 != null ? j6.j6() : null;
            }

            public boolean j6(View view, int i, Bundle bundle) {
                return this.j6.j6(view, i, bundle);
            }
        }

        c() {
        }

        public Object j6(a aVar) {
            return c.j6(new 1(this, aVar));
        }

        public aa j6(Object obj, View view) {
            Object j6 = c.j6(obj, view);
            if (j6 != null) {
                return new aa(j6);
            }
            return null;
        }

        public boolean j6(Object obj, View view, int i, Bundle bundle) {
            return c.j6(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            DW = new c();
        } else if (VERSION.SDK_INT >= 14) {
            DW = new a();
        } else {
            DW = new d();
        }
        FH = DW.j6();
    }

    public a() {
        this.j6 = DW.j6(this);
    }

    Object j6() {
        return this.j6;
    }

    public void j6(View view, int i) {
        DW.j6(FH, view, i);
    }

    public void j6(View view, AccessibilityEvent accessibilityEvent) {
        DW.Hw(FH, view, accessibilityEvent);
    }

    public boolean DW(View view, AccessibilityEvent accessibilityEvent) {
        return DW.j6(FH, view, accessibilityEvent);
    }

    public void FH(View view, AccessibilityEvent accessibilityEvent) {
        DW.FH(FH, view, accessibilityEvent);
    }

    public void Hw(View view, AccessibilityEvent accessibilityEvent) {
        DW.DW(FH, view, accessibilityEvent);
    }

    public void j6(View view, v vVar) {
        DW.j6(FH, view, vVar);
    }

    public boolean j6(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return DW.j6(FH, viewGroup, view, accessibilityEvent);
    }

    public aa j6(View view) {
        return DW.j6(FH, view);
    }

    public boolean j6(View view, int i, Bundle bundle) {
        return DW.j6(FH, view, i, bundle);
    }
}
