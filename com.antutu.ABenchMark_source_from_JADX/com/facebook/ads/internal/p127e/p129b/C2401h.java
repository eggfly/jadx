package com.facebook.ads.internal.p127e.p129b;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.util.HttpConstant;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.e.b.h */
public class C2401h implements C2400n {
    public final String f8323a;
    private HttpURLConnection f8324b;
    private InputStream f8325c;
    private volatile int f8326d;
    private volatile String f8327e;

    public C2401h(C2401h c2401h) {
        this.f8326d = LinearLayoutManager.INVALID_OFFSET;
        this.f8323a = c2401h.f8323a;
        this.f8327e = c2401h.f8327e;
        this.f8326d = c2401h.f8326d;
    }

    public C2401h(String str) {
        this(str, C2407m.m9252a(str));
    }

    public C2401h(String str, String str2) {
        this.f8326d = LinearLayoutManager.INVALID_OFFSET;
        this.f8323a = (String) C2404j.m9249a(str);
        this.f8327e = str2;
    }

    private int m9241a(HttpURLConnection httpURLConnection, int i, int i2) {
        int contentLength = httpURLConnection.getContentLength();
        return i2 == Constants.COMMAND_HANDSHAKE ? contentLength : i2 == HttpConstant.SC_PARTIAL_CONTENT ? contentLength + i : this.f8326d;
    }

    private HttpURLConnection m9242a(int i, int i2) {
        HttpURLConnection httpURLConnection;
        String str = this.f8323a;
        int i3 = 0;
        Object obj;
        do {
            Log.d("ProxyCache", "Open connection " + (i > 0 ? " with offset " + i : BuildConfig.FLAVOR) + " to " + str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + i + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            obj = (responseCode == Constants.COMMAND_STOP_FOR_ELECTION || responseCode == ErrorCode.DM_DEVICEID_INVALID || responseCode == ErrorCode.DM_APPKEY_INVALID) ? 1 : null;
            if (obj != null) {
                str = httpURLConnection.getHeaderField(HttpRequest.f14565r);
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new C2402l("Too many redirects: " + i3);
            }
        } while (obj != null);
        return httpURLConnection;
    }

    private void m9243d() {
        Throwable e;
        Closeable closeable = null;
        Log.d("ProxyCache", "Read content info from " + this.f8323a);
        HttpURLConnection a;
        try {
            a = m9242a(0, 10000);
            try {
                this.f8326d = a.getContentLength();
                this.f8327e = a.getContentType();
                closeable = a.getInputStream();
                Log.i("ProxyCache", "Content info for `" + this.f8323a + "`: mime: " + this.f8327e + ", content-length: " + this.f8326d);
                C2407m.m9254a(closeable);
                if (a != null) {
                    a.disconnect();
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    Log.e("ProxyCache", "Error fetching info from " + this.f8323a, e);
                    C2407m.m9254a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                } catch (Throwable th) {
                    e = th;
                    C2407m.m9254a(closeable);
                    if (a != null) {
                        a.disconnect();
                    }
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            a = null;
            Log.e("ProxyCache", "Error fetching info from " + this.f8323a, e);
            C2407m.m9254a(closeable);
            if (a != null) {
                a.disconnect();
            }
        } catch (Throwable th2) {
            e = th2;
            a = null;
            C2407m.m9254a(closeable);
            if (a != null) {
                a.disconnect();
            }
            throw e;
        }
    }

    public synchronized int m9244a() {
        if (this.f8326d == LinearLayoutManager.INVALID_OFFSET) {
            m9243d();
        }
        return this.f8326d;
    }

    public int m9245a(byte[] bArr) {
        if (this.f8325c == null) {
            throw new C2402l("Error reading data from " + this.f8323a + ": connection is absent!");
        }
        try {
            return this.f8325c.read(bArr, 0, bArr.length);
        } catch (Throwable e) {
            throw new C2403i("Reading source " + this.f8323a + " is interrupted", e);
        } catch (Throwable e2) {
            throw new C2402l("Error reading data from " + this.f8323a, e2);
        }
    }

    public void m9246a(int i) {
        try {
            this.f8324b = m9242a(i, -1);
            this.f8327e = this.f8324b.getContentType();
            this.f8325c = new BufferedInputStream(this.f8324b.getInputStream(), SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            this.f8326d = m9241a(this.f8324b, i, this.f8324b.getResponseCode());
        } catch (Throwable e) {
            throw new C2402l("Error opening connection for " + this.f8323a + " with offset " + i, e);
        }
    }

    public void m9247b() {
        if (this.f8324b != null) {
            try {
                this.f8324b.disconnect();
            } catch (Throwable e) {
                throw new C2402l("Error disconnecting HttpUrlConnection", e);
            }
        }
    }

    public synchronized String m9248c() {
        if (TextUtils.isEmpty(this.f8327e)) {
            m9243d();
        }
        return this.f8327e;
    }

    public String toString() {
        return "HttpUrlSource{url='" + this.f8323a + "}";
    }
}
