package com.xiaomi.push.service.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.common.Constants;
import com.xiaomi.channel.commonutils.android.C4290b;
import com.xiaomi.channel.commonutils.android.C4292d;
import com.xiaomi.channel.commonutils.file.C4298a;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.misc.C4315i;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.channel.commonutils.string.C4329d;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.service.C4445v;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.xmpush.thrift.C4518b;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.spdy.SpdyRequest;

/* renamed from: com.xiaomi.push.service.module.c */
public class C4429c {
    private static C4429c f15117a;
    private Map<String, C4426b> f15118b;
    private List<C4428b> f15119c;
    private Context f15120d;
    private SharedPreferences f15121e;
    private boolean f15122f;

    /* renamed from: com.xiaomi.push.service.module.c.a */
    private static class C4427a implements Runnable {
        private String f15111a;
        private String f15112b;
        private String f15113c;
        private boolean f15114d;
        private Context f15115e;
        private boolean f15116f;

        public C4427a(Context context, String str, String str2, String str3, boolean z) {
            this.f15111a = null;
            this.f15112b = null;
            this.f15116f = false;
            this.f15111a = str;
            this.f15112b = str2;
            this.f15113c = str3;
            this.f15114d = z;
            this.f15115e = context.getApplicationContext();
        }

        public void run() {
            Exception e;
            Throwable th;
            OutputStream outputStream = null;
            if (C4321d.m17711f(this.f15115e)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f15111a).openConnection();
                    httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
                    httpURLConnection.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == Constants.COMMAND_HANDSHAKE) {
                        byte[] b = C4298a.m17637b(httpURLConnection.getInputStream());
                        if (!TextUtils.isEmpty(this.f15112b)) {
                            if (!this.f15112b.equalsIgnoreCase(C4329d.m17745a(b))) {
                                b = null;
                            }
                        }
                        if (b != null) {
                            C4302b.m17652b("download apk success.");
                            try {
                                File file = new File(this.f15113c + ".tmp");
                                file.delete();
                                OutputStream fileOutputStream = new FileOutputStream(file);
                                try {
                                    fileOutputStream.write(b);
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    if (C4292d.m17606a(C4290b.m17603e(this.f15115e, file.getPath()))) {
                                        C4302b.m17652b("verify signature success");
                                        file.renameTo(new File(this.f15113c));
                                        this.f15116f = true;
                                        if (this.f15114d && !C4290b.m17600b(this.f15115e)) {
                                            Process.killProcess(Process.myPid());
                                        }
                                    } else {
                                        C4302b.m17654d("verify signature failed");
                                        file.delete();
                                    }
                                    C4298a.m17633a(null);
                                } catch (Exception e2) {
                                    e = e2;
                                    outputStream = fileOutputStream;
                                    try {
                                        e.printStackTrace();
                                        C4298a.m17633a(outputStream);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        C4298a.m17633a(outputStream);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    outputStream = fileOutputStream;
                                    C4298a.m17633a(outputStream);
                                    throw th;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                C4298a.m17633a(outputStream);
                            }
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.module.c.b */
    public interface C4428b {
        void m18305a(C4431e c4431e);
    }

    static {
        f15117a = null;
    }

    private C4429c(Context context) {
        this.f15118b = new HashMap();
        this.f15119c = new ArrayList();
        this.f15120d = context.getApplicationContext();
        this.f15121e = this.f15120d.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    private C4426b m18306a(C4425a c4425a, DexClassLoader dexClassLoader) {
        if (dexClassLoader == null) {
            return null;
        }
        return new C4426b(c4425a.m18300e(), c4425a.m18301f(), dexClassLoader, c4425a.m18297b(), c4425a.m18296a());
    }

    public static synchronized C4429c m18307a(Context context) {
        C4429c c4429c;
        synchronized (C4429c.class) {
            if (f15117a == null) {
                f15117a = new C4429c(context);
            }
            c4429c = f15117a;
        }
        return c4429c;
    }

    private void m18308a(C4430d c4430d, int i) {
        this.f15121e.edit().putInt("plugin_version_" + c4430d.f15125b, i).commit();
    }

    private synchronized void m18309a(C4431e c4431e) {
        for (C4428b a : this.f15119c) {
            a.m18305a(c4431e);
        }
    }

    private int m18310b(C4430d c4430d) {
        return this.f15121e.getInt("plugin_version_" + c4430d.f15125b, 0);
    }

    private List<C4431e> m18311b() {
        List<C4431e> arrayList = new ArrayList();
        C4445v a = C4445v.m18368a(this.f15120d);
        C4431e c4431e = new C4431e();
        c4431e.f15126a = C4430d.MODULE_CDATA;
        c4431e.f15127b = a.m18372a(C4518b.CollectionDataPluginVersion.m18794a(), 0);
        c4431e.f15128c = a.m18373a(C4518b.CollectionPluginDownloadUrl.m18794a(), BuildConfig.FLAVOR);
        c4431e.f15129d = a.m18373a(C4518b.CollectionPluginMd5.m18794a(), BuildConfig.FLAVOR);
        c4431e.f15130e = a.m18375a(C4518b.CollectionPluginForceStop.m18794a(), false);
        arrayList.add(c4431e);
        return arrayList;
    }

    public C4426b m18312a(C4430d c4430d) {
        C4315i.m17688a();
        if (c4430d == null) {
            return null;
        }
        m18313a();
        C4302b.m17652b("loadModule " + c4430d.f15125b);
        String str = c4430d.f15125b;
        if (this.f15118b.containsKey(str)) {
            return (C4426b) this.f15118b.get(str);
        }
        C4425a c4425a = new C4425a(this.f15120d, str);
        DexClassLoader c = c4425a.m18298c();
        if (c == null) {
            return null;
        }
        C4426b a = m18306a(c4425a, c);
        a.m18303a(this.f15120d);
        this.f15118b.put(str, a);
        C4302b.m17652b("module load success.");
        return a;
    }

    public synchronized void m18313a() {
        if (!this.f15122f) {
            this.f15122f = true;
            for (C4431e c4431e : m18311b()) {
                if (m18310b(c4431e.f15126a) < c4431e.f15127b && !TextUtils.isEmpty(c4431e.f15128c)) {
                    C4427a c4427a = new C4427a(this.f15120d, c4431e.f15128c, c4431e.f15129d, C4425a.m18270a(this.f15120d, c4431e.f15126a.f15125b), c4431e.f15130e);
                    c4427a.run();
                    if (c4427a.f15116f) {
                        m18308a(c4431e.f15126a, c4431e.f15127b);
                        m18309a(c4431e);
                    }
                }
            }
            this.f15122f = false;
        }
    }
}
