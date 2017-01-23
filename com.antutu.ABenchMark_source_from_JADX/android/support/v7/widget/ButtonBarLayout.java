package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0417R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.antutu.utils.widget.SystemBarTintManager;

public class ButtonBarLayout extends LinearLayout {
    private boolean f1449a;
    private int f1450b;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1450b = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0417R.styleable.ButtonBarLayout);
        this.f1449a = obtainStyledAttributes.getBoolean(C0417R.styleable.ButtonBarLayout_allowStacking, false);
        obtainStyledAttributes.recycle();
    }

    private boolean m1670a() {
        return getOrientation() == 1;
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(C0417R.id.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        boolean z2 = false;
        int size = MeasureSpec.getSize(i);
        if (this.f1449a) {
            if (size > this.f1450b && m1670a()) {
                setStacked(false);
            }
            this.f1450b = size;
        }
        if (m1670a() || MeasureSpec.getMode(i) != 1073741824) {
            i3 = i;
            z = false;
        } else {
            i3 = MeasureSpec.makeMeasureSpec(size, LinearLayoutManager.INVALID_OFFSET);
            z = true;
        }
        super.onMeasure(i3, i2);
        if (this.f1449a && !m1670a()) {
            if (VERSION.SDK_INT < 11) {
                int i4 = 0;
                for (i3 = 0; i3 < getChildCount(); i3++) {
                    i4 += getChildAt(i3).getMeasuredWidth();
                }
                if ((getPaddingLeft() + i4) + getPaddingRight() > size) {
                    z2 = true;
                }
            } else if ((ViewCompat.getMeasuredWidthAndState(this) & SystemBarTintManager.DEFAULT_TINT_COLOR) == ViewCompat.MEASURED_STATE_TOO_SMALL) {
                z2 = true;
            }
            if (z2) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i, i2);
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f1449a != z) {
            this.f1449a = z;
            if (!this.f1449a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
