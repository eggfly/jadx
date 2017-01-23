package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0493h;
import android.support.v7.widget.RecyclerView.C0529r;
import android.view.View;

class ay {
    static int m2459a(C0529r c0529r, as asVar, View view, View view2, C0493h c0493h, boolean z) {
        if (c0493h.getChildCount() == 0 || c0529r.m1929e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(c0493h.getPosition(view) - c0493h.getPosition(view2)) + 1;
        }
        return Math.min(asVar.m2396f(), asVar.m2390b(view2) - asVar.m2386a(view));
    }

    static int m2460a(C0529r c0529r, as asVar, View view, View view2, C0493h c0493h, boolean z, boolean z2) {
        if (c0493h.getChildCount() == 0 || c0529r.m1929e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (c0529r.m1929e() - Math.max(c0493h.getPosition(view), c0493h.getPosition(view2))) - 1) : Math.max(0, Math.min(c0493h.getPosition(view), c0493h.getPosition(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(asVar.m2390b(view2) - asVar.m2386a(view))) / ((float) (Math.abs(c0493h.getPosition(view) - c0493h.getPosition(view2)) + 1)))) + ((float) (asVar.m2391c() - asVar.m2386a(view))));
    }

    static int m2461b(C0529r c0529r, as asVar, View view, View view2, C0493h c0493h, boolean z) {
        if (c0493h.getChildCount() == 0 || c0529r.m1929e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0529r.m1929e();
        }
        return (int) ((((float) (asVar.m2390b(view2) - asVar.m2386a(view))) / ((float) (Math.abs(c0493h.getPosition(view) - c0493h.getPosition(view2)) + 1))) * ((float) c0529r.m1929e()));
    }
}
