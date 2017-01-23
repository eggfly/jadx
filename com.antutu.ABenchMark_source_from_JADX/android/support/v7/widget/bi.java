package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.menu.C0440a;
import android.support.v7.view.menu.C0441l.C0342a;
import android.support.v7.view.menu.C0447f;
import android.support.v7.view.menu.C0447f.C0351a;
import android.support.v7.widget.Toolbar.C0553b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class bi implements ai {
    private Toolbar f1994a;
    private int f1995b;
    private View f1996c;
    private View f1997d;
    private Drawable f1998e;
    private Drawable f1999f;
    private Drawable f2000g;
    private boolean f2001h;
    private CharSequence f2002i;
    private CharSequence f2003j;
    private CharSequence f2004k;
    private Callback f2005l;
    private boolean f2006m;
    private ActionMenuPresenter f2007n;
    private int f2008o;
    private final C0616l f2009p;
    private int f2010q;
    private Drawable f2011r;

    /* renamed from: android.support.v7.widget.bi.1 */
    class C05931 implements OnClickListener {
        final C0440a f1989a;
        final /* synthetic */ bi f1990b;

        C05931(bi biVar) {
            this.f1990b = biVar;
            this.f1989a = new C0440a(this.f1990b.f1994a.getContext(), 0, 16908332, 0, 0, this.f1990b.f2002i);
        }

        public void onClick(View view) {
            if (this.f1990b.f2005l != null && this.f1990b.f2006m) {
                this.f1990b.f2005l.onMenuItemSelected(0, this.f1989a);
            }
        }
    }

    /* renamed from: android.support.v7.widget.bi.2 */
    class C05942 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ int f1991a;
        final /* synthetic */ bi f1992b;
        private boolean f1993c;

        C05942(bi biVar, int i) {
            this.f1992b = biVar;
            this.f1991a = i;
            this.f1993c = false;
        }

        public void onAnimationCancel(View view) {
            this.f1993c = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.f1993c) {
                this.f1992b.f1994a.setVisibility(this.f1991a);
            }
        }

        public void onAnimationStart(View view) {
            this.f1992b.f1994a.setVisibility(0);
        }
    }

    public bi(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0417R.string.abc_action_bar_up_description, C0417R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    }

    public bi(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2008o = 0;
        this.f2010q = 0;
        this.f1994a = toolbar;
        this.f2002i = toolbar.getTitle();
        this.f2003j = toolbar.getSubtitle();
        this.f2001h = this.f2002i != null;
        this.f2000g = toolbar.getNavigationIcon();
        if (z) {
            bh a = bh.m2502a(toolbar.getContext(), null, C0417R.styleable.ActionBar, C0417R.attr.actionBarStyle, 0);
            CharSequence c = a.m2511c(C0417R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                m2542b(c);
            }
            c = a.m2511c(C0417R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m2546c(c);
            }
            Drawable a2 = a.m2505a(C0417R.styleable.ActionBar_logo);
            if (a2 != null) {
                m2545c(a2);
            }
            a2 = a.m2505a(C0417R.styleable.ActionBar_icon);
            if (this.f2000g == null && a2 != null) {
                m2531a(a2);
            }
            a2 = a.m2505a(C0417R.styleable.ActionBar_homeAsUpIndicator);
            if (a2 != null) {
                m2550d(a2);
            }
            m2544c(a.m2504a(C0417R.styleable.ActionBar_displayOptions, 0));
            int g = a.m2518g(C0417R.styleable.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m2535a(LayoutInflater.from(this.f1994a.getContext()).inflate(g, this.f1994a, false));
                m2544c(this.f1995b | 16);
            }
            g = a.m2516f(C0417R.styleable.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f1994a.getLayoutParams();
                layoutParams.height = g;
                this.f1994a.setLayoutParams(layoutParams);
            }
            g = a.m2512d(C0417R.styleable.ActionBar_contentInsetStart, -1);
            int d = a.m2512d(C0417R.styleable.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f1994a.m2138a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m2518g(C0417R.styleable.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f1994a.m2139a(this.f1994a.getContext(), g);
            }
            g = a.m2518g(C0417R.styleable.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f1994a.m2143b(this.f1994a.getContext(), g);
            }
            int g2 = a.m2518g(C0417R.styleable.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f1994a.setPopupTheme(g2);
            }
            a.m2506a();
        } else {
            this.f1995b = m2524s();
        }
        this.f2009p = C0616l.m2672a();
        m2553e(i);
        this.f2004k = this.f1994a.getNavigationContentDescription();
        m2541b(this.f2009p.m2695a(m2539b(), i2));
        this.f1994a.setNavigationOnClickListener(new C05931(this));
    }

    private void m2523e(CharSequence charSequence) {
        this.f2002i = charSequence;
        if ((this.f1995b & 8) != 0) {
            this.f1994a.setTitle(charSequence);
        }
    }

    private int m2524s() {
        return this.f1994a.getNavigationIcon() != null ? 15 : 11;
    }

    private void m2525t() {
        Drawable drawable = null;
        if ((this.f1995b & 2) != 0) {
            drawable = (this.f1995b & 1) != 0 ? this.f1999f != null ? this.f1999f : this.f1998e : this.f1998e;
        }
        this.f1994a.setLogo(drawable);
    }

    private void m2526u() {
        if ((this.f1995b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2004k)) {
            this.f1994a.setNavigationContentDescription(this.f2010q);
        } else {
            this.f1994a.setNavigationContentDescription(this.f2004k);
        }
    }

    private void m2527v() {
        if ((this.f1995b & 4) != 0) {
            this.f1994a.setNavigationIcon(this.f2000g != null ? this.f2000g : this.f2011r);
        }
    }

    public ViewPropertyAnimatorCompat m2528a(int i, long j) {
        return ViewCompat.animate(this.f1994a).alpha(i == 0 ? 1.0f : 0.0f).setDuration(j).setListener(new C05942(this, i));
    }

    public ViewGroup m2529a() {
        return this.f1994a;
    }

    public void m2530a(int i) {
        m2531a(i != 0 ? this.f2009p.m2695a(m2539b(), i) : null);
    }

    public void m2531a(Drawable drawable) {
        this.f1998e = drawable;
        m2525t();
    }

    public void m2532a(C0342a c0342a, C0351a c0351a) {
        this.f1994a.m2141a(c0342a, c0351a);
    }

    public void m2533a(az azVar) {
        if (this.f1996c != null && this.f1996c.getParent() == this.f1994a) {
            this.f1994a.removeView(this.f1996c);
        }
        this.f1996c = azVar;
        if (azVar != null && this.f2008o == 2) {
            this.f1994a.addView(this.f1996c, 0);
            C0553b c0553b = (C0553b) this.f1996c.getLayoutParams();
            c0553b.width = -2;
            c0553b.height = -2;
            c0553b.a = 8388691;
            azVar.setAllowCollapse(true);
        }
    }

    public void m2534a(Menu menu, C0342a c0342a) {
        if (this.f2007n == null) {
            this.f2007n = new ActionMenuPresenter(this.f1994a.getContext());
            this.f2007n.m1346a(C0417R.id.action_menu_presenter);
        }
        this.f2007n.m1350a(c0342a);
        this.f1994a.m2140a((C0447f) menu, this.f2007n);
    }

    public void m2535a(View view) {
        if (!(this.f1997d == null || (this.f1995b & 16) == 0)) {
            this.f1994a.removeView(this.f1997d);
        }
        this.f1997d = view;
        if (view != null && (this.f1995b & 16) != 0) {
            this.f1994a.addView(this.f1997d);
        }
    }

    public void m2536a(Callback callback) {
        this.f2005l = callback;
    }

    public void m2537a(CharSequence charSequence) {
        if (!this.f2001h) {
            m2523e(charSequence);
        }
    }

    public void m2538a(boolean z) {
        this.f1994a.setCollapsible(z);
    }

    public Context m2539b() {
        return this.f1994a.getContext();
    }

    public void m2540b(int i) {
        m2545c(i != 0 ? this.f2009p.m2695a(m2539b(), i) : null);
    }

    public void m2541b(Drawable drawable) {
        if (this.f2011r != drawable) {
            this.f2011r = drawable;
            m2527v();
        }
    }

    public void m2542b(CharSequence charSequence) {
        this.f2001h = true;
        m2523e(charSequence);
    }

    public void m2543b(boolean z) {
    }

    public void m2544c(int i) {
        int i2 = this.f1995b ^ i;
        this.f1995b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m2527v();
                    m2526u();
                } else {
                    this.f1994a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                m2525t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1994a.setTitle(this.f2002i);
                    this.f1994a.setSubtitle(this.f2003j);
                } else {
                    this.f1994a.setTitle(null);
                    this.f1994a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f1997d != null) {
                if ((i & 16) != 0) {
                    this.f1994a.addView(this.f1997d);
                } else {
                    this.f1994a.removeView(this.f1997d);
                }
            }
        }
    }

    public void m2545c(Drawable drawable) {
        this.f1999f = drawable;
        m2525t();
    }

    public void m2546c(CharSequence charSequence) {
        this.f2003j = charSequence;
        if ((this.f1995b & 8) != 0) {
            this.f1994a.setSubtitle(charSequence);
        }
    }

    public boolean m2547c() {
        return this.f1994a.m2149g();
    }

    public void m2548d() {
        this.f1994a.m2150h();
    }

    public void m2549d(int i) {
        m2551d(i == 0 ? null : m2539b().getString(i));
    }

    public void m2550d(Drawable drawable) {
        this.f2000g = drawable;
        m2527v();
    }

    public void m2551d(CharSequence charSequence) {
        this.f2004k = charSequence;
        m2526u();
    }

    public CharSequence m2552e() {
        return this.f1994a.getTitle();
    }

    public void m2553e(int i) {
        if (i != this.f2010q) {
            this.f2010q = i;
            if (TextUtils.isEmpty(this.f1994a.getNavigationContentDescription())) {
                m2549d(this.f2010q);
            }
        }
    }

    public void m2554f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void m2555g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean m2556h() {
        return this.f1994a.m2142a();
    }

    public boolean m2557i() {
        return this.f1994a.m2144b();
    }

    public boolean m2558j() {
        return this.f1994a.m2145c();
    }

    public boolean m2559k() {
        return this.f1994a.m2146d();
    }

    public boolean m2560l() {
        return this.f1994a.m2147e();
    }

    public void m2561m() {
        this.f2006m = true;
    }

    public void m2562n() {
        this.f1994a.m2148f();
    }

    public int m2563o() {
        return this.f1995b;
    }

    public int m2564p() {
        return this.f2008o;
    }

    public int m2565q() {
        return this.f1994a.getVisibility();
    }

    public Menu m2566r() {
        return this.f1994a.getMenu();
    }
}
