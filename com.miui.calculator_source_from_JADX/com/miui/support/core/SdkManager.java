package com.miui.support.core;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.miui.support.internal.app.MiuiApplication;
import com.miui.support.internal.component.ComponentManager;
import com.miui.support.internal.component.module.ModuleLoader;
import com.miui.support.internal.util.ClassProxy;
import com.miui.support.internal.util.PackageConstants;
import com.miui.support.internal.util.PackageHelper;
import com.miui.support.internal.variable.hook.Android_App_Activity_class;
import com.miui.support.internal.variable.hook.Android_App_AlertDialog_Builder_class;
import com.miui.support.internal.variable.hook.Android_App_AlertDialog_class;
import com.miui.support.internal.variable.hook.Android_Content_Res_Resources_class.Factory;
import com.miui.support.internal.variable.hook.Android_Preference_EditTextPreference_class;
import com.miui.support.internal.variable.hook.Android_Preference_Preference_class;
import com.miui.support.internal.variable.hook.Android_Text_Util_Linkify_class;
import com.miui.support.internal.variable.hook.Android_View_ViewGroup_class;
import com.miui.support.internal.variable.hook.Android_View_View_class;
import com.miui.support.internal.variable.hook.Android_Widget_AbsSeekBar_class;
import com.miui.support.internal.variable.hook.Android_Widget_AbsSpinner_class;
import com.miui.support.internal.variable.hook.Android_Widget_GridView_class;
import com.miui.support.internal.variable.hook.Android_Widget_ListPopupWindow_class;
import com.miui.support.internal.variable.hook.Android_Widget_ListView_class;
import com.miui.support.internal.variable.hook.Android_Widget_PopupWindow_class;
import com.miui.support.internal.variable.hook.Android_Widget_RemoteViews_class;
import com.miui.support.internal.variable.hook.Android_Widget_Spinner_class;
import com.miui.support.internal.variable.hook.HookedClassSet;
import java.util.Map;

public abstract class SdkManager {
    private static final String MIUI_CORE_SERVICE = "com.miui.support.internal.server.CoreService";
    public static final int RETURN_CODE_LOW_SDK_VERSION = 1;
    public static final int RETURN_CODE_SUCCESS = 0;
    private static final String TAG = "miuisdk";

    /* renamed from: com.miui.support.core.SdkManager.1 */
    final class C02401 implements Runnable {
        C02401() {
        }

        public void run() {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setClassName("com.miui.core", SdkManager.MIUI_CORE_SERVICE);
            PackageConstants.f2564a.startService(intent);
        }
    }

    private SdkManager() {
    }

    public static int initialize(Application application, Map<String, Object> map) {
        synchronized (SdkManager.class) {
            if (PackageConstants.f2565b >= 2) {
                Log.d(TAG, "sdk already initialized");
            } else {
                boolean z;
                PackageConstants.f2564a = application;
                if (PackageHelper.m4235a()) {
                    ClassProxy.setupResourceHook();
                    String[] strArr = new String[RETURN_CODE_LOW_SDK_VERSION];
                    strArr[RETURN_CODE_SUCCESS] = PackageConstants.f2566c;
                    ModuleLoader.m3896a(strArr);
                }
                if (PackageHelper.m4236a(PackageConstants.f2564a)) {
                    try {
                        z = ClassProxy.setupClassHook(VERSION.SDK_INT, HookedClassSet.CLASSES);
                    } catch (Throwable th) {
                        Log.w(TAG, "setup class hook encounter errors: " + th.getMessage());
                    }
                    if (!z) {
                        if (PackageHelper.m4236a(PackageConstants.f2564a)) {
                            try {
                                buildProxy();
                                z = true;
                            } catch (Throwable th2) {
                                Log.w(TAG, "build class proxy encounter errors: " + th2.getMessage());
                            }
                        }
                    }
                    if (z) {
                        ClassProxy.setupInterpreterHook();
                    }
                    if (PackageConstants.f2565b < 2) {
                        PackageConstants.f2565b = 2;
                    }
                }
                z = false;
                if (z) {
                    if (PackageHelper.m4236a(PackageConstants.f2564a)) {
                        buildProxy();
                        z = true;
                    }
                }
                if (z) {
                    ClassProxy.setupInterpreterHook();
                }
                if (PackageConstants.f2565b < 2) {
                    PackageConstants.f2565b = 2;
                }
            }
        }
        return RETURN_CODE_SUCCESS;
    }

    private static void buildProxy() {
        Factory.getInstance().get().buildProxy();
        Android_App_AlertDialog_class.Factory.getInstance().get().buildProxy();
        Android_App_AlertDialog_Builder_class.Factory.getInstance().get().buildProxy();
        Android_App_Activity_class.Factory.getInstance().get().buildProxy();
        Android_View_View_class.Factory.getInstance().get().buildProxy();
        Android_View_ViewGroup_class.Factory.getInstance().get().buildProxy();
        Android_Preference_Preference_class.Factory.getInstance().get().buildProxy();
        Android_Preference_EditTextPreference_class.Factory.getInstance().get().buildProxy();
        Android_Widget_RemoteViews_class.Factory.getInstance().get().buildProxy();
        Android_Widget_ListView_class.Factory.getInstance().get().buildProxy();
        Android_Widget_GridView_class.Factory.getInstance().get().buildProxy();
        Android_Widget_ListPopupWindow_class.Factory.getInstance().get().buildProxy();
        Android_Widget_AbsSpinner_class.Factory.getInstance().get().buildProxy();
        Android_Widget_Spinner_class.Factory.getInstance().get().buildProxy();
        Android_Widget_PopupWindow_class.Factory.getInstance().get().buildProxy();
        Android_Widget_AbsSeekBar_class.Factory.getInstance().get().buildProxy();
        Android_Text_Util_Linkify_class.Factory.getInstance().get().buildProxy();
    }

    public static int start(Map<String, Object> map) {
        int i;
        synchronized (SdkManager.class) {
            if (PackageConstants.f2565b >= 3) {
                Log.d(TAG, "sdk already started");
            }
            Manifest a = ManifestParser.m3340a(PackageConstants.f2564a).m3355a((Map) map);
            if ((PackageConstants.f2564a instanceof MiuiApplication) || PackageHelper.m4239b() || isCompatible(PackageConstants.f2564a, a)) {
                loadComponents(PackageConstants.f2564a, a);
                startService();
                if (PackageConstants.f2565b < 3) {
                    PackageConstants.f2565b = 3;
                }
                i = RETURN_CODE_SUCCESS;
            } else {
                i = RETURN_CODE_LOW_SDK_VERSION;
            }
        }
        return i;
    }

    private static boolean isCompatible(Context context, Manifest manifest) {
        return new CompatibleManager(context, manifest).m3331a();
    }

    private static void loadComponents(Context context, Manifest manifest) {
        new ComponentManager(manifest).m3872a();
    }

    private static void startService() {
        new Handler().post(new C02401());
    }

    public static boolean supportUpdate(Map<String, Object> map) {
        return false;
    }

    public static boolean update(Map<String, Object> map) {
        return false;
    }
}
