package com.antutu.redacc.p067f;

import android.os.Message;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.common.Constants;
import com.tools.utility.JNILIB;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;

/* renamed from: com.antutu.redacc.f.g */
public class C1751g extends C1750o {
    private HashMap<String, Object> f6181a;
    private String f6182b;
    private C1715j f6183c;
    private String f6184d;
    private boolean f6185e;
    private int f6186f;

    public C1751g(HashMap<String, Object> hashMap, String str, C1715j c1715j) {
        this.f6184d = SpdyRequest.GET_METHOD;
        this.f6185e = true;
        this.f6186f = 1;
        this.f6181a = hashMap;
        this.f6182b = str;
        this.f6183c = c1715j;
    }

    public static final String m6750a(InputStream inputStream, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 1) {
                return new String(byteArrayOutputStream.toByteArray(), HttpRequest.f14548a);
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private String m6751d() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f6182b).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestMethod(this.f6184d);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            String a = responseCode == Constants.COMMAND_HANDSHAKE ? C1751g.m6750a(inputStream, false) : null;
            if (inputStream == null) {
                return a;
            }
            try {
                inputStream.close();
                return a;
            } catch (Exception e) {
                return a;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private String m6752e() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Entry entry : this.f6181a.entrySet()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
                if (SpdyRequest.GET_METHOD.equalsIgnoreCase(this.f6184d)) {
                    stringBuilder.append("&");
                }
            } else {
                stringBuilder.append("&");
                obj2 = obj;
            }
            stringBuilder.append(URLEncoder.encode((String) entry.getKey(), HttpRequest.f14548a));
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode(String.valueOf(entry.getValue()), HttpRequest.f14548a));
            obj = obj2;
        }
        String stringBuilder2 = stringBuilder.toString();
        return (!this.f6185e || stringBuilder2.length() <= 0) ? stringBuilder2 : this.f6186f == 1 ? "&gpv=" + JNILIB.getData(stringBuilder2, BuildConfig.FLAVOR) : this.f6186f == 2 ? "?gpv=" + JNILIB.getData(stringBuilder2, BuildConfig.FLAVOR) : stringBuilder2;
    }

    Object m6753a() {
        try {
            return m6751d();
        } catch (IOException e) {
            return null;
        }
    }

    void m6754a(Message message) {
        if (message != null) {
            this.f6183c.m6660a(message.what, (String) message.obj);
        }
    }

    void m6755b() {
        try {
            this.f6182b += m6752e();
        } catch (UnsupportedEncodingException e) {
        }
    }

    public void m6756c() {
        C1759p.m6765a().m6766a(this);
    }
}
