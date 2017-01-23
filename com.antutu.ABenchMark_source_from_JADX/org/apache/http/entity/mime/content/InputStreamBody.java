package org.apache.http.entity.mime.content;

import java.io.InputStream;
import java.io.OutputStream;
import org.android.spdy.SpdyProtocol;
import org.apache.http.entity.mime.MIME;

public class InputStreamBody extends AbstractContentBody {
    private final String filename;
    private final InputStream in;

    public InputStreamBody(InputStream inputStream, String str) {
        this(inputStream, "application/octet-stream", str);
    }

    public InputStreamBody(InputStream inputStream, String str, String str2) {
        super(str);
        if (inputStream == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        this.in = inputStream;
        this.filename = str2;
    }

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return -1;
    }

    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return this.in;
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            while (true) {
                int read = this.in.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
        } finally {
            this.in.close();
        }
    }

    @Deprecated
    public void writeTo(OutputStream outputStream, int i) {
        writeTo(outputStream);
    }
}
