package com.google.android.gms.internal;

import com.aide.uidesigner.ProxyTextView;
import java.net.URI;
import java.util.Map;
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
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ib implements id {
    protected final HttpClient j6;

    public static final class a extends HttpEntityEnclosingRequestBase {
        public a(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public ib(HttpClient httpClient) {
        this.j6 = httpClient;
    }

    static HttpUriRequest DW(es<?> esVar, Map<String, String> map) {
        HttpEntityEnclosingRequestBase httpPost;
        switch (esVar.j6()) {
            case -1:
                byte[] EQ = esVar.EQ();
                if (EQ == null) {
                    return new HttpGet(esVar.FH());
                }
                HttpUriRequest httpPost2 = new HttpPost(esVar.FH());
                httpPost2.addHeader("Content-Type", esVar.tp());
                httpPost2.setEntity(new ByteArrayEntity(EQ));
                return httpPost2;
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return new HttpGet(esVar.FH());
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                httpPost = new HttpPost(esVar.FH());
                httpPost.addHeader("Content-Type", esVar.J8());
                j6(httpPost, (es) esVar);
                return httpPost;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                httpPost = new HttpPut(esVar.FH());
                httpPost.addHeader("Content-Type", esVar.J8());
                j6(httpPost, (es) esVar);
                return httpPost;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return new HttpDelete(esVar.FH());
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return new HttpHead(esVar.FH());
            case 5:
                return new HttpOptions(esVar.FH());
            case 6:
                return new HttpTrace(esVar.FH());
            case 7:
                httpPost = new a(esVar.FH());
                httpPost.addHeader("Content-Type", esVar.J8());
                j6(httpPost, (es) esVar);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void j6(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, es<?> esVar) {
        byte[] Ws = esVar.Ws();
        if (Ws != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(Ws));
        }
    }

    private static void j6(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    public HttpResponse j6(es<?> esVar, Map<String, String> map) {
        HttpUriRequest DW = DW(esVar, map);
        j6(DW, (Map) map);
        j6(DW, esVar.VH());
        j6(DW);
        HttpParams params = DW.getParams();
        int aM = esVar.aM();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, aM);
        return this.j6.execute(DW);
    }

    protected void j6(HttpUriRequest httpUriRequest) {
    }
}
