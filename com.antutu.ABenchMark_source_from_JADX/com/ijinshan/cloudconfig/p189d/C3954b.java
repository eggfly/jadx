package com.ijinshan.cloudconfig.p189d;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.common.Constants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyRequest;

/* renamed from: com.ijinshan.cloudconfig.d.b */
public class C3954b {
    public static String m16258a(String str, int i, int i2) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        Throwable th2;
        Object obj;
        HttpURLConnection httpURLConnection2 = null;
        if (str == null || i <= 0 || i2 <= 0) {
            return null;
        }
        String str2;
        BufferedReader bufferedReader;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
                httpURLConnection.setRequestProperty("Charset", "utf8");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < Constants.COMMAND_HANDSHAKE || responseCode > 207) {
                    bufferedReader = null;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    char[] cArr = new char[IXAdIOUtils.BUFFER_SIZE];
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    while (true) {
                        try {
                            int read = bufferedReader.read(cArr);
                            if (read < 0) {
                                break;
                            } else if (read > 0) {
                                stringBuilder.append(cArr, 0, read);
                            }
                        } catch (Exception e) {
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection2 = httpURLConnection;
                            th2 = th;
                        }
                    }
                    if (stringBuilder.length() > 0) {
                        httpURLConnection2 = stringBuilder.toString();
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e2) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        str2 = httpURLConnection2;
                    } catch (Exception e3) {
                        obj = httpURLConnection2;
                    }
                } else {
                    obj = httpURLConnection2;
                }
            } catch (Exception e4) {
                bufferedReader = null;
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e5) {
                    }
                }
                if (bufferedReader == null) {
                    str2 = null;
                } else {
                    try {
                        bufferedReader.close();
                        str2 = null;
                    } catch (Exception e6) {
                        str2 = null;
                    }
                }
                return str2 == null ? C3954b.m16258a(str, i, i2 - 1) : str2;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                httpURLConnection2 = httpURLConnection;
                th2 = th;
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e7) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e8) {
                    }
                }
                throw th2;
            }
        } catch (Exception e9) {
            httpURLConnection = null;
            bufferedReader = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedReader == null) {
                bufferedReader.close();
                str2 = null;
            } else {
                str2 = null;
            }
            if (str2 == null) {
            }
        } catch (Throwable th5) {
            th2 = th5;
            bufferedReader = null;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th2;
        }
        if (str2 == null) {
        }
    }
}
