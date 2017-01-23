package com.miui.support.internal.variable.v16;

import android.content.res.AssetManager;
import android.content.res.Resources;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Field;

public class Android_Content_Res_Resources_class implements com.miui.support.internal.variable.Android_Content_Res_Resources_class {
    private static final Field mAssets;

    static {
        mAssets = Field.of(Resources.class, "mAssets", "Landroid/content/res/AssetManager;");
    }

    public void setAssetManager(Resources resources, AssetManager assetManager) {
        try {
            mAssets.set((Object) resources, (Object) assetManager);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("mAssets", e);
        }
    }
}
