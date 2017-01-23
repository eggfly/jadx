package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.aide.uidesigner.ProxyTextView;

public class PagerTabStrip extends PagerTitleStrip {
    private int EQ;
    private final Rect J0;
    private int J8;
    private float Mr;
    private boolean QX;
    private int U2;
    private int VH;
    private boolean Ws;
    private int XL;
    private int Zo;
    private boolean aM;
    private int gn;
    private float j3;
    private int tp;
    private int u7;
    private final Paint we;

    class 1 implements OnClickListener {
        final /* synthetic */ PagerTabStrip j6;

        1(PagerTabStrip pagerTabStrip) {
            this.j6 = pagerTabStrip;
        }

        public void onClick(View view) {
            this.j6.j6.setCurrentItem(this.j6.j6.getCurrentItem() - 1);
        }
    }

    class 2 implements OnClickListener {
        final /* synthetic */ PagerTabStrip j6;

        2(PagerTabStrip pagerTabStrip) {
            this.j6 = pagerTabStrip;
        }

        public void onClick(View view) {
            this.j6.j6.setCurrentItem(this.j6.j6.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.we = new Paint();
        this.J0 = new Rect();
        this.J8 = 255;
        this.Ws = false;
        this.QX = false;
        this.Zo = this.v5;
        this.we.setColor(this.Zo);
        float f = context.getResources().getDisplayMetrics().density;
        this.VH = (int) ((3.0f * f) + 0.5f);
        this.gn = (int) ((6.0f * f) + 0.5f);
        this.u7 = (int) (64.0f * f);
        this.EQ = (int) ((16.0f * f) + 0.5f);
        this.XL = (int) ((1.0f * f) + 0.5f);
        this.tp = (int) ((f * 32.0f) + 0.5f);
        this.U2 = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.DW.setFocusable(true);
        this.DW.setOnClickListener(new 1(this));
        this.Hw.setFocusable(true);
        this.Hw.setOnClickListener(new 2(this));
        if (getBackground() == null) {
            this.Ws = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.Zo = i;
        this.we.setColor(this.Zo);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(getContext().getResources().getColor(i));
    }

    public int getTabIndicatorColor() {
        return this.Zo;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.gn) {
            i4 = this.gn;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.u7) {
            i = this.u7;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.QX) {
            this.Ws = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.QX) {
            this.Ws = (-16777216 & i) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.QX) {
            this.Ws = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.Ws = z;
        this.QX = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.Ws;
    }

    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.tp);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.aM) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                this.j3 = x;
                this.Mr = y;
                this.aM = false;
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (x >= ((float) (this.FH.getLeft() - this.EQ))) {
                    if (x > ((float) (this.FH.getRight() + this.EQ))) {
                        this.j6.setCurrentItem(this.j6.getCurrentItem() + 1);
                        break;
                    }
                }
                this.j6.setCurrentItem(this.j6.getCurrentItem() - 1);
                break;
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                if (Math.abs(x - this.j3) > ((float) this.U2) || Math.abs(y - this.Mr) > ((float) this.U2)) {
                    this.aM = true;
                    break;
                }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.FH.getLeft() - this.EQ;
        int right = this.FH.getRight() + this.EQ;
        int i = height - this.VH;
        this.we.setColor((this.J8 << 24) | (this.Zo & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.we);
        if (this.Ws) {
            this.we.setColor(-16777216 | (this.Zo & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.XL), (float) (getWidth() - getPaddingRight()), (float) height, this.we);
        }
    }

    void j6(int i, float f, boolean z) {
        Rect rect = this.J0;
        int height = getHeight();
        int i2 = height - this.VH;
        rect.set(this.FH.getLeft() - this.EQ, i2, this.FH.getRight() + this.EQ, height);
        super.j6(i, f, z);
        this.J8 = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.FH.getLeft() - this.EQ, i2, this.FH.getRight() + this.EQ, height);
        invalidate(rect);
    }
}
