package com.cmcm.p074a.p075a.p115d;

import com.cmcm.p074a.p075a.p112a.C2115i;
import com.cmcm.p074a.p075a.p112a.C2133z;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import org.apache.http.entity.mime.MIME;

/* renamed from: com.cmcm.a.a.d.q */
class C2176q implements Runnable {
    final /* synthetic */ File f7558a;
    final /* synthetic */ String f7559b;
    final /* synthetic */ C2178x f7560c;
    final /* synthetic */ C2169j f7561d;

    C2176q(C2169j c2169j, File file, String str, C2178x c2178x) {
        this.f7561d = c2169j;
        this.f7558a = file;
        this.f7559b = str;
        this.f7560c = c2178x;
    }

    public void run() {
        Closeable fileInputStream;
        Exception e;
        HttpURLConnection httpURLConnection;
        Closeable closeable;
        Throwable th;
        HttpURLConnection httpURLConnection2 = null;
        boolean z = true;
        if (C2133z.f7482a) {
            C2169j.m8181b("begin", new Object[0]);
        }
        try {
            HttpURLConnection httpURLConnection3;
            fileInputStream = new FileInputStream(this.f7558a);
            try {
                httpURLConnection3 = (HttpURLConnection) new URL(this.f7559b).openConnection();
            } catch (Exception e2) {
                e = e2;
                httpURLConnection = null;
                closeable = fileInputStream;
                try {
                    if (C2133z.f7482a) {
                        C2169j.m8181b(e.getMessage(), new Object[0]);
                    }
                    C2115i.m7967a(closeable);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        z = false;
                    } else {
                        z = false;
                    }
                    if (C2133z.f7482a) {
                        C2169j.m8181b("end", new Object[0]);
                    }
                    this.f7561d.f7539d.post(new C2177r(this, z));
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = closeable;
                    httpURLConnection2 = httpURLConnection;
                    C2115i.m7967a(fileInputStream);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                C2115i.m7967a(fileInputStream);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
            try {
                httpURLConnection3.setConnectTimeout(10000);
                int length = (int) this.f7558a.length();
                if (C2133z.f7482a) {
                    C2169j.m8181b("Send File Size : %d", Integer.valueOf(length));
                }
                httpURLConnection3.setFixedLengthStreamingMode(length);
                httpURLConnection3.setRequestProperty(HttpRequest.f14554g, "identity");
                httpURLConnection3.setRequestProperty(MIME.CONTENT_TYPE, HttpRequest.f14550c);
                httpURLConnection3.setRequestProperty(HttpRequest.f14557j, HttpRequest.f14551d);
                httpURLConnection3.setRequestMethod(SpdyRequest.POST_METHOD);
                httpURLConnection3.setDoOutput(true);
                httpURLConnection3.connect();
                byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
                OutputStream outputStream = httpURLConnection3.getOutputStream();
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                outputStream.flush();
                length = httpURLConnection3.getResponseCode();
                if (C2133z.f7482a) {
                    C2169j.m8181b("Http Response Code : %d", Integer.valueOf(length));
                }
                if (!(length == Constants.COMMAND_HANDSHAKE || length == 202)) {
                    z = false;
                }
                C2115i.m7967a(fileInputStream);
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
            } catch (Exception e3) {
                closeable = fileInputStream;
                HttpURLConnection httpURLConnection4 = httpURLConnection3;
                e = e3;
                httpURLConnection = httpURLConnection4;
                if (C2133z.f7482a) {
                    C2169j.m8181b(e.getMessage(), new Object[0]);
                }
                C2115i.m7967a(closeable);
                if (httpURLConnection != null) {
                    z = false;
                } else {
                    httpURLConnection.disconnect();
                    z = false;
                }
                if (C2133z.f7482a) {
                    C2169j.m8181b("end", new Object[0]);
                }
                this.f7561d.f7539d.post(new C2177r(this, z));
            } catch (Throwable th4) {
                httpURLConnection2 = httpURLConnection3;
                th = th4;
                C2115i.m7967a(fileInputStream);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            httpURLConnection = null;
            if (C2133z.f7482a) {
                C2169j.m8181b(e.getMessage(), new Object[0]);
            }
            C2115i.m7967a(closeable);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                z = false;
            } else {
                z = false;
            }
            if (C2133z.f7482a) {
                C2169j.m8181b("end", new Object[0]);
            }
            this.f7561d.f7539d.post(new C2177r(this, z));
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            C2115i.m7967a(fileInputStream);
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        if (C2133z.f7482a) {
            C2169j.m8181b("end", new Object[0]);
        }
        this.f7561d.f7539d.post(new C2177r(this, z));
    }
}
