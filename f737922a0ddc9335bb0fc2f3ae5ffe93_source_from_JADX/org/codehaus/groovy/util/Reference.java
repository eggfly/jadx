package org.codehaus.groovy.util;

public interface Reference<T, V extends Finalizable> {
    void clear();

    T get();

    V j6();
}
