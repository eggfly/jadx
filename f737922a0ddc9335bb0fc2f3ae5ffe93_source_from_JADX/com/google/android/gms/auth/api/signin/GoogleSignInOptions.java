package com.google.android.gms.auth.api.signin;

import afl;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.a.d;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GoogleSignInOptions extends AbstractSafeParcelable implements d {
    public static final Creator<GoogleSignInOptions> CREATOR;
    public static final Scope DW;
    public static final Scope FH;
    public static final GoogleSignInOptions Hw;
    private static Comparator<Scope> J0;
    public static final Scope j6;
    private String EQ;
    private Account VH;
    private final ArrayList<Scope> Zo;
    private boolean gn;
    private final boolean tp;
    private final boolean u7;
    final int v5;
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

    public static final class a {
        private boolean DW;
        private boolean FH;
        private boolean Hw;
        private String VH;
        private Account Zo;
        private Set<Scope> j6;
        private String v5;

        public a() {
            this.j6 = new HashSet();
        }

        public a DW() {
            this.j6.add(GoogleSignInOptions.j6);
            return this;
        }

        public GoogleSignInOptions FH() {
            if (this.Hw && (this.Zo == null || !this.j6.isEmpty())) {
                j6();
            }
            return new GoogleSignInOptions(this.Zo, this.Hw, this.DW, this.FH, this.v5, this.VH, null);
        }

        public a j6() {
            this.j6.add(GoogleSignInOptions.FH);
            return this;
        }
    }

    static {
        j6 = new Scope("profile");
        DW = new Scope("email");
        FH = new Scope("openid");
        Hw = new a().j6().DW().FH();
        CREATOR = new b();
        J0 = new 1();
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.v5 = i;
        this.Zo = arrayList;
        this.VH = account;
        this.gn = z;
        this.u7 = z2;
        this.tp = z3;
        this.EQ = str;
        this.we = str2;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, new ArrayList(set), account, z, z2, z3, str, str2);
    }

    public Account DW() {
        return this.VH;
    }

    public boolean FH() {
        return this.gn;
    }

    public boolean Hw() {
        return this.u7;
    }

    public String VH() {
        return this.we;
    }

    public String Zo() {
        return this.EQ;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.Zo.size() != googleSignInOptions.j6().size() || !this.Zo.containsAll(googleSignInOptions.j6())) {
                return false;
            }
            if (this.VH == null) {
                if (googleSignInOptions.DW() != null) {
                    return false;
                }
            } else if (!this.VH.equals(googleSignInOptions.DW())) {
                return false;
            }
            if (TextUtils.isEmpty(this.EQ)) {
                if (!TextUtils.isEmpty(googleSignInOptions.Zo())) {
                    return false;
                }
            } else if (!this.EQ.equals(googleSignInOptions.Zo())) {
                return false;
            }
            return this.tp == googleSignInOptions.v5() && this.gn == googleSignInOptions.FH() && this.u7 == googleSignInOptions.Hw();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        Iterator it = this.Zo.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).j6());
        }
        Collections.sort(arrayList);
        return new afl().j6(arrayList).j6(this.VH).j6(this.EQ).j6(this.tp).j6(this.gn).j6(this.u7).j6();
    }

    public ArrayList<Scope> j6() {
        return new ArrayList(this.Zo);
    }

    public boolean v5() {
        return this.tp;
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.j6(this, parcel, i);
    }
}
