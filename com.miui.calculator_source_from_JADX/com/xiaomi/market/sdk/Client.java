package com.xiaomi.market.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class Client {
    static int f4525a;
    static int f4526b;
    static String f4527c;
    static int f4528d;
    static int f4529e;
    static String f4530f;
    static ArrayList<String> f4531g;
    static ArrayList<String> f4532h;
    static ArrayList<String> f4533i;
    static int f4534j;
    static String f4535k;
    static String f4536l;
    static String f4537m;
    static String f4538n;
    static String f4539o;
    static String f4540p;
    private static boolean f4541q;
    private static final Object f4542r;

    static {
        f4541q = false;
        f4542r = new Object();
    }

    static void m6136a(Context context) {
        if (!f4541q) {
            m6138b(context);
            m6141c(context);
            m6143d(context);
            m6144e(context);
            m6140c();
            m6145f(context);
            m6146g(context);
            m6147h(context);
            f4541q = true;
        }
    }

    private static void m6138b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        f4526b = displayMetrics.heightPixels;
        f4525a = displayMetrics.widthPixels;
        f4527c = f4526b + "*" + f4525a;
        f4528d = displayMetrics.densityDpi;
    }

    private static void m6141c(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        f4529e = deviceConfigurationInfo.reqTouchScreen;
        f4530f = deviceConfigurationInfo.getGlEsVersion();
    }

    private static void m6143d(Context context) {
        FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
        synchronized (f4542r) {
            f4531g = new ArrayList();
            if (systemAvailableFeatures != null) {
                for (FeatureInfo featureInfo : systemAvailableFeatures) {
                    if (!TextUtils.isEmpty(featureInfo.name)) {
                        f4531g.add(featureInfo.name);
                    }
                }
            }
            Collections.sort(f4531g);
        }
    }

    private static void m6144e(Context context) {
        String[] systemSharedLibraryNames = context.getPackageManager().getSystemSharedLibraryNames();
        synchronized (f4542r) {
            f4532h = new ArrayList();
            if (systemSharedLibraryNames != null) {
                for (CharSequence charSequence : systemSharedLibraryNames) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        f4532h.add(charSequence);
                    }
                }
            }
            Collections.sort(f4532h);
        }
    }

    private static void m6140c() {
        Object d = m6142d();
        synchronized (f4542r) {
            f4533i = new ArrayList();
            if (!TextUtils.isEmpty(d)) {
                for (CharSequence charSequence : TextUtils.split(d, " ")) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        f4533i.add(charSequence);
                    }
                }
            }
            Collections.sort(f4533i);
        }
    }

    private static void m6145f(Context context) {
        f4536l = VERSION.RELEASE;
        f4535k = VERSION.INCREMENTAL;
        f4534j = VERSION.SDK_INT;
    }

    private static void m6146g(Context context) {
        f4540p = Locale.getDefault().getCountry();
        f4539o = Locale.getDefault().getLanguage();
    }

    private static void m6147h(Context context) {
        String str = "";
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable e) {
            Log.e("MarketSdkClient", e.getMessage(), e);
        }
        f4537m = !TextUtils.isEmpty(str) ? str : "";
        Object macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(str);
        }
        if (!TextUtils.isEmpty(macAddress)) {
            stringBuffer.append("_");
            stringBuffer.append(macAddress);
        }
        f4538n = Coder.m6150a(stringBuffer.toString());
    }

    private static String m6142d() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY || !egl10.eglInitialize(eglGetDisplay, new int[2])) {
            return null;
        }
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!egl10.eglChooseConfig(eglGetDisplay, new int[]{12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, eGLConfigArr, 1, iArr)) {
            return null;
        }
        EGLConfig eGLConfig;
        if (iArr[0] > 0) {
            eGLConfig = eGLConfigArr[0];
        } else {
            eGLConfig = null;
        }
        EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, null);
        EGLSurface eglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 480, 12374, 800, 12344});
        if (eglCreatePbufferSurface == null || eglCreatePbufferSurface == EGL10.EGL_NO_SURFACE) {
            return null;
        }
        egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
        if (!egl10.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext)) {
            return null;
        }
        String glGetString = ((GL10) eglCreateContext.getGL()).glGetString(7939);
        egl10.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
        egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
        egl10.eglTerminate(eglGetDisplay);
        if (glGetString != null) {
            return glGetString.trim();
        }
        return null;
    }

    static boolean m6137a() {
        return f4534j >= 11;
    }

    public static boolean m6139b() {
        return f4534j >= 24;
    }
}
