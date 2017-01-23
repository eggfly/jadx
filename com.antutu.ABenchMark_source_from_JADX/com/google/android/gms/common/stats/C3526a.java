package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.stats.a */
public class C3526a implements Creator<ConnectionEvent> {
    static void m14715a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, connectionEvent.f12159a);
        C3508b.m14558a(parcel, 2, connectionEvent.m14689a());
        C3508b.m14565a(parcel, 4, connectionEvent.m14691c(), false);
        C3508b.m14565a(parcel, 5, connectionEvent.m14692d(), false);
        C3508b.m14565a(parcel, 6, connectionEvent.m14693e(), false);
        C3508b.m14565a(parcel, 7, connectionEvent.m14694f(), false);
        C3508b.m14565a(parcel, 8, connectionEvent.m14695g(), false);
        C3508b.m14558a(parcel, 10, connectionEvent.m14699k());
        C3508b.m14558a(parcel, 11, connectionEvent.m14698j());
        C3508b.m14557a(parcel, 12, connectionEvent.m14690b());
        C3508b.m14565a(parcel, 13, connectionEvent.m14696h(), false);
        C3508b.m14555a(parcel, a);
    }

    public ConnectionEvent m14716a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    j = C3507a.m14533f(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    str5 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    j2 = C3507a.m14533f(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    j3 = C3507a.m14533f(parcel, a);
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    str6 = C3507a.m14539l(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public ConnectionEvent[] m14717a(int i) {
        return new ConnectionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14716a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14717a(i);
    }
}
