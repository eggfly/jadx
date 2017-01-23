package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.handmark.pulltorefresh.library.C3628R;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.client.j */
public class C2768j implements Creator<SearchAdRequestParcel> {
    static void m10695a(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, searchAdRequestParcel.f9336a);
        C3508b.m14557a(parcel, 2, searchAdRequestParcel.f9337b);
        C3508b.m14557a(parcel, 3, searchAdRequestParcel.f9338c);
        C3508b.m14557a(parcel, 4, searchAdRequestParcel.f9339d);
        C3508b.m14557a(parcel, 5, searchAdRequestParcel.f9340e);
        C3508b.m14557a(parcel, 6, searchAdRequestParcel.f9341f);
        C3508b.m14557a(parcel, 7, searchAdRequestParcel.f9342g);
        C3508b.m14557a(parcel, 8, searchAdRequestParcel.f9343h);
        C3508b.m14557a(parcel, 9, searchAdRequestParcel.f9344i);
        C3508b.m14565a(parcel, 10, searchAdRequestParcel.f9345j, false);
        C3508b.m14557a(parcel, 11, searchAdRequestParcel.f9346k);
        C3508b.m14565a(parcel, 12, searchAdRequestParcel.f9347l, false);
        C3508b.m14557a(parcel, 13, searchAdRequestParcel.f9348m);
        C3508b.m14557a(parcel, 14, searchAdRequestParcel.f9349n);
        C3508b.m14565a(parcel, 15, searchAdRequestParcel.f9350o, false);
        C3508b.m14555a(parcel, a);
    }

    public SearchAdRequestParcel m10696a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    i4 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    i5 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    i6 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    i7 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    i8 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    i9 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    i10 = C3507a.m14531d(parcel, a);
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    i11 = C3507a.m14531d(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    i12 = C3507a.m14531d(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public SearchAdRequestParcel[] m10697a(int i) {
        return new SearchAdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10696a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10697a(i);
    }
}
