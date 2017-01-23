package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import anet.channel.util.HttpConstant;
import com.facebook.ads.C2279R;
import com.google.android.gms.common.internal.C3511t;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.handmark.pulltorefresh.library.C3628R;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.viewpagerindicator.C4273R;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public final class ConnectionResult implements SafeParcelable {
    public static final Creator<ConnectionResult> CREATOR;
    public static final ConnectionResult f11813a;
    final int f11814b;
    private final int f11815c;
    private final PendingIntent f11816d;
    private final String f11817e;

    static {
        f11813a = new ConnectionResult(0);
        CREATOR = new C3456e();
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f11814b = i;
        this.f11815c = i2;
        this.f11816d = pendingIntent;
        this.f11817e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String m13949a(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return HttpConstant.SUCCESS;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return "SERVICE_MISSING";
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return "SERVICE_DISABLED";
            case SpdyProtocol.QUIC /*4*/:
                return "SIGN_IN_REQUIRED";
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return "INVALID_ACCOUNT";
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return "RESOLUTION_REQUIRED";
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                return "NETWORK_ERROR";
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return "INTERNAL_ERROR";
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return "SERVICE_INVALID";
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return "DEVELOPER_ERROR";
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return "LICENSE_CHECK_FAILED";
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                return "CANCELED";
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                return "TIMEOUT";
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return "INTERRUPTED";
            case SpdyProtocol.CUSTOM /*16*/:
                return "API_UNAVAILABLE";
            case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                return "SIGN_IN_FAILED";
            case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                return "SERVICE_UPDATING";
            case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                return "SERVICE_MISSING_PERMISSION";
            case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                return "RESTRICTED_PROFILE";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + C4233j.f14397t;
        }
    }

    public void m13950a(Activity activity, int i) {
        if (m13951a()) {
            activity.startIntentSenderForResult(this.f11816d.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public boolean m13951a() {
        return (this.f11815c == 0 || this.f11816d == null) ? false : true;
    }

    public boolean m13952b() {
        return this.f11815c == 0;
    }

    public int m13953c() {
        return this.f11815c;
    }

    public PendingIntent m13954d() {
        return this.f11816d;
    }

    public int describeContents() {
        return 0;
    }

    public String m13955e() {
        return this.f11817e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f11815c == connectionResult.f11815c && C3511t.m14579a(this.f11816d, connectionResult.f11816d) && C3511t.m14579a(this.f11817e, connectionResult.f11817e);
    }

    public int hashCode() {
        return C3511t.m14577a(Integer.valueOf(this.f11815c), this.f11816d, this.f11817e);
    }

    public String toString() {
        return C3511t.m14578a((Object) this).m14576a("statusCode", m13949a(this.f11815c)).m14576a("resolution", this.f11816d).m14576a(C4233j.f14376C, this.f11817e).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3456e.m14266a(this, parcel, i);
    }
}
