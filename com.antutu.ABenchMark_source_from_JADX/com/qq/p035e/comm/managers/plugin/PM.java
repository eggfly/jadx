package com.qq.p035e.comm.managers.plugin;

import android.content.Context;
import com.qq.p035e.comm.pi.POFactory;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.e.comm.managers.plugin.PM */
public class PM {
    private static final Map<Class<?>, String> f13455i;
    private final Context f13456a;
    private String f13457b;
    private File f13458c;
    private int f13459d;
    private DexClassLoader f13460e;
    private RandomAccessFile f13461f;
    private FileLock f13462g;
    private boolean f13463h;

    /* renamed from: com.qq.e.comm.managers.plugin.PM.1 */
    static class C40501 extends HashMap<Class<?>, String> {
        C40501() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    static {
        f13455i = new C40501();
    }

    public PM(Context context) {
        this.f13456a = context.getApplicationContext();
        this.f13463h = m16549b();
        if (m16548a()) {
            GDTLogger.m16599d("PluginFile:\t" + (this.f13458c == null ? "null" : this.f13458c.getAbsolutePath()));
            if (this.f13457b != null) {
                try {
                    this.f13460e = new DexClassLoader(this.f13458c.getAbsolutePath(), this.f13456a.getDir("e_qq_com_dex", 0).getAbsolutePath(), null, getClass().getClassLoader());
                    return;
                } catch (Throwable th) {
                    GDTLogger.m16601e("exception while init plugin class loader", th);
                    return;
                }
            }
            this.f13460e = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m16548a() {
        /*
        r7 = this;
        r6 = 524; // 0x20c float:7.34E-43 double:2.59E-321;
        r1 = 1;
        r0 = 0;
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f3 }
        r3 = "TimeStap_BEFORE_PLUGIN_INIT:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00f3 }
        com.qq.p035e.comm.util.GDTLogger.m16599d(r2);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r7.f13463h;	 Catch:{ Throwable -> 0x00f3 }
        if (r2 == 0) goto L_0x0057;
    L_0x001e:
        r2 = new com.qq.e.comm.managers.plugin.c;	 Catch:{ Throwable -> 0x00f3 }
        r3 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = com.qq.p035e.comm.managers.plugin.C4054c.m16555b(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r4 = com.qq.p035e.comm.managers.plugin.C4054c.m16557d(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x00f3 }
        r3 = r2.m16558a();	 Catch:{ Throwable -> 0x00f3 }
        if (r3 == 0) goto L_0x0057;
    L_0x0035:
        r3 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = com.qq.p035e.comm.managers.plugin.C4054c.m16554a(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r4 = com.qq.p035e.comm.managers.plugin.C4054c.m16556c(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.m16559a(r3, r4);	 Catch:{ Throwable -> 0x00f3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f3 }
        r4 = "NextExist,Updated=";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r3.append(r2);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00f3 }
        com.qq.p035e.comm.util.GDTLogger.m16599d(r2);	 Catch:{ Throwable -> 0x00f3 }
    L_0x0057:
        r2 = new com.qq.e.comm.managers.plugin.c;	 Catch:{ Throwable -> 0x00f3 }
        r3 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = com.qq.p035e.comm.managers.plugin.C4054c.m16554a(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r4 = com.qq.p035e.comm.managers.plugin.C4054c.m16556c(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x00f3 }
        r3 = r2.m16558a();	 Catch:{ Throwable -> 0x00f3 }
        if (r3 == 0) goto L_0x008e;
    L_0x006e:
        r3 = r2.m16560b();	 Catch:{ Throwable -> 0x00f3 }
        if (r3 >= r6) goto L_0x00b0;
    L_0x0074:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f3 }
        r3 = "last updated plugin version =";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00f3 }
        r3 = r7.f13459d;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00f3 }
        r3 = ";asset plugin version=524";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00f3 }
        com.qq.p035e.comm.util.GDTLogger.m16599d(r2);	 Catch:{ Throwable -> 0x00f3 }
    L_0x008e:
        r2 = r0;
    L_0x008f:
        if (r2 != 0) goto L_0x0098;
    L_0x0091:
        r2 = r7.f13463h;	 Catch:{ Throwable -> 0x00f3 }
        if (r2 != 0) goto L_0x00c6;
    L_0x0095:
        r2 = r0;
    L_0x0096:
        if (r2 == 0) goto L_0x0099;
    L_0x0098:
        r0 = r1;
    L_0x0099:
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.qq.p035e.comm.util.GDTLogger.m16599d(r1);
    L_0x00af:
        return r0;
    L_0x00b0:
        r3 = r2.m16561c();	 Catch:{ Throwable -> 0x00f3 }
        r7.f13457b = r3;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.m16560b();	 Catch:{ Throwable -> 0x00f3 }
        r7.f13459d = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r2 = com.qq.p035e.comm.managers.plugin.C4054c.m16554a(r2);	 Catch:{ Throwable -> 0x00f3 }
        r7.f13458c = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r1;
        goto L_0x008f;
    L_0x00c6:
        r2 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = com.qq.p035e.comm.managers.plugin.C4054c.m16554a(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r4 = com.qq.p035e.comm.managers.plugin.C4054c.m16556c(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2 = com.qq.p035e.comm.C4048a.m16539a(r2, r3, r4);	 Catch:{ Throwable -> 0x00f3 }
        if (r2 == 0) goto L_0x00ec;
    L_0x00da:
        r2 = "T2UkXHdY8gY5YPWcNl12IWYcLmHnxhFPvNmi4d4PNoaRN7b0n404ASri/FoLfiLAAZu64EfwDDunzq/Smq6cI7NKa2NjR9aB/3h0F/DK1V4QvA9W3VYB3soM+Gcys8AaXjLPucZOAyQ34X1Nj2PkPu7iImMPWDF6Qun15HAmHk8=";
        r7.f13457b = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r7.f13456a;	 Catch:{ Throwable -> 0x00f3 }
        r2 = com.qq.p035e.comm.managers.plugin.C4054c.m16554a(r2);	 Catch:{ Throwable -> 0x00f3 }
        r7.f13458c = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = 524; // 0x20c float:7.34E-43 double:2.59E-321;
        r7.f13459d = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r1;
        goto L_0x0096;
    L_0x00ec:
        r2 = "Fail to prepair Defult plugin ";
        com.qq.p035e.comm.util.GDTLogger.m16600e(r2);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r0;
        goto L_0x0096;
    L_0x00f3:
        r1 = move-exception;
        r2 = "Exception while init plugin manager";
        com.qq.p035e.comm.util.GDTLogger.report(r2, r1);	 Catch:{ all -> 0x0110 }
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.qq.p035e.comm.util.GDTLogger.m16599d(r1);
        goto L_0x00af;
    L_0x0110:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.qq.p035e.comm.util.GDTLogger.m16599d(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.a():boolean");
    }

    private boolean m16549b() {
        try {
            File file = new File(this.f13456a.getDir("e_qq_com_plugin", 0), "update_lc");
            if (!file.exists()) {
                file.createNewFile();
                StringUtil.writeTo("lock", file);
            }
            if (!file.exists()) {
                return false;
            }
            this.f13461f = new RandomAccessFile(file, "rw");
            this.f13462g = this.f13461f.getChannel().tryLock();
            if (this.f13462g == null) {
                return false;
            }
            this.f13461f.writeByte(37);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public <T> T getFactory(Class<T> cls) {
        GDTLogger.m16599d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = this.f13460e;
        if (classLoader == null) {
            throw new C4053b("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = (String) f13455i.get(cls);
            if (StringUtil.isEmpty(str)) {
                throw new C4053b("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class loadClass = classLoader.loadClass(str);
            return cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
        } catch (Throwable th) {
            C4053b c4053b = new C4053b("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public String getLocalSig() {
        return this.f13457b;
    }

    public POFactory getPOFactory() {
        return (POFactory) getFactory(POFactory.class);
    }

    public int getPluginVersion() {
        return this.f13459d;
    }

    public void update(String str, String str2) {
        if (this.f13463h) {
            new C4052a(this.f13456a).m16553a(str, str2);
        }
    }
}
