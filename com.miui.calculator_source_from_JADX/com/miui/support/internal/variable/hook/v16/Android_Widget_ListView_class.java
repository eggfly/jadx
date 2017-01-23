package com.miui.support.internal.variable.hook.v16;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ListView;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.TaggingDrawableHelper;

public class Android_Widget_ListView_class extends com.miui.support.internal.variable.hook.Android_Widget_ListView_class {
    public void buildProxy() {
        attachMethod("layoutChildren", "()V");
        attachMethod("fillGap", "(Z)V");
        attachSpecialMethod();
    }

    protected void handle() {
        handleLayoutChildren(0, null);
        handleFillGap(0, null, false);
        handle_init_(0, null, null, null, 0);
    }

    protected void attachSpecialMethod() {
        attachConstructor("(Landroid/content/Context;Landroid/util/AttributeSet;I)V");
    }

    protected void doInit(ListView listView, Context context) {
        if (listView.getPaddingLeft() == 0 && listView.getPaddingRight() == 0) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0264R.dimen.listview_horizontal_padding);
            if (dimensionPixelSize != 0) {
                listView.setPadding(dimensionPixelSize, listView.getPaddingTop(), dimensionPixelSize, listView.getPaddingBottom());
            }
        }
    }

    protected void handleLayoutChildren(long j, ListView listView) {
        originalLayoutChildren(j, listView);
        TaggingDrawableHelper.m4252a((ViewGroup) listView);
    }

    protected void originalLayoutChildren(long j, ListView listView) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_Widget_ListView_class.originalLayoutChildren(long, ListView)");
    }

    protected void handleFillGap(long j, ListView listView, boolean z) {
        originalFillGap(j, listView, z);
        TaggingDrawableHelper.m4252a((ViewGroup) listView);
    }

    protected void originalFillGap(long j, ListView listView, boolean z) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_Widget_ListView_class.originalFillGap(long, ListView, boolean)");
    }

    protected void handle_init_(long j, ListView listView, Context context, AttributeSet attributeSet, int i) {
        original_init_(j, listView, context, attributeSet, i);
        doInit(listView, context);
    }

    protected void original_init_(long j, ListView listView, Context context, AttributeSet attributeSet, int i) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_Widget_ListView_class.original_init_(long, ListView, Context, AttributeSet, int)");
    }
}
