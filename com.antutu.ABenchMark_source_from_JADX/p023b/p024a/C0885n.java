package p023b.p024a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.antutu.utils.HttpUtil;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C4156a;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4210b;
import com.umeng.message.util.HttpRequest;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import org.android.spdy.SpdyRequest;
import org.apache.http.entity.mime.MIME;

/* renamed from: b.a.n */
public class C0885n {
    private String f2960a;
    private String f2961b;
    private int f2962c;
    private Context f2963d;
    private C0883l f2964e;

    public C0885n(Context context) {
        this.f2961b = "10.0.0.172";
        this.f2962c = 80;
        this.f2963d = context;
        this.f2960a = m3922a(context);
    }

    private String m3922a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(C4210b.f14219D);
        stringBuffer.append("/");
        stringBuffer.append(C4156a.f13941c);
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(am.m3362t(context));
            stringBuffer2.append("/");
            stringBuffer2.append(am.m3339b(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("/");
            stringBuffer2.append(VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(an.m3370a(AnalyticsConfig.getAppkey(context)));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), HttpRequest.f14548a));
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }

    private boolean m3923a() {
        if (this.f2963d.getPackageManager().checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, this.f2963d.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f2963d.getSystemService("connectivity");
            if (!am.m3336a(this.f2963d, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null && (extraInfo.equals(HttpUtil.APN_CMWAP) || extraInfo.equals(HttpUtil.APN_3GWAP) || extraInfo.equals(HttpUtil.APN_UNIWAP))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] m3924a(byte[] bArr, String str) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        try {
            if (this.f2964e != null) {
                this.f2964e.m3913a();
            }
            if (m3923a()) {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection(new Proxy(Type.HTTP, new InetSocketAddress(this.f2961b, this.f2962c)));
            } else {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            }
            InputStream inputStream;
            try {
                httpURLConnection2.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                httpURLConnection2.setRequestProperty("X-Umeng-Sdk", this.f2960a);
                httpURLConnection2.setRequestProperty("Msg-Type", "envelope/json");
                httpURLConnection2.setRequestProperty(MIME.CONTENT_TYPE, "envelope/json");
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setRequestMethod(SpdyRequest.POST_METHOD);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                if (VERSION.SDK_INT < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                if (this.f2964e != null) {
                    this.f2964e.m3914b();
                }
                int responseCode = httpURLConnection2.getResponseCode();
                Object headerField = httpURLConnection2.getHeaderField(MIME.CONTENT_TYPE);
                headerField = (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) ? null : 1;
                if (responseCode != Constants.COMMAND_HANDSHAKE || headerField == null) {
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                ap.m3386b("Send message to " + str);
                inputStream = httpURLConnection2.getInputStream();
                byte[] b = an.m3376b(inputStream);
                an.m3377c(inputStream);
                if (httpURLConnection2 == null) {
                    return b;
                }
                httpURLConnection2.disconnect();
                return b;
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = null;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public void m3925a(C0883l c0883l) {
        this.f2964e = c0883l;
    }

    public byte[] m3926a(byte[] bArr) {
        byte[] bArr2 = null;
        for (String a : C4156a.f13947i) {
            bArr2 = m3924a(bArr, a);
            if (bArr2 != null) {
                if (this.f2964e != null) {
                    this.f2964e.m3915c();
                }
                return bArr2;
            }
            if (this.f2964e != null) {
                this.f2964e.m3916d();
            }
        }
        return bArr2;
    }
}
