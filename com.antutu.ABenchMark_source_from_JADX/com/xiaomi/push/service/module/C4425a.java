package com.xiaomi.push.service.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.C4288a;
import com.xiaomi.channel.commonutils.android.C4290b;
import com.xiaomi.channel.commonutils.android.C4291c;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.pushsdk.BuildConfig;
import dalvik.system.DexClassLoader;
import java.io.File;
import junit.framework.Assert;

/* renamed from: com.xiaomi.push.service.module.a */
class C4425a {
    private Context f15097a;
    private String f15098b;
    private String f15099c;
    private int f15100d;
    private int f15101e;
    private int f15102f;
    private String f15103g;
    private SharedPreferences f15104h;

    public C4425a(Context context, String str) {
        boolean z = false;
        this.f15100d = 0;
        this.f15101e = 0;
        this.f15102f = 0;
        this.f15097a = context.getApplicationContext();
        this.f15098b = str;
        this.f15104h = this.f15097a.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        if (!TextUtils.isEmpty(this.f15098b)) {
            z = true;
        }
        Assert.assertEquals(true, z);
    }

    public static String m18270a(Context context, String str) {
        return C4425a.m18274b(context, str) + "/" + str + ".apk";
    }

    private String m18271a(String str) {
        try {
            return this.f15097a.getPackageManager().getPackageArchiveInfo(str, 16512).applicationInfo.metaData.getString("Launcher");
        } catch (Exception e) {
            return null;
        }
    }

    private void m18272a(int i) {
        this.f15104h.edit().putInt(this.f15098b + "_asset_app_version", i).commit();
    }

    private void m18273a(long j) {
        this.f15104h.edit().putLong(this.f15098b + "_asset_modified", j).commit();
    }

    private static String m18274b(Context context, String str) {
        return context.getDir(str, 0).getAbsolutePath();
    }

    private void m18275b(int i) {
        this.f15104h.edit().putInt(this.f15098b + "_asset_version", i).commit();
    }

    private void m18276b(long j) {
        this.f15104h.edit().putLong(this.f15098b + "_local_modified", j).commit();
    }

    private void m18277b(String str) {
        this.f15104h.edit().putString(this.f15098b + "_asset_launcher", str).commit();
    }

    private void m18278c(int i) {
        this.f15104h.edit().putInt(this.f15098b + "_local_version", i).commit();
    }

    private void m18279c(String str) {
        this.f15104h.edit().putString(this.f15098b + "_local_launcher", str).commit();
    }

    private boolean m18280g() {
        File file = new File(m18285l());
        return file.exists() && (m18292s() != file.lastModified() || m18290q() == 0);
    }

    private boolean m18281h() {
        File file = new File(m18299d());
        return file.exists() && (m18293t() == file.lastModified() || m18291r() == 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m18282i() {
        /*
        r7 = this;
        r0 = 0;
        r2 = new java.io.File;
        r1 = r7.m18285l();
        r2.<init>(r1);
        r1 = r2.exists();
        if (r1 == 0) goto L_0x0046;
    L_0x0010:
        r1 = 0;
        r3 = r7.f15097a;	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x006d }
        r3 = r3.getAssets();	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x006d }
        r4 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x006d }
        r4.<init>();	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x006d }
        r5 = r7.f15098b;	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x006d }
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x006d }
        r5 = ".apk";
        r4 = r4.append(r5);	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x006d }
        r4 = r4.toString();	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x006d }
        r1 = r3.openFd(r4);	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x006d }
        r4 = r1.getLength();	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x0089 }
        r2 = r2.length();	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x0089 }
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x003d;
    L_0x003c:
        r0 = 1;
    L_0x003d:
        if (r1 == 0) goto L_0x0046;
    L_0x003f:
        r1 = r1.getParcelFileDescriptor();
    L_0x0043:
        com.xiaomi.channel.commonutils.file.C4298a.m17630a(r1);
    L_0x0046:
        return r0;
    L_0x0047:
        r2 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007b }
        r2.<init>();	 Catch:{ all -> 0x007b }
        r3 = "no ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x007b }
        r3 = r7.f15098b;	 Catch:{ all -> 0x007b }
        r2 = r2.append(r3);	 Catch:{ all -> 0x007b }
        r3 = ".apk file in assets of app";
        r2 = r2.append(r3);	 Catch:{ all -> 0x007b }
        r2 = r2.toString();	 Catch:{ all -> 0x007b }
        com.xiaomi.channel.commonutils.logger.C4302b.m17654d(r2);	 Catch:{ all -> 0x007b }
        if (r1 == 0) goto L_0x0046;
    L_0x0068:
        r1 = r1.getParcelFileDescriptor();
        goto L_0x0043;
    L_0x006d:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x0071:
        r1.printStackTrace();	 Catch:{ all -> 0x0086 }
        if (r2 == 0) goto L_0x0046;
    L_0x0076:
        r1 = r2.getParcelFileDescriptor();
        goto L_0x0043;
    L_0x007b:
        r0 = move-exception;
    L_0x007c:
        if (r1 == 0) goto L_0x0085;
    L_0x007e:
        r1 = r1.getParcelFileDescriptor();
        com.xiaomi.channel.commonutils.file.C4298a.m17630a(r1);
    L_0x0085:
        throw r0;
    L_0x0086:
        r0 = move-exception;
        r1 = r2;
        goto L_0x007c;
    L_0x0089:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x0071;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.module.a.i():boolean");
    }

    private void m18283j() {
        String str;
        try {
            C4302b.m17652b("copyAssetFile start");
            String[] list = this.f15097a.getAssets().list(BuildConfig.FLAVOR);
            if (list != null) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2) && str2.startsWith(this.f15098b)) {
                        C4291c.m17604a(this.f15097a, str2, m18285l());
                        str = "copyAssetFile end";
                        break;
                    }
                }
            }
            str = "copyAssetFile end";
        } catch (Exception e) {
            e.printStackTrace();
            str = "copyAssetFile end";
        } catch (Throwable th) {
            C4302b.m17652b("copyAssetFile end");
        }
        C4302b.m17652b(str);
    }

    private String m18284k() {
        return C4425a.m18274b(this.f15097a, this.f15098b);
    }

    private String m18285l() {
        return m18284k() + "/" + this.f15098b + "_asset.apk";
    }

    private String m18286m() {
        return m18284k() + "/lib/";
    }

    private String m18287n() {
        return m18284k() + "/asset_lib/";
    }

    private boolean m18288o() {
        try {
            return m18289p() != C4290b.m17599b(this.f15097a, this.f15097a.getPackageName());
        } catch (Exception e) {
            return true;
        }
    }

    private int m18289p() {
        int i = 0;
        try {
            i = this.f15104h.getInt(this.f15098b + "_asset_app_version", 0);
        } catch (Exception e) {
        }
        return i;
    }

    private int m18290q() {
        int i = 0;
        try {
            i = this.f15104h.getInt(this.f15098b + "_asset_version", 0);
        } catch (Exception e) {
        }
        return i;
    }

    private int m18291r() {
        int i = 0;
        try {
            i = this.f15104h.getInt(this.f15098b + "_local_version", 0);
        } catch (Exception e) {
        }
        return i;
    }

    private long m18292s() {
        long j = 0;
        try {
            j = this.f15104h.getLong(this.f15098b + "_asset_modified", 0);
        } catch (Exception e) {
        }
        return j;
    }

    private long m18293t() {
        long j = 0;
        try {
            j = this.f15104h.getLong(this.f15098b + "_local_modified", 0);
        } catch (Exception e) {
        }
        return j;
    }

    private String m18294u() {
        String str = null;
        try {
            str = this.f15104h.getString(this.f15098b + "_asset_launcher", null);
        } catch (Exception e) {
        }
        return str;
    }

    private String m18295v() {
        String str = null;
        try {
            str = this.f15104h.getString(this.f15098b + "_local_launcher", null);
        } catch (Exception e) {
        }
        return str;
    }

    public int m18296a() {
        return this.f15100d;
    }

    public String m18297b() {
        return this.f15103g;
    }

    public synchronized DexClassLoader m18298c() {
        DexClassLoader dexClassLoader;
        Object obj = 1;
        synchronized (this) {
            try {
                Object obj2;
                String d;
                File file;
                C4302b.m17652b("load apk " + this.f15098b);
                String l = m18285l();
                File file2 = new File(l);
                boolean i = m18282i();
                C4302b.m17652b("assert app size changed : " + i);
                if (!file2.exists() || i || m18288o()) {
                    C4302b.m17652b("re-copy asset file");
                    m18283j();
                }
                if (file2.exists()) {
                    C4302b.m17652b("check modify.");
                    if (m18280g() || i || m18288o()) {
                        C4302b.m17652b("modified.");
                        this.f15101e = C4290b.m17601c(this.f15097a, l);
                        m18275b(this.f15101e);
                        m18272a(C4290b.m17599b(this.f15097a, this.f15097a.getPackageName()));
                        m18273a(file2.lastModified());
                        obj2 = 1;
                        d = m18299d();
                        file = new File(d);
                        if (file.exists()) {
                            if (m18281h()) {
                                this.f15102f = m18291r();
                            } else {
                                this.f15102f = C4290b.m17601c(this.f15097a, d);
                                m18278c(this.f15102f);
                                m18276b(file.lastModified());
                                C4302b.m17652b("asset version " + this.f15101e);
                                C4302b.m17652b("local version " + this.f15102f);
                                if (this.f15101e < this.f15102f) {
                                    if (this.f15101e > this.f15100d) {
                                        this.f15100d = this.f15101e;
                                        this.f15099c = m18285l();
                                        if (obj2 == null) {
                                            this.f15103g = m18271a(this.f15099c);
                                            m18277b(this.f15103g);
                                            C4288a.m17593a(this.f15097a, this.f15099c, m18287n());
                                        } else {
                                            this.f15103g = m18294u();
                                        }
                                        dexClassLoader = new DexClassLoader(this.f15099c, this.f15097a.getDir("dex", 0).getAbsolutePath(), m18287n(), ClassLoader.getSystemClassLoader());
                                        C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                                        C4302b.m17652b("load apk done.");
                                    }
                                } else if (this.f15102f > this.f15100d) {
                                    this.f15100d = this.f15102f;
                                    this.f15099c = m18299d();
                                    if (obj == null) {
                                        this.f15103g = m18271a(this.f15099c);
                                        m18279c(this.f15103g);
                                        C4288a.m17593a(this.f15097a, this.f15099c, m18286m());
                                    } else {
                                        this.f15103g = m18295v();
                                    }
                                    dexClassLoader = new DexClassLoader(this.f15099c, this.f15097a.getDir("dex", 0).getAbsolutePath(), m18286m(), ClassLoader.getSystemClassLoader());
                                    C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                                    C4302b.m17652b("load apk done.");
                                }
                                C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                                C4302b.m17652b("load apk done.");
                                dexClassLoader = null;
                            }
                        }
                        obj = null;
                        C4302b.m17652b("asset version " + this.f15101e);
                        C4302b.m17652b("local version " + this.f15102f);
                        if (this.f15101e < this.f15102f) {
                            if (this.f15102f > this.f15100d) {
                                this.f15100d = this.f15102f;
                                this.f15099c = m18299d();
                                if (obj == null) {
                                    this.f15103g = m18295v();
                                } else {
                                    this.f15103g = m18271a(this.f15099c);
                                    m18279c(this.f15103g);
                                    C4288a.m17593a(this.f15097a, this.f15099c, m18286m());
                                }
                                dexClassLoader = new DexClassLoader(this.f15099c, this.f15097a.getDir("dex", 0).getAbsolutePath(), m18286m(), ClassLoader.getSystemClassLoader());
                                C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                                C4302b.m17652b("load apk done.");
                            }
                        } else if (this.f15101e > this.f15100d) {
                            this.f15100d = this.f15101e;
                            this.f15099c = m18285l();
                            if (obj2 == null) {
                                this.f15103g = m18294u();
                            } else {
                                this.f15103g = m18271a(this.f15099c);
                                m18277b(this.f15103g);
                                C4288a.m17593a(this.f15097a, this.f15099c, m18287n());
                            }
                            dexClassLoader = new DexClassLoader(this.f15099c, this.f15097a.getDir("dex", 0).getAbsolutePath(), m18287n(), ClassLoader.getSystemClassLoader());
                            C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                            C4302b.m17652b("load apk done.");
                        }
                        C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                        C4302b.m17652b("load apk done.");
                        dexClassLoader = null;
                    } else {
                        C4302b.m17652b("not modified.");
                        this.f15101e = m18290q();
                    }
                }
                obj2 = null;
                d = m18299d();
                file = new File(d);
                if (file.exists()) {
                    if (m18281h()) {
                        this.f15102f = m18291r();
                    } else {
                        this.f15102f = C4290b.m17601c(this.f15097a, d);
                        m18278c(this.f15102f);
                        m18276b(file.lastModified());
                        C4302b.m17652b("asset version " + this.f15101e);
                        C4302b.m17652b("local version " + this.f15102f);
                        if (this.f15101e < this.f15102f) {
                            if (this.f15101e > this.f15100d) {
                                this.f15100d = this.f15101e;
                                this.f15099c = m18285l();
                                if (obj2 == null) {
                                    this.f15103g = m18271a(this.f15099c);
                                    m18277b(this.f15103g);
                                    C4288a.m17593a(this.f15097a, this.f15099c, m18287n());
                                } else {
                                    this.f15103g = m18294u();
                                }
                                dexClassLoader = new DexClassLoader(this.f15099c, this.f15097a.getDir("dex", 0).getAbsolutePath(), m18287n(), ClassLoader.getSystemClassLoader());
                                C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                                C4302b.m17652b("load apk done.");
                            }
                        } else if (this.f15102f > this.f15100d) {
                            this.f15100d = this.f15102f;
                            this.f15099c = m18299d();
                            if (obj == null) {
                                this.f15103g = m18271a(this.f15099c);
                                m18279c(this.f15103g);
                                C4288a.m17593a(this.f15097a, this.f15099c, m18286m());
                            } else {
                                this.f15103g = m18295v();
                            }
                            dexClassLoader = new DexClassLoader(this.f15099c, this.f15097a.getDir("dex", 0).getAbsolutePath(), m18286m(), ClassLoader.getSystemClassLoader());
                            C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                            C4302b.m17652b("load apk done.");
                        }
                        C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                        C4302b.m17652b("load apk done.");
                        dexClassLoader = null;
                    }
                }
                obj = null;
                C4302b.m17652b("asset version " + this.f15101e);
                C4302b.m17652b("local version " + this.f15102f);
                if (this.f15101e < this.f15102f) {
                    if (this.f15102f > this.f15100d) {
                        this.f15100d = this.f15102f;
                        this.f15099c = m18299d();
                        if (obj == null) {
                            this.f15103g = m18295v();
                        } else {
                            this.f15103g = m18271a(this.f15099c);
                            m18279c(this.f15103g);
                            C4288a.m17593a(this.f15097a, this.f15099c, m18286m());
                        }
                        dexClassLoader = new DexClassLoader(this.f15099c, this.f15097a.getDir("dex", 0).getAbsolutePath(), m18286m(), ClassLoader.getSystemClassLoader());
                        C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                        C4302b.m17652b("load apk done.");
                    }
                } else if (this.f15101e > this.f15100d) {
                    this.f15100d = this.f15101e;
                    this.f15099c = m18285l();
                    if (obj2 == null) {
                        this.f15103g = m18294u();
                    } else {
                        this.f15103g = m18271a(this.f15099c);
                        m18277b(this.f15103g);
                        C4288a.m17593a(this.f15097a, this.f15099c, m18287n());
                    }
                    dexClassLoader = new DexClassLoader(this.f15099c, this.f15097a.getDir("dex", 0).getAbsolutePath(), m18287n(), ClassLoader.getSystemClassLoader());
                    C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                    C4302b.m17652b("load apk done.");
                }
                C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                C4302b.m17652b("load apk done.");
            } catch (Throwable e) {
                C4302b.m17651a(e);
                C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                C4302b.m17652b("load apk done.");
            } catch (Throwable th) {
                C4302b.m17652b("load apk : " + this.f15099c + ", version : " + this.f15100d);
                C4302b.m17652b("load apk done.");
            }
            dexClassLoader = null;
        }
        return dexClassLoader;
    }

    public String m18299d() {
        return C4425a.m18270a(this.f15097a, this.f15098b);
    }

    public String m18300e() {
        return this.f15098b;
    }

    public String m18301f() {
        return this.f15099c;
    }
}
