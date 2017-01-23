package com.miui.support.internal.variable.hook.v21;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class.Factory;

public class Android_Content_Res_Resources_class extends com.miui.support.internal.variable.hook.Android_Content_Res_Resources_class {
    private static final Android_Graphics_Drawable_Drawable_class DrawableClass;

    static {
        DrawableClass = Factory.getInstance().get();
    }

    public void buildProxy() {
        attachMethod("loadDrawable", "(Landroid/util/TypedValue;ILandroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;");
    }

    protected void handle() {
        handleLoadDrawable(0, null, null, 0, null);
    }

    protected Drawable handleLoadDrawable(long j, Resources resources, TypedValue typedValue, int i, Theme theme) {
        Drawable originalLoadDrawable = originalLoadDrawable(j, resources, typedValue, i, theme);
        if (originalLoadDrawable != null && originalLoadDrawable.isStateful()) {
            DrawableClass.setId(originalLoadDrawable, i);
        }
        return originalLoadDrawable;
    }

    protected Drawable originalLoadDrawable(long j, Resources resources, TypedValue typedValue, int i, Theme theme) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v21.Android_Content_Res_Resources_class.originalLoadDrawable(long, Resources, TypedValue, int, Resources.Theme)");
    }
}
