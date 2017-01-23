package com.miui.support.net.http;

import com.miui.support.util.IOUtils;
import com.miui.support.util.SoftReferenceSingleton;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class HttpSession {
    private static final SoftReferenceSingleton<HttpSession> f3448a;
    private final HttpContext f3449b;
    private final DefaultHttpClient f3450c;
    private final Map<String, String> f3451d;
    private Cache f3452e;
    private RetryStrategy f3453f;

    /* renamed from: com.miui.support.net.http.HttpSession.1 */
    final class C04081 extends SoftReferenceSingleton<HttpSession> {
        C04081() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5137a();
        }

        protected HttpSession m5137a() {
            return new HttpSession();
        }
    }

    /* renamed from: com.miui.support.net.http.HttpSession.2 */
    class C04092 implements HttpRequestInterceptor {
        final /* synthetic */ HttpSession f3442a;

        C04092(HttpSession httpSession) {
            this.f3442a = httpSession;
        }

        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (!httpRequest.containsHeader("Accept-Encoding")) {
                httpRequest.addHeader("Accept-Encoding", "gzip");
            }
            for (Entry entry : this.f3442a.f3451d.entrySet()) {
                httpRequest.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private static class CountingInputStream extends FilterInputStream {
        private ProgressListener f3443a;
        private long f3444b;
        private long f3445c;
        private long f3446d;
        private HttpEntity f3447e;

        public CountingInputStream(HttpEntity httpEntity, String str, ProgressListener progressListener) {
            super(httpEntity.getContent());
            this.f3447e = httpEntity;
            this.f3444b = httpEntity.getContentLength();
            this.f3443a = progressListener;
            this.f3445c = 0;
            this.f3446d = 0;
            if (str != null && str.length() > 0) {
                Matcher matcher = Pattern.compile("bytes\\s+(\\d+)-(\\d+)/(\\d+)").matcher(str);
                if (matcher.matches() && matcher.groupCount() == 3) {
                    this.f3445c = Long.parseLong(matcher.group(1));
                    this.f3444b = Long.parseLong(matcher.group(3));
                }
            }
        }

        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read > 0) {
                this.f3445c += (long) read;
                m5138a(read);
            }
            return read;
        }

        public int read() {
            int read = super.read();
            if (read > 0) {
                this.f3445c++;
                m5138a(1);
            }
            return read;
        }

        public void close() {
            this.f3447e.consumeContent();
            super.close();
        }

        private void m5138a(int i) {
            if (this.f3444b > 0 && this.f3443a != null) {
                long j = (this.f3445c * 10) / this.f3444b;
                if (this.f3446d != j || i > 1024) {
                    this.f3446d = j;
                    this.f3443a.m5139a(this.f3444b, this.f3445c);
                }
            }
        }
    }

    public interface ProgressListener {
        void m5139a(long j, long j2);
    }

    static {
        f3448a = new C04081();
    }

    public HttpSession() {
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, 10000);
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 20);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, "miui v5");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f3449b = new SyncBasicHttpContext(new BasicHttpContext());
        this.f3450c = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.f3449b.setAttribute("http.cookie-store", PersistentCookieStore.m5153a());
        this.f3450c.addRequestInterceptor(new C04092(this));
        this.f3451d = new HashMap();
        this.f3452e = DiskBasedCache.m5125a();
        this.f3453f = new BaseRetryStrategy();
    }

    public void m5150a(int i) {
        HttpParams params = this.f3450c.getParams();
        ConnManagerParams.setTimeout(params, (long) i);
        HttpConnectionParams.setSoTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
    }

    public HttpResponse m5149a(String str, Map<String, String> map, HttpRequestParams httpRequestParams, ProgressListener progressListener) {
        HttpUriRequest httpGet = new HttpGet(m5143a(str, httpRequestParams));
        m5148a(httpGet, (Map) map);
        return m5142a(httpGet, progressListener);
    }

    public HttpResponse m5151b(String str, Map<String, String> map, HttpRequestParams httpRequestParams, ProgressListener progressListener) {
        HttpUriRequest httpPost = new HttpPost(str);
        if (httpRequestParams != null) {
            httpPost.setEntity(httpRequestParams.m5136b());
        }
        m5148a(httpPost, (Map) map);
        return m5142a(httpPost, progressListener);
    }

    private DefaultHttpResponse m5142a(HttpUriRequest httpUriRequest, ProgressListener progressListener) {
        DefaultHttpResponse a;
        Cache.Entry a2 = m5140a(httpUriRequest);
        if (a2 == null || a2.f3407h <= System.currentTimeMillis()) {
            if (progressListener != null) {
                progressListener.m5139a(-1, -1);
            }
            if (a2 != null) {
                m5146a(httpUriRequest, a2);
            }
            m5148a(httpUriRequest, this.f3451d);
            if (!httpUriRequest.containsHeader("Accept-Encoding")) {
                httpUriRequest.addHeader("Accept-Encoding", "gzip");
            }
            RetryStrategy retryStrategy = this.f3453f;
            while (retryStrategy != null) {
                try {
                    m5150a(retryStrategy.m5088a());
                    break;
                } catch (Throwable e) {
                    if (retryStrategy == null || !retryStrategy.m5089a(e)) {
                        throw e;
                    }
                } catch (Throwable e2) {
                    if (retryStrategy == null || !retryStrategy.m5089a(e2)) {
                        throw e2;
                    }
                }
            }
            a = m5141a(httpUriRequest, a2, progressListener);
        } else {
            a = new DefaultHttpResponse(200, a2.f3408i, a2.f3400a, a2.f3401b, a2.f3403d, a2.f3404e);
            if (progressListener != null) {
                progressListener.m5139a(a2.f3401b, a2.f3401b);
            }
        }
        return a;
    }

    private DefaultHttpResponse m5141a(HttpUriRequest httpUriRequest, Cache.Entry entry, ProgressListener progressListener) {
        InputStream countingInputStream;
        Throwable th;
        InputStream inputStream = null;
        try {
            DefaultHttpResponse defaultHttpResponse;
            InputStream inputStream2;
            HttpResponse execute = this.f3450c.execute(httpUriRequest, this.f3449b);
            int statusCode = execute.getStatusLine().getStatusCode();
            HttpEntity entity = execute.getEntity();
            if (statusCode == 304 && entry != null) {
                defaultHttpResponse = new DefaultHttpResponse(200, entry.f3408i, entry.f3400a, entry.f3401b, entry.f3403d, entry.f3404e);
                inputStream2 = null;
            } else if (statusCode < 200 || statusCode > 299) {
                throw new IOException(execute.getStatusLine().getReasonPhrase());
            } else {
                long j = -1;
                String str = null;
                String str2 = null;
                Map a = m5145a(execute.getAllHeaders());
                if (entity != null) {
                    countingInputStream = new CountingInputStream(entity, (String) a.get("content-range"), progressListener);
                    try {
                        j = entity.getContentLength();
                        if (entity.getContentType() != null) {
                            str = entity.getContentType().getValue().toLowerCase();
                        }
                        if (entity.getContentEncoding() != null) {
                            str2 = entity.getContentEncoding().getValue().toLowerCase();
                        }
                        if (str2 != null && str2.contains("gzip")) {
                            inputStream = new GZIPInputStream(countingInputStream);
                            j = -1;
                            StringBuilder stringBuilder = new StringBuilder();
                            for (HeaderElement headerElement : entity.getContentEncoding().getElements()) {
                                if (!"gzip".equalsIgnoreCase(headerElement.getName())) {
                                    if (stringBuilder.length() != 0) {
                                        stringBuilder.append(", ");
                                    }
                                    stringBuilder.append(headerElement.getName());
                                }
                            }
                            str2 = stringBuilder.toString();
                            a.put("content-encoding", str2);
                            countingInputStream = inputStream;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = countingInputStream;
                        IOUtils.m5387a(inputStream);
                        throw th;
                    }
                }
                countingInputStream = null;
                try {
                    defaultHttpResponse = new DefaultHttpResponse(statusCode, a, countingInputStream, j, str, str2);
                    m5147a(httpUriRequest, defaultHttpResponse);
                    inputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = countingInputStream;
                    IOUtils.m5387a(inputStream);
                    throw th;
                }
            }
            IOUtils.m5387a(inputStream2);
            return defaultHttpResponse;
        } catch (Throwable th4) {
            th = th4;
            IOUtils.m5387a(inputStream);
            throw th;
        }
    }

    private void m5147a(HttpUriRequest httpUriRequest, DefaultHttpResponse defaultHttpResponse) {
        Cache cache = this.f3452e;
        if (cache != null && "GET".equals(httpUriRequest.getMethod()) && !httpUriRequest.containsHeader("RANGE")) {
            String uri = httpUriRequest.getURI().toString();
            Cache.Entry a = HttpHeaderParser.m5133a((HttpResponse) defaultHttpResponse);
            if (a != null && cache.m5095a(uri, a)) {
                defaultHttpResponse.m5102a(a.f3400a, a.f3401b);
            }
        }
    }

    private Cache.Entry m5140a(HttpUriRequest httpUriRequest) {
        Cache cache = this.f3452e;
        if (cache != null && "GET".equals(httpUriRequest.getMethod())) {
            return cache.m5094a(httpUriRequest.getURI().toString());
        }
        return null;
    }

    private static void m5148a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        if (map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                httpUriRequest.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private static void m5146a(HttpUriRequest httpUriRequest, Cache.Entry entry) {
        if (entry.f3402c != null) {
            httpUriRequest.addHeader("If-None-Match", entry.f3402c);
        }
        if (entry.f3405f > 0) {
            httpUriRequest.addHeader("If-Modified-Since", DateUtils.formatDate(new Date(entry.f3405f)));
        }
    }

    private static Map<String, String> m5145a(Header[] headerArr) {
        Map<String, String> hashMap = new HashMap();
        if (headerArr != null) {
            for (Header header : headerArr) {
                hashMap.put(header.getName().toLowerCase(), header.getValue());
            }
        }
        return hashMap;
    }

    private static String m5143a(String str, HttpRequestParams httpRequestParams) {
        if (httpRequestParams == null) {
            return str;
        }
        String a = httpRequestParams.m5135a();
        if (a == null || a.length() <= 0) {
            return str;
        }
        if (str.indexOf(63) >= 0) {
            return str + "?" + a;
        }
        return str + "&" + a;
    }
}
