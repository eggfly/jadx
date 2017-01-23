package com.xiaomi.mistatistic.sdk.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.controller.C0565g;
import com.xiaomi.mistatistic.sdk.controller.C0566h;
import com.xiaomi.mistatistic.sdk.data.HttpEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.mistatistic.sdk.network.c */
public class C0613c extends HttpURLConnection {
    private String f4856a;
    private long f4857b;
    private long f4858c;
    private long f4859d;
    private int f4860e;
    private boolean f4861f;
    private String f4862g;
    private C0617f f4863h;
    private C0616e f4864i;
    private HttpURLConnection f4865j;

    /* renamed from: com.xiaomi.mistatistic.sdk.network.c.1 */
    class C06121 implements Runnable {
        final /* synthetic */ C0613c f4855a;

        C06121(C0613c c0613c) {
            this.f4855a = c0613c;
        }

        public void run() {
            this.f4855a.m6589e();
        }
    }

    public InputStream getErrorStream() {
        return this.f4865j.getErrorStream();
    }

    public Permission getPermission() {
        try {
            return this.f4865j.getPermission();
        } catch (Exception e) {
            m6595a(e);
            throw e;
        }
    }

    public String getRequestMethod() {
        return this.f4865j.getRequestMethod();
    }

    public int getResponseCode() {
        try {
            m6591g();
            this.f4860e = this.f4865j.getResponseCode();
            m6592h();
            return this.f4860e;
        } catch (Exception e) {
            m6595a(e);
            throw e;
        }
    }

    public String getResponseMessage() {
        try {
            return this.f4865j.getResponseMessage();
        } catch (Exception e) {
            m6595a(e);
            throw e;
        }
    }

    public void setRequestMethod(String str) {
        try {
            this.f4865j.setRequestMethod(str);
        } catch (Exception e) {
            m6595a(e);
            throw e;
        }
    }

    public String getContentEncoding() {
        return this.f4865j.getContentEncoding();
    }

    public boolean getInstanceFollowRedirects() {
        return this.f4865j.getInstanceFollowRedirects();
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f4865j.setInstanceFollowRedirects(z);
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.f4865j.getHeaderFieldDate(str, j);
    }

    public void setFixedLengthStreamingMode(long j) {
        try {
            this.f4865j.getClass().getDeclaredMethod("setFixedLengthStreamingMode", new Class[]{Long.TYPE}).invoke(this.f4865j, new Object[]{Long.valueOf(j)});
        } catch (Throwable e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f4865j.setFixedLengthStreamingMode(i);
    }

    public void setChunkedStreamingMode(int i) {
        this.f4865j.setChunkedStreamingMode(i);
    }

    public boolean getAllowUserInteraction() {
        return this.f4865j.getAllowUserInteraction();
    }

    public Object getContent() {
        try {
            return this.f4865j.getContent();
        } catch (Exception e) {
            m6595a(e);
            throw e;
        }
    }

    public Object getContent(Class[] clsArr) {
        try {
            return this.f4865j.getContent(clsArr);
        } catch (Exception e) {
            m6595a(e);
            throw e;
        }
    }

    public int getContentLength() {
        return this.f4865j.getContentLength();
    }

    public String getContentType() {
        return this.f4865j.getContentType();
    }

    public long getDate() {
        return this.f4865j.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.f4865j.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f4865j.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f4865j.getDoOutput();
    }

    public long getExpiration() {
        return this.f4865j.getExpiration();
    }

    public String getHeaderField(int i) {
        return this.f4865j.getHeaderField(i);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.f4865j.getHeaderFields();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f4865j.getRequestProperties();
    }

    public void addRequestProperty(String str, String str2) {
        this.f4865j.addRequestProperty(str, str2);
    }

    public String getHeaderField(String str) {
        return this.f4865j.getHeaderField(str);
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.f4865j.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        return this.f4865j.getHeaderFieldKey(i);
    }

    public long getIfModifiedSince() {
        return this.f4865j.getIfModifiedSince();
    }

    public InputStream getInputStream() {
        try {
            m6591g();
            this.f4864i = new C0616e(this, this.f4865j.getInputStream());
            m6592h();
            m6588d();
            return this.f4864i;
        } catch (Exception e) {
            m6589e();
            m6595a(e);
            throw e;
        }
    }

    public long getLastModified() {
        return this.f4865j.getLastModified();
    }

    public OutputStream getOutputStream() {
        try {
            m6591g();
            this.f4863h = new C0617f(this, this.f4865j.getOutputStream());
            m6592h();
            m6588d();
            return this.f4863h;
        } catch (Exception e) {
            m6589e();
            m6595a(e);
            throw e;
        }
    }

    public String getRequestProperty(String str) {
        return this.f4865j.getRequestProperty(str);
    }

    public URL getURL() {
        return this.f4865j.getURL();
    }

    public boolean getUseCaches() {
        return this.f4865j.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f4865j.setAllowUserInteraction(z);
    }

    public void setDefaultUseCaches(boolean z) {
        this.f4865j.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.f4865j.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.f4865j.setDoOutput(z);
    }

    public void setIfModifiedSince(long j) {
        this.f4865j.setIfModifiedSince(j);
    }

    public void setRequestProperty(String str, String str2) {
        if ("x-mistats-header".equals(str)) {
            this.f4856a = str2;
        }
        this.f4865j.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.f4865j.setUseCaches(z);
    }

    public void setConnectTimeout(int i) {
        this.f4865j.setConnectTimeout(i);
    }

    public int getConnectTimeout() {
        return this.f4865j.getConnectTimeout();
    }

    public void setReadTimeout(int i) {
        this.f4865j.setReadTimeout(i);
    }

    public int getReadTimeout() {
        return this.f4865j.getReadTimeout();
    }

    public String toString() {
        return this.f4865j.toString();
    }

    public C0613c(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.f4856a = null;
        this.f4860e = -1;
        this.f4861f = false;
        this.f4862g = null;
        this.f4857b = SystemClock.elapsedRealtime();
        this.f4865j = httpURLConnection;
    }

    public void m6594a(long j) {
        this.f4857b = j;
    }

    public void disconnect() {
        this.f4865j.disconnect();
        m6596b();
    }

    public boolean usingProxy() {
        return this.f4865j.usingProxy();
    }

    public void connect() {
        try {
            this.f4865j.connect();
        } catch (Exception e) {
            m6595a(e);
            throw e;
        }
    }

    public void m6593a() {
        m6596b();
    }

    void m6596b() {
        if (!this.f4861f) {
            this.f4861f = true;
            HttpEvent httpEvent = new HttpEvent(getURL().toString(), SystemClock.elapsedRealtime() - this.f4857b, (long) m6587c(), m6590f());
            httpEvent.m6550c(this.f4862g);
            httpEvent.m6545a(this.f4859d);
            httpEvent.m6548b(this.f4856a);
            C0565g.m6398a().m6404a(httpEvent);
        }
    }

    private int m6587c() {
        int a;
        int i = 0;
        if (this.f4864i != null) {
            a = this.f4864i.m6609a();
        } else {
            a = 0;
        }
        if (this.f4863h != null) {
            i = this.f4863h.m6611a();
        }
        return ((a + 1100) + i) + getURL().toString().getBytes().length;
    }

    void m6595a(Exception exception) {
        if (!this.f4861f) {
            this.f4861f = true;
            HttpEvent httpEvent = new HttpEvent(getURL().toString(), -1, m6590f(), exception.getClass().getSimpleName());
            httpEvent.m6550c(this.f4862g);
            httpEvent.m6548b(this.f4856a);
            C0565g.m6398a().m6404a(httpEvent);
        }
    }

    private void m6588d() {
        String host = this.url.getHost();
        if (this.f4862g == null && host != null && !m6586a(host)) {
            C0610a.m6580a().execute(new C06121(this));
        }
    }

    private synchronized void m6589e() {
        if (TextUtils.isEmpty(this.f4862g) && !this.f4861f) {
            String host = this.url.getHost();
            if (!(this.f4862g != null || host == null || m6586a(host))) {
                try {
                    this.f4862g = InetAddress.getByName(host).getHostAddress();
                } catch (Exception e) {
                    C0566h.m6426d("MHC", "can not get ip exception: " + e.getMessage());
                }
            }
        }
    }

    private boolean m6586a(String str) {
        if (C0611b.m6581a(str) || C0611b.m6584d(str)) {
            return true;
        }
        return false;
    }

    private int m6590f() {
        int i = -1;
        if (this.f4860e != i) {
            return this.f4860e;
        }
        try {
            return this.f4865j.getResponseCode();
        } catch (Exception e) {
            return i;
        }
    }

    private synchronized void m6591g() {
        if (this.f4858c == 0) {
            this.f4858c = SystemClock.elapsedRealtime();
            this.f4857b = this.f4858c;
        }
    }

    private synchronized void m6592h() {
        if (this.f4859d == 0 && this.f4858c != 0) {
            this.f4859d = SystemClock.elapsedRealtime() - this.f4858c;
        }
    }
}
