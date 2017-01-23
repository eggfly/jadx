package org.codehaus.groovy.util;

public abstract class AbstractConcurrentMap<K, V> extends AbstractConcurrentMapBase {

    public static abstract class Segment<K, V> extends org.codehaus.groovy.util.AbstractConcurrentMapBase.Segment {
        protected abstract Entry<K, V> j6(K k, int i, V v);

        protected Segment(int i) {
            super(i);
        }

        public final V j6(K k, int i) {
            Object[] objArr = this.FH;
            Object obj = objArr[(objArr.length - 1) & i];
            if (obj != null) {
                if (obj instanceof Entry) {
                    Entry entry = (Entry) obj;
                    if (entry.j6(k, i)) {
                        return entry.u7();
                    }
                }
                objArr = (Object[]) obj;
                for (Object obj2 : objArr) {
                    Entry entry2 = (Entry) obj2;
                    if (entry2 != null && entry2.j6(k, i)) {
                        return entry2.u7();
                    }
                }
            }
            return null;
        }

        public final Entry<K, V> DW(K k, int i, V v) {
            Object[] objArr = this.FH;
            Object obj = objArr[(objArr.length - 1) & i];
            if (obj != null) {
                if (obj instanceof Entry) {
                    Entry<K, V> entry = (Entry) obj;
                    if (entry.j6(k, i)) {
                        return entry;
                    }
                }
                objArr = (Object[]) obj;
                for (Object obj2 : objArr) {
                    Entry<K, V> entry2 = (Entry) obj2;
                    if (entry2 != null && entry2.j6(k, i)) {
                        return entry2;
                    }
                }
            }
            return FH(k, i, v);
        }

        public final Entry FH(K k, int i, V v) {
            int i2 = 0;
            Hw();
            try {
                int i3 = this.j6;
                int i4 = i3 + 1;
                if (i3 > this.DW) {
                    j6();
                }
                Object[] objArr = this.FH;
                int length = i & (objArr.length - 1);
                Object obj = objArr[length];
                Entry j6;
                if (obj == null) {
                    j6 = j6(k, i, v);
                    objArr[length] = j6;
                    this.j6 = i4;
                    v5();
                    return j6;
                } else if (obj instanceof Entry) {
                    j6 = (Entry) obj;
                    if (j6.j6(k, i)) {
                        j6.j6(v);
                        return j6;
                    }
                    r2 = new Object[2];
                    r1 = j6(k, i, v);
                    r2[0] = r1;
                    r2[1] = j6;
                    objArr[length] = r2;
                    this.j6 = i4;
                    v5();
                    return r1;
                } else {
                    Object[] objArr2 = (Object[]) obj;
                    int i5 = 0;
                    while (i5 < objArr2.length) {
                        r1 = (Entry) objArr2[i5];
                        if (r1 == null || !r1.j6(k, i)) {
                            i5++;
                        } else {
                            r1.j6(v);
                            v5();
                            return r1;
                        }
                    }
                    Entry j62 = j6(k, i, v);
                    while (i2 < objArr2.length) {
                        if (((Entry) objArr2[i2]) == null) {
                            objArr2[i2] = j62;
                            this.j6 = i4;
                            v5();
                            return j62;
                        }
                        i2++;
                    }
                    Object obj2 = new Object[(objArr2.length + 1)];
                    obj2[0] = j62;
                    System.arraycopy(objArr2, 0, obj2, 1, objArr2.length);
                    objArr[length] = obj2;
                    this.j6 = i4;
                    v5();
                    return j62;
                }
            } finally {
                v5();
            }
        }
    }

    public interface Entry<K, V> extends org.codehaus.groovy.util.AbstractConcurrentMapBase.Entry<V> {
        boolean j6(K k, int i);
    }

    public /* synthetic */ org.codehaus.groovy.util.AbstractConcurrentMapBase.Segment DW(int i) {
        return j6(i);
    }

    public AbstractConcurrentMap(Object obj) {
        super(obj);
    }

    public Segment j6(int i) {
        return (Segment) super.DW(i);
    }

    public V j6(K k) {
        int DW = AbstractConcurrentMapBase.DW((Object) k);
        return j6(DW).j6(k, DW);
    }

    public Entry<K, V> j6(K k, V v) {
        int DW = AbstractConcurrentMapBase.DW((Object) k);
        return j6(DW).DW(k, DW, v);
    }

    public void DW(K k, V v) {
        int DW = AbstractConcurrentMapBase.DW((Object) k);
        j6(DW).FH(k, DW, v);
    }
}
