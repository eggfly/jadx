package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0525n;
import android.support.v7.widget.RecyclerView.C0529r;
import android.view.View;

class am {
    boolean f1819a;
    int f1820b;
    int f1821c;
    int f1822d;
    int f1823e;
    int f1824f;
    int f1825g;
    boolean f1826h;
    boolean f1827i;

    am() {
        this.f1819a = true;
        this.f1824f = 0;
        this.f1825g = 0;
    }

    View m2324a(C0525n c0525n) {
        View c = c0525n.m1877c(this.f1821c);
        this.f1821c += this.f1822d;
        return c;
    }

    boolean m2325a(C0529r c0529r) {
        return this.f1821c >= 0 && this.f1821c < c0529r.m1929e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1820b + ", mCurrentPosition=" + this.f1821c + ", mItemDirection=" + this.f1822d + ", mLayoutDirection=" + this.f1823e + ", mStartLine=" + this.f1824f + ", mEndLine=" + this.f1825g + '}';
    }
}
