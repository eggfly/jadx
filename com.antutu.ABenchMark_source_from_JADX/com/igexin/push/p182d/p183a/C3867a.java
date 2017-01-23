package com.igexin.push.p182d.p183a;

import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.facebook.ads.C2279R;
import com.igexin.p158b.p159a.p161b.C3667e;
import com.igexin.p158b.p159a.p161b.C3683b;
import com.igexin.p158b.p159a.p161b.C3686d;
import com.igexin.p158b.p159a.p165d.p166a.C3664f;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.p182d.p185c.C3876e;
import com.igexin.push.p182d.p185c.C3877a;
import com.igexin.push.p182d.p185c.C3878b;
import com.igexin.push.p182d.p185c.C3883h;
import com.igexin.push.p182d.p185c.C3885j;
import com.igexin.push.p182d.p185c.C3888m;
import com.igexin.push.p182d.p185c.C3890o;
import com.igexin.push.p182d.p185c.C3891p;
import com.igexin.push.p182d.p185c.C3892q;
import com.igexin.sdk.PushConsts;
import org.android.spdy.SpdyProtocol;
import org.json.JSONObject;

/* renamed from: com.igexin.push.d.a.a */
public class C3867a extends C3683b {
    public C3867a(String str, C3683b c3683b) {
        super(str, true);
        m15043a(c3683b);
    }

    private boolean m15911a(C3878b c3878b, C3876e c3876e) {
        if (c3878b.f13045b != 26) {
            return false;
        }
        C3891p c3891p = (C3891p) c3876e;
        if (c3891p.m15992a() && c3891p.f13116e != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) c3891p.f13116e);
                if (jSONObject.has(PushConsts.CMD_ACTION)) {
                    String string = jSONObject.getString(PushConsts.CMD_ACTION);
                    if (string != null && string.equals("redirect_server")) {
                        return true;
                    }
                }
            } catch (Exception e) {
                C3688a.m15097b("CommandFilter|" + e.toString());
            }
        }
        return false;
    }

    public Object m15912a(C3667e c3667e, C3686d c3686d, Object obj) {
        if (obj instanceof C3876e) {
            C3876e c3876e = (C3876e) obj;
            C3878b c3878b = new C3878b();
            c3878b.f13045b = (byte) c3876e.f13034i;
            c3878b.m15955a(c3876e.m15948d());
            c3878b.f13046c = c3876e.f13035j;
            c3878b.f13047d = c3876e.f13036k;
            return c3878b;
        } else if (!(obj instanceof C3876e[])) {
            return null;
        } else {
            C3876e[] c3876eArr = (C3876e[]) obj;
            Object obj2 = new C3878b[c3876eArr.length];
            for (int i = 0; i < c3876eArr.length; i++) {
                obj2[i] = new C3878b();
                obj2[i].f13045b = (byte) c3876eArr[i].f13034i;
                obj2[i].m15955a(c3876eArr[i].m15948d());
            }
            return obj2;
        }
    }

    public C3664f m15913b(C3667e c3667e, C3686d c3686d, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof C3883h) {
            return (C3664f) obj;
        }
        C3876e c3888m;
        C3878b c3878b = (C3878b) obj;
        switch (c3878b.f13045b) {
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                c3888m = new C3888m();
                break;
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                c3888m = new C3892q();
                break;
            case C2279R.styleable.ActionBar_homeAsUpIndicator /*26*/:
                c3888m = new C3891p();
                break;
            case C1692R.styleable.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                c3888m = new C3877a();
                break;
            case jni.SID_UX_IMG /*37*/:
                c3888m = new C3890o();
                break;
            case C1692R.styleable.AppCompatTheme_buttonBarNegativeButtonStyle /*97*/:
                c3888m = new C3885j();
                break;
            default:
                c3888m = null;
                break;
        }
        if ((c3878b.f13049f != 1 && c3878b.f13049f != 7) || c3888m == null) {
            return null;
        }
        c3888m.m15946a(c3878b.f13048e);
        if (c3878b.f13049f == 7) {
            return (c3878b.f13050g != 32 || m15911a(c3878b, c3888m)) ? c3888m : null;
        } else {
            if (!m15911a(c3878b, c3888m)) {
                c3888m = null;
            }
            return c3888m;
        }
    }

    public /* synthetic */ Object m15914c(C3667e c3667e, C3686d c3686d, Object obj) {
        return m15913b(c3667e, c3686d, obj);
    }
}
