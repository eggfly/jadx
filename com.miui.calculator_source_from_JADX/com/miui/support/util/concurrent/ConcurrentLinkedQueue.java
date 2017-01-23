package com.miui.support.util.concurrent;

public class ConcurrentLinkedQueue<T> implements Queue<T> {
    private final java.util.concurrent.ConcurrentLinkedQueue<T> f3852a;

    public ConcurrentLinkedQueue() {
        this.f3852a = new java.util.concurrent.ConcurrentLinkedQueue();
    }

    public boolean m5610b(T t) {
        return this.f3852a.offer(t);
    }

    public T m5611c() {
        return this.f3852a.poll();
    }

    public boolean m5609a(T t) {
        return this.f3852a.remove(t);
    }
}
