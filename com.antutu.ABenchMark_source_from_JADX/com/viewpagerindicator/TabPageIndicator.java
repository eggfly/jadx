package com.viewpagerindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.pushsdk.BuildConfig;

public class TabPageIndicator extends HorizontalScrollView implements C4270c {
    private static final CharSequence f14635a;
    private Runnable f14636b;
    private final OnClickListener f14637c;
    private final C4287b f14638d;
    private ViewPager f14639e;
    private OnPageChangeListener f14640f;
    private int f14641g;
    private int f14642h;
    private C4276a f14643i;

    /* renamed from: com.viewpagerindicator.TabPageIndicator.1 */
    class C42741 implements OnClickListener {
        final /* synthetic */ TabPageIndicator f14630a;

        C42741(TabPageIndicator tabPageIndicator) {
            this.f14630a = tabPageIndicator;
        }

        public void onClick(View view) {
            C4277b c4277b = (C4277b) view;
            int currentItem = this.f14630a.f14639e.getCurrentItem();
            int a = c4277b.m17562a();
            this.f14630a.f14639e.setCurrentItem(a);
            if (currentItem == a && this.f14630a.f14643i != null) {
                this.f14630a.f14643i.m17560a(a);
            }
        }
    }

    /* renamed from: com.viewpagerindicator.TabPageIndicator.2 */
    class C42752 implements Runnable {
        final /* synthetic */ View f14631a;
        final /* synthetic */ TabPageIndicator f14632b;

        C42752(TabPageIndicator tabPageIndicator, View view) {
            this.f14632b = tabPageIndicator;
            this.f14631a = view;
        }

        public void run() {
            this.f14632b.smoothScrollTo(this.f14631a.getLeft() - ((this.f14632b.getWidth() - this.f14631a.getWidth()) / 2), 0);
            this.f14632b.f14636b = null;
        }
    }

    /* renamed from: com.viewpagerindicator.TabPageIndicator.a */
    public interface C4276a {
        void m17560a(int i);
    }

    /* renamed from: com.viewpagerindicator.TabPageIndicator.b */
    private class C4277b extends TextView {
        final /* synthetic */ TabPageIndicator f14633a;
        private int f14634b;

        public C4277b(TabPageIndicator tabPageIndicator, Context context) {
            this.f14633a = tabPageIndicator;
            super(context, null, C4273R.attr.vpiTabPageIndicatorStyle);
        }

        public int m17562a() {
            return this.f14634b;
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f14633a.f14641g > 0 && getMeasuredWidth() > this.f14633a.f14641g) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f14633a.f14641g, 1073741824), i2);
            }
        }
    }

    static {
        f14635a = BuildConfig.FLAVOR;
    }

    public TabPageIndicator(Context context) {
        this(context, null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14637c = new C42741(this);
        setHorizontalScrollBarEnabled(false);
        this.f14638d = new C4287b(context, C4273R.attr.vpiTabPageIndicatorStyle);
        addView(this.f14638d, new LayoutParams(-2, -1));
    }

    private void m17565a(int i) {
        View childAt = this.f14638d.getChildAt(i);
        if (this.f14636b != null) {
            removeCallbacks(this.f14636b);
        }
        this.f14636b = new C42752(this, childAt);
        post(this.f14636b);
    }

    private void m17566a(int i, CharSequence charSequence, int i2) {
        View c4277b = new C4277b(this, getContext());
        c4277b.f14634b = i;
        c4277b.setFocusable(true);
        c4277b.setOnClickListener(this.f14637c);
        c4277b.setText(charSequence);
        if (i2 != 0) {
            c4277b.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        }
        this.f14638d.addView(c4277b, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    public void m17569a() {
        this.f14638d.removeAllViews();
        PagerAdapter adapter = this.f14639e.getAdapter();
        C4286a c4286a = null;
        if (adapter instanceof C4286a) {
            c4286a = (C4286a) adapter;
        }
        int count = adapter.getCount();
        int i = 0;
        while (i < count) {
            CharSequence pageTitle = adapter.getPageTitle(i);
            m17566a(i, pageTitle == null ? f14635a : pageTitle, c4286a != null ? c4286a.m17584a(i) : 0);
            i++;
        }
        if (this.f14642h > count) {
            this.f14642h = count - 1;
        }
        setCurrentItem(this.f14642h);
        requestLayout();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f14636b != null) {
            post(this.f14636b);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f14636b != null) {
            removeCallbacks(this.f14636b);
        }
    }

    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f14638d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == LinearLayoutManager.INVALID_OFFSET)) {
            this.f14641g = -1;
        } else if (childCount > 2) {
            this.f14641g = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
        } else {
            this.f14641g = MeasureSpec.getSize(i) / 2;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        mode = getMeasuredWidth();
        if (z && measuredWidth != mode) {
            setCurrentItem(this.f14642h);
        }
    }

    public void onPageScrollStateChanged(int i) {
        if (this.f14640f != null) {
            this.f14640f.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f14640f != null) {
            this.f14640f.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        setCurrentItem(i);
        if (this.f14640f != null) {
            this.f14640f.onPageSelected(i);
        }
    }

    public void setCurrentItem(int i) {
        if (this.f14639e == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f14642h = i;
        this.f14639e.setCurrentItem(i);
        int childCount = this.f14638d.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f14638d.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m17565a(i);
            }
            i2++;
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f14640f = onPageChangeListener;
    }

    public void setOnTabReselectedListener(C4276a c4276a) {
        this.f14643i = c4276a;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f14639e != viewPager) {
            if (this.f14639e != null) {
                this.f14639e.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f14639e = viewPager;
            viewPager.setOnPageChangeListener(this);
            m17569a();
        }
    }
}
