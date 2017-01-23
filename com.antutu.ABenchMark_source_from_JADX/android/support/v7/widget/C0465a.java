package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* renamed from: android.support.v7.widget.a */
abstract class C0465a extends ViewGroup {
    protected final C0555a f1303a;
    protected final Context f1304b;
    protected ActionMenuView f1305c;
    protected ActionMenuPresenter f1306d;
    protected int f1307e;
    protected ViewPropertyAnimatorCompat f1308f;
    private boolean f1309g;
    private boolean f1310h;

    /* renamed from: android.support.v7.widget.a.a */
    protected class C0555a implements ViewPropertyAnimatorListener {
        int f1759a;
        final /* synthetic */ C0465a f1760b;
        private boolean f1761c;

        protected C0555a(C0465a c0465a) {
            this.f1760b = c0465a;
            this.f1761c = false;
        }

        public C0555a m2156a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            this.f1760b.f1308f = viewPropertyAnimatorCompat;
            this.f1759a = i;
            return this;
        }

        public void onAnimationCancel(View view) {
            this.f1761c = true;
        }

        public void onAnimationEnd(View view) {
            if (!this.f1761c) {
                this.f1760b.f1308f = null;
                super.setVisibility(this.f1759a);
            }
        }

        public void onAnimationStart(View view) {
            super.setVisibility(0);
            this.f1761c = false;
        }
    }

    C0465a(Context context) {
        this(context, null);
    }

    C0465a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0465a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1303a = new C0555a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0417R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1304b = context;
        } else {
            this.f1304b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int m1504a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m1507a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, LinearLayoutManager.INVALID_OFFSET), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int m1508a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public ViewPropertyAnimatorCompat m1509a(int i, long j) {
        if (this.f1308f != null) {
            this.f1308f.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ViewCompat.setAlpha(this, 0.0f);
            }
            ViewPropertyAnimatorCompat alpha = ViewCompat.animate(this).alpha(1.0f);
            alpha.setDuration(j);
            alpha.setListener(this.f1303a.m2156a(alpha, i));
            return alpha;
        }
        alpha = ViewCompat.animate(this).alpha(0.0f);
        alpha.setDuration(j);
        alpha.setListener(this.f1303a.m2156a(alpha, i));
        return alpha;
    }

    public boolean m1510a() {
        return this.f1306d != null ? this.f1306d.m1593d() : false;
    }

    public int getAnimatedVisibility() {
        return this.f1308f != null ? this.f1303a.f1759a : getVisibility();
    }

    public int getContentHeight() {
        return this.f1307e;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0417R.styleable.ActionBar, C0417R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0417R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1306d != null) {
            this.f1306d.m1580a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.f1310h = false;
        }
        if (!this.f1310h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1310h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1310h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f1309g = false;
        }
        if (!this.f1309g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1309g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1309g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1307e = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1308f != null) {
                this.f1308f.cancel();
            }
            super.setVisibility(i);
        }
    }
}
