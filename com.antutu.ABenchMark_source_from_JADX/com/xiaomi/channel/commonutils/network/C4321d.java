package com.xiaomi.channel.commonutils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.util.HttpConstant;
import com.antutu.utils.HttpUtil;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.channel.commonutils.string.C4328c;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import org.apache.http.entity.mime.MIME;

/* renamed from: com.xiaomi.channel.commonutils.network.d */
public class C4321d {
    public static final Pattern f14759a;
    public static final Pattern f14760b;
    public static final Pattern f14761c;

    /* renamed from: com.xiaomi.channel.commonutils.network.d.a */
    public static final class C4319a extends FilterInputStream {
        private boolean f14756a;

        public C4319a(InputStream inputStream) {
            super(inputStream);
        }

        public int read(byte[] bArr, int i, int i2) {
            if (!this.f14756a) {
                int read = super.read(bArr, i, i2);
                if (read != -1) {
                    return read;
                }
            }
            this.f14756a = true;
            return -1;
        }
    }

    /* renamed from: com.xiaomi.channel.commonutils.network.d.b */
    public static class C4320b {
        public int f14757a;
        public Map<String, String> f14758b;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", new Object[]{Integer.valueOf(this.f14757a), this.f14758b.toString()});
        }
    }

    static {
        f14759a = Pattern.compile("([^\\s;]+)(.*)");
        f14760b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
        f14761c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    }

    public static int m17694a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? -1 : activeNetworkInfo.getType();
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.channel.commonutils.network.C4318b m17695a(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.lang.String r13) {
        /*
        r3 = 0;
        r2 = 0;
        r5 = new com.xiaomi.channel.commonutils.network.b;
        r5.<init>();
        r0 = com.xiaomi.channel.commonutils.network.C4321d.m17706b(r10);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r6 = com.xiaomi.channel.commonutils.network.C4321d.m17705b(r9, r0);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r6.setConnectTimeout(r0);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r0 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r6.setReadTimeout(r0);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        if (r11 != 0) goto L_0x001d;
    L_0x001b:
        r11 = "GET";
    L_0x001d:
        r6.setRequestMethod(r11);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        if (r12 == 0) goto L_0x0052;
    L_0x0022:
        r0 = r12.keySet();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r4 = r0.iterator();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
    L_0x002a:
        r0 = r4.hasNext();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        if (r0 == 0) goto L_0x0052;
    L_0x0030:
        r0 = r4.next();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r0 = (java.lang.String) r0;	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r1 = r12.get(r0);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r6.setRequestProperty(r0, r1);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        goto L_0x002a;
    L_0x0040:
        r0 = move-exception;
        r1 = r2;
    L_0x0042:
        throw r0;	 Catch:{ all -> 0x0043 }
    L_0x0043:
        r0 = move-exception;
        r8 = r1;
        r1 = r2;
        r2 = r8;
    L_0x0047:
        if (r1 == 0) goto L_0x004c;
    L_0x0049:
        r1.close();	 Catch:{ IOException -> 0x0118 }
    L_0x004c:
        if (r2 == 0) goto L_0x0051;
    L_0x004e:
        r2.close();	 Catch:{ IOException -> 0x0118 }
    L_0x0051:
        throw r0;
    L_0x0052:
        r0 = android.text.TextUtils.isEmpty(r13);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        if (r0 != 0) goto L_0x013c;
    L_0x0058:
        r0 = 1;
        r6.setDoOutput(r0);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r0 = r13.getBytes();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r1 = r6.getOutputStream();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r4 = 0;
        r7 = r0.length;	 Catch:{ IOException -> 0x0133, Throwable -> 0x012c }
        r1.write(r0, r4, r7);	 Catch:{ IOException -> 0x0133, Throwable -> 0x012c }
        r1.flush();	 Catch:{ IOException -> 0x0133, Throwable -> 0x012c }
        r1.close();	 Catch:{ IOException -> 0x0133, Throwable -> 0x012c }
        r4 = r2;
    L_0x0070:
        r0 = r6.getResponseCode();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r5.f14753a = r0;	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r0 = "com.xiaomi.common.Network";
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r1.<init>();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r7 = "Http POST Response Code: ";
        r1 = r1.append(r7);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r7 = r5.f14753a;	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r1 = r1.append(r7);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        android.util.Log.d(r0, r1);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r0 = r3;
    L_0x0091:
        r1 = r6.getHeaderFieldKey(r0);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r3 = r6.getHeaderField(r0);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        if (r1 != 0) goto L_0x00cc;
    L_0x009b:
        if (r3 != 0) goto L_0x00cc;
    L_0x009d:
        r1 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x00d6, Throwable -> 0x00eb, all -> 0x0122 }
        r0 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x00d6, Throwable -> 0x00eb, all -> 0x0122 }
        r3 = new com.xiaomi.channel.commonutils.network.d$a;	 Catch:{ IOException -> 0x00d6, Throwable -> 0x00eb, all -> 0x0122 }
        r7 = r6.getInputStream();	 Catch:{ IOException -> 0x00d6, Throwable -> 0x00eb, all -> 0x0122 }
        r3.<init>(r7);	 Catch:{ IOException -> 0x00d6, Throwable -> 0x00eb, all -> 0x0122 }
        r0.<init>(r3);	 Catch:{ IOException -> 0x00d6, Throwable -> 0x00eb, all -> 0x0122 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x00d6, Throwable -> 0x00eb, all -> 0x0122 }
    L_0x00b0:
        r0 = r1.readLine();	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
        r3 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
        r3.<init>();	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
        r6 = "line.separator";
        r6 = java.lang.System.getProperty(r6);	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
    L_0x00bf:
        if (r0 == 0) goto L_0x00fa;
    L_0x00c1:
        r3.append(r0);	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
        r3.append(r6);	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
        r0 = r1.readLine();	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
        goto L_0x00bf;
    L_0x00cc:
        r7 = r5.f14754b;	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r7.put(r1, r3);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r0 = r0 + 1;
        r0 = r0 + 1;
        goto L_0x0091;
    L_0x00d6:
        r0 = move-exception;
        r1 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r0 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r3 = new com.xiaomi.channel.commonutils.network.d$a;	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r6 = r6.getErrorStream();	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r3.<init>(r6);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r0.<init>(r3);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x0040, Throwable -> 0x00eb, all -> 0x0122 }
        goto L_0x00b0;
    L_0x00eb:
        r0 = move-exception;
        r1 = r2;
    L_0x00ed:
        r3 = new java.io.IOException;	 Catch:{ all -> 0x00f7 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x00f7 }
        r3.<init>(r0);	 Catch:{ all -> 0x00f7 }
        throw r3;	 Catch:{ all -> 0x00f7 }
    L_0x00f7:
        r0 = move-exception;
        goto L_0x0047;
    L_0x00fa:
        r0 = r3.toString();	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
        r5.f14755c = r0;	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
        r1.close();	 Catch:{ IOException -> 0x0139, Throwable -> 0x012e, all -> 0x0126 }
        r0 = 0;
        if (r2 == 0) goto L_0x0109;
    L_0x0106:
        r4.close();	 Catch:{ IOException -> 0x010f }
    L_0x0109:
        if (r2 == 0) goto L_0x010e;
    L_0x010b:
        r0.close();	 Catch:{ IOException -> 0x010f }
    L_0x010e:
        return r5;
    L_0x010f:
        r0 = move-exception;
        r1 = "com.xiaomi.common.Network";
        r2 = "error while closing strean";
        android.util.Log.e(r1, r2, r0);
        goto L_0x010e;
    L_0x0118:
        r1 = move-exception;
        r2 = "com.xiaomi.common.Network";
        r3 = "error while closing strean";
        android.util.Log.e(r2, r3, r1);
        goto L_0x0051;
    L_0x0122:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0047;
    L_0x0126:
        r0 = move-exception;
        r8 = r1;
        r1 = r2;
        r2 = r8;
        goto L_0x0047;
    L_0x012c:
        r0 = move-exception;
        goto L_0x00ed;
    L_0x012e:
        r0 = move-exception;
        r8 = r1;
        r1 = r2;
        r2 = r8;
        goto L_0x00ed;
    L_0x0133:
        r0 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0042;
    L_0x0139:
        r0 = move-exception;
        goto L_0x0042;
    L_0x013c:
        r4 = r2;
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.network.d.a(android.content.Context, java.lang.String, java.lang.String, java.util.Map, java.lang.String):com.xiaomi.channel.commonutils.network.b");
    }

    public static C4318b m17696a(Context context, String str, Map<String, String> map) {
        return C4321d.m17695a(context, str, SpdyRequest.POST_METHOD, null, C4321d.m17704a((Map) map));
    }

    public static InputStream m17697a(Context context, URL url, boolean z, String str, String str2) {
        return C4321d.m17698a(context, url, z, str, str2, null, null);
    }

    public static InputStream m17698a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, C4320b c4320b) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        } else if (url == null) {
            throw new IllegalArgumentException("url");
        } else {
            URL url2 = !z ? new URL(C4321d.m17701a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection b = C4321d.m17705b(context, url2);
                b.setConnectTimeout(10000);
                b.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    b.setRequestProperty(HttpRequest.f14569v, str);
                }
                if (str2 != null) {
                    b.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        b.setRequestProperty(str3, (String) map.get(str3));
                    }
                }
                if (c4320b != null) {
                    if (url.getProtocol().equals(HttpConstant.HTTP) || url.getProtocol().equals(HttpConstant.HTTPS)) {
                        c4320b.f14757a = b.getResponseCode();
                        if (c4320b.f14758b == null) {
                            c4320b.f14758b = new HashMap();
                        }
                        int i = 0;
                        while (true) {
                            CharSequence headerFieldKey = b.getHeaderFieldKey(i);
                            CharSequence headerField = b.getHeaderField(i);
                            if (headerFieldKey == null && headerField == null) {
                                break;
                            }
                            if (!(TextUtils.isEmpty(headerFieldKey) || TextUtils.isEmpty(headerField))) {
                                c4320b.f14758b.put(headerFieldKey, headerField);
                            }
                            i++;
                        }
                    }
                }
                return new C4319a(b.getInputStream());
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                IOException iOException = new IOException(th.getMessage());
            }
        }
    }

    public static String m17699a(Context context, URL url) {
        return C4321d.m17700a(context, url, false, null, HttpRequest.f14548a, null);
    }

    public static String m17700a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream = null;
        try {
            inputStream = C4321d.m17697a(context, url, z, str, str3);
            StringBuilder stringBuilder = new StringBuilder(IXAdIOUtils.BUFFER_SIZE);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
            char[] cArr = new char[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 == read) {
                    break;
                }
                stringBuilder.append(cArr, 0, read);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + e.toString());
                }
            }
            return stringBuilder.toString();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + e2.toString());
                }
            }
        }
    }

    public static String m17701a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = new String();
        str2 = String.format("%sbe988a6134bc8254465424e5a70ef037", new Object[]{str});
        return String.format("%s&key=%s", new Object[]{str, C4328c.m17739a(str2)});
    }

    public static String m17702a(String str, Map<String, String> map, File file, String str2) {
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
            httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
            httpURLConnection.setRequestProperty(HttpConstant.CONNECTION, "Keep-Alive");
            httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data;boundary=*****");
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
                    byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
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
                    bufferedReader = new BufferedReader(new InputStreamReader(new C4319a(httpURLConnection.getInputStream())));
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
                            Log.e("com.xiaomi.common.Network", "error while closing strean", e3);
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
                                Log.e("com.xiaomi.common.Network", "error while closing strean", e32);
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

    public static String m17703a(URL url) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url.getProtocol()).append(HttpConstant.SCHEME_SPLIT).append("10.0.0.172").append(url.getPath());
        if (!TextUtils.isEmpty(url.getQuery())) {
            stringBuilder.append("?").append(url.getQuery());
        }
        return stringBuilder.toString();
    }

    public static String m17704a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode((String) entry.getKey(), HttpRequest.f14548a));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode((String) entry.getValue(), HttpRequest.f14548a));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    Log.d("com.xiaomi.common.Network", "Failed to convert from params map to string: " + e.toString());
                    Log.d("com.xiaomi.common.Network", "map: " + map.toString());
                    return null;
                }
            }
        }
        return (stringBuffer.length() > 0 ? stringBuffer.deleteCharAt(stringBuffer.length() - 1) : stringBuffer).toString();
    }

    public static HttpURLConnection m17705b(Context context, URL url) {
        if (!HttpConstant.HTTP.equals(url.getProtocol())) {
            return (HttpURLConnection) url.openConnection();
        }
        if (C4321d.m17708c(context)) {
            return (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
        }
        if (!C4321d.m17707b(context)) {
            return (HttpURLConnection) url.openConnection();
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(C4321d.m17703a(url)).openConnection();
        httpURLConnection.addRequestProperty("X-Online-Host", url.getHost());
        return httpURLConnection;
    }

    private static URL m17706b(String str) {
        return new URL(str);
    }

    public static boolean m17707b(Context context) {
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
                return (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3 || extraInfo.contains(HttpUtil.APN_CTWAP)) ? false : extraInfo.regionMatches(true, extraInfo.length() - 3, "wap", 0, 3);
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean m17708c(Context context) {
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
                return (TextUtils.isEmpty(extraInfo) || extraInfo.length() < 3) ? false : extraInfo.contains(HttpUtil.APN_CTWAP);
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean m17709d(Context context) {
        return C4321d.m17694a(context) >= 0;
    }

    public static boolean m17710e(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean m17711f(Context context) {
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

    public static String m17712g(Context context) {
        if (C4321d.m17711f(context)) {
            return UtilityImpl.NET_TYPE_WIFI;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return BuildConfig.FLAVOR;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? BuildConfig.FLAVOR : (activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getExtraInfo()).toLowerCase();
            } catch (Exception e) {
                return BuildConfig.FLAVOR;
            }
        } catch (Exception e2) {
            return BuildConfig.FLAVOR;
        }
    }
}
