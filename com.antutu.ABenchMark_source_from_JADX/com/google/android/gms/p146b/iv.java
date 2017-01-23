package com.google.android.gms.p146b;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.b.iv */
public class iv {
    private AtomicInteger f11497a;
    private final Map<String, Queue<it<?>>> f11498b;
    private final Set<it<?>> f11499c;
    private final PriorityBlockingQueue<it<?>> f11500d;
    private final PriorityBlockingQueue<it<?>> f11501e;
    private final C3345w f11502f;
    private final dx f11503g;
    private final jl f11504h;
    private ey[] f11505i;
    private ax f11506j;
    private List<C3298a> f11507k;

    /* renamed from: com.google.android.gms.b.iv.a */
    public interface C3298a<T> {
        void m13427a(it<T> itVar);
    }

    public iv(C3345w c3345w, dx dxVar) {
        this(c3345w, dxVar, 4);
    }

    public iv(C3345w c3345w, dx dxVar, int i) {
        this(c3345w, dxVar, i, new cw(new Handler(Looper.getMainLooper())));
    }

    public iv(C3345w c3345w, dx dxVar, int i, jl jlVar) {
        this.f11497a = new AtomicInteger();
        this.f11498b = new HashMap();
        this.f11499c = new HashSet();
        this.f11500d = new PriorityBlockingQueue();
        this.f11501e = new PriorityBlockingQueue();
        this.f11507k = new ArrayList();
        this.f11502f = c3345w;
        this.f11503g = dxVar;
        this.f11505i = new ey[i];
        this.f11504h = jlVar;
    }

    public <T> it<T> m13428a(it<T> itVar) {
        itVar.m11980a(this);
        synchronized (this.f11499c) {
            this.f11499c.add(itVar);
        }
        itVar.m11979a(m13432c());
        itVar.m11989b("add-to-queue");
        if (itVar.m12004p()) {
            synchronized (this.f11498b) {
                String e = itVar.m11993e();
                if (this.f11498b.containsKey(e)) {
                    Queue queue = (Queue) this.f11498b.get(e);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(itVar);
                    this.f11498b.put(e, queue);
                    if (ke.f11609b) {
                        ke.m13613a("Request for cacheKey=%s is in flight, putting on hold.", e);
                    }
                } else {
                    this.f11498b.put(e, null);
                    this.f11500d.add(itVar);
                }
            }
        } else {
            this.f11501e.add(itVar);
        }
        return itVar;
    }

    public void m13429a() {
        m13430b();
        this.f11506j = new ax(this.f11500d, this.f11501e, this.f11502f, this.f11504h);
        this.f11506j.start();
        for (int i = 0; i < this.f11505i.length; i++) {
            ey eyVar = new ey(this.f11501e, this.f11503g, this.f11502f, this.f11504h);
            this.f11505i[i] = eyVar;
            eyVar.start();
        }
    }

    public void m13430b() {
        if (this.f11506j != null) {
            this.f11506j.m11845a();
        }
        for (int i = 0; i < this.f11505i.length; i++) {
            if (this.f11505i[i] != null) {
                this.f11505i[i].m12663a();
            }
        }
    }

    <T> void m13431b(it<T> itVar) {
        synchronized (this.f11499c) {
            this.f11499c.remove(itVar);
        }
        synchronized (this.f11507k) {
            for (C3298a a : this.f11507k) {
                a.m13427a(itVar);
            }
        }
        if (itVar.m12004p()) {
            synchronized (this.f11498b) {
                Queue queue = (Queue) this.f11498b.remove(itVar.m11993e());
                if (queue != null) {
                    if (ke.f11609b) {
                        ke.m13613a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f11500d.addAll(queue);
                }
            }
        }
    }

    public int m13432c() {
        return this.f11497a.incrementAndGet();
    }
}
