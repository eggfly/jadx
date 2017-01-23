package com.antutu.benchmark.view;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;

public class TextRoundCornerProgressBar extends BaseRoundCornerProgressBar implements OnGlobalLayoutListener {
    private TextView f5887a;
    private int f5888b;
    private int f5889c;
    private int f5890d;
    private String f5891e;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f5883a;
        int f5884b;
        int f5885c;
        String f5886d;

        /* renamed from: com.antutu.benchmark.view.TextRoundCornerProgressBar.SavedState.1 */
        static class C16411 implements Creator<SavedState> {
            C16411() {
            }

            public SavedState m6481a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m6482a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m6481a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m6482a(i);
            }
        }

        static {
            CREATOR = new C16411();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5883a = parcel.readInt();
            this.f5884b = parcel.readInt();
            this.f5885c = parcel.readInt();
            this.f5886d = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5883a);
            parcel.writeInt(this.f5884b);
            parcel.writeInt(this.f5885c);
            parcel.writeString(this.f5886d);
        }
    }

    private void m6483d() {
        this.f5887a.setText(this.f5891e);
    }

    private void m6484e() {
        this.f5887a.setTextColor(this.f5888b);
    }

    private void m6485f() {
        this.f5887a.setTextSize(0, (float) this.f5889c);
    }

    private void m6486g() {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f5887a.getLayoutParams();
        marginLayoutParams.setMargins(this.f5890d, 0, this.f5890d, 0);
        this.f5887a.setLayoutParams(marginLayoutParams);
    }

    private void m6487h() {
        m6488i();
        if ((this.f5887a.getMeasuredWidth() + (getTextProgressMargin() * 2)) + this.f5890d < ((int) ((getLayoutWidth() - ((float) (getPadding() * 2))) / (getMax() / getProgress())))) {
            m6489j();
        } else {
            m6490k();
        }
    }

    private void m6488i() {
        LayoutParams layoutParams = (LayoutParams) this.f5887a.getLayoutParams();
        layoutParams.addRule(5, 0);
        layoutParams.addRule(7, 0);
        layoutParams.addRule(0, 0);
        layoutParams.addRule(1, 0);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(16);
            layoutParams.removeRule(17);
            layoutParams.removeRule(18);
            layoutParams.removeRule(19);
        }
        this.f5887a.setLayoutParams(layoutParams);
    }

    private void m6489j() {
        LayoutParams layoutParams = (LayoutParams) this.f5887a.getLayoutParams();
        if (m6398c()) {
            layoutParams.addRule(5, C1082R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(18, C1082R.id.layout_progress);
            }
        } else {
            layoutParams.addRule(7, C1082R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(19, C1082R.id.layout_progress);
            }
        }
        this.f5887a.setLayoutParams(layoutParams);
    }

    private void m6490k() {
        LayoutParams layoutParams = (LayoutParams) this.f5887a.getLayoutParams();
        if (m6398c()) {
            layoutParams.addRule(0, C1082R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(16, C1082R.id.layout_progress);
            }
        } else {
            layoutParams.addRule(1, C1082R.id.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(17, C1082R.id.layout_progress);
            }
        }
        this.f5887a.setLayoutParams(layoutParams);
    }

    protected void m6491a() {
        m6483d();
        m6485f();
        m6486g();
        m6487h();
        m6484e();
    }

    protected void m6492a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z) {
        Drawable a = m6394a(i3);
        int i4 = i - (i2 / 2);
        a.setCornerRadii(new float[]{(float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4});
        if (VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(a);
        } else {
            linearLayout.setBackgroundDrawable(a);
        }
        int i5 = (int) ((f3 - ((float) (i2 * 2))) / (f / f2));
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = i5;
        linearLayout.setLayoutParams(layoutParams);
    }

    public String getProgressText() {
        return this.f5891e;
    }

    public int getTextProgressColor() {
        return this.f5888b;
    }

    public int getTextProgressMargin() {
        return this.f5890d;
    }

    public int getTextProgressSize() {
        return this.f5889c;
    }

    public void onGlobalLayout() {
        if (VERSION.SDK_INT >= 16) {
            this.f5887a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            this.f5887a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        m6487h();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f5888b = savedState.f5883a;
            this.f5889c = savedState.f5884b;
            this.f5890d = savedState.f5885c;
            this.f5891e = savedState.f5886d;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5883a = this.f5888b;
        savedState.f5884b = this.f5889c;
        savedState.f5885c = this.f5890d;
        savedState.f5886d = this.f5891e;
        return savedState;
    }

    public void setProgress(float f) {
        super.setProgress(f);
        m6487h();
    }

    public void setProgressText(String str) {
        this.f5891e = str;
        m6483d();
        m6487h();
    }

    public void setTextProgressColor(int i) {
        this.f5888b = i;
        m6484e();
    }

    public void setTextProgressMargin(int i) {
        this.f5890d = i;
        m6486g();
        m6487h();
    }

    public void setTextProgressSize(int i) {
        this.f5889c = i;
        m6485f();
        m6487h();
    }
}
