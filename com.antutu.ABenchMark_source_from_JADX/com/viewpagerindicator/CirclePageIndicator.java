package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class CirclePageIndicator extends View implements C4270c {
    private float f14600a;
    private final Paint f14601b;
    private final Paint f14602c;
    private final Paint f14603d;
    private ViewPager f14604e;
    private OnPageChangeListener f14605f;
    private int f14606g;
    private int f14607h;
    private float f14608i;
    private int f14609j;
    private int f14610k;
    private boolean f14611l;
    private boolean f14612m;
    private int f14613n;
    private float f14614o;
    private int f14615p;
    private boolean f14616q;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f14599a;

        /* renamed from: com.viewpagerindicator.CirclePageIndicator.SavedState.1 */
        static class C42691 implements Creator<SavedState> {
            C42691() {
            }

            public SavedState m17552a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m17553a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m17552a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m17553a(i);
            }
        }

        static {
            CREATOR = new C42691();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14599a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f14599a);
        }
    }

    private int m17554a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.f14604e == null) {
            return size;
        }
        int count = this.f14604e.getAdapter().getCount();
        count = (int) (((((float) (count - 1)) * this.f14600a) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (count * 2)) * this.f14600a))) + 1.0f);
        return mode == LinearLayoutManager.INVALID_OFFSET ? Math.min(count, size) : count;
    }

    private int m17555b(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((((2.0f * this.f14600a) + ((float) getPaddingTop())) + ((float) getPaddingBottom())) + 1.0f);
        return mode == LinearLayoutManager.INVALID_OFFSET ? Math.min(paddingTop, size) : paddingTop;
    }

    public int getFillColor() {
        return this.f14603d.getColor();
    }

    public int getOrientation() {
        return this.f14610k;
    }

    public int getPageColor() {
        return this.f14601b.getColor();
    }

    public float getRadius() {
        return this.f14600a;
    }

    public int getStrokeColor() {
        return this.f14602c.getColor();
    }

    public float getStrokeWidth() {
        return this.f14602c.getStrokeWidth();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14604e != null) {
            int count = this.f14604e.getAdapter().getCount();
            if (count == 0) {
                return;
            }
            if (this.f14606g >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int width;
            int paddingLeft;
            int paddingRight;
            int paddingTop;
            if (this.f14610k == 0) {
                width = getWidth();
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
                paddingTop = getPaddingTop();
            } else {
                width = getHeight();
                paddingLeft = getPaddingTop();
                paddingRight = getPaddingBottom();
                paddingTop = getPaddingLeft();
            }
            float f = this.f14600a * 3.0f;
            float f2 = this.f14600a + ((float) paddingTop);
            float f3 = ((float) paddingLeft) + this.f14600a;
            if (this.f14611l) {
                f3 += (((float) ((width - paddingLeft) - paddingRight)) / 2.0f) - ((((float) count) * f) / 2.0f);
            }
            float f4 = this.f14600a;
            if (this.f14602c.getStrokeWidth() > 0.0f) {
                f4 -= this.f14602c.getStrokeWidth() / 2.0f;
            }
            for (int i = 0; i < count; i++) {
                float f5;
                float f6 = (((float) i) * f) + f3;
                if (this.f14610k == 0) {
                    f5 = f6;
                    f6 = f2;
                } else {
                    f5 = f2;
                }
                if (this.f14601b.getAlpha() > 0) {
                    canvas.drawCircle(f5, f6, f4, this.f14601b);
                }
                if (f4 != this.f14600a) {
                    canvas.drawCircle(f5, f6, this.f14600a, this.f14602c);
                }
            }
            f4 = ((float) (this.f14612m ? this.f14607h : this.f14606g)) * f;
            if (!this.f14612m) {
                f4 += this.f14608i * f;
            }
            if (this.f14610k == 0) {
                f3 += f4;
            } else {
                float f7 = f3 + f4;
                f3 = f2;
                f2 = f7;
            }
            canvas.drawCircle(f3, f2, this.f14600a, this.f14603d);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f14610k == 0) {
            setMeasuredDimension(m17554a(i), m17555b(i2));
        } else {
            setMeasuredDimension(m17555b(i), m17554a(i2));
        }
    }

    public void onPageScrollStateChanged(int i) {
        this.f14609j = i;
        if (this.f14605f != null) {
            this.f14605f.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.f14606g = i;
        this.f14608i = f;
        invalidate();
        if (this.f14605f != null) {
            this.f14605f.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.f14612m || this.f14609j == 0) {
            this.f14606g = i;
            this.f14607h = i;
            invalidate();
        }
        if (this.f14605f != null) {
            this.f14605f.onPageSelected(i);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f14606g = savedState.f14599a;
        this.f14607h = savedState.f14599a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14599a = this.f14606g;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f14604e == null || this.f14604e.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        switch (action) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f14615p = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f14614o = motionEvent.getX();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (!this.f14616q) {
                    int count = this.f14604e.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.f14606g <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.f14606g < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.f14604e.setCurrentItem(this.f14606g + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f14604e.setCurrentItem(this.f14606g - 1);
                        return true;
                    }
                }
                this.f14616q = false;
                this.f14615p = -1;
                if (!this.f14604e.isFakeDragging()) {
                    return true;
                }
                this.f14604e.endFakeDrag();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14615p));
                float f3 = x - this.f14614o;
                if (!this.f14616q && Math.abs(f3) > ((float) this.f14613n)) {
                    this.f14616q = true;
                }
                if (!this.f14616q) {
                    return true;
                }
                this.f14614o = x;
                if (!this.f14604e.isFakeDragging() && !this.f14604e.beginFakeDrag()) {
                    return true;
                }
                this.f14604e.fakeDragBy(f3);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.f14614o = MotionEventCompat.getX(motionEvent, i);
                this.f14615p = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.f14615p) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.f14615p = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.f14614o = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14615p));
                return true;
            default:
                return true;
        }
    }

    public void setCentered(boolean z) {
        this.f14611l = z;
        invalidate();
    }

    public void setCurrentItem(int i) {
        if (this.f14604e == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f14604e.setCurrentItem(i);
        this.f14606g = i;
        invalidate();
    }

    public void setFillColor(int i) {
        this.f14603d.setColor(i);
        invalidate();
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f14605f = onPageChangeListener;
    }

    public void setOrientation(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f14610k = i;
                requestLayout();
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public void setPageColor(int i) {
        this.f14601b.setColor(i);
        invalidate();
    }

    public void setRadius(float f) {
        this.f14600a = f;
        invalidate();
    }

    public void setSnap(boolean z) {
        this.f14612m = z;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.f14602c.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.f14602c.setStrokeWidth(f);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f14604e != viewPager) {
            if (this.f14604e != null) {
                this.f14604e.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f14604e = viewPager;
            this.f14604e.setOnPageChangeListener(this);
            invalidate();
        }
    }
}
