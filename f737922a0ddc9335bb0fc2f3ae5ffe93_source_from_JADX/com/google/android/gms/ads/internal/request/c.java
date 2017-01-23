package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class c implements Creator<AdResponseParcel> {
    static void j6(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, adResponseParcel.j6);
        b.j6(parcel, 2, adResponseParcel.DW, false);
        b.j6(parcel, 3, adResponseParcel.FH, false);
        b.j6(parcel, 4, adResponseParcel.Hw, false);
        b.j6(parcel, 5, adResponseParcel.v5);
        b.j6(parcel, 6, adResponseParcel.Zo, false);
        b.j6(parcel, 7, adResponseParcel.VH);
        b.j6(parcel, 8, adResponseParcel.gn);
        b.j6(parcel, 9, adResponseParcel.u7);
        b.j6(parcel, 10, adResponseParcel.tp, false);
        b.j6(parcel, 11, adResponseParcel.EQ);
        b.j6(parcel, 12, adResponseParcel.we);
        b.j6(parcel, 13, adResponseParcel.J0, false);
        b.j6(parcel, 14, adResponseParcel.J8);
        b.j6(parcel, 15, adResponseParcel.Ws, false);
        b.j6(parcel, 18, adResponseParcel.QX);
        b.j6(parcel, 19, adResponseParcel.XL, false);
        b.j6(parcel, 21, adResponseParcel.aM, false);
        b.j6(parcel, 22, adResponseParcel.j3);
        b.j6(parcel, 23, adResponseParcel.Mr);
        b.j6(parcel, 24, adResponseParcel.U2);
        b.j6(parcel, 25, adResponseParcel.a8);
        b.j6(parcel, 26, adResponseParcel.lg);
        b.j6(parcel, 27, adResponseParcel.rN);
        b.j6(parcel, 28, adResponseParcel.er, i, false);
        b.j6(parcel, 29, adResponseParcel.yS, false);
        b.j6(parcel, 30, adResponseParcel.gW, false);
        b.j6(parcel, 31, adResponseParcel.BT);
        b.j6(parcel, 32, adResponseParcel.vy);
        b.j6(parcel, 33, adResponseParcel.P8, i, false);
        b.j6(parcel, 34, adResponseParcel.ei, false);
        b.j6(parcel, 35, adResponseParcel.nw, false);
        b.j6(parcel, 36, adResponseParcel.SI);
        b.j6(parcel, 37, adResponseParcel.KD, i, false);
        b.j6(parcel, 38, adResponseParcel.ro);
        b.j6(parcel, 39, adResponseParcel.cn, false);
        b.j6(parcel, 40, adResponseParcel.sh, false);
        b.j6(parcel, 41, adResponseParcel.cb, false);
        b.j6(parcel, 42, adResponseParcel.dx);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public AdResponseParcel j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i4 = 0;
        LargeParcelTeleporter largeParcelTeleporter = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        boolean z9 = false;
        RewardItemParcel rewardItemParcel = null;
        List list4 = null;
        List list5 = null;
        boolean z10 = false;
        AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel = null;
        boolean z11 = false;
        String str9 = null;
        List list6 = null;
        String str10 = null;
        boolean z12 = false;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str = a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    str2 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    list = a.yS(parcel, j6);
                    break;
                case 5:
                    i2 = a.Hw(parcel, j6);
                    break;
                case 6:
                    list2 = a.yS(parcel, j6);
                    break;
                case 7:
                    j = a.Zo(parcel, j6);
                    break;
                case 8:
                    z = a.FH(parcel, j6);
                    break;
                case 9:
                    j2 = a.Zo(parcel, j6);
                    break;
                case 10:
                    list3 = a.yS(parcel, j6);
                    break;
                case 11:
                    j3 = a.Zo(parcel, j6);
                    break;
                case 12:
                    i3 = a.Hw(parcel, j6);
                    break;
                case 13:
                    str3 = a.J8(parcel, j6);
                    break;
                case 14:
                    j4 = a.Zo(parcel, j6);
                    break;
                case 15:
                    str4 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                    z2 = a.FH(parcel, j6);
                    break;
                case 19:
                    str5 = a.J8(parcel, j6);
                    break;
                case 21:
                    str6 = a.J8(parcel, j6);
                    break;
                case 22:
                    z3 = a.FH(parcel, j6);
                    break;
                case 23:
                    z4 = a.FH(parcel, j6);
                    break;
                case 24:
                    z5 = a.FH(parcel, j6);
                    break;
                case 25:
                    z6 = a.FH(parcel, j6);
                    break;
                case 26:
                    z7 = a.FH(parcel, j6);
                    break;
                case 27:
                    i4 = a.Hw(parcel, j6);
                    break;
                case 28:
                    largeParcelTeleporter = (LargeParcelTeleporter) a.j6(parcel, j6, LargeParcelTeleporter.CREATOR);
                    break;
                case 29:
                    str7 = a.J8(parcel, j6);
                    break;
                case 30:
                    str8 = a.J8(parcel, j6);
                    break;
                case 31:
                    z8 = a.FH(parcel, j6);
                    break;
                case 32:
                    z9 = a.FH(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                    rewardItemParcel = (RewardItemParcel) a.j6(parcel, j6, RewardItemParcel.CREATOR);
                    break;
                case 34:
                    list4 = a.yS(parcel, j6);
                    break;
                case 35:
                    list5 = a.yS(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_time /*36*/:
                    z10 = a.FH(parcel, j6);
                    break;
                case 37:
                    autoClickProtectionConfigurationParcel = (AutoClickProtectionConfigurationParcel) a.j6(parcel, j6, AutoClickProtectionConfigurationParcel.CREATOR);
                    break;
                case 38:
                    z11 = a.FH(parcel, j6);
                    break;
                case 39:
                    str9 = a.J8(parcel, j6);
                    break;
                case 40:
                    list6 = a.yS(parcel, j6);
                    break;
                case 41:
                    str10 = a.J8(parcel, j6);
                    break;
                case 42:
                    z12 = a.FH(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new AdResponseParcel(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i4, largeParcelTeleporter, str7, str8, z8, z9, rewardItemParcel, list4, list5, z10, autoClickProtectionConfigurationParcel, z11, str9, list6, str10, z12);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public AdResponseParcel[] j6(int i) {
        return new AdResponseParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
