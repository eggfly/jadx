package com.xiaomi.mistatistic.sdk.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.controller.C0565g;
import com.xiaomi.mistatistic.sdk.controller.C0566h;
import com.xiaomi.mistatistic.sdk.data.HttpEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.xiaomi.mistatistic.sdk.network.d */
public class C0615d extends HttpsURLConnection {
    private String f4867a;
    private long f4868b;
    private long f4869c;
    private long f4870d;
    private int f4871e;
    private boolean f4872f;
    private String f4873g;
    private HttpsURLConnection f4874h;

    /* renamed from: com.xiaomi.mistatistic.sdk.network.d.1 */
    class C06141 implements Runnable {
        final /* synthetic */ C0615d f4866a;

        C06141(C0615d c0615d) {
            this.f4866a = c0615d;
        }

        public void run() {
            this.f4866a.m6600d();
        }
    }

    public Principal getPeerPrincipal() {
        try {
            return this.f4874h.getPeerPrincipal();
        } catch (Exception e) {
            m6606a(e);
            throw e;
        }
    }

    public Principal getLocalPrincipal() {
        return this.f4874h.getLocalPrincipal();
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f4874h.setHostnameVerifier(hostnameVerifier);
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f4874h.getHostnameVerifier();
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f4874h.setSSLSocketFactory(sSLSocketFactory);
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.f4874h.getSSLSocketFactory();
    }

    public InputStream getErrorStream() {
        return this.f4874h.getErrorStream();
    }

    public Permission getPermission() {
        try {
            return this.f4874h.getPermission();
        } catch (Exception e) {
            m6606a(e);
            throw e;
        }
    }

    public String getRequestMethod() {
        return this.f4874h.getRequestMethod();
    }

    public int getResponseCode() {
        try {
            m6602f();
            this.f4871e = this.f4874h.getResponseCode();
            m6603g();
            return this.f4871e;
        } catch (Exception e) {
            m6606a(e);
            throw e;
        }
    }

    public String getResponseMessage() {
        try {
            return this.f4874h.getResponseMessage();
        } catch (Exception e) {
            m6606a(e);
            throw e;
        }
    }

    public void setRequestMethod(String str) {
        try {
            this.f4874h.setRequestMethod(str);
        } catch (Exception e) {
            m6606a(e);
            throw e;
        }
    }

    public String getContentEncoding() {
        return this.f4874h.getContentEncoding();
    }

    public boolean getInstanceFollowRedirects() {
        return this.f4874h.getInstanceFollowRedirects();
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f4874h.setInstanceFollowRedirects(z);
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.f4874h.getHeaderFieldDate(str, j);
    }

    public void setFixedLengthStreamingMode(long j) {
        try {
            this.f4874h.getClass().getMethod("setFixedLengthStreamingMode", new Class[]{Long.TYPE}).invoke(this.f4874h, new Object[]{Long.valueOf(j)});
        } catch (Throwable e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f4874h.setFixedLengthStreamingMode(i);
    }

    public void setChunkedStreamingMode(int i) {
        this.f4874h.setChunkedStreamingMode(i);
    }

    public boolean getAllowUserInteraction() {
        return this.f4874h.getAllowUserInteraction();
    }

    public Object getContent() {
        return this.f4874h.getContent();
    }

    public Object getContent(Class[] clsArr) {
        try {
            return this.f4874h.getContent(clsArr);
        } catch (Exception e) {
            m6606a(e);
            throw e;
        }
    }

    public int getContentLength() {
        return this.f4874h.getContentLength();
    }

    public String getContentType() {
        return this.f4874h.getContentType();
    }

    public long getDate() {
        return this.f4874h.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.f4874h.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f4874h.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f4874h.getDoOutput();
    }

    public long getExpiration() {
        return this.f4874h.getExpiration();
    }

    public String getHeaderField(int i) {
        return this.f4874h.getHeaderField(i);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.f4874h.getHeaderFields();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f4874h.getRequestProperties();
    }

    public void addRequestProperty(String str, String str2) {
        this.f4874h.addRequestProperty(str, str2);
    }

    public String getHeaderField(String str) {
        return this.f4874h.getHeaderField(str);
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.f4874h.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        return this.f4874h.getHeaderFieldKey(i);
    }

    public long getIfModifiedSince() {
        return this.f4874h.getIfModifiedSince();
    }

    public InputStream getInputStream() {
        try {
            m6602f();
            InputStream c0616e = new C0616e(this, this.f4874h.getInputStream());
            m6603g();
            m6599c();
            return c0616e;
        } catch (Exception e) {
            m6600d();
            m6606a(e);
            throw e;
        }
    }

    public long getLastModified() {
        return this.f4874h.getLastModified();
    }

    public OutputStream getOutputStream() {
        try {
            m6602f();
            OutputStream c0617f = new C0617f(this, this.f4874h.getOutputStream());
            m6603g();
            m6599c();
            return c0617f;
        } catch (Exception e) {
            m6600d();
            m6606a(e);
            throw e;
        }
    }

    public String getRequestProperty(String str) {
        return this.f4874h.getRequestProperty(str);
    }

    public URL getURL() {
        return this.f4874h.getURL();
    }

    public boolean getUseCaches() {
        return this.f4874h.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f4874h.setAllowUserInteraction(z);
    }

    public void setDefaultUseCaches(boolean z) {
        this.f4874h.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.f4874h.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.f4874h.setDoOutput(z);
    }

    public void setIfModifiedSince(long j) {
        this.f4874h.setIfModifiedSince(j);
    }

    public void setRequestProperty(String str, String str2) {
        if ("x-mistats-header".equals(str)) {
            this.f4867a = str2;
        }
        this.f4874h.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.f4874h.setUseCaches(z);
    }

    public void setConnectTimeout(int i) {
        this.f4874h.setConnectTimeout(i);
    }

    public int getConnectTimeout() {
        return this.f4874h.getConnectTimeout();
    }

    public void setReadTimeout(int i) {
        this.f4874h.setReadTimeout(i);
    }

    public int getReadTimeout() {
        return this.f4874h.getReadTimeout();
    }

    public String toString() {
        return this.f4874h.toString();
    }

    public C0615d(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        this.f4867a = null;
        this.f4871e = -1;
        this.f4872f = false;
        this.f4873g = null;
        this.f4874h = httpsURLConnection;
        this.f4868b = SystemClock.elapsedRealtime();
    }

    public void m6605a(long j) {
        this.f4868b = j;
    }

    public void disconnect() {
        this.f4874h.disconnect();
        m6607b();
    }

    public boolean usingProxy() {
        return this.f4874h.usingProxy();
    }

    public void connect() {
        try {
            this.f4874h.connect();
        } catch (Exception e) {
            m6606a(e);
            throw e;
        }
    }

    public String getCipherSuite() {
        return this.f4874h.getCipherSuite();
    }

    public Certificate[] getLocalCertificates() {
        return this.f4874h.getLocalCertificates();
    }

    public Certificate[] getServerCertificates() {
        try {
            return this.f4874h.getServerCertificates();
        } catch (Exception e) {
            m6606a(e);
            throw e;
        }
    }

    public void m6604a() {
        m6607b();
    }

    public void m6607b() {
        if (!this.f4872f) {
            this.f4872f = true;
            HttpEvent httpEvent = new HttpEvent(getURL().toString(), SystemClock.elapsedRealtime() - this.f4868b, 0, m6601e());
            httpEvent.m6550c(this.f4873g);
            httpEvent.m6545a(this.f4870d);
            httpEvent.m6548b(this.f4867a);
            C0565g.m6398a().m6404a(httpEvent);
        }
    }

    void m6606a(Exception exception) {
        if (!this.f4872f) {
            this.f4872f = true;
            HttpEvent httpEvent = new HttpEvent(getURL().toString(), -1, m6601e(), exception.getClass().getSimpleName());
            httpEvent.m6550c(this.f4873g);
            httpEvent.m6548b(this.f4867a);
            C0565g.m6398a().m6404a(httpEvent);
        }
    }

    private void m6599c() {
        String host = this.url.getHost();
        if (this.f4873g == null && host != null && !m6598a(host)) {
            C0610a.m6580a().execute(new C06141(this));
        }
    }

    private synchronized void m6600d() {
        if (TextUtils.isEmpty(this.f4873g) && !this.f4872f) {
            String host = this.url.getHost();
            if (!(this.f4873g != null || host == null || m6598a(host))) {
                try {
                    this.f4873g = InetAddress.getByName(host).getHostAddress();
                } catch (Throwable e) {
                    C0566h.m6418a("can not get ip exception:", e);
                }
            }
        }
    }

    private boolean m6598a(String str) {
        if (C0611b.m6581a(str) || C0611b.m6584d(str)) {
            return true;
        }
        return false;
    }

    private int m6601e() {
        int i = -1;
        if (this.f4871e != i) {
            return this.f4871e;
        }
        try {
            return this.f4874h.getResponseCode();
        } catch (Exception e) {
            return i;
        }
    }

    private synchronized void m6602f() {
        if (this.f4869c == 0) {
            this.f4869c = SystemClock.elapsedRealtime();
            this.f4868b = this.f4869c;
        }
    }

    private synchronized void m6603g() {
        if (this.f4870d == 0 && this.f4869c != 0) {
            this.f4870d = SystemClock.elapsedRealtime() - this.f4869c;
        }
    }
}
