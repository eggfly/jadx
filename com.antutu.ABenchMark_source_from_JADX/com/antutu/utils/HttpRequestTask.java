package com.antutu.utils;

import android.os.Message;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;
import org.android.spdy.SpdyProtocol;

public class HttpRequestTask extends TaskItem {
    public static final String GET = "GET";
    public static final String POST = "POST";
    private boolean isEnc;
    private RequestListener mRequestListener;
    private HashMap<String, Object> params;
    private String path;
    private String way;

    public HttpRequestTask(HashMap<String, Object> hashMap, String str) {
        this.way = GET;
        this.isEnc = true;
        this.params = hashMap;
        this.path = str;
    }

    public HttpRequestTask(HashMap<String, Object> hashMap, String str, RequestListener requestListener) {
        this.way = GET;
        this.isEnc = true;
        this.params = hashMap;
        this.path = str;
        this.mRequestListener = requestListener;
    }

    public HttpRequestTask(HashMap<String, Object> hashMap, String str, RequestListener requestListener, String str2) {
        this.way = GET;
        this.isEnc = true;
        this.params = hashMap;
        this.path = str;
        this.mRequestListener = requestListener;
        this.way = str2;
    }

    public HttpRequestTask(HashMap<String, Object> hashMap, String str, String str2) {
        this.way = GET;
        this.isEnc = true;
        this.params = hashMap;
        this.path = str;
        this.way = str2;
    }

    public HttpRequestTask(HashMap<String, Object> hashMap, String str, String str2, RequestListener requestListener) {
        this.way = GET;
        this.isEnc = true;
        this.params = hashMap;
        this.path = str;
        this.way = str2;
        this.mRequestListener = requestListener;
    }

    private String getRequestQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Entry entry : this.params.entrySet()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
                if (GET.equalsIgnoreCase(this.way)) {
                    stringBuilder.append("&");
                }
            } else {
                stringBuilder.append("&");
                obj2 = obj;
            }
            stringBuilder.append(URLEncoder.encode((String) entry.getKey(), HttpRequest.f14548a));
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode(String.valueOf(entry.getValue()), HttpRequest.f14548a));
            obj = obj2;
        }
        String stringBuilder2 = stringBuilder.toString();
        return (!this.isEnc || stringBuilder2.length() <= 0) ? stringBuilder2 : "&gpv=" + jni.getDataSafe(stringBuilder2, BuildConfig.FLAVOR);
    }

    public static final String inputStreamToString(InputStream inputStream, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 1) {
                return new String(byteArrayOutputStream.toByteArray(), HttpRequest.f14548a);
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private String request() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.path).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestMethod(this.way);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            InputStream inputStream = httpURLConnection.getInputStream();
            String inputStreamToString = responseCode == Constants.COMMAND_HANDSHAKE ? inputStreamToString(inputStream, false) : null;
            if (inputStream == null) {
                return inputStreamToString;
            }
            try {
                inputStream.close();
                return inputStreamToString;
            } catch (Exception e) {
                return inputStreamToString;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    void conbineUrl() {
        try {
            this.path += getRequestQuery();
        } catch (UnsupportedEncodingException e) {
        }
    }

    Object exe() {
        try {
            return request();
        } catch (IOException e) {
            return null;
        }
    }

    void handleMsg(Message message) {
        if (message != null) {
            this.mRequestListener.setRespond(message.what, (String) message.obj);
        }
    }

    public boolean isEnc() {
        return this.isEnc;
    }

    public void setEnc(boolean z) {
        this.isEnc = z;
    }

    public void setRequestListener(RequestListener requestListener) {
        this.mRequestListener = requestListener;
    }

    public void submit() {
        ThreadPoolUtils.getInstance().submit(this);
    }
}
