package com.facebook.ads.internal.p125c;

import android.content.Context;
import anet.channel.strategy.dispatch.C0714a;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.AdSdkVersion;
import com.facebook.ads.internal.C2353c;
import com.facebook.ads.internal.C2356d;
import com.facebook.ads.internal.C2409e;
import com.facebook.ads.internal.adapters.C2312f;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.C2490c;
import com.facebook.ads.internal.util.C2506n;
import com.umeng.message.common.C4210b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.c.e */
public class C2350e {
    protected String f8186a;
    protected AdPlacementType f8187b;
    protected C2346b f8188c;
    public Context f8189d;
    public C2409e f8190e;
    public boolean f8191f;
    private C2353c f8192g;
    private int f8193h;
    private AdSize f8194i;

    /* renamed from: com.facebook.ads.internal.c.e.1 */
    static /* synthetic */ class C23491 {
        static final /* synthetic */ int[] f8185a;

        static {
            f8185a = new int[C2346b.values().length];
            try {
                f8185a[C2346b.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8185a[C2346b.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8185a[C2346b.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public C2350e(Context context, String str, AdSize adSize, C2409e c2409e, C2353c c2353c, int i, boolean z) {
        this.f8186a = str;
        this.f8194i = adSize;
        this.f8190e = c2409e;
        this.f8188c = C2346b.m9040a(c2409e);
        this.f8192g = c2353c;
        this.f8193h = i;
        this.f8191f = z;
        m9055a(context);
    }

    private void m9055a(Context context) {
        this.f8189d = context;
        C2352g.m9064a(context);
        m9058f();
    }

    private void m9056a(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    private static Map<String, String> m9057b(Context context) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("SDK", C0714a.ANDROID);
        hashMap.put("SDK_VERSION", AdSdkVersion.BUILD);
        hashMap.put("LOCALE", Locale.getDefault().toString());
        float f = context.getResources().getDisplayMetrics().density;
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        hashMap.put("DENSITY", String.valueOf(f));
        hashMap.put("SCREEN_WIDTH", String.valueOf((int) (((float) i) / f)));
        hashMap.put("SCREEN_HEIGHT", String.valueOf((int) (((float) i2) / f)));
        hashMap.put("IDFA", C2352g.f8213o);
        hashMap.put("IDFA_FLAG", C2352g.f8214p ? MessageService.MSG_DB_READY_REPORT : MessageService.MSG_DB_NOTIFY_REACHED);
        hashMap.put("ATTRIBUTION_ID", C2352g.f8212n);
        hashMap.put("ID_SOURCE", C2352g.f8215q);
        hashMap.put("OS", C4210b.f14219D);
        hashMap.put("OSVERS", C2352g.f8199a);
        hashMap.put("BUNDLE", C2352g.f8202d);
        hashMap.put("APPNAME", C2352g.f8203e);
        hashMap.put("APPVERS", C2352g.f8204f);
        hashMap.put("APPBUILD", String.valueOf(C2352g.f8205g));
        hashMap.put("CARRIER", C2352g.f8207i);
        hashMap.put("MAKE", C2352g.f8200b);
        hashMap.put("MODEL", C2352g.f8201c);
        hashMap.put("COPPA", String.valueOf(AdSettings.isChildDirected()));
        hashMap.put("INSTALLER", C2352g.f8206h);
        hashMap.put("SDK_CAPABILITY", C2356d.m9072b());
        hashMap.put("NETWORK_TYPE", String.valueOf(C2506n.m9508a(context).f8615g));
        return hashMap;
    }

    private void m9058f() {
        if (this.f8188c == null) {
            this.f8188c = C2346b.UNKNOWN;
        }
        switch (C23491.f8185a[this.f8188c.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f8187b = AdPlacementType.INTERSTITIAL;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f8187b = AdPlacementType.BANNER;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                this.f8187b = AdPlacementType.NATIVE;
            default:
                this.f8187b = AdPlacementType.UNKNOWN;
        }
    }

    public String m9059a() {
        return this.f8186a;
    }

    public C2346b m9060b() {
        return this.f8188c;
    }

    public AdSize m9061c() {
        return this.f8194i;
    }

    public int m9062d() {
        return this.f8193h;
    }

    public Map<String, String> m9063e() {
        Map<String, String> hashMap = new HashMap();
        m9056a(hashMap, "PLACEMENT_ID", this.f8186a);
        if (this.f8187b != AdPlacementType.UNKNOWN) {
            m9056a(hashMap, "PLACEMENT_TYPE", this.f8187b.toString().toLowerCase());
        }
        for (Entry entry : C2350e.m9057b(this.f8189d).entrySet()) {
            m9056a(hashMap, (String) entry.getKey(), (String) entry.getValue());
        }
        if (this.f8194i != null) {
            m9056a(hashMap, "WIDTH", String.valueOf(this.f8194i.getWidth()));
            m9056a(hashMap, "HEIGHT", String.valueOf(this.f8194i.getHeight()));
        }
        m9056a(hashMap, "ADAPTERS", C2312f.m8816a(this.f8187b));
        if (this.f8190e != null) {
            m9056a(hashMap, "TEMPLATE_ID", String.valueOf(this.f8190e.m9262a()));
        }
        if (this.f8192g != null) {
            m9056a(hashMap, "REQUEST_TYPE", String.valueOf(this.f8192g.m9068a()));
        }
        if (this.f8191f) {
            m9056a(hashMap, "TEST_MODE", MessageService.MSG_DB_NOTIFY_REACHED);
        }
        if (this.f8193h != 0) {
            m9056a(hashMap, "NUM_ADS_REQUESTED", String.valueOf(this.f8193h));
        }
        String mediationService = AdSettings.getMediationService();
        if (mediationService != null) {
            m9056a(hashMap, "MEDIATION_SERVICE", mediationService);
        }
        m9056a(hashMap, "CLIENT_EVENTS", C2490c.m9455a());
        return hashMap;
    }
}
