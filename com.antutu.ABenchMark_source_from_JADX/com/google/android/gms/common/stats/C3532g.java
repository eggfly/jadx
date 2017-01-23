package com.google.android.gms.common.stats;

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

/* renamed from: com.google.android.gms.common.stats.g */
public class C3532g implements Creator<WakeLockEvent> {
    static void m14735a(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, wakeLockEvent.f12171a);
        C3508b.m14558a(parcel, 2, wakeLockEvent.m14701a());
        C3508b.m14565a(parcel, 4, wakeLockEvent.m14703c(), false);
        C3508b.m14557a(parcel, 5, wakeLockEvent.m14705e());
        C3508b.m14566a(parcel, 6, wakeLockEvent.m14706f(), false);
        C3508b.m14558a(parcel, 8, wakeLockEvent.m14708h());
        C3508b.m14565a(parcel, 10, wakeLockEvent.m14704d(), false);
        C3508b.m14557a(parcel, 11, wakeLockEvent.m14702b());
        C3508b.m14565a(parcel, 12, wakeLockEvent.m14707g(), false);
        C3508b.m14565a(parcel, 13, wakeLockEvent.m14711k(), false);
        C3508b.m14557a(parcel, 14, wakeLockEvent.m14710j());
        C3508b.m14556a(parcel, 15, wakeLockEvent.m14713m());
        C3508b.m14558a(parcel, 16, wakeLockEvent.m14714n());
        C3508b.m14555a(parcel, a);
    }

    public WakeLockEvent m14736a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
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
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    list = C3507a.m14551x(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    j2 = C3507a.m14533f(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    i4 = C3507a.m14531d(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    f = C3507a.m14536i(parcel, a);
                    break;
                case SpdyProtocol.CUSTOM /*16*/:
                    j3 = C3507a.m14533f(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public WakeLockEvent[] m14737a(int i) {
        return new WakeLockEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14736a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14737a(i);
    }
}
