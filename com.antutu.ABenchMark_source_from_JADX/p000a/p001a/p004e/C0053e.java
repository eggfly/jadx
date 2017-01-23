package p000a.p001a.p004e;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.IOException;
import okio.ByteString;
import org.android.spdy.SpdyProtocol;
import p000a.p001a.C0037c;

/* renamed from: a.a.e.e */
public final class C0053e {
    static final ByteString f192a;
    static final String[] f193b;
    static final String[] f194c;
    private static final String[] f195d;

    static {
        int i = 0;
        f192a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f195d = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f193b = new String[64];
        f194c = new String[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        for (int i2 = 0; i2 < f194c.length; i2++) {
            f194c[i2] = C0037c.m153a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
        }
        f193b[0] = BuildConfig.FLAVOR;
        f193b[1] = "END_STREAM";
        int[] iArr = new int[]{1};
        f193b[8] = "PADDED";
        for (int i3 : iArr) {
            f193b[i3 | 8] = f193b[i3] + "|PADDED";
        }
        f193b[4] = "END_HEADERS";
        f193b[32] = "PRIORITY";
        f193b[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr) {
                f193b[i5 | i4] = f193b[i5] + '|' + f193b[i4];
                f193b[(i5 | i4) | 8] = f193b[i5] + '|' + f193b[i4] + "|PADDED";
            }
        }
        while (i < f193b.length) {
            if (f193b[i] == null) {
                f193b[i] = f194c[i];
            }
            i++;
        }
    }

    private C0053e() {
    }

    static IllegalArgumentException m218a(String str, Object... objArr) {
        throw new IllegalArgumentException(C0037c.m153a(str, objArr));
    }

    static String m219a(byte b, byte b2) {
        if (b2 == null) {
            return BuildConfig.FLAVOR;
        }
        switch (b) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return f194c[b2];
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return b2 == 1 ? "ACK" : f194c[b2];
            default:
                String str = b2 < f193b.length ? f193b[b2] : f194c[b2];
                return (b != 5 || (b2 & 4) == 0) ? (b != null || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
        }
    }

    static String m220a(boolean z, int i, int i2, byte b, byte b2) {
        String a = b < f195d.length ? f195d[b] : C0037c.m153a("0x%02x", Byte.valueOf(b));
        String a2 = C0053e.m219a(b, b2);
        String str = "%s 0x%08x %5d %-13s %s";
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a;
        objArr[4] = a2;
        return C0037c.m153a(str, objArr);
    }

    static IOException m221b(String str, Object... objArr) {
        throw new IOException(C0037c.m153a(str, objArr));
    }
}
