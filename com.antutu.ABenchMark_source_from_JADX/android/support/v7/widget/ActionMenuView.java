package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0439m;
import android.support.v7.view.menu.C0441l.C0342a;
import android.support.v7.view.menu.C0447f;
import android.support.v7.view.menu.C0447f.C0351a;
import android.support.v7.view.menu.C0447f.C0438b;
import android.support.v7.view.menu.C0450h;
import android.support.v7.widget.an.C0482a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends an implements C0438b, C0439m {
    private C0447f f1413a;
    private Context f1414b;
    private int f1415c;
    private boolean f1416d;
    private ActionMenuPresenter f1417e;
    private C0342a f1418f;
    private C0351a f1419g;
    private boolean f1420h;
    private int f1421i;
    private int f1422j;
    private int f1423k;
    private C0485e f1424l;

    /* renamed from: android.support.v7.widget.ActionMenuView.a */
    public interface C0437a {
        boolean m1312c();

        boolean m1313d();
    }

    /* renamed from: android.support.v7.widget.ActionMenuView.b */
    private class C0481b implements C0342a {
        final /* synthetic */ ActionMenuView f1388a;

        private C0481b(ActionMenuView actionMenuView) {
            this.f1388a = actionMenuView;
        }

        public void m1599a(C0447f c0447f, boolean z) {
        }

        public boolean m1600a(C0447f c0447f) {
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView.c */
    public static class C0483c extends C0482a {
        @ExportedProperty
        public boolean f1391a;
        @ExportedProperty
        public int f1392b;
        @ExportedProperty
        public int f1393c;
        @ExportedProperty
        public boolean f1394d;
        @ExportedProperty
        public boolean f1395e;
        boolean f1396f;

        public C0483c(int i, int i2) {
            super(i, i2);
            this.f1391a = false;
        }

        public C0483c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0483c(C0483c c0483c) {
            super(c0483c);
            this.f1391a = c0483c.f1391a;
        }

        public C0483c(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView.d */
    private class C0484d implements C0351a {
        final /* synthetic */ ActionMenuView f1397a;

        private C0484d(ActionMenuView actionMenuView) {
            this.f1397a = actionMenuView;
        }

        public void m1601a(C0447f c0447f) {
            if (this.f1397a.f1419g != null) {
                this.f1397a.f1419g.m912a(c0447f);
            }
        }

        public boolean m1602a(C0447f c0447f, MenuItem menuItem) {
            return this.f1397a.f1424l != null && this.f1397a.f1424l.m1603a(menuItem);
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuView.e */
    public interface C0485e {
        boolean m1603a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1422j = (int) (56.0f * f);
        this.f1423k = (int) (f * 4.0f);
        this.f1414b = context;
        this.f1415c = 0;
    }

    static int m1625a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        C0483c c0483c = (C0483c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m1320b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, LinearLayoutManager.INVALID_OFFSET), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0483c.f1391a && z2) {
            z = true;
        }
        c0483c.f1394d = z;
        c0483c.f1392b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    private void m1628c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f1422j;
        size = i3 % this.f1422j;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        Object obj;
        int i6 = this.f1422j + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj2 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            long j2;
            int i12;
            int i13;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i11 = paddingLeft;
                j2 = j;
                i12 = i7;
                i13 = i4;
                i4 = i8;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f1423k, 0, this.f1423k, 0);
                }
                C0483c c0483c = (C0483c) childAt.getLayoutParams();
                c0483c.f1396f = false;
                c0483c.f1393c = 0;
                c0483c.f1392b = 0;
                c0483c.f1394d = false;
                c0483c.leftMargin = 0;
                c0483c.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m1320b();
                c0483c.f1395e = z2;
                int a = m1625a(childAt, i6, c0483c.f1391a ? 1 : i4, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                paddingLeft = c0483c.f1394d ? i9 + 1 : i9;
                obj = c0483c.f1391a ? 1 : obj2;
                int i14 = i4 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = paddingLeft;
                    obj2 = obj;
                    j2 = j3;
                    i4 = i8;
                    i11 = i5;
                } else {
                    i11 = i5;
                    i4 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj2 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            }
            i10++;
            i8 = i4;
            i7 = i12;
            i4 = i13;
            j = j2;
            paddingLeft = i11;
        }
        Object obj3 = (obj2 == null || paddingLeft != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0483c = (C0483c) getChildAt(i15).getLayoutParams();
                if (c0483c.f1394d) {
                    int i16 = c0483c.f1392b;
                    if (r0 < i5) {
                        i4 = c0483c.f1392b;
                        j = (long) (1 << i15);
                        size = 1;
                    } else if (c0483c.f1392b == i5) {
                        j |= (long) (1 << i15);
                        size = i4 + 1;
                        i4 = i5;
                    } else {
                        size = i4;
                        i4 = i5;
                    }
                } else {
                    size = i4;
                    i4 = i5;
                }
                i15++;
                i5 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                c0483c = (C0483c) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj3 != null && c0483c.f1395e && i4 == 1) {
                        childAt2.setPadding(this.f1423k + i6, 0, this.f1423k, 0);
                    }
                    c0483c.f1392b++;
                    c0483c.f1396f = true;
                    size = i4 - 1;
                } else if (c0483c.f1392b == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj2 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0483c) getChildAt(0).getLayoutParams()).f1395e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0483c) getChildAt(childCount - 1).getLayoutParams()).f1395e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i4 = 0;
                    obj3 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj3;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0483c = (C0483c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0483c.f1393c = paddingLeft;
                                c0483c.f1396f = true;
                                if (i4 == 0 && !c0483c.f1395e) {
                                    c0483c.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0483c.f1391a) {
                                if (i4 != 0) {
                                    c0483c.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0483c.rightMargin = paddingLeft / 2;
                                }
                                obj = obj3;
                            } else {
                                c0483c.f1393c = paddingLeft;
                                c0483c.f1396f = true;
                                c0483c.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj3 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0483c = (C0483c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0483c.f1393c = paddingLeft;
                        c0483c.f1396f = true;
                        c0483c.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0483c.f1391a) {
                        if (i4 != 0) {
                            c0483c.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0483c.rightMargin = paddingLeft / 2;
                        }
                        obj = obj3;
                    } else {
                        c0483c.f1393c = paddingLeft;
                        c0483c.f1396f = true;
                        c0483c.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj3;
                }
                i4++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0483c = (C0483c) childAt.getLayoutParams();
                if (c0483c.f1396f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0483c.f1393c + (c0483c.f1392b * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    public C0483c m1629a(AttributeSet attributeSet) {
        return new C0483c(getContext(), attributeSet);
    }

    protected C0483c m1630a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m1636b();
        }
        C0483c c0483c = layoutParams instanceof C0483c ? new C0483c((C0483c) layoutParams) : new C0483c(layoutParams);
        if (c0483c.h > 0) {
            return c0483c;
        }
        c0483c.h = 16;
        return c0483c;
    }

    public void m1631a(C0447f c0447f) {
        this.f1413a = c0447f;
    }

    public void m1632a(C0342a c0342a, C0351a c0351a) {
        this.f1418f = c0342a;
        this.f1419g = c0351a;
    }

    public boolean m1633a() {
        return this.f1416d;
    }

    protected boolean m1634a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0437a)) {
            z = 0 | ((C0437a) childAt).m1313d();
        }
        return (i <= 0 || !(childAt2 instanceof C0437a)) ? z : ((C0437a) childAt2).m1312c() | z;
    }

    public boolean m1635a(C0450h c0450h) {
        return this.f1413a.m1403a((MenuItem) c0450h, 0);
    }

    protected C0483c m1636b() {
        C0483c c0483c = new C0483c(-2, -2);
        c0483c.h = 16;
        return c0483c;
    }

    public /* synthetic */ C0482a m1637b(AttributeSet attributeSet) {
        return m1629a(attributeSet);
    }

    protected /* synthetic */ C0482a m1638b(LayoutParams layoutParams) {
        return m1630a(layoutParams);
    }

    public C0483c m1639c() {
        C0483c b = m1636b();
        b.f1391a = true;
        return b;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0483c);
    }

    public C0447f m1640d() {
        return this.f1413a;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean m1641e() {
        return this.f1417e != null && this.f1417e.m1593d();
    }

    public boolean m1642f() {
        return this.f1417e != null && this.f1417e.m1594e();
    }

    public boolean m1643g() {
        return this.f1417e != null && this.f1417e.m1597h();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1636b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1629a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m1630a(layoutParams);
    }

    public Menu getMenu() {
        if (this.f1413a == null) {
            Context context = getContext();
            this.f1413a = new C0447f(context);
            this.f1413a.m1395a(new C0484d());
            this.f1417e = new ActionMenuPresenter(context);
            this.f1417e.m1589b(true);
            this.f1417e.m1350a(this.f1418f != null ? this.f1418f : new C0481b());
            this.f1413a.m1398a(this.f1417e, this.f1414b);
            this.f1417e.m1584a(this);
        }
        return this.f1413a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1417e.m1591c();
    }

    public int getPopupTheme() {
        return this.f1415c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean m1644h() {
        return this.f1417e != null && this.f1417e.m1598i();
    }

    public void m1645i() {
        if (this.f1417e != null) {
            this.f1417e.m1595f();
        }
    }

    protected /* synthetic */ C0482a m1646j() {
        return m1636b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f1417e != null) {
            this.f1417e.m1585a(false);
            if (this.f1417e.m1597h()) {
                this.f1417e.m1594e();
                this.f1417e.m1593d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1645i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1420h) {
            int i5;
            int i6;
            C0483c c0483c;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = bl.m2591a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0483c = (C0483c) childAt.getLayoutParams();
                    if (c0483c.f1391a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m1634a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0483c.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0483c.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0483c.leftMargin) + c0483c.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m1634a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0483c = (C0483c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0483c.f1391a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0483c.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0483c.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0483c = (C0483c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0483c.f1391a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0483c.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0483c.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f1420h;
        this.f1420h = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1420h) {
            this.f1421i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1420h || this.f1413a == null || size == this.f1421i)) {
            this.f1421i = size;
            this.f1413a.m1409b(true);
        }
        int childCount = getChildCount();
        if (!this.f1420h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0483c c0483c = (C0483c) getChildAt(i3).getLayoutParams();
                c0483c.rightMargin = 0;
                c0483c.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m1628c(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1417e.m1592c(z);
    }

    public void setOnMenuItemClickListener(C0485e c0485e) {
        this.f1424l = c0485e;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1417e.m1581a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f1416d = z;
    }

    public void setPopupTheme(int i) {
        if (this.f1415c != i) {
            this.f1415c = i;
            if (i == 0) {
                this.f1414b = getContext();
            } else {
                this.f1414b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1417e = actionMenuPresenter;
        this.f1417e.m1584a(this);
    }
}
