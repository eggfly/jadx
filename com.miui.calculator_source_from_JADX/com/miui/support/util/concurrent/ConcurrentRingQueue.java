package com.miui.support.util.concurrent;

import com.miui.support.util.concurrent.Queue.Predicate;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentRingQueue<T> implements Queue<T> {
    private int f3855a;
    private final boolean f3856b;
    private final boolean f3857c;
    private final AtomicInteger f3858d;
    private volatile Node<T> f3859e;
    private final AtomicInteger f3860f;
    private volatile Node<T> f3861g;
    private volatile int f3862h;

    private static class Node<T> {
        T f3853a;
        Node<T> f3854b;

        private Node() {
        }
    }

    public ConcurrentRingQueue(int i, boolean z, boolean z2) {
        int i2 = 0;
        this.f3855a = i;
        this.f3856b = z;
        this.f3857c = z2;
        this.f3858d = new AtomicInteger(0);
        this.f3860f = new AtomicInteger(0);
        this.f3859e = new Node();
        this.f3861g = this.f3859e;
        Node node = this.f3859e;
        while (i2 < i) {
            node.f3854b = new Node();
            node = node.f3854b;
            i2++;
        }
        node.f3854b = this.f3859e;
    }

    public boolean m5618b(T t) {
        boolean z = true;
        if (t == null) {
            return false;
        }
        int i = this.f3860f.get();
        while (true) {
            if (i == 0 && this.f3860f.compareAndSet(0, -1)) {
                break;
            }
            Thread.yield();
            i = this.f3860f.get();
        }
        Node node = this.f3859e;
        Node node2 = this.f3861g;
        int i2 = this.f3862h;
        if (node2.f3854b != node) {
            node2.f3853a = t;
            if (node2.f3854b.f3854b != node && this.f3857c && i2 > 0) {
                node2.f3854b = node2.f3854b.f3854b;
                this.f3862h = i2 - 1;
            }
            this.f3861g = node2.f3854b;
        } else if (this.f3856b || i2 < 0) {
            node2.f3854b = new Node();
            node2.f3854b.f3854b = node;
            node2.f3853a = t;
            this.f3862h = i2 + 1;
            this.f3861g = node2.f3854b;
        } else {
            z = false;
        }
        this.f3860f.set(0);
        return z;
    }

    public T m5619c() {
        int i = this.f3858d.get();
        while (true) {
            if (i == 0 && this.f3858d.compareAndSet(0, -1)) {
                break;
            }
            Thread.yield();
            i = this.f3858d.get();
        }
        Node node = this.f3859e;
        Node node2 = this.f3861g;
        T t = null;
        while (t == null && node != r0) {
            t = node.f3853a;
            node.f3853a = null;
            node = node.f3854b;
            node2 = this.f3861g;
        }
        if (t != null) {
            this.f3859e = node;
        }
        this.f3858d.set(0);
        return t;
    }

    public boolean m5615a(T t) {
        if (t == null) {
            return false;
        }
        boolean z;
        int i = this.f3858d.get();
        while (true) {
            if (i == 0 && this.f3858d.compareAndSet(0, -1)) {
                break;
            }
            Thread.yield();
            i = this.f3858d.get();
        }
        for (Node node = this.f3859e; node != this.f3861g; node = node.f3854b) {
            if (t.equals(node.f3853a)) {
                node.f3853a = null;
                z = true;
                break;
            }
        }
        z = false;
        this.f3858d.set(0);
        return z;
    }

    public int m5612a(Predicate<T> predicate) {
        if (predicate == null) {
            return 0;
        }
        int i = this.f3858d.get();
        while (true) {
            if (i == 0 && this.f3858d.compareAndSet(0, -1)) {
                try {
                    break;
                } finally {
                    this.f3858d.set(0);
                }
            } else {
                Thread.yield();
                i = this.f3858d.get();
            }
        }
        i = 0;
        for (Node node = this.f3859e; node != this.f3861g; node = node.f3854b) {
            if (predicate.m5495a(node.f3853a)) {
                node.f3853a = null;
                i++;
            }
        }
        return i;
    }

    public boolean m5614a() {
        return this.f3861g == this.f3859e;
    }

    public int m5616b() {
        int i = this.f3862h;
        return i > 0 ? i + this.f3855a : this.f3855a;
    }

    public void m5613a(int i) {
        if (!this.f3856b && i > 0) {
            int i2 = this.f3860f.get();
            while (true) {
                if (i2 == 0 && this.f3860f.compareAndSet(0, -1)) {
                    this.f3862h = -i;
                    this.f3855a += i;
                    this.f3860f.set(0);
                    return;
                }
                Thread.yield();
                i2 = this.f3860f.get();
            }
        }
    }

    public void m5617b(int i) {
        if (this.f3857c && i > 0) {
            int i2 = this.f3860f.get();
            while (true) {
                if (i2 == 0 && this.f3860f.compareAndSet(0, -1)) {
                    this.f3855a -= i;
                    this.f3862h = i;
                    this.f3860f.set(0);
                    return;
                }
                Thread.yield();
                i2 = this.f3860f.get();
            }
        }
    }
}
