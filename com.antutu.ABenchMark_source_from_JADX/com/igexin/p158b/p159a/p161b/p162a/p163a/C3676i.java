package com.igexin.p158b.p159a.p161b.p162a.p163a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.p176a.C3777e;
import java.net.Socket;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.igexin.b.a.b.a.a.i */
class C3676i extends Handler {
    final /* synthetic */ C3671d f12390a;

    public C3676i(C3671d c3671d) {
        this.f12390a = c3671d;
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                if (!this.f12390a.m15005k()) {
                    this.f12390a.m14996f();
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f12390a.f12382l = false;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f12390a.m14984a((Socket) message.obj);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (this.f12390a.m15004j()) {
                    this.f12390a.m15000h();
                }
            case SpdyProtocol.QUIC /*4*/:
                this.f12390a.m15006l();
                if (this.f12390a.f12381k == null && this.f12390a.f12380j == null && this.f12390a.f12379i == null) {
                    C3777e.m15491a().m15556e(false);
                } else if (this.f12390a.m15004j()) {
                    this.f12390a.m15000h();
                } else {
                    this.f12390a.m14998g();
                }
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                if (this.f12390a.m15004j()) {
                    C3688a.m15097b(C3671d.f12369e + "|tcp is close reconnect immediately");
                    C3777e.m15491a().m15556e(((Boolean) message.obj).booleanValue());
                    return;
                }
                C3688a.m15097b(C3671d.f12369e + "|reconnect will run after close");
            default:
        }
    }
}
