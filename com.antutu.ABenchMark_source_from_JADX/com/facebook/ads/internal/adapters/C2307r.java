package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.view.View;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.NativeAd.Rating;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.adapters.r */
public abstract class C2307r implements AdAdapter {
    public abstract AdExtras m8723A();

    public abstract List<NativeAd> m8724B();

    public abstract void m8725a();

    public abstract void m8726a(int i);

    public abstract void m8727a(Context context, C2288s c2288s, Map<String, Object> map);

    public abstract void m8728a(View view, List<View> list);

    public abstract void m8729a(Map<String, Object> map);

    public abstract void m8730b(Map<String, Object> map);

    public abstract boolean m8731b();

    public abstract boolean m8732c();

    public abstract boolean m8733d();

    public abstract boolean m8734e();

    public abstract boolean m8735f();

    public abstract boolean m8736g();

    public final AdPlacementType getPlacementType() {
        return AdPlacementType.NATIVE;
    }

    public abstract int m8737h();

    public abstract int m8738i();

    public abstract int m8739j();

    public abstract Image m8740k();

    public abstract Image m8741l();

    public abstract NativeAdViewAttributes m8742m();

    public abstract String m8743n();

    public abstract String m8744o();

    public abstract String m8745p();

    public abstract String m8746q();

    public abstract String m8747r();

    public abstract Rating m8748s();

    public abstract Image m8749t();

    public abstract String m8750u();

    public abstract String m8751v();

    public abstract String m8752w();

    public abstract int m8753x();

    public abstract String m8754y();

    public abstract String m8755z();
}
