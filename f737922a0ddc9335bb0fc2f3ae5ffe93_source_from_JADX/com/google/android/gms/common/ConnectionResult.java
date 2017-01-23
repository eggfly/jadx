package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final Creator<ConnectionResult> CREATOR;
    public static final ConnectionResult j6;
    final int DW;
    private final int FH;
    private final PendingIntent Hw;
    private final String v5;

    static {
        j6 = new ConnectionResult(0);
        CREATOR = new h();
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.DW = i;
        this.FH = i2;
        this.Hw = pendingIntent;
        this.v5 = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String j6(int i) {
        switch (i) {
            case -1:
                return "UNKNOWN";
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return "SUCCESS";
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return "SERVICE_MISSING";
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return "SERVICE_DISABLED";
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                return "SIGN_IN_FAILED";
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            case ProxyTextView.INPUTTYPE_date /*20*/:
                return "RESTRICTED_PROFILE";
            case 21:
                return "API_VERSION_UPDATE_REQUIRED";
            case 42:
                return "UPDATE_ANDROID_WEAR";
            case 99:
                return "UNFINISHED";
            case 1500:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public boolean DW() {
        return this.FH == 0;
    }

    public int FH() {
        return this.FH;
    }

    public PendingIntent Hw() {
        return this.Hw;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.FH == connectionResult.FH && ae.j6(this.Hw, connectionResult.Hw) && ae.j6(this.v5, connectionResult.v5);
    }

    public int hashCode() {
        return ae.j6(Integer.valueOf(this.FH), this.Hw, this.v5);
    }

    public boolean j6() {
        return (this.FH == 0 || this.Hw == null) ? false : true;
    }

    public String toString() {
        return ae.j6((Object) this).j6("statusCode", j6(this.FH)).j6("resolution", this.Hw).j6("message", this.v5).toString();
    }

    public String v5() {
        return this.v5;
    }

    public void writeToParcel(Parcel parcel, int i) {
        h.j6(this, parcel, i);
    }
}
