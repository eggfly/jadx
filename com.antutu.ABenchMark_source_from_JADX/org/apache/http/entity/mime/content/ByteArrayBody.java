package org.apache.http.entity.mime.content;

import java.io.OutputStream;
import org.apache.http.entity.mime.MIME;

public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    public ByteArrayBody(byte[] bArr, String str) {
        this(bArr, "application/octet-stream", str);
    }

    public ByteArrayBody(byte[] bArr, String str, String str2) {
        super(str);
        if (bArr == null) {
            throw new IllegalArgumentException("byte[] may not be null");
        }
        this.data = bArr;
        this.filename = str2;
    }

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return (long) this.data.length;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(this.data);
    }
}
