package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final SlidingPanelLayoutImpl f1197a;
    private int f1198b;
    private int f1199c;
    private Drawable f1200d;
    private Drawable f1201e;
    private final int f1202f;
    private boolean f1203g;
    private View f1204h;
    private float f1205i;
    private float f1206j;
    private int f1207k;
    private boolean f1208l;
    private int f1209m;
    private float f1210n;
    private float f1211o;
    private PanelSlideListener f1212p;
    private final ViewDragHelper f1213q;
    private boolean f1214r;
    private boolean f1215s;
    private final Rect f1216t;
    private final ArrayList<DisableLayerRunnable> f1217u;

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ SlidingPaneLayout f1184b;
        private final Rect f1185c;

        AccessibilityDelegate(SlidingPaneLayout slidingPaneLayout) {
            this.f1184b = slidingPaneLayout;
            this.f1185c = new Rect();
        }

        public void m2410a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat a = AccessibilityNodeInfoCompat.m1791a(accessibilityNodeInfoCompat);
            super.m1192a(view, a);
            m2409a(accessibilityNodeInfoCompat, a);
            a.m1840u();
            accessibilityNodeInfoCompat.m1808b(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.m1806b(view);
            ViewParent g = ViewCompat.m1468g(view);
            if (g instanceof View) {
                accessibilityNodeInfoCompat.m1817d((View) g);
            }
            int childCount = this.f1184b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f1184b.getChildAt(i);
                if (!m2412b(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.m1464c(childAt, 1);
                    accessibilityNodeInfoCompat.m1812c(childAt);
                }
            }
        }

        public void m2413d(View view, AccessibilityEvent accessibilityEvent) {
            super.m1198d(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public boolean m2411a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (m2412b(view)) {
                return false;
            }
            return super.m1195a(viewGroup, view, accessibilityEvent);
        }

        public boolean m2412b(View view) {
            return this.f1184b.m2463e(view);
        }

        private void m2409a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f1185c;
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
            accessibilityNodeInfoCompat.m1804b(accessibilityNodeInfoCompat2.m1815d());
        }
    }

    private class DisableLayerRunnable implements Runnable {
        final View f1186a;
        final /* synthetic */ SlidingPaneLayout f1187b;

        DisableLayerRunnable(SlidingPaneLayout slidingPaneLayout, View view) {
            this.f1187b = slidingPaneLayout;
            this.f1186a = view;
        }

        public void run() {
            if (this.f1186a.getParent() == this.f1187b) {
                ViewCompat.m1448a(this.f1186a, 0, null);
                this.f1187b.m2452g(this.f1186a);
            }
            this.f1187b.f1217u.remove(this);
        }
    }

    private class DragHelperCallback extends Callback {
        final /* synthetic */ SlidingPaneLayout f1188a;

        private DragHelperCallback(SlidingPaneLayout slidingPaneLayout) {
            this.f1188a = slidingPaneLayout;
        }

        public boolean m2419a(View view, int i) {
            if (this.f1188a.f1208l) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f1191b;
        }

        public void m2416a(int i) {
            if (this.f1188a.f1213q.m2522a() != 0) {
                return;
            }
            if (this.f1188a.f1205i == 0.0f) {
                this.f1188a.m2460d(this.f1188a.f1204h);
                this.f1188a.m2458c(this.f1188a.f1204h);
                this.f1188a.f1214r = false;
                return;
            }
            this.f1188a.m2456b(this.f1188a.f1204h);
            this.f1188a.f1214r = true;
        }

        public void m2422b(View view, int i) {
            this.f1188a.m2453a();
        }

        public void m2418a(View view, int i, int i2, int i3, int i4) {
            this.f1188a.m2436a(i);
            this.f1188a.invalidate();
        }

        public void m2417a(View view, float f, float f2) {
            int paddingRight;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f1188a.m2449f()) {
                paddingRight = layoutParams.rightMargin + this.f1188a.getPaddingRight();
                if (f < 0.0f || (f == 0.0f && this.f1188a.f1205i > 0.5f)) {
                    paddingRight += this.f1188a.f1207k;
                }
                paddingRight = (this.f1188a.getWidth() - paddingRight) - this.f1188a.f1204h.getWidth();
            } else {
                paddingRight = layoutParams.leftMargin + this.f1188a.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && this.f1188a.f1205i > 0.5f)) {
                    paddingRight += this.f1188a.f1207k;
                }
            }
            this.f1188a.f1213q.m2526a(paddingRight, view.getTop());
            this.f1188a.invalidate();
        }

        public int m2414a(View view) {
            return this.f1188a.f1207k;
        }

        public int m2415a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) this.f1188a.f1204h.getLayoutParams();
            if (this.f1188a.m2449f()) {
                int width = this.f1188a.getWidth() - ((layoutParams.rightMargin + this.f1188a.getPaddingRight()) + this.f1188a.f1204h.getWidth());
                return Math.max(Math.min(i, width), width - this.f1188a.f1207k);
            }
            width = layoutParams.leftMargin + this.f1188a.getPaddingLeft();
            return Math.min(Math.max(i, width), this.f1188a.f1207k + width);
        }

        public int m2420b(View view, int i, int i2) {
            return view.getTop();
        }

        public void m2421b(int i, int i2) {
            this.f1188a.f1213q.m2525a(this.f1188a.f1204h, i2);
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        private static final int[] f1189e;
        public float f1190a;
        boolean f1191b;
        boolean f1192c;
        Paint f1193d;

        static {
            f1189e = new int[]{16843137};
        }

        public LayoutParams() {
            super(-1, -1);
            this.f1190a = 0.0f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1190a = 0.0f;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1190a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1190a = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1189e);
            this.f1190a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public interface PanelSlideListener {
        void m2423a(View view);

        void m2424a(View view, float f);

        void m2425b(View view);
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        boolean f1194a;

        /* renamed from: android.support.v4.widget.SlidingPaneLayout.SavedState.1 */
        final class C01211 implements Creator<SavedState> {
            C01211() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2426a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2427a(i);
            }

            public SavedState m2426a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m2427a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f1194a = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1194a ? 1 : 0);
        }

        static {
            CREATOR = new C01211();
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void m2429a(View view, float f) {
        }

        public void m2428a(View view) {
        }

        public void m2430b(View view) {
        }
    }

    interface SlidingPanelLayoutImpl {
        void m2431a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
        }

        public void m2432a(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.m1447a(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        private Method f1195a;
        private Field f1196b;

        SlidingPanelLayoutImplJB() {
            try {
                this.f1195a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (Throwable e) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.f1196b = View.class.getDeclaredField("mRecreateDisplayList");
                this.f1196b.setAccessible(true);
            } catch (Throwable e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        public void m2433a(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.f1195a == null || this.f1196b == null) {
                view.invalidate();
                return;
            }
            try {
                this.f1196b.setBoolean(view, true);
                this.f1195a.invoke(view, (Object[]) null);
            } catch (Throwable e) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
            }
            super.m2432a(slidingPaneLayout, view);
        }
    }

    static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
        }

        public void m2434a(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.m1449a(view, ((LayoutParams) view.getLayoutParams()).f1193d);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            f1197a = new SlidingPanelLayoutImplJBMR1();
        } else if (i >= 16) {
            f1197a = new SlidingPanelLayoutImplJB();
        } else {
            f1197a = new SlidingPanelLayoutImplBase();
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1198b = -858993460;
        this.f1215s = true;
        this.f1216t = new Rect();
        this.f1217u = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.f1202f = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        ViewCompat.m1450a((View) this, new AccessibilityDelegate(this));
        ViewCompat.m1464c((View) this, 1);
        this.f1213q = ViewDragHelper.m2505a((ViewGroup) this, 0.5f, new DragHelperCallback());
        this.f1213q.m2523a(f * 400.0f);
    }

    public void setParallaxDistance(int i) {
        this.f1209m = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f1209m;
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.f1198b = i;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.f1198b;
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.f1199c = i;
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.f1199c;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.f1212p = panelSlideListener;
    }

    void m2454a(View view) {
        if (this.f1212p != null) {
            this.f1212p.m2424a(view, this.f1205i);
        }
    }

    void m2456b(View view) {
        if (this.f1212p != null) {
            this.f1212p.m2423a(view);
        }
        sendAccessibilityEvent(32);
    }

    void m2458c(View view) {
        if (this.f1212p != null) {
            this.f1212p.m2425b(view);
        }
        sendAccessibilityEvent(32);
    }

    void m2460d(View view) {
        int paddingLeft;
        int i;
        boolean f = m2449f();
        int width = f ? getWidth() - getPaddingRight() : getPaddingLeft();
        if (f) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        int i2;
        int i3;
        int i4;
        if (view == null || !m2450f(view)) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i = 0;
        } else {
            i = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                int i6;
                if (f) {
                    i6 = paddingLeft;
                } else {
                    i6 = width;
                }
                int max = Math.max(i6, childAt.getLeft());
                int max2 = Math.max(paddingTop, childAt.getTop());
                if (f) {
                    i6 = width;
                } else {
                    i6 = paddingLeft;
                }
                i6 = Math.min(i6, childAt.getRight());
                int min = Math.min(height, childAt.getBottom());
                if (max < i || max2 < r3 || i6 > r4 || min > r2) {
                    i6 = 0;
                } else {
                    i6 = 4;
                }
                childAt.setVisibility(i6);
                i5++;
            } else {
                return;
            }
        }
    }

    void m2453a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean m2450f(View view) {
        if (ViewCompat.m1469h(view)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            return false;
        }
        if (background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1215s = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1215s = true;
        int size = this.f1217u.size();
        for (int i = 0; i < size; i++) {
            ((DisableLayerRunnable) this.f1217u.get(i)).run();
        }
        this.f1217u.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == Integer.MIN_VALUE) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = -1;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f1204h = null;
        int i5 = 0;
        int i6 = paddingLeft;
        int i7 = size2;
        float f = 0.0f;
        while (i5 < childCount) {
            float f2;
            int i8;
            boolean z2;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.f1192c = false;
                size2 = i6;
                f2 = f;
                i8 = i7;
                z2 = z;
            } else {
                if (layoutParams.f1190a > 0.0f) {
                    f += layoutParams.f1190a;
                    if (layoutParams.width == 0) {
                        size2 = i6;
                        f2 = f;
                        i8 = i7;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                if (layoutParams.width == -2) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    mode = MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824);
                } else {
                    mode = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                } else if (layoutParams.height == -1) {
                    i8 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                } else {
                    i8 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                }
                childAt.measure(mode, i8);
                mode = childAt.getMeasuredWidth();
                i8 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i8 > i7) {
                    i7 = Math.min(i8, mode2);
                }
                i8 = i6 - mode;
                boolean z3 = i8 < 0;
                layoutParams.f1191b = z3;
                z3 |= z;
                if (layoutParams.f1191b) {
                    this.f1204h = childAt;
                }
                size2 = i8;
                i8 = i7;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i5++;
            z = z2;
            i7 = i8;
            f = f2;
            i6 = size2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.f1202f;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.f1190a <= 0.0f) ? null : 1;
                        i8 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.f1204h) {
                            if (layoutParams.f1190a > 0.0f) {
                                if (layoutParams.width != 0) {
                                    mode = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                } else if (layoutParams.height == -2) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                                } else if (layoutParams.height == -1) {
                                    mode = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                                } else {
                                    mode = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                                }
                                if (z) {
                                    size2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i5 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i8 != size2) {
                                        childAt2.measure(i5, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.f1190a * ((float) Math.max(0, i6))) / f)) + i8, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (i8 > i9 || layoutParams.f1190a > 0.0f)) {
                            if (obj == null) {
                                size2 = MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            } else if (layoutParams.height == -2) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE);
                            } else if (layoutParams.height == -1) {
                                size2 = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                            } else {
                                size2 = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                            }
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i7) + getPaddingBottom());
        this.f1203g = z;
        if (this.f1213q.m2522a() != 0 && !z) {
            this.f1213q.m2543f();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean f = m2449f();
        if (f) {
            this.f1213q.m2524a(2);
        } else {
            this.f1213q.m2524a(1);
        }
        int i5 = i3 - i;
        int paddingRight = f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f1215s) {
            float f2 = (this.f1203g && this.f1214r) ? 1.0f : 0.0f;
            this.f1205i = f2;
        }
        int i6 = 0;
        int i7 = paddingRight;
        while (i6 < childCount) {
            int i8;
            int i9;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                i8 = paddingRight;
                i9 = i7;
            } else {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f1191b) {
                    int min = (Math.min(paddingRight, (i5 - paddingLeft) - this.f1202f) - i7) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f1207k = min;
                    i9 = f ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f1192c = ((i7 + i9) + min) + (measuredWidth / 2) > i5 - paddingLeft;
                    i8 = (int) (((float) min) * this.f1205i);
                    i10 = i7 + (i9 + i8);
                    this.f1205i = ((float) i8) / ((float) this.f1207k);
                    i8 = 0;
                } else if (!this.f1203g || this.f1209m == 0) {
                    i8 = 0;
                    i10 = paddingRight;
                } else {
                    i8 = (int) ((1.0f - this.f1205i) * ((float) this.f1209m));
                    i10 = paddingRight;
                }
                if (f) {
                    i9 = (i5 - i10) + i8;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i10 - i8;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i8 = childAt.getWidth() + paddingRight;
                i9 = i10;
            }
            i6++;
            paddingRight = i8;
            i7 = i9;
        }
        if (this.f1215s) {
            if (this.f1203g) {
                if (this.f1209m != 0) {
                    m2435a(this.f1205i);
                }
                if (((LayoutParams) this.f1204h.getLayoutParams()).f1192c) {
                    m2439a(this.f1204h, this.f1205i, this.f1198b);
                }
            } else {
                for (i8 = 0; i8 < childCount; i8++) {
                    m2439a(getChildAt(i8), 0.0f, this.f1198b);
                }
            }
            m2460d(this.f1204h);
        }
        this.f1215s = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f1215s = true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f1203g) {
            this.f1214r = view == this.f1204h;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = android.support.v4.view.MotionEventCompat.m1283a(r8);
        r0 = r7.f1203g;
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        if (r3 != 0) goto L_0x002d;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002d;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r4 = r7.f1213q;
        r5 = r8.getX();
        r5 = (int) r5;
        r6 = r8.getY();
        r6 = (int) r6;
        r0 = r4.m2535b(r0, r5, r6);
        if (r0 != 0) goto L_0x0041;
    L_0x002a:
        r0 = r1;
    L_0x002b:
        r7.f1214r = r0;
    L_0x002d:
        r0 = r7.f1203g;
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r7.f1208l;
        if (r0 == 0) goto L_0x0043;
    L_0x0035:
        if (r3 == 0) goto L_0x0043;
    L_0x0037:
        r0 = r7.f1213q;
        r0.m2542e();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0040:
        return r2;
    L_0x0041:
        r0 = r2;
        goto L_0x002b;
    L_0x0043:
        r0 = 3;
        if (r3 == r0) goto L_0x0048;
    L_0x0046:
        if (r3 != r1) goto L_0x004e;
    L_0x0048:
        r0 = r7.f1213q;
        r0.m2542e();
        goto L_0x0040;
    L_0x004e:
        switch(r3) {
            case 0: goto L_0x005e;
            case 1: goto L_0x0051;
            case 2: goto L_0x0082;
            default: goto L_0x0051;
        };
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r3 = r7.f1213q;
        r3 = r3.m2527a(r8);
        if (r3 != 0) goto L_0x005c;
    L_0x005a:
        if (r0 == 0) goto L_0x0040;
    L_0x005c:
        r2 = r1;
        goto L_0x0040;
    L_0x005e:
        r7.f1208l = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.f1210n = r0;
        r7.f1211o = r3;
        r4 = r7.f1213q;
        r5 = r7.f1204h;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r4.m2535b(r5, r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0078:
        r0 = r7.f1204h;
        r0 = r7.m2463e(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0080:
        r0 = r1;
        goto L_0x0052;
    L_0x0082:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.f1210n;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.f1211o;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.f1213q;
        r4 = r4.m2539d();
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0051;
    L_0x00a3:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x00a7:
        r0 = r7.f1213q;
        r0.m2542e();
        r7.f1208l = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f1203g) {
            return super.onTouchEvent(motionEvent);
        }
        this.f1213q.m2531b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f1210n = x;
                this.f1211o = y;
                return true;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (!m2463e(this.f1204h)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.f1210n;
                float f2 = y - this.f1211o;
                int d = this.f1213q.m2539d();
                if ((f * f) + (f2 * f2) >= ((float) (d * d)) || !this.f1213q.m2535b(this.f1204h, (int) x, (int) y)) {
                    return true;
                }
                m2442a(this.f1204h, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean m2442a(View view, int i) {
        if (!this.f1215s && !m2455a(0.0f, i)) {
            return false;
        }
        this.f1214r = false;
        return true;
    }

    private boolean m2444b(View view, int i) {
        if (!this.f1215s && !m2455a(1.0f, i)) {
            return false;
        }
        this.f1214r = true;
        return true;
    }

    public boolean m2457b() {
        return m2444b(this.f1204h, 0);
    }

    public boolean m2459c() {
        return m2442a(this.f1204h, 0);
    }

    public boolean m2461d() {
        return !this.f1203g || this.f1205i == 1.0f;
    }

    public boolean m2462e() {
        return this.f1203g;
    }

    private void m2436a(int i) {
        if (this.f1204h == null) {
            this.f1205i = 0.0f;
            return;
        }
        boolean f = m2449f();
        LayoutParams layoutParams = (LayoutParams) this.f1204h.getLayoutParams();
        int width = this.f1204h.getWidth();
        if (f) {
            i = (getWidth() - i) - width;
        }
        this.f1205i = ((float) (i - ((f ? layoutParams.rightMargin : layoutParams.leftMargin) + (f ? getPaddingRight() : getPaddingLeft())))) / ((float) this.f1207k);
        if (this.f1209m != 0) {
            m2435a(this.f1205i);
        }
        if (layoutParams.f1192c) {
            m2439a(this.f1204h, this.f1205i, this.f1198b);
        }
        m2454a(this.f1204h);
    }

    private void m2439a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((-16777216 & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.f1193d == null) {
                layoutParams.f1193d = new Paint();
            }
            layoutParams.f1193d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (ViewCompat.m1466e(view) != 2) {
                ViewCompat.m1448a(view, 2, layoutParams.f1193d);
            }
            m2452g(view);
        } else if (ViewCompat.m1466e(view) != 0) {
            if (layoutParams.f1193d != null) {
                layoutParams.f1193d.setColorFilter(null);
            }
            Runnable disableLayerRunnable = new DisableLayerRunnable(this, view);
            this.f1217u.add(disableLayerRunnable);
            ViewCompat.m1453a((View) this, disableLayerRunnable);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.f1203g || layoutParams.f1191b || this.f1204h == null)) {
            canvas.getClipBounds(this.f1216t);
            if (m2449f()) {
                this.f1216t.left = Math.max(this.f1216t.left, this.f1204h.getRight());
            } else {
                this.f1216t.right = Math.min(this.f1216t.right, this.f1204h.getLeft());
            }
            canvas.clipRect(this.f1216t);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!layoutParams.f1192c || this.f1205i <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.f1193d);
                drawChild = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + view + " returned null drawing cache");
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    private void m2452g(View view) {
        f1197a.m2431a(this, view);
    }

    boolean m2455a(float f, int i) {
        if (!this.f1203g) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.f1204h.getLayoutParams();
        if (m2449f()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.f1207k) * f)) + ((float) this.f1204h.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.f1207k) * f));
        }
        if (!this.f1213q.m2528a(this.f1204h, width, this.f1204h.getTop())) {
            return false;
        }
        m2453a();
        ViewCompat.m1459b(this);
        return true;
    }

    public void computeScroll() {
        if (!this.f1213q.m2529a(true)) {
            return;
        }
        if (this.f1203g) {
            ViewCompat.m1459b(this);
        } else {
            this.f1213q.m2543f();
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f1200d = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f1201e = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getResources().getDrawable(i));
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        if (m2449f()) {
            drawable = this.f1201e;
        } else {
            drawable = this.f1200d;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (m2449f()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    private void m2435a(float f) {
        Object obj;
        int childCount;
        int i;
        View childAt;
        int i2;
        boolean f2 = m2449f();
        LayoutParams layoutParams = (LayoutParams) this.f1204h.getLayoutParams();
        if (layoutParams.f1192c) {
            if ((f2 ? layoutParams.rightMargin : layoutParams.leftMargin) <= 0) {
                obj = 1;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    childAt = getChildAt(i);
                    if (childAt == this.f1204h) {
                        i2 = (int) ((1.0f - this.f1206j) * ((float) this.f1209m));
                        this.f1206j = f;
                        i2 -= (int) ((1.0f - f) * ((float) this.f1209m));
                        if (f2) {
                            i2 = -i2;
                        }
                        childAt.offsetLeftAndRight(i2);
                        if (obj == null) {
                            m2439a(childAt, f2 ? this.f1206j - 1.0f : 1.0f - this.f1206j, this.f1199c);
                        }
                    }
                }
            }
        }
        obj = null;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (childAt == this.f1204h) {
                i2 = (int) ((1.0f - this.f1206j) * ((float) this.f1209m));
                this.f1206j = f;
                i2 -= (int) ((1.0f - f) * ((float) this.f1209m));
                if (f2) {
                    i2 = -i2;
                }
                childAt.offsetLeftAndRight(i2);
                if (obj == null) {
                    if (f2) {
                    }
                    m2439a(childAt, f2 ? this.f1206j - 1.0f : 1.0f - this.f1206j, this.f1199c);
                }
            }
        }
    }

    boolean m2463e(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1203g && ((LayoutParams) view.getLayoutParams()).f1192c && this.f1205i > 0.0f;
        return z;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1194a = m2462e() ? m2461d() : this.f1214r;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1194a) {
            m2457b();
        } else {
            m2459c();
        }
        this.f1214r = savedState.f1194a;
    }

    private boolean m2449f() {
        return ViewCompat.m1467f(this) == 1;
    }
}
