package org.codehaus.groovy.util;

import java.util.AbstractList;
import java.util.List;

public class FastArray implements Cloneable {
    public static final FastArray DW;
    private Object[] FH;
    public int j6;

    class 1 extends AbstractList {
        final /* synthetic */ FastArray j6;

        1(FastArray fastArray) {
            this.j6 = fastArray;
        }

        public Object get(int i) {
            return this.j6.j6(i);
        }

        public int size() {
            return this.j6.j6;
        }
    }

    static {
        DW = new FastArray(0);
    }

    public FastArray(int i) {
        this.FH = new Object[i];
    }

    public FastArray() {
        this(8);
    }

    public Object j6(int i) {
        return this.FH[i];
    }

    public int j6() {
        return this.j6;
    }

    public List DW() {
        return new 1(this);
    }

    public String toString() {
        if (j6() == 0) {
            return "[]";
        }
        return DW().toString();
    }
}
