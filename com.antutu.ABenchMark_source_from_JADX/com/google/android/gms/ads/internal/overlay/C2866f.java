package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.handmark.pulltorefresh.library.C3628R;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.overlay.f */
public class C2866f implements Creator<AdOverlayInfoParcel> {
    static void m11124a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, adOverlayInfoParcel.f9645a);
        C3508b.m14562a(parcel, 2, adOverlayInfoParcel.f9646b, i, false);
        C3508b.m14560a(parcel, 3, adOverlayInfoParcel.m11037a(), false);
        C3508b.m14560a(parcel, 4, adOverlayInfoParcel.m11038b(), false);
        C3508b.m14560a(parcel, 5, adOverlayInfoParcel.m11039c(), false);
        C3508b.m14560a(parcel, 6, adOverlayInfoParcel.m11040d(), false);
        C3508b.m14565a(parcel, 7, adOverlayInfoParcel.f9651g, false);
        C3508b.m14567a(parcel, 8, adOverlayInfoParcel.f9652h);
        C3508b.m14565a(parcel, 9, adOverlayInfoParcel.f9653i, false);
        C3508b.m14560a(parcel, 10, adOverlayInfoParcel.m11042f(), false);
        C3508b.m14557a(parcel, 11, adOverlayInfoParcel.f9655k);
        C3508b.m14557a(parcel, 12, adOverlayInfoParcel.f9656l);
        C3508b.m14565a(parcel, 13, adOverlayInfoParcel.f9657m, false);
        C3508b.m14562a(parcel, 14, adOverlayInfoParcel.f9658n, i, false);
        C3508b.m14560a(parcel, 15, adOverlayInfoParcel.m11041e(), false);
        C3508b.m14562a(parcel, 17, adOverlayInfoParcel.f9661q, i, false);
        C3508b.m14565a(parcel, 16, adOverlayInfoParcel.f9660p, false);
        C3508b.m14555a(parcel, a);
    }

    public AdOverlayInfoParcel m11125a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) C3507a.m14523a(parcel, a, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    iBinder = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    iBinder2 = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    iBinder3 = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    iBinder4 = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    iBinder5 = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    versionInfoParcel = (VersionInfoParcel) C3507a.m14523a(parcel, a, VersionInfoParcel.CREATOR);
                    break;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    iBinder6 = C3507a.m14540m(parcel, a);
                    break;
                case SpdyProtocol.CUSTOM /*16*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) C3507a.m14523a(parcel, a, InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AdOverlayInfoParcel[] m11126a(int i) {
        return new AdOverlayInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11125a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11126a(i);
    }
}
