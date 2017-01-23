package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.eh;
import java.util.Collections;
import java.util.List;

@eh
public final class AdResponseParcel extends AbstractSafeParcelable {
    public static final c CREATOR;
    public final boolean BT;
    public final String DW;
    public final long EQ;
    public String FH;
    public final List<String> Hw;
    public final String J0;
    public final long J8;
    public final AutoClickProtectionConfigurationParcel KD;
    public final boolean Mr;
    public final RewardItemParcel P8;
    public final boolean QX;
    public final boolean SI;
    public final boolean U2;
    public final long VH;
    public final String Ws;
    public final String XL;
    public final List<String> Zo;
    public final boolean a8;
    public final String aM;
    public final String cb;
    public String cn;
    public final boolean dx;
    public final List<String> ei;
    public LargeParcelTeleporter er;
    public final String gW;
    public final boolean gn;
    public final boolean j3;
    public final int j6;
    public final boolean lg;
    public final List<String> nw;
    public final int rN;
    public final boolean ro;
    private AdRequestInfoParcel sG;
    public final List<String> sh;
    public final List<String> tp;
    public final long u7;
    public final int v5;
    public final boolean vy;
    public final int we;
    public String yS;

    static {
        CREATOR = new c();
    }

    AdResponseParcel(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4, LargeParcelTeleporter largeParcelTeleporter, String str7, String str8, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z11, String str9, List<String> list6, String str10, boolean z12) {
        this.j6 = i;
        this.DW = str;
        this.FH = str2;
        this.Hw = list != null ? Collections.unmodifiableList(list) : null;
        this.v5 = i2;
        this.Zo = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.VH = j;
        this.gn = z;
        this.u7 = j2;
        this.tp = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.EQ = j3;
        this.we = i3;
        this.J0 = str3;
        this.J8 = j4;
        this.Ws = str4;
        this.QX = z2;
        this.XL = str5;
        this.aM = str6;
        this.j3 = z3;
        this.Mr = z4;
        this.U2 = z5;
        this.a8 = z6;
        this.lg = z7;
        this.rN = i4;
        this.er = largeParcelTeleporter;
        this.yS = str7;
        this.gW = str8;
        if (this.FH == null && this.er != null) {
            StringParcel stringParcel = (StringParcel) this.er.j6(StringParcel.CREATOR);
            if (!(stringParcel == null || TextUtils.isEmpty(stringParcel.j6()))) {
                this.FH = stringParcel.j6();
            }
        }
        this.BT = z8;
        this.vy = z9;
        this.P8 = rewardItemParcel;
        this.ei = list4;
        this.nw = list5;
        this.SI = z10;
        this.KD = autoClickProtectionConfigurationParcel;
        this.ro = z11;
        this.cn = str9;
        this.sh = list6;
        this.cb = str10;
        this.dx = z12;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (!(this.sG == null || this.sG.j6 < 9 || TextUtils.isEmpty(this.FH))) {
            this.er = new LargeParcelTeleporter(new StringParcel(this.FH));
            this.FH = null;
        }
        c.j6(this, parcel, i);
    }
}
