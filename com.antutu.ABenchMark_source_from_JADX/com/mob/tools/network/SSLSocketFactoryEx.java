package com.mob.tools.network;

import com.mob.tools.network.NetworkHelper.SimpleX509TrustManager;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class SSLSocketFactoryEx extends SSLSocketFactory {
    SSLContext sslContext;

    public SSLSocketFactoryEx(KeyStore keyStore) {
        super(keyStore);
        this.sslContext = SSLContext.getInstance("TLS");
        this.sslContext.init(null, new TrustManager[]{new SimpleX509TrustManager(null)}, new SecureRandom());
    }

    public void allowAllHostnameVerifier() {
        setHostnameVerifier(STRICT_HOSTNAME_VERIFIER);
    }

    public Socket createSocket() {
        return this.sslContext.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.sslContext.getSocketFactory().createSocket(socket, str, i, z);
    }
}
