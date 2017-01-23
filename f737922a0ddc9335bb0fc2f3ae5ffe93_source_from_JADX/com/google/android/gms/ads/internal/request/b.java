package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

public class b implements Creator<AdRequestInfoParcel> {
    static void j6(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, adRequestInfoParcel.j6);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 2, adRequestInfoParcel.DW, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 3, adRequestInfoParcel.FH, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 4, adRequestInfoParcel.Hw, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 5, adRequestInfoParcel.v5, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 6, adRequestInfoParcel.Zo, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 7, adRequestInfoParcel.VH, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 8, adRequestInfoParcel.gn, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 9, adRequestInfoParcel.u7, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 10, adRequestInfoParcel.tp, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 11, adRequestInfoParcel.EQ, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 12, adRequestInfoParcel.we, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 13, adRequestInfoParcel.J0);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 14, adRequestInfoParcel.J8, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 15, adRequestInfoParcel.Ws, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 16, adRequestInfoParcel.QX);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 17, adRequestInfoParcel.XL, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 18, adRequestInfoParcel.aM);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 19, adRequestInfoParcel.j3);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 20, adRequestInfoParcel.Mr);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 21, adRequestInfoParcel.U2, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 25, adRequestInfoParcel.a8);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 26, adRequestInfoParcel.lg, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 27, adRequestInfoParcel.rN, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 28, adRequestInfoParcel.er, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 29, adRequestInfoParcel.yS, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 30, adRequestInfoParcel.gW, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 31, adRequestInfoParcel.BT);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 32, adRequestInfoParcel.vy, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 33, adRequestInfoParcel.P8, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 34, adRequestInfoParcel.ei);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 35, adRequestInfoParcel.nw);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 36, adRequestInfoParcel.SI);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 37, adRequestInfoParcel.KD);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 38, adRequestInfoParcel.ro);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 39, adRequestInfoParcel.cn, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 40, adRequestInfoParcel.sh);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 41, adRequestInfoParcel.cb, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 42, adRequestInfoParcel.dx);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 43, adRequestInfoParcel.sG);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 44, adRequestInfoParcel.ef, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public AdRequestInfoParcel j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        Bundle bundle = null;
        AdRequestParcel adRequestParcel = null;
        AdSizeParcel adSizeParcel = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list2 = null;
        String str7 = null;
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        List list3 = null;
        long j2 = 0;
        CapabilityParcel capabilityParcel = null;
        String str8 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        int i7 = 0;
        Bundle bundle4 = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    bundle = a.QX(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    adRequestParcel = (AdRequestParcel) a.j6(parcel, j6, AdRequestParcel.CREATOR);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    adSizeParcel = (AdSizeParcel) a.j6(parcel, j6, AdSizeParcel.CREATOR);
                    break;
                case 5:
                    str = a.J8(parcel, j6);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) a.j6(parcel, j6, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) a.j6(parcel, j6, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = a.J8(parcel, j6);
                    break;
                case 9:
                    str3 = a.J8(parcel, j6);
                    break;
                case 10:
                    str4 = a.J8(parcel, j6);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) a.j6(parcel, j6, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundle2 = a.QX(parcel, j6);
                    break;
                case 13:
                    i2 = a.Hw(parcel, j6);
                    break;
                case 14:
                    list = a.yS(parcel, j6);
                    break;
                case 15:
                    bundle3 = a.QX(parcel, j6);
                    break;
                case 16:
                    z = a.FH(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    messenger = (Messenger) a.j6(parcel, j6, Messenger.CREATOR);
                    break;
                case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                    i3 = a.Hw(parcel, j6);
                    break;
                case 19:
                    i4 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    f = a.u7(parcel, j6);
                    break;
                case 21:
                    str5 = a.J8(parcel, j6);
                    break;
                case 25:
                    j = a.Zo(parcel, j6);
                    break;
                case 26:
                    str6 = a.J8(parcel, j6);
                    break;
                case 27:
                    list2 = a.yS(parcel, j6);
                    break;
                case 28:
                    str7 = a.J8(parcel, j6);
                    break;
                case 29:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) a.j6(parcel, j6, NativeAdOptionsParcel.CREATOR);
                    break;
                case 30:
                    list3 = a.yS(parcel, j6);
                    break;
                case 31:
                    j2 = a.Zo(parcel, j6);
                    break;
                case 32:
                    capabilityParcel = (CapabilityParcel) a.j6(parcel, j6, CapabilityParcel.CREATOR);
                    break;
                case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                    str8 = a.J8(parcel, j6);
                    break;
                case 34:
                    f2 = a.u7(parcel, j6);
                    break;
                case 35:
                    i5 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_time /*36*/:
                    i6 = a.Hw(parcel, j6);
                    break;
                case 37:
                    z3 = a.FH(parcel, j6);
                    break;
                case 38:
                    z4 = a.FH(parcel, j6);
                    break;
                case 39:
                    str9 = a.J8(parcel, j6);
                    break;
                case 40:
                    z2 = a.FH(parcel, j6);
                    break;
                case 41:
                    str10 = a.J8(parcel, j6);
                    break;
                case 42:
                    z5 = a.FH(parcel, j6);
                    break;
                case 43:
                    i7 = a.Hw(parcel, j6);
                    break;
                case 44:
                    bundle4 = a.QX(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new AdRequestInfoParcel(i, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i2, list, bundle3, z, messenger, i3, i4, f, str5, j, str6, list2, str7, nativeAdOptionsParcel, list3, j2, capabilityParcel, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public AdRequestInfoParcel[] j6(int i) {
        return new AdRequestInfoParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
