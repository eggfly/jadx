package anet.channel.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.security.C0684c;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import com.p105c.p106a.p111c.C2101a;
import com.taobao.accs.utl.C4135a;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Method;
import java.util.List;

public class Utils {
    private static final String SSL_TIKET_KEY2 = "accs_ssl_key2_";
    private static final String TAG = "awcn.Utils";
    public static int accsVersion;

    static {
        accsVersion = 0;
    }

    public static byte[] SecurityGuardGetSslTicket2(Context context, String str) {
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            ALog.m2963i(TAG, "get sslticket host is null", bArr, new Object[0]);
        } else {
            try {
                bArr = C0684c.m2818a().dynamicGetBytes(context, SSL_TIKET_KEY2 + str);
            } catch (Throwable th) {
                ALog.m2961e(TAG, "SecurityGuardGetSslTicket2", bArr, th, new Object[0]);
            }
        }
        return bArr;
    }

    public static int SecurityGuardPutSslTicket2(Context context, String str, byte[] bArr) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            if (!C0684c.m2818a().dynamicPutBytes(context, SSL_TIKET_KEY2 + str, bArr)) {
                i = -1;
            }
        } catch (Throwable th) {
            ALog.m2961e(TAG, "SecurityGuardPutSslTicket2", null, th, new Object[0]);
            i = -1;
        }
        return i;
    }

    public static int getAccsVersion() {
        if (accsVersion != 0) {
            return accsVersion;
        }
        try {
            accsVersion = ((Integer) Utils.class.getClassLoader().loadClass(C4135a.channelService).getDeclaredField("SDK_VERSION_CODE").get(null)).intValue();
        } catch (Throwable e) {
            ALog.m2964w(TAG, "getAccsVersion", null, e, new Object[0]);
        }
        return accsVersion;
    }

    public static String getAppSign(Context context, String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            ALog.m2962e(TAG, "getAppSign appkey null", null, new Object[0]);
            return null;
        }
        String signAuth;
        try {
            signAuth = C0684c.m2818a().signAuth(context, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, str, str2, GlobalAppRuntimeInfo.getAuthCode());
        } catch (Throwable th) {
            signAuth = null;
        }
        return signAuth;
    }

    public static String getAppVersion(Context context) {
        String str = BuildConfig.FLAVOR;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getDeviceId(Context context) {
        return C2101a.m7882a(context);
    }

    public static String getImsi(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getMainProcessName(Context context) {
        String str = BuildConfig.FLAVOR;
        if (context != null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
            } catch (NameNotFoundException e) {
            }
        }
        return str;
    }

    public static String getOperator(Context context) {
        String imsi = getImsi(context);
        String str = "null";
        return (imsi == null || imsi.length() <= 5) ? str : imsi.substring(0, 5);
    }

    public static String getProcessName(Context context, int i) {
        String str = BuildConfig.FLAVOR;
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            String str2;
            Object obj;
            if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, ErrorConstant.formatMsg(ErrorConstant.ERROR_GET_PROCESS_NULL, "BuildVersion=" + String.valueOf(VERSION.SDK_INT)), "rt"));
                str2 = str;
                return TextUtils.isEmpty(obj) ? getProcessNameNew(i) : obj;
            } else {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        obj = runningAppProcessInfo.processName;
                        break;
                    }
                }
                str2 = str;
                if (TextUtils.isEmpty(obj)) {
                }
            }
        } catch (Exception e) {
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, e.toString(), "rt"));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getProcessNameNew(int r9) {
        /*
        r8 = 0;
        r2 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "ps  |  grep  ";
        r0 = r0.append(r1);
        r0 = r0.append(r9);
        r0 = r0.toString();
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x00bc, all -> 0x00e0 }
        r3 = "sh";
        r4 = r1.exec(r3);	 Catch:{ Exception -> 0x00bc, all -> 0x00e0 }
        r3 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00bc, all -> 0x00e0 }
        r1 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00bc, all -> 0x00e0 }
        r5 = r4.getInputStream();	 Catch:{ Exception -> 0x00bc, all -> 0x00e0 }
        r1.<init>(r5);	 Catch:{ Exception -> 0x00bc, all -> 0x00e0 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x00bc, all -> 0x00e0 }
        r1 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x00fe, all -> 0x00f9 }
        r5 = r4.getOutputStream();	 Catch:{ Exception -> 0x00fe, all -> 0x00f9 }
        r1.<init>(r5);	 Catch:{ Exception -> 0x00fe, all -> 0x00f9 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0101 }
        r5.<init>();	 Catch:{ Exception -> 0x0101 }
        r0 = r5.append(r0);	 Catch:{ Exception -> 0x0101 }
        r5 = "  &\n";
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x0101 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0101 }
        r1.writeBytes(r0);	 Catch:{ Exception -> 0x0101 }
        r1.flush();	 Catch:{ Exception -> 0x0101 }
        r0 = "exit\n";
        r1.writeBytes(r0);	 Catch:{ Exception -> 0x0101 }
        r4.waitFor();	 Catch:{ Exception -> 0x0101 }
    L_0x0057:
        r0 = r3.readLine();	 Catch:{ Exception -> 0x0101 }
        if (r0 == 0) goto L_0x00a4;
    L_0x005d:
        r4 = "\\s+";
        r5 = "  ";
        r0 = r0.replaceAll(r4, r5);	 Catch:{ Exception -> 0x0101 }
        r4 = "  ";
        r0 = r0.split(r4);	 Catch:{ Exception -> 0x0101 }
        r4 = r0.length;	 Catch:{ Exception -> 0x0101 }
        r5 = 9;
        if (r4 < r5) goto L_0x0057;
    L_0x0070:
        r4 = 1;
        r4 = r0[r4];	 Catch:{ Exception -> 0x0101 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0101 }
        if (r4 != 0) goto L_0x0057;
    L_0x0079:
        r4 = 1;
        r4 = r0[r4];	 Catch:{ Exception -> 0x0101 }
        r4 = r4.trim();	 Catch:{ Exception -> 0x0101 }
        r5 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x0101 }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0101 }
        if (r4 == 0) goto L_0x0057;
    L_0x008a:
        r4 = 8;
        r0 = r0[r4];	 Catch:{ Exception -> 0x0101 }
        if (r3 == 0) goto L_0x0093;
    L_0x0090:
        r3.close();	 Catch:{ IOException -> 0x0099 }
    L_0x0093:
        if (r1 == 0) goto L_0x0098;
    L_0x0095:
        r1.close();	 Catch:{ IOException -> 0x0099 }
    L_0x0098:
        return r0;
    L_0x0099:
        r1 = move-exception;
        r3 = "awcn.Utils";
        r4 = "getProcessNameNew ";
        r5 = new java.lang.Object[r8];
        anet.channel.util.ALog.m2961e(r3, r4, r2, r1, r5);
        goto L_0x0098;
    L_0x00a4:
        if (r3 == 0) goto L_0x00a9;
    L_0x00a6:
        r3.close();	 Catch:{ IOException -> 0x00b1 }
    L_0x00a9:
        if (r1 == 0) goto L_0x00ae;
    L_0x00ab:
        r1.close();	 Catch:{ IOException -> 0x00b1 }
    L_0x00ae:
        r0 = "";
        goto L_0x0098;
    L_0x00b1:
        r0 = move-exception;
        r1 = "awcn.Utils";
        r3 = "getProcessNameNew ";
        r4 = new java.lang.Object[r8];
        anet.channel.util.ALog.m2961e(r1, r3, r2, r0, r4);
        goto L_0x00ae;
    L_0x00bc:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x00bf:
        r4 = "awcn.Utils";
        r5 = "getProcessNameNew ";
        r6 = 0;
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x00fc }
        anet.channel.util.ALog.m2961e(r4, r5, r6, r0, r7);	 Catch:{ all -> 0x00fc }
        if (r3 == 0) goto L_0x00cf;
    L_0x00cc:
        r3.close();	 Catch:{ IOException -> 0x00d5 }
    L_0x00cf:
        if (r1 == 0) goto L_0x00ae;
    L_0x00d1:
        r1.close();	 Catch:{ IOException -> 0x00d5 }
        goto L_0x00ae;
    L_0x00d5:
        r0 = move-exception;
        r1 = "awcn.Utils";
        r3 = "getProcessNameNew ";
        r4 = new java.lang.Object[r8];
        anet.channel.util.ALog.m2961e(r1, r3, r2, r0, r4);
        goto L_0x00ae;
    L_0x00e0:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x00e3:
        if (r3 == 0) goto L_0x00e8;
    L_0x00e5:
        r3.close();	 Catch:{ IOException -> 0x00ee }
    L_0x00e8:
        if (r1 == 0) goto L_0x00ed;
    L_0x00ea:
        r1.close();	 Catch:{ IOException -> 0x00ee }
    L_0x00ed:
        throw r0;
    L_0x00ee:
        r1 = move-exception;
        r3 = "awcn.Utils";
        r4 = "getProcessNameNew ";
        r5 = new java.lang.Object[r8];
        anet.channel.util.ALog.m2961e(r3, r4, r2, r1, r5);
        goto L_0x00ed;
    L_0x00f9:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00e3;
    L_0x00fc:
        r0 = move-exception;
        goto L_0x00e3;
    L_0x00fe:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00bf;
    L_0x0101:
        r0 = move-exception;
        goto L_0x00bf;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.Utils.getProcessNameNew(int):java.lang.String");
    }

    public static String getStackMsg(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString() + "\n");
                }
            }
        } catch (Throwable e) {
            ALog.m2961e(TAG, "getStackMsg", null, e, new Object[0]);
        }
        return stringBuffer.toString();
    }

    public static Object invokeStaticMethodThrowException(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        if (str == null || str2 == null) {
            return null;
        }
        Class cls = Class.forName(str);
        Method declaredMethod = clsArr != null ? cls.getDeclaredMethod(str2, clsArr) : cls.getDeclaredMethod(str2, new Class[0]);
        if (declaredMethod == null) {
            return null;
        }
        declaredMethod.setAccessible(true);
        return objArr != null ? declaredMethod.invoke(cls, objArr) : declaredMethod.invoke(cls, new Object[0]);
    }

    public static boolean isDebugMode(Context context) {
        return false;
    }

    public static byte[] staticBinarySafeDecryptNoB64(Context context, String str, byte[] bArr) {
        byte[] staticDecrypt;
        Throwable th;
        try {
            staticDecrypt = C0684c.m2818a().staticDecrypt(context, ISecurity.CIPHER_ALGORITHM_AES128, str, bArr, GlobalAppRuntimeInfo.getAuthCode());
            if (staticDecrypt != null) {
                try {
                    if (ALog.isPrintLog(2)) {
                        ALog.m2963i("staticBinarySafeDecryptNoB64", null, "decrypt", new String(staticDecrypt));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    ALog.m2961e(TAG, "staticBinarySafeDecryptNoB64", null, th, new Object[0]);
                    return staticDecrypt;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            staticDecrypt = null;
            ALog.m2961e(TAG, "staticBinarySafeDecryptNoB64", null, th, new Object[0]);
            return staticDecrypt;
        }
        return staticDecrypt;
    }
}
