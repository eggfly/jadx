package com.umeng.message.util;

import com.qq.p035e.comm.constants.ErrorCode.AdError;
import com.qq.p035e.comm.constants.ErrorCode.NetWorkError;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.android.spdy.SpdyProtocol;
import org.apache.http.entity.mime.MIME;

public class HttpRequest {
    public static final String f14535A = "POST";
    public static final String f14536B = "PUT";
    public static final String f14537C = "TRACE";
    public static final String f14538D = "charset";
    private static final String f14539E = "00content0boundary00";
    private static final String f14540F = "multipart/form-data; boundary=00content0boundary00";
    private static final String f14541G = "\r\n";
    private static final String[] f14542H;
    private static SSLSocketFactory f14543I = null;
    private static HostnameVerifier f14544J = null;
    private static int f14545K = 0;
    private static int f14546L = 0;
    private static ConnectionFactory f14547M = null;
    public static final String f14548a = "UTF-8";
    public static final String f14549b = "application/x-www-form-urlencoded";
    public static final String f14550c = "application/json";
    public static final String f14551d = "gzip";
    public static final String f14552e = "Accept";
    public static final String f14553f = "Accept-Charset";
    public static final String f14554g = "Accept-Encoding";
    public static final String f14555h = "Authorization";
    public static final String f14556i = "Cache-Control";
    public static final String f14557j = "Content-Encoding";
    public static final String f14558k = "Content-Length";
    public static final String f14559l = "Content-Type";
    public static final String f14560m = "Date";
    public static final String f14561n = "ETag";
    public static final String f14562o = "Expires";
    public static final String f14563p = "If-None-Match";
    public static final String f14564q = "Last-Modified";
    public static final String f14565r = "Location";
    public static final String f14566s = "Proxy-Authorization";
    public static final String f14567t = "Referer";
    public static final String f14568u = "Server";
    public static final String f14569v = "User-Agent";
    public static final String f14570w = "DELETE";
    public static final String f14571x = "GET";
    public static final String f14572y = "HEAD";
    public static final String f14573z = "OPTIONS";
    private HttpURLConnection f14574N;
    private final URL f14575O;
    private final String f14576P;
    private C4264e f14577Q;
    private boolean f14578R;
    private boolean f14579S;
    private boolean f14580T;
    private boolean f14581U;
    private int f14582V;
    private String f14583W;
    private int f14584X;

    /* renamed from: com.umeng.message.util.HttpRequest.d */
    protected static abstract class C4250d<V> implements Callable<V> {
        protected C4250d() {
        }

        protected abstract V m17348b();

        protected abstract void m17349c();

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V call() {
            /*
            r3 = this;
            r1 = 1;
            r2 = 0;
            r0 = r3.m17348b();	 Catch:{ HttpRequestException -> 0x0011, IOException -> 0x0018, all -> 0x0028 }
            r3.m17349c();	 Catch:{ IOException -> 0x000a }
            return r0;
        L_0x000a:
            r0 = move-exception;
            r1 = new com.umeng.message.util.HttpRequest$HttpRequestException;
            r1.<init>(r0);
            throw r1;
        L_0x0011:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x0013 }
        L_0x0013:
            r0 = move-exception;
        L_0x0014:
            r3.m17349c();	 Catch:{ IOException -> 0x001f }
        L_0x0017:
            throw r0;
        L_0x0018:
            r0 = move-exception;
            r2 = new com.umeng.message.util.HttpRequest$HttpRequestException;	 Catch:{ all -> 0x0013 }
            r2.<init>(r0);	 Catch:{ all -> 0x0013 }
            throw r2;	 Catch:{ all -> 0x0013 }
        L_0x001f:
            r2 = move-exception;
            if (r1 != 0) goto L_0x0017;
        L_0x0022:
            r0 = new com.umeng.message.util.HttpRequest$HttpRequestException;
            r0.<init>(r2);
            throw r0;
        L_0x0028:
            r0 = move-exception;
            r1 = r2;
            goto L_0x0014;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.HttpRequest.d.call():V");
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.b */
    protected static abstract class C4251b<V> extends C4250d<V> {
        private final Closeable f14508a;
        private final boolean f14509b;

        protected C4251b(Closeable closeable, boolean z) {
            this.f14508a = closeable;
            this.f14509b = z;
        }

        protected void m17350c() {
            if (this.f14508a instanceof Flushable) {
                ((Flushable) this.f14508a).flush();
            }
            if (this.f14509b) {
                try {
                    this.f14508a.close();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.f14508a.close();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.10 */
    class AnonymousClass10 extends C4251b<HttpRequest> {
        final /* synthetic */ Reader f14510a;
        final /* synthetic */ Writer f14511b;
        final /* synthetic */ HttpRequest f14512c;

        AnonymousClass10(HttpRequest httpRequest, Closeable closeable, boolean z, Reader reader, Writer writer) {
            this.f14512c = httpRequest;
            this.f14510a = reader;
            this.f14511b = writer;
            super(closeable, z);
        }

        public HttpRequest m17351a() {
            char[] cArr = new char[this.f14512c.f14582V];
            while (true) {
                int read = this.f14510a.read(cArr);
                if (read == -1) {
                    return this.f14512c;
                }
                this.f14511b.write(cArr, 0, read);
            }
        }

        public /* synthetic */ Object m17352b() {
            return m17351a();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.1 */
    static class C42521 implements X509TrustManager {
        C42521() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.c */
    protected static abstract class C4253c<V> extends C4250d<V> {
        private final Flushable f14513a;

        protected C4253c(Flushable flushable) {
            this.f14513a = flushable;
        }

        protected void m17353c() {
            this.f14513a.flush();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.2 */
    class C42542 extends C4253c<HttpRequest> {
        final /* synthetic */ Reader f14514a;
        final /* synthetic */ Writer f14515b;
        final /* synthetic */ HttpRequest f14516c;

        C42542(HttpRequest httpRequest, Flushable flushable, Reader reader, Writer writer) {
            this.f14516c = httpRequest;
            this.f14514a = reader;
            this.f14515b = writer;
            super(flushable);
        }

        protected HttpRequest m17354a() {
            return this.f14516c.m17442a(this.f14514a, this.f14515b);
        }

        protected /* synthetic */ Object m17355b() {
            return m17354a();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.3 */
    static class C42553 implements HostnameVerifier {
        C42553() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.4 */
    static class C42564 implements PrivilegedAction<String> {
        final /* synthetic */ String f14517a;
        final /* synthetic */ String f14518b;

        C42564(String str, String str2) {
            this.f14517a = str;
            this.f14518b = str2;
        }

        public String m17356a() {
            return System.setProperty(this.f14517a, this.f14518b);
        }

        public /* synthetic */ Object run() {
            return m17356a();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.5 */
    static class C42575 implements PrivilegedAction<String> {
        final /* synthetic */ String f14519a;

        C42575(String str) {
            this.f14519a = str;
        }

        public String m17357a() {
            return System.clearProperty(this.f14519a);
        }

        public /* synthetic */ Object run() {
            return m17357a();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.6 */
    class C42586 extends C4251b<HttpRequest> {
        final /* synthetic */ OutputStream f14520a;
        final /* synthetic */ HttpRequest f14521b;

        C42586(HttpRequest httpRequest, Closeable closeable, boolean z, OutputStream outputStream) {
            this.f14521b = httpRequest;
            this.f14520a = outputStream;
            super(closeable, z);
        }

        protected HttpRequest m17358a() {
            return this.f14521b.m17439a(this.f14520a);
        }

        protected /* synthetic */ Object m17359b() {
            return m17358a();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.7 */
    class C42597 extends C4251b<HttpRequest> {
        final /* synthetic */ BufferedReader f14522a;
        final /* synthetic */ Appendable f14523b;
        final /* synthetic */ HttpRequest f14524c;

        C42597(HttpRequest httpRequest, Closeable closeable, boolean z, BufferedReader bufferedReader, Appendable appendable) {
            this.f14524c = httpRequest;
            this.f14522a = bufferedReader;
            this.f14523b = appendable;
            super(closeable, z);
        }

        public HttpRequest m17360a() {
            Object allocate = CharBuffer.allocate(this.f14524c.f14582V);
            while (true) {
                int read = this.f14522a.read(allocate);
                if (read == -1) {
                    return this.f14524c;
                }
                allocate.rewind();
                this.f14523b.append(allocate, 0, read);
                allocate.rewind();
            }
        }

        public /* synthetic */ Object m17361b() {
            return m17360a();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.8 */
    class C42608 extends C4251b<HttpRequest> {
        final /* synthetic */ BufferedReader f14525a;
        final /* synthetic */ Writer f14526b;
        final /* synthetic */ HttpRequest f14527c;

        C42608(HttpRequest httpRequest, Closeable closeable, boolean z, BufferedReader bufferedReader, Writer writer) {
            this.f14527c = httpRequest;
            this.f14525a = bufferedReader;
            this.f14526b = writer;
            super(closeable, z);
        }

        public HttpRequest m17362a() {
            return this.f14527c.m17442a(this.f14525a, this.f14526b);
        }

        public /* synthetic */ Object m17363b() {
            return m17362a();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.9 */
    class C42619 extends C4251b<HttpRequest> {
        final /* synthetic */ InputStream f14528a;
        final /* synthetic */ OutputStream f14529b;
        final /* synthetic */ HttpRequest f14530c;

        C42619(HttpRequest httpRequest, Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
            this.f14530c = httpRequest;
            this.f14528a = inputStream;
            this.f14529b = outputStream;
            super(closeable, z);
        }

        public HttpRequest m17364a() {
            byte[] bArr = new byte[this.f14530c.f14582V];
            while (true) {
                int read = this.f14528a.read(bArr);
                if (read == -1) {
                    return this.f14530c;
                }
                this.f14529b.write(bArr, 0, read);
            }
        }

        public /* synthetic */ Object m17365b() {
            return m17364a();
        }
    }

    public interface ConnectionFactory {
        public static final ConnectionFactory DEFAULT;

        /* renamed from: com.umeng.message.util.HttpRequest.ConnectionFactory.1 */
        static class C42621 implements ConnectionFactory {
            C42621() {
            }

            public HttpURLConnection create(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            public HttpURLConnection create(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        static {
            DEFAULT = new C42621();
        }

        HttpURLConnection create(URL url);

        HttpURLConnection create(URL url, Proxy proxy);
    }

    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        public IOException m17366a() {
            return (IOException) super.getCause();
        }

        public /* synthetic */ Throwable getCause() {
            return m17366a();
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.a */
    public static class C4263a {
        private static final byte f14531a = (byte) 61;
        private static final String f14532b = "US-ASCII";
        private static final byte[] f14533c;

        static {
            f14533c = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        }

        private C4263a() {
        }

        public static String m17367a(String str) {
            byte[] bytes;
            try {
                bytes = str.getBytes(f14532b);
            } catch (UnsupportedEncodingException e) {
                bytes = str.getBytes();
            }
            return C4263a.m17368a(bytes);
        }

        public static String m17368a(byte[] bArr) {
            return C4263a.m17369a(bArr, 0, bArr.length);
        }

        public static String m17369a(byte[] bArr, int i, int i2) {
            byte[] b = C4263a.m17371b(bArr, i, i2);
            try {
                return new String(b, f14532b);
            } catch (UnsupportedEncodingException e) {
                return new String(b);
            }
        }

        private static byte[] m17370a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            int i4 = 0;
            byte[] bArr3 = f14533c;
            int i5 = (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
            if (i2 > 2) {
                i4 = (bArr[i + 2] << 24) >>> 24;
            }
            i4 |= i5;
            switch (i2) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    bArr2[i3] = bArr3[i4 >>> 18];
                    bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                    bArr2[i3 + 2] = f14531a;
                    bArr2[i3 + 3] = f14531a;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    bArr2[i3] = bArr3[i4 >>> 18];
                    bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                    bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
                    bArr2[i3 + 3] = f14531a;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    bArr2[i3] = bArr3[i4 >>> 18];
                    bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                    bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
                    bArr2[i3 + 3] = bArr3[i4 & 63];
                    break;
            }
            return bArr2;
        }

        public static byte[] m17371b(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw new NullPointerException("Cannot serialize a null array.");
            } else if (i < 0) {
                throw new IllegalArgumentException("Cannot have negative offset: " + i);
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Cannot have length offset: " + i2);
            } else if (i + i2 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)}));
            } else {
                Object obj = new byte[((i2 % 3 > 0 ? 4 : 0) + ((i2 / 3) * 4))];
                int i3 = i2 - 2;
                int i4 = 0;
                int i5 = 0;
                while (i5 < i3) {
                    C4263a.m17370a(bArr, i5 + i, 3, obj, i4);
                    i5 += 3;
                    i4 += 4;
                }
                if (i5 < i2) {
                    C4263a.m17370a(bArr, i5 + i, i2 - i5, obj, i4);
                    i4 += 4;
                }
                if (i4 > obj.length - 1) {
                    return obj;
                }
                Object obj2 = new byte[i4];
                System.arraycopy(obj, 0, obj2, 0, i4);
                return obj2;
            }
        }
    }

    /* renamed from: com.umeng.message.util.HttpRequest.e */
    public static class C4264e extends BufferedOutputStream {
        private final CharsetEncoder f14534a;

        public C4264e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f14534a = Charset.forName(HttpRequest.m17415v(str)).newEncoder();
        }

        public C4264e m17373a(String str) {
            ByteBuffer encode = this.f14534a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    static {
        f14542H = new String[0];
        f14545K = 60000;
        f14546L = 60000;
        f14547M = ConnectionFactory.DEFAULT;
    }

    public HttpRequest(CharSequence charSequence, String str) {
        this.f14574N = null;
        this.f14580T = true;
        this.f14581U = false;
        this.f14582V = SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
        try {
            this.f14575O = new URL(charSequence.toString());
            this.f14576P = str;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest(URL url, String str) {
        this.f14574N = null;
        this.f14580T = true;
        this.f14581U = false;
        this.f14582V = SpdyProtocol.SLIGHTSSL_1_RTT_MODE;
        this.f14575O = url;
        this.f14576P = str;
    }

    private static SSLSocketFactory m17374R() {
        if (f14543I == null) {
            TrustManager[] trustManagerArr = new TrustManager[]{new C42521()};
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, trustManagerArr, new SecureRandom());
                f14543I = instance.getSocketFactory();
            } catch (Throwable e) {
                IOException iOException = new IOException("Security exception configuring SSL context");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        }
        return f14543I;
    }

    private static HostnameVerifier m17375S() {
        if (f14544J == null) {
            f14544J = new C42553();
        }
        return f14544J;
    }

    private Proxy m17376T() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f14583W, this.f14584X));
    }

    private HttpURLConnection m17377U() {
        try {
            HttpURLConnection create = this.f14583W != null ? f14547M.create(this.f14575O, m17376T()) : f14547M.create(this.f14575O);
            create.setRequestMethod(this.f14576P);
            return create;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public static HttpRequest m17379a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m17383a(charSequence, (Map) map);
        if (z) {
            a = m17382a(a);
        }
        return m17391b(a);
    }

    public static HttpRequest m17380a(CharSequence charSequence, boolean z, Object... objArr) {
        CharSequence a = m17384a(charSequence, objArr);
        if (z) {
            a = m17382a(a);
        }
        return m17391b(a);
    }

    public static HttpRequest m17381a(URL url) {
        return new HttpRequest(url, f14571x);
    }

    public static String m17382a(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String toASCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = toASCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < toASCIIString.length()) {
                    toASCIIString = toASCIIString.substring(0, indexOf + 1) + toASCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return toASCIIString;
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static String m17383a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        m17385a(charSequence2, stringBuilder);
        m17395b(charSequence2, stringBuilder);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static String m17384a(CharSequence charSequence, Object... objArr) {
        String charSequence2 = charSequence.toString();
        if (objArr == null || objArr.length == 0) {
            return charSequence2;
        }
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("Must specify an even number of parameter names/values");
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        m17385a(charSequence2, stringBuilder);
        m17395b(charSequence2, stringBuilder);
        stringBuilder.append(objArr[0]);
        stringBuilder.append('=');
        Object obj = objArr[1];
        if (obj != null) {
            stringBuilder.append(obj);
        }
        for (int i = 2; i < objArr.length; i += 2) {
            stringBuilder.append('&');
            stringBuilder.append(objArr[i]);
            stringBuilder.append('=');
            Object obj2 = objArr[i + 1];
            if (obj2 != null) {
                stringBuilder.append(obj2);
            }
        }
        return stringBuilder.toString();
    }

    private static StringBuilder m17385a(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    public static void m17386a(int i) {
        String num = Integer.toString(i);
        m17413j("http.proxyPort", num);
        m17413j("https.proxyPort", num);
    }

    public static void m17387a(ConnectionFactory connectionFactory) {
        if (connectionFactory == null) {
            f14547M = ConnectionFactory.DEFAULT;
        } else {
            f14547M = connectionFactory;
        }
    }

    public static void m17388a(String str) {
        m17413j("http.proxyHost", str);
        m17413j("https.proxyHost", str);
    }

    public static void m17389a(boolean z) {
        m17413j("http.keepAlive", Boolean.toString(z));
    }

    public static void m17390a(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            m17413j("http.nonProxyHosts", null);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(strArr[i]).append('|');
        }
        stringBuilder.append(strArr[length]);
        m17413j("http.nonProxyHosts", stringBuilder.toString());
    }

    public static HttpRequest m17391b(CharSequence charSequence) {
        return new HttpRequest(charSequence, f14571x);
    }

    public static HttpRequest m17392b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m17383a(charSequence, (Map) map);
        if (z) {
            a = m17382a(a);
        }
        return m17396c(a);
    }

    public static HttpRequest m17393b(CharSequence charSequence, boolean z, Object... objArr) {
        CharSequence a = m17384a(charSequence, objArr);
        if (z) {
            a = m17382a(a);
        }
        return m17396c(a);
    }

    public static HttpRequest m17394b(URL url) {
        HttpRequest httpRequest = new HttpRequest(url, f14535A);
        httpRequest.m17465a().setConnectTimeout(f14546L);
        httpRequest.m17465a().setReadTimeout(f14545K);
        return httpRequest;
    }

    private static StringBuilder m17395b(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static HttpRequest m17396c(CharSequence charSequence) {
        HttpRequest httpRequest = new HttpRequest(charSequence, f14535A);
        httpRequest.m17465a().setConnectTimeout(f14546L);
        httpRequest.m17465a().setReadTimeout(f14545K);
        return httpRequest;
    }

    public static HttpRequest m17397c(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m17383a(charSequence, (Map) map);
        if (z) {
            a = m17382a(a);
        }
        return m17400d(a);
    }

    public static HttpRequest m17398c(CharSequence charSequence, boolean z, Object... objArr) {
        CharSequence a = m17384a(charSequence, objArr);
        if (z) {
            a = m17382a(a);
        }
        return m17400d(a);
    }

    public static HttpRequest m17399c(URL url) {
        return new HttpRequest(url, f14536B);
    }

    public static HttpRequest m17400d(CharSequence charSequence) {
        return new HttpRequest(charSequence, f14536B);
    }

    public static HttpRequest m17401d(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m17383a(charSequence, (Map) map);
        if (z) {
            a = m17382a(a);
        }
        return m17404e(a);
    }

    public static HttpRequest m17402d(CharSequence charSequence, boolean z, Object... objArr) {
        CharSequence a = m17384a(charSequence, objArr);
        if (z) {
            a = m17382a(a);
        }
        return m17404e(a);
    }

    public static HttpRequest m17403d(URL url) {
        return new HttpRequest(url, f14570w);
    }

    public static HttpRequest m17404e(CharSequence charSequence) {
        return new HttpRequest(charSequence, f14570w);
    }

    public static HttpRequest m17405e(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m17383a(charSequence, (Map) map);
        if (z) {
            a = m17382a(a);
        }
        return m17408f(a);
    }

    public static HttpRequest m17406e(CharSequence charSequence, boolean z, Object... objArr) {
        CharSequence a = m17384a(charSequence, objArr);
        if (z) {
            a = m17382a(a);
        }
        return m17408f(a);
    }

    public static HttpRequest m17407e(URL url) {
        return new HttpRequest(url, f14572y);
    }

    public static HttpRequest m17408f(CharSequence charSequence) {
        return new HttpRequest(charSequence, f14572y);
    }

    public static HttpRequest m17409f(URL url) {
        return new HttpRequest(url, f14573z);
    }

    public static HttpRequest m17410g(CharSequence charSequence) {
        return new HttpRequest(charSequence, f14573z);
    }

    public static HttpRequest m17411g(URL url) {
        return new HttpRequest(url, f14537C);
    }

    public static HttpRequest m17412h(CharSequence charSequence) {
        return new HttpRequest(charSequence, f14537C);
    }

    private static String m17413j(String str, String str2) {
        return (String) AccessController.doPrivileged(str2 != null ? new C42564(str, str2) : new C42575(str));
    }

    private static String m17415v(String str) {
        return (str == null || str.length() <= 0) ? f14548a : str;
    }

    public String m17416A() {
        return m17490e(f14556i);
    }

    public String m17417B() {
        return m17490e(f14561n);
    }

    public long m17418C() {
        return m17492f(f14562o);
    }

    public long m17419D() {
        return m17492f(f14564q);
    }

    public String m17420E() {
        return m17490e(f14565r);
    }

    public String m17421F() {
        return m17490e(f14559l);
    }

    public int m17422G() {
        return m17496g(f14558k);
    }

    public HttpRequest m17423H() {
        return m17526t(f14550c);
    }

    protected HttpRequest m17424I() {
        if (this.f14577Q != null) {
            if (this.f14578R) {
                this.f14577Q.m17373a("\r\n--00content0boundary00--\r\n");
            }
            if (this.f14580T) {
                try {
                    this.f14577Q.close();
                } catch (IOException e) {
                }
            } else {
                this.f14577Q.close();
            }
            this.f14577Q = null;
        }
        return this;
    }

    protected HttpRequest m17425J() {
        try {
            return m17424I();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest m17426K() {
        if (this.f14577Q == null) {
            m17465a().setDoOutput(true);
            this.f14577Q = new C4264e(m17465a().getOutputStream(), m17481c(m17465a().getRequestProperty(f14559l), f14538D), this.f14582V);
        }
        return this;
    }

    protected HttpRequest m17427L() {
        if (this.f14578R) {
            this.f14577Q.m17373a("\r\n--00content0boundary00\r\n");
        } else {
            this.f14578R = true;
            m17522r(f14540F).m17426K();
            this.f14577Q.m17373a("--00content0boundary00\r\n");
        }
        return this;
    }

    public OutputStreamWriter m17428M() {
        try {
            m17426K();
            return new OutputStreamWriter(this.f14577Q, this.f14577Q.f14534a.charset());
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17429N() {
        HttpURLConnection a = m17465a();
        if (a instanceof HttpsURLConnection) {
            ((HttpsURLConnection) a).setSSLSocketFactory(m17374R());
        }
        return this;
    }

    public HttpRequest m17430O() {
        HttpURLConnection a = m17465a();
        if (a instanceof HttpsURLConnection) {
            ((HttpsURLConnection) a).setHostnameVerifier(m17375S());
        }
        return this;
    }

    public URL m17431P() {
        return m17465a().getURL();
    }

    public String m17432Q() {
        return m17465a().getRequestMethod();
    }

    public int m17433a(String str, int i) {
        m17425J();
        return m17465a().getHeaderFieldInt(str, i);
    }

    public long m17434a(String str, long j) {
        m17425J();
        return m17465a().getHeaderFieldDate(str, j);
    }

    public HttpRequest m17435a(long j) {
        m17465a().setIfModifiedSince(j);
        return this;
    }

    public HttpRequest m17436a(File file) {
        try {
            Object bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f14582V);
            return (HttpRequest) new C42586(this, bufferedOutputStream, this.f14580T, bufferedOutputStream).call();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17437a(InputStream inputStream) {
        try {
            m17426K();
            m17438a(inputStream, this.f14577Q);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest m17438a(InputStream inputStream, OutputStream outputStream) {
        return (HttpRequest) new C42619(this, inputStream, this.f14580T, inputStream, outputStream).call();
    }

    public HttpRequest m17439a(OutputStream outputStream) {
        try {
            return m17438a(m17521q(), outputStream);
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17440a(PrintStream printStream) {
        return m17439a((OutputStream) printStream);
    }

    public HttpRequest m17441a(Reader reader) {
        try {
            m17426K();
            Object outputStreamWriter = new OutputStreamWriter(this.f14577Q, this.f14577Q.f14534a.charset());
            return (HttpRequest) new C42542(this, outputStreamWriter, reader, outputStreamWriter).call();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest m17442a(Reader reader, Writer writer) {
        return (HttpRequest) new AnonymousClass10(this, reader, this.f14580T, reader, writer).call();
    }

    public HttpRequest m17443a(Writer writer) {
        Closeable t = m17527t();
        return (HttpRequest) new C42608(this, t, this.f14580T, t, writer).call();
    }

    public HttpRequest m17444a(Appendable appendable) {
        Closeable t = m17527t();
        return (HttpRequest) new C42597(this, t, this.f14580T, t, appendable).call();
    }

    public HttpRequest m17445a(Object obj, Object obj2) {
        return m17446a(obj, obj2, f14548a);
    }

    public HttpRequest m17446a(Object obj, Object obj2, String str) {
        boolean z = !this.f14579S;
        if (z) {
            m17494f(f14549b, str);
            this.f14579S = true;
        }
        String v = m17415v(str);
        try {
            m17426K();
            if (!z) {
                this.f14577Q.write(38);
            }
            this.f14577Q.m17373a(URLEncoder.encode(obj.toString(), v));
            this.f14577Q.write(61);
            if (obj2 != null) {
                this.f14577Q.m17373a(URLEncoder.encode(obj2.toString(), v));
            }
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17447a(String str, File file) {
        return m17451a(str, null, file);
    }

    public HttpRequest m17448a(String str, InputStream inputStream) {
        return m17455a(str, null, null, inputStream);
    }

    public HttpRequest m17449a(String str, Number number) {
        return m17450a(str, number != null ? number.toString() : null);
    }

    public HttpRequest m17450a(String str, String str2) {
        m17465a().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest m17451a(String str, String str2, File file) {
        return m17454a(str, str2, null, file);
    }

    public HttpRequest m17452a(String str, String str2, Number number) {
        return m17470b(str, str2, number != null ? number.toString() : null);
    }

    protected HttpRequest m17453a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"").append(str2);
        }
        stringBuilder.append('\"');
        m17503i(MIME.CONTENT_DISPOSITION, stringBuilder.toString());
        if (str3 != null) {
            m17503i(f14559l, str3);
        }
        return m17502i(f14541G);
    }

    public HttpRequest m17454a(String str, String str2, String str3, File file) {
        try {
            return m17455a(str, str2, str3, new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17455a(String str, String str2, String str3, InputStream inputStream) {
        try {
            m17427L();
            m17453a(str, str2, str3);
            m17438a(inputStream, this.f14577Q);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17456a(String str, String str2, String str3, String str4) {
        try {
            m17427L();
            m17453a(str, str2, str3);
            this.f14577Q.m17373a(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17457a(Entry<String, String> entry) {
        return m17450a((String) entry.getKey(), (String) entry.getValue());
    }

    public HttpRequest m17458a(Entry<?, ?> entry, String str) {
        return m17446a(entry.getKey(), entry.getValue(), str);
    }

    public HttpRequest m17459a(Map<String, String> map) {
        if (!map.isEmpty()) {
            for (Entry a : map.entrySet()) {
                m17457a(a);
            }
        }
        return this;
    }

    public HttpRequest m17460a(Map<?, ?> map, String str) {
        if (!map.isEmpty()) {
            for (Entry a : map.entrySet()) {
                m17458a(a, str);
            }
        }
        return this;
    }

    public HttpRequest m17461a(AtomicInteger atomicInteger) {
        atomicInteger.set(m17477c());
        return this;
    }

    public HttpRequest m17462a(AtomicReference<String> atomicReference) {
        atomicReference.set(m17515n());
        return this;
    }

    public HttpRequest m17463a(AtomicReference<String> atomicReference, String str) {
        atomicReference.set(m17474b(str));
        return this;
    }

    public HttpRequest m17464a(byte[] bArr) {
        return m17437a(new ByteArrayInputStream(bArr));
    }

    public HttpURLConnection m17465a() {
        if (this.f14574N == null) {
            this.f14574N = m17377U();
        }
        return this.f14574N;
    }

    public HttpRequest m17466b(int i) {
        m17465a().setChunkedStreamingMode(i);
        return this;
    }

    public HttpRequest m17467b(File file) {
        try {
            return m17437a(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17468b(String str, int i) {
        if (this.f14574N != null) {
            throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
        }
        this.f14583W = str;
        this.f14584X = i;
        return this;
    }

    public HttpRequest m17469b(String str, Number number) {
        return m17452a(str, null, number);
    }

    public HttpRequest m17470b(String str, String str2, String str3) {
        return m17456a(str, str2, null, str3);
    }

    public HttpRequest m17471b(Entry<?, ?> entry) {
        return m17458a((Entry) entry, f14548a);
    }

    public HttpRequest m17472b(Map<?, ?> map) {
        return m17460a((Map) map, f14548a);
    }

    public HttpRequest m17473b(boolean z) {
        this.f14580T = z;
        return this;
    }

    public String m17474b(String str) {
        OutputStream m = m17513m();
        try {
            m17438a(m17521q(), m);
            return m.toString(m17415v(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String m17475b(String str, String str2) {
        return m17481c(m17490e(str), str2);
    }

    public boolean m17476b() {
        return this.f14580T;
    }

    public int m17477c() {
        try {
            m17424I();
            return m17465a().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17478c(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Size must be greater than zero");
        }
        this.f14582V = i;
        return this;
    }

    public HttpRequest m17479c(boolean z) {
        this.f14581U = z;
        return this;
    }

    public InputStreamReader m17480c(String str) {
        try {
            return new InputStreamReader(m17523r(), m17415v(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected String m17481c(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length) {
            return null;
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = indexOf;
            indexOf = length;
        } else {
            int i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        while (indexOf2 < indexOf) {
            int indexOf3 = str.indexOf(61, indexOf2);
            if (indexOf3 != -1 && indexOf3 < indexOf && str2.equals(str.substring(indexOf2, indexOf3).trim())) {
                String trim = str.substring(indexOf3 + 1, indexOf).trim();
                indexOf3 = trim.length();
                if (indexOf3 != 0) {
                    return (indexOf3 > 2 && '\"' == trim.charAt(0) && '\"' == trim.charAt(indexOf3 - 1)) ? trim.substring(1, indexOf3 - 1) : trim;
                }
            }
            indexOf++;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length;
            }
            i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        return null;
    }

    public HttpRequest m17482d(int i) {
        m17465a().setReadTimeout(i);
        return this;
    }

    public HttpRequest m17483d(String str, String str2) {
        return m17516o("Basic " + C4263a.m17367a(str + ':' + str2));
    }

    public HttpRequest m17484d(boolean z) {
        m17465a().setUseCaches(z);
        return this;
    }

    public BufferedReader m17485d(String str) {
        return new BufferedReader(m17480c(str), this.f14582V);
    }

    public boolean m17486d() {
        return Constants.COMMAND_HANDSHAKE == m17477c();
    }

    public HttpRequest m17487e(int i) {
        m17465a().setConnectTimeout(i);
        return this;
    }

    public HttpRequest m17488e(String str, String str2) {
        return m17518p("Basic " + C4263a.m17367a(str + ':' + str2));
    }

    public HttpRequest m17489e(boolean z) {
        m17465a();
        HttpURLConnection.setFollowRedirects(z);
        return this;
    }

    public String m17490e(String str) {
        m17425J();
        return m17465a().getHeaderField(str);
    }

    public boolean m17491e() {
        return Constants.COMMAND_PING == m17477c();
    }

    public long m17492f(String str) {
        return m17434a(str, -1);
    }

    public HttpRequest m17493f(int i) {
        m17465a().setFixedLengthStreamingMode(i);
        return this;
    }

    public HttpRequest m17494f(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return m17450a(f14559l, str);
        }
        String str3 = "; charset=";
        return m17450a(f14559l, str + "; charset=" + str2);
    }

    public boolean m17495f() {
        return AdError.PLACEMENT_ERROR == m17477c();
    }

    public int m17496g(String str) {
        return m17433a(str, -1);
    }

    protected HttpRequest m17497g(String str, String str2) {
        return m17453a(str, str2, null);
    }

    public boolean m17498g() {
        return NetWorkError.STUB_NETWORK_ERROR == m17477c();
    }

    public HttpRequest m17499h(String str, String str2) {
        return m17470b(str, null, str2);
    }

    public boolean m17500h() {
        return NetWorkError.TIME_OUT_ERROR == m17477c();
    }

    public String[] m17501h(String str) {
        Map u = m17528u();
        if (u == null || u.isEmpty()) {
            return f14542H;
        }
        List list = (List) u.get(str);
        return (list == null || list.isEmpty()) ? f14542H : (String[]) list.toArray(new String[list.size()]);
    }

    public HttpRequest m17502i(CharSequence charSequence) {
        try {
            m17426K();
            this.f14577Q.m17373a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17503i(String str, String str2) {
        return m17502i((CharSequence) str).m17502i((CharSequence) ": ").m17502i((CharSequence) str2).m17502i(f14541G);
    }

    public Map<String, String> m17504i(String str) {
        return m17507j(m17490e(str));
    }

    public boolean m17505i() {
        return ErrorCode.DM_PACKAGENAME_INVALID == m17477c();
    }

    public String m17506j() {
        try {
            m17424I();
            return m17465a().getResponseMessage();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected Map<String, String> m17507j(String str) {
        if (str == null || str.length() == 0) {
            return Collections.emptyMap();
        }
        int length = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length) {
            return Collections.emptyMap();
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = length;
        }
        Map<String, String> linkedHashMap = new LinkedHashMap();
        while (indexOf < indexOf2) {
            int indexOf3 = str.indexOf(61, indexOf);
            if (indexOf3 != -1 && indexOf3 < indexOf2) {
                String trim = str.substring(indexOf, indexOf3).trim();
                if (trim.length() > 0) {
                    String trim2 = str.substring(indexOf3 + 1, indexOf2).trim();
                    int length2 = trim2.length();
                    if (length2 != 0) {
                        if (length2 > 2 && '\"' == trim2.charAt(0) && '\"' == trim2.charAt(length2 - 1)) {
                            linkedHashMap.put(trim, trim2.substring(1, length2 - 1));
                        } else {
                            linkedHashMap.put(trim, trim2);
                        }
                    }
                }
            }
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length;
            }
        }
        return linkedHashMap;
    }

    public HttpRequest m17508k() {
        m17465a().disconnect();
        return this;
    }

    public HttpRequest m17509k(String str) {
        return m17450a(f14569v, str);
    }

    public int m17510l() {
        return this.f14582V;
    }

    public HttpRequest m17511l(String str) {
        return m17450a(f14567t, str);
    }

    public HttpRequest m17512m(String str) {
        return m17450a(f14554g, str);
    }

    protected ByteArrayOutputStream m17513m() {
        int G = m17422G();
        return G > 0 ? new ByteArrayOutputStream(G) : new ByteArrayOutputStream();
    }

    public HttpRequest m17514n(String str) {
        return m17450a(f14553f, str);
    }

    public String m17515n() {
        return m17474b(m17529v());
    }

    public HttpRequest m17516o(String str) {
        return m17450a(f14555h, str);
    }

    public boolean m17517o() {
        return m17422G() == 0;
    }

    public HttpRequest m17518p(String str) {
        return m17450a(f14566s, str);
    }

    public byte[] m17519p() {
        OutputStream m = m17513m();
        try {
            m17438a(m17521q(), m);
            return m.toByteArray();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m17520q(String str) {
        return m17450a(f14563p, str);
    }

    public BufferedInputStream m17521q() {
        return new BufferedInputStream(m17523r(), this.f14582V);
    }

    public HttpRequest m17522r(String str) {
        return m17494f(str, null);
    }

    public InputStream m17523r() {
        if (m17477c() < NetWorkError.STUB_NETWORK_ERROR) {
            try {
                InputStream inputStream = m17465a().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        }
        inputStream = m17465a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = m17465a().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        }
        if (!this.f14581U || !f14551d.equals(m17531x())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new HttpRequestException(e22);
        }
    }

    public HttpRequest m17524s(String str) {
        return m17493f(Integer.parseInt(str));
    }

    public InputStreamReader m17525s() {
        return m17480c(m17529v());
    }

    public HttpRequest m17526t(String str) {
        return m17450a(f14552e, str);
    }

    public BufferedReader m17527t() {
        return m17485d(m17529v());
    }

    public String toString() {
        return m17432Q() + ' ' + m17431P();
    }

    public Map<String, List<String>> m17528u() {
        m17425J();
        return m17465a().getHeaderFields();
    }

    public String m17529v() {
        return m17475b(f14559l, f14538D);
    }

    public HttpRequest m17530w() {
        return m17512m(f14551d);
    }

    public String m17531x() {
        return m17490e(f14557j);
    }

    public String m17532y() {
        return m17490e(f14568u);
    }

    public long m17533z() {
        return m17492f(f14560m);
    }
}
