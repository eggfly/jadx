import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;

public class adx {
    private static final DateFormat j6;

    static {
        j6 = new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss ZZZZZ", Locale.US);
    }

    public static Object j6(adx$a adx_a, String str, String str2, int i, String[] strArr, aem aem) {
        return j6(DW(adx_a, str, str2, i, strArr, aem).DW);
    }

    public static adv$f DW(adx$a adx_a, String str, String str2, int i, String[] strArr, aem aem) {
        HttpUriRequest httpGet;
        if (adx_a == adx$a.GET) {
            httpGet = new HttpGet(j6(str, i, str2, strArr));
        } else {
            HttpPost httpPost = new HttpPost(j6(str, i, str2, null));
            if (strArr != null && strArr.length >= 2) {
                if (strArr.length % 2 != 0) {
                    throw new IllegalArgumentException("Params must have an even number of elements.");
                }
                List arrayList = new ArrayList();
                for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                    if (strArr[i2 + 1] != null) {
                        arrayList.add(new BasicNameValuePair(strArr[i2], strArr[i2 + 1]));
                    }
                }
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
                } catch (Throwable e) {
                    throw new aea(e);
                }
            }
            Object obj = httpPost;
        }
        aem.j6((HttpRequest) httpGet);
        return new adv$f(httpGet, j6(aem, httpGet));
    }

    public static Object j6(HttpResponse httpResponse) {
        Reader bufferedReader;
        IOException e;
        Throwable th;
        Reader reader;
        BufferedReader bufferedReader2 = null;
        try {
            Object DW;
            BufferedReader bufferedReader3;
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()), 16384);
                try {
                    bufferedReader.mark(16384);
                    DW = new aya().DW(bufferedReader);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        throw new aeb(e);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                } catch (ayb e4) {
                    reader = bufferedReader;
                    if (aeg.j6(httpResponse)) {
                        throw new aec(bufferedReader2);
                    }
                    throw new aeg(httpResponse);
                } catch (OutOfMemoryError e5) {
                    th = e5;
                    reader = bufferedReader;
                    throw new aea(th);
                }
            }
            bufferedReader3 = null;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e6) {
                }
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                return DW;
            }
            if (statusCode == 401) {
                throw new aeh();
            }
            throw new aeg(httpResponse, DW);
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
            throw new aeb(e);
        } catch (ayb e8) {
            if (aeg.j6(httpResponse)) {
                throw new aec(bufferedReader2);
            }
            throw new aeg(httpResponse);
        } catch (OutOfMemoryError e9) {
            th = e9;
            throw new aea(th);
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    public static HttpResponse j6(aem aem, HttpUriRequest httpUriRequest) {
        return j6(aem, httpUriRequest, -1);
    }

    public static HttpResponse j6(aem aem, HttpUriRequest httpUriRequest, int i) {
        HttpClient j6 = j6(aem);
        aem.j6(httpUriRequest);
        if (i >= 0) {
            HttpConnectionParams.setSoTimeout(httpUriRequest.getParams(), i);
        }
        boolean j62 = j6((HttpRequest) httpUriRequest);
        HttpResponse httpResponse = null;
        int i2 = 0;
        while (i2 < 5) {
            try {
                httpResponse = j6.execute(httpUriRequest);
            } catch (NullPointerException e) {
            }
            if (httpResponse != null) {
                break;
            }
            j6(j6, aem);
            if (j62) {
                i2++;
            } else {
                throw new aee();
            }
        }
        if (httpResponse == null) {
            try {
                throw new aeb("Apache HTTPClient encountered an error. No response, try again.");
            } catch (SSLException e2) {
                throw new aef(e2);
            } catch (IOException e3) {
                throw new aeb(e3);
            } catch (Throwable e4) {
                throw new aea(e4);
            }
        }
        i2 = httpResponse.getStatusLine().getStatusCode();
        if (!(i2 == 200 || i2 == 206)) {
            j6(httpResponse);
        }
        return httpResponse;
    }

    private static boolean j6(HttpRequest httpRequest) {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (!(entity == null || entity.isRepeatable())) {
                return false;
            }
        }
        return true;
    }

    public static String j6(String str, int i, String str2, String[] strArr) {
        if (!str2.startsWith("/")) {
            str2 = "/" + str2;
        }
        try {
            String replace = URLEncoder.encode("/" + i + str2, "UTF-8").replace("%2F", "/");
            if (strArr != null && strArr.length > 0) {
                replace = replace + "?" + j6(strArr);
            }
            return "https://" + str + ":443" + replace.replace("+", "%20").replace("*", "%2A");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private static synchronized HttpClient j6(aem aem) {
        HttpClient tp;
        synchronized (adx.class) {
            tp = aem.tp();
            j6(tp, aem);
        }
        return tp;
    }

    private static void j6(HttpClient httpClient, aem aem) {
        aem$b u7 = aem.u7();
        if (u7 == null || u7.j6 == null || u7.j6.equals("")) {
            httpClient.getParams().removeParameter("http.route.default-proxy");
            return;
        }
        Object httpHost;
        if (u7.DW < 0) {
            httpHost = new HttpHost(u7.j6);
        } else {
            httpHost = new HttpHost(u7.j6, u7.DW);
        }
        httpClient.getParams().setParameter("http.route.default-proxy", httpHost);
    }

    private static String j6(String[] strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Params must have an even number of elements.");
        }
        String str = "";
        Object obj = 1;
        int i = 0;
        while (i < strArr.length) {
            try {
                if (strArr[i + 1] != null) {
                    if (obj != null) {
                        obj = null;
                    } else {
                        str = str + "&";
                    }
                    str = str + URLEncoder.encode(strArr[i], "UTF-8") + "=" + URLEncoder.encode(strArr[i + 1], "UTF-8");
                }
                i += 2;
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }
        return str;
    }
}
