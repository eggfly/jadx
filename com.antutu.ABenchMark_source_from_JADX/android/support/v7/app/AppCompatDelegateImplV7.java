package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.NavUtils;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0413b;
import android.support.v7.view.C0413b.C0345a;
import android.support.v7.view.C0424d;
import android.support.v7.view.C0425e;
import android.support.v7.view.menu.C0439m;
import android.support.v7.view.menu.C0441l.C0342a;
import android.support.v7.view.menu.C0446e;
import android.support.v7.view.menu.C0447f;
import android.support.v7.view.menu.C0447f.C0351a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.C0616l;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.C0336a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ah;
import android.support.v7.widget.al;
import android.support.v7.widget.al.C0334a;
import android.support.v7.widget.bj;
import android.support.v7.widget.bl;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import org.android.spdy.SpdyProtocol;

class AppCompatDelegateImplV7 extends C0350h implements LayoutInflaterFactory, C0351a {
    private boolean f824A;
    private PanelFeatureState[] f825B;
    private PanelFeatureState f826C;
    private boolean f827D;
    private boolean f828E;
    private int f829F;
    private final Runnable f830G;
    private boolean f831H;
    private Rect f832I;
    private Rect f833J;
    private C0388m f834K;
    C0413b f835m;
    ActionBarContextView f836n;
    PopupWindow f837o;
    Runnable f838p;
    ViewPropertyAnimatorCompat f839q;
    private ah f840r;
    private C0343a f841s;
    private C0348d f842t;
    private boolean f843u;
    private ViewGroup f844v;
    private TextView f845w;
    private View f846x;
    private boolean f847y;
    private boolean f848z;

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.1 */
    class C03321 implements Runnable {
        final /* synthetic */ AppCompatDelegateImplV7 f765a;

        C03321(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f765a = appCompatDelegateImplV7;
        }

        public void run() {
            if ((this.f765a.f829F & 1) != 0) {
                this.f765a.m943f(0);
            }
            if ((this.f765a.f829F & SpdyProtocol.SLIGHTSSL_0_RTT_MODE) != 0) {
                this.f765a.m943f(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall);
            }
            this.f765a.f828E = false;
            this.f765a.f829F = 0;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.2 */
    class C03332 implements OnApplyWindowInsetsListener {
        final /* synthetic */ AppCompatDelegateImplV7 f766a;

        C03332(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f766a = appCompatDelegateImplV7;
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int c = this.f766a.m944g(systemWindowInsetTop);
            if (systemWindowInsetTop != c) {
                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), c, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            }
            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.3 */
    class C03353 implements C0334a {
        final /* synthetic */ AppCompatDelegateImplV7 f767a;

        C03353(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f767a = appCompatDelegateImplV7;
        }

        public void m834a(Rect rect) {
            rect.top = this.f767a.m944g(rect.top);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.4 */
    class C03374 implements C0336a {
        final /* synthetic */ AppCompatDelegateImplV7 f768a;

        C03374(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f768a = appCompatDelegateImplV7;
        }

        public void m837a() {
        }

        public void m838b() {
            this.f768a.m951y();
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.5 */
    class C03395 implements Runnable {
        final /* synthetic */ AppCompatDelegateImplV7 f770a;

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.5.1 */
        class C03381 extends ViewPropertyAnimatorListenerAdapter {
            final /* synthetic */ C03395 f769a;

            C03381(C03395 c03395) {
                this.f769a = c03395;
            }

            public void onAnimationEnd(View view) {
                ViewCompat.setAlpha(this.f769a.f770a.f836n, 1.0f);
                this.f769a.f770a.f839q.setListener(null);
                this.f769a.f770a.f839q = null;
            }

            public void onAnimationStart(View view) {
                this.f769a.f770a.f836n.setVisibility(0);
            }
        }

        C03395(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f770a = appCompatDelegateImplV7;
        }

        public void run() {
            this.f770a.f837o.showAtLocation(this.f770a.f836n, 55, 0, 0);
            this.f770a.m949w();
            ViewCompat.setAlpha(this.f770a.f836n, 0.0f);
            this.f770a.f839q = ViewCompat.animate(this.f770a.f836n).alpha(1.0f);
            this.f770a.f839q.setListener(new C03381(this));
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.6 */
    class C03406 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ AppCompatDelegateImplV7 f771a;

        C03406(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f771a = appCompatDelegateImplV7;
        }

        public void onAnimationEnd(View view) {
            ViewCompat.setAlpha(this.f771a.f836n, 1.0f);
            this.f771a.f839q.setListener(null);
            this.f771a.f839q = null;
        }

        public void onAnimationStart(View view) {
            this.f771a.f836n.setVisibility(0);
            this.f771a.f836n.sendAccessibilityEvent(32);
            if (this.f771a.f836n.getParent() != null) {
                ViewCompat.requestApplyInsets((View) this.f771a.f836n.getParent());
            }
        }
    }

    private static final class PanelFeatureState {
        int f775a;
        int f776b;
        int f777c;
        int f778d;
        int f779e;
        int f780f;
        ViewGroup f781g;
        View f782h;
        View f783i;
        C0447f f784j;
        C0446e f785k;
        Context f786l;
        boolean f787m;
        boolean f788n;
        boolean f789o;
        public boolean f790p;
        boolean f791q;
        boolean f792r;
        Bundle f793s;

        private static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR;
            int f772a;
            boolean f773b;
            Bundle f774c;

            /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState.SavedState.1 */
            static class C03411 implements ParcelableCompatCreatorCallbacks<SavedState> {
                C03411() {
                }

                public SavedState m839a(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.m842b(parcel, classLoader);
                }

                public SavedState[] m840a(int i) {
                    return new SavedState[i];
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return m839a(parcel, classLoader);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m840a(i);
                }
            }

            static {
                CREATOR = ParcelableCompat.newCreator(new C03411());
            }

            private SavedState() {
            }

            private static SavedState m842b(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.f772a = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f773b = z;
                if (savedState.f773b) {
                    savedState.f774c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f772a);
                parcel.writeInt(this.f773b ? 1 : 0);
                if (this.f773b) {
                    parcel.writeBundle(this.f774c);
                }
            }
        }

        PanelFeatureState(int i) {
            this.f775a = i;
            this.f791q = false;
        }

        C0439m m843a(C0342a c0342a) {
            if (this.f784j == null) {
                return null;
            }
            if (this.f785k == null) {
                this.f785k = new C0446e(this.f786l, C0417R.layout.abc_list_menu_item_layout);
                this.f785k.m1372a(c0342a);
                this.f784j.m1397a(this.f785k);
            }
            return this.f785k.m1368a(this.f781g);
        }

        void m844a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0417R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0417R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0417R.style.Theme_AppCompat_CompactMenu, true);
            }
            Context c0424d = new C0424d(context, 0);
            c0424d.getTheme().setTo(newTheme);
            this.f786l = c0424d;
            TypedArray obtainStyledAttributes = c0424d.obtainStyledAttributes(C0417R.styleable.AppCompatTheme);
            this.f776b = obtainStyledAttributes.getResourceId(C0417R.styleable.AppCompatTheme_panelBackground, 0);
            this.f780f = obtainStyledAttributes.getResourceId(C0417R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void m845a(C0447f c0447f) {
            if (c0447f != this.f784j) {
                if (this.f784j != null) {
                    this.f784j.m1408b(this.f785k);
                }
                this.f784j = c0447f;
                if (c0447f != null && this.f785k != null) {
                    c0447f.m1397a(this.f785k);
                }
            }
        }

        public boolean m846a() {
            return this.f782h == null ? false : this.f783i != null || this.f785k.m1369a().getCount() > 0;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.a */
    private final class C0343a implements C0342a {
        final /* synthetic */ AppCompatDelegateImplV7 f794a;

        private C0343a(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f794a = appCompatDelegateImplV7;
        }

        public void m849a(C0447f c0447f, boolean z) {
            this.f794a.m932b(c0447f);
        }

        public boolean m850a(C0447f c0447f) {
            Callback q = this.f794a.m910q();
            if (q != null) {
                q.onMenuOpened(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall, c0447f);
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.b */
    class C0346b implements C0345a {
        final /* synthetic */ AppCompatDelegateImplV7 f796a;
        private C0345a f797b;

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.b.1 */
        class C03441 extends ViewPropertyAnimatorListenerAdapter {
            final /* synthetic */ C0346b f795a;

            C03441(C0346b c0346b) {
                this.f795a = c0346b;
            }

            public void onAnimationEnd(View view) {
                this.f795a.f796a.f836n.setVisibility(8);
                if (this.f795a.f796a.f837o != null) {
                    this.f795a.f796a.f837o.dismiss();
                } else if (this.f795a.f796a.f836n.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) this.f795a.f796a.f836n.getParent());
                }
                this.f795a.f796a.f836n.removeAllViews();
                this.f795a.f796a.f839q.setListener(null);
                this.f795a.f796a.f839q = null;
            }
        }

        public C0346b(AppCompatDelegateImplV7 appCompatDelegateImplV7, C0345a c0345a) {
            this.f796a = appCompatDelegateImplV7;
            this.f797b = c0345a;
        }

        public void m855a(C0413b c0413b) {
            this.f797b.m851a(c0413b);
            if (this.f796a.f837o != null) {
                this.f796a.b.getDecorView().removeCallbacks(this.f796a.f838p);
            }
            if (this.f796a.f836n != null) {
                this.f796a.m949w();
                this.f796a.f839q = ViewCompat.animate(this.f796a.f836n).alpha(0.0f);
                this.f796a.f839q.setListener(new C03441(this));
            }
            if (this.f796a.e != null) {
                this.f796a.e.onSupportActionModeFinished(this.f796a.f835m);
            }
            this.f796a.f835m = null;
        }

        public boolean m856a(C0413b c0413b, Menu menu) {
            return this.f797b.m852a(c0413b, menu);
        }

        public boolean m857a(C0413b c0413b, MenuItem menuItem) {
            return this.f797b.m853a(c0413b, menuItem);
        }

        public boolean m858b(C0413b c0413b, Menu menu) {
            return this.f797b.m854b(c0413b, menu);
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.c */
    private class C0347c extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImplV7 f806a;

        public C0347c(AppCompatDelegateImplV7 appCompatDelegateImplV7, Context context) {
            this.f806a = appCompatDelegateImplV7;
            super(context);
        }

        private boolean m861a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f806a.m965a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m861a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f806a.m938d(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0616l.m2672a().m2695a(getContext(), i));
        }
    }

    /* renamed from: android.support.v7.app.AppCompatDelegateImplV7.d */
    private final class C0348d implements C0342a {
        final /* synthetic */ AppCompatDelegateImplV7 f807a;

        private C0348d(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
            this.f807a = appCompatDelegateImplV7;
        }

        public void m862a(C0447f c0447f, boolean z) {
            Menu menu;
            Menu p = c0447f.m1428p();
            boolean z2 = p != c0447f;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.f807a;
            if (z2) {
                menu = p;
            }
            PanelFeatureState a = appCompatDelegateImplV7.m917a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.f807a.m918a(a.f775a, a, p);
                this.f807a.m920a(a, true);
                return;
            }
            this.f807a.m920a(a, z);
        }

        public boolean m863a(C0447f c0447f) {
            if (c0447f == null && this.f807a.h) {
                Callback q = this.f807a.m910q();
                if (!(q == null || this.f807a.m909p())) {
                    q.onMenuOpened(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall, c0447f);
                }
            }
            return true;
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, C0374f c0374f) {
        super(context, window, c0374f);
        this.f839q = null;
        this.f830G = new C03321(this);
    }

    private PanelFeatureState m915a(int i, boolean z) {
        Object obj = this.f825B;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f825B = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private PanelFeatureState m917a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f825B;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.f784j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private void m918a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.f825B.length) {
                panelFeatureState = this.f825B[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f784j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f789o) && !m909p()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m919a(android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f789o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m909p();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f775a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m910q();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f775a;
        r5 = r11.f784j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m920a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m934b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f781g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f791q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f781g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m926a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f781g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m937c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m846a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f782h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f776b;
        r4 = r11.f781g;
        r4.setBackgroundResource(r0);
        r0 = r11.f782h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f782h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f781g;
        r4 = r11.f782h;
        r0.addView(r4, r1);
        r0 = r11.f782h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f782h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f788n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f778d;
        r4 = r11.f779e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f777c;
        r0.gravity = r1;
        r1 = r11.f780f;
        r0.windowAnimations = r1;
        r1 = r11.f781g;
        r8.addView(r1, r0);
        r11.f789o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f791q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f781g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f781g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f783i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f783i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):void");
    }

    private void m920a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.f775a == 0 && this.f840r != null && this.f840r.m1521e()) {
            m932b(panelFeatureState.f784j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.f789o || panelFeatureState.f781g == null)) {
            windowManager.removeView(panelFeatureState.f781g);
            if (z) {
                m918a(panelFeatureState.f775a, panelFeatureState, null);
            }
        }
        panelFeatureState.f787m = false;
        panelFeatureState.f788n = false;
        panelFeatureState.f789o = false;
        panelFeatureState.f782h = null;
        panelFeatureState.f791q = true;
        if (this.f826C == panelFeatureState) {
            this.f826C = null;
        }
    }

    private void m925a(C0447f c0447f, boolean z) {
        if (this.f840r == null || !this.f840r.m1520d() || (ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.a)) && !this.f840r.m1522f())) {
            PanelFeatureState a = m915a(0, true);
            a.f791q = true;
            m920a(a, false);
            m919a(a, null);
            return;
        }
        Callback q = m910q();
        if (this.f840r.m1521e() && z) {
            this.f840r.m1524h();
            if (!m909p()) {
                q.onPanelClosed(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall, m915a(0, true).f784j);
            }
        } else if (q != null && !m909p()) {
            if (this.f828E && (this.f829F & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.f830G);
                this.f830G.run();
            }
            PanelFeatureState a2 = m915a(0, true);
            if (a2.f784j != null && !a2.f792r && q.onPreparePanel(0, a2.f783i, a2.f784j)) {
                q.onMenuOpened(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall, a2.f784j);
                this.f840r.m1523g();
            }
        }
    }

    private boolean m926a(PanelFeatureState panelFeatureState) {
        panelFeatureState.m844a(m907n());
        panelFeatureState.f781g = new C0347c(this, panelFeatureState.f786l);
        panelFeatureState.f777c = 81;
        return true;
    }

    private boolean m927a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((panelFeatureState.f787m || m934b(panelFeatureState, keyEvent)) && panelFeatureState.f784j != null) {
                z = panelFeatureState.f784j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f840r == null) {
                m920a(panelFeatureState, true);
            }
        }
        return z;
    }

    private boolean m929a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || ViewCompat.isAttachedToWindow((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    private void m932b(C0447f c0447f) {
        if (!this.f824A) {
            this.f824A = true;
            this.f840r.m1526j();
            Callback q = m910q();
            if (!(q == null || m909p())) {
                q.onPanelClosed(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall, c0447f);
            }
            this.f824A = false;
        }
    }

    private boolean m933b(PanelFeatureState panelFeatureState) {
        Context c0424d;
        C0447f c0447f;
        Context context = this.a;
        if ((panelFeatureState.f775a == 0 || panelFeatureState.f775a == C1692R.styleable.AppCompatTheme_ratingBarStyleSmall) && this.f840r != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0417R.attr.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0417R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0417R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0424d = new C0424d(context, 0);
                c0424d.getTheme().setTo(theme3);
                c0447f = new C0447f(c0424d);
                c0447f.m1395a((C0351a) this);
                panelFeatureState.m845a(c0447f);
                return true;
            }
        }
        c0424d = context;
        c0447f = new C0447f(c0424d);
        c0447f.m1395a((C0351a) this);
        panelFeatureState.m845a(c0447f);
        return true;
    }

    private boolean m934b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (m909p()) {
            return false;
        }
        if (panelFeatureState.f787m) {
            return true;
        }
        if (!(this.f826C == null || this.f826C == panelFeatureState)) {
            m920a(this.f826C, false);
        }
        Callback q = m910q();
        if (q != null) {
            panelFeatureState.f783i = q.onCreatePanelView(panelFeatureState.f775a);
        }
        boolean z = panelFeatureState.f775a == 0 || panelFeatureState.f775a == C1692R.styleable.AppCompatTheme_ratingBarStyleSmall;
        if (z && this.f840r != null) {
            this.f840r.m1525i();
        }
        if (panelFeatureState.f783i == null && !(z && (m906m() instanceof C0405q))) {
            if (panelFeatureState.f784j == null || panelFeatureState.f792r) {
                if (panelFeatureState.f784j == null && (!m933b(panelFeatureState) || panelFeatureState.f784j == null)) {
                    return false;
                }
                if (z && this.f840r != null) {
                    if (this.f841s == null) {
                        this.f841s = new C0343a();
                    }
                    this.f840r.m1519a(panelFeatureState.f784j, this.f841s);
                }
                panelFeatureState.f784j.m1419g();
                if (q.onCreatePanelMenu(panelFeatureState.f775a, panelFeatureState.f784j)) {
                    panelFeatureState.f792r = false;
                } else {
                    panelFeatureState.m845a(null);
                    if (!z || this.f840r == null) {
                        return false;
                    }
                    this.f840r.m1519a(null, this.f841s);
                    return false;
                }
            }
            panelFeatureState.f784j.m1419g();
            if (panelFeatureState.f793s != null) {
                panelFeatureState.f784j.m1406b(panelFeatureState.f793s);
                panelFeatureState.f793s = null;
            }
            if (q.onPreparePanel(0, panelFeatureState.f783i, panelFeatureState.f784j)) {
                panelFeatureState.f790p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                panelFeatureState.f784j.setQwertyMode(panelFeatureState.f790p);
                panelFeatureState.f784j.m1420h();
            } else {
                if (z && this.f840r != null) {
                    this.f840r.m1519a(null, this.f841s);
                }
                panelFeatureState.f784j.m1420h();
                return false;
            }
        }
        panelFeatureState.f787m = true;
        panelFeatureState.f788n = false;
        this.f826C = panelFeatureState;
        return true;
    }

    private boolean m937c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f783i != null) {
            panelFeatureState.f782h = panelFeatureState.f783i;
            return true;
        } else if (panelFeatureState.f784j == null) {
            return false;
        } else {
            if (this.f842t == null) {
                this.f842t = new C0348d();
            }
            panelFeatureState.f782h = (View) panelFeatureState.m843a(this.f842t);
            return panelFeatureState.f782h != null;
        }
    }

    private void m938d(int i) {
        m920a(m915a(i, true), true);
    }

    private boolean m940d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState a = m915a(i, true);
            if (!a.f789o) {
                return m934b(a, keyEvent);
            }
        }
        return false;
    }

    private void m941e(int i) {
        this.f829F |= 1 << i;
        if (!this.f828E) {
            ViewCompat.postOnAnimation(this.b.getDecorView(), this.f830G);
            this.f828E = true;
        }
    }

    private boolean m942e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f835m != null) {
            return false;
        }
        PanelFeatureState a = m915a(i, true);
        if (i != 0 || this.f840r == null || !this.f840r.m1520d() || ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.a))) {
            boolean z2;
            if (a.f789o || a.f788n) {
                z2 = a.f789o;
                m920a(a, true);
                z = z2;
            } else {
                if (a.f787m) {
                    if (a.f792r) {
                        a.f787m = false;
                        z2 = m934b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m919a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f840r.m1521e()) {
            z = this.f840r.m1524h();
        } else {
            if (!m909p() && m934b(a, keyEvent)) {
                z = this.f840r.m1523g();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private void m943f(int i) {
        PanelFeatureState a = m915a(i, true);
        if (a.f784j != null) {
            Bundle bundle = new Bundle();
            a.f784j.m1394a(bundle);
            if (bundle.size() > 0) {
                a.f793s = bundle;
            }
            a.f784j.m1419g();
            a.f784j.clear();
        }
        a.f792r = true;
        a.f791q = true;
        if ((i == C1692R.styleable.AppCompatTheme_ratingBarStyleSmall || i == 0) && this.f840r != null) {
            a = m915a(0, false);
            if (a != null) {
                a.f787m = false;
                m934b(a, null);
            }
        }
    }

    private int m944g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f836n == null || !(this.f836n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f836n.getLayoutParams();
            if (this.f836n.isShown()) {
                if (this.f832I == null) {
                    this.f832I = new Rect();
                    this.f833J = new Rect();
                }
                Rect rect = this.f832I;
                Rect rect2 = this.f833J;
                rect.set(0, i, 0, 0);
                bl.m2590a(this.f844v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f846x == null) {
                        this.f846x = new View(this.a);
                        this.f846x.setBackgroundColor(this.a.getResources().getColor(C0417R.color.abc_input_method_navigation_guard));
                        this.f844v.addView(this.f846x, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f846x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f846x.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f846x == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f836n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f846x != null) {
            View view = this.f846x;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private int m945h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return C1692R.styleable.AppCompatTheme_ratingBarStyleSmall;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return C1692R.styleable.AppCompatTheme_seekBarStyle;
        }
    }

    private void m946t() {
        if (!this.f843u) {
            this.f844v = m947u();
            CharSequence r = m911r();
            if (!TextUtils.isEmpty(r)) {
                m971b(r);
            }
            m948v();
            m962a(this.f844v);
            this.f843u = true;
            PanelFeatureState a = m915a(0, false);
            if (!m909p()) {
                if (a == null || a.f784j == null) {
                    m941e(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall);
                }
            }
        }
    }

    private ViewGroup m947u() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0417R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0417R.styleable.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0417R.styleable.AppCompatTheme_windowNoTitle, false)) {
                m975c(1);
            } else if (obtainStyledAttributes.getBoolean(C0417R.styleable.AppCompatTheme_windowActionBar, false)) {
                m975c((int) C1692R.styleable.AppCompatTheme_ratingBarStyleSmall);
            }
            if (obtainStyledAttributes.getBoolean(C0417R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                m975c((int) C1692R.styleable.AppCompatTheme_seekBarStyle);
            }
            if (obtainStyledAttributes.getBoolean(C0417R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                m975c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0417R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2 = this.j ? (ViewGroup) from.inflate(C0417R.layout.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(C0417R.layout.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    ViewCompat.setOnApplyWindowInsetsListener(view2, new C03332(this));
                    view = view2;
                } else {
                    ((al) view2).setOnFitSystemWindowsListener(new C03353(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(C0417R.layout.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0417R.attr.actionBarTheme, typedValue, true);
                r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0424d(this.a, typedValue.resourceId) : this.a).inflate(C0417R.layout.abc_screen_toolbar, null);
                this.f840r = (ah) r0.findViewById(C0417R.id.decor_content_parent);
                this.f840r.setWindowCallback(m910q());
                if (this.i) {
                    this.f840r.m1518a(C1692R.styleable.AppCompatTheme_seekBarStyle);
                }
                if (this.f847y) {
                    this.f840r.m1518a(2);
                }
                if (this.f848z) {
                    this.f840r.m1518a(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f840r == null) {
                this.f845w = (TextView) view.findViewById(C0417R.id.title);
            }
            bl.m2592b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0417R.id.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new C03374(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void m948v() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f844v.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m859a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0417R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(C0417R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0417R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0417R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0417R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0417R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0417R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0417R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0417R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0417R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0417R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void m949w() {
        if (this.f839q != null) {
            this.f839q.cancel();
        }
    }

    private void m950x() {
        if (this.f843u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void m951y() {
        if (this.f840r != null) {
            this.f840r.m1526j();
        }
        if (this.f837o != null) {
            this.b.getDecorView().removeCallbacks(this.f838p);
            if (this.f837o.isShowing()) {
                try {
                    this.f837o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f837o = null;
        }
        m949w();
        PanelFeatureState a = m915a(0, false);
        if (a != null && a.f784j != null) {
            a.f784j.close();
        }
    }

    public C0413b m952a(C0345a c0345a) {
        if (c0345a == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f835m != null) {
            this.f835m.m1150c();
        }
        C0345a c0346b = new C0346b(this, c0345a);
        C0355a a = m891a();
        if (a != null) {
            this.f835m = a.m990a(c0346b);
            if (!(this.f835m == null || this.e == null)) {
                this.e.onSupportActionModeStarted(this.f835m);
            }
        }
        if (this.f835m == null) {
            this.f835m = m966b(c0346b);
        }
        return this.f835m;
    }

    public View m953a(int i) {
        m946t();
        return this.b.findViewById(i);
    }

    View m954a(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    void m955a(int i, Menu menu) {
        if (i == C1692R.styleable.AppCompatTheme_ratingBarStyleSmall) {
            C0355a a = m891a();
            if (a != null) {
                a.m1003e(false);
            }
        } else if (i == 0) {
            PanelFeatureState a2 = m915a(i, true);
            if (a2.f789o) {
                m920a(a2, false);
            }
        }
    }

    public void m956a(Configuration configuration) {
        if (this.h && this.f843u) {
            C0355a a = m891a();
            if (a != null) {
                a.m993a(configuration);
            }
        }
        m904i();
    }

    public void m957a(Bundle bundle) {
        if ((this.c instanceof Activity) && NavUtils.getParentActivityName((Activity) this.c) != null) {
            C0355a m = m906m();
            if (m == null) {
                this.f831H = true;
            } else {
                m.m1000c(true);
            }
        }
    }

    public void m958a(C0447f c0447f) {
        m925a(c0447f, true);
    }

    public void m959a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            C0355a a = m891a();
            if (a instanceof C0416t) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.g = null;
            if (a != null) {
                a.m1007h();
            }
            if (toolbar != null) {
                C0355a c0405q = new C0405q(toolbar, ((Activity) this.a).getTitle(), this.d);
                this.f = c0405q;
                this.b.setCallback(c0405q.m1132i());
            } else {
                this.f = null;
                this.b.setCallback(this.d);
            }
            m978e();
        }
    }

    public void m960a(View view) {
        m946t();
        ViewGroup viewGroup = (ViewGroup) this.f844v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void m961a(View view, LayoutParams layoutParams) {
        m946t();
        ViewGroup viewGroup = (ViewGroup) this.f844v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m962a(ViewGroup viewGroup) {
    }

    boolean m963a(int i, KeyEvent keyEvent) {
        C0355a a = m891a();
        if (a != null && a.m996a(i, keyEvent)) {
            return true;
        }
        if (this.f826C == null || !m927a(this.f826C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f826C == null) {
                PanelFeatureState a2 = m915a(0, true);
                m934b(a2, keyEvent);
                boolean a3 = m927a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f787m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f826C == null) {
            return true;
        } else {
            this.f826C.f788n = true;
            return true;
        }
    }

    public boolean m964a(C0447f c0447f, MenuItem menuItem) {
        Callback q = m910q();
        if (!(q == null || m909p())) {
            PanelFeatureState a = m917a(c0447f.m1428p());
            if (a != null) {
                return q.onMenuItemSelected(a.f775a, menuItem);
            }
        }
        return false;
    }

    boolean m965a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m976c(keyCode, keyEvent) : m972b(keyCode, keyEvent);
    }

    C0413b m966b(C0345a c0345a) {
        C0413b c0413b;
        m949w();
        if (this.f835m != null) {
            this.f835m.m1150c();
        }
        C0345a c0346b = new C0346b(this, c0345a);
        if (this.e == null || m909p()) {
            c0413b = null;
        } else {
            try {
                c0413b = this.e.onWindowStartingSupportActionMode(c0346b);
            } catch (AbstractMethodError e) {
                c0413b = null;
            }
        }
        if (c0413b != null) {
            this.f835m = c0413b;
        } else {
            if (this.f836n == null) {
                if (this.k) {
                    Context c0424d;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0417R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0424d = new C0424d(this.a, 0);
                        c0424d.getTheme().setTo(newTheme);
                    } else {
                        c0424d = this.a;
                    }
                    this.f836n = new ActionBarContextView(c0424d);
                    this.f837o = new PopupWindow(c0424d, null, C0417R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.setWindowLayoutType(this.f837o, 2);
                    this.f837o.setContentView(this.f836n);
                    this.f837o.setWidth(-1);
                    c0424d.getTheme().resolveAttribute(C0417R.attr.actionBarSize, typedValue, true);
                    this.f836n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0424d.getResources().getDisplayMetrics()));
                    this.f837o.setHeight(-2);
                    this.f838p = new C03395(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f844v.findViewById(C0417R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m907n()));
                        this.f836n = (ActionBarContextView) viewStubCompat.m2155a();
                    }
                }
            }
            if (this.f836n != null) {
                m949w();
                this.f836n.m1516c();
                C0413b c0425e = new C0425e(this.f836n.getContext(), this.f836n, c0346b, this.f837o == null);
                if (c0345a.m852a(c0425e, c0425e.m1147b())) {
                    c0425e.m1151d();
                    this.f836n.m1513a(c0425e);
                    this.f835m = c0425e;
                    ViewCompat.setAlpha(this.f836n, 0.0f);
                    this.f839q = ViewCompat.animate(this.f836n).alpha(1.0f);
                    this.f839q.setListener(new C03406(this));
                    if (this.f837o != null) {
                        this.b.getDecorView().post(this.f838p);
                    }
                } else {
                    this.f835m = null;
                }
            }
        }
        if (!(this.f835m == null || this.e == null)) {
            this.e.onSupportActionModeStarted(this.f835m);
        }
        return this.f835m;
    }

    public View m967b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = VERSION.SDK_INT < 21;
        if (this.f834K == null) {
            this.f834K = new C0388m();
        }
        boolean z2 = z && m929a((ViewParent) view);
        return this.f834K.m1085a(view, str, context, attributeSet, z2, z, true, bj.m2567a());
    }

    public void m968b(int i) {
        m946t();
        ViewGroup viewGroup = (ViewGroup) this.f844v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void m969b(Bundle bundle) {
        m946t();
    }

    public void m970b(View view, LayoutParams layoutParams) {
        m946t();
        ((ViewGroup) this.f844v.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m971b(CharSequence charSequence) {
        if (this.f840r != null) {
            this.f840r.setWindowTitle(charSequence);
        } else if (m906m() != null) {
            m906m().m994a(charSequence);
        } else if (this.f845w != null) {
            this.f845w.setText(charSequence);
        }
    }

    boolean m972b(int i, KeyEvent keyEvent) {
        switch (i) {
            case SpdyProtocol.QUIC /*4*/:
                boolean z = this.f827D;
                this.f827D = false;
                PanelFeatureState a = m915a(0, false);
                if (a == null || !a.f789o) {
                    if (m982s()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m920a(a, true);
                    return true;
                }
                break;
            case C1692R.styleable.AppCompatTheme_colorPrimary /*82*/:
                m942e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean m973b(int i, Menu menu) {
        if (i != C1692R.styleable.AppCompatTheme_ratingBarStyleSmall) {
            return false;
        }
        C0355a a = m891a();
        if (a == null) {
            return true;
        }
        a.m1003e(true);
        return true;
    }

    public void m974c() {
        C0355a a = m891a();
        if (a != null) {
            a.m1002d(false);
        }
    }

    public boolean m975c(int i) {
        int h = m945h(i);
        if (this.l && h == C1692R.styleable.AppCompatTheme_ratingBarStyleSmall) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                m950x();
                this.l = true;
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                m950x();
                this.f847y = true;
                return true;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                m950x();
                this.f848z = true;
                return true;
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                m950x();
                this.j = true;
                return true;
            case C1692R.styleable.AppCompatTheme_ratingBarStyleSmall /*108*/:
                m950x();
                this.h = true;
                return true;
            case C1692R.styleable.AppCompatTheme_seekBarStyle /*109*/:
                m950x();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    boolean m976c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case SpdyProtocol.QUIC /*4*/:
                if ((keyEvent.getFlags() & SpdyProtocol.SLIGHTSSLV2) == 0) {
                    z = false;
                }
                this.f827D = z;
                break;
            case C1692R.styleable.AppCompatTheme_colorPrimary /*82*/:
                m940d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            m963a(i, keyEvent);
        }
        return false;
    }

    public void m977d() {
        C0355a a = m891a();
        if (a != null) {
            a.m1002d(true);
        }
    }

    public void m978e() {
        C0355a a = m891a();
        if (a == null || !a.m1004e()) {
            m941e(0);
        }
    }

    public void m979f() {
        super.m902f();
        if (this.f != null) {
            this.f.m1007h();
        }
    }

    public void m980h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory(from, this);
        } else if (!(LayoutInflaterCompat.getFactory(from) instanceof AppCompatDelegateImplV7)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void m981l() {
        m946t();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new C0416t((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new C0416t((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.m1000c(this.f831H);
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = m954a(view, str, context, attributeSet);
        return a != null ? a : m967b(view, str, context, attributeSet);
    }

    boolean m982s() {
        if (this.f835m != null) {
            this.f835m.m1150c();
            return true;
        }
        C0355a a = m891a();
        return a != null && a.m1005f();
    }
}
