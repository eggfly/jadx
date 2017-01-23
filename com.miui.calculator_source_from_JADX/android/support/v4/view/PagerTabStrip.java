package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;

public class PagerTabStrip extends PagerTitleStrip {
    private int f806f;
    private int f807g;
    private int f808h;
    private int f809i;
    private int f810j;
    private int f811k;
    private final Paint f812l;
    private final Rect f813m;
    private int f814n;
    private boolean f815o;
    private boolean f816p;
    private int f817q;
    private boolean f818r;
    private float f819s;
    private float f820t;
    private int f821u;

    /* renamed from: android.support.v4.view.PagerTabStrip.1 */
    class C00841 implements OnClickListener {
        final /* synthetic */ PagerTabStrip f787a;

        C00841(PagerTabStrip pagerTabStrip) {
            this.f787a = pagerTabStrip;
        }

        public void onClick(View view) {
            this.f787a.a.setCurrentItem(this.f787a.a.getCurrentItem() - 1);
        }
    }

    /* renamed from: android.support.v4.view.PagerTabStrip.2 */
    class C00852 implements OnClickListener {
        final /* synthetic */ PagerTabStrip f788a;

        C00852(PagerTabStrip pagerTabStrip) {
            this.f788a = pagerTabStrip;
        }

        public void onClick(View view) {
            this.f788a.a.setCurrentItem(this.f788a.a.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f812l = new Paint();
        this.f813m = new Rect();
        this.f814n = 255;
        this.f815o = false;
        this.f816p = false;
        this.f806f = this.e;
        this.f812l.setColor(this.f806f);
        float f = context.getResources().getDisplayMetrics().density;
        this.f807g = (int) ((3.0f * f) + 0.5f);
        this.f808h = (int) ((6.0f * f) + 0.5f);
        this.f809i = (int) (64.0f * f);
        this.f811k = (int) ((16.0f * f) + 0.5f);
        this.f817q = (int) ((1.0f * f) + 0.5f);
        this.f810j = (int) ((f * 32.0f) + 0.5f);
        this.f821u = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.b.setFocusable(true);
        this.b.setOnClickListener(new C00841(this));
        this.d.setFocusable(true);
        this.d.setOnClickListener(new C00852(this));
        if (getBackground() == null) {
            this.f815o = true;
        }
    }

    public void setTabIndicatorColor(@ColorInt int i) {
        this.f806f = i;
        this.f812l.setColor(this.f806f);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.f806f;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.f808h) {
            i4 = this.f808h;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.f809i) {
            i = this.f809i;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f816p) {
            this.f815o = drawable == null;
        }
    }

    public void setBackgroundColor(@ColorInt int i) {
        super.setBackgroundColor(i);
        if (!this.f816p) {
            this.f815o = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        if (!this.f816p) {
            this.f815o = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f815o = z;
        this.f816p = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.f815o;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f810j);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f818r) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f819s = x;
                this.f820t = y;
                this.f818r = false;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (x >= ((float) (this.c.getLeft() - this.f811k))) {
                    if (x > ((float) (this.c.getRight() + this.f811k))) {
                        this.a.setCurrentItem(this.a.getCurrentItem() + 1);
                        break;
                    }
                }
                this.a.setCurrentItem(this.a.getCurrentItem() - 1);
                break;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (Math.abs(x - this.f819s) > ((float) this.f821u) || Math.abs(y - this.f820t) > ((float) this.f821u)) {
                    this.f818r = true;
                    break;
                }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.c.getLeft() - this.f811k;
        int right = this.c.getRight() + this.f811k;
        int i = height - this.f807g;
        this.f812l.setColor((this.f814n << 24) | (this.f806f & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.f812l);
        if (this.f815o) {
            this.f812l.setColor(-16777216 | (this.f806f & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.f817q), (float) (getWidth() - getPaddingRight()), (float) height, this.f812l);
        }
    }

    void m1317a(int i, float f, boolean z) {
        Rect rect = this.f813m;
        int height = getHeight();
        int i2 = height - this.f807g;
        rect.set(this.c.getLeft() - this.f811k, i2, this.c.getRight() + this.f811k, height);
        super.m1314a(i, f, z);
        this.f814n = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.c.getLeft() - this.f811k, i2, this.c.getRight() + this.f811k, height);
        invalidate(rect);
    }
}
