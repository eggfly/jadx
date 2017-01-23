package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.C3008a;
import com.google.android.gms.common.api.C3444a.C3000a.C3003d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GoogleSignInOptions implements C3003d, SafeParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR;
    public static final Scope f10147a;
    public static final Scope f10148b;
    public static final Scope f10149c;
    public static final GoogleSignInOptions f10150d;
    private static Comparator<Scope> f10151m;
    final int f10152e;
    private final ArrayList<Scope> f10153f;
    private Account f10154g;
    private boolean f10155h;
    private final boolean f10156i;
    private final boolean f10157j;
    private String f10158k;
    private String f10159l;

    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInOptions.1 */
    static class C29981 implements Comparator<Scope> {
        C29981() {
        }

        public int m11664a(Scope scope, Scope scope2) {
            return scope.m13956a().compareTo(scope2.m13956a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m11664a((Scope) obj, (Scope) obj2);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInOptions.a */
    public static final class C2999a {
        private Set<Scope> f10140a;
        private boolean f10141b;
        private boolean f10142c;
        private boolean f10143d;
        private String f10144e;
        private Account f10145f;
        private String f10146g;

        public C2999a() {
            this.f10140a = new HashSet();
        }

        public C2999a m11665a() {
            this.f10140a.add(GoogleSignInOptions.f10149c);
            return this;
        }

        public C2999a m11666b() {
            this.f10140a.add(GoogleSignInOptions.f10147a);
            return this;
        }

        public GoogleSignInOptions m11667c() {
            if (this.f10143d && (this.f10145f == null || !this.f10140a.isEmpty())) {
                m11665a();
            }
            return new GoogleSignInOptions(this.f10145f, this.f10143d, this.f10141b, this.f10142c, this.f10144e, this.f10146g, null);
        }
    }

    static {
        f10147a = new Scope("profile");
        f10148b = new Scope(NotificationCompatApi21.CATEGORY_EMAIL);
        f10149c = new Scope("openid");
        f10150d = new C2999a().m11665a().m11666b().m11667c();
        CREATOR = new C3006c();
        f10151m = new C29981();
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.f10152e = i;
        this.f10153f = arrayList;
        this.f10154g = account;
        this.f10155h = z;
        this.f10156i = z2;
        this.f10157j = z3;
        this.f10158k = str;
        this.f10159l = str2;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, new ArrayList(set), account, z, z2, z3, str, str2);
    }

    public ArrayList<Scope> m11668a() {
        return new ArrayList(this.f10153f);
    }

    public Account m11669b() {
        return this.f10154g;
    }

    public boolean m11670c() {
        return this.f10155h;
    }

    public boolean m11671d() {
        return this.f10156i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean m11672e() {
        return this.f10157j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f10153f.size() != googleSignInOptions.m11668a().size() || !this.f10153f.containsAll(googleSignInOptions.m11668a())) {
                return false;
            }
            if (this.f10154g == null) {
                if (googleSignInOptions.m11669b() != null) {
                    return false;
                }
            } else if (!this.f10154g.equals(googleSignInOptions.m11669b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f10158k)) {
                if (!TextUtils.isEmpty(googleSignInOptions.m11673f())) {
                    return false;
                }
            } else if (!this.f10158k.equals(googleSignInOptions.m11673f())) {
                return false;
            }
            return this.f10157j == googleSignInOptions.m11672e() && this.f10155h == googleSignInOptions.m11670c() && this.f10156i == googleSignInOptions.m11671d();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public String m11673f() {
        return this.f10158k;
    }

    public String m11674g() {
        return this.f10159l;
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        Iterator it = this.f10153f.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).m13956a());
        }
        Collections.sort(arrayList);
        return new C3008a().m11701a(arrayList).m11701a(this.f10154g).m11701a(this.f10158k).m11702a(this.f10157j).m11702a(this.f10155h).m11702a(this.f10156i).m11700a();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C3006c.m11689a(this, parcel, i);
    }
}
