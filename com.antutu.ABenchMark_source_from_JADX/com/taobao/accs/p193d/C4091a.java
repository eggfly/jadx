package com.taobao.accs.p193d;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import dalvik.system.DexClassLoader;
import java.io.File;

/* renamed from: com.taobao.accs.d.a */
public class C4091a {
    private static C4091a f13648a;
    private ClassLoader f13649b;
    private boolean f13650c;
    private Context f13651d;

    /* renamed from: com.taobao.accs.d.a.a */
    private static class C4090a extends DexClassLoader {
        private ClassLoader f13647a;

        public C4090a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader.getParent());
            this.f13647a = classLoader;
        }

        protected Class<?> findClass(String str) {
            try {
                return super.findClass(str);
            } catch (Exception e) {
                return this.f13647a.loadClass(str);
            }
        }

        public String toString() {
            return "ACCSClassLoader$InnerClassLoader$" + hashCode();
        }
    }

    static {
        f13648a = null;
    }

    public C4091a() {
        this.f13649b = null;
        this.f13650c = false;
    }

    public static synchronized C4091a m16693a() {
        C4091a c4091a;
        synchronized (C4091a.class) {
            if (f13648a == null) {
                f13648a = new C4091a();
            }
            c4091a = f13648a;
        }
        return c4091a;
    }

    private synchronized void m16694a(String str, String str2) {
        if (this.f13650c) {
            ALog.m16901d("ACCSClassLoader", "dexOpting, exit", new Object[0]);
        } else {
            this.f13650c = true;
            new C4092b(this, str, str2).start();
        }
    }

    public synchronized ClassLoader m16696a(Context context) {
        if (context != null) {
            this.f13651d = context;
        }
        if (this.f13649b == null) {
            ALog.m16901d("ACCSClassLoader", "create new class loader", new Object[0]);
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            String string = sharedPreferences.getString(Constants.SP_KEY_UPDATE_FOLDER, null);
            ALog.m16901d("ACCSClassLoader", "baseUpdateFolder:" + string, new Object[0]);
            if (string != null) {
                File dir = context.getDir(string, 0);
                if (dir.exists() && dir.isDirectory()) {
                    File file = new File(dir, Constants.UPDATE_DEX_FILE);
                    if (file.exists() && file.isFile() && sharedPreferences.getInt(Constants.SP_KEY_UPDATE_VERSION, Constants.SDK_VERSION_CODE) > Constants.SDK_VERSION_CODE) {
                        if (sharedPreferences.getBoolean(Constants.SP_KEY_UPDATE_DONE, false)) {
                            ALog.m16901d("ACCSClassLoader", "dexopt already done", new Object[0]);
                            this.f13649b = new C4090a(file.getAbsolutePath(), dir.getAbsolutePath(), new File(dir.getParentFile(), "lib").getAbsolutePath(), C4091a.class.getClassLoader());
                        } else {
                            ALog.m16901d("ACCSClassLoader", "try dexopt", new Object[0]);
                            m16694a(file.getAbsolutePath(), dir.getAbsolutePath());
                        }
                    }
                }
            }
        }
        if (this.f13649b == null) {
            ALog.m16901d("ACCSClassLoader", "get defalut class loader", new Object[0]);
            this.f13649b = C4091a.class.getClassLoader();
        }
        return this.f13649b;
    }
}
