package p000a.p001a.p005c;

import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import java.util.List;
import java.util.regex.Pattern;
import p000a.C0119l;
import p000a.C0120m;
import p000a.C0127q;
import p000a.C0130r;
import p000a.C0143z;

/* renamed from: a.a.c.e */
public final class C0028e {
    private static final Pattern f98a;

    static {
        f98a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static int m104a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                break;
            }
            i++;
        }
        return i;
    }

    public static int m105a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static long m106a(C0127q c0127q) {
        return C0028e.m108a(c0127q.m550a(HttpRequest.f14558k));
    }

    public static long m107a(C0143z c0143z) {
        return C0028e.m106a(c0143z.m699d());
    }

    private static long m108a(String str) {
        long j = -1;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static void m109a(C0120m c0120m, C0130r c0130r, C0127q c0127q) {
        if (c0120m != C0120m.f511a) {
            List a = C0119l.m517a(c0130r, c0127q);
            if (!a.isEmpty()) {
                c0120m.m524a(c0130r, a);
            }
        }
    }

    public static int m110b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            return parseLong > 2147483647L ? Integer.MAX_VALUE : parseLong < 0 ? 0 : (int) parseLong;
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static boolean m111b(C0143z c0143z) {
        if (c0143z.m694a().m663b().equals(HttpRequest.f14572y)) {
            return false;
        }
        int b = c0143z.m697b();
        return ((b >= 100 && b < Constants.COMMAND_HANDSHAKE) || b == 204 || b == ErrorCode.DM_PACKAGENAME_INVALID) ? C0028e.m107a(c0143z) != -1 || "chunked".equalsIgnoreCase(c0143z.m695a("Transfer-Encoding")) : true;
    }
}
