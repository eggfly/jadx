package org.apache.http.entity.mime.content;

import java.io.OutputStream;

public interface ContentBody extends ContentDescriptor {
    String getFilename();

    void writeTo(OutputStream outputStream);
}
