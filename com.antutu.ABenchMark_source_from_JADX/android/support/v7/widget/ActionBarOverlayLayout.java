package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.menu.C0441l.C0342a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import com.antutu.redacc.C1692R;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import org.android.spdy.SpdyProtocol;

public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, ah {
    static final int[] f1325a;
    private final Runnable f1326A;
    private final NestedScrollingParentHelper f1327B;
    private int f1328b;
    private int f1329c;
    private ContentFrameLayout f1330d;
    private ActionBarContainer f1331e;
    private ai f1332f;
    private Drawable f1333g;
    private boolean f1334h;
    private boolean f1335i;
    private boolean f1336j;
    private boolean f1337k;
    private boolean f1338l;
    private int f1339m;
    private int f1340n;
    private final Rect f1341o;
    private final Rect f1342p;
    private final Rect f1343q;
    private final Rect f1344r;
    private final Rect f1345s;
    private final Rect f1346t;
    private C0415a f1347u;
    private final int f1348v;
    private ScrollerCompat f1349w;
    private ViewPropertyAnimatorCompat f1350x;
    private final ViewPropertyAnimatorListener f1351y;
    private final Runnable f1352z;

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.a */
    public interface C0415a {
        void m1175b(int i);

        void m1176g(boolean z);

        void m1177l();

        void m1178m();

        void m1179n();

        void m1180o();
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.1 */
    class C04661 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ ActionBarOverlayLayout f1322a;

        C04661(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1322a = actionBarOverlayLayout;
        }

        public void onAnimationCancel(View view) {
            this.f1322a.f1350x = null;
            this.f1322a.f1338l = false;
        }

        public void onAnimationEnd(View view) {
            this.f1322a.f1350x = null;
            this.f1322a.f1338l = false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.2 */
    class C04672 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1323a;

        C04672(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1323a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1323a.m1536k();
            this.f1323a.f1350x = ViewCompat.animate(this.f1323a.f1331e).translationY(0.0f).setListener(this.f1323a.f1351y);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.3 */
    class C04683 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1324a;

        C04683(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1324a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1324a.m1536k();
            this.f1324a.f1350x = ViewCompat.animate(this.f1324a.f1331e).translationY((float) (-this.f1324a.f1331e.getHeight())).setListener(this.f1324a.f1351y);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout.b */
    public static class C0469b extends MarginLayoutParams {
        public C0469b(int i, int i2) {
            super(i, i2);
        }

        public C0469b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0469b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    static {
        f1325a = new int[]{C0417R.attr.actionBarSize, 16842841};
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1329c = 0;
        this.f1341o = new Rect();
        this.f1342p = new Rect();
        this.f1343q = new Rect();
        this.f1344r = new Rect();
        this.f1345s = new Rect();
        this.f1346t = new Rect();
        this.f1348v = OtherError.CONTAINER_INVISIBLE_ERROR;
        this.f1351y = new C04661(this);
        this.f1352z = new C04672(this);
        this.f1326A = new C04683(this);
        m1529a(context);
        this.f1327B = new NestedScrollingParentHelper(this);
    }

    private ai m1528a(View view) {
        if (view instanceof ai) {
            return (ai) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void m1529a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1325a);
        this.f1328b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1333g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1333g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1334h = z;
        this.f1349w = ScrollerCompat.create(context);
    }

    private boolean m1531a(float f, float f2) {
        this.f1349w.fling(0, 0, 0, (int) f2, 0, 0, LinearLayoutManager.INVALID_OFFSET, Integer.MAX_VALUE);
        return this.f1349w.getFinalY() > this.f1331e.getHeight();
    }

    private boolean m1533a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0469b c0469b = (C0469b) view.getLayoutParams();
        if (z && c0469b.leftMargin != rect.left) {
            c0469b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0469b.topMargin != rect.top) {
            c0469b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0469b.rightMargin != rect.right) {
            c0469b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0469b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0469b.bottomMargin = rect.bottom;
        return true;
    }

    private void m1536k() {
        removeCallbacks(this.f1352z);
        removeCallbacks(this.f1326A);
        if (this.f1350x != null) {
            this.f1350x.cancel();
        }
    }

    private void m1537l() {
        m1536k();
        postDelayed(this.f1352z, 600);
    }

    private void m1538m() {
        m1536k();
        postDelayed(this.f1326A, 600);
    }

    private void m1539n() {
        m1536k();
        this.f1352z.run();
    }

    private void m1540o() {
        m1536k();
        this.f1326A.run();
    }

    public C0469b m1541a(AttributeSet attributeSet) {
        return new C0469b(getContext(), attributeSet);
    }

    public void m1542a(int i) {
        m1546c();
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f1332f.m2251f();
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                this.f1332f.m2252g();
            case C1692R.styleable.AppCompatTheme_seekBarStyle /*109*/:
                setOverlayMode(true);
            default:
        }
    }

    public void m1543a(Menu menu, C0342a c0342a) {
        m1546c();
        this.f1332f.m2239a(menu, c0342a);
    }

    public boolean m1544a() {
        return this.f1335i;
    }

    protected C0469b m1545b() {
        return new C0469b(-1, -1);
    }

    void m1546c() {
        if (this.f1330d == null) {
            this.f1330d = (ContentFrameLayout) findViewById(C0417R.id.action_bar_activity_content);
            this.f1331e = (ActionBarContainer) findViewById(C0417R.id.action_bar_container);
            this.f1332f = m1528a(findViewById(C0417R.id.action_bar));
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0469b;
    }

    public boolean m1547d() {
        m1546c();
        return this.f1332f.m2253h();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1333g != null && !this.f1334h) {
            int bottom = this.f1331e.getVisibility() == 0 ? (int) ((((float) this.f1331e.getBottom()) + ViewCompat.getTranslationY(this.f1331e)) + 0.5f) : 0;
            this.f1333g.setBounds(0, bottom, getWidth(), this.f1333g.getIntrinsicHeight() + bottom);
            this.f1333g.draw(canvas);
        }
    }

    public boolean m1548e() {
        m1546c();
        return this.f1332f.m2254i();
    }

    public boolean m1549f() {
        m1546c();
        return this.f1332f.m2255j();
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        m1546c();
        if ((ViewCompat.getWindowSystemUiVisibility(this) & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) != 0) {
            a = m1533a(this.f1331e, rect, true, true, false, true);
            this.f1344r.set(rect);
            bl.m2590a(this, this.f1344r, this.f1341o);
        } else {
            a = m1533a(this.f1331e, rect, true, true, false, true);
            this.f1344r.set(rect);
            bl.m2590a(this, this.f1344r, this.f1341o);
        }
        if (!this.f1342p.equals(this.f1341o)) {
            this.f1342p.set(this.f1341o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public boolean m1550g() {
        m1546c();
        return this.f1332f.m2256k();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m1545b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m1541a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0469b(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.f1331e != null ? -((int) ViewCompat.getTranslationY(this.f1331e)) : 0;
    }

    public int getNestedScrollAxes() {
        return this.f1327B.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        m1546c();
        return this.f1332f.m2250e();
    }

    public boolean m1551h() {
        m1546c();
        return this.f1332f.m2257l();
    }

    public void m1552i() {
        m1546c();
        this.f1332f.m2258m();
    }

    public void m1553j() {
        m1546c();
        this.f1332f.m2259n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m1529a(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1536k();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0469b c0469b = (C0469b) childAt.getLayoutParams();
                int i6 = c0469b.leftMargin + paddingLeft;
                paddingRight = c0469b.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        m1546c();
        measureChildWithMargins(this.f1331e, i, 0, i2, 0);
        C0469b c0469b = (C0469b) this.f1331e.getLayoutParams();
        int max = Math.max(0, (this.f1331e.getMeasuredWidth() + c0469b.leftMargin) + c0469b.rightMargin);
        int max2 = Math.max(0, c0469b.bottomMargin + (this.f1331e.getMeasuredHeight() + c0469b.topMargin));
        int a = bl.m2589a(0, ViewCompat.getMeasuredState(this.f1331e));
        Object obj = (ViewCompat.getWindowSystemUiVisibility(this) & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) != 0 ? 1 : null;
        if (obj != null) {
            i3 = this.f1328b;
            if (this.f1336j && this.f1331e.getTabContainer() != null) {
                i3 += this.f1328b;
            }
        } else {
            i3 = this.f1331e.getVisibility() != 8 ? this.f1331e.getMeasuredHeight() : 0;
        }
        this.f1343q.set(this.f1341o);
        this.f1345s.set(this.f1344r);
        Rect rect;
        Rect rect2;
        if (this.f1335i || obj != null) {
            rect = this.f1345s;
            rect.top = i3 + rect.top;
            rect2 = this.f1345s;
            rect2.bottom += 0;
        } else {
            rect = this.f1343q;
            rect.top = i3 + rect.top;
            rect2 = this.f1343q;
            rect2.bottom += 0;
        }
        m1533a(this.f1330d, this.f1343q, true, true, true, true);
        if (!this.f1346t.equals(this.f1345s)) {
            this.f1346t.set(this.f1345s);
            this.f1330d.m860a(this.f1345s);
        }
        measureChildWithMargins(this.f1330d, i, 0, i2, 0);
        c0469b = (C0469b) this.f1330d.getLayoutParams();
        int max3 = Math.max(max, (this.f1330d.getMeasuredWidth() + c0469b.leftMargin) + c0469b.rightMargin);
        i3 = Math.max(max2, c0469b.bottomMargin + (this.f1330d.getMeasuredHeight() + c0469b.topMargin));
        int a2 = bl.m2589a(a, ViewCompat.getMeasuredState(this.f1330d));
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ViewCompat.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1337k || !z) {
            return false;
        }
        if (m1531a(f, f2)) {
            m1540o();
        } else {
            m1539n();
        }
        this.f1338l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1339m += i2;
        setActionBarHideOffset(this.f1339m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1327B.onNestedScrollAccepted(view, view2, i);
        this.f1339m = getActionBarHideOffset();
        m1536k();
        if (this.f1347u != null) {
            this.f1347u.m1179n();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.f1331e.getVisibility() != 0) ? false : this.f1337k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f1337k && !this.f1338l) {
            if (this.f1339m <= this.f1331e.getHeight()) {
                m1537l();
            } else {
                m1538m();
            }
        }
        if (this.f1347u != null) {
            this.f1347u.m1180o();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m1546c();
        int i2 = this.f1340n ^ i;
        this.f1340n = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) != 0;
        if (this.f1347u != null) {
            C0415a c0415a = this.f1347u;
            if (z3) {
                z = false;
            }
            c0415a.m1176g(z);
            if (z2 || !z3) {
                this.f1347u.m1177l();
            } else {
                this.f1347u.m1178m();
            }
        }
        if ((i2 & AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) != 0 && this.f1347u != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1329c = i;
        if (this.f1347u != null) {
            this.f1347u.m1175b(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        m1536k();
        ViewCompat.setTranslationY(this.f1331e, (float) (-Math.max(0, Math.min(i, this.f1331e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(C0415a c0415a) {
        this.f1347u = c0415a;
        if (getWindowToken() != null) {
            this.f1347u.m1175b(this.f1329c);
            if (this.f1340n != 0) {
                onWindowSystemUiVisibilityChanged(this.f1340n);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1336j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1337k) {
            this.f1337k = z;
            if (!z) {
                m1536k();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        m1546c();
        this.f1332f.m2235a(i);
    }

    public void setIcon(Drawable drawable) {
        m1546c();
        this.f1332f.m2236a(drawable);
    }

    public void setLogo(int i) {
        m1546c();
        this.f1332f.m2244b(i);
    }

    public void setOverlayMode(boolean z) {
        this.f1335i = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f1334h = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        m1546c();
        this.f1332f.m2240a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m1546c();
        this.f1332f.m2241a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
