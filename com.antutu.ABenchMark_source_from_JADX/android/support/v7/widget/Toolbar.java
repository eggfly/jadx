package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.C0355a.C0352a;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0423c;
import android.support.v7.view.C0430g;
import android.support.v7.view.menu.C0441l;
import android.support.v7.view.menu.C0441l.C0342a;
import android.support.v7.view.menu.C0447f;
import android.support.v7.view.menu.C0447f.C0351a;
import android.support.v7.view.menu.C0450h;
import android.support.v7.view.menu.C0462p;
import android.support.v7.widget.ActionMenuView.C0485e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import com.antutu.utils.widget.SystemBarTintManager;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;

public class Toolbar extends ViewGroup {
    private boolean f1714A;
    private final ArrayList<View> f1715B;
    private final ArrayList<View> f1716C;
    private final int[] f1717D;
    private C0399c f1718E;
    private final C0485e f1719F;
    private bi f1720G;
    private ActionMenuPresenter f1721H;
    private C0552a f1722I;
    private C0342a f1723J;
    private C0351a f1724K;
    private boolean f1725L;
    private final Runnable f1726M;
    private final C0616l f1727N;
    View f1728a;
    private ActionMenuView f1729b;
    private TextView f1730c;
    private TextView f1731d;
    private ImageButton f1732e;
    private ImageView f1733f;
    private Drawable f1734g;
    private CharSequence f1735h;
    private ImageButton f1736i;
    private Context f1737j;
    private int f1738k;
    private int f1739l;
    private int f1740m;
    private int f1741n;
    private int f1742o;
    private int f1743p;
    private int f1744q;
    private int f1745r;
    private int f1746s;
    private final ax f1747t;
    private int f1748u;
    private CharSequence f1749v;
    private CharSequence f1750w;
    private int f1751x;
    private int f1752y;
    private boolean f1753z;

    /* renamed from: android.support.v7.widget.Toolbar.c */
    public interface C0399c {
        boolean m1100a(MenuItem menuItem);
    }

    /* renamed from: android.support.v7.widget.Toolbar.1 */
    class C05481 implements C0485e {
        final /* synthetic */ Toolbar f1705a;

        C05481(Toolbar toolbar) {
            this.f1705a = toolbar;
        }

        public boolean m2100a(MenuItem menuItem) {
            return this.f1705a.f1718E != null ? this.f1705a.f1718E.m1100a(menuItem) : false;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.2 */
    class C05492 implements Runnable {
        final /* synthetic */ Toolbar f1706a;

        C05492(Toolbar toolbar) {
            this.f1706a = toolbar;
        }

        public void run() {
            this.f1706a.m2146d();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.3 */
    class C05503 implements OnClickListener {
        final /* synthetic */ Toolbar f1707a;

        C05503(Toolbar toolbar) {
            this.f1707a = toolbar;
        }

        public void onClick(View view) {
            this.f1707a.m2150h();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f1708a;
        boolean f1709b;

        /* renamed from: android.support.v7.widget.Toolbar.SavedState.1 */
        static class C05511 implements Creator<SavedState> {
            C05511() {
            }

            public SavedState m2101a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2102a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2101a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2102a(i);
            }
        }

        static {
            CREATOR = new C05511();
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1708a = parcel.readInt();
            this.f1709b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1708a);
            parcel.writeInt(this.f1709b ? 1 : 0);
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.a */
    private class C0552a implements C0441l {
        C0447f f1710a;
        C0450h f1711b;
        final /* synthetic */ Toolbar f1712c;

        private C0552a(Toolbar toolbar) {
            this.f1712c = toolbar;
        }

        public void m2103a(Context context, C0447f c0447f) {
            if (!(this.f1710a == null || this.f1711b == null)) {
                this.f1710a.m1416d(this.f1711b);
            }
            this.f1710a = c0447f;
        }

        public void m2104a(C0447f c0447f, boolean z) {
        }

        public void m2105a(boolean z) {
            Object obj = null;
            if (this.f1711b != null) {
                if (this.f1710a != null) {
                    int size = this.f1710a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f1710a.getItem(i) == this.f1711b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    m2109b(this.f1710a, this.f1711b);
                }
            }
        }

        public boolean m2106a(C0447f c0447f, C0450h c0450h) {
            this.f1712c.m2133p();
            if (this.f1712c.f1736i.getParent() != this.f1712c) {
                this.f1712c.addView(this.f1712c.f1736i);
            }
            this.f1712c.f1728a = c0450h.getActionView();
            this.f1711b = c0450h;
            if (this.f1712c.f1728a.getParent() != this.f1712c) {
                LayoutParams i = this.f1712c.m2151i();
                i.a = GravityCompat.START | (this.f1712c.f1741n & 112);
                i.f1713b = 2;
                this.f1712c.f1728a.setLayoutParams(i);
                this.f1712c.addView(this.f1712c.f1728a);
            }
            this.f1712c.m2152j();
            this.f1712c.requestLayout();
            c0450h.m1450e(true);
            if (this.f1712c.f1728a instanceof C0423c) {
                ((C0423c) this.f1712c.f1728a).m1238a();
            }
            return true;
        }

        public boolean m2107a(C0462p c0462p) {
            return false;
        }

        public boolean m2108b() {
            return false;
        }

        public boolean m2109b(C0447f c0447f, C0450h c0450h) {
            if (this.f1712c.f1728a instanceof C0423c) {
                ((C0423c) this.f1712c.f1728a).m1239b();
            }
            this.f1712c.removeView(this.f1712c.f1728a);
            this.f1712c.removeView(this.f1712c.f1736i);
            this.f1712c.f1728a = null;
            this.f1712c.m2153k();
            this.f1711b = null;
            this.f1712c.requestLayout();
            c0450h.m1450e(false);
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.b */
    public static class C0553b extends C0352a {
        int f1713b;

        public C0553b(int i, int i2) {
            super(i, i2);
            this.f1713b = 0;
            this.a = 8388627;
        }

        public C0553b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1713b = 0;
        }

        public C0553b(C0352a c0352a) {
            super(c0352a);
            this.f1713b = 0;
        }

        public C0553b(C0553b c0553b) {
            super((C0352a) c0553b);
            this.f1713b = 0;
            this.f1713b = c0553b.f1713b;
        }

        public C0553b(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1713b = 0;
        }

        public C0553b(MarginLayoutParams marginLayoutParams) {
            super((LayoutParams) marginLayoutParams);
            this.f1713b = 0;
            m2110a(marginLayoutParams);
        }

        void m2110a(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0417R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1747t = new ax();
        this.f1748u = 8388627;
        this.f1715B = new ArrayList();
        this.f1716C = new ArrayList();
        this.f1717D = new int[2];
        this.f1719F = new C05481(this);
        this.f1726M = new C05492(this);
        bh a = bh.m2502a(getContext(), attributeSet, C0417R.styleable.Toolbar, i, 0);
        this.f1739l = a.m2518g(C0417R.styleable.Toolbar_titleTextAppearance, 0);
        this.f1740m = a.m2518g(C0417R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f1748u = a.m2510c(C0417R.styleable.Toolbar_android_gravity, this.f1748u);
        this.f1741n = 48;
        int d = a.m2512d(C0417R.styleable.Toolbar_titleMargins, 0);
        this.f1746s = d;
        this.f1745r = d;
        this.f1744q = d;
        this.f1743p = d;
        d = a.m2512d(C0417R.styleable.Toolbar_titleMarginStart, -1);
        if (d >= 0) {
            this.f1743p = d;
        }
        d = a.m2512d(C0417R.styleable.Toolbar_titleMarginEnd, -1);
        if (d >= 0) {
            this.f1744q = d;
        }
        d = a.m2512d(C0417R.styleable.Toolbar_titleMarginTop, -1);
        if (d >= 0) {
            this.f1745r = d;
        }
        d = a.m2512d(C0417R.styleable.Toolbar_titleMarginBottom, -1);
        if (d >= 0) {
            this.f1746s = d;
        }
        this.f1742o = a.m2514e(C0417R.styleable.Toolbar_maxButtonHeight, -1);
        d = a.m2512d(C0417R.styleable.Toolbar_contentInsetStart, LinearLayoutManager.INVALID_OFFSET);
        int d2 = a.m2512d(C0417R.styleable.Toolbar_contentInsetEnd, LinearLayoutManager.INVALID_OFFSET);
        this.f1747t.m2456b(a.m2514e(C0417R.styleable.Toolbar_contentInsetLeft, 0), a.m2514e(C0417R.styleable.Toolbar_contentInsetRight, 0));
        if (!(d == LinearLayoutManager.INVALID_OFFSET && d2 == LinearLayoutManager.INVALID_OFFSET)) {
            this.f1747t.m2453a(d, d2);
        }
        this.f1734g = a.m2505a(C0417R.styleable.Toolbar_collapseIcon);
        this.f1735h = a.m2511c(C0417R.styleable.Toolbar_collapseContentDescription);
        CharSequence c = a.m2511c(C0417R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = a.m2511c(C0417R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f1737j = getContext();
        setPopupTheme(a.m2518g(C0417R.styleable.Toolbar_popupTheme, 0));
        Drawable a2 = a.m2505a(C0417R.styleable.Toolbar_navigationIcon);
        if (a2 != null) {
            setNavigationIcon(a2);
        }
        c = a.m2511c(C0417R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a2 = a.m2505a(C0417R.styleable.Toolbar_logo);
        if (a2 != null) {
            setLogo(a2);
        }
        c = a.m2511c(C0417R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (a.m2517f(C0417R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(a.m2508b(C0417R.styleable.Toolbar_titleTextColor, -1));
        }
        if (a.m2517f(C0417R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.m2508b(C0417R.styleable.Toolbar_subtitleTextColor, -1));
        }
        a.m2506a();
        this.f1727N = C0616l.m2672a();
    }

    private int m2111a(int i) {
        int i2 = i & 112;
        switch (i2) {
            case SpdyProtocol.CUSTOM /*16*/:
            case C1692R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
            case C1692R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                return i2;
            default:
                return this.f1748u & 112;
        }
    }

    private int m2112a(View view, int i) {
        C0553b c0553b = (C0553b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (m2111a(c0553b.a)) {
            case C1692R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                return getPaddingTop() - i2;
            case C1692R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0553b.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < c0553b.topMargin) {
                    i3 = c0553b.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < c0553b.bottomMargin ? Math.max(0, i2 - (c0553b.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int m2113a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private int m2114a(View view, int i, int[] iArr, int i2) {
        C0553b c0553b = (C0553b) view.getLayoutParams();
        int i3 = c0553b.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = m2112a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (c0553b.rightMargin + measuredWidth) + max;
    }

    private int m2115a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            C0553b c0553b = (C0553b) view.getLayoutParams();
            i6 = c0553b.leftMargin - i6;
            i = c0553b.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private void m2117a(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void m2118a(View view, boolean z) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m2151i();
        } else if (checkLayoutParams(layoutParams)) {
            C0553b c0553b = (C0553b) layoutParams;
        } else {
            layoutParams = m2137a(layoutParams);
        }
        layoutParams.f1713b = 1;
        if (!z || this.f1728a == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.f1716C.add(view);
    }

    private void m2119a(List<View> list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ViewCompat.getLayoutDirection(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        list.clear();
        C0553b c0553b;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                c0553b = (C0553b) childAt.getLayoutParams();
                if (c0553b.f1713b == 0 && m2120a(childAt) && m2121b(c0553b.a) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            c0553b = (C0553b) childAt2.getLayoutParams();
            if (c0553b.f1713b == 0 && m2120a(childAt2) && m2121b(c0553b.a) == absoluteGravity) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private boolean m2120a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int m2121b(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        switch (absoluteGravity) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return absoluteGravity;
            default:
                return layoutDirection == 1 ? 5 : 3;
        }
    }

    private int m2122b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
    }

    private int m2123b(View view, int i, int[] iArr, int i2) {
        C0553b c0553b = (C0553b) view.getLayoutParams();
        int i3 = c0553b.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = m2112a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (c0553b.leftMargin + measuredWidth);
    }

    private int m2125c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private boolean m2128d(View view) {
        return view.getParent() == this || this.f1716C.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new C0430g(getContext());
    }

    private void m2129l() {
        if (this.f1733f == null) {
            this.f1733f = new ImageView(getContext());
        }
    }

    private void m2130m() {
        m2131n();
        if (this.f1729b.m1640d() == null) {
            C0447f c0447f = (C0447f) this.f1729b.getMenu();
            if (this.f1722I == null) {
                this.f1722I = new C0552a();
            }
            this.f1729b.setExpandedActionViewsExclusive(true);
            c0447f.m1398a(this.f1722I, this.f1737j);
        }
    }

    private void m2131n() {
        if (this.f1729b == null) {
            this.f1729b = new ActionMenuView(getContext());
            this.f1729b.setPopupTheme(this.f1738k);
            this.f1729b.setOnMenuItemClickListener(this.f1719F);
            this.f1729b.m1632a(this.f1723J, this.f1724K);
            LayoutParams i = m2151i();
            i.a = GravityCompat.END | (this.f1741n & 112);
            this.f1729b.setLayoutParams(i);
            m2118a(this.f1729b, false);
        }
    }

    private void m2132o() {
        if (this.f1732e == null) {
            this.f1732e = new ImageButton(getContext(), null, C0417R.attr.toolbarNavigationButtonStyle);
            LayoutParams i = m2151i();
            i.a = GravityCompat.START | (this.f1741n & 112);
            this.f1732e.setLayoutParams(i);
        }
    }

    private void m2133p() {
        if (this.f1736i == null) {
            this.f1736i = new ImageButton(getContext(), null, C0417R.attr.toolbarNavigationButtonStyle);
            this.f1736i.setImageDrawable(this.f1734g);
            this.f1736i.setContentDescription(this.f1735h);
            LayoutParams i = m2151i();
            i.a = GravityCompat.START | (this.f1741n & 112);
            i.f1713b = 2;
            this.f1736i.setLayoutParams(i);
            this.f1736i.setOnClickListener(new C05503(this));
        }
    }

    private void m2134q() {
        removeCallbacks(this.f1726M);
        post(this.f1726M);
    }

    private boolean m2135r() {
        if (!this.f1725L) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2120a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    public C0553b m2136a(AttributeSet attributeSet) {
        return new C0553b(getContext(), attributeSet);
    }

    protected C0553b m2137a(LayoutParams layoutParams) {
        return layoutParams instanceof C0553b ? new C0553b((C0553b) layoutParams) : layoutParams instanceof C0352a ? new C0553b((C0352a) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0553b((MarginLayoutParams) layoutParams) : new C0553b(layoutParams);
    }

    public void m2138a(int i, int i2) {
        this.f1747t.m2453a(i, i2);
    }

    public void m2139a(Context context, int i) {
        this.f1739l = i;
        if (this.f1730c != null) {
            this.f1730c.setTextAppearance(context, i);
        }
    }

    public void m2140a(C0447f c0447f, ActionMenuPresenter actionMenuPresenter) {
        if (c0447f != null || this.f1729b != null) {
            m2131n();
            C0447f d = this.f1729b.m1640d();
            if (d != c0447f) {
                if (d != null) {
                    d.m1408b(this.f1721H);
                    d.m1408b(this.f1722I);
                }
                if (this.f1722I == null) {
                    this.f1722I = new C0552a();
                }
                actionMenuPresenter.m1592c(true);
                if (c0447f != null) {
                    c0447f.m1398a((C0441l) actionMenuPresenter, this.f1737j);
                    c0447f.m1398a(this.f1722I, this.f1737j);
                } else {
                    actionMenuPresenter.m1579a(this.f1737j, null);
                    this.f1722I.m2103a(this.f1737j, null);
                    actionMenuPresenter.m1585a(true);
                    this.f1722I.m2105a(true);
                }
                this.f1729b.setPopupTheme(this.f1738k);
                this.f1729b.setPresenter(actionMenuPresenter);
                this.f1721H = actionMenuPresenter;
            }
        }
    }

    public void m2141a(C0342a c0342a, C0351a c0351a) {
        this.f1723J = c0342a;
        this.f1724K = c0351a;
        if (this.f1729b != null) {
            this.f1729b.m1632a(c0342a, c0351a);
        }
    }

    public boolean m2142a() {
        return getVisibility() == 0 && this.f1729b != null && this.f1729b.m1633a();
    }

    public void m2143b(Context context, int i) {
        this.f1740m = i;
        if (this.f1731d != null) {
            this.f1731d.setTextAppearance(context, i);
        }
    }

    public boolean m2144b() {
        return this.f1729b != null && this.f1729b.m1643g();
    }

    public boolean m2145c() {
        return this.f1729b != null && this.f1729b.m1644h();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0553b);
    }

    public boolean m2146d() {
        return this.f1729b != null && this.f1729b.m1641e();
    }

    public boolean m2147e() {
        return this.f1729b != null && this.f1729b.m1642f();
    }

    public void m2148f() {
        if (this.f1729b != null) {
            this.f1729b.m1645i();
        }
    }

    public boolean m2149g() {
        return (this.f1722I == null || this.f1722I.f1711b == null) ? false : true;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m2151i();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m2136a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m2137a(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.f1747t.m2458d();
    }

    public int getContentInsetLeft() {
        return this.f1747t.m2452a();
    }

    public int getContentInsetRight() {
        return this.f1747t.m2455b();
    }

    public int getContentInsetStart() {
        return this.f1747t.m2457c();
    }

    public Drawable getLogo() {
        return this.f1733f != null ? this.f1733f.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.f1733f != null ? this.f1733f.getContentDescription() : null;
    }

    public Menu getMenu() {
        m2130m();
        return this.f1729b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.f1732e != null ? this.f1732e.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.f1732e != null ? this.f1732e.getDrawable() : null;
    }

    public Drawable getOverflowIcon() {
        m2130m();
        return this.f1729b.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.f1738k;
    }

    public CharSequence getSubtitle() {
        return this.f1750w;
    }

    public CharSequence getTitle() {
        return this.f1749v;
    }

    public ai getWrapper() {
        if (this.f1720G == null) {
            this.f1720G = new bi(this, true);
        }
        return this.f1720G;
    }

    public void m2150h() {
        C0450h c0450h = this.f1722I == null ? null : this.f1722I.f1711b;
        if (c0450h != null) {
            c0450h.collapseActionView();
        }
    }

    protected C0553b m2151i() {
        return new C0553b(-2, -2);
    }

    void m2152j() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((C0553b) childAt.getLayoutParams()).f1713b == 2 || childAt == this.f1729b)) {
                removeViewAt(childCount);
                this.f1716C.add(childAt);
            }
        }
    }

    void m2153k() {
        for (int size = this.f1716C.size() - 1; size >= 0; size--) {
            addView((View) this.f1716C.get(size));
        }
        this.f1716C.clear();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1726M);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.f1714A = false;
        }
        if (!this.f1714A) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1714A = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1714A = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        Object obj = ViewCompat.getLayoutDirection(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.f1717D;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (!m2120a(this.f1732e)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = m2123b(this.f1732e, i8, iArr, minimumHeight);
            i5 = paddingLeft;
        } else {
            i5 = m2114a(this.f1732e, paddingLeft, iArr, minimumHeight);
        }
        if (m2120a(this.f1736i)) {
            if (obj != null) {
                i8 = m2123b(this.f1736i, i8, iArr, minimumHeight);
            } else {
                i5 = m2114a(this.f1736i, i5, iArr, minimumHeight);
            }
        }
        if (m2120a(this.f1729b)) {
            if (obj != null) {
                i5 = m2114a(this.f1729b, i5, iArr, minimumHeight);
            } else {
                i8 = m2123b(this.f1729b, i8, iArr, minimumHeight);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (m2120a(this.f1728a)) {
            if (obj != null) {
                i8 = m2123b(this.f1728a, i8, iArr, minimumHeight);
            } else {
                i5 = m2114a(this.f1728a, i5, iArr, minimumHeight);
            }
        }
        if (!m2120a(this.f1733f)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = m2123b(this.f1733f, i8, iArr, minimumHeight);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = m2114a(this.f1733f, i5, iArr, minimumHeight);
        }
        boolean a = m2120a(this.f1730c);
        boolean a2 = m2120a(this.f1731d);
        i5 = 0;
        if (a) {
            C0553b c0553b = (C0553b) this.f1730c.getLayoutParams();
            i5 = 0 + (c0553b.bottomMargin + (c0553b.topMargin + this.f1730c.getMeasuredHeight()));
        }
        if (a2) {
            c0553b = (C0553b) this.f1731d.getLayoutParams();
            measuredHeight = (c0553b.bottomMargin + (c0553b.topMargin + this.f1731d.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (a || a2) {
            int paddingTop2;
            c0553b = (C0553b) (a ? this.f1730c : this.f1731d).getLayoutParams();
            C0553b c0553b2 = (C0553b) (a2 ? this.f1731d : this.f1730c).getLayoutParams();
            Object obj2 = ((!a || this.f1730c.getMeasuredWidth() <= 0) && (!a2 || this.f1731d.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.f1748u & 112) {
                case C1692R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    paddingTop2 = (c0553b.topMargin + getPaddingTop()) + this.f1745r;
                    break;
                case C1692R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                    paddingTop2 = (((height - paddingBottom) - c0553b2.bottomMargin) - this.f1746s) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < c0553b.topMargin + this.f1745r) {
                        i8 = c0553b.topMargin + this.f1745r;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        i8 = measuredHeight < c0553b.bottomMargin + this.f1746s ? Math.max(0, paddingTop2 - ((c0553b2.bottomMargin + this.f1746s) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.f1743p : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (a) {
                    c0553b = (C0553b) this.f1730c.getLayoutParams();
                    measuredWidth = i5 - this.f1730c.getMeasuredWidth();
                    i6 = this.f1730c.getMeasuredHeight() + paddingTop2;
                    this.f1730c.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + c0553b.bottomMargin;
                    i6 = measuredWidth - this.f1744q;
                } else {
                    i6 = i5;
                }
                if (a2) {
                    c0553b = (C0553b) this.f1731d.getLayoutParams();
                    measuredWidth = c0553b.topMargin + paddingTop2;
                    measuredHeight = this.f1731d.getMeasuredHeight() + measuredWidth;
                    this.f1731d.layout(i5 - this.f1731d.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i8 = c0553b.bottomMargin + measuredHeight;
                    i8 = i5 - this.f1744q;
                } else {
                    i8 = i5;
                }
                i6 = obj2 != null ? Math.min(i6, i8) : i5;
            } else {
                i8 = (obj2 != null ? this.f1743p : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (a) {
                    c0553b = (C0553b) this.f1730c.getLayoutParams();
                    i5 = this.f1730c.getMeasuredWidth() + i7;
                    measuredWidth = this.f1730c.getMeasuredHeight() + paddingTop2;
                    this.f1730c.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = c0553b.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.f1744q;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (a2) {
                    c0553b = (C0553b) this.f1731d.getLayoutParams();
                    i5 += c0553b.topMargin;
                    paddingTop2 = this.f1731d.getMeasuredWidth() + i7;
                    measuredHeight = this.f1731d.getMeasuredHeight() + i5;
                    this.f1731d.layout(i7, i5, paddingTop2, measuredHeight);
                    i8 = c0553b.bottomMargin + measuredHeight;
                    i8 = this.f1744q + paddingTop2;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        m2119a(this.f1715B, 3);
        int size = this.f1715B.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = m2114a((View) this.f1715B.get(measuredWidth), i5, iArr, minimumHeight);
        }
        m2119a(this.f1715B, 5);
        i7 = this.f1715B.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = m2123b((View) this.f1715B.get(measuredWidth), i6, iArr, minimumHeight);
        }
        m2119a(this.f1715B, 1);
        measuredWidth = m2115a(this.f1715B, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.f1715B.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = m2114a((View) this.f1715B.get(i5), measuredWidth, iArr, minimumHeight);
        }
        this.f1715B.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.f1717D;
        if (bl.m2591a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (m2120a(this.f1732e)) {
            m2117a(this.f1732e, i, 0, i2, 0, this.f1742o);
            i7 = this.f1732e.getMeasuredWidth() + m2122b(this.f1732e);
            max = Math.max(0, this.f1732e.getMeasuredHeight() + m2125c(this.f1732e));
            i6 = bl.m2589a(0, ViewCompat.getMeasuredState(this.f1732e));
            i5 = max;
        }
        if (m2120a(this.f1736i)) {
            m2117a(this.f1736i, i, 0, i2, 0, this.f1742o);
            i7 = this.f1736i.getMeasuredWidth() + m2122b(this.f1736i);
            i5 = Math.max(i5, this.f1736i.getMeasuredHeight() + m2125c(this.f1736i));
            i6 = bl.m2589a(i6, ViewCompat.getMeasuredState(this.f1736i));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[i4] = Math.max(0, contentInsetStart - i7);
        i7 = 0;
        if (m2120a(this.f1729b)) {
            m2117a(this.f1729b, i, max2, i2, 0, this.f1742o);
            i7 = this.f1729b.getMeasuredWidth() + m2122b(this.f1729b);
            i5 = Math.max(i5, this.f1729b.getMeasuredHeight() + m2125c(this.f1729b));
            i6 = bl.m2589a(i6, ViewCompat.getMeasuredState(this.f1729b));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i7);
        iArr[i3] = Math.max(0, contentInsetStart - i7);
        if (m2120a(this.f1728a)) {
            max2 += m2113a(this.f1728a, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1728a.getMeasuredHeight() + m2125c(this.f1728a));
            i6 = bl.m2589a(i6, ViewCompat.getMeasuredState(this.f1728a));
        }
        if (m2120a(this.f1733f)) {
            max2 += m2113a(this.f1733f, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.f1733f.getMeasuredHeight() + m2125c(this.f1733f));
            i6 = bl.m2589a(i6, ViewCompat.getMeasuredState(this.f1733f));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((C0553b) childAt.getLayoutParams()).f1713b != 0) {
                i7 = i5;
                contentInsetStart = i8;
            } else if (m2120a(childAt)) {
                max2 += m2113a(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + m2125c(childAt));
                i7 = bl.m2589a(i5, ViewCompat.getMeasuredState(childAt));
                contentInsetStart = max;
            } else {
                i7 = i5;
                contentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i7 = 0;
        i6 = this.f1745r + this.f1746s;
        max = this.f1743p + this.f1744q;
        if (m2120a(this.f1730c)) {
            m2113a(this.f1730c, i, max2 + max, i2, i6, iArr);
            contentInsetStart = m2122b(this.f1730c) + this.f1730c.getMeasuredWidth();
            i7 = this.f1730c.getMeasuredHeight() + m2125c(this.f1730c);
            i5 = bl.m2589a(i5, ViewCompat.getMeasuredState(this.f1730c));
        }
        if (m2120a(this.f1731d)) {
            contentInsetStart = Math.max(contentInsetStart, m2113a(this.f1731d, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.f1731d.getMeasuredHeight() + m2125c(this.f1731d);
            i5 = bl.m2589a(i5, ViewCompat.getMeasuredState(this.f1731d));
        }
        contentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = ViewCompat.resolveSizeAndState(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, SystemBarTintManager.DEFAULT_TINT_COLOR & i5);
        i7 = ViewCompat.resolveSizeAndState(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (m2135r()) {
            i7 = 0;
        }
        setMeasuredDimension(contentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            Menu d = this.f1729b != null ? this.f1729b.m1640d() : null;
            if (!(savedState.f1708a == 0 || this.f1722I == null || d == null)) {
                MenuItem findItem = d.findItem(savedState.f1708a);
                if (findItem != null) {
                    MenuItemCompat.expandActionView(findItem);
                }
            }
            if (savedState.f1709b) {
                m2134q();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        ax axVar = this.f1747t;
        if (i != 1) {
            z = false;
        }
        axVar.m2454a(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f1722I == null || this.f1722I.f1711b == null)) {
            savedState.f1708a = this.f1722I.f1711b.getItemId();
        }
        savedState.f1709b = m2144b();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f1753z = false;
        }
        if (!this.f1753z) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1753z = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1753z = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f1725L = z;
        requestLayout();
    }

    public void setLogo(int i) {
        setLogo(this.f1727N.m2695a(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m2129l();
            if (!m2128d(this.f1733f)) {
                m2118a(this.f1733f, true);
            }
        } else if (this.f1733f != null && m2128d(this.f1733f)) {
            removeView(this.f1733f);
            this.f1716C.remove(this.f1733f);
        }
        if (this.f1733f != null) {
            this.f1733f.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2129l();
        }
        if (this.f1733f != null) {
            this.f1733f.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2132o();
        }
        if (this.f1732e != null) {
            this.f1732e.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.f1727N.m2695a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m2132o();
            if (!m2128d(this.f1732e)) {
                m2118a(this.f1732e, true);
            }
        } else if (this.f1732e != null && m2128d(this.f1732e)) {
            removeView(this.f1732e);
            this.f1716C.remove(this.f1732e);
        }
        if (this.f1732e != null) {
            this.f1732e.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m2132o();
        this.f1732e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(C0399c c0399c) {
        this.f1718E = c0399c;
    }

    public void setOverflowIcon(Drawable drawable) {
        m2130m();
        this.f1729b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f1738k != i) {
            this.f1738k = i;
            if (i == 0) {
                this.f1737j = getContext();
            } else {
                this.f1737j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1731d == null) {
                Context context = getContext();
                this.f1731d = new TextView(context);
                this.f1731d.setSingleLine();
                this.f1731d.setEllipsize(TruncateAt.END);
                if (this.f1740m != 0) {
                    this.f1731d.setTextAppearance(context, this.f1740m);
                }
                if (this.f1752y != 0) {
                    this.f1731d.setTextColor(this.f1752y);
                }
            }
            if (!m2128d(this.f1731d)) {
                m2118a(this.f1731d, true);
            }
        } else if (this.f1731d != null && m2128d(this.f1731d)) {
            removeView(this.f1731d);
            this.f1716C.remove(this.f1731d);
        }
        if (this.f1731d != null) {
            this.f1731d.setText(charSequence);
        }
        this.f1750w = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.f1752y = i;
        if (this.f1731d != null) {
            this.f1731d.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1730c == null) {
                Context context = getContext();
                this.f1730c = new TextView(context);
                this.f1730c.setSingleLine();
                this.f1730c.setEllipsize(TruncateAt.END);
                if (this.f1739l != 0) {
                    this.f1730c.setTextAppearance(context, this.f1739l);
                }
                if (this.f1751x != 0) {
                    this.f1730c.setTextColor(this.f1751x);
                }
            }
            if (!m2128d(this.f1730c)) {
                m2118a(this.f1730c, true);
            }
        } else if (this.f1730c != null && m2128d(this.f1730c)) {
            removeView(this.f1730c);
            this.f1716C.remove(this.f1730c);
        }
        if (this.f1730c != null) {
            this.f1730c.setText(charSequence);
        }
        this.f1749v = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.f1751x = i;
        if (this.f1730c != null) {
            this.f1730c.setTextColor(i);
        }
    }
}
