package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.utils.Hashon;
import com.taobao.accs.ErrorCode;
import java.util.HashMap;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: cn.sharesdk.wechat.utils.i */
public class C1053i {
    private Platform f3539a;
    private ShareParams f3540b;
    private PlatformActionListener f3541c;
    private AuthorizeListener f3542d;
    private C1051g f3543e;

    public C1053i(Platform platform) {
        this.f3539a = platform;
    }

    public ShareParams m4708a() {
        return this.f3540b;
    }

    public void m4709a(ShareParams shareParams, PlatformActionListener platformActionListener) {
        this.f3540b = shareParams;
        this.f3541c = platformActionListener;
    }

    public void m4710a(AuthorizeListener authorizeListener) {
        this.f3542d = authorizeListener;
    }

    public void m4711a(WechatResp wechatResp) {
        HashMap hashMap;
        Throwable th;
        switch (wechatResp.f3512f) {
            case ErrorCode.MESSAGE_TOO_LARGE /*-4*/:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(wechatResp.f3512f));
                hashMap.put("errStr", wechatResp.f3513g);
                hashMap.put("transaction", wechatResp.f3514h);
                th = new Throwable(new Hashon().fromHashMap(hashMap));
                switch (wechatResp.m4664a()) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (this.f3542d != null) {
                            this.f3542d.onError(th);
                        }
                    default:
                }
            case TnetStatusCode.EASY_REQ_STATE_PROCESS_RSP_FAIL /*-3*/:
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(wechatResp.f3512f));
                hashMap.put("errStr", wechatResp.f3513g);
                hashMap.put("transaction", wechatResp.f3514h);
                th = new Throwable(new Hashon().fromHashMap(hashMap));
                switch (wechatResp.m4664a()) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (this.f3542d != null) {
                            this.f3542d.onError(th);
                        }
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (this.f3541c != null) {
                            this.f3541c.onError(this.f3539a, 9, th);
                        }
                    default:
                }
            case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                switch (wechatResp.m4664a()) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (this.f3542d != null) {
                            this.f3542d.onCancel();
                        }
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (this.f3541c != null) {
                            this.f3541c.onCancel(this.f3539a, 9);
                        }
                    default:
                }
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                switch (wechatResp.m4664a()) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (this.f3542d != null) {
                            Bundle bundle = new Bundle();
                            wechatResp.m4666b(bundle);
                            this.f3543e.m4693a(bundle, this.f3542d);
                        }
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (this.f3541c != null) {
                            hashMap = new HashMap();
                            hashMap.put("ShareParams", this.f3540b);
                            this.f3541c.onComplete(this.f3539a, 9, hashMap);
                        }
                    default:
                }
            default:
                hashMap = new HashMap();
                hashMap.put("req", wechatResp.getClass().getSimpleName());
                hashMap.put("errCode", Integer.valueOf(wechatResp.f3512f));
                hashMap.put("errStr", wechatResp.f3513g);
                hashMap.put("transaction", wechatResp.f3514h);
                new Throwable(new Hashon().fromHashMap(hashMap)).printStackTrace();
        }
    }

    public void m4712a(C1051g c1051g) {
        this.f3543e = c1051g;
    }

    public Platform m4713b() {
        return this.f3539a;
    }

    public PlatformActionListener m4714c() {
        return this.f3541c;
    }
}
