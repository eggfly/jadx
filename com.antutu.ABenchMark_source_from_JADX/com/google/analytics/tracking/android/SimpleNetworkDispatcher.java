package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher implements Dispatcher {
    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
    private final Context ctx;
    private final HttpClientFactory httpClientFactory;
    private final String userAgent;

    SimpleNetworkDispatcher(AnalyticsStore analyticsStore, HttpClientFactory httpClientFactory, Context context) {
        this(httpClientFactory, context);
    }

    SimpleNetworkDispatcher(HttpClientFactory httpClientFactory, Context context) {
        this.ctx = context.getApplicationContext();
        this.userAgent = createUserAgentString("GoogleAnalytics", "2.0", VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
        this.httpClientFactory = httpClientFactory;
    }

    private HttpEntityEnclosingRequest buildRequest(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Log.m10260w("Empty hit, discarding.");
            return null;
        }
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        String str3 = str2 + "?" + str;
        if (str3.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest(SpdyRequest.GET_METHOD, str3);
        } else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest(SpdyRequest.POST_METHOD, str2);
            try {
                basicHttpEntityEnclosingRequest.setEntity(new StringEntity(str));
            } catch (UnsupportedEncodingException e) {
                Log.m10260w("Encoding error, discarding hit");
                return null;
            }
        }
        basicHttpEntityEnclosingRequest.addHeader(HttpRequest.f14569v, this.userAgent);
        return basicHttpEntityEnclosingRequest;
    }

    private URL getUrl(Hit hit) {
        if (TextUtils.isEmpty(hit.getHitUrl())) {
            return null;
        }
        try {
            return new URL(hit.getHitUrl());
        } catch (MalformedURLException e) {
            try {
                return new URL("http://www.google-analytics.com/collect");
            } catch (MalformedURLException e2) {
                return null;
            }
        }
    }

    private void logDebugInformation(boolean z, HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        if (z) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
                stringBuffer.append(obj.toString()).append("\n");
            }
            stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
            if (httpEntityEnclosingRequest.getEntity() != null) {
                try {
                    InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                    if (content != null) {
                        int available = content.available();
                        if (available > 0) {
                            byte[] bArr = new byte[available];
                            content.read(bArr);
                            stringBuffer.append("POST:\n");
                            stringBuffer.append(new String(bArr)).append("\n");
                        }
                    }
                } catch (IOException e) {
                    Log.m10260w("Error Writing hit to log...");
                }
            }
            Log.m10258i(stringBuffer.toString());
        }
    }

    String createUserAgentString(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format(USER_AGENT_TEMPLATE, new Object[]{str, str2, str3, str4, str5, str6});
    }

    public int dispatchHits(List<Hit> list) {
        int min = Math.min(list.size(), 40);
        int i = 0;
        int i2 = 0;
        while (i < min) {
            int i3;
            HttpClient newInstance = this.httpClientFactory.newInstance();
            Hit hit = (Hit) list.get(i);
            URL url = getUrl(hit);
            if (url == null) {
                if (Log.isDebugEnabled()) {
                    Log.m10260w("No destination: discarding hit: " + hit.getHitParams());
                } else {
                    Log.m10260w("No destination: discarding hit.");
                }
                i3 = i2 + 1;
            } else {
                HttpHost httpHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
                String path = url.getPath();
                String postProcessHit = TextUtils.isEmpty(hit.getHitParams()) ? BuildConfig.FLAVOR : HitBuilder.postProcessHit(hit, System.currentTimeMillis());
                org.apache.http.HttpRequest buildRequest = buildRequest(postProcessHit, path);
                if (buildRequest == null) {
                    i3 = i2 + 1;
                } else {
                    buildRequest.addHeader(HttpConstant.HOST, httpHost.toHostString());
                    logDebugInformation(Log.isDebugEnabled(), buildRequest);
                    if (postProcessHit.length() > SpdyProtocol.SLIGHTSSL_1_RTT_MODE) {
                        Log.m10260w("Hit too long (> 8192 bytes)--not sent");
                    } else {
                        try {
                            HttpResponse execute = newInstance.execute(httpHost, buildRequest);
                            if (execute.getStatusLine().getStatusCode() != Constants.COMMAND_HANDSHAKE) {
                                Log.m10260w("Bad response: " + execute.getStatusLine().getStatusCode());
                                return i2;
                            }
                        } catch (ClientProtocolException e) {
                            Log.m10260w("ClientProtocolException sending hit; discarding hit...");
                        } catch (IOException e2) {
                            Log.m10260w("Exception sending hit: " + e2.getClass().getSimpleName());
                            Log.m10260w(e2.getMessage());
                            return i2;
                        }
                    }
                    i3 = i2 + 1;
                }
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    public boolean okToDispatch() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        Log.vDebug("...no network connectivity");
        return false;
    }
}
