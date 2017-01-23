package com.mob.tools.gui;

public class CachePool<K, V> {
    private int capacity;
    private Node<K, V> head;
    private int size;
    private Node<K, V> tail;

    private static class Node<K, V> {
        private long cacheTime;
        public K key;
        public Node<K, V> next;
        public Node<K, V> previous;
        public V value;

        private Node() {
        }
    }

    public CachePool(int i) {
        this.capacity = i;
    }

    public synchronized void clear() {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    public synchronized V get(K k) {
        V v = null;
        synchronized (this) {
            if (this.head == null) {
                this.size = 0;
                this.tail = null;
            } else if (this.head.key.equals(k)) {
                v = this.head.value;
            } else {
                Node node = this.head;
                while (node.next != null) {
                    node = node.next;
                    if (node.key.equals(k)) {
                        if (node.next == null) {
                            node.previous.next = null;
                            this.tail = node.previous;
                        } else {
                            node.previous.next = node.next;
                            node.next.previous = node.previous;
                        }
                        node.previous = null;
                        node.next = this.head;
                        this.head.previous = node;
                        this.head = node;
                        v = node.value;
                    }
                }
            }
        }
        return v;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean put(K r6, V r7) {
        /*
        r5 = this;
        r0 = 1;
        r2 = 0;
        r1 = 0;
        monitor-enter(r5);
        if (r6 == 0) goto L_0x000a;
    L_0x0006:
        r3 = r5.capacity;	 Catch:{ all -> 0x002f }
        if (r3 > 0) goto L_0x000d;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        monitor-exit(r5);
        return r0;
    L_0x000d:
        r1 = r2;
    L_0x000e:
        r2 = r5.size;	 Catch:{ all -> 0x002f }
        r3 = r5.capacity;	 Catch:{ all -> 0x002f }
        if (r2 < r3) goto L_0x0057;
    L_0x0014:
        r1 = r5.tail;	 Catch:{ all -> 0x002f }
        if (r1 != 0) goto L_0x0045;
    L_0x0018:
        r2 = com.mob.tools.MobLog.getInstance();	 Catch:{ all -> 0x002f }
        r3 = "size != 0 but tail == null, this must meet any mistake! fix me!!";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x002f }
        r2.m4387w(r3, r4);	 Catch:{ all -> 0x002f }
        r2 = r5.head;	 Catch:{ all -> 0x002f }
        if (r2 != 0) goto L_0x0032;
    L_0x0028:
        r2 = 0;
        r5.size = r2;	 Catch:{ all -> 0x002f }
        r2 = 0;
        r5.tail = r2;	 Catch:{ all -> 0x002f }
        goto L_0x000e;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0032:
        r3 = 1;
        r5.size = r3;	 Catch:{ all -> 0x002f }
    L_0x0035:
        r3 = r2.next;	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x0042;
    L_0x0039:
        r3 = r5.size;	 Catch:{ all -> 0x002f }
        r3 = r3 + 1;
        r5.size = r3;	 Catch:{ all -> 0x002f }
        r2 = r2.next;	 Catch:{ all -> 0x002f }
        goto L_0x0035;
    L_0x0042:
        r5.tail = r2;	 Catch:{ all -> 0x002f }
        goto L_0x000e;
    L_0x0045:
        r2 = r5.tail;	 Catch:{ all -> 0x002f }
        r2 = r2.previous;	 Catch:{ all -> 0x002f }
        r5.tail = r2;	 Catch:{ all -> 0x002f }
        r2 = r5.tail;	 Catch:{ all -> 0x002f }
        r3 = 0;
        r2.next = r3;	 Catch:{ all -> 0x002f }
        r2 = r5.size;	 Catch:{ all -> 0x002f }
        r2 = r2 + -1;
        r5.size = r2;	 Catch:{ all -> 0x002f }
        goto L_0x000e;
    L_0x0057:
        if (r1 != 0) goto L_0x005f;
    L_0x0059:
        r1 = new com.mob.tools.gui.CachePool$Node;	 Catch:{ all -> 0x002f }
        r2 = 0;
        r1.<init>();	 Catch:{ all -> 0x002f }
    L_0x005f:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x002f }
        r1.cacheTime = r2;	 Catch:{ all -> 0x002f }
        r1.key = r6;	 Catch:{ all -> 0x002f }
        r1.value = r7;	 Catch:{ all -> 0x002f }
        r2 = 0;
        r1.previous = r2;	 Catch:{ all -> 0x002f }
        r2 = r5.head;	 Catch:{ all -> 0x002f }
        r1.next = r2;	 Catch:{ all -> 0x002f }
        r2 = r5.size;	 Catch:{ all -> 0x002f }
        if (r2 != 0) goto L_0x0080;
    L_0x0075:
        r5.tail = r1;	 Catch:{ all -> 0x002f }
    L_0x0077:
        r5.head = r1;	 Catch:{ all -> 0x002f }
        r1 = r5.size;	 Catch:{ all -> 0x002f }
        r1 = r1 + 1;
        r5.size = r1;	 Catch:{ all -> 0x002f }
        goto L_0x000b;
    L_0x0080:
        r2 = r5.head;	 Catch:{ all -> 0x002f }
        if (r2 == 0) goto L_0x0089;
    L_0x0084:
        r2 = r5.head;	 Catch:{ all -> 0x002f }
        r2.previous = r1;	 Catch:{ all -> 0x002f }
        goto L_0x0077;
    L_0x0089:
        r2 = com.mob.tools.MobLog.getInstance();	 Catch:{ all -> 0x002f }
        r3 = "size != 0 but head == null, this must meet any mistake! fix me!!";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x002f }
        r2.m4387w(r3, r4);	 Catch:{ all -> 0x002f }
        r5.tail = r1;	 Catch:{ all -> 0x002f }
        r2 = 0;
        r5.size = r2;	 Catch:{ all -> 0x002f }
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.gui.CachePool.put(java.lang.Object, java.lang.Object):boolean");
    }

    public int size() {
        return this.size;
    }

    public synchronized void trimBeforeTime(long j) {
        if (this.capacity > 0) {
            for (Node node = this.head; node != null; node = node.next) {
                if (node.cacheTime < j) {
                    if (node.previous != null) {
                        node.previous.next = node.next;
                    }
                    if (node.next != null) {
                        node.next.previous = node.previous;
                    }
                    if (node.equals(this.head)) {
                        this.head = this.head.next;
                    }
                    this.size--;
                }
            }
        }
    }
}
