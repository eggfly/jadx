package com.qq.p035e.comm.net.rr;

import java.io.InputStream;

/* renamed from: com.qq.e.comm.net.rr.Response */
public interface Response {
    void close();

    byte[] getBytesContent();

    int getStatusCode();

    InputStream getStreamContent();

    String getStringContent();

    String getStringContent(String str);
}
