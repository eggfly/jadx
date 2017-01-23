package com.google.android.gms.p146b;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.p124b.C2701a.C2700a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;

@gb
/* renamed from: com.google.android.gms.b.bg */
public class bg extends C2700a {
    private final bf f10360a;
    private final Drawable f10361b;
    private final Uri f10362c;
    private final double f10363d;

    public bg(bf bfVar) {
        Drawable drawable;
        double d;
        Uri uri = null;
        this.f10360a = bfVar;
        try {
            C2687a a = this.f10360a.m10785a();
            if (a != null) {
                drawable = (Drawable) C2690b.m10263a(a);
                this.f10361b = drawable;
                uri = this.f10360a.m10786b();
                this.f10362c = uri;
                d = 1.0d;
                d = this.f10360a.m10787c();
                this.f10363d = d;
            }
        } catch (Throwable e) {
            C2972b.m11580b("Failed to get drawable.", e);
        }
        Object obj = uri;
        this.f10361b = drawable;
        try {
            uri = this.f10360a.m10786b();
        } catch (Throwable e2) {
            C2972b.m11580b("Failed to get uri.", e2);
        }
        this.f10362c = uri;
        d = 1.0d;
        try {
            d = this.f10360a.m10787c();
        } catch (Throwable e3) {
            C2972b.m11580b("Failed to get scale.", e3);
        }
        this.f10363d = d;
    }

    public Drawable m11884a() {
        return this.f10361b;
    }

    public Uri m11885b() {
        return this.f10362c;
    }

    public double m11886c() {
        return this.f10363d;
    }
}
