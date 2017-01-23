package com.antutu.redacc.p072e;

import android.content.Context;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.net.Uri;
import android.util.Log;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Method;

/* renamed from: com.antutu.redacc.e.a */
public class C1737a {
    private static Method f6154a;
    private int f6155b;
    private boolean f6156c;
    private boolean f6157d;
    private boolean f6158e;
    private String f6159f;
    private String f6160g;
    private long f6161h;
    private int f6162i;
    private String f6163j;
    private long f6164k;

    /* renamed from: com.antutu.redacc.e.a.1 */
    class C17361 extends Stub {
        final /* synthetic */ C1737a f6153a;

        C17361(C1737a c1737a) {
            this.f6153a = c1737a;
        }

        public void onGetStatsCompleted(PackageStats packageStats, boolean z) {
            this.f6153a.m6710b((packageStats.cacheSize + packageStats.codeSize) + packageStats.dataSize);
        }
    }

    static {
        f6154a = null;
    }

    public C1737a() {
        this.f6155b = -1;
        this.f6156c = false;
        this.f6157d = false;
        this.f6158e = false;
        this.f6159f = BuildConfig.FLAVOR;
        this.f6160g = BuildConfig.FLAVOR;
        this.f6163j = BuildConfig.FLAVOR;
        this.f6164k = -1;
    }

    public long m6702a() {
        return this.f6164k;
    }

    public void m6703a(int i) {
        this.f6162i = i;
    }

    public void m6704a(long j) {
        this.f6164k = j;
    }

    public void m6705a(Context context) {
        if (f6154a == null) {
            try {
                f6154a = PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class});
            } catch (NoSuchMethodException e) {
                f6154a = null;
            }
        }
        if (f6154a != null) {
            try {
                f6154a.invoke(context.getPackageManager(), new Object[]{this.f6160g, new C17361(this)});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void m6706a(String str) {
        this.f6163j = str;
    }

    public void m6707a(boolean z) {
        if (this.f6160g.equalsIgnoreCase("com.tencent.mm")) {
            Log.e("weixin", "weixin");
        }
        this.f6158e = z;
    }

    public long m6708b() {
        return this.f6161h;
    }

    public void m6709b(int i) {
        this.f6155b = i;
    }

    public void m6710b(long j) {
        this.f6161h = j;
    }

    public void m6711b(String str) {
        this.f6160g = str;
    }

    public void m6712b(boolean z) {
        this.f6157d = z;
    }

    public int m6713c() {
        return this.f6162i;
    }

    public void m6714c(String str) {
        this.f6159f = str;
    }

    public void m6715c(boolean z) {
        this.f6156c = z;
    }

    public Uri m6716d() {
        return Uri.parse("android.resource://" + this.f6160g + "/" + this.f6162i);
    }

    public boolean m6717e() {
        return this.f6158e;
    }

    public String m6718f() {
        return this.f6163j;
    }

    public boolean m6719g() {
        return this.f6157d;
    }

    public boolean m6720h() {
        return this.f6156c;
    }

    public String m6721i() {
        return this.f6160g;
    }

    public String m6722j() {
        return this.f6159f;
    }
}
