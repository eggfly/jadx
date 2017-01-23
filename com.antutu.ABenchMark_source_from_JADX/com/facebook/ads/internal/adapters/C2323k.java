package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;
import android.webkit.WebView;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.InterstitialAdActivity.Type;
import com.facebook.ads.internal.util.C2494f;
import com.facebook.ads.internal.util.C2499h;
import com.taobao.accs.common.Constants;
import java.util.Map;
import java.util.UUID;
import org.android.spdy.SpdyProtocol;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.k */
public class C2323k extends InterstitialAdapter {
    private final String f8032a;
    private Context f8033b;
    private C2300c f8034c;
    private InterstitialAdapterListener f8035d;
    private boolean f8036e;
    private C2329n f8037f;
    private C2322a f8038g;
    private WebView f8039h;

    /* renamed from: com.facebook.ads.internal.adapters.k.a */
    public enum C2322a {
        VERTICAL,
        HORIZONTAL;

        public static C2322a m8843a(int i) {
            return i == 2 ? HORIZONTAL : VERTICAL;
        }
    }

    public C2323k() {
        this.f8032a = UUID.randomUUID().toString();
        this.f8036e = false;
    }

    private int m8844a() {
        int rotation = ((WindowManager) this.f8033b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (this.f8038g == C2322a.HORIZONTAL) {
            switch (rotation) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    return 8;
                default:
                    return 0;
            }
        }
        switch (rotation) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return 9;
            default:
                return 1;
        }
    }

    public void loadInterstitialAd(Context context, InterstitialAdapterListener interstitialAdapterListener, Map<String, Object> map) {
        this.f8033b = context;
        this.f8035d = interstitialAdapterListener;
        this.f8037f = C2329n.m8937a((JSONObject) map.get(Constants.KEY_DATA));
        if (C2494f.m9466a(context, this.f8037f)) {
            interstitialAdapterListener.onInterstitialError(this, AdError.NO_FILL);
            return;
        }
        this.f8034c = new C2300c(context, this.f8032a, this, this.f8035d);
        this.f8034c.m8721a();
        Map e = this.f8037f.m8947e();
        if (e.containsKey("orientation")) {
            this.f8038g = C2322a.m8843a(Integer.parseInt((String) e.get("orientation")));
        }
        this.f8036e = true;
        if (this.f8035d != null) {
            this.f8035d.onInterstitialAdLoaded(this);
        }
    }

    public void onDestroy() {
        if (this.f8034c != null) {
            this.f8034c.m8722b();
        }
        if (this.f8039h != null) {
            C2499h.m9493a(this.f8039h);
            this.f8039h.destroy();
            this.f8039h = null;
        }
    }

    public boolean show() {
        if (this.f8036e) {
            Intent intent = new Intent(this.f8033b, InterstitialAdActivity.class);
            this.f8037f.m8943a(intent);
            intent.putExtra(InterstitialAdActivity.PREDEFINED_ORIENTATION_KEY, m8844a());
            intent.putExtra("adInterstitialUniqueId", this.f8032a);
            intent.putExtra(InterstitialAdActivity.VIEW_TYPE, Type.DISPLAY);
            intent.addFlags(268435456);
            this.f8033b.startActivity(intent);
            return true;
        }
        if (this.f8035d != null) {
            this.f8035d.onInterstitialError(this, AdError.INTERNAL_ERROR);
        }
        return false;
    }
}
