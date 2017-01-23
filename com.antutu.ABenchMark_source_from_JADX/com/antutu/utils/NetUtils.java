package com.antutu.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.antutu.benchmark.ABenchmarkApplication;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.handmark.pulltorefresh.library.C3628R;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.proguard.C4218e;
import com.umeng.message.util.HttpRequest;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.zip.GZIPInputStream;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

public final class NetUtils {
    public static final int NETWORKTYPE_2G = 2;
    public static final int NETWORKTYPE_3G = 3;
    public static final int NETWORKTYPE_INVALID = 0;
    public static final int NETWORKTYPE_WAP = 1;
    public static final int NETWORKTYPE_WIFI = 4;

    public static String checkNetInfo(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return BuildConfig.FLAVOR;
        }
        int type = activeNetworkInfo.getType();
        if (type == NETWORKTYPE_WAP) {
            return BuildConfig.FLAVOR;
        }
        if (type == 0) {
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo != null) {
                extraInfo = extraInfo.toLowerCase();
                if (extraInfo.contains(HttpUtil.APN_CMWAP) || extraInfo.contains(HttpUtil.APN_3GWAP) || extraInfo.contains(HttpUtil.APN_UNIWAP)) {
                    return "10.0.0.172";
                }
                if (extraInfo.contains(HttpUtil.APN_CTWAP)) {
                    return "10.0.0.200";
                }
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static int getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return NETWORKTYPE_INVALID;
        }
        String typeName = activeNetworkInfo.getTypeName();
        return typeName.equalsIgnoreCase("WIFI") ? NETWORKTYPE_WIFI : typeName.equalsIgnoreCase("MOBILE") ? TextUtils.isEmpty(Proxy.getDefaultHost()) ? isFastMobileNetwork(context) ? NETWORKTYPE_3G : NETWORKTYPE_2G : NETWORKTYPE_WAP : NETWORKTYPE_INVALID;
    }

    public static boolean isAirMode(Context context) {
        return System.getString(context.getContentResolver(), "airplane_mode_on").equals(MessageService.MSG_DB_NOTIFY_REACHED);
    }

    private static boolean isFastMobileNetwork(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case NETWORKTYPE_INVALID /*0*/:
                return false;
            case NETWORKTYPE_WAP /*1*/:
                return false;
            case NETWORKTYPE_2G /*2*/:
                return false;
            case NETWORKTYPE_3G /*3*/:
                return true;
            case NETWORKTYPE_WIFI /*4*/:
                return false;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return true;
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                return false;
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return true;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return true;
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return true;
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return false;
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                return true;
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                return true;
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                return true;
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean isGPRSEnabled(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            Field declaredField = Class.forName(connectivityManager.getClass().getName()).getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(connectivityManager);
            Method declaredMethod = Class.forName(obj.getClass().getName()).getDeclaredMethod("getMobileDataEnabled", new Class[NETWORKTYPE_INVALID]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(obj, new Object[NETWORKTYPE_INVALID])).booleanValue();
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoSuchFieldException e2) {
            return false;
        } catch (SecurityException e3) {
            return false;
        } catch (NoSuchMethodException e4) {
            return false;
        } catch (IllegalArgumentException e5) {
            return false;
        } catch (IllegalAccessException e6) {
            return false;
        } catch (InvocationTargetException e7) {
            return false;
        }
    }

    public static boolean isNetworkAvailable() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ABenchmarkApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isWifiConnected() {
        NetworkInfo networkInfo = ((ConnectivityManager) ABenchmarkApplication.getContext().getSystemService("connectivity")).getNetworkInfo(NETWORKTYPE_WAP);
        return networkInfo == null ? false : "CONNECTED".equalsIgnoreCase(networkInfo.getState().toString());
    }

    public static boolean setGPRSEnabled(Context context, boolean z) {
        if (isGPRSEnabled(context) == (!z ? NETWORKTYPE_WAP : NETWORKTYPE_INVALID)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (VERSION.SDK_INT == 8) {
                return true;
            }
            try {
                Field declaredField = Class.forName(connectivityManager.getClass().getName()).getDeclaredField("mService");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(connectivityManager);
                Class[] clsArr = new Class[NETWORKTYPE_WAP];
                clsArr[NETWORKTYPE_INVALID] = Boolean.TYPE;
                Method declaredMethod = Class.forName(obj.getClass().getName()).getDeclaredMethod("setMobileDataEnabled", clsArr);
                declaredMethod.setAccessible(true);
                Object[] objArr = new Object[NETWORKTYPE_WAP];
                objArr[NETWORKTYPE_INVALID] = Boolean.valueOf(z);
                declaredMethod.invoke(obj, objArr);
            } catch (ClassNotFoundException e) {
            } catch (NoSuchFieldException e2) {
            } catch (SecurityException e3) {
            } catch (NoSuchMethodException e4) {
            } catch (IllegalArgumentException e5) {
            } catch (IllegalAccessException e6) {
            } catch (InvocationTargetException e7) {
            }
        }
        return false;
    }

    public static boolean setWifiEnabled(Context context, boolean z) {
        boolean isWifiConnected = isWifiConnected();
        if (isWifiConnected == (!z)) {
            ((WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI)).setWifiEnabled(z);
        }
        return isWifiConnected;
    }

    public static String toString(HttpEntity httpEntity) {
        return toString(httpEntity, null);
    }

    public static String toString(HttpEntity httpEntity, String str) {
        if (httpEntity == null) {
            return null;
        }
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return BuildConfig.FLAVOR;
        }
        if (httpEntity.getContentLength() > 2147483647L) {
            return null;
        }
        InputStream gZIPInputStream;
        Reader inputStreamReader;
        CharArrayBuffer charArrayBuffer;
        char[] cArr;
        int read;
        int contentLength = (int) httpEntity.getContentLength();
        if (contentLength < 0) {
            contentLength = SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
        }
        String contentCharSet = EntityUtils.getContentCharSet(httpEntity);
        if (contentCharSet == null) {
            contentCharSet = str;
        }
        if (contentCharSet == null) {
            contentCharSet = C4218e.f14336a;
        }
        Header contentEncoding = httpEntity.getContentEncoding();
        if (contentEncoding != null) {
            Object value = contentEncoding.getValue();
            if (!TextUtils.isEmpty(value) && value.contains(HttpRequest.f14551d)) {
                gZIPInputStream = new GZIPInputStream(content);
                inputStreamReader = new InputStreamReader(gZIPInputStream, contentCharSet);
                charArrayBuffer = new CharArrayBuffer(contentLength);
                cArr = new char[IXAdIOUtils.BUFFER_SIZE];
                while (true) {
                    read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        break;
                    }
                    charArrayBuffer.append(cArr, NETWORKTYPE_INVALID, read);
                }
                return charArrayBuffer.toString();
            }
        }
        gZIPInputStream = content;
        inputStreamReader = new InputStreamReader(gZIPInputStream, contentCharSet);
        charArrayBuffer = new CharArrayBuffer(contentLength);
        try {
            cArr = new char[IXAdIOUtils.BUFFER_SIZE];
            while (true) {
                read = inputStreamReader.read(cArr);
                if (read != -1) {
                    break;
                    return charArrayBuffer.toString();
                }
                charArrayBuffer.append(cArr, NETWORKTYPE_INVALID, read);
            }
        } finally {
            inputStreamReader.close();
        }
    }
}
