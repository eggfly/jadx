package com.umeng.analytics.social;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.antutu.utils.PointMark;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C4156a;
import com.umeng.analytics.social.UMPlatformData.GENDER;
import com.umeng.message.MsgConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.social.f */
public abstract class C4189f {
    private static Map<String, String> f14080a;

    private static String m17074a(List<String> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(URLEncoder.encode(list.toString()).getBytes());
            return byteArrayOutputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> m17075a(UMPlatformData... uMPlatformDataArr) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        for (UMPlatformData uMPlatformData : uMPlatformDataArr) {
            stringBuilder.append(uMPlatformData.getMeida().toString());
            stringBuilder.append(',');
            stringBuilder2.append(uMPlatformData.getUsid());
            stringBuilder2.append(',');
            stringBuilder3.append(uMPlatformData.getWeiboId());
            stringBuilder3.append(',');
        }
        if (uMPlatformDataArr.length > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            stringBuilder3.deleteCharAt(stringBuilder3.length() - 1);
        }
        List<String> arrayList = new ArrayList();
        arrayList.add("platform=" + stringBuilder.toString());
        arrayList.add("usid=" + stringBuilder2.toString());
        if (stringBuilder3.length() > 0) {
            arrayList.add("weiboid=" + stringBuilder3.toString());
        }
        return arrayList;
    }

    public static Map<String, String> m17076a(Context context) {
        CharSequence deviceId;
        CharSequence c;
        CharSequence string;
        Map<String, String> hashMap = new HashMap();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            C4185b.m17062e(C4156a.f13942d, "No IMEI.");
        }
        try {
            if (C4189f.m17077a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                deviceId = telephonyManager.getDeviceId();
                c = C4189f.m17081c(context);
                string = Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(c)) {
                    hashMap.put(PointMark.T_MAC, c);
                }
                if (!TextUtils.isEmpty(deviceId)) {
                    hashMap.put(Constants.KEY_IMEI, deviceId);
                }
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put("android_id", string);
                }
                return hashMap;
            }
        } catch (Exception e) {
            C4185b.m17063e(C4156a.f13942d, "No IMEI.", e);
        }
        deviceId = null;
        c = C4189f.m17081c(context);
        string = Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(c)) {
            hashMap.put(PointMark.T_MAC, c);
        }
        if (TextUtils.isEmpty(deviceId)) {
            hashMap.put(Constants.KEY_IMEI, deviceId);
        }
        if (TextUtils.isEmpty(string)) {
            hashMap.put("android_id", string);
        }
        return hashMap;
    }

    private static boolean m17077a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    protected static String[] m17078a(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        if (uMPlatformDataArr == null || uMPlatformDataArr.length == 0) {
            throw new C4184a("platform data is null");
        }
        Object appkey = AnalyticsConfig.getAppkey(context);
        if (TextUtils.isEmpty(appkey)) {
            throw new C4184a("can`t get appkey.");
        }
        List arrayList = new ArrayList();
        String str2 = "http://log.umsns.com/share/api/" + appkey + "/";
        if (f14080a == null || f14080a.isEmpty()) {
            f14080a = C4189f.m17080b(context);
        }
        if (!(f14080a == null || f14080a.isEmpty())) {
            for (Entry entry : f14080a.entrySet()) {
                arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            }
        }
        arrayList.add("date=" + String.valueOf(System.currentTimeMillis()));
        arrayList.add("channel=" + C4188e.f14062e);
        if (!TextUtils.isEmpty(str)) {
            arrayList.add("topic=" + str);
        }
        arrayList.addAll(C4189f.m17075a(uMPlatformDataArr));
        String b = C4189f.m17079b(uMPlatformDataArr);
        if (b == null) {
            b = "null";
        }
        String str3 = str2 + "?" + C4189f.m17074a(arrayList);
        while (str3.contains("%2C+")) {
            str3 = str3.replace("%2C+", "&");
        }
        while (str3.contains("%3D")) {
            str3 = str3.replace("%3D", "=");
        }
        while (str3.contains("%5B")) {
            str3 = str3.replace("%5B", BuildConfig.FLAVOR);
        }
        while (str3.contains("%5D")) {
            str3 = str3.replace("%5D", BuildConfig.FLAVOR);
        }
        C4185b.m17058c(C4156a.f13942d, "URL:" + str3);
        C4185b.m17058c(C4156a.f13942d, "BODY:" + b);
        return new String[]{str3, b};
    }

    private static String m17079b(UMPlatformData... uMPlatformDataArr) {
        JSONObject jSONObject = new JSONObject();
        for (UMPlatformData uMPlatformData : uMPlatformDataArr) {
            GENDER gender = uMPlatformData.getGender();
            CharSequence name = uMPlatformData.getName();
            if (gender == null) {
                try {
                    if (TextUtils.isEmpty(name)) {
                    }
                } catch (Throwable e) {
                    throw new C4184a("build body exception", e);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("gender", gender == null ? BuildConfig.FLAVOR : String.valueOf(gender.value));
            jSONObject2.put("name", name == null ? BuildConfig.FLAVOR : String.valueOf(name));
            jSONObject.put(uMPlatformData.getMeida().toString(), jSONObject2);
        }
        return jSONObject.length() == 0 ? null : jSONObject.toString();
    }

    private static Map<String, String> m17080b(Context context) {
        Map<String, String> hashMap = new HashMap();
        Map a = C4189f.m17076a(context);
        if (a == null || a.isEmpty()) {
            throw new C4184a("can`t get device id.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry entry : a.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getValue())) {
                stringBuilder2.append((String) entry.getKey()).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                stringBuilder.append((String) entry.getValue()).append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            hashMap.put("deviceid", stringBuilder.toString());
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            hashMap.put("idtype", stringBuilder2.toString());
        }
        return hashMap;
    }

    private static String m17081c(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            if (C4189f.m17077a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            C4185b.m17062e(C4156a.f13942d, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return BuildConfig.FLAVOR;
        } catch (Exception e) {
            C4185b.m17062e(C4156a.f13942d, "Could not get mac address." + e.toString());
        }
    }
}
