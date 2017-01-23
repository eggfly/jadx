package com.qq.p035e.comm.net;

import com.qq.p035e.comm.net.rr.Request;
import com.qq.p035e.comm.net.rr.Response;

/* renamed from: com.qq.e.comm.net.NetworkCallBack */
public interface NetworkCallBack {
    void onException(Exception exception);

    void onResponse(Request request, Response response);
}
