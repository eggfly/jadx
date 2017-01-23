package groovyjarjarantlr.collections.impl;

import java.util.Enumeration;

public class Vector implements Cloneable {
    protected int DW;
    protected Object[] j6;

    public Vector() {
        this(10);
    }

    public Vector(int i) {
        this.DW = -1;
        this.j6 = new Object[i];
    }

    public synchronized void j6(Object obj) {
        DW(this.DW + 2);
        Object[] objArr = this.j6;
        int i = this.DW + 1;
        this.DW = i;
        objArr[i] = obj;
    }

    public Object clone() {
        try {
            Vector vector = (Vector) super.clone();
            vector.j6 = new Object[DW()];
            System.arraycopy(this.j6, 0, vector.j6, 0, DW());
            return vector;
        } catch (CloneNotSupportedException e) {
            System.err.println("cannot clone Vector.super");
            return null;
        }
    }

    public synchronized Object j6(int i) {
        if (i >= this.j6.length) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append(i).append(" >= ").append(this.j6.length).toString());
        } else if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append(i).append(" < 0 ").toString());
        }
        return this.j6[i];
    }

    public synchronized Enumeration j6() {
        return new VectorEnumerator(this);
    }

    public synchronized void DW(int i) {
        if (i + 1 > this.j6.length) {
            Object obj = this.j6;
            int length = this.j6.length * 2;
            if (i + 1 > length) {
                length = i + 1;
            }
            this.j6 = new Object[length];
            System.arraycopy(obj, 0, this.j6, 0, obj.length);
        }
    }

    public synchronized void j6(Object obj, int i) {
        if (i >= this.j6.length) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append(i).append(" >= ").append(this.j6.length).toString());
        }
        this.j6[i] = obj;
        if (i > this.DW) {
            this.DW = i;
        }
    }

    public int DW() {
        return this.DW + 1;
    }
}
