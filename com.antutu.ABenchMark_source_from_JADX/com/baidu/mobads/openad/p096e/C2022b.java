package com.baidu.mobads.openad.p096e;

import android.os.Build.VERSION;
import anet.channel.util.HttpConstant;
import com.baidu.mobads.openad.p079d.C2020d;
import com.baidu.mobads.p080j.C1991m;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.android.spdy.SpdyRequest;

/* renamed from: com.baidu.mobads.openad.e.b */
class C2022b extends Thread {
    final /* synthetic */ C2024d f7049a;
    final /* synthetic */ double f7050b;
    final /* synthetic */ C2021a f7051c;

    C2022b(C2021a c2021a, C2024d c2024d, double d) {
        this.f7051c = c2021a;
        this.f7049a = c2024d;
        this.f7050b = d;
    }

    public void run() {
        InputStream inputStream = null;
        try {
            String str = BuildConfig.FLAVOR;
            if (this.f7049a.f7055c > 0) {
                Thread.sleep(this.f7049a.f7055c);
            }
            this.f7051c.f7045e.set(true);
            this.f7051c.f7047g = (HttpURLConnection) new URL(this.f7049a.f7053a).openConnection();
            this.f7051c.f7047g.setConnectTimeout((int) this.f7050b);
            this.f7051c.f7047g.setUseCaches(false);
            if (this.f7049a.f7054b != null && this.f7049a.f7054b.length() > 0) {
                this.f7051c.f7047g.setRequestProperty(HttpRequest.f14569v, this.f7049a.f7054b);
            }
            this.f7051c.f7047g.setRequestProperty("Content-type", this.f7049a.f7056d);
            this.f7051c.f7047g.setRequestProperty(HttpConstant.CONNECTION, "keep-alive");
            this.f7051c.f7047g.setRequestProperty(HttpRequest.f14556i, "no-cache");
            if (Integer.parseInt(VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            if (C2021a.f7043b != null) {
                str = BuildConfig.FLAVOR;
                if (this.f7051c.f7044d != null) {
                    str = this.f7051c.f7044d;
                }
                String a = C2021a.f7043b.m7483a(this.f7049a.f7053a);
                if (a != null) {
                    str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + a;
                }
                if (str.length() > 0) {
                    this.f7051c.f7047g.setRequestProperty("Cookie", str);
                }
            }
            if (this.f7049a.f7057e == 1) {
                this.f7051c.f7047g.setRequestMethod(SpdyRequest.GET_METHOD);
                this.f7051c.f7047g.connect();
                inputStream = this.f7051c.f7047g.getInputStream();
                Map headerFields = this.f7051c.f7047g.getHeaderFields();
                if (headerFields.containsKey(HttpConstant.SET_COOKIE)) {
                    List<String> list = (List) headerFields.get(HttpConstant.SET_COOKIE);
                    if (list != null) {
                        for (String str2 : list) {
                            C2021a.f7043b.m7485a(this.f7049a.f7053a, str2);
                        }
                    }
                }
                if (!this.f7051c.f7046f.booleanValue()) {
                    this.f7051c.dispatchEvent(new C2020d("URLLoader.Load.Complete", C2021a.m7538b(inputStream), this.f7049a.m7548a()));
                }
            } else if (this.f7049a.f7057e == 0) {
                this.f7051c.f7047g.setRequestMethod(SpdyRequest.POST_METHOD);
                this.f7051c.f7047g.setDoInput(true);
                this.f7051c.f7047g.setDoOutput(true);
                if (this.f7049a.m7551b() != null) {
                    str2 = this.f7049a.m7551b().build().getEncodedQuery();
                    OutputStream outputStream = this.f7051c.f7047g.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, HttpRequest.f14548a));
                    bufferedWriter.write(str2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }
                this.f7051c.f7047g.connect();
                this.f7051c.f7047g.getResponseCode();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    C1991m.m7449a().m7457f().m7400e("OAdURLLoader", e.getMessage());
                }
                try {
                    this.f7051c.f7047g.disconnect();
                } catch (Exception e2) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    C1991m.m7449a().m7457f().m7400e("OAdURLLoader", e3.getMessage());
                }
                try {
                    this.f7051c.f7047g.disconnect();
                } catch (Exception e4) {
                }
            }
        }
    }
}
