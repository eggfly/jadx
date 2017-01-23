package com.cmcm.p074a.p075a.p112a;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.cmcm.a.a.a.i */
public class C2115i {
    private static Class f7430a;
    private static Method f7431b;

    public static long m7964a() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            String[] split = bufferedReader.readLine().split("\\s+");
            if (split.length == 3) {
                j = (long) (Integer.valueOf(split[1]).intValue() * IXAdIOUtils.BUFFER_SIZE);
            }
            bufferedReader.close();
        } catch (Exception e) {
        }
        return j;
    }

    public static String m7965a(Context context, String str) {
        InputStream open;
        Throwable th;
        String str2 = null;
        try {
            open = context.getAssets().open(str);
            try {
                int available = open.available();
                byte[] bArr = new byte[available];
                if (open.read(bArr) == available) {
                    str2 = new String(bArr);
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e3) {
                    }
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (open != null) {
                    try {
                        open.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            open = null;
            if (open != null) {
                open.close();
            }
            return str2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            open = null;
            th = th4;
            if (open != null) {
                open.close();
            }
            throw th;
        }
        return str2;
    }

    public static String m7966a(String str) {
        if (f7431b == null) {
            synchronized (C2115i.class) {
                if (f7431b == null) {
                    try {
                        if (f7430a == null) {
                            f7430a = Class.forName("android.os.SystemProperties");
                        }
                        f7431b = f7430a.getDeclaredMethod("get", new Class[]{String.class});
                    } catch (Exception e) {
                    }
                }
            }
        }
        try {
            return (String) f7431b.invoke(f7430a, new Object[]{str});
        } catch (Exception e2) {
            return null;
        }
    }

    public static void m7967a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static String[] m7968a(Context context) {
        try {
            if (((TelephonyManager) context.getSystemService("phone")).getSimOperator().length() >= 5) {
                return new String[]{((TelephonyManager) context.getSystemService("phone")).getSimOperator().substring(0, 3), ((TelephonyManager) context.getSystemService("phone")).getSimOperator().substring(3, 5)};
            }
        } catch (Exception e) {
        }
        return new String[]{BuildConfig.FLAVOR, BuildConfig.FLAVOR};
    }

    public static String m7969b() {
        Object a = C2115i.m7966a("ro.product.brand");
        if (TextUtils.isEmpty(a)) {
            a = Build.MODEL;
        }
        return !TextUtils.isEmpty(a) ? a : UtilityImpl.NET_TYPE_UNKNOWN;
    }

    public static String m7970b(Context context) {
        try {
            return System.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    private static boolean m7971b(String str) {
        boolean z = false;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("ls -l " + str);
            String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            if (readLine == null || readLine.length() < 4) {
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Exception e) {
                    }
                }
                return z;
            }
            char charAt = readLine.charAt(3);
            if (charAt == 's' || charAt == 'x') {
                z = true;
            }
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e2) {
                }
            }
            return z;
        } catch (Exception e3) {
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e4) {
                }
            }
        } catch (Throwable th) {
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e5) {
                }
            }
        }
    }

    public static String m7972c(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            return String.valueOf(displayMetrics.heightPixels) + "*" + String.valueOf(i);
        } catch (Exception e) {
            return "Unknown";
        }
    }

    public static boolean m7973c() {
        String str = "/system/bin/su";
        String str2 = "/system/xbin/su";
        return (new File(str).exists() && C2115i.m7971b(str)) || (new File(str2).exists() && C2115i.m7971b(str2));
    }

    public static long m7974d() {
        File file = new File(Environment.getExternalStorageDirectory(), "DCIM");
        long lastModified = (file.exists() && file.isDirectory()) ? file.lastModified() : 0;
        File file2 = new File("/system/usr");
        long lastModified2 = (file2.exists() && file2.isDirectory()) ? file2.lastModified() : 0;
        if (lastModified < 1230739201000L) {
            lastModified = 0;
        }
        return (lastModified2 < 1230739201000L || lastModified <= 0) ? lastModified2 : lastModified > lastModified2 ? lastModified2 : lastModified;
    }

    @SuppressLint({"NewApi"})
    public static long m7975d(Context context) {
        if (VERSION.SDK_INT < 16) {
            return C2115i.m7964a();
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static String m7976e(Context context) {
        try {
            return context.getResources().getDisplayMetrics().density + BuildConfig.FLAVOR;
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static String m7977f(Context context) {
        Locale locale = null;
        Resources resources = context.getResources();
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            if (configuration != null) {
                locale = configuration.locale;
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
        } else {
            locale = Locale.getDefault();
        }
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    public static int m7978g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean m7979h(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isAvailable();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m7980i(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo.getType() == 1 && activeNetworkInfo.isAvailable();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m7981j(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo.getType() == 0 && activeNetworkInfo.isAvailable();
        } catch (Exception e) {
            return false;
        }
    }

    public static int m7982k(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        } catch (Exception e) {
            return -1;
        }
    }
}
