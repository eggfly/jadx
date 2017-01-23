package com.miui.support.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;

public class GroupButton extends Button {
    private static final int[] f3126a;
    private static final int[] f3127b;
    private static final int[] f3128c;
    private static final int[] f3129d;

    static {
        f3126a = new int[]{16842916};
        f3127b = new int[]{16842917};
        f3128c = new int[]{16842918};
        f3129d = new int[]{16842915};
    }

    public GroupButton(Context context) {
        super(context);
    }

    public GroupButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GroupButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected int[] onCreateDrawableState(int i) {
        int i2 = 1;
        Log.d("wuhua", "onCreateDrawableState");
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return super.onCreateDrawableState(i);
        }
        int i3;
        int childCount = viewGroup.getChildCount();
        int i4 = viewGroup.getChildCount() == 1 ? 1 : 0;
        if (viewGroup.getChildAt(0) == this) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (viewGroup.getChildAt(childCount - 1) != this) {
            i2 = 0;
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 4);
        if (i4 != 0) {
            Log.d("wuhua", "single");
            mergeDrawableStates(onCreateDrawableState, f3129d);
            return onCreateDrawableState;
        } else if (i3 != 0) {
            Log.d("wuhua", "first");
            mergeDrawableStates(onCreateDrawableState, f3126a);
            return onCreateDrawableState;
        } else if (i2 != 0) {
            Log.d("wuhua", "last");
            mergeDrawableStates(onCreateDrawableState, f3128c);
            return onCreateDrawableState;
        } else {
            Log.d("wuhua", "middle");
            mergeDrawableStates(onCreateDrawableState, f3127b);
            return onCreateDrawableState;
        }
    }
}
