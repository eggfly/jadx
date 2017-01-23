package com.cmcm.p074a.p075a.p113b;

import com.cmcm.p074a.p075a.p112a.C2115i;
import com.cmcm.p074a.p075a.p112a.C2133z;
import com.cmcm.p074a.p075a.p112a.ad;
import com.taobao.accs.common.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;

/* renamed from: com.cmcm.a.a.b.a */
public class C2121a {
    private boolean f7446a;
    private Thread f7447b;
    private boolean f7448c;
    private String f7449d;
    private int f7450e;

    public C2121a() {
        this.f7450e = 10000;
    }

    private boolean m8005a() {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        Closeable closeable = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.f7449d).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(this.f7450e);
                httpURLConnection2.setReadTimeout(this.f7450e);
                httpURLConnection2.setRequestMethod(SpdyRequest.GET_METHOD);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(false);
                if (m8009a(httpURLConnection2)) {
                    httpURLConnection2.connect();
                    closeable = httpURLConnection2.getInputStream();
                    if (m8010a(httpURLConnection2, (InputStream) closeable)) {
                        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
                        int read;
                        do {
                            read = closeable.read(bArr);
                            if (read <= 0) {
                                C2115i.m7967a(closeable);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return true;
                            }
                        } while (m8011a(httpURLConnection2, bArr, 0, read));
                        C2115i.m7967a(closeable);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return false;
                    }
                    C2115i.m7967a(closeable);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return false;
                }
                C2115i.m7967a(null);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return false;
            } catch (Exception e) {
                Exception exception2 = e;
                httpURLConnection = httpURLConnection2;
                exception = exception2;
            } catch (Throwable th2) {
                httpURLConnection = httpURLConnection2;
                th = th2;
            }
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = null;
            try {
                if (C2133z.f7482a) {
                    ad.m7931a("HttpDownloader", "failed to download : " + exception.getMessage(), new Object[0]);
                }
                exception.printStackTrace();
                C2115i.m7967a(closeable);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                C2115i.m7967a(closeable);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            C2115i.m7967a(closeable);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public void m8007a(String str, int i) {
        this.f7449d = str;
        this.f7450e = i;
        synchronized (this) {
            this.f7446a = false;
            this.f7448c = false;
        }
        this.f7447b = new Thread(new C2134b(this));
        this.f7447b.start();
    }

    public void m8008a(boolean z) {
        m8012b(z);
    }

    public boolean m8009a(HttpURLConnection httpURLConnection) {
        return !m8013b();
    }

    public boolean m8010a(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if (m8013b()) {
            return false;
        }
        try {
            if (httpURLConnection.getResponseCode() != Constants.COMMAND_HANDSHAKE) {
                return false;
            }
        } catch (IOException e) {
        }
        return true;
    }

    public boolean m8011a(HttpURLConnection httpURLConnection, byte[] bArr, int i, int i2) {
        return !m8013b();
    }

    public final synchronized void m8012b(boolean z) {
        this.f7446a = z;
    }

    public final synchronized boolean m8013b() {
        return this.f7448c;
    }

    public final String m8014c() {
        return this.f7449d;
    }

    public void m8015c(String str) {
        m8007a(str, 10000);
    }
}
