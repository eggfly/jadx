package com.cmcm.support;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.handmark.pulltorefresh.library.C3628R;
import com.taobao.accs.utl.UtilityImpl;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Locale;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.cmcm.support.g */
public class C2234g {
    public static int m8419a(Context context) {
        int i = 0;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    i = packageInfo.versionCode;
                }
            } catch (NameNotFoundException e) {
            }
        }
        return i;
    }

    public static String m8420a() {
        return Locale.getDefault().toString();
    }

    public static int m8421b(Context context) {
        if (context == null) {
            return 1;
        }
        int subtype;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                subtype = activeNetworkInfo.getSubtype();
                if (type == 1) {
                    if (C2234g.m8422c(context)) {
                        subtype = 2;
                    }
                } else if (type == 0) {
                    switch (subtype) {
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        case SpdyProtocol.QUIC /*4*/:
                        case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                        case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                            subtype = 4;
                            break;
                        case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                        case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                        case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                        case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                        case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                        case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                        case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                            subtype = 8;
                            break;
                        case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                            subtype = 16;
                            break;
                        default:
                            subtype = 1;
                            break;
                    }
                } else {
                    subtype = 1;
                }
                return subtype;
            }
        } catch (NullPointerException e) {
            subtype = 32;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        subtype = 0;
        return subtype;
    }

    public static boolean m8422c(Context context) {
        if (context == null) {
            return false;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                int ipAddress = connectionInfo == null ? 0 : connectionInfo.getIpAddress();
                if (wifiManager.isWifiEnabled() && ipAddress != 0) {
                    return true;
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static boolean m8423d(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        return z;
    }

    public static String m8424e(Context context) {
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static int m8425f(Context context) {
        if (context == null) {
            return 0;
        }
        int i;
        CharSequence simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (simOperator == null || simOperator.length() < 3) {
            i = 0;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(simOperator, 0, 3);
            try {
                i = Integer.valueOf(stringBuilder.toString()).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
        }
        return i;
    }

    public static int m8426g(Context context) {
        if (context == null) {
            return 0;
        }
        int i;
        CharSequence simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (simOperator == null || simOperator.length() < 5) {
            i = 0;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(simOperator, 3, 5);
            try {
                i = Integer.valueOf(stringBuilder.toString()).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
        }
        return i;
    }
}
