import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.zzah;

public final class agk {
    private final String DW;
    private final String FH;
    private final String Hw;
    private final String Zo;
    private final String j6;
    private final String v5;

    private agk(String str, String str2, String str3, String str4, String str5, String str6) {
        b.j6(!agd.j6(str), (Object) "ApplicationId must be set.");
        this.DW = str;
        this.j6 = str2;
        this.FH = str3;
        this.Hw = str4;
        this.v5 = str5;
        this.Zo = str6;
    }

    public static agk j6(Context context) {
        zzah com_google_android_gms_common_internal_zzah = new zzah(context);
        Object j6 = com_google_android_gms_common_internal_zzah.j6("google_app_id");
        return TextUtils.isEmpty(j6) ? null : new agk(j6, com_google_android_gms_common_internal_zzah.j6("google_api_key"), com_google_android_gms_common_internal_zzah.j6("firebase_database_url"), com_google_android_gms_common_internal_zzah.j6("ga_trackingId"), com_google_android_gms_common_internal_zzah.j6("gcm_defaultSenderId"), com_google_android_gms_common_internal_zzah.j6("google_storage_bucket"));
    }

    public String DW() {
        return this.v5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof agk)) {
            return false;
        }
        agk agk = (agk) obj;
        return ae.j6(this.DW, agk.DW) && ae.j6(this.j6, agk.j6) && ae.j6(this.FH, agk.FH) && ae.j6(this.Hw, agk.Hw) && ae.j6(this.v5, agk.v5) && ae.j6(this.Zo, agk.Zo);
    }

    public int hashCode() {
        return ae.j6(this.DW, this.j6, this.FH, this.Hw, this.v5, this.Zo);
    }

    public String j6() {
        return this.DW;
    }

    public String toString() {
        return ae.j6((Object) this).j6("applicationId", this.DW).j6("apiKey", this.j6).j6("databaseUrl", this.FH).j6("gcmSenderId", this.v5).j6("storageBucket", this.Zo).toString();
    }
}
