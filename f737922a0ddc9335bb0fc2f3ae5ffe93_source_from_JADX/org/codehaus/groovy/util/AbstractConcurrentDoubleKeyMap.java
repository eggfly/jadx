package org.codehaus.groovy.util;

public abstract class AbstractConcurrentDoubleKeyMap<K1, K2, V> extends AbstractConcurrentMapBase {

    interface Entry<K1, K2, V> extends org.codehaus.groovy.util.AbstractConcurrentMapBase.Entry<V> {
    }

    static abstract class Segment<K1, K2, V> extends org.codehaus.groovy.util.AbstractConcurrentMapBase.Segment {
        Segment(int i) {
            super(i);
        }
    }

    public /* synthetic */ org.codehaus.groovy.util.AbstractConcurrentMapBase.Segment DW(int i) {
        return j6(i);
    }

    public final Segment<K1, K2, V> j6(int i) {
        return (Segment) this.Zo[(i >>> this.v5) & this.Hw];
    }
}
