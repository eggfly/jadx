package com.google.android.gms.p146b;

import com.mob.tools.network.HttpPatch;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.net.URI;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.mime.MIME;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* renamed from: com.google.android.gms.b.ku */
public class ku implements kw {
    protected final HttpClient f11694a;

    /* renamed from: com.google.android.gms.b.ku.a */
    public static final class C3346a extends HttpEntityEnclosingRequestBase {
        public C3346a(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return HttpPatch.METHOD_NAME;
        }
    }

    public ku(HttpClient httpClient) {
        this.f11694a = httpClient;
    }

    private static void m13764a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, it<?> itVar) {
        byte[] o = itVar.m12003o();
        if (o != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(o));
        }
    }

    private static void m13765a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    static HttpUriRequest m13766b(it<?> itVar, Map<String, String> map) {
        HttpEntityEnclosingRequestBase httpPost;
        switch (itVar.m11987b()) {
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                byte[] k = itVar.m11999k();
                if (k == null) {
                    return new HttpGet(itVar.m11992d());
                }
                HttpUriRequest httpPost2 = new HttpPost(itVar.m11992d());
                httpPost2.addHeader(MIME.CONTENT_TYPE, itVar.m11998j());
                httpPost2.setEntity(new ByteArrayEntity(k));
                return httpPost2;
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return new HttpGet(itVar.m11992d());
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                httpPost = new HttpPost(itVar.m11992d());
                httpPost.addHeader(MIME.CONTENT_TYPE, itVar.m12002n());
                ku.m13764a(httpPost, (it) itVar);
                return httpPost;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                httpPost = new HttpPut(itVar.m11992d());
                httpPost.addHeader(MIME.CONTENT_TYPE, itVar.m12002n());
                ku.m13764a(httpPost, (it) itVar);
                return httpPost;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return new HttpDelete(itVar.m11992d());
            case SpdyProtocol.QUIC /*4*/:
                return new HttpHead(itVar.m11992d());
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return new HttpOptions(itVar.m11992d());
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return new HttpTrace(itVar.m11992d());
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                httpPost = new C3346a(itVar.m11992d());
                httpPost.addHeader(MIME.CONTENT_TYPE, itVar.m12002n());
                ku.m13764a(httpPost, (it) itVar);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    public HttpResponse m13767a(it<?> itVar, Map<String, String> map) {
        HttpUriRequest b = ku.m13766b(itVar, map);
        ku.m13765a(b, (Map) map);
        ku.m13765a(b, itVar.m11985a());
        m13768a(b);
        HttpParams params = b.getParams();
        int r = itVar.m12006r();
        HttpConnectionParams.setConnectionTimeout(params, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        HttpConnectionParams.setSoTimeout(params, r);
        return this.f11694a.execute(b);
    }

    protected void m13768a(HttpUriRequest httpUriRequest) {
    }
}
