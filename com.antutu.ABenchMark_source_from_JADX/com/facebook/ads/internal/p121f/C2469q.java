package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.facebook.ads.internal.f.q */
public class C2469q extends View {
    private C2264p f8496a;

    public C2469q(Context context, C2264p c2264p) {
        super(context);
        this.f8496a = c2264p;
        setLayoutParams(new LayoutParams(0, 0));
    }

    public void onWindowVisibilityChanged(int i) {
        if (this.f8496a != null) {
            this.f8496a.m8570a(i);
        }
    }
}
