package com.qq.p035e.comm.net.rr;

import com.qq.p035e.comm.net.rr.C4063a.C4062b;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* renamed from: com.qq.e.comm.net.rr.S2SSResponse */
public class S2SSResponse extends AbstractResponse {
    public S2SSResponse(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        super(httpResponse, httpUriRequest);
    }

    public byte[] getBytesContent() {
        try {
            return C4063a.m16588b(super.getBytesContent());
        } catch (C4062b e) {
            e.printStackTrace();
            return null;
        }
    }
}
