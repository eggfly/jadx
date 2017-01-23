package com.google.android.gms.p146b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.p147a.p148a.C2625a.C2624a;
import com.google.ads.p147a.p148a.C2630b.C2627a;
import com.google.ads.p147a.p148a.C2630b.C2627a.C2626a;
import com.google.android.gms.clearcut.C3383b;
import com.google.android.gms.clearcut.C3383b.C3380a;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.api.C3427c.C3447a;
import com.umeng.message.util.HttpRequest;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.b.i */
public abstract class C3279i extends C3235h {
    private static Method f11368A;
    private static Method f11369B;
    private static Method f11370C;
    private static Method f11371D;
    private static String f11372E;
    private static String f11373F;
    private static String f11374G;
    private static long f11375H;
    private static C3350n f11376I;
    private static Random f11377J;
    private static C3457f f11378K;
    private static boolean f11379L;
    private static boolean f11380M;
    static boolean f11381j;
    protected static C3383b f11382k;
    protected static C2624a f11383l;
    protected static int f11384m;
    protected static boolean f11385n;
    protected static boolean f11386o;
    protected static boolean f11387p;
    protected static boolean f11388q;
    private static Method f11389r;
    private static Method f11390s;
    private static Method f11391t;
    private static Method f11392u;
    private static Method f11393v;
    private static Method f11394w;
    private static Method f11395x;
    private static Method f11396y;
    private static Method f11397z;

    /* renamed from: com.google.android.gms.b.i.a */
    static class C3278a extends Exception {
        public C3278a(Throwable th) {
            super(th);
        }
    }

    static {
        f11375H = 0;
        f11381j = false;
        f11382k = null;
        f11377J = new Random();
        f11378K = C3457f.m14269a();
        f11385n = false;
        f11386o = false;
        f11387p = false;
        f11388q = false;
        f11380M = false;
    }

    protected C3279i(Context context, C3158m c3158m) {
        super(context, c3158m);
        f11383l = new C2624a();
        f11383l.f9109a = context.getPackageName();
    }

    static String m13173a(Context context, C3158m c3158m) {
        if (f11373F != null) {
            return f11373F;
        }
        if (f11392u == null) {
            throw new C3278a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f11392u.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new C3278a();
            }
            f11373F = c3158m.m12446a(byteBuffer.array(), true);
            return f11373F;
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static ArrayList<Long> m13174a(MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        if (f11393v == null || motionEvent == null) {
            throw new C3278a();
        }
        try {
            return (ArrayList) f11393v.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    protected static void m13175a(int i, int i2) {
        if (f11388q && f11385n && f11382k != null) {
            C3380a a = f11382k.m13944a(km.m10116a(f11383l));
            a.m13925b(i2);
            a.m13923a(i);
            a.m13924a(i);
        }
    }

    protected static synchronized void m13176a(String str, Context context, C3158m c3158m) {
        synchronized (C3279i.class) {
            if (!f11381j) {
                try {
                    f11376I = new C3350n(c3158m, null);
                    f11372E = str;
                    aq.m11814a(context);
                    C3279i.m13192l(context);
                    f11375H = C3279i.m13180c().longValue();
                    f11377J = new Random();
                    try {
                        i = new C3447a(context).m14251a(C3383b.f11798c).m14253b();
                        f11378K = C3457f.m14269a();
                        f11379L = f11378K.m14271a(context) == 0;
                        aq.m11814a(context);
                        f11385n = ((Boolean) aq.az.m11794c()).booleanValue();
                        f11382k = new C3383b(context, "ADSHIELD", null, null);
                    } catch (NoClassDefFoundError e) {
                    }
                    f11380M = f11378K.m14278c(context) > 0;
                    f11381j = true;
                } catch (C3278a e2) {
                } catch (UnsupportedOperationException e3) {
                }
            }
        }
    }

    static String m13177b() {
        if (f11372E != null) {
            return f11372E;
        }
        throw new C3278a();
    }

    static String m13178b(Context context, C3158m c3158m) {
        if (f11374G != null) {
            return f11374G;
        }
        if (f11395x == null) {
            throw new C3278a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f11395x.invoke(null, new Object[]{context});
            if (byteBuffer == null) {
                throw new C3278a();
            }
            f11374G = c3158m.m12446a(byteBuffer.array(), true);
            return f11374G;
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    private static String m13179b(byte[] bArr, String str) {
        try {
            return new String(f11376I.m13782a(bArr, str), HttpRequest.f14548a);
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static Long m13180c() {
        if (f11389r == null) {
            throw new C3278a();
        }
        try {
            return (Long) f11389r.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static String m13181d() {
        if (f11391t == null) {
            throw new C3278a();
        }
        try {
            return (String) f11391t.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static String m13182d(Context context) {
        if (f11394w == null) {
            throw new C3278a();
        }
        try {
            String str = (String) f11394w.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C3278a();
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static Long m13183e() {
        if (f11390s == null) {
            throw new C3278a();
        }
        try {
            return (Long) f11390s.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static String m13184e(Context context) {
        if (f11368A == null) {
            throw new C3278a();
        }
        try {
            return (String) f11368A.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static Long m13185f(Context context) {
        if (f11369B == null) {
            throw new C3278a();
        }
        try {
            return (Long) f11369B.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    private void m13186f() {
        if (f11388q && f11382k != null) {
            f11382k.m13945a(i, 100, TimeUnit.MILLISECONDS);
            i.m14140c();
        }
    }

    static ArrayList<Long> m13187g(Context context) {
        if (f11396y == null) {
            throw new C3278a();
        }
        try {
            ArrayList<Long> arrayList = (ArrayList) f11396y.invoke(null, new Object[]{context});
            if (arrayList != null && arrayList.size() == 2) {
                return arrayList;
            }
            throw new C3278a();
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static int[] m13188h(Context context) {
        if (f11397z == null) {
            throw new C3278a();
        }
        try {
            return (int[]) f11397z.invoke(null, new Object[]{context});
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static int m13189i(Context context) {
        if (f11370C == null) {
            throw new C3278a();
        }
        try {
            return ((Integer) f11370C.invoke(null, new Object[]{context})).intValue();
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    static int m13190j(Context context) {
        if (f11371D == null) {
            throw new C3278a();
        }
        try {
            return ((Integer) f11371D.invoke(null, new Object[]{context})).intValue();
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        }
    }

    private void m13191k(Context context) {
        if (f11379L) {
            i.m14137b();
            f11388q = true;
            return;
        }
        f11388q = false;
    }

    private static void m13192l(Context context) {
        File file;
        File createTempFile;
        try {
            byte[] a = f11376I.m13781a(C3351o.m13785a());
            byte[] a2 = f11376I.m13782a(a, C3351o.m13786b());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C3278a();
                }
            }
            file = cacheDir;
            createTempFile = File.createTempFile("ads", ".jar", file);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(a2, 0, a2.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13795k()));
            Class loadClass2 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13809y()));
            Class loadClass3 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13803s()));
            Class loadClass4 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13799o()));
            Class loadClass5 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13783A()));
            Class loadClass6 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13797m()));
            Class loadClass7 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13807w()));
            Class loadClass8 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13805u()));
            Class loadClass9 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13793i()));
            Class loadClass10 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13791g()));
            Class loadClass11 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13789e()));
            Class loadClass12 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13801q()));
            Class loadClass13 = dexClassLoader.loadClass(C3279i.m13179b(a, C3351o.m13787c()));
            f11389r = loadClass.getMethod(C3279i.m13179b(a, C3351o.m13796l()), new Class[0]);
            f11390s = loadClass2.getMethod(C3279i.m13179b(a, C3351o.m13810z()), new Class[0]);
            f11391t = loadClass3.getMethod(C3279i.m13179b(a, C3351o.m13804t()), new Class[0]);
            f11392u = loadClass4.getMethod(C3279i.m13179b(a, C3351o.m13800p()), new Class[]{Context.class});
            f11393v = loadClass5.getMethod(C3279i.m13179b(a, C3351o.m13784B()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            f11394w = loadClass6.getMethod(C3279i.m13179b(a, C3351o.m13798n()), new Class[]{Context.class});
            f11395x = loadClass7.getMethod(C3279i.m13179b(a, C3351o.m13808x()), new Class[]{Context.class});
            f11396y = loadClass8.getMethod(C3279i.m13179b(a, C3351o.m13806v()), new Class[]{Context.class});
            f11397z = loadClass9.getMethod(C3279i.m13179b(a, C3351o.m13794j()), new Class[]{Context.class});
            f11368A = loadClass10.getMethod(C3279i.m13179b(a, C3351o.m13792h()), new Class[]{Context.class});
            f11369B = loadClass11.getMethod(C3279i.m13179b(a, C3351o.m13790f()), new Class[]{Context.class});
            f11370C = loadClass12.getMethod(C3279i.m13179b(a, C3351o.m13802r()), new Class[]{Context.class});
            f11371D = loadClass13.getMethod(C3279i.m13179b(a, C3351o.m13788d()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(file, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new C3278a(e);
        } catch (Throwable e2) {
            throw new C3278a(e2);
        } catch (Throwable e22) {
            throw new C3278a(e22);
        } catch (Throwable e222) {
            throw new C3278a(e222);
        } catch (Throwable e2222) {
            throw new C3278a(e2222);
        } catch (Throwable e22222) {
            throw new C3278a(e22222);
        } catch (Throwable th) {
            String name2 = createTempFile.getName();
            createTempFile.delete();
            new File(file, name2.replace(".jar", ".dex")).delete();
        }
    }

    protected boolean m13193a() {
        return f11380M;
    }

    protected C2627a m13194b(Context context) {
        C2627a c2627a = new C2627a();
        try {
            m13191k(context);
            f11384m = f11377J.nextInt();
            C3279i.m13175a(0, f11384m);
            try {
                c2627a.f9131a = C3279i.m13181d();
                C3279i.m13175a(1, f11384m);
            } catch (C3278a e) {
            }
            try {
                c2627a.f9132b = C3279i.m13177b();
                C3279i.m13175a(2, f11384m);
            } catch (C3278a e2) {
            }
            try {
                long longValue = C3279i.m13180c().longValue();
                c2627a.f9129Q = Long.valueOf(longValue);
                if (f11375H != 0) {
                    c2627a.f9147q = Long.valueOf(longValue - f11375H);
                    c2627a.f9152v = Long.valueOf(f11375H);
                }
                C3279i.m13175a(25, f11384m);
            } catch (C3278a e3) {
            }
            try {
                ArrayList g = C3279i.m13187g(context);
                c2627a.f9155y = Long.valueOf(((Long) g.get(0)).longValue());
                c2627a.f9156z = Long.valueOf(((Long) g.get(1)).longValue());
                C3279i.m13175a(31, f11384m);
            } catch (C3278a e4) {
            }
            try {
                c2627a.f9113A = C3279i.m13183e();
                C3279i.m13175a(33, f11384m);
            } catch (C3278a e5) {
            }
            try {
                if (!(f11386o && f11387p)) {
                    c2627a.f9153w = C3279i.m13173a(context, this.h);
                    C3279i.m13175a(27, f11384m);
                }
            } catch (C3278a e6) {
            }
            try {
                c2627a.f9154x = C3279i.m13178b(context, this.h);
                C3279i.m13175a(29, f11384m);
            } catch (C3278a e7) {
            }
            try {
                int[] h = C3279i.m13188h(context);
                c2627a.f9135e = Long.valueOf((long) h[0]);
                c2627a.f9136f = Long.valueOf((long) h[1]);
                C3279i.m13175a(5, f11384m);
            } catch (C3278a e8) {
            }
            try {
                c2627a.f9142l = Long.valueOf((long) C3279i.m13189i(context));
                C3279i.m13175a(12, f11384m);
            } catch (C3278a e9) {
            }
            try {
                c2627a.f9133c = Long.valueOf((long) C3279i.m13190j(context));
                C3279i.m13175a(3, f11384m);
            } catch (C3278a e10) {
            }
            try {
                c2627a.f9114B = C3279i.m13184e(context);
                C3279i.m13175a(34, f11384m);
            } catch (C3278a e11) {
            }
            try {
                c2627a.f9115C = C3279i.m13185f(context);
                C3279i.m13175a(35, f11384m);
            } catch (C3278a e12) {
            }
            m13186f();
        } catch (IOException e13) {
        }
        return c2627a;
    }

    protected C2627a m13195c(Context context) {
        C2627a c2627a = new C2627a();
        m13191k(context);
        f11384m = f11377J.nextInt();
        try {
            c2627a.f9132b = C3279i.m13177b();
        } catch (C3278a e) {
        }
        try {
            c2627a.f9131a = C3279i.m13181d();
        } catch (C3278a e2) {
        }
        try {
            c2627a.f9129Q = C3279i.m13180c();
        } catch (C3278a e3) {
        }
        C3279i.m13175a(0, f11384m);
        try {
            ArrayList a = C3279i.m13174a(this.a, this.g);
            c2627a.f9144n = (Long) a.get(0);
            c2627a.f9145o = (Long) a.get(1);
            if (((Long) a.get(2)).longValue() >= 0) {
                c2627a.f9146p = (Long) a.get(2);
            }
            c2627a.f9116D = (Long) a.get(3);
            c2627a.f9117E = (Long) a.get(4);
            C3279i.m13175a(14, f11384m);
        } catch (C3278a e4) {
        }
        try {
            if (this.c > 0) {
                c2627a.f9121I = Long.valueOf(this.c);
            }
            if (this.d > 0) {
                c2627a.f9120H = Long.valueOf(this.d);
            }
            if (this.e > 0) {
                c2627a.f9119G = Long.valueOf(this.e);
            }
            if (this.f > 0) {
                c2627a.f9122J = Long.valueOf(this.f);
            }
            try {
                int size = this.b.size() - 1;
                if (size > 0) {
                    c2627a.f9123K = new C2626a[size];
                    for (int i = 0; i < size; i++) {
                        ArrayList a2 = C3279i.m13174a((MotionEvent) this.b.get(i), this.g);
                        C2626a c2626a = new C2626a();
                        c2626a.f9111a = (Long) a2.get(0);
                        c2626a.f9112b = (Long) a2.get(1);
                        c2627a.f9123K[i] = c2626a;
                    }
                }
            } catch (C3278a e5) {
                c2627a.f9123K = null;
            }
            try {
                c2627a.f9114B = C3279i.m13184e(context);
            } catch (C3278a e6) {
            }
            try {
                c2627a.f9115C = C3279i.m13185f(context);
            } catch (C3278a e7) {
            }
            m13186f();
        } catch (IOException e8) {
        }
        return c2627a;
    }
}
