package com.miui.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.HashMap;

public class ImageTextView extends LinearLayout {
    private static final int[] f4174b;
    private final LayoutParams f4175a;
    private HashMap<Character, Integer> f4176c;
    private CharSequence f4177d;

    static {
        f4174b = new int[]{16842930, 16843256};
    }

    public ImageTextView(Context context) {
        this(context, null);
    }

    public ImageTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4175a = new LayoutParams(-2, -2);
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4174b, i, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(0);
        Integer[] a = m5873a(obtainStyledAttributes);
        if (!(textArray == null || a == null || textArray.length != a.length)) {
            this.f4176c = new HashMap();
            for (int i2 = 0; i2 < textArray.length; i2++) {
                this.f4176c.put(Character.valueOf(textArray[i2].charAt(0)), a[i2]);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private Integer[] m5873a(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(1, typedValue)) {
            return null;
        }
        TypedArray obtainTypedArray = getContext().getResources().obtainTypedArray(typedValue.resourceId);
        Integer[] numArr = new Integer[obtainTypedArray.length()];
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            numArr[i] = Integer.valueOf(obtainTypedArray.peekValue(i).resourceId);
        }
        obtainTypedArray.recycle();
        return numArr;
    }

    public void setCharMap(HashMap<Character, Integer> hashMap) {
        this.f4176c = hashMap;
    }

    public CharSequence getText() {
        return this.f4177d == null ? "" : this.f4177d;
    }

    public void setText(CharSequence charSequence) {
        if (this.f4176c != null && charSequence != null && !charSequence.equals(this.f4177d)) {
            this.f4177d = charSequence;
            for (int i = 0; i < charSequence.length(); i++) {
                View childAt;
                if (i < getChildCount()) {
                    childAt = getChildAt(i);
                } else {
                    View imageView = new ImageView(getContext());
                    imageView.setLayoutParams(this.f4175a);
                    addView(imageView);
                    childAt = imageView;
                }
                Integer num = (Integer) this.f4176c.get(Character.valueOf(charSequence.charAt(i)));
                if (num != null) {
                    childAt.setBackground(getResources().getDrawable(num.intValue()));
                }
            }
            for (int childCount = getChildCount(); childCount > charSequence.length(); childCount--) {
                removeViewAt(childCount - 1);
            }
        }
    }
}
