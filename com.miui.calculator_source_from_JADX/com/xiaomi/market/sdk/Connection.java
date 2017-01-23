package com.xiaomi.market.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.TreeMap;
import org.json.JSONObject;

public class Connection {
    protected JSONObject f4560a;
    protected URL f4561b;
    protected Parameter f4562c;
    protected boolean f4563d;
    protected boolean f4564e;
    protected boolean f4565f;
    protected boolean f4566g;
    protected boolean f4567h;
    protected boolean f4568i;

    protected class ConnectionException extends Exception {
        protected NetworkError f4544a;
    }

    protected abstract class ResetableOutputStream extends OutputStream {
        protected OutputStream f4545b;
        final /* synthetic */ Connection f4546c;

        public abstract void m6152a();

        public ResetableOutputStream(Connection connection, OutputStream outputStream) {
            this.f4546c = connection;
            if (outputStream == null) {
                throw new IllegalArgumentException("outputstream is null");
            }
            this.f4545b = outputStream;
        }

        public void close() {
            this.f4545b.close();
        }

        public void flush() {
            this.f4545b.flush();
        }

        public void write(byte[] bArr) {
            this.f4545b.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.f4545b.write(bArr, i, i2);
        }

        public void write(int i) {
            this.f4545b.write(i);
        }
    }

    protected class FileResetableOutputStream extends ResetableOutputStream {
        private File f4547a;

        public void m6153a() {
            try {
                this.b.close();
            } catch (IOException e) {
            }
            this.f4547a.delete();
            try {
                this.b = new FileOutputStream(this.f4547a);
            } catch (FileNotFoundException e2) {
            }
        }
    }

    protected class MemoryResetableOutputStream extends ResetableOutputStream {
        final /* synthetic */ Connection f4548a;

        public MemoryResetableOutputStream(Connection connection, ByteArrayOutputStream byteArrayOutputStream) {
            this.f4548a = connection;
            super(connection, byteArrayOutputStream);
        }

        public void m6154a() {
            ((ByteArrayOutputStream) this.b).reset();
        }
    }

    public enum NetworkError {
        OK,
        URL_ERROR,
        NETWORK_ERROR,
        AUTH_ERROR,
        CLIENT_ERROR,
        SERVER_ERROR,
        RESULT_ERROR,
        UNKNOWN_ERROR
    }

    public class Parameter {
        final /* synthetic */ Connection f4558a;
        private TreeMap<String, String> f4559b;

        public Parameter(Connection connection) {
            this(connection, true);
        }

        public Parameter(Connection connection, boolean z) {
            this.f4558a = connection;
            this.f4559b = new TreeMap();
            if (z) {
                connection.f4562c = this;
            }
        }

        public Parameter m6155a(String str, String str2) {
            if (str2 == null) {
                str2 = "";
            }
            this.f4559b.put(str, str2);
            return this;
        }

        public boolean m6156a() {
            return this.f4559b.isEmpty();
        }

        public String toString() {
            if (this.f4559b.isEmpty()) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String str : this.f4559b.keySet()) {
                stringBuilder.append(str);
                stringBuilder.append("=");
                try {
                    stringBuilder.append(URLEncoder.encode((String) this.f4559b.get(str), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                }
                stringBuilder.append("&");
            }
            return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
        }
    }

    public Connection(String str) {
        this(str, false);
    }

    public Connection(String str, boolean z) {
        URL url;
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            Log.e("MarketConnection", "URL error: " + e);
            url = null;
        }
        m6160b(url);
        this.f4568i = z;
    }

    public static String m6159a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.charAt(str.length() - 1) == '/') {
            str = str.substring(0, str.length() - 1);
        }
        if (str2.charAt(0) == '/') {
            str2 = str2.substring(1);
        }
        return str + "/" + str2;
    }

    private void m6160b(URL url) {
        this.f4563d = true;
        this.f4564e = false;
        this.f4565f = true;
        this.f4566g = true;
        this.f4567h = true;
        if (m6166a(url)) {
            this.f4561b = url;
        }
    }

    public JSONObject m6165a() {
        return this.f4560a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xiaomi.market.sdk.Connection.NetworkError m6167b() {
        /*
        r5 = this;
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r0 = new com.xiaomi.market.sdk.Connection$MemoryResetableOutputStream;
        r0.<init>(r5, r1);
        r0 = r5.m6161a(r0);
        r2 = com.xiaomi.market.sdk.Connection.NetworkError.OK;	 Catch:{ JSONException -> 0x003a }
        if (r0 != r2) goto L_0x0021;
    L_0x0012:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x003a }
        r3 = r1.toString();	 Catch:{ JSONException -> 0x003a }
        r2.<init>(r3);	 Catch:{ JSONException -> 0x003a }
        r5.f4560a = r2;	 Catch:{ JSONException -> 0x003a }
    L_0x001d:
        r1.close();	 Catch:{ IOException -> 0x0060 }
    L_0x0020:
        return r0;
    L_0x0021:
        r2 = "MarketConnection";
        r3 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x003a }
        r3.<init>();	 Catch:{ JSONException -> 0x003a }
        r4 = "Connection failed : ";
        r3 = r3.append(r4);	 Catch:{ JSONException -> 0x003a }
        r3 = r3.append(r0);	 Catch:{ JSONException -> 0x003a }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x003a }
        android.util.Log.e(r2, r3);	 Catch:{ JSONException -> 0x003a }
        goto L_0x001d;
    L_0x003a:
        r0 = move-exception;
        r2 = "MarketConnection";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005b }
        r3.<init>();	 Catch:{ all -> 0x005b }
        r4 = "JSON error: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005b }
        r0 = r3.append(r0);	 Catch:{ all -> 0x005b }
        r0 = r0.toString();	 Catch:{ all -> 0x005b }
        android.util.Log.e(r2, r0);	 Catch:{ all -> 0x005b }
        r0 = com.xiaomi.market.sdk.Connection.NetworkError.RESULT_ERROR;	 Catch:{ all -> 0x005b }
        r1.close();	 Catch:{ IOException -> 0x0059 }
        goto L_0x0020;
    L_0x0059:
        r1 = move-exception;
        goto L_0x0020;
    L_0x005b:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0062 }
    L_0x005f:
        throw r0;
    L_0x0060:
        r1 = move-exception;
        goto L_0x0020;
    L_0x0062:
        r1 = move-exception;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.market.sdk.Connection.b():com.xiaomi.market.sdk.Connection$NetworkError");
    }

    protected NetworkError m6161a(ResetableOutputStream resetableOutputStream) {
        if (this.f4561b == null) {
            return NetworkError.URL_ERROR;
        }
        if (!Utils.m6203b(XiaomiUpdateAgent.m6213a())) {
            return NetworkError.NETWORK_ERROR;
        }
        if (this.f4562c == null) {
            this.f4562c = new Parameter(this);
        }
        Parameter parameter = this.f4562c;
        try {
            String url;
            Parameter a = m6162a(this.f4562c);
            String url2 = this.f4561b.toString();
            if (this.f4564e && !a.m6156a()) {
                CharSequence query = this.f4561b.getQuery();
                url = this.f4561b.toString();
                url2 = TextUtils.isEmpty(query) ? url + "?" + a.toString() : url + "&" + a.toString();
            }
            try {
                url = m6163a(url2, a);
                if (Utils.f4609a) {
                    Log.d("MarketConnection", "connection url: " + url);
                }
                String str = "";
                if (!this.f4564e) {
                    str = a.toString();
                }
                long currentTimeMillis = System.currentTimeMillis();
                NetworkError a2 = m6158a(url, str, this.f4564e, false, resetableOutputStream);
                if (!Utils.f4609a) {
                    return a2;
                }
                Log.d("MarketConnection", "Time(ms) spent in request: " + (System.currentTimeMillis() - currentTimeMillis) + ", " + url);
                return a2;
            } catch (ConnectionException e) {
                return e.f4544a;
            }
        } catch (ConnectionException e2) {
            return e2.f4544a;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.xiaomi.market.sdk.Connection.NetworkError m6158a(java.lang.String r11, java.lang.String r12, boolean r13, boolean r14, com.xiaomi.market.sdk.Connection.ResetableOutputStream r15) {
        /*
        r10 = this;
        r2 = 0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0.add(r11);
        r4 = r0.iterator();
    L_0x000d:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0183;
    L_0x0013:
        r0 = r4.next();
        r0 = (java.lang.String) r0;
        r1 = com.xiaomi.market.sdk.Utils.f4609a;
        if (r1 == 0) goto L_0x0035;
    L_0x001d:
        r1 = "MarketConnection";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "hosted connection url: ";
        r3 = r3.append(r5);
        r3 = r3.append(r0);
        r3 = r3.toString();
        android.util.Log.d(r1, r3);
    L_0x0035:
        r5 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00f9 }
        r5.<init>(r0);	 Catch:{ MalformedURLException -> 0x00f9 }
        r0 = r5.openConnection();	 Catch:{ Exception -> 0x018e, all -> 0x0186 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x018e, all -> 0x0186 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
        r1 = com.xiaomi.market.sdk.XiaomiUpdateAgent.m6213a();	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
        r1 = com.xiaomi.market.sdk.Utils.m6204c(r1);	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
        if (r1 == 0) goto L_0x0114;
    L_0x004f:
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
    L_0x0054:
        if (r13 == 0) goto L_0x014c;
    L_0x0056:
        r1 = "GET";
        r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
        r1 = 0;
        r0.setDoOutput(r1);	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
    L_0x005f:
        r3 = r10.m6164a(r0);	 Catch:{ ConnectionException -> 0x0160 }
        r3.connect();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        if (r13 != 0) goto L_0x0098;
    L_0x0068:
        r0 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        if (r0 != 0) goto L_0x0098;
    L_0x006e:
        r0 = r3.getOutputStream();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        r1 = r12.getBytes();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        r0.write(r1);	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        r1 = com.xiaomi.market.sdk.Utils.f4609a;	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        if (r1 == 0) goto L_0x0095;
    L_0x007d:
        r1 = "MarketConnection";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        r6.<init>();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        r7 = "[post]";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        r6 = r6.append(r12);	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        android.util.Log.d(r1, r6);	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
    L_0x0095:
        r0.close();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
    L_0x0098:
        r0 = r3.getResponseCode();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        r0 = r10.m6157a(r0);	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        r1 = com.xiaomi.market.sdk.Connection.NetworkError.OK;	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
        if (r0 != r1) goto L_0x0172;
    L_0x00a4:
        if (r15 == 0) goto L_0x0172;
    L_0x00a6:
        r1 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0193, all -> 0x0178 }
        r6 = r3.getInputStream();	 Catch:{ Exception -> 0x0193, all -> 0x0178 }
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r1.<init>(r6, r7);	 Catch:{ Exception -> 0x0193, all -> 0x0178 }
        r6 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r6 = new byte[r6];	 Catch:{ Exception -> 0x00c3 }
    L_0x00b5:
        r7 = 0;
        r8 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r7 = r1.read(r6, r7, r8);	 Catch:{ Exception -> 0x00c3 }
        if (r7 <= 0) goto L_0x016a;
    L_0x00be:
        r8 = 0;
        r15.write(r6, r8, r7);	 Catch:{ Exception -> 0x00c3 }
        goto L_0x00b5;
    L_0x00c3:
        r0 = move-exception;
    L_0x00c4:
        r6 = "MarketConnection";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0191 }
        r7.<init>();	 Catch:{ all -> 0x0191 }
        r8 = "Connection Exception for ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0191 }
        r8 = r5.getHost();	 Catch:{ all -> 0x0191 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x0191 }
        r8 = " : read file stream error ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0191 }
        r0 = r7.append(r0);	 Catch:{ all -> 0x0191 }
        r0 = r0.toString();	 Catch:{ all -> 0x0191 }
        android.util.Log.e(r6, r0);	 Catch:{ all -> 0x0191 }
        r15.m6152a();	 Catch:{ all -> 0x0191 }
        if (r1 == 0) goto L_0x00f2;
    L_0x00ef:
        r1.close();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
    L_0x00f2:
        if (r3 == 0) goto L_0x000d;
    L_0x00f4:
        r3.disconnect();
        goto L_0x000d;
    L_0x00f9:
        r0 = move-exception;
        r1 = "MarketConnection";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = " URL error :";
        r3 = r3.append(r5);
        r0 = r3.append(r0);
        r0 = r0.toString();
        android.util.Log.e(r1, r0);
        goto L_0x000d;
    L_0x0114:
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
        goto L_0x0054;
    L_0x011b:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x011f:
        r3 = "MarketConnection";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x018b }
        r6.<init>();	 Catch:{ all -> 0x018b }
        r7 = "Connection Exception for ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x018b }
        r5 = r5.getHost();	 Catch:{ all -> 0x018b }
        r5 = r6.append(r5);	 Catch:{ all -> 0x018b }
        r6 = " :";
        r5 = r5.append(r6);	 Catch:{ all -> 0x018b }
        r0 = r5.append(r0);	 Catch:{ all -> 0x018b }
        r0 = r0.toString();	 Catch:{ all -> 0x018b }
        android.util.Log.e(r3, r0);	 Catch:{ all -> 0x018b }
        if (r1 == 0) goto L_0x000d;
    L_0x0147:
        r1.disconnect();
        goto L_0x000d;
    L_0x014c:
        r1 = "POST";
        r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
        r1 = 1;
        r0.setDoOutput(r1);	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
        goto L_0x005f;
    L_0x0157:
        r1 = move-exception;
        r3 = r0;
        r0 = r1;
    L_0x015a:
        if (r3 == 0) goto L_0x015f;
    L_0x015c:
        r3.disconnect();
    L_0x015f:
        throw r0;
    L_0x0160:
        r1 = move-exception;
        r1 = r1.f4544a;	 Catch:{ Exception -> 0x011b, all -> 0x0157 }
        if (r0 == 0) goto L_0x0168;
    L_0x0165:
        r0.disconnect();
    L_0x0168:
        r0 = r1;
    L_0x0169:
        return r0;
    L_0x016a:
        r15.flush();	 Catch:{ Exception -> 0x00c3 }
        if (r1 == 0) goto L_0x0172;
    L_0x016f:
        r1.close();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
    L_0x0172:
        if (r3 == 0) goto L_0x0169;
    L_0x0174:
        r3.disconnect();
        goto L_0x0169;
    L_0x0178:
        r0 = move-exception;
        r1 = r2;
    L_0x017a:
        if (r1 == 0) goto L_0x017f;
    L_0x017c:
        r1.close();	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
    L_0x017f:
        throw r0;	 Catch:{ Exception -> 0x0180, all -> 0x0189 }
    L_0x0180:
        r0 = move-exception;
        r1 = r3;
        goto L_0x011f;
    L_0x0183:
        r0 = com.xiaomi.market.sdk.Connection.NetworkError.NETWORK_ERROR;
        goto L_0x0169;
    L_0x0186:
        r0 = move-exception;
        r3 = r2;
        goto L_0x015a;
    L_0x0189:
        r0 = move-exception;
        goto L_0x015a;
    L_0x018b:
        r0 = move-exception;
        r3 = r1;
        goto L_0x015a;
    L_0x018e:
        r0 = move-exception;
        r1 = r2;
        goto L_0x011f;
    L_0x0191:
        r0 = move-exception;
        goto L_0x017a;
    L_0x0193:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00c4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.market.sdk.Connection.a(java.lang.String, java.lang.String, boolean, boolean, com.xiaomi.market.sdk.Connection$ResetableOutputStream):com.xiaomi.market.sdk.Connection$NetworkError");
    }

    protected Parameter m6162a(Parameter parameter) {
        return parameter;
    }

    protected String m6163a(String str, Parameter parameter) {
        return str;
    }

    protected HttpURLConnection m6164a(HttpURLConnection httpURLConnection) {
        return httpURLConnection;
    }

    protected boolean m6166a(URL url) {
        if (url != null && TextUtils.equals(url.getProtocol(), "http")) {
            return true;
        }
        return false;
    }

    private NetworkError m6157a(int i) {
        if (i == 200) {
            return NetworkError.OK;
        }
        Log.e("MarketConnection", "Network Error : " + i);
        return NetworkError.SERVER_ERROR;
    }
}
