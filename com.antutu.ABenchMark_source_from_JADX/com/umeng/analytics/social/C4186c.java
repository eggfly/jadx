package com.umeng.analytics.social;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.C4156a;
import com.umeng.message.util.HttpRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdyRequest;

/* renamed from: com.umeng.analytics.social.c */
public abstract class C4186c {
    private static String m17064a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine + "\n");
            } catch (Exception e) {
                stringBuilder = C4156a.f13942d;
                C4185b.m17057b(stringBuilder, "Caught IOException in convertStreamToString()", e);
                return null;
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    C4185b.m17057b(C4156a.f13942d, "Caught IOException in convertStreamToString()", e2);
                    return null;
                }
            }
        }
        return stringBuilder.toString();
    }

    protected static String m17065a(String str) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        HttpURLConnection httpURLConnection2 = null;
        int nextInt = new Random().nextInt(AdError.NETWORK_ERROR_CODE);
        try {
            String property = System.getProperty("line.separator");
            if (str.length() <= 1) {
                C4185b.m17056b(C4156a.f13942d, nextInt + ":  Invalid baseUrl.");
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return httpURLConnection2;
            }
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setConnectTimeout(10000);
                httpURLConnection3.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
                httpURLConnection3.setRequestMethod(SpdyRequest.GET_METHOD);
                if (Integer.parseInt(VERSION.SDK) < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                C4185b.m17054a(C4156a.f13942d, nextInt + ": GET_URL: " + str);
                if (httpURLConnection3.getResponseCode() == Constants.COMMAND_HANDSHAKE) {
                    InputStream gZIPInputStream;
                    InputStream inputStream = httpURLConnection3.getInputStream();
                    Object headerField = httpURLConnection3.getHeaderField(HttpRequest.f14557j);
                    if (!TextUtils.isEmpty(headerField) && headerField.equalsIgnoreCase(HttpRequest.f14551d)) {
                        C4185b.m17054a(C4156a.f13942d, nextInt + "  Use GZIPInputStream get data....");
                        gZIPInputStream = new GZIPInputStream(inputStream);
                    } else if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("deflate")) {
                        gZIPInputStream = inputStream;
                    } else {
                        C4185b.m17054a(C4156a.f13942d, nextInt + "  Use InflaterInputStream get data....");
                        gZIPInputStream = new InflaterInputStream(inputStream);
                    }
                    String a = C4186c.m17064a(gZIPInputStream);
                    C4185b.m17054a(C4156a.f13942d, nextInt + ":  response: " + property + a);
                    if (a == null) {
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        return httpURLConnection2;
                    }
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    return a;
                }
                C4185b.m17054a(C4156a.f13942d, nextInt + ":  Failed to get message." + str);
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return httpURLConnection2;
            } catch (Exception e) {
                Exception exception2 = e;
                httpURLConnection = httpURLConnection3;
                exception = exception2;
                try {
                    C4185b.m17059c(C4156a.f13942d, nextInt + ":  Exception,Failed to send message." + str, exception);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return httpURLConnection2;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                httpURLConnection2 = httpURLConnection3;
                th = th4;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = httpURLConnection2;
            C4185b.m17059c(C4156a.f13942d, nextInt + ":  Exception,Failed to send message." + str, exception);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return httpURLConnection2;
        } catch (Throwable th5) {
            th = th5;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    protected static String m17066a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        int nextInt = new Random().nextInt(AdError.NETWORK_ERROR_CODE);
        try {
            String property = System.getProperty("line.separator");
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod(SpdyRequest.POST_METHOD);
                C4185b.m17054a(C4156a.f13942d, nextInt + ": POST_URL: " + str);
                if (Integer.parseInt(VERSION.SDK) < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                if (!TextUtils.isEmpty(str2)) {
                    C4185b.m17054a(C4156a.f13942d, nextInt + ": POST_BODY: " + str2);
                    List arrayList = new ArrayList();
                    arrayList.add("data=" + str2);
                    OutputStream outputStream = httpURLConnection2.getOutputStream();
                    outputStream.write(URLEncoder.encode(arrayList.toString()).getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
                if (httpURLConnection2.getResponseCode() == Constants.COMMAND_HANDSHAKE) {
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    Object headerField = httpURLConnection2.getHeaderField(HttpRequest.f14557j);
                    InputStream inflaterInputStream = (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase(HttpRequest.f14551d)) ? inputStream : new InflaterInputStream(inputStream);
                    String a = C4186c.m17064a(inflaterInputStream);
                    C4185b.m17054a(C4156a.f13942d, nextInt + ":  response: " + property + a);
                    if (a == null) {
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return null;
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return a;
                }
                C4185b.m17058c(C4156a.f13942d, nextInt + ":  Failed to send message." + str);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return null;
            } catch (Exception e) {
                Exception exception2 = e;
                httpURLConnection = httpURLConnection2;
                exception = exception2;
                try {
                    C4185b.m17059c(C4156a.f13942d, nextInt + ":  Exception,Failed to send message." + str, exception);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection = httpURLConnection2;
                th = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = null;
            C4185b.m17059c(C4156a.f13942d, nextInt + ":  Exception,Failed to send message." + str, exception);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
