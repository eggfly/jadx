package com.qq.p035e.comm.net;

import anet.channel.util.HttpConstant;
import com.qq.p035e.comm.net.NetworkClient.Priority;
import com.qq.p035e.comm.net.rr.Request;
import com.qq.p035e.comm.net.rr.Request.Method;
import com.qq.p035e.comm.net.rr.Response;
import com.qq.p035e.comm.util.GDTLogger;
import com.umeng.message.util.HttpRequest;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyProtocol;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* renamed from: com.qq.e.comm.net.NetworkClientImpl */
public class NetworkClientImpl implements NetworkClient {
    private static final HttpClient f13516a;
    private static final NetworkClient f13517b;
    private final ExecutorService f13518c;
    private PriorityBlockingQueue<Runnable> f13519d;

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl.1 */
    static /* synthetic */ class C40601 {
        static final /* synthetic */ int[] f13512a;

        static {
            f13512a = new int[Method.values().length];
            try {
                f13512a[Method.POST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13512a[Method.GET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl.NetFutureTask */
    class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {
        private final Priority f13513a;

        public NetFutureTask(NetworkClientImpl networkClientImpl, Callable<T> callable, Priority priority) {
            super(callable);
            this.f13513a = priority;
        }

        public int compareTo(NetFutureTask<T> netFutureTask) {
            return netFutureTask == null ? 1 : this.f13513a.value() - netFutureTask.f13513a.value();
        }
    }

    /* renamed from: com.qq.e.comm.net.NetworkClientImpl.TaskCallable */
    static class TaskCallable implements Callable<Response> {
        private Request f13514a;
        private NetworkCallBack f13515b;

        public TaskCallable(Request request) {
            this(request, null);
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            this.f13514a = request;
            this.f13515b = networkCallBack;
        }

        private void m16583a(HttpRequestBase httpRequestBase) {
            for (Entry entry : this.f13514a.getHeaders().entrySet()) {
                httpRequestBase.setHeader((String) entry.getKey(), (String) entry.getValue());
            }
            httpRequestBase.setHeader(HttpRequest.f14569v, "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
            httpRequestBase.addHeader(HttpRequest.f14554g, HttpRequest.f14551d);
            HttpParams params = httpRequestBase.getParams();
            if (params == null) {
                params = new BasicHttpParams();
            }
            if (this.f13514a.getConnectionTimeOut() > 0) {
                HttpConnectionParams.setConnectionTimeout(params, this.f13514a.getConnectionTimeOut());
            }
            if (this.f13514a.getSocketTimeOut() > 0) {
                HttpConnectionParams.setSoTimeout(params, this.f13514a.getSocketTimeOut());
            }
            httpRequestBase.setParams(params);
        }

        public Response call() {
            Throwable th;
            Response response = null;
            try {
                HttpUriRequest httpPost;
                HttpClient a = NetworkClientImpl.f13516a;
                switch (C40601.f13512a[this.f13514a.getMethod().ordinal()]) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        httpPost = new HttpPost(this.f13514a.getUrlWithParas());
                        m16583a(httpPost);
                        byte[] postData = this.f13514a.getPostData();
                        if (postData != null && postData.length > 0) {
                            httpPost.setEntity(new ByteArrayEntity(postData));
                            break;
                        }
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        httpPost = new HttpGet(this.f13514a.getUrlWithParas());
                        m16583a(httpPost);
                        break;
                    default:
                        httpPost = null;
                        break;
                }
                response = this.f13514a.initResponse(httpPost, a.execute(httpPost));
                th = null;
            } catch (Exception e) {
                th = e;
            }
            if (th == null) {
                if (this.f13515b != null) {
                    this.f13515b.onResponse(this.f13514a, response);
                }
                if (this.f13514a.isAutoClose()) {
                    response.close();
                }
            } else if (this.f13515b != null) {
                GDTLogger.m16604w("NetworkClientException", th);
                this.f13515b.onException(th);
                if (response != null) {
                    response.close();
                }
            } else {
                throw th;
            }
            return response;
        }
    }

    static {
        f13517b = new NetworkClientImpl();
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(3));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, HttpRequest.f14548a);
        HttpProtocolParams.setUserAgent(basicHttpParams, "GDTADNetClient-[" + System.getProperty("http.agent") + "]");
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpConstant.HTTP, PlainSocketFactory.getSocketFactory(), 80));
        f13516a = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    private NetworkClientImpl() {
        this.f13519d = new PriorityBlockingQueue(15);
        this.f13518c = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.f13519d);
    }

    public static NetworkClient getInstance() {
        return f13517b;
    }

    public Future<Response> submit(Request request) {
        return submit(request, Priority.Mid);
    }

    public Future<Response> submit(Request request, Priority priority) {
        Object netFutureTask = new NetFutureTask(this, new TaskCallable(request), priority);
        this.f13518c.execute(netFutureTask);
        GDTLogger.m16599d("QueueSize:" + this.f13519d.size());
        return netFutureTask;
    }

    public void submit(Request request, NetworkCallBack networkCallBack) {
        submit(request, Priority.Mid, networkCallBack);
    }

    public void submit(Request request, Priority priority, NetworkCallBack networkCallBack) {
        this.f13518c.execute(new NetFutureTask(this, new TaskCallable(request, networkCallBack), priority));
        GDTLogger.m16599d("QueueSize:" + this.f13519d.size());
    }
}
