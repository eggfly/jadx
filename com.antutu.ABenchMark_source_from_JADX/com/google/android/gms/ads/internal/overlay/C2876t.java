package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.aq;
import com.google.android.gms.p146b.au;
import com.google.android.gms.p146b.aw;
import com.google.android.gms.p146b.az;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.hn;
import com.google.android.gms.p146b.hn.C3265a;
import com.google.android.gms.p146b.hn.C3266b;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyProtocol;

@gb
/* renamed from: com.google.android.gms.ads.internal.overlay.t */
public class C2876t {
    private final Context f9727a;
    private final String f9728b;
    private final VersionInfoParcel f9729c;
    private final aw f9730d;
    private final az f9731e;
    private final hn f9732f;
    private final long[] f9733g;
    private final String[] f9734h;
    private aw f9735i;
    private aw f9736j;
    private aw f9737k;
    private aw f9738l;
    private boolean f9739m;
    private C2854i f9740n;
    private boolean f9741o;
    private boolean f9742p;
    private long f9743q;

    public C2876t(Context context, VersionInfoParcel versionInfoParcel, String str, az azVar, aw awVar) {
        this.f9732f = new C3266b().m13130a("min_1", Double.MIN_VALUE, 1.0d).m13130a("1_5", 1.0d, 5.0d).m13130a("5_10", 5.0d, 10.0d).m13130a("10_20", 10.0d, 20.0d).m13130a("20_30", 20.0d, 30.0d).m13130a("30_max", 30.0d, Double.MAX_VALUE).m13131a();
        this.f9743q = -1;
        this.f9727a = context;
        this.f9729c = versionInfoParcel;
        this.f9728b = str;
        this.f9731e = azVar;
        this.f9730d = awVar;
        String str2 = (String) aq.f10308v.m11794c();
        if (str2 == null) {
            this.f9734h = new String[0];
            this.f9733g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, Constants.ACCEPT_TIME_SEPARATOR_SP);
        this.f9734h = new String[split.length];
        this.f9733g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.f9733g[i] = Long.parseLong(split[i]);
            } catch (Throwable e) {
                C2972b.m11584d("Unable to parse frame hash target time number.", e);
                this.f9733g[i] = -1;
            }
        }
    }

    private void m11179c(C2854i c2854i) {
        long longValue = ((Long) aq.f10309w.m11794c()).longValue();
        long currentPosition = (long) c2854i.getCurrentPosition();
        int i = 0;
        while (i < this.f9734h.length) {
            if (this.f9734h[i] == null && longValue > Math.abs(currentPosition - this.f9733g[i])) {
                this.f9734h[i] = m11181a((TextureView) c2854i);
                return;
            }
            i++;
        }
    }

    private void m11180e() {
        if (this.f9737k != null && this.f9738l == null) {
            au.m11834a(this.f9731e, this.f9737k, "vff");
            au.m11834a(this.f9731e, this.f9730d, "vtt");
            this.f9738l = au.m11831a(this.f9731e);
        }
        long c = C2968s.m11529i().m13545c();
        if (this.f9739m && this.f9742p && this.f9743q != -1) {
            this.f9732f.m13134a(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (c - this.f9743q)));
        }
        this.f9742p = this.f9739m;
        this.f9743q = c;
    }

    String m11181a(TextureView textureView) {
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j = 0;
        long j2 = 63;
        int i = 0;
        while (i < 8) {
            long j3 = j;
            j = j2;
            for (int i2 = 0; i2 < 8; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                j3 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > SpdyProtocol.SLIGHTSSLV2 ? 1 : 0) << ((int) j);
                j--;
            }
            i++;
            j2 = j;
            j = j3;
        }
        return String.format("%016X", new Object[]{Long.valueOf(j)});
    }

    public void m11182a() {
        if (this.f9735i != null && this.f9736j == null) {
            au.m11834a(this.f9731e, this.f9735i, "vfr");
            this.f9736j = au.m11831a(this.f9731e);
        }
    }

    public void m11183a(C2854i c2854i) {
        au.m11834a(this.f9731e, this.f9730d, "vpc");
        this.f9735i = au.m11831a(this.f9731e);
        this.f9740n = c2854i;
    }

    public void m11184b() {
        if (((Boolean) aq.f10307u.m11794c()).booleanValue() && !this.f9741o) {
            Bundle bundle = new Bundle();
            bundle.putString(C4233j.f14402y, "native-player-metrics");
            bundle.putString("request", this.f9728b);
            bundle.putString("player", this.f9740n.m11048a());
            for (C3265a c3265a : this.f9732f.m13133a()) {
                bundle.putString("fps_c_" + c3265a.f11314a, Integer.toString(c3265a.f11318e));
                bundle.putString("fps_p_" + c3265a.f11314a, Double.toString(c3265a.f11317d));
            }
            for (int i = 0; i < this.f9733g.length; i++) {
                String str = this.f9734h[i];
                if (str != null) {
                    bundle.putString("fh_" + Long.valueOf(this.f9733g[i]), str);
                }
            }
            C2968s.m11525e().m13036a(this.f9727a, this.f9729c.f10081b, "gmob-apps", bundle, true);
            this.f9741o = true;
        }
    }

    public void m11185b(C2854i c2854i) {
        m11180e();
        m11179c(c2854i);
    }

    public void m11186c() {
        this.f9739m = true;
        if (this.f9736j != null && this.f9737k == null) {
            au.m11834a(this.f9731e, this.f9736j, "vfp");
            this.f9737k = au.m11831a(this.f9731e);
        }
    }

    public void m11187d() {
        this.f9739m = false;
    }
}
