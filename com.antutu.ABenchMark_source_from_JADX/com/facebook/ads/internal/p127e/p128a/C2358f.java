package com.facebook.ads.internal.p127e.p128a;

import com.umeng.message.util.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyProtocol;
import org.apache.http.entity.mime.MIME;

/* renamed from: com.facebook.ads.internal.e.a.f */
public abstract class C2358f implements C2357p {
    private final C2365q f8241a;

    public C2358f() {
        this(new C2366g());
    }

    public C2358f(C2365q c2365q) {
        this.f8241a = c2365q;
    }

    public OutputStream m9081a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getOutputStream();
    }

    public HttpURLConnection m9082a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    public void m9083a(OutputStream outputStream, byte[] bArr) {
        outputStream.write(bArr);
    }

    public void m9084a(HttpURLConnection httpURLConnection, C2370j c2370j, String str) {
        httpURLConnection.setRequestMethod(c2370j.m9132c());
        httpURLConnection.setDoOutput(c2370j.m9131b());
        httpURLConnection.setDoInput(c2370j.m9130a());
        if (str != null) {
            httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, str);
        }
        httpURLConnection.setRequestProperty(HttpRequest.f14553f, HttpRequest.f14548a);
    }

    public boolean m9085a(C2372m c2372m) {
        C2373n a = c2372m.m9133a();
        if (this.f8241a.m9117a()) {
            this.f8241a.m9115a("BasicRequestHandler.onError got");
            c2372m.printStackTrace();
        }
        return a != null && a.m9134a() > 0;
    }

    public byte[] m9086a(InputStream inputStream) {
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_L7E];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public InputStream m9087b(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getInputStream();
    }
}
