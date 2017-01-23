package org.apache.http.entity.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.apache.http.util.ByteArrayBuffer;

public class HttpMultipart {
    private static final ByteArrayBuffer CR_LF;
    private static final ByteArrayBuffer FIELD_SEP;
    private static final ByteArrayBuffer TWO_DASHES;
    private final String boundary;
    private final Charset charset;
    private final HttpMultipartMode mode;
    private final List<FormBodyPart> parts;
    private final String subType;

    /* renamed from: org.apache.http.entity.mime.HttpMultipart.1 */
    static /* synthetic */ class C45911 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode;

        static {
            $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode = new int[HttpMultipartMode.values().length];
            try {
                $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[HttpMultipartMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static {
        FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
        CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
        TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
    }

    public HttpMultipart(String str, String str2) {
        this(str, null, str2);
    }

    public HttpMultipart(String str, Charset charset, String str2) {
        this(str, charset, str2, HttpMultipartMode.STRICT);
    }

    public HttpMultipart(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        if (str == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        } else {
            this.subType = str;
            if (charset == null) {
                charset = MIME.DEFAULT_CHARSET;
            }
            this.charset = charset;
            this.boundary = str2;
            this.parts = new ArrayList();
            this.mode = httpMultipartMode;
        }
    }

    private void doWriteTo(HttpMultipartMode httpMultipartMode, OutputStream outputStream, boolean z) {
        ByteArrayBuffer encode = encode(this.charset, getBoundary());
        for (FormBodyPart formBodyPart : this.parts) {
            writeBytes(TWO_DASHES, outputStream);
            writeBytes(encode, outputStream);
            writeBytes(CR_LF, outputStream);
            Header header = formBodyPart.getHeader();
            switch (C45911.$SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[httpMultipartMode.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    Iterator it = header.iterator();
                    while (it.hasNext()) {
                        writeField((MinimalField) it.next(), outputStream);
                    }
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    writeField(formBodyPart.getHeader().getField(MIME.CONTENT_DISPOSITION), this.charset, outputStream);
                    if (formBodyPart.getBody().getFilename() != null) {
                        writeField(formBodyPart.getHeader().getField(MIME.CONTENT_TYPE), this.charset, outputStream);
                        break;
                    }
                    break;
            }
            writeBytes(CR_LF, outputStream);
            if (z) {
                formBodyPart.getBody().writeTo(outputStream);
            }
            writeBytes(CR_LF, outputStream);
        }
        writeBytes(TWO_DASHES, outputStream);
        writeBytes(encode, outputStream);
        writeBytes(TWO_DASHES, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    private static ByteArrayBuffer encode(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private static void writeBytes(String str, OutputStream outputStream) {
        writeBytes(encode(MIME.DEFAULT_CHARSET, str), outputStream);
    }

    private static void writeBytes(String str, Charset charset, OutputStream outputStream) {
        writeBytes(encode(charset, str), outputStream);
    }

    private static void writeBytes(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    private static void writeField(MinimalField minimalField, OutputStream outputStream) {
        writeBytes(minimalField.getName(), outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), outputStream);
        writeBytes(CR_LF, outputStream);
    }

    private static void writeField(MinimalField minimalField, Charset charset, OutputStream outputStream) {
        writeBytes(minimalField.getName(), charset, outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), charset, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    public void addBodyPart(FormBodyPart formBodyPart) {
        if (formBodyPart != null) {
            this.parts.add(formBodyPart);
        }
    }

    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    public String getBoundary() {
        return this.boundary;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public HttpMultipartMode getMode() {
        return this.mode;
    }

    public String getSubType() {
        return this.subType;
    }

    public long getTotalLength() {
        long j = 0;
        for (FormBodyPart body : this.parts) {
            long contentLength = body.getBody().getContentLength();
            if (contentLength < 0) {
                return -1;
            }
            j = contentLength + j;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            doWriteTo(this.mode, byteArrayOutputStream, false);
            return ((long) byteArrayOutputStream.toByteArray().length) + j;
        } catch (IOException e) {
            return -1;
        }
    }

    public void writeTo(OutputStream outputStream) {
        doWriteTo(this.mode, outputStream, true);
    }
}
