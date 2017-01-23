package com.umeng.message.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.antutu.utils.HttpUtil;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.proguard.C4230g;
import java.net.URLEncoder;

/* renamed from: com.umeng.message.util.b */
public class C4266b {
    public static final int f14586a = 1;
    public static final int f14587b = 2;
    public static final int f14588c = 3;
    private static final String f14589i;
    private final int f14590d;
    private String f14591e;
    private String f14592f;
    private int f14593g;
    private Context f14594h;

    static {
        f14589i = C4266b.class.getName();
    }

    public C4266b(Context context) {
        this.f14590d = f14586a;
        this.f14592f = "10.0.0.172";
        this.f14593g = 80;
        this.f14594h = context;
        this.f14591e = m17545a(context);
    }

    private String m17545a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MsgConstant.SDK_VERSION);
        stringBuffer.append("/");
        stringBuffer.append(MsgConstant.SDK_VERSION);
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(UmengMessageDeviceConfig.getApplicationLable(context));
            stringBuffer2.append("/");
            stringBuffer2.append(UmengMessageDeviceConfig.getAppVersionName(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("/");
            stringBuffer2.append(VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(C4230g.m17261a(PushAgent.getInstance(context).getMessageAppkey()));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), HttpRequest.f14548a));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private boolean m17546a() {
        if (this.f14594h.getPackageManager().checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, this.f14594h.getPackageName()) != 0) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f14594h.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == f14586a)) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null && (extraInfo.equals(HttpUtil.APN_CMWAP) || extraInfo.equals(HttpUtil.APN_3GWAP) || extraInfo.equals(HttpUtil.APN_UNIWAP))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] m17547a(byte[] r8, java.lang.String r9) {
        /*
        r7 = this;
        r2 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x008e }
        r0.<init>(r9);	 Catch:{ Exception -> 0x008e }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x008e }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x008e }
        r1 = "POST";
        r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1 = "Msg-Type";
        r3 = "envelope";
        r0.setRequestProperty(r1, r3);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1 = 1;
        r0.setDoOutput(r1);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1 = 0;
        r0.setChunkedStreamingMode(r1);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r3 = r0.getOutputStream();	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1.write(r8);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1.flush();	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1.close();	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1 = r0.getInputStream();	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r3.<init>(r1);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        r1 = com.umeng.message.proguard.C4230g.m17269a(r3);	 Catch:{ all -> 0x0053 }
        com.umeng.message.proguard.C4230g.m17275b(r3);	 Catch:{ Exception -> 0x0092, all -> 0x008a }
        if (r0 == 0) goto L_0x0098;
    L_0x004e:
        r0.disconnect();
        r0 = r1;
    L_0x0052:
        return r0;
    L_0x0053:
        r1 = move-exception;
        com.umeng.message.proguard.C4230g.m17275b(r3);	 Catch:{ Exception -> 0x0058, all -> 0x008a }
        throw r1;	 Catch:{ Exception -> 0x0058, all -> 0x008a }
    L_0x0058:
        r1 = move-exception;
        r6 = r0;
        r0 = r2;
        r2 = r6;
    L_0x005c:
        if (r1 == 0) goto L_0x007a;
    L_0x005e:
        r3 = f14589i;	 Catch:{ all -> 0x0083 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0083 }
        r4.<init>();	 Catch:{ all -> 0x0083 }
        r5 = "sendMessage:";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0083 }
        r5 = r1.getMessage();	 Catch:{ all -> 0x0083 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0083 }
        r4 = r4.toString();	 Catch:{ all -> 0x0083 }
        com.umeng.message.common.UmLog.m17138e(r3, r4);	 Catch:{ all -> 0x0083 }
    L_0x007a:
        r1.printStackTrace();	 Catch:{ all -> 0x0083 }
        if (r2 == 0) goto L_0x0052;
    L_0x007f:
        r2.disconnect();
        goto L_0x0052;
    L_0x0083:
        r0 = move-exception;
    L_0x0084:
        if (r2 == 0) goto L_0x0089;
    L_0x0086:
        r2.disconnect();
    L_0x0089:
        throw r0;
    L_0x008a:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x0084;
    L_0x008e:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x005c;
    L_0x0092:
        r2 = move-exception;
        r6 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x005c;
    L_0x0098:
        r0 = r1;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.b.a(byte[], java.lang.String):byte[]");
    }
}
