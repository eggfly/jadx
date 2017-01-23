package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.C0355a.C0353b;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0413b;
import android.support.v7.view.C0413b.C0345a;
import android.support.v7.view.C0422a;
import android.support.v7.view.C0430g;
import android.support.v7.view.C0432h;
import android.support.v7.view.menu.C0447f;
import android.support.v7.view.menu.C0447f.C0351a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.C0415a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ai;
import android.support.v7.widget.az;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.v7.app.t */
public class C0416t extends C0355a implements C0415a {
    static final /* synthetic */ boolean f1026h;
    private static final Interpolator f1027i;
    private static final Interpolator f1028j;
    private static final boolean f1029k;
    private boolean f1030A;
    private int f1031B;
    private boolean f1032C;
    private boolean f1033D;
    private boolean f1034E;
    private boolean f1035F;
    private boolean f1036G;
    private C0432h f1037H;
    private boolean f1038I;
    C0414a f1039a;
    C0413b f1040b;
    C0345a f1041c;
    boolean f1042d;
    final ViewPropertyAnimatorListener f1043e;
    final ViewPropertyAnimatorListener f1044f;
    final ViewPropertyAnimatorUpdateListener f1045g;
    private Context f1046l;
    private Context f1047m;
    private Activity f1048n;
    private Dialog f1049o;
    private ActionBarOverlayLayout f1050p;
    private ActionBarContainer f1051q;
    private ai f1052r;
    private ActionBarContextView f1053s;
    private View f1054t;
    private az f1055u;
    private ArrayList<Object> f1056v;
    private int f1057w;
    private boolean f1058x;
    private boolean f1059y;
    private ArrayList<C0353b> f1060z;

    /* renamed from: android.support.v7.app.t.1 */
    class C04101 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ C0416t f1016a;

        C04101(C0416t c0416t) {
            this.f1016a = c0416t;
        }

        public void onAnimationEnd(View view) {
            if (this.f1016a.f1032C && this.f1016a.f1054t != null) {
                ViewCompat.setTranslationY(this.f1016a.f1054t, 0.0f);
                ViewCompat.setTranslationY(this.f1016a.f1051q, 0.0f);
            }
            this.f1016a.f1051q.setVisibility(8);
            this.f1016a.f1051q.setTransitioning(false);
            this.f1016a.f1037H = null;
            this.f1016a.m1220i();
            if (this.f1016a.f1050p != null) {
                ViewCompat.requestApplyInsets(this.f1016a.f1050p);
            }
        }
    }

    /* renamed from: android.support.v7.app.t.2 */
    class C04112 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ C0416t f1017a;

        C04112(C0416t c0416t) {
            this.f1017a = c0416t;
        }

        public void onAnimationEnd(View view) {
            this.f1017a.f1037H = null;
            this.f1017a.f1051q.requestLayout();
        }
    }

    /* renamed from: android.support.v7.app.t.3 */
    class C04123 implements ViewPropertyAnimatorUpdateListener {
        final /* synthetic */ C0416t f1018a;

        C04123(C0416t c0416t) {
            this.f1018a = c0416t;
        }

        public void onAnimationUpdate(View view) {
            ((View) this.f1018a.f1051q.getParent()).invalidate();
        }
    }

    /* renamed from: android.support.v7.app.t.a */
    public class C0414a extends C0413b implements C0351a {
        final /* synthetic */ C0416t f1021a;
        private final Context f1022b;
        private final C0447f f1023c;
        private C0345a f1024d;
        private WeakReference<View> f1025e;

        public C0414a(C0416t c0416t, Context context, C0345a c0345a) {
            this.f1021a = c0416t;
            this.f1022b = context;
            this.f1024d = c0345a;
            this.f1023c = new C0447f(context).m1387a(1);
            this.f1023c.m1395a((C0351a) this);
        }

        public MenuInflater m1158a() {
            return new C0430g(this.f1022b);
        }

        public void m1159a(int i) {
            m1167b(this.f1021a.f1046l.getResources().getString(i));
        }

        public void m1160a(C0447f c0447f) {
            if (this.f1024d != null) {
                m1169d();
                this.f1021a.f1053s.m1514a();
            }
        }

        public void m1161a(View view) {
            this.f1021a.f1053s.setCustomView(view);
            this.f1025e = new WeakReference(view);
        }

        public void m1162a(CharSequence charSequence) {
            this.f1021a.f1053s.setSubtitle(charSequence);
        }

        public void m1163a(boolean z) {
            super.m1146a(z);
            this.f1021a.f1053s.setTitleOptional(z);
        }

        public boolean m1164a(C0447f c0447f, MenuItem menuItem) {
            return this.f1024d != null ? this.f1024d.m853a((C0413b) this, menuItem) : false;
        }

        public Menu m1165b() {
            return this.f1023c;
        }

        public void m1166b(int i) {
            m1162a(this.f1021a.f1046l.getResources().getString(i));
        }

        public void m1167b(CharSequence charSequence) {
            this.f1021a.f1053s.setTitle(charSequence);
        }

        public void m1168c() {
            if (this.f1021a.f1039a == this) {
                if (C0416t.m1187b(this.f1021a.f1033D, this.f1021a.f1034E, false)) {
                    this.f1024d.m851a(this);
                } else {
                    this.f1021a.f1040b = this;
                    this.f1021a.f1041c = this.f1024d;
                }
                this.f1024d = null;
                this.f1021a.m1223j(false);
                this.f1021a.f1053s.m1515b();
                this.f1021a.f1052r.m2234a().sendAccessibilityEvent(32);
                this.f1021a.f1050p.setHideOnContentScrollEnabled(this.f1021a.f1042d);
                this.f1021a.f1039a = null;
            }
        }

        public void m1169d() {
            if (this.f1021a.f1039a == this) {
                this.f1023c.m1419g();
                try {
                    this.f1024d.m854b(this, this.f1023c);
                } finally {
                    this.f1023c.m1420h();
                }
            }
        }

        public boolean m1170e() {
            this.f1023c.m1419g();
            try {
                boolean a = this.f1024d.m852a((C0413b) this, this.f1023c);
                return a;
            } finally {
                this.f1023c.m1420h();
            }
        }

        public CharSequence m1171f() {
            return this.f1021a.f1053s.getTitle();
        }

        public CharSequence m1172g() {
            return this.f1021a.f1053s.getSubtitle();
        }

        public boolean m1173h() {
            return this.f1021a.f1053s.m1517d();
        }

        public View m1174i() {
            return this.f1025e != null ? (View) this.f1025e.get() : null;
        }
    }

    static {
        boolean z = true;
        f1026h = !C0416t.class.desiredAssertionStatus();
        f1027i = new AccelerateInterpolator();
        f1028j = new DecelerateInterpolator();
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f1029k = z;
    }

    public C0416t(Activity activity, boolean z) {
        this.f1056v = new ArrayList();
        this.f1057w = -1;
        this.f1060z = new ArrayList();
        this.f1031B = 0;
        this.f1032C = true;
        this.f1036G = true;
        this.f1043e = new C04101(this);
        this.f1044f = new C04112(this);
        this.f1045g = new C04123(this);
        this.f1048n = activity;
        View decorView = activity.getWindow().getDecorView();
        m1182a(decorView);
        if (!z) {
            this.f1054t = decorView.findViewById(16908290);
        }
    }

    public C0416t(Dialog dialog) {
        this.f1056v = new ArrayList();
        this.f1057w = -1;
        this.f1060z = new ArrayList();
        this.f1031B = 0;
        this.f1032C = true;
        this.f1036G = true;
        this.f1043e = new C04101(this);
        this.f1044f = new C04112(this);
        this.f1045g = new C04123(this);
        this.f1049o = dialog;
        m1182a(dialog.getWindow().getDecorView());
    }

    private void m1182a(View view) {
        this.f1050p = (ActionBarOverlayLayout) view.findViewById(C0417R.id.decor_content_parent);
        if (this.f1050p != null) {
            this.f1050p.setActionBarVisibilityCallback(this);
        }
        this.f1052r = m1185b(view.findViewById(C0417R.id.action_bar));
        this.f1053s = (ActionBarContextView) view.findViewById(C0417R.id.action_context_bar);
        this.f1051q = (ActionBarContainer) view.findViewById(C0417R.id.action_bar_container);
        if (this.f1052r == null || this.f1053s == null || this.f1051q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1046l = this.f1052r.m2243b();
        boolean z = (this.f1052r.m2260o() & 4) != 0;
        if (z) {
            this.f1058x = true;
        }
        C0422a a = C0422a.m1230a(this.f1046l);
        z = a.m1236f() || z;
        m1206a(z);
        m1195k(a.m1234d());
        TypedArray obtainStyledAttributes = this.f1046l.obtainStyledAttributes(null, C0417R.styleable.ActionBar, C0417R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0417R.styleable.ActionBar_hideOnContentScroll, false)) {
            m1208b(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0417R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            m1201a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private ai m1185b(View view) {
        if (view instanceof ai) {
            return (ai) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private static boolean m1187b(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private void m1195k(boolean z) {
        boolean z2 = true;
        this.f1030A = z;
        if (this.f1030A) {
            this.f1051q.setTabContainer(null);
            this.f1052r.m2238a(this.f1055u);
        } else {
            this.f1052r.m2238a(null);
            this.f1051q.setTabContainer(this.f1055u);
        }
        boolean z3 = m1222j() == 2;
        if (this.f1055u != null) {
            if (z3) {
                this.f1055u.setVisibility(0);
                if (this.f1050p != null) {
                    ViewCompat.requestApplyInsets(this.f1050p);
                }
            } else {
                this.f1055u.setVisibility(8);
            }
        }
        ai aiVar = this.f1052r;
        boolean z4 = !this.f1030A && z3;
        aiVar.m2242a(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1050p;
        if (this.f1030A || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void m1196l(boolean z) {
        if (C0416t.m1187b(this.f1033D, this.f1034E, this.f1035F)) {
            if (!this.f1036G) {
                this.f1036G = true;
                m1219h(z);
            }
        } else if (this.f1036G) {
            this.f1036G = false;
            m1221i(z);
        }
    }

    private void m1197p() {
        if (!this.f1035F) {
            this.f1035F = true;
            if (this.f1050p != null) {
                this.f1050p.setShowingForActionMode(true);
            }
            m1196l(false);
        }
    }

    private void m1198q() {
        if (this.f1035F) {
            this.f1035F = false;
            if (this.f1050p != null) {
                this.f1050p.setShowingForActionMode(false);
            }
            m1196l(false);
        }
    }

    public int m1199a() {
        return this.f1052r.m2260o();
    }

    public C0413b m1200a(C0345a c0345a) {
        if (this.f1039a != null) {
            this.f1039a.m1168c();
        }
        this.f1050p.setHideOnContentScrollEnabled(false);
        this.f1053s.m1516c();
        C0413b c0414a = new C0414a(this, this.f1053s.getContext(), c0345a);
        if (!c0414a.m1170e()) {
            return null;
        }
        c0414a.m1169d();
        this.f1053s.m1513a(c0414a);
        m1223j(true);
        this.f1053s.sendAccessibilityEvent(32);
        this.f1039a = c0414a;
        return c0414a;
    }

    public void m1201a(float f) {
        ViewCompat.setElevation(this.f1051q, f);
    }

    public void m1202a(int i) {
        this.f1052r.m2249d(i);
    }

    public void m1203a(int i, int i2) {
        int o = this.f1052r.m2260o();
        if ((i2 & 4) != 0) {
            this.f1058x = true;
        }
        this.f1052r.m2246c((o & (i2 ^ -1)) | (i & i2));
    }

    public void m1204a(Configuration configuration) {
        m1195k(C0422a.m1230a(this.f1046l).m1234d());
    }

    public void m1205a(CharSequence charSequence) {
        this.f1052r.m2241a(charSequence);
    }

    public void m1206a(boolean z) {
        this.f1052r.m2245b(z);
    }

    public void m1207b(int i) {
        this.f1031B = i;
    }

    public void m1208b(boolean z) {
        if (!z || this.f1050p.m1544a()) {
            this.f1042d = z;
            this.f1050p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public boolean m1209b() {
        int k = m1224k();
        return this.f1036G && (k == 0 || m1212d() < k);
    }

    public Context m1210c() {
        if (this.f1047m == null) {
            TypedValue typedValue = new TypedValue();
            this.f1046l.getTheme().resolveAttribute(C0417R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1047m = new ContextThemeWrapper(this.f1046l, i);
            } else {
                this.f1047m = this.f1046l;
            }
        }
        return this.f1047m;
    }

    public void m1211c(boolean z) {
        if (!this.f1058x) {
            m1215f(z);
        }
    }

    public int m1212d() {
        return this.f1050p.getActionBarHideOffset();
    }

    public void m1213d(boolean z) {
        this.f1038I = z;
        if (!z && this.f1037H != null) {
            this.f1037H.m1294b();
        }
    }

    public void m1214e(boolean z) {
        if (z != this.f1059y) {
            this.f1059y = z;
            int size = this.f1060z.size();
            for (int i = 0; i < size; i++) {
                ((C0353b) this.f1060z.get(i)).m983a(z);
            }
        }
    }

    public void m1215f(boolean z) {
        m1203a(z ? 4 : 0, 4);
    }

    public boolean m1216f() {
        if (this.f1052r == null || !this.f1052r.m2247c()) {
            return false;
        }
        this.f1052r.m2248d();
        return true;
    }

    public void m1217g(boolean z) {
        this.f1032C = z;
    }

    public boolean m1218g() {
        ViewGroup a = this.f1052r.m2234a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void m1219h(boolean z) {
        if (this.f1037H != null) {
            this.f1037H.m1294b();
        }
        this.f1051q.setVisibility(0);
        if (this.f1031B == 0 && f1029k && (this.f1038I || z)) {
            ViewCompat.setTranslationY(this.f1051q, 0.0f);
            float f = (float) (-this.f1051q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1051q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ViewCompat.setTranslationY(this.f1051q, f);
            C0432h c0432h = new C0432h();
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f1051q).translationY(0.0f);
            translationY.setUpdateListener(this.f1045g);
            c0432h.m1289a(translationY);
            if (this.f1032C && this.f1054t != null) {
                ViewCompat.setTranslationY(this.f1054t, f);
                c0432h.m1289a(ViewCompat.animate(this.f1054t).translationY(0.0f));
            }
            c0432h.m1292a(f1028j);
            c0432h.m1288a(250);
            c0432h.m1291a(this.f1044f);
            this.f1037H = c0432h;
            c0432h.m1293a();
        } else {
            ViewCompat.setAlpha(this.f1051q, 1.0f);
            ViewCompat.setTranslationY(this.f1051q, 0.0f);
            if (this.f1032C && this.f1054t != null) {
                ViewCompat.setTranslationY(this.f1054t, 0.0f);
            }
            this.f1044f.onAnimationEnd(null);
        }
        if (this.f1050p != null) {
            ViewCompat.requestApplyInsets(this.f1050p);
        }
    }

    void m1220i() {
        if (this.f1041c != null) {
            this.f1041c.m851a(this.f1040b);
            this.f1040b = null;
            this.f1041c = null;
        }
    }

    public void m1221i(boolean z) {
        if (this.f1037H != null) {
            this.f1037H.m1294b();
        }
        if (this.f1031B == 0 && f1029k && (this.f1038I || z)) {
            ViewCompat.setAlpha(this.f1051q, 1.0f);
            this.f1051q.setTransitioning(true);
            C0432h c0432h = new C0432h();
            float f = (float) (-this.f1051q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1051q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ViewPropertyAnimatorCompat translationY = ViewCompat.animate(this.f1051q).translationY(f);
            translationY.setUpdateListener(this.f1045g);
            c0432h.m1289a(translationY);
            if (this.f1032C && this.f1054t != null) {
                c0432h.m1289a(ViewCompat.animate(this.f1054t).translationY(f));
            }
            c0432h.m1292a(f1027i);
            c0432h.m1288a(250);
            c0432h.m1291a(this.f1043e);
            this.f1037H = c0432h;
            c0432h.m1293a();
            return;
        }
        this.f1043e.onAnimationEnd(null);
    }

    public int m1222j() {
        return this.f1052r.m2261p();
    }

    public void m1223j(boolean z) {
        ViewPropertyAnimatorCompat a;
        ViewPropertyAnimatorCompat a2;
        if (z) {
            m1197p();
        } else {
            m1198q();
        }
        if (z) {
            a = this.f1052r.m2233a(4, 100);
            a2 = this.f1053s.m1512a(0, 200);
        } else {
            a2 = this.f1052r.m2233a(0, 200);
            a = this.f1053s.m1512a(8, 100);
        }
        C0432h c0432h = new C0432h();
        c0432h.m1290a(a, a2);
        c0432h.m1293a();
    }

    public int m1224k() {
        return this.f1051q.getHeight();
    }

    public void m1225l() {
        if (this.f1034E) {
            this.f1034E = false;
            m1196l(true);
        }
    }

    public void m1226m() {
        if (!this.f1034E) {
            this.f1034E = true;
            m1196l(true);
        }
    }

    public void m1227n() {
        if (this.f1037H != null) {
            this.f1037H.m1294b();
            this.f1037H = null;
        }
    }

    public void m1228o() {
    }
}
