package com.qq.p035e.comm.net.rr;

import com.qq.p035e.comm.net.rr.Request.Method;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* renamed from: com.qq.e.comm.net.rr.S2SSRequest */
public class S2SSRequest extends AbstractRequest {
    public S2SSRequest(String str, byte[] bArr) {
        super(str, Method.POST, bArr);
    }

    public byte[] getPostData() {
        return C4063a.m16586a(super.getPostData());
    }

    public Response initResponse(HttpUriRequest httpUriRequest, HttpResponse httpResponse) {
        return new S2SSResponse(httpResponse, httpUriRequest);
    }
}
