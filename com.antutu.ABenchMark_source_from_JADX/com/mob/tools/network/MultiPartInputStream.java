package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiPartInputStream extends InputStream {
    private int curIs;
    private ArrayList<InputStream> isList;

    MultiPartInputStream() {
        this.isList = new ArrayList();
    }

    private boolean isEmpty() {
        return this.isList == null || this.isList.size() <= 0;
    }

    public void addInputStream(InputStream inputStream) {
        this.isList.add(inputStream);
    }

    public int available() {
        return isEmpty() ? 0 : ((InputStream) this.isList.get(this.curIs)).available();
    }

    public void close() {
        Iterator it = this.isList.iterator();
        while (it.hasNext()) {
            ((InputStream) it.next()).close();
        }
    }

    public int read() {
        if (isEmpty()) {
            return -1;
        }
        int read = ((InputStream) this.isList.get(this.curIs)).read();
        while (read < 0) {
            this.curIs++;
            if (this.curIs >= this.isList.size()) {
                return read;
            }
            read = ((InputStream) this.isList.get(this.curIs)).read();
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (isEmpty()) {
            return -1;
        }
        int read = ((InputStream) this.isList.get(this.curIs)).read(bArr, i, i2);
        while (read < 0) {
            this.curIs++;
            if (this.curIs >= this.isList.size()) {
                return read;
            }
            read = ((InputStream) this.isList.get(this.curIs)).read(bArr, i, i2);
        }
        return read;
    }

    public long skip(long j) {
        throw new IOException();
    }
}
