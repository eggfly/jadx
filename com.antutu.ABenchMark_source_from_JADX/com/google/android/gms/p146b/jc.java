package com.google.android.gms.p146b;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.google.android.gms.b.jc */
public class jc<E> extends AbstractSet<E> {
    private final ArrayMap<E, E> f11561a;

    public jc() {
        this.f11561a = new ArrayMap();
    }

    public jc(int i) {
        this.f11561a = new ArrayMap(i);
    }

    public jc(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean m13531a(jc<? extends E> jcVar) {
        int size = size();
        this.f11561a.putAll(jcVar.f11561a);
        return size() > size;
    }

    public boolean add(E e) {
        if (this.f11561a.containsKey(e)) {
            return false;
        }
        this.f11561a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof jc ? m13531a((jc) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f11561a.clear();
    }

    public boolean contains(Object obj) {
        return this.f11561a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f11561a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f11561a.containsKey(obj)) {
            return false;
        }
        this.f11561a.remove(obj);
        return true;
    }

    public int size() {
        return this.f11561a.size();
    }
}
