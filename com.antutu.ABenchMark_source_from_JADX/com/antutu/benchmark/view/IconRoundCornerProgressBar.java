package com.antutu.benchmark.view;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.antutu.ABenchMark.C1082R;

public class IconRoundCornerProgressBar extends BaseRoundCornerProgressBar implements OnClickListener {
    private ImageView f5790a;
    private int f5791b;
    private int f5792c;
    private int f5793d;
    private int f5794e;
    private int f5795f;
    private int f5796g;
    private int f5797h;
    private int f5798i;
    private int f5799j;
    private int f5800k;
    private C1628a f5801l;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f5780a;
        int f5781b;
        int f5782c;
        int f5783d;
        int f5784e;
        int f5785f;
        int f5786g;
        int f5787h;
        int f5788i;
        int f5789j;

        /* renamed from: com.antutu.benchmark.view.IconRoundCornerProgressBar.SavedState.1 */
        static class C16271 implements Creator<SavedState> {
            C16271() {
            }

            public SavedState m6426a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m6427a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m6426a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m6427a(i);
            }
        }

        static {
            CREATOR = new C16271();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f5780a = parcel.readInt();
            this.f5781b = parcel.readInt();
            this.f5782c = parcel.readInt();
            this.f5783d = parcel.readInt();
            this.f5784e = parcel.readInt();
            this.f5785f = parcel.readInt();
            this.f5786g = parcel.readInt();
            this.f5787h = parcel.readInt();
            this.f5788i = parcel.readInt();
            this.f5789j = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5780a);
            parcel.writeInt(this.f5781b);
            parcel.writeInt(this.f5782c);
            parcel.writeInt(this.f5783d);
            parcel.writeInt(this.f5784e);
            parcel.writeInt(this.f5785f);
            parcel.writeInt(this.f5786g);
            parcel.writeInt(this.f5787h);
            parcel.writeInt(this.f5788i);
            parcel.writeInt(this.f5789j);
        }
    }

    /* renamed from: com.antutu.benchmark.view.IconRoundCornerProgressBar.a */
    public interface C1628a {
        void m6428a();
    }

    private void m6429d() {
        this.f5790a.setImageResource(this.f5791b);
    }

    private void m6430e() {
        if (this.f5792c == -1) {
            this.f5790a.setLayoutParams(new LayoutParams(this.f5793d, this.f5794e));
        } else {
            this.f5790a.setLayoutParams(new LayoutParams(this.f5792c, this.f5792c));
        }
    }

    private void m6431f() {
        if (this.f5795f == -1 || this.f5795f == 0) {
            this.f5790a.setPadding(this.f5796g, this.f5798i, this.f5797h, this.f5799j);
        } else {
            this.f5790a.setPadding(this.f5795f, this.f5795f, this.f5795f, this.f5795f);
        }
        this.f5790a.invalidate();
    }

    private void m6432g() {
        Drawable a = m6394a(this.f5800k);
        int radius = getRadius() - (getPadding() / 2);
        a.setCornerRadii(new float[]{(float) radius, (float) radius, 0.0f, 0.0f, 0.0f, 0.0f, (float) radius, (float) radius});
        if (VERSION.SDK_INT >= 16) {
            this.f5790a.setBackground(a);
        } else {
            this.f5790a.setBackgroundDrawable(a);
        }
    }

    protected void m6433a() {
        m6429d();
        m6430e();
        m6431f();
        m6432g();
    }

    protected void m6434a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z) {
        Drawable a = m6394a(i3);
        int i4 = i - (i2 / 2);
        if (!z || f2 == f) {
            a.setCornerRadii(new float[]{0.0f, 0.0f, (float) i4, (float) i4, (float) i4, (float) i4, 0.0f, 0.0f});
        } else {
            a.setCornerRadii(new float[]{(float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4});
        }
        if (VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(a);
        } else {
            linearLayout.setBackgroundDrawable(a);
        }
        int width = (int) ((f3 - ((float) ((i2 * 2) + this.f5790a.getWidth()))) / (f / f2));
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = width;
        linearLayout.setLayoutParams(layoutParams);
    }

    public int getColorIconBackground() {
        return this.f5800k;
    }

    public int getIconImageResource() {
        return this.f5791b;
    }

    public int getIconPadding() {
        return this.f5795f;
    }

    public int getIconPaddingBottom() {
        return this.f5799j;
    }

    public int getIconPaddingLeft() {
        return this.f5796g;
    }

    public int getIconPaddingRight() {
        return this.f5797h;
    }

    public int getIconPaddingTop() {
        return this.f5798i;
    }

    public int getIconSize() {
        return this.f5792c;
    }

    public void onClick(View view) {
        if (view.getId() == C1082R.id.iv_progress_icon && this.f5801l != null) {
            this.f5801l.m6428a();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f5791b = savedState.f5780a;
            this.f5792c = savedState.f5781b;
            this.f5793d = savedState.f5782c;
            this.f5794e = savedState.f5783d;
            this.f5795f = savedState.f5784e;
            this.f5796g = savedState.f5785f;
            this.f5797h = savedState.f5786g;
            this.f5798i = savedState.f5787h;
            this.f5799j = savedState.f5788i;
            this.f5800k = savedState.f5789j;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5780a = this.f5791b;
        savedState.f5781b = this.f5792c;
        savedState.f5782c = this.f5793d;
        savedState.f5783d = this.f5794e;
        savedState.f5784e = this.f5795f;
        savedState.f5785f = this.f5796g;
        savedState.f5786g = this.f5797h;
        savedState.f5787h = this.f5798i;
        savedState.f5788i = this.f5799j;
        savedState.f5789j = this.f5800k;
        return savedState;
    }

    public void setIconBackgroundColor(int i) {
        this.f5800k = i;
        m6432g();
    }

    public void setIconImageResource(int i) {
        this.f5791b = i;
        m6429d();
    }

    public void setIconPadding(int i) {
        if (i >= 0) {
            this.f5795f = i;
        }
        m6431f();
    }

    public void setIconPaddingBottom(int i) {
        if (i > 0) {
            this.f5799j = i;
        }
        m6431f();
    }

    public void setIconPaddingLeft(int i) {
        if (i > 0) {
            this.f5796g = i;
        }
        m6431f();
    }

    public void setIconPaddingRight(int i) {
        if (i > 0) {
            this.f5797h = i;
        }
        m6431f();
    }

    public void setIconPaddingTop(int i) {
        if (i > 0) {
            this.f5798i = i;
        }
        m6431f();
    }

    public void setIconSize(int i) {
        if (i >= 0) {
            this.f5792c = i;
        }
        m6430e();
    }

    public void setOnIconClickListener(C1628a c1628a) {
        this.f5801l = c1628a;
    }
}
