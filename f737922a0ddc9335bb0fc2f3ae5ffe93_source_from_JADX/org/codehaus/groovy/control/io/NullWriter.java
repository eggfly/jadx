package org.codehaus.groovy.control.io;

import java.io.Writer;

public class NullWriter extends Writer {
    public static final NullWriter j6;

    static {
        j6 = new NullWriter();
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(char[] cArr, int i, int i2) {
    }
}
