package com.miui.support.internal.variable.hook.v16;

import android.content.Context;
import android.util.AttributeSet;
import android.view.DisplayList;
import android.view.View;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.TaggingDrawableHelper;
import com.miui.support.util.AttributeResolver;

public class Android_View_View_class extends com.miui.support.internal.variable.hook.Android_View_View_class {
    public void buildProxy() {
        attachMethod("refreshDrawableState", "()V");
        attachMethod("onCreateDrawableState", "(I)[I");
        attachConstructor("(Landroid/content/Context;)V");
        attachConstructor("()V");
        attachSpecialMethods();
    }

    protected void handle() {
        handleRefreshDrawableState(0, null);
        handleOnCreateDrawableState(0, null, 0);
        handleSetDisplayListProperties(0, null, null);
        handle_init_(0, null, null, null, 0);
        handle_init_(0, null, null, null);
    }

    protected void attachSpecialMethods() {
        attachConstructor("(Landroid/content/Context;Landroid/util/AttributeSet;I)V");
        attachMethod("setDisplayListProperties", "(Landroid/view/DisplayList;)V");
    }

    protected void handleRefreshDrawableState(long j, View view) {
        originalRefreshDrawableState(j, view);
        TaggingDrawableHelper.m4249a(view);
    }

    protected void originalRefreshDrawableState(long j, View view) {
        throw new IllegalStateException("com.miui.internal.variable.v16.Android_View_View_class.originalRefreshDrawableState(long, View)");
    }

    protected int[] handleOnCreateDrawableState(long j, View view, int i) {
        return onCreateDrawableState(view, originalOnCreateDrawableState(j, view, 0), i);
    }

    protected int[] originalOnCreateDrawableState(long j, View view, int i) {
        throw new IllegalStateException("com.miui.internal.variable.v16.Android_View_View_class.originalOnCreateDrawableState(long, View, int)");
    }

    protected void handle_init_(long j, View view, Context context, AttributeSet attributeSet, int i) {
        original_init_(j, view, context, attributeSet, i);
        TaggingDrawableHelper.m4251a(view, attributeSet);
    }

    protected void original_init_(long j, View view, Context context, AttributeSet attributeSet, int i) {
        throw new IllegalStateException("com.miui.internal.variable.v16.Android_View_View_class.original_init_(long, View, Context, AttributeSet, int)");
    }

    protected void handle_init_(long j, View view, Context context, AttributeSet attributeSet) {
        original_init_(j, view, context, attributeSet);
        TaggingDrawableHelper.m4251a(view, attributeSet);
    }

    protected void original_init_(long j, View view, Context context, AttributeSet attributeSet) {
        throw new IllegalStateException("com.miui.internal.variable.v16.Android_View_View_class.original_init_(long, View, Context, AttributeSet)");
    }

    protected void handleSetDisplayListProperties(long j, View view, DisplayList displayList) {
        originalSetDisplayListProperties(j, view, displayList);
        if (displayList != null && !AttributeResolver.m5319a(view.getContext(), C0264R.attr.hasOverlappingRendering, true)) {
            displayList.setHasOverlappingRendering(false);
        }
    }

    protected void originalSetDisplayListProperties(long j, View view, DisplayList displayList) {
        throw new IllegalStateException("com.miui.internal.variable.v16.Android_View_View_class.originalSetDisplayListProperties(long, View, DisplayList)");
    }
}
