package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.android.spdy.SpdyProtocol;

class StrictLineReader implements Closeable {
    private static final byte CR = (byte) 13;
    private static final byte LF = (byte) 10;
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    /* renamed from: com.nostra13.universalimageloader.cache.disc.impl.ext.StrictLineReader.1 */
    class C40271 extends ByteArrayOutputStream {
        C40271(int i) {
            super(i);
        }

        public String toString() {
            int i = (this.count <= 0 || this.buf[this.count - 1] != 13) ? this.count : this.count - 1;
            try {
                return new String(this.buf, 0, i, StrictLineReader.this.charset.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(Util.US_ASCII)) {
            this.in = inputStream;
            this.charset = charset;
            this.buf = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, SpdyProtocol.SLIGHTSSL_1_RTT_MODE, charset);
    }

    private void fillBuf() {
        int read = this.in.read(this.buf, 0, this.buf.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = read;
    }

    public void close() {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }

    public String readLine() {
        String str;
        synchronized (this.in) {
            if (this.buf == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.pos >= this.end) {
                fillBuf();
            }
            int i2 = this.pos;
            while (i2 != this.end) {
                if (this.buf[i2] == LF) {
                    int i3 = (i2 == this.pos || this.buf[i2 - 1] != 13) ? i2 : i2 - 1;
                    str = new String(this.buf, this.pos, i3 - this.pos, this.charset.name());
                    this.pos = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c40271 = new C40271((this.end - this.pos) + 80);
            loop1:
            while (true) {
                c40271.write(this.buf, this.pos, this.end - this.pos);
                this.end = -1;
                fillBuf();
                i = this.pos;
                while (i != this.end) {
                    if (this.buf[i] == LF) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.pos) {
                c40271.write(this.buf, this.pos, i - this.pos);
            }
            this.pos = i + 1;
            str = c40271.toString();
        }
        return str;
    }
}
