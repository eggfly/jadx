package groovyjarjarantlr.collections.impl;

import java.util.Enumeration;
import java.util.NoSuchElementException;

class VectorEnumerator implements Enumeration {
    int DW;
    Vector j6;

    VectorEnumerator(Vector vector) {
        this.j6 = vector;
        this.DW = 0;
    }

    public boolean hasMoreElements() {
        boolean z;
        synchronized (this.j6) {
            z = this.DW <= this.j6.DW;
        }
        return z;
    }

    public Object nextElement() {
        Object obj;
        synchronized (this.j6) {
            if (this.DW <= this.j6.DW) {
                Object[] objArr = this.j6.j6;
                int i = this.DW;
                this.DW = i + 1;
                obj = objArr[i];
            } else {
                throw new NoSuchElementException("VectorEnumerator");
            }
        }
        return obj;
    }
}
