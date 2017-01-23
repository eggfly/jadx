package com.google.android.gms.p146b;

import android.content.Context;
import android.text.TextUtils;
import com.google.analytics.tracking.android.ModelFields;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2971a;
import com.google.android.gms.common.api.C3079e;
import com.umeng.message.proguard.C4233j;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

@gb
/* renamed from: com.google.android.gms.b.cn */
public abstract class cn implements C3079e {
    protected Context f10471a;
    protected String f10472b;
    protected WeakReference<ii> f10473c;

    /* renamed from: com.google.android.gms.b.cn.1 */
    class C30761 implements Runnable {
        final /* synthetic */ String f10456a;
        final /* synthetic */ String f10457b;
        final /* synthetic */ int f10458c;
        final /* synthetic */ int f10459d;
        final /* synthetic */ boolean f10460e;
        final /* synthetic */ cn f10461f;

        C30761(cn cnVar, String str, String str2, int i, int i2, boolean z) {
            this.f10461f = cnVar;
            this.f10456a = str;
            this.f10457b = str2;
            this.f10458c = i;
            this.f10459d = i2;
            this.f10460e = z;
        }

        public void run() {
            Map hashMap = new HashMap();
            hashMap.put(ModelFields.EVENT, "precacheProgress");
            hashMap.put("src", this.f10456a);
            hashMap.put("cachedSrc", this.f10457b);
            hashMap.put("bytesLoaded", Integer.toString(this.f10458c));
            hashMap.put("totalBytes", Integer.toString(this.f10459d));
            hashMap.put("cacheReady", this.f10460e ? MessageService.MSG_DB_NOTIFY_REACHED : MessageService.MSG_DB_READY_REPORT);
            this.f10461f.m12079a("onPrecacheEvent", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.b.cn.2 */
    class C30772 implements Runnable {
        final /* synthetic */ String f10462a;
        final /* synthetic */ String f10463b;
        final /* synthetic */ int f10464c;
        final /* synthetic */ cn f10465d;

        C30772(cn cnVar, String str, String str2, int i) {
            this.f10465d = cnVar;
            this.f10462a = str;
            this.f10463b = str2;
            this.f10464c = i;
        }

        public void run() {
            Map hashMap = new HashMap();
            hashMap.put(ModelFields.EVENT, "precacheComplete");
            hashMap.put("src", this.f10462a);
            hashMap.put("cachedSrc", this.f10463b);
            hashMap.put("totalBytes", Integer.toString(this.f10464c));
            this.f10465d.m12079a("onPrecacheEvent", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.b.cn.3 */
    class C30783 implements Runnable {
        final /* synthetic */ String f10466a;
        final /* synthetic */ String f10467b;
        final /* synthetic */ String f10468c;
        final /* synthetic */ String f10469d;
        final /* synthetic */ cn f10470e;

        C30783(cn cnVar, String str, String str2, String str3, String str4) {
            this.f10470e = cnVar;
            this.f10466a = str;
            this.f10467b = str2;
            this.f10468c = str3;
            this.f10469d = str4;
        }

        public void run() {
            Map hashMap = new HashMap();
            hashMap.put(ModelFields.EVENT, "precacheCanceled");
            hashMap.put("src", this.f10466a);
            if (!TextUtils.isEmpty(this.f10467b)) {
                hashMap.put("cachedSrc", this.f10467b);
            }
            hashMap.put(C4233j.f14402y, this.f10470e.m12080c(this.f10468c));
            hashMap.put("reason", this.f10468c);
            if (!TextUtils.isEmpty(this.f10469d)) {
                hashMap.put(C4233j.f14376C, this.f10469d);
            }
            this.f10470e.m12079a("onPrecacheEvent", hashMap);
        }
    }

    public cn(ii iiVar) {
        this.f10471a = iiVar.getContext();
        this.f10472b = C2968s.m11525e().m13024a(this.f10471a, iiVar.m13252o().f10081b);
        this.f10473c = new WeakReference(iiVar);
    }

    private void m12079a(String str, Map<String, String> map) {
        ii iiVar = (ii) this.f10473c.get();
        if (iiVar != null) {
            iiVar.m13230a(str, (Map) map);
        }
    }

    private String m12080c(String str) {
        String str2 = "internal";
        Object obj = -1;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    obj = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    obj = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    obj = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    obj = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    obj = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    obj = 8;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    obj = 9;
                    break;
                }
                break;
            case 96784904:
                if (str.equals(C4233j.f14375B)) {
                    obj = null;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    obj = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return "internal";
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return "io";
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                return "network";
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return "policy";
            default:
                return str2;
        }
    }

    public void m12081a() {
    }

    protected void m12082a(String str, String str2, int i) {
        C2971a.f10085a.post(new C30772(this, str, str2, i));
    }

    protected void m12083a(String str, String str2, int i, int i2, boolean z) {
        C2971a.f10085a.post(new C30761(this, str, str2, i, i2, z));
    }

    protected void m12084a(String str, String str2, String str3, String str4) {
        C2971a.f10085a.post(new C30783(this, str, str2, str3, str4));
    }

    public abstract boolean m12085a(String str);

    protected String m12086b(String str) {
        return C2784w.m10741a().m11563a(str);
    }

    public abstract void m12087b();
}
