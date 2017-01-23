package com.baidu.mobads.p093h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p096e.C2021a;
import com.baidu.mobads.p080j.C1991m;
import com.baidu.mobads.p081a.C1908b;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.baidu.mobads.h.g */
public class C1960g {
    protected static UncaughtExceptionHandler f6831a;
    protected static volatile C1949a f6832b;
    protected static volatile C1949a f6833c;
    protected static final Handler f6834e;
    private static String f6835h;
    protected String f6836d;
    protected Handler f6837f;
    @SuppressLint({"HandlerLeak"})
    protected final Handler f6838g;
    private C2021a f6839i;
    private C1955e f6840j;
    private final Context f6841k;
    private IXAdLogger f6842l;
    private C1959c f6843m;

    /* renamed from: com.baidu.mobads.h.g.a */
    public static final class C1957a extends Exception {
        public C1957a(String str) {
            C1991m.m7449a().m7457f().m7397e(str);
        }
    }

    /* renamed from: com.baidu.mobads.h.g.b */
    protected static final class C1958b extends Exception {
        public C1958b(String str) {
            C1991m.m7449a().m7457f().m7397e(str);
        }
    }

    /* renamed from: com.baidu.mobads.h.g.c */
    public interface C1959c {
        void m7318a(boolean z);
    }

    static {
        f6832b = null;
        f6833c = null;
        f6834e = new C1961h(Looper.getMainLooper());
    }

    public C1960g(Context context) {
        this.f6842l = C1991m.m7449a().m7457f();
        this.f6836d = null;
        this.f6837f = f6834e;
        this.f6838g = new C1962i(this, Looper.getMainLooper());
        if (f6835h == null) {
            f6835h = "http://mobads.baidu.com/ads/pa/" + C1908b.m7198b() + "/__pasys_remote_banner.php?";
        }
        this.f6841k = context;
        this.f6836d = context.getDir("baidu_ad_sdk", 0).getAbsolutePath() + "/";
        if (f6831a == null) {
            f6831a = C1971q.m7360a(context);
            C1971q.m7360a(context).m7370a(new C1964j(this));
        }
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof C1971q)) {
            Thread.setDefaultUncaughtExceptionHandler(f6831a);
        }
    }

    private IXAdContainerFactory m7321a(C1949a c1949a) {
        IXAdContainerFactory iXAdContainerFactory = null;
        if (c1949a != null) {
            try {
                iXAdContainerFactory = c1949a.m7289a();
            } catch (Exception e) {
            }
        }
        return iXAdContainerFactory;
    }

    private void m7323a(C1951b c1951b) {
        Class b = c1951b.m7298b();
        synchronized (this) {
            f6833c = new C1949a(b, this.f6841k, C1908b.m7197a(), C1908b.f6664a);
        }
    }

    private void m7324a(C1955e c1955e) {
        if (c1955e.m7311a().booleanValue()) {
            C1952c a = C1952c.m7300a(this.f6841k, c1955e, this.f6836d, this.f6838g);
            if (a.isAlive()) {
                this.f6842l.m7393d("XAdApkLoader", "XApkDownloadThread already started");
                a.m7306a(c1955e.m7313c());
                return;
            }
            this.f6842l.m7393d("XAdApkLoader", "XApkDownloadThread starting ...");
            a.start();
        }
    }

    private void m7328a(boolean z) {
        Message obtainMessage = this.f6837f.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean(MsgConstant.KEY_SUCCESS, z);
        obtainMessage.setData(bundle);
        obtainMessage.what = 0;
        this.f6837f.sendMessage(obtainMessage);
    }

    private void m7329a(boolean z, String str) {
        if (this.f6843m != null) {
            this.f6843m.m7318a(z);
        }
    }

    private void m7331b(C1951b c1951b) {
        Log.i("XAdApkLoader", "len=" + c1951b.length() + ", path=" + c1951b.getAbsolutePath());
        if (f6832b == null) {
            f6832b = new C1949a(c1951b.m7298b(), this.f6841k, C1908b.m7197a(), C1908b.f6664a);
            try {
                this.f6842l.m7393d("XAdApkLoader", "preloaded apk.version=" + f6832b.m7289a().getRemoteVersion());
                return;
            } catch (C1957a e) {
                this.f6842l.m7408w("XAdApkLoader", "preload local apk " + c1951b.getAbsolutePath() + " failed, msg:" + e.getMessage() + ", v=" + f6832b.f6800a);
                m7348a(e.getMessage());
                throw e;
            }
        }
        this.f6842l.m7408w("XAdApkLoader", "mApkBuilder already initialized, version: " + f6832b.f6800a);
    }

    private void m7332b(C1959c c1959c, Handler handler) {
        this.f6843m = c1959c;
        this.f6837f = handler;
        if (f6832b == null) {
            m7353f();
        } else {
            m7335b(true);
        }
    }

    private void m7335b(boolean z) {
        m7329a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        new Handler(Looper.getMainLooper()).postDelayed(new C1965k(this, z), 5000);
    }

    private void m7336c(C1951b c1951b) {
        synchronized (this) {
            m7331b(c1951b);
            this.f6842l.m7393d("XAdApkLoader", "loaded: " + c1951b.getPath());
            m7335b(true);
        }
    }

    private SharedPreferences m7342j() {
        return this.f6841k.getSharedPreferences("com.baidu.mobads.loader", 0);
    }

    private boolean m7343k() {
        String string = m7342j().getString("previousProxyVersion", null);
        return string == null || !string.equals(m7345a());
    }

    private synchronized void m7344l() {
        try {
            if (this.f6839i != null) {
                this.f6839i.removeAllListeners();
                this.f6839i.m7543a();
            }
            this.f6839i = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String m7345a() {
        return "8.8";
    }

    public void m7346a(C1959c c1959c) {
        m7347a(c1959c, f6834e);
    }

    public void m7347a(C1959c c1959c, Handler handler) {
        new Thread(new C1968n(this, c1959c, handler)).start();
    }

    protected void m7348a(String str) {
        if (f6832b != null) {
            Editor edit = m7342j().edit();
            edit.putFloat("__badApkVersion__8.8", (float) f6832b.f6800a);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    protected void m7349b() {
        new File(m7352e()).delete();
    }

    protected String m7350c() {
        return this.f6836d + "__xadsdk__remote__final__builtin__.jar";
    }

    protected void m7351d() {
        String c = m7350c();
        C1951b c1951b = new C1951b(c, this.f6841k);
        try {
            C1991m.m7449a().m7462k().copyFileFromAssetsTo(this.f6841k, "__xadsdk__remote__final__.jar", c);
            if (c1951b.exists() && c1951b.canRead()) {
                m7336c(c1951b);
                return;
            }
            throw new C1958b("loadBuiltInApk failed: " + c);
        } catch (IOException e) {
            throw new C1958b("loadBuiltInApk failed: " + e.toString());
        }
    }

    protected String m7352e() {
        return this.f6836d + "__xadsdk__remote__final__downloaded__.jar";
    }

    protected void m7353f() {
        C1951b c1951b = new C1951b(m7352e(), this.f6841k);
        Boolean valueOf = Boolean.valueOf(c1951b.exists());
        Boolean valueOf2 = Boolean.valueOf(c1951b.canRead());
        long length = c1951b.length();
        if (valueOf.booleanValue() && valueOf2.booleanValue() && length > 0) {
            try {
                if (Boolean.valueOf(m7343k()).booleanValue()) {
                    String str = "XAdApkLoader upgraded, drop stale downloaded file, use built-in instead";
                    throw new C1957a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
                }
                synchronized (this) {
                    Log.i("XAdApkLoader", "loadDownloadedOrBuiltInApk len=" + c1951b.length() + ", path=" + c1951b.getAbsolutePath());
                    m7331b(c1951b);
                    double d = (double) m7342j().getFloat("__badApkVersion__8.8", -1.0f);
                    this.f6842l.m7393d("XAdApkLoader", "downloadedApkFile.getApkVersion(): " + c1951b.m7299c() + ", badApkVersion: " + d);
                    if (c1951b.m7299c() == d) {
                        throw new C1957a("downloaded file marked bad, drop it and use built-in");
                    }
                    this.f6842l.m7393d("XAdApkLoader", "loaded: " + c1951b.getPath());
                    m7335b(true);
                }
                return;
            } catch (C1957a e) {
                this.f6842l.m7400e("XAdApkLoader", "load downloaded apk failed: " + e.toString() + ", fallback to built-in");
                if (c1951b != null && c1951b.exists()) {
                    c1951b.delete();
                }
                m7355h();
                try {
                    m7351d();
                    return;
                } catch (C1958b e2) {
                    throw new C1957a("load built-in apk also failed" + e2.toString());
                }
            }
        }
        this.f6842l.m7393d("XAdApkLoader", "no downloaded file yet, use built-in apk file");
        try {
            m7351d();
        } catch (C1958b e22) {
            this.f6842l.m7400e("XAdApkLoader", "loadBuiltInApk failed: " + e22.toString());
            throw new C1957a("load built-in apk failed" + e22.toString());
        }
    }

    public IXAdContainerFactory m7354g() {
        return m7321a(f6832b);
    }

    protected void m7355h() {
        if (f6832b != null) {
            f6832b.m7290b();
            f6832b = null;
        }
    }
}
