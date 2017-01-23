package com.taobao.accs.utl;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.p105c.p106a.p111c.C2101a;
import com.taobao.accs.client.C4085a;
import com.taobao.accs.common.Constants;
import com.umeng.message.common.C4209a;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;

/* renamed from: com.taobao.accs.utl.a */
public class C4135a {
    public static String f13895a = null;
    public static final String channelService = "com.taobao.accs.ChannelService";
    public static final String msgService = "com.taobao.accs.data.MsgDistributeService";

    static {
        f13895a = BuildConfig.FLAVOR;
    }

    public static long m16907a() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1;
            }
            if (VERSION.SDK_INT >= 9) {
                return dataDirectory.getUsableSpace();
            }
            if (!dataDirectory.exists()) {
                return -1;
            }
            StatFs statFs = new StatFs(dataDirectory.getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            ALog.m16902e("AdapterUtilityImpl", "getUsableSpace", th, new Object[0]);
            return -1;
        }
    }

    public static String m16908a(Context context, int i) {
        if (C4085a.f13625f != null) {
            return C4085a.f13625f.getCurrProcessName();
        }
        String str = BuildConfig.FLAVOR;
        for (RunningAppProcessInfo runningAppProcessInfo : C4085a.m16662a(context).m16668b().getRunningAppProcesses()) {
            String str2;
            try {
                if (runningAppProcessInfo.pid == i) {
                    str2 = runningAppProcessInfo.processName;
                    str = str2;
                }
            } catch (Exception e) {
            }
            str2 = str;
            str = str2;
        }
        return str;
    }

    public static String m16909a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString() + "\n");
                }
            }
        } catch (Exception e) {
        }
        return stringBuffer.toString();
    }

    public static boolean m16910a(Context context) {
        try {
            Object obj = TextUtils.isEmpty(C4085a.f13623d) ? context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName : C4085a.f13623d;
            Object a = C4135a.m16908a(context, Process.myPid());
            return (TextUtils.isEmpty(obj) || TextUtils.isEmpty(a)) ? true : a.equalsIgnoreCase(obj);
        } catch (Throwable th) {
            ALog.m16902e("AdapterUtilityImpl", "isMainProcess", th, new Object[0]);
            return true;
        }
    }

    public static final boolean m16911a(String str, int i) {
        if (str == null) {
            return false;
        }
        StatFs statFs = new StatFs(str);
        int blockSize = statFs.getBlockSize();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        Log.d("FileCheckUtils", "st.getAvailableBlocks()=" + statFs.getAvailableBlocks() + ",st.getAvailableBlocks() * blockSize=" + (((long) statFs.getAvailableBlocks()) * ((long) blockSize)));
        return statFs.getAvailableBlocks() > 10 && ((long) blockSize) * availableBlocks > ((long) i);
    }

    public static String m16912b(Context context) {
        return C2101a.m7882a(context);
    }

    public static boolean m16913c(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = C4085a.m16662a(context).m16669c().getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String m16914d(Context context) {
        String string;
        Throwable th;
        String str = f13895a;
        try {
            string = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(C4209a.f14204g, f13895a);
            try {
                if (!TextUtils.isEmpty(string)) {
                    f13895a = string;
                }
                ALog.m16901d("AdapterUtilityImpl", "getAppkey APPKEY:" + string, new Object[0]);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return string;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            string = str;
            th = th4;
            th.printStackTrace();
            return string;
        }
        return string;
    }
}
