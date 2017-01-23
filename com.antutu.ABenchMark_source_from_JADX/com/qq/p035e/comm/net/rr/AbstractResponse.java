package com.qq.p035e.comm.net.rr;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;

/* renamed from: com.qq.e.comm.net.rr.AbstractResponse */
public abstract class AbstractResponse implements Response {
    private final HttpResponse f13531a;
    private final HttpUriRequest f13532b;

    public AbstractResponse(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        this.f13531a = httpResponse;
        this.f13532b = httpUriRequest;
    }

    public void close() {
        if (!(this.f13532b == null || this.f13532b.isAborted())) {
            this.f13532b.abort();
        }
        if (this.f13531a != null) {
            this.f13531a.getEntity().getContent().close();
        }
    }

    public byte[] getBytesContent() {
        if (Constants.COMMAND_HANDSHAKE != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = streamContent.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public int getStatusCode() {
        return this.f13531a.getStatusLine().getStatusCode();
    }

    public InputStream getStreamContent() {
        InputStream content = this.f13531a.getEntity().getContent();
        Header contentEncoding = this.f13531a.getEntity().getContentEncoding();
        return (contentEncoding == null || !contentEncoding.getValue().contains(HttpRequest.f14551d)) ? content : new GZIPInputStream(content);
    }

    public String getStringContent() {
        return getStringContent(HttpRequest.f14548a);
    }

    public String getStringContent(String str) {
        String str2 = null;
        byte[] bytesContent = getBytesContent();
        if (bytesContent == null) {
            return str2;
        }
        if (bytesContent.length == 0) {
            return BuildConfig.FLAVOR;
        }
        try {
            str2 = EntityUtils.getContentCharSet(this.f13531a.getEntity());
        } catch (Throwable th) {
        }
        if (str2 != null) {
            str = str2;
        }
        return new String(bytesContent, str);
    }
}
