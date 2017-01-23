package anet.channel.session;

import anet.channel.request.Request;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* renamed from: anet.channel.session.d */
final class C0691d implements HostnameVerifier {
    final /* synthetic */ Request f2273a;

    C0691d(Request request) {
        this.f2273a = request;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f2273a.getHost(), sSLSession);
    }
}
