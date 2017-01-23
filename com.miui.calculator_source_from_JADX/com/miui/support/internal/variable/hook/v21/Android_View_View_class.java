package com.miui.support.internal.variable.hook.v21;

import android.content.Context;
import android.util.AttributeSet;
import android.view.RenderNode;
import android.view.View;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.TaggingDrawableHelper;
import com.miui.support.util.AttributeResolver;

public class Android_View_View_class extends com.miui.support.internal.variable.hook.v16.Android_View_View_class {
    protected void handle() {
        handle_init_(0, null, null, null, 0, 0);
        handleSetDisplayListProperties(0, null, (RenderNode) null);
        super.handle();
    }

    protected void attachSpecialMethods() {
        attachConstructor("(Landroid/content/Context;Landroid/util/AttributeSet;II)V");
        attachMethod("setDisplayListProperties", "(Landroid/view/RenderNode;)V");
    }

    protected void handle_init_(long j, View view, Context context, AttributeSet attributeSet, int i, int i2) {
        original_init_(j, view, context, attributeSet, i, i2);
        TaggingDrawableHelper.m4251a(view, attributeSet);
    }

    protected void original_init_(long j, View view, Context context, AttributeSet attributeSet, int i, int i2) {
        throw new IllegalStateException("com.miui.internal.variable.v21.Android_View_View_class.original_init_(long, View, Context, AttributeSet, int, int)");
    }

    protected void handleSetDisplayListProperties(long j, View view, RenderNode renderNode) {
        originalSetDisplayListProperties(j, view, renderNode);
        if (renderNode != null && !AttributeResolver.m5319a(view.getContext(), C0264R.attr.hasOverlappingRendering, true)) {
            renderNode.setHasOverlappingRendering(false);
        }
    }

    protected void originalSetDisplayListProperties(long j, View view, RenderNode renderNode) {
        throw new IllegalStateException("com.miui.internal.variable.v21.Android_View_View_class.originalSetDisplayListProperties(long, View, RenderNode)");
    }
}
