package org.apache.http.entity.mime.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.android.spdy.SpdyProtocol;
import org.apache.http.entity.mime.MIME;

public class FileBody extends AbstractContentBody {
    private final String charset;
    private final File file;
    private final String filename;

    public FileBody(File file) {
        this(file, "application/octet-stream");
    }

    public FileBody(File file, String str) {
        this(file, str, null);
    }

    public FileBody(File file, String str, String str2) {
        this(file, null, str, str2);
    }

    public FileBody(File file, String str, String str2, String str3) {
        super(str2);
        if (file == null) {
            throw new IllegalArgumentException("File may not be null");
        }
        this.file = file;
        if (str != null) {
            this.filename = str;
        } else {
            this.filename = file.getName();
        }
        this.charset = str3;
    }

    public String getCharset() {
        return this.charset;
    }

    public long getContentLength() {
        return this.file.length();
    }

    public File getFile() {
        return this.file;
    }

    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.file);
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream fileInputStream = new FileInputStream(this.file);
        try {
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            outputStream.flush();
        } finally {
            fileInputStream.close();
        }
    }

    @Deprecated
    public void writeTo(OutputStream outputStream, int i) {
        writeTo(outputStream);
    }
}
