package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

class ap implements f {
    private final Context DW;
    private final b FH;
    private final a Hw;
    private final String j6;

    public interface a {
        void DW(k kVar);

        void FH(k kVar);

        void j6(k kVar);
    }

    interface b {
        HttpURLConnection j6(URL url);
    }

    class 1 implements b {
        1() {
        }

        public HttpURLConnection j6(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    ap(Context context, a aVar) {
        this(new 1(), context, aVar);
    }

    ap(b bVar, Context context, a aVar) {
        this.FH = bVar;
        this.DW = context.getApplicationContext();
        this.Hw = aVar;
        this.j6 = j6("GoogleTagManager", "4.00", VERSION.RELEASE, j6(Locale.getDefault()), Build.MODEL, Build.ID);
    }

    static String j6(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    String j6(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    URL j6(k kVar) {
        try {
            return new URL(kVar.FH());
        } catch (MalformedURLException e) {
            r.j6("Error trying to parse the GTM url.");
            return null;
        }
    }

    public void j6(List<k> list) {
        Object obj;
        Throwable th;
        InputStream inputStream;
        Object obj2;
        Throwable th2;
        Object obj3;
        IOException iOException;
        int min = Math.min(list.size(), 40);
        Object obj4 = 1;
        int i = 0;
        while (i < min) {
            k kVar = (k) list.get(i);
            URL j6 = j6(kVar);
            if (j6 == null) {
                r.DW("No destination: discarding hit.");
                this.Hw.DW(kVar);
                obj = obj4;
            } else {
                try {
                    HttpURLConnection j62 = this.FH.j6(j6);
                    if (obj4 != null) {
                        try {
                            u.DW(this.DW);
                            obj4 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                            obj2 = obj4;
                            th2 = th;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    obj3 = obj2;
                                    iOException = e;
                                }
                            }
                            j62.disconnect();
                            throw th2;
                        }
                    }
                    j62.setRequestProperty("User-Agent", this.j6);
                    int responseCode = j62.getResponseCode();
                    InputStream inputStream2 = j62.getInputStream();
                    if (responseCode != 200) {
                        try {
                            r.DW("Bad response: " + responseCode);
                            this.Hw.FH(kVar);
                        } catch (Throwable th32) {
                            th = th32;
                            inputStream = inputStream2;
                            obj2 = obj4;
                            th2 = th;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            j62.disconnect();
                            throw th2;
                        }
                    }
                    this.Hw.j6(kVar);
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    j62.disconnect();
                    obj = obj4;
                } catch (IOException e2) {
                    iOException = e2;
                    obj3 = obj4;
                    String str = "Exception sending hit: ";
                    String valueOf = String.valueOf(iOException.getClass().getSimpleName());
                    r.DW(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    r.DW(iOException.getMessage());
                    this.Hw.FH(kVar);
                    obj = obj3;
                    i++;
                    obj4 = obj;
                }
            }
            i++;
            obj4 = obj;
        }
    }

    public boolean j6() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.DW.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        r.Hw("...no network connectivity");
        return false;
    }
}
