package p000a;

import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: a.ac */
public enum ac {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    final String f392f;

    private ac(String str) {
        this.f392f = str;
    }

    public static ac m462a(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -503070503:
                if (str.equals("TLSv1.1")) {
                    obj = 2;
                    break;
                }
                break;
            case -503070502:
                if (str.equals("TLSv1.2")) {
                    obj = 1;
                    break;
                }
                break;
            case -503070501:
                if (str.equals("TLSv1.3")) {
                    obj = null;
                    break;
                }
                break;
            case 79201641:
                if (str.equals("SSLv3")) {
                    obj = 4;
                    break;
                }
                break;
            case 79923350:
                if (str.equals("TLSv1")) {
                    obj = 3;
                    break;
                }
                break;
        }
        switch (obj) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return TLS_1_3;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return TLS_1_2;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return TLS_1_1;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return TLS_1_0;
            case SpdyProtocol.QUIC /*4*/:
                return SSL_3_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }
}
