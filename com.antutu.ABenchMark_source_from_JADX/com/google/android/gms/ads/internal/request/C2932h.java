package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.facebook.ads.C2279R;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.handmark.pulltorefresh.library.C3628R;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.request.h */
public class C2932h implements Creator<AdResponseParcel> {
    static void m11411a(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, adResponseParcel.f9885a);
        C3508b.m14565a(parcel, 2, adResponseParcel.f9886b, false);
        C3508b.m14565a(parcel, 3, adResponseParcel.f9887c, false);
        C3508b.m14566a(parcel, 4, adResponseParcel.f9888d, false);
        C3508b.m14557a(parcel, 5, adResponseParcel.f9889e);
        C3508b.m14566a(parcel, 6, adResponseParcel.f9890f, false);
        C3508b.m14558a(parcel, 7, adResponseParcel.f9891g);
        C3508b.m14567a(parcel, 8, adResponseParcel.f9892h);
        C3508b.m14558a(parcel, 9, adResponseParcel.f9893i);
        C3508b.m14566a(parcel, 10, adResponseParcel.f9894j, false);
        C3508b.m14558a(parcel, 11, adResponseParcel.f9895k);
        C3508b.m14557a(parcel, 12, adResponseParcel.f9896l);
        C3508b.m14565a(parcel, 13, adResponseParcel.f9897m, false);
        C3508b.m14558a(parcel, 14, adResponseParcel.f9898n);
        C3508b.m14565a(parcel, 15, adResponseParcel.f9899o, false);
        C3508b.m14565a(parcel, 19, adResponseParcel.f9901q, false);
        C3508b.m14567a(parcel, 18, adResponseParcel.f9900p);
        C3508b.m14565a(parcel, 21, adResponseParcel.f9902r, false);
        C3508b.m14567a(parcel, 23, adResponseParcel.f9904t);
        C3508b.m14567a(parcel, 22, adResponseParcel.f9903s);
        C3508b.m14567a(parcel, 25, adResponseParcel.f9906v);
        C3508b.m14567a(parcel, 24, adResponseParcel.f9905u);
        C3508b.m14557a(parcel, 27, adResponseParcel.f9908x);
        C3508b.m14567a(parcel, 26, adResponseParcel.f9907w);
        C3508b.m14565a(parcel, 29, adResponseParcel.f9910z, false);
        C3508b.m14562a(parcel, 28, adResponseParcel.f9909y, i, false);
        C3508b.m14567a(parcel, 31, adResponseParcel.f9878B);
        C3508b.m14565a(parcel, 30, adResponseParcel.f9877A, false);
        C3508b.m14566a(parcel, 34, adResponseParcel.f9881E, false);
        C3508b.m14566a(parcel, 35, adResponseParcel.f9882F, false);
        C3508b.m14567a(parcel, 32, adResponseParcel.f9879C);
        C3508b.m14562a(parcel, 33, adResponseParcel.f9880D, i, false);
        C3508b.m14567a(parcel, 36, adResponseParcel.f9883G);
        C3508b.m14555a(parcel, a);
    }

    public AdResponseParcel m11412a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
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
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    list = C3507a.m14551x(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    list2 = C3507a.m14551x(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    j = C3507a.m14533f(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    j2 = C3507a.m14533f(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    list3 = C3507a.m14551x(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    j3 = C3507a.m14533f(parcel, a);
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    j4 = C3507a.m14533f(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                    str5 = C3507a.m14539l(parcel, a);
                    break;
                case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                    str6 = C3507a.m14539l(parcel, a);
                    break;
                case C4209a.f14215r /*22*/:
                    z3 = C3507a.m14530c(parcel, a);
                    break;
                case C2279R.styleable.Toolbar_titleTextColor /*23*/:
                    z4 = C3507a.m14530c(parcel, a);
                    break;
                case C4209a.f14216s /*24*/:
                    z5 = C3507a.m14530c(parcel, a);
                    break;
                case C2279R.styleable.ActionBar_popupTheme /*25*/:
                    z6 = C3507a.m14530c(parcel, a);
                    break;
                case C2279R.styleable.ActionBar_homeAsUpIndicator /*26*/:
                    z7 = C3507a.m14530c(parcel, a);
                    break;
                case C1692R.styleable.AppCompatTheme_actionModeStyle /*27*/:
                    i4 = C3507a.m14531d(parcel, a);
                    break;
                case C1692R.styleable.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    largeParcelTeleporter = (LargeParcelTeleporter) C3507a.m14523a(parcel, a, LargeParcelTeleporter.CREATOR);
                    break;
                case C1692R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    str7 = C3507a.m14539l(parcel, a);
                    break;
                case jni.SID_RAM /*30*/:
                    str8 = C3507a.m14539l(parcel, a);
                    break;
                case jni.SID_CPU_MATH /*31*/:
                    z8 = C3507a.m14530c(parcel, a);
                    break;
                case C4574a.ORDERED /*32*/:
                    z9 = C3507a.m14530c(parcel, a);
                    break;
                case jni.SID_CPU_MULTI /*33*/:
                    rewardItemParcel = (RewardItemParcel) C3507a.m14523a(parcel, a, RewardItemParcel.CREATOR);
                    break;
                case jni.SID_UX_SEC /*34*/:
                    list4 = C3507a.m14551x(parcel, a);
                    break;
                case jni.SID_UX_DATA /*35*/:
                    list5 = C3507a.m14551x(parcel, a);
                    break;
                case jni.SID_UX_GAME /*36*/:
                    z10 = C3507a.m14530c(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdResponseParcel(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i4, largeParcelTeleporter, str7, str8, z8, z9, rewardItemParcel, list4, list5, z10);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AdResponseParcel[] m11413a(int i) {
        return new AdResponseParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11412a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11413a(i);
    }
}
