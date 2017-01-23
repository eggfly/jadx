package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl {
    static final DrawerLayoutCompatImpl f1040a;
    private static final int[] f1041b;
    private static final boolean f1042c;
    private static final boolean f1043d;
    private Drawable f1044A;
    private CharSequence f1045B;
    private CharSequence f1046C;
    private Object f1047D;
    private boolean f1048E;
    private Drawable f1049F;
    private Drawable f1050G;
    private Drawable f1051H;
    private Drawable f1052I;
    private final ArrayList<View> f1053J;
    private final ChildAccessibilityDelegate f1054e;
    private float f1055f;
    private int f1056g;
    private int f1057h;
    private float f1058i;
    private Paint f1059j;
    private final ViewDragHelper f1060k;
    private final ViewDragHelper f1061l;
    private final ViewDragCallback f1062m;
    private final ViewDragCallback f1063n;
    private int f1064o;
    private boolean f1065p;
    private boolean f1066q;
    private int f1067r;
    private int f1068s;
    private boolean f1069t;
    private boolean f1070u;
    private DrawerListener f1071v;
    private float f1072w;
    private float f1073x;
    private Drawable f1074y;
    private Drawable f1075z;

    public interface DrawerListener {
        void m52a(int i);

        void m53a(View view);

        void m54a(View view, float f);

        void m55b(View view);
    }

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ DrawerLayout f1025b;
        private final Rect f1026c;

        AccessibilityDelegate(DrawerLayout drawerLayout) {
            this.f1025b = drawerLayout;
            this.f1026c = new Rect();
        }

        public void m2066a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.f1042c) {
                super.m1192a(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat a = AccessibilityNodeInfoCompat.m1791a(accessibilityNodeInfoCompat);
                super.m1192a(view, a);
                accessibilityNodeInfoCompat.m1806b(view);
                ViewParent g = ViewCompat.m1468g(view);
                if (g instanceof View) {
                    accessibilityNodeInfoCompat.m1817d((View) g);
                }
                m2064a(accessibilityNodeInfoCompat, a);
                a.m1840u();
                m2065a(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.m1808b(DrawerLayout.class.getName());
            accessibilityNodeInfoCompat.m1802a(false);
            accessibilityNodeInfoCompat.m1809b(false);
            accessibilityNodeInfoCompat.m1803a(AccessibilityActionCompat.f924a);
            accessibilityNodeInfoCompat.m1803a(AccessibilityActionCompat.f925b);
        }

        public void m2069d(View view, AccessibilityEvent accessibilityEvent) {
            super.m1198d(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public boolean m2068b(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.m1196b(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View a = this.f1025b.m2129k();
            if (a != null) {
                CharSequence a2 = this.f1025b.m2135a(this.f1025b.m2149e(a));
                if (a2 != null) {
                    text.add(a2);
                }
            }
            return true;
        }

        public boolean m2067a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f1042c || DrawerLayout.m2132n(view)) {
                return super.m1195a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private void m2065a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.m2132n(childAt)) {
                    accessibilityNodeInfoCompat.m1812c(childAt);
                }
            }
        }

        private void m2064a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f1026c;
            accessibilityNodeInfoCompat2.m1799a(rect);
            accessibilityNodeInfoCompat.m1805b(rect);
            accessibilityNodeInfoCompat2.m1811c(rect);
            accessibilityNodeInfoCompat.m1816d(rect);
            accessibilityNodeInfoCompat.m1814c(accessibilityNodeInfoCompat2.m1828i());
            accessibilityNodeInfoCompat.m1801a(accessibilityNodeInfoCompat2.m1836q());
            accessibilityNodeInfoCompat.m1808b(accessibilityNodeInfoCompat2.m1837r());
            accessibilityNodeInfoCompat.m1813c(accessibilityNodeInfoCompat2.m1839t());
            accessibilityNodeInfoCompat.m1825h(accessibilityNodeInfoCompat2.m1833n());
            accessibilityNodeInfoCompat.m1821f(accessibilityNodeInfoCompat2.m1831l());
            accessibilityNodeInfoCompat.m1802a(accessibilityNodeInfoCompat2.m1824g());
            accessibilityNodeInfoCompat.m1809b(accessibilityNodeInfoCompat2.m1826h());
            accessibilityNodeInfoCompat.m1818d(accessibilityNodeInfoCompat2.m1829j());
            accessibilityNodeInfoCompat.m1819e(accessibilityNodeInfoCompat2.m1830k());
            accessibilityNodeInfoCompat.m1823g(accessibilityNodeInfoCompat2.m1832m());
            accessibilityNodeInfoCompat.m1798a(accessibilityNodeInfoCompat2.m1810c());
        }
    }

    final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ DrawerLayout f1027b;

        ChildAccessibilityDelegate(DrawerLayout drawerLayout) {
            this.f1027b = drawerLayout;
        }

        public void m2070a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.m1192a(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.m2132n(view)) {
                accessibilityNodeInfoCompat.m1817d(null);
            }
        }
    }

    interface DrawerLayoutCompatImpl {
        int m2071a(Object obj);

        Drawable m2072a(Context context);

        void m2073a(View view);

        void m2074a(View view, Object obj, int i);

        void m2075a(MarginLayoutParams marginLayoutParams, Object obj, int i);
    }

    static class DrawerLayoutCompatImplApi21 implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplApi21() {
        }

        public void m2078a(View view) {
            DrawerLayoutCompatApi21.m2158a(view);
        }

        public void m2079a(View view, Object obj, int i) {
            DrawerLayoutCompatApi21.m2159a(view, obj, i);
        }

        public void m2080a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            DrawerLayoutCompatApi21.m2160a(marginLayoutParams, obj, i);
        }

        public int m2076a(Object obj) {
            return DrawerLayoutCompatApi21.m2156a(obj);
        }

        public Drawable m2077a(Context context) {
            return DrawerLayoutCompatApi21.m2157a(context);
        }
    }

    static class DrawerLayoutCompatImplBase implements DrawerLayoutCompatImpl {
        DrawerLayoutCompatImplBase() {
        }

        public void m2083a(View view) {
        }

        public void m2084a(View view, Object obj, int i) {
        }

        public void m2085a(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public int m2081a(Object obj) {
            return 0;
        }

        public Drawable m2082a(Context context) {
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface EdgeGravity {
    }

    public static class LayoutParams extends MarginLayoutParams {
        public int f1028a;
        float f1029b;
        boolean f1030c;
        boolean f1031d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1028a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f1041b);
            this.f1028a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1028a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1028a = 0;
            this.f1028a = layoutParams.f1028a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1028a = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1028a = 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface LockMode {
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f1032a;
        int f1033b;
        int f1034c;

        /* renamed from: android.support.v4.widget.DrawerLayout.SavedState.1 */
        final class C01091 implements Creator<SavedState> {
            C01091() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2086a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2087a(i);
            }

            public SavedState m2086a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2087a(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1032a = 0;
            this.f1033b = 0;
            this.f1034c = 0;
            this.f1032a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f1032a = 0;
            this.f1033b = 0;
            this.f1034c = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1032a);
        }

        static {
            CREATOR = new C01091();
        }
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    private class ViewDragCallback extends Callback {
        final /* synthetic */ DrawerLayout f1036a;
        private final int f1037b;
        private ViewDragHelper f1038c;
        private final Runnable f1039d;

        /* renamed from: android.support.v4.widget.DrawerLayout.ViewDragCallback.1 */
        class C01101 implements Runnable {
            final /* synthetic */ ViewDragCallback f1035a;

            C01101(ViewDragCallback viewDragCallback) {
                this.f1035a = viewDragCallback;
            }

            public void run() {
                this.f1035a.m2103c();
            }
        }

        public ViewDragCallback(DrawerLayout drawerLayout, int i) {
            this.f1036a = drawerLayout;
            this.f1039d = new C01101(this);
            this.f1037b = i;
        }

        public void m2109a(ViewDragHelper viewDragHelper) {
            this.f1038c = viewDragHelper;
        }

        public void m2106a() {
            this.f1036a.removeCallbacks(this.f1039d);
        }

        public boolean m2112a(View view, int i) {
            return this.f1036a.m2151g(view) && this.f1036a.m2141a(view, this.f1037b) && this.f1036a.m2133a(view) == 0;
        }

        public void m2107a(int i) {
            this.f1036a.m2137a(this.f1037b, i, this.f1038c.m2536c());
        }

        public void m2111a(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (this.f1036a.m2141a(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (this.f1036a.getWidth() - i)) / ((float) width);
            }
            this.f1036a.m2145b(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            this.f1036a.invalidate();
        }

        public void m2115b(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f1030c = false;
            m2102b();
        }

        private void m2102b() {
            int i = 3;
            if (this.f1037b == 3) {
                i = 5;
            }
            View b = this.f1036a.m2142b(i);
            if (b != null) {
                this.f1036a.m2153i(b);
            }
        }

        public void m2110a(View view, float f, float f2) {
            int i;
            float d = this.f1036a.m2148d(view);
            int width = view.getWidth();
            if (this.f1036a.m2141a(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
            } else {
                i = this.f1036a.getWidth();
                if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                    i -= width;
                }
            }
            this.f1038c.m2526a(i, view.getTop());
            this.f1036a.invalidate();
        }

        public void m2108a(int i, int i2) {
            this.f1036a.postDelayed(this.f1039d, 160);
        }

        private void m2103c() {
            View view;
            int i;
            int i2 = 0;
            int b = this.f1038c.m2530b();
            boolean z = this.f1037b == 3;
            if (z) {
                View b2 = this.f1036a.m2142b(3);
                if (b2 != null) {
                    i2 = -b2.getWidth();
                }
                i2 += b;
                view = b2;
                i = i2;
            } else {
                i2 = this.f1036a.getWidth() - b;
                view = this.f1036a.m2142b(5);
                i = i2;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.f1036a.m2133a(view) == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                this.f1038c.m2528a(view, i, view.getTop());
                layoutParams.f1030c = true;
                this.f1036a.invalidate();
                m2102b();
                this.f1036a.m2146c();
            }
        }

        public boolean m2116b(int i) {
            return false;
        }

        public void m2114b(int i, int i2) {
            View b;
            if ((i & 1) == 1) {
                b = this.f1036a.m2142b(3);
            } else {
                b = this.f1036a.m2142b(5);
            }
            if (b != null && this.f1036a.m2133a(b) == 0) {
                this.f1038c.m2525a(b, i2);
            }
        }

        public int m2104a(View view) {
            return this.f1036a.m2151g(view) ? view.getWidth() : 0;
        }

        public int m2105a(View view, int i, int i2) {
            if (this.f1036a.m2141a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.f1036a.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int m2113b(View view, int i, int i2) {
            return view.getTop();
        }
    }

    static {
        boolean z = true;
        f1041b = new int[]{16842931};
        f1042c = VERSION.SDK_INT >= 19;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        f1043d = z;
        if (VERSION.SDK_INT >= 21) {
            f1040a = new DrawerLayoutCompatImplApi21();
        } else {
            f1040a = new DrawerLayoutCompatImplBase();
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1054e = new ChildAccessibilityDelegate(this);
        this.f1057h = -1728053248;
        this.f1059j = new Paint();
        this.f1066q = true;
        this.f1049F = null;
        this.f1050G = null;
        this.f1051H = null;
        this.f1052I = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.f1056g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f1062m = new ViewDragCallback(this, 3);
        this.f1063n = new ViewDragCallback(this, 5);
        this.f1060k = ViewDragHelper.m2505a((ViewGroup) this, 1.0f, this.f1062m);
        this.f1060k.m2524a(1);
        this.f1060k.m2523a(f2);
        this.f1062m.m2109a(this.f1060k);
        this.f1061l = ViewDragHelper.m2505a((ViewGroup) this, 1.0f, this.f1063n);
        this.f1061l.m2524a(2);
        this.f1061l.m2523a(f2);
        this.f1063n.m2109a(this.f1061l);
        setFocusableInTouchMode(true);
        ViewCompat.m1464c((View) this, 1);
        ViewCompat.m1450a((View) this, new AccessibilityDelegate(this));
        ViewGroupCompat.m1516a(this, false);
        if (ViewCompat.m1472k(this)) {
            f1040a.m2073a((View) this);
            this.f1074y = f1040a.m2072a(context);
        }
        this.f1055f = f * 10.0f;
        this.f1053J = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.f1055f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m2151g(childAt)) {
                ViewCompat.m1463c(childAt, this.f1055f);
            }
        }
    }

    public float getDrawerElevation() {
        if (f1043d) {
            return this.f1055f;
        }
        return 0.0f;
    }

    public void m2139a(Object obj, boolean z) {
        this.f1047D = obj;
        this.f1048E = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setScrimColor(@ColorInt int i) {
        this.f1057h = i;
        invalidate();
    }

    public void setDrawerListener(DrawerListener drawerListener) {
        this.f1071v = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        m2136a(i, 3);
        m2136a(i, 5);
    }

    public void m2136a(int i, int i2) {
        int a = GravityCompat.m1224a(i2, ViewCompat.m1467f(this));
        if (a == 3) {
            this.f1067r = i;
        } else if (a == 5) {
            this.f1068s = i;
        }
        if (i != 0) {
            (a == 3 ? this.f1060k : this.f1061l).m2542e();
        }
        View b;
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                b = m2142b(a);
                if (b != null) {
                    m2153i(b);
                }
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                b = m2142b(a);
                if (b != null) {
                    m2152h(b);
                }
            default:
        }
    }

    public int m2133a(View view) {
        int e = m2149e(view);
        if (e == 3) {
            return this.f1067r;
        }
        if (e == 5) {
            return this.f1068s;
        }
        return 0;
    }

    @Nullable
    public CharSequence m2135a(int i) {
        int a = GravityCompat.m1224a(i, ViewCompat.m1467f(this));
        if (a == 3) {
            return this.f1045B;
        }
        if (a == 5) {
            return this.f1046C;
        }
        return null;
    }

    void m2137a(int i, int i2, View view) {
        int i3 = 1;
        int a = this.f1060k.m2522a();
        int a2 = this.f1061l.m2522a();
        if (!(a == 1 || a2 == 1)) {
            i3 = (a == 2 || a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f1029b == 0.0f) {
                m2144b(view);
            } else if (layoutParams.f1029b == 1.0f) {
                m2147c(view);
            }
        }
        if (i3 != this.f1064o) {
            this.f1064o = i3;
            if (this.f1071v != null) {
                this.f1071v.m52a(i3);
            }
        }
    }

    void m2144b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f1031d) {
            layoutParams.f1031d = false;
            if (this.f1071v != null) {
                this.f1071v.m55b(view);
            }
            m2119a(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void m2147c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f1031d) {
            layoutParams.f1031d = true;
            if (this.f1071v != null) {
                this.f1071v.m53a(view);
            }
            m2119a(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    private void m2119a(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || m2151g(childAt)) && !(z && childAt == view)) {
                ViewCompat.m1464c(childAt, 4);
            } else {
                ViewCompat.m1464c(childAt, 1);
            }
        }
    }

    void m2138a(View view, float f) {
        if (this.f1071v != null) {
            this.f1071v.m54a(view, f);
        }
    }

    void m2145b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f1029b) {
            layoutParams.f1029b = f;
            m2138a(view, f);
        }
    }

    float m2148d(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1029b;
    }

    int m2149e(View view) {
        return GravityCompat.m1224a(((LayoutParams) view.getLayoutParams()).f1028a, ViewCompat.m1467f(this));
    }

    boolean m2141a(View view, int i) {
        return (m2149e(view) & i) == i;
    }

    View m2134a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).f1031d) {
                return childAt;
            }
        }
        return null;
    }

    View m2142b(int i) {
        int a = GravityCompat.m1224a(i, ViewCompat.m1467f(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m2149e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    static String m2121c(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1066q = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1066q = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r14, int r15) {
        /*
        r13 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = 0;
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r14);
        r5 = android.view.View.MeasureSpec.getMode(r15);
        r2 = android.view.View.MeasureSpec.getSize(r14);
        r0 = android.view.View.MeasureSpec.getSize(r15);
        if (r3 != r12) goto L_0x001b;
    L_0x0019:
        if (r5 == r12) goto L_0x0056;
    L_0x001b:
        r6 = r13.isInEditMode();
        if (r6 == 0) goto L_0x0058;
    L_0x0021:
        if (r3 != r7) goto L_0x0050;
    L_0x0023:
        if (r5 != r7) goto L_0x0054;
    L_0x0025:
        r1 = r0;
    L_0x0026:
        r13.setMeasuredDimension(r2, r1);
        r0 = r13.f1047D;
        if (r0 == 0) goto L_0x0060;
    L_0x002d:
        r0 = android.support.v4.view.ViewCompat.m1472k(r13);
        if (r0 == 0) goto L_0x0060;
    L_0x0033:
        r0 = 1;
        r3 = r0;
    L_0x0035:
        r6 = android.support.v4.view.ViewCompat.m1467f(r13);
        r7 = r13.getChildCount();
        r5 = r4;
    L_0x003e:
        if (r5 >= r7) goto L_0x014b;
    L_0x0040:
        r8 = r13.getChildAt(r5);
        r0 = r8.getVisibility();
        r9 = 8;
        if (r0 != r9) goto L_0x0062;
    L_0x004c:
        r0 = r5 + 1;
        r5 = r0;
        goto L_0x003e;
    L_0x0050:
        if (r3 != 0) goto L_0x0023;
    L_0x0052:
        r2 = r1;
        goto L_0x0023;
    L_0x0054:
        if (r5 == 0) goto L_0x0026;
    L_0x0056:
        r1 = r0;
        goto L_0x0026;
    L_0x0058:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0060:
        r3 = r4;
        goto L_0x0035;
    L_0x0062:
        r0 = r8.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        if (r3 == 0) goto L_0x007d;
    L_0x006a:
        r9 = r0.f1028a;
        r9 = android.support.v4.view.GravityCompat.m1224a(r9, r6);
        r10 = android.support.v4.view.ViewCompat.m1472k(r8);
        if (r10 == 0) goto L_0x009e;
    L_0x0076:
        r10 = f1040a;
        r11 = r13.f1047D;
        r10.m2074a(r8, r11, r9);
    L_0x007d:
        r9 = r13.m2150f(r8);
        if (r9 == 0) goto L_0x00a6;
    L_0x0083:
        r9 = r0.leftMargin;
        r9 = r2 - r9;
        r10 = r0.rightMargin;
        r9 = r9 - r10;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r12);
        r10 = r0.topMargin;
        r10 = r1 - r10;
        r0 = r0.bottomMargin;
        r0 = r10 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r12);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x009e:
        r10 = f1040a;
        r11 = r13.f1047D;
        r10.m2075a(r0, r11, r9);
        goto L_0x007d;
    L_0x00a6:
        r9 = r13.m2151g(r8);
        if (r9 == 0) goto L_0x011c;
    L_0x00ac:
        r9 = f1043d;
        if (r9 == 0) goto L_0x00bf;
    L_0x00b0:
        r9 = android.support.v4.view.ViewCompat.m1471j(r8);
        r10 = r13.f1055f;
        r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1));
        if (r9 == 0) goto L_0x00bf;
    L_0x00ba:
        r9 = r13.f1055f;
        android.support.v4.view.ViewCompat.m1463c(r8, r9);
    L_0x00bf:
        r9 = r13.m2149e(r8);
        r9 = r9 & 7;
        r10 = r4 & r9;
        if (r10 == 0) goto L_0x00fe;
    L_0x00c9:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child drawer has absolute gravity ";
        r1 = r1.append(r2);
        r2 = m2121c(r9);
        r1 = r1.append(r2);
        r2 = " but this ";
        r1 = r1.append(r2);
        r2 = "DrawerLayout";
        r1 = r1.append(r2);
        r2 = " already has a ";
        r1 = r1.append(r2);
        r2 = "drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00fe:
        r9 = r13.f1056g;
        r10 = r0.leftMargin;
        r9 = r9 + r10;
        r10 = r0.rightMargin;
        r9 = r9 + r10;
        r10 = r0.width;
        r9 = getChildMeasureSpec(r14, r9, r10);
        r10 = r0.topMargin;
        r11 = r0.bottomMargin;
        r10 = r10 + r11;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r15, r10, r0);
        r8.measure(r9, r0);
        goto L_0x004c;
    L_0x011c:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child ";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, ";
        r1 = r1.append(r2);
        r2 = "Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x014b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    private void m2124f() {
        if (!f1043d) {
            this.f1075z = m2125g();
            this.f1044A = m2126h();
        }
    }

    private Drawable m2125g() {
        int f = ViewCompat.m1467f(this);
        if (f == 0) {
            if (this.f1049F != null) {
                m2120a(this.f1049F, f);
                return this.f1049F;
            }
        } else if (this.f1050G != null) {
            m2120a(this.f1050G, f);
            return this.f1050G;
        }
        return this.f1051H;
    }

    private Drawable m2126h() {
        int f = ViewCompat.m1467f(this);
        if (f == 0) {
            if (this.f1050G != null) {
                m2120a(this.f1050G, f);
                return this.f1050G;
            }
        } else if (this.f1049F != null) {
            m2120a(this.f1049F, f);
            return this.f1049F;
        }
        return this.f1052I;
    }

    private boolean m2120a(Drawable drawable, int i) {
        if (drawable == null || !DrawableCompat.m589a(drawable)) {
            return false;
        }
        DrawableCompat.m588a(drawable, i);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1065p = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m2150f(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m2141a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.f1029b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.f1029b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.f1029b ? 1 : null;
                    int i8;
                    switch (layoutParams.f1028a & 112) {
                        case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < layoutParams.topMargin) {
                                i8 = layoutParams.topMargin;
                            } else if (i8 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i8 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case 80:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m2145b(childAt, f);
                    }
                    int i10 = layoutParams.f1029b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f1065p = false;
        this.f1066q = false;
    }

    public void requestLayout() {
        if (!this.f1065p) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f1029b);
        }
        this.f1058i = f;
        if ((this.f1060k.m2529a(true) | this.f1061l.m2529a(true)) != 0) {
            ViewCompat.m1459b(this);
        }
    }

    private static boolean m2131m(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f1074y = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f1074y;
    }

    public void setStatusBarBackground(int i) {
        this.f1074y = i != 0 ? ContextCompat.m78a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        this.f1074y = new ColorDrawable(i);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i) {
        m2124f();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1048E && this.f1074y != null) {
            int a = f1040a.m2071a(this.f1047D);
            if (a > 0) {
                this.f1074y.setBounds(0, 0, getWidth(), a);
                this.f1074y.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = m2150f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m2131m(childAt) && m2151g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (m2141a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f1058i > 0.0f && f) {
            this.f1059j.setColor((((int) (((float) ((this.f1057h & -16777216) >>> 24)) * this.f1058i)) << 24) | (this.f1057h & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.f1059j);
        } else if (this.f1075z != null && m2141a(view, 3)) {
            i = this.f1075z.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.f1060k.m2530b()), 1.0f));
            this.f1075z.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.f1075z.setAlpha((int) (255.0f * r2));
            this.f1075z.draw(canvas);
        } else if (this.f1044A != null && m2141a(view, 5)) {
            i = this.f1044A.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.f1061l.m2530b()), 1.0f));
            this.f1044A.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.f1044A.setAlpha((int) (255.0f * r2));
            this.f1044A.draw(canvas);
        }
        return drawChild;
    }

    boolean m2150f(View view) {
        return ((LayoutParams) view.getLayoutParams()).f1028a == 0;
    }

    boolean m2151g(View view) {
        return (GravityCompat.m1224a(((LayoutParams) view.getLayoutParams()).f1028a, ViewCompat.m1467f(view)) & 7) != 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.MotionEventCompat.m1283a(r8);
        r3 = r7.f1060k;
        r3 = r3.m2527a(r8);
        r4 = r7.f1061l;
        r4 = r4.m2527a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0065;
            case 2: goto L_0x0050;
            case 3: goto L_0x0065;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.m2127i();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.f1070u;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.f1072w = r0;
        r7.f1073x = r4;
        r5 = r7.f1058i;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.f1060k;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m2540d(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.m2150f(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.f1069t = r2;
        r7.f1070u = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.f1060k;
        r4 = 3;
        r0 = r0.m2541d(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.f1062m;
        r0.m2106a();
        r0 = r7.f1063n;
        r0.m2106a();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.m2140a(r1);
        r7.f1069t = r2;
        r7.f1070u = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1060k.m2531b(motionEvent);
        this.f1061l.m2531b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f1072w = x;
                this.f1073x = y;
                this.f1069t = false;
                this.f1070u = false;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.f1060k.m2540d((int) x, (int) y);
                if (d != null && m2150f(d)) {
                    x -= this.f1072w;
                    y -= this.f1073x;
                    int d2 = this.f1060k.m2539d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = m2134a();
                        if (a != null) {
                            z = m2133a(a) == 2;
                            m2140a(z);
                            this.f1069t = false;
                            break;
                        }
                    }
                }
                z = true;
                m2140a(z);
                this.f1069t = false;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m2140a(true);
                this.f1069t = false;
                this.f1070u = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f1069t = z;
        if (z) {
            m2140a(true);
        }
    }

    public void m2143b() {
        m2140a(false);
    }

    void m2140a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m2151g(childAt) && (!z || layoutParams.f1030c)) {
                int width = childAt.getWidth();
                if (m2141a(childAt, 3)) {
                    i |= this.f1060k.m2528a(childAt, -width, childAt.getTop());
                } else {
                    i |= this.f1061l.m2528a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.f1030c = false;
            }
        }
        this.f1062m.m2106a();
        this.f1063n.m2106a();
        if (i != 0) {
            invalidate();
        }
    }

    public void m2152h(View view) {
        if (m2151g(view)) {
            if (this.f1066q) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.f1029b = 1.0f;
                layoutParams.f1031d = true;
                m2119a(view, true);
            } else if (m2141a(view, 3)) {
                this.f1060k.m2528a(view, 0, view.getTop());
            } else {
                this.f1061l.m2528a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void m2153i(View view) {
        if (m2151g(view)) {
            if (this.f1066q) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.f1029b = 0.0f;
                layoutParams.f1031d = false;
            } else if (m2141a(view, 3)) {
                this.f1060k.m2528a(view, -view.getWidth(), view.getTop());
            } else {
                this.f1061l.m2528a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean m2154j(View view) {
        if (m2151g(view)) {
            return ((LayoutParams) view.getLayoutParams()).f1031d;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean m2155k(View view) {
        if (m2151g(view)) {
            return ((LayoutParams) view.getLayoutParams()).f1029b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    private boolean m2127i() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f1030c) {
                return true;
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int i3 = 0;
        if (getDescendantFocusability() != 393216) {
            int i4;
            int childCount = getChildCount();
            int i5 = 0;
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!m2151g(childAt)) {
                    this.f1053J.add(childAt);
                } else if (m2154j(childAt)) {
                    i5 = 1;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (i5 == 0) {
                i4 = this.f1053J.size();
                while (i3 < i4) {
                    View view = (View) this.f1053J.get(i3);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                    i3++;
                }
            }
            this.f1053J.clear();
        }
    }

    private boolean m2128j() {
        return m2129k() != null;
    }

    private View m2129k() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2151g(childAt) && m2155k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void m2146c() {
        int i = 0;
        if (!this.f1070u) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i++;
            }
            obtain.recycle();
            this.f1070u = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m2128j()) {
            return super.onKeyDown(i, keyEvent);
        }
        KeyEventCompat.m1242b(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View k = m2129k();
        if (k != null && m2133a(k) == 0) {
            m2143b();
        }
        return k != null;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1032a != 0) {
            View b = m2142b(savedState.f1032a);
            if (b != null) {
                m2152h(b);
            }
        }
        m2136a(savedState.f1033b, 3);
        m2136a(savedState.f1034c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        View a = m2134a();
        if (a != null) {
            savedState.f1032a = ((LayoutParams) a.getLayoutParams()).f1028a;
        }
        savedState.f1033b = this.f1067r;
        savedState.f1034c = this.f1068s;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m2134a() != null || m2151g(view)) {
            ViewCompat.m1464c(view, 4);
        } else {
            ViewCompat.m1464c(view, 1);
        }
        if (!f1042c) {
            ViewCompat.m1450a(view, this.f1054e);
        }
    }

    private static boolean m2132n(View view) {
        return (ViewCompat.m1462c(view) == 4 || ViewCompat.m1462c(view) == 2) ? false : true;
    }
}
