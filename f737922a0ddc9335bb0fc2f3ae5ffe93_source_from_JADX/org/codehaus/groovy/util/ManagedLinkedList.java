package org.codehaus.groovy.util;

import java.util.Iterator;

public class ManagedLinkedList<T> {
    private Element<T> DW;
    private Element<T> j6;

    private final class Element<V> extends ManagedReference<V> {
        Element DW;
        final /* synthetic */ ManagedLinkedList FH;
        Element j6;

        public void we() {
            if (!(this.DW == null || this.DW.j6 == null)) {
                this.DW.j6 = this.j6;
            }
            if (!(this.j6 == null || this.j6.DW == null)) {
                this.j6.DW = this.DW;
            }
            if (this == this.FH.DW) {
                this.FH.DW = this.j6;
            }
            this.j6 = null;
            if (this == this.FH.j6) {
                this.FH.j6 = this.DW;
            }
            this.DW = null;
            super.we();
        }
    }

    private final class Iter implements Iterator<T> {
        private boolean DW;
        private Element<T> j6;

        public boolean hasNext() {
            if (this.j6 == null) {
                return false;
            }
            if (this.DW) {
                if (this.j6.j6 == null) {
                    return false;
                }
                return true;
            } else if (this.j6 == null) {
                return false;
            } else {
                return true;
            }
        }

        public T next() {
            if (this.DW) {
                this.j6 = this.j6.j6;
            }
            this.DW = true;
            if (this.j6 == null) {
                return null;
            }
            return this.j6.J0();
        }

        public void remove() {
            if (this.j6 != null) {
                this.j6.we();
            }
        }
    }
}
