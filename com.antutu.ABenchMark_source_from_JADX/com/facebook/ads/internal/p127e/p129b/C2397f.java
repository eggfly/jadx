package com.facebook.ads.internal.p127e.p129b;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.ads.internal.p127e.p129b.p130a.C2375a;
import com.facebook.ads.internal.p127e.p129b.p130a.C2378c;
import com.facebook.ads.internal.p127e.p129b.p130a.C2384f;
import com.facebook.ads.internal.p127e.p129b.p130a.C2385g;
import com.taobao.accs.ErrorCode;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.e.b.f */
public class C2397f {
    private final Object f8307a;
    private final ExecutorService f8308b;
    private final Map<String, C2399g> f8309c;
    private final ServerSocket f8310d;
    private final int f8311e;
    private final Thread f8312f;
    private final C2387c f8313g;
    private boolean f8314h;

    /* renamed from: com.facebook.ads.internal.e.b.f.a */
    public static final class C2392a {
        private File f8297a;
        private C2378c f8298b;
        private C2375a f8299c;

        public C2392a(Context context) {
            this.f8297a = C2408o.m9259a(context);
            this.f8299c = new C2385g(54525952);
            this.f8298b = new C2384f();
        }

        private C2387c m9204a() {
            return new C2387c(this.f8297a, this.f8298b, this.f8299c);
        }
    }

    /* renamed from: com.facebook.ads.internal.e.b.f.b */
    private class C2393b implements Callable<Boolean> {
        final /* synthetic */ C2397f f8300a;

        private C2393b(C2397f c2397f) {
            this.f8300a = c2397f;
        }

        public Boolean m9206a() {
            return Boolean.valueOf(this.f8300a.m9217c());
        }

        public /* synthetic */ Object call() {
            return m9206a();
        }
    }

    /* renamed from: com.facebook.ads.internal.e.b.f.c */
    private class C2394c implements Callable<Boolean> {
        final /* synthetic */ C2397f f8301a;
        private final String f8302b;

        public C2394c(C2397f c2397f, String str) {
            this.f8301a = c2397f;
            this.f8302b = str;
        }

        public Boolean m9207a() {
            return Boolean.valueOf(this.f8301a.m9218c(this.f8302b));
        }

        public /* synthetic */ Object call() {
            return m9207a();
        }
    }

    /* renamed from: com.facebook.ads.internal.e.b.f.d */
    private final class C2395d implements Runnable {
        final /* synthetic */ C2397f f8303a;
        private final Socket f8304b;

        public C2395d(C2397f c2397f, Socket socket) {
            this.f8303a = c2397f;
            this.f8304b = socket;
        }

        public void run() {
            this.f8303a.m9211a(this.f8304b);
        }
    }

    /* renamed from: com.facebook.ads.internal.e.b.f.e */
    private final class C2396e implements Runnable {
        final /* synthetic */ C2397f f8305a;
        private final CountDownLatch f8306b;

        public C2396e(C2397f c2397f, CountDownLatch countDownLatch) {
            this.f8305a = c2397f;
            this.f8306b = countDownLatch;
        }

        public void run() {
            this.f8306b.countDown();
            this.f8305a.m9223e();
        }
    }

    public C2397f(Context context) {
        this(new C2392a(context).m9204a());
    }

    private C2397f(C2387c c2387c) {
        Throwable e;
        this.f8307a = new Object();
        this.f8308b = Executors.newFixedThreadPool(8);
        this.f8309c = new ConcurrentHashMap();
        this.f8313g = (C2387c) C2404j.m9249a(c2387c);
        try {
            this.f8310d = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f8311e = this.f8310d.getLocalPort();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f8312f = new Thread(new C2396e(this, countDownLatch));
            this.f8312f.start();
            countDownLatch.await();
            Log.i("ProxyCache", "Proxy cache server started. Ping it...");
            m9213b();
        } catch (IOException e2) {
            e = e2;
            this.f8308b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        } catch (InterruptedException e3) {
            e = e3;
            this.f8308b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private void m9210a(Throwable th) {
        Log.e("ProxyCache", "HttpProxyCacheServer error", th);
    }

    private void m9211a(Socket socket) {
        Throwable e;
        try {
            C2388d a = C2388d.m9181a(socket.getInputStream());
            Log.i("ProxyCache", "Request to cache proxy:" + a);
            String c = C2407m.m9257c(a.f8283a);
            if ("ping".equals(c)) {
                m9214b(socket);
            } else {
                m9222e(c).m9235a(a, socket);
            }
            m9216c(socket);
            Log.d("ProxyCache", "Opened connections: " + m9225f());
        } catch (SocketException e2) {
            Log.d("ProxyCache", "Closing socket... Socket is closed by client.");
            m9216c(socket);
            Log.d("ProxyCache", "Opened connections: " + m9225f());
        } catch (C2402l e3) {
            e = e3;
            m9210a(new C2402l("Error processing request", e));
            m9216c(socket);
            Log.d("ProxyCache", "Opened connections: " + m9225f());
        } catch (IOException e4) {
            e = e4;
            m9210a(new C2402l("Error processing request", e));
            m9216c(socket);
            Log.d("ProxyCache", "Opened connections: " + m9225f());
        } catch (Throwable th) {
            m9216c(socket);
            Log.d("ProxyCache", "Opened connections: " + m9225f());
        }
    }

    private void m9213b() {
        int i = ErrorCode.APP_NOT_BIND;
        int i2 = 0;
        while (i2 < 3) {
            try {
                this.f8314h = ((Boolean) this.f8308b.submit(new C2393b()).get((long) i, TimeUnit.MILLISECONDS)).booleanValue();
                if (!this.f8314h) {
                    SystemClock.sleep((long) i);
                    i *= 2;
                    i2++;
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Throwable e2 = e;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            } catch (ExecutionException e3) {
                e2 = e3;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            } catch (TimeoutException e4) {
                e2 = e4;
                Log.e("ProxyCache", "Error pinging server [attempt: " + i2 + ", timeout: " + i + "]. ", e2);
                i *= 2;
                i2++;
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error pinging server [attempts: " + i2 + ", max timeout: " + (i / 2) + "].");
        m9227a();
    }

    private void m9214b(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }

    private void m9216c(Socket socket) {
        m9221d(socket);
        m9224e(socket);
        m9226f(socket);
    }

    private boolean m9217c() {
        C2401h c2401h = new C2401h(m9219d("ping"));
        boolean equals;
        try {
            byte[] bytes = "ping ok".getBytes();
            c2401h.m9246a(0);
            byte[] bArr = new byte[bytes.length];
            c2401h.m9245a(bArr);
            equals = Arrays.equals(bytes, bArr);
            Log.d("ProxyCache", "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
            return equals;
        } catch (C2402l e) {
            equals = e;
            Log.e("ProxyCache", "Error reading ping response", equals);
            return false;
        } finally {
            c2401h.m9247b();
        }
    }

    private boolean m9218c(String str) {
        C2401h c2401h = new C2401h(m9219d(str));
        try {
            c2401h.m9246a(0);
            while (true) {
                if (c2401h.m9245a(new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE]) == -1) {
                    break;
                }
            }
            return true;
        } catch (Throwable e) {
            Log.e("ProxyCache", "Error reading url", e);
            return false;
        } finally {
            c2401h.m9247b();
        }
    }

    private String m9219d(String str) {
        return String.format("http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(this.f8311e), C2407m.m9256b(str)});
    }

    private void m9220d() {
        synchronized (this.f8307a) {
            for (C2399g a : this.f8309c.values()) {
                a.m9234a();
            }
            this.f8309c.clear();
        }
    }

    private void m9221d(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException e) {
            Log.d("ProxyCache", "Releasing input stream... Socket is closed by client.");
        } catch (Throwable e2) {
            m9210a(new C2402l("Error closing socket input stream", e2));
        }
    }

    private C2399g m9222e(String str) {
        C2399g c2399g;
        synchronized (this.f8307a) {
            c2399g = (C2399g) this.f8309c.get(str);
            if (c2399g == null) {
                c2399g = new C2399g(str, this.f8313g);
                this.f8309c.put(str, c2399g);
            }
        }
        return c2399g;
    }

    private void m9223e() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f8310d.accept();
                Log.d("ProxyCache", "Accept new socket " + accept);
                this.f8308b.submit(new C2395d(this, accept));
            } catch (Throwable e) {
                m9210a(new C2402l("Error during waiting connection", e));
                return;
            }
        }
    }

    private void m9224e(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (Throwable e) {
            m9210a(new C2402l("Error closing socket output stream", e));
        }
    }

    private int m9225f() {
        int i;
        synchronized (this.f8307a) {
            i = 0;
            for (C2399g b : this.f8309c.values()) {
                i = b.m9236b() + i;
            }
        }
        return i;
    }

    private void m9226f(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (Throwable e) {
            m9210a(new C2402l("Error closing socket", e));
        }
    }

    public void m9227a() {
        Log.i("ProxyCache", "Shutdown proxy server");
        m9220d();
        this.f8312f.interrupt();
        try {
            if (!this.f8310d.isClosed()) {
                this.f8310d.close();
            }
        } catch (Throwable e) {
            m9210a(new C2402l("Error shutting down proxy server", e));
        }
    }

    public void m9228a(String str) {
        int i = ErrorCode.APP_NOT_BIND;
        int i2 = 0;
        while (i2 < 3) {
            try {
                if (!((Boolean) this.f8308b.submit(new C2394c(this, str)).get()).booleanValue()) {
                    SystemClock.sleep((long) i);
                    i *= 2;
                    i2++;
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Throwable e2 = e;
                Log.e("ProxyCache", "Error precaching url [attempt: " + i2 + ", url: " + str + "]. ", e2);
                i *= 2;
                i2++;
            } catch (ExecutionException e3) {
                e2 = e3;
                Log.e("ProxyCache", "Error precaching url [attempt: " + i2 + ", url: " + str + "]. ", e2);
                i *= 2;
                i2++;
            }
        }
        Log.e("ProxyCache", "Shutdown server... Error precaching url [attempts: " + i2 + ", url: " + str + "].");
        m9227a();
    }

    public String m9229b(String str) {
        if (!this.f8314h) {
            Log.e("ProxyCache", "Proxy server isn't pinged. Caching doesn't work.");
        }
        return this.f8314h ? m9219d(str) : str;
    }
}
