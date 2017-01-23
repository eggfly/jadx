package anet.channel.session;

import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Pair;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.p017a.C0644a;
import anet.channel.p017a.C0646b.C0645a;
import anet.channel.p018b.C0653b;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.C0739d;
import anet.channel.util.C0744e;
import anet.channel.util.C0745f;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import com.antutu.utils.HttpUtil;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.internal.C4103b;
import com.umeng.analytics.social.C4188e;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.android.spdy.SpdyRequest;

/* renamed from: anet.channel.session.c */
public class C0690c {

    /* renamed from: anet.channel.session.c.a */
    public static class C0689a {
        public int f2270a;
        public byte[] f2271b;
        public Map<String, List<String>> f2272c;
    }

    private C0690c() {
    }

    public static C0689a m2820a(Request request, RequestCb requestCb) {
        C0689a c0689a = new C0689a();
        HttpURLConnection httpURLConnection = null;
        while (request != null && request.getUrl() != null) {
            if (!NetworkStatusHelper.m2846e()) {
                request.rs.sendBeforeTime = System.currentTimeMillis() - request.rs.start;
                C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_NO_NETWORK, null);
                break;
            }
            try {
                request.rs.sendBeforeTime = System.currentTimeMillis() - request.rs.start;
                if (ALog.isPrintLog(2)) {
                    ALog.m2963i("awcn.HttpConnector", BuildConfig.FLAVOR, request.getSeq(), "request URL", request.getUrlString());
                    ALog.m2963i("awcn.HttpConnector", BuildConfig.FLAVOR, request.getSeq(), "request headers", request.getHeaders());
                }
                httpURLConnection = C0690c.m2821a(request);
                if (httpURLConnection != null) {
                    httpURLConnection.connect();
                    C0690c.m2825b(httpURLConnection, request);
                    c0689a.f2270a = httpURLConnection.getResponseCode();
                    c0689a.f2272c = C0739d.m2969a(httpURLConnection.getHeaderFields());
                    ALog.m2963i("awcn.HttpConnector", "heads:" + c0689a.f2272c, request.getSeq(), new Object[0]);
                    if (!C0739d.m2971a(request, c0689a.f2270a, c0689a.f2272c)) {
                        if (c0689a.f2270a == ErrorCode.DM_PACKAGENAME_INVALID || c0689a.f2270a == 204 || (c0689a.f2270a >= 100 && c0689a.f2270a < Constants.COMMAND_HANDSHAKE)) {
                            requestCb.onResponseCode(c0689a.f2270a, c0689a.f2272c);
                        } else {
                            if (!(C0739d.m2974b(c0689a.f2272c) || requestCb == null)) {
                                requestCb.onResponseCode(c0689a.f2270a, c0689a.f2272c);
                            }
                            C0690c.m2824a(httpURLConnection, request, c0689a, requestCb);
                        }
                        request.rs.oneWayTime = System.currentTimeMillis() - request.rs.start;
                        request.rs.ret = true;
                        if (requestCb != null) {
                            requestCb.onFinish(c0689a.f2270a, HttpConstant.SUCCESS, request.rs);
                        }
                    } else if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable e) {
                            ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e, new Object[0]);
                        }
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e2) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e2, new Object[0]);
                    }
                }
            } catch (Throwable e22) {
                C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_UNKNOWN_HOST_EXCEPTION, e22);
                ALog.m2962e("awcn.HttpConnector", "Unknown Host Exception", request.getSeq(), C4103b.ELECTION_KEY_HOST, request.getHost(), e22);
                NetworkStatusHelper.m2850i();
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e222) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e222, new Object[0]);
                    }
                }
            } catch (Throwable e2222) {
                C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_SOCKET_TIME_OUT, e2222);
                ALog.m2961e("awcn.HttpConnector", "HTTP Socket Timeout", request.getSeq(), e2222, new Object[0]);
                NetworkStatusHelper.m2850i();
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e22222) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e22222, new Object[0]);
                    }
                }
            } catch (Throwable e222222) {
                C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_CONN_TIME_OUT, e222222);
                ALog.m2961e("awcn.HttpConnector", "HTTP Connect Timeout", request.getSeq(), e222222, new Object[0]);
                NetworkStatusHelper.m2850i();
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e2222222) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e2222222, new Object[0]);
                    }
                }
            } catch (Throwable e22222222) {
                C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_CONNECT_EXCEPTION, e22222222);
                ALog.m2961e("awcn.HttpConnector", "HTTP Connect Exception", request.getSeq(), e22222222, new Object[0]);
                NetworkStatusHelper.m2850i();
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e222222222) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e222222222, new Object[0]);
                    }
                }
            } catch (Throwable e2222222222) {
                C0653b.m2767a().m2769a(3, request.getHost());
                C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_SSL_ERROR, e2222222222);
                ALog.m2962e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", request.getSeq(), C4103b.ELECTION_KEY_HOST, request.getHost(), e2222222222);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e22222222222) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e22222222222, new Object[0]);
                    }
                }
            } catch (Throwable e222222222222) {
                C0653b.m2767a().m2769a(3, request.getHost());
                C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_SSL_ERROR, e222222222222);
                ALog.m2962e("awcn.HttpConnector", "connect SSLException", request.getSeq(), C4103b.ELECTION_KEY_HOST, request.getHost(), e222222222222);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e2222222222222) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e2222222222222, new Object[0]);
                    }
                }
            } catch (Throwable e22222222222222) {
                C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_REQUEST_CANCEL, e22222222222222);
                ALog.m2961e("awcn.HttpConnector", "HTTP Request Cancel", request.getSeq(), e22222222222222, new Object[0]);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e222222222222222) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e222222222222222, new Object[0]);
                    }
                }
            } catch (Throwable e2222222222222222) {
                String message = e2222222222222222.getMessage();
                if (message == null || !message.contains("not verified")) {
                    C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_EXCEPTION, e2222222222222222);
                } else {
                    C0653b.m2767a().m2769a(3, request.getHost());
                    C0690c.m2822a(request, c0689a, requestCb, ErrorConstant.ERROR_HOST_NOT_VERIFY_ERROR, e2222222222222222);
                }
                ALog.m2961e("awcn.HttpConnector", "HTTP Connect Exception", request.getSeq(), e2222222222222222, new Object[0]);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e22222222222222222) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e22222222222222222, new Object[0]);
                    }
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e3) {
                        ALog.m2961e("awcn.HttpConnector", "http disconnect", null, e3, new Object[0]);
                    }
                }
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(ErrorConstant.ERROR_PARAM_ILLEGAL, ErrorConstant.getErrMsg(ErrorConstant.ERROR_PARAM_ILLEGAL), new RequestStatistic(null, null));
        }
        return c0689a;
    }

    private static HttpURLConnection m2821a(Request request) {
        C0745f c0745f;
        Pair h = NetworkStatusHelper.m2849h();
        Proxy proxy = h != null ? new Proxy(Type.HTTP, new InetSocketAddress((String) h.first, ((Integer) h.second).intValue())) : null;
        if (NetworkStatusHelper.m2839a().isMobile()) {
            C0745f proxySetting = GlobalAppRuntimeInfo.getProxySetting();
            if (proxySetting != null) {
                proxy = proxySetting.f2432a;
                c0745f = proxySetting;
            } else {
                c0745f = proxySetting;
            }
        } else {
            c0745f = null;
        }
        try {
            URL url = request.getUrl();
            HttpURLConnection httpURLConnection = proxy != null ? (HttpURLConnection) url.openConnection(proxy) : (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setConnectTimeout(request.getConnectTimeout());
                httpURLConnection.setReadTimeout(request.getReadTimeout());
                String method = request.getMethod().toString();
                httpURLConnection.setRequestMethod(method);
                if (SpdyRequest.POST_METHOD.equalsIgnoreCase(method)) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                }
                httpURLConnection.addRequestProperty(HttpConstant.HOST, request.getHost());
                if (NetworkStatusHelper.m2844c().equals(HttpUtil.APN_CMWAP)) {
                    httpURLConnection.setRequestProperty(HttpConstant.X_ONLINE_HOST, request.getHost());
                }
                Map headers = request.getHeaders();
                if (headers != null) {
                    for (Entry entry : headers.entrySet()) {
                        httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (!headers.containsKey(HttpRequest.f14554g)) {
                    httpURLConnection.addRequestProperty(HttpRequest.f14554g, HttpRequest.f14551d);
                }
                if (c0745f != null) {
                    httpURLConnection.setRequestProperty(HttpRequest.f14555h, c0745f.m2982a());
                }
                if (url.getProtocol().equalsIgnoreCase(HttpConstant.HTTPS)) {
                    C0690c.m2823a(httpURLConnection, request);
                }
                httpURLConnection.setInstanceFollowRedirects(false);
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private static void m2822a(Request request, C0689a c0689a, RequestCb requestCb, int i, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i);
        ALog.m2962e("awcn.HttpConnector", "onException", request.getSeq(), Constants.KEY_ERROR_CODE, Integer.valueOf(i), "errMsg", errMsg, "url", request.getUrlString(), C4103b.ELECTION_KEY_HOST, request.getHost());
        if (c0689a != null) {
            c0689a.f2270a = i;
        }
        request.rs.oneWayTime = System.currentTimeMillis() - request.rs.start;
        if (requestCb != null) {
            requestCb.onFinish(i, errMsg, request.rs);
        }
        if (i != ErrorConstant.ERROR_REQUEST_CANCEL) {
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(i, errMsg, request.rs, th));
        }
    }

    private static void m2823a(HttpURLConnection httpURLConnection, Request request) {
        if (Integer.parseInt(VERSION.SDK) < 8) {
            ALog.m2962e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo \u4ee5\u4e0b\u7248\u672c\u4e0d\u652f\u6301https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (C0744e.m2977a() != null) {
            httpsURLConnection.setSSLSocketFactory(C0744e.m2977a());
        }
        if (C0744e.m2980b() != null) {
            httpsURLConnection.setHostnameVerifier(C0744e.m2980b());
        } else if (request.isHostnameVerifyEnable()) {
            httpsURLConnection.setHostnameVerifier(new C0691d(request));
        } else {
            httpsURLConnection.setHostnameVerifier(C0744e.ALLOW_ALL_HOSTNAME_VERIFIER);
        }
    }

    private static void m2824a(HttpURLConnection httpURLConnection, Request request, C0689a c0689a, RequestCb requestCb) {
        InputStream inputStream;
        InputStream errorStream;
        Throwable e;
        int i = 0;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Throwable e2) {
            try {
                errorStream = httpURLConnection.getErrorStream();
            } catch (Throwable e3) {
                ALog.m2961e("awcn.HttpConnector", "get error stream failed." + httpURLConnection.getURL().toString(), request.getSeq(), e3, new Object[0]);
                errorStream = null;
            }
            ALog.m2964w("awcn.HttpConnector", httpURLConnection.getURL().toString(), null, e2, new Object[0]);
            inputStream = errorStream;
        }
        if (inputStream == null) {
            C0690c.m2822a(request, c0689a, requestCb, C4188e.f14077t, null);
            return;
        }
        OutputStream byteArrayOutputStream;
        int c = C0739d.m2975c(c0689a.f2272c);
        boolean b = C0739d.m2974b(c0689a.f2272c);
        if (b) {
            c0689a.f2272c.remove(HttpRequest.f14557j);
        }
        if (requestCb == null || (b && c <= AccessibilityNodeInfoCompat.ACTION_DISMISS)) {
            if (c <= 0) {
                c = IXAdIOUtils.BUFFER_SIZE;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(c);
        } else {
            byteArrayOutputStream = null;
        }
        if (b) {
            try {
                errorStream = new GZIPInputStream(inputStream);
            } catch (Throwable th) {
                e3 = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw e3;
            }
        }
        errorStream = inputStream;
        C0644a c0644a = null;
        while (!Thread.currentThread().isInterrupted()) {
            if (c0644a == null) {
                try {
                    c0644a = C0645a.f2174a.m2763a((int) Message.FLAG_RET);
                } catch (Throwable th2) {
                    inputStream = errorStream;
                    e3 = th2;
                }
            }
            int a = c0644a.m2757a(errorStream);
            if (a != -1) {
                if (request.rs.firstDataTime == 0) {
                    request.rs.firstDataTime = System.currentTimeMillis() - request.rs.start;
                }
                i += a;
                if (byteArrayOutputStream != null) {
                    c0644a.m2758a(byteArrayOutputStream);
                } else {
                    requestCb.onDataReceive(c0644a, false);
                    c0644a = null;
                }
            } else {
                if (byteArrayOutputStream != null) {
                    c0644a.m2762d();
                } else {
                    requestCb.onDataReceive(c0644a, true);
                }
                request.rs.recDataTime = (System.currentTimeMillis() - request.rs.start) - request.rs.firstDataTime;
                request.rs.recDataSize = (long) i;
                if (byteArrayOutputStream != null) {
                    c0689a.f2271b = byteArrayOutputStream.toByteArray();
                    if (b) {
                        List arrayList = new ArrayList();
                        arrayList.add(String.valueOf(c0689a.f2271b.length));
                        c0689a.f2272c.put(HttpRequest.f14558k, arrayList);
                    }
                    if (requestCb != null) {
                        requestCb.onResponseCode(c0689a.f2270a, c0689a.f2272c);
                        requestCb.onDataReceive(C0644a.m2754a(c0689a.f2271b), true);
                    }
                }
                if (errorStream != null) {
                    try {
                        errorStream.close();
                        return;
                    } catch (IOException e5) {
                        return;
                    }
                }
                return;
            }
        }
        throw new CancellationException("task cancelled");
    }

    private static void m2825b(HttpURLConnection httpURLConnection, Request request) {
        if (SpdyRequest.POST_METHOD.equalsIgnoreCase(request.getMethod().toString())) {
            int postBody;
            long currentTimeMillis = System.currentTimeMillis();
            OutputStream outputStream = null;
            try {
                outputStream = httpURLConnection.getOutputStream();
                postBody = request.postBody(outputStream);
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (Throwable e) {
                        ALog.m2961e("awcn.HttpConnector", "postData", request.getSeq(), e, new Object[0]);
                    }
                }
            } catch (Throwable e2) {
                ALog.m2961e("awcn.HttpConnector", "postData error", request.getSeq(), e2, new Object[0]);
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                        postBody = 0;
                    } catch (Throwable e22) {
                        ALog.m2961e("awcn.HttpConnector", "postData", request.getSeq(), e22, new Object[0]);
                        postBody = 0;
                    }
                } else {
                    postBody = 0;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (Throwable e3) {
                        ALog.m2961e("awcn.HttpConnector", "postData", request.getSeq(), e3, new Object[0]);
                    }
                }
            }
            request.rs.sendDataSize = (long) postBody;
            request.rs.sendDataTime = System.currentTimeMillis() - currentTimeMillis;
        }
    }
}
