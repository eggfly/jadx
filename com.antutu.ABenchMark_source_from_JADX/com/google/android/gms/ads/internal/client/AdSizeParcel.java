package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.C2719d;
import com.google.android.gms.ads.C2726i;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.p146b.gb;
import com.qq.p035e.comm.constants.ErrorCode.NetWorkError;

@gb
public class AdSizeParcel implements SafeParcelable {
    public static final C2780r CREATOR;
    public final int f9325a;
    public final String f9326b;
    public final int f9327c;
    public final int f9328d;
    public final boolean f9329e;
    public final int f9330f;
    public final int f9331g;
    public final AdSizeParcel[] f9332h;
    public final boolean f9333i;
    public final boolean f9334j;
    public boolean f9335k;

    static {
        CREATOR = new C2780r();
    }

    public AdSizeParcel() {
        this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2, boolean z3, boolean z4) {
        this.f9325a = i;
        this.f9326b = str;
        this.f9327c = i2;
        this.f9328d = i3;
        this.f9329e = z;
        this.f9330f = i4;
        this.f9331g = i5;
        this.f9332h = adSizeParcelArr;
        this.f9333i = z2;
        this.f9334j = z3;
        this.f9335k = z4;
    }

    public AdSizeParcel(Context context, C2719d c2719d) {
        this(context, new C2719d[]{c2719d});
    }

    public AdSizeParcel(Context context, C2719d[] c2719dArr) {
        int i;
        int i2;
        C2719d c2719d = c2719dArr[0];
        this.f9325a = 5;
        this.f9329e = false;
        this.f9334j = c2719d.m10348c();
        if (this.f9334j) {
            this.f9330f = C2719d.f9257a.m10346b();
            this.f9327c = C2719d.f9257a.m10344a();
        } else {
            this.f9330f = c2719d.m10346b();
            this.f9327c = c2719d.m10344a();
        }
        boolean z = this.f9330f == -1;
        boolean z2 = this.f9327c == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (C2784w.m10741a().m11573c(context) && C2784w.m10741a().m11574d(context)) {
                this.f9331g = m10498a(displayMetrics) - C2784w.m10741a().m11575e(context);
            } else {
                this.f9331g = m10498a(displayMetrics);
            }
            double d = (double) (((float) this.f9331g) / displayMetrics.density);
            i = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i++;
            }
            i2 = i;
        } else {
            i = this.f9330f;
            this.f9331g = C2784w.m10741a().m11561a(displayMetrics, this.f9330f);
            i2 = i;
        }
        i = z2 ? m10502c(displayMetrics) : this.f9327c;
        this.f9328d = C2784w.m10741a().m11561a(displayMetrics, i);
        if (z || z2) {
            this.f9326b = i2 + "x" + i + "_as";
        } else if (this.f9334j) {
            this.f9326b = "320x50_mb";
        } else {
            this.f9326b = c2719d.toString();
        }
        if (c2719dArr.length > 1) {
            this.f9332h = new AdSizeParcel[c2719dArr.length];
            for (int i3 = 0; i3 < c2719dArr.length; i3++) {
                this.f9332h[i3] = new AdSizeParcel(context, c2719dArr[i3]);
            }
        } else {
            this.f9332h = null;
        }
        this.f9333i = false;
        this.f9335k = false;
    }

    public AdSizeParcel(AdSizeParcel adSizeParcel, AdSizeParcel[] adSizeParcelArr) {
        this(5, adSizeParcel.f9326b, adSizeParcel.f9327c, adSizeParcel.f9328d, adSizeParcel.f9329e, adSizeParcel.f9330f, adSizeParcel.f9331g, adSizeParcelArr, adSizeParcel.f9333i, adSizeParcel.f9334j, adSizeParcel.f9335k);
    }

    public static int m10498a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static AdSizeParcel m10499a() {
        return new AdSizeParcel(5, "reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public static AdSizeParcel m10500a(Context context) {
        return new AdSizeParcel(5, "320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static int m10501b(DisplayMetrics displayMetrics) {
        return (int) (((float) m10502c(displayMetrics)) * displayMetrics.density);
    }

    private static int m10502c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= NetWorkError.STUB_NETWORK_ERROR ? 32 : i <= 720 ? 50 : 90;
    }

    public void m10503a(boolean z) {
        this.f9335k = z;
    }

    public C2719d m10504b() {
        return C2726i.m10380a(this.f9330f, this.f9327c, this.f9326b);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2780r.m10728a(this, parcel, i);
    }
}
