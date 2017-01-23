package com.antutu.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class Report {
    private static final String TAG_OEMID = "oemid";
    private static final String TAG_SETTING = "setting";
    private static final String TAG_SOFTID = "softid";

    /* renamed from: com.antutu.utils.Report.1 */
    static class C18071 extends Thread {
        final /* synthetic */ info_data val$idata;

        C18071(info_data com_antutu_utils_Report_info_data) {
            this.val$idata = com_antutu_utils_Report_info_data;
        }

        public void run() {
            try {
                Methods.httpPost(jni.getURI(), "data=" + jni.getOEMData(this.val$idata.uid, this.val$idata.oem, this.val$idata.soft, this.val$idata.other, this.val$idata.ver, this.val$idata.act));
            } catch (Exception e) {
            }
        }
    }

    static class info_data {
        int act;
        String dui;
        String ip;
        String mac;
        String oem;
        String other;
        String soft;
        String uid;
        int ver;

        info_data() {
            this.uid = BuildConfig.FLAVOR;
            this.oem = BuildConfig.FLAVOR;
            this.soft = BuildConfig.FLAVOR;
            this.mac = BuildConfig.FLAVOR;
            this.dui = BuildConfig.FLAVOR;
            this.ip = BuildConfig.FLAVOR;
            this.other = BuildConfig.FLAVOR;
            this.act = 0;
            this.ver = 0;
        }

        public boolean bEnable() {
            return this.dui != null && this.dui.length() > 1;
        }

        public boolean bUseable() {
            return (this.uid.isEmpty() || this.mac.isEmpty() || this.ip.isEmpty()) ? false : true;
        }
    }

    public static String getLocalIPAddress() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
        }
        return BuildConfig.FLAVOR;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getUID(android.content.Context r8) {
        /*
        r2 = 14;
        r0 = "phone";
        r0 = r8.getSystemService(r0);
        r0 = (android.telephony.TelephonyManager) r0;
        r0 = r0.getDeviceId();
        if (r0 != 0) goto L_0x0012;
    L_0x0010:
        r0 = "";
    L_0x0012:
        r1 = "000000";
        r1 = r0.startsWith(r1);
        if (r1 != 0) goto L_0x0022;
    L_0x001a:
        r1 = "123456";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x0024;
    L_0x0022:
        r0 = "";
    L_0x0024:
        r1 = r0.length();
        if (r1 >= r2) goto L_0x003d;
    L_0x002a:
        r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r8);
        r0 = "SGUID";
        r1 = "";
        r1 = r3.getString(r0, r1);
        r0 = r1.length();
        if (r0 < r2) goto L_0x003e;
    L_0x003c:
        r0 = r1;
    L_0x003d:
        return r0;
    L_0x003e:
        r2 = 0;
        r0 = "android.os.SystemProperties";
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x007a }
        r4 = "get";
        r5 = 1;
        r5 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x007a }
        r6 = 0;
        r7 = java.lang.String.class;
        r5[r6] = r7;	 Catch:{ Exception -> 0x007a }
        r4 = r0.getMethod(r4, r5);	 Catch:{ Exception -> 0x007a }
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x007a }
        r6 = 0;
        r7 = "ro.serialno";
        r5[r6] = r7;	 Catch:{ Exception -> 0x007a }
        r0 = r4.invoke(r0, r5);	 Catch:{ Exception -> 0x007a }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x007a }
    L_0x0061:
        if (r0 == 0) goto L_0x007d;
    L_0x0063:
        r2 = r0.length();	 Catch:{ Exception -> 0x0088 }
        r4 = 10;
        if (r2 <= r4) goto L_0x007d;
    L_0x006b:
        r1 = r3.edit();	 Catch:{ Exception -> 0x0078 }
        r2 = "SGUID";
        r1.putString(r2, r0);	 Catch:{ Exception -> 0x0078 }
        r1.commit();	 Catch:{ Exception -> 0x0078 }
        goto L_0x003d;
    L_0x0078:
        r1 = move-exception;
        goto L_0x003d;
    L_0x007a:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0061;
    L_0x007d:
        r0 = r8.getContentResolver();	 Catch:{ Exception -> 0x0088 }
        r2 = "android_id";
        r0 = android.provider.Settings.System.getString(r0, r2);	 Catch:{ Exception -> 0x0088 }
        goto L_0x006b;
    L_0x0088:
        r0 = move-exception;
        r0 = r1;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.Report.getUID(android.content.Context):java.lang.String");
    }

    private static void logData(info_data com_antutu_utils_Report_info_data) {
        new C18071(com_antutu_utils_Report_info_data).start();
    }

    public static void report(Context context, int i) {
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Editor edit;
            if (defaultSharedPreferences.getBoolean("frist_start", true)) {
                edit = defaultSharedPreferences.edit();
                edit.putBoolean("frist_start", false);
                edit.commit();
                reportInstall(context, i);
                return;
            }
            String string = defaultSharedPreferences.getString("last_start", BuildConfig.FLAVOR);
            String charSequence = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
            if (!string.equals(charSequence)) {
                reportRun(context, i);
                edit = defaultSharedPreferences.edit();
                edit.putString("last_start", charSequence);
                edit.commit();
            }
        } catch (Exception e) {
        }
    }

    private static void reportInstall(Context context, int i) {
        test(context, i, 0);
    }

    public static void reportInstallOEM(Context context, int i) {
        test(context, i, 0);
    }

    private static void reportOnTime(Context context, int i) {
        test(context, i, 2);
    }

    private static void reportRun(Context context, int i) {
        test(context, i, 1);
    }

    public static void test(Context context, int i, int i2) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return;
            }
        } catch (Exception e) {
        }
        try {
            info_data com_antutu_utils_Report_info_data = new info_data();
            XmlResourceParser xml = context.getResources().getXml(i);
            while (true) {
                int next = xml.next();
                if (next == 2) {
                    if (xml.getName().equals(TAG_SETTING)) {
                        int attributeCount = xml.getAttributeCount();
                        for (next = 0; next < attributeCount; next++) {
                            String attributeName = xml.getAttributeName(next);
                            String attributeValue = xml.getAttributeValue(next);
                            if (attributeName.equals(TAG_OEMID)) {
                                com_antutu_utils_Report_info_data.oem = attributeValue;
                            } else if (attributeName.equals(TAG_SOFTID)) {
                                com_antutu_utils_Report_info_data.soft = attributeValue;
                            }
                        }
                    }
                } else if (next == 1) {
                    try {
                        break;
                    } catch (Exception e2) {
                    }
                }
            }
            com_antutu_utils_Report_info_data.ver = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            try {
                String language = context.getResources().getConfiguration().locale.getLanguage();
                String country = context.getResources().getConfiguration().locale.getCountry();
                if (language != null && language.length() > 0) {
                    com_antutu_utils_Report_info_data.other += "&lang=" + language;
                }
                if (country != null && country.length() > 0) {
                    com_antutu_utils_Report_info_data.other += "&country=" + country;
                }
            } catch (Exception e3) {
            }
            try {
                com_antutu_utils_Report_info_data.other += "&android_id=" + System.getString(context.getContentResolver(), "android_id");
            } catch (Exception e4) {
            }
            com_antutu_utils_Report_info_data.act = i2;
            WifiManager wifiManager = (WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                com_antutu_utils_Report_info_data.mac = connectionInfo.getMacAddress().replace(":", BuildConfig.FLAVOR);
            }
            com_antutu_utils_Report_info_data.ip = getLocalIPAddress();
            com_antutu_utils_Report_info_data.uid = getUID(context);
            logData(com_antutu_utils_Report_info_data);
        } catch (Exception e5) {
        }
    }
}
