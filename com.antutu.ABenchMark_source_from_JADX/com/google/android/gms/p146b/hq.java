package com.google.android.gms.p146b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@gb
/* renamed from: com.google.android.gms.b.hq */
public final class hq extends he {
    private final String f11345a;
    private final Context f11346b;
    private final String f11347c;
    private String f11348d;

    public hq(Context context, String str, String str2) {
        this.f11348d = null;
        this.f11346b = context;
        this.f11345a = str;
        this.f11347c = str2;
    }

    public hq(Context context, String str, String str2, String str3) {
        this.f11348d = null;
        this.f11346b = context;
        this.f11345a = str;
        this.f11347c = str2;
        this.f11348d = str3;
    }

    public void m13155a() {
        HttpURLConnection httpURLConnection;
        try {
            hf.m12982e("Pinging URL: " + this.f11347c);
            httpURLConnection = (HttpURLConnection) new URL(this.f11347c).openConnection();
            if (TextUtils.isEmpty(this.f11348d)) {
                C2968s.m11525e().m13039a(this.f11346b, this.f11345a, true, httpURLConnection);
            } else {
                C2968s.m11525e().m13040a(this.f11346b, this.f11345a, true, httpURLConnection, this.f11348d);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < Constants.COMMAND_HANDSHAKE || responseCode >= ErrorCode.APP_NOT_BIND) {
                C2972b.m11583d("Received non-success response code " + responseCode + " from pinging URL: " + this.f11347c);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            C2972b.m11583d("Error while parsing ping URL: " + this.f11347c + ". " + e.getMessage());
        } catch (IOException e2) {
            C2972b.m11583d("Error while pinging URL: " + this.f11347c + ". " + e2.getMessage());
        } catch (RuntimeException e3) {
            C2972b.m11583d("Error while pinging URL: " + this.f11347c + ". " + e3.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public void m13156b() {
    }
}
