package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

class ConnectivityManagerCompatHoneycombMR2 {
    ConnectivityManagerCompatHoneycombMR2() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return false;
            default:
                return true;
        }
    }
}
