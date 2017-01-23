package p000a.p001a.p005c;

import com.mob.tools.network.HttpPatch;
import com.umeng.message.util.HttpRequest;
import org.android.spdy.SpdyRequest;

/* renamed from: a.a.c.f */
public final class C0029f {
    public static boolean m112a(String str) {
        return str.equals(SpdyRequest.POST_METHOD) || str.equals(HttpPatch.METHOD_NAME) || str.equals(HttpRequest.f14536B) || str.equals(HttpRequest.f14570w) || str.equals("MOVE");
    }

    public static boolean m113b(String str) {
        return str.equals(SpdyRequest.POST_METHOD) || str.equals(HttpRequest.f14536B) || str.equals(HttpPatch.METHOD_NAME) || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean m114c(String str) {
        return C0029f.m113b(str) || str.equals(HttpRequest.f14573z) || str.equals(HttpRequest.f14570w) || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static boolean m115d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean m116e(String str) {
        return !str.equals("PROPFIND");
    }
}
