package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int[] f851a;
    private static final ViewPositionComparator ah;
    private static final Comparator<ItemInfo> f852c;
    private static final Interpolator f853d;
    private boolean f854A;
    private boolean f855B;
    private int f856C;
    private int f857D;
    private int f858E;
    private float f859F;
    private float f860G;
    private float f861H;
    private float f862I;
    private int f863J;
    private VelocityTracker f864K;
    private int f865L;
    private int f866M;
    private int f867N;
    private int f868O;
    private boolean f869P;
    private EdgeEffectCompat f870Q;
    private EdgeEffectCompat f871R;
    private boolean f872S;
    private boolean f873T;
    private boolean f874U;
    private int f875V;
    private List<OnPageChangeListener> f876W;
    private OnPageChangeListener aa;
    private OnPageChangeListener ab;
    private OnAdapterChangeListener ac;
    private PageTransformer ad;
    private Method ae;
    private int af;
    private ArrayList<View> ag;
    private final Runnable ai;
    private int aj;
    private int f877b;
    private final ArrayList<ItemInfo> f878e;
    private final ItemInfo f879f;
    private final Rect f880g;
    private PagerAdapter f881h;
    private int f882i;
    private int f883j;
    private Parcelable f884k;
    private ClassLoader f885l;
    private Scroller f886m;
    private PagerObserver f887n;
    private int f888o;
    private Drawable f889p;
    private int f890q;
    private int f891r;
    private float f892s;
    private float f893t;
    private int f894u;
    private int f895v;
    private boolean f896w;
    private boolean f897x;
    private boolean f898y;
    private int f899z;

    interface Decor {
    }

    interface OnAdapterChangeListener {
        void m1318a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void m1319a(int i);

        void m1320a(int i, float f, int i2);

        void m1321b(int i);
    }

    /* renamed from: android.support.v4.view.ViewPager.1 */
    final class C00891 implements Comparator<ItemInfo> {
        C00891() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1518a((ItemInfo) obj, (ItemInfo) obj2);
        }

        public int m1518a(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f836b - itemInfo2.f836b;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.2 */
    final class C00902 implements Interpolator {
        C00902() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.3 */
    class C00913 implements Runnable {
        final /* synthetic */ ViewPager f834a;

        C00913(ViewPager viewPager) {
            this.f834a = viewPager;
        }

        public void run() {
            this.f834a.setScrollState(0);
            this.f834a.m1571c();
        }
    }

    static class ItemInfo {
        Object f835a;
        int f836b;
        boolean f837c;
        float f838d;
        float f839e;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean f840a;
        public int f841b;
        float f842c;
        boolean f843d;
        int f844e;
        int f845f;

        public LayoutParams() {
            super(-1, -1);
            this.f842c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f842c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f851a);
            this.f841b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        final /* synthetic */ ViewPager f846b;

        MyAccessibilityDelegate(ViewPager viewPager) {
            this.f846b = viewPager;
        }

        public void m1522d(View view, AccessibilityEvent accessibilityEvent) {
            super.m1198d(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat a = AccessibilityRecordCompat.m1945a();
            a.m1948a(m1519b());
            if (accessibilityEvent.getEventType() == 4096 && this.f846b.f881h != null) {
                a.m1946a(this.f846b.f881h.m1a());
                a.m1949b(this.f846b.f882i);
                a.m1950c(this.f846b.f882i);
            }
        }

        public void m1520a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.m1192a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m1808b(ViewPager.class.getName());
            accessibilityNodeInfoCompat.m1827i(m1519b());
            if (this.f846b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.m1798a(4096);
            }
            if (this.f846b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.m1798a(8192);
            }
        }

        public boolean m1521a(View view, int i, Bundle bundle) {
            if (super.m1194a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.f846b.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.f846b.setCurrentItem(this.f846b.f882i + 1);
                    return true;
                case 8192:
                    if (!this.f846b.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.f846b.setCurrentItem(this.f846b.f882i - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean m1519b() {
            return this.f846b.f881h != null && this.f846b.f881h.m1a() > 1;
        }
    }

    public interface PageTransformer {
        void m1523a(View view, float f);
    }

    private class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager f847a;

        private PagerObserver(ViewPager viewPager) {
            this.f847a = viewPager;
        }

        public void onChanged() {
            this.f847a.m1570b();
        }

        public void onInvalidated() {
            this.f847a.m1570b();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f848a;
        Parcelable f849b;
        ClassLoader f850c;

        /* renamed from: android.support.v4.view.ViewPager.SavedState.1 */
        final class C00921 implements ParcelableCompatCreatorCallbacks<SavedState> {
            C00921() {
            }

            public /* synthetic */ Object m1524a(Parcel parcel, ClassLoader classLoader) {
                return m1526b(parcel, classLoader);
            }

            public /* synthetic */ Object[] m1525a(int i) {
                return m1527b(i);
            }

            public SavedState m1526b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m1527b(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f848a);
            parcel.writeParcelable(this.f849b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f848a + "}";
        }

        static {
            CREATOR = ParcelableCompat.m1007a(new C00921());
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f848a = parcel.readInt();
            this.f849b = parcel.readParcelable(classLoader);
            this.f850c = classLoader;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void m1529a(int i, float f, int i2) {
        }

        public void m1528a(int i) {
        }

        public void m1530b(int i) {
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1531a((View) obj, (View) obj2);
        }

        public int m1531a(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.f840a != layoutParams2.f840a) {
                return layoutParams.f840a ? 1 : -1;
            } else {
                return layoutParams.f844e - layoutParams2.f844e;
            }
        }
    }

    static {
        f851a = new int[]{16842931};
        f852c = new C00891();
        f853d = new C00902();
        ah = new ViewPositionComparator();
    }

    public ViewPager(Context context) {
        super(context);
        this.f878e = new ArrayList();
        this.f879f = new ItemInfo();
        this.f880g = new Rect();
        this.f883j = -1;
        this.f884k = null;
        this.f885l = null;
        this.f892s = -3.4028235E38f;
        this.f893t = Float.MAX_VALUE;
        this.f899z = 1;
        this.f863J = -1;
        this.f872S = true;
        this.f873T = false;
        this.ai = new C00913(this);
        this.aj = 0;
        m1559a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f878e = new ArrayList();
        this.f879f = new ItemInfo();
        this.f880g = new Rect();
        this.f883j = -1;
        this.f884k = null;
        this.f885l = null;
        this.f892s = -3.4028235E38f;
        this.f893t = Float.MAX_VALUE;
        this.f899z = 1;
        this.f863J = -1;
        this.f872S = true;
        this.f873T = false;
        this.ai = new C00913(this);
        this.aj = 0;
        m1559a();
    }

    void m1559a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f886m = new Scroller(context, f853d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f858E = ViewConfigurationCompat.m1511a(viewConfiguration);
        this.f865L = (int) (400.0f * f);
        this.f866M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f870Q = new EdgeEffectCompat(context);
        this.f871R = new EdgeEffectCompat(context);
        this.f867N = (int) (25.0f * f);
        this.f868O = (int) (2.0f * f);
        this.f856C = (int) (16.0f * f);
        ViewCompat.m1450a((View) this, new MyAccessibilityDelegate(this));
        if (ViewCompat.m1462c(this) == 0) {
            ViewCompat.m1464c((View) this, 1);
        }
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ai);
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        if (this.aj != i) {
            this.aj = i;
            if (this.ad != null) {
                m1544b(i != 0);
            }
            m1549f(i);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f881h != null) {
            this.f881h.m15b(this.f887n);
            this.f881h.m10a((ViewGroup) this);
            for (int i = 0; i < this.f878e.size(); i++) {
                ItemInfo itemInfo = (ItemInfo) this.f878e.get(i);
                this.f881h.m11a((ViewGroup) this, itemInfo.f836b, itemInfo.f835a);
            }
            this.f881h.m18b((ViewGroup) this);
            this.f878e.clear();
            m1551g();
            this.f882i = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.f881h;
        this.f881h = pagerAdapter;
        this.f877b = 0;
        if (this.f881h != null) {
            if (this.f887n == null) {
                this.f887n = new PagerObserver();
            }
            this.f881h.m6a(this.f887n);
            this.f898y = false;
            boolean z = this.f872S;
            this.f872S = true;
            this.f877b = this.f881h.m1a();
            if (this.f883j >= 0) {
                this.f881h.m7a(this.f884k, this.f885l);
                m1564a(this.f883j, false, true);
                this.f883j = -1;
                this.f884k = null;
                this.f885l = null;
            } else if (z) {
                requestLayout();
            } else {
                m1571c();
            }
        }
        if (this.ac != null && pagerAdapter2 != pagerAdapter) {
            this.ac.m1318a(pagerAdapter2, pagerAdapter);
        }
    }

    private void m1551g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f840a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.f881h;
    }

    void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.ac = onAdapterChangeListener;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f898y = false;
        if (this.f872S) {
            z = false;
        } else {
            z = true;
        }
        m1564a(i, z, false);
    }

    public void m1563a(int i, boolean z) {
        this.f898y = false;
        m1564a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f882i;
    }

    void m1564a(int i, boolean z, boolean z2) {
        m1565a(i, z, z2, 0);
    }

    void m1565a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f881h == null || this.f881h.m1a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f882i != i || this.f878e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f881h.m1a()) {
                i = this.f881h.m1a() - 1;
            }
            int i3 = this.f899z;
            if (i > this.f882i + i3 || i < this.f882i - i3) {
                for (int i4 = 0; i4 < this.f878e.size(); i4++) {
                    ((ItemInfo) this.f878e.get(i4)).f837c = true;
                }
            }
            if (this.f882i != i) {
                z3 = true;
            }
            if (this.f872S) {
                this.f882i = i;
                if (z3) {
                    m1548e(i);
                }
                requestLayout();
                return;
            }
            m1560a(i);
            m1536a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void m1536a(int i, boolean z, int i2, boolean z2) {
        int max;
        ItemInfo b = m1568b(i);
        if (b != null) {
            max = (int) (Math.max(this.f892s, Math.min(b.f839e, this.f893t)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m1562a(max, 0, i2);
            if (z2) {
                m1548e(i);
                return;
            }
            return;
        }
        if (z2) {
            m1548e(i);
        }
        m1540a(false);
        scrollTo(max, 0);
        m1547d(max);
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.aa = onPageChangeListener;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ae == null) {
                try {
                    this.ae = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ae.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.af == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.ag.get(i2)).getLayoutParams()).f845f;
    }

    OnPageChangeListener m1558a(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.ab;
        this.ab = onPageChangeListener;
        return onPageChangeListener2;
    }

    public int getOffscreenPageLimit() {
        return this.f899z;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f899z) {
            this.f899z = i;
            m1571c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f888o;
        this.f888o = i;
        int width = getWidth();
        m1535a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f888o;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f889p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f889p;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f889p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float m1555a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void m1562a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m1540a(false);
            m1571c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * m1555a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.f881h.m13b(this.f882i)) + ((float) this.f888o))) + 1.0f) * 100.0f);
        }
        this.f886m.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        ViewCompat.m1459b(this);
    }

    ItemInfo m1556a(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f836b = i;
        itemInfo.f835a = this.f881h.m5a((ViewGroup) this, i);
        itemInfo.f838d = this.f881h.m13b(i);
        if (i2 < 0 || i2 >= this.f878e.size()) {
            this.f878e.add(itemInfo);
        } else {
            this.f878e.add(i2, itemInfo);
        }
        return itemInfo;
    }

    void m1570b() {
        int a = this.f881h.m1a();
        this.f877b = a;
        boolean z = this.f878e.size() < (this.f899z * 2) + 1 && this.f878e.size() < a;
        boolean z2 = false;
        int i = this.f882i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f878e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            ItemInfo itemInfo = (ItemInfo) this.f878e.get(i2);
            int a2 = this.f881h.m2a(itemInfo.f835a);
            if (a2 == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a2 == -2) {
                this.f878e.remove(i2);
                i2--;
                if (!z2) {
                    this.f881h.m10a((ViewGroup) this);
                    z2 = true;
                }
                this.f881h.m11a((ViewGroup) this, itemInfo.f836b, itemInfo.f835a);
                if (this.f882i == itemInfo.f836b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f882i, a - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (itemInfo.f836b != a2) {
                if (itemInfo.f836b == this.f882i) {
                    i = a2;
                }
                itemInfo.f836b = a2;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f881h.m18b((ViewGroup) this);
        }
        Collections.sort(this.f878e, f852c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.f840a) {
                    layoutParams.f842c = 0.0f;
                }
            }
            m1564a(i, false, true);
            requestLayout();
        }
    }

    void m1571c() {
        m1560a(this.f882i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1560a(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.f882i;
        r0 = r19;
        if (r4 == r0) goto L_0x033f;
    L_0x000a:
        r0 = r18;
        r2 = r0.f882i;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.f882i;
        r0 = r18;
        r3 = r0.m1568b(r3);
        r0 = r19;
        r1 = r18;
        r1.f882i = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.f881h;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.m1552h();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.f898y;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.m1552h();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.f881h;
        r0 = r18;
        r2.m10a(r0);
        r0 = r18;
        r2 = r0.f899z;
        r5 = 0;
        r0 = r18;
        r6 = r0.f882i;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.f881h;
        r12 = r5.m1a();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.f882i;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.f877b;
        if (r12 == r2) goto L_0x00da;
    L_0x0073:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00d0 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00d0 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00d0 }
    L_0x007f:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r18;
        r5 = r0.f877b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.f881h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00d0:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007f;
    L_0x00da:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00dd:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x033c;
    L_0x00e7:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        r7 = r2.f836b;
        r0 = r18;
        r8 = r0.f882i;
        if (r7 < r8) goto L_0x01cf;
    L_0x00f9:
        r7 = r2.f836b;
        r0 = r18;
        r8 = r0.f882i;
        if (r7 != r8) goto L_0x033c;
    L_0x0101:
        if (r2 != 0) goto L_0x0339;
    L_0x0103:
        if (r12 <= 0) goto L_0x0339;
    L_0x0105:
        r0 = r18;
        r2 = r0.f882i;
        r0 = r18;
        r2 = r0.m1556a(r2, r5);
        r10 = r2;
    L_0x0110:
        if (r10 == 0) goto L_0x0180;
    L_0x0112:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d4;
    L_0x0117:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x0121:
        r14 = r18.getClientWidth();
        if (r14 > 0) goto L_0x01d7;
    L_0x0127:
        r6 = 0;
    L_0x0128:
        r0 = r18;
        r7 = r0.f882i;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0138:
        if (r9 < 0) goto L_0x0142;
    L_0x013a:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x0216;
    L_0x013e:
        if (r9 >= r11) goto L_0x0216;
    L_0x0140:
        if (r2 != 0) goto L_0x01e6;
    L_0x0142:
        r6 = r10.f838d;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x017b;
    L_0x014c:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x024c;
    L_0x0156:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.get(r9);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        r7 = r2;
    L_0x0161:
        if (r14 > 0) goto L_0x024f;
    L_0x0163:
        r2 = 0;
        r5 = r2;
    L_0x0165:
        r0 = r18;
        r2 = r0.f882i;
        r2 = r2 + 1;
        r16 = r2;
        r2 = r7;
        r7 = r9;
        r9 = r16;
    L_0x0171:
        if (r9 >= r12) goto L_0x017b;
    L_0x0173:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x029a;
    L_0x0177:
        if (r9 <= r13) goto L_0x029a;
    L_0x0179:
        if (r2 != 0) goto L_0x025c;
    L_0x017b:
        r0 = r18;
        r0.m1537a(r10, r8, r4);
    L_0x0180:
        r0 = r18;
        r4 = r0.f881h;
        r0 = r18;
        r5 = r0.f882i;
        if (r10 == 0) goto L_0x02e8;
    L_0x018a:
        r2 = r10.f835a;
    L_0x018c:
        r0 = r18;
        r4.m19b(r0, r5, r2);
        r0 = r18;
        r2 = r0.f881h;
        r0 = r18;
        r2.m18b(r0);
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x01a0:
        if (r4 >= r5) goto L_0x02eb;
    L_0x01a2:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.f845f = r4;
        r7 = r2.f840a;
        if (r7 != 0) goto L_0x01cb;
    L_0x01b4:
        r7 = r2.f842c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r18;
        r6 = r0.m1557a(r6);
        if (r6 == 0) goto L_0x01cb;
    L_0x01c3:
        r7 = r6.f838d;
        r2.f842c = r7;
        r6 = r6.f836b;
        r2.f844e = r6;
    L_0x01cb:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x01a0;
    L_0x01cf:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00dd;
    L_0x01d4:
        r2 = 0;
        goto L_0x0121;
    L_0x01d7:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.f838d;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0128;
    L_0x01e6:
        r15 = r2.f836b;
        if (r9 != r15) goto L_0x0210;
    L_0x01ea:
        r15 = r2.f837c;
        if (r15 != 0) goto L_0x0210;
    L_0x01ee:
        r0 = r18;
        r15 = r0.f878e;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.f881h;
        r2 = r2.f835a;
        r0 = r18;
        r15.m11a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0214;
    L_0x0206:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x0210:
        r9 = r9 + -1;
        goto L_0x0138;
    L_0x0214:
        r2 = 0;
        goto L_0x0210;
    L_0x0216:
        if (r2 == 0) goto L_0x0230;
    L_0x0218:
        r15 = r2.f836b;
        if (r9 != r15) goto L_0x0230;
    L_0x021c:
        r2 = r2.f838d;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x022e;
    L_0x0223:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        goto L_0x0210;
    L_0x022e:
        r2 = 0;
        goto L_0x0210;
    L_0x0230:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.m1556a(r9, r2);
        r2 = r2.f838d;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024a;
    L_0x023f:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
        goto L_0x0210;
    L_0x024a:
        r2 = 0;
        goto L_0x0210;
    L_0x024c:
        r7 = 0;
        goto L_0x0161;
    L_0x024f:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x0165;
    L_0x025c:
        r11 = r2.f836b;
        if (r9 != r11) goto L_0x0332;
    L_0x0260:
        r11 = r2.f837c;
        if (r11 != 0) goto L_0x0332;
    L_0x0264:
        r0 = r18;
        r11 = r0.f878e;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.f881h;
        r2 = r2.f835a;
        r0 = r18;
        r11.m11a(r0, r9, r2);
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0298;
    L_0x0280:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x028a:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x028f:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x0171;
    L_0x0298:
        r2 = 0;
        goto L_0x028a;
    L_0x029a:
        if (r2 == 0) goto L_0x02c1;
    L_0x029c:
        r11 = r2.f836b;
        if (r9 != r11) goto L_0x02c1;
    L_0x02a0:
        r2 = r2.f838d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02bf;
    L_0x02af:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x02b9:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02bf:
        r2 = 0;
        goto L_0x02b9;
    L_0x02c1:
        r0 = r18;
        r2 = r0.m1556a(r9, r7);
        r7 = r7 + 1;
        r2 = r2.f838d;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02e6;
    L_0x02d6:
        r0 = r18;
        r2 = r0.f878e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.ItemInfo) r2;
    L_0x02e0:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02e6:
        r2 = 0;
        goto L_0x02e0;
    L_0x02e8:
        r2 = 0;
        goto L_0x018c;
    L_0x02eb:
        r18.m1552h();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f4:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0330;
    L_0x02fa:
        r0 = r18;
        r2 = r0.m1569b(r2);
    L_0x0300:
        if (r2 == 0) goto L_0x030a;
    L_0x0302:
        r2 = r2.f836b;
        r0 = r18;
        r4 = r0.f882i;
        if (r2 == r4) goto L_0x002f;
    L_0x030a:
        r2 = 0;
    L_0x030b:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x0311:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.m1557a(r4);
        if (r5 == 0) goto L_0x032d;
    L_0x031f:
        r5 = r5.f836b;
        r0 = r18;
        r6 = r0.f882i;
        if (r5 != r6) goto L_0x032d;
    L_0x0327:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x032d:
        r2 = r2 + 1;
        goto L_0x030b;
    L_0x0330:
        r2 = 0;
        goto L_0x0300;
    L_0x0332:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x0339:
        r10 = r2;
        goto L_0x0110;
    L_0x033c:
        r2 = r6;
        goto L_0x0101;
    L_0x033f:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void m1552h() {
        if (this.af != 0) {
            if (this.ag == null) {
                this.ag = new ArrayList();
            } else {
                this.ag.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ag.add(getChildAt(i));
            }
            Collections.sort(this.ag, ah);
        }
    }

    private void m1537a(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        float f;
        float f2;
        int i2;
        ItemInfo itemInfo3;
        int i3;
        int a = this.f881h.m1a();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.f888o) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (itemInfo2 != null) {
            clientWidth = itemInfo2.f836b;
            int i4;
            if (clientWidth < itemInfo.f836b) {
                f2 = (itemInfo2.f839e + itemInfo2.f838d) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= itemInfo.f836b && i2 < this.f878e.size()) {
                    itemInfo3 = (ItemInfo) this.f878e.get(i2);
                    while (i4 > itemInfo3.f836b && i2 < this.f878e.size() - 1) {
                        i2++;
                        itemInfo3 = (ItemInfo) this.f878e.get(i2);
                    }
                    while (i4 < itemInfo3.f836b) {
                        f2 += this.f881h.m13b(i4) + f;
                        i4++;
                    }
                    itemInfo3.f839e = f2;
                    f2 += itemInfo3.f838d + f;
                    i4++;
                }
            } else if (clientWidth > itemInfo.f836b) {
                i2 = this.f878e.size() - 1;
                f2 = itemInfo2.f839e;
                i4 = clientWidth - 1;
                while (i4 >= itemInfo.f836b && i2 >= 0) {
                    itemInfo3 = (ItemInfo) this.f878e.get(i2);
                    while (i4 < itemInfo3.f836b && i2 > 0) {
                        i2--;
                        itemInfo3 = (ItemInfo) this.f878e.get(i2);
                    }
                    while (i4 > itemInfo3.f836b) {
                        f2 -= this.f881h.m13b(i4) + f;
                        i4--;
                    }
                    f2 -= itemInfo3.f838d + f;
                    itemInfo3.f839e = f2;
                    i4--;
                }
            }
        }
        int size = this.f878e.size();
        float f3 = itemInfo.f839e;
        i2 = itemInfo.f836b - 1;
        this.f892s = itemInfo.f836b == 0 ? itemInfo.f839e : -3.4028235E38f;
        this.f893t = itemInfo.f836b == a + -1 ? (itemInfo.f839e + itemInfo.f838d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            itemInfo3 = (ItemInfo) this.f878e.get(i3);
            f2 = f3;
            while (i2 > itemInfo3.f836b) {
                f2 -= this.f881h.m13b(i2) + f;
                i2--;
            }
            f3 = f2 - (itemInfo3.f838d + f);
            itemInfo3.f839e = f3;
            if (itemInfo3.f836b == 0) {
                this.f892s = f3;
            }
            i2--;
        }
        f3 = (itemInfo.f839e + itemInfo.f838d) + f;
        i2 = itemInfo.f836b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            itemInfo3 = (ItemInfo) this.f878e.get(i3);
            f2 = f3;
            while (i2 < itemInfo3.f836b) {
                f2 = (this.f881h.m13b(i2) + f) + f2;
                i2++;
            }
            if (itemInfo3.f836b == a - 1) {
                this.f893t = (itemInfo3.f838d + f2) - 1.0f;
            }
            itemInfo3.f839e = f2;
            f3 = f2 + (itemInfo3.f838d + f);
            i2++;
        }
        this.f873T = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f848a = this.f882i;
        if (this.f881h != null) {
            savedState.f849b = this.f881h.m14b();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f881h != null) {
                this.f881h.m7a(savedState.f849b, savedState.f850c);
                m1564a(savedState.f848a, false, true);
                return;
            }
            this.f883j = savedState.f848a;
            this.f884k = savedState.f849b;
            this.f885l = savedState.f850c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.f840a |= view instanceof Decor;
        if (!this.f896w) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.f840a) {
            layoutParams3.f843d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.f896w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    ItemInfo m1557a(View view) {
        for (int i = 0; i < this.f878e.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.f878e.get(i);
            if (this.f881h.m12a(view, itemInfo.f835a)) {
                return itemInfo;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    android.support.v4.view.ViewPager.ItemInfo m1569b(android.view.View r3) {
        /*
        r2 = this;
    L_0x0000:
        r0 = r3.getParent();
        if (r0 == r2) goto L_0x0012;
    L_0x0006:
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r1 = r0 instanceof android.view.View;
        if (r1 != 0) goto L_0x000e;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = (android.view.View) r0;
        r3 = r0;
        goto L_0x0000;
    L_0x0012:
        r0 = r2.m1557a(r3);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.b(android.view.View):android.support.v4.view.ViewPager$ItemInfo");
    }

    ItemInfo m1568b(int i) {
        for (int i2 = 0; i2 < this.f878e.size(); i2++) {
            ItemInfo itemInfo = (ItemInfo) this.f878e.get(i2);
            if (itemInfo.f836b == i) {
                return itemInfo;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f872S = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f857D = Math.min(measuredWidth / 10, this.f856C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.f840a) {
                    int i6 = layoutParams.f841b & 7;
                    int i7 = layoutParams.f841b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i5 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f894u = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f895v = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f896w = true;
        m1571c();
        this.f896w = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.f840a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.f842c * ((float) paddingLeft)), 1073741824), this.f895v);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m1535a(i, i3, this.f888o, this.f888o);
        }
    }

    private void m1535a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f878e.isEmpty()) {
            ItemInfo b = m1568b(this.f882i);
            int min = (int) ((b != null ? Math.min(b.f839e, this.f893t) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m1540a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.f886m.isFinished()) {
            this.f886m.startScroll(paddingLeft, 0, (int) (m1568b(this.f882i).f839e * ((float) i)), 0, this.f886m.getDuration() - this.f886m.timePassed());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            LayoutParams layoutParams;
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f840a) {
                    int i9 = layoutParams.f841b & 112;
                    switch (layoutParams.f841b & 7) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.f840a) {
                    ItemInfo a = m1557a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f839e * ((float) max))) + paddingLeft;
                        if (layoutParams.f843d) {
                            layoutParams.f843d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.f842c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f890q = paddingTop;
        this.f891r = i6 - paddingBottom;
        this.f875V = i7;
        if (this.f872S) {
            m1536a(this.f882i, false, 0, false);
        }
        this.f872S = false;
    }

    public void computeScroll() {
        if (this.f886m.isFinished() || !this.f886m.computeScrollOffset()) {
            m1540a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f886m.getCurrX();
        int currY = this.f886m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m1547d(currX)) {
                this.f886m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.m1459b(this);
    }

    private boolean m1547d(int i) {
        if (this.f878e.size() == 0) {
            this.f874U = false;
            m1561a(0, 0.0f, 0);
            if (this.f874U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo i2 = m1553i();
        int clientWidth = getClientWidth();
        int i3 = this.f888o + clientWidth;
        float f = ((float) this.f888o) / ((float) clientWidth);
        int i4 = i2.f836b;
        float f2 = ((((float) i) / ((float) clientWidth)) - i2.f839e) / (i2.f838d + f);
        clientWidth = (int) (((float) i3) * f2);
        this.f874U = false;
        m1561a(i4, f2, clientWidth);
        if (this.f874U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    @CallSuper
    protected void m1561a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f875V > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f840a) {
                    int max;
                    switch (layoutParams.f841b & 7) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        m1543b(i, f, i2);
        if (this.ad != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).f840a) {
                    this.ad.m1523a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f874U = true;
    }

    private void m1543b(int i, float f, int i2) {
        if (this.aa != null) {
            this.aa.m1320a(i, f, i2);
        }
        if (this.f876W != null) {
            int size = this.f876W.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.f876W.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.m1320a(i, f, i2);
                }
            }
        }
        if (this.ab != null) {
            this.ab.m1320a(i, f, i2);
        }
    }

    private void m1548e(int i) {
        if (this.aa != null) {
            this.aa.m1319a(i);
        }
        if (this.f876W != null) {
            int size = this.f876W.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.f876W.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.m1319a(i);
                }
            }
        }
        if (this.ab != null) {
            this.ab.m1319a(i);
        }
    }

    private void m1549f(int i) {
        if (this.aa != null) {
            this.aa.m1321b(i);
        }
        if (this.f876W != null) {
            int size = this.f876W.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.f876W.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.m1321b(i);
                }
            }
        }
        if (this.ab != null) {
            this.ab.m1321b(i);
        }
    }

    private void m1540a(boolean z) {
        int scrollX;
        boolean z2 = this.aj == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.f886m.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f886m.getCurrX();
            int currY = this.f886m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    m1547d(currX);
                }
            }
        }
        this.f898y = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.f878e.size(); scrollX++) {
            ItemInfo itemInfo = (ItemInfo) this.f878e.get(scrollX);
            if (itemInfo.f837c) {
                itemInfo.f837c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            ViewCompat.m1453a((View) this, this.ai);
        } else {
            this.ai.run();
        }
    }

    private boolean m1541a(float f, float f2) {
        return (f < ((float) this.f857D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f857D)) && f2 < 0.0f);
    }

    private void m1544b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ViewCompat.m1448a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f854A = false;
            this.f855B = false;
            this.f863J = -1;
            if (this.f864K == null) {
                return false;
            }
            this.f864K.recycle();
            this.f864K = null;
            return false;
        }
        if (action != 0) {
            if (this.f854A) {
                return true;
            }
            if (this.f855B) {
                return false;
            }
        }
        switch (action) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                float x = motionEvent.getX();
                this.f861H = x;
                this.f859F = x;
                x = motionEvent.getY();
                this.f862I = x;
                this.f860G = x;
                this.f863J = MotionEventCompat.m1286b(motionEvent, 0);
                this.f855B = false;
                this.f886m.computeScrollOffset();
                if (this.aj == 2 && Math.abs(this.f886m.getFinalX() - this.f886m.getCurrX()) > this.f868O) {
                    this.f886m.abortAnimation();
                    this.f898y = false;
                    m1571c();
                    this.f854A = true;
                    m1546c(true);
                    setScrollState(1);
                    break;
                }
                m1540a(false);
                this.f854A = false;
                break;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                action = this.f863J;
                if (action != -1) {
                    action = MotionEventCompat.m1284a(motionEvent, action);
                    float c = MotionEventCompat.m1287c(motionEvent, action);
                    float f = c - this.f859F;
                    float abs = Math.abs(f);
                    float d = MotionEventCompat.m1289d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f862I);
                    if (f == 0.0f || m1541a(this.f859F, f) || !m1567a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f858E) && 0.5f * abs > abs2) {
                            this.f854A = true;
                            m1546c(true);
                            setScrollState(1);
                            this.f859F = f > 0.0f ? this.f861H + ((float) this.f858E) : this.f861H - ((float) this.f858E);
                            this.f860G = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f858E)) {
                            this.f855B = true;
                        }
                        if (this.f854A && m1545b(c)) {
                            ViewCompat.m1459b(this);
                            break;
                        }
                    }
                    this.f859F = c;
                    this.f860G = d;
                    this.f855B = true;
                    return false;
                }
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m1539a(motionEvent);
                break;
        }
        if (this.f864K == null) {
            this.f864K = VelocityTracker.obtain();
        }
        this.f864K.addMovement(motionEvent);
        return this.f854A;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f869P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f881h == null || this.f881h.m1a() == 0) {
            return false;
        }
        if (this.f864K == null) {
            this.f864K = VelocityTracker.obtain();
        }
        this.f864K.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f886m.abortAnimation();
                this.f898y = false;
                m1571c();
                x = motionEvent.getX();
                this.f861H = x;
                this.f859F = x;
                x = motionEvent.getY();
                this.f862I = x;
                this.f860G = x;
                this.f863J = MotionEventCompat.m1286b(motionEvent, 0);
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (this.f854A) {
                    VelocityTracker velocityTracker = this.f864K;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f866M);
                    a = (int) VelocityTrackerCompat.m1342a(velocityTracker, this.f863J);
                    this.f898y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    ItemInfo i = m1553i();
                    m1565a(m1532a(i.f836b, ((((float) scrollX) / ((float) clientWidth)) - i.f839e) / i.f838d, a, (int) (MotionEventCompat.m1287c(motionEvent, MotionEventCompat.m1284a(motionEvent, this.f863J)) - this.f861H)), true, true, a);
                    this.f863J = -1;
                    m1554j();
                    z = this.f871R.m2196c() | this.f870Q.m2196c();
                    break;
                }
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (!this.f854A) {
                    a = MotionEventCompat.m1284a(motionEvent, this.f863J);
                    float c = MotionEventCompat.m1287c(motionEvent, a);
                    float abs = Math.abs(c - this.f859F);
                    float d = MotionEventCompat.m1289d(motionEvent, a);
                    x = Math.abs(d - this.f860G);
                    if (abs > ((float) this.f858E) && abs > x) {
                        this.f854A = true;
                        m1546c(true);
                        if (c - this.f861H > 0.0f) {
                            x = this.f861H + ((float) this.f858E);
                        } else {
                            x = this.f861H - ((float) this.f858E);
                        }
                        this.f859F = x;
                        this.f860G = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f854A) {
                    z = false | m1545b(MotionEventCompat.m1287c(motionEvent, MotionEventCompat.m1284a(motionEvent, this.f863J)));
                    break;
                }
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f854A) {
                    m1536a(this.f882i, true, 0, false);
                    this.f863J = -1;
                    m1554j();
                    z = this.f871R.m2196c() | this.f870Q.m2196c();
                    break;
                }
                break;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                a = MotionEventCompat.m1285b(motionEvent);
                this.f859F = MotionEventCompat.m1287c(motionEvent, a);
                this.f863J = MotionEventCompat.m1286b(motionEvent, a);
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m1539a(motionEvent);
                this.f859F = MotionEventCompat.m1287c(motionEvent, MotionEventCompat.m1284a(motionEvent, this.f863J));
                break;
        }
        if (z) {
            ViewCompat.m1459b(this);
        }
        return true;
    }

    private void m1546c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m1545b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f859F - f;
        this.f859F = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f892s;
        float f5 = ((float) clientWidth) * this.f893t;
        ItemInfo itemInfo = (ItemInfo) this.f878e.get(0);
        ItemInfo itemInfo2 = (ItemInfo) this.f878e.get(this.f878e.size() - 1);
        if (itemInfo.f836b != 0) {
            f4 = itemInfo.f839e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f836b != this.f881h.m1a() - 1) {
            f2 = itemInfo2.f839e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f870Q.m2191a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f871R.m2191a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f859F += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m1547d((int) f4);
        return z3;
    }

    private ItemInfo m1553i() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.f888o) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        ItemInfo itemInfo = null;
        while (i2 < this.f878e.size()) {
            int i3;
            ItemInfo itemInfo2;
            ItemInfo itemInfo3 = (ItemInfo) this.f878e.get(i2);
            ItemInfo itemInfo4;
            if (obj != null || itemInfo3.f836b == i + 1) {
                itemInfo4 = itemInfo3;
                i3 = i2;
                itemInfo2 = itemInfo4;
            } else {
                itemInfo3 = this.f879f;
                itemInfo3.f839e = (f2 + f3) + f;
                itemInfo3.f836b = i + 1;
                itemInfo3.f838d = this.f881h.m13b(itemInfo3.f836b);
                itemInfo4 = itemInfo3;
                i3 = i2 - 1;
                itemInfo2 = itemInfo4;
            }
            f2 = itemInfo2.f839e;
            f3 = (itemInfo2.f838d + f2) + f;
            if (obj == null && scrollX < f2) {
                return itemInfo;
            }
            if (scrollX < f3 || i3 == this.f878e.size() - 1) {
                return itemInfo2;
            }
            f3 = f2;
            i = itemInfo2.f836b;
            obj = null;
            f2 = itemInfo2.f838d;
            itemInfo = itemInfo2;
            i2 = i3 + 1;
        }
        return itemInfo;
    }

    private int m1532a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f867N || Math.abs(i2) <= this.f865L) {
            i = (int) ((i >= this.f882i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f878e.size() <= 0) {
            return i;
        }
        return Math.max(((ItemInfo) this.f878e.get(0)).f836b, Math.min(i, ((ItemInfo) this.f878e.get(this.f878e.size() - 1)).f836b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ViewCompat.m1445a(this);
        if (a == 0 || (a == 1 && this.f881h != null && this.f881h.m1a() > 1)) {
            int height;
            int width;
            if (!this.f870Q.m2190a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f892s * ((float) width));
                this.f870Q.m2189a(height, width);
                i = 0 | this.f870Q.m2194a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f871R.m2190a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f893t + 1.0f)) * ((float) height));
                this.f871R.m2189a(width, height);
                i |= this.f871R.m2194a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f870Q.m2195b();
            this.f871R.m2195b();
        }
        if (i != 0) {
            ViewCompat.m1459b(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f888o > 0 && this.f889p != null && this.f878e.size() > 0 && this.f881h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f888o) / ((float) width);
            ItemInfo itemInfo = (ItemInfo) this.f878e.get(0);
            float f2 = itemInfo.f839e;
            int size = this.f878e.size();
            int i = itemInfo.f836b;
            int i2 = ((ItemInfo) this.f878e.get(size - 1)).f836b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > itemInfo.f836b && i3 < size) {
                    i3++;
                    itemInfo = (ItemInfo) this.f878e.get(i3);
                }
                if (i4 == itemInfo.f836b) {
                    f3 = (itemInfo.f839e + itemInfo.f838d) * ((float) width);
                    f2 = (itemInfo.f839e + itemInfo.f838d) + f;
                } else {
                    float b = this.f881h.m13b(i4);
                    f3 = (f2 + b) * ((float) width);
                    f2 += b + f;
                }
                if (((float) this.f888o) + f3 > ((float) scrollX)) {
                    this.f889p.setBounds((int) f3, this.f890q, (int) ((((float) this.f888o) + f3) + 0.5f), this.f891r);
                    this.f889p.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void m1539a(MotionEvent motionEvent) {
        int b = MotionEventCompat.m1285b(motionEvent);
        if (MotionEventCompat.m1286b(motionEvent, b) == this.f863J) {
            b = b == 0 ? 1 : 0;
            this.f859F = MotionEventCompat.m1287c(motionEvent, b);
            this.f863J = MotionEventCompat.m1286b(motionEvent, b);
            if (this.f864K != null) {
                this.f864K.clear();
            }
        }
    }

    private void m1554j() {
        this.f854A = false;
        this.f855B = false;
        if (this.f864K != null) {
            this.f864K.recycle();
            this.f864K = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f897x != z) {
            this.f897x = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f881h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f892s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f893t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean m1567a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m1567a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && ViewCompat.m1457a(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1566a(keyEvent);
    }

    public boolean m1566a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case C0264R.styleable.Window_immersionButtonCloseBackground /*21*/:
                return m1572c(17);
            case C0264R.styleable.Window_immersionWindowBackground /*22*/:
                return m1572c(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (KeyEventCompat.m1240a(keyEvent)) {
                    return m1572c(2);
                }
                if (KeyEventCompat.m1241a(keyEvent, 1)) {
                    return m1572c(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean m1572c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m1573d();
            } else {
                if (i == 66 || i == 2) {
                    d = m1574e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m1533a(this.f880g, findNextFocus).left < m1533a(this.f880g, view).left) ? findNextFocus.requestFocus() : m1573d();
        } else {
            if (i == 66) {
                d = (view == null || m1533a(this.f880g, findNextFocus).left > m1533a(this.f880g, view).left) ? findNextFocus.requestFocus() : m1574e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    private Rect m1533a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean m1573d() {
        if (this.f882i <= 0) {
            return false;
        }
        m1563a(this.f882i - 1, true);
        return true;
    }

    boolean m1574e() {
        if (this.f881h == null || this.f882i >= this.f881h.m1a() - 1) {
            return false;
        }
        m1563a(this.f882i + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    ItemInfo a = m1557a(childAt);
                    if (a != null && a.f836b == this.f882i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = m1557a(childAt);
                if (a != null && a.f836b == this.f882i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = m1557a(childAt);
                if (a != null && a.f836b == this.f882i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = m1557a(childAt);
                if (a != null && a.f836b == this.f882i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
