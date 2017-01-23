package org.codehaus.groovy.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ListHashMap<K, V> implements Map<K, V> {
    private final Object[] DW;
    private int FH;
    private Map<K, V> Hw;
    private final Object[] j6;
    private final int v5;

    public ListHashMap() {
        this(3);
    }

    public ListHashMap(int i) {
        this.FH = 0;
        this.j6 = new Object[i];
        this.DW = new Object[i];
        this.v5 = i;
    }

    public void clear() {
        this.Hw = null;
        for (int i = 0; i < this.v5; i++) {
            this.DW[i] = null;
            this.j6[i] = null;
        }
        this.FH = 0;
    }

    public boolean containsKey(Object obj) {
        if (this.FH >= this.v5) {
            return this.Hw.containsKey(obj);
        }
        for (int i = 0; i < this.FH; i++) {
            if (this.j6[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (this.FH >= this.v5) {
            return this.Hw.containsValue(obj);
        }
        for (int i = 0; i < this.FH; i++) {
            if (this.DW[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    private Map<K, V> j6() {
        Map<K, V> hashMap = new HashMap();
        for (int i = 0; i < this.FH; i++) {
            hashMap.put(this.j6[i], this.DW[i]);
        }
        return hashMap;
    }

    public Set<Entry<K, V>> entrySet() {
        return (this.Hw != null ? this.Hw : j6()).entrySet();
    }

    public V get(Object obj) {
        if (this.FH == 0) {
            return null;
        }
        if (this.Hw != null) {
            return this.Hw.get(obj);
        }
        for (int i = 0; i < this.FH; i++) {
            if (this.j6[i].equals(obj)) {
                return this.DW[i];
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.FH == 0;
    }

    public Set<K> keySet() {
        return (this.Hw != null ? this.Hw : j6()).keySet();
    }

    public V put(K k, V v) {
        if (this.Hw == null) {
            for (int i = 0; i < this.FH; i++) {
                if (this.j6[i].equals(k)) {
                    V v2 = this.DW[i];
                    this.DW[i] = v;
                    return v2;
                }
            }
            if (this.FH < this.v5) {
                this.j6[this.FH] = k;
                this.DW[this.FH] = v;
                this.FH++;
                return null;
            }
            this.Hw = j6();
        }
        V put = this.Hw.put(k, v);
        this.FH = this.Hw.size();
        return put;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object obj) {
        if (this.Hw == null) {
            for (int i = 0; i < this.FH; i++) {
                if (this.j6[i].equals(obj)) {
                    V v = this.DW[i];
                    this.FH--;
                    this.DW[i] = this.DW[this.FH];
                    this.j6[i] = this.j6[this.FH];
                    return v;
                }
            }
            return null;
        }
        V remove = this.Hw.remove(obj);
        this.FH = this.Hw.size();
        if (this.FH > this.v5) {
            return remove;
        }
        DW();
        return remove;
    }

    private void DW() {
        int i = 0;
        for (Entry entry : this.Hw.entrySet()) {
            this.j6[i] = entry.getKey();
            this.DW[i] = entry.getValue();
            i++;
        }
        this.FH = this.Hw.size();
        this.Hw = null;
    }

    public int size() {
        return this.FH;
    }

    public Collection<V> values() {
        if (this.Hw != null) {
            return this.Hw.values();
        }
        ArrayList arrayList = new ArrayList(this.FH);
        for (int i = 0; i < this.FH; i++) {
            arrayList.add(this.DW[i]);
        }
        return arrayList;
    }
}
