package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.C2798f;
import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

@gb
/* renamed from: com.google.android.gms.b.ch */
public class ch implements cb {
    static final Map<String, Integer> f10437a;
    private final C2798f f10438b;
    private final el f10439c;

    static {
        f10437a = jh.m13546a("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    }

    public ch(C2798f c2798f, el elVar) {
        this.f10438b = c2798f;
        this.f10439c = elVar;
    }

    public void m12048a(ii iiVar, Map<String, String> map) {
        int intValue = ((Integer) f10437a.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.f10438b == null || this.f10438b.m10777b()) {
            switch (intValue) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    this.f10439c.m12602a((Map) map);
                    return;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    new en(iiVar, map).m12613a();
                    return;
                case SpdyProtocol.QUIC /*4*/:
                    new ek(iiVar, map).m12596a();
                    return;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    new em(iiVar, map).m12609a();
                    return;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    this.f10439c.m12603a(true);
                    return;
                default:
                    C2972b.m11581c("Unknown MRAID command called.");
                    return;
            }
        }
        this.f10438b.m10776a(null);
    }
}
