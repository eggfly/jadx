package com.p063b.p064a;

import android.util.Log;
import com.p063b.p076b.C1865c;
import com.p063b.p076b.C1866a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.b.a.k */
public class C1879k implements Cloneable {
    private static final C1856l f6407i;
    private static final C1856l f6408j;
    private static Class[] f6409k;
    private static Class[] f6410l;
    private static Class[] f6411m;
    private static final HashMap<Class, HashMap<String, Method>> f6412n;
    private static final HashMap<Class, HashMap<String, Method>> f6413o;
    String f6414a;
    protected C1865c f6415b;
    Method f6416c;
    Class f6417d;
    C1858h f6418e;
    final ReentrantReadWriteLock f6419f;
    final Object[] f6420g;
    private Method f6421h;
    private C1856l f6422p;
    private Object f6423q;

    /* renamed from: com.b.a.k.a */
    static class C1880a extends C1879k {
        C1859e f6424h;
        float f6425i;
        private C1866a f6426j;

        public C1880a(C1865c c1865c, float... fArr) {
            super(null);
            m7076a(fArr);
            if (c1865c instanceof C1866a) {
                this.f6426j = (C1866a) this.b;
            }
        }

        public C1880a(String str, float... fArr) {
            super(null);
            m7076a(fArr);
        }

        public /* synthetic */ C1879k m7073a() {
            return m7079e();
        }

        void m7074a(float f) {
            this.f6425i = this.f6424h.m6936b(f);
        }

        void m7075a(Class cls) {
            if (this.b == null) {
                super.m7065a(cls);
            }
        }

        public void m7076a(float... fArr) {
            super.m7068a(fArr);
            this.f6424h = (C1859e) this.e;
        }

        void m7077b(Object obj) {
            if (this.f6426j != null) {
                this.f6426j.m6999a(obj, this.f6425i);
            } else if (this.b != null) {
                this.b.m6998a(obj, Float.valueOf(this.f6425i));
            } else if (this.c != null) {
                try {
                    this.g[0] = Float.valueOf(this.f6425i);
                    this.c.invoke(obj, this.g);
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        public /* synthetic */ Object clone() {
            return m7079e();
        }

        Object m7078d() {
            return Float.valueOf(this.f6425i);
        }

        public C1880a m7079e() {
            C1880a c1880a = (C1880a) super.m7062a();
            c1880a.f6424h = (C1859e) c1880a.e;
            return c1880a;
        }
    }

    static {
        f6407i = new C1860f();
        f6408j = new C1857d();
        f6409k = new Class[]{Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
        f6410l = new Class[]{Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
        f6411m = new Class[]{Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
        f6412n = new HashMap();
        f6413o = new HashMap();
    }

    private C1879k(C1865c c1865c) {
        this.f6416c = null;
        this.f6421h = null;
        this.f6418e = null;
        this.f6419f = new ReentrantReadWriteLock();
        this.f6420g = new Object[1];
        this.f6415b = c1865c;
        if (c1865c != null) {
            this.f6414a = c1865c.m6997a();
        }
    }

    private C1879k(String str) {
        this.f6416c = null;
        this.f6421h = null;
        this.f6418e = null;
        this.f6419f = new ReentrantReadWriteLock();
        this.f6420g = new Object[1];
        this.f6414a = str;
    }

    public static C1879k m7056a(C1865c<?, Float> c1865c, float... fArr) {
        return new C1880a((C1865c) c1865c, fArr);
    }

    public static C1879k m7057a(String str, float... fArr) {
        return new C1880a(str, fArr);
    }

    static String m7058a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char toUpperCase = Character.toUpperCase(str2.charAt(0));
        return str + toUpperCase + str2.substring(1);
    }

    private Method m7059a(Class cls, String str, Class cls2) {
        Method method = null;
        String a = C1879k.m7058a(str, this.f6414a);
        Class[] clsArr = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(a, clsArr);
            } catch (NoSuchMethodException e) {
                Method declaredMethod;
                try {
                    declaredMethod = cls.getDeclaredMethod(a, clsArr);
                    try {
                        declaredMethod.setAccessible(true);
                        return declaredMethod;
                    } catch (NoSuchMethodException e2) {
                        Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f6414a + ": " + e);
                        return declaredMethod;
                    }
                } catch (NoSuchMethodException e3) {
                    declaredMethod = null;
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f6414a + ": " + e);
                    return declaredMethod;
                }
            }
        }
        Class[] clsArr2 = new Class[1];
        clsArr = this.f6417d.equals(Float.class) ? f6409k : this.f6417d.equals(Integer.class) ? f6410l : this.f6417d.equals(Double.class) ? f6411m : new Class[]{this.f6417d};
        int length = clsArr.length;
        int i = 0;
        while (i < length) {
            Class cls3 = clsArr[i];
            clsArr2[0] = cls3;
            try {
                method = cls.getMethod(a, clsArr2);
                this.f6417d = cls3;
                return method;
            } catch (NoSuchMethodException e4) {
                try {
                    method = cls.getDeclaredMethod(a, clsArr2);
                    method.setAccessible(true);
                    this.f6417d = cls3;
                    return method;
                } catch (NoSuchMethodException e5) {
                    i++;
                }
            }
        }
        Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f6414a + " with value type " + this.f6417d);
        return method;
    }

    private Method m7060a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method = null;
        try {
            this.f6419f.writeLock().lock();
            HashMap hashMap2 = (HashMap) hashMap.get(cls);
            if (hashMap2 != null) {
                method = (Method) hashMap2.get(this.f6414a);
            }
            if (method == null) {
                method = m7059a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f6414a, method);
            }
            Method method2 = method;
            this.f6419f.writeLock().unlock();
            return method2;
        } catch (Throwable th) {
            this.f6419f.writeLock().unlock();
        }
    }

    private void m7061b(Class cls) {
        this.f6421h = m7060a(cls, f6413o, "get", null);
    }

    public C1879k m7062a() {
        try {
            C1879k c1879k = (C1879k) super.clone();
            c1879k.f6414a = this.f6414a;
            c1879k.f6415b = this.f6415b;
            c1879k.f6418e = this.f6418e.m6933b();
            c1879k.f6422p = this.f6422p;
            return c1879k;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    void m7063a(float f) {
        this.f6423q = this.f6418e.m6931a(f);
    }

    public void m7064a(C1865c c1865c) {
        this.f6415b = c1865c;
    }

    void m7065a(Class cls) {
        this.f6416c = m7060a(cls, f6412n, "set", this.f6417d);
    }

    void m7066a(Object obj) {
        C1861g c1861g;
        if (this.f6415b != null) {
            try {
                this.f6415b.m6996a(obj);
                Iterator it = this.f6418e.f6347e.iterator();
                while (it.hasNext()) {
                    c1861g = (C1861g) it.next();
                    if (!c1861g.m6944a()) {
                        c1861g.m6943a(this.f6415b.m6996a(obj));
                    }
                }
                return;
            } catch (ClassCastException e) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f6415b.m6997a() + ") on target object " + obj + ". Trying reflection instead");
                this.f6415b = null;
            }
        }
        Class cls = obj.getClass();
        if (this.f6416c == null) {
            m7065a(cls);
        }
        Iterator it2 = this.f6418e.f6347e.iterator();
        while (it2.hasNext()) {
            c1861g = (C1861g) it2.next();
            if (!c1861g.m6944a()) {
                if (this.f6421h == null) {
                    m7061b(cls);
                }
                try {
                    c1861g.m6943a(this.f6421h.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (IllegalAccessException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }
    }

    public void m7067a(String str) {
        this.f6414a = str;
    }

    public void m7068a(float... fArr) {
        this.f6417d = Float.TYPE;
        this.f6418e = C1858h.m6930a(fArr);
    }

    void m7069b() {
        if (this.f6422p == null) {
            C1856l c1856l = this.f6417d == Integer.class ? f6407i : this.f6417d == Float.class ? f6408j : null;
            this.f6422p = c1856l;
        }
        if (this.f6422p != null) {
            this.f6418e.m6932a(this.f6422p);
        }
    }

    void m7070b(Object obj) {
        if (this.f6415b != null) {
            this.f6415b.m6998a(obj, m7072d());
        }
        if (this.f6416c != null) {
            try {
                this.f6420g[0] = m7072d();
                this.f6416c.invoke(obj, this.f6420g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public String m7071c() {
        return this.f6414a;
    }

    public /* synthetic */ Object clone() {
        return m7062a();
    }

    Object m7072d() {
        return this.f6423q;
    }

    public String toString() {
        return this.f6414a + ": " + this.f6418e.toString();
    }
}
