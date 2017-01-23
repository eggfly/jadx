package com.xiaomi.mistatistic.sdk;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.xiaomi.mistatistic.sdk.controller.C0551c;
import com.xiaomi.mistatistic.sdk.controller.C0557e;
import com.xiaomi.mistatistic.sdk.controller.C0566h;
import com.xiaomi.mistatistic.sdk.controller.C0571j;
import com.xiaomi.mistatistic.sdk.controller.C0571j.C0530b;
import com.xiaomi.mistatistic.sdk.controller.C0573k;
import com.xiaomi.mistatistic.sdk.controller.C0584n;
import com.xiaomi.mistatistic.sdk.controller.asyncjobs.C0542a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.xiaomi.mistatistic.sdk.b */
public class C0534b implements UncaughtExceptionHandler {
    private static int f4669a;
    private static boolean f4670b;
    private final UncaughtExceptionHandler f4671c;

    /* renamed from: com.xiaomi.mistatistic.sdk.b.1 */
    final class C05321 implements Runnable {
        final /* synthetic */ Map f4663a;

        /* renamed from: com.xiaomi.mistatistic.sdk.b.1.1 */
        class C05311 implements C0530b {
            final /* synthetic */ C05321 f4662a;

            C05311(C05321 c05321) {
                this.f4662a = c05321;
            }

            public void m6281a(String str) {
                C0566h.m6414a("upload exception result: " + str);
            }
        }

        C05321(Map map) {
            this.f4663a = map;
        }

        public void run() {
            try {
                C0571j.m6434a(BuildSetting.m6240a() ? "http://10.99.168.145:8097/micrash" : "https://data.mistat.xiaomi.com/micrash", this.f4663a, new C05311(this));
            } catch (Throwable e) {
                C0566h.m6418a("Error to upload the exception ", e);
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.b.a */
    public static class C0533a implements Serializable {
        public Throwable f4664a;
        public String f4665b;
        public String f4666c;
        public String f4667d;
        public String f4668e;

        public C0533a(Throwable th) {
            this.f4664a = th;
            this.f4665b = C0551c.m6357e();
            this.f4666c = C0551c.m6356d();
            this.f4667d = C0551c.m6358f();
            this.f4668e = String.valueOf(System.currentTimeMillis());
        }

        public C0533a() {
            this.f4664a = null;
            this.f4665b = C0551c.m6357e();
            this.f4666c = C0551c.m6356d();
            this.f4667d = C0551c.m6358f();
            this.f4668e = null;
        }
    }

    static {
        f4669a = 1;
        f4670b = false;
    }

    public static void m6285a(boolean z) {
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (!(defaultUncaughtExceptionHandler instanceof C0534b)) {
            if (z) {
                defaultUncaughtExceptionHandler = null;
            }
            Thread.setDefaultUncaughtExceptionHandler(new C0534b(defaultUncaughtExceptionHandler));
            f4670b = true;
        }
    }

    public static void m6283a(C0533a c0533a, boolean z) {
        C0566h.m6414a("uploadException, isManually:" + z);
        if (!f4670b) {
            return;
        }
        if (c0533a == null || c0533a.f4664a == null) {
            throw new IllegalArgumentException("the throwable is null.");
        } else if (c0533a.f4664a.getStackTrace() != null && c0533a.f4664a.getStackTrace().length != 0) {
            if (BuildSetting.m6245c(C0551c.m6352a())) {
                Object obj;
                Writer stringWriter = new StringWriter();
                c0533a.f4664a.printStackTrace(new PrintWriter(stringWriter));
                String obj2 = stringWriter.toString();
                C0566h.m6419b("exception callstack:" + obj2);
                Map treeMap = new TreeMap();
                treeMap.put("app_id", C0551c.m6354b());
                treeMap.put("app_key", C0551c.m6355c());
                treeMap.put("device_uuid", C0557e.m6368a(C0551c.m6352a()));
                treeMap.put("device_os", "Android " + VERSION.SDK_INT);
                treeMap.put("device_model", Build.MODEL);
                treeMap.put("app_version", c0533a.f4665b);
                treeMap.put("app_channel", c0533a.f4666c);
                treeMap.put("app_start_time", c0533a.f4667d);
                treeMap.put("app_crash_time", c0533a.f4668e);
                treeMap.put("crash_exception_type", c0533a.f4664a.getClass().getName() + ":" + c0533a.f4664a.getMessage());
                String str = "crash_exception_desc";
                if (c0533a.f4664a instanceof OutOfMemoryError) {
                    obj = "OutOfMemoryError";
                } else {
                    String str2 = obj2;
                }
                treeMap.put(str, obj);
                treeMap.put("crash_callstack", obj2);
                if (z) {
                    treeMap.put("manual", "true");
                }
                C0584n.f4780b.execute(new C05321(treeMap));
                return;
            }
            C0566h.m6425d("not allowed to upload debug or exception log");
        }
    }

    public C0534b() {
        this.f4671c = null;
    }

    public C0534b(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f4671c = uncaughtExceptionHandler;
    }

    @SuppressLint({"NewApi"})
    public void uncaughtException(Thread thread, Throwable th) {
        C0566h.m6414a("uncaughtException...");
        if (VERSION.SDK_INT >= 9) {
            StrictMode.setThreadPolicy(new Builder().build());
        }
        C0542a.m6320b();
        if (!MiStatInterface.m6273b()) {
            C0534b.m6284a(th);
        } else if (m6290a()) {
            C0566h.m6414a("crazy crash...");
        } else {
            C0534b.m6283a(new C0533a(th), false);
        }
        if (this.f4671c != null) {
            this.f4671c.uncaughtException(thread, th);
        }
    }

    public void m6289a(Thread thread, Throwable th) {
        C0566h.m6414a("uncaughtExceptionManually...");
        if (VERSION.SDK_INT >= 9) {
            StrictMode.setThreadPolicy(new Builder().build());
        }
        if (!MiStatInterface.m6273b()) {
            C0534b.m6284a(th);
        } else if (m6290a()) {
            C0566h.m6414a("crazy crash, skip the crash");
        } else {
            C0534b.m6283a(new C0533a(th), true);
        }
        if (this.f4671c != null) {
            this.f4671c.uncaughtException(thread, th);
        }
    }

    public boolean m6290a() {
        if (System.currentTimeMillis() - C0573k.m6444a(C0551c.m6352a(), "crash_time", 0) > 300000) {
            C0573k.m6450b(C0551c.m6352a(), "crash_count", 1);
            C0573k.m6451b(C0551c.m6352a(), "crash_time", System.currentTimeMillis());
        } else {
            int a = C0573k.m6443a(C0551c.m6352a(), "crash_count", 0);
            if (a == 0) {
                C0573k.m6451b(C0551c.m6352a(), "crash_time", System.currentTimeMillis());
            }
            a++;
            C0573k.m6450b(C0551c.m6352a(), "crash_count", a);
            if (a > 10) {
                return true;
            }
        }
        return false;
    }

    public static void m6284a(Throwable th) {
        ObjectOutputStream objectOutputStream;
        Throwable e;
        ArrayList b = C0534b.m6286b();
        b.add(new C0533a(th));
        if (b.size() > 5) {
            b.remove(0);
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(C0551c.m6352a().openFileOutput(".exceptiondetail", 0));
            try {
                objectOutputStream.writeObject(b);
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    C0566h.m6418a("", e);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            objectOutputStream = null;
            C0566h.m6418a("", e);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Throwable th3) {
            e = th3;
            if (objectOutputStream2 != null) {
                objectOutputStream2.close();
            }
            throw e;
        }
    }

    public static ArrayList<C0533a> m6286b() {
        ArrayList<C0533a> arrayList;
        Object obj;
        Throwable e;
        ArrayList<C0533a> arrayList2 = new ArrayList();
        ObjectInputStream objectInputStream = null;
        ObjectInputStream objectInputStream2;
        try {
            ArrayList<C0533a> arrayList3;
            File filesDir = C0551c.m6352a().getFilesDir();
            if (filesDir != null) {
                File file = new File(filesDir, ".exceptiondetail");
                if (file.isFile()) {
                    objectInputStream2 = new ObjectInputStream(new FileInputStream(file));
                    try {
                        arrayList3 = (ArrayList) objectInputStream2.readObject();
                        objectInputStream = objectInputStream2;
                        if (objectInputStream == null) {
                            try {
                                objectInputStream.close();
                                arrayList = arrayList3;
                                obj = null;
                            } catch (IOException e2) {
                                arrayList = arrayList3;
                                obj = null;
                            }
                        } else {
                            arrayList = arrayList3;
                            obj = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            C0566h.m6418a("", e);
                            obj = 1;
                            if (objectInputStream2 == null) {
                                try {
                                    objectInputStream2.close();
                                    arrayList = arrayList2;
                                } catch (IOException e4) {
                                    arrayList = arrayList2;
                                }
                            } else {
                                arrayList = arrayList2;
                            }
                            if (obj != null) {
                                C0534b.m6287c();
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            e = th;
                            objectInputStream = objectInputStream2;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw e;
                        }
                    }
                    if (obj != null) {
                        C0534b.m6287c();
                    }
                    return arrayList;
                }
            }
            arrayList3 = arrayList2;
            if (objectInputStream == null) {
                arrayList = arrayList3;
                obj = null;
            } else {
                objectInputStream.close();
                arrayList = arrayList3;
                obj = null;
            }
        } catch (Exception e6) {
            e = e6;
            objectInputStream2 = null;
            C0566h.m6418a("", e);
            obj = 1;
            if (objectInputStream2 == null) {
                arrayList = arrayList2;
            } else {
                objectInputStream2.close();
                arrayList = arrayList2;
            }
            if (obj != null) {
                C0534b.m6287c();
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw e;
        }
        if (obj != null) {
            C0534b.m6287c();
        }
        return arrayList;
    }

    public static void m6287c() {
        new File(C0551c.m6352a().getFilesDir(), ".exceptiondetail").delete();
    }

    public static void m6282a(int i) {
        f4669a = i;
    }

    public static int m6288d() {
        return f4669a;
    }
}
