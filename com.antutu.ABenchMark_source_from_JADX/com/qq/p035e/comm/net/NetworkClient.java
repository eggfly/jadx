package com.qq.p035e.comm.net;

import com.qq.p035e.comm.net.rr.Request;
import com.qq.p035e.comm.net.rr.Response;
import java.util.concurrent.Future;

/* renamed from: com.qq.e.comm.net.NetworkClient */
public interface NetworkClient {

    /* renamed from: com.qq.e.comm.net.NetworkClient.Priority */
    public enum Priority {
        High(1),
        Mid(2),
        Low(3);
        
        private int f13511a;

        private Priority(int i) {
            this.f13511a = i;
        }

        public final int value() {
            return this.f13511a;
        }
    }

    Future<Response> submit(Request request);

    Future<Response> submit(Request request, Priority priority);

    void submit(Request request, NetworkCallBack networkCallBack);

    void submit(Request request, Priority priority, NetworkCallBack networkCallBack);
}
