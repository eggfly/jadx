package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

class i extends t {
    private static final byte[] FH;
    private final m DW;
    private final String j6;

    private class a {
        private int DW;
        private ByteArrayOutputStream FH;
        final /* synthetic */ i j6;

        public a(i iVar) {
            this.j6 = iVar;
            this.FH = new ByteArrayOutputStream();
        }

        public byte[] DW() {
            return this.FH.toByteArray();
        }

        public int j6() {
            return this.DW;
        }

        public boolean j6(c cVar) {
            b.j6((Object) cVar);
            if (this.DW + 1 > this.j6.XL().J0()) {
                return false;
            }
            String j6 = this.j6.j6(cVar, false);
            if (j6 == null) {
                this.j6.QX().j6(cVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = j6.getBytes();
            int length = bytes.length;
            if (length > this.j6.XL().v5()) {
                this.j6.QX().j6(cVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.FH.size() > 0) {
                length++;
            }
            if (length + this.FH.size() > this.j6.XL().VH()) {
                return false;
            }
            try {
                if (this.FH.size() > 0) {
                    this.FH.write(i.FH);
                }
                this.FH.write(bytes);
                this.DW++;
                return true;
            } catch (IOException e) {
                this.j6.v5("Failed to write payload when batching hits", e);
                return true;
            }
        }
    }

    static {
        FH = "\n".getBytes();
    }

    i(v vVar) {
        super(vVar);
        this.j6 = j6("GoogleAnalytics", u.j6, VERSION.RELEASE, p.j6(Locale.getDefault()), Build.MODEL, Build.ID);
        this.DW = new m(vVar.Hw());
    }

    private int DW(URL url) {
        b.j6((Object) url);
        DW("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = j6(url);
            httpURLConnection.connect();
            j6(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                Mr().u7();
            }
            DW("GET status", Integer.valueOf(responseCode));
            if (httpURLConnection == null) {
                return responseCode;
            }
            httpURLConnection.disconnect();
            return responseCode;
        } catch (IOException e) {
            Hw("Network GET connection error", e);
            return 0;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private int DW(URL url, byte[] bArr) {
        Object e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        OutputStream outputStream = null;
        b.j6((Object) url);
        b.j6((Object) bArr);
        HttpURLConnection j6;
        try {
            j6(Ws().getPackageName());
            byte[] j62 = j6(bArr);
            j6("POST compressed size, ratio %, url", Integer.valueOf(j62.length), Long.valueOf((100 * ((long) j62.length)) / ((long) bArr.length)), url);
            if (j62.length > bArr.length) {
                FH("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(j62.length), Integer.valueOf(bArr.length));
            }
            if (BT()) {
                String str = "Post payload";
                String str2 = "\n";
                String valueOf = String.valueOf(new String(bArr));
                j6(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            j6 = j6(url);
            try {
                j6.setDoOutput(true);
                j6.addRequestProperty("Content-Encoding", "gzip");
                j6.setFixedLengthStreamingMode(j62.length);
                j6.connect();
                OutputStream outputStream2 = j6.getOutputStream();
                try {
                    outputStream2.write(j62);
                    outputStream2.close();
                    j6(j6);
                    int responseCode = j6.getResponseCode();
                    if (responseCode == 200) {
                        Mr().u7();
                    }
                    DW("POST status", Integer.valueOf(responseCode));
                    if (j6 != null) {
                        j6.disconnect();
                    }
                    FH();
                    return responseCode;
                } catch (IOException e2) {
                    e = e2;
                    outputStream = outputStream2;
                    httpURLConnection = j6;
                    try {
                        Hw("Network compressed POST connection error", e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                v5("Error closing http compressed post connection output stream", e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        FH();
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        j6 = httpURLConnection;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                                v5("Error closing http compressed post connection output stream", e4);
                            }
                        }
                        if (j6 != null) {
                            j6.disconnect();
                        }
                        FH();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (j6 != null) {
                        j6.disconnect();
                    }
                    FH();
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                httpURLConnection = j6;
                Hw("Network compressed POST connection error", e);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                FH();
                return 0;
            } catch (Throwable th4) {
                th = th4;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (j6 != null) {
                    j6.disconnect();
                }
                FH();
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnection = null;
            Hw("Network compressed POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            FH();
            return 0;
        } catch (Throwable th5) {
            th = th5;
            j6 = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (j6 != null) {
                j6.disconnect();
            }
            FH();
            throw th;
        }
    }

    private URL DW(c cVar) {
        String valueOf;
        String valueOf2;
        if (cVar.Zo()) {
            valueOf = String.valueOf(XL().Ws());
            valueOf2 = String.valueOf(XL().XL());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            valueOf = String.valueOf(XL().QX());
            valueOf2 = String.valueOf(XL().XL());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            v5("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String FH(c cVar) {
        return String.valueOf(cVar.FH());
    }

    private int j6(URL url, byte[] bArr) {
        Object e;
        Throwable th;
        OutputStream outputStream = null;
        b.j6((Object) url);
        b.j6((Object) bArr);
        DW("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (BT()) {
            j6("Post payload\n", new String(bArr));
        }
        HttpURLConnection j6;
        try {
            j6(Ws().getPackageName());
            j6 = j6(url);
            try {
                j6.setDoOutput(true);
                j6.setFixedLengthStreamingMode(bArr.length);
                j6.connect();
                outputStream = j6.getOutputStream();
                outputStream.write(bArr);
                j6(j6);
                int responseCode = j6.getResponseCode();
                if (responseCode == 200) {
                    Mr().u7();
                }
                DW("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        v5("Error closing http post connection output stream", e2);
                    }
                }
                if (j6 != null) {
                    j6.disconnect();
                }
                FH();
                return responseCode;
            } catch (IOException e3) {
                e = e3;
                try {
                    Hw("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            v5("Error closing http post connection output stream", e4);
                        }
                    }
                    if (j6 != null) {
                        j6.disconnect();
                    }
                    FH();
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            v5("Error closing http post connection output stream", e22);
                        }
                    }
                    if (j6 != null) {
                        j6.disconnect();
                    }
                    FH();
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            j6 = outputStream;
            Hw("Network POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (j6 != null) {
                j6.disconnect();
            }
            FH();
            return 0;
        } catch (Throwable th3) {
            th = th3;
            j6 = outputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            if (j6 != null) {
                j6.disconnect();
            }
            FH();
            throw th;
        }
    }

    private static String j6(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    private URL j6(c cVar, String str) {
        String valueOf;
        String valueOf2;
        if (cVar.Zo()) {
            valueOf2 = String.valueOf(XL().Ws());
            valueOf = String.valueOf(XL().XL());
            valueOf = new StringBuilder(((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str).length()).append(valueOf2).append(valueOf).append("?").append(str).toString();
        } else {
            valueOf2 = String.valueOf(XL().QX());
            valueOf = String.valueOf(XL().XL());
            valueOf = new StringBuilder(((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str).length()).append(valueOf2).append(valueOf).append("?").append(str).toString();
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            v5("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void j6(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private void j6(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    v5("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    v5("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private boolean j6(c cVar) {
        b.j6((Object) cVar);
        String j6 = j6(cVar, !cVar.Zo());
        if (j6 == null) {
            QX().j6(cVar, "Error formatting hit for upload");
            return true;
        } else if (j6.length() <= XL().Hw()) {
            URL j62 = j6(cVar, j6);
            if (j62 != null) {
                return DW(j62) == 200;
            } else {
                Zo("Failed to build collect GET endpoint url");
                return false;
            }
        } else {
            j6 = j6(cVar, false);
            if (j6 == null) {
                QX().j6(cVar, "Error formatting hit for POST upload");
                return true;
            }
            byte[] bytes = j6.getBytes();
            if (bytes.length > XL().Zo()) {
                QX().j6(cVar, "Hit payload exceeds size limit");
                return true;
            }
            URL DW = DW(cVar);
            if (DW != null) {
                return j6(DW, bytes) == 200;
            } else {
                Zo("Failed to build collect POST endpoint url");
                return false;
            }
        }
    }

    private static byte[] j6(byte[] bArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL v5() {
        String valueOf = String.valueOf(XL().Ws());
        String valueOf2 = String.valueOf(XL().aM());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            v5("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    List<Long> DW(List<c> list) {
        List<Long> arrayList = new ArrayList(list.size());
        for (c cVar : list) {
            if (!j6(cVar)) {
                break;
            }
            arrayList.add(Long.valueOf(cVar.FH()));
            if (arrayList.size() >= XL().we()) {
                break;
            }
        }
        return arrayList;
    }

    public boolean DW() {
        NetworkInfo activeNetworkInfo;
        J0();
        P8();
        try {
            activeNetworkInfo = ((ConnectivityManager) Ws().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        DW("No network connectivity");
        return false;
    }

    protected void FH() {
    }

    String j6(c cVar, boolean z) {
        b.j6((Object) cVar);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : cVar.DW().entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    j6(stringBuilder, str, (String) entry.getValue());
                }
            }
            j6(stringBuilder, "ht", String.valueOf(cVar.Hw()));
            j6(stringBuilder, "qt", String.valueOf(J8().j6() - cVar.Hw()));
            if (XL().j6()) {
                j6(stringBuilder, "_gmsv", u.j6);
            }
            if (z) {
                long VH = cVar.VH();
                j6(stringBuilder, "z", VH != 0 ? String.valueOf(VH) : FH(cVar));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            v5("Failed to encode name or value", e);
            return null;
        }
    }

    HttpURLConnection j6(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(XL().P8());
            httpURLConnection.setReadTimeout(XL().ei());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.j6);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    public List<Long> j6(List<c> list) {
        boolean z;
        boolean z2 = true;
        J0();
        P8();
        b.j6((Object) list);
        if (XL().U2().isEmpty() || !this.DW.j6(XL().J8() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = XL().j3() != ab.NONE;
            if (XL().Mr() != ad.GZIP) {
                z2 = false;
            }
        }
        return z ? j6((List) list, z2) : DW((List) list);
    }

    List<Long> j6(List<c> list, boolean z) {
        b.DW(!list.isEmpty());
        j6("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        a aVar = new a(this);
        List<Long> arrayList = new ArrayList();
        for (c cVar : list) {
            if (!aVar.j6(cVar)) {
                break;
            }
            arrayList.add(Long.valueOf(cVar.FH()));
        }
        if (aVar.j6() == 0) {
            return arrayList;
        }
        URL v5 = v5();
        if (v5 == null) {
            Zo("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int DW = z ? DW(v5, aVar.DW()) : j6(v5, aVar.DW());
        if (200 == DW) {
            j6("Batched upload completed. Hits batched", Integer.valueOf(aVar.j6()));
            return arrayList;
        }
        j6("Network error uploading hits. status code", Integer.valueOf(DW));
        if (XL().U2().contains(Integer.valueOf(DW))) {
            v5("Server instructed the client to stop batching");
            this.DW.j6();
        }
        return Collections.emptyList();
    }

    protected void j6() {
        j6("Network initialized. User agent", this.j6);
    }

    protected void j6(String str) {
    }
}
