package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.facebook.ads.C2279R;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.handmark.pulltorefresh.library.C3628R;
import com.umeng.message.MsgConstant;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.request.f */
public class C2928f implements Creator<AdRequestInfoParcel> {
    static void m11405a(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, adRequestInfoParcel.f9851a);
        C3508b.m14559a(parcel, 2, adRequestInfoParcel.f9852b, false);
        C3508b.m14562a(parcel, 3, adRequestInfoParcel.f9853c, i, false);
        C3508b.m14562a(parcel, 4, adRequestInfoParcel.f9854d, i, false);
        C3508b.m14565a(parcel, 5, adRequestInfoParcel.f9855e, false);
        C3508b.m14562a(parcel, 6, adRequestInfoParcel.f9856f, i, false);
        C3508b.m14562a(parcel, 7, adRequestInfoParcel.f9857g, i, false);
        C3508b.m14565a(parcel, 8, adRequestInfoParcel.f9858h, false);
        C3508b.m14565a(parcel, 9, adRequestInfoParcel.f9859i, false);
        C3508b.m14565a(parcel, 10, adRequestInfoParcel.f9860j, false);
        C3508b.m14562a(parcel, 11, adRequestInfoParcel.f9861k, i, false);
        C3508b.m14559a(parcel, 12, adRequestInfoParcel.f9862l, false);
        C3508b.m14557a(parcel, 13, adRequestInfoParcel.f9863m);
        C3508b.m14566a(parcel, 14, adRequestInfoParcel.f9864n, false);
        C3508b.m14559a(parcel, 15, adRequestInfoParcel.f9865o, false);
        C3508b.m14562a(parcel, 17, adRequestInfoParcel.f9867q, i, false);
        C3508b.m14567a(parcel, 16, adRequestInfoParcel.f9866p);
        C3508b.m14557a(parcel, 19, adRequestInfoParcel.f9869s);
        C3508b.m14557a(parcel, 18, adRequestInfoParcel.f9868r);
        C3508b.m14565a(parcel, 21, adRequestInfoParcel.f9871u, false);
        C3508b.m14556a(parcel, 20, adRequestInfoParcel.f9870t);
        C3508b.m14558a(parcel, 25, adRequestInfoParcel.f9872v);
        C3508b.m14566a(parcel, 27, adRequestInfoParcel.f9874x, false);
        C3508b.m14565a(parcel, 26, adRequestInfoParcel.f9873w, false);
        C3508b.m14562a(parcel, 29, adRequestInfoParcel.f9876z, i, false);
        C3508b.m14565a(parcel, 28, adRequestInfoParcel.f9875y, false);
        C3508b.m14558a(parcel, 31, adRequestInfoParcel.f9845B);
        C3508b.m14566a(parcel, 30, adRequestInfoParcel.f9844A, false);
        C3508b.m14556a(parcel, 34, adRequestInfoParcel.f9848E);
        C3508b.m14557a(parcel, 35, adRequestInfoParcel.f9849F);
        C3508b.m14562a(parcel, 32, adRequestInfoParcel.f9846C, i, false);
        C3508b.m14565a(parcel, 33, adRequestInfoParcel.f9847D, false);
        C3508b.m14557a(parcel, 36, adRequestInfoParcel.f9850G);
        C3508b.m14555a(parcel, a);
    }

    public AdRequestInfoParcel m11406a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
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
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    bundle = C3507a.m14541n(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    adRequestParcel = (AdRequestParcel) C3507a.m14523a(parcel, a, AdRequestParcel.CREATOR);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    adSizeParcel = (AdSizeParcel) C3507a.m14523a(parcel, a, AdSizeParcel.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    applicationInfo = (ApplicationInfo) C3507a.m14523a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    packageInfo = (PackageInfo) C3507a.m14523a(parcel, a, PackageInfo.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    versionInfoParcel = (VersionInfoParcel) C3507a.m14523a(parcel, a, VersionInfoParcel.CREATOR);
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    bundle2 = C3507a.m14541n(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    list = C3507a.m14551x(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    bundle3 = C3507a.m14541n(parcel, a);
                    break;
                case SpdyProtocol.CUSTOM /*16*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                    messenger = (Messenger) C3507a.m14523a(parcel, a, Messenger.CREATOR);
                    break;
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                    i4 = C3507a.m14531d(parcel, a);
                    break;
                case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                    f = C3507a.m14536i(parcel, a);
                    break;
                case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                    str5 = C3507a.m14539l(parcel, a);
                    break;
                case C2279R.styleable.ActionBar_popupTheme /*25*/:
                    j = C3507a.m14533f(parcel, a);
                    break;
                case C2279R.styleable.ActionBar_homeAsUpIndicator /*26*/:
                    str6 = C3507a.m14539l(parcel, a);
                    break;
                case C1692R.styleable.AppCompatTheme_actionModeStyle /*27*/:
                    list2 = C3507a.m14551x(parcel, a);
                    break;
                case C1692R.styleable.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    str7 = C3507a.m14539l(parcel, a);
                    break;
                case C1692R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) C3507a.m14523a(parcel, a, NativeAdOptionsParcel.CREATOR);
                    break;
                case jni.SID_RAM /*30*/:
                    list3 = C3507a.m14551x(parcel, a);
                    break;
                case jni.SID_CPU_MATH /*31*/:
                    j2 = C3507a.m14533f(parcel, a);
                    break;
                case C4574a.ORDERED /*32*/:
                    capabilityParcel = (CapabilityParcel) C3507a.m14523a(parcel, a, CapabilityParcel.CREATOR);
                    break;
                case jni.SID_CPU_MULTI /*33*/:
                    str8 = C3507a.m14539l(parcel, a);
                    break;
                case jni.SID_UX_SEC /*34*/:
                    f2 = C3507a.m14536i(parcel, a);
                    break;
                case jni.SID_UX_DATA /*35*/:
                    i5 = C3507a.m14531d(parcel, a);
                    break;
                case jni.SID_UX_GAME /*36*/:
                    i6 = C3507a.m14531d(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdRequestInfoParcel(i, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i2, list, bundle3, z, messenger, i3, i4, f, str5, j, str6, list2, str7, nativeAdOptionsParcel, list3, j2, capabilityParcel, str8, f2, i5, i6);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AdRequestInfoParcel[] m11407a(int i) {
        return new AdRequestInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11406a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11407a(i);
    }
}
