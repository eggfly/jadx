package org.codehaus.groovy.util;

public class ComplexKeyHashMap {
    protected transient int DW;
    protected Entry[] j6;

    public interface EntryIterator {
    }

    class 1 implements EntryIterator {
    }

    public static class Entry {
    }

    public ComplexKeyHashMap() {
        j6(32);
    }

    public void j6(int i) {
        this.DW = (i * 6) / 8;
        this.j6 = new Entry[i];
    }
}
