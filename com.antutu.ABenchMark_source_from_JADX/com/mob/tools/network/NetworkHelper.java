package com.mob.tools.network;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.mob.tools.MobLog;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.MIME;

public class NetworkHelper {
    public static int connectionTimeout;
    public static int readTimout;

    /* renamed from: com.mob.tools.network.NetworkHelper.1 */
    class C40171 implements HttpResponseCallback {
        final /* synthetic */ HashMap val$tmpMap;

        C40171(HashMap hashMap) {
            this.val$tmpMap = hashMap;
        }

        public void onResponse(HttpConnection httpConnection) {
            int responseCode = httpConnection.getResponseCode();
            String readLine;
            if (responseCode == Constants.COMMAND_HANDSHAKE || responseCode == Constants.COMMAND_PING) {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8")));
                for (readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append('\n');
                    }
                    stringBuilder.append(readLine);
                }
                bufferedReader.close();
                this.val$tmpMap.put("resp", stringBuilder.toString());
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
            for (readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append('\n');
                }
                stringBuilder2.append(readLine);
            }
            bufferedReader2.close();
            HashMap hashMap = new HashMap();
            hashMap.put(C4233j.f14375B, stringBuilder2.toString());
            hashMap.put(MsgConstant.KEY_STATUS, Integer.valueOf(responseCode));
            throw new Throwable(new Hashon().fromHashMap(hashMap));
        }
    }

    public static class NetworkTimeOut {
        public int connectionTimeout;
        public int readTimout;
    }

    public static final class SimpleX509TrustManager implements X509TrustManager {
        private X509TrustManager standardTrustManager;

        public SimpleX509TrustManager(KeyStore keyStore) {
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
                instance.init(keyStore);
                TrustManager[] trustManagers = instance.getTrustManagers();
                if (trustManagers == null || trustManagers.length == 0) {
                    throw new NoSuchAlgorithmException("no trust manager found.");
                }
                this.standardTrustManager = (X509TrustManager) trustManagers[0];
            } catch (Exception e) {
                MobLog.getInstance().m4375d("failed to initialize the standard trust manager: " + e.getMessage(), new Object[0]);
                this.standardTrustManager = null;
            }
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            if (x509CertificateArr == null) {
                throw new IllegalArgumentException("there were no certificates.");
            } else if (x509CertificateArr.length == 1) {
                x509CertificateArr[0].checkValidity();
            } else if (this.standardTrustManager != null) {
                this.standardTrustManager.checkServerTrusted(x509CertificateArr, str);
            } else {
                throw new CertificateException("there were one more certificates but no trust manager found.");
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private HttpURLConnection getConnection(String str, NetworkTimeOut networkTimeOut) {
        Object instanceField;
        String str2;
        int i;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        String str3 = "methodTokens";
        try {
            instanceField = ReflectHelper.getInstanceField(httpURLConnection, str3);
        } catch (Throwable th) {
            instanceField = null;
        }
        if (instanceField == null) {
            str3 = "PERMITTED_USER_METHODS";
            try {
                instanceField = ReflectHelper.getStaticField("HttpURLConnection", str3);
                str2 = str3;
                i = 1;
            } catch (Throwable th2) {
                str2 = str3;
                i = 1;
            }
        } else {
            str2 = str3;
            i = 0;
        }
        if (instanceField != null) {
            String[] strArr = (String[]) instanceField;
            Object obj = new String[(strArr.length + 1)];
            System.arraycopy(strArr, 0, obj, 0, strArr.length);
            obj[strArr.length] = HttpPatch.METHOD_NAME;
            if (i != 0) {
                ReflectHelper.setStaticField("HttpURLConnection", str2, obj);
            } else {
                ReflectHelper.setInstanceField(httpURLConnection, str2, obj);
            }
        }
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            HostnameVerifier hostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{new SimpleX509TrustManager(null)}, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
        }
        int i2 = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i2 > 0) {
            httpURLConnection.setConnectTimeout(i2);
        }
        i2 = networkTimeOut == null ? readTimout : networkTimeOut.readTimout;
        if (i2 > 0) {
            httpURLConnection.setReadTimeout(i2);
        }
        return httpURLConnection;
    }

    private HTTPPart getFilePostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2) {
        Iterator it;
        HTTPPart stringPart;
        String uuid = UUID.randomUUID().toString();
        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + uuid);
        HTTPPart multiPart = new MultiPart();
        HTTPPart stringPart2 = new StringPart();
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair kVPair = (KVPair) it.next();
                stringPart2.append("--").append(uuid).append("\r\n");
                stringPart2.append("Content-Disposition: form-data; name=\"").append(kVPair.name).append("\"\r\n\r\n");
                stringPart2.append((String) kVPair.value).append("\r\n");
            }
        }
        multiPart.append(stringPart2);
        it = arrayList2.iterator();
        while (it.hasNext()) {
            kVPair = (KVPair) it.next();
            HTTPPart stringPart3 = new StringPart();
            File file = new File((String) kVPair.value);
            stringPart3.append("--").append(uuid).append("\r\n");
            stringPart3.append("Content-Disposition: form-data; name=\"").append(kVPair.name).append("\"; filename=\"").append(file.getName()).append("\"\r\n");
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor((String) kVPair.value);
            if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                if (((String) kVPair.value).toLowerCase().endsWith("jpg") || ((String) kVPair.value).toLowerCase().endsWith("jpeg")) {
                    contentTypeFor = "image/jpeg";
                } else if (((String) kVPair.value).toLowerCase().endsWith("png")) {
                    contentTypeFor = "image/png";
                } else if (((String) kVPair.value).toLowerCase().endsWith("gif")) {
                    contentTypeFor = "image/gif";
                } else {
                    InputStream fileInputStream = new FileInputStream((String) kVPair.value);
                    contentTypeFor = URLConnection.guessContentTypeFromStream(fileInputStream);
                    fileInputStream.close();
                    if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                        contentTypeFor = "application/octet-stream";
                    }
                }
            }
            stringPart3.append("Content-Type: ").append(contentTypeFor).append("\r\n\r\n");
            multiPart.append(stringPart3);
            stringPart2 = new FilePart();
            stringPart2.setFile((String) kVPair.value);
            multiPart.append(stringPart2);
            stringPart = new StringPart();
            stringPart.append("\r\n");
            multiPart.append(stringPart);
        }
        stringPart = new StringPart();
        stringPart.append("--").append(uuid).append("--\r\n");
        multiPart.append(stringPart);
        return multiPart;
    }

    private HTTPPart getTextPostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList) {
        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, HttpRequest.f14549b);
        HTTPPart stringPart = new StringPart();
        if (arrayList != null) {
            stringPart.append(kvPairsToUrl(arrayList));
        }
        return stringPart;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void httpPatchImpl(java.lang.String r13, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r14, com.mob.tools.network.KVPair<java.lang.String> r15, long r16, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r18, com.mob.tools.network.OnReadListener r19, com.mob.tools.network.HttpResponseCallback r20, com.mob.tools.network.NetworkHelper.NetworkTimeOut r21) {
        /*
        r12 = this;
        r4 = java.lang.System.currentTimeMillis();
        r2 = com.mob.tools.MobLog.getInstance();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r6 = "httpPatch: ";
        r3 = r3.append(r6);
        r3 = r3.append(r13);
        r3 = r3.toString();
        r6 = 0;
        r6 = new java.lang.Object[r6];
        r2.m4381i(r3, r6);
        if (r14 == 0) goto L_0x0044;
    L_0x0023:
        r2 = r12.kvPairsToUrl(r14);
        r3 = r2.length();
        if (r3 <= 0) goto L_0x0044;
    L_0x002d:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r13);
        r6 = "?";
        r3 = r3.append(r6);
        r2 = r3.append(r2);
        r13 = r2.toString();
    L_0x0044:
        r3 = new com.mob.tools.network.HttpPatch;
        r3.<init>(r13);
        if (r18 == 0) goto L_0x0065;
    L_0x004b:
        r6 = r18.iterator();
    L_0x004f:
        r2 = r6.hasNext();
        if (r2 == 0) goto L_0x0065;
    L_0x0055:
        r2 = r6.next();
        r2 = (com.mob.tools.network.KVPair) r2;
        r7 = r2.name;
        r2 = r2.value;
        r2 = (java.lang.String) r2;
        r3.setHeader(r7, r2);
        goto L_0x004f;
    L_0x0065:
        r6 = new com.mob.tools.network.FilePart;
        r6.<init>();
        r0 = r19;
        r6.setOnReadListener(r0);
        r2 = r15.value;
        r2 = (java.lang.String) r2;
        r6.setFile(r2);
        r0 = r16;
        r6.setOffset(r0);
        r2 = r6.toInputStream();
        r6 = r6.length();
        r6 = r6 - r16;
        r8 = new org.apache.http.entity.InputStreamEntity;
        r8.<init>(r2, r6);
        r2 = "application/offset+octet-stream";
        r8.setContentEncoding(r2);
        r3.setEntity(r8);
        r6 = new org.apache.http.params.BasicHttpParams;
        r6.<init>();
        if (r21 != 0) goto L_0x0140;
    L_0x0099:
        r2 = connectionTimeout;
    L_0x009b:
        if (r2 <= 0) goto L_0x00a0;
    L_0x009d:
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r6, r2);
    L_0x00a0:
        if (r21 != 0) goto L_0x0146;
    L_0x00a2:
        r2 = readTimout;
    L_0x00a4:
        if (r2 <= 0) goto L_0x00a9;
    L_0x00a6:
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r6, r2);
    L_0x00a9:
        r3.setParams(r6);
        r2 = "https://";
        r2 = r13.startsWith(r2);
        if (r2 == 0) goto L_0x014c;
    L_0x00b4:
        r2 = java.security.KeyStore.getDefaultType();
        r2 = java.security.KeyStore.getInstance(r2);
        r6 = 0;
        r7 = 0;
        r2.load(r6, r7);
        r6 = new com.mob.tools.network.SSLSocketFactoryEx;
        r6.<init>(r2);
        r2 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
        r6.setHostnameVerifier(r2);
        r7 = new org.apache.http.params.BasicHttpParams;
        r7.<init>();
        r2 = org.apache.http.HttpVersion.HTTP_1_1;
        org.apache.http.params.HttpProtocolParams.setVersion(r7, r2);
        r2 = "UTF-8";
        org.apache.http.params.HttpProtocolParams.setContentCharset(r7, r2);
        r2 = new org.apache.http.conn.scheme.SchemeRegistry;
        r2.<init>();
        r8 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory();
        r9 = new org.apache.http.conn.scheme.Scheme;
        r10 = "http";
        r11 = 80;
        r9.<init>(r10, r8, r11);
        r2.register(r9);
        r8 = new org.apache.http.conn.scheme.Scheme;
        r9 = "https";
        r10 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;
        r8.<init>(r9, r6, r10);
        r2.register(r8);
        r6 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
        r6.<init>(r7, r2);
        r2 = new org.apache.http.impl.client.DefaultHttpClient;
        r2.<init>(r6, r7);
    L_0x0105:
        r3 = r2.execute(r3);
        if (r20 == 0) goto L_0x015d;
    L_0x010b:
        r6 = new com.mob.tools.network.HttpConnectionImpl;	 Catch:{ Throwable -> 0x0152 }
        r6.<init>(r3);	 Catch:{ Throwable -> 0x0152 }
        r0 = r20;
        r0.onResponse(r6);	 Catch:{ Throwable -> 0x0152 }
        r2 = r2.getConnectionManager();
        r2.shutdown();
    L_0x011c:
        r2 = com.mob.tools.MobLog.getInstance();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r6 = "use time: ";
        r3 = r3.append(r6);
        r6 = java.lang.System.currentTimeMillis();
        r4 = r6 - r4;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r4 = 0;
        r4 = new java.lang.Object[r4];
        r2.m4381i(r3, r4);
        return;
    L_0x0140:
        r0 = r21;
        r2 = r0.connectionTimeout;
        goto L_0x009b;
    L_0x0146:
        r0 = r21;
        r2 = r0.readTimout;
        goto L_0x00a4;
    L_0x014c:
        r2 = new org.apache.http.impl.client.DefaultHttpClient;
        r2.<init>();
        goto L_0x0105;
    L_0x0152:
        r3 = move-exception;
        throw r3;	 Catch:{ all -> 0x0154 }
    L_0x0154:
        r3 = move-exception;
        r2 = r2.getConnectionManager();
        r2.shutdown();
        throw r3;
    L_0x015d:
        r2 = r2.getConnectionManager();
        r2.shutdown();
        goto L_0x011c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.httpPatchImpl(java.lang.String, java.util.ArrayList, com.mob.tools.network.KVPair, long, java.util.ArrayList, com.mob.tools.network.OnReadListener, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    private String kvPairsToUrl(ArrayList<KVPair<String>> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            KVPair kVPair = (KVPair) it.next();
            String urlEncode = Data.urlEncode(kVPair.name, "utf-8");
            String urlEncode2 = kVPair.value != null ? Data.urlEncode((String) kVPair.value, "utf-8") : BuildConfig.FLAVOR;
            if (stringBuilder.length() > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(urlEncode).append('=').append(urlEncode2);
        }
        return stringBuilder.toString();
    }

    public String downloadCache(Context context, String str, String str2, boolean z, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m4381i("downloading: " + str, new Object[0]);
        if (z) {
            File file = new File(C4021R.getCachePath(context, str2), Data.MD5(str));
            if (z && file.exists()) {
                MobLog.getInstance().m4381i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                return file.getAbsolutePath();
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.connect();
        int responseCode = connection.getResponseCode();
        String str3;
        if (responseCode == Constants.COMMAND_HANDSHAKE) {
            List list;
            String MD5;
            int lastIndexOf;
            StringBuilder append;
            File file2;
            InputStream inputStream;
            FileOutputStream fileOutputStream;
            byte[] bArr;
            int read;
            Map headerFields = connection.getHeaderFields();
            if (headerFields != null) {
                list = (List) headerFields.get(MIME.CONTENT_DISPOSITION);
                if (list != null && list.size() > 0) {
                    str3 = null;
                    for (String str4 : ((String) list.get(0)).split(";")) {
                        if (str4.trim().startsWith("filename")) {
                            str3 = str4.split("=")[1];
                            if (str3.startsWith("\"") && str3.endsWith("\"")) {
                                str3 = str3.substring(1, str3.length() - 1);
                            }
                        }
                    }
                    if (str3 == null) {
                        MD5 = Data.MD5(str);
                        if (headerFields != null) {
                            list = (List) headerFields.get(MIME.CONTENT_TYPE);
                            if (list != null && list.size() > 0) {
                                str3 = (String) list.get(0);
                                str3 = str3 != null ? BuildConfig.FLAVOR : str3.trim();
                                if (str3.startsWith("image/")) {
                                    lastIndexOf = str.lastIndexOf(47);
                                    str3 = null;
                                    if (lastIndexOf > 0) {
                                        str3 = str.substring(lastIndexOf + 1);
                                    }
                                    if (str3 != null && str3.length() > 0) {
                                        lastIndexOf = str3.lastIndexOf(46);
                                        if (lastIndexOf > 0 && str3.length() - lastIndexOf < 10) {
                                            str3 = MD5 + str3.substring(lastIndexOf);
                                        }
                                    }
                                } else {
                                    str3 = str3.substring("image/".length());
                                    append = new StringBuilder().append(MD5).append(".");
                                    if ("jpeg".equals(str3)) {
                                        str3 = "jpg";
                                    }
                                    str3 = append.append(str3).toString();
                                }
                            }
                        }
                        str3 = MD5;
                    }
                    file2 = new File(C4021R.getCachePath(context, str2), str3);
                    if (z || !file2.exists()) {
                        if (!file2.getParentFile().exists()) {
                            file2.getParentFile().mkdirs();
                        }
                        if (file2.exists()) {
                            file2.delete();
                        }
                        inputStream = connection.getInputStream();
                        fileOutputStream = new FileOutputStream(file2);
                        bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                        for (read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        inputStream.close();
                        fileOutputStream.close();
                        connection.disconnect();
                        MobLog.getInstance().m4381i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                        return file2.getAbsolutePath();
                    }
                    connection.disconnect();
                    MobLog.getInstance().m4381i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                    return file2.getAbsolutePath();
                }
            }
            str3 = null;
            if (str3 == null) {
                MD5 = Data.MD5(str);
                if (headerFields != null) {
                    list = (List) headerFields.get(MIME.CONTENT_TYPE);
                    str3 = (String) list.get(0);
                    if (str3 != null) {
                    }
                    if (str3.startsWith("image/")) {
                        lastIndexOf = str.lastIndexOf(47);
                        str3 = null;
                        if (lastIndexOf > 0) {
                            str3 = str.substring(lastIndexOf + 1);
                        }
                        lastIndexOf = str3.lastIndexOf(46);
                        str3 = MD5 + str3.substring(lastIndexOf);
                    } else {
                        str3 = str3.substring("image/".length());
                        append = new StringBuilder().append(MD5).append(".");
                        if ("jpeg".equals(str3)) {
                            str3 = "jpg";
                        }
                        str3 = append.append(str3).toString();
                    }
                }
                str3 = MD5;
            }
            file2 = new File(C4021R.getCachePath(context, str2), str3);
            if (z) {
            }
            if (file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists()) {
                file2.delete();
            }
            try {
                inputStream = connection.getInputStream();
                fileOutputStream = new FileOutputStream(file2);
                bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                for (read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                inputStream.close();
                fileOutputStream.close();
                connection.disconnect();
                MobLog.getInstance().m4381i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                return file2.getAbsolutePath();
            } catch (Throwable th) {
                if (file2.exists()) {
                    file2.delete();
                }
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
            for (str3 = bufferedReader.readLine(); str3 != null; str3 = bufferedReader.readLine()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(str3);
            }
            bufferedReader.close();
            connection.disconnect();
            HashMap hashMap = new HashMap();
            hashMap.put(C4233j.f14375B, stringBuilder.toString());
            hashMap.put(MsgConstant.KEY_STATUS, Integer.valueOf(responseCode));
            throw new Throwable(new Hashon().fromHashMap(hashMap));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getHttpPostResponse(java.lang.String r9, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r10, com.mob.tools.network.KVPair<java.lang.String> r11, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r12, com.mob.tools.network.HttpResponseCallback r13, com.mob.tools.network.NetworkHelper.NetworkTimeOut r14) {
        /*
        r8 = this;
        r7 = 0;
        r2 = java.lang.System.currentTimeMillis();
        r0 = com.mob.tools.MobLog.getInstance();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "httpPost: ";
        r1 = r1.append(r4);
        r1 = r1.append(r9);
        r1 = r1.toString();
        r4 = new java.lang.Object[r7];
        r0.m4381i(r1, r4);
        r4 = r8.getConnection(r9, r14);
        r0 = 1;
        r4.setDoOutput(r0);
        r4.setChunkedStreamingMode(r7);
        if (r11 == 0) goto L_0x006a;
    L_0x002e:
        r0 = r11.value;
        if (r0 == 0) goto L_0x006a;
    L_0x0032:
        r1 = new java.io.File;
        r0 = r11.value;
        r0 = (java.lang.String) r0;
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x006a;
    L_0x0041:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0.add(r11);
        r0 = r8.getFilePostHTTPPart(r4, r9, r10, r0);
        r1 = r0;
    L_0x004e:
        if (r12 == 0) goto L_0x0070;
    L_0x0050:
        r5 = r12.iterator();
    L_0x0054:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0070;
    L_0x005a:
        r0 = r5.next();
        r0 = (com.mob.tools.network.KVPair) r0;
        r6 = r0.name;
        r0 = r0.value;
        r0 = (java.lang.String) r0;
        r4.setRequestProperty(r6, r0);
        goto L_0x0054;
    L_0x006a:
        r0 = r8.getTextPostHTTPPart(r4, r9, r10);
        r1 = r0;
        goto L_0x004e;
    L_0x0070:
        r4.connect();
        r5 = r4.getOutputStream();
        r1 = r1.toInputStream();
        r0 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r6 = new byte[r0];
        r0 = r1.read(r6);
    L_0x0083:
        if (r0 <= 0) goto L_0x008d;
    L_0x0085:
        r5.write(r6, r7, r0);
        r0 = r1.read(r6);
        goto L_0x0083;
    L_0x008d:
        r5.flush();
        r1.close();
        r5.close();
        if (r13 == 0) goto L_0x00cd;
    L_0x0098:
        r0 = new com.mob.tools.network.HttpConnectionImpl23;	 Catch:{ Throwable -> 0x00c6 }
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00c6 }
        r13.onResponse(r0);	 Catch:{ Throwable -> 0x00c6 }
        r4.disconnect();
    L_0x00a3:
        r0 = com.mob.tools.MobLog.getInstance();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "use time: ";
        r1 = r1.append(r4);
        r4 = java.lang.System.currentTimeMillis();
        r2 = r4 - r2;
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = new java.lang.Object[r7];
        r0.m4381i(r1, r2);
        return;
    L_0x00c6:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00c8 }
    L_0x00c8:
        r0 = move-exception;
        r4.disconnect();
        throw r0;
    L_0x00cd:
        r4.disconnect();
        goto L_0x00a3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.getHttpPostResponse(java.lang.String, java.util.ArrayList, com.mob.tools.network.KVPair, java.util.ArrayList, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    public String httpGet(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        String kvPairsToUrl;
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m4381i("httpGet: " + str, new Object[0]);
        if (arrayList != null) {
            kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + "?" + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair kVPair = (KVPair) it.next();
                connection.setRequestProperty(kVPair.name, (String) kVPair.value);
            }
        }
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == Constants.COMMAND_HANDSHAKE) {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
            for (kvPairsToUrl = bufferedReader.readLine(); kvPairsToUrl != null; kvPairsToUrl = bufferedReader.readLine()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(kvPairsToUrl);
            }
            bufferedReader.close();
            connection.disconnect();
            kvPairsToUrl = stringBuilder.toString();
            MobLog.getInstance().m4381i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return kvPairsToUrl;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (kvPairsToUrl = bufferedReader2.readLine(); kvPairsToUrl != null; kvPairsToUrl = bufferedReader2.readLine()) {
            if (stringBuilder2.length() > 0) {
                stringBuilder2.append('\n');
            }
            stringBuilder2.append(kvPairsToUrl);
        }
        bufferedReader2.close();
        connection.disconnect();
        HashMap hashMap = new HashMap();
        hashMap.put(C4233j.f14375B, stringBuilder2.toString());
        hashMap.put(MsgConstant.KEY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }

    public ArrayList<KVPair<String[]>> httpHead(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m4381i("httpHead: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + "?" + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setRequestMethod(HttpRequest.f14572y);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair kVPair2 = (KVPair) it.next();
                connection.setRequestProperty(kVPair2.name, (String) kVPair2.value);
            }
        }
        connection.connect();
        Map headerFields = connection.getHeaderFields();
        ArrayList<KVPair<String[]>> arrayList3 = new ArrayList();
        if (headerFields != null) {
            for (Entry entry : headerFields.entrySet()) {
                List list = (List) entry.getValue();
                if (list == null) {
                    arrayList3.add(new KVPair((String) entry.getKey(), new String[0]));
                } else {
                    Object obj = new String[list.size()];
                    for (int i = 0; i < obj.length; i++) {
                        obj[i] = (String) list.get(i);
                    }
                    arrayList3.add(new KVPair((String) entry.getKey(), obj));
                }
            }
        }
        connection.disconnect();
        MobLog.getInstance().m4381i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        return arrayList3;
    }

    public void httpPatch(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        if (VERSION.SDK_INT >= 23) {
            httpPatchImpl23(str, arrayList, kVPair, j, arrayList2, onReadListener, httpResponseCallback, networkTimeOut);
        } else {
            httpPatchImpl(str, arrayList, kVPair, j, arrayList2, onReadListener, httpResponseCallback, networkTimeOut);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void httpPatchImpl23(java.lang.String r11, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r12, com.mob.tools.network.KVPair<java.lang.String> r13, long r14, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r16, com.mob.tools.network.OnReadListener r17, com.mob.tools.network.HttpResponseCallback r18, com.mob.tools.network.NetworkHelper.NetworkTimeOut r19) {
        /*
        r10 = this;
        r4 = java.lang.System.currentTimeMillis();
        r2 = com.mob.tools.MobLog.getInstance();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r6 = "httpPatch: ";
        r3 = r3.append(r6);
        r3 = r3.append(r11);
        r3 = r3.toString();
        r6 = 0;
        r6 = new java.lang.Object[r6];
        r2.m4381i(r3, r6);
        if (r12 == 0) goto L_0x0044;
    L_0x0023:
        r2 = r10.kvPairsToUrl(r12);
        r3 = r2.length();
        if (r3 <= 0) goto L_0x0044;
    L_0x002d:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r11);
        r6 = "?";
        r3 = r3.append(r6);
        r2 = r3.append(r2);
        r11 = r2.toString();
    L_0x0044:
        r0 = r19;
        r3 = r10.getConnection(r11, r0);
        r2 = 1;
        r3.setDoOutput(r2);
        r2 = 0;
        r3.setChunkedStreamingMode(r2);
        r2 = "PATCH";
        r3.setRequestMethod(r2);
        r2 = "Content-Type";
        r6 = "application/offset+octet-stream";
        r3.setRequestProperty(r2, r6);
        if (r16 == 0) goto L_0x007a;
    L_0x0060:
        r6 = r16.iterator();
    L_0x0064:
        r2 = r6.hasNext();
        if (r2 == 0) goto L_0x007a;
    L_0x006a:
        r2 = r6.next();
        r2 = (com.mob.tools.network.KVPair) r2;
        r7 = r2.name;
        r2 = r2.value;
        r2 = (java.lang.String) r2;
        r3.setRequestProperty(r7, r2);
        goto L_0x0064;
    L_0x007a:
        r3.connect();
        r6 = r3.getOutputStream();
        r7 = new com.mob.tools.network.FilePart;
        r7.<init>();
        r0 = r17;
        r7.setOnReadListener(r0);
        r2 = r13.value;
        r2 = (java.lang.String) r2;
        r7.setFile(r2);
        r7.setOffset(r14);
        r7 = r7.toInputStream();
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r8 = new byte[r2];
        r2 = r7.read(r8);
    L_0x00a1:
        if (r2 <= 0) goto L_0x00ac;
    L_0x00a3:
        r9 = 0;
        r6.write(r8, r9, r2);
        r2 = r7.read(r8);
        goto L_0x00a1;
    L_0x00ac:
        r6.flush();
        r7.close();
        r6.close();
        if (r18 == 0) goto L_0x00ef;
    L_0x00b7:
        r2 = new com.mob.tools.network.HttpConnectionImpl23;	 Catch:{ Throwable -> 0x00e8 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00e8 }
        r0 = r18;
        r0.onResponse(r2);	 Catch:{ Throwable -> 0x00e8 }
        r3.disconnect();
    L_0x00c4:
        r2 = com.mob.tools.MobLog.getInstance();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r6 = "use time: ";
        r3 = r3.append(r6);
        r6 = java.lang.System.currentTimeMillis();
        r4 = r6 - r4;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r4 = 0;
        r4 = new java.lang.Object[r4];
        r2.m4381i(r3, r4);
        return;
    L_0x00e8:
        r2 = move-exception;
        throw r2;	 Catch:{ all -> 0x00ea }
    L_0x00ea:
        r2 = move-exception;
        r3.disconnect();
        throw r2;
    L_0x00ef:
        r3.disconnect();
        goto L_0x00c4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.httpPatchImpl23(java.lang.String, java.util.ArrayList, com.mob.tools.network.KVPair, long, java.util.ArrayList, com.mob.tools.network.OnReadListener, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, int i, NetworkTimeOut networkTimeOut) {
        ArrayList arrayList3 = new ArrayList();
        if (!(kVPair == null || kVPair.value == null || !new File((String) kVPair.value).exists())) {
            arrayList3.add(kVPair);
        }
        return httpPostFiles(str, arrayList, arrayList3, arrayList2, i, networkTimeOut);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        return httpPost(str, (ArrayList) arrayList, (KVPair) kVPair, (ArrayList) arrayList2, 0, networkTimeOut);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void httpPost(java.lang.String r9, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r10, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r11, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r12, int r13, com.mob.tools.network.HttpResponseCallback r14, com.mob.tools.network.NetworkHelper.NetworkTimeOut r15) {
        /*
        r8 = this;
        r2 = java.lang.System.currentTimeMillis();
        r0 = com.mob.tools.MobLog.getInstance();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "httpPost: ";
        r1 = r1.append(r4);
        r1 = r1.append(r9);
        r1 = r1.toString();
        r4 = 0;
        r4 = new java.lang.Object[r4];
        r0.m4381i(r1, r4);
        r4 = r8.getConnection(r9, r15);
        r0 = 1;
        r4.setDoOutput(r0);
        if (r11 == 0) goto L_0x0057;
    L_0x002b:
        r0 = r11.size();
        if (r0 <= 0) goto L_0x0057;
    L_0x0031:
        r0 = r8.getFilePostHTTPPart(r4, r9, r10, r11);
        if (r13 < 0) goto L_0x0063;
    L_0x0037:
        r4.setChunkedStreamingMode(r13);
        r1 = r0;
    L_0x003b:
        if (r12 == 0) goto L_0x0065;
    L_0x003d:
        r5 = r12.iterator();
    L_0x0041:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0065;
    L_0x0047:
        r0 = r5.next();
        r0 = (com.mob.tools.network.KVPair) r0;
        r6 = r0.name;
        r0 = r0.value;
        r0 = (java.lang.String) r0;
        r4.setRequestProperty(r6, r0);
        goto L_0x0041;
    L_0x0057:
        r0 = r8.getTextPostHTTPPart(r4, r9, r10);
        r6 = r0.length();
        r1 = (int) r6;
        r4.setFixedLengthStreamingMode(r1);
    L_0x0063:
        r1 = r0;
        goto L_0x003b;
    L_0x0065:
        r4.connect();
        r5 = r4.getOutputStream();
        r1 = r1.toInputStream();
        r0 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r6 = new byte[r0];
        r0 = r1.read(r6);
    L_0x0078:
        if (r0 <= 0) goto L_0x0083;
    L_0x007a:
        r7 = 0;
        r5.write(r6, r7, r0);
        r0 = r1.read(r6);
        goto L_0x0078;
    L_0x0083:
        r5.flush();
        r1.close();
        r5.close();
        if (r14 == 0) goto L_0x00c4;
    L_0x008e:
        r0 = new com.mob.tools.network.HttpConnectionImpl23;	 Catch:{ Throwable -> 0x00bd }
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00bd }
        r14.onResponse(r0);	 Catch:{ Throwable -> 0x00bd }
        r4.disconnect();
    L_0x0099:
        r0 = com.mob.tools.MobLog.getInstance();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "use time: ";
        r1 = r1.append(r4);
        r4 = java.lang.System.currentTimeMillis();
        r2 = r4 - r2;
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = 0;
        r2 = new java.lang.Object[r2];
        r0.m4381i(r1, r2);
        return;
    L_0x00bd:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00bf }
    L_0x00bf:
        r0 = move-exception;
        r4.disconnect();
        throw r0;
    L_0x00c4:
        r4.disconnect();
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.httpPost(java.lang.String, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, int, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        httpPost(str, arrayList, arrayList2, arrayList3, 0, httpResponseCallback, networkTimeOut);
    }

    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i, NetworkTimeOut networkTimeOut) {
        HashMap hashMap = new HashMap();
        httpPost(str, arrayList, arrayList2, arrayList3, i, new C40171(hashMap), networkTimeOut);
        return (String) hashMap.get("resp");
    }

    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, NetworkTimeOut networkTimeOut) {
        return httpPostFiles(str, arrayList, arrayList2, arrayList3, 0, networkTimeOut);
    }

    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        String kvPairsToUrl;
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m4381i("httpPut: " + str, new Object[0]);
        if (arrayList != null) {
            kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + "?" + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestMethod(HttpRequest.f14536B);
        connection.setRequestProperty(MIME.CONTENT_TYPE, "application/octet-stream");
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair kVPair2 = (KVPair) it.next();
                connection.setRequestProperty(kVPair2.name, (String) kVPair2.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        FilePart filePart = new FilePart();
        filePart.setFile((String) kVPair.value);
        InputStream toInputStream = filePart.toInputStream();
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_CUT];
        for (int read = toInputStream.read(bArr); read > 0; read = toInputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        toInputStream.close();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        if (responseCode == Constants.COMMAND_HANDSHAKE || responseCode == Constants.COMMAND_PING) {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
            for (kvPairsToUrl = bufferedReader.readLine(); kvPairsToUrl != null; kvPairsToUrl = bufferedReader.readLine()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(kvPairsToUrl);
            }
            bufferedReader.close();
            connection.disconnect();
            kvPairsToUrl = stringBuilder.toString();
            MobLog.getInstance().m4381i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return kvPairsToUrl;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (kvPairsToUrl = bufferedReader2.readLine(); kvPairsToUrl != null; kvPairsToUrl = bufferedReader2.readLine()) {
            if (stringBuilder2.length() > 0) {
                stringBuilder2.append('\n');
            }
            stringBuilder2.append(kvPairsToUrl);
        }
        bufferedReader2.close();
        HashMap hashMap = new HashMap();
        hashMap.put(C4233j.f14375B, stringBuilder2.toString());
        hashMap.put(MsgConstant.KEY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }

    public String jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m4381i("jsonPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestProperty("content-type", HttpRequest.f14550c);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair kVPair = (KVPair) it.next();
                connection.setRequestProperty(kVPair.name, (String) kVPair.value);
            }
        }
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            HashMap hashMap = new HashMap();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                kVPair = (KVPair) it2.next();
                hashMap.put(kVPair.name, kVPair.value);
            }
            stringPart.append(new Hashon().fromHashMap(hashMap));
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream toInputStream = stringPart.toInputStream();
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_CUT];
        for (int read = toInputStream.read(bArr); read > 0; read = toInputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        toInputStream.close();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        String readLine;
        if (responseCode == Constants.COMMAND_HANDSHAKE || responseCode == Constants.COMMAND_PING) {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
            for (readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(readLine);
            }
            bufferedReader.close();
            connection.disconnect();
            readLine = stringBuilder.toString();
            MobLog.getInstance().m4381i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return readLine;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
            if (stringBuilder2.length() > 0) {
                stringBuilder2.append('\n');
            }
            stringBuilder2.append(readLine);
        }
        bufferedReader2.close();
        connection.disconnect();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(C4233j.f14375B, stringBuilder2.toString());
        hashMap2.put(MsgConstant.KEY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap2));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rawGet(java.lang.String r8, com.mob.tools.network.HttpResponseCallback r9, com.mob.tools.network.NetworkHelper.NetworkTimeOut r10) {
        /*
        r7 = this;
        r6 = 0;
        r0 = java.lang.System.currentTimeMillis();
        r2 = com.mob.tools.MobLog.getInstance();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "rawGet: ";
        r3 = r3.append(r4);
        r3 = r3.append(r8);
        r3 = r3.toString();
        r4 = new java.lang.Object[r6];
        r2.m4381i(r3, r4);
        r2 = r7.getConnection(r8, r10);
        r2.connect();
        if (r9 == 0) goto L_0x005f;
    L_0x002a:
        r3 = new com.mob.tools.network.HttpConnectionImpl23;	 Catch:{ Throwable -> 0x0058 }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x0058 }
        r9.onResponse(r3);	 Catch:{ Throwable -> 0x0058 }
        r2.disconnect();
    L_0x0035:
        r2 = com.mob.tools.MobLog.getInstance();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "use time: ";
        r3 = r3.append(r4);
        r4 = java.lang.System.currentTimeMillis();
        r0 = r4 - r0;
        r0 = r3.append(r0);
        r0 = r0.toString();
        r1 = new java.lang.Object[r6];
        r2.m4381i(r0, r1);
        return;
    L_0x0058:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x005a }
    L_0x005a:
        r0 = move-exception;
        r2.disconnect();
        throw r0;
    L_0x005f:
        r2.disconnect();
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.rawGet(java.lang.String, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    public void rawGet(String str, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        rawGet(str, null, rawNetworkCallback, networkTimeOut);
    }

    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m4381i("rawGet: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair kVPair = (KVPair) it.next();
                connection.setRequestProperty(kVPair.name, (String) kVPair.value);
            }
        }
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == Constants.COMMAND_HANDSHAKE) {
            if (rawNetworkCallback != null) {
                rawNetworkCallback.onResponse(connection.getInputStream());
            }
            connection.disconnect();
            MobLog.getInstance().m4381i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('\n');
            }
            stringBuilder.append(readLine);
        }
        bufferedReader.close();
        connection.disconnect();
        HashMap hashMap = new HashMap();
        hashMap.put(C4233j.f14375B, stringBuilder.toString());
        hashMap.put(MsgConstant.KEY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rawPost(java.lang.String r9, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r10, com.mob.tools.network.HTTPPart r11, com.mob.tools.network.HttpResponseCallback r12, com.mob.tools.network.NetworkHelper.NetworkTimeOut r13) {
        /*
        r8 = this;
        r7 = 0;
        r2 = java.lang.System.currentTimeMillis();
        r0 = com.mob.tools.MobLog.getInstance();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "rawpost: ";
        r1 = r1.append(r4);
        r1 = r1.append(r9);
        r1 = r1.toString();
        r4 = new java.lang.Object[r7];
        r0.m4381i(r1, r4);
        r1 = r8.getConnection(r9, r13);
        r0 = 1;
        r1.setDoOutput(r0);
        r1.setChunkedStreamingMode(r7);
        if (r10 == 0) goto L_0x0048;
    L_0x002e:
        r4 = r10.iterator();
    L_0x0032:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0048;
    L_0x0038:
        r0 = r4.next();
        r0 = (com.mob.tools.network.KVPair) r0;
        r5 = r0.name;
        r0 = r0.value;
        r0 = (java.lang.String) r0;
        r1.setRequestProperty(r5, r0);
        goto L_0x0032;
    L_0x0048:
        r1.connect();
        r4 = r1.getOutputStream();
        r5 = r11.toInputStream();
        r0 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r6 = new byte[r0];
        r0 = r5.read(r6);
    L_0x005b:
        if (r0 <= 0) goto L_0x0065;
    L_0x005d:
        r4.write(r6, r7, r0);
        r0 = r5.read(r6);
        goto L_0x005b;
    L_0x0065:
        r4.flush();
        r5.close();
        r4.close();
        if (r12 == 0) goto L_0x00a5;
    L_0x0070:
        r0 = new com.mob.tools.network.HttpConnectionImpl23;	 Catch:{ Throwable -> 0x009e }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x009e }
        r12.onResponse(r0);	 Catch:{ Throwable -> 0x009e }
        r1.disconnect();
    L_0x007b:
        r0 = com.mob.tools.MobLog.getInstance();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "use time: ";
        r1 = r1.append(r4);
        r4 = java.lang.System.currentTimeMillis();
        r2 = r4 - r2;
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = new java.lang.Object[r7];
        r0.m4381i(r1, r2);
        return;
    L_0x009e:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00a0 }
    L_0x00a0:
        r0 = move-exception;
        r1.disconnect();
        throw r0;
    L_0x00a5:
        r1.disconnect();
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.rawPost(java.lang.String, java.util.ArrayList, com.mob.tools.network.HTTPPart, com.mob.tools.network.HttpResponseCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void rawPost(java.lang.String r9, java.util.ArrayList<com.mob.tools.network.KVPair<java.lang.String>> r10, com.mob.tools.network.HTTPPart r11, com.mob.tools.network.RawNetworkCallback r12, com.mob.tools.network.NetworkHelper.NetworkTimeOut r13) {
        /*
        r8 = this;
        r7 = 0;
        r2 = java.lang.System.currentTimeMillis();
        r0 = com.mob.tools.MobLog.getInstance();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "rawpost: ";
        r1 = r1.append(r4);
        r1 = r1.append(r9);
        r1 = r1.toString();
        r4 = new java.lang.Object[r7];
        r0.m4381i(r1, r4);
        r1 = r8.getConnection(r9, r13);
        r0 = 1;
        r1.setDoOutput(r0);
        r1.setChunkedStreamingMode(r7);
        if (r10 == 0) goto L_0x0048;
    L_0x002e:
        r4 = r10.iterator();
    L_0x0032:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0048;
    L_0x0038:
        r0 = r4.next();
        r0 = (com.mob.tools.network.KVPair) r0;
        r5 = r0.name;
        r0 = r0.value;
        r0 = (java.lang.String) r0;
        r1.setRequestProperty(r5, r0);
        goto L_0x0032;
    L_0x0048:
        r1.connect();
        r4 = r1.getOutputStream();
        r5 = r11.toInputStream();
        r0 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r6 = new byte[r0];
        r0 = r5.read(r6);
    L_0x005b:
        if (r0 <= 0) goto L_0x0065;
    L_0x005d:
        r4.write(r6, r7, r0);
        r0 = r5.read(r6);
        goto L_0x005b;
    L_0x0065:
        r4.flush();
        r5.close();
        r4.close();
        r4 = r1.getResponseCode();
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r4 != r0) goto L_0x00ba;
    L_0x0076:
        if (r12 == 0) goto L_0x00b6;
    L_0x0078:
        r4 = r1.getInputStream();
        r12.onResponse(r4);	 Catch:{ Throwable -> 0x00aa }
        if (r4 == 0) goto L_0x0084;
    L_0x0081:
        r4.close();	 Catch:{ Throwable -> 0x0118 }
    L_0x0084:
        r1.disconnect();
    L_0x0087:
        r0 = com.mob.tools.MobLog.getInstance();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "use time: ";
        r1 = r1.append(r4);
        r4 = java.lang.System.currentTimeMillis();
        r2 = r4 - r2;
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = new java.lang.Object[r7];
        r0.m4381i(r1, r2);
        return;
    L_0x00aa:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00ac }
    L_0x00ac:
        r0 = move-exception;
        if (r4 == 0) goto L_0x00b2;
    L_0x00af:
        r4.close();	 Catch:{ Throwable -> 0x011b }
    L_0x00b2:
        r1.disconnect();
        throw r0;
    L_0x00b6:
        r1.disconnect();
        goto L_0x0087;
    L_0x00ba:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = new java.io.InputStreamReader;
        r3 = r1.getErrorStream();
        r5 = "utf-8";
        r5 = java.nio.charset.Charset.forName(r5);
        r0.<init>(r3, r5);
        r3 = new java.io.BufferedReader;
        r3.<init>(r0);
        r0 = r3.readLine();
    L_0x00d7:
        if (r0 == 0) goto L_0x00ec;
    L_0x00d9:
        r5 = r2.length();
        if (r5 <= 0) goto L_0x00e4;
    L_0x00df:
        r5 = 10;
        r2.append(r5);
    L_0x00e4:
        r2.append(r0);
        r0 = r3.readLine();
        goto L_0x00d7;
    L_0x00ec:
        r3.close();
        r1.disconnect();
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "error";
        r2 = r2.toString();
        r0.put(r1, r2);
        r1 = "status";
        r2 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r2);
        r1 = new java.lang.Throwable;
        r2 = new com.mob.tools.utils.Hashon;
        r2.<init>();
        r0 = r2.fromHashMap(r0);
        r1.<init>(r0);
        throw r1;
    L_0x0118:
        r0 = move-exception;
        goto L_0x0084;
    L_0x011b:
        r2 = move-exception;
        goto L_0x00b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.rawPost(java.lang.String, java.util.ArrayList, com.mob.tools.network.HTTPPart, com.mob.tools.network.RawNetworkCallback, com.mob.tools.network.NetworkHelper$NetworkTimeOut):void");
    }
}
