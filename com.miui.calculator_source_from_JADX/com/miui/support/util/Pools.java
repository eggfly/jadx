package com.miui.support.util;

import com.miui.support.util.concurrent.ConcurrentRingQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public final class Pools {
    private static final HashMap<Class<?>, InstanceHolder<?>> f3707a;
    private static final HashMap<Class<?>, SoftReferenceInstanceHolder<?>> f3708b;
    private static final Pool<StringBuilder> f3709c;

    public static abstract class Manager<T> {
        public abstract T m3421b();

        public void m3422b(T t) {
        }

        public void m3420a(T t) {
        }

        public void m3423c(T t) {
        }
    }

    /* renamed from: com.miui.support.util.Pools.1 */
    final class C04321 extends Manager<StringBuilder> {
        C04321() {
        }

        public /* synthetic */ Object m5399b() {
            return m5396a();
        }

        public StringBuilder m5396a() {
            return new StringBuilder();
        }

        public void m5398a(StringBuilder stringBuilder) {
            stringBuilder.setLength(0);
        }
    }

    public interface Pool<T> {
        T m5400b();

        void m5401b(T t);
    }

    static abstract class BasePool<T> implements Pool<T> {
        private final Manager<T> f3697a;
        private final int f3698b;
        private IInstanceHolder<T> f3699c;
        private final Object f3700d;

        /* renamed from: com.miui.support.util.Pools.BasePool.1 */
        class C04331 {
            final /* synthetic */ BasePool f3696a;

            C04331(BasePool basePool) {
                this.f3696a = basePool;
            }

            protected void finalize() {
                try {
                    this.f3696a.m5408c();
                } finally {
                    super.finalize();
                }
            }
        }

        abstract IInstanceHolder<T> m5402a(Class<T> cls, int i);

        abstract void m5404a(IInstanceHolder<T> iInstanceHolder, int i);

        public BasePool(Manager<T> manager, int i) {
            this.f3700d = new C04331(this);
            if (manager == null || i < 1) {
                this.f3698b = this.f3700d.hashCode();
                throw new IllegalArgumentException("manager cannot be null and size cannot less then 1");
            }
            this.f3697a = manager;
            this.f3698b = i;
            Object b = this.f3697a.m3421b();
            if (b == null) {
                throw new IllegalStateException("manager create instance cannot return null");
            }
            this.f3699c = m5402a(b.getClass(), i);
            m5405a(b);
        }

        protected final T m5403a() {
            if (this.f3699c == null) {
                throw new IllegalStateException("Cannot acquire object after close()");
            }
            T a = this.f3699c.m5409a();
            if (a == null) {
                a = this.f3697a.m3421b();
                if (a == null) {
                    throw new IllegalStateException("manager create instance cannot return null");
                }
            }
            this.f3697a.m3422b(a);
            return a;
        }

        protected final void m5405a(T t) {
            if (this.f3699c == null) {
                throw new IllegalStateException("Cannot release object after close()");
            } else if (t != null) {
                this.f3697a.m3420a(t);
                if (!this.f3699c.m5410a(t)) {
                    this.f3697a.m3423c(t);
                }
            }
        }

        public T m5406b() {
            return m5403a();
        }

        public void m5407b(T t) {
            m5405a(t);
        }

        public void m5408c() {
            if (this.f3699c != null) {
                m5404a(this.f3699c, this.f3698b);
                this.f3699c = null;
            }
        }
    }

    private interface IInstanceHolder<T> {
        T m5409a();

        boolean m5410a(T t);
    }

    private static class InstanceHolder<T> implements IInstanceHolder<T> {
        private final Class<T> f3701a;
        private final ConcurrentRingQueue<T> f3702b;

        InstanceHolder(Class<T> cls, int i) {
            this.f3701a = cls;
            this.f3702b = new ConcurrentRingQueue(i, false, true);
        }

        public Class<T> m5414b() {
            return this.f3701a;
        }

        public synchronized void m5412a(int i) {
            int b = this.f3702b.m5616b() + i;
            if (b <= 0) {
                synchronized (Pools.f3707a) {
                    Pools.f3707a.remove(m5414b());
                }
            } else if (b > 0) {
                this.f3702b.m5613a(b);
            } else {
                this.f3702b.m5617b(-b);
            }
        }

        public T m5411a() {
            return this.f3702b.m5619c();
        }

        public boolean m5413a(T t) {
            return this.f3702b.m5618b((Object) t);
        }
    }

    public static class SimplePool<T> extends BasePool<T> {
        public /* bridge */ /* synthetic */ Object m5417b() {
            return super.m5406b();
        }

        public /* bridge */ /* synthetic */ void m5418b(Object obj) {
            super.m5407b(obj);
        }

        public /* bridge */ /* synthetic */ void m5419c() {
            super.m5408c();
        }

        SimplePool(Manager<T> manager, int i) {
            super(manager, i);
        }

        final IInstanceHolder<T> m5415a(Class<T> cls, int i) {
            return Pools.m5429a((Class) cls, i);
        }

        final void m5416a(IInstanceHolder<T> iInstanceHolder, int i) {
            Pools.m5432a((InstanceHolder) iInstanceHolder, i);
        }
    }

    private static class SoftReferenceInstanceHolder<T> implements IInstanceHolder<T> {
        private final Class<T> f3703a;
        private volatile SoftReference<T>[] f3704b;
        private volatile int f3705c;
        private volatile int f3706d;

        SoftReferenceInstanceHolder(Class<T> cls, int i) {
            this.f3703a = cls;
            this.f3706d = i;
            this.f3704b = new SoftReference[i];
            this.f3705c = 0;
        }

        public Class<T> m5423b() {
            return this.f3703a;
        }

        public synchronized void m5421a(int i) {
            int i2 = this.f3706d + i;
            if (i2 <= 0) {
                synchronized (Pools.f3708b) {
                    Pools.f3708b.remove(m5423b());
                }
            } else {
                this.f3706d = i2;
                Object obj = this.f3704b;
                int i3 = this.f3705c;
                if (i2 > obj.length) {
                    SoftReference[] softReferenceArr = new SoftReference[i2];
                    System.arraycopy(obj, 0, softReferenceArr, 0, i3);
                    this.f3704b = softReferenceArr;
                }
            }
        }

        public synchronized T m5420a() {
            T t;
            int i = this.f3705c;
            SoftReference[] softReferenceArr = this.f3704b;
            while (i != 0) {
                int i2 = i - 1;
                if (softReferenceArr[i2] != null) {
                    t = softReferenceArr[i2].get();
                    softReferenceArr[i2] = null;
                    if (t != null) {
                        this.f3705c = i2;
                        break;
                    }
                    i = i2;
                } else {
                    i = i2;
                }
            }
            t = null;
            return t;
        }

        public synchronized boolean m5422a(T t) {
            boolean z = true;
            synchronized (this) {
                int i = this.f3705c;
                SoftReference[] softReferenceArr = this.f3704b;
                if (i >= this.f3706d) {
                    int i2 = 0;
                    while (i2 < i) {
                        if (softReferenceArr[i2] == null || softReferenceArr[i2].get() == null) {
                            softReferenceArr[i2] = new SoftReference(t);
                            break;
                        }
                        i2++;
                    }
                    z = false;
                } else {
                    softReferenceArr[i] = new SoftReference(t);
                    this.f3705c = i + 1;
                }
            }
            return z;
        }
    }

    public static class SoftReferencePool<T> extends BasePool<T> {
        public /* bridge */ /* synthetic */ Object m5426b() {
            return super.m5406b();
        }

        public /* bridge */ /* synthetic */ void m5427b(Object obj) {
            super.m5407b(obj);
        }

        public /* bridge */ /* synthetic */ void m5428c() {
            super.m5408c();
        }

        SoftReferencePool(Manager<T> manager, int i) {
            super(manager, i);
        }

        final IInstanceHolder<T> m5424a(Class<T> cls, int i) {
            return Pools.m5434b((Class) cls, i);
        }

        final void m5425a(IInstanceHolder<T> iInstanceHolder, int i) {
            Pools.m5433a((SoftReferenceInstanceHolder) iInstanceHolder, i);
        }
    }

    static {
        f3707a = new HashMap();
        f3708b = new HashMap();
        f3709c = m5435b(new C04321(), 4);
    }

    public static Pool<StringBuilder> m5430a() {
        return f3709c;
    }

    static <T> InstanceHolder<T> m5429a(Class<T> cls, int i) {
        InstanceHolder<T> instanceHolder;
        synchronized (f3707a) {
            instanceHolder = (InstanceHolder) f3707a.get(cls);
            if (instanceHolder == null) {
                instanceHolder = new InstanceHolder(cls, i);
                f3707a.put(cls, instanceHolder);
            } else {
                instanceHolder.m5412a(i);
            }
        }
        return instanceHolder;
    }

    static <T> void m5432a(InstanceHolder<T> instanceHolder, int i) {
        synchronized (f3707a) {
            instanceHolder.m5412a(-i);
        }
    }

    static <T> SoftReferenceInstanceHolder<T> m5434b(Class<T> cls, int i) {
        SoftReferenceInstanceHolder<T> softReferenceInstanceHolder;
        synchronized (f3708b) {
            softReferenceInstanceHolder = (SoftReferenceInstanceHolder) f3708b.get(cls);
            if (softReferenceInstanceHolder == null) {
                softReferenceInstanceHolder = new SoftReferenceInstanceHolder(cls, i);
                f3708b.put(cls, softReferenceInstanceHolder);
            } else {
                softReferenceInstanceHolder.m5421a(i);
            }
        }
        return softReferenceInstanceHolder;
    }

    static <T> void m5433a(SoftReferenceInstanceHolder<T> softReferenceInstanceHolder, int i) {
        synchronized (f3708b) {
            softReferenceInstanceHolder.m5421a(-i);
        }
    }

    public static <T> SimplePool<T> m5431a(Manager<T> manager, int i) {
        return new SimplePool(manager, i);
    }

    public static <T> SoftReferencePool<T> m5435b(Manager<T> manager, int i) {
        return new SoftReferencePool(manager, i);
    }
}
