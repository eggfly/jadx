package com.miui.support.internal.component.module;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.miui.support.internal.util.PackageConstants;
import com.miui.support.internal.variable.Android_App_ActivityThread_class;
import com.miui.support.internal.variable.Android_App_ActivityThread_class.Factory;
import com.miui.support.internal.variable.Android_App_LoadedApk_class;
import com.miui.support.internal.variable.Android_Content_Res_AssetManager_class;
import com.miui.support.internal.variable.Android_Content_Res_Resources_class;
import java.util.List;

public class ModuleResourceLoader {
    public static void m3902a(List<String> list) {
        m3903a((List) list, null);
    }

    public static void m3903a(List<String> list, List<String> list2) {
        if (PackageConstants.f2565b < 2) {
            m3905b(list, list2);
        } else {
            m3904a(list, list2, PackageConstants.f2564a);
        }
    }

    public static void m3905b(List<String> list, List<String> list2) {
        Android_App_ActivityThread_class android_App_ActivityThread_class = Factory.getInstance().get();
        Object currentActivityThread = android_App_ActivityThread_class.currentActivityThread();
        Android_App_LoadedApk_class android_App_LoadedApk_class = Android_App_LoadedApk_class.Factory.getInstance().get();
        Object initialLoadedApk = android_App_ActivityThread_class.getInitialLoadedApk(currentActivityThread);
        m3901a(android_App_LoadedApk_class.getResources(initialLoadedApk), android_App_LoadedApk_class.getApplicationInfo(initialLoadedApk).sourceDir, list2, list);
    }

    public static void m3904a(List<String> list, List<String> list2, Context context) {
        m3901a(context.getResources(), context.getApplicationInfo().sourceDir, list2, list);
    }

    private static void m3901a(Resources resources, String str, List<String> list, List<String> list2) {
        AssetManager newInstance;
        Android_Content_Res_AssetManager_class android_Content_Res_AssetManager_class = Android_Content_Res_AssetManager_class.Factory.getInstance().get();
        AssetManager assets = resources.getAssets();
        if (VERSION.SDK_INT < 21) {
            newInstance = android_Content_Res_AssetManager_class.newInstance();
            android_Content_Res_AssetManager_class.addAssetPath(newInstance, str);
            if (list != null) {
                for (String addAssetPath : list) {
                    android_Content_Res_AssetManager_class.addAssetPath(newInstance, addAssetPath);
                }
            }
        } else {
            newInstance = assets;
        }
        for (String addAssetPath2 : list2) {
            android_Content_Res_AssetManager_class.addAssetPath(newInstance, addAssetPath2);
        }
        if (VERSION.SDK_INT < 21) {
            m3900a(resources, newInstance);
        }
    }

    private static void m3900a(Resources resources, AssetManager assetManager) {
        Resources resources2 = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        AssetManager assets = resources.getAssets();
        Android_Content_Res_Resources_class android_Content_Res_Resources_class = Android_Content_Res_Resources_class.Factory.getInstance().get();
        android_Content_Res_Resources_class.setAssetManager(resources, assetManager);
        android_Content_Res_Resources_class.setAssetManager(resources2, null);
        assets.close();
        resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
    }
}
