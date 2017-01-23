package com.taobao.accs.net;

import anet.channel.util.Utils;
import org.android.spdy.AccsSSLCallback;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.taobao.accs.net.o */
class C4127o implements AccsSSLCallback {
    final /* synthetic */ C4124l f13826a;

    C4127o(C4124l c4124l) {
        this.f13826a = c4124l;
    }

    public byte[] getSSLPublicKey(int i, byte[] bArr) {
        return Utils.staticBinarySafeDecryptNoB64(this.f13826a.b, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr);
    }
}
