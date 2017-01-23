package com.igexin.push.util;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.umeng.message.util.HttpRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.entity.mime.MIME;

/* renamed from: com.igexin.push.util.q */
public class C3938q {
    public static final String f13222a;

    static {
        f13222a = C3938q.class.getName();
    }

    private static String m16191a(InputStream inputStream, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            return stringWriter2;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static String m16192a(String str) {
        String str2 = "utf-8";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String[] split = str.split(";");
        int length = split.length;
        int i = 0;
        while (i < length) {
            String trim = split[i].trim();
            if (trim.startsWith(HttpRequest.f14538D)) {
                String[] split2 = trim.split("=", 2);
                return (split2.length != 2 || TextUtils.isEmpty(split2[1])) ? str2 : split2[1].trim();
            } else {
                i++;
            }
        }
        return str2;
    }

    private static HttpURLConnection m16193a(URL url, String str, String str2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestProperty(HttpRequest.f14569v, "GETUI");
        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, str2);
        httpURLConnection.setRequestProperty("HOST", url.getHost() + ":" + url.getPort());
        return httpURLConnection;
    }

    private static byte[] m16194a(InputStream inputStream) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        byte[] bArr = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(IXAdIOUtils.BUFFER_SIZE);
                byte[] bArr2 = new byte[IXAdIOUtils.BUFFER_SIZE];
                while (true) {
                    int read = bufferedInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Exception e2) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            bufferedInputStream = bArr;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedInputStream = bArr;
            th = th4;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
        return bArr;
    }

    public static byte[] m16195a(java.lang.String r3, java.lang.String r4, byte[] r5, int r6, int r7) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.igexin.push.util.q.a(java.lang.String, java.lang.String, byte[], int, int):byte[]. bs: [B:6:0x0012, B:16:0x002a]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:57)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r2 = 0;
        r0 = new java.net.URL;	 Catch:{ IOException -> 0x0028, all -> 0x0039 }
        r0.<init>(r3);	 Catch:{ IOException -> 0x0028, all -> 0x0039 }
        r1 = "POST";	 Catch:{ IOException -> 0x0028, all -> 0x0039 }
        r1 = com.igexin.push.util.C3938q.m16193a(r0, r1, r4);	 Catch:{ IOException -> 0x0028, all -> 0x0039 }
        r1.setConnectTimeout(r6);	 Catch:{ IOException -> 0x003c }
        r1.setReadTimeout(r7);	 Catch:{ IOException -> 0x003c }
        r2 = r1.getOutputStream();	 Catch:{ Exception -> 0x0037 }
        r2.write(r5);	 Catch:{ Exception -> 0x0037 }
        r0 = com.igexin.push.util.C3938q.m16197a(r1);	 Catch:{ Exception -> 0x0037 }
        if (r2 == 0) goto L_0x0022;
    L_0x001f:
        r2.close();
    L_0x0022:
        if (r1 == 0) goto L_0x0027;
    L_0x0024:
        r1.disconnect();
    L_0x0027:
        return r0;
    L_0x0028:
        r0 = move-exception;
        r1 = r2;
    L_0x002a:
        throw r0;	 Catch:{ all -> 0x002b }
    L_0x002b:
        r0 = move-exception;
    L_0x002c:
        if (r2 == 0) goto L_0x0031;
    L_0x002e:
        r2.close();
    L_0x0031:
        if (r1 == 0) goto L_0x0036;
    L_0x0033:
        r1.disconnect();
    L_0x0036:
        throw r0;
    L_0x0037:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x002b }
    L_0x0039:
        r0 = move-exception;
        r1 = r2;
        goto L_0x002c;
    L_0x003c:
        r0 = move-exception;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.q.a(java.lang.String, java.lang.String, byte[], int, int):byte[]");
    }

    public static byte[] m16196a(String str, byte[] bArr, int i, int i2) {
        return C3938q.m16195a(str, "application/octet-stream", bArr, i, i2);
    }

    private static byte[] m16197a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getErrorStream() == null ? C3938q.m16194a(httpURLConnection.getInputStream()) : C3938q.m16198b(httpURLConnection).getBytes();
    }

    private static String m16198b(HttpURLConnection httpURLConnection) {
        Object a = C3938q.m16191a(httpURLConnection.getErrorStream(), C3938q.m16192a(httpURLConnection.getContentType()));
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        throw new IOException(httpURLConnection.getResponseCode() + ":" + httpURLConnection.getResponseMessage());
    }
}
