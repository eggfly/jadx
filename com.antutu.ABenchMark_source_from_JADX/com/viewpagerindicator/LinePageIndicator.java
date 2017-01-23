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

public class LinePageIndicator extends View implements C4270c {
    private final Paint f14618a;
    private final Paint f14619b;
    private ViewPager f14620c;
    private OnPageChangeListener f14621d;
    private int f14622e;
    private boolean f14623f;
    private float f14624g;
    private float f14625h;
    private int f14626i;
    private float f14627j;
    private int f14628k;
    private boolean f14629l;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f14617a;

        /* renamed from: com.viewpagerindicator.LinePageIndicator.SavedState.1 */
        static class C42721 implements Creator<SavedState> {
            C42721() {
            }

            public SavedState m17556a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m17557a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m17556a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m17557a(i);
            }
        }

        static {
            CREATOR = new C42721();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14617a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f14617a);
        }
    }

    private int m17558a(int i) {
        float f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.f14620c == null) {
            f = (float) size;
        } else {
            int count = this.f14620c.getAdapter().getCount();
            f = (((float) (count - 1)) * this.f14625h) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) count) * this.f14624g));
            if (mode == LinearLayoutManager.INVALID_OFFSET) {
                f = Math.min(f, (float) size);
            }
        }
        return (int) Math.ceil((double) f);
    }

    private int m17559b(int i) {
        float f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            f = (float) size;
        } else {
            f = (this.f14619b.getStrokeWidth() + ((float) getPaddingTop())) + ((float) getPaddingBottom());
            if (mode == LinearLayoutManager.INVALID_OFFSET) {
                f = Math.min(f, (float) size);
            }
        }
        return (int) Math.ceil((double) f);
    }

    public float getGapWidth() {
        return this.f14625h;
    }

    public float getLineWidth() {
        return this.f14624g;
    }

    public int getSelectedColor() {
        return this.f14619b.getColor();
    }

    public float getStrokeWidth() {
        return this.f14619b.getStrokeWidth();
    }

    public int getUnselectedColor() {
        return this.f14618a.getColor();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14620c != null) {
            int count = this.f14620c.getAdapter().getCount();
            if (count == 0) {
                return;
            }
            if (this.f14622e >= count) {
                setCurrentItem(count - 1);
                return;
            }
            float f = this.f14624g + this.f14625h;
            float paddingTop = (float) getPaddingTop();
            float paddingLeft = (float) getPaddingLeft();
            paddingTop += ((((float) getHeight()) - paddingTop) - ((float) getPaddingBottom())) / 2.0f;
            float width = this.f14623f ? paddingLeft + ((((((float) getWidth()) - paddingLeft) - ((float) getPaddingRight())) / 2.0f) - (((((float) count) * f) - this.f14625h) / 2.0f)) : paddingLeft;
            int i = 0;
            while (i < count) {
                float f2 = width + (((float) i) * f);
                canvas.drawLine(f2, paddingTop, f2 + this.f14624g, paddingTop, i == this.f14622e ? this.f14619b : this.f14618a);
                i++;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m17558a(i), m17559b(i2));
    }

    public void onPageScrollStateChanged(int i) {
        if (this.f14621d != null) {
            this.f14621d.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f14621d != null) {
            this.f14621d.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        this.f14622e = i;
        invalidate();
        if (this.f14621d != null) {
            this.f14621d.onPageSelected(i);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f14622e = savedState.f14617a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14617a = this.f14622e;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f14620c == null || this.f14620c.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        switch (action) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f14628k = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f14627j = motionEvent.getX();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (!this.f14629l) {
                    int count = this.f14620c.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.f14622e <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.f14622e < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.f14620c.setCurrentItem(this.f14622e + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f14620c.setCurrentItem(this.f14622e - 1);
                        return true;
                    }
                }
                this.f14629l = false;
                this.f14628k = -1;
                if (!this.f14620c.isFakeDragging()) {
                    return true;
                }
                this.f14620c.endFakeDrag();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14628k));
                float f3 = x - this.f14627j;
                if (!this.f14629l && Math.abs(f3) > ((float) this.f14626i)) {
                    this.f14629l = true;
                }
                if (!this.f14629l) {
                    return true;
                }
                this.f14627j = x;
                if (!this.f14620c.isFakeDragging() && !this.f14620c.beginFakeDrag()) {
                    return true;
                }
                this.f14620c.fakeDragBy(f3);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.f14627j = MotionEventCompat.getX(motionEvent, i);
                this.f14628k = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.f14628k) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.f14628k = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.f14627j = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14628k));
                return true;
            default:
                return true;
        }
    }

    public void setCentered(boolean z) {
        this.f14623f = z;
        invalidate();
    }

    public void setCurrentItem(int i) {
        if (this.f14620c == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f14620c.setCurrentItem(i);
        this.f14622e = i;
        invalidate();
    }

    public void setGapWidth(float f) {
        this.f14625h = f;
        invalidate();
    }

    public void setLineWidth(float f) {
        this.f14624g = f;
        invalidate();
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f14621d = onPageChangeListener;
    }

    public void setSelectedColor(int i) {
        this.f14619b.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.f14619b.setStrokeWidth(f);
        this.f14618a.setStrokeWidth(f);
        invalidate();
    }

    public void setUnselectedColor(int i) {
        this.f14618a.setColor(i);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f14620c != viewPager) {
            if (this.f14620c != null) {
                this.f14620c.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f14620c = viewPager;
            this.f14620c.setOnPageChangeListener(this);
            invalidate();
        }
    }
}
