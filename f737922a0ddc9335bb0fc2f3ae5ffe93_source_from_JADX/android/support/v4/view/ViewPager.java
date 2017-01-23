package android.support.v4.view;

import ad;
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
import com.aide.uidesigner.ProxyTextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import v;

public class ViewPager extends ViewGroup {
    private static final Comparator<b> FH;
    private static final Interpolator Hw;
    private static final int[] j6;
    private static final i yO;
    private boolean BT;
    private int DW;
    private Parcelable EQ;
    private boolean I;
    private Scroller J0;
    private g J8;
    private float KD;
    private float Mr;
    private boolean Mz;
    private f OW;
    private int P8;
    private Drawable QX;
    private List<e> Qq;
    private float SI;
    private boolean Sf;
    private int U2;
    private final Rect VH;
    private int Ws;
    private final Runnable XG;
    private int XL;
    private int XX;
    private final b Zo;
    private int a8;
    private int aM;
    private e aj;
    private Method br;
    private boolean ca;
    private int cb;
    private int cn;
    private int dx;
    private int ef;
    private int ei;
    private boolean er;
    private EdgeEffectCompat g3;
    private boolean gW;
    private v gn;
    private float j3;
    private int jJ;
    private ArrayList<View> kQ;
    private boolean lg;
    private d lp;
    private float nw;
    private boolean rN;
    private float ro;
    private int sG;
    private VelocityTracker sh;
    private e sy;
    private int tp;
    private int u7;
    private final ArrayList<b> v5;
    private EdgeEffectCompat vJ;
    private int vy;
    private ClassLoader we;
    private int x9;
    private int yS;

    interface a {
    }

    interface d {
        void j6(v vVar, v vVar2);
    }

    public interface e {
        void DW(int i);

        void j6(int i);

        void j6(int i, float f, int i2);
    }

    static class 1 implements Comparator<b> {
        1() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((b) obj, (b) obj2);
        }

        public int j6(b bVar, b bVar2) {
            return bVar.DW - bVar2.DW;
        }
    }

    static class 2 implements Interpolator {
        2() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ ViewPager j6;

        3(ViewPager viewPager) {
            this.j6 = viewPager;
        }

        public void run() {
            this.j6.setScrollState(0);
            this.j6.FH();
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public int DW;
        float FH;
        boolean Hw;
        int Zo;
        public boolean j6;
        int v5;

        public LayoutParams() {
            super(-1, -1);
            this.FH = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.FH = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.j6);
            this.DW = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        Parcelable DW;
        ClassLoader FH;
        int j6;

        static class 1 implements i<SavedState> {
            1() {
            }

            public /* synthetic */ Object j6(Parcel parcel, ClassLoader classLoader) {
                return DW(parcel, classLoader);
            }

            public /* synthetic */ Object[] j6(int i) {
                return DW(i);
            }

            public SavedState DW(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] DW(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.j6);
            parcel.writeParcelable(this.DW, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.j6 + "}";
        }

        static {
            CREATOR = h.j6(new 1());
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.j6 = parcel.readInt();
            this.DW = parcel.readParcelable(classLoader);
            this.FH = classLoader;
        }
    }

    static class b {
        int DW;
        boolean FH;
        float Hw;
        Object j6;
        float v5;

        b() {
        }
    }

    class c extends a {
        final /* synthetic */ ViewPager DW;

        c(ViewPager viewPager) {
            this.DW = viewPager;
        }

        public void Hw(View view, AccessibilityEvent accessibilityEvent) {
            super.Hw(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            ad j6 = ad.j6();
            j6.j6(DW());
            if (accessibilityEvent.getEventType() == 4096 && this.DW.gn != null) {
                j6.j6(this.DW.gn.DW());
                j6.DW(this.DW.u7);
                j6.FH(this.DW.u7);
            }
        }

        public void j6(View view, v vVar) {
            super.j6(view, vVar);
            vVar.DW(ViewPager.class.getName());
            vVar.u7(DW());
            if (this.DW.canScrollHorizontally(1)) {
                vVar.j6(4096);
            }
            if (this.DW.canScrollHorizontally(-1)) {
                vVar.j6(8192);
            }
        }

        public boolean j6(View view, int i, Bundle bundle) {
            if (super.j6(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.DW.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.DW.setCurrentItem(this.DW.u7 + 1);
                    return true;
                case 8192:
                    if (!this.DW.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.DW.setCurrentItem(this.DW.u7 - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean DW() {
            return this.DW.gn != null && this.DW.gn.DW() > 1;
        }
    }

    public interface f {
        void j6(View view, float f);
    }

    private class g extends DataSetObserver {
        final /* synthetic */ ViewPager j6;

        private g(ViewPager viewPager) {
            this.j6 = viewPager;
        }

        public void onChanged() {
            this.j6.DW();
        }

        public void onInvalidated() {
            this.j6.DW();
        }
    }

    public static class h implements e {
        public void j6(int i, float f, int i2) {
        }

        public void j6(int i) {
        }

        public void DW(int i) {
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((View) obj, (View) obj2);
        }

        public int j6(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.j6 != layoutParams2.j6) {
                return layoutParams.j6 ? 1 : -1;
            } else {
                return layoutParams.v5 - layoutParams2.v5;
            }
        }
    }

    static {
        j6 = new int[]{16842931};
        FH = new 1();
        Hw = new 2();
        yO = new i();
    }

    public ViewPager(Context context) {
        super(context);
        this.v5 = new ArrayList();
        this.Zo = new b();
        this.VH = new Rect();
        this.tp = -1;
        this.EQ = null;
        this.we = null;
        this.j3 = -3.4028235E38f;
        this.Mr = Float.MAX_VALUE;
        this.yS = 1;
        this.cn = -1;
        this.Mz = true;
        this.I = false;
        this.XG = new 3(this);
        this.jJ = 0;
        j6();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v5 = new ArrayList();
        this.Zo = new b();
        this.VH = new Rect();
        this.tp = -1;
        this.EQ = null;
        this.we = null;
        this.j3 = -3.4028235E38f;
        this.Mr = Float.MAX_VALUE;
        this.yS = 1;
        this.cn = -1;
        this.Mz = true;
        this.I = false;
        this.XG = new 3(this);
        this.jJ = 0;
        j6();
    }

    void j6() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.J0 = new Scroller(context, Hw);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.ei = ah.j6(viewConfiguration);
        this.cb = (int) (400.0f * f);
        this.dx = viewConfiguration.getScaledMaximumFlingVelocity();
        this.vJ = new EdgeEffectCompat(context);
        this.g3 = new EdgeEffectCompat(context);
        this.sG = (int) (25.0f * f);
        this.ef = (int) (2.0f * f);
        this.vy = (int) (16.0f * f);
        z.j6((View) this, new c(this));
        if (z.FH(this) == 0) {
            z.FH((View) this, 1);
        }
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.XG);
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        if (this.jJ != i) {
            this.jJ = i;
            if (this.OW != null) {
                DW(i != 0);
            }
            Zo(i);
        }
    }

    public void setAdapter(v vVar) {
        if (this.gn != null) {
            this.gn.DW(this.J8);
            this.gn.j6((ViewGroup) this);
            for (int i = 0; i < this.v5.size(); i++) {
                b bVar = (b) this.v5.get(i);
                this.gn.j6((ViewGroup) this, bVar.DW, bVar.j6);
            }
            this.gn.DW((ViewGroup) this);
            this.v5.clear();
            VH();
            this.u7 = 0;
            scrollTo(0, 0);
        }
        v vVar2 = this.gn;
        this.gn = vVar;
        this.DW = 0;
        if (this.gn != null) {
            if (this.J8 == null) {
                this.J8 = new g();
            }
            this.gn.j6(this.J8);
            this.er = false;
            boolean z = this.Mz;
            this.Mz = true;
            this.DW = this.gn.DW();
            if (this.tp >= 0) {
                this.gn.j6(this.EQ, this.we);
                j6(this.tp, false, true);
                this.tp = -1;
                this.EQ = null;
                this.we = null;
            } else if (z) {
                requestLayout();
            } else {
                FH();
            }
        }
        if (this.lp != null && vVar2 != vVar) {
            this.lp.j6(vVar2, vVar);
        }
    }

    private void VH() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).j6) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public v getAdapter() {
        return this.gn;
    }

    void setOnAdapterChangeListener(d dVar) {
        this.lp = dVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.er = false;
        if (this.Mz) {
            z = false;
        } else {
            z = true;
        }
        j6(i, z, false);
    }

    public void j6(int i, boolean z) {
        this.er = false;
        j6(i, z, false);
    }

    public int getCurrentItem() {
        return this.u7;
    }

    void j6(int i, boolean z, boolean z2) {
        j6(i, z, z2, 0);
    }

    void j6(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.gn == null || this.gn.DW() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.u7 != i || this.v5.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.gn.DW()) {
                i = this.gn.DW() - 1;
            }
            int i3 = this.yS;
            if (i > this.u7 + i3 || i < this.u7 - i3) {
                for (int i4 = 0; i4 < this.v5.size(); i4++) {
                    ((b) this.v5.get(i4)).FH = true;
                }
            }
            if (this.u7 != i) {
                z3 = true;
            }
            if (this.Mz) {
                this.u7 = i;
                if (z3) {
                    v5(i);
                }
                requestLayout();
                return;
            }
            j6(i);
            j6(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void j6(int i, boolean z, int i2, boolean z2) {
        int max;
        b DW = DW(i);
        if (DW != null) {
            max = (int) (Math.max(this.j3, Math.min(DW.v5, this.Mr)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            j6(max, 0, i2);
            if (z2) {
                v5(i);
                return;
            }
            return;
        }
        if (z2) {
            v5(i);
        }
        j6(false);
        scrollTo(max, 0);
        Hw(max);
    }

    @Deprecated
    public void setOnPageChangeListener(e eVar) {
        this.sy = eVar;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.br == null) {
                try {
                    this.br = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.br.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.XX == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.kQ.get(i2)).getLayoutParams()).Zo;
    }

    e j6(e eVar) {
        e eVar2 = this.aj;
        this.aj = eVar;
        return eVar2;
    }

    public int getOffscreenPageLimit() {
        return this.yS;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.yS) {
            this.yS = i;
            FH();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.Ws;
        this.Ws = i;
        int width = getWidth();
        j6(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.Ws;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.QX = drawable;
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
        return super.verifyDrawable(drawable) || drawable == this.QX;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.QX;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float j6(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void j6(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            j6(false);
            FH();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float j6 = (((float) i6) * j6(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(j6 / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.gn.FH(this.u7)) + ((float) this.Ws))) + 1.0f) * 100.0f);
        }
        this.J0.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        z.DW(this);
    }

    b j6(int i, int i2) {
        b bVar = new b();
        bVar.DW = i;
        bVar.j6 = this.gn.j6((ViewGroup) this, i);
        bVar.Hw = this.gn.FH(i);
        if (i2 < 0 || i2 >= this.v5.size()) {
            this.v5.add(bVar);
        } else {
            this.v5.add(i2, bVar);
        }
        return bVar;
    }

    void DW() {
        int i;
        int DW = this.gn.DW();
        this.DW = DW;
        boolean z = this.v5.size() < (this.yS * 2) + 1 && this.v5.size() < DW;
        boolean z2 = false;
        int i2 = this.u7;
        boolean z3 = z;
        int i3 = 0;
        while (i3 < this.v5.size()) {
            int i4;
            boolean z4;
            boolean z5;
            b bVar = (b) this.v5.get(i3);
            int j6 = this.gn.j6(bVar.j6);
            if (j6 == -1) {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            } else if (j6 == -2) {
                this.v5.remove(i3);
                i3--;
                if (!z2) {
                    this.gn.j6((ViewGroup) this);
                    z2 = true;
                }
                this.gn.j6((ViewGroup) this, bVar.DW, bVar.j6);
                if (this.u7 == bVar.DW) {
                    i4 = i3;
                    z4 = z2;
                    i = Math.max(0, Math.min(this.u7, DW - 1));
                    z5 = true;
                } else {
                    i4 = i3;
                    z4 = z2;
                    i = i2;
                    z5 = true;
                }
            } else if (bVar.DW != j6) {
                if (bVar.DW == this.u7) {
                    i2 = j6;
                }
                bVar.DW = j6;
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = true;
            } else {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            }
            z3 = z5;
            i2 = i;
            z2 = z4;
            i3 = i4 + 1;
        }
        if (z2) {
            this.gn.DW((ViewGroup) this);
        }
        Collections.sort(this.v5, FH);
        if (z3) {
            i = getChildCount();
            for (i3 = 0; i3 < i; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.j6) {
                    layoutParams.FH = 0.0f;
                }
            }
            j6(i2, false, true);
            requestLayout();
        }
    }

    void FH() {
        j6(this.u7);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void j6(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.u7;
        r0 = r19;
        if (r4 == r0) goto L_0x0344;
    L_0x000a:
        r0 = r18;
        r2 = r0.u7;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.u7;
        r0 = r18;
        r3 = r0.DW(r3);
        r0 = r19;
        r1 = r18;
        r1.u7 = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.gn;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.gn();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.er;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.gn();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.gn;
        r0 = r18;
        r2.j6(r0);
        r0 = r18;
        r2 = r0.yS;
        r5 = 0;
        r0 = r18;
        r6 = r0.u7;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.gn;
        r12 = r5.DW();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.u7;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.DW;
        if (r12 == r2) goto L_0x00df;
    L_0x0073:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00d5 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00d5 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00d5 }
    L_0x007f:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r18;
        r5 = r0.DW;
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
        r4 = r0.gn;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00d5:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007f;
    L_0x00df:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00e2:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x0341;
    L_0x00ec:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        r7 = r2.DW;
        r0 = r18;
        r8 = r0.u7;
        if (r7 < r8) goto L_0x01d4;
    L_0x00fe:
        r7 = r2.DW;
        r0 = r18;
        r8 = r0.u7;
        if (r7 != r8) goto L_0x0341;
    L_0x0106:
        if (r2 != 0) goto L_0x033e;
    L_0x0108:
        if (r12 <= 0) goto L_0x033e;
    L_0x010a:
        r0 = r18;
        r2 = r0.u7;
        r0 = r18;
        r2 = r0.j6(r2, r5);
        r10 = r2;
    L_0x0115:
        if (r10 == 0) goto L_0x0185;
    L_0x0117:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d9;
    L_0x011c:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0126:
        r14 = r18.getClientWidth();
        if (r14 > 0) goto L_0x01dc;
    L_0x012c:
        r6 = 0;
    L_0x012d:
        r0 = r18;
        r7 = r0.u7;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x013d:
        if (r9 < 0) goto L_0x0147;
    L_0x013f:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x021b;
    L_0x0143:
        if (r9 >= r11) goto L_0x021b;
    L_0x0145:
        if (r2 != 0) goto L_0x01eb;
    L_0x0147:
        r6 = r10.Hw;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0180;
    L_0x0151:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x0251;
    L_0x015b:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.get(r9);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        r7 = r2;
    L_0x0166:
        if (r14 > 0) goto L_0x0254;
    L_0x0168:
        r2 = 0;
        r5 = r2;
    L_0x016a:
        r0 = r18;
        r2 = r0.u7;
        r2 = r2 + 1;
        r16 = r2;
        r2 = r7;
        r7 = r9;
        r9 = r16;
    L_0x0176:
        if (r9 >= r12) goto L_0x0180;
    L_0x0178:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x029f;
    L_0x017c:
        if (r9 <= r13) goto L_0x029f;
    L_0x017e:
        if (r2 != 0) goto L_0x0261;
    L_0x0180:
        r0 = r18;
        r0.j6(r10, r8, r4);
    L_0x0185:
        r0 = r18;
        r4 = r0.gn;
        r0 = r18;
        r5 = r0.u7;
        if (r10 == 0) goto L_0x02ed;
    L_0x018f:
        r2 = r10.j6;
    L_0x0191:
        r0 = r18;
        r4.DW(r0, r5, r2);
        r0 = r18;
        r2 = r0.gn;
        r0 = r18;
        r2.DW(r0);
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x01a5:
        if (r4 >= r5) goto L_0x02f0;
    L_0x01a7:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.Zo = r4;
        r7 = r2.j6;
        if (r7 != 0) goto L_0x01d0;
    L_0x01b9:
        r7 = r2.FH;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01d0;
    L_0x01c0:
        r0 = r18;
        r6 = r0.j6(r6);
        if (r6 == 0) goto L_0x01d0;
    L_0x01c8:
        r7 = r6.Hw;
        r2.FH = r7;
        r6 = r6.DW;
        r2.v5 = r6;
    L_0x01d0:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x01a5;
    L_0x01d4:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00e2;
    L_0x01d9:
        r2 = 0;
        goto L_0x0126;
    L_0x01dc:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.Hw;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x012d;
    L_0x01eb:
        r15 = r2.DW;
        if (r9 != r15) goto L_0x0215;
    L_0x01ef:
        r15 = r2.FH;
        if (r15 != 0) goto L_0x0215;
    L_0x01f3:
        r0 = r18;
        r15 = r0.v5;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.gn;
        r2 = r2.j6;
        r0 = r18;
        r15.j6(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0219;
    L_0x020b:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0215:
        r9 = r9 + -1;
        goto L_0x013d;
    L_0x0219:
        r2 = 0;
        goto L_0x0215;
    L_0x021b:
        if (r2 == 0) goto L_0x0235;
    L_0x021d:
        r15 = r2.DW;
        if (r9 != r15) goto L_0x0235;
    L_0x0221:
        r2 = r2.Hw;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x0233;
    L_0x0228:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        goto L_0x0215;
    L_0x0233:
        r2 = 0;
        goto L_0x0215;
    L_0x0235:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.j6(r9, r2);
        r2 = r2.Hw;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024f;
    L_0x0244:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.get(r5);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        goto L_0x0215;
    L_0x024f:
        r2 = 0;
        goto L_0x0215;
    L_0x0251:
        r7 = 0;
        goto L_0x0166;
    L_0x0254:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x016a;
    L_0x0261:
        r11 = r2.DW;
        if (r9 != r11) goto L_0x0337;
    L_0x0265:
        r11 = r2.FH;
        if (r11 != 0) goto L_0x0337;
    L_0x0269:
        r0 = r18;
        r11 = r0.v5;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.gn;
        r2 = r2.j6;
        r0 = r18;
        r11.j6(r0, r9, r2);
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x029d;
    L_0x0285:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x028f:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x0294:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x0176;
    L_0x029d:
        r2 = 0;
        goto L_0x028f;
    L_0x029f:
        if (r2 == 0) goto L_0x02c6;
    L_0x02a1:
        r11 = r2.DW;
        if (r9 != r11) goto L_0x02c6;
    L_0x02a5:
        r2 = r2.Hw;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02c4;
    L_0x02b4:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x02be:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0294;
    L_0x02c4:
        r2 = 0;
        goto L_0x02be;
    L_0x02c6:
        r0 = r18;
        r2 = r0.j6(r9, r7);
        r7 = r7 + 1;
        r2 = r2.Hw;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02eb;
    L_0x02db:
        r0 = r18;
        r2 = r0.v5;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x02e5:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0294;
    L_0x02eb:
        r2 = 0;
        goto L_0x02e5;
    L_0x02ed:
        r2 = 0;
        goto L_0x0191;
    L_0x02f0:
        r18.gn();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f9:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0335;
    L_0x02ff:
        r0 = r18;
        r2 = r0.DW(r2);
    L_0x0305:
        if (r2 == 0) goto L_0x030f;
    L_0x0307:
        r2 = r2.DW;
        r0 = r18;
        r4 = r0.u7;
        if (r2 == r4) goto L_0x002f;
    L_0x030f:
        r2 = 0;
    L_0x0310:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x0316:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.j6(r4);
        if (r5 == 0) goto L_0x0332;
    L_0x0324:
        r5 = r5.DW;
        r0 = r18;
        r6 = r0.u7;
        if (r5 != r6) goto L_0x0332;
    L_0x032c:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x0332:
        r2 = r2 + 1;
        goto L_0x0310;
    L_0x0335:
        r2 = 0;
        goto L_0x0305;
    L_0x0337:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0294;
    L_0x033e:
        r10 = r2;
        goto L_0x0115;
    L_0x0341:
        r2 = r6;
        goto L_0x0106;
    L_0x0344:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.j6(int):void");
    }

    private void gn() {
        if (this.XX != 0) {
            if (this.kQ == null) {
                this.kQ = new ArrayList();
            } else {
                this.kQ.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.kQ.add(getChildAt(i));
            }
            Collections.sort(this.kQ, yO);
        }
    }

    private void j6(b bVar, int i, b bVar2) {
        float f;
        float f2;
        int i2;
        b bVar3;
        int i3;
        int DW = this.gn.DW();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.Ws) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (bVar2 != null) {
            clientWidth = bVar2.DW;
            int i4;
            if (clientWidth < bVar.DW) {
                f2 = (bVar2.v5 + bVar2.Hw) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= bVar.DW && i2 < this.v5.size()) {
                    bVar3 = (b) this.v5.get(i2);
                    while (i4 > bVar3.DW && i2 < this.v5.size() - 1) {
                        i2++;
                        bVar3 = (b) this.v5.get(i2);
                    }
                    while (i4 < bVar3.DW) {
                        f2 += this.gn.FH(i4) + f;
                        i4++;
                    }
                    bVar3.v5 = f2;
                    f2 += bVar3.Hw + f;
                    i4++;
                }
            } else if (clientWidth > bVar.DW) {
                i2 = this.v5.size() - 1;
                f2 = bVar2.v5;
                i4 = clientWidth - 1;
                while (i4 >= bVar.DW && i2 >= 0) {
                    bVar3 = (b) this.v5.get(i2);
                    while (i4 < bVar3.DW && i2 > 0) {
                        i2--;
                        bVar3 = (b) this.v5.get(i2);
                    }
                    while (i4 > bVar3.DW) {
                        f2 -= this.gn.FH(i4) + f;
                        i4--;
                    }
                    f2 -= bVar3.Hw + f;
                    bVar3.v5 = f2;
                    i4--;
                }
            }
        }
        int size = this.v5.size();
        float f3 = bVar.v5;
        i2 = bVar.DW - 1;
        this.j3 = bVar.DW == 0 ? bVar.v5 : -3.4028235E38f;
        this.Mr = bVar.DW == DW + -1 ? (bVar.v5 + bVar.Hw) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            bVar3 = (b) this.v5.get(i3);
            f2 = f3;
            while (i2 > bVar3.DW) {
                f2 -= this.gn.FH(i2) + f;
                i2--;
            }
            f3 = f2 - (bVar3.Hw + f);
            bVar3.v5 = f3;
            if (bVar3.DW == 0) {
                this.j3 = f3;
            }
            i2--;
        }
        f3 = (bVar.v5 + bVar.Hw) + f;
        i2 = bVar.DW + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            bVar3 = (b) this.v5.get(i3);
            f2 = f3;
            while (i2 < bVar3.DW) {
                f2 = (this.gn.FH(i2) + f) + f2;
                i2++;
            }
            if (bVar3.DW == DW - 1) {
                this.Mr = (bVar3.Hw + f2) - 1.0f;
            }
            bVar3.v5 = f2;
            f3 = f2 + (bVar3.Hw + f);
            i2++;
        }
        this.I = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.j6 = this.u7;
        if (this.gn != null) {
            savedState.DW = this.gn.j6();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.gn != null) {
                this.gn.j6(savedState.DW, savedState.FH);
                j6(savedState.j6, false, true);
                return;
            }
            this.tp = savedState.j6;
            this.EQ = savedState.DW;
            this.we = savedState.FH;
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
        layoutParams3.j6 |= view instanceof a;
        if (!this.lg) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.j6) {
            layoutParams3.Hw = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.lg) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    b j6(View view) {
        for (int i = 0; i < this.v5.size(); i++) {
            b bVar = (b) this.v5.get(i);
            if (this.gn.j6(view, bVar.j6)) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    android.support.v4.view.ViewPager.b DW(android.view.View r3) {
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
        r0 = r2.j6(r3);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.DW(android.view.View):android.support.v4.view.ViewPager$b");
    }

    b DW(int i) {
        for (int i2 = 0; i2 < this.v5.size(); i2++) {
            b bVar = (b) this.v5.get(i2);
            if (bVar.DW == i) {
                return bVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Mz = true;
    }

    protected void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.P8 = Math.min(measuredWidth / 10, this.vy);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.j6) {
                    int i6 = layoutParams.DW & 7;
                    int i7 = layoutParams.DW & 112;
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
        this.U2 = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.a8 = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.lg = true;
        FH();
        this.lg = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.j6) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.FH * ((float) paddingLeft)), 1073741824), this.a8);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            j6(i, i3, this.Ws, this.Ws);
        }
    }

    private void j6(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.v5.isEmpty()) {
            b DW = DW(this.u7);
            int min = (int) ((DW != null ? Math.min(DW.v5, this.Mr) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                j6(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.J0.isFinished()) {
            this.J0.startScroll(paddingLeft, 0, (int) (DW(this.u7).v5 * ((float) i)), 0, this.J0.getDuration() - this.J0.timePassed());
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
                if (layoutParams.j6) {
                    int i9 = layoutParams.DW & 112;
                    switch (layoutParams.DW & 7) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
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
                        case 16:
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
                if (!layoutParams.j6) {
                    b j6 = j6(childAt2);
                    if (j6 != null) {
                        i5 = ((int) (j6.v5 * ((float) max))) + paddingLeft;
                        if (layoutParams.Hw) {
                            layoutParams.Hw = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.FH * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.XL = paddingTop;
        this.aM = i6 - paddingBottom;
        this.x9 = i7;
        if (this.Mz) {
            j6(this.u7, false, 0, false);
        }
        this.Mz = false;
    }

    public void computeScroll() {
        if (this.J0.isFinished() || !this.J0.computeScrollOffset()) {
            j6(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.J0.getCurrX();
        int currY = this.J0.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!Hw(currX)) {
                this.J0.abortAnimation();
                scrollTo(0, currY);
            }
        }
        z.DW(this);
    }

    private boolean Hw(int i) {
        if (this.v5.size() == 0) {
            this.ca = false;
            j6(0, 0.0f, 0);
            if (this.ca) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b u7 = u7();
        int clientWidth = getClientWidth();
        int i2 = this.Ws + clientWidth;
        float f = ((float) this.Ws) / ((float) clientWidth);
        int i3 = u7.DW;
        float f2 = ((((float) i) / ((float) clientWidth)) - u7.v5) / (u7.Hw + f);
        clientWidth = (int) (((float) i2) * f2);
        this.ca = false;
        j6(i3, f2, clientWidth);
        if (this.ca) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    protected void j6(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.x9 > 0) {
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
                if (layoutParams.j6) {
                    int max;
                    switch (layoutParams.DW & 7) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
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
        DW(i, f, i2);
        if (this.OW != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).j6) {
                    this.OW.j6(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.ca = true;
    }

    private void DW(int i, float f, int i2) {
        if (this.sy != null) {
            this.sy.j6(i, f, i2);
        }
        if (this.Qq != null) {
            int size = this.Qq.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = (e) this.Qq.get(i3);
                if (eVar != null) {
                    eVar.j6(i, f, i2);
                }
            }
        }
        if (this.aj != null) {
            this.aj.j6(i, f, i2);
        }
    }

    private void v5(int i) {
        if (this.sy != null) {
            this.sy.j6(i);
        }
        if (this.Qq != null) {
            int size = this.Qq.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) this.Qq.get(i2);
                if (eVar != null) {
                    eVar.j6(i);
                }
            }
        }
        if (this.aj != null) {
            this.aj.j6(i);
        }
    }

    private void Zo(int i) {
        if (this.sy != null) {
            this.sy.DW(i);
        }
        if (this.Qq != null) {
            int size = this.Qq.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) this.Qq.get(i2);
                if (eVar != null) {
                    eVar.DW(i);
                }
            }
        }
        if (this.aj != null) {
            this.aj.DW(i);
        }
    }

    private void j6(boolean z) {
        int scrollX;
        boolean z2 = this.jJ == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.J0.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.J0.getCurrX();
            int currY = this.J0.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    Hw(currX);
                }
            }
        }
        this.er = false;
        boolean z3 = z2;
        for (scrollX = 0; scrollX < this.v5.size(); scrollX++) {
            b bVar = (b) this.v5.get(scrollX);
            if (bVar.FH) {
                bVar.FH = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z) {
            z.j6((View) this, this.XG);
        } else {
            this.XG.run();
        }
    }

    private boolean j6(float f, float f2) {
        return (f < ((float) this.P8) && f2 > 0.0f) || (f > ((float) (getWidth() - this.P8)) && f2 < 0.0f);
    }

    private void DW(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            z.j6(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.gW = false;
            this.BT = false;
            this.cn = -1;
            if (this.sh == null) {
                return false;
            }
            this.sh.recycle();
            this.sh = null;
            return false;
        }
        if (action != 0) {
            if (this.gW) {
                return true;
            }
            if (this.BT) {
                return false;
            }
        }
        switch (action) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                float x = motionEvent.getX();
                this.KD = x;
                this.nw = x;
                x = motionEvent.getY();
                this.ro = x;
                this.SI = x;
                this.cn = n.DW(motionEvent, 0);
                this.BT = false;
                this.J0.computeScrollOffset();
                if (this.jJ == 2 && Math.abs(this.J0.getFinalX() - this.J0.getCurrX()) > this.ef) {
                    this.J0.abortAnimation();
                    this.er = false;
                    FH();
                    this.gW = true;
                    FH(true);
                    setScrollState(1);
                    break;
                }
                j6(false);
                this.gW = false;
                break;
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                action = this.cn;
                if (action != -1) {
                    action = n.j6(motionEvent, action);
                    float FH = n.FH(motionEvent, action);
                    float f = FH - this.nw;
                    float abs = Math.abs(f);
                    float Hw = n.Hw(motionEvent, action);
                    float abs2 = Math.abs(Hw - this.ro);
                    if (f == 0.0f || j6(this.nw, f) || !j6(this, false, (int) f, (int) FH, (int) Hw)) {
                        if (abs > ((float) this.ei) && 0.5f * abs > abs2) {
                            this.gW = true;
                            FH(true);
                            setScrollState(1);
                            this.nw = f > 0.0f ? this.KD + ((float) this.ei) : this.KD - ((float) this.ei);
                            this.SI = Hw;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.ei)) {
                            this.BT = true;
                        }
                        if (this.gW && DW(FH)) {
                            z.DW(this);
                            break;
                        }
                    }
                    this.nw = FH;
                    this.SI = Hw;
                    this.BT = true;
                    return false;
                }
                break;
            case 6:
                j6(motionEvent);
                break;
        }
        if (this.sh == null) {
            this.sh = VelocityTracker.obtain();
        }
        this.sh.addMovement(motionEvent);
        return this.gW;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.Sf) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.gn == null || this.gn.DW() == 0) {
            return false;
        }
        if (this.sh == null) {
            this.sh = VelocityTracker.obtain();
        }
        this.sh.addMovement(motionEvent);
        float x;
        int j6;
        switch (motionEvent.getAction() & 255) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                this.J0.abortAnimation();
                this.er = false;
                FH();
                x = motionEvent.getX();
                this.KD = x;
                this.nw = x;
                x = motionEvent.getY();
                this.ro = x;
                this.SI = x;
                this.cn = n.DW(motionEvent, 0);
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (this.gW) {
                    VelocityTracker velocityTracker = this.sh;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.dx);
                    j6 = (int) x.j6(velocityTracker, this.cn);
                    this.er = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    b u7 = u7();
                    j6(j6(u7.DW, ((((float) scrollX) / ((float) clientWidth)) - u7.v5) / u7.Hw, j6, (int) (n.FH(motionEvent, n.j6(motionEvent, this.cn)) - this.KD)), true, true, j6);
                    this.cn = -1;
                    tp();
                    z = this.g3.FH() | this.vJ.FH();
                    break;
                }
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                if (!this.gW) {
                    j6 = n.j6(motionEvent, this.cn);
                    float FH = n.FH(motionEvent, j6);
                    float abs = Math.abs(FH - this.nw);
                    float Hw = n.Hw(motionEvent, j6);
                    x = Math.abs(Hw - this.SI);
                    if (abs > ((float) this.ei) && abs > x) {
                        this.gW = true;
                        FH(true);
                        if (FH - this.KD > 0.0f) {
                            x = this.KD + ((float) this.ei);
                        } else {
                            x = this.KD - ((float) this.ei);
                        }
                        this.nw = x;
                        this.SI = Hw;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.gW) {
                    z = false | DW(n.FH(motionEvent, n.j6(motionEvent, this.cn)));
                    break;
                }
                break;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                if (this.gW) {
                    j6(this.u7, true, 0, false);
                    this.cn = -1;
                    tp();
                    z = this.g3.FH() | this.vJ.FH();
                    break;
                }
                break;
            case 5:
                j6 = n.DW(motionEvent);
                this.nw = n.FH(motionEvent, j6);
                this.cn = n.DW(motionEvent, j6);
                break;
            case 6:
                j6(motionEvent);
                this.nw = n.FH(motionEvent, n.j6(motionEvent, this.cn));
                break;
        }
        if (z) {
            z.DW(this);
        }
        return true;
    }

    private void FH(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean DW(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.nw - f;
        this.nw = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.j3;
        float f5 = ((float) clientWidth) * this.Mr;
        b bVar = (b) this.v5.get(0);
        b bVar2 = (b) this.v5.get(this.v5.size() - 1);
        if (bVar.DW != 0) {
            f4 = bVar.v5 * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (bVar2.DW != this.gn.DW() - 1) {
            f2 = bVar2.v5 * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.vJ.j6(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.g3.j6(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.nw += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        Hw((int) f4);
        return z3;
    }

    private b u7() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.Ws) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        b bVar = null;
        while (i2 < this.v5.size()) {
            int i3;
            b bVar2;
            b bVar3 = (b) this.v5.get(i2);
            b bVar4;
            if (obj != null || bVar3.DW == i + 1) {
                bVar4 = bVar3;
                i3 = i2;
                bVar2 = bVar4;
            } else {
                bVar3 = this.Zo;
                bVar3.v5 = (f2 + f3) + f;
                bVar3.DW = i + 1;
                bVar3.Hw = this.gn.FH(bVar3.DW);
                bVar4 = bVar3;
                i3 = i2 - 1;
                bVar2 = bVar4;
            }
            f2 = bVar2.v5;
            f3 = (bVar2.Hw + f2) + f;
            if (obj == null && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f3 || i3 == this.v5.size() - 1) {
                return bVar2;
            }
            f3 = f2;
            i = bVar2.DW;
            obj = null;
            f2 = bVar2.Hw;
            bVar = bVar2;
            i2 = i3 + 1;
        }
        return bVar;
    }

    private int j6(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.sG || Math.abs(i2) <= this.cb) {
            i = (int) ((i >= this.u7 ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.v5.size() <= 0) {
            return i;
        }
        return Math.max(((b) this.v5.get(0)).DW, Math.min(i, ((b) this.v5.get(this.v5.size() - 1)).DW));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int j6 = z.j6(this);
        if (j6 == 0 || (j6 == 1 && this.gn != null && this.gn.DW() > 1)) {
            int height;
            int width;
            if (!this.vJ.j6()) {
                j6 = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.j3 * ((float) width));
                this.vJ.j6(height, width);
                i = 0 | this.vJ.j6(canvas);
                canvas.restoreToCount(j6);
            }
            if (!this.g3.j6()) {
                j6 = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.Mr + 1.0f)) * ((float) height));
                this.g3.j6(width, height);
                i |= this.g3.j6(canvas);
                canvas.restoreToCount(j6);
            }
        } else {
            this.vJ.DW();
            this.g3.DW();
        }
        if (i != 0) {
            z.DW(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Ws > 0 && this.QX != null && this.v5.size() > 0 && this.gn != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.Ws) / ((float) width);
            b bVar = (b) this.v5.get(0);
            float f2 = bVar.v5;
            int size = this.v5.size();
            int i = bVar.DW;
            int i2 = ((b) this.v5.get(size - 1)).DW;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bVar.DW && i3 < size) {
                    i3++;
                    bVar = (b) this.v5.get(i3);
                }
                if (i4 == bVar.DW) {
                    f3 = (bVar.v5 + bVar.Hw) * ((float) width);
                    f2 = (bVar.v5 + bVar.Hw) + f;
                } else {
                    float FH = this.gn.FH(i4);
                    f3 = (f2 + FH) * ((float) width);
                    f2 += FH + f;
                }
                if (((float) this.Ws) + f3 > ((float) scrollX)) {
                    this.QX.setBounds((int) f3, this.XL, (int) ((((float) this.Ws) + f3) + 0.5f), this.aM);
                    this.QX.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void j6(MotionEvent motionEvent) {
        int DW = n.DW(motionEvent);
        if (n.DW(motionEvent, DW) == this.cn) {
            DW = DW == 0 ? 1 : 0;
            this.nw = n.FH(motionEvent, DW);
            this.cn = n.DW(motionEvent, DW);
            if (this.sh != null) {
                this.sh.clear();
            }
        }
    }

    private void tp() {
        this.gW = false;
        this.BT = false;
        if (this.sh != null) {
            this.sh.recycle();
            this.sh = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.rN != z) {
            this.rN = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.gn == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.j3))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.Mr))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean j6(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (j6(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && z.j6(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || j6(keyEvent);
    }

    public boolean j6(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return FH(17);
            case 22:
                return FH(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (f.j6(keyEvent)) {
                    return FH(2);
                }
                if (f.j6(keyEvent, 1)) {
                    return FH(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean FH(int i) {
        View view;
        boolean Hw;
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
                Hw = Hw();
            } else {
                if (i == 66 || i == 2) {
                    Hw = v5();
                }
                Hw = false;
            }
        } else if (i == 17) {
            Hw = (view == null || j6(this.VH, findNextFocus).left < j6(this.VH, view).left) ? findNextFocus.requestFocus() : Hw();
        } else {
            if (i == 66) {
                Hw = (view == null || j6(this.VH, findNextFocus).left > j6(this.VH, view).left) ? findNextFocus.requestFocus() : v5();
            }
            Hw = false;
        }
        if (Hw) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return Hw;
    }

    private Rect j6(Rect rect, View view) {
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

    boolean Hw() {
        if (this.u7 <= 0) {
            return false;
        }
        j6(this.u7 - 1, true);
        return true;
    }

    boolean v5() {
        if (this.gn == null || this.u7 >= this.gn.DW() - 1) {
            return false;
        }
        j6(this.u7 + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b j6 = j6(childAt);
                    if (j6 != null && j6.DW == this.u7) {
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
                b j6 = j6(childAt);
                if (j6 != null && j6.DW == this.u7) {
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
                b j6 = j6(childAt);
                if (j6 != null && j6.DW == this.u7 && childAt.requestFocus(i, rect)) {
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
                b j6 = j6(childAt);
                if (j6 != null && j6.DW == this.u7 && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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
