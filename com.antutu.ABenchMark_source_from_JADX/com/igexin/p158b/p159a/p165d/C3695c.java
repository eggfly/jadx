package com.igexin.p158b.p159a.p165d;

import com.igexin.p158b.p159a.p167c.C3688a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.b.a.d.c */
public class C3695c {
    static final /* synthetic */ boolean f12447i;
    public String f12448a;
    final transient ReentrantLock f12449b;
    final transient Condition f12450c;
    final TreeSet f12451d;
    final AtomicInteger f12452e;
    int f12453f;
    C3684e f12454g;
    public final AtomicLong f12455h;

    static {
        f12447i = !C3695c.class.desiredAssertionStatus();
    }

    public C3695c(Comparator comparator, C3684e c3684e) {
        this.f12448a = getClass().getName();
        this.f12449b = new ReentrantLock();
        this.f12450c = this.f12449b.newCondition();
        this.f12452e = new AtomicInteger(0);
        this.f12455h = new AtomicLong(-1);
        this.f12451d = new TreeSet(comparator);
        this.f12454g = c3684e;
    }

    private C3666d m15111e() {
        C3666d a = m15113a();
        return (a != null && this.f12451d.remove(a)) ? a : null;
    }

    public final int m15112a(C3666d c3666d, long j, TimeUnit timeUnit) {
        ReentrantLock reentrantLock = this.f12449b;
        reentrantLock.lock();
        try {
            if (!this.f12451d.contains(c3666d)) {
                return -1;
            }
            this.f12451d.remove(c3666d);
            c3666d.f12348u = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
            int i = m15114a(c3666d) ? 1 : -2;
            reentrantLock.unlock();
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    C3666d m15113a() {
        try {
            return (C3666d) this.f12451d.first();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public final boolean m15114a(C3666d c3666d) {
        if (c3666d == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f12449b;
        reentrantLock.lock();
        try {
            C3666d a = m15113a();
            int i = this.f12453f + 1;
            this.f12453f = i;
            c3666d.f12349v = i;
            if (this.f12451d.add(c3666d)) {
                c3666d.m14964n();
                if (a == null || this.f12451d.comparator().compare(c3666d, a) < 0) {
                    this.f12450c.signalAll();
                }
                reentrantLock.unlock();
                return true;
            }
            c3666d.f12349v--;
            return false;
        } catch (Exception e) {
            C3688a.m15097b("ScheduleQueue|offer|error");
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean m15115a(Class cls) {
        if (cls == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f12449b;
        reentrantLock.lock();
        try {
            Collection arrayList = new ArrayList();
            Iterator it = this.f12451d.iterator();
            while (it.hasNext()) {
                C3666d c3666d = (C3666d) it.next();
                if (c3666d.getClass() == cls) {
                    arrayList.add(c3666d);
                }
            }
            this.f12451d.removeAll(arrayList);
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    final boolean m15116b() {
        ReentrantLock reentrantLock = this.f12449b;
        reentrantLock.lock();
        try {
            boolean isEmpty = this.f12451d.isEmpty();
            return isEmpty;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.igexin.p158b.p159a.p165d.C3666d m15117c() {
        /*
        r10 = this;
        r2 = 1;
        r1 = 0;
        r3 = r10.f12449b;
        r3.lockInterruptibly();
    L_0x0007:
        r4 = r10.m15113a();	 Catch:{ all -> 0x001c }
        if (r4 != 0) goto L_0x0021;
    L_0x000d:
        r0 = r10.f12452e;	 Catch:{ all -> 0x001c }
        r4 = 1;
        r0.set(r4);	 Catch:{ all -> 0x001c }
        r0 = 0;
        r10.f12453f = r0;	 Catch:{ all -> 0x001c }
        r0 = r10.f12450c;	 Catch:{ all -> 0x001c }
        r0.await();	 Catch:{ all -> 0x001c }
        goto L_0x0007;
    L_0x001c:
        r0 = move-exception;
        r3.unlock();
        throw r0;
    L_0x0021:
        r0 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ all -> 0x001c }
        r6 = r4.m14955a(r0);	 Catch:{ all -> 0x001c }
        r0 = r4.f12339k;	 Catch:{ all -> 0x001c }
        if (r0 != 0) goto L_0x002f;
    L_0x002b:
        r0 = r4.f12340m;	 Catch:{ all -> 0x001c }
        if (r0 == 0) goto L_0x0048;
    L_0x002f:
        r0 = r2;
    L_0x0030:
        r8 = 0;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 <= 0) goto L_0x0038;
    L_0x0036:
        if (r0 == 0) goto L_0x0060;
    L_0x0038:
        r0 = r10.m15111e();	 Catch:{ all -> 0x001c }
        r1 = f12447i;	 Catch:{ all -> 0x001c }
        if (r1 != 0) goto L_0x004a;
    L_0x0040:
        if (r0 != 0) goto L_0x004a;
    L_0x0042:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x001c }
        r0.<init>();	 Catch:{ all -> 0x001c }
        throw r0;	 Catch:{ all -> 0x001c }
    L_0x0048:
        r0 = r1;
        goto L_0x0030;
    L_0x004a:
        r1 = r10.m15116b();	 Catch:{ all -> 0x001c }
        if (r1 != 0) goto L_0x0055;
    L_0x0050:
        r1 = r10.f12450c;	 Catch:{ all -> 0x001c }
        r1.signalAll();	 Catch:{ all -> 0x001c }
    L_0x0055:
        r1 = r10.f12455h;	 Catch:{ all -> 0x001c }
        r4 = -1;
        r1.set(r4);	 Catch:{ all -> 0x001c }
        r3.unlock();
        return r0;
    L_0x0060:
        r0 = r10.f12455h;	 Catch:{ all -> 0x001c }
        r8 = r4.f12348u;	 Catch:{ all -> 0x001c }
        r0.set(r8);	 Catch:{ all -> 0x001c }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001c }
        r0.<init>();	 Catch:{ all -> 0x001c }
        r5 = "schedule take|needAlarm = ";
        r0 = r0.append(r5);	 Catch:{ all -> 0x001c }
        r5 = r10.f12454g;	 Catch:{ all -> 0x001c }
        r5 = r5.f12428t;	 Catch:{ all -> 0x001c }
        r0 = r0.append(r5);	 Catch:{ all -> 0x001c }
        r5 = "|";
        r0 = r0.append(r5);	 Catch:{ all -> 0x001c }
        r5 = r4.getClass();	 Catch:{ all -> 0x001c }
        r5 = r5.getName();	 Catch:{ all -> 0x001c }
        r0 = r0.append(r5);	 Catch:{ all -> 0x001c }
        r5 = "@";
        r0 = r0.append(r5);	 Catch:{ all -> 0x001c }
        r5 = r4.hashCode();	 Catch:{ all -> 0x001c }
        r0 = r0.append(r5);	 Catch:{ all -> 0x001c }
        r0 = r0.toString();	 Catch:{ all -> 0x001c }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ all -> 0x001c }
        r0 = r10.f12454g;	 Catch:{ all -> 0x001c }
        r0 = r0.f12428t;	 Catch:{ all -> 0x001c }
        if (r0 == 0) goto L_0x00ae;
    L_0x00a7:
        r0 = r10.f12454g;	 Catch:{ all -> 0x001c }
        r4 = r4.f12348u;	 Catch:{ all -> 0x001c }
        r0.m15048a(r4);	 Catch:{ all -> 0x001c }
    L_0x00ae:
        r0 = r10.f12450c;	 Catch:{ all -> 0x001c }
        r0.awaitNanos(r6);	 Catch:{ all -> 0x001c }
        goto L_0x0007;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.c.c():com.igexin.b.a.d.d");
    }

    public final void m15118d() {
        this.f12451d.clear();
    }
}
