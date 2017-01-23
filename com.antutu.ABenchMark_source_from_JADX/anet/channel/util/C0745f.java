package anet.channel.util;

import android.util.Base64;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* renamed from: anet.channel.util.f */
public class C0745f {
    public final Proxy f2432a;
    public final String f2433b;
    public final String f2434c;

    private C0745f(Proxy proxy, String str, String str2) {
        this.f2432a = proxy;
        this.f2433b = str;
        this.f2434c = str2;
    }

    public static C0745f m2981a(String str, int i, String str2, String str3) {
        return new C0745f(new Proxy(Type.HTTP, new InetSocketAddress(str, i)), str2, str3);
    }

    public String m2982a() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.f2433b).append(":").append(this.f2434c);
        String encodeToString = Base64.encodeToString(stringBuilder.toString().getBytes(), 0);
        StringBuilder stringBuilder2 = new StringBuilder(64);
        stringBuilder2.append("Basic ").append(encodeToString);
        return stringBuilder2.toString();
    }
}
