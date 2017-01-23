package org.android.spdy;

import java.util.Arrays;

public class SpdyByteArray implements Comparable<SpdyByteArray> {
    private byte[] byteArray;
    int dataLength;
    int length;

    SpdyByteArray() {
        this.byteArray = null;
        this.length = 0;
        this.dataLength = 0;
    }

    SpdyByteArray(int i) {
        this.byteArray = new byte[i];
        this.length = i;
        this.dataLength = 0;
    }

    public int compareTo(SpdyByteArray spdyByteArray) {
        return this.length == spdyByteArray.length ? this.byteArray == null ? -1 : spdyByteArray.byteArray == null ? 1 : hashCode() - spdyByteArray.hashCode() : this.length - spdyByteArray.length;
    }

    public byte[] getByteArray() {
        return this.byteArray;
    }

    public int getDataLength() {
        return this.dataLength;
    }

    public void recycle() {
        Arrays.fill(this.byteArray, (byte) 0);
        this.dataLength = 0;
        SpdyBytePool.getInstance().recycle(this);
    }

    void setByteArrayDataLength(int i) {
        this.dataLength = i;
    }
}
