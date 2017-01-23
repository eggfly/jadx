package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.internal.eh;

@eh
public class l extends FrameLayout implements OnClickListener {
    private final p DW;
    private final ImageButton j6;

    public l(Context context, int i, p pVar) {
        super(context);
        this.DW = pVar;
        setOnClickListener(this);
        this.j6 = new ImageButton(context);
        this.j6.setImageResource(17301527);
        this.j6.setBackgroundColor(0);
        this.j6.setOnClickListener(this);
        this.j6.setPadding(0, 0, 0, 0);
        this.j6.setContentDescription("Interstitial close button");
        int j6 = w.j6().j6(context, i);
        addView(this.j6, new LayoutParams(j6, j6, 17));
    }

    public void j6(boolean z, boolean z2) {
        if (!z2) {
            this.j6.setVisibility(0);
        } else if (z) {
            this.j6.setVisibility(4);
        } else {
            this.j6.setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (this.DW != null) {
            this.DW.FH();
        }
    }
}
