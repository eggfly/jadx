package org.codehaus.groovy.util;

import java.util.concurrent.ConcurrentHashMap;

public class ManagedConcurrentValueMap<K, V> {
    private final ConcurrentHashMap<K, ManagedReference<V>> j6;

    class 1 extends ManagedReference<V> {
        final /* synthetic */ ManagedConcurrentValueMap DW;
        final /* synthetic */ Object j6;

        public void we() {
            super.we();
            this.DW.j6.remove(this.j6, J0());
        }
    }
}
