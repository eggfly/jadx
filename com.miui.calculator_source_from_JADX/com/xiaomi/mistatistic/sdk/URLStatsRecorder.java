package com.xiaomi.mistatistic.sdk;

import android.os.Build.VERSION;
import android.os.SystemClock;
import com.xiaomi.mistatistic.sdk.controller.C0565g;
import com.xiaomi.mistatistic.sdk.controller.C0566h;
import com.xiaomi.mistatistic.sdk.data.HttpEvent;
import com.xiaomi.mistatistic.sdk.network.C0613c;
import com.xiaomi.mistatistic.sdk.network.C0615d;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class URLStatsRecorder {
    private static final Map<String, URLStreamHandler> f4655a;
    private static final List<String> f4656b;
    private static final List<String> f4657c;
    private static final List<String> f4658d;
    private static final List<String> f4659e;
    private static Boolean f4660f;

    /* renamed from: com.xiaomi.mistatistic.sdk.URLStatsRecorder.1 */
    final class C05271 implements URLStreamHandlerFactory {
        C05271() {
        }

        public URLStreamHandler createURLStreamHandler(String str) {
            if (URLStatsRecorder.f4655a.containsKey(str)) {
                return new C0528a((URLStreamHandler) URLStatsRecorder.f4655a.get(str));
            }
            return null;
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.URLStatsRecorder.a */
    static class C0528a extends URLStreamHandler {
        private URLStreamHandler f4654a;

        public C0528a(URLStreamHandler uRLStreamHandler) {
            this.f4654a = uRLStreamHandler;
        }

        protected URLConnection openConnection(URL url) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Method declaredMethod = URLStreamHandler.class.getDeclaredMethod("openConnection", new Class[]{URL.class});
                declaredMethod.setAccessible(true);
                URLConnection uRLConnection = (URLConnection) declaredMethod.invoke(this.f4654a, new Object[]{url});
                URLConnection c0615d;
                if (uRLConnection instanceof HttpsURLConnection) {
                    c0615d = new C0615d((HttpsURLConnection) uRLConnection);
                    c0615d.m6605a(elapsedRealtime);
                    return c0615d;
                } else if (!(uRLConnection instanceof HttpURLConnection)) {
                    return uRLConnection;
                } else {
                    c0615d = new C0613c((HttpURLConnection) uRLConnection);
                    c0615d.m6594a(elapsedRealtime);
                    return c0615d;
                }
            } catch (Exception e) {
                C0565g.m6398a().m6404a(new HttpEvent(url.toString(), e.getClass().getSimpleName()));
                throw new IOException();
            }
        }

        protected URLConnection openConnection(URL url, Proxy proxy) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Method declaredMethod = URLStreamHandler.class.getDeclaredMethod("openConnection", new Class[]{URL.class, Proxy.class});
                declaredMethod.setAccessible(true);
                URLConnection uRLConnection = (URLConnection) declaredMethod.invoke(this.f4654a, new Object[]{url, proxy});
                URLConnection c0615d;
                if (uRLConnection instanceof HttpsURLConnection) {
                    c0615d = new C0615d((HttpsURLConnection) uRLConnection);
                    c0615d.m6605a(elapsedRealtime);
                    return c0615d;
                } else if (!(uRLConnection instanceof HttpURLConnection)) {
                    return uRLConnection;
                } else {
                    c0615d = new C0613c((HttpURLConnection) uRLConnection);
                    c0615d.m6594a(elapsedRealtime);
                    return c0615d;
                }
            } catch (Exception e) {
                C0565g.m6398a().m6404a(new HttpEvent(url.toString(), e.getClass().getSimpleName()));
                throw new IOException();
            }
        }
    }

    static {
        f4655a = new HashMap();
        f4656b = new ArrayList();
        f4657c = new ArrayList();
        f4658d = new ArrayList();
        f4659e = new ArrayList();
        f4660f = null;
        f4656b.add("file");
        f4656b.add("ftp");
        f4656b.add("http");
        f4656b.add("https");
        f4656b.add("jar");
        f4657c.add("http");
    }

    public static boolean m6275a() {
        if (f4660f != null) {
            return f4660f.booleanValue();
        }
        try {
            Field declaredField;
            for (String url : f4656b) {
                URL url2 = new URL(url, "www.xiaomi.com", "");
            }
            if (VERSION.SDK_INT >= 24) {
                declaredField = URL.class.getDeclaredField("handlers");
            } else {
                declaredField = URL.class.getDeclaredField("streamHandlers");
            }
            declaredField.setAccessible(true);
            Hashtable hashtable = (Hashtable) declaredField.get(null);
            for (String str : f4656b) {
                f4655a.put(str, (URLStreamHandler) hashtable.get(str));
            }
            URL.setURLStreamHandlerFactory(new C05271());
            f4660f = Boolean.valueOf(true);
        } catch (Throwable th) {
            f4660f = Boolean.valueOf(false);
            C0566h.m6418a("failed to enable url interceptor", th);
        }
        return f4660f.booleanValue();
    }
}
