package com.antutu.benchmark.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public abstract class BaseRoundCornerProgressBar extends LinearLayout {
    private LinearLayout f5679a;
    private LinearLayout f5680b;
    private LinearLayout f5681c;
    private int f5682d;
    private int f5683e;
    private int f5684f;
    private float f5685g;
    private float f5686h;
    private float f5687i;
    private int f5688j;
    private int f5689k;
    private int f5690l;
    private boolean f5691m;
    private C1618a f5692n;

    /* renamed from: com.antutu.benchmark.view.BaseRoundCornerProgressBar.1 */
    class C16161 implements Runnable {
        final /* synthetic */ BaseRoundCornerProgressBar f5669a;

        C16161(BaseRoundCornerProgressBar baseRoundCornerProgressBar) {
            this.f5669a = baseRoundCornerProgressBar;
        }

        public void run() {
            this.f5669a.m6390e();
            this.f5669a.m6391f();
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        float f5670a;
        float f5671b;
        float f5672c;
        int f5673d;
        int f5674e;
        int f5675f;
        int f5676g;
        int f5677h;
        boolean f5678i;

        /* renamed from: com.antutu.benchmark.view.BaseRoundCornerProgressBar.SavedState.1 */
        static class C16171 implements Creator<SavedState> {
            C16171() {
            }

            public SavedState m6383a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m6384a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m6383a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m6384a(i);
            }
        }

        static {
            CREATOR = new C16171();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5670a = parcel.readFloat();
            this.f5671b = parcel.readFloat();
            this.f5672c = parcel.readFloat();
            this.f5673d = parcel.readInt();
            this.f5674e = parcel.readInt();
            this.f5675f = parcel.readInt();
            this.f5676g = parcel.readInt();
            this.f5677h = parcel.readInt();
            this.f5678i = parcel.readByte() != null;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f5670a);
            parcel.writeFloat(this.f5671b);
            parcel.writeFloat(this.f5672c);
            parcel.writeInt(this.f5673d);
            parcel.writeInt(this.f5674e);
            parcel.writeInt(this.f5675f);
            parcel.writeInt(this.f5676g);
            parcel.writeInt(this.f5677h);
            parcel.writeByte((byte) (this.f5678i ? 1 : 0));
        }
    }

    /* renamed from: com.antutu.benchmark.view.BaseRoundCornerProgressBar.a */
    public interface C1618a {
        void m6385a(int i, float f, boolean z, boolean z2);
    }

    private void m6386a(LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(11);
            layoutParams.removeRule(21);
            layoutParams.removeRule(9);
            layoutParams.removeRule(20);
            return;
        }
        layoutParams.addRule(11, 0);
        layoutParams.addRule(9, 0);
    }

    private void m6389d() {
        Drawable a = m6394a(this.f5688j);
        int i = this.f5682d - (this.f5683e / 2);
        a.setCornerRadii(new float[]{(float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i, (float) i});
        if (VERSION.SDK_INT >= 16) {
            this.f5679a.setBackground(a);
        } else {
            this.f5679a.setBackgroundDrawable(a);
        }
    }

    private void m6390e() {
        m6396a(this.f5680b, this.f5685g, this.f5686h, (float) this.f5684f, this.f5682d, this.f5683e, this.f5689k, this.f5691m);
    }

    private void m6391f() {
        m6396a(this.f5681c, this.f5685g, this.f5687i, (float) this.f5684f, this.f5682d, this.f5683e, this.f5690l, this.f5691m);
    }

    private void m6392g() {
        setupReverse(this.f5680b);
        setupReverse(this.f5681c);
    }

    private void m6393h() {
        this.f5679a.setPadding(this.f5683e, this.f5683e, this.f5683e, this.f5683e);
    }

    private void setupReverse(LinearLayout linearLayout) {
        LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
        m6386a(layoutParams);
        if (this.f5691m) {
            layoutParams.addRule(11);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(21);
            }
        } else {
            layoutParams.addRule(9);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(20);
            }
        }
        linearLayout.setLayoutParams(layoutParams);
    }

    protected GradientDrawable m6394a(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    protected abstract void m6395a();

    protected abstract void m6396a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z);

    protected void m6397b() {
        m6389d();
        m6393h();
        m6392g();
        m6390e();
        m6391f();
        m6395a();
    }

    public boolean m6398c() {
        return this.f5691m;
    }

    public float getLayoutWidth() {
        return (float) this.f5684f;
    }

    public float getMax() {
        return this.f5685g;
    }

    public int getPadding() {
        return this.f5683e;
    }

    public float getProgress() {
        return this.f5686h;
    }

    public int getProgressBackgroundColor() {
        return this.f5688j;
    }

    public int getProgressColor() {
        return this.f5689k;
    }

    public int getRadius() {
        return this.f5682d;
    }

    public float getSecondaryProgress() {
        return this.f5687i;
    }

    public int getSecondaryProgressColor() {
        return this.f5690l;
    }

    public float getSecondaryProgressWidth() {
        return this.f5681c != null ? (float) this.f5681c.getWidth() : 0.0f;
    }

    public void invalidate() {
        super.invalidate();
        m6397b();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f5682d = savedState.f5673d;
            this.f5683e = savedState.f5674e;
            this.f5688j = savedState.f5675f;
            this.f5689k = savedState.f5676g;
            this.f5690l = savedState.f5677h;
            this.f5685g = savedState.f5670a;
            this.f5686h = savedState.f5671b;
            this.f5687i = savedState.f5672c;
            this.f5691m = savedState.f5678i;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5673d = this.f5682d;
        savedState.f5674e = this.f5683e;
        savedState.f5675f = this.f5688j;
        savedState.f5676g = this.f5689k;
        savedState.f5677h = this.f5690l;
        savedState.f5670a = this.f5685g;
        savedState.f5671b = this.f5686h;
        savedState.f5672c = this.f5687i;
        savedState.f5678i = this.f5691m;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!isInEditMode()) {
            this.f5684f = i;
            m6397b();
            postDelayed(new C16161(this), 5);
        }
    }

    public void setMax(float f) {
        if (f >= 0.0f) {
            this.f5685g = f;
        }
        if (this.f5686h > f) {
            this.f5686h = f;
        }
        m6390e();
        m6391f();
    }

    public void setOnProgressChangedListener(C1618a c1618a) {
        this.f5692n = c1618a;
    }

    public void setPadding(int i) {
        if (i >= 0) {
            this.f5683e = i;
        }
        m6393h();
        m6390e();
        m6391f();
    }

    public void setProgress(float f) {
        if (f < 0.0f) {
            this.f5686h = 0.0f;
        } else if (f > this.f5685g) {
            this.f5686h = this.f5685g;
        } else {
            this.f5686h = f;
        }
        m6390e();
        if (this.f5692n != null) {
            this.f5692n.m6385a(getId(), this.f5686h, true, false);
        }
    }

    public void setProgressBackgroundColor(int i) {
        this.f5688j = i;
        m6389d();
    }

    public void setProgressColor(int i) {
        this.f5689k = i;
        m6390e();
    }

    public void setRadius(int i) {
        if (i >= 0) {
            this.f5682d = i;
        }
        m6389d();
        m6390e();
        m6391f();
    }

    public void setReverse(boolean z) {
        this.f5691m = z;
        m6392g();
        m6390e();
        m6391f();
    }

    public void setSecondaryProgress(float f) {
        if (f < 0.0f) {
            this.f5687i = 0.0f;
        } else if (f > this.f5685g) {
            this.f5687i = this.f5685g;
        } else {
            this.f5687i = f;
        }
        m6391f();
        if (this.f5692n != null) {
            this.f5692n.m6385a(getId(), this.f5687i, false, true);
        }
    }

    public void setSecondaryProgressColor(int i) {
        this.f5690l = i;
        m6391f();
    }
}
