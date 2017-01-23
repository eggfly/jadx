package com.qq.p035e.comm.net.rr;

import com.qq.p035e.comm.net.rr.Request.Method;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* renamed from: com.qq.e.comm.net.rr.PlainRequest */
public class PlainRequest extends AbstractRequest {
    public PlainRequest(String str, Method method, byte[] bArr) {
        super(str, method, bArr);
    }

    public Response initResponse(HttpUriRequest httpUriRequest, HttpResponse httpResponse) {
        return new PlainResponse(httpResponse, httpUriRequest);
    }
}
