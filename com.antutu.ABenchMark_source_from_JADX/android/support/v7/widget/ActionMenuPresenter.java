package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.SubUiVisibilityListener;
import android.support.v4.view.GravityCompat;
import android.support.v7.appcompat.C0417R;
import android.support.v7.p016c.C0419a;
import android.support.v7.view.C0422a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.C0435b;
import android.support.v7.view.menu.C0439m;
import android.support.v7.view.menu.C0439m.C0436a;
import android.support.v7.view.menu.C0441l.C0342a;
import android.support.v7.view.menu.C0442b;
import android.support.v7.view.menu.C0447f;
import android.support.v7.view.menu.C0450h;
import android.support.v7.view.menu.C0459k;
import android.support.v7.view.menu.C0462p;
import android.support.v7.widget.ActionMenuView.C0437a;
import android.support.v7.widget.ap.C0433b;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class ActionMenuPresenter extends C0442b implements SubUiVisibilityListener {
    private C0473b f1367A;
    final C0479f f1368g;
    int f1369h;
    private C0477d f1370i;
    private Drawable f1371j;
    private boolean f1372k;
    private boolean f1373l;
    private boolean f1374m;
    private int f1375n;
    private int f1376o;
    private int f1377p;
    private boolean f1378q;
    private boolean f1379r;
    private boolean f1380s;
    private boolean f1381t;
    private int f1382u;
    private final SparseBooleanArray f1383v;
    private View f1384w;
    private C0478e f1385x;
    private C0472a f1386y;
    private C0474c f1387z;

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        public int f1353a;

        /* renamed from: android.support.v7.widget.ActionMenuPresenter.SavedState.1 */
        static class C04711 implements Creator<SavedState> {
            C04711() {
            }

            public SavedState m1554a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m1555a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1554a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1555a(i);
            }
        }

        static {
            CREATOR = new C04711();
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f1353a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1353a);
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter.a */
    private class C0472a extends C0459k {
        final /* synthetic */ ActionMenuPresenter f1354c;
        private C0462p f1355d;

        public C0472a(ActionMenuPresenter actionMenuPresenter, Context context, C0462p c0462p) {
            boolean z = false;
            this.f1354c = actionMenuPresenter;
            super(context, c0462p, null, false, C0417R.attr.actionOverflowMenuStyle);
            this.f1355d = c0462p;
            if (!((C0450h) c0462p.getItem()).m1455i()) {
                m1478a(actionMenuPresenter.f1370i == null ? (View) actionMenuPresenter.f : actionMenuPresenter.f1370i);
            }
            m1477a(actionMenuPresenter.f1368g);
            int size = c0462p.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = c0462p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            m1482b(z);
        }

        public void onDismiss() {
            super.onDismiss();
            this.f1354c.f1386y = null;
            this.f1354c.f1369h = 0;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter.b */
    private class C0473b extends C0435b {
        final /* synthetic */ ActionMenuPresenter f1356a;

        private C0473b(ActionMenuPresenter actionMenuPresenter) {
            this.f1356a = actionMenuPresenter;
        }

        public ap m1556a() {
            return this.f1356a.f1386y != null ? this.f1356a.f1386y.m1485c() : null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter.c */
    private class C0474c implements Runnable {
        final /* synthetic */ ActionMenuPresenter f1357a;
        private C0478e f1358b;

        public C0474c(ActionMenuPresenter actionMenuPresenter, C0478e c0478e) {
            this.f1357a = actionMenuPresenter;
            this.f1358b = c0478e;
        }

        public void run() {
            this.f1357a.c.m1418f();
            View view = (View) this.f1357a.f;
            if (!(view == null || view.getWindowToken() == null || !this.f1358b.m1486d())) {
                this.f1357a.f1385x = this.f1358b;
            }
            this.f1357a.f1387z = null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter.d */
    private class C0477d extends C0476p implements C0437a {
        final /* synthetic */ ActionMenuPresenter f1363a;
        private final float[] f1364b;

        /* renamed from: android.support.v7.widget.ActionMenuPresenter.d.1 */
        class C04751 extends C0433b {
            final /* synthetic */ ActionMenuPresenter f1359a;
            final /* synthetic */ C0477d f1360b;

            C04751(C0477d c0477d, View view, ActionMenuPresenter actionMenuPresenter) {
                this.f1360b = c0477d;
                this.f1359a = actionMenuPresenter;
                super(view);
            }

            public ap m1557a() {
                return this.f1360b.f1363a.f1385x == null ? null : this.f1360b.f1363a.f1385x.m1485c();
            }

            public boolean m1558b() {
                this.f1360b.f1363a.m1593d();
                return true;
            }

            public boolean m1559c() {
                if (this.f1360b.f1363a.f1387z != null) {
                    return false;
                }
                this.f1360b.f1363a.m1594e();
                return true;
            }
        }

        public C0477d(ActionMenuPresenter actionMenuPresenter, Context context) {
            this.f1363a = actionMenuPresenter;
            super(context, null, C0417R.attr.actionOverflowButtonStyle);
            this.f1364b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new C04751(this, this, actionMenuPresenter));
        }

        public boolean m1560c() {
            return false;
        }

        public boolean m1561d() {
            return false;
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f1363a.m1593d();
            }
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.setHotspotBounds(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter.e */
    private class C0478e extends C0459k {
        final /* synthetic */ ActionMenuPresenter f1365c;

        public C0478e(ActionMenuPresenter actionMenuPresenter, Context context, C0447f c0447f, View view, boolean z) {
            this.f1365c = actionMenuPresenter;
            super(context, c0447f, view, z, C0417R.attr.actionOverflowMenuStyle);
            m1474a((int) GravityCompat.END);
            m1477a(actionMenuPresenter.f1368g);
        }

        public void onDismiss() {
            super.onDismiss();
            if (this.f1365c.c != null) {
                this.f1365c.c.close();
            }
            this.f1365c.f1385x = null;
        }
    }

    /* renamed from: android.support.v7.widget.ActionMenuPresenter.f */
    private class C0479f implements C0342a {
        final /* synthetic */ ActionMenuPresenter f1366a;

        private C0479f(ActionMenuPresenter actionMenuPresenter) {
            this.f1366a = actionMenuPresenter;
        }

        public void m1562a(C0447f c0447f, boolean z) {
            if (c0447f instanceof C0462p) {
                ((C0462p) c0447f).m1499p().m1401a(false);
            }
            C0342a a = this.f1366a.m1343a();
            if (a != null) {
                a.m847a(c0447f, z);
            }
        }

        public boolean m1563a(C0447f c0447f) {
            if (c0447f == null) {
                return false;
            }
            this.f1366a.f1369h = ((C0462p) c0447f).getItem().getItemId();
            C0342a a = this.f1366a.m1343a();
            return a != null ? a.m848a(c0447f) : false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0417R.layout.abc_action_menu_layout, C0417R.layout.abc_action_menu_item_layout);
        this.f1383v = new SparseBooleanArray();
        this.f1368g = new C0479f();
    }

    private View m1568a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0436a) && ((C0436a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public C0439m m1577a(ViewGroup viewGroup) {
        C0439m a = super.m1344a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View m1578a(C0450h c0450h, View view, ViewGroup viewGroup) {
        View actionView = c0450h.getActionView();
        if (actionView == null || c0450h.m1459m()) {
            actionView = super.m1345a(c0450h, view, viewGroup);
        }
        actionView.setVisibility(c0450h.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m1630a(layoutParams));
        }
        return actionView;
    }

    public void m1579a(Context context, C0447f c0447f) {
        super.m1347a(context, c0447f);
        Resources resources = context.getResources();
        C0422a a = C0422a.m1230a(context);
        if (!this.f1374m) {
            this.f1373l = a.m1232b();
        }
        if (!this.f1380s) {
            this.f1375n = a.m1233c();
        }
        if (!this.f1378q) {
            this.f1377p = a.m1231a();
        }
        int i = this.f1375n;
        if (this.f1373l) {
            if (this.f1370i == null) {
                this.f1370i = new C0477d(this, this.a);
                if (this.f1372k) {
                    this.f1370i.setImageDrawable(this.f1371j);
                    this.f1371j = null;
                    this.f1372k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f1370i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1370i.getMeasuredWidth();
        } else {
            this.f1370i = null;
        }
        this.f1376o = i;
        this.f1382u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f1384w = null;
    }

    public void m1580a(Configuration configuration) {
        if (!this.f1378q) {
            this.f1377p = this.b.getResources().getInteger(C0417R.integer.abc_max_action_buttons);
        }
        if (this.c != null) {
            this.c.m1409b(true);
        }
    }

    public void m1581a(Drawable drawable) {
        if (this.f1370i != null) {
            this.f1370i.setImageDrawable(drawable);
            return;
        }
        this.f1372k = true;
        this.f1371j = drawable;
    }

    public void m1582a(C0447f c0447f, boolean z) {
        m1595f();
        super.m1348a(c0447f, z);
    }

    public void m1583a(C0450h c0450h, C0436a c0436a) {
        c0436a.m1310a(c0450h, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0436a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f1367A == null) {
            this.f1367A = new C0473b();
        }
        actionMenuItemView.setPopupCallback(this.f1367A);
    }

    public void m1584a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.m1631a(this.c);
    }

    public void m1585a(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            C0419a.m1229a(viewGroup);
        }
        super.m1352a(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.m1423k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                ActionProvider supportActionProvider = ((C0450h) k.get(i)).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.m1424l() : null;
        if (this.f1373l && l != null) {
            i = l.size();
            if (i == 1) {
                i3 = !((C0450h) l.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f1370i == null) {
                this.f1370i = new C0477d(this, this.a);
            }
            viewGroup = (ViewGroup) this.f1370i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1370i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f1370i, actionMenuView.m1639c());
            }
        } else if (this.f1370i != null && this.f1370i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f1370i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f1373l);
    }

    public boolean m1586a(int i, C0450h c0450h) {
        return c0450h.m1455i();
    }

    public boolean m1587a(C0462p c0462p) {
        if (!c0462p.hasVisibleItems()) {
            return false;
        }
        C0462p c0462p2 = c0462p;
        while (c0462p2.m1500s() != this.c) {
            c0462p2 = (C0462p) c0462p2.m1500s();
        }
        View a = m1568a(c0462p2.getItem());
        if (a == null) {
            if (this.f1370i == null) {
                return false;
            }
            a = this.f1370i;
        }
        this.f1369h = c0462p.getItem().getItemId();
        this.f1386y = new C0472a(this, this.b, c0462p);
        this.f1386y.m1478a(a);
        this.f1386y.m1473a();
        super.m1355a(c0462p);
        return true;
    }

    public boolean m1588a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.f1370i ? false : super.m1356a(viewGroup, i);
    }

    public void m1589b(boolean z) {
        this.f1373l = z;
        this.f1374m = true;
    }

    public boolean m1590b() {
        int i;
        ArrayList i2 = this.c.m1421i();
        int size = i2.size();
        int i3 = this.f1377p;
        int i4 = this.f1376o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0450h c0450h = (C0450h) i2.get(i7);
            if (c0450h.m1457k()) {
                i5++;
            } else if (c0450h.m1456j()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.f1381t && c0450h.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.f1373l && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.f1383v;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f1379r) {
            i = i4 / this.f1382u;
            i6 = ((i4 % this.f1382u) / i) + this.f1382u;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0450h = (C0450h) i2.get(i8);
            int i10;
            if (c0450h.m1457k()) {
                View a = m1578a(c0450h, this.f1384w, viewGroup);
                if (this.f1384w == null) {
                    this.f1384w = a;
                }
                if (this.f1379r) {
                    i9 -= ActionMenuView.m1625a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0450h.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0450h.m1449d(true);
                i = i10;
                i3 = i7;
            } else if (c0450h.m1456j()) {
                boolean z;
                int groupId = c0450h.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.f1379r || i9 > 0);
                if (z3) {
                    View a2 = m1578a(c0450h, this.f1384w, viewGroup);
                    if (this.f1384w == null) {
                        this.f1384w = a2;
                    }
                    boolean z4;
                    if (this.f1379r) {
                        int a3 = ActionMenuView.m1625a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.f1379r) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0450h c0450h2 = (C0450h) i2.get(i7);
                        if (c0450h2.getGroupId() == groupId) {
                            if (c0450h2.m1455i()) {
                                i5++;
                            }
                            c0450h2.m1449d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0450h.m1449d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0450h.m1449d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public Drawable m1591c() {
        return this.f1370i != null ? this.f1370i.getDrawable() : this.f1372k ? this.f1371j : null;
    }

    public void m1592c(boolean z) {
        this.f1381t = z;
    }

    public boolean m1593d() {
        if (!this.f1373l || m1597h() || this.c == null || this.f == null || this.f1387z != null || this.c.m1424l().isEmpty()) {
            return false;
        }
        this.f1387z = new C0474c(this, new C0478e(this, this.b, this.c, this.f1370i, true));
        ((View) this.f).post(this.f1387z);
        super.m1355a(null);
        return true;
    }

    public boolean m1594e() {
        if (this.f1387z == null || this.f == null) {
            C0459k c0459k = this.f1385x;
            if (c0459k == null) {
                return false;
            }
            c0459k.m1487e();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f1387z);
        this.f1387z = null;
        return true;
    }

    public boolean m1595f() {
        return m1594e() | m1596g();
    }

    public boolean m1596g() {
        if (this.f1386y == null) {
            return false;
        }
        this.f1386y.m1487e();
        return true;
    }

    public boolean m1597h() {
        return this.f1385x != null && this.f1385x.m1488f();
    }

    public boolean m1598i() {
        return this.f1387z != null || m1597h();
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.m1355a(null);
        } else {
            this.c.m1401a(false);
        }
    }
}
