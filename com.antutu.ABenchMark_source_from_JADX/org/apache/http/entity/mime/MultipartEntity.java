package org.apache.http.entity.mime;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.message.BasicHeader;

public class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS;
    private final Header contentType;
    private volatile boolean dirty;
    private long length;
    private final HttpMultipart multipart;

    static {
        MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public MultipartEntity() {
        this(HttpMultipartMode.STRICT, null, null);
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode) {
        this(httpMultipartMode, null, null);
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode, String str, Charset charset) {
        if (str == null) {
            str = generateBoundary();
        }
        if (httpMultipartMode == null) {
            httpMultipartMode = HttpMultipartMode.STRICT;
        }
        this.multipart = new HttpMultipart("form-data", charset, str, httpMultipartMode);
        this.contentType = new BasicHeader(MIME.CONTENT_TYPE, generateContentType(str, charset));
        this.dirty = true;
    }

    public void addPart(String str, ContentBody contentBody) {
        addPart(new FormBodyPart(str, contentBody));
    }

    public void addPart(FormBodyPart formBodyPart) {
        this.multipart.addBodyPart(formBodyPart);
        this.dirty = true;
    }

    public void consumeContent() {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    protected String generateBoundary() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            stringBuilder.append(MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)]);
        }
        return stringBuilder.toString();
    }

    protected String generateContentType(String str, Charset charset) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("multipart/form-data; boundary=");
        stringBuilder.append(str);
        if (charset != null) {
            stringBuilder.append("; charset=");
            stringBuilder.append(charset.name());
        }
        return stringBuilder.toString();
    }

    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        if (this.dirty) {
            this.length = this.multipart.getTotalLength();
            this.dirty = false;
        }
        return this.length;
    }

    public Header getContentType() {
        return this.contentType;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isRepeatable() {
        for (FormBodyPart body : this.multipart.getBodyParts()) {
            if (body.getBody().getContentLength() < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public void writeTo(OutputStream outputStream) {
        this.multipart.writeTo(outputStream);
    }
}
