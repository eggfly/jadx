package org.codehaus.groovy.util;

public class ManagedConcurrentMap<K, V> extends AbstractConcurrentMap<K, V> {
    protected ReferenceBundle VH;

    public static class Segment<K, V> extends org.codehaus.groovy.util.AbstractConcurrentMap.Segment<K, V> {
        protected final ReferenceBundle v5;

        public Segment(ReferenceBundle referenceBundle, int i) {
            super(i);
            this.v5 = referenceBundle;
            if (referenceBundle == null) {
                throw new IllegalArgumentException("bundle must not be null");
            }
        }

        protected org.codehaus.groovy.util.AbstractConcurrentMap.Entry<K, V> j6(K k, int i, V v) {
            if (this.v5 != null) {
                return new EntryWithValue(this.v5, this, k, i, v);
            }
            throw new IllegalArgumentException("bundle must not be null");
        }
    }

    public static class Entry<K, V> extends ManagedReference<K> implements org.codehaus.groovy.util.AbstractConcurrentMap.Entry<K, V> {
        private int DW;
        private final Segment j6;

        public Entry(ReferenceBundle referenceBundle, Segment segment, K k, int i) {
            super(referenceBundle, k);
            this.j6 = segment;
            this.DW = i;
        }

        public boolean EQ() {
            return J0() != null;
        }

        public boolean j6(K k, int i) {
            return this.DW == i && J0() == k;
        }

        public V u7() {
            return this;
        }

        public void j6(V v) {
        }

        public int tp() {
            return this.DW;
        }
    }

    public static class EntryWithValue<K, V> extends Entry<K, V> {
        private V j6;

        public EntryWithValue(ReferenceBundle referenceBundle, Segment segment, K k, int i, V v) {
            super(referenceBundle, segment, k, i);
            j6(v);
        }

        public V u7() {
            return this.j6;
        }

        public void j6(V v) {
            this.j6 = v;
        }
    }

    protected /* synthetic */ org.codehaus.groovy.util.AbstractConcurrentMapBase.Segment FH(Object obj, int i) {
        return DW(obj, i);
    }

    public ManagedConcurrentMap(ReferenceBundle referenceBundle) {
        super(referenceBundle);
        this.VH = referenceBundle;
        if (referenceBundle == null) {
            throw new IllegalArgumentException("bundle must not be null");
        }
    }

    protected Segment<K, V> DW(Object obj, int i) {
        ReferenceBundle referenceBundle = (ReferenceBundle) obj;
        if (referenceBundle != null) {
            return new Segment(referenceBundle, i);
        }
        throw new IllegalArgumentException("bundle must not be null");
    }
}
