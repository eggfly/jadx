package com.xiaomi.mistatistic.sdk.controller.asyncjobs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.reflect.Field;
import com.xiaomi.mistatistic.sdk.BuildSetting;
import com.xiaomi.mistatistic.sdk.C0534b;
import com.xiaomi.mistatistic.sdk.CustomSettings;
import com.xiaomi.mistatistic.sdk.controller.C0551c;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.controller.C0557e;
import com.xiaomi.mistatistic.sdk.controller.C0566h;
import com.xiaomi.mistatistic.sdk.controller.C0573k;
import com.xiaomi.mistatistic.sdk.controller.C0579l;
import com.xiaomi.mistatistic.sdk.controller.C0597q;
import com.xiaomi.mistatistic.sdk.controller.LocalEventRecorder;
import com.xiaomi.mistatistic.sdk.data.AbstractEvent;
import com.xiaomi.mistatistic.sdk.data.C0604d;
import com.xiaomi.mistatistic.sdk.data.C0606g;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.asyncjobs.a */
public class C0542a implements C0523a {
    private boolean f4685a;

    public C0542a() {
        this.f4685a = false;
    }

    public void m6326a() {
        Context a = C0551c.m6352a();
        m6321b(a);
        m6322c(a);
        if (!C0573k.m6448a(a, "basic_info_reported")) {
            m6327a(a);
            C0573k.m6450b(a, "basic_info_reported", 1);
            this.f4685a = true;
        }
        String e = C0551c.m6357e();
        Object a2 = C0573k.m6446a(a, "basic_info_version", "");
        if (!(TextUtils.isEmpty(a2) || a2.equals(e))) {
            C0534b.m6287c();
            LocalEventRecorder.m6297a(new C0604d("mistat_basic", "upgrade"));
        }
        C0573k.m6452b(a, "basic_info_version", e);
        if (this.f4685a) {
            new C0579l().m6470a();
        }
    }

    private void m6321b(Context context) {
        int i = new GregorianCalendar().get(6);
        if (i != C0573k.m6443a(context, "last_day", 0)) {
            C0573k.m6450b(context, "last_day", i);
            LocalEventRecorder.m6297a(new C0604d("mistat_basic", "mistat_dau"));
            C0542a.m6323d(context);
            C0542a.m6318a("ui_version", C0542a.m6317a("ro.miui.ui.version.name"));
            C0542a.m6318a("version", VERSION.INCREMENTAL);
            C0542a.m6318a("sd", C0542a.m6325f(context));
            C0542a.m6318a("network", C0542a.m6324e(context));
            C0542a.m6318a("carrier_name", C0542a.m6317a("ro.carrier.name"));
            C0542a.m6318a("region", C0542a.m6317a("ro.miui.region"));
            C0542a.m6318a("imei_md5", C0597q.m6531b(C0557e.m6371b(context)));
            C0542a.m6318a("miui_imei_md5", C0597q.m6531b(C0597q.m6536f(context)));
            C0542a.m6318a("android_id_md5", C0597q.m6531b(C0597q.m6532c(context)));
            C0542a.m6318a("serial_num_md5", C0597q.m6531b(C0597q.m6524a()));
            this.f4685a = true;
        }
    }

    private void m6322c(Context context) {
        if (C0573k.m6443a(context, "uep_property", 0) == 0) {
            AbstractEvent c0606g;
            if (!C0597q.m6534d(context)) {
                c0606g = new C0606g("mistat_basic", "UEP", "not_miui");
            } else if (BuildSetting.m6243b(context)) {
                c0606g = new C0606g("mistat_basic", "UEP", "yes");
            } else {
                c0606g = new C0606g("mistat_basic", "UEP", "no");
            }
            LocalEventRecorder.m6297a(c0606g);
            C0573k.m6450b(C0551c.m6352a(), "uep_property", 1);
        }
    }

    @SuppressLint({"NewApi"})
    public void m6327a(Context context) {
        String str;
        LocalEventRecorder.m6297a(new C0604d("mistat_basic", "new"));
        LocalEventRecorder.m6297a(new C0606g("mistat_basic", "model", Build.MODEL));
        LocalEventRecorder.m6297a(new C0606g("mistat_basic", "OS", "android" + VERSION.SDK_INT));
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!TextUtils.isEmpty(telephonyManager.getNetworkOperatorName())) {
            LocalEventRecorder.m6297a(new C0606g("mistat_basic", "operator", telephonyManager.getSimOperator()));
        }
        C0542a.m6318a("device_id", C0557e.m6368a(context));
        C0542a.m6318a("imei_md5", C0597q.m6531b(C0557e.m6371b(context)));
        C0542a.m6318a("android_id_md5", C0597q.m6531b(C0597q.m6532c(context)));
        C0542a.m6318a("serial_num_md5", C0597q.m6531b(C0597q.m6524a()));
        C0542a.m6318a("mac_md5", C0597q.m6530b(context));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i < i2) {
                str = i + "x" + i2;
            } else {
                str = i2 + "x" + i;
            }
            LocalEventRecorder.m6297a(new C0606g("mistat_basic", "resolution", str));
        }
        C0542a.m6318a("locale", Locale.getDefault().toString());
        C0542a.m6318a("channel", C0542a.m6317a("ro.sys.miui_rom_channel_id"));
        C0542a.m6318a("device_name", C0542a.m6317a("ro.product.mod_device"));
        C0542a.m6318a("real_model", C0542a.m6317a("ro.product.model.real"));
        if (C0597q.m6534d(C0551c.m6352a())) {
            try {
                str = Class.forName("com.miui.support.os.Build").getField("IS_INTERNATIONAL_BUILD").getBoolean(null) ? "1" : "0";
                C0566h.m6419b("mi:" + str);
                C0542a.m6318a("mi", str);
            } catch (Throwable e) {
                C0566h.m6418a("", e);
            }
            try {
                Class cls = Class.forName("com.miui.support.os.Build");
                str = cls.getField("IS_ALPHA_BUILD").getBoolean(null) ? "A" : cls.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? Field.DOUBLE_SIGNATURE_PRIMITIVE : Field.SHORT_SIGNATURE_PRIMITIVE;
                C0566h.m6419b("bc:" + str);
                C0542a.m6318a("bc", str);
            } catch (Throwable e2) {
                C0566h.m6418a("", e2);
            }
        }
    }

    private static void m6318a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            LocalEventRecorder.m6297a(new C0606g("mistat_basic", str, str2));
        }
    }

    private static String m6317a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{str});
        } catch (Throwable e) {
            C0566h.m6418a("", e);
            return null;
        }
    }

    private static void m6323d(Context context) {
        try {
            if (CustomSettings.m6256d()) {
                Iterable arrayList = new ArrayList();
                List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
                if (installedApplications != null) {
                    for (ApplicationInfo applicationInfo : installedApplications) {
                        arrayList.add(applicationInfo.packageName);
                    }
                    LocalEventRecorder.m6297a(new C0606g("mistat_basic", "installed_package", TextUtils.join(",", arrayList)));
                }
            }
        } catch (Throwable th) {
            C0566h.m6418a("", th);
        }
    }

    private static String m6324e(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    case C0264R.styleable.Window_windowMaxWidthMajor /*11*/:
                        return "2G";
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                    case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                    case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                    case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                    case C0264R.styleable.Window_windowMaxHeightMinor /*12*/:
                    case C0264R.styleable.Window_windowTranslucentStatus /*14*/:
                    case C0264R.styleable.Window_windowLayoutMode /*15*/:
                        return "3G";
                    case C0264R.styleable.Window_windowMaxHeightMajor /*13*/:
                        return "4G";
                    default:
                        return "unknown";
                }
            }
            return "unknown";
        } catch (Throwable th) {
            C0566h.m6418a("", th);
        }
    }

    private static String m6325f(Context context) {
        String str = "0";
        str = "1";
        str = "2";
        str = "0";
        try {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            String str2 = System.getenv("SECONDARY_STORAGE");
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (!C0542a.m6319a(context, str2) || str2.equals(absolutePath)) {
                return "2";
            }
            return "1";
        } catch (Throwable th) {
            C0566h.m6418a("", th);
            return str;
        }
    }

    @SuppressLint({"InlinedApi"})
    private static boolean m6319a(Context context, String str) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            if ("mounted".equals((String) storageManager.getClass().getMethod("getVolumeState", new Class[]{String.class}).invoke(storageManager, new Object[]{str}))) {
                return true;
            }
        } catch (Throwable th) {
            C0566h.m6418a("", th);
        }
        return false;
    }

    public static void m6320b() {
        try {
            Context a = C0551c.m6352a();
            if (!C0597q.m6525a(C0573k.m6444a(a, "dau_time", 0)) && C0597q.m6527a(a)) {
                LocalEventRecorder.m6297a(new C0604d("mistat_basic", "mistat_dau_dummy"));
                C0573k.m6451b(a, "dau_time", System.currentTimeMillis());
                C0566h.m6419b("addDauEventWhenForeground " + System.currentTimeMillis());
            }
        } catch (Throwable e) {
            C0566h.m6418a("addDauEventWhenForeground exception: ", e);
        }
    }
}
