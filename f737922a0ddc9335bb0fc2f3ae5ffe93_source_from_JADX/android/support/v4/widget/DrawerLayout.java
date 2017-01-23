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
import android.support.v4.view.aj;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.List;
import v;
import v$a;

public class DrawerLayout extends ViewGroup implements c {
    private static final int[] DW;
    private static final boolean FH;
    private static final boolean Hw;
    static final c j6;
    private CharSequence BT;
    private final j EQ;
    private final g J0;
    private final g J8;
    private Drawable KD;
    private boolean Mr;
    private Object P8;
    private boolean QX;
    private Drawable SI;
    private boolean U2;
    private int VH;
    private int Ws;
    private boolean XL;
    private float Zo;
    private f a8;
    private int aM;
    private final ArrayList<View> cn;
    private boolean ei;
    private Drawable er;
    private Drawable gW;
    private int gn;
    private int j3;
    private float lg;
    private Drawable nw;
    private float rN;
    private Drawable ro;
    private Paint tp;
    private float u7;
    private final b v5;
    private CharSequence vy;
    private final j we;
    private Drawable yS;

    public interface f {
        void DW(View view);

        void j6(int i);

        void j6(View view);

        void j6(View view, float f);
    }

    public static class LayoutParams extends MarginLayoutParams {
        float DW;
        boolean FH;
        boolean Hw;
        public int j6;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.j6 = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.DW);
            this.j6 = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.j6 = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.j6 = 0;
            this.j6 = layoutParams.j6;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.j6 = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.j6 = 0;
        }
    }

    protected static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int DW;
        int FH;
        int j6;

        static class 1 implements Creator<SavedState> {
            1() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return j6(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return j6(i);
            }

            public SavedState j6(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] j6(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.j6 = 0;
            this.DW = 0;
            this.FH = 0;
            this.j6 = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.j6 = 0;
            this.DW = 0;
            this.FH = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.j6);
        }

        static {
            CREATOR = new 1();
        }
    }

    class a extends android.support.v4.view.a {
        final /* synthetic */ DrawerLayout DW;
        private final Rect FH;

        a(DrawerLayout drawerLayout) {
            this.DW = drawerLayout;
            this.FH = new Rect();
        }

        public void j6(View view, v vVar) {
            if (DrawerLayout.FH) {
                super.j6(view, vVar);
            } else {
                v j6 = v.j6(vVar);
                super.j6(view, j6);
                vVar.j6(view);
                ViewParent Zo = z.Zo(view);
                if (Zo instanceof View) {
                    vVar.FH((View) Zo);
                }
                j6(vVar, j6);
                j6.Mr();
                j6(vVar, (ViewGroup) view);
            }
            vVar.DW(DrawerLayout.class.getName());
            vVar.j6(false);
            vVar.DW(false);
            vVar.j6(v$a.j6);
            vVar.j6(v$a.DW);
        }

        public void Hw(View view, AccessibilityEvent accessibilityEvent) {
            super.Hw(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public boolean DW(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.DW(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View j6 = this.DW.EQ();
            if (j6 != null) {
                CharSequence j62 = this.DW.j6(this.DW.v5(j6));
                if (j62 != null) {
                    text.add(j62);
                }
            }
            return true;
        }

        public boolean j6(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.FH || DrawerLayout.J8(view)) {
                return super.j6(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        private void j6(v vVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.J8(childAt)) {
                    vVar.DW(childAt);
                }
            }
        }

        private void j6(v vVar, v vVar2) {
            Rect rect = this.FH;
            vVar2.j6(rect);
            vVar.DW(rect);
            vVar2.FH(rect);
            vVar.Hw(rect);
            vVar.FH(vVar2.gn());
            vVar.j6(vVar2.QX());
            vVar.DW(vVar2.XL());
            vVar.FH(vVar2.j3());
            vVar.gn(vVar2.J0());
            vVar.Zo(vVar2.EQ());
            vVar.j6(vVar2.Zo());
            vVar.DW(vVar2.VH());
            vVar.Hw(vVar2.u7());
            vVar.v5(vVar2.tp());
            vVar.VH(vVar2.we());
            vVar.j6(vVar2.DW());
        }
    }

    final class b extends android.support.v4.view.a {
        final /* synthetic */ DrawerLayout DW;

        b(DrawerLayout drawerLayout) {
            this.DW = drawerLayout;
        }

        public void j6(View view, v vVar) {
            super.j6(view, vVar);
            if (!DrawerLayout.J8(view)) {
                vVar.FH(null);
            }
        }
    }

    interface c {
        int j6(Object obj);

        Drawable j6(Context context);

        void j6(View view);

        void j6(View view, Object obj, int i);

        void j6(MarginLayoutParams marginLayoutParams, Object obj, int i);
    }

    static class d implements c {
        d() {
        }

        public void j6(View view) {
            b.j6(view);
        }

        public void j6(View view, Object obj, int i) {
            b.j6(view, obj, i);
        }

        public void j6(MarginLayoutParams marginLayoutParams, Object obj, int i) {
            b.j6(marginLayoutParams, obj, i);
        }

        public int j6(Object obj) {
            return b.j6(obj);
        }

        public Drawable j6(Context context) {
            return b.j6(context);
        }
    }

    static class e implements c {
        e() {
        }

        public void j6(View view) {
        }

        public void j6(View view, Object obj, int i) {
        }

        public void j6(MarginLayoutParams marginLayoutParams, Object obj, int i) {
        }

        public int j6(Object obj) {
            return 0;
        }

        public Drawable j6(Context context) {
            return null;
        }
    }

    private class g extends android.support.v4.widget.j.a {
        private final int DW;
        private j FH;
        private final Runnable Hw;
        final /* synthetic */ DrawerLayout j6;

        class 1 implements Runnable {
            final /* synthetic */ g j6;

            1(g gVar) {
                this.j6 = gVar;
            }

            public void run() {
                this.j6.FH();
            }
        }

        public g(DrawerLayout drawerLayout, int i) {
            this.j6 = drawerLayout;
            this.Hw = new 1(this);
            this.DW = i;
        }

        public void j6(j jVar) {
            this.FH = jVar;
        }

        public void j6() {
            this.j6.removeCallbacks(this.Hw);
        }

        public boolean j6(View view, int i) {
            return this.j6.VH(view) && this.j6.j6(view, this.DW) && this.j6.j6(view) == 0;
        }

        public void j6(int i) {
            this.j6.j6(this.DW, i, this.FH.FH());
        }

        public void j6(View view, int i, int i2, int i3, int i4) {
            float f;
            int width = view.getWidth();
            if (this.j6.j6(view, 3)) {
                f = ((float) (width + i)) / ((float) width);
            } else {
                f = ((float) (this.j6.getWidth() - i)) / ((float) width);
            }
            this.j6.DW(view, f);
            view.setVisibility(f == 0.0f ? 4 : 0);
            this.j6.invalidate();
        }

        public void DW(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).FH = false;
            DW();
        }

        private void DW() {
            int i = 3;
            if (this.DW == 3) {
                i = 5;
            }
            View DW = this.j6.DW(i);
            if (DW != null) {
                this.j6.u7(DW);
            }
        }

        public void j6(View view, float f, float f2) {
            int i;
            float Hw = this.j6.Hw(view);
            int width = view.getWidth();
            if (this.j6.j6(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && Hw > 0.5f)) ? 0 : -width;
            } else {
                i = this.j6.getWidth();
                if (f < 0.0f || (f == 0.0f && Hw > 0.5f)) {
                    i -= width;
                }
            }
            this.FH.j6(i, view.getTop());
            this.j6.invalidate();
        }

        public void j6(int i, int i2) {
            this.j6.postDelayed(this.Hw, 160);
        }

        private void FH() {
            View view;
            int i;
            int i2 = 0;
            int DW = this.FH.DW();
            boolean z = this.DW == 3;
            if (z) {
                View DW2 = this.j6.DW(3);
                if (DW2 != null) {
                    i2 = -DW2.getWidth();
                }
                i2 += DW;
                view = DW2;
                i = i2;
            } else {
                i2 = this.j6.getWidth() - DW;
                view = this.j6.DW(5);
                i = i2;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.j6.j6(view) == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                this.FH.j6(view, i, view.getTop());
                layoutParams.FH = true;
                this.j6.invalidate();
                DW();
                this.j6.FH();
            }
        }

        public boolean DW(int i) {
            return false;
        }

        public void DW(int i, int i2) {
            View DW;
            if ((i & 1) == 1) {
                DW = this.j6.DW(3);
            } else {
                DW = this.j6.DW(5);
            }
            if (DW != null && this.j6.j6(DW) == 0) {
                this.FH.j6(DW, i2);
            }
        }

        public int j6(View view) {
            return this.j6.VH(view) ? view.getWidth() : 0;
        }

        public int j6(View view, int i, int i2) {
            if (this.j6.j6(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = this.j6.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public int DW(View view, int i, int i2) {
            return view.getTop();
        }
    }

    static {
        boolean z = true;
        DW = new int[]{16842931};
        FH = VERSION.SDK_INT >= 19;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        Hw = z;
        if (VERSION.SDK_INT >= 21) {
            j6 = new d();
        } else {
            j6 = new e();
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
        this.v5 = new b(this);
        this.gn = -1728053248;
        this.tp = new Paint();
        this.XL = true;
        this.nw = null;
        this.SI = null;
        this.KD = null;
        this.ro = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.VH = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.J0 = new g(this, 3);
        this.J8 = new g(this, 5);
        this.EQ = j.j6((ViewGroup) this, 1.0f, this.J0);
        this.EQ.j6(1);
        this.EQ.j6(f2);
        this.J0.j6(this.EQ);
        this.we = j.j6((ViewGroup) this, 1.0f, this.J8);
        this.we.j6(2);
        this.we.j6(f2);
        this.J8.j6(this.we);
        setFocusableInTouchMode(true);
        z.FH((View) this, 1);
        z.j6((View) this, new a(this));
        aj.j6(this, false);
        if (z.tp(this)) {
            j6.j6((View) this);
            this.er = j6.j6(context);
        }
        this.Zo = f * 10.0f;
        this.cn = new ArrayList();
    }

    public void setDrawerElevation(float f) {
        this.Zo = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (VH(childAt)) {
                z.FH(childAt, this.Zo);
            }
        }
    }

    public float getDrawerElevation() {
        if (Hw) {
            return this.Zo;
        }
        return 0.0f;
    }

    public void j6(Object obj, boolean z) {
        this.P8 = obj;
        this.ei = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setScrimColor(int i) {
        this.gn = i;
        invalidate();
    }

    public void setDrawerListener(f fVar) {
        this.a8 = fVar;
    }

    public void setDrawerLockMode(int i) {
        j6(i, 3);
        j6(i, 5);
    }

    public void j6(int i, int i2) {
        int j6 = android.support.v4.view.d.j6(i2, z.v5(this));
        if (j6 == 3) {
            this.aM = i;
        } else if (j6 == 5) {
            this.j3 = i;
        }
        if (i != 0) {
            (j6 == 3 ? this.EQ : this.we).v5();
        }
        View DW;
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                DW = DW(j6);
                if (DW != null) {
                    u7(DW);
                }
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                DW = DW(j6);
                if (DW != null) {
                    gn(DW);
                }
            default:
        }
    }

    public int j6(View view) {
        int v5 = v5(view);
        if (v5 == 3) {
            return this.aM;
        }
        if (v5 == 5) {
            return this.j3;
        }
        return 0;
    }

    public CharSequence j6(int i) {
        int j6 = android.support.v4.view.d.j6(i, z.v5(this));
        if (j6 == 3) {
            return this.BT;
        }
        if (j6 == 5) {
            return this.vy;
        }
        return null;
    }

    void j6(int i, int i2, View view) {
        int i3 = 1;
        int j6 = this.EQ.j6();
        int j62 = this.we.j6();
        if (!(j6 == 1 || j62 == 1)) {
            i3 = (j6 == 2 || j62 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.DW == 0.0f) {
                DW(view);
            } else if (layoutParams.DW == 1.0f) {
                FH(view);
            }
        }
        if (i3 != this.Ws) {
            this.Ws = i3;
            if (this.a8 != null) {
                this.a8.j6(i3);
            }
        }
    }

    void DW(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.Hw) {
            layoutParams.Hw = false;
            if (this.a8 != null) {
                this.a8.DW(view);
            }
            j6(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void FH(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.Hw) {
            layoutParams.Hw = true;
            if (this.a8 != null) {
                this.a8.j6(view);
            }
            j6(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
            view.requestFocus();
        }
    }

    private void j6(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || VH(childAt)) && !(z && childAt == view)) {
                z.FH(childAt, 4);
            } else {
                z.FH(childAt, 1);
            }
        }
    }

    void j6(View view, float f) {
        if (this.a8 != null) {
            this.a8.j6(view, f);
        }
    }

    void DW(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.DW) {
            layoutParams.DW = f;
            j6(view, f);
        }
    }

    float Hw(View view) {
        return ((LayoutParams) view.getLayoutParams()).DW;
    }

    int v5(View view) {
        return android.support.v4.view.d.j6(((LayoutParams) view.getLayoutParams()).j6, z.v5(this));
    }

    boolean j6(View view, int i) {
        return (v5(view) & i) == i;
    }

    View j6() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (((LayoutParams) childAt.getLayoutParams()).Hw) {
                return childAt;
            }
        }
        return null;
    }

    View DW(int i) {
        int j6 = android.support.v4.view.d.j6(i, z.v5(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((v5(childAt) & 7) == j6) {
                return childAt;
            }
        }
        return null;
    }

    static String FH(int i) {
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
        this.XL = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.XL = true;
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
        r0 = r13.P8;
        if (r0 == 0) goto L_0x0061;
    L_0x002d:
        r0 = android.support.v4.view.z.tp(r13);
        if (r0 == 0) goto L_0x0061;
    L_0x0033:
        r0 = 1;
        r3 = r0;
    L_0x0035:
        r6 = android.support.v4.view.z.v5(r13);
        r7 = r13.getChildCount();
        r5 = r4;
    L_0x003e:
        if (r5 >= r7) goto L_0x0155;
    L_0x0040:
        r8 = r13.getChildAt(r5);
        r0 = r8.getVisibility();
        r9 = 8;
        if (r0 != r9) goto L_0x0063;
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
    L_0x0061:
        r3 = r4;
        goto L_0x0035;
    L_0x0063:
        r0 = r8.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        if (r3 == 0) goto L_0x007e;
    L_0x006b:
        r9 = r0.j6;
        r9 = android.support.v4.view.d.j6(r9, r6);
        r10 = android.support.v4.view.z.tp(r8);
        if (r10 == 0) goto L_0x009f;
    L_0x0077:
        r10 = j6;
        r11 = r13.P8;
        r10.j6(r8, r11, r9);
    L_0x007e:
        r9 = r13.Zo(r8);
        if (r9 == 0) goto L_0x00a7;
    L_0x0084:
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
    L_0x009f:
        r10 = j6;
        r11 = r13.P8;
        r10.j6(r0, r11, r9);
        goto L_0x007e;
    L_0x00a7:
        r9 = r13.VH(r8);
        if (r9 == 0) goto L_0x0122;
    L_0x00ad:
        r9 = Hw;
        if (r9 == 0) goto L_0x00c0;
    L_0x00b1:
        r9 = android.support.v4.view.z.u7(r8);
        r10 = r13.Zo;
        r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1));
        if (r9 == 0) goto L_0x00c0;
    L_0x00bb:
        r9 = r13.Zo;
        android.support.v4.view.z.FH(r8, r9);
    L_0x00c0:
        r9 = r13.v5(r8);
        r9 = r9 & 7;
        r10 = r4 & r9;
        if (r10 == 0) goto L_0x0104;
    L_0x00ca:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Child drawer has absolute gravity ";
        r1 = r1.append(r2);
        r2 = FH(r9);
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
    L_0x0104:
        r9 = r13.VH;
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
    L_0x0122:
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
    L_0x0155:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    private void Zo() {
        if (!Hw) {
            this.yS = VH();
            this.gW = gn();
        }
    }

    private Drawable VH() {
        int v5 = z.v5(this);
        if (v5 == 0) {
            if (this.nw != null) {
                j6(this.nw, v5);
                return this.nw;
            }
        } else if (this.SI != null) {
            j6(this.SI, v5);
            return this.SI;
        }
        return this.KD;
    }

    private Drawable gn() {
        int v5 = z.v5(this);
        if (v5 == 0) {
            if (this.SI != null) {
                j6(this.SI, v5);
                return this.SI;
            }
        } else if (this.nw != null) {
            j6(this.nw, v5);
            return this.nw;
        }
        return this.ro;
    }

    private boolean j6(Drawable drawable, int i) {
        if (drawable == null || !a.j6(drawable)) {
            return false;
        }
        a.j6(drawable, i);
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.QX = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (Zo(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (j6(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.DW)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.DW));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.DW ? 1 : null;
                    int i8;
                    switch (layoutParams.j6 & 112) {
                        case 16:
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
                        DW(childAt, f);
                    }
                    int i10 = layoutParams.DW > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.QX = false;
        this.XL = false;
    }

    public void requestLayout() {
        if (!this.QX) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).DW);
        }
        this.u7 = f;
        if ((this.EQ.j6(true) | this.we.j6(true)) != 0) {
            z.DW(this);
        }
    }

    private static boolean J0(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.er = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.er;
    }

    public void setStatusBarBackground(int i) {
        this.er = i != 0 ? android.support.v4.content.c.j6(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.er = new ColorDrawable(i);
        invalidate();
    }

    public void onRtlPropertiesChanged(int i) {
        Zo();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ei && this.er != null) {
            int j6 = j6.j6(this.P8);
            if (j6 > 0) {
                this.er.setBounds(0, 0, getWidth(), j6);
                this.er.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean Zo = Zo(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (Zo) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && J0(childAt) && VH(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (j6(childAt, 3)) {
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
        if (this.u7 > 0.0f && Zo) {
            this.tp.setColor((((int) (((float) ((this.gn & -16777216) >>> 24)) * this.u7)) << 24) | (this.gn & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.tp);
        } else if (this.yS != null && j6(view, 3)) {
            i = this.yS.getIntrinsicWidth();
            i2 = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i2) / ((float) this.EQ.DW()), 1.0f));
            this.yS.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.yS.setAlpha((int) (255.0f * r2));
            this.yS.draw(canvas);
        } else if (this.gW != null && j6(view, 5)) {
            i = this.gW.getIntrinsicWidth();
            i2 = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.we.DW()), 1.0f));
            this.gW.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.gW.setAlpha((int) (255.0f * r2));
            this.gW.draw(canvas);
        }
        return drawChild;
    }

    boolean Zo(View view) {
        return ((LayoutParams) view.getLayoutParams()).j6 == 0;
    }

    boolean VH(View view) {
        return (android.support.v4.view.d.j6(((LayoutParams) view.getLayoutParams()).j6, z.v5(view)) & 7) != 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.view.n.j6(r8);
        r3 = r7.EQ;
        r3 = r3.j6(r8);
        r4 = r7.we;
        r4 = r4.j6(r8);
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
        r0 = r7.u7();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.U2;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.lg = r0;
        r7.rN = r4;
        r5 = r7.u7;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.EQ;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.Hw(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.Zo(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.Mr = r2;
        r7.U2 = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.EQ;
        r4 = 3;
        r0 = r0.Hw(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.J0;
        r0.j6();
        r0 = r7.J8;
        r0.j6();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.j6(r1);
        r7.Mr = r2;
        r7.U2 = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.EQ.DW(motionEvent);
        this.we.DW(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.lg = x;
                this.rN = y;
                this.Mr = false;
                this.U2 = false;
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View Hw = this.EQ.Hw((int) x, (int) y);
                if (Hw != null && Zo(Hw)) {
                    x -= this.lg;
                    y -= this.rN;
                    int Hw2 = this.EQ.Hw();
                    if ((x * x) + (y * y) < ((float) (Hw2 * Hw2))) {
                        View j6 = j6();
                        if (j6 != null) {
                            z = j6(j6) == 2;
                            j6(z);
                            this.Mr = false;
                            break;
                        }
                    }
                }
                z = true;
                j6(z);
                this.Mr = false;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                j6(true);
                this.Mr = false;
                this.U2 = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.Mr = z;
        if (z) {
            j6(true);
        }
    }

    public void DW() {
        j6(false);
    }

    void j6(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (VH(childAt) && (!z || layoutParams.FH)) {
                int width = childAt.getWidth();
                if (j6(childAt, 3)) {
                    i |= this.EQ.j6(childAt, -width, childAt.getTop());
                } else {
                    i |= this.we.j6(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.FH = false;
            }
        }
        this.J0.j6();
        this.J8.j6();
        if (i != 0) {
            invalidate();
        }
    }

    public void gn(View view) {
        if (VH(view)) {
            if (this.XL) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.DW = 1.0f;
                layoutParams.Hw = true;
                j6(view, true);
            } else if (j6(view, 3)) {
                this.EQ.j6(view, 0, view.getTop());
            } else {
                this.we.j6(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void Hw(int i) {
        View DW = DW(i);
        if (DW == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + FH(i));
        }
        gn(DW);
    }

    public void u7(View view) {
        if (VH(view)) {
            if (this.XL) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.DW = 0.0f;
                layoutParams.Hw = false;
            } else if (j6(view, 3)) {
                this.EQ.j6(view, -view.getWidth(), view.getTop());
            } else {
                this.we.j6(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void v5(int i) {
        View DW = DW(i);
        if (DW == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + FH(i));
        }
        u7(DW);
    }

    public boolean tp(View view) {
        if (VH(view)) {
            return ((LayoutParams) view.getLayoutParams()).Hw;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean Zo(int i) {
        View DW = DW(i);
        if (DW != null) {
            return tp(DW);
        }
        return false;
    }

    public boolean EQ(View view) {
        if (VH(view)) {
            return ((LayoutParams) view.getLayoutParams()).DW > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    public boolean VH(int i) {
        View DW = DW(i);
        if (DW != null) {
            return EQ(DW);
        }
        return false;
    }

    private boolean u7() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).FH) {
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
                if (!VH(childAt)) {
                    this.cn.add(childAt);
                } else if (tp(childAt)) {
                    i5 = 1;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (i5 == 0) {
                i4 = this.cn.size();
                while (i3 < i4) {
                    View view = (View) this.cn.get(i3);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                    i3++;
                }
            }
            this.cn.clear();
        }
    }

    private boolean tp() {
        return EQ() != null;
    }

    private View EQ() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (VH(childAt) && EQ(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    void FH() {
        int i = 0;
        if (!this.U2) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i++;
            }
            obtain.recycle();
            this.U2 = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !tp()) {
            return super.onKeyDown(i, keyEvent);
        }
        android.support.v4.view.f.DW(keyEvent);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View EQ = EQ();
        if (EQ != null && j6(EQ) == 0) {
            DW();
        }
        return EQ != null;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.j6 != 0) {
            View DW = DW(savedState.j6);
            if (DW != null) {
                gn(DW);
            }
        }
        j6(savedState.DW, 3);
        j6(savedState.FH, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        View j6 = j6();
        if (j6 != null) {
            savedState.j6 = ((LayoutParams) j6.getLayoutParams()).j6;
        }
        savedState.DW = this.aM;
        savedState.FH = this.j3;
        return savedState;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (j6() != null || VH(view)) {
            z.FH(view, 4);
        } else {
            z.FH(view, 1);
        }
        if (!FH) {
            z.j6(view, this.v5);
        }
    }

    private static boolean J8(View view) {
        return (z.FH(view) == 4 || z.FH(view) == 2) ? false : true;
    }
}
