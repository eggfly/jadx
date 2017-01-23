package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.MsgConstant;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.reflect.C4323a;
import com.xiaomi.channel.commonutils.string.C4329d;

/* renamed from: com.xiaomi.channel.commonutils.android.e */
public class C4293e {
    private static String f14711a;
    private static String f14712b;
    private static String f14713c;

    static {
        f14711a = null;
        f14712b = null;
        f14713c = null;
    }

    public static String m17607a() {
        return VERSION.SDK_INT > 8 ? Build.SERIAL : null;
    }

    public static String m17608a(Context context) {
        if (f14712b == null) {
            String c = C4293e.m17611c(context);
            String b = C4293e.m17610b(context);
            f14712b = "a-" + C4329d.m17746b(c + b + C4293e.m17607a());
        }
        return f14712b;
    }

    @TargetApi(17)
    public static int m17609b() {
        if (VERSION.SDK_INT < 17) {
            return -1;
        }
        Object a = C4323a.m17718a("android.os.UserHandle", "myUserId", new Object[0]);
        return a != null ? ((Integer) Integer.class.cast(a)).intValue() : -1;
    }

    public static String m17610b(Context context) {
        String str = null;
        try {
            str = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            C4302b.m17651a(th);
        }
        return str;
    }

    public static String m17611c(Context context) {
        int i = 10;
        String d = C4293e.m17612d(context);
        while (d == null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            d = C4293e.m17612d(context);
            if (d != null) {
                C4302b.m17654d("block Get imei success: " + d + " at cnt:" + i2);
                i = i2;
            } else {
                i = i2;
            }
        }
        return d;
    }

    public static String m17612d(Context context) {
        if (f14711a != null) {
            return f14711a;
        }
        try {
            String str;
            TelephonyManager telephonyManager;
            String deviceId;
            if (C4294f.m17617a()) {
                str = "miui.telephony.TelephonyManager";
                Object a = C4323a.m17718a("miui.telephony.TelephonyManager", "getDefault", new Object[0]);
                if (a != null) {
                    a = C4323a.m17717a(a, "getMiuiDeviceId", new Object[0]);
                    if (a == null || !(a instanceof String)) {
                        C4302b.m17654d("getMiuiDeviceId() failed, when Get imei.");
                        str = null;
                    } else {
                        str = (String) String.class.cast(a);
                    }
                    if (str != null) {
                        C4302b.m17649a("Get imei by miui.telephony.TelephonyManager success, imei:" + str);
                    }
                    if (str == null) {
                        if (C4293e.m17616h(context)) {
                            C4302b.m17654d("Get imei Failed, need permission android.permission.READ_PHONE_STATE");
                        } else {
                            telephonyManager = (TelephonyManager) context.getSystemService("phone");
                            deviceId = telephonyManager.getDeviceId();
                            if (deviceId != null) {
                                C4302b.m17649a("Get imei by " + telephonyManager.getClass().getName() + " success, imei: " + deviceId);
                            }
                            str = deviceId;
                        }
                    }
                    if (str != null) {
                        return str;
                    }
                    f14711a = str;
                    return str;
                }
            }
            str = null;
            if (str == null) {
                if (C4293e.m17616h(context)) {
                    C4302b.m17654d("Get imei Failed, need permission android.permission.READ_PHONE_STATE");
                } else {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    deviceId = telephonyManager.getDeviceId();
                    if (deviceId != null) {
                        C4302b.m17649a("Get imei by " + telephonyManager.getClass().getName() + " success, imei: " + deviceId);
                    }
                    str = deviceId;
                }
            }
            if (str != null) {
                return str;
            }
            f14711a = str;
            return str;
        } catch (Throwable th) {
            C4302b.m17651a(th);
            return null;
        }
    }

    public static synchronized String m17613e(Context context) {
        String str;
        synchronized (C4293e.class) {
            if (f14713c != null) {
                str = f14713c;
            } else {
                str = C4293e.m17610b(context);
                f14713c = C4329d.m17746b(str + C4293e.m17607a());
                str = f14713c;
            }
        }
        return str;
    }

    public static String m17614f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static String m17615g(Context context) {
        try {
            return ((WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo().getMacAddress();
        } catch (Throwable e) {
            C4302b.m17651a(e);
            return null;
        }
    }

    private static boolean m17616h(Context context) {
        String str = MsgConstant.PERMISSION_READ_PHONE_STATE;
        return context.getPackageManager().checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE, context.getPackageName()) == 0;
    }
}
