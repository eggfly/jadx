package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.cardview.C0420R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    private static final int[] f1453a;
    private static final ae f1454b;
    private boolean f1455c;
    private boolean f1456d;
    private int f1457e;
    private int f1458f;
    private final Rect f1459g;
    private final Rect f1460h;
    private final ac f1461i;

    /* renamed from: android.support.v7.widget.CardView.1 */
    class C04881 implements ac {
        final /* synthetic */ CardView f1451a;
        private Drawable f1452b;

        C04881(CardView cardView) {
            this.f1451a = cardView;
        }

        public void m1678a(int i, int i2) {
            if (i > this.f1451a.f1457e) {
                super.setMinimumWidth(i);
            }
            if (i2 > this.f1451a.f1458f) {
                super.setMinimumHeight(i2);
            }
        }

        public void m1679a(int i, int i2, int i3, int i4) {
            this.f1451a.f1460h.set(i, i2, i3, i4);
            super.setPadding(this.f1451a.f1459g.left + i, this.f1451a.f1459g.top + i2, this.f1451a.f1459g.right + i3, this.f1451a.f1459g.bottom + i4);
        }

        public void m1680a(Drawable drawable) {
            this.f1452b = drawable;
            this.f1451a.setBackgroundDrawable(drawable);
        }

        public boolean m1681a() {
            return this.f1451a.getUseCompatPadding();
        }

        public boolean m1682b() {
            return this.f1451a.getPreventCornerOverlap();
        }

        public Drawable m1683c() {
            return this.f1452b;
        }

        public View m1684d() {
            return this.f1451a;
        }
    }

    static {
        f1453a = new int[]{16842801};
        if (VERSION.SDK_INT >= 21) {
            f1454b = new ab();
        } else if (VERSION.SDK_INT >= 17) {
            f1454b = new af();
        } else {
            f1454b = new ad();
        }
        f1454b.m2158a();
    }

    public CardView(Context context) {
        super(context);
        this.f1459g = new Rect();
        this.f1460h = new Rect();
        this.f1461i = new C04881(this);
        m1686a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1459g = new Rect();
        this.f1460h = new Rect();
        this.f1461i = new C04881(this);
        m1686a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1459g = new Rect();
        this.f1460h = new Rect();
        this.f1461i = new C04881(this);
        m1686a(context, attributeSet, i);
    }

    private void m1686a(Context context, AttributeSet attributeSet, int i) {
        int color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0420R.styleable.CardView, i, C0420R.style.CardView);
        if (obtainStyledAttributes.hasValue(C0420R.styleable.CardView_cardBackgroundColor)) {
            color = obtainStyledAttributes.getColor(C0420R.styleable.CardView_cardBackgroundColor, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1453a);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            color = fArr[2] > 0.5f ? getResources().getColor(C0420R.color.cardview_light_background) : getResources().getColor(C0420R.color.cardview_dark_background);
        }
        float dimension = obtainStyledAttributes.getDimension(C0420R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0420R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(C0420R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f1455c = obtainStyledAttributes.getBoolean(C0420R.styleable.CardView_cardUseCompatPadding, false);
        this.f1456d = obtainStyledAttributes.getBoolean(C0420R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0420R.styleable.CardView_contentPadding, 0);
        this.f1459g.left = obtainStyledAttributes.getDimensionPixelSize(C0420R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f1459g.top = obtainStyledAttributes.getDimensionPixelSize(C0420R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.f1459g.right = obtainStyledAttributes.getDimensionPixelSize(C0420R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.f1459g.bottom = obtainStyledAttributes.getDimensionPixelSize(C0420R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.f1457e = obtainStyledAttributes.getDimensionPixelSize(C0420R.styleable.CardView_android_minWidth, 0);
        this.f1458f = obtainStyledAttributes.getDimensionPixelSize(C0420R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f1454b.m2161a(this.f1461i, context, color, dimension, dimension2, dimension3);
    }

    public float getCardElevation() {
        return f1454b.m2167e(this.f1461i);
    }

    public int getContentPaddingBottom() {
        return this.f1459g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1459g.left;
    }

    public int getContentPaddingRight() {
        return this.f1459g.right;
    }

    public int getContentPaddingTop() {
        return this.f1459g.top;
    }

    public float getMaxCardElevation() {
        return f1454b.m2157a(this.f1461i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1456d;
    }

    public float getRadius() {
        return f1454b.m2166d(this.f1461i);
    }

    public boolean getUseCompatPadding() {
        return this.f1455c;
    }

    protected void onMeasure(int i, int i2) {
        if (f1454b instanceof ab) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case LinearLayoutManager.INVALID_OFFSET /*-2147483648*/:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1454b.m2162b(this.f1461i)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case LinearLayoutManager.INVALID_OFFSET /*-2147483648*/:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f1454b.m2164c(this.f1461i)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f1454b.m2160a(this.f1461i, i);
    }

    public void setCardElevation(float f) {
        f1454b.m2165c(this.f1461i, f);
    }

    public void setMaxCardElevation(float f) {
        f1454b.m2163b(this.f1461i, f);
    }

    public void setMinimumHeight(int i) {
        this.f1458f = i;
        super.setMinimumHeight(i);
    }

    public void setMinimumWidth(int i) {
        this.f1457e = i;
        super.setMinimumWidth(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1456d) {
            this.f1456d = z;
            f1454b.m2169h(this.f1461i);
        }
    }

    public void setRadius(float f) {
        f1454b.m2159a(this.f1461i, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1455c != z) {
            this.f1455c = z;
            f1454b.m2168g(this.f1461i);
        }
    }
}
