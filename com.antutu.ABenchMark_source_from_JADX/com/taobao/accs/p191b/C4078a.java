package com.taobao.accs.p191b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import anet.channel.strategy.dispatch.C0720e;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.facebook.ads.AdError;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;
import org.android.agoo.message.MessageService;

/* renamed from: com.taobao.accs.b.a */
public class C4078a implements Callback {
    public static final int ACT_START = 0;
    public static final int ACT_STOP = -1;
    public static final String AGOO_PID = "agoo.pid";
    public static final String EX_FILE_NAME = "DaemonServer";
    public static final String PROCESS_NAME = "runServer";
    public static String f13576a;
    private static final String f13577c;
    private static int f13578g;
    private static int f13579h;
    private static final ReentrantLock f13580i;
    private static C4078a f13581j;
    public boolean f13582b;
    private Context f13583d;
    private String f13584e;
    private int f13585f;
    private String f13586k;
    private String f13587l;
    private String f13588m;
    private String f13589n;
    private int f13590o;
    private String f13591p;
    private String f13592q;
    private int f13593r;
    private boolean f13594s;
    private Handler f13595t;
    private HandlerThread f13596u;

    static {
        f13577c = C4078a.class.getName();
        f13576a = "startservice -n {packname}/com.taobao.accs.ChannelService";
        f13578g = 7200;
        f13579h = C0720e.REQUEST_MERGE_PERIOD;
        f13580i = new ReentrantLock();
        f13581j = null;
    }

    public C4078a(Context context, int i, boolean z) {
        this.f13583d = null;
        this.f13585f = 1800;
        this.f13582b = false;
        this.f13586k = "100001";
        this.f13587l = "tb_accs_eudemon_1.1.3";
        this.f13588m = BuildConfig.FLAVOR;
        this.f13589n = "21646297";
        this.f13590o = ACT_START;
        this.f13591p = "100.69.165.28";
        this.f13592q = "http://100.69.165.28/agoo/report";
        this.f13593r = 80;
        this.f13594s = true;
        this.f13595t = null;
        this.f13596u = null;
        m16641b();
        f13576a = "startservice -n {packname}/com.taobao.accs.ChannelService";
        this.f13583d = context;
        this.f13585f = i;
        this.f13582b = z;
        this.f13584e = C4078a.m16635a(new Build(), "CPU_ABI");
        this.f13588m = "/data/data/" + context.getPackageName();
        this.f13590o = Constants.SDK_VERSION_CODE;
        this.f13589n = UtilityImpl.getAppkey(this.f13583d);
        if (UtilityImpl.isReleaseMode(context)) {
            this.f13591p = "agoodm.m.taobao.com";
            this.f13593r = 80;
            this.f13592q = "http://agoodm.m.taobao.com/agoo/report";
            this.f13586k = "1009527";
        } else if (UtilityImpl.isPreviewMode(context)) {
            this.f13591p = "110.75.98.154";
            this.f13593r = 80;
            this.f13592q = "http://agoodm.wapa.taobao.com/agoo/report";
            this.f13586k = "1009527";
        } else {
            this.f13591p = "100.69.168.33";
            this.f13593r = 80;
            this.f13592q = "http://100.69.168.33/agoo/report";
            this.f13585f = 60;
            this.f13586k = "9527";
        }
    }

    public static final PendingIntent m16633a(Context context) {
        Intent intent = new Intent();
        intent.setAction(context.getApplicationContext().getPackageName() + ".intent.action.COCKROACH");
        intent.putExtra("cockroach", "cockroach-PPreotect");
        intent.putExtra("pack", context.getApplicationContext().getPackageName());
        return PendingIntent.getService(context, ACT_START, intent, 134217728);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.taobao.accs.p191b.C4078a m16634a(android.content.Context r4, int r5, boolean r6) {
        /*
        r0 = f13580i;	 Catch:{ Exception -> 0x0018 }
        r0.lock();	 Catch:{ Exception -> 0x0018 }
        r0 = f13581j;	 Catch:{ Exception -> 0x0018 }
        if (r0 != 0) goto L_0x0010;
    L_0x0009:
        r0 = new com.taobao.accs.b.a;	 Catch:{ Exception -> 0x0018 }
        r0.<init>(r4, r5, r6);	 Catch:{ Exception -> 0x0018 }
        f13581j = r0;	 Catch:{ Exception -> 0x0018 }
    L_0x0010:
        r0 = f13580i;
        r0.unlock();
    L_0x0015:
        r0 = f13581j;
        return r0;
    L_0x0018:
        r0 = move-exception;
        r1 = f13577c;	 Catch:{ all -> 0x0029 }
        r2 = "getInstance";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0029 }
        com.taobao.accs.utl.ALog.m16902e(r1, r2, r0, r3);	 Catch:{ all -> 0x0029 }
        r0 = f13580i;
        r0.unlock();
        goto L_0x0015;
    L_0x0029:
        r0 = move-exception;
        r1 = f13580i;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.b.a.a(android.content.Context, int, boolean):com.taobao.accs.b.a");
    }

    private static String m16635a(Build build, String str) {
        try {
            return Build.class.getField(str).get(build).toString();
        } catch (Throwable th) {
            return "Unknown";
        }
    }

    private static void m16636a(AlarmManager alarmManager, PendingIntent pendingIntent, long j) {
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
            alarmManager.setRepeating(2, ((long) (f13579h * AdError.NETWORK_ERROR_CODE)) + j, (long) (f13579h * AdError.NETWORK_ERROR_CODE), pendingIntent);
        }
    }

    private void m16637a(FileOutputStream fileOutputStream, File file) {
        Throwable e;
        String a = C4079b.m16654a(this.f13584e);
        ALog.m16901d(f13577c, ">>>soDataSize:datasize:" + a.length(), new Object[ACT_START]);
        byte[] decode = Base64.decode(a.getBytes(), ACT_START);
        ALog.m16901d(f13577c, ">>>soDataSize:" + decode.length, new Object[ACT_START]);
        if (decode.length > 0 && fileOutputStream != null) {
            StatFs statFs = new StatFs(file.getCanonicalPath());
            if (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) < ((long) decode.length)) {
                Log.e(f13577c, "Disk is not enough for writing this file");
                return;
            }
            ByteArrayInputStream byteArrayInputStream;
            try {
                byteArrayInputStream = new ByteArrayInputStream(decode);
                try {
                    decode = new byte[100];
                    while (true) {
                        int read = byteArrayInputStream.read(decode, ACT_START, 100);
                        if (read < 0) {
                            break;
                        }
                        fileOutputStream.write(decode, ACT_START, read);
                    }
                    fileOutputStream.getFD().sync();
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        ALog.m16902e(f13577c, "error in write files", e, new Object[ACT_START]);
                        fileOutputStream.getFD().sync();
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        fileOutputStream.getFD().sync();
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                byteArrayInputStream = null;
                ALog.m16902e(f13577c, "error in write files", e, new Object[ACT_START]);
                fileOutputStream.getFD().sync();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            } catch (Throwable th2) {
                e = th2;
                byteArrayInputStream = null;
                fileOutputStream.getFD().sync();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw e;
            }
        }
    }

    private void m16638a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        C4078a.m16640a(BuildConfig.FLAVOR, "chmod 500 " + str, stringBuilder);
        C4078a.m16640a(BuildConfig.FLAVOR, str + " " + m16647e(), stringBuilder);
        ALog.m16906w(f13577c, str + " " + m16647e(), new Object[ACT_START]);
    }

    private void m16639a(String str, int i, int i2, String str2, String str3, int i3) {
        String str4 = "AndroidVer=" + VERSION.RELEASE + "&Model=" + Build.MODEL + "&AndroidSdk=" + VERSION.SDK_INT + "&AccsVer=" + Constants.SDK_VERSION_CODE + "&Appkey=" + UtilityImpl.getAppkey(this.f13583d) + "&PullCount=" + str2 + "&Pid=" + str + "&StartTime=" + i + "&EndTime=" + i2 + "&ExitCode=" + str3 + "&AliveTime=" + i3;
        Log.d(f13577c, "EUDEMON_ENDSTAT doReportDaemonStat:" + str4);
        UTMini.getInstance().commitEvent(UT.EVENT_ID, "EUDEMON_ENDSTAT", str4);
    }

    public static boolean m16640a(String str, String str2, StringBuilder stringBuilder) {
        Log.w("TAG.", str2);
        try {
            Process exec = Runtime.getRuntime().exec(IXAdRequestInfo.SCREEN_HEIGHT);
            DataInputStream dataInputStream = new DataInputStream(exec.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
            if (!(str == null || BuildConfig.FLAVOR.equals(str.trim()))) {
                dataOutputStream.writeBytes("cd " + str + "\n");
            }
            dataOutputStream.writeBytes(str2 + " &\n");
            dataOutputStream.writeBytes("exit \n");
            dataOutputStream.flush();
            exec.waitFor();
            byte[] bArr = new byte[dataInputStream.available()];
            dataInputStream.read(bArr);
            String str3 = new String(bArr);
            if (str3.length() != 0) {
                stringBuilder.append(str3);
            }
            return true;
        } catch (Exception e) {
            stringBuilder.append("Exception:" + e.getMessage());
            return false;
        }
    }

    private void m16641b() {
        Log.d(f13577c, "start handler init");
        this.f13596u = new HandlerThread("soManager-threads");
        this.f13596u.start();
        this.f13595t = new Handler(this.f13596u.getLooper(), this);
    }

    private static void m16642b(AlarmManager alarmManager, PendingIntent pendingIntent, long j) {
        alarmManager.cancel(pendingIntent);
        alarmManager.setRepeating(3, ((long) (f13578g * AdError.NETWORK_ERROR_CODE)) + j, (long) (f13578g * AdError.NETWORK_ERROR_CODE), pendingIntent);
    }

    public static void m16643b(Context context) {
        int i = Calendar.getInstance().get(11);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompatApi21.CATEGORY_ALARM);
        if (alarmManager != null) {
            PendingIntent a = C4078a.m16633a(context);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (i > 23 || i < 6) {
                ALog.m16906w(f13577c, "time is night, do not wakeup cpu", new Object[ACT_START]);
                C4078a.m16642b(alarmManager, a, elapsedRealtime);
                return;
            }
            ALog.m16906w(f13577c, "time is daytime, wakeup cpu for keeping connecntion", new Object[ACT_START]);
            C4078a.m16636a(alarmManager, a, elapsedRealtime);
        }
    }

    private String m16644c() {
        return this.f13584e.startsWith("arm") ? "armeabi/" : this.f13584e + "/";
    }

    public static void m16645c(Context context) {
        Throwable th;
        try {
            File file = new File(context.getFilesDir(), AGOO_PID);
            ALog.m16901d(f13577c, "pid path:" + file.getAbsolutePath(), new Object[ACT_START]);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fileWriter;
            try {
                int myPid = Process.myPid();
                fileWriter = new FileWriter(file);
                try {
                    fileWriter.write(String.valueOf(myPid).toCharArray());
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable th2) {
                            ALog.m16902e(f13577c, C4233j.f14375B, th2, new Object[ACT_START]);
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        ALog.m16902e(f13577c, "save pid error", th2, new Object[ACT_START]);
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Throwable th22) {
                                ALog.m16902e(f13577c, C4233j.f14375B, th22, new Object[ACT_START]);
                            }
                        }
                    } catch (Throwable th4) {
                        th22 = th4;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Throwable th5) {
                                ALog.m16902e(f13577c, C4233j.f14375B, th5, new Object[ACT_START]);
                            }
                        }
                        throw th22;
                    }
                }
            } catch (Throwable th6) {
                th22 = th6;
                fileWriter = null;
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th22;
            }
        } catch (Throwable th222) {
            ALog.m16902e(f13577c, "error in create file", th222, new Object[ACT_START]);
        }
    }

    private String m16646d() {
        InputStream inputStream = null;
        File file = new File(this.f13583d.getFilesDir(), EX_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
        ALog.m16906w(f13577c, "open assets from = " + m16644c() + EX_FILE_NAME, new Object[ACT_START]);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            if (this.f13582b) {
                inputStream = this.f13583d.getAssets().open(m16644c() + EX_FILE_NAME);
                byte[] bArr = new byte[100];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, ACT_START, read);
                }
            } else {
                m16637a(fileOutputStream, file);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    ALog.m16902e(f13577c, "error in close input file", e, new Object[ACT_START]);
                }
            }
            try {
                fileOutputStream.close();
            } catch (Throwable e2) {
                ALog.m16902e(f13577c, "error in close io", e2, new Object[ACT_START]);
            }
        } catch (Throwable e22) {
            ALog.m16902e(f13577c, "error in copy daemon files", e22, new Object[ACT_START]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e222) {
                    ALog.m16902e(f13577c, "error in close input file", e222, new Object[ACT_START]);
                }
            }
            try {
                fileOutputStream.close();
            } catch (Throwable e2222) {
                ALog.m16902e(f13577c, "error in close io", e2222, new Object[ACT_START]);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    ALog.m16902e(f13577c, "error in close input file", e3, new Object[ACT_START]);
                }
            }
            try {
                fileOutputStream.close();
            } catch (Throwable e32) {
                ALog.m16902e(f13577c, "error in close io", e32, new Object[ACT_START]);
            }
        }
        return file.getCanonicalPath();
    }

    private String m16647e() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "/data/data/" + this.f13583d.getPackageName();
        stringBuilder.append("-s \"" + str + "/lib/" + "\" ");
        stringBuilder.append("-n \"runServer\" ");
        stringBuilder.append("-p \"" + m16649g() + "\" ");
        stringBuilder.append("-f \"" + str + "\" ");
        stringBuilder.append("-t \"" + this.f13585f + "\" ");
        stringBuilder.append("-c \"agoo.pid\" ");
        if (this.f13588m != null) {
            stringBuilder.append("-P " + this.f13588m + " ");
        }
        if (this.f13586k != null) {
            stringBuilder.append("-K " + this.f13586k + " ");
        }
        if (this.f13587l != null) {
            stringBuilder.append("-U " + this.f13587l + " ");
        }
        if (this.f13592q != null) {
            stringBuilder.append("-L " + this.f13592q + " ");
        }
        stringBuilder.append("-D " + m16648f() + " ");
        if (this.f13591p != null) {
            stringBuilder.append("-I " + this.f13591p + " ");
        }
        if (this.f13593r > 0) {
            stringBuilder.append("-O " + this.f13593r + " ");
        }
        str = UtilityImpl.getProxyHost(this.f13583d);
        int proxyPort = UtilityImpl.getProxyPort(this.f13583d);
        if (str != null && proxyPort > 0) {
            stringBuilder.append("-X " + str + " ");
            stringBuilder.append("-Y " + proxyPort + " ");
        }
        if (this.f13594s) {
            stringBuilder.append("-T ");
        }
        stringBuilder.append("-Z ");
        return stringBuilder.toString();
    }

    private String m16648f() {
        String deviceId = UtilityImpl.getDeviceId(this.f13583d);
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = "null";
        }
        deviceId = "{\"package\":\"" + this.f13583d.getPackageName() + "\",\"appKey\":\"" + this.f13589n + "\",\"utdid\":\"" + deviceId + "\",\"sdkVersion\":\"" + this.f13590o + "\"}";
        try {
            deviceId = URLEncoder.encode(deviceId, HttpRequest.f14548a);
        } catch (Throwable th) {
            ALog.m16903e(f13577c, "getReportData failed for url encode, data:" + deviceId, new Object[ACT_START]);
        }
        return deviceId;
    }

    private String m16649g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f13576a.replaceAll("\\{packname\\}", this.f13583d.getApplicationContext().getPackageName()));
        if (VERSION.SDK_INT > 15) {
            stringBuilder.append(" --user 0");
        }
        return stringBuilder.toString();
    }

    private void m16650h() {
        FileInputStream fileInputStream;
        Throwable e;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader;
        String str = "/data/data/" + this.f13583d.getPackageName() + "/" + "eudemon";
        File file = new File(str);
        if (file.exists()) {
            FileOutputStream fileOutputStream2 = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader2 = null;
            InputStreamReader inputStreamReader2;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader2 = new InputStreamReader(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    fileInputStream2 = fileInputStream;
                    try {
                        Log.e(f13577c, "report daemon stat exp:", e);
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable e3) {
                                Log.e(f13577c, "error in close buffreader stream", e3);
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable e32) {
                                Log.e(f13577c, "error in close reader stream", e32);
                            }
                        }
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Throwable e322) {
                                Log.e(f13577c, "error in close input file", e322);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e3222) {
                                Log.e(f13577c, "error in close input file", e3222);
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        e3222 = th;
                        bufferedReader = bufferedReader2;
                        inputStreamReader2 = inputStreamReader;
                        fileOutputStream2 = fileOutputStream;
                        fileInputStream = fileInputStream2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                Log.e(f13577c, "error in close buffreader stream", th2);
                            }
                        }
                        if (inputStreamReader2 != null) {
                            try {
                                inputStreamReader2.close();
                            } catch (Throwable th22) {
                                Log.e(f13577c, "error in close reader stream", th22);
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th222) {
                                Log.e(f13577c, "error in close input file", th222);
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th2222) {
                                Log.e(f13577c, "error in close input file", th2222);
                            }
                        }
                        throw e3222;
                    }
                } catch (Throwable th3) {
                    e3222 = th3;
                    bufferedReader = null;
                    inputStreamReader2 = null;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e3222;
                }
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2);
                    try {
                        String str2 = BuildConfig.FLAVOR;
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = readLine.split("\\|");
                            if (split.length == 5) {
                                String trim = split[ACT_START].trim();
                                int intValue = Integer.valueOf(split[1].trim()).intValue();
                                int intValue2 = Integer.valueOf(split[2].trim()).intValue();
                                int i = intValue2 - intValue;
                                String trim2 = split[3].trim();
                                String trim3 = split[4].trim();
                                if (trim3.equals(MessageService.MSG_DB_READY_REPORT)) {
                                    File file2 = new File("/proc", trim);
                                    Log.e(f13577c, "pidfile:" + file2);
                                    if (file2.exists()) {
                                        str2 = str2 + readLine + "\n";
                                    } else {
                                        i += this.f13585f / 2;
                                    }
                                }
                                m16639a(trim, intValue, intValue2, trim2, trim3, i);
                            }
                        }
                        FileOutputStream fileOutputStream3 = new FileOutputStream(new File(str));
                        try {
                            fileOutputStream3.write(str2.getBytes());
                            bufferedReader.close();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable e32222) {
                                    Log.e(f13577c, "error in close buffreader stream", e32222);
                                }
                            }
                            if (inputStreamReader2 != null) {
                                try {
                                    inputStreamReader2.close();
                                } catch (Throwable e322222) {
                                    Log.e(f13577c, "error in close reader stream", e322222);
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e3222222) {
                                    Log.e(f13577c, "error in close input file", e3222222);
                                }
                            }
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (Throwable e32222222) {
                                    Log.e(f13577c, "error in close input file", e32222222);
                                }
                            }
                        } catch (Exception e4) {
                            e32222222 = e4;
                            inputStreamReader = inputStreamReader2;
                            fileOutputStream = fileOutputStream3;
                            fileInputStream2 = fileInputStream;
                            bufferedReader2 = bufferedReader;
                            Log.e(f13577c, "report daemon stat exp:", e32222222);
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th4) {
                            e32222222 = th4;
                            fileOutputStream2 = fileOutputStream3;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader2 != null) {
                                inputStreamReader2.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            throw e32222222;
                        }
                    } catch (Exception e5) {
                        e32222222 = e5;
                        bufferedReader2 = bufferedReader;
                        inputStreamReader = inputStreamReader2;
                        fileOutputStream = null;
                        fileInputStream2 = fileInputStream;
                        Log.e(f13577c, "report daemon stat exp:", e32222222);
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        e32222222 = th5;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw e32222222;
                    }
                } catch (Exception e6) {
                    e32222222 = e6;
                    inputStreamReader = inputStreamReader2;
                    fileOutputStream = null;
                    fileInputStream2 = fileInputStream;
                    Log.e(f13577c, "report daemon stat exp:", e32222222);
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th6) {
                    e32222222 = th6;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e32222222;
                }
            } catch (Exception e7) {
                e32222222 = e7;
                fileInputStream2 = null;
                fileOutputStream = null;
                Log.e(f13577c, "report daemon stat exp:", e32222222);
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th7) {
                e32222222 = th7;
                bufferedReader = null;
                inputStreamReader2 = null;
                fileInputStream = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw e32222222;
            }
        }
    }

    private void m16651i() {
        ALog.m16901d(f13577c, "api level is:" + VERSION.SDK_INT, new Object[ACT_START]);
        C4078a.m16643b(this.f13583d);
        if (VERSION.SDK_INT < 20) {
            try {
                String d = m16646d();
                m16650h();
                m16638a(d);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        UTMini.getInstance().commitEvent(UT.EVENT_ID, "EUDEMON_START", BuildConfig.FLAVOR);
    }

    private void m16652j() {
        File file = new File("/data/data/" + this.f13583d.getPackageName(), "daemonserver.pid");
        if (file.exists()) {
            file.delete();
        }
    }

    public void m16653a() {
        Log.d(f13577c, "start SoManager");
        Message message = new Message();
        message.what = ACT_START;
        this.f13595t.sendMessage(message);
    }

    public boolean handleMessage(Message message) {
        try {
            if (message.what == 0) {
                m16651i();
            } else if (message.what == ACT_STOP) {
                m16652j();
            }
        } catch (Throwable th) {
            ALog.m16902e(f13577c, "handleMessage error", th, new Object[ACT_START]);
        }
        return true;
    }
}
