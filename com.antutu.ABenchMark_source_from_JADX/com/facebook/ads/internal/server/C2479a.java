package com.facebook.ads.internal.server;

import android.content.Context;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.AdErrorType;
import com.facebook.ads.internal.C2343b;
import com.facebook.ads.internal.C2472h;
import com.facebook.ads.internal.p125c.C2347c;
import com.facebook.ads.internal.p125c.C2350e;
import com.facebook.ads.internal.p125c.C2352g;
import com.facebook.ads.internal.p127e.p128a.C2360a;
import com.facebook.ads.internal.p127e.p128a.C2361b;
import com.facebook.ads.internal.p127e.p128a.C2372m;
import com.facebook.ads.internal.p127e.p128a.C2373n;
import com.facebook.ads.internal.server.C2482c.C2481a;
import com.facebook.ads.internal.util.C2492d;
import com.facebook.ads.internal.util.C2506n;
import com.facebook.ads.internal.util.C2506n.C2505a;
import com.facebook.ads.internal.util.C2508p;
import com.facebook.ads.internal.util.C2510r;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.android.spdy.SpdyProtocol;
import org.json.JSONException;

/* renamed from: com.facebook.ads.internal.server.a */
public class C2479a {
    private static final C2508p f8528i;
    private static final ThreadPoolExecutor f8529j;
    Map<String, String> f8530a;
    private final Context f8531b;
    private final C2480b f8532c;
    private final C2472h f8533d;
    private C2294a f8534e;
    private C2350e f8535f;
    private C2360a f8536g;
    private final String f8537h;

    /* renamed from: com.facebook.ads.internal.server.a.a */
    public interface C2294a {
        void m8656a(C2343b c2343b);

        void m8657a(C2483d c2483d);
    }

    /* renamed from: com.facebook.ads.internal.server.a.1 */
    class C24761 implements Runnable {
        final /* synthetic */ C2350e f8524a;
        final /* synthetic */ C2479a f8525b;

        C24761(C2479a c2479a, C2350e c2350e) {
            this.f8525b = c2479a;
            this.f8524a = c2350e;
        }

        public void run() {
            C2352g.m9065b(this.f8525b.f8531b);
            this.f8525b.f8530a = this.f8524a.m9063e();
            try {
                this.f8525b.f8536g = new C2360a(this.f8525b.f8531b, this.f8524a.f8190e);
                this.f8525b.f8536g.m9100a(this.f8525b.f8537h, this.f8525b.f8536g.m9106b().m9139a(this.f8525b.f8530a), this.f8525b.m9431b());
            } catch (Exception e) {
                this.f8525b.m9426a(AdErrorType.AD_REQUEST_FAILED.getAdErrorWrapper(e.getMessage()));
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.server.a.2 */
    class C24772 extends C2361b {
        final /* synthetic */ C2479a f8526a;

        C24772(C2479a c2479a) {
            this.f8526a = c2479a;
        }

        public void m9421a(C2372m c2372m) {
            C2492d.m9461b(this.f8526a.f8535f);
            this.f8526a.f8536g = null;
            try {
                C2373n a = c2372m.m9133a();
                if (a != null) {
                    String e = a.m9138e();
                    C2482c a2 = this.f8526a.f8532c.m9444a(e);
                    if (a2.m9445a() == C2481a.ERROR) {
                        C2484e c2484e = (C2484e) a2;
                        String c = c2484e.m9447c();
                        this.f8526a.m9426a(AdErrorType.adErrorTypeFromCode(c2484e.m9448d(), AdErrorType.ERROR_MESSAGE).getAdErrorWrapper(c == null ? e : c));
                        return;
                    }
                }
            } catch (JSONException e2) {
            }
            this.f8526a.m9426a(new C2343b(AdErrorType.NETWORK_ERROR, c2372m.getMessage()));
        }

        public void m9422a(C2373n c2373n) {
            if (c2373n != null) {
                String e = c2373n.m9138e();
                C2492d.m9461b(this.f8526a.f8535f);
                this.f8526a.f8536g = null;
                this.f8526a.m9430a(e);
            }
        }

        public void m9423a(Exception exception) {
            if (C2372m.class.equals(exception.getClass())) {
                m9421a((C2372m) exception);
            } else {
                this.f8526a.m9426a(new C2343b(AdErrorType.NETWORK_ERROR, exception.getMessage()));
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.server.a.3 */
    static /* synthetic */ class C24783 {
        static final /* synthetic */ int[] f8527a;

        static {
            f8527a = new int[C2481a.values().length];
            try {
                f8527a[C2481a.ADS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8527a[C2481a.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static {
        f8528i = new C2508p();
        f8529j = (ThreadPoolExecutor) Executors.newCachedThreadPool(f8528i);
    }

    public C2479a(Context context) {
        String str;
        this.f8531b = context.getApplicationContext();
        this.f8532c = C2480b.m9440a();
        this.f8533d = new C2472h(this.f8531b);
        if (C2510r.m9516a(AdSettings.getUrlPrefix())) {
            str = "https://graph.facebook.com/network_ads_common/";
        } else {
            str = String.format("https://graph.%s.facebook.com/network_ads_common/", new Object[]{AdSettings.getUrlPrefix()});
        }
        this.f8537h = str;
    }

    private void m9426a(C2343b c2343b) {
        if (this.f8534e != null) {
            this.f8534e.m8656a(c2343b);
        }
        m9437a();
    }

    private void m9429a(C2483d c2483d) {
        if (this.f8534e != null) {
            this.f8534e.m8657a(c2483d);
        }
        m9437a();
    }

    private void m9430a(String str) {
        try {
            C2482c a = this.f8532c.m9444a(str);
            C2347c b = a.m9446b();
            if (b != null) {
                this.f8533d.m9405a(b.m9043b());
                C2492d.m9458a(b.m9041a().m9049c(), this.f8535f);
            }
            switch (C24783.f8527a[a.m9445a().ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    C2483d c2483d = (C2483d) a;
                    if (b != null && b.m9041a().m9050d()) {
                        C2492d.m9459a(str, this.f8535f);
                    }
                    m9429a(c2483d);
                    return;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    C2484e c2484e = (C2484e) a;
                    String c = c2484e.m9447c();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(c2484e.m9448d(), AdErrorType.ERROR_MESSAGE);
                    if (c != null) {
                        str = c;
                    }
                    m9426a(adErrorTypeFromCode.getAdErrorWrapper(str));
                    return;
                default:
                    m9426a(AdErrorType.UNKNOWN_RESPONSE.getAdErrorWrapper(str));
                    return;
            }
        } catch (Exception e) {
            m9426a(AdErrorType.PARSER_FAILURE.getAdErrorWrapper(e.getMessage()));
        }
        m9426a(AdErrorType.PARSER_FAILURE.getAdErrorWrapper(e.getMessage()));
    }

    private C2361b m9431b() {
        return new C24772(this);
    }

    public void m9437a() {
        if (this.f8536g != null) {
            this.f8536g.m9108c(1);
            this.f8536g.m9107b(1);
            this.f8536g = null;
        }
    }

    public void m9438a(C2350e c2350e) {
        m9437a();
        if (C2506n.m9508a(this.f8531b) == C2505a.NONE) {
            m9426a(new C2343b(AdErrorType.NETWORK_ERROR, "No network connection"));
            return;
        }
        this.f8535f = c2350e;
        if (C2492d.m9460a(c2350e)) {
            String c = C2492d.m9462c(c2350e);
            if (c != null) {
                m9430a(c);
                return;
            } else {
                m9426a(AdErrorType.LOAD_TOO_FREQUENTLY.getAdErrorWrapper(null));
                return;
            }
        }
        f8529j.submit(new C24761(this, c2350e));
    }

    public void m9439a(C2294a c2294a) {
        this.f8534e = c2294a;
    }
}
