package com.google.android.gms.p146b;

import anet.channel.util.HttpConstant;
import com.mob.tools.network.HttpPatch;
import com.umeng.message.util.HttpRequest;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import org.android.spdy.TnetStatusCode;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.mime.MIME;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* renamed from: com.google.android.gms.b.kx */
public class kx implements kw {
    private final C3347a f11695a;
    private final SSLSocketFactory f11696b;

    /* renamed from: com.google.android.gms.b.kx.a */
    public interface C3347a {
        String m13773a(String str);
    }

    public kx() {
        this(null);
    }

    public kx(C3347a c3347a) {
        this(c3347a, null);
    }

    public kx(C3347a c3347a, SSLSocketFactory sSLSocketFactory) {
        this.f11695a = c3347a;
        this.f11696b = sSLSocketFactory;
    }

    private HttpURLConnection m13774a(URL url, it<?> itVar) {
        HttpURLConnection a = m13778a(url);
        int r = itVar.m12006r();
        a.setConnectTimeout(r);
        a.setReadTimeout(r);
        a.setUseCaches(false);
        a.setDoInput(true);
        if (HttpConstant.HTTPS.equals(url.getProtocol()) && this.f11696b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f11696b);
        }
        return a;
    }

    private static HttpEntity m13775a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void m13776a(HttpURLConnection httpURLConnection, it<?> itVar) {
        switch (itVar.m11987b()) {
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                byte[] k = itVar.m11999k();
                if (k != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
                    httpURLConnection.addRequestProperty(MIME.CONTENT_TYPE, itVar.m11998j());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(k);
                    dataOutputStream.close();
                }
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
                kx.m13777b(httpURLConnection, itVar);
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                httpURLConnection.setRequestMethod(HttpRequest.f14536B);
                kx.m13777b(httpURLConnection, itVar);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                httpURLConnection.setRequestMethod(HttpRequest.f14570w);
            case SpdyProtocol.QUIC /*4*/:
                httpURLConnection.setRequestMethod(HttpRequest.f14572y);
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                httpURLConnection.setRequestMethod(HttpRequest.f14573z);
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                httpURLConnection.setRequestMethod(HttpRequest.f14537C);
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                httpURLConnection.setRequestMethod(HttpPatch.METHOD_NAME);
                kx.m13777b(httpURLConnection, itVar);
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void m13777b(HttpURLConnection httpURLConnection, it<?> itVar) {
        byte[] o = itVar.m12003o();
        if (o != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(MIME.CONTENT_TYPE, itVar.m12002n());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(o);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection m13778a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse m13779a(it<?> itVar, Map<String, String> map) {
        String a;
        String d = itVar.m11992d();
        HashMap hashMap = new HashMap();
        hashMap.putAll(itVar.m11985a());
        hashMap.putAll(map);
        if (this.f11695a != null) {
            a = this.f11695a.m13773a(d);
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + d);
            }
        }
        a = d;
        HttpURLConnection a2 = m13774a(new URL(a), (it) itVar);
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        kx.m13776a(a2, (it) itVar);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(kx.m13775a(a2));
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
