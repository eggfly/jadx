package org.codehaus.groovy.util;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public enum ReferenceType {
    SOFT {
        protected <T, V extends Finalizable> Reference<T, V> j6(T t, V v, ReferenceQueue referenceQueue) {
            return new SoftRef(t, v, referenceQueue);
        }
    },
    WEAK {
        protected <T, V extends Finalizable> Reference<T, V> j6(T t, V v, ReferenceQueue referenceQueue) {
            return new WeakRef(t, v, referenceQueue);
        }
    },
    PHANTOM {
        protected <T, V extends Finalizable> Reference<T, V> j6(T t, V v, ReferenceQueue referenceQueue) {
            return new PhantomRef(t, v, referenceQueue);
        }
    },
    HARD {
        protected <T, V extends Finalizable> Reference<T, V> j6(T t, V v, ReferenceQueue referenceQueue) {
            return new HardRef(t, v, referenceQueue);
        }
    };

    private static class HardRef<TT, V extends Finalizable> implements Reference<TT, V> {
        private final V DW;
        private TT j6;

        public HardRef(TT tt, V v, ReferenceQueue<? super TT> referenceQueue) {
            this.j6 = tt;
            this.DW = v;
        }

        public V j6() {
            return this.DW;
        }

        public TT get() {
            return this.j6;
        }

        public void clear() {
            this.j6 = null;
        }
    }

    private static class PhantomRef<TT, V extends Finalizable> extends PhantomReference<TT> implements Reference<TT, V> {
        private final V j6;

        public PhantomRef(TT tt, V v, ReferenceQueue<? super TT> referenceQueue) {
            super(tt, referenceQueue);
            this.j6 = v;
        }

        public V j6() {
            return this.j6;
        }
    }

    private static class SoftRef<TT, V extends Finalizable> extends SoftReference<TT> implements Reference<TT, V> {
        private final V j6;

        public SoftRef(TT tt, V v, ReferenceQueue<? super TT> referenceQueue) {
            super(tt, referenceQueue);
            this.j6 = v;
        }

        public V j6() {
            return this.j6;
        }
    }

    private static class WeakRef<TT, V extends Finalizable> extends WeakReference<TT> implements Reference<TT, V> {
        private final V j6;

        public WeakRef(TT tt, V v, ReferenceQueue<? super TT> referenceQueue) {
            super(tt, referenceQueue);
            this.j6 = v;
        }

        public V j6() {
            return this.j6;
        }
    }

    protected abstract <T, V extends Finalizable> Reference<T, V> j6(T t, V v, ReferenceQueue referenceQueue);
}
