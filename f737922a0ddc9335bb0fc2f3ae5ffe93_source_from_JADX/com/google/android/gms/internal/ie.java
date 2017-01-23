package com.google.android.gms.internal;

import com.aide.uidesigner.ProxyTextView;
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
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class ie implements id {
    private final SSLSocketFactory DW;
    private final a j6;

    public interface a {
        String j6(String str);
    }

    public ie() {
        this(null);
    }

    public ie(a aVar) {
        this(aVar, null);
    }

    public ie(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.j6 = aVar;
        this.DW = sSLSocketFactory;
    }

    private static void DW(HttpURLConnection httpURLConnection, es<?> esVar) {
        byte[] Ws = esVar.Ws();
        if (Ws != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", esVar.J8());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(Ws);
            dataOutputStream.close();
        }
    }

    private HttpURLConnection j6(URL url, es<?> esVar) {
        HttpURLConnection j6 = j6(url);
        int aM = esVar.aM();
        j6.setConnectTimeout(aM);
        j6.setReadTimeout(aM);
        j6.setUseCaches(false);
        j6.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.DW != null) {
            ((HttpsURLConnection) j6).setSSLSocketFactory(this.DW);
        }
        return j6;
    }

    private static HttpEntity j6(HttpURLConnection httpURLConnection) {
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

    static void j6(HttpURLConnection httpURLConnection, es<?> esVar) {
        switch (esVar.j6()) {
            case -1:
                byte[] EQ = esVar.EQ();
                if (EQ != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", esVar.tp());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(EQ);
                    dataOutputStream.close();
                }
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                httpURLConnection.setRequestMethod("GET");
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                httpURLConnection.setRequestMethod("POST");
                DW(httpURLConnection, esVar);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                httpURLConnection.setRequestMethod("PUT");
                DW(httpURLConnection, esVar);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                httpURLConnection.setRequestMethod("DELETE");
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                httpURLConnection.setRequestMethod("HEAD");
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                DW(httpURLConnection, esVar);
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    protected HttpURLConnection j6(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse j6(es<?> esVar, Map<String, String> map) {
        String j6;
        String FH = esVar.FH();
        HashMap hashMap = new HashMap();
        hashMap.putAll(esVar.VH());
        hashMap.putAll(map);
        if (this.j6 != null) {
            j6 = this.j6.j6(FH);
            if (j6 == null) {
                String str = "URL blocked by rewriter: ";
                j6 = String.valueOf(FH);
                throw new IOException(j6.length() != 0 ? str.concat(j6) : new String(str));
            }
        }
        j6 = FH;
        HttpURLConnection j62 = j6(new URL(j6), (es) esVar);
        for (String j63 : hashMap.keySet()) {
            j62.addRequestProperty(j63, (String) hashMap.get(j63));
        }
        j6(j62, (es) esVar);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (j62.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, j62.getResponseCode(), j62.getResponseMessage()));
        basicHttpResponse.setEntity(j6(j62));
        for (Entry entry : j62.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
