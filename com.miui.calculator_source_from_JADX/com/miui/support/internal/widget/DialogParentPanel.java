package com.miui.support.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.miui.support.internal.C0264R;

public class DialogParentPanel extends LinearLayout {
    private TypedValue f3091a;
    private TypedValue f3092b;
    private TypedValue f3093c;
    private TypedValue f3094d;
    private TypedValue f3095e;
    private TypedValue f3096f;
    private TypedValue f3097g;
    private TypedValue f3098h;

    public DialogParentPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.Window);
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowFixedWidthMinor)) {
            this.f3091a = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowFixedWidthMinor, this.f3091a);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowFixedHeightMajor)) {
            this.f3092b = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowFixedHeightMajor, this.f3092b);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowFixedWidthMajor)) {
            this.f3093c = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowFixedWidthMajor, this.f3093c);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowFixedHeightMinor)) {
            this.f3094d = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowFixedHeightMinor, this.f3094d);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowMaxWidthMinor)) {
            this.f3095e = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowMaxWidthMinor, this.f3095e);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowMaxWidthMajor)) {
            this.f3096f = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowMaxWidthMajor, this.f3096f);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowMaxHeightMajor)) {
            this.f3098h = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowMaxHeightMajor, this.f3098h);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowMaxHeightMinor)) {
            this.f3097g = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowMaxHeightMinor, this.f3097g);
        }
        obtainStyledAttributes.recycle();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(m4787a(i), m4790b(i2));
    }

    private int m4787a(int i) {
        return m4788a(i, true, this.f3091a, this.f3093c, this.f3095e, this.f3096f);
    }

    private int m4790b(int i) {
        return m4788a(i, false, this.f3094d, this.f3092b, this.f3097g, this.f3098h);
    }

    private int m4788a(int i, boolean z, TypedValue typedValue, TypedValue typedValue2, TypedValue typedValue3, TypedValue typedValue4) {
        if (MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return i;
        }
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        if (obj == null) {
            typedValue = typedValue2;
        }
        int a = m4789a(displayMetrics, typedValue, z);
        if (a > 0) {
            return MeasureSpec.makeMeasureSpec(a, 1073741824);
        }
        if (obj == null) {
            typedValue3 = typedValue4;
        }
        int a2 = m4789a(displayMetrics, typedValue3, z);
        if (a2 > 0) {
            return MeasureSpec.makeMeasureSpec(Math.min(a2, MeasureSpec.getSize(i)), Integer.MIN_VALUE);
        }
        return i;
    }

    private int m4789a(DisplayMetrics displayMetrics, TypedValue typedValue, boolean z) {
        if (typedValue == null) {
            return 0;
        }
        if (typedValue.type == 5) {
            return (int) typedValue.getDimension(displayMetrics);
        }
        if (typedValue.type != 6) {
            return 0;
        }
        float f = z ? (float) displayMetrics.widthPixels : (float) displayMetrics.heightPixels;
        return (int) typedValue.getFraction(f, f);
    }
}
