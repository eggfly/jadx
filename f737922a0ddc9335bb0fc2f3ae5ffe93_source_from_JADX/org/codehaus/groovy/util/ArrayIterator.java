package org.codehaus.groovy.util;

import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private int DW;
    private int FH;
    private final T[] j6;

    public boolean hasNext() {
        return this.FH < this.DW;
    }

    public T next() {
        Object obj = this.j6;
        int i = this.FH;
        this.FH = i + 1;
        return Array.get(obj, i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove not supported for arrays");
    }
}
