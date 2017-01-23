package com.miui.support.internal.variable.hook.v16;

import android.widget.AbsSpinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import com.miui.support.internal.C0264R;
import com.miui.support.util.AttributeResolver;

public class Android_Widget_AbsSpinner_class extends com.miui.support.internal.variable.hook.Android_Widget_AbsSpinner_class {
    public void buildProxy() {
        attachMethod("setAdapter", "(Landroid/widget/SpinnerAdapter;)V");
    }

    protected void handle() {
        handleSetAdapter(0, null, null);
    }

    protected void handleSetAdapter(long j, AbsSpinner absSpinner, SpinnerAdapter spinnerAdapter) {
        if ((spinnerAdapter instanceof ArrayAdapter) && AttributeResolver.m5318a(absSpinner.getContext())) {
            ((ArrayAdapter) spinnerAdapter).setDropDownViewResource(C0264R.layout.simple_spinner_dropdown_item);
        }
        originalSetAdapter(j, absSpinner, spinnerAdapter);
    }

    protected void originalSetAdapter(long j, AbsSpinner absSpinner, SpinnerAdapter spinnerAdapter) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_Widget_AbsSpinner_class.original_init_(long, AbsSpinner, Context, AttributeSet, int)");
    }
}
