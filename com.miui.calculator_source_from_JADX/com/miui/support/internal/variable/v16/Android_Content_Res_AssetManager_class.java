package com.miui.support.internal.variable.v16;

import android.content.res.AssetManager;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Constructor;
import com.miui.support.reflect.Method;

public class Android_Content_Res_AssetManager_class implements com.miui.support.internal.variable.Android_Content_Res_AssetManager_class {
    private static final Method mAddAssetPath;

    static {
        mAddAssetPath = Method.of(AssetManager.class, "addAssetPath", "(Ljava/lang/String;)I");
    }

    public AssetManager newInstance() {
        return (AssetManager) Constructor.of(AssetManager.class, "()V").newInstance(new Object[0]);
    }

    public int addAssetPath(AssetManager assetManager, String str) {
        int i = 0;
        try {
            i = mAddAssetPath.invokeInt(null, assetManager, str);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.content.res.AssetManager.addAssetPath", e);
        }
        return i;
    }
}
