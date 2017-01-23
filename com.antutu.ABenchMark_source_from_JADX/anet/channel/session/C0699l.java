package anet.channel.session;

import anet.channel.util.Utils;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SpdyProtocol;

/* renamed from: anet.channel.session.l */
class C0699l implements AccsSSLCallback {
    final /* synthetic */ C0687k f2289a;

    C0699l(C0687k c0687k) {
        this.f2289a = c0687k;
    }

    public byte[] getSSLPublicKey(int i, byte[] bArr) {
        return Utils.staticBinarySafeDecryptNoB64(this.f2289a.mContext, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
    }
}
