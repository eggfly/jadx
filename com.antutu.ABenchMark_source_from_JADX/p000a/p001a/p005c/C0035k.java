package p000a.p001a.p005c;

import com.xiaomi.pushsdk.BuildConfig;
import java.net.ProtocolException;
import p000a.C0135v;

/* renamed from: a.a.c.k */
public final class C0035k {
    public final C0135v f113a;
    public final int f114b;
    public final String f115c;

    public C0035k(C0135v c0135v, int i, String str) {
        this.f113a = c0135v;
        this.f114b = i;
        this.f115c = str;
    }

    public static C0035k m146a(String str) {
        C0135v c0135v;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - 48;
            if (charAt == 0) {
                c0135v = C0135v.HTTP_1_0;
            } else if (charAt == 1) {
                c0135v = C0135v.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            c0135v = C0135v.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        if (str.length() < i + 3) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            String str2;
            int parseInt = Integer.parseInt(str.substring(i, i + 3));
            String str3 = BuildConfig.FLAVOR;
            if (str.length() <= i + 3) {
                str2 = str3;
            } else if (str.charAt(i + 3) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i + 4);
            }
            return new C0035k(c0135v, parseInt, str2);
        } catch (NumberFormatException e) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f113a == C0135v.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        stringBuilder.append(' ').append(this.f114b);
        if (this.f115c != null) {
            stringBuilder.append(' ').append(this.f115c);
        }
        return stringBuilder.toString();
    }
}
