package com.miui.support.view;

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
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.widget.ActionBarOverlayLayout;
import com.miui.support.util.ActionBarUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ViewPager extends ViewGroup {
    private static final int[] f3876c;
    private static final Comparator<ItemInfo> f3877d;
    private static final Interpolator f3878e;
    private boolean f3879A;
    private boolean f3880B;
    private int f3881C;
    private int f3882D;
    private int f3883E;
    private float f3884F;
    private float f3885G;
    private boolean f3886H;
    private float f3887I;
    private float f3888J;
    private int f3889K;
    private VelocityTracker f3890L;
    private int f3891M;
    private int f3892N;
    private int f3893O;
    private int f3894P;
    private boolean f3895Q;
    private EdgeEffect f3896R;
    private EdgeEffect f3897S;
    private boolean f3898T;
    private boolean f3899U;
    private boolean f3900V;
    private int f3901W;
    boolean f3902a;
    private OnPageChangeListener aa;
    private OnPageChangeListener ab;
    private OnAdapterChangeListener ac;
    private int ad;
    float f3903b;
    private final ArrayList<ItemInfo> f3904f;
    private final ItemInfo f3905g;
    private final Rect f3906h;
    private PagerAdapter f3907i;
    private int f3908j;
    private int f3909k;
    private Parcelable f3910l;
    private Scroller f3911m;
    private PagerObserver f3912n;
    private int f3913o;
    private Drawable f3914p;
    private int f3915q;
    private int f3916r;
    private float f3917s;
    private float f3918t;
    private int f3919u;
    private int f3920v;
    private boolean f3921w;
    private boolean f3922x;
    private boolean f3923y;
    private int f3924z;

    public interface OnPageChangeListener {
        void m3683a(int i);

        void m3684a(int i, float f, int i2);

        void m3685b(int i);
    }

    /* renamed from: com.miui.support.view.ViewPager.1 */
    final class C04471 implements Comparator<ItemInfo> {
        C04471() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5621a((ItemInfo) obj, (ItemInfo) obj2);
        }

        public int m5621a(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f3864b - itemInfo2.f3864b;
        }
    }

    /* renamed from: com.miui.support.view.ViewPager.2 */
    final class C04482 implements Interpolator {
        C04482() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    interface Decor {
    }

    static class ItemInfo {
        Object f3863a;
        int f3864b;
        boolean f3865c;
        float f3866d;
        float f3867e;
        boolean f3868f;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean f3869a;
        public int f3870b;
        public float f3871c;
        public boolean f3872d;

        public LayoutParams() {
            super(-1, -1);
            this.f3871c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3871c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f3876c);
            this.f3870b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    interface OnAdapterChangeListener {
        void m5622a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    private class PagerObserver extends DataSetObserver {
        final /* synthetic */ ViewPager f3873a;

        private PagerObserver(ViewPager viewPager) {
            this.f3873a = viewPager;
        }

        public void onChanged() {
            this.f3873a.m5655b();
        }

        public void onInvalidated() {
            this.f3873a.m5655b();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f3874a;
        Parcelable f3875b;

        /* renamed from: com.miui.support.view.ViewPager.SavedState.1 */
        final class C04491 implements Creator<SavedState> {
            C04491() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m5623a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m5624a(i);
            }

            public SavedState m5623a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m5624a(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3874a);
            parcel.writeParcelable(this.f3875b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f3874a + "}";
        }

        static {
            CREATOR = new C04491();
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f3874a = parcel.readInt();
            this.f3875b = parcel.readParcelable(null);
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void m5626a(int i, float f, int i2) {
        }

        public void m5625a(int i) {
        }

        public void m5627b(int i) {
        }
    }

    static {
        f3876c = new int[]{16842931};
        f3877d = new C04471();
        f3878e = new C04482();
    }

    public ViewPager(Context context) {
        super(context);
        this.f3904f = new ArrayList();
        this.f3905g = new ItemInfo();
        this.f3906h = new Rect();
        this.f3909k = -1;
        this.f3910l = null;
        this.f3917s = -3.4028235E38f;
        this.f3918t = Float.MAX_VALUE;
        this.f3924z = 3;
        this.f3889K = -1;
        this.f3898T = true;
        this.f3899U = false;
        this.f3902a = true;
        this.f3903b = 0.0f;
        this.ad = 0;
        m5644a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3904f = new ArrayList();
        this.f3905g = new ItemInfo();
        this.f3906h = new Rect();
        this.f3909k = -1;
        this.f3910l = null;
        this.f3917s = -3.4028235E38f;
        this.f3918t = Float.MAX_VALUE;
        this.f3924z = 3;
        this.f3889K = -1;
        this.f3898T = true;
        this.f3899U = false;
        this.f3902a = true;
        this.f3903b = 0.0f;
        this.ad = 0;
        m5644a();
    }

    void m5644a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f3911m = new Scroller(context, f3878e);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3883E = viewConfiguration.getScaledPagingTouchSlop();
        this.f3891M = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3892N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3896R = new EdgeEffect(context);
        this.f3897S = new EdgeEffect(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f3893O = (int) (25.0f * f);
        this.f3894P = (int) (2.0f * f);
        this.f3881C = (int) (f * 16.0f);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private void setScrollState(int i) {
        if (this.ad != i) {
            this.ad = i;
            if (this.aa != null) {
                this.aa.m3685b(i);
            }
            if (this.ab != null) {
                this.ab.m3685b(i);
            }
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f3907i != null) {
            this.f3907i.m3795b(this.f3912n);
            this.f3907i.m3790a((ViewGroup) this);
            Iterator it = this.f3904f.iterator();
            while (it.hasNext()) {
                ItemInfo itemInfo = (ItemInfo) it.next();
                this.f3907i.m3791a((ViewGroup) this, itemInfo.f3864b, itemInfo.f3863a);
            }
            this.f3907i.m3798b((ViewGroup) this);
            this.f3904f.clear();
            m5637g();
            this.f3908j = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.f3907i;
        this.f3907i = pagerAdapter;
        if (this.f3907i != null) {
            if (this.f3912n == null) {
                this.f3912n = new PagerObserver();
            }
            this.f3907i.m3786a(this.f3912n);
            this.f3923y = false;
            this.f3898T = true;
            if (this.f3909k >= 0) {
                this.f3907i.m3787a(this.f3910l, null);
                m5649a(this.f3909k, false, true);
                this.f3909k = -1;
                this.f3910l = null;
            } else {
                m5656c();
            }
        }
        if (this.ac != null && pagerAdapter2 != pagerAdapter) {
            this.ac.m5622a(pagerAdapter2, pagerAdapter);
        }
    }

    private void m5637g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f3869a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.f3907i;
    }

    void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.ac = onAdapterChangeListener;
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f3923y = false;
        if (this.f3898T) {
            z = false;
        } else {
            z = true;
        }
        m5649a(i, z, false);
    }

    public void m5648a(int i, boolean z) {
        this.f3923y = false;
        m5649a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f3908j;
    }

    void m5649a(int i, boolean z, boolean z2) {
        m5650a(i, z, z2, 0);
    }

    void m5650a(int i, boolean z, boolean z2, int i2) {
        if (this.f3907i == null || this.f3907i.m3782a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f3908j != i || this.f3904f.size() == 0) {
            int max;
            if (i < 0) {
                i = 0;
            } else if (i >= this.f3907i.m3782a()) {
                i = this.f3907i.m3782a() - 1;
            }
            int i3 = this.f3924z;
            if (i > this.f3908j + i3 || i < this.f3908j - i3) {
                Iterator it = this.f3904f.iterator();
                while (it.hasNext()) {
                    ((ItemInfo) it.next()).f3865c = true;
                }
            }
            boolean z3 = this.f3908j != i;
            m5645a(i);
            ItemInfo b = m5653b(i);
            if (b != null) {
                max = (int) (Math.max(this.f3917s, Math.min(b.f3867e, this.f3918t)) * ((float) getWidth()));
            } else {
                max = 0;
            }
            if (z) {
                m5647a(max, 0, i2);
                if (z3 && this.aa != null) {
                    this.aa.m3683a(i);
                }
                if (z3 && this.ab != null) {
                    this.ab.m3683a(i);
                    return;
                }
                return;
            }
            if (z3 && this.aa != null) {
                this.aa.m3683a(i);
            }
            if (z3 && this.ab != null) {
                this.ab.m3683a(i);
            }
            m5638h();
            scrollTo(max, 0);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.aa = onPageChangeListener;
    }

    public int getOffscreenPageLimit() {
        return this.f3924z;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 3) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 3);
            i = 3;
        }
        if (i != this.f3924z) {
            this.f3924z = i;
            m5656c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f3913o;
        this.f3913o = i;
        int width = getWidth();
        m5630a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f3913o;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f3914p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3914p;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3914p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float m5641a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void m5647a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m5638h();
            m5656c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int width = getWidth();
        int i6 = width / 2;
        float a = (((float) i6) * m5641a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) width)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            width = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            width = (int) (((((float) Math.abs(i4)) / ((((float) width) * this.f3907i.m3800c(this.f3908j)) + ((float) this.f3913o))) + 1.0f) * 250.0f);
        }
        this.f3911m.startScroll(scrollX, scrollY, i4, i5, Math.min(width, 800));
        postInvalidateOnAnimation();
    }

    ItemInfo m5642a(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f3864b = i;
        itemInfo.f3863a = this.f3907i.m3785a((ViewGroup) this, i);
        itemInfo.f3866d = this.f3907i.m3800c(i);
        itemInfo.f3868f = this.f3907i.m3792a(i);
        if (i2 < 0 || i2 >= this.f3904f.size()) {
            this.f3904f.add(itemInfo);
        } else {
            this.f3904f.add(i2, itemInfo);
        }
        return itemInfo;
    }

    void m5655b() {
        boolean z = false;
        boolean z2 = this.f3904f.size() < (this.f3924z * 2) + 1 && this.f3904f.size() < this.f3907i.m3782a();
        boolean z3 = false;
        boolean z4 = false;
        int i = this.f3908j;
        boolean z5 = z2;
        int i2 = 0;
        while (i2 < this.f3904f.size()) {
            int i3;
            int i4;
            boolean z6;
            boolean z7;
            ItemInfo itemInfo = (ItemInfo) this.f3904f.get(i2);
            int a = this.f3907i.m3783a(itemInfo.f3863a);
            if (a == -1) {
                if (itemInfo.f3868f != this.f3907i.m3792a(itemInfo.f3864b)) {
                    if (itemInfo.f3868f) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    itemInfo.f3868f = z4;
                    i3 = i2;
                    i4 = i;
                    z6 = z3;
                    z7 = z5;
                    z3 = true;
                }
                i3 = i2;
                z6 = z3;
                z3 = z4;
                i4 = i;
                z7 = z5;
            } else if (a == -2) {
                this.f3904f.remove(i2);
                i2--;
                if (!z3) {
                    this.f3907i.m3790a((ViewGroup) this);
                    z3 = true;
                }
                this.f3907i.m3791a((ViewGroup) this, itemInfo.f3864b, itemInfo.f3863a);
                if (this.f3908j == itemInfo.f3864b) {
                    i3 = i2;
                    z6 = z3;
                    z3 = z4;
                    i4 = Math.max(0, Math.min(this.f3908j, this.f3907i.m3782a() - 1));
                    z7 = true;
                } else {
                    i3 = i2;
                    z6 = z3;
                    z3 = z4;
                    i4 = i;
                    z7 = true;
                }
            } else {
                if (itemInfo.f3864b != a) {
                    if (itemInfo.f3864b == this.f3908j) {
                        i = a;
                    }
                    itemInfo.f3864b = a;
                    z5 = true;
                }
                if (itemInfo.f3868f != this.f3907i.m3792a(itemInfo.f3864b)) {
                    if (itemInfo.f3868f) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    itemInfo.f3868f = z4;
                    i3 = i2;
                    i4 = i;
                    z6 = z3;
                    z7 = z5;
                    z3 = true;
                }
                i3 = i2;
                z6 = z3;
                z3 = z4;
                i4 = i;
                z7 = z5;
            }
            z5 = z7;
            i = i4;
            z4 = z3;
            z3 = z6;
            i2 = i3 + 1;
        }
        if (z3) {
            this.f3907i.m3798b((ViewGroup) this);
        }
        Collections.sort(this.f3904f, f3877d);
        if (z5) {
            int childCount = getChildCount();
            for (i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.f3869a) {
                    layoutParams.f3871c = 0.0f;
                }
            }
            m5649a(i, false, true);
            requestLayout();
        } else {
            z = z4;
        }
        if (z) {
            requestLayout();
        }
    }

    void m5656c() {
        m5645a(this.f3908j);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m5645a(int r15) {
        /*
        r14 = this;
        r0 = 0;
        r1 = r14.f3908j;
        if (r1 == r15) goto L_0x0216;
    L_0x0005:
        r0 = r14.f3908j;
        r0 = r14.m5653b(r0);
        r14.f3908j = r15;
        r1 = r0;
    L_0x000e:
        r0 = r14.f3907i;
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r0 = r14.f3923y;
        if (r0 != 0) goto L_0x0012;
    L_0x0017:
        r0 = r14.getWindowToken();
        if (r0 == 0) goto L_0x0012;
    L_0x001d:
        r0 = r14.f3907i;
        r0.m3790a(r14);
        r0 = r14.f3924z;
        r2 = 0;
        r3 = r14.f3908j;
        r3 = r3 - r0;
        r7 = java.lang.Math.max(r2, r3);
        r2 = r14.f3907i;
        r8 = r2.m3782a();
        r2 = r8 + -1;
        r3 = r14.f3908j;
        r0 = r0 + r3;
        r9 = java.lang.Math.min(r2, r0);
        r3 = 0;
        r0 = 0;
        r2 = r0;
    L_0x003e:
        r0 = r14.f3904f;
        r0 = r0.size();
        if (r2 >= r0) goto L_0x0213;
    L_0x0046:
        r0 = r14.f3904f;
        r0 = r0.get(r2);
        r0 = (com.miui.support.view.ViewPager.ItemInfo) r0;
        r4 = r0.f3864b;
        r5 = r14.f3908j;
        if (r4 < r5) goto L_0x00fa;
    L_0x0054:
        r4 = r0.f3864b;
        r5 = r14.f3908j;
        if (r4 != r5) goto L_0x0213;
    L_0x005a:
        if (r0 != 0) goto L_0x0210;
    L_0x005c:
        if (r8 <= 0) goto L_0x0210;
    L_0x005e:
        r0 = r14.f3908j;
        r0 = r14.m5642a(r0, r2);
        r6 = r0;
    L_0x0065:
        if (r6 == 0) goto L_0x00bf;
    L_0x0067:
        r5 = 0;
        r4 = r2 + -1;
        if (r4 < 0) goto L_0x00ff;
    L_0x006c:
        r0 = r14.f3904f;
        r0 = r0.get(r4);
        r0 = (com.miui.support.view.ViewPager.ItemInfo) r0;
    L_0x0074:
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r10 = r6.f3866d;
        r10 = r3 - r10;
        r3 = r14.f3908j;
        r3 = r3 + -1;
        r12 = r3;
        r3 = r5;
        r5 = r12;
        r13 = r4;
        r4 = r2;
        r2 = r13;
    L_0x0084:
        if (r5 < 0) goto L_0x008e;
    L_0x0086:
        r11 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        if (r11 < 0) goto L_0x012a;
    L_0x008a:
        if (r5 >= r7) goto L_0x012a;
    L_0x008c:
        if (r0 != 0) goto L_0x0102;
    L_0x008e:
        r3 = r6.f3866d;
        r5 = r4 + 1;
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x00bc;
    L_0x0098:
        r0 = r14.f3904f;
        r0 = r0.size();
        if (r5 >= r0) goto L_0x015a;
    L_0x00a0:
        r0 = r14.f3904f;
        r0 = r0.get(r5);
        r0 = (com.miui.support.view.ViewPager.ItemInfo) r0;
    L_0x00a8:
        r2 = r14.f3908j;
        r2 = r2 + 1;
        r12 = r2;
        r2 = r3;
        r3 = r5;
        r5 = r12;
    L_0x00b0:
        if (r5 >= r8) goto L_0x00bc;
    L_0x00b2:
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r7 < 0) goto L_0x018d;
    L_0x00b8:
        if (r5 <= r9) goto L_0x018d;
    L_0x00ba:
        if (r0 != 0) goto L_0x015d;
    L_0x00bc:
        r14.m5632a(r6, r4, r1);
    L_0x00bf:
        r1 = r14.f3907i;
        r2 = r14.f3908j;
        if (r6 == 0) goto L_0x01cd;
    L_0x00c5:
        r0 = r6.f3863a;
    L_0x00c7:
        r1.m3799b(r14, r2, r0);
        r0 = r14.f3907i;
        r0.m3798b(r14);
        r2 = r14.getChildCount();
        r0 = 0;
        r1 = r0;
    L_0x00d5:
        if (r1 >= r2) goto L_0x01d0;
    L_0x00d7:
        r3 = r14.getChildAt(r1);
        r0 = r3.getLayoutParams();
        r0 = (com.miui.support.view.ViewPager.LayoutParams) r0;
        r4 = r0.f3869a;
        if (r4 != 0) goto L_0x00f6;
    L_0x00e5:
        r4 = r0.f3871c;
        r5 = 0;
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 != 0) goto L_0x00f6;
    L_0x00ec:
        r3 = r14.m5643a(r3);
        if (r3 == 0) goto L_0x00f6;
    L_0x00f2:
        r3 = r3.f3866d;
        r0.f3871c = r3;
    L_0x00f6:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00d5;
    L_0x00fa:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x003e;
    L_0x00ff:
        r0 = 0;
        goto L_0x0074;
    L_0x0102:
        r11 = r0.f3864b;
        if (r5 != r11) goto L_0x0124;
    L_0x0106:
        r11 = r0.f3865c;
        if (r11 != 0) goto L_0x0124;
    L_0x010a:
        r11 = r14.f3904f;
        r11.remove(r2);
        r11 = r14.f3907i;
        r0 = r0.f3863a;
        r11.m3791a(r14, r5, r0);
        r2 = r2 + -1;
        r4 = r4 + -1;
        if (r2 < 0) goto L_0x0128;
    L_0x011c:
        r0 = r14.f3904f;
        r0 = r0.get(r2);
        r0 = (com.miui.support.view.ViewPager.ItemInfo) r0;
    L_0x0124:
        r5 = r5 + -1;
        goto L_0x0084;
    L_0x0128:
        r0 = 0;
        goto L_0x0124;
    L_0x012a:
        if (r0 == 0) goto L_0x0142;
    L_0x012c:
        r11 = r0.f3864b;
        if (r5 != r11) goto L_0x0142;
    L_0x0130:
        r0 = r0.f3866d;
        r3 = r3 + r0;
        r2 = r2 + -1;
        if (r2 < 0) goto L_0x0140;
    L_0x0137:
        r0 = r14.f3904f;
        r0 = r0.get(r2);
        r0 = (com.miui.support.view.ViewPager.ItemInfo) r0;
        goto L_0x0124;
    L_0x0140:
        r0 = 0;
        goto L_0x0124;
    L_0x0142:
        r0 = r2 + 1;
        r0 = r14.m5642a(r5, r0);
        r0 = r0.f3866d;
        r3 = r3 + r0;
        r4 = r4 + 1;
        if (r2 < 0) goto L_0x0158;
    L_0x014f:
        r0 = r14.f3904f;
        r0 = r0.get(r2);
        r0 = (com.miui.support.view.ViewPager.ItemInfo) r0;
        goto L_0x0124;
    L_0x0158:
        r0 = 0;
        goto L_0x0124;
    L_0x015a:
        r0 = 0;
        goto L_0x00a8;
    L_0x015d:
        r7 = r0.f3864b;
        if (r5 != r7) goto L_0x020b;
    L_0x0161:
        r7 = r0.f3865c;
        if (r7 != 0) goto L_0x020b;
    L_0x0165:
        r7 = r14.f3904f;
        r7.remove(r3);
        r7 = r14.f3907i;
        r0 = r0.f3863a;
        r7.m3791a(r14, r5, r0);
        r0 = r14.f3904f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x018b;
    L_0x0179:
        r0 = r14.f3904f;
        r0 = r0.get(r3);
        r0 = (com.miui.support.view.ViewPager.ItemInfo) r0;
    L_0x0181:
        r12 = r2;
        r2 = r0;
        r0 = r12;
    L_0x0184:
        r5 = r5 + 1;
        r12 = r0;
        r0 = r2;
        r2 = r12;
        goto L_0x00b0;
    L_0x018b:
        r0 = 0;
        goto L_0x0181;
    L_0x018d:
        if (r0 == 0) goto L_0x01ae;
    L_0x018f:
        r7 = r0.f3864b;
        if (r5 != r7) goto L_0x01ae;
    L_0x0193:
        r0 = r0.f3866d;
        r2 = r2 + r0;
        r3 = r3 + 1;
        r0 = r14.f3904f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x01ac;
    L_0x01a0:
        r0 = r14.f3904f;
        r0 = r0.get(r3);
        r0 = (com.miui.support.view.ViewPager.ItemInfo) r0;
    L_0x01a8:
        r12 = r2;
        r2 = r0;
        r0 = r12;
        goto L_0x0184;
    L_0x01ac:
        r0 = 0;
        goto L_0x01a8;
    L_0x01ae:
        r0 = r14.m5642a(r5, r3);
        r3 = r3 + 1;
        r0 = r0.f3866d;
        r2 = r2 + r0;
        r0 = r14.f3904f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x01cb;
    L_0x01bf:
        r0 = r14.f3904f;
        r0 = r0.get(r3);
        r0 = (com.miui.support.view.ViewPager.ItemInfo) r0;
    L_0x01c7:
        r12 = r2;
        r2 = r0;
        r0 = r12;
        goto L_0x0184;
    L_0x01cb:
        r0 = 0;
        goto L_0x01c7;
    L_0x01cd:
        r0 = 0;
        goto L_0x00c7;
    L_0x01d0:
        r0 = r14.hasFocus();
        if (r0 == 0) goto L_0x0012;
    L_0x01d6:
        r0 = r14.findFocus();
        if (r0 == 0) goto L_0x0209;
    L_0x01dc:
        r0 = r14.m5654b(r0);
    L_0x01e0:
        if (r0 == 0) goto L_0x01e8;
    L_0x01e2:
        r0 = r0.f3864b;
        r1 = r14.f3908j;
        if (r0 == r1) goto L_0x0012;
    L_0x01e8:
        r0 = 0;
    L_0x01e9:
        r1 = r14.getChildCount();
        if (r0 >= r1) goto L_0x0012;
    L_0x01ef:
        r1 = r14.getChildAt(r0);
        r2 = r14.m5643a(r1);
        if (r2 == 0) goto L_0x0206;
    L_0x01f9:
        r2 = r2.f3864b;
        r3 = r14.f3908j;
        if (r2 != r3) goto L_0x0206;
    L_0x01ff:
        r2 = 2;
        r1 = r1.requestFocus(r2);
        if (r1 != 0) goto L_0x0012;
    L_0x0206:
        r0 = r0 + 1;
        goto L_0x01e9;
    L_0x0209:
        r0 = 0;
        goto L_0x01e0;
    L_0x020b:
        r12 = r2;
        r2 = r0;
        r0 = r12;
        goto L_0x0184;
    L_0x0210:
        r6 = r0;
        goto L_0x0065;
    L_0x0213:
        r0 = r3;
        goto L_0x005a;
    L_0x0216:
        r1 = r0;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.view.ViewPager.a(int):void");
    }

    private void m5632a(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        float f;
        float f2;
        int i2;
        ItemInfo itemInfo3;
        int i3;
        int a = this.f3907i.m3782a();
        int width = getWidth();
        if (width > 0) {
            f = ((float) this.f3913o) / ((float) width);
        } else {
            f = 0.0f;
        }
        if (itemInfo2 != null) {
            width = itemInfo2.f3864b;
            int i4;
            int i5;
            float f3;
            int i6;
            float c;
            if (width < itemInfo.f3864b) {
                f2 = (itemInfo2.f3867e + itemInfo2.f3866d) + f;
                i4 = 0;
                i2 = width + 1;
                while (i2 <= itemInfo.f3864b && i4 < this.f3904f.size()) {
                    itemInfo3 = (ItemInfo) this.f3904f.get(i4);
                    while (i2 > itemInfo3.f3864b && i4 < this.f3904f.size() - 1) {
                        i4++;
                        itemInfo3 = (ItemInfo) this.f3904f.get(i4);
                    }
                    i5 = i2;
                    f3 = f2;
                    i6 = i5;
                    while (i6 < itemInfo3.f3864b) {
                        c = (this.f3907i.m3800c(i6) + f) + f3;
                        i6++;
                        f3 = c;
                    }
                    itemInfo3.f3867e = f3;
                    f3 += itemInfo3.f3866d + f;
                    width = i6 + 1;
                    f2 = f3;
                    i2 = width;
                }
            } else if (width > itemInfo.f3864b) {
                i4 = this.f3904f.size() - 1;
                f2 = itemInfo2.f3867e;
                i2 = width - 1;
                while (i2 >= itemInfo.f3864b && i4 >= 0) {
                    itemInfo3 = (ItemInfo) this.f3904f.get(i4);
                    while (i2 < itemInfo3.f3864b && i4 > 0) {
                        i4--;
                        itemInfo3 = (ItemInfo) this.f3904f.get(i4);
                    }
                    i5 = i2;
                    f3 = f2;
                    i6 = i5;
                    while (i6 > itemInfo3.f3864b) {
                        c = f3 - (this.f3907i.m3800c(i6) + f);
                        i6--;
                        f3 = c;
                    }
                    f3 -= itemInfo3.f3866d + f;
                    itemInfo3.f3867e = f3;
                    width = i6 - 1;
                    f2 = f3;
                    i2 = width;
                }
            }
        }
        int size = this.f3904f.size();
        f2 = itemInfo.f3867e;
        i2 = itemInfo.f3864b - 1;
        this.f3917s = itemInfo.f3864b == 0 ? itemInfo.f3867e : -3.4028235E38f;
        this.f3918t = itemInfo.f3864b == a + -1 ? (itemInfo.f3867e + itemInfo.f3866d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            itemInfo3 = (ItemInfo) this.f3904f.get(i3);
            float f4 = f2;
            while (i2 > itemInfo3.f3864b) {
                f4 -= this.f3907i.m3800c(i2) + f;
                i2--;
            }
            f2 = f4 - (itemInfo3.f3866d + f);
            itemInfo3.f3867e = f2;
            if (itemInfo3.f3864b == 0) {
                this.f3917s = f2;
            }
            i2--;
        }
        f2 = (itemInfo.f3867e + itemInfo.f3866d) + f;
        i2 = itemInfo.f3864b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            itemInfo3 = (ItemInfo) this.f3904f.get(i3);
            f4 = f2;
            while (i2 < itemInfo3.f3864b) {
                f4 = (this.f3907i.m3800c(i2) + f) + f4;
                i2++;
            }
            if (itemInfo3.f3864b == a - 1) {
                this.f3918t = (itemInfo3.f3866d + f4) - 1.0f;
            }
            itemInfo3.f3867e = f4;
            f2 = f4 + (itemInfo3.f3866d + f);
            i2++;
        }
        this.f3899U = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3874a = this.f3908j;
        if (this.f3907i != null) {
            savedState.f3875b = this.f3907i.m3794b();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f3907i != null) {
                this.f3907i.m3787a(savedState.f3875b, null);
                m5649a(savedState.f3874a, false, true);
                return;
            }
            this.f3909k = savedState.f3874a;
            this.f3910l = savedState.f3875b;
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
        layoutParams3.f3869a |= view instanceof Decor;
        if (!this.f3921w) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3.f3869a) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        } else {
            layoutParams3.f3872d = true;
            addViewInLayout(view, i, layoutParams2);
        }
    }

    ItemInfo m5643a(View view) {
        Iterator it = this.f3904f.iterator();
        while (it.hasNext()) {
            ItemInfo itemInfo = (ItemInfo) it.next();
            if (this.f3907i.m3793a(view, itemInfo.f3863a)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo m5654b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m5643a(view);
            }
            if (!(parent instanceof View)) {
                return null;
            }
            view = parent;
        }
    }

    ItemInfo m5653b(int i) {
        Iterator it = this.f3904f.iterator();
        while (it.hasNext()) {
            ItemInfo itemInfo = (ItemInfo) it.next();
            if (itemInfo.f3864b == i) {
                return itemInfo;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3898T = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f3882D = Math.min(measuredWidth / 10, this.f3881C);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.f3869a) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(layoutParams.f3870b, getLayoutDirection()) & 7;
                    int i6 = layoutParams.f3870b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i6 == 48 || i6 == 80) ? 1 : null;
                    Object obj2 = (absoluteGravity == 3 || absoluteGravity == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i6 = 1073741824;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i6 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i5 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i6), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i6), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f3919u = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f3920v = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f3921w = true;
        m5656c();
        this.f3921w = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.f3869a) {
                    absoluteGravity = MeasureSpec.makeMeasureSpec((int) (layoutParams.f3871c * ((float) paddingLeft)), 1073741824);
                    ItemInfo a = m5643a(childAt2);
                    if (a == null || !a.f3868f) {
                        measuredWidth = measuredHeight;
                    } else {
                        measuredWidth = measuredHeight - ((int) (((float) getSplitActionBarHeight()) * (1.0f - this.f3885G)));
                    }
                    childAt2.measure(absoluteGravity, MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824));
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m5630a(i, i3, this.f3913o, this.f3913o);
        }
    }

    private void m5630a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f3904f.isEmpty()) {
            ItemInfo b = m5653b(this.f3908j);
            int min = (int) ((b != null ? Math.min(b.f3867e, this.f3918t) : 0.0f) * ((float) i));
            if (min != getScrollX()) {
                m5638h();
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int scrollX = (int) (((float) (i + i3)) * (((float) getScrollX()) / ((float) (i2 + i4))));
        scrollTo(scrollX, getScrollY());
        if (!this.f3911m.isFinished()) {
            this.f3911m.startScroll(scrollX, 0, (int) (m5653b(this.f3908j).f3867e * ((float) i)), 0, this.f3911m.getDuration() - this.f3911m.timePassed());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        this.f3921w = true;
        m5656c();
        this.f3921w = false;
        int childCount = getChildCount();
        int i6 = i3 - i;
        int i7 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i8 = 0;
        int i9 = 0;
        while (i9 < childCount) {
            LayoutParams layoutParams;
            int max;
            int measuredWidth;
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3869a) {
                    i5 = layoutParams.f3870b & 112;
                    switch (Gravity.getAbsoluteGravity(layoutParams.f3870b, getLayoutDirection()) & 7) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            max = Math.max((i6 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                            measuredWidth = (i6 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i5) {
                        case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                            measuredWidth = Math.max((i7 - childAt.getMeasuredHeight()) / 2, paddingTop);
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
                            measuredWidth = (i7 - paddingBottom) - childAt.getMeasuredHeight();
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
                    measuredWidth = i8 + 1;
                    i8 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i9++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i8;
                    i8 = measuredWidth;
                }
            }
            measuredWidth = i8;
            i8 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i9++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i8;
            i8 = measuredWidth;
        }
        for (max = 0; max < childCount; max++) {
            View childAt2 = getChildAt(max);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.f3869a) {
                    ItemInfo a = m5643a(childAt2);
                    if (a != null) {
                        int i11 = ((int) (((float) i6) * a.f3867e)) + paddingLeft;
                        if (this.f3886H || layoutParams.f3872d) {
                            layoutParams.f3872d = false;
                            i5 = MeasureSpec.makeMeasureSpec((int) (layoutParams.f3871c * ((float) ((i6 - paddingLeft) - paddingRight))), 1073741824);
                            this.f3886H = false;
                            measuredWidth = 0;
                            if (a.f3868f) {
                                measuredWidth = getSplitActionBarHeight();
                            }
                            childAt2.measure(i5, MeasureSpec.makeMeasureSpec((int) (((float) ((i7 - paddingTop) - paddingBottom)) - (((float) measuredWidth) * (1.0f - this.f3885G))), 1073741824));
                        }
                        childAt2.layout(i11, paddingTop, childAt2.getMeasuredWidth() + i11, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f3915q = paddingTop;
        this.f3916r = i7 - paddingBottom;
        this.f3901W = i8;
        this.f3898T = false;
    }

    public void computeScroll() {
        if (this.f3911m.isFinished() || !this.f3911m.computeScrollOffset()) {
            m5638h();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f3911m.getCurrX();
        int currY = this.f3911m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m5635b(currX, false)) {
                this.f3911m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    private boolean m5635b(int i, boolean z) {
        if (this.f3904f.size() == 0) {
            this.f3900V = false;
            m5646a(0, 0.0f, 0);
            if (this.f3900V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo i2 = m5639i();
        int width = getWidth();
        int i3 = width + this.f3913o;
        float f = ((float) this.f3913o) / ((float) width);
        int i4 = i2.f3864b;
        f = ((((float) i) / ((float) width)) - i2.f3867e) / (i2.f3866d + f);
        i3 = (int) (((float) i3) * f);
        if (z) {
            int i5;
            if (this.f3903b < f && f > 0.55f) {
                i5 = i4 + 1;
                width = 1;
            } else if (this.f3903b <= f || f >= 0.45f) {
                i5 = i4;
                width = 0;
            } else {
                i5 = i4;
                width = 1;
            }
            this.f3903b = f;
            if (width != 0) {
                if (i5 < 0) {
                    i5 = 0;
                } else if (i5 >= this.f3907i.m3782a()) {
                    i5 = this.f3907i.m3782a() - 1;
                }
                if (i5 != this.f3908j) {
                    m5645a(i5);
                    if (this.aa != null) {
                        this.aa.m3683a(i5);
                    }
                    if (this.ab != null) {
                        this.ab.m3683a(i5);
                    }
                }
            }
        }
        this.f3900V = false;
        m5646a(i4, f, i3);
        if (this.f3900V) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    protected void m5646a(int i, float f, int i2) {
        if (this.f3901W > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3869a) {
                    int max;
                    switch (Gravity.getAbsoluteGravity(layoutParams.f3870b, getLayoutDirection()) & 7) {
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
        if (this.aa != null) {
            this.aa.m3684a(i, f, i2);
        }
        if (this.ab != null) {
            this.ab.m3684a(i, f, i2);
        }
        this.f3900V = true;
    }

    private void m5638h() {
        boolean z = this.ad == 2;
        if (z) {
            setScrollingCacheEnabled(false);
            this.f3911m.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f3911m.getCurrX();
            int currY = this.f3911m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            setScrollState(0);
        }
        this.f3923y = false;
        Iterator it = this.f3904f.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            ItemInfo itemInfo = (ItemInfo) it.next();
            if (itemInfo.f3865c) {
                itemInfo.f3865c = false;
                z = true;
            } else {
                z = z2;
            }
            z2 = z;
        }
        if (z2) {
            m5656c();
        }
    }

    private boolean m5633a(float f, float f2) {
        return (f < ((float) this.f3882D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f3882D)) && f2 < 0.0f);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f3902a) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f3879A = false;
            this.f3880B = false;
            this.f3889K = -1;
            if (this.f3890L == null) {
                return false;
            }
            this.f3890L.recycle();
            this.f3890L = null;
            return false;
        }
        if (action != 0) {
            if (this.f3879A) {
                return true;
            }
            if (this.f3880B) {
                return false;
            }
        }
        switch (action) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                float x = motionEvent.getX();
                this.f3884F = x;
                this.f3887I = x;
                this.f3888J = motionEvent.getY();
                this.f3889K = motionEvent.getPointerId(0);
                this.f3880B = false;
                this.f3911m.computeScrollOffset();
                if (this.ad == 2 && Math.abs(this.f3911m.getFinalX() - this.f3911m.getCurrX()) > this.f3894P) {
                    this.f3911m.abortAnimation();
                    this.f3923y = false;
                    m5656c();
                    this.f3879A = true;
                    setScrollState(1);
                    break;
                }
                m5638h();
                this.f3879A = false;
                break;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                action = this.f3889K;
                if (action != -1) {
                    action = motionEvent.findPointerIndex(action);
                    if (action >= 0) {
                        float x2 = motionEvent.getX(action);
                        float f = x2 - this.f3887I;
                        float abs = Math.abs(f);
                        float y = motionEvent.getY(action);
                        float abs2 = Math.abs(y - this.f3888J);
                        if (f == 0.0f || m5633a(this.f3887I, f) || !m5652a(this, false, (int) f, (int) x2, (int) y)) {
                            if (abs > ((float) this.f3883E) && abs > abs2) {
                                this.f3879A = true;
                                setScrollState(1);
                                this.f3887I = f > 0.0f ? this.f3884F + ((float) this.f3883E) : this.f3884F - ((float) this.f3883E);
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > ((float) this.f3883E)) {
                                this.f3880B = true;
                            }
                            if (this.f3879A && m5634b(x2)) {
                                postInvalidateOnAnimation();
                                break;
                            }
                        }
                        this.f3887I = x2;
                        this.f3884F = x2;
                        this.f3888J = y;
                        this.f3880B = true;
                        return false;
                    }
                }
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m5631a(motionEvent);
                break;
        }
        if (this.f3890L == null) {
            this.f3890L = VelocityTracker.obtain();
        }
        this.f3890L.addMovement(motionEvent);
        return this.f3879A;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f3895Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f3907i == null || this.f3907i.m3782a() == 0) {
            return false;
        }
        if (this.f3890L == null) {
            this.f3890L = VelocityTracker.obtain();
        }
        this.f3890L.addMovement(motionEvent);
        float x;
        int xVelocity;
        switch (motionEvent.getAction() & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f3911m.abortAnimation();
                this.f3923y = false;
                m5656c();
                this.f3879A = true;
                setScrollState(1);
                x = motionEvent.getX();
                this.f3884F = x;
                this.f3887I = x;
                this.f3889K = motionEvent.getPointerId(0);
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (this.f3879A) {
                    VelocityTracker velocityTracker = this.f3890L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f3892N);
                    xVelocity = (int) velocityTracker.getXVelocity(this.f3889K);
                    this.f3923y = true;
                    int width = getWidth();
                    int scrollX = getScrollX();
                    ItemInfo i = m5639i();
                    m5650a(m5628a(i.f3864b, ((((float) scrollX) / ((float) width)) - i.f3867e) / i.f3866d, xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f3889K)) - this.f3884F)), true, true, xVelocity);
                    this.f3889K = -1;
                    m5640j();
                    this.f3896R.onRelease();
                    this.f3897S.onRelease();
                    z = this.f3897S.isFinished() | this.f3896R.isFinished();
                    break;
                }
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (!this.f3879A) {
                    xVelocity = motionEvent.findPointerIndex(this.f3889K);
                    float x2 = motionEvent.getX(xVelocity);
                    float abs = Math.abs(x2 - this.f3887I);
                    x = Math.abs(motionEvent.getY(xVelocity) - this.f3888J);
                    if (abs > ((float) this.f3883E) && abs > x) {
                        this.f3879A = true;
                        if (x2 - this.f3884F > 0.0f) {
                            x = this.f3884F + ((float) this.f3883E);
                        } else {
                            x = this.f3884F - ((float) this.f3883E);
                        }
                        this.f3887I = x;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.f3879A) {
                    z = m5634b(motionEvent.getX(motionEvent.findPointerIndex(this.f3889K)));
                    break;
                }
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (this.f3879A) {
                    m5649a(this.f3908j, true, true);
                    this.f3889K = -1;
                    m5640j();
                    this.f3896R.onRelease();
                    this.f3897S.onRelease();
                    z = this.f3897S.isFinished() | this.f3896R.isFinished();
                    break;
                }
                break;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                xVelocity = motionEvent.getActionIndex();
                this.f3887I = motionEvent.getX(xVelocity);
                this.f3889K = motionEvent.getPointerId(xVelocity);
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                m5631a(motionEvent);
                this.f3887I = motionEvent.getX(motionEvent.findPointerIndex(this.f3889K));
                break;
        }
        if (z) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    private boolean m5634b(float f) {
        boolean z;
        float f2;
        boolean z2;
        boolean z3 = false;
        float f3 = this.f3887I - f;
        this.f3887I = f;
        float scrollX = ((float) getScrollX()) + f3;
        int width = getWidth();
        float f4 = ((float) width) * this.f3917s;
        float f5 = ((float) width) * this.f3918t;
        ItemInfo itemInfo = (ItemInfo) this.f3904f.get(0);
        ItemInfo itemInfo2 = (ItemInfo) this.f3904f.get(this.f3904f.size() - 1);
        if (itemInfo.f3864b != 0) {
            f4 = itemInfo.f3867e * ((float) width);
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f3864b != this.f3907i.m3782a() - 1) {
            f2 = itemInfo2.f3867e * ((float) width);
            z2 = false;
        } else {
            f2 = f5;
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.f3896R.onPull(Math.abs(f4 - scrollX) / ((float) width));
                z3 = true;
            }
        } else if (scrollX > f2) {
            if (z2) {
                this.f3897S.onPull(Math.abs(scrollX - f2) / ((float) width));
                z3 = true;
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f3887I += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m5635b((int) f4, true);
        return z3;
    }

    private ItemInfo m5639i() {
        float f;
        int width = getWidth();
        float scrollX = width > 0 ? ((float) getScrollX()) / ((float) width) : 0.0f;
        if (width > 0) {
            f = ((float) this.f3913o) / ((float) width);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        ItemInfo itemInfo = null;
        while (i2 < this.f3904f.size()) {
            int i3;
            ItemInfo itemInfo2;
            ItemInfo itemInfo3 = (ItemInfo) this.f3904f.get(i2);
            ItemInfo itemInfo4;
            if (obj != null || itemInfo3.f3864b == i + 1) {
                itemInfo4 = itemInfo3;
                i3 = i2;
                itemInfo2 = itemInfo4;
            } else {
                itemInfo3 = this.f3905g;
                itemInfo3.f3867e = (f2 + f3) + f;
                itemInfo3.f3864b = i + 1;
                itemInfo3.f3866d = this.f3907i.m3800c(itemInfo3.f3864b);
                itemInfo4 = itemInfo3;
                i3 = i2 - 1;
                itemInfo2 = itemInfo4;
            }
            f2 = itemInfo2.f3867e;
            f3 = (itemInfo2.f3866d + f2) + f;
            if (obj == null && scrollX < f2) {
                return itemInfo;
            }
            if (scrollX < f3 || i3 == this.f3904f.size() - 1) {
                return itemInfo2;
            }
            f3 = f2;
            i = itemInfo2.f3864b;
            obj = null;
            f2 = itemInfo2.f3866d;
            itemInfo = itemInfo2;
            i2 = i3 + 1;
        }
        return itemInfo;
    }

    private int m5628a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f3893O || Math.abs(i2) <= this.f3891M) {
            i = (int) ((((float) i) + f) + 0.5f);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f3904f.size() <= 0) {
            return i;
        }
        return Math.max(((ItemInfo) this.f3904f.get(0)).f3864b, Math.min(i, ((ItemInfo) this.f3904f.get(this.f3904f.size() - 1)).f3864b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f3907i != null && this.f3907i.m3782a() > 1)) {
            int width;
            if (!this.f3896R.isFinished()) {
                overScrollMode = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.f3917s * ((float) width));
                this.f3896R.setSize(i, width);
                i = this.f3896R.draw(canvas);
                canvas.restoreToCount(overScrollMode);
            }
            if (!this.f3897S.isFinished()) {
                overScrollMode = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f3918t + 1.0f)) * ((float) width));
                this.f3897S.setSize(height, width);
                i |= this.f3897S.draw(canvas);
                canvas.restoreToCount(overScrollMode);
            }
        } else {
            this.f3896R.finish();
            this.f3897S.finish();
        }
        if (i != 0) {
            postInvalidateOnAnimation();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3913o > 0 && this.f3914p != null && this.f3904f.size() > 0 && this.f3907i != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f3913o) / ((float) width);
            ItemInfo itemInfo = (ItemInfo) this.f3904f.get(0);
            float f2 = itemInfo.f3867e;
            int size = this.f3904f.size();
            int i = itemInfo.f3864b;
            int i2 = ((ItemInfo) this.f3904f.get(size - 1)).f3864b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > itemInfo.f3864b && i3 < size) {
                    i3++;
                    itemInfo = (ItemInfo) this.f3904f.get(i3);
                }
                if (i4 == itemInfo.f3864b) {
                    f3 = (itemInfo.f3867e + itemInfo.f3866d) * ((float) width);
                    f2 = (itemInfo.f3867e + itemInfo.f3866d) + f;
                } else {
                    float c = this.f3907i.m3800c(i4);
                    f3 = (f2 + c) * ((float) width);
                    f2 += c + f;
                }
                if (((float) this.f3913o) + f3 > ((float) scrollX)) {
                    this.f3914p.setBounds((int) f3, this.f3915q, (int) ((((float) this.f3913o) + f3) + 0.5f), this.f3916r);
                    this.f3914p.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void m5631a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3889K) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.f3887I = motionEvent.getX(actionIndex);
            this.f3889K = motionEvent.getPointerId(actionIndex);
            if (this.f3890L != null) {
                this.f3890L.clear();
            }
        }
    }

    private void m5640j() {
        this.f3879A = false;
        this.f3880B = false;
        if (this.f3890L != null) {
            this.f3890L.recycle();
            this.f3890L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f3922x != z) {
            this.f3922x = z;
        }
    }

    protected boolean m5652a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m5652a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && view.canScrollHorizontally(-i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m5651a(keyEvent);
    }

    public boolean m5651a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case C0264R.styleable.Window_immersionButtonCloseBackground /*21*/:
                return m5657c(17);
            case C0264R.styleable.Window_immersionWindowBackground /*22*/:
                return m5657c(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (keyEvent.hasNoModifiers()) {
                    return m5657c(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return m5657c(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean m5657c(int i) {
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null || findNextFocus == findFocus) {
            if (i == 17 || i == 1) {
                d = m5658d();
            } else {
                if (i == 66 || i == 2) {
                    d = m5659e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (findFocus == null || m5629a(this.f3906h, findNextFocus).left < m5629a(this.f3906h, findFocus).left) ? findNextFocus.requestFocus() : m5658d();
        } else {
            if (i == 66) {
                d = (findFocus == null || m5629a(this.f3906h, findNextFocus).left > m5629a(this.f3906h, findFocus).left) ? findNextFocus.requestFocus() : m5659e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    private Rect m5629a(Rect rect, View view) {
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

    boolean m5658d() {
        if (this.f3908j <= 0) {
            return false;
        }
        m5648a(this.f3908j - 1, true);
        return true;
    }

    boolean m5659e() {
        if (this.f3907i == null || this.f3908j >= this.f3907i.m3782a() - 1) {
            return false;
        }
        m5648a(this.f3908j + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    ItemInfo a = m5643a(childAt);
                    if (a != null && a.f3864b == this.f3908j) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && (arrayList == null || size != arrayList.size())) || !isFocusable()) {
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
                ItemInfo a = m5643a(childAt);
                if (a != null && a.f3864b == this.f3908j) {
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
                ItemInfo a = m5643a(childAt);
                if (a != null && a.f3864b == this.f3908j && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo a = m5643a(childAt);
                if (a != null && a.f3864b == this.f3908j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z = true;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ViewPager.class.getName());
        if (this.f3907i == null || this.f3907i.m3782a() <= 1) {
            z = false;
        }
        accessibilityNodeInfo.setScrollable(z);
        if (this.f3907i != null && this.f3908j >= 0 && this.f3908j < this.f3907i.m3782a() - 1) {
            accessibilityNodeInfo.addAction(4096);
        }
        if (this.f3907i != null && this.f3908j > 0 && this.f3908j < this.f3907i.m3782a()) {
            accessibilityNodeInfo.addAction(8192);
        }
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        switch (i) {
            case 4096:
                if (this.f3907i == null || this.f3908j < 0 || this.f3908j >= this.f3907i.m3782a() - 1) {
                    return false;
                }
                setCurrentItem(this.f3908j + 1);
                return true;
            case 8192:
                if (this.f3907i == null || this.f3908j <= 0 || this.f3908j >= this.f3907i.m3782a()) {
                    return false;
                }
                setCurrentItem(this.f3908j - 1);
                return true;
            default:
                return false;
        }
    }

    public void setDraggable(boolean z) {
        this.f3902a = z;
    }

    int getSplitActionBarHeight() {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) ActionBarUtils.m5257a(this);
        if (actionBarOverlayLayout == null || actionBarOverlayLayout.getActionBarView() == null) {
            return 0;
        }
        return actionBarOverlayLayout.getActionBarView().m4747a(true);
    }

    public void setBottomMarginProgress(float f) {
        this.f3885G = f;
        this.f3886H = true;
        requestLayout();
        invalidate();
    }
}
