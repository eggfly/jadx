package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class UnderlinePageIndicator extends View implements C4270c {
    private final Paint f14685a;
    private boolean f14686b;
    private int f14687c;
    private int f14688d;
    private int f14689e;
    private ViewPager f14690f;
    private OnPageChangeListener f14691g;
    private int f14692h;
    private int f14693i;
    private float f14694j;
    private int f14695k;
    private float f14696l;
    private int f14697m;
    private boolean f14698n;
    private final Runnable f14699o;

    /* renamed from: com.viewpagerindicator.UnderlinePageIndicator.1 */
    class C42831 implements Runnable {
        final /* synthetic */ UnderlinePageIndicator f14682a;

        public void run() {
            if (this.f14682a.f14686b) {
                int max = Math.max(this.f14682a.f14685a.getAlpha() - this.f14682a.f14689e, 0);
                this.f14682a.f14685a.setAlpha(max);
                this.f14682a.invalidate();
                if (max > 0) {
                    this.f14682a.postDelayed(this, 30);
                }
            }
        }
    }

    /* renamed from: com.viewpagerindicator.UnderlinePageIndicator.2 */
    class C42842 implements Runnable {
        final /* synthetic */ UnderlinePageIndicator f14683a;

        C42842(UnderlinePageIndicator underlinePageIndicator) {
            this.f14683a = underlinePageIndicator;
        }

        public void run() {
            if (this.f14683a.f14686b) {
                this.f14683a.post(this.f14683a.f14699o);
            }
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f14684a;

        /* renamed from: com.viewpagerindicator.UnderlinePageIndicator.SavedState.1 */
        static class C42851 implements Creator<SavedState> {
            C42851() {
            }

            public SavedState m17578a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m17579a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m17578a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m17579a(i);
            }
        }

        static {
            CREATOR = new C42851();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14684a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f14684a);
        }
    }

    public int getFadeDelay() {
        return this.f14687c;
    }

    public int getFadeLength() {
        return this.f14688d;
    }

    public boolean getFades() {
        return this.f14686b;
    }

    public int getSelectedColor() {
        return this.f14685a.getColor();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14690f != null) {
            int count = this.f14690f.getAdapter().getCount();
            if (count == 0) {
                return;
            }
            if (this.f14693i >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int paddingLeft = getPaddingLeft();
            float width = ((float) ((getWidth() - paddingLeft) - getPaddingRight())) / (((float) count) * 1.0f);
            float f = ((float) paddingLeft) + ((((float) this.f14693i) + this.f14694j) * width);
            float f2 = f + width;
            canvas.drawRect(f, (float) getPaddingTop(), f2, (float) (getHeight() - getPaddingBottom()), this.f14685a);
        }
    }

    public void onPageScrollStateChanged(int i) {
        this.f14692h = i;
        if (this.f14691g != null) {
            this.f14691g.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.f14693i = i;
        this.f14694j = f;
        if (this.f14686b) {
            if (i2 > 0) {
                removeCallbacks(this.f14699o);
                this.f14685a.setAlpha(MotionEventCompat.ACTION_MASK);
            } else if (this.f14692h != 1) {
                postDelayed(this.f14699o, (long) this.f14687c);
            }
        }
        invalidate();
        if (this.f14691g != null) {
            this.f14691g.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.f14692h == 0) {
            this.f14693i = i;
            this.f14694j = 0.0f;
            invalidate();
            this.f14699o.run();
        }
        if (this.f14691g != null) {
            this.f14691g.onPageSelected(i);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f14693i = savedState.f14684a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14684a = this.f14693i;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f14690f == null || this.f14690f.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        switch (action) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f14697m = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f14696l = motionEvent.getX();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (!this.f14698n) {
                    int count = this.f14690f.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.f14693i <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.f14693i < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.f14690f.setCurrentItem(this.f14693i + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f14690f.setCurrentItem(this.f14693i - 1);
                        return true;
                    }
                }
                this.f14698n = false;
                this.f14697m = -1;
                if (!this.f14690f.isFakeDragging()) {
                    return true;
                }
                this.f14690f.endFakeDrag();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14697m));
                float f3 = x - this.f14696l;
                if (!this.f14698n && Math.abs(f3) > ((float) this.f14695k)) {
                    this.f14698n = true;
                }
                if (!this.f14698n) {
                    return true;
                }
                this.f14696l = x;
                if (!this.f14690f.isFakeDragging() && !this.f14690f.beginFakeDrag()) {
                    return true;
                }
                this.f14690f.fakeDragBy(f3);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.f14696l = MotionEventCompat.getX(motionEvent, i);
                this.f14697m = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.f14697m) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.f14697m = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.f14696l = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14697m));
                return true;
            default:
                return true;
        }
    }

    public void setCurrentItem(int i) {
        if (this.f14690f == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f14690f.setCurrentItem(i);
        this.f14693i = i;
        invalidate();
    }

    public void setFadeDelay(int i) {
        this.f14687c = i;
    }

    public void setFadeLength(int i) {
        this.f14688d = i;
        this.f14689e = MotionEventCompat.ACTION_MASK / (this.f14688d / 30);
    }

    public void setFades(boolean z) {
        if (z != this.f14686b) {
            this.f14686b = z;
            if (z) {
                post(this.f14699o);
                return;
            }
            removeCallbacks(this.f14699o);
            this.f14685a.setAlpha(MotionEventCompat.ACTION_MASK);
            invalidate();
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f14691g = onPageChangeListener;
    }

    public void setSelectedColor(int i) {
        this.f14685a.setColor(i);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f14690f != viewPager) {
            if (this.f14690f != null) {
                this.f14690f.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f14690f = viewPager;
            this.f14690f.setOnPageChangeListener(this);
            invalidate();
            post(new C42842(this));
        }
    }
}
