package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v7.widget.LinearLayoutManager.C0497a;
import android.support.v7.widget.LinearLayoutManager.C0498b;
import android.support.v7.widget.LinearLayoutManager.C0499c;
import android.support.v7.widget.RecyclerView.C0491i;
import android.support.v7.widget.RecyclerView.C0493h;
import android.support.v7.widget.RecyclerView.C0525n;
import android.support.v7.widget.RecyclerView.C0529r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean f1472a;
    int f1473b;
    int[] f1474c;
    View[] f1475d;
    final SparseIntArray f1476e;
    final SparseIntArray f1477f;
    C0489c f1478g;
    final Rect f1479h;

    /* renamed from: android.support.v7.widget.GridLayoutManager.c */
    public static abstract class C0489c {
        final SparseIntArray f1464a;
        private boolean f1465b;

        public C0489c() {
            this.f1464a = new SparseIntArray();
            this.f1465b = false;
        }

        public abstract int m1693a(int i);

        public int m1694a(int i, int i2) {
            int a = m1693a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int i3;
            if (this.f1465b && this.f1464a.size() > 0) {
                b = m1696b(i);
                if (b >= 0) {
                    a2 = this.f1464a.get(b) + m1693a(b);
                    b++;
                    i3 = b;
                    while (i3 < i) {
                        b = m1693a(i3);
                        a2 += b;
                        if (a2 == i2) {
                            b = 0;
                        } else if (a2 <= i2) {
                            b = a2;
                        }
                        i3++;
                        a2 = b;
                    }
                    return a2 + a > i2 ? a2 : 0;
                }
            }
            b = 0;
            a2 = 0;
            i3 = b;
            while (i3 < i) {
                b = m1693a(i3);
                a2 += b;
                if (a2 == i2) {
                    b = 0;
                } else if (a2 <= i2) {
                    b = a2;
                }
                i3++;
                a2 = b;
            }
            if (a2 + a > i2) {
            }
        }

        public void m1695a() {
            this.f1464a.clear();
        }

        int m1696b(int i) {
            int i2 = 0;
            int size = this.f1464a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f1464a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            return (size < 0 || size >= this.f1464a.size()) ? -1 : this.f1464a.keyAt(size);
        }

        int m1697b(int i, int i2) {
            if (!this.f1465b) {
                return m1694a(i, i2);
            }
            int i3 = this.f1464a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = m1694a(i, i2);
            this.f1464a.put(i, i3);
            return i3;
        }

        public int m1698c(int i, int i2) {
            int a = m1693a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int a2 = m1693a(i3);
                i5 += a2;
                if (i5 == i2) {
                    i4++;
                    a2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    a2 = i5;
                }
                i3++;
                i5 = a2;
            }
            return i5 + a > i2 ? i4 + 1 : i4;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager.a */
    public static final class C0490a extends C0489c {
        public int m1699a(int i) {
            return 1;
        }

        public int m1700a(int i, int i2) {
            return i % i2;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayoutManager.b */
    public static class C0492b extends C0491i {
        private int f1470e;
        private int f1471f;

        public C0492b(int i, int i2) {
            super(i, i2);
            this.f1470e = -1;
            this.f1471f = 0;
        }

        public C0492b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1470e = -1;
            this.f1471f = 0;
        }

        public C0492b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1470e = -1;
            this.f1471f = 0;
        }

        public C0492b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1470e = -1;
            this.f1471f = 0;
        }

        public int m1708a() {
            return this.f1470e;
        }

        public int m1709b() {
            return this.f1471f;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.f1472a = false;
        this.f1473b = -1;
        this.f1476e = new SparseIntArray();
        this.f1477f = new SparseIntArray();
        this.f1478g = new C0490a();
        this.f1479h = new Rect();
        m1725a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f1472a = false;
        this.f1473b = -1;
        this.f1476e = new SparseIntArray();
        this.f1477f = new SparseIntArray();
        this.f1478g = new C0490a();
        this.f1479h = new Rect();
        m1725a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1472a = false;
        this.f1473b = -1;
        this.f1476e = new SparseIntArray();
        this.f1477f = new SparseIntArray();
        this.f1478g = new C0490a();
        this.f1479h = new Rect();
        m1725a(C0493h.getProperties(context, attributeSet, i, i2).f1522b);
    }

    private int m1710a(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == LinearLayoutManager.INVALID_OFFSET || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int m1711a(C0525n c0525n, C0529r c0529r, int i) {
        if (!c0529r.m1925a()) {
            return this.f1478g.m1698c(i, this.f1473b);
        }
        int b = c0525n.m1871b(i);
        if (b != -1) {
            return this.f1478g.m1698c(b, this.f1473b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void m1712a(float f, int i) {
        m1719b(Math.max(Math.round(((float) this.f1473b) * f), i));
    }

    private void m1713a(C0525n c0525n, C0529r c0529r, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = i - 1;
            i3 = -1;
            i = -1;
        }
        if (this.mOrientation == 1 && isLayoutRTL()) {
            i5 = this.f1473b - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.f1475d[i5];
            C0492b c0492b = (C0492b) view.getLayoutParams();
            c0492b.f1471f = m1720c(c0525n, c0529r, getPosition(view));
            if (i6 != -1 || c0492b.f1471f <= 1) {
                c0492b.f1470e = i7;
            } else {
                c0492b.f1470e = i7 - (c0492b.f1471f - 1);
            }
            i7 += c0492b.f1471f * i6;
        }
    }

    private void m1714a(C0525n c0525n, C0529r c0529r, C0497a c0497a, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = m1717b(c0525n, c0529r, c0497a.f1484a);
        if (obj != null) {
            while (b > 0 && c0497a.f1484a > 0) {
                c0497a.f1484a--;
                b = m1717b(c0525n, c0529r, c0497a.f1484a);
            }
            return;
        }
        int e = c0529r.m1929e() - 1;
        int i2 = c0497a.f1484a;
        int i3 = b;
        while (i2 < e) {
            b = m1717b(c0525n, c0529r, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        c0497a.f1484a = i2;
    }

    private void m1715a(View view, int i, int i2, boolean z, boolean z2) {
        calculateItemDecorationsForChild(view, this.f1479h);
        C0491i c0491i = (C0491i) view.getLayoutParams();
        if (z || this.mOrientation == 1) {
            i = m1710a(i, c0491i.leftMargin + this.f1479h.left, c0491i.rightMargin + this.f1479h.right);
        }
        if (z || this.mOrientation == 0) {
            i2 = m1710a(i2, c0491i.topMargin + this.f1479h.top, c0491i.bottomMargin + this.f1479h.bottom);
        }
        if (z2 ? shouldReMeasureChild(view, i, i2, c0491i) : shouldMeasureChild(view, i, i2, c0491i)) {
            view.measure(i, i2);
        }
    }

    static int[] m1716a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    private int m1717b(C0525n c0525n, C0529r c0529r, int i) {
        if (!c0529r.m1925a()) {
            return this.f1478g.m1697b(i, this.f1473b);
        }
        int i2 = this.f1477f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0525n.m1871b(i);
        if (i2 != -1) {
            return this.f1478g.m1697b(i2, this.f1473b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void m1718b() {
        this.f1476e.clear();
        this.f1477f.clear();
    }

    private void m1719b(int i) {
        this.f1474c = m1716a(this.f1474c, this.f1473b, i);
    }

    private int m1720c(C0525n c0525n, C0529r c0529r, int i) {
        if (!c0529r.m1925a()) {
            return this.f1478g.m1693a(i);
        }
        int i2 = this.f1476e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0525n.m1871b(i);
        if (i2 != -1) {
            return this.f1478g.m1693a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void m1721c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0492b c0492b = (C0492b) getChildAt(i).getLayoutParams();
            int e = c0492b.m1703e();
            this.f1476e.put(e, c0492b.m1709b());
            this.f1477f.put(e, c0492b.m1708a());
        }
    }

    private void m1722d() {
        m1719b(getOrientation() == 1 ? (getWidth() - getPaddingRight()) - getPaddingLeft() : (getHeight() - getPaddingBottom()) - getPaddingTop());
    }

    private void m1723e() {
        if (this.f1475d == null || this.f1475d.length != this.f1473b) {
            this.f1475d = new View[this.f1473b];
        }
    }

    public int m1724a() {
        return this.f1473b;
    }

    public void m1725a(int i) {
        if (i != this.f1473b) {
            this.f1472a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f1473b = i;
            this.f1478g.m1695a();
        }
    }

    public boolean checkLayoutParams(C0491i c0491i) {
        return c0491i instanceof C0492b;
    }

    View findReferenceChild(C0525n c0525n, C0529r c0529r, int i, int i2, int i3) {
        View view = null;
        ensureLayoutState();
        int c = this.mOrientationHelper.m2391c();
        int d = this.mOrientationHelper.m2393d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (m1717b(c0525n, c0529r, position) != 0) {
                    view3 = view;
                    childAt = view2;
                } else if (((C0491i) childAt.getLayoutParams()).m1701c()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.mOrientationHelper.m2386a(childAt) < d && this.mOrientationHelper.m2390b(childAt) >= c) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = childAt;
            }
            view3 = view;
            childAt = view2;
            i += i4;
            view = view3;
            view2 = childAt;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public C0491i generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new C0492b(-2, -1) : new C0492b(-1, -2);
    }

    public C0491i generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new C0492b(context, attributeSet);
    }

    public C0491i generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0492b((MarginLayoutParams) layoutParams) : new C0492b(layoutParams);
    }

    public int getColumnCountForAccessibility(C0525n c0525n, C0529r c0529r) {
        return this.mOrientation == 1 ? this.f1473b : c0529r.m1929e() < 1 ? 0 : m1711a(c0525n, c0529r, c0529r.m1929e() - 1) + 1;
    }

    public int getRowCountForAccessibility(C0525n c0525n, C0529r c0529r) {
        return this.mOrientation == 0 ? this.f1473b : c0529r.m1929e() < 1 ? 0 : m1711a(c0525n, c0529r, c0529r.m1929e() - 1) + 1;
    }

    void layoutChunk(C0525n c0525n, C0529r c0529r, C0499c c0499c, C0498b c0498b) {
        int i = this.mOrientationHelper.m2399i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = getChildCount() > 0 ? this.f1474c[this.f1473b] : 0;
        if (obj != null) {
            m1722d();
        }
        boolean z = c0499c.f1496e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f1473b;
        if (!z) {
            i5 = m1717b(c0525n, c0529r, c0499c.f1495d) + m1720c(c0525n, c0529r, c0499c.f1495d);
        }
        while (i3 < this.f1473b && c0499c.m1741a(c0529r) && i5 > 0) {
            int i6 = c0499c.f1495d;
            int c = m1720c(c0525n, c0529r, i6);
            if (c <= this.f1473b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = c0499c.m1738a(c0525n);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.f1475d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.f1473b + " spans.");
        }
        if (i3 == 0) {
            c0498b.f1489b = true;
            return;
        }
        View view;
        int childMeasureSpec;
        int childMeasureSpec2;
        m1713a(c0525n, c0529r, i3, i4, z);
        int i7 = 0;
        float f = 0.0f;
        c = 0;
        while (i7 < i3) {
            View view2 = this.f1475d[i7];
            if (c0499c.f1502k == null) {
                if (z) {
                    addView(view2);
                } else {
                    addView(view2, 0);
                }
            } else if (z) {
                addDisappearingView(view2);
            } else {
                addDisappearingView(view2, 0);
            }
            C0492b c0492b = (C0492b) view2.getLayoutParams();
            int childMeasureSpec3 = C0493h.getChildMeasureSpec(this.f1474c[c0492b.f1470e + c0492b.f1471f] - this.f1474c[c0492b.f1470e], i, 0, this.mOrientation == 0 ? c0492b.height : c0492b.width, false);
            int childMeasureSpec4 = C0493h.getChildMeasureSpec(this.mOrientationHelper.m2396f(), this.mOrientationHelper.m2398h(), 0, this.mOrientation == 1 ? c0492b.height : c0492b.width, true);
            if (this.mOrientation == 1) {
                m1715a(view2, childMeasureSpec3, childMeasureSpec4, c0492b.height == -1, false);
            } else {
                m1715a(view2, childMeasureSpec4, childMeasureSpec3, c0492b.width == -1, false);
            }
            i6 = this.mOrientationHelper.m2392c(view2);
            if (i6 <= c) {
                i6 = c;
            }
            float d = (1.0f * ((float) this.mOrientationHelper.m2394d(view2))) / ((float) c0492b.f1471f);
            if (d <= f) {
                d = f;
            }
            i7++;
            f = d;
            c = i6;
        }
        if (obj != null) {
            m1712a(f, i2);
            c = 0;
            int i8 = 0;
            while (i8 < i3) {
                view = this.f1475d[i8];
                c0492b = (C0492b) view.getLayoutParams();
                childMeasureSpec = C0493h.getChildMeasureSpec(this.f1474c[c0492b.f1470e + c0492b.f1471f] - this.f1474c[c0492b.f1470e], 1073741824, 0, this.mOrientation == 0 ? c0492b.height : c0492b.width, false);
                childMeasureSpec2 = C0493h.getChildMeasureSpec(this.mOrientationHelper.m2396f(), this.mOrientationHelper.m2398h(), 0, this.mOrientation == 1 ? c0492b.height : c0492b.width, true);
                if (this.mOrientation == 1) {
                    m1715a(view, childMeasureSpec, childMeasureSpec2, false, true);
                } else {
                    m1715a(view, childMeasureSpec2, childMeasureSpec, false, true);
                }
                i5 = this.mOrientationHelper.m2392c(view);
                if (i5 <= c) {
                    i5 = c;
                }
                i8++;
                c = i5;
            }
        }
        childMeasureSpec2 = MeasureSpec.makeMeasureSpec(c, 1073741824);
        for (i6 = 0; i6 < i3; i6++) {
            view = this.f1475d[i6];
            if (this.mOrientationHelper.m2392c(view) != c) {
                c0492b = (C0492b) view.getLayoutParams();
                childMeasureSpec = C0493h.getChildMeasureSpec(this.f1474c[c0492b.f1470e + c0492b.f1471f] - this.f1474c[c0492b.f1470e], 1073741824, 0, this.mOrientation == 0 ? c0492b.height : c0492b.width, false);
                if (this.mOrientation == 1) {
                    m1715a(view, childMeasureSpec, childMeasureSpec2, true, true);
                } else {
                    m1715a(view, childMeasureSpec2, childMeasureSpec, true, true);
                }
            }
        }
        c0498b.f1488a = c;
        i6 = 0;
        i5 = 0;
        if (this.mOrientation == 1) {
            if (c0499c.f1497f == -1) {
                i5 = c0499c.f1493b;
                i6 = i5 - c;
                c = 0;
                i4 = 0;
            } else {
                i6 = c0499c.f1493b;
                i5 = i6 + c;
                c = 0;
                i4 = 0;
            }
        } else if (c0499c.f1497f == -1) {
            i4 = c0499c.f1493b;
            int i9 = i4;
            i4 -= c;
            c = i9;
        } else {
            i4 = c0499c.f1493b;
            c += i4;
        }
        int i10 = 0;
        childMeasureSpec = i4;
        i4 = c;
        c = i6;
        i6 = i5;
        while (i10 < i3) {
            int i11;
            int i12;
            view = this.f1475d[i10];
            c0492b = (C0492b) view.getLayoutParams();
            if (this.mOrientation != 1) {
                c = this.f1474c[c0492b.f1470e] + getPaddingTop();
                i6 = this.mOrientationHelper.m2394d(view) + c;
                i11 = i4;
                i12 = childMeasureSpec;
            } else if (isLayoutRTL()) {
                i4 = getPaddingLeft() + this.f1474c[c0492b.f1470e + c0492b.f1471f];
                i11 = i4;
                i12 = i4 - this.mOrientationHelper.m2394d(view);
            } else {
                childMeasureSpec = this.f1474c[c0492b.f1470e] + getPaddingLeft();
                i11 = this.mOrientationHelper.m2394d(view) + childMeasureSpec;
                i12 = childMeasureSpec;
            }
            layoutDecorated(view, i12 + c0492b.leftMargin, c + c0492b.topMargin, i11 - c0492b.rightMargin, i6 - c0492b.bottomMargin);
            if (c0492b.m1701c() || c0492b.m1702d()) {
                c0498b.f1490c = true;
            }
            c0498b.f1491d |= view.isFocusable();
            i10++;
            i4 = i11;
            childMeasureSpec = i12;
        }
        Arrays.fill(this.f1475d, null);
    }

    void onAnchorReady(C0525n c0525n, C0529r c0529r, C0497a c0497a, int i) {
        super.onAnchorReady(c0525n, c0529r, c0497a, i);
        m1722d();
        if (c0529r.m1929e() > 0 && !c0529r.m1925a()) {
            m1714a(c0525n, c0529r, c0497a, i);
        }
        m1723e();
    }

    public View onFocusSearchFailed(View view, int i, C0525n c0525n, C0529r c0529r) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        C0492b c0492b = (C0492b) findContainingItemView.getLayoutParams();
        int a = c0492b.f1470e;
        int a2 = c0492b.f1470e + c0492b.f1471f;
        if (super.onFocusSearchFailed(view, i, c0525n, c0529r) == null) {
            return null;
        }
        int childCount;
        int i2;
        int i3;
        if (((convertFocusDirectionToLayoutDirection(i) == 1) != this.mShouldReverseLayout ? 1 : null) != null) {
            childCount = getChildCount() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            childCount = 0;
            i2 = 1;
            i3 = getChildCount();
        }
        Object obj = (this.mOrientation == 1 && isLayoutRTL()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = childCount;
        while (i6 != i3) {
            View childAt = getChildAt(i6);
            if (childAt == findContainingItemView) {
                break;
            }
            View view3;
            if (childAt.isFocusable()) {
                c0492b = (C0492b) childAt.getLayoutParams();
                int a3 = c0492b.f1470e;
                int a4 = c0492b.f1470e + c0492b.f1471f;
                if (a3 == a && a4 == a2) {
                    return childAt;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = c0492b.f1470e;
                    childCount = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = childAt;
                } else {
                    childCount = i5;
                    i5 = i4;
                    view3 = view2;
                }
            } else {
                childCount = i5;
                i5 = i4;
                view3 = view2;
            }
            i6 += i2;
            view2 = view3;
            i4 = i5;
            i5 = childCount;
        }
        return view2;
    }

    public void onInitializeAccessibilityNodeInfoForItem(C0525n c0525n, C0529r c0529r, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0492b) {
            C0492b c0492b = (C0492b) layoutParams;
            int a = m1711a(c0525n, c0529r, c0492b.m1703e());
            if (this.mOrientation == 0) {
                int a2 = c0492b.m1708a();
                int b = c0492b.m1709b();
                boolean z = this.f1473b > 1 && c0492b.m1709b() == this.f1473b;
                accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(a2, b, a, 1, z, false));
                return;
            }
            int a3 = c0492b.m1708a();
            int b2 = c0492b.m1709b();
            boolean z2 = this.f1473b > 1 && c0492b.m1709b() == this.f1473b;
            accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(a, 1, a3, b2, z2, false));
            return;
        }
        super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f1478g.m1695a();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f1478g.m1695a();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f1478g.m1695a();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f1478g.m1695a();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f1478g.m1695a();
    }

    public void onLayoutChildren(C0525n c0525n, C0529r c0529r) {
        if (c0529r.m1925a()) {
            m1721c();
        }
        super.onLayoutChildren(c0525n, c0529r);
        m1718b();
        if (!c0529r.m1925a()) {
            this.f1472a = false;
        }
    }

    public int scrollHorizontallyBy(int i, C0525n c0525n, C0529r c0529r) {
        m1722d();
        m1723e();
        return super.scrollHorizontallyBy(i, c0525n, c0529r);
    }

    public int scrollVerticallyBy(int i, C0525n c0525n, C0529r c0529r) {
        m1722d();
        m1723e();
        return super.scrollVerticallyBy(i, c0525n, c0529r);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        if (this.f1474c == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            paddingTop = C0493h.chooseSize(i2, paddingTop + rect.height(), getMinimumHeight());
            paddingRight = C0493h.chooseSize(i, paddingRight + this.f1474c[this.f1474c.length - 1], getMinimumWidth());
        } else {
            paddingRight = C0493h.chooseSize(i, paddingRight + rect.width(), getMinimumWidth());
            paddingTop = C0493h.chooseSize(i2, paddingTop + this.f1474c[this.f1474c.length - 1], getMinimumHeight());
        }
        setMeasuredDimension(paddingRight, paddingTop);
    }

    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f1472a;
    }
}
