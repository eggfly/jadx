package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.facebook.ads.AdError;
import java.lang.reflect.Method;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class ap {
    private static Method f1852a;
    private static Method f1853c;
    private final C0577c f1854A;
    private Runnable f1855B;
    private final Handler f1856C;
    private Rect f1857D;
    private boolean f1858E;
    private int f1859F;
    int f1860b;
    private Context f1861d;
    private PopupWindow f1862e;
    private ListAdapter f1863f;
    private C0574a f1864g;
    private int f1865h;
    private int f1866i;
    private int f1867j;
    private int f1868k;
    private int f1869l;
    private boolean f1870m;
    private int f1871n;
    private boolean f1872o;
    private boolean f1873p;
    private View f1874q;
    private int f1875r;
    private DataSetObserver f1876s;
    private View f1877t;
    private Drawable f1878u;
    private OnItemClickListener f1879v;
    private OnItemSelectedListener f1880w;
    private final C0581g f1881x;
    private final C0580f f1882y;
    private final C0579e f1883z;

    /* renamed from: android.support.v7.widget.ap.b */
    public static abstract class C0433b implements OnTouchListener {
        private final float f1123a;
        private final int f1124b;
        private final int f1125c;
        private final View f1126d;
        private Runnable f1127e;
        private Runnable f1128f;
        private boolean f1129g;
        private boolean f1130h;
        private int f1131i;
        private final int[] f1132j;

        /* renamed from: android.support.v7.widget.ap.b.a */
        private class C0575a implements Runnable {
            final /* synthetic */ C0433b f1845a;

            private C0575a(C0433b c0433b) {
                this.f1845a = c0433b;
            }

            public void run() {
                this.f1845a.f1126d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* renamed from: android.support.v7.widget.ap.b.b */
        private class C0576b implements Runnable {
            final /* synthetic */ C0433b f1846a;

            private C0576b(C0433b c0433b) {
                this.f1846a = c0433b;
            }

            public void run() {
                this.f1846a.m1303e();
            }
        }

        public C0433b(View view) {
            this.f1132j = new int[2];
            this.f1126d = view;
            this.f1123a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1124b = ViewConfiguration.getTapTimeout();
            this.f1125c = (this.f1124b + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        private boolean m1296a(MotionEvent motionEvent) {
            View view = this.f1126d;
            if (!view.isEnabled()) {
                return false;
            }
            switch (MotionEventCompat.getActionMasked(motionEvent)) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    this.f1131i = motionEvent.getPointerId(0);
                    this.f1130h = false;
                    if (this.f1127e == null) {
                        this.f1127e = new C0575a();
                    }
                    view.postDelayed(this.f1127e, (long) this.f1124b);
                    if (this.f1128f == null) {
                        this.f1128f = new C0576b();
                    }
                    view.postDelayed(this.f1128f, (long) this.f1125c);
                    return false;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    m1302d();
                    return false;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1131i);
                    if (findPointerIndex < 0 || C0433b.m1297a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1123a)) {
                        return false;
                    }
                    m1302d();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        private static boolean m1297a(View view, float f, float f2, float f3) {
            return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
        }

        private boolean m1298a(View view, MotionEvent motionEvent) {
            int[] iArr = this.f1132j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
            return true;
        }

        private boolean m1300b(MotionEvent motionEvent) {
            boolean z = true;
            View view = this.f1126d;
            ap a = m1304a();
            if (a == null || !a.m2371k()) {
                return false;
            }
            View a2 = a.f1864g;
            if (a2 == null || !a2.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            m1301b(view, obtainNoHistory);
            m1298a(a2, obtainNoHistory);
            boolean a3 = a2.m2340a(obtainNoHistory, this.f1131i);
            obtainNoHistory.recycle();
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            boolean z2 = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (!(a3 && z2)) {
                z = false;
            }
            return z;
        }

        private boolean m1301b(View view, MotionEvent motionEvent) {
            int[] iArr = this.f1132j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            return true;
        }

        private void m1302d() {
            if (this.f1128f != null) {
                this.f1126d.removeCallbacks(this.f1128f);
            }
            if (this.f1127e != null) {
                this.f1126d.removeCallbacks(this.f1127e);
            }
        }

        private void m1303e() {
            m1302d();
            View view = this.f1126d;
            if (view.isEnabled() && !view.isLongClickable() && m1305b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                this.f1129g = true;
                this.f1130h = true;
            }
        }

        public abstract ap m1304a();

        protected boolean m1305b() {
            ap a = m1304a();
            if (!(a == null || a.m2371k())) {
                a.m2357c();
            }
            return true;
        }

        protected boolean m1306c() {
            ap a = m1304a();
            if (a != null && a.m2371k()) {
                a.m2369i();
            }
            return true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean b;
            boolean z = this.f1129g;
            if (z) {
                b = this.f1130h ? m1300b(motionEvent) : m1300b(motionEvent) || !m1306c();
            } else {
                boolean z2 = m1296a(motionEvent) && m1305b();
                if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.f1126d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                b = z2;
            }
            this.f1129g = b;
            return b || z;
        }
    }

    /* renamed from: android.support.v7.widget.ap.1 */
    class C05711 extends C0433b {
        final /* synthetic */ ap f1828a;

        public ap m2326a() {
            return this.f1828a;
        }
    }

    /* renamed from: android.support.v7.widget.ap.2 */
    class C05722 implements Runnable {
        final /* synthetic */ ap f1829a;

        C05722(ap apVar) {
            this.f1829a = apVar;
        }

        public void run() {
            View e = this.f1829a.m2361e();
            if (e != null && e.getWindowToken() != null) {
                this.f1829a.m2357c();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ap.3 */
    class C05733 implements OnItemSelectedListener {
        final /* synthetic */ ap f1830a;

        C05733(ap apVar) {
            this.f1830a = apVar;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                C0574a a = this.f1830a.f1864g;
                if (a != null) {
                    a.f1840g = false;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: android.support.v7.widget.ap.a */
    private static class C0574a extends aq {
        private boolean f1840g;
        private boolean f1841h;
        private boolean f1842i;
        private ViewPropertyAnimatorCompat f1843j;
        private ListViewAutoScrollHelper f1844k;

        public C0574a(Context context, boolean z) {
            super(context, null, C0417R.attr.dropDownListViewStyle);
            this.f1841h = z;
            setCacheColorHint(0);
        }

        private void m2335a(View view, int i) {
            performItemClick(view, i, getItemIdAtPosition(i));
        }

        private void m2336a(View view, int i, float f, float f2) {
            this.f1842i = true;
            if (VERSION.SDK_INT >= 21) {
                drawableHotspotChanged(f, f2);
            }
            if (!isPressed()) {
                setPressed(true);
            }
            layoutChildren();
            if (this.f != -1) {
                View childAt = getChildAt(this.f - getFirstVisiblePosition());
                if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                    childAt.setPressed(false);
                }
            }
            this.f = i;
            float left = f - ((float) view.getLeft());
            float top = f2 - ((float) view.getTop());
            if (VERSION.SDK_INT >= 21) {
                view.drawableHotspotChanged(left, top);
            }
            if (!view.isPressed()) {
                view.setPressed(true);
            }
            m2329a(i, view, f, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        private void m2338d() {
            this.f1842i = false;
            setPressed(false);
            drawableStateChanged();
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(false);
            }
            if (this.f1843j != null) {
                this.f1843j.cancel();
                this.f1843j = null;
            }
        }

        protected boolean m2339a() {
            return this.f1842i || super.m2331a();
        }

        public boolean m2340a(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            switch (actionMasked) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    z = false;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    z = true;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    z = false;
                    z2 = false;
                    break;
                default:
                    z = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    m2336a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                    if (actionMasked == 1) {
                        m2335a(childAt, pointToPosition);
                    }
                    z = false;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                m2338d();
            }
            if (z2) {
                if (this.f1844k == null) {
                    this.f1844k = new ListViewAutoScrollHelper(this);
                }
                this.f1844k.setEnabled(true);
                this.f1844k.onTouch(this, motionEvent);
            } else if (this.f1844k != null) {
                this.f1844k.setEnabled(false);
            }
            return z2;
        }

        public boolean hasFocus() {
            return this.f1841h || super.hasFocus();
        }

        public boolean hasWindowFocus() {
            return this.f1841h || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f1841h || super.isFocused();
        }

        public boolean isInTouchMode() {
            return (this.f1841h && this.f1840g) || super.isInTouchMode();
        }
    }

    /* renamed from: android.support.v7.widget.ap.c */
    private class C0577c implements Runnable {
        final /* synthetic */ ap f1847a;

        private C0577c(ap apVar) {
            this.f1847a = apVar;
        }

        public void run() {
            this.f1847a.m2370j();
        }
    }

    /* renamed from: android.support.v7.widget.ap.d */
    private class C0578d extends DataSetObserver {
        final /* synthetic */ ap f1848a;

        private C0578d(ap apVar) {
            this.f1848a = apVar;
        }

        public void onChanged() {
            if (this.f1848a.m2371k()) {
                this.f1848a.m2357c();
            }
        }

        public void onInvalidated() {
            this.f1848a.m2369i();
        }
    }

    /* renamed from: android.support.v7.widget.ap.e */
    private class C0579e implements OnScrollListener {
        final /* synthetic */ ap f1849a;

        private C0579e(ap apVar) {
            this.f1849a = apVar;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f1849a.m2372l() && this.f1849a.f1862e.getContentView() != null) {
                this.f1849a.f1856C.removeCallbacks(this.f1849a.f1881x);
                this.f1849a.f1881x.run();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ap.f */
    private class C0580f implements OnTouchListener {
        final /* synthetic */ ap f1850a;

        private C0580f(ap apVar) {
            this.f1850a = apVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f1850a.f1862e != null && this.f1850a.f1862e.isShowing() && x >= 0 && x < this.f1850a.f1862e.getWidth() && y >= 0 && y < this.f1850a.f1862e.getHeight()) {
                this.f1850a.f1856C.postDelayed(this.f1850a.f1881x, 250);
            } else if (action == 1) {
                this.f1850a.f1856C.removeCallbacks(this.f1850a.f1881x);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.ap.g */
    private class C0581g implements Runnable {
        final /* synthetic */ ap f1851a;

        private C0581g(ap apVar) {
            this.f1851a = apVar;
        }

        public void run() {
            if (this.f1851a.f1864g != null && ViewCompat.isAttachedToWindow(this.f1851a.f1864g) && this.f1851a.f1864g.getCount() > this.f1851a.f1864g.getChildCount() && this.f1851a.f1864g.getChildCount() <= this.f1851a.f1860b) {
                this.f1851a.f1862e.setInputMethodMode(2);
                this.f1851a.m2357c();
            }
        }
    }

    static {
        try {
            f1852a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f1853c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public ap(Context context) {
        this(context, null, C0417R.attr.listPopupWindowStyle);
    }

    public ap(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ap(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1865h = -2;
        this.f1866i = -2;
        this.f1869l = AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE;
        this.f1871n = 0;
        this.f1872o = false;
        this.f1873p = false;
        this.f1860b = Integer.MAX_VALUE;
        this.f1875r = 0;
        this.f1881x = new C0581g();
        this.f1882y = new C0580f();
        this.f1883z = new C0579e();
        this.f1854A = new C0577c();
        this.f1857D = new Rect();
        this.f1861d = context;
        this.f1856C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0417R.styleable.ListPopupWindow, i, i2);
        this.f1867j = obtainStyledAttributes.getDimensionPixelOffset(C0417R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1868k = obtainStyledAttributes.getDimensionPixelOffset(C0417R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1868k != 0) {
            this.f1870m = true;
        }
        obtainStyledAttributes.recycle();
        this.f1862e = new C0622r(context, attributeSet, i);
        this.f1862e.setInputMethodMode(1);
        this.f1859F = TextUtilsCompat.getLayoutDirectionFromLocale(this.f1861d.getResources().getConfiguration().locale);
    }

    private int m2341a(View view, int i, boolean z) {
        if (f1853c != null) {
            try {
                return ((Integer) f1853c.invoke(this.f1862e, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1862e.getMaxAvailableHeight(view, i);
    }

    private void m2343a() {
        if (this.f1874q != null) {
            ViewParent parent = this.f1874q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1874q);
            }
        }
    }

    private int m2344b() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.f1864g == null) {
            Context context = this.f1861d;
            this.f1855B = new C05722(this);
            this.f1864g = new C0574a(context, !this.f1858E);
            if (this.f1878u != null) {
                this.f1864g.setSelector(this.f1878u);
            }
            this.f1864g.setAdapter(this.f1863f);
            this.f1864g.setOnItemClickListener(this.f1879v);
            this.f1864g.setFocusable(true);
            this.f1864g.setFocusableInTouchMode(true);
            this.f1864g.setOnItemSelectedListener(new C05733(this));
            this.f1864g.setOnScrollListener(this.f1883z);
            if (this.f1880w != null) {
                this.f1864g.setOnItemSelectedListener(this.f1880w);
            }
            View view2 = this.f1864g;
            View view3 = this.f1874q;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f1875r) {
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f1875r);
                        break;
                }
                if (this.f1866i >= 0) {
                    i = this.f1866i;
                    i2 = LinearLayoutManager.INVALID_OFFSET;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.f1862e.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f1862e.getContentView();
            view = this.f1874q;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f1862e.getBackground();
        if (background != null) {
            background.getPadding(this.f1857D);
            i2 = this.f1857D.top + this.f1857D.bottom;
            if (this.f1870m) {
                i4 = i2;
            } else {
                this.f1868k = -this.f1857D.top;
                i4 = i2;
            }
        } else {
            this.f1857D.setEmpty();
            i4 = 0;
        }
        if (this.f1862e.getInputMethodMode() != 2) {
            z = false;
        }
        i = m2341a(m2361e(), this.f1868k, z);
        if (this.f1872o || this.f1865h == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.f1866i) {
            case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1861d.getResources().getDisplayMetrics().widthPixels - (this.f1857D.left + this.f1857D.right), LinearLayoutManager.INVALID_OFFSET);
                break;
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1861d.getResources().getDisplayMetrics().widthPixels - (this.f1857D.left + this.f1857D.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1866i, 1073741824);
                break;
        }
        i2 = this.f1864g.m2327a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += i4;
        }
        return i2 + i3;
    }

    private void m2346b(boolean z) {
        if (f1852a != null) {
            try {
                f1852a.invoke(this.f1862e, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void m2349a(int i) {
        this.f1875r = i;
    }

    public void m2350a(Drawable drawable) {
        this.f1862e.setBackgroundDrawable(drawable);
    }

    public void m2351a(View view) {
        this.f1877t = view;
    }

    public void m2352a(OnItemClickListener onItemClickListener) {
        this.f1879v = onItemClickListener;
    }

    public void m2353a(ListAdapter listAdapter) {
        if (this.f1876s == null) {
            this.f1876s = new C0578d();
        } else if (this.f1863f != null) {
            this.f1863f.unregisterDataSetObserver(this.f1876s);
        }
        this.f1863f = listAdapter;
        if (this.f1863f != null) {
            listAdapter.registerDataSetObserver(this.f1876s);
        }
        if (this.f1864g != null) {
            this.f1864g.setAdapter(this.f1863f);
        }
    }

    public void m2354a(OnDismissListener onDismissListener) {
        this.f1862e.setOnDismissListener(onDismissListener);
    }

    public void m2355a(boolean z) {
        this.f1858E = z;
        this.f1862e.setFocusable(z);
    }

    public void m2356b(int i) {
        this.f1867j = i;
    }

    public void m2357c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int b = m2344b();
        boolean l = m2372l();
        PopupWindowCompat.setWindowLayoutType(this.f1862e, this.f1869l);
        if (this.f1862e.isShowing()) {
            int i2;
            int width = this.f1866i == -1 ? -1 : this.f1866i == -2 ? m2361e().getWidth() : this.f1866i;
            if (this.f1865h == -1) {
                if (!l) {
                    b = -1;
                }
                if (l) {
                    this.f1862e.setWidth(this.f1866i == -1 ? -1 : 0);
                    this.f1862e.setHeight(0);
                    i2 = b;
                } else {
                    this.f1862e.setWidth(this.f1866i == -1 ? -1 : 0);
                    this.f1862e.setHeight(-1);
                    i2 = b;
                }
            } else {
                i2 = this.f1865h == -2 ? b : this.f1865h;
            }
            PopupWindow popupWindow = this.f1862e;
            if (!(this.f1873p || this.f1872o)) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.f1862e;
            View e = m2361e();
            b = this.f1867j;
            int i3 = this.f1868k;
            if (width < 0) {
                width = -1;
            }
            if (i2 >= 0) {
                i = i2;
            }
            popupWindow.update(e, b, i3, width, i);
            return;
        }
        int width2 = this.f1866i == -1 ? -1 : this.f1866i == -2 ? m2361e().getWidth() : this.f1866i;
        if (this.f1865h == -1) {
            b = -1;
        } else if (this.f1865h != -2) {
            b = this.f1865h;
        }
        this.f1862e.setWidth(width2);
        this.f1862e.setHeight(b);
        m2346b(true);
        popupWindow = this.f1862e;
        if (this.f1873p || this.f1872o) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.f1862e.setTouchInterceptor(this.f1882y);
        PopupWindowCompat.showAsDropDown(this.f1862e, m2361e(), this.f1867j, this.f1868k, this.f1871n);
        this.f1864g.setSelection(-1);
        if (!this.f1858E || this.f1864g.isInTouchMode()) {
            m2370j();
        }
        if (!this.f1858E) {
            this.f1856C.post(this.f1854A);
        }
    }

    public void m2358c(int i) {
        this.f1868k = i;
        this.f1870m = true;
    }

    public Drawable m2359d() {
        return this.f1862e.getBackground();
    }

    public void m2360d(int i) {
        this.f1871n = i;
    }

    public View m2361e() {
        return this.f1877t;
    }

    public void m2362e(int i) {
        this.f1866i = i;
    }

    public int m2363f() {
        return this.f1867j;
    }

    public void m2364f(int i) {
        Drawable background = this.f1862e.getBackground();
        if (background != null) {
            background.getPadding(this.f1857D);
            this.f1866i = (this.f1857D.left + this.f1857D.right) + i;
            return;
        }
        m2362e(i);
    }

    public int m2365g() {
        return !this.f1870m ? 0 : this.f1868k;
    }

    public void m2366g(int i) {
        this.f1862e.setInputMethodMode(i);
    }

    public int m2367h() {
        return this.f1866i;
    }

    public void m2368h(int i) {
        C0574a c0574a = this.f1864g;
        if (m2371k() && c0574a != null) {
            c0574a.f1840g = false;
            c0574a.setSelection(i);
            if (VERSION.SDK_INT >= 11 && c0574a.getChoiceMode() != 0) {
                c0574a.setItemChecked(i, true);
            }
        }
    }

    public void m2369i() {
        this.f1862e.dismiss();
        m2343a();
        this.f1862e.setContentView(null);
        this.f1864g = null;
        this.f1856C.removeCallbacks(this.f1881x);
    }

    public void m2370j() {
        C0574a c0574a = this.f1864g;
        if (c0574a != null) {
            c0574a.f1840g = true;
            c0574a.requestLayout();
        }
    }

    public boolean m2371k() {
        return this.f1862e.isShowing();
    }

    public boolean m2372l() {
        return this.f1862e.getInputMethodMode() == 2;
    }

    public ListView m2373m() {
        return this.f1864g;
    }
}
