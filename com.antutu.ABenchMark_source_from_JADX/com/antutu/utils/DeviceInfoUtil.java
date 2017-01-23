package com.antutu.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.handmark.pulltorefresh.library.C3628R;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import org.android.spdy.SpdyProtocol;

public class DeviceInfoUtil {
    private static String sResolution;

    public static String getAndroidId(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            str = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            try {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    private static boolean getAppIsExist(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 1152);
            Log.i("1111111", "true");
            return true;
        } catch (NameNotFoundException e) {
            Log.i("1111111", "false");
            return false;
        } catch (Exception e2) {
            Log.i("1111111", "false");
            return false;
        }
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getIMEI(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
            return BuildConfig.FLAVOR;
        }
    }

    public static String getLocale(Context context) {
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static String getMCC(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 5) {
                return networkOperator.substring(0, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getMNC(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 5) {
                return networkOperator.substring(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getNetworkName(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return BuildConfig.FLAVOR;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() != 0) {
            return BuildConfig.FLAVOR;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return "2G";
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return "3G";
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                return "4G";
            default:
                return BuildConfig.FLAVOR;
        }
    }

    public static String getOSVersion() {
        return VERSION.RELEASE;
    }

    public static String getResolution(Context context) {
        if (sResolution == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            sResolution = displayMetrics.heightPixels + "x" + displayMetrics.widthPixels;
        }
        return sResolution;
    }

    public static int getSDKVersionNumber() {
        return VERSION.SDK_INT;
    }

    public static String getSimMCC(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if (!TextUtils.isEmpty(simOperator) && simOperator.length() >= 5) {
                return simOperator.substring(0, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String getSimMNC(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            if (!TextUtils.isEmpty(simOperator) && simOperator.length() >= 5) {
                return simOperator.substring(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static boolean hasGooglePlayApp(Context context) {
        return getAppIsExist(context, "com.android.vending");
    }

    public static boolean isRoot() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception e) {
            return false;
        }
    }
}
