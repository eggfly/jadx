package com.xiaomi.mistatistic.sdk.controller;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.BuildSetting;
import com.xiaomi.mistatistic.sdk.CustomSettings;
import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.xmsf.push.service.C0618a.C0620a;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.j */
public abstract class C0571j {

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.j.b */
    public interface C0530b {
        void m6280a(String str);
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.j.1 */
    final class C05691 implements ServiceConnection {
        final /* synthetic */ C0530b f4748a;
        final /* synthetic */ String f4749b;
        final /* synthetic */ Map f4750c;
        final /* synthetic */ Context f4751d;
        private boolean f4752e;

        /* renamed from: com.xiaomi.mistatistic.sdk.controller.j.1.1 */
        class C05681 implements C0523a {
            final /* synthetic */ IBinder f4745a;
            final /* synthetic */ ServiceConnection f4746b;
            final /* synthetic */ C05691 f4747c;

            C05681(C05691 c05691, IBinder iBinder, ServiceConnection serviceConnection) {
                this.f4747c = c05691;
                this.f4745a = iBinder;
                this.f4746b = serviceConnection;
            }

            public void m6428a() {
                try {
                    this.f4747c.f4748a.m6280a(C0620a.m6614a(this.f4745a).m6612a(this.f4747c.f4749b, this.f4747c.f4750c));
                    this.f4747c.f4752e = true;
                    C0566h.m6414a("connected, do remote http post");
                    this.f4747c.f4751d.unbindService(this.f4746b);
                } catch (Throwable th) {
                    C0566h.m6418a("error while uploading the logs by IPC.", th);
                    this.f4747c.f4748a.m6280a(null);
                    this.f4747c.f4752e = true;
                }
            }
        }

        C05691(C0530b c0530b, String str, Map map, Context context) {
            this.f4748a = c0530b;
            this.f4749b = str;
            this.f4750c = map;
            this.f4751d = context;
            this.f4752e = false;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0566h.m6418a("error while perform IPC connection.", null);
            if (!this.f4752e) {
                this.f4748a.m6280a(null);
                C0566h.m6414a("disconnected, remote http post hasn't not processed");
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C0555d.m6362a().m6365a(new C05681(this, iBinder, this));
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.j.a */
    public static final class C0570a extends FilterInputStream {
        private boolean f4753a;

        public C0570a(InputStream inputStream) {
            super(inputStream);
        }

        public int read(byte[] bArr, int i, int i2) {
            if (!this.f4753a) {
                int read = super.read(bArr, i, i2);
                if (read != -1) {
                    return read;
                }
            }
            this.f4753a = true;
            return -1;
        }
    }

    public static boolean m6437a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                return 1 == activeNetworkInfo.getType();
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static String m6438b(Context context) {
        if (C0571j.m6437a(context)) {
            return "WIFI";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return "";
                }
                return (activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName() + "-" + activeNetworkInfo.getExtraInfo()).toLowerCase();
            } catch (Exception e) {
                return "";
            }
        } catch (Exception e2) {
            return "";
        }
    }

    public static void m6433a(Context context, String str, Map<String, String> map, C0530b c0530b) {
        IOException e;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("url");
        }
        OutputStream outputStream;
        try {
            HttpURLConnection a = C0571j.m6432a(context, new URL(str));
            a.setConnectTimeout(10000);
            a.setReadTimeout(15000);
            a.setRequestMethod("POST");
            C0571j.m6435a((Map) map);
            String b = C0571j.m6439b((Map) map);
            if (b == null) {
                throw new IllegalArgumentException("nameValuePairs");
            }
            a.setDoOutput(true);
            byte[] bytes = b.getBytes();
            outputStream = a.getOutputStream();
            try {
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();
                OutputStream outputStream2 = null;
                a.getResponseCode();
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new C0570a(a.getInputStream())));
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    String property = System.getProperty("line.separator");
                    for (String readLine = bufferedReader3.readLine(); readLine != null; readLine = bufferedReader3.readLine()) {
                        stringBuffer.append(readLine);
                        stringBuffer.append(property);
                    }
                    c0530b.m6280a(stringBuffer.toString());
                    bufferedReader3.close();
                    BufferedReader bufferedReader4 = null;
                    if (null != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e2) {
                            return;
                        }
                    }
                    if (null != null) {
                        bufferedReader4.close();
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedReader = bufferedReader3;
                    outputStream = null;
                    bufferedReader2 = bufferedReader;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader3;
                    outputStream = null;
                    bufferedReader2 = bufferedReader;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            throw th;
                        }
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                throw new IOException(th.getMessage());
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            throw e;
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    protected static void m6435a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap hashMap = new HashMap();
        if (map != null) {
            List<String> arrayList = new ArrayList(map.keySet());
            C0566h.m6419b("mistats_NetworkUtils_keys:" + arrayList.toString());
            Collections.sort(arrayList);
            for (String str : arrayList) {
                stringBuilder.append(str + ((String) map.get(str)));
            }
        }
        stringBuilder.append("mistats_sdkconfig_jafej!@#)(*e@!#");
        map.put("sign", C0597q.m6531b(stringBuilder.toString()).toLowerCase(Locale.getDefault()));
    }

    public static String m6439b(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer deleteCharAt;
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            deleteCharAt = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } else {
            deleteCharAt = stringBuffer;
        }
        return deleteCharAt.toString();
    }

    public static HttpURLConnection m6432a(Context context, URL url) {
        if (!"http".equals(url.getProtocol())) {
            return (HttpURLConnection) url.openConnection();
        }
        if (C0571j.m6442d(context)) {
            return (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        if (!C0571j.m6441c(context)) {
            return (HttpURLConnection) url.openConnection();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(C0571j.m6431a(url)).openConnection();
        httpURLConnection.addRequestProperty("X-Online-Host", url.getHost());
        return httpURLConnection;
    }

    public static String m6431a(URL url) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url.getProtocol()).append("://").append("10.0.0.172").append(url.getPath());
        if (!TextUtils.isEmpty(url.getQuery())) {
            stringBuilder.append("?").append(url.getQuery());
        }
        return stringBuilder.toString();
    }

    public static boolean m6441c(Context context) {
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3 || extraInfo.contains("ctwap")) {
                    return false;
                }
                return extraInfo.regionMatches(true, extraInfo.length() - 3, "wap", 0, 3);
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean m6442d(Context context) {
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return false;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3) {
                    return false;
                }
                return extraInfo.contains("ctwap");
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static void m6434a(String str, Map<String, String> map, C0530b c0530b) {
        if (CustomSettings.m6255c()) {
            C0566h.m6414a("Uploading to: " + str);
            if (map != null) {
                map.put("bc", BuildSetting.m6246d());
            }
            if (!CustomSettings.m6253a()) {
                C0566h.m6414a("Uploading under app network");
                C0571j.m6433a(C0551c.m6352a(), str, (Map) map, c0530b);
                return;
            } else if (C0571j.m6436a()) {
                try {
                    C0566h.m6414a("Uploading via sys service, unmetered network connected");
                    C0571j.m6440b(C0551c.m6352a(), str, map, c0530b);
                    return;
                } catch (Exception e) {
                    throw new IOException("exception thrown from IPC." + e.getMessage());
                }
            } else {
                C0566h.m6414a("Uploading via sys service, metered network connected, skip");
                return;
            }
        }
        C0566h.m6425d("upload is disabled.");
        c0530b.m6280a("");
    }

    @SuppressLint({"NewApi"})
    public static boolean m6436a() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) C0551c.m6352a().getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            if (activeNetworkInfo.getType() == 1) {
                return true;
            }
            if (VERSION.SDK_INT < 16) {
                return false;
            }
            return !connectivityManager.isActiveNetworkMetered();
        } catch (Exception e) {
            return false;
        }
    }

    public static String m6430a(String str, Map<String, String> map, File file, String str2) {
        DataOutputStream dataOutputStream;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        IOException e;
        Object obj;
        Object obj2;
        Throwable th;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        String str3 = "\r\n";
        str3 = "--";
        str3 = "*****";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            httpURLConnection.setFixedLengthStreamingMode(((name.length() + 77) + ((int) file.length())) + str2.length());
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"" + "\r\n");
                dataOutputStream.writeBytes("\r\n");
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    bufferedReader = new BufferedReader(new InputStreamReader(new C0570a(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            str3 = bufferedReader.readLine();
                            if (str3 == null) {
                                break;
                            }
                            stringBuffer.append(str3);
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader3 = bufferedReader;
                            obj = dataOutputStream;
                            obj2 = fileInputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader3 = bufferedReader;
                        }
                    }
                    str3 = stringBuffer.toString();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e3) {
                            C0566h.m6418a("", e3);
                            return str3;
                        }
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedReader == null) {
                        return str3;
                    }
                    bufferedReader.close();
                    return str3;
                } catch (IOException e4) {
                    e = e4;
                    obj = dataOutputStream;
                    obj2 = fileInputStream;
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = bufferedReader2;
                        dataOutputStream = bufferedReader;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        throw new IOException(th.getMessage());
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e32) {
                                C0566h.m6418a("", e32);
                                throw th;
                            }
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                        throw th;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                obj = dataOutputStream;
                bufferedReader2 = null;
                throw e;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (bufferedReader3 != null) {
                    bufferedReader3.close();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
            bufferedReader2 = null;
            throw e;
        } catch (Throwable th7) {
            th = th7;
            dataOutputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            throw th;
        }
    }

    public static void m6440b(Context context, String str, Map<String, String> map, C0530b c0530b) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.xiaomi.xmsf", "com.xiaomi.xmsf.push.service.HttpService");
            if (!context.bindService(intent, new C05691(c0530b, str, map, context), 1)) {
                C0566h.m6414a("failed to bind");
                c0530b.m6280a(null);
            }
        } catch (Throwable e) {
            C0566h.m6418a("uploadDataThroughSystemService", e);
            c0530b.m6280a(null);
        }
    }
}
