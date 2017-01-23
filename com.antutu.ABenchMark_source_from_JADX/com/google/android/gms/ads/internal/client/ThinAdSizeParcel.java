package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.google.android.gms.p146b.gb;

@gb
public class ThinAdSizeParcel extends AdSizeParcel {
    public ThinAdSizeParcel(AdSizeParcel adSizeParcel) {
        super(adSizeParcel.f9325a, adSizeParcel.f9326b, adSizeParcel.f9327c, adSizeParcel.f9328d, adSizeParcel.f9329e, adSizeParcel.f9330f, adSizeParcel.f9331g, adSizeParcel.f9332h, adSizeParcel.f9333i, adSizeParcel.f9334j, adSizeParcel.f9335k);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, this.a);
        C3508b.m14565a(parcel, 2, this.b, false);
        C3508b.m14557a(parcel, 3, this.c);
        C3508b.m14557a(parcel, 6, this.f);
        C3508b.m14555a(parcel, a);
    }
}
