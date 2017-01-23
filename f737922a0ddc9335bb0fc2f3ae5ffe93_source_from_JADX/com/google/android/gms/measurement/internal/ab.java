package com.google.android.gms.measurement.internal;

import afq;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ab extends b {

    interface a {
        void j6(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map);
    }

    private static class b implements Runnable {
        private final int DW;
        private final Throwable FH;
        private final byte[] Hw;
        private final Map<String, List<String>> Zo;
        private final a j6;
        private final String v5;

        private b(String str, a aVar, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            com.google.android.gms.common.internal.b.j6((Object) aVar);
            this.j6 = aVar;
            this.DW = i;
            this.FH = th;
            this.Hw = bArr;
            this.v5 = str;
            this.Zo = map;
        }

        public void run() {
            this.j6.j6(this.v5, this.DW, this.FH, this.Hw, this.Zo);
        }
    }

    private class c implements Runnable {
        private final URL DW;
        private final byte[] FH;
        private final a Hw;
        private final Map<String, String> Zo;
        final /* synthetic */ ab j6;
        private final String v5;

        public c(ab abVar, String str, URL url, byte[] bArr, Map<String, String> map, a aVar) {
            this.j6 = abVar;
            com.google.android.gms.common.internal.b.j6(str);
            com.google.android.gms.common.internal.b.j6((Object) url);
            com.google.android.gms.common.internal.b.j6((Object) aVar);
            this.DW = url;
            this.FH = bArr;
            this.Hw = aVar;
            this.v5 = str;
            this.Zo = map;
        }

        public void run() {
            HttpURLConnection j6;
            OutputStream outputStream;
            Throwable e;
            Map map;
            int i;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Map map2;
            this.j6.u7();
            int i2 = 0;
            try {
                this.j6.j6(this.v5);
                j6 = this.j6.j6(this.DW);
                try {
                    if (this.Zo != null) {
                        for (Entry entry : this.Zo.entrySet()) {
                            j6.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    if (this.FH != null) {
                        byte[] j62 = this.j6.j3().j6(this.FH);
                        this.j6.lg().ei().j6("Uploading data. size", Integer.valueOf(j62.length));
                        j6.setDoOutput(true);
                        j6.addRequestProperty("Content-Encoding", "gzip");
                        j6.setFixedLengthStreamingMode(j62.length);
                        j6.connect();
                        outputStream = j6.getOutputStream();
                        try {
                            outputStream.write(j62);
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            map = null;
                            i = 0;
                            httpURLConnection = j6;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    this.j6.lg().Zo().j6("Error closing HTTP compressed POST connection output stream", e3);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.j6.VH();
                            this.j6.a8().j6(new b(this.Hw, i, e, null, map, null));
                        } catch (Throwable th2) {
                            th = th2;
                            map2 = null;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e32) {
                                    this.j6.lg().Zo().j6("Error closing HTTP compressed POST connection output stream", e32);
                                }
                            }
                            if (j6 != null) {
                                j6.disconnect();
                            }
                            this.j6.VH();
                            this.j6.a8().j6(new b(this.Hw, i2, null, null, map2, null));
                            throw th;
                        }
                    }
                    i2 = j6.getResponseCode();
                    map2 = j6.getHeaderFields();
                } catch (IOException e4) {
                    e = e4;
                    map = null;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = j6;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.j6.VH();
                    this.j6.a8().j6(new b(this.Hw, i, e, null, map, null));
                } catch (Throwable th3) {
                    th = th3;
                    map2 = null;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (j6 != null) {
                        j6.disconnect();
                    }
                    this.j6.VH();
                    this.j6.a8().j6(new b(this.Hw, i2, null, null, map2, null));
                    throw th;
                }
                try {
                    byte[] j63 = this.j6.j6(j6);
                    if (j6 != null) {
                        j6.disconnect();
                    }
                    this.j6.VH();
                    this.j6.a8().j6(new b(this.Hw, i2, null, j63, map2, null));
                } catch (IOException e5) {
                    e = e5;
                    map = map2;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = j6;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.j6.VH();
                    this.j6.a8().j6(new b(this.Hw, i, e, null, map, null));
                } catch (Throwable th32) {
                    th = th32;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (j6 != null) {
                        j6.disconnect();
                    }
                    this.j6.VH();
                    this.j6.a8().j6(new b(this.Hw, i2, null, null, map2, null));
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                map = null;
                i = 0;
                outputStream = null;
                httpURLConnection = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.j6.VH();
                this.j6.a8().j6(new b(this.Hw, i, e, null, map, null));
            } catch (Throwable th322) {
                th = th322;
                map2 = null;
                j6 = null;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (j6 != null) {
                    j6.disconnect();
                }
                this.j6.VH();
                this.j6.a8().j6(new b(this.Hw, i2, null, null, map2, null));
                throw th;
            }
        }
    }

    public ab(ai aiVar) {
        super(aiVar);
    }

    private byte[] j6(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public /* bridge */ /* synthetic */ n EQ() {
        return super.EQ();
    }

    public /* bridge */ /* synthetic */ y J0() {
        return super.J0();
    }

    public /* bridge */ /* synthetic */ r J8() {
        return super.J8();
    }

    public /* bridge */ /* synthetic */ ag Mr() {
        return super.Mr();
    }

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    protected void VH() {
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    public boolean Zo() {
        NetworkInfo activeNetworkInfo;
        FH();
        try {
            activeNetworkInfo = ((ConnectivityManager) XL().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    protected HttpURLConnection j6(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout((int) er().ro());
            httpURLConnection.setReadTimeout((int) er().cn());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    protected void j6(String str) {
    }

    public void j6(String str, URL url, Map<String, String> map, a aVar) {
        tp();
        FH();
        com.google.android.gms.common.internal.b.j6((Object) url);
        com.google.android.gms.common.internal.b.j6((Object) aVar);
        a8().DW(new c(this, str, url, null, map, aVar));
    }

    public void j6(String str, URL url, byte[] bArr, Map<String, String> map, a aVar) {
        tp();
        FH();
        com.google.android.gms.common.internal.b.j6((Object) url);
        com.google.android.gms.common.internal.b.j6((Object) bArr);
        com.google.android.gms.common.internal.b.j6((Object) aVar);
        a8().DW(new c(this, str, url, bArr, map, aVar));
    }

    public /* bridge */ /* synthetic */ aa lg() {
        return super.lg();
    }

    public /* bridge */ /* synthetic */ ae rN() {
        return super.rN();
    }

    public /* bridge */ /* synthetic */ void tp() {
        super.tp();
    }

    public /* bridge */ /* synthetic */ void u7() {
        super.u7();
    }

    protected void v5() {
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }
}
