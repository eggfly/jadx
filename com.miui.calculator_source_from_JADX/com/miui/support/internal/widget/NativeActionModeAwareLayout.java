package com.miui.support.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;
import android.widget.LinearLayout;

public class NativeActionModeAwareLayout extends LinearLayout {
    private OnActionModeForChildListener f3165a;

    public interface OnActionModeForChildListener {
        Callback m4843a(Callback callback);
    }

    public NativeActionModeAwareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setActionModeForChildListener(OnActionModeForChildListener onActionModeForChildListener) {
        this.f3165a = onActionModeForChildListener;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        if (this.f3165a != null) {
            callback = this.f3165a.m4843a(callback);
        }
        return super.startActionModeForChild(view, callback);
    }
}
