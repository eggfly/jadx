package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.C0355a.C0354c;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0422a;
import android.support.v7.widget.an.C0482a;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class az extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator f1938j;
    Runnable f1939a;
    int f1940b;
    int f1941c;
    private C0589b f1942d;
    private an f1943e;
    private Spinner f1944f;
    private boolean f1945g;
    private int f1946h;
    private int f1947i;

    /* renamed from: android.support.v7.widget.az.1 */
    class C05871 implements Runnable {
        final /* synthetic */ View f1928a;
        final /* synthetic */ az f1929b;

        C05871(az azVar, View view) {
            this.f1929b = azVar;
            this.f1928a = view;
        }

        public void run() {
            this.f1929b.smoothScrollTo(this.f1928a.getLeft() - ((this.f1929b.getWidth() - this.f1928a.getWidth()) / 2), 0);
            this.f1929b.f1939a = null;
        }
    }

    /* renamed from: android.support.v7.widget.az.a */
    private class C0588a extends BaseAdapter {
        final /* synthetic */ az f1930a;

        private C0588a(az azVar) {
            this.f1930a = azVar;
        }

        public int getCount() {
            return this.f1930a.f1943e.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0590c) this.f1930a.f1943e.getChildAt(i)).m2464b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return this.f1930a.m2466a((C0354c) getItem(i), true);
            }
            ((C0590c) view).m2463a((C0354c) getItem(i));
            return view;
        }
    }

    /* renamed from: android.support.v7.widget.az.b */
    private class C0589b implements OnClickListener {
        final /* synthetic */ az f1931a;

        private C0589b(az azVar) {
            this.f1931a = azVar;
        }

        public void onClick(View view) {
            ((C0590c) view).m2464b().m987d();
            int childCount = this.f1931a.f1943e.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f1931a.f1943e.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* renamed from: android.support.v7.widget.az.c */
    private class C0590c extends an implements OnLongClickListener {
        final /* synthetic */ az f1932a;
        private final int[] f1933b;
        private C0354c f1934c;
        private TextView f1935d;
        private ImageView f1936e;
        private View f1937f;

        public C0590c(az azVar, Context context, C0354c c0354c, boolean z) {
            this.f1932a = azVar;
            super(context, null, C0417R.attr.actionBarTabStyle);
            this.f1933b = new int[]{16842964};
            this.f1934c = c0354c;
            bh a = bh.m2502a(context, null, this.f1933b, C0417R.attr.actionBarTabStyle, 0);
            if (a.m2517f(0)) {
                setBackgroundDrawable(a.m2505a(0));
            }
            a.m2506a();
            if (z) {
                setGravity(8388627);
            }
            m2462a();
        }

        public void m2462a() {
            C0354c c0354c = this.f1934c;
            View c = c0354c.m986c();
            if (c != null) {
                C0590c parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(c);
                    }
                    addView(c);
                }
                this.f1937f = c;
                if (this.f1935d != null) {
                    this.f1935d.setVisibility(8);
                }
                if (this.f1936e != null) {
                    this.f1936e.setVisibility(8);
                    this.f1936e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f1937f != null) {
                removeView(this.f1937f);
                this.f1937f = null;
            }
            Drawable a = c0354c.m984a();
            CharSequence b = c0354c.m985b();
            if (a != null) {
                if (this.f1936e == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams c0482a = new C0482a(-2, -2);
                    c0482a.f1390h = 16;
                    imageView.setLayoutParams(c0482a);
                    addView(imageView, 0);
                    this.f1936e = imageView;
                }
                this.f1936e.setImageDrawable(a);
                this.f1936e.setVisibility(0);
            } else if (this.f1936e != null) {
                this.f1936e.setVisibility(8);
                this.f1936e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(b);
            if (z) {
                if (this.f1935d == null) {
                    imageView = new aa(getContext(), null, C0417R.attr.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    c0482a = new C0482a(-2, -2);
                    c0482a.f1390h = 16;
                    imageView.setLayoutParams(c0482a);
                    addView(imageView);
                    this.f1935d = imageView;
                }
                this.f1935d.setText(b);
                this.f1935d.setVisibility(0);
            } else if (this.f1935d != null) {
                this.f1935d.setVisibility(8);
                this.f1935d.setText(null);
            }
            if (this.f1936e != null) {
                this.f1936e.setContentDescription(c0354c.m988e());
            }
            if (z || TextUtils.isEmpty(c0354c.m988e())) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public void m2463a(C0354c c0354c) {
            this.f1934c = c0354c;
            m2462a();
        }

        public C0354c m2464b() {
            return this.f1934c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0354c.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(C0354c.class.getName());
            }
        }

        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.f1934c.m988e(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f1932a.f1940b > 0 && getMeasuredWidth() > this.f1932a.f1940b) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f1932a.f1940b, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        f1938j = new DecelerateInterpolator();
    }

    private C0590c m2466a(C0354c c0354c, boolean z) {
        C0590c c0590c = new C0590c(this, getContext(), c0354c, z);
        if (z) {
            c0590c.setBackgroundDrawable(null);
            c0590c.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1946h));
        } else {
            c0590c.setFocusable(true);
            if (this.f1942d == null) {
                this.f1942d = new C0589b();
            }
            c0590c.setOnClickListener(this.f1942d);
        }
        return c0590c;
    }

    private boolean m2468a() {
        return this.f1944f != null && this.f1944f.getParent() == this;
    }

    private void m2469b() {
        if (!m2468a()) {
            if (this.f1944f == null) {
                this.f1944f = m2471d();
            }
            removeView(this.f1943e);
            addView(this.f1944f, new LayoutParams(-2, -1));
            if (this.f1944f.getAdapter() == null) {
                this.f1944f.setAdapter(new C0588a());
            }
            if (this.f1939a != null) {
                removeCallbacks(this.f1939a);
                this.f1939a = null;
            }
            this.f1944f.setSelection(this.f1947i);
        }
    }

    private boolean m2470c() {
        if (m2468a()) {
            removeView(this.f1944f);
            addView(this.f1943e, new LayoutParams(-2, -1));
            setTabSelected(this.f1944f.getSelectedItemPosition());
        }
        return false;
    }

    private Spinner m2471d() {
        Spinner c0634x = new C0634x(getContext(), null, C0417R.attr.actionDropDownStyle);
        c0634x.setLayoutParams(new C0482a(-2, -1));
        c0634x.setOnItemSelectedListener(this);
        return c0634x;
    }

    public void m2472a(int i) {
        View childAt = this.f1943e.getChildAt(i);
        if (this.f1939a != null) {
            removeCallbacks(this.f1939a);
        }
        this.f1939a = new C05871(this, childAt);
        post(this.f1939a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1939a != null) {
            post(this.f1939a);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        C0422a a = C0422a.m1230a(getContext());
        setContentHeight(a.m1235e());
        this.f1941c = a.m1237g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1939a != null) {
            removeCallbacks(this.f1939a);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0590c) view).m2464b().m987d();
    }

    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f1943e.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == LinearLayoutManager.INVALID_OFFSET)) {
            this.f1940b = -1;
        } else {
            if (childCount > 2) {
                this.f1940b = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f1940b = MeasureSpec.getSize(i) / 2;
            }
            this.f1940b = Math.min(this.f1940b, this.f1941c);
        }
        mode = MeasureSpec.makeMeasureSpec(this.f1946h, 1073741824);
        if (z || !this.f1945g) {
            i3 = 0;
        }
        if (i3 != 0) {
            this.f1943e.measure(0, mode);
            if (this.f1943e.getMeasuredWidth() > MeasureSpec.getSize(i)) {
                m2469b();
            } else {
                m2470c();
            }
        } else {
            m2470c();
        }
        i3 = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth = getMeasuredWidth();
        if (z && i3 != measuredWidth) {
            setTabSelected(this.f1947i);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f1945g = z;
    }

    public void setContentHeight(int i) {
        this.f1946h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f1947i = i;
        int childCount = this.f1943e.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1943e.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m2472a(i);
            }
            i2++;
        }
        if (this.f1944f != null && i >= 0) {
            this.f1944f.setSelection(i);
        }
    }
}
