package com.antutu.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.antutu.benchmark.ABenchmarkApplication;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.facebook.ads.AdError;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpUtil {
    public static final String APN_3GWAP = "3gwap";
    public static final String APN_CMWAP = "cmwap";
    public static final String APN_CTWAP = "ctwap";
    public static final String APN_UNIWAP = "uniwap";
    public static final int CONNECT_TIMEOUT = 45000;
    public static final int HTTP_STATUS_TIMEOUT = -1;
    public static final int SOCKET_TIMEOUT = 45000;
    private static HashMap<String, String> apnProxy;
    private static int mHttpStatusCode;
    private static String mUrlEncode;

    static {
        apnProxy = new HashMap();
        apnProxy.put(APN_CMWAP, "10.0.0.172:80");
        apnProxy.put(APN_UNIWAP, "10.0.0.172:80");
        apnProxy.put(APN_3GWAP, "10.0.0.172:80");
        apnProxy.put(APN_CTWAP, "10.0.0.200:80");
    }

    public static String appendTimestampToUrl(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static final HttpPost createHttpPost(Context context, NetworkInfo networkInfo, String str) {
        Object httpPost = new HttpPost(appendTimestampToUrl(str));
        setProxy(httpPost, networkInfo);
        return httpPost;
    }

    public static final HttpPost createHttpPost(Context context, String str) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo == null ? new HttpPost(appendTimestampToUrl(str)) : createHttpPost(context, activeNetworkInfo, str);
    }

    public static final HttpPost createHttpPost(Context context, String str, MultipartForm multipartForm) {
        HttpPost createHttpPost = createHttpPost(context, str);
        createHttpPost.addHeader(HttpConstant.CONNECTION, "keep-alive");
        createHttpPost.addHeader(HttpRequest.f14552e, "*/*");
        createHttpPost.setHeader(MIME.CONTENT_TYPE, "multipart/form-data; charset=UTF-8;boundary=" + multipartForm.Get_Boundary());
        createHttpPost.setEntity(multipartForm);
        return createHttpPost;
    }

    public static String get(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = BuildConfig.FLAVOR;
        HttpClient newHttpClient = getNewHttpClient();
        HttpUriRequest httpGet = new HttpGet(appendTimestampToUrl(str));
        httpGet.addHeader(HttpRequest.f14554g, "gzip, deflate");
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, (i * AdError.NETWORK_ERROR_CODE) / 5);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i * AdError.NETWORK_ERROR_CODE);
        Object checkNetInfo = NetUtils.checkNetInfo(ABenchmarkApplication.getContext());
        if (!TextUtils.isEmpty(checkNetInfo)) {
            ConnRouteParams.setDefaultProxy(basicHttpParams, new HttpHost(checkNetInfo, 80));
        }
        httpGet.setParams(basicHttpParams);
        try {
            mHttpStatusCode = 0;
            HttpResponse execute = newHttpClient.execute(httpGet);
            mHttpStatusCode = execute.getStatusLine().getStatusCode();
            if (execute.getStatusLine().getStatusCode() == Constants.COMMAND_HANDSHAKE) {
                str2 = NetUtils.toString(execute.getEntity(), "utf-8");
            }
        } catch (ConnectTimeoutException e) {
            mHttpStatusCode = HTTP_STATUS_TIMEOUT;
        } catch (SocketTimeoutException e2) {
            mHttpStatusCode = HTTP_STATUS_TIMEOUT;
        } catch (Exception e3) {
        }
        stop(newHttpClient);
        return str2;
    }

    public static String getApn(NetworkInfo networkInfo) {
        String extraInfo = networkInfo.getExtraInfo();
        return TextUtils.isEmpty(extraInfo) ? null : extraInfo.toLowerCase().contains(APN_CMWAP) ? APN_CMWAP : extraInfo.toLowerCase().contains(APN_UNIWAP) ? APN_UNIWAP : extraInfo.toLowerCase().contains(APN_3GWAP) ? APN_3GWAP : extraInfo.toLowerCase().contains(APN_CTWAP) ? APN_CTWAP : extraInfo;
    }

    public static HashMap<String, String> getApnProxyConfig() {
        return apnProxy;
    }

    public static int getHttpStatusCode() {
        return mHttpStatusCode;
    }

    public static InputStream getInputStream(String str, int i) {
        InputStream inputStream = null;
        if (!TextUtils.isEmpty(str)) {
            String str2 = BuildConfig.FLAVOR;
            HttpClient newHttpClient = getNewHttpClient();
            HttpUriRequest httpGet = new HttpGet(appendTimestampToUrl(str));
            httpGet.addHeader(HttpRequest.f14554g, "gzip, deflate");
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, (i * AdError.NETWORK_ERROR_CODE) / 5);
            HttpConnectionParams.setSoTimeout(basicHttpParams, i * AdError.NETWORK_ERROR_CODE);
            Object checkNetInfo = NetUtils.checkNetInfo(ABenchmarkApplication.getContext());
            if (!TextUtils.isEmpty(checkNetInfo)) {
                ConnRouteParams.setDefaultProxy(basicHttpParams, new HttpHost(checkNetInfo, 80));
            }
            httpGet.setParams(basicHttpParams);
            try {
                mHttpStatusCode = 0;
                HttpResponse execute = newHttpClient.execute(httpGet);
                mHttpStatusCode = execute.getStatusLine().getStatusCode();
                if (execute.getStatusLine().getStatusCode() == Constants.COMMAND_HANDSHAKE) {
                    inputStream = execute.getEntity().getContent();
                }
            } catch (ConnectTimeoutException e) {
                mHttpStatusCode = HTTP_STATUS_TIMEOUT;
            } catch (SocketTimeoutException e2) {
                mHttpStatusCode = HTTP_STATUS_TIMEOUT;
            } catch (Exception e3) {
            }
            stop(newHttpClient);
        }
        return inputStream;
    }

    public static HttpHost getNetProxy(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            String apn = getApn(activeNetworkInfo);
            if (apn != null) {
                if (APN_CMWAP.equals(apn) || APN_UNIWAP.equals(apn) || APN_3GWAP.equals(apn)) {
                    return new HttpHost("10.0.0.172", 80);
                }
                if (APN_CTWAP.equals(apn)) {
                    return new HttpHost("10.0.0.200", 80);
                }
            }
        }
        return null;
    }

    public static DefaultHttpClient getNewHttpClient() {
        try {
            KeyStore.getInstance(KeyStore.getDefaultType()).load(null, null);
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, HttpRequest.f14548a);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme(HttpConstant.HTTP, PlainSocketFactory.getSocketFactory(), 80));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    public static final String getRequestForString(String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        readCookies(httpURLConnection, hashMap2);
        return inputStreamToString(httpURLConnection.getInputStream(), true);
    }

    public static DefaultHttpClient getThreadSafeClient() {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        ClientConnectionManager connectionManager = defaultHttpClient.getConnectionManager();
        HttpParams params = defaultHttpClient.getParams();
        return new DefaultHttpClient(new ThreadSafeClientConnManager(params, connectionManager.getSchemeRegistry()), params);
    }

    public static final String inputStreamToString(InputStream inputStream, boolean z) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[IXAdIOUtils.BUFFER_SIZE];
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == HTTP_STATUS_TIMEOUT) {
                break;
            }
            stringBuilder.append(cArr, 0, read);
        }
        if (z) {
            inputStreamReader.close();
            inputStream.close();
        }
        return stringBuilder.toString();
    }

    public static boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ABenchmarkApplication.getContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isProxyApn(String str) {
        return str == null ? false : APN_3GWAP.equals(str) || APN_CMWAP.equals(str) || APN_CTWAP.equals(str) || APN_UNIWAP.equals(str);
    }

    public static final HttpResponse postRequestForMultipart(Context context, String str, HashMap<String, ? extends Object> hashMap, MultipartForm multipartForm, int i) {
        MLog.m6865d("HttpUtil.class", "postRequestForMultipart");
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, (i * AdError.NETWORK_ERROR_CODE) / 5);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i * AdError.NETWORK_ERROR_CODE);
        DefaultHttpClient newHttpClient = getNewHttpClient();
        newHttpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        HttpUriRequest createHttpPost = createHttpPost(context, str, multipartForm);
        createHttpPost.setEntity(multipartForm);
        return newHttpClient.execute(createHttpPost);
    }

    public static final HttpResponse postRequestForStream(Context context, String str, HashMap<String, ? extends Object> hashMap, int i) {
        MLog.m6865d("HttpUtil.class", "postRequestForStream");
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, (i * AdError.NETWORK_ERROR_CODE) / 5);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i * AdError.NETWORK_ERROR_CODE);
        DefaultHttpClient newHttpClient = getNewHttpClient();
        newHttpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        HttpUriRequest createHttpPost = createHttpPost(context, str);
        List arrayList = new ArrayList();
        for (String str2 : hashMap.keySet()) {
            Object obj = hashMap.get(str2);
            if (obj instanceof String) {
                arrayList.add(new BasicNameValuePair(str2, (String) obj));
                MLog.m6865d("HttpUtil.class", str2 + "=" + obj);
            } else if (obj instanceof File) {
                MLog.m6865d("HttpUtil.class", str2 + " = [file content]" + obj);
            }
        }
        arrayList.add(new BasicNameValuePair("timestamp", System.currentTimeMillis() + BuildConfig.FLAVOR));
        if (mUrlEncode == null) {
            mUrlEncode = HttpRequest.f14548a;
        }
        createHttpPost.setEntity(new UrlEncodedFormEntity(arrayList, mUrlEncode));
        return newHttpClient.execute(createHttpPost);
    }

    public static final String postRequestForString(Context context, String str, HashMap<String, String> hashMap, int i) {
        return inputStreamToString(postRequestForStream(context, str, hashMap, i).getEntity().getContent(), true);
    }

    static void readCookies(URLConnection uRLConnection, HashMap<String, String> hashMap) {
        int i = 1;
        while (true) {
            String headerFieldKey = uRLConnection.getHeaderFieldKey(i);
            if (headerFieldKey != null) {
                if (headerFieldKey.toLowerCase().equals("set-cookie")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(uRLConnection.getHeaderField(i), com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                    while (stringTokenizer.hasMoreTokens()) {
                        headerFieldKey = stringTokenizer.nextToken();
                        headerFieldKey = headerFieldKey.substring(0, headerFieldKey.indexOf(";"));
                        int indexOf = headerFieldKey.indexOf("=");
                        if (!(indexOf == HTTP_STATUS_TIMEOUT || hashMap.containsKey(headerFieldKey.substring(0, indexOf)))) {
                            hashMap.put(headerFieldKey.substring(0, indexOf), headerFieldKey.substring(indexOf + 1));
                        }
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    public static void readHeaders(Header[] headerArr, HashMap<String, String> hashMap) {
        for (Header value : headerArr) {
            StringTokenizer stringTokenizer = new StringTokenizer(value.getValue(), com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                nextToken = nextToken.substring(0, nextToken.indexOf(";") == HTTP_STATUS_TIMEOUT ? 0 : nextToken.indexOf(";"));
                int indexOf = nextToken.indexOf("=");
                if (!(indexOf == HTTP_STATUS_TIMEOUT || hashMap.containsKey(nextToken.substring(0, indexOf)))) {
                    String substring = nextToken.substring(0, indexOf);
                    if (indexOf + 1 <= nextToken.length() + HTTP_STATUS_TIMEOUT) {
                        indexOf++;
                    }
                    hashMap.put(substring, nextToken.substring(indexOf));
                }
            }
        }
    }

    private static final void setProxy(HttpMessage httpMessage, NetworkInfo networkInfo) {
        if (networkInfo != null) {
            CharSequence apn = getApn(networkInfo);
            if (!TextUtils.isEmpty(apn) && apnProxy.containsKey(apn)) {
                String str = (String) apnProxy.get(apn);
                int indexOf = str.indexOf(58);
                httpMessage.getParams().setParameter("http.route.default-proxy", new HttpHost(str.substring(0, indexOf), Integer.valueOf(str.substring(indexOf + 1)).intValue()));
            }
        }
    }

    public static void setUrlEncode(String str) {
        mUrlEncode = str;
    }

    private static void stop(HttpClient httpClient) {
        if (httpClient != null) {
            ClientConnectionManager connectionManager = httpClient.getConnectionManager();
            if (connectionManager != null) {
                connectionManager.shutdown();
            }
        }
    }
}
