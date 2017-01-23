package org.codehaus.groovy.util;

public class ManagedDoubleKeyMap<K1, K2, V> extends AbstractConcurrentDoubleKeyMap<K1, K2, V> {

    public static class Entry<K1, K2, V> implements Entry<K1, K2, V> {
        final Ref<K2> DW;
        private final int FH;
        final Ref<K1> j6;

        public boolean EQ() {
            return (this.j6.J0() == null || this.DW.J0() == null) ? false : true;
        }

        public V u7() {
            return this;
        }

        public void j6(V v) {
        }

        public int tp() {
            return this.FH;
        }
    }

    private static class EntryWithValue<K1, K2, V> extends Entry<K1, K2, V> {
        private V FH;

        public V u7() {
            return this.FH;
        }

        public void j6(V v) {
            this.FH = v;
        }
    }

    static class Ref<K> extends ManagedReference<K> {
    }

    static class Segment<K1, K2, V> extends Segment<K1, K2, V> {
        private ReferenceBundle v5;

        public Segment(ReferenceBundle referenceBundle, int i) {
            super(i);
            this.v5 = referenceBundle;
        }
    }

    protected /* synthetic */ org.codehaus.groovy.util.AbstractConcurrentMapBase.Segment FH(Object obj, int i) {
        return j6(obj, i);
    }

    protected Segment<K1, K2, V> j6(Object obj, int i) {
        return new Segment((ReferenceBundle) obj, i);
    }
}
