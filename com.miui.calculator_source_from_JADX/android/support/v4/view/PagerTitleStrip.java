package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.miui.support.internal.C0264R;
import java.lang.ref.WeakReference;

public class PagerTitleStrip extends ViewGroup implements Decor {
    private static final int[] f789n;
    private static final int[] f790o;
    private static final PagerTitleStripImpl f791q;
    ViewPager f792a;
    TextView f793b;
    TextView f794c;
    TextView f795d;
    int f796e;
    private int f797f;
    private float f798g;
    private int f799h;
    private int f800i;
    private boolean f801j;
    private boolean f802k;
    private final PageListener f803l;
    private WeakReference<PagerAdapter> f804m;
    private int f805p;

    private class PageListener extends DataSetObserver implements OnAdapterChangeListener, OnPageChangeListener {
        final /* synthetic */ PagerTitleStrip f822a;
        private int f823b;

        private PageListener(PagerTitleStrip pagerTitleStrip) {
            this.f822a = pagerTitleStrip;
        }

        public void m1323a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            this.f822a.m1314a(i, f, false);
        }

        public void m1322a(int i) {
            float f = 0.0f;
            if (this.f823b == 0) {
                this.f822a.m1315a(this.f822a.f792a.getCurrentItem(), this.f822a.f792a.getAdapter());
                if (this.f822a.f798g >= 0.0f) {
                    f = this.f822a.f798g;
                }
                this.f822a.m1314a(this.f822a.f792a.getCurrentItem(), f, true);
            }
        }

        public void m1325b(int i) {
            this.f823b = i;
        }

        public void m1324a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            this.f822a.m1316a(pagerAdapter, pagerAdapter2);
        }

        public void onChanged() {
            float f = 0.0f;
            this.f822a.m1315a(this.f822a.f792a.getCurrentItem(), this.f822a.f792a.getAdapter());
            if (this.f822a.f798g >= 0.0f) {
                f = this.f822a.f798g;
            }
            this.f822a.m1314a(this.f822a.f792a.getCurrentItem(), f, true);
        }
    }

    interface PagerTitleStripImpl {
        void m1326a(TextView textView);
    }

    static class PagerTitleStripImplBase implements PagerTitleStripImpl {
        PagerTitleStripImplBase() {
        }

        public void m1327a(TextView textView) {
            textView.setSingleLine();
        }
    }

    static class PagerTitleStripImplIcs implements PagerTitleStripImpl {
        PagerTitleStripImplIcs() {
        }

        public void m1328a(TextView textView) {
            PagerTitleStripIcs.m1329a(textView);
        }
    }

    static {
        f789n = new int[]{16842804, 16842901, 16842904, 16842927};
        f790o = new int[]{16843660};
        if (VERSION.SDK_INT >= 14) {
            f791q = new PagerTitleStripImplIcs();
        } else {
            f791q = new PagerTitleStripImplBase();
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        f791q.m1326a(textView);
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        this.f797f = -1;
        this.f798g = -1.0f;
        this.f803l = new PageListener();
        View textView = new TextView(context);
        this.f793b = textView;
        addView(textView);
        textView = new TextView(context);
        this.f794c = textView;
        addView(textView);
        textView = new TextView(context);
        this.f795d = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f789n);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.f793b.setTextAppearance(context, resourceId);
            this.f794c.setTextAppearance(context, resourceId);
            this.f795d.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            m1313a(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.f793b.setTextColor(dimensionPixelSize);
            this.f794c.setTextColor(dimensionPixelSize);
            this.f795d.setTextColor(dimensionPixelSize);
        }
        this.f800i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f796e = this.f794c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f793b.setEllipsize(TruncateAt.END);
        this.f794c.setEllipsize(TruncateAt.END);
        this.f795d.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, f790o);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f793b);
            setSingleLineAllCaps(this.f794c);
            setSingleLineAllCaps(this.f795d);
        } else {
            this.f793b.setSingleLine();
            this.f794c.setSingleLine();
            this.f795d.setSingleLine();
        }
        this.f799h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.f799h = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.f799h;
    }

    public void setNonPrimaryAlpha(@FloatRange float f) {
        this.f805p = ((int) (255.0f * f)) & 255;
        int i = (this.f805p << 24) | (this.f796e & 16777215);
        this.f793b.setTextColor(i);
        this.f795d.setTextColor(i);
    }

    public void setTextColor(@ColorInt int i) {
        this.f796e = i;
        this.f794c.setTextColor(i);
        int i2 = (this.f805p << 24) | (this.f796e & 16777215);
        this.f793b.setTextColor(i2);
        this.f795d.setTextColor(i2);
    }

    public void m1313a(int i, float f) {
        this.f793b.setTextSize(i, f);
        this.f794c.setTextSize(i, f);
        this.f795d.setTextSize(i, f);
    }

    public void setGravity(int i) {
        this.f800i = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.m1558a(this.f803l);
            viewPager.setOnAdapterChangeListener(this.f803l);
            this.f792a = viewPager;
            m1316a(this.f804m != null ? (PagerAdapter) this.f804m.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f792a != null) {
            m1316a(this.f792a.getAdapter(), null);
            this.f792a.m1558a(null);
            this.f792a.setOnAdapterChangeListener(null);
            this.f792a = null;
        }
    }

    void m1315a(int i, PagerAdapter pagerAdapter) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int a = pagerAdapter != null ? pagerAdapter.m1a() : 0;
        this.f801j = true;
        if (i < 1 || pagerAdapter == null) {
            charSequence = null;
        } else {
            charSequence = pagerAdapter.m3a(i - 1);
        }
        this.f793b.setText(charSequence);
        TextView textView = this.f794c;
        if (pagerAdapter == null || i >= a) {
            charSequence = null;
        } else {
            charSequence = pagerAdapter.m3a(i);
        }
        textView.setText(charSequence);
        if (i + 1 < a && pagerAdapter != null) {
            charSequence2 = pagerAdapter.m3a(i + 1);
        }
        this.f795d.setText(charSequence2);
        a = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f793b.measure(a, makeMeasureSpec);
        this.f794c.measure(a, makeMeasureSpec);
        this.f795d.measure(a, makeMeasureSpec);
        this.f797f = i;
        if (!this.f802k) {
            m1314a(i, this.f798g, false);
        }
        this.f801j = false;
    }

    public void requestLayout() {
        if (!this.f801j) {
            super.requestLayout();
        }
    }

    void m1316a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.m15b(this.f803l);
            this.f804m = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.m6a(this.f803l);
            this.f804m = new WeakReference(pagerAdapter2);
        }
        if (this.f792a != null) {
            this.f797f = -1;
            this.f798g = -1.0f;
            m1315a(this.f792a.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    void m1314a(int i, float f, boolean z) {
        if (i != this.f797f) {
            m1315a(i, this.f792a.getAdapter());
        } else if (!z && f == this.f798g) {
            return;
        }
        this.f802k = true;
        int measuredWidth = this.f793b.getMeasuredWidth();
        int measuredWidth2 = this.f794c.getMeasuredWidth();
        int measuredWidth3 = this.f795d.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i4 = ((width - i3) - ((int) (f2 * ((float) i4)))) - (measuredWidth2 / 2);
        i3 = i4 + measuredWidth2;
        i2 = this.f793b.getBaseline();
        measuredWidth2 = this.f794c.getBaseline();
        int baseline = this.f795d.getBaseline();
        int max = Math.max(Math.max(i2, measuredWidth2), baseline);
        i2 = max - i2;
        measuredWidth2 = max - measuredWidth2;
        baseline = max - baseline;
        max = this.f793b.getMeasuredHeight() + i2;
        int measuredHeight = this.f794c.getMeasuredHeight() + measuredWidth2;
        max = Math.max(Math.max(max, measuredHeight), this.f795d.getMeasuredHeight() + baseline);
        switch (this.f800i & 112) {
            case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                paddingTop = (((height - paddingTop) - paddingBottom) - max) / 2;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            case 80:
                paddingTop = (height - paddingBottom) - max;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            default:
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
        }
        this.f794c.layout(i4, measuredWidth2, i3, this.f794c.getMeasuredHeight() + measuredWidth2);
        measuredWidth2 = Math.min(paddingLeft, (i4 - this.f799h) - measuredWidth);
        this.f793b.layout(measuredWidth2, height, measuredWidth + measuredWidth2, this.f793b.getMeasuredHeight() + height);
        measuredWidth2 = Math.max((width - paddingRight) - measuredWidth3, this.f799h + i3);
        this.f795d.layout(measuredWidth2, i2, measuredWidth2 + measuredWidth3, this.f795d.getMeasuredHeight() + i2);
        this.f798g = f;
        this.f802k = false;
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        mode = getMinHeight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i3 = size2 - paddingTop;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) size) * 0.8f)), Integer.MIN_VALUE);
        i3 = MeasureSpec.makeMeasureSpec(Math.min(0, i3), Integer.MIN_VALUE);
        this.f793b.measure(makeMeasureSpec, i3);
        this.f794c.measure(makeMeasureSpec, i3);
        this.f795d.measure(makeMeasureSpec, i3);
        if (mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(size, Math.max(mode, this.f794c.getMeasuredHeight() + paddingTop));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.f792a != null) {
            if (this.f798g >= 0.0f) {
                f = this.f798g;
            }
            m1314a(this.f797f, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
