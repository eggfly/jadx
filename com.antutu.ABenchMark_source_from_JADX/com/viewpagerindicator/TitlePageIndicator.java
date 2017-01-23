package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class TitlePageIndicator extends View implements C4270c {
    private C4282c f14655A;
    private ViewPager f14656a;
    private OnPageChangeListener f14657b;
    private int f14658c;
    private float f14659d;
    private int f14660e;
    private final Paint f14661f;
    private boolean f14662g;
    private int f14663h;
    private int f14664i;
    private Path f14665j;
    private final Rect f14666k;
    private final Paint f14667l;
    private C4280a f14668m;
    private C4281b f14669n;
    private final Paint f14670o;
    private float f14671p;
    private float f14672q;
    private float f14673r;
    private float f14674s;
    private float f14675t;
    private float f14676u;
    private float f14677v;
    private int f14678w;
    private float f14679x;
    private int f14680y;
    private boolean f14681z;

    /* renamed from: com.viewpagerindicator.TitlePageIndicator.1 */
    static /* synthetic */ class C42781 {
        static final /* synthetic */ int[] f14644a;

        static {
            f14644a = new int[C4280a.values().length];
            try {
                f14644a[C4280a.Triangle.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14644a[C4280a.Underline.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f14645a;

        /* renamed from: com.viewpagerindicator.TitlePageIndicator.SavedState.1 */
        static class C42791 implements Creator<SavedState> {
            C42791() {
            }

            public SavedState m17570a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m17571a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m17570a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m17571a(i);
            }
        }

        static {
            CREATOR = new C42791();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f14645a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f14645a);
        }
    }

    /* renamed from: com.viewpagerindicator.TitlePageIndicator.a */
    public enum C4280a {
        None(0),
        Triangle(1),
        Underline(2);
        
        public final int f14650d;

        private C4280a(int i) {
            this.f14650d = i;
        }
    }

    /* renamed from: com.viewpagerindicator.TitlePageIndicator.b */
    public enum C4281b {
        Bottom(0),
        Top(1);
        
        public final int f14654c;

        private C4281b(int i) {
            this.f14654c = i;
        }
    }

    /* renamed from: com.viewpagerindicator.TitlePageIndicator.c */
    public interface C4282c {
        void m17572a(int i);
    }

    private Rect m17573a(int i, Paint paint) {
        Rect rect = new Rect();
        CharSequence a = m17574a(i);
        rect.right = (int) paint.measureText(a, 0, a.length());
        rect.bottom = (int) (paint.descent() - paint.ascent());
        return rect;
    }

    private CharSequence m17574a(int i) {
        CharSequence pageTitle = this.f14656a.getAdapter().getPageTitle(i);
        return pageTitle == null ? BuildConfig.FLAVOR : pageTitle;
    }

    private ArrayList<Rect> m17575a(Paint paint) {
        ArrayList<Rect> arrayList = new ArrayList();
        int count = this.f14656a.getAdapter().getCount();
        int width = getWidth();
        int i = width / 2;
        for (int i2 = 0; i2 < count; i2++) {
            Rect a = m17573a(i2, paint);
            int i3 = a.right - a.left;
            int i4 = a.bottom - a.top;
            a.left = (int) ((((float) i) - (((float) i3) / 2.0f)) + ((((float) (i2 - this.f14658c)) - this.f14659d) * ((float) width)));
            a.right = i3 + a.left;
            a.top = 0;
            a.bottom = i4;
            arrayList.add(a);
        }
        return arrayList;
    }

    private void m17576a(Rect rect, float f, int i) {
        rect.right = (int) (((float) i) - this.f14676u);
        rect.left = (int) (((float) rect.right) - f);
    }

    private void m17577b(Rect rect, float f, int i) {
        rect.left = (int) (((float) i) + this.f14676u);
        rect.right = (int) (this.f14676u + f);
    }

    public float getClipPadding() {
        return this.f14676u;
    }

    public int getFooterColor() {
        return this.f14667l.getColor();
    }

    public float getFooterIndicatorHeight() {
        return this.f14671p;
    }

    public float getFooterIndicatorPadding() {
        return this.f14673r;
    }

    public C4280a getFooterIndicatorStyle() {
        return this.f14668m;
    }

    public float getFooterLineHeight() {
        return this.f14677v;
    }

    public C4281b getLinePosition() {
        return this.f14669n;
    }

    public int getSelectedColor() {
        return this.f14664i;
    }

    public int getTextColor() {
        return this.f14663h;
    }

    public float getTextSize() {
        return this.f14661f.getTextSize();
    }

    public float getTitlePadding() {
        return this.f14674s;
    }

    public float getTopPadding() {
        return this.f14675t;
    }

    public Typeface getTypeface() {
        return this.f14661f.getTypeface();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14656a != null) {
            int count = this.f14656a.getAdapter().getCount();
            if (count != 0) {
                if (this.f14658c == -1 && this.f14656a != null) {
                    this.f14658c = this.f14656a.getCurrentItem();
                }
                ArrayList a = m17575a(this.f14661f);
                int size = a.size();
                if (this.f14658c >= size) {
                    setCurrentItem(size - 1);
                    return;
                }
                int i;
                float f;
                int i2;
                Rect rect;
                int i3 = count - 1;
                float width = ((float) getWidth()) / 2.0f;
                int left = getLeft();
                float f2 = ((float) left) + this.f14676u;
                int width2 = getWidth();
                int height = getHeight();
                int i4 = left + width2;
                float f3 = ((float) i4) - this.f14676u;
                int i5 = this.f14658c;
                if (((double) this.f14659d) <= 0.5d) {
                    i = i5;
                    f = this.f14659d;
                } else {
                    i = i5 + 1;
                    f = 1.0f - this.f14659d;
                }
                Object obj = f <= 0.25f ? 1 : null;
                Object obj2 = f <= 0.05f ? 1 : null;
                float f4 = (0.25f - f) / 0.25f;
                Rect rect2 = (Rect) a.get(this.f14658c);
                f = (float) (rect2.right - rect2.left);
                if (((float) rect2.left) < f2) {
                    m17577b(rect2, f, left);
                }
                if (((float) rect2.right) > f3) {
                    m17576a(rect2, f, i4);
                }
                if (this.f14658c > 0) {
                    for (i2 = this.f14658c - 1; i2 >= 0; i2--) {
                        rect2 = (Rect) a.get(i2);
                        if (((float) rect2.left) < f2) {
                            int i6 = rect2.right - rect2.left;
                            m17577b(rect2, (float) i6, left);
                            rect = (Rect) a.get(i2 + 1);
                            if (((float) rect2.right) + this.f14674s > ((float) rect.left)) {
                                rect2.left = (int) (((float) (rect.left - i6)) - this.f14674s);
                                rect2.right = rect2.left + i6;
                            }
                        }
                    }
                }
                if (this.f14658c < i3) {
                    for (i2 = this.f14658c + 1; i2 < count; i2++) {
                        rect2 = (Rect) a.get(i2);
                        if (((float) rect2.right) > f3) {
                            i3 = rect2.right - rect2.left;
                            m17576a(rect2, (float) i3, i4);
                            rect = (Rect) a.get(i2 - 1);
                            if (((float) rect2.left) - this.f14674s < ((float) rect.right)) {
                                rect2.left = (int) (((float) rect.right) + this.f14674s);
                                rect2.right = rect2.left + i3;
                            }
                        }
                    }
                }
                int i7 = this.f14663h >>> 24;
                int i8 = 0;
                while (i8 < count) {
                    Rect rect3 = (Rect) a.get(i8);
                    if ((rect3.left > left && rect3.left < i4) || (rect3.right > left && rect3.right < i4)) {
                        Object obj3 = i8 == i ? 1 : null;
                        CharSequence a2 = m17574a(i8);
                        Paint paint = this.f14661f;
                        boolean z = (obj3 == null || obj2 == null || !this.f14662g) ? false : true;
                        paint.setFakeBoldText(z);
                        this.f14661f.setColor(this.f14663h);
                        if (!(obj3 == null || obj == null)) {
                            this.f14661f.setAlpha(i7 - ((int) (((float) i7) * f4)));
                        }
                        if (i8 < size - 1) {
                            rect2 = (Rect) a.get(i8 + 1);
                            if (((float) rect3.right) + this.f14674s > ((float) rect2.left)) {
                                i2 = rect3.right - rect3.left;
                                rect3.left = (int) (((float) (rect2.left - i2)) - this.f14674s);
                                rect3.right = rect3.left + i2;
                            }
                        }
                        canvas.drawText(a2, 0, a2.length(), (float) rect3.left, this.f14675t + ((float) rect3.bottom), this.f14661f);
                        if (!(obj3 == null || obj == null)) {
                            this.f14661f.setColor(this.f14664i);
                            this.f14661f.setAlpha((int) (((float) (this.f14664i >>> 24)) * f4));
                            canvas.drawText(a2, 0, a2.length(), (float) rect3.left, this.f14675t + ((float) rect3.bottom), this.f14661f);
                        }
                    }
                    i8++;
                }
                f = this.f14677v;
                float f5 = this.f14671p;
                float f6;
                if (this.f14669n == C4281b.Top) {
                    i2 = 0;
                    f6 = -f5;
                    f5 = -f;
                    f = f6;
                } else {
                    i2 = height;
                    f6 = f;
                    f = f5;
                    f5 = f6;
                }
                this.f14665j.reset();
                this.f14665j.moveTo(0.0f, ((float) i2) - (f5 / 2.0f));
                this.f14665j.lineTo((float) width2, ((float) i2) - (f5 / 2.0f));
                this.f14665j.close();
                canvas.drawPath(this.f14665j, this.f14667l);
                float f7 = ((float) i2) - f5;
                switch (C42781.f14644a[this.f14668m.ordinal()]) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        this.f14665j.reset();
                        this.f14665j.moveTo(width, f7 - f);
                        this.f14665j.lineTo(width + f, f7);
                        this.f14665j.lineTo(width - f, f7);
                        this.f14665j.close();
                        canvas.drawPath(this.f14665j, this.f14670o);
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (obj != null && i < size) {
                            rect2 = (Rect) a.get(i);
                            float f8 = ((float) rect2.right) + this.f14672q;
                            f5 = ((float) rect2.left) - this.f14672q;
                            f = f7 - f;
                            this.f14665j.reset();
                            this.f14665j.moveTo(f5, f7);
                            this.f14665j.lineTo(f8, f7);
                            this.f14665j.lineTo(f8, f);
                            this.f14665j.lineTo(f5, f);
                            this.f14665j.close();
                            this.f14670o.setAlpha((int) (255.0f * f4));
                            canvas.drawPath(this.f14665j, this.f14670o);
                            this.f14670o.setAlpha(MotionEventCompat.ACTION_MASK);
                        }
                    default:
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        float size;
        int size2 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            size = (float) MeasureSpec.getSize(i2);
        } else {
            this.f14666k.setEmpty();
            this.f14666k.bottom = (int) (this.f14661f.descent() - this.f14661f.ascent());
            size = ((((float) (this.f14666k.bottom - this.f14666k.top)) + this.f14677v) + this.f14673r) + this.f14675t;
            if (this.f14668m != C4280a.None) {
                size += this.f14671p;
            }
        }
        setMeasuredDimension(size2, (int) size);
    }

    public void onPageScrollStateChanged(int i) {
        this.f14660e = i;
        if (this.f14657b != null) {
            this.f14657b.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.f14658c = i;
        this.f14659d = f;
        invalidate();
        if (this.f14657b != null) {
            this.f14657b.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.f14660e == 0) {
            this.f14658c = i;
            invalidate();
        }
        if (this.f14657b != null) {
            this.f14657b.onPageSelected(i);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f14658c = savedState.f14645a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14645a = this.f14658c;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f14656a == null || this.f14656a.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & MotionEventCompat.ACTION_MASK;
        switch (action) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.f14680y = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f14679x = motionEvent.getX();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (!this.f14681z) {
                    int count = this.f14656a.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    float f3 = f - f2;
                    f2 += f;
                    f = motionEvent.getX();
                    if (f < f3) {
                        if (this.f14658c > 0) {
                            if (action == 3) {
                                return true;
                            }
                            this.f14656a.setCurrentItem(this.f14658c - 1);
                            return true;
                        }
                    } else if (f > f2) {
                        if (this.f14658c < count - 1) {
                            if (action == 3) {
                                return true;
                            }
                            this.f14656a.setCurrentItem(this.f14658c + 1);
                            return true;
                        }
                    } else if (!(this.f14655A == null || action == 3)) {
                        this.f14655A.m17572a(this.f14658c);
                    }
                }
                this.f14681z = false;
                this.f14680y = -1;
                if (!this.f14656a.isFakeDragging()) {
                    return true;
                }
                this.f14656a.endFakeDrag();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14680y));
                float f4 = x - this.f14679x;
                if (!this.f14681z && Math.abs(f4) > ((float) this.f14678w)) {
                    this.f14681z = true;
                }
                if (!this.f14681z) {
                    return true;
                }
                this.f14679x = x;
                if (!this.f14656a.isFakeDragging() && !this.f14656a.beginFakeDrag()) {
                    return true;
                }
                this.f14656a.fakeDragBy(f4);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.f14679x = MotionEventCompat.getX(motionEvent, i);
                this.f14680y = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.f14680y) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.f14680y = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.f14679x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f14680y));
                return true;
            default:
                return true;
        }
    }

    public void setClipPadding(float f) {
        this.f14676u = f;
        invalidate();
    }

    public void setCurrentItem(int i) {
        if (this.f14656a == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f14656a.setCurrentItem(i);
        this.f14658c = i;
        invalidate();
    }

    public void setFooterColor(int i) {
        this.f14667l.setColor(i);
        this.f14670o.setColor(i);
        invalidate();
    }

    public void setFooterIndicatorHeight(float f) {
        this.f14671p = f;
        invalidate();
    }

    public void setFooterIndicatorPadding(float f) {
        this.f14673r = f;
        invalidate();
    }

    public void setFooterIndicatorStyle(C4280a c4280a) {
        this.f14668m = c4280a;
        invalidate();
    }

    public void setFooterLineHeight(float f) {
        this.f14677v = f;
        this.f14667l.setStrokeWidth(this.f14677v);
        invalidate();
    }

    public void setLinePosition(C4281b c4281b) {
        this.f14669n = c4281b;
        invalidate();
    }

    public void setOnCenterItemClickListener(C4282c c4282c) {
        this.f14655A = c4282c;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f14657b = onPageChangeListener;
    }

    public void setSelectedBold(boolean z) {
        this.f14662g = z;
        invalidate();
    }

    public void setSelectedColor(int i) {
        this.f14664i = i;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f14661f.setColor(i);
        this.f14663h = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f14661f.setTextSize(f);
        invalidate();
    }

    public void setTitlePadding(float f) {
        this.f14674s = f;
        invalidate();
    }

    public void setTopPadding(float f) {
        this.f14675t = f;
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        this.f14661f.setTypeface(typeface);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f14656a != viewPager) {
            if (this.f14656a != null) {
                this.f14656a.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f14656a = viewPager;
            this.f14656a.setOnPageChangeListener(this);
            invalidate();
        }
    }
}
