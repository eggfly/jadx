package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.overlay.o */
public class C2873o extends FrameLayout implements OnClickListener {
    private final ImageButton f9725a;
    private final C2863s f9726b;

    public C2873o(Context context, int i, C2863s c2863s) {
        super(context);
        this.f9726b = c2863s;
        setOnClickListener(this);
        this.f9725a = new ImageButton(context);
        this.f9725a.setImageResource(17301527);
        this.f9725a.setBackgroundColor(0);
        this.f9725a.setOnClickListener(this);
        this.f9725a.setPadding(0, 0, 0, 0);
        this.f9725a.setContentDescription("Interstitial close button");
        int a = C2784w.m10741a().m11560a(context, i);
        addView(this.f9725a, new LayoutParams(a, a, 17));
    }

    public void m11171a(boolean z, boolean z2) {
        if (!z2) {
            this.f9725a.setVisibility(0);
        } else if (z) {
            this.f9725a.setVisibility(4);
        } else {
            this.f9725a.setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (this.f9726b != null) {
            this.f9726b.m11095c();
        }
    }
}
