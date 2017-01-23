package com.nostra13.universalimageloader.core.assist;

import java.io.InputStream;

public class ContentLengthInputStream extends InputStream {
    private final int length;
    private final InputStream stream;

    public ContentLengthInputStream(InputStream inputStream, int i) {
        this.stream = inputStream;
        this.length = i;
    }

    public int available() {
        return this.length;
    }

    public void close() {
        this.stream.close();
    }

    public void mark(int i) {
        this.stream.mark(i);
    }

    public boolean markSupported() {
        return this.stream.markSupported();
    }

    public int read() {
        return this.stream.read();
    }

    public int read(byte[] bArr) {
        return this.stream.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) {
        return this.stream.read(bArr, i, i2);
    }

    public void reset() {
        this.stream.reset();
    }

    public long skip(long j) {
        return this.stream.skip(j);
    }
}
