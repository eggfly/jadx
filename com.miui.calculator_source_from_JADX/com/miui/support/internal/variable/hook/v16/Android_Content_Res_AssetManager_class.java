package com.miui.support.internal.variable.hook.v16;

import android.content.res.AssetManager;
import com.miui.support.internal.util.PackageConstants;
import com.miui.support.internal.variable.VariableExceptionHandler;

public class Android_Content_Res_AssetManager_class extends com.miui.support.internal.variable.hook.Android_Content_Res_AssetManager_class {
    protected void handle() {
        handleAddAssetPath(0, null, null);
    }

    protected int handleAddAssetPath(long j, AssetManager assetManager, String str) {
        if (!PackageConstants.f2566c.equals(str)) {
            originalAddAssetPath(j, assetManager, PackageConstants.f2566c);
        }
        return originalAddAssetPath(j, assetManager, str);
    }

    protected int originalAddAssetPath(long j, AssetManager assetManager, String str) {
        throw new IllegalStateException("com.miui.internal.variable.v16.Android_Content_Res_AssetManager_class.originalAddAssetPath(long, AssetManager, String)");
    }

    public void buildProxy() {
        try {
            attachMethod("addAssetPath", "(Ljava/lang/String;)I");
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.content.res.AssetManager.addAssetPath", e);
        }
    }
}
