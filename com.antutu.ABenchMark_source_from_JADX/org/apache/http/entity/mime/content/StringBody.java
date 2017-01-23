package org.apache.http.entity.mime.content;

import com.umeng.message.proguard.C4218e;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import org.android.spdy.SpdyProtocol;
import org.apache.http.entity.mime.MIME;

public class StringBody extends AbstractContentBody {
    private final Charset charset;
    private final byte[] content;

    public StringBody(String str) {
        this(str, "text/plain", null);
    }

    public StringBody(String str, String str2, Charset charset) {
        super(str2);
        if (str == null) {
            throw new IllegalArgumentException("Text may not be null");
        }
        if (charset == null) {
            charset = Charset.forName(C4218e.f14337b);
        }
        this.content = str.getBytes(charset.name());
        this.charset = charset;
    }

    public StringBody(String str, Charset charset) {
        this(str, "text/plain", charset);
    }

    public static StringBody create(String str) {
        return create(str, null, null);
    }

    public static StringBody create(String str, String str2, Charset charset) {
        try {
            return new StringBody(str, str2, charset);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Charset " + charset + " is not supported", e);
        }
    }

    public static StringBody create(String str, Charset charset) {
        return create(str, null, charset);
    }

    public String getCharset() {
        return this.charset.name();
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public String getFilename() {
        return null;
    }

    public Reader getReader() {
        return new InputStreamReader(new ByteArrayInputStream(this.content), this.charset);
    }

    public String getTransferEncoding() {
        return MIME.ENC_8BIT;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    @Deprecated
    public void writeTo(OutputStream outputStream, int i) {
        writeTo(outputStream);
    }
}
