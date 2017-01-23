package com.google.android.gms.auth.api.signin;

import afq;
import afs;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR;
    private static Comparator<Scope> J8;
    public static afq j6;
    final int DW;
    private String EQ;
    List<Scope> FH;
    private String Hw;
    private String J0;
    private String VH;
    private String Zo;
    private Uri gn;
    private long tp;
    private String u7;
    private String v5;
    private String we;

    class 1 implements Comparator<Scope> {
        1() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((Scope) obj, (Scope) obj2);
        }

        public int j6(Scope scope, Scope scope2) {
            return scope.j6().compareTo(scope2.j6());
        }
    }

    static {
        CREATOR = new a();
        j6 = afs.Hw();
        J8 = new 1();
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.DW = i;
        this.Hw = str;
        this.v5 = str2;
        this.Zo = str3;
        this.VH = str4;
        this.gn = uri;
        this.u7 = str5;
        this.tp = j;
        this.EQ = str6;
        this.FH = list;
        this.we = str7;
        this.J0 = str8;
    }

    private JSONObject we() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (j6() != null) {
                jSONObject.put("id", j6());
            }
            if (DW() != null) {
                jSONObject.put("tokenId", DW());
            }
            if (FH() != null) {
                jSONObject.put("email", FH());
            }
            if (Hw() != null) {
                jSONObject.put("displayName", Hw());
            }
            if (v5() != null) {
                jSONObject.put("givenName", v5());
            }
            if (Zo() != null) {
                jSONObject.put("familyName", Zo());
            }
            if (VH() != null) {
                jSONObject.put("photoUrl", VH().toString());
            }
            if (gn() != null) {
                jSONObject.put("serverAuthCode", gn());
            }
            jSONObject.put("expirationTime", this.tp);
            jSONObject.put("obfuscatedIdentifier", tp());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.FH, J8);
            for (Scope j6 : this.FH) {
                jSONArray.put(j6.j6());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String DW() {
        return this.v5;
    }

    public String EQ() {
        return we().toString();
    }

    public String FH() {
        return this.Zo;
    }

    public String Hw() {
        return this.VH;
    }

    public Uri VH() {
        return this.gn;
    }

    public String Zo() {
        return this.J0;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).EQ().equals(EQ());
    }

    public String gn() {
        return this.u7;
    }

    public String j6() {
        return this.Hw;
    }

    public String tp() {
        return this.EQ;
    }

    public long u7() {
        return this.tp;
    }

    public String v5() {
        return this.we;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.j6(this, parcel, i);
    }
}
