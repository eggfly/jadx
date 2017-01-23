package com.miui.support.internal.widget;

import android.app.ActionBar.Tab;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.miui.support.C0234R;
import com.miui.support.app.ActionBar.FragmentViewPagerChangeListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.view.ActionBarPolicy;
import com.miui.support.util.AttributeResolver;
import com.miui.support.util.ViewUtils;

public class ScrollingTabContainerView extends HorizontalScrollView implements OnItemClickListener, FragmentViewPagerChangeListener {
    Runnable f3191a;
    int f3192b;
    int f3193c;
    private final LayoutInflater f3194d;
    private TabClickListener f3195e;
    private LinearLayout f3196f;
    private Spinner f3197g;
    private boolean f3198h;
    private int f3199i;
    private int f3200j;
    private Bitmap f3201k;
    private boolean f3202l;
    private float f3203m;
    private Paint f3204n;
    private int f3205o;
    private boolean f3206p;

    /* renamed from: com.miui.support.internal.widget.ScrollingTabContainerView.1 */
    class C03931 implements Runnable {
        final /* synthetic */ View f3181a;
        final /* synthetic */ ScrollingTabContainerView f3182b;

        C03931(ScrollingTabContainerView scrollingTabContainerView, View view) {
            this.f3182b = scrollingTabContainerView;
            this.f3181a = view;
        }

        public void run() {
            int left = this.f3181a.getLeft() - ((this.f3182b.getWidth() - this.f3181a.getWidth()) / 2);
            if (DeviceHelper.f2553e) {
                this.f3182b.smoothScrollTo(left, 0);
            } else {
                this.f3182b.scrollTo(left, 0);
            }
            this.f3182b.f3191a = null;
        }
    }

    private class TabAdapter extends BaseAdapter {
        final /* synthetic */ ScrollingTabContainerView f3183a;

        private TabAdapter(ScrollingTabContainerView scrollingTabContainerView) {
            this.f3183a = scrollingTabContainerView;
        }

        public int getCount() {
            return this.f3183a.f3196f.getChildCount();
        }

        public Object getItem(int i) {
            return ((TabView) this.f3183a.f3196f.getChildAt(i)).getTab();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.f3183a.m4868b((Tab) getItem(i), true);
            }
            ((TabView) view).m4863a((Tab) getItem(i));
            return view;
        }
    }

    private class TabClickListener implements OnClickListener {
        final /* synthetic */ ScrollingTabContainerView f3184a;

        private TabClickListener(ScrollingTabContainerView scrollingTabContainerView) {
            this.f3184a = scrollingTabContainerView;
        }

        public void onClick(View view) {
            ((TabView) view).getTab().select();
            int childCount = this.f3184a.f3196f.getChildCount();
            for (int i = 0; i < childCount; i++) {
                boolean z;
                View childAt = this.f3184a.f3196f.getChildAt(i);
                if (childAt == view) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    public static class TabView extends LinearLayout {
        private Tab f3185a;
        private TextView f3186b;
        private ImageView f3187c;
        private View f3188d;
        private ImageView f3189e;
        private ScrollingTabContainerView f3190f;

        public TabView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        void m4864a(ScrollingTabContainerView scrollingTabContainerView, Tab tab, boolean z) {
            this.f3190f = scrollingTabContainerView;
            this.f3185a = tab;
            if (z) {
                setGravity(8388627);
            }
            m4862a();
        }

        public void m4863a(Tab tab) {
            this.f3185a = tab;
            m4862a();
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int i3 = this.f3190f != null ? this.f3190f.f3192b : 0;
            if (i3 > 0 && getMeasuredWidth() > i3) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
            }
        }

        public void m4862a() {
            Tab tab = this.f3185a;
            View customView = tab.getCustomView();
            if (customView != null) {
                TabView parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(customView);
                    }
                    addView(customView);
                }
                this.f3188d = customView;
                if (this.f3186b != null) {
                    this.f3186b.setVisibility(8);
                }
                if (this.f3187c != null) {
                    this.f3187c.setVisibility(8);
                    this.f3187c.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f3188d != null) {
                removeView(this.f3188d);
                this.f3188d = null;
            }
            Context context = getContext();
            Drawable icon = tab.getIcon();
            CharSequence text = tab.getText();
            if (icon != null) {
                if (this.f3187c == null) {
                    View imageView = new ImageView(context);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView, 0);
                    this.f3187c = imageView;
                }
                this.f3187c.setImageDrawable(icon);
                this.f3187c.setVisibility(0);
            } else if (this.f3187c != null) {
                this.f3187c.setVisibility(8);
                this.f3187c.setImageDrawable(null);
            }
            if (text != null) {
                View scrollingTabTextView;
                if (this.f3186b == null) {
                    scrollingTabTextView = new ScrollingTabTextView(context, null, 16843509);
                    scrollingTabTextView.setEllipsize(TruncateAt.END);
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    scrollingTabTextView.setLayoutParams(layoutParams2);
                    addView(scrollingTabTextView);
                    this.f3186b = scrollingTabTextView;
                }
                this.f3186b.setText(text);
                this.f3186b.setVisibility(0);
                if (this.f3189e == null) {
                    scrollingTabTextView = new ImageView(context);
                    scrollingTabTextView.setImageDrawable(AttributeResolver.m5320b(context, C0264R.attr.actionBarTabBadgeIcon));
                    scrollingTabTextView.setVisibility(8);
                    LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams3.gravity = 48;
                    Drawable background = getBackground();
                    if (background != null) {
                        int intrinsicHeight = background.getIntrinsicHeight();
                        int lineHeight = this.f3186b.getLineHeight();
                        if (intrinsicHeight > lineHeight) {
                            layoutParams3.topMargin = (intrinsicHeight - lineHeight) / 2;
                        }
                    }
                    scrollingTabTextView.setLayoutParams(layoutParams3);
                    addView(scrollingTabTextView);
                    this.f3189e = scrollingTabTextView;
                }
            } else if (this.f3186b != null) {
                this.f3186b.setVisibility(8);
                this.f3186b.setText(null);
            }
            if (this.f3187c != null) {
                this.f3187c.setContentDescription(tab.getContentDescription());
            }
        }

        public Tab getTab() {
            return this.f3185a;
        }

        public TextView getTextView() {
            return this.f3186b;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.f3204n = new Paint();
        this.f3205o = -1;
        this.f3194d = LayoutInflater.from(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0234R.styleable.ActionBar, 16843470, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0234R.styleable.ActionBar_tabIndicator);
        this.f3202l = obtainStyledAttributes.getBoolean(C0234R.styleable.ActionBar_translucentTabIndicator, true);
        this.f3201k = m4865a(drawable);
        obtainStyledAttributes.recycle();
        if (this.f3202l) {
            this.f3204n.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        }
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy a = ActionBarPolicy.m4264a(context);
        setContentHeight(a.m4270f());
        this.f3193c = a.m4272h();
        this.f3196f = (LinearLayout) this.f3194d.inflate(C0264R.layout.action_bar_tabbar, this, false);
        addView(this.f3196f, new FrameLayout.LayoutParams(-2, -1));
    }

    public void setEmbeded(boolean z) {
        this.f3206p = z;
        setHorizontalFadingEdgeEnabled(z);
    }

    private Bitmap m4865a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap;
        if (this.f3202l) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ALPHA_8);
        } else {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3201k != null) {
            canvas.drawBitmap(this.f3201k, this.f3203m, (float) (getHeight() - this.f3201k.getHeight()), this.f3204n);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3196f.getChildAt(this.f3200j) != null) {
            setTabIndicatorPosition(this.f3200j);
        }
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f3196f.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f3192b = -1;
        } else {
            if (childCount > 2) {
                this.f3192b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f3192b = (int) (((float) MeasureSpec.getSize(i)) * 0.6f);
            }
            this.f3192b = Math.min(this.f3192b, this.f3193c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f3199i, 1073741824);
        if (z || !this.f3198h) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f3196f.measure(0, mode);
            if (this.f3196f.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m4870c();
            } else {
                m4871d();
            }
        } else {
            m4871d();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f3200j);
        }
    }

    public float getTabIndicatorPosition() {
        return this.f3203m;
    }

    public void setTabIndicatorPosition(int i) {
        m4875a(i, 0.0f);
    }

    public void m4875a(int i, float f) {
        if (this.f3201k != null) {
            float width;
            View childAt = this.f3196f.getChildAt(i);
            View childAt2 = this.f3196f.getChildAt(i + 1);
            if (childAt2 == null) {
                width = (float) childAt.getWidth();
            } else {
                width = ((float) (childAt2.getWidth() + childAt.getWidth())) / 2.0f;
            }
            width *= f;
            this.f3203m = width + ((float) (((childAt.getWidth() - this.f3201k.getWidth()) / 2) + childAt.getLeft()));
            invalidate();
        }
    }

    private boolean m4869b() {
        return this.f3197g != null && this.f3197g.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f3198h = z;
    }

    private void m4870c() {
        if (!m4869b()) {
            if (this.f3197g == null) {
                this.f3197g = m4872e();
            }
            removeView(this.f3196f);
            addView(this.f3197g, new LayoutParams(-2, -1));
            if (this.f3197g.getAdapter() == null) {
                this.f3197g.setAdapter(new TabAdapter());
            }
            if (this.f3191a != null) {
                removeCallbacks(this.f3191a);
                this.f3191a = null;
            }
            this.f3197g.setSelection(this.f3200j);
        }
    }

    private boolean m4871d() {
        if (m4869b()) {
            removeView(this.f3197g);
            addView(this.f3196f, new LayoutParams(-2, -1));
            setTabSelected(this.f3197g.getSelectedItemPosition());
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.f3200j = i;
        int childCount = this.f3196f.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.f3196f.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                m4880c(i);
            }
        }
    }

    public void setContentHeight(int i) {
        this.f3199i = i;
        requestLayout();
    }

    private Spinner m4872e() {
        Spinner spinner = new Spinner(getContext(), null, 16843479);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        return spinner;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        ActionBarPolicy a = ActionBarPolicy.m4264a(getContext());
        setContentHeight(a.m4270f());
        this.f3193c = a.m4272h();
    }

    public void m4880c(int i) {
        View childAt = this.f3196f.getChildAt(i);
        if (this.f3191a != null) {
            removeCallbacks(this.f3191a);
        }
        this.f3191a = new C03931(this, childAt);
        post(this.f3191a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3191a != null) {
            post(this.f3191a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3191a != null) {
            removeCallbacks(this.f3191a);
        }
    }

    private TabView m4868b(Tab tab, boolean z) {
        TabView tabView = (TabView) this.f3194d.inflate(C0264R.layout.action_bar_tab, this.f3196f, false);
        tabView.m4864a(this, tab, z);
        if (z) {
            tabView.setBackground(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f3199i));
        } else {
            tabView.setFocusable(true);
            if (this.f3195e == null) {
                this.f3195e = new TabClickListener();
            }
            tabView.setOnClickListener(this.f3195e);
        }
        return tabView;
    }

    public void m4878a(Tab tab, boolean z) {
        View b = m4868b(tab, false);
        this.f3196f.addView(b);
        if (this.f3197g != null) {
            ((TabAdapter) this.f3197g.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            b.setSelected(true);
            this.f3205o = this.f3196f.getChildCount() - 1;
        }
        if (this.f3198h) {
            requestLayout();
        }
    }

    public void m4877a(Tab tab, int i, boolean z) {
        View b = m4868b(tab, false);
        this.f3196f.addView(b, i);
        if (this.f3197g != null) {
            ((TabAdapter) this.f3197g.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            b.setSelected(true);
            this.f3205o = this.f3196f.getChildCount() - 1;
        }
        if (this.f3198h) {
            requestLayout();
        }
    }

    public void m4881d(int i) {
        ((TabView) this.f3196f.getChildAt(i)).m4862a();
        if (this.f3197g != null) {
            ((TabAdapter) this.f3197g.getAdapter()).notifyDataSetChanged();
        }
        if (this.f3198h) {
            requestLayout();
        }
    }

    public void m4882e(int i) {
        this.f3196f.removeViewAt(i);
        if (this.f3197g != null) {
            ((TabAdapter) this.f3197g.getAdapter()).notifyDataSetChanged();
        }
        if (this.f3198h) {
            requestLayout();
        }
    }

    public void m4873a() {
        this.f3196f.removeAllViews();
        if (this.f3197g != null) {
            ((TabAdapter) this.f3197g.getAdapter()).notifyDataSetChanged();
        }
        if (this.f3198h) {
            requestLayout();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((TabView) view).getTab().select();
    }

    public void m4876a(int i, float f, boolean z, boolean z2) {
        m4875a(i, f);
    }

    public void m4874a(int i) {
        boolean z = true;
        TabView tabView = (TabView) this.f3196f.getChildAt(i);
        if (tabView != null) {
            tabView.sendAccessibilityEvent(4);
        }
        setTabIndicatorPosition(i);
        if (this.f3206p && this.f3205o != -1 && Math.abs(this.f3205o - i) == 1) {
            ScrollingTabTextView scrollingTabTextView = (ScrollingTabTextView) ((TabView) this.f3196f.getChildAt(this.f3205o)).getTextView();
            ScrollingTabTextView scrollingTabTextView2 = (ScrollingTabTextView) tabView.getTextView();
            if (!(scrollingTabTextView == null || scrollingTabTextView2 == null)) {
                if (ViewUtils.m5452a((View) this)) {
                    if (i >= this.f3205o) {
                        z = false;
                    }
                } else if (i <= this.f3205o) {
                    z = false;
                }
                scrollingTabTextView.m4884a(z);
                scrollingTabTextView2.m4884a(z);
            }
        }
        this.f3205o = i;
    }

    public void m4879b(int i) {
    }
}
