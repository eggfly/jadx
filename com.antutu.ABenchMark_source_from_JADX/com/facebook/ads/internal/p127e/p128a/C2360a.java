package com.facebook.ads.internal.p127e.p128a;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.C2409e;
import com.facebook.ads.internal.p125c.C2352g;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2499h;
import com.umeng.message.common.C4210b;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.facebook.ads.internal.e.a.a */
public class C2360a {
    private static int[] f8242g;
    private static final String f8243h;
    protected final C2357p f8244a;
    protected final C2363d f8245b;
    protected String f8246c;
    protected C2365q f8247d;
    protected int f8248e;
    protected int f8249f;
    private int f8250i;
    private Map<String, String> f8251j;
    private boolean f8252k;

    /* renamed from: com.facebook.ads.internal.e.a.a.1 */
    class C23591 extends C2358f {
        C23591() {
        }
    }

    static {
        f8242g = new int[20];
        f8243h = C2360a.class.getSimpleName();
        C2360a.m9089c();
        if (VERSION.SDK_INT > 8) {
            C2360a.m9088a();
        }
    }

    public C2360a() {
        this(BuildConfig.FLAVOR);
    }

    public C2360a(Context context) {
        this(context, null);
    }

    public C2360a(Context context, C2409e c2409e) {
        this();
        m9093a("user-agent", C2499h.m9491a(context, c2409e) + " [" + "FBAN/AudienceNetworkForAndroid;" + "FBSN/" + C4210b.f14219D + ";" + "FBSV/" + C2352g.f8199a + ";" + "FBAB/" + C2352g.f8202d + ";" + "FBAV/" + C2352g.f8204f + ";" + "FBBV/" + C2352g.f8205g + ";" + "FBLC/" + Locale.getDefault().toString() + "]");
        if (C2498g.m9480a()) {
            C2498g.m9485b();
        }
    }

    public C2360a(C2363d c2363d, String str) {
        this(c2363d, str, new C23591());
    }

    public C2360a(C2363d c2363d, String str, C2357p c2357p) {
        this.f8246c = BuildConfig.FLAVOR;
        this.f8247d = new C2366g();
        this.f8248e = AdError.SERVER_ERROR_CODE;
        this.f8249f = 8000;
        this.f8250i = 3;
        this.f8251j = new TreeMap();
        this.f8246c = str;
        this.f8244a = c2357p;
        this.f8245b = c2363d;
    }

    public C2360a(String str) {
        this(new C2364e(), str);
    }

    public static void m9088a() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private static void m9089c() {
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void m9090c(HttpURLConnection httpURLConnection) {
        for (String str : this.f8251j.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.f8251j.get(str));
        }
    }

    protected int m9091a(int i) {
        return f8242g[i + 2] * AdError.NETWORK_ERROR_CODE;
    }

    protected int m9092a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            outputStream = this.f8244a.m9074a(httpURLConnection);
            if (outputStream != null) {
                this.f8244a.m9076a(outputStream, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                }
            }
        }
    }

    public C2360a m9093a(String str, String str2) {
        this.f8251j.put(str, str2);
        return this;
    }

    public C2373n m9094a(C2368l c2368l) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        while (i < this.f8250i) {
            try {
                m9108c(m9091a(i));
                if (this.f8247d.m9117a()) {
                    this.f8247d.m9115a((i + 1) + "of" + this.f8250i + ", trying " + c2368l.m9126a());
                }
                currentTimeMillis = System.currentTimeMillis();
                C2373n a = m9095a(c2368l.m9126a(), c2368l.m9127b(), c2368l.m9128c(), c2368l.m9129d());
                if (a != null) {
                    return a;
                }
                i++;
            } catch (C2372m e) {
                if (m9102a((Throwable) e, currentTimeMillis) && i < this.f8250i - 1) {
                    continue;
                } else if (!this.f8244a.m9078a(e) || i >= this.f8250i - 1) {
                    throw e;
                } else {
                    try {
                        Thread.sleep((long) this.f8248e);
                    } catch (InterruptedException e2) {
                        throw e;
                    }
                }
            }
        }
        return null;
    }

    protected C2373n m9095a(String str, C2370j c2370j, String str2, byte[] bArr) {
        HttpURLConnection a;
        C2373n a2;
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        C2373n c2373n = null;
        C2373n c2373n2 = null;
        try {
            this.f8252k = false;
            a = m9098a(str);
            try {
                m9101a(a, c2370j, str2);
                m9090c(a);
                if (this.f8247d.m9117a()) {
                    this.f8247d.m9116a(a, bArr);
                }
                a.connect();
                this.f8252k = true;
                if (a.getDoOutput() && bArr != null) {
                    m9092a(a, bArr);
                }
                a2 = a.getDoInput() ? m9097a(a) : new C2373n(a, null);
                if (this.f8247d.m9117a()) {
                    this.f8247d.m9114a(a2);
                }
                if (a == null) {
                    return a2;
                }
                a.disconnect();
                return a2;
            } catch (Exception e) {
                httpURLConnection = a;
                exception = e;
                try {
                    a2 = m9105b(httpURLConnection);
                    if (a2 != null) {
                        try {
                            if (a2.m9134a() > 0) {
                                if (this.f8247d.m9117a()) {
                                    this.f8247d.m9114a(a2);
                                }
                                if (httpURLConnection != null) {
                                    return a2;
                                }
                                httpURLConnection.disconnect();
                                return a2;
                            }
                        } catch (Throwable th2) {
                            a = httpURLConnection;
                            C2373n c2373n3 = a2;
                            th = th2;
                            c2373n = c2373n3;
                            if (this.f8247d.m9117a()) {
                                this.f8247d.m9114a(c2373n);
                            }
                            if (a != null) {
                                a.disconnect();
                            }
                            throw th;
                        }
                    }
                    throw new C2372m(exception, a2);
                } catch (Exception e2) {
                    exception.printStackTrace();
                    if (null != null) {
                        if (c2373n2.m9134a() > 0) {
                            if (this.f8247d.m9117a()) {
                                this.f8247d.m9114a(null);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return null;
                        }
                    }
                    throw new C2372m(exception, c2373n2);
                } catch (Throwable th3) {
                    th = th3;
                    a = httpURLConnection;
                    if (this.f8247d.m9117a()) {
                        this.f8247d.m9114a(c2373n);
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (this.f8247d.m9117a()) {
                    this.f8247d.m9114a(c2373n);
                }
                if (a != null) {
                    a.disconnect();
                }
                throw th;
            }
        } catch (Exception e3) {
            exception = e3;
            httpURLConnection = null;
            a2 = m9105b(httpURLConnection);
            if (a2 != null) {
                if (a2.m9134a() > 0) {
                    if (this.f8247d.m9117a()) {
                        this.f8247d.m9114a(a2);
                    }
                    if (httpURLConnection != null) {
                        return a2;
                    }
                    httpURLConnection.disconnect();
                    return a2;
                }
            }
            throw new C2372m(exception, a2);
        } catch (Throwable th5) {
            th = th5;
            a = null;
            if (this.f8247d.m9117a()) {
                this.f8247d.m9114a(c2373n);
            }
            if (a != null) {
                a.disconnect();
            }
            throw th;
        }
    }

    public C2373n m9096a(String str, C2374o c2374o) {
        return m9103b(new C2369i(str, c2374o));
    }

    protected C2373n m9097a(HttpURLConnection httpURLConnection) {
        Throwable th;
        byte[] bArr = null;
        InputStream b;
        try {
            b = this.f8244a.m9080b(httpURLConnection);
            if (b != null) {
                try {
                    bArr = this.f8244a.m9079a(b);
                } catch (Throwable th2) {
                    th = th2;
                    if (b != null) {
                        try {
                            b.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C2373n c2373n = new C2373n(httpURLConnection, bArr);
            if (b != null) {
                try {
                    b.close();
                } catch (Exception e2) {
                }
            }
            return c2373n;
        } catch (Throwable th3) {
            th = th3;
            b = null;
            if (b != null) {
                b.close();
            }
            throw th;
        }
    }

    protected HttpURLConnection m9098a(String str) {
        String str2 = this.f8246c + str;
        try {
            URL url = new URL(str2);
            return this.f8244a.m9075a(str2);
        } catch (Throwable e) {
            throw new IllegalArgumentException(str2 + " is not a valid URL", e);
        }
    }

    protected void m9099a(C2368l c2368l, C2361b c2361b) {
        this.f8245b.m9112a(this, c2361b).m9111a(c2368l);
    }

    public void m9100a(String str, C2374o c2374o, C2361b c2361b) {
        m9099a(new C2371k(str, c2374o), c2361b);
    }

    protected void m9101a(HttpURLConnection httpURLConnection, C2370j c2370j, String str) {
        httpURLConnection.setConnectTimeout(this.f8248e);
        httpURLConnection.setReadTimeout(this.f8249f);
        this.f8244a.m9077a(httpURLConnection, c2370j, str);
    }

    protected boolean m9102a(Throwable th, long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.f8247d.m9117a()) {
            this.f8247d.m9115a("ELAPSED TIME = " + currentTimeMillis + ", CT = " + this.f8248e + ", RT = " + this.f8249f);
        }
        return this.f8252k ? currentTimeMillis >= ((long) this.f8249f) : currentTimeMillis >= ((long) this.f8248e);
    }

    public C2373n m9103b(C2368l c2368l) {
        C2373n c2373n = null;
        try {
            c2373n = m9095a(c2368l.m9126a(), c2368l.m9127b(), c2368l.m9128c(), c2368l.m9129d());
        } catch (C2372m e) {
            this.f8244a.m9078a(e);
        } catch (Exception e2) {
            this.f8244a.m9078a(new C2372m(e2, c2373n));
        }
        return c2373n;
    }

    public C2373n m9104b(String str, C2374o c2374o) {
        return m9103b(new C2371k(str, c2374o));
    }

    protected C2373n m9105b(HttpURLConnection httpURLConnection) {
        Throwable th;
        byte[] bArr = null;
        InputStream errorStream;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                try {
                    bArr = this.f8244a.m9079a(errorStream);
                } catch (Throwable th2) {
                    th = th2;
                    if (errorStream != null) {
                        try {
                            errorStream.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C2373n c2373n = new C2373n(httpURLConnection, bArr);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception e2) {
                }
            }
            return c2373n;
        } catch (Throwable th3) {
            th = th3;
            errorStream = null;
            if (errorStream != null) {
                errorStream.close();
            }
            throw th;
        }
    }

    public C2374o m9106b() {
        return new C2374o();
    }

    public void m9107b(int i) {
        if (i < 1 || i > 18) {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        }
        this.f8250i = i;
    }

    public void m9108c(int i) {
        this.f8248e = i;
    }
}
