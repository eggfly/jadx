package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.handmark.pulltorefresh.library.C3628R;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.client.p */
public class C2778p implements Creator<AdRequestParcel> {
    static void m10723a(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, adRequestParcel.f9307a);
        C3508b.m14558a(parcel, 2, adRequestParcel.f9308b);
        C3508b.m14559a(parcel, 3, adRequestParcel.f9309c, false);
        C3508b.m14557a(parcel, 4, adRequestParcel.f9310d);
        C3508b.m14566a(parcel, 5, adRequestParcel.f9311e, false);
        C3508b.m14567a(parcel, 6, adRequestParcel.f9312f);
        C3508b.m14557a(parcel, 7, adRequestParcel.f9313g);
        C3508b.m14567a(parcel, 8, adRequestParcel.f9314h);
        C3508b.m14565a(parcel, 9, adRequestParcel.f9315i, false);
        C3508b.m14562a(parcel, 10, adRequestParcel.f9316j, i, false);
        C3508b.m14562a(parcel, 11, adRequestParcel.f9317k, i, false);
        C3508b.m14565a(parcel, 12, adRequestParcel.f9318l, false);
        C3508b.m14559a(parcel, 13, adRequestParcel.f9319m, false);
        C3508b.m14559a(parcel, 14, adRequestParcel.f9320n, false);
        C3508b.m14566a(parcel, 15, adRequestParcel.f9321o, false);
        C3508b.m14565a(parcel, 17, adRequestParcel.f9323q, false);
        C3508b.m14565a(parcel, 16, adRequestParcel.f9322p, false);
        C3508b.m14567a(parcel, 18, adRequestParcel.f9324r);
        C3508b.m14555a(parcel, a);
    }

    public AdRequestParcel m10724a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    j = C3507a.m14533f(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    bundle = C3507a.m14541n(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    list = C3507a.m14551x(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    searchAdRequestParcel = (SearchAdRequestParcel) C3507a.m14523a(parcel, a, SearchAdRequestParcel.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    location = (Location) C3507a.m14523a(parcel, a, Location.CREATOR);
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    bundle2 = C3507a.m14541n(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    bundle3 = C3507a.m14541n(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    list2 = C3507a.m14551x(parcel, a);
                    break;
                case SpdyProtocol.CUSTOM /*16*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                    z3 = C3507a.m14530c(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AdRequestParcel[] m10725a(int i) {
        return new AdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10724a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10725a(i);
    }
}
