package com.google.android.gms.ads.internal.util.client;

import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.util.client.a.a;
import com.google.android.gms.internal.eh;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@eh
public class c implements a {
    private final String j6;

    public c() {
        this(null);
    }

    public c(String str) {
        this.j6 = str;
    }

    public void j6(String str) {
        String valueOf;
        HttpURLConnection httpURLConnection;
        try {
            String str2 = "Pinging URL: ";
            valueOf = String.valueOf(str);
            b.j6(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            w.j6().j6(true, httpURLConnection, this.j6);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                b.Hw(new StringBuilder(String.valueOf(str).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(str).toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            valueOf = String.valueOf(e.getMessage());
            b.Hw(new StringBuilder((String.valueOf(str).length() + 32) + String.valueOf(valueOf).length()).append("Error while parsing ping URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (IOException e2) {
            valueOf = String.valueOf(e2.getMessage());
            b.Hw(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (RuntimeException e3) {
            valueOf = String.valueOf(e3.getMessage());
            b.Hw(new StringBuilder((String.valueOf(str).length() + 27) + String.valueOf(valueOf).length()).append("Error while pinging URL: ").append(str).append(". ").append(valueOf).toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
