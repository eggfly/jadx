package com.facebook.ads.internal.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView.C0510a;
import android.support.v7.widget.RecyclerView.C0532u;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView.ScaleType;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.p121f.C2452f;
import com.facebook.ads.internal.p121f.C2467n;
import com.facebook.ads.internal.p121f.p132b.C2430c;
import com.facebook.ads.internal.util.C2315l;
import com.facebook.ads.internal.util.C2502k;
import java.util.List;

/* renamed from: com.facebook.ads.internal.adapters.i */
public class C2317i extends C0510a<C2452f> {
    private static final int f8014a;
    private final List<NativeAd> f8015b;
    private final int f8016c;
    private final int f8017d;

    /* renamed from: com.facebook.ads.internal.adapters.i.1 */
    class C23161 implements C2315l {
        final /* synthetic */ C2452f f8012a;
        final /* synthetic */ C2317i f8013b;

        C23161(C2317i c2317i, C2452f c2452f) {
            this.f8013b = c2317i;
            this.f8012a = c2452f;
        }

        public void m8821a() {
            this.f8012a.f8464a.setBackgroundColor(C2317i.f8014a);
        }
    }

    static {
        f8014a = Color.argb(51, 0, 0, 0);
    }

    public C2317i(C2430c c2430c, List<NativeAd> list) {
        float f = c2430c.getContext().getResources().getDisplayMetrics().density;
        this.f8015b = list;
        this.f8016c = Math.round(f * 1.0f);
        this.f8017d = c2430c.getChildSpacing();
    }

    public C2452f m8823a(ViewGroup viewGroup, int i) {
        C2467n c2467n = new C2467n(viewGroup.getContext());
        c2467n.setScaleType(ScaleType.CENTER_CROP);
        return new C2452f(c2467n);
    }

    public void m8824a(C2452f c2452f, int i) {
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -1);
        marginLayoutParams.setMargins(i == 0 ? this.f8017d * 2 : this.f8017d, 0, i >= this.f8015b.size() + -1 ? this.f8017d * 2 : this.f8017d, 0);
        c2452f.f8464a.setBackgroundColor(0);
        c2452f.f8464a.setImageDrawable(null);
        c2452f.f8464a.setLayoutParams(marginLayoutParams);
        c2452f.f8464a.setPadding(this.f8016c, this.f8016c, this.f8016c, this.f8016c);
        NativeAd nativeAd = (NativeAd) this.f8015b.get(i);
        nativeAd.registerViewForInteraction(c2452f.f8464a);
        if (nativeAd.getAdCoverImage() != null) {
            C2502k c2502k = new C2502k(c2452f.f8464a);
            c2502k.m9500a(new C23161(this, c2452f));
            c2502k.m9502a(r0.getUrl());
        }
    }

    public int getItemCount() {
        return this.f8015b.size();
    }

    public /* synthetic */ void onBindViewHolder(C0532u c0532u, int i) {
        m8824a((C2452f) c0532u, i);
    }

    public /* synthetic */ C0532u onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m8823a(viewGroup, i);
    }
}
